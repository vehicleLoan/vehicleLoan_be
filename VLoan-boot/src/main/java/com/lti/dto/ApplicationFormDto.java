package com.lti.dto;

import java.time.LocalDate;



public class ApplicationFormDto {
	
	int custId; //from session storage
	String email;
	/* Personal Details */
	String custFirstName;
	String custLastName;
	String gender;
	String address;
	String phone;
	String city;
	String state;
	String pinCode;
	LocalDate dateOfBirth;

	/* Employment Details */
	double annualSal;
	String profession;
	String empType;			//salaried, pensioner, self-employed
	String companyName;
	String companyAddress;
	String companyCity;
	String companyState;
	int workExp;
	
	//vehicle details
	int vehicleId;
	
	String vehicleType;
	
	String vehicleMake;
	
	String vehicleModel;
	
	String vehicleState;
	
	String vehicleCity;
	
	//bank details
	String accountNumber;
	
	String branchName;
	
	String bankName;
	
	String ifsc;
	
	//loan details
	int loanAmount;
	double rateOfInterest;
	int tenure;
	
	//existing loan details
	String existingEmi;
	String existingLoanAmount;
	String existingLoanBank;
	
	int docId;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getAnnualSal() {
		return annualSal;
	}
	public void setAnnualSal(double annualSal) {
		this.annualSal = annualSal;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public int getWorkExp() {
		return workExp;
	}
	public void setWorkExp(int workExp) {
		this.workExp = workExp;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleState() {
		return vehicleState;
	}
	public void setVehicleState(String vehicleState) {
		this.vehicleState = vehicleState;
	}
	public String getVehicleCity() {
		return vehicleCity;
	}
	public void setVehicleCity(String vehicleCity) {
		this.vehicleCity = vehicleCity;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getExistingEmi() {
		return existingEmi;
	}
	public void setExistingEmi(String existingEmi) {
		this.existingEmi = existingEmi;
	}
	public String getExistingLoanAmount() {
		return existingLoanAmount;
	}
	public void setExistingLoanAmount(String existingLoanAmount) {
		this.existingLoanAmount = existingLoanAmount;
	}
	public String getExistingLoanBank() {
		return existingLoanBank;
	}
	public void setExistingLoanBank(String existingLoanBank) {
		this.existingLoanBank = existingLoanBank;
	}
}
