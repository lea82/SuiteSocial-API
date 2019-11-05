package com.advantal.model;

public class OrgPayload {
	
	private String organizationName;
	private String organizationKey;
	private String organizationEmail;
	private int isVerified;
	private String emailOtp;
	private boolean isSurveyCompleted;
	
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationKey() {
		return organizationKey;
	}
	public void setOrganizationKey(String organizationKey) {
		this.organizationKey = organizationKey;
	}
	public String getOrganizationEmail() {
		return organizationEmail;
	}
	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}
	public int getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}
	public String getEmailOtp() {
		return emailOtp;
	}
	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}
	public boolean isSurveyCompleted() {
		return isSurveyCompleted;
	}
	public void setSurveyCompleted(boolean isSurveyCompleted) {
		this.isSurveyCompleted = isSurveyCompleted;
	}
	
	

}
