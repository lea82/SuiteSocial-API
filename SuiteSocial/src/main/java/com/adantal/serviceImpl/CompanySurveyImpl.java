package com.adantal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.CompanySurvey;
import com.advantal.model.Organization;
import com.advantal.repository.CompanySurveyRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.CompanySurveyService;

@Service
public class CompanySurveyImpl implements CompanySurveyService{

	@Autowired
	private CompanySurveyRepository comSurveyRepo;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	@Override
	public CompanySurvey saveSurveyDetail(CompanySurvey companySurvey) {
		
		CompanySurvey companySurveySave = new CompanySurvey();
		
		companySurveySave=	comSurveyRepo.save(companySurvey);
		
		
		if(companySurveySave!=null) {
		Organization org =	organizationRepository.findByOrganzationId(companySurveySave.getOrg().getOrganzationId());
			org.setSurveyCompleted(true);
			organizationRepository.save(org);
		}
		return companySurveySave;
	}
	
	

}
