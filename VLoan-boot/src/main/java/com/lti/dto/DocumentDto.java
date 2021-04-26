package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {
	
	private int custId;
	private MultipartFile aadharCard;
	private MultipartFile panCard;
	private MultipartFile paySlip;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public MultipartFile getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}
	public MultipartFile getPanCard() {
		return panCard;
	}
	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}
	public MultipartFile getPaySlip() {
		return paySlip;
	}
	public void setPaySlip(MultipartFile paySlip) {
		this.paySlip = paySlip;
	}
	
	
}
