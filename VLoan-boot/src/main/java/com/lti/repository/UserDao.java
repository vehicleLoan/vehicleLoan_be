package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

public interface UserDao {
	
	public Customer registerACustomer(Customer cust);
	public boolean Login(int custId, String password);
	public Loan ApplyForLoan(Loan loan) ;
	public List<Loan> viewAllLoansByCustId(int id);
	public VehicleDetails addvehicle(VehicleDetails vehicle);
	public VehicleDetails findveh(int vehicleId);
	public Document findDocById(int docId);
	public Customer findcustomer(int custId);
	public void loandetails(Loan l);
	public void addDocument(Document doc);
	public void addVehicle(VehicleDetails vehicle);
	
	
	
}
