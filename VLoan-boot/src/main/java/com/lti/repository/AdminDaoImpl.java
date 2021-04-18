package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Loan;

//@Component
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceContext
	EntityManager em ;
	
	@Transactional
	public Admin registerAdmin(Admin admin){
		Admin adm = em.merge(admin);
		return adm;
	}
	
	
	
	public Loan viewSingle(int custId){
		String jpql="select l from Loan l where l.customer.custId=:lid";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		query.setParameter("lid",custId );
		Loan loan=new Loan();
		loan=query.getSingleResult();
		return loan;
	}
	
	@Transactional
	public Loan changeStatus(int loanId){
		Loan loan = em.find(Loan.class, loanId);
		loan.setStatus("not approved");
		
		em.merge(loan);
		
		
		return loan;
	}
	
	
	public List<Customer> viewAllCustomers() {
		String jpql="select c from Customer c ";
        TypedQuery<Customer> query=em.createQuery(jpql,Customer.class);
        List<Customer>cust=query.getResultList();
		return cust;
	}

	/*public Admin loginAdmin(AdminLoginDto adminLoginDto) {
		String jpql = "select a from Admin a where a.userName=:name and a.userPassword=:pass";
		TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
		query.setParameter("name", adminLoginDto.getUserName());
		query.setParameter("pass", adminLoginDto.getUserPassword());
		Admin  adm = query.getSingleResult();
		return adm;
	}*/
}
