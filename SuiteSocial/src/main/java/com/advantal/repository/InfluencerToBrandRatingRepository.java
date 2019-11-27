package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.BrandToInfluencerRating;
import com.advantal.model.InfluencerToBrandRating;

public interface InfluencerToBrandRatingRepository extends JpaRepository<InfluencerToBrandRating, Long>{

	@Query(value = "SELECT * FROM influencer_to_brand_rating WHERE brand_email_id = :brandEmailId ", nativeQuery = true)
	List<InfluencerToBrandRating> findByBrandEmail(String brandEmailId);
	
	@Query(value = " FROM InfluencerToBrandRating WHERE brandEmailId= :byEmail   ")
	List<InfluencerToBrandRating> findInfluencerToBrandRatingRecordsbyMail(String byEmail);

}
