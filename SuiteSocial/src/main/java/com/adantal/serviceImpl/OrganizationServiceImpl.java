package com.adantal.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.CostumPayload;
import com.advantal.model.Influencer;
import com.advantal.model.Organization;
import com.advantal.repository.InfluencerRepository;
import com.advantal.repository.OrganizationRepository;
import com.advantal.service.OrganizationService;
import com.advantal.util.AESCipher;
import com.advantal.util.EmailTemplate;
import com.advantal.util.IConstant;
import com.advantal.util.MailSenderByThread;
import com.advantal.util.RandomStringGenerator;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private InfluencerRepository influencerRepository;


	@Override
	public boolean createUser(Organization organization) {
		try {

			String rncPwd = AESCipher.aesEncryptString(organization.getOrganizationpwd(), AESCipher.CUSTOMER_KEY);
			System.out.println("OrganizationServiceImpl.createUser()" + rncPwd);
			// String str =AESCipher.aesDecryptString(organization.getOrganizationpwd(),
			// AESCipher.CUSTOMER_KEY);
			String str = AESCipher.aesDecryptString(rncPwd, AESCipher.CUSTOMER_KEY);
			System.out.println(str);
			String sha256hex = DigestUtils.sha256Hex(str);
			organization.setOrganizationpwd(sha256hex);

			String emailOtp = RandomStringGenerator.getRandomNumberString(4);
			organization.setEmailOtp(emailOtp);

			Organization org = organizationRepository.save(organization);

			if (org != null) {
				String data = EmailTemplate.getMailBodyTemplate(org.getEmailOtp());

				MailSenderByThread mailSenderByThread = new MailSenderByThread();
				mailSenderByThread.toMailId = org.getOrganizationEmail();
				mailSenderByThread.msg = data;
				mailSenderByThread.subject = "SuiteSocial Registration";
				mailSenderByThread.start();

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean verifyOtp(Organization organization) {
		try {
			if (organization != null && organization.getEmailOtp() != null && !organization.getEmailOtp().equals("")) {
				Organization detail = organizationRepository.findByEmailId(organization.getOrganizationEmail());
				if (detail != null && detail.getEmailOtp().equals(organization.getEmailOtp())) {

					detail.setIsVerified(IConstant.ONE);
					organizationRepository.save(detail);
					return true;
				} else {
//					Influencer infdetail =influencerRepository.findByEmailId(organization.getOrganizationEmail());
					Influencer infdetail = influencerRepository.findByEmail(organization.getOrganizationEmail());

					if (infdetail != null && infdetail.getEmailOtp().equals(organization.getEmailOtp())) {
						infdetail.setIsVerified(IConstant.ONE);
						influencerRepository.save(infdetail);
						return true;
					} else {
						return false;
					}
				}

			}

			else {
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

//	@Override
//	public Organization resendOtp(Organization organization) {
//		Organization orgSave = new Organization();
//		try {
//			Organization  org=organizationRepository.findByEmailId(organization.getOrganizationEmail());
//			org.setEmailOtp(RandomStringGenerator.getRandomNumberString(4));
//			orgSave=	organizationRepository.save(org);
//			if(orgSave!=null) {
//				String data = EmailTemplate.getMailBodyTemplate(orgSave.getEmailOtp());
//					
//					MailSenderByThread mailSenderByThread = new MailSenderByThread();
//					mailSenderByThread.toMailId =org.getOrganizationEmail();
//					mailSenderByThread.msg =	data;
//					mailSenderByThread.subject="Social Suite OTP " ;
//					mailSenderByThread.start();	
//				}
//					
//		} catch (Exception e) {
//			// TODO: handle exceptione
//			e.printStackTrace();
//			orgSave=null;
//		}
//		return orgSave;
//	}

	@Override
	public CostumPayload resendOtp(Organization organization) {

		CostumPayload cosPayload = new CostumPayload();

		Organization orgSave = new Organization();
		try {
			Organization org = organizationRepository.findByEmailId(organization.getOrganizationEmail());
			if (org!=null) {
				org.setEmailOtp(RandomStringGenerator.getRandomNumberString(4));
				orgSave = organizationRepository.save(org);
				if (orgSave != null) {
					String data = EmailTemplate.getMailBodyTemplate(orgSave.getEmailOtp());

					MailSenderByThread mailSenderByThread = new MailSenderByThread();
					mailSenderByThread.toMailId = org.getOrganizationEmail();
					mailSenderByThread.msg = data;
					mailSenderByThread.subject = "Social Suite OTP ";
					mailSenderByThread.start();
					cosPayload.setOrganization(orgSave);
				}
			}
			Influencer inflSave = new Influencer();
			try {
				Influencer infdetail = influencerRepository.findByEmail(organization.getOrganizationEmail());
				infdetail.setEmailOtp(RandomStringGenerator.getRandomNumberString(4));
				inflSave = influencerRepository.save(infdetail);
				if (inflSave != null) {
					String data = EmailTemplate.getMailBodyTemplate(inflSave.getEmailOtp());

					MailSenderByThread mailSenderByThread = new MailSenderByThread();
					mailSenderByThread.toMailId = inflSave.getEmail();
					mailSenderByThread.msg = data;
					mailSenderByThread.subject = "Social Suite OTP ";
					mailSenderByThread.start();
					cosPayload.setInfluencer(inflSave);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cosPayload;
	}

	@Override
	public boolean forwardLink(Organization organization) {

		Organization org = organizationRepository.findByEmailId(organization.getOrganizationEmail());

		if (org != null) {
			String data = EmailTemplate.getTemplate(org.getOrganizationName(), org.getOrganizationEmail());

			MailSenderByThread mailSenderByThread = new MailSenderByThread();
			mailSenderByThread.toMailId = org.getOrganizationEmail();
			mailSenderByThread.msg = data;
			mailSenderByThread.subject = "Email Link ";
			mailSenderByThread.start();
			return true;

		} else {

		}

		return false;
	}

	@Override
	public boolean resetPassword(Organization organization) {
		try {
			if (organization != null) {
				Organization orgdetail = organizationRepository.findByEmailId(organization.getOrganizationEmail());
				if (orgdetail != null) {
					orgdetail.setOrganizationpwd(organization.getOrganizationpwd());
					organizationRepository.save(orgdetail);
					return true;

				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
