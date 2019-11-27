package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.BrandToInfluencerRating;

public interface BrandToInfluencerRatingRepository extends JpaRepository<BrandToInfluencerRating, Long> {

	@Query(value = "SELECT * FROM brand_to_influencer_rating WHERE influencer_email_id = :influencerEmailId ", nativeQuery = true)
	List<BrandToInfluencerRating> findByInfluencerEmail(String influencerEmailId);

	@Query(value = " FROM BrandToInfluencerRating WHERE influencerEmailId= :byEmail   ")
	List<BrandToInfluencerRating> findBrandToInfluencerRatingRecordsbyMail(String byEmail);

}
