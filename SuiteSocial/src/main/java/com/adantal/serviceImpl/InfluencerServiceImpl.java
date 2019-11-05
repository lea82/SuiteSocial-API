package com.adantal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advantal.model.InflPayload;
import com.advantal.model.Influencer;
import com.advantal.model.OrgPayload;
import com.advantal.model.Organization;
import com.advantal.repository.InfluencerRepository;
import com.advantal.service.InfluencerService;
import com.advantal.util.AESCipher;
import com.advantal.util.EmailTemplate;
import com.advantal.util.IConstant;
import com.advantal.util.MailSenderByThread;
import com.advantal.util.RandomStringGenerator;

@Service
public class InfluencerServiceImpl implements InfluencerService{

	@Autowired
	private InfluencerRepository influencerRepository;


//	@Override
//	public boolean createUser(Influencer influencer) {
//		
//		Influencer  influencerSave = new Influencer();
//		try {
//			
//			
//		   Influencer influencerold=influencerRepository.findByEmailId(influencer.getEmail());
//		
//		   if(influencerold ==null) {
//			
//            String encrypt=AESCipher.aesEncryptString(influencer.getPassword(), AESCipher.CUSTOMER_KEY);
//			
//
//			System.out.println(encrypt);
//			String decrypt=AESCipher.aesDecryptString(encrypt, AESCipher.CUSTOMER_KEY);
//			
//			System.out.println(decrypt);
//			//String decrypt=AESCipher.aesDecryptString(influencer.getPassword(), AESCipher.CUSTOMER_KEY);
//			influencer.setPassword(decrypt);
//			
//			String sha256hex = DigestUtils.sha256Hex(decrypt);
//			influencer.setPassword(sha256hex);
//			influencer.setResponse(IConstant.ZERO);
//		
//			influencerSave=	influencerRepository.save(influencer);
//			return influencerSave;
//		}
//		
//		else {
//			
//			influencerSave.setResponse(IConstant.ONE);
//			
//			return influencerSave;
//			
//		}
//		
//		
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			influencerSave=null;
//            return influencerSave;
//		}
//	}
	
	@Override
	public boolean createUser(Influencer influencer) {
	try {
System.err.println(influencer.getPassword());
        
			/*
			 * String rncPwd = AESCipher.aesEncryptString(influencer.getPassword(),
			 * AESCipher.CUSTOMER_KEY); System.out.println("Influencer.createUser()" +
			 * rncPwd);
			 */	// String str =AESCipher.aesDecryptString(organization.getOrganizationpwd(),
		// AESCipher.CUSTOMER_KEY);
		String str = AESCipher.aesDecryptString(influencer.getPassword(), AESCipher.CUSTOMER_KEY);
		System.out.println(str);
		String sha256hex = DigestUtils.sha256Hex(str);
		influencer.setPassword(sha256hex);

		String emailOtp=RandomStringGenerator.getRandomNumberString(4);
		influencer.setEmailOtp(emailOtp);
		
		Influencer infl=	influencerRepository.save(influencer);
		
		if(infl!=null) {
		String data = EmailTemplate.getMailBodyTemplate(infl.getEmailOtp());
			
			MailSenderByThread mailSenderByThread = new MailSenderByThread();
			mailSenderByThread.toMailId =infl.getEmail();
			mailSenderByThread.msg =	data;
			mailSenderByThread.subject="SuiteSocial Registration";
			mailSenderByThread.start();

			
		}
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

//	@Override
//	public boolean verifyOtp(Influencer influencer) {
//		try {
//			if (influencer!=null && influencer.getEmailOtp()!=null && !influencer.getEmailOtp().equals("")) {
//				Influencer detail=influencerRepository.findByEmailId(influencer.getEmail());
//				if (detail !=null && detail.getEmailOtp().equals(influencer.getEmailOtp())) {
//					
//					detail.setIsVerified(IConstant.ONE);
//					influencerRepository.save(detail);
//					return true;
//				}
//				
//				else {
//					
//					
//					return false;
//					
//				}
//			}else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
//
//	@Override
//	public Influencer resendOtp(Influencer influencer) {
//		// TODO Auto-generated method stub
//		Influencer inflSave = new Influencer();
//		
//		try {
//			Influencer  infl=influencerRepository.findByEmailId(influencer.getEmail());
//			infl.setEmailOtp(RandomStringGenerator.getRandomNumberString(4));
//			
//			inflSave=	influencerRepository.save(infl);
//			if(inflSave!=null) {
//				String data = EmailTemplate.getMailBodyTemplate(inflSave.getEmailOtp());
//					
//					MailSenderByThread mailSenderByThread = new MailSenderByThread();
//					mailSenderByThread.toMailId =infl.getEmail();
//					mailSenderByThread.msg =	data;
//					mailSenderByThread.subject="Social Suite OTP " ;
//					mailSenderByThread.start();
//
//					
//				}
//		} catch (Exception e) {
//			// TODO: handle exceptione
//			e.printStackTrace();
//			inflSave=null;
//		}
//		return inflSave;
//	}

	
	@Override
	public boolean socialcreateUser(Influencer influencer) {
		try {


			String rncPwd=	AESCipher.aesEncryptString(influencer.getPassword(),AESCipher.CUSTOMER_KEY );
			System.out.println("InfluencerServiceImpl.socialcreateUser()"+ rncPwd);
			String str =AESCipher.aesDecryptString(rncPwd, AESCipher.CUSTOMER_KEY);
			System.out.println(str);
			String sha256hex = DigestUtils.sha256Hex(str);
			influencer.setPassword(sha256hex);
			influencerRepository.save(influencer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Influencer verifySocialUser(Influencer influencer) {
		try {
			if (influencer!=null && influencer.getSocialLoginType()!=null) {
				//influencer=influencerRepository.findBySocialIdAndSocialType(influencer.getSocialLoginId(), influencer.getSocialLoginType());
			return influencer;
		    }else {
		    	return influencer;
			}
			
		 } catch (Exception e) {
			e.printStackTrace();
			return influencer;
		}
		
	}

	@Override
	public List<InflPayload> getinfluencerList() {
		List<InflPayload> inflList = new ArrayList<>();
		List<Influencer> influencerList = influencerRepository.findAll();
		for (Influencer influencerList1 : influencerList) {
			InflPayload inflPayload=new InflPayload();
			inflPayload.setEmail(influencerList1.getEmail());
			inflPayload.setEmailOtp(influencerList1.getEmailOtp());
			inflPayload.setIsVerified(influencerList1.getIsVerified());
			inflPayload.setSurveyCompleted(influencerList1.isSurveyCompleted());
			
			inflList.add(inflPayload);
		}
		return inflList;
	}	
	
}
