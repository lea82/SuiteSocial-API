package com.advantal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.CompanySurvey;
import com.advantal.service.CompanySurveyService;
import com.advantal.util.IConstant;

@RestController
public class CompanySurveyController {
	
	@Autowired
	private CompanySurveyService comSurveyService;
	
	
	@PostMapping("/Save_ComponySurvey_Details")
	public Map<Object, Object> createComponySurvey(@RequestBody CompanySurvey companySurvey) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		CompanySurvey oldCompanySurvey=comSurveyService.saveSurveyDetail(companySurvey);
			if (oldCompanySurvey != null) {
					map.put(IConstant.RESPONSE, IConstant.SUCCESS);
					map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
					map.put(IConstant.OBJECT, oldCompanySurvey);

				} else {
					map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
					map.put(IConstant.MESSAGE, IConstant.COMPANYSURVEY_ERROR_MESSAGE);
				}

		return map;

	}

}
