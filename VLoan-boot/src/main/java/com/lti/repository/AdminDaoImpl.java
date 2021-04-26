package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Document;
import com.lti.entity.Loan;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Admin registerAdmin(Admin admin) {
		Admin adm = em.merge(admin);
		return adm;
	}

	public Loan viewSingle(int custId) {
		String jpql = "select l from Loan l where l.customer.custId=:lid";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		query.setParameter("lid", custId);
		Loan loan = new Loan();
		loan = query.getSingleResult();
		return loan;
	}

	@Transactional
	public Loan changeStatus(int loanId) {
		Loan loan = em.find(Loan.class, loanId);
		loan.setStatus("not approved");

		em.merge(loan);

		return loan;
	}

	public List<Loan> viewAllCustomers() {
		String jpql = "select l from Loan l where l.status ='pending' ";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		List<Loan> loan = query.getResultList();
		return loan;
	}

	public boolean loginAdmin(int adminId, String userPassword) {
		Admin admin = em.find(Admin.class, adminId);
		if (admin == null) {
			return false;
		} else if (admin.getUserPassword().equals(userPassword)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public void approveLoan(int loanId) {
		Loan loan = em.find(Loan.class, loanId);
		loan.setStatus("Approved");
		em.merge(loan);
	}

	@Override
	@Transactional
	public void rejectLoan(int loanId) {
		Loan loan = em.find(Loan.class, loanId);
		loan.setStatus("Rejected");
		em.merge(loan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> allApprovedUsers() {
		return em.createQuery("select l from Loan l where l.status = 'Approved'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> allRejectedUsers() {
		return em.createQuery("select l from Loan l where l.status = 'Rejected'").getResultList();
	}

	@Override
	public List<Document> viewFiles() {
		String jpql = "select d from Document d";
		TypedQuery<Document> query = em.createQuery(jpql, Document.class);
		List<Document> document = query.getResultList();

		return document;
	}

	@Override
	public Loan viewLoan(int loanId) {
		Loan loan = new Loan();
		loan = em.find(Loan.class, loanId);
		return loan;
	}

}
