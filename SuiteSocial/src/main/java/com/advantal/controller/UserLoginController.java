package com.advantal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.Influencer;
import com.advantal.model.Organization;
import com.advantal.model.UserLogin;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.UserLoginService;
import com.advantal.util.IConstant;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService uloginService;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private InfluencerRepository influencerRepository;

	@PostMapping(value = "/user_login")
	public Map<Object, Object> signupUserRole(@RequestBody UserLogin userLogin) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status=uloginService.userLogin(userLogin);
		if (status) {
			if(userLogin!=null && userLogin.getUserType()!=null && userLogin.getUserType()==1) {
				Organization orgLogin=organizationRepository.findByEmailId(userLogin.getEmailId());
				map.put(IConstant.ORGANIZATION_EMAIL_ID, orgLogin.getOrganizationEmail());
				map.put(IConstant.ORGANIZATION_USER_ID, orgLogin.getOrganzationId());
				map.put(IConstant.USER_TYPE, userLogin.getUserType());
			    map.put(IConstant.SURVEY_VERIFIED, orgLogin.isSurveyCompleted());
				
					
			}
			if(userLogin!=null && userLogin.getUserType()!=null && userLogin.getUserType()==2) {
				Influencer inLogin=influencerRepository.findByEmail(userLogin.getEmailId());
				map.put(IConstant.INFLUNCER_EMAIL_ID,inLogin.getEmail());
				map.put(IConstant.INFLUENCER_USERID, inLogin.getInfluencerId());
				map.put(IConstant.USER_TYPE, userLogin.getUserType());
				map.put(IConstant.SURVEY_VERIFIED, inLogin.isSurveyCompleted());
				
		}
			map.put(IConstant.STATUS, IConstant.ONE);
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.USER_LOGIN_SUCCESS_MESSAGE);
			
		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.USER_LOGIN_ERROR_MESSAGE);
		}
		return map;

	}
	
}
