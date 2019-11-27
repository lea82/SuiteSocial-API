
package com.advantal.service;

import java.util.Map;

import com.advantal.model.InfluencerToBrandRating;

public interface InfluencerToBrandRatingService {

	InfluencerToBrandRating saveRatingDetail(InfluencerToBrandRating influencerToBrandRating);

	Map<Object, Object> searchInfluencerToBrandRatingReview(InfluencerToBrandRating influencerToBrandRating);

	Map<Object, Object> getInfluencerToBrandRatingReviewRecordbyMail(String byEmail);

}
