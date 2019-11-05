package com.adantal.vo;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;

import com.advantal.model.Organization;

public class CompanySurveyVO {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "company_survey_id")
	private Long companysurveyId;

	// Your name?
	@XmlElement(name = "your_name")
	private String yourName;

	// Your company's name?
	@XmlElement(name = "your_company_name")
	private String yourcompanyName;

	// Which product category you are trying to promote?
	@XmlElement(name = "product_category")
	private List<String> productCategory;

	// What is your overall budget for this campaign?
	@XmlElement(name = "over_all_budget")
	private String overallBudget;

	// How many influencers would you like to hire?
	@XmlElement(name = "no_of_influencer")
	private String noOfInfluencer;

	// Could you please describe your brand or product in one sentence?
	@XmlElement(name = "describe_your_brand")
	private String describeYourBrand;

	// What ages are you targeting for the campaign?
	@XmlElement(name = "age_for_campaign")
	private String ageForCampaign;

	// Which social media platforms are you targeting?
	@XmlElement(name = "social_media_platform")
	private String socialMediaPlatform;

	// When is your campaign timeline (i.e. November 1 - November 25, 2019)?
	@XmlElement(name = "your_campaign_timeline")
	private String yourCampaignTimeline;

	// Your email?
	@XmlElement(name = "your_email")
	private String yourEmail;

	// Your phone number?
	@XmlElement(name = "your_Phone_number")
	private String yourPhoneNumber;

	// Thank you for your interest. Please leave your preferred method of
	// communication below (phone number or email).
	// Our brand team will contact you shortly.
	// Mark only one oval.
	@XmlElement(name = "method_of_communication")
	private String methodOfCommunication;

	// Send me a copy of my responses.
	@XmlElement(name = "copy_of_response")
	private String copyOfResponse;

	@ManyToOne
	private Organization org;

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

	public List<String> getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(List<String> productCategory) {
		this.productCategory = productCategory;
	}

	public String getOverallBudget() {
		return overallBudget;
	}

	public void setOverallBudget(String overallBudget) {
		this.overallBudget = overallBudget;
	}

	public String getNoOfInfluencer() {
		return noOfInfluencer;
	}

	public void setNoOfInfluencer(String noOfInfluencer) {
		this.noOfInfluencer = noOfInfluencer;
	}

	public String getDescribeYourBrand() {
		return describeYourBrand;
	}

	public void setDescribeYourBrand(String describeYourBrand) {
		this.describeYourBrand = describeYourBrand;
	}

	public String getAgeForCampaign() {
		return ageForCampaign;
	}

	public void setAgeForCampaign(String ageForCampaign) {
		this.ageForCampaign = ageForCampaign;
	}

	public String getSocialMediaPlatform() {
		return socialMediaPlatform;
	}

	public void setSocialMediaPlatform(String socialMediaPlatform) {
		this.socialMediaPlatform = socialMediaPlatform;
	}

	public String getYourCampaignTimeline() {
		return yourCampaignTimeline;
	}

	public void setYourCampaignTimeline(String yourCampaignTimeline) {
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

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CompanySurveyVO [companysurveyId=" + companysurveyId + ", yourName=" + yourName + ", yourcompanyName="
				+ yourcompanyName + ", productCategory=" + productCategory + ", overallBudget=" + overallBudget
				+ ", noOfInfluencer=" + noOfInfluencer + ", describeYourBrand=" + describeYourBrand
				+ ", ageForCampaign=" + ageForCampaign + ", socialMediaPlatform=" + socialMediaPlatform
				+ ", yourCampaignTimeline=" + yourCampaignTimeline + ", yourEmail=" + yourEmail + ", yourPhoneNumber="
				+ yourPhoneNumber + ", methodOfCommunication=" + methodOfCommunication + ", copyOfResponse="
				+ copyOfResponse + ", org=" + org + ", getCompanysurveyId()=" + getCompanysurveyId()
				+ ", getYourName()=" + getYourName() + ", getYourcompanyName()=" + getYourcompanyName()
				+ ", getProductCategory()=" + getProductCategory() + ", getOverallBudget()=" + getOverallBudget()
				+ ", getNoOfInfluencer()=" + getNoOfInfluencer() + ", getDescribeYourBrand()=" + getDescribeYourBrand()
				+ ", getAgeForCampaign()=" + getAgeForCampaign() + ", getSocialMediaPlatform()="
				+ getSocialMediaPlatform() + ", getYourCampaignTimeline()=" + getYourCampaignTimeline()
				+ ", getYourEmail()=" + getYourEmail() + ", getYourPhoneNumber()=" + getYourPhoneNumber()
				+ ", getMethodOfCommunication()=" + getMethodOfCommunication() + ", getCopyOfResponse()="
				+ getCopyOfResponse() + ", getOrg()=" + getOrg() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
