package com.advantal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advantal.model.PostCampaign;

public interface PostCampaignRepository extends JpaRepository<PostCampaign, Long>{

	PostCampaign findBypostcampaignId(Long postcampaignId);

	@Query(value = "FROM PostCampaign WHERE organizationEmail= :byEmail ORDER BY postcampaignId DESC")
	List<PostCampaign> findPostCampaignRecordbyMail(String byEmail);

	@Query(value ="FROM  PostCampaign ORDER BY postcampaignId DESC")
	List<PostCampaign> findByDesecdingOrder();
	
	@Query(value = "FROM PostCampaign WHERE organizationEmail= :byEmail")
	List<PostCampaign> findPostCampaignRecordbyMailCount(String byEmail);
	
//	@Query(value = " SELECT COUNT(*) FROM post_campaign WHERE `organzation_email`= :byEmail", nativeQuery = true)
//	List<PostCampaign> findPostCampaignRecordbyMailCount(String byEmail);

	


}
