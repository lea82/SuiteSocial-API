package com.advantal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advantal.model.PostCampaign;

public interface PostCampaignRepository extends JpaRepository<PostCampaign, Long>{

	PostCampaign findBypostcampaignId(Long postcampaignId);

	//PostCampaign findByEmailId(String organizationEmail);


}
