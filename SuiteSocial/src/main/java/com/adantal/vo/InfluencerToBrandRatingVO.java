package com.adantal.vo;

import javax.persistence.Transient;

public class InfluencerToBrandRatingVO {
	
	private String reviewerEmailId;
	
	private String brandEmailId;
	
	@Transient
	private Double averageRating;

	@Transient
	private Integer totalRating;

	public String getReviewerEmailId() {
		return reviewerEmailId;
	}

	public void setReviewerEmailId(String reviewerEmailId) {
		this.reviewerEmailId = reviewerEmailId;
	}

	public String getBrandEmailId() {
		return brandEmailId;
	}

	public void setBrandEmailId(String brandEmailId) {
		this.brandEmailId = brandEmailId;
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
		return "InfluencerToBrandRatingVO [reviewerEmailId=" + reviewerEmailId + ", brandEmailId=" + brandEmailId
				+ ", averageRating=" + averageRating + ", totalRating=" + totalRating + "]";
	}
	
	


}
