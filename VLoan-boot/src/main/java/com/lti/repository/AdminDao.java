package com.lti.repository;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Document;
import com.lti.entity.Loan;

public interface AdminDao {

	public Loan viewSingle(int custId);

	public Loan changeStatus(int loanId);

	public List<Loan> viewAllCustomers();

	public Admin registerAdmin(Admin admin);

	public boolean loginAdmin(int adminId, String userPassword);

	void approveLoan(int loanId);

	void rejectLoan(int loanId);

	List<Loan> allApprovedUsers();

	List<Loan> allRejectedUsers();

	List<Document> viewFiles();

	public Loan viewLoan(int loanId);
}
