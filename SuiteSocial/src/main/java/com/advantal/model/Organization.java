package com.advantal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="organization")
public class Organization  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="organzation_id")
	private Long organzationId;
	
	@Column(name="organzation_name")
	private String organizationName;
	
	@Column(name="organzation_key")
	private String organizationKey;
	
	@Column(name="organzation_email")
	private String organizationEmail;
	
	@Column(name="organzation_pwd")
	private String organizationpwd;
	
	@Column(name="is_verified")
	private int isVerified;
	
	@Column(name = "email_otp")
	private String emailOtp;
	
	@Column(name ="is_survey_completed" ,columnDefinition="boolean default false")
    private boolean isSurveyCompleted;
	
	@Transient
	private int response;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Organization() {
		super();
	}

	
	public int getResponse() {
		return response;
	}


	public void setResponse(int response) {
		this.response = response;
	}


	public Long getOrganzationId() {
		return organzationId;
	}

	public void setOrganzationId(Long organzationId) {
		this.organzationId = organzationId;
	}

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

	public String getOrganizationpwd() {
		return organizationpwd;
	}

	public void setOrganizationpwd(String organizationpwd) {
		this.organizationpwd = organizationpwd;
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
