package com.advantal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="influencer_to_brand_rating")
public class InfluencerToBrandRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="influencer_id")
	private Long influencerId;
	
	@Column(name="reviewer_email_id")
	private String reviewerEmailId;
	
	@Column(name="rating")
	private Double rating;
	
	@Column(name="brand_email_id")
	private String brandEmailId;
	
	@Lob
	@Column(name="review_remark")
	private String reviewRemark;
	
	@Transient
	private Double averageRating;

	@Transient
	private Integer totalRating;

	public Long getInfluencerId() {
		return influencerId;
	}

	public void setInfluencerId(Long influencerId) {
		this.influencerId = influencerId;
	}

	public String getReviewerEmailId() {
		return reviewerEmailId;
	}

	public void setReviewerEmailId(String reviewerEmailId) {
		this.reviewerEmailId = reviewerEmailId;
	}

	
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getBrandEmailId() {
		return brandEmailId;
	}

	public void setBrandEmailId(String brandEmailId) {
		this.brandEmailId = brandEmailId;
	}

	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}

	
	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Integer getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(Integer totalRating) {
		this.totalRating = totalRating;
	}

	@Override
	public String toString() {
		return "InfluencerToBrandRating [influencerId=" + influencerId + ", reviewerEmailId=" + reviewerEmailId
				+ ", rating=" + rating + ", brandEmailId=" + brandEmailId + ", reviewRemark=" + reviewRemark
				+ ", averageRating=" + averageRating + ", totalRating=" + totalRating + "]";
	}
	
	
	
}
