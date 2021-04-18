package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {
	
	private int customerId;
	private MultipartFile profilePic;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public MultipartFile getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
	
	
}
