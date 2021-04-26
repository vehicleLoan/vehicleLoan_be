package com.lti.repository;

import java.util.List;

import com.lti.dto.ApplicationFormDto;
import com.lti.dto.EmploymentDetailsDto;
import com.lti.dto.PersonalDetailsDto;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

public interface UserDao {
	
	public Customer registerACustomer(Customer cust);
	public boolean Login(int custId, String password);
	public Loan addLoanDetails(ApplicationFormDto appFormDto) ;
	public List<Loan> viewAllLoansByCustId(int id);
	public VehicleDetails addvehicle(VehicleDetails vehicle);
	public VehicleDetails findveh(int vehicleId);
	public Document findDocById(int docId);
	public Customer findcustomer(int custId);
	public void loandetails(Loan l);
	public int addDocument(Document doc);
	public void addVehicle(VehicleDetails vehicle);
	public boolean forgetPassword(int custId, String email);
	public Customer resetPassword(String password, int custId);
	public boolean addEmpDetails(ApplicationFormDto appFormDto);
	public  Customer addPersonalDetals(PersonalDetailsDto appFormDto);
	public Customer addEmploymentDetails(EmploymentDetailsDto appFormDto);
	public int vehicledtls(ApplicationFormDto appFormDto);
	public BankDetails addBankDetails(ApplicationFormDto appfdto);
	public Loan lndtls(ApplicationFormDto appFormDto);
	public boolean isCustomerPresent(String email) ;
	public List<Loan> viewApprove(int id);
	
}
