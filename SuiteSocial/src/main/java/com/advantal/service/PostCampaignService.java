package com.advantal.service;

import org.springframework.web.multipart.MultipartFile;

import com.advantal.model.PostCampaign;

public interface PostCampaignService {

	public PostCampaign addPostCampaign(PostCampaign postCampaign, MultipartFile[] files);

	PostCampaign addCronJobPostCampaign();

}
