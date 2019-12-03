package com.advantal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.advantal.model.InflPayload;
import com.advantal.model.Influencer;
import com.advantal.repository.InfluencerRepository;
import com.advantal.service.InfluencerService;
import com.advantal.util.IConstant;

@RestController
public class InfluencerController {
	
	@Autowired
	private InfluencerService influencerService;
	
	@Autowired
	private InfluencerRepository influencerRepository;
	
	@PostMapping("/create_influencer")
	public Map<Object, Object> createOrganization(@RequestBody Influencer influencer) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Influencer i = influencerRepository.findByEmail(influencer.getEmail());
		if (i!=null) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.INFLUENCER_ALREADY_MESSAGE);
		} else {
			if (influencer != null) {
				boolean status = influencerService.createUser(influencer);
				if (status) {
					map.put(IConstant.RESPONSE, IConstant.SUCCESS);
					map.put(IConstant.MESSAGE, IConstant.INFLUENCER_CREATED_SUCCESS_MESSAGE);
					map.put(IConstant.STATUS, IConstant.ONE);

				} else {
					map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
					map.put(IConstant.MESSAGE, IConstant.INFLUENCER_ERROR_MESSAGE);
				}
			} 

		}

		return map;

	}
	
//	@PostMapping("/verify_otp_infl")
//	public Map<Object, Object> verifyOtp(@RequestBody Influencer influencer) {
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		//Organization detail=organizationRepository.findByEmailId(organization.getOrganizationEmail());
//		boolean status = influencerService.verifyOtp(influencer);
//		if (status) {
//			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
//			map.put(IConstant.MESSAGE, IConstant.VERIFY_SUCCESS_MESSAGE);
//		} else {
//			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
//			map.put(IConstant.MESSAGE, IConstant.VERIFY_ERROR_MESSAGE);
//		}
//		return map;
//	
//	}
//	
//	@PostMapping("/resend_otp_infl")
//	public Map<Object, Object> resendOtp(@RequestBody Influencer influencer) {
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		Influencer status = influencerService.resendOtp(influencer);
//		if (status!=null) {
//			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
//			map.put(IConstant.MESSAGE, IConstant.OTP_SEND_SUCCESS_MESSAGE);
//			map.put(IConstant.EMAIL_OTP, status.getEmailOtp());
//		} else {
//			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
//			map.put(IConstant.MESSAGE, IConstant.OTP_SEND_ERROR_MESSAGE);
//		}
//		return map;
//	
//	}
//	
	
//	@CrossOrigin
//	@PostMapping("/create_influencer")
//	public Map<Object, Object> createInfluencer(@RequestBody Influencer influencer) {
//		Map<Object, Object> map = new HashMap<Object, Object>();
//		if (influencer != null) {
//			Influencer influencerObj = influencerService.createUser(influencer);
//			if (influencerObj!=null) {
//				
//				if(influencerObj.getResponse()==0) {
//					
//					map.put(IConstant.RESPONSE, IConstant.SUCCESS);
//					map.put(IConstant.MESSAGE, IConstant.INFLUENCER_CREATED_SUCCESS_MESSAGE);
//					map.put(IConstant.STATUS, IConstant.ONE);
//					map.put(IConstant.INFLUENCER_USERID, influencerObj.getInfluencerId());
//					
//					map.put(IConstant.INFLUNCER_EMAIL_ID, influencerObj.getEmail());
//
//				}
//				
//				if(influencerObj.getResponse()==1) {
//					
//					map.put(IConstant.RESPONSE, IConstant.ERROR_MESSAGE);
//				
//					
//					map.put(IConstant.ERROR_MESSAGE, IConstant.EMAIL_EXIST);
//
//				}
//					
//			} else {
//				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
//				map.put(IConstant.MESSAGE, IConstant.ORGANIZATION_ERROR_MESSAGE);
//			}
//		} else {
//			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
//			map.put(IConstant.MESSAGE, IConstant.ORGANIZATION_ERROR_MESSAGE);
//		}
//
//		return map;
//
//	}
		
	@CrossOrigin
	@PostMapping("/social_signup")
	public Map<Object, Object> influencerSocialSignup(@RequestBody Influencer influencer) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (influencer != null) {
			boolean status = influencerService.socialcreateUser(influencer);
			if (status) {
				map.put(IConstant.RESPONSE, IConstant.SUCCESS);
				map.put(IConstant.MESSAGE, IConstant.INFLUENCER_SOCIAL_CREATED_SUCCESS_MESSAGE);
				map.put(IConstant.STATUS, IConstant.ONE);

			} else {
				map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
				map.put(IConstant.MESSAGE, IConstant.INFLUENCER_SOCIAL_ERROR_MESSAGE);
			}
		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.INFLUENCER_SOCIAL_ERROR_MESSAGE);
		}

		return map;
}
	
	@GetMapping(value = "/influencer_list")
	public Map<Object, Object> findByAll() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<InflPayload> influencerList = influencerService.getinfluencerList();
		if (influencerList.size() >0 && !influencerList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.RESPONSE_LIST, influencerList);
		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.EMPTY_LIST_MESSAGE);
		}

		return map;
	}
	@SuppressWarnings("unused")
	@PostMapping(value = "/verify_social_id")
	public Map<Object, Object> verifySocialId(@RequestBody Influencer influencer,
			UriComponentsBuilder ucBuilder) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Influencer Infl=influencerService.verifySocialUser(influencer);
		if (Infl!=null && Infl.getSocialLoginId()!=null && Infl.getSocialLoginType()!=null ) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.VERIFY_STATUS, IConstant.ONE);
			
		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.VERIFY_STATUS, IConstant.ZERO);
		}
		return map;
		}
	
	
		
	
}
