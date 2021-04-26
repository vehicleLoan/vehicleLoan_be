package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.dto.ApplicationFormDto;
import com.lti.dto.EmploymentDetailsDto;
import com.lti.dto.PersonalDetailsDto;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;

@Component
public interface UserService {
	Customer registerCustomer(Customer cust);
	 boolean loginCustomer(int custId,String custpass);
	 Customer ApplyForLoan(Customer cust);
	 Loan addLoan(ApplicationFormDto appFormDto);
	 int addDoc(Document doc);
	 Loan findByLoanId(int loanId);
	 List<Loan> viewAllLoansByCustId(int custid);
	 VehicleDetails addvehicle(VehicleDetails vehicle);
	 VehicleDetails findveh(int vehicleId);
	 Document findDocById(int docId);
	 BankDetails findBankById(int bankId);
	 Customer findCustomerById(int custId);
	 List<VehicleDetails> viewAllVehicleByLoanId(int loanId);
	 BankDetails addBankDetails(BankDetails bank);
	 boolean forgetPassword(int custId, String email);
	 Customer resetPassword(String password,int custId);
	Customer addPersonalDetails(PersonalDetailsDto personalDetailsDto);
	 Customer addEmploymentDetails(EmploymentDetailsDto employmentDetailsDto);
	int vehicledtls(ApplicationFormDto appformdto);
	BankDetails addBankDetails(ApplicationFormDto appformdto);
	Loan lndtls(ApplicationFormDto appformdto);
	List<Loan> viewApproved(int id);
	 
}
