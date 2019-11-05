package com.advantal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Influencer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="influencer_id")
	private Long influencerId;

	private String email;

	@Column(name="password")
	private String password;

	@Column(name="is_verified")
    private int isVerified;
    
	@Column(name="is_social_login")
    private String isSocialLogin;
	
	@Column(name="social_login_type")
    private String socialLoginType;
	
	@Column(name="social_login_id")
	private Integer socialLoginId;
	
	@Column(name = "email_otp")
	private String emailOtp;
	
    @Column(name ="is_survey_completed" ,columnDefinition="boolean default false")
	private boolean isSurveyCompleted;
	
	@Transient
	private int response;
	
	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public Long getInfluencerId() {
		return influencerId;
	}

	public void setInfluencerId(Long influencerId) {
		this.influencerId = influencerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	

	public Integer getSocialLoginId() {
		return socialLoginId;
	}

	public void setSocialLoginId(Integer socialLoginId) {
		this.socialLoginId = socialLoginId;
	}

	public String getIsSocialLogin() {
		return isSocialLogin;
	}

	public void setIsSocialLogin(String isSocialLogin) {
		this.isSocialLogin = isSocialLogin;
	}

	public String getSocialLoginType() {
		return socialLoginType;
	}

	public void setSocialLoginType(String socialLoginType) {
		this.socialLoginType = socialLoginType;
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
