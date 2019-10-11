package com.adantal.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.Influencer;
import com.advantal.model.Organization;
import com.advantal.model.UserLogin;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.UserLoginService;
import com.advantal.util.AESCipher;

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
//				String despassword = AESCipher.aesDecryptString(userLogin.getPassword(), AESCipher.CUSTOMER_KEY);
//				String inPassword = DigestUtils.sha256Hex(despassword);
				
				String rncPwd=	AESCipher.aesEncryptString(userLogin.getPassword(),AESCipher.CUSTOMER_KEY );
				System.out.println("InfluencerServiceImpl.createUser()"+ rncPwd);
				String str =AESCipher.aesDecryptString(rncPwd, AESCipher.CUSTOMER_KEY);
				System.out.println(str);
				String inPassword = DigestUtils.sha256Hex(str);
				
				
				System.err.println(inPassword);
				
				System.err.println(influencer.getPassword());
				if (inPassword.equals(influencer.getPassword())) {
					return status = true;
				} else {
					return status = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return status = false;
		}
		return status = false;
	}

}
