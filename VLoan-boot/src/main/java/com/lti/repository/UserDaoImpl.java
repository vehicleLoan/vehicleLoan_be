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

import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

//@Component
@Repository
public class UserDaoImpl implements UserDao {
	 
	@PersistenceContext
	EntityManager em;

	@Transactional
	public Customer registerACustomer(Customer cust) {
		Customer c= em.merge(cust);
		return c;
	}

	public boolean Login(int custId, String password) {
		Customer cust = em.find(Customer.class, custId);   
        if (cust != null)
            return true;
        return false;
	}

	@Transactional
	public Loan ApplyForLoan(Loan loan) {
		// User should be logged in
		
		em.merge(loan);
		
		System.out.println("Loan applied");
		return loan;

	}

	public List<Loan> viewAllLoansByCustId(int id){	
		String jpql = "select l from Loan l where l.customer.custId=:id";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		query.setParameter("id", id); 
		List<Loan> loans = query.getResultList();
		return loans;
	 }
	
	//not tested
	@Transactional
	public VehicleDetails addvehicle(VehicleDetails vehicle){
        
        em.merge(vehicle);
       
        return vehicle;
    }
    public VehicleDetails findveh(int vehicleId){
        return em.find(VehicleDetails.class, vehicleId);
       
    }
    public Document findDocById(int docId){
        return em.find(Document.class, docId);
       
    }
    public Customer findcustomer(int custId){
        return em.find(Customer.class, custId);
    }
    
    @Transactional
    public void loandetails(Loan l){
        Loan loan=new Loan();
      
        em.merge(l);
        
    }

    @Transactional
	public void addDocument(Document doc) {
		
		em.merge(doc);
		
	}
    @Transactional
	public void addVehicle(VehicleDetails vehicle) {
		
		em.merge(vehicle);
		
	}
    
    @Transactional
	public void addBankAccount(BankDetails bank) {
		
		em.merge(bank);
			
	}
    @Transactional
	public void addLoan(Loan loan){
        
        em.merge(loan);
        
        
    }
	
	
}
