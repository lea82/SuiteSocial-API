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
@Table(name = "brand_to_influencer_rating")
public class BrandToInfluencerRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "brand_id")
	private Long brandId;

	@Column(name = "reviewer_email_id")
	private String reviewerEmailId;

	@Column(name = "rating")
	private Double rating;

	@Column(name = "influencer_email_id")
	private String influencerEmailId;
    
	@Lob
	@Column(name = "review_remark")
	private String reviewRemark;

	/*
	 * @Transient private String userType;
	 */
	@Transient
	private Double averageRating;

	@Transient
	private Integer totalRating;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getInfluencerEmailId() {
		return influencerEmailId;
	}

	public void setInfluencerEmailId(String influencerEmailId) {
		this.influencerEmailId = influencerEmailId;
	}

	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
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
		return "BrandToInfluencerRating [brandId=" + brandId + ", reviewerEmailId=" + reviewerEmailId + ", rating="
				+ rating + ", influencerEmailId=" + influencerEmailId + ", reviewRemark=" + reviewRemark
				+ ", averageRating=" + averageRating + ", totalRating=" + totalRating + "]";
	}

}
