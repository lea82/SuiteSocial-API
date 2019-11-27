
package com.advantal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.InfluencerToBrandRating;
import com.advantal.service.InfluencerToBrandRatingService;

@RestController
@RequestMapping("/review")
public class InfluencerToBrandRatingController {

	@Autowired
	InfluencerToBrandRatingService influencerToBrandRatingService;

	@PostMapping("/save_influencer_to_brand_rating")
	public Map<Object, Object> searchInfluencerToBrandRatingReview(@RequestBody InfluencerToBrandRating influencerToBrandRating) {
		
		return influencerToBrandRatingService.searchInfluencerToBrandRatingReview(influencerToBrandRating);

   }		

	@PostMapping(value = "/get_influencer_to_brand_rating_by_email")
	public Map<Object, Object> findInfluencerToBrandRatingReviewByEmail(@RequestBody Map<String, String> reqParams) {		
		
		return influencerToBrandRatingService.getInfluencerToBrandRatingReviewRecordbyMail(reqParams.get("brandEmailId"));	
	}

}
