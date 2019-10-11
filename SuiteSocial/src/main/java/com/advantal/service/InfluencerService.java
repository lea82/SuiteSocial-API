package com.advantal.service;

import com.advantal.model.Influencer;

public interface InfluencerService {
	public boolean createUser(Influencer influencer);
	
	public boolean socialcreateUser(Influencer influencer);

	public Influencer verifySocialUser(Influencer influencer);

	//public boolean verifyOtp(Influencer influencer);
	
	//public Influencer resendOtp(Influencer influencer);
	
}
