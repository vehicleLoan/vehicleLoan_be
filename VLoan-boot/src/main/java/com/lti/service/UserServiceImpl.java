package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.repository.UserDao;
import com.lti.repository.UserDaoImpl;
import com.lti.dto.ApplicationFormDto;
import com.lti.dto.EmploymentDetailsDto;
import com.lti.dto.PersonalDetailsDto;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;
import com.lti.exception.CustomerServiceException;

//@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	EmailService emailService;
	
	@Override
	public Customer registerCustomer(Customer cust) {
		if(!userDao.isCustomerPresent(cust.getEmail())) {
		Customer c= userDao.registerACustomer(cust);
		String subject = "Registration Confirmation";
		String txt = "Hi "+c.getCustFirstName()+" You have successfully registered "+
						"Your userId is "+c.getCustId();
		emailService.sendEmailForNewRegistration(c.getEmail(), txt, subject);
		
		System.out.println("mail sent. ");
		return c;
		}
		else {
			//throw new CustomerServiceException("Customer already registered!");
			return null;
		}
	}

	@Override
	public boolean loginCustomer(int custId, String custpass) {
		// TODO Auto-generated method stub
		return userDao.Login(custId, custpass);
	}

	@Override
	public Customer ApplyForLoan(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan addLoan(ApplicationFormDto appFormDto) {
		// TODO Auto-generated method stub
		return userDao.addLoanDetails(appFormDto);
	}

	@Override
	public int addDoc(Document doc) {
		// TODO Auto-generated method stub
		 
		 return userDao.addDocument(doc);
	}

	@Override
	public Loan findByLoanId(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> viewAllLoansByCustId(int custid) {
		// TODO Auto-generated method stub
		return userDao.viewAllLoansByCustId(custid);
	}

	@Override
	public VehicleDetails addvehicle(VehicleDetails vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDetails findveh(int vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document findDocById(int docId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankDetails findBankById(int bankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(int custId) {
		// TODO Auto-generated method stub
		return userDao.findcustomer(custId);
	}

	@Override
	public List<VehicleDetails> viewAllVehicleByLoanId(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankDetails addBankDetails(BankDetails bank) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public Customer resetPassword(String password,int custId) {

		 

        return userDao.resetPassword(password,custId);
    }

 


    public boolean forgetPassword(int custId, String email) {

 

        return userDao.forgetPassword(custId, email);
    }

	@Override
	public Customer addPersonalDetails(PersonalDetailsDto personalDetailsDto) {
		// TODO Auto-generated method stub
		return userDao.addPersonalDetals(personalDetailsDto);
	}
	
	@Override
	public Customer addEmploymentDetails(EmploymentDetailsDto appFormDto) {
		return userDao.addEmploymentDetails(appFormDto);
	}

	@Override
	public int vehicledtls(ApplicationFormDto appformdto) {
		// TODO Auto-generated method stub
		return userDao.vehicledtls(appformdto);
	}

	@Override
	public BankDetails addBankDetails(ApplicationFormDto appformdto) {
		// TODO Auto-generated method stub
		return userDao.addBankDetails(appformdto);
	}

	@Override
	public Loan lndtls(ApplicationFormDto appformdto) {
		// TODO Auto-generated method stub
		return userDao.lndtls(appformdto);
	}

	@Override
	public List<Loan> viewApproved(int id) {
		// TODO Auto-generated method stub
		return userDao.viewApprove(id);
	}
}
