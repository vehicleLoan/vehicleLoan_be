/*Bank account details of customers who have applied for a loan*/

package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@Table(name="vl_bank_details")
public class BankDetails {
	
	@Id
	@SequenceGenerator(name="account_seq",initialValue=400,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="account_seq")
	int accountId;
	
	@Column(name="AccountNumber")
	String accountNumber;
	
	@Column(name="BranchName")
	String branchName;
	
	@Column(name="BankName")
	String bankName;
	
	@Column(name="IFSC")
	String ifsc;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	
	
	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
