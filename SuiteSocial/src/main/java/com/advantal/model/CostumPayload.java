package com.advantal.model;

public class CostumPayload {
	
	private Organization organization;
	
	private Influencer influencer;
	
	

	public CostumPayload() {
		super();
	}

	public CostumPayload(Organization organization, Influencer influencer) {
		super();
		this.organization = organization;
		this.influencer = influencer;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Influencer getInfluencer() {
		return influencer;
	}

	public void setInfluencer(Influencer influencer) {
		this.influencer = influencer;
	}
	
	

}
