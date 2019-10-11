package com.advantal.service;

import com.advantal.model.CostumPayload;
import com.advantal.model.Organization;

public interface OrganizationService {
	

	public boolean createUser(Organization organization);
	
	boolean verifyOtp(Organization organization);

	public CostumPayload resendOtp(Organization organization);

	public boolean resetPassword(Organization organization);

	public boolean forwardLink(Organization organization);

}
