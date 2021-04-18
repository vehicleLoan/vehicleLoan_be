package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginDto;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/viewAll")
	public List<Customer> viewAllCustomers(){
		return adminService.viewAllCustomers();
	}
	
	@RequestMapping(value="/registerAdmin",method=RequestMethod.POST)
	public Admin adminRegister(@RequestBody Admin admin){
		return adminService.registerAdmin(admin);
	}
	
	/*@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public Admin adminRegister(@RequestBody AdminLoginDto adminlogindto){
		return adminService.loginAdmin(adminlogindto);
	}*/
	
}
