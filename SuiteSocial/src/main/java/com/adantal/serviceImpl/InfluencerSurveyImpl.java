package com.adantal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.Influencer;
import com.advantal.model.InfluencerSurvey;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.InfluencerSurveyRepository;
import com.advantal.service.InfluencerSurveyService;

@Service
public class InfluencerSurveyImpl implements InfluencerSurveyService{

	@Autowired
	private InfluencerSurveyRepository inflSurveyRepo;
	
	
	@Autowired
	private InfluencerRepository  influencerRepository;
	
	@Override
	public InfluencerSurvey saveSurveyDetail(InfluencerSurvey influencerSurvey) {
		
		InfluencerSurvey infsave	= inflSurveyRepo.save(influencerSurvey);
		
		if(infsave!=null) {
			Influencer org =	influencerRepository.findByInfluencerId(infsave.getInfl().getInfluencerId());
				org.setSurveyCompleted(true);
				influencerRepository.save(org);
			}
		return infsave;
	}

}
