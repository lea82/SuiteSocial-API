package com.adantal.vo;

public class BrandToInfluencerRatingVO {
	
	private String reviewerEmailId;
	
	private String influencerEmailId;
	
	private Double averageRating;

	private Integer totalRating;

	public String getReviewerEmailId() {
		return reviewerEmailId;
	}

	public void setReviewerEmailId(String reviewerEmailId) {
		this.reviewerEmailId = reviewerEmailId;
	}

	public String getInfluencerEmailId() {
		return influencerEmailId;
	}

	public void setInfluencerEmailId(String influencerEmailId) {
		this.influencerEmailId = influencerEmailId;
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
		return "BrandToInfluencerRatingVO [reviewerEmailId=" + reviewerEmailId + ", influencerEmailId="
				+ influencerEmailId + ", averageRating=" + averageRating + ", totalRating=" + totalRating + "]";
	}
	
	
	

}
