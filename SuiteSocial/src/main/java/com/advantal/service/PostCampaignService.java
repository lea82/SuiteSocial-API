package com.advantal.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.advantal.model.PostCampaign;

public interface PostCampaignService {

	public PostCampaign addPostCampaign(PostCampaign postCampaign, MultipartFile[] files);

	PostCampaign addCronJobPostCampaign();

	public Map<Object, Object> getPostCampaignRecordbyMail(String byEmail);
	
	public Map<Object, Object> getCountPostCampaignRecordbyMail(String byEmail);

}
