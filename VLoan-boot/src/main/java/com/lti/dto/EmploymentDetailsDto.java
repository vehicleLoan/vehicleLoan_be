package com.lti.dto;

public class EmploymentDetailsDto {

	int custId;
	double annualSal;
	String profession;
	String empType;			//salaried, pensioner, self-employed
	String companyName;
	String companyAddress;
	String companyCity;
	String companyState;
	int workExp;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
	
}
