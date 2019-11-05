package com.advantal.util;

public class EmailTemplate {
	
	
	
	public static String getMailBodyTemplate(String emailOtp) {
		// TODO Auto-generated method stub
		
		
		String email_template = "Thank you for registration."
				              + "<br><br> Verification code for your SuiteSocial Account is:"+emailOtp;
				
		return email_template;
	}

	
	public static String getTemplate(String organizationName, String organizationEmail) {
		String email_template = "<b>Dear " +organizationName+"," +"</b>"+"<br>Please click on the following link to reset your password:<br> <a href='https://shieldcrypt.com:7384/SuiteSocial/#/reset_password?email="+organizationEmail+"&ts="+System.currentTimeMillis()+"&ut=1'>Click Here </a>";
		System.out.println("<b>Dear " +organizationName+"," +"</b>"+"<br>Please click on the following link to reset your password:<br> <a href='https://shieldcrypt.com:7384/SuiteSocial/reset_password?email="+organizationEmail+"&ts="+System.currentTimeMillis()+"&ut=1'>Click Here </a>");
//		String email_template = "<b>Dear " +organizationName+"," +"</b>"+"<br>Please click on the following link to reset your password:<br> <a href='localhost:8080/reset_password?email="+organizationEmail+"'>Click Here </a>";
		
	
return email_template;
	}
	
	public static String getMailBodyTemplate1(String email) {
		// TODO Auto-generated method stub
		
		
		String email_template = "Thank you for sending message."
				              + "<br><br> Verification code for your SuiteSocial Account is:"+email;
				
		return email_template;
	}

	public static String getMailBodyTemplate2(String email) {
		// TODO Auto-generated method stub
		
		
		String email_template = "Thank you for Otp."
				              + "<br><br> Verification code for your SuiteSocial Account is:"+email;
				
		return email_template;
	}


	public static String getTemplate1(String influencerEmail) {
		String email_template = "<br>Please click on the following link to reset your password:<br> <a href='https://shieldcrypt.com:7384/SuiteSocial/#/reset_password?email="+influencerEmail+"&ts="+System.currentTimeMillis()+"&ut=2'>Click Here </a>";
		System.out.println("<br>Please click on the following link to reset your password:<br> <a href='https://shieldcrypt.com:7384/SuiteSocial/reset_password?email="+influencerEmail+"&ts="+System.currentTimeMillis()+"&ut=2'>Click Here </a>");
		return email_template;
	}


}
