package com.advantal.service;

import java.util.List;

import com.advantal.model.CostumPayload;
import com.advantal.model.OrgPayload;
import com.advantal.model.Organization;

public interface OrganizationService {
	

	public boolean createUser(Organization organization);
	
	boolean verifyOtp(Organization organization);

	public CostumPayload resendOtp(Organization organization);

	public List<OrgPayload> getorganizationList();

}
