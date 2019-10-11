package com.advantal.util;

public class EmailTemplate {
	
	
	
	public static String getMailBodyTemplate(String emailOtp) {
		// TODO Auto-generated method stub
		
		
		String email_template = "Thank you for registration."
				              + "<br><br> Verification code for your SuiteSocial Account is:"+emailOtp;
				
		return email_template;
	}

	
	public static String getTemplate(String organizationName, String organizationEmail) {
		String email_template = "<b>Dear " +organizationName+"," +"</b>"+"<br>Please click on the following link to reset your password:<br> <a href='https://shieldcrypt.com:7384/SuiteSocial/reset_password?email="+organizationEmail+"/"+System.currentTimeMillis()+"'>Click Here </a>";
//		String email_template = "<b>Dear " +organizationName+"," +"</b>"+"<br>Please click on the following link to reset your password:<br> <a href='localhost:8080/reset_password?email="+organizationEmail+"'>Click Here </a>";
		
	
return email_template;
	}


}
