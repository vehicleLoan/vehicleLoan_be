package com.lti.controller;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ForgotPasswordDto;
import com.lti.dto.LoginDto;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public Customer registerUser(@RequestBody Customer cust){
		return userService.registerCustomer(cust);
	}
	
	@PostMapping("/userlogin")
	public boolean loginCustomer(@RequestBody LoginDto loginDto) {
		return userService.loginCustomer(loginDto.getCustId(),loginDto.getPassword());
	}
	@RequestMapping(value="/addVehicle",method=RequestMethod.POST)
	public VehicleDetails addvehicle(VehicleDetails vehicle) {
		return userService.addvehicle(vehicle);
	}
	@RequestMapping(value="/addDoc",method=RequestMethod.POST)
	public Document addDoc(Document doc) {
		return userService.addDoc(doc);
	}
	@RequestMapping(value="/addBank",method=RequestMethod.POST)
	public BankDetails addBankDetails(BankDetails bank) {
		return userService.addBankDetails(bank);
	}
	@RequestMapping(value="/findVehById",method=RequestMethod.GET)
	public VehicleDetails findveh(int vehicleId) {
		return userService.findveh(vehicleId);
	}
	@RequestMapping(value="/findDocById",method=RequestMethod.GET)
	public Document findDocById(int docId) {
		return userService.findDocById(docId);
	}
	@RequestMapping(value="/findBankById",method=RequestMethod.GET)
	public BankDetails findBankById(int bankId) {
		return userService.findBankById(bankId);
	}
	@RequestMapping(value="/findCustById",method=RequestMethod.GET)
	public Customer findCustomerById(int custId) {
		return userService.findCustomerById(custId);
	}
	@RequestMapping(value="/viewLoanByCid",method=RequestMethod.GET)
	public List<Loan> viewAllLoanByCustId(int custid){
		return userService.viewAllLoansByCustId(custid);
		
	}
	@RequestMapping(value="/viewLoanByid",method=RequestMethod.GET)
	public List<Loan> viewAllLoan(int loanId){
		return userService.viewAllLoansByCustId(loanId);
	}
	@RequestMapping(value="/viewLoanStatus",method=RequestMethod.GET)
	public List<Loan> viewAllLoanStatus(int loanId) {
		return null;
	}
	
	@PostMapping("/forgotPassword")
	public boolean forgotPassword(ForgotPasswordDto fpDto) {
		return false;
	}
	
}
