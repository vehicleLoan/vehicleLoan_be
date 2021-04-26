package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginDto;
//import com.lti.dto.Status;
import com.lti.entity.Admin;
//import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/viewAll")
	@ResponseBody
	public List<Loan> viewAllCustomers(){
		return adminService.viewAllCustomers();
	}
	
	@RequestMapping(value="/registerAdmin",method=RequestMethod.POST)
	public Admin adminRegister(@RequestBody Admin admin){
		return adminService.registerAdmin(admin);
	}
	
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public boolean adminLogin(@RequestBody AdminLoginDto adminlogindto){
		return adminService.loginAdmin(adminlogindto.getAdminId(), adminlogindto.getUserPassword());
	}
	
	@RequestMapping(value="/rejectLoan",method=RequestMethod.POST)
    public void rejectLoan(@RequestBody int loanId) {
        adminService.rejectLoan(loanId);
    }
    
	//http://localhost:9090/approveLoan?loanId=
    @RequestMapping(value="/approveLoan",method=RequestMethod.POST)
    public void approveLoan(@RequestBody int loanId) {
        adminService.approveLoan(loanId);
        //return "Approved";
    }
    
    //http://localhost:9090/viewrejectedUsers
    @GetMapping("/viewrejectedusers")
    public List<Loan> viewRejectedUsers() {    
        return adminService.allRejectedUsers();
    }
    
    //http://localhost:9090/viewapprovedUsers
    @GetMapping("/viewapprovedusers")
    public List<Loan> viewApprovedUsers() {    
        return adminService.allApprovedUsers();
    }
	
    @RequestMapping("/viewDocuments")
	public List<Document> viewFiles(HttpServletRequest request){
		List<Document> document = adminService.viewfiles();
		String projPath = request.getServletContext().getRealPath("/");
		String tempDownloadPath = projPath + "/downloads/";
		File f = new File(tempDownloadPath);
		if(!f.exists())
			f.mkdir();
		
		for(Document docu : document) {
			String aadhaartargetFile = tempDownloadPath + docu.getAadharCard();
			String pantargetFile = tempDownloadPath + docu.getPanCard();
			String paytargetFile = tempDownloadPath + docu.getPaySlip();
		   
			String uploadImagesPath = "D:/LTI/uploads/";
			String aadhaarsourceFile = uploadImagesPath + docu.getAadharCard();
			String pansourceFile = uploadImagesPath + docu.getPanCard();
			String paysourceFile = uploadImagesPath + docu.getPaySlip();
			
		    try {
		    	FileCopyUtils.copy(new File(aadhaarsourceFile),new File(aadhaartargetFile));
		    	FileCopyUtils.copy(new File(pansourceFile), new File(pantargetFile));
		    	FileCopyUtils.copy(new File(paysourceFile), new File(paytargetFile));
		    }catch(IOException e) {
		    	e.printStackTrace();
		    }
		
		}
		return document;
	}
    
    @GetMapping("/viewLoanByLoanId")
    public Loan viewLoan(@RequestParam("loanId") int loanId) {
    	return adminService.viewLoan(loanId);
    }
    
}
