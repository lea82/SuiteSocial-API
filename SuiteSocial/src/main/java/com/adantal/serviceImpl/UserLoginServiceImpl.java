package com.adantal.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.advantal.model.Influencer;
import com.advantal.model.Organization;
import com.advantal.model.UserLogin;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.UserLoginService;
import com.advantal.util.AESCipher;
import com.advantal.util.EmailTemplate;
import com.advantal.util.IConstant;
import com.advantal.util.MailSenderByThread;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private OrganizationRepository orgRepository;

	@Autowired
	private InfluencerRepository inflRepository;

	@Override
	public boolean userLogin(UserLogin userLogin) {
		boolean status = false;
		try {
			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 1 && userLogin.getPassword() != null
					&& !userLogin.getPassword().equals("")) {
				Organization organization = orgRepository.findByEmailId(userLogin.getEmailId());
				String descpassword = AESCipher.aesDecryptString(userLogin.getPassword(), AESCipher.CUSTOMER_KEY);
				String password = DigestUtils.sha256Hex(descpassword);
				if (password.equals(organization.getOrganizationpwd())) {
					return status = true;
				} else {
					return status = false;
				}
			}

			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 2 && userLogin.getPassword() != null
					&& !userLogin.getPassword().equals("")) {
				Influencer influencer = inflRepository.findByEmail(userLogin.getEmailId());

				String str = AESCipher.aesDecryptString(userLogin.getPassword(), AESCipher.CUSTOMER_KEY);
				System.out.println(str);
				String sha256hex = DigestUtils.sha256Hex(str);
				if (sha256hex.equals(influencer.getPassword())) {
					return status = true;
				} else {
					return status = false;
				}
			}
		} catch (Exception e) {

			//e.printStackTrace();
			return status = false;
		}
		return status = false;
	}


	@Override
	public boolean forwardLink(UserLogin userLogin) {
		boolean status = false;
		try {
			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 1 ) {
				Organization org = orgRepository.findByEmailId(userLogin.getEmailId());
				if (org != null) {
					String data = EmailTemplate.getTemplate(org.getOrganizationName(), org.getOrganizationEmail());
					MailSenderByThread mailSenderByThread = new MailSenderByThread();
					mailSenderByThread.toMailId = org.getOrganizationEmail();
					mailSenderByThread.msg = data;
					mailSenderByThread.subject = "Email Link";
					mailSenderByThread.start();
					return status = true;
				} else {
					return status = false;
				}
			}

			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 2) {
				Influencer infl = inflRepository.findByEmail(userLogin.getEmailId());
				if (infl != null) {
					String data = EmailTemplate.getTemplate1(infl.getEmail());

					MailSenderByThread mailSenderByThread = new MailSenderByThread();
					mailSenderByThread.toMailId = infl.getEmail();
					mailSenderByThread.msg = data;
					mailSenderByThread.subject = "Email Link";
					mailSenderByThread.start();
					return status = true;
				} else {
					return status = false;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return status = false;
		}
		return status = false;
	}

	
//	@Override
//	public boolean resetPassword(UserLogin userLogin) {
//		boolean status = false;
//		try {
//			if (organization != null) {
//				Organization orgdetail = organizationRepository.findByEmailId(organization.getOrganizationEmail());
//				if (orgdetail != null) {
//					String str = AESCipher.aesDecryptString(organization.getOrganizationpwd(), AESCipher.CUSTOMER_KEY);
//					System.out.println(str);
//					String sha256hex = DigestUtils.sha256Hex(str);
//					orgdetail.setOrganizationpwd(sha256hex);
//					organizationRepository.save(orgdetail); // Organization org =
//					organizationRepository.save(organization);
//					return true;
//
//				} else {
//					return false;
//				}
//
//			} else {
//				return false;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}
	 
	@Override
	public boolean resetPassword(UserLogin userLogin) {
		boolean status = false;
		try {
			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 1 && userLogin.getPassword() != null
							&& !userLogin.getPassword().equals("") ) {
				Organization org = orgRepository.findByEmailId(userLogin.getEmailId());
				if (org != null) {
					String str = AESCipher.aesDecryptString(userLogin.getPassword(), AESCipher.CUSTOMER_KEY);
					System.out.println(str);
					String sha256hex = DigestUtils.sha256Hex(str);
					org.setOrganizationpwd(sha256hex);
					orgRepository.save(org);
					return status = true;
				} else {
					return status = false;
				}
			}

			if (userLogin != null && userLogin.getUserType() != null && userLogin.getEmailId() != null
					&& userLogin.getUserType() == 2 && userLogin.getPassword() != null
							&& !userLogin.getPassword().equals("")) {
				Influencer infl = inflRepository.findByEmail(userLogin.getEmailId());
				if (infl != null) {
					String str = AESCipher.aesDecryptString(userLogin.getPassword(), AESCipher.CUSTOMER_KEY);
					System.out.println(str);
					String sha256hex = DigestUtils.sha256Hex(str);
					infl.setPassword(sha256hex);
				//	organizationRepository.save(orgdetail); // Organization org =
					inflRepository.save(infl);
					return status = true;
				} else {
					return status = false;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return status = false;
		}
		return status = false;
	}

}
