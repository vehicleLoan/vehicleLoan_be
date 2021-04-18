package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Loan;

//@Component
//@Repository
public interface AdminDao {
	
	public Loan viewSingle(int custId);
	public Loan changeStatus(int loanId);
	public List<Customer> viewAllCustomers();
	public Admin registerAdmin(Admin admin);
	//public Admin loginAdmin(AdminLoginDto adminLoginDto);
}
