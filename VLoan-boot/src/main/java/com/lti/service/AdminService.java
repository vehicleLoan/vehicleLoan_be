package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Loan;

@Component
@Service
public interface AdminService {
	Admin registerAdmin(Admin admin);
	String loginAdmin(int adminId,String adminpass);
	List<Loan> viewAlltoAdmin();
	int findloan(int loanId);
	Customer findCustomerById(int custId);
	Loan viewSingleUser(int custId);
	Loan changeStatus(int loanId);
	List<Customer> viewAllCustomers();
	/*Admin loginAdmin(AdminLoginDto adminLoginDto);*/
}
