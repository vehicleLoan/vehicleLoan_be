package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.ApplicationFormDto;
import com.lti.dto.DocumentDto;
import com.lti.dto.EmploymentDetailsDto;
import com.lti.dto.ForgotPasswordDto;
import com.lti.dto.LoginDto;
import com.lti.dto.PersonalDetailsDto;
import com.lti.dto.ResetPasswordDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;
//import com.lti.service.EmailService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Customer registerUser(@RequestBody Customer cust) {

		return userService.registerCustomer(cust);
	}

	@PostMapping("/userlogin")
	public boolean loginCustomer(@RequestBody LoginDto loginDto) {
		return userService.loginCustomer(loginDto.getCustId(), loginDto.getPassword());
	}

	@PostMapping("/applyForLoan-page1")
	public Status applicationForm1(@RequestBody PersonalDetailsDto personalDetailsDto) {

		Customer cust = userService.addPersonalDetails(personalDetailsDto);

		if (cust!=null) {
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Uploaded!");
			return status;
		} else {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage("unsuccessful");
			return status;
		}
	}
	
	@PostMapping("/addEmploymentDetails")
	public Status applicationForm2(@RequestBody EmploymentDetailsDto appFormDto) {
		
		Customer cust = userService.addEmploymentDetails(appFormDto);
		if (cust!=null) {
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Uploaded!");
			return status;
		} else {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage("unsuccessful");
			return status;
		}
		
	}
	
	@PostMapping(value="/applypage3")
    public int applicationForm3(@RequestBody ApplicationFormDto appformdto) {
      int  v=userService.vehicledtls(appformdto);
      System.out.println(v);
       return v;
    }

	@PostMapping(value="/applypage4")
	public Status applicationForm4(@RequestBody ApplicationFormDto appformdto) {
	    BankDetails bank=userService.addBankDetails(appformdto);
	    if (bank!=null) {
	        Status status = new Status();
	        status.setStatus(StatusType.SUCCESS);
	        status.setMessage("Uploaded!");
	        return status;
	    } else {
	        Status status = new Status();
	        status.setStatus(StatusType.FAILURE);
	        status.setMessage("unsuccessful");
	        return status;
	    }
	}
	
	@PostMapping("/doc-upload")
	public int upload(DocumentDto docsDto) {
		String imageUploadLocation = "d:/LTI/uploads/";
		String aadhar = docsDto.getAadharCard().getOriginalFilename();
		String aadharFile = imageUploadLocation + aadhar;
		try {
			FileCopyUtils.copy(docsDto.getAadharCard().getInputStream(), new FileOutputStream(aadharFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return 0;
		}
		String pan = docsDto.getPanCard().getOriginalFilename();
		String panFile = imageUploadLocation + pan;
		try {
			FileCopyUtils.copy(docsDto.getPanCard().getInputStream(), new FileOutputStream(panFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return 0;
		}
		String paySlip = docsDto.getPaySlip().getOriginalFilename();
		String paySlipFile = imageUploadLocation + paySlip;
		try {
			FileCopyUtils.copy(docsDto.getPaySlip().getInputStream(), new FileOutputStream(paySlipFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return 0;
		}

		Document doc = new Document();
		doc.setAadharCard(aadhar);
		doc.setPanCard(pan);
		doc.setPaySlip(paySlip);
		int docId = userService.addDoc(doc);

		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return docId;

	}
	
	@PostMapping(value="/applypage5")
    public Status applicationForm5(@RequestBody ApplicationFormDto appformdto) {
      Loan l=userService.lndtls(appformdto);
        if (l!=null) {
            Status status = new Status();
            status.setStatus(StatusType.SUCCESS);
            status.setMessage("Uploaded!");
            return status;
        } else {
            Status status = new Status();
            status.setStatus(StatusType.FAILURE);
            status.setMessage("unsuccessful");
            return status;
        }
    }
	

	@PostMapping("/applyNow")
	public Loan applyLoan(@RequestBody ApplicationFormDto appFormDto) {
		return userService.addLoan(appFormDto);
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	public VehicleDetails addvehicle(VehicleDetails vehicle) {
		return userService.addvehicle(vehicle);
	}

	@RequestMapping(value = "/addBank", method = RequestMethod.POST)
	public BankDetails addBankDetails(BankDetails bank) {
		return userService.addBankDetails(bank);
	}

	@RequestMapping(value = "/findVehById", method = RequestMethod.GET)
	public VehicleDetails findveh(int vehicleId) {
		return userService.findveh(vehicleId);
	}

	@RequestMapping(value = "/findDocById", method = RequestMethod.GET)
	public Document findDocById(int docId) {
		return userService.findDocById(docId);
	}

	@RequestMapping(value = "/findBankById", method = RequestMethod.GET)
	public BankDetails findBankById(int bankId) {
		return userService.findBankById(bankId);
	}

	@RequestMapping(value = "/findCustById", method = RequestMethod.GET)
	public Customer findCustomerById(@RequestParam int custId) {
		return userService.findCustomerById(custId);
	}

	@RequestMapping(value = "/viewLoanByCustId", method = RequestMethod.GET)
	public List<Loan> viewAllLoanByCustId(@RequestParam("custId") int custId) {
		return userService.viewAllLoansByCustId(custId);

	}
	
	@RequestMapping(value = "/viewAllLoans", method = RequestMethod.GET)
	public List<Loan> viewAllLoans(@RequestParam("custId") int custId) {
		return userService.viewAllLoansByCustId(custId);

	}
	

	@RequestMapping(value = "/viewLoanByid", method = RequestMethod.GET)
	public List<Loan> viewAllLoan(int custId) {
		return userService.viewAllLoansByCustId(custId);
	}

	@RequestMapping(value = "/viewLoanStatus", method = RequestMethod.GET)
	public List<Loan> viewAllLoanStatus(int loanId) {
		return null;
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public Customer resetPassword(@RequestBody ResetPasswordDto resetpass, @RequestParam("custId") int custId) {
		return userService.resetPassword(resetpass.getPassword(), custId);
	}

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	public boolean forgetPassword(@RequestBody ForgotPasswordDto forgetpass) {
		return userService.forgetPassword(forgetpass.getCustId(), forgetpass.getEmail());
	}
	
	@RequestMapping(value = "/viewApprov")
    public List<Loan> viewApprovedd(@RequestParam("custId") int custId) {
        return userService.viewApproved(custId);
    }

}
