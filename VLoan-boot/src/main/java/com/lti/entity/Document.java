/*Stores documents of customer*/

package com.lti.entity;

import javax.persistence.*;

@Entity
@Table(name="vl_documents")
public class Document {

	@Id
	@SequenceGenerator(name = "doc_seq", initialValue = 40500, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq")
	int docId;
	
	String panCard; //path of file
	
	String aadharCard; //path of file
	
	String paySlip; //path of file
	
	@OneToOne(mappedBy="document",cascade=CascadeType.ALL)
	Loan loan;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPaySlip() {
		return paySlip;
	}

	public void setPaySlip(String paySlip) {
		this.paySlip = paySlip;
	}
	
}
