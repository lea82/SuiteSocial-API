package com.advantal.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.advantal.model.BrandToInfluencerRating;

@Service
public interface BrandToInfluencerRatingService {
	
	Map<Object, Object> searchBrandToInfluencerRatingReview(BrandToInfluencerRating brandToInfluencerRating);

	Map<Object, Object> getBrandToInfluencerRatingReviewRecordbyMail(String byEmail);

}
