package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.repository.AdminDao;
import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

//@Component
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	EmailService emailService;
	
	public Admin registerAdmin(Admin admin) {
		
		return adminDao.registerAdmin(admin);
	}

	/*public Admin loginAdmin(AdminLoginDto adminLoginDto) {
		
		return adminDao.loginAdmin(adminLoginDto);
	}
*/
	public List<Loan> viewAlltoAdmin() {
		
		return adminDao.viewAllCustomers();
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

	public List<Loan> viewAllCustomers() {
		// TODO Auto-generated method stub
		return adminDao.viewAllCustomers();
	}

	public boolean loginAdmin(int adminId, String adminpass) {
		// TODO Auto-generated method stub
		return adminDao.loginAdmin(adminId, adminpass);
	}

	@Override
    public void approveLoan(int loanId) {
		
		Loan l = viewLoan(loanId);
		Customer c = l.getCustomer();
		VehicleDetails v = l.getVehicle();
		String subject = "Loan Application Update";
		String txt = "Hi "+c.getCustFirstName()+",\nYour loan application "+ "for vehicle "+ v.getVehicleModel()+
						" has been approved ";
		emailService.sendEmailForNewRegistration(c.getEmail(), txt, subject);
		
		
        adminDao.approveLoan(loanId);
    }

 

    @Override
    public void rejectLoan(int loanId) {
    	
    	Loan l = viewLoan(loanId);
		Customer c = l.getCustomer();
		VehicleDetails v = l.getVehicle();
		String subject = "Loan Application Update";
		String txt = "Hi "+c.getCustFirstName()+",\nYour loan application "+ "for vehicle "+ v.getVehicleModel()+
						" has been rejected please review your application";
		emailService.sendEmailForNewRegistration(c.getEmail(), txt, subject);
    	
        adminDao.rejectLoan(loanId);
    }

 

    @Override
    public List<Loan> allApprovedUsers() {
        return adminDao.allApprovedUsers();
    }

 

    @Override
    public List<Loan> allRejectedUsers() {
        return adminDao.allRejectedUsers();
    }


	@Override
	public List<Document> viewfiles() {
		// TODO Auto-generated method stub
		return adminDao.viewFiles();
	}

	@Override
	public Loan viewLoan(int loanId) {
		// TODO Auto-generated method stub
		return adminDao.viewLoan(loanId);
	}

}
