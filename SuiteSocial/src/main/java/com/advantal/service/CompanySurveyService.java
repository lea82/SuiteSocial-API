package com.advantal.service;

import java.util.List;
import java.util.Map;

import com.adantal.vo.CompanySurveyVO;
import com.advantal.model.CompanySurvey;

public interface CompanySurveyService {
	

	CompanySurvey saveSurveyDetail(CompanySurvey companySurvey);

	Map<Object, Object> searchByCmnyCriteria(CompanySurveyVO companySurveyVO);

	List<CompanySurvey> findAllCompanySurvey();
}
