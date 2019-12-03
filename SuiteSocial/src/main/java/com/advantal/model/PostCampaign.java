package com.advantal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="post_campaign")
public class PostCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_campaign_id")
	private Long postcampaignId;
    
	@Lob
	@Column(name="campaign_title")
    private String campaignTitle;
	
	@Column(name="sub_title")
    private String subTitle;
	
	
	@Column(name="start_date")
    private Date startDate;
	
	@Column(name="end_date")
    private Date endDate;
	
    //discription
	@Lob
	@Column(name="about_campaigning")
	private String aboutCampaigning;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="images")
	private String images;
	
	@Column(name="is_active" ,columnDefinition="boolean default true")
	private boolean isActive;
	
	
    @NotNull
	@Column(name="organzation_email")
	private String organizationEmail;
	

	public PostCampaign() {
		super();
	}

	

	public PostCampaign(Long postcampaignId, String campaignTitle, String subTitle, Date startDate, Date endDate,
			String aboutCampaigning, Integer status, String images, boolean isActive, String organizationEmail) {
		super();
		this.postcampaignId = postcampaignId;
		this.campaignTitle = campaignTitle;
		this.subTitle = subTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.aboutCampaigning = aboutCampaigning;
		this.status = status;
		this.images = images;
		this.isActive = isActive;
		this.organizationEmail = organizationEmail;
	}



	public Long getPostcampaignId() {
		return postcampaignId;
	}

	public void setPostcampaignId(Long postcampaignId) {
		this.postcampaignId = postcampaignId;
	}

	public String getCampaignTitle() {
		return campaignTitle;
	}

	public void setCampaignTitle(String campaignTitle) {
		this.campaignTitle = campaignTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	
	public String getAboutCampaigning() {
		return aboutCampaigning;
	}

	public void setAboutCampaigning(String aboutCampaigning) {
		this.aboutCampaigning = aboutCampaigning;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	
	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	

	public String getOrganizationEmail() {
		return organizationEmail;
	}



	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}



	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	@Override
	public String toString() {
		return "PostCampaign [postcampaignId=" + postcampaignId + ", campaignTitle=" + campaignTitle + ", subTitle="
				+ subTitle + ", startDate=" + startDate + ", endDate=" + endDate + ", aboutCampaigning="
				+ aboutCampaigning + ", status=" + status + ", images=" + images + ", isActive=" + isActive
				+ ", organizationEmail=" + organizationEmail + "]";
	}

	


	
		
}
