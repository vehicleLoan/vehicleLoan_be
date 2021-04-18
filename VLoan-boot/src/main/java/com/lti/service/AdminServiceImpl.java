package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.repository.AdminDao;
import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Loan;

//@Component
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	
	public Admin registerAdmin(Admin admin) {
		
		return adminDao.registerAdmin(admin);
	}

	/*public Admin loginAdmin(AdminLoginDto adminLoginDto) {
		
		return adminDao.loginAdmin(adminLoginDto);
	}
*/
	public List<Loan> viewAlltoAdmin() {
		
		return null;
	}

	public int findloan(int loanId) {
		
		return 0;
	}

	public Customer findCustomerById(int custId) {
		
		return null;
	}

	public Loan viewSingleUser(int custId) {
		
		return null;
	}

	public Loan changeStatus(int loanId) {
		
		return null;
	}

	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return adminDao.viewAllCustomers();
	}

	public String loginAdmin(int adminId, String adminpass) {
		// TODO Auto-generated method stub
		return null;
	}


}
