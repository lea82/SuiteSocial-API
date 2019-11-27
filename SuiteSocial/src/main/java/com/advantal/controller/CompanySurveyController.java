package com.advantal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adantal.vo.CompanySurveyVO;
import com.advantal.model.CompanySurvey;
import com.advantal.model.InfluencerSurvey;
import com.advantal.service.CompanySurveyService;
import com.advantal.util.IConstant;

@RestController
public class CompanySurveyController {

	@Autowired
	private CompanySurveyService companySurveyService;
	
	@Autowired
	private CompanySurveyService comSurveyService;
	
	@GetMapping("/getallCompanySurvey")
	public List<CompanySurvey> getRecentlyMessages() {
		return comSurveyService.findAllCompanySurvey();
	}

	@PostMapping("/Save_ComponySurvey_Details")
	public Map<Object, Object> createComponySurvey(@RequestBody CompanySurvey companySurvey) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		CompanySurvey oldCompanySurvey = comSurveyService.saveSurveyDetail(companySurvey);
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


	@PostMapping("/cmny_search_by_criteria")
	public Map<Object, Object> searchByCmnyCriteria(@RequestBody CompanySurveyVO CompanySurveyVO) {
		
		return companySurveyService.searchByCmnyCriteria(CompanySurveyVO);

	}
	
	@PostMapping(value = "/get_company_survey_by_email")
	public Map<Object, Object> findCompanySurveyByEmail(@RequestBody Map<String, String> reqParams) {		
		
		return companySurveyService.getCompanySurveyRecordbyMail(reqParams.get("yourEmail"));	
	}
	
	@PostMapping(value = "/edit_company_survey")
	public Map<Object, Object> editCompanySurveyByEmail(@RequestBody CompanySurvey companySurvey) {		
		
		return companySurveyService.editCompanySurveyRecord(companySurvey);	
	}


}
