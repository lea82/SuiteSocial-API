package com.advantal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adantal.vo.InfluencerSurveyVO;
import com.advantal.model.InfluencerSurvey;
import com.advantal.service.InfluencerSurveyService;
import com.advantal.util.IConstant;

@RestController
public class InfluencerSurveyController {
	@Autowired
	private InfluencerSurveyService inflSurveyService;

	@PostMapping("/Save_Influencer_Survey_Details")
	public Map<Object, Object> createInfluencerSurvey(@RequestBody InfluencerSurvey influencerSurvey) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		InfluencerSurvey oldInfluencerSurvey = inflSurveyService.saveSurveyDetail(influencerSurvey);
		if (oldInfluencerSurvey != null) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.OBJECT, oldInfluencerSurvey);

		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.INFLUENCER_SURVEY_ERROR_MESSAGE);
		}

		return map;
	}

	@PostMapping("/search_Influencer_Survey_by_criteria")
	public Map<Object, Object> searchByInfluencerSurveyCriteria(@RequestBody InfluencerSurveyVO InfluencerSurveyVO) {

		return inflSurveyService.searchByInfluencerSurveyCriteria(InfluencerSurveyVO);

	}
}
