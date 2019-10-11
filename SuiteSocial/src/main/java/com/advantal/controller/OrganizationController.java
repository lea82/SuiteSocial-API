package com.advantal.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advantal.model.CostumPayload;
import com.advantal.model.Organization;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.OrganizationService;
import com.advantal.util.IConstant;

@RestController
public class OrganizationController {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private OrganizationService organizationService;

	@SuppressWarnings("null")
	@PostMapping(value = "/verify_Organization")
	public Map<Object, Object> verifyOrganization(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Organization org = organizationRepository.findByOrganizationName(organization.getOrganizationName());
		if (org == null) {
			String uuidKey = UUID.randomUUID().toString();

			Organization orgnew = new Organization();
			orgnew.setOrganizationName(organization.getOrganizationName());
			orgnew.setOrganizationKey(uuidKey);
			System.out.println(uuidKey);
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.NOT_REGISTERED);
			map.put(IConstant.ORGANIZATION, orgnew);
			map.put(IConstant.STATUS, IConstant.ONE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
			map.put(IConstant.MESSAGE, IConstant.ORGANIZAION_VERIFY_MESSAGE);
			map.put(IConstant.STATUS, IConstant.ZERO);
		}
		return map;

	}

	@PostMapping("/create_org")
	public Map<Object, Object> createOrganization(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Organization o = organizationRepository.findByEmailId(organization.getOrganizationEmail());

		if (o != null) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.ORGANIZATION_ALREADY_MESSAGE);
		} else {

			if (organization != null) {
				boolean status = organizationService.createUser(organization);
				if (status) {
					map.put(IConstant.RESPONSE, IConstant.SUCCESS);
					map.put(IConstant.MESSAGE, IConstant.ORGANIZAION_CREATED_SUCCESS_MESSAGE);
					map.put(IConstant.STATUS, IConstant.ONE);

				} else {
					map.put(IConstant.RESPONSE, IConstant.NOT_AUTHORIZED);
					map.put(IConstant.MESSAGE, IConstant.ORGANIZATION_ERROR_MESSAGE);
				}
			}
		}

		return map;

	}

	@PostMapping("/verify_otp")
	public Map<Object, Object> verifyOtp(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = organizationService.verifyOtp(organization);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.VERIFY_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
			map.put(IConstant.MESSAGE, IConstant.VERIFY_ERROR_MESSAGE);
		}
		return map;

	}

	@PostMapping("/resend_otp")
	public Map<Object, Object> resendOtp(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		CostumPayload status = organizationService.resendOtp(organization);
		if (status != null) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.OTP_SEND_SUCCESS_MESSAGE);
			if (status.getInfluencer() != null) {
				map.put(IConstant.EMAIL_OTP, status.getInfluencer().getEmailOtp());
			} else {
				if (status.getOrganization() != null) {
					map.put(IConstant.EMAIL_OTP, status.getOrganization().getEmailOtp());
				}
			}
		} else {
			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
			map.put(IConstant.MESSAGE, IConstant.OTP_SEND_ERROR_MESSAGE);
		}
		return map;

	}

	@PostMapping("/forget_password")
	public Map<Object, Object> forgetPassword(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = organizationService.forwardLink(organization);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
			map.put(IConstant.MESSAGE, IConstant.FORGOT_PASSWORD_ERROR_MESSAGE);
		}

		return map;
	}

	@PostMapping("/reset_password")
	public Map<Object, Object> resetPassword(@RequestBody Organization organization) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = organizationService.resetPassword(organization);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS);
			map.put(IConstant.MESSAGE, IConstant.PASSWORD_CHANGE_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.INTERNAL_SERVER_ERROR);
			map.put(IConstant.MESSAGE, IConstant.PASSWORD_CHANGE_ERROR_MESSAGE);
		}

		return map;

	}
}