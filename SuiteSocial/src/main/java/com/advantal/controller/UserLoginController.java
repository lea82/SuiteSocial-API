package com.advantal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.Influencer;
import com.advantal.model.Organization;
import com.advantal.model.UserLogin;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.UserLoginService;
import com.advantal.util.EmailTemplate;
import com.advantal.util.IConstant;
import com.advantal.util.MailSenderByThread;
import com.advantal.util.RandomStringGenerator;

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
		if (userLogin != null && userLogin.getEmailId() != null && !userLogin.getEmailId().equals("")) {
			if (userLogin.getUserType() == 1) {
				Organization orgLogin = organizationRepository.findByEmailId(userLogin.getEmailId());
				if (orgLogin != null) {
					if (orgLogin.getIsVerified() == 0) {
						
						String emailOtp=RandomStringGenerator.getRandomNumberString(4);
						//System.out.println(emailOtp);
						orgLogin.setEmailOtp(emailOtp);
				        Organization org=organizationRepository.save(orgLogin);
						String data = EmailTemplate.getMailBodyTemplate2(org.getEmailOtp());
						
						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =orgLogin.getOrganizationEmail();
						mailSenderByThread.msg =	data;
						mailSenderByThread.subject="SuiteSocial Otp";
						mailSenderByThread.start();

						map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
						map.put(IConstant.MESSAGE, "Otp not verfied");
					} else {
						boolean status = uloginService.userLogin(userLogin);
						if (status) {
							map.put(IConstant.RESPONSE, HttpStatus.OK);
							map.put(IConstant.MESSAGE, "Welcome, You're successfully logged in");
							map.put(IConstant.ORGANIZATION_EMAIL_ID, orgLogin.getOrganizationEmail());
							map.put(IConstant.ORGANIZATION_USER_ID, orgLogin.getOrganzationId());
							map.put(IConstant.USER_TYPE, userLogin.getUserType());
							map.put(IConstant.SURVEY_VERIFIED, orgLogin.isSurveyCompleted());
						    map.put(IConstant.IS_OTP_VERIFIED, orgLogin.getIsVerified());
						} else {
							map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
							map.put(IConstant.MESSAGE, "Invalid email Id or password");
						}

					}
				} else {
					map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
					map.put(IConstant.MESSAGE, "Invalid email Id or password");
				}
			} else {
				Influencer inLogin = influencerRepository.findByEmail(userLogin.getEmailId());
				if (inLogin != null) {
					if (inLogin.getIsVerified() == 0) {
						
						String emailOtp=RandomStringGenerator.getRandomNumberString(4);
						//System.out.println(emailOtp);
						inLogin.setEmailOtp(emailOtp);
						Influencer infl=influencerRepository.save(inLogin);
						String data = EmailTemplate.getMailBodyTemplate2(infl.getEmailOtp());
						
						MailSenderByThread mailSenderByThread = new MailSenderByThread();
						mailSenderByThread.toMailId =inLogin.getEmail();
						mailSenderByThread.msg =	data;
						mailSenderByThread.subject="SuiteSocial Otp";
						mailSenderByThread.start();
						map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
						map.put(IConstant.MESSAGE, "Otp not verfied");
					} else {
						boolean status = uloginService.userLogin(userLogin);
						if (status) {
							map.put(IConstant.RESPONSE, HttpStatus.OK);
							map.put(IConstant.MESSAGE, "Welcome, You're successfully logged in");
							map.put(IConstant.INFLUNCER_EMAIL_ID, inLogin.getEmail());
							map.put(IConstant.INFLUENCER_USERID, inLogin.getInfluencerId());
							map.put(IConstant.USER_TYPE, userLogin.getUserType());
							map.put(IConstant.SURVEY_VERIFIED, inLogin.isSurveyCompleted());
							map.put(IConstant.IS_OTP_VERIFIED, inLogin.getIsVerified());
						} else {
							map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
							map.put(IConstant.MESSAGE, "Invalid email Id or password");
						}
					}
				} else {
					map.put(IConstant.RESPONSE, HttpStatus.BAD_REQUEST);
					map.put(IConstant.MESSAGE, "Invalid email Id or password");
//					map.put(IConstant.MESSAGE, "No record found by this user");
				}
			}
		}
		return map;
	}

	
	@PostMapping("/forget_password") 
	public Map<Object, Object>forgetPassword(@RequestBody UserLogin userLogin) { 
	Map<Object, Object> map = new HashMap<Object, Object>(); 
	boolean status =uloginService.forwardLink(userLogin); 
	if (status) {
	  map.put(IConstant.RESPONSE, IConstant.SUCCESS);
	  map.put(IConstant.MESSAGE,IConstant.FORGOT_PASSWORD_SUCCESS_MESSAGE); 
	  } else  { 
		  if(userLogin!=null && userLogin.getUserType()!=null && userLogin.getUserType()==1) { 
	      Organization orgLogin=organizationRepository.findByEmailId(userLogin.getEmailId());
	 
	  if(orgLogin==null) {
	    map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
	    map.put(IConstant.MESSAGE, IConstant.EMAIL_EXIST_ERROR_MESSAGE);
	  
	  } else { 
		  map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
	    map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_ERROR_MESSAGE);
	    } 
	  }
	  else if (userLogin!=null && userLogin.getUserType()!=null &&userLogin.getUserType()==2) { 
		  Influencer inLogin=influencerRepository.findByEmail(userLogin.getEmailId());
	  if(inLogin==null) { 
		  map.put(IConstant.RESPONSE,IConstant.NOT_AUTHORIZED); 
		  map.put(IConstant.MESSAGE, IConstant.EMAIL_EXIST_ERROR_MESSAGE);
	  
	  }else {
		  map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
	      map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_ERROR_MESSAGE); 
	      }
	  
	  }
	  
	  else { 
		  map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
	      map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_ERROR_MESSAGE);
	      }
		}
	  return map;
	  
	  }

	/*
	 * @PostMapping("/forget_password") public Map<Object, Object>
	 * forgetPassword(@RequestBody UserLogin userLogin) { Map<Object, Object> map =
	 * new HashMap<Object, Object>(); boolean status =
	 * uloginService.forwardLink(userLogin); if (status) {
	 * map.put(IConstant.RESPONSE, IConstant.SUCCESS); map.put(IConstant.MESSAGE,
	 * IConstant.FORGOT_PASSWORD_SUCCESS_MESSAGE); } else { if(userLogin!=null &&
	 * userLogin.getUserType()!=null && userLogin.getUserType()==1) { Organization
	 * orgLogin=organizationRepository.findByEmailId(userLogin.getEmailId());
	 * 
	 * if(orgLogin==null) { map.put(IConstant.RESPONSE,
	 * IConstant.INTERNAL_SERVER_ERROR); map.put(IConstant.MESSAGEE,
	 * IConstant.EMAIL_EXIST_ERROR_MESSAGE);
	 * 
	 * }
	 * 
	 * } if (userLogin!=null && userLogin.getUserType()!=null &&
	 * userLogin.getUserType()==2) { Influencer
	 * inLogin=influencerRepository.findByEmail(userLogin.getEmailId());
	 * 
	 * if(inLogin==null) { map.put(IConstant.RESPONSE,
	 * IConstant.INTERNAL_SERVER_ERROR); map.put(IConstant.MESSAGEE,
	 * IConstant.EMAIL_EXIST_ERROR_MESSAGE);
	 * 
	 * } } map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
	 * map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_ERROR_MESSAGE); }
	 * 
	 * return map;
	 * 
	 * }
	 */
	 
	@PostMapping("/reset_password")
	public Map<Object, Object> resetPassword(@RequestBody UserLogin userLogin) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = uloginService.resetPassword(userLogin);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.PASSWORD_CHANGE_SUCCESS_MESSAGE);
		} else {
			if(userLogin!=null && userLogin.getUserType()!=null && userLogin.getUserType()==1) {
				Organization orgLogin=organizationRepository.findByEmailId(userLogin.getEmailId());
				
				if(orgLogin==null && userLogin.getPassword()== null) {
					map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
					map.put(IConstant.MESSAGEE, IConstant.EMAIL_EXIST_ERROR_MESSAGE);
						
				}
				
			}
			if (userLogin!=null && userLogin.getUserType()!=null && userLogin.getUserType()==2) {
				Influencer inLogin=influencerRepository.findByEmail(userLogin.getEmailId());
				
				if(inLogin==null && userLogin.getPassword()== null) {
					map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
					map.put(IConstant.MESSAGEE, IConstant.EMAIL_EXIST_ERROR_MESSAGE);
					
				}
			}
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.PASSWORD_CHANGE_ERROR_MESSAGE);
		}

		return map;

	}
	 
}
