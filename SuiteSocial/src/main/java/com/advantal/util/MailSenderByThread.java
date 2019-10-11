package com.advantal.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailSenderByThread extends Thread{
	public  String toMailId;
	public  String subject;
	public  String msg;
	
	@Override
	public void run(){  
		try {
			Message message = new MimeMessage(SendMailProperty.mailProperty());
			message.setFrom(new InternetAddress(ConstantAction.FROM_EMAIL_ID));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMailId));
			message.setSubject(subject);
			message.setContent(msg, ConstantAction.TEXT_HTML);
	
			Transport.send(message);

		} catch (MessagingException messagingException) {
System.out.println("MailSenderByThread.run() "+messagingException);
			messagingException.printStackTrace();
			
		}
		
	}

}
