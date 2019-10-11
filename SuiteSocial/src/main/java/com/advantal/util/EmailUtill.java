package com.advantal.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtill {

	public static String sendEmail(String emailId, String otp) {

		try {
			String msg = IConstant.EMAIL_VERIFICATION_MESSAGE + otp;
			Message message = new MimeMessage(SendMailProperty.mailProperty());
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
			message.setSubject(IConstant.EMAIL_SUBJECT_MESSAGE);
			message.setContent(msg, ConstantAction.TEXT_HTML);
			Transport.send(message);
		} catch (Exception e) {
		}
		return otp;

	}
	
	public static void main(String args[]) throws AddressException, MessagingException {
		
		String msg = "otp testing";
		String emailId="shivam.ec08@gmail.com";
		Message message = new MimeMessage(SendMailProperty.mailProperty());
		message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
		message.setSubject(IConstant.EMAIL_SUBJECT_MESSAGE);
		message.setContent(msg, ConstantAction.TEXT_HTML);
		Transport.send(message);
	}
	
	public static void sendEmailPassowrdReset(String emailId, String msg) {

		try {
			String msg1=  msg;
			Message message = new MimeMessage(SendMailProperty.mailProperty());
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
			message.setSubject(IConstant.FORGOT_EMAIL_SUBJECT_MESSAGE);
			message.setContent(msg1, ConstantAction.TEXT_HTML);
			Transport.send(message);
		} catch (Exception e) {
		}

	}

}
