package com.advantal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="company_survey")
public class CompanySurvey{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_survey_id")
	private Long companysurveyId;
	
	//Your name?
	@Column(name="your_name")
	private String yourName;
	
	//Your company's name?
	@Column(name="your_company_name")
	private String yourcompanyName;
	
	//Which product category you are trying to promote?
	@Column(name="product_category")
	private String productCategory;
	
	//What is your overall budget for this campaign?
	@Column(name="over_all_budget")
	private Integer overallBudget;
	
	//How many influencers would you like to hire?
	@Column(name="no_of_influencer")
	private Integer noOfInfluencer;

	//Could you please describe your brand or product in one sentence?
	@Column(name="describe_your_brand")
	private String describeYourBrand;
	
	//What ages are you targeting for the campaign?
	@Column(name="age_for_campaign")
	private Integer ageForCampaign;
	
	//Which social media platforms are you targeting?
	@Column(name="social_media_platform")
	private String socialMediaPlatform;
	
	//When is your campaign timeline (i.e. November 1 - November 25, 2019)?
	@Column(name="your_campaign_timeline")
	private Integer yourCampaignTimeline;
	
	//Your email?
	@Column(name="your_email")
	private String yourEmail;
	
	//Your phone number?
	@Column(name="your_Phone_number")
	private String yourPhoneNumber;
	
	//Thank you for your interest. Please leave your preferred method of communication below (phone number or email).
	//Our brand team will contact you shortly.
	//Mark only one oval.
	@Column(name="method_of_communication")
	private String methodOfCommunication;
	
	//Send me a copy of my responses.
	@Column(name="copy_of_response")
	private String copyOfResponse;
	
	@ManyToOne
	private Organization org;
	

	public Organization getOrg() {
		return org;
	}



	public void setOrg(Organization org) {
		this.org = org;
	}



	public CompanySurvey() {
		super();
	}

	

	public CompanySurvey(Long companysurveyId, String yourName, String yourcompanyName, String productCategory,
			Integer overallBudget, Integer noOfInfluencer, String describeYourBrand, Integer ageForCampaign,
			String socialMediaPlatform, Integer yourCampaignTimeline, String yourEmail, String yourPhoneNumber,
			String methodOfCommunication, String copyOfResponse) {
		super();
		this.companysurveyId = companysurveyId;
		this.yourName = yourName;
		this.yourcompanyName = yourcompanyName;
		this.productCategory = productCategory;
		this.overallBudget = overallBudget;
		this.noOfInfluencer = noOfInfluencer;
		this.describeYourBrand = describeYourBrand;
		this.ageForCampaign = ageForCampaign;
		this.socialMediaPlatform = socialMediaPlatform;
		this.yourCampaignTimeline = yourCampaignTimeline;
		this.yourEmail = yourEmail;
		this.yourPhoneNumber = yourPhoneNumber;
		this.methodOfCommunication = methodOfCommunication;
		this.copyOfResponse = copyOfResponse;
	}



	public Long getCompanysurveyId() {
		return companysurveyId;
	}

	public void setCompanysurveyId(Long companysurveyId) {
		this.companysurveyId = companysurveyId;
	}

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getYourcompanyName() {
		return yourcompanyName;
	}

	public void setYourcompanyName(String yourcompanyName) {
		this.yourcompanyName = yourcompanyName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	
	public Integer getOverallBudget() {
		return overallBudget;
	}

	public void setOverallBudget(Integer overallBudget) {
		this.overallBudget = overallBudget;
	}

	public Integer getNoOfInfluencer() {
		return noOfInfluencer;
	}

	public void setNoOfInfluencer(Integer noOfInfluencer) {
		this.noOfInfluencer = noOfInfluencer;
	}

	public String getDescribeYourBrand() {
		return describeYourBrand;
	}

	public void setDescribeYourBrand(String describeYourBrand) {
		this.describeYourBrand = describeYourBrand;
	}

	public Integer getAgeForCampaign() {
		return ageForCampaign;
	}

	public void setAgeForCampaign(Integer ageForCampaign) {
		this.ageForCampaign = ageForCampaign;
	}

	public String getSocialMediaPlatform() {
		return socialMediaPlatform;
	}

	public void setSocialMediaPlatform(String socialMediaPlatform) {
		this.socialMediaPlatform = socialMediaPlatform;
	}

	public Integer getYourCampaignTimeline() {
		return yourCampaignTimeline;
	}

	public void setYourCampaignTimeline(Integer yourCampaignTimeline) {
		this.yourCampaignTimeline = yourCampaignTimeline;
	}

	public String getYourEmail() {
		return yourEmail;
	}

	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}

	public String getYourPhoneNumber() {
		return yourPhoneNumber;
	}

	public void setYourPhoneNumber(String yourPhoneNumber) {
		this.yourPhoneNumber = yourPhoneNumber;
	}

	public String getMethodOfCommunication() {
		return methodOfCommunication;
	}

	public void setMethodOfCommunication(String methodOfCommunication) {
		this.methodOfCommunication = methodOfCommunication;
	}

	public String getCopyOfResponse() {
		return copyOfResponse;
	}

	public void setCopyOfResponse(String copyOfResponse) {
		this.copyOfResponse = copyOfResponse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
