package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.CostumPayload;
import com.advantal.model.Influencer;
import com.advantal.model.OrgPayload;
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

			
			System.out.println(organization.getOrganizationpwd());
			
			String str = AESCipher.aesDecryptString(organization.getOrganizationpwd(), AESCipher.CUSTOMER_KEY);
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
	public List<OrgPayload> getorganizationList() {
		List<OrgPayload> orgList = new ArrayList<>();
		List<Organization> organizationList = organizationRepository.findAll();
		for (Organization organizationList1 : organizationList) {
			OrgPayload orgPayload=new OrgPayload();
			orgPayload.setOrganizationName(organizationList1.getOrganizationName());
			orgPayload.setOrganizationKey(organizationList1.getOrganizationKey());
			orgPayload.setOrganizationEmail(organizationList1.getOrganizationEmail());
			orgPayload.setIsVerified(organizationList1.getIsVerified());
			orgPayload.setEmailOtp(organizationList1.getEmailOtp());
			orgPayload.setSurveyCompleted(organizationList1.isSurveyCompleted());
			orgList.add(orgPayload);
		}
		return orgList;
	}
}
