package com.advantal.service;

import java.util.List;
import java.util.Map;

import com.advantal.model.InflPayload;
import com.advantal.model.Influencer;

public interface InfluencerService {
	public boolean createUser(Influencer influencer);
	
	public boolean socialcreateUser(Influencer influencer);

	public Influencer verifySocialUser(Influencer influencer);

	public List<InflPayload> getinfluencerList();

	
}
