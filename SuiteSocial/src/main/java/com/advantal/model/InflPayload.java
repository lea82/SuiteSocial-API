package com.advantal.model;

public class InflPayload {
	
	private String email;

    private int isVerified;
    
	private String emailOtp;
	
	private boolean isSurveyCompleted;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
