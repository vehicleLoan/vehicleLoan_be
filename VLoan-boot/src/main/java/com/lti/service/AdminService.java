package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;

@Component
@Service
public interface AdminService {
	Admin registerAdmin(Admin admin);
	boolean loginAdmin(int adminId,String adminpass);
	List<Loan> viewAlltoAdmin();
	int findloan(int loanId);
	Customer findCustomerById(int custId);
	Loan viewSingleUser(int custId);
	Loan changeStatus(int loanId);
	List<Loan> viewAllCustomers();
	/*Admin loginAdmin(AdminLoginDto adminLoginDto);*/
	void rejectLoan(int loanId);
	void approveLoan(int loanId);
	List<Loan> allRejectedUsers();
	List<Loan> allApprovedUsers();
	List<Document> viewfiles();
	public Loan viewLoan(int loanId);
}
