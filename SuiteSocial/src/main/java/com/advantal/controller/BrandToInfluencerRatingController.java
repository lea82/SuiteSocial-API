package com.advantal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.BrandToInfluencerRating;
import com.advantal.service.BrandToInfluencerRatingService;

@RestController
@RequestMapping("/review")
public class BrandToInfluencerRatingController {

	@Autowired
	BrandToInfluencerRatingService brandToInfluencerRatingService;

	@PostMapping("/save_brand_to_influencer_rating")
	public Map<Object, Object> searchBrandToInfluencerRatingReview(
			@RequestBody BrandToInfluencerRating brandToInfluencerRating) {

		return brandToInfluencerRatingService.searchBrandToInfluencerRatingReview(brandToInfluencerRating);

	}
	
	@PostMapping(value = "/get_brand_to_influencer_rating_by_email")
	public Map<Object, Object> findBrandToInfluencerRatingReviewByEmail(@RequestBody Map<String, String> reqParams) {		
		
		return brandToInfluencerRatingService.getBrandToInfluencerRatingReviewRecordbyMail(reqParams.get("influencerEmailId"));	
	}

}
