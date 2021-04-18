package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.repository.UserDao;
import com.lti.repository.UserDaoImpl;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

//@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Customer registerCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return userDao.registerACustomer(cust);
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
	public Loan addLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document addDoc(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan findByLoanId(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> viewAllLoansByCustId(int custid) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
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

}
