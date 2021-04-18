package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vl_loan")
public class Loan {

	@Id
	@SequenceGenerator(name = "loan_seq", initialValue = 300, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	int loanId;
	int loanAmount;
	double rateOfInterest;
	int tenure;
	//existing loan details
	String existingEmi;
	String existingLoanAmount;
	String existingLoanBank;
	@Column(name="Status")
	String status;
	
	@ManyToOne
	@JoinColumn(name="custId")
	Customer customer;           //emp details, personal details,loan details of customers

	@OneToOne
	@JoinColumn(name="vehicleId")
	VehicleDetails vehicle;
	
	@OneToOne
	@JoinColumn(name="docId")
	Document document;
	
	
	
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public VehicleDetails getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDetails vehicle) {
		this.vehicle = vehicle;
	}

}