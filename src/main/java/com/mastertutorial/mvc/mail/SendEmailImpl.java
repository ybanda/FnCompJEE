/**
 * 
 */
package com.mastertutorial.mvc.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.mastertutorial.mvc.dao.SendEmail;

/**
 * @author Yashwanth
 *
 */
public class SendEmailImpl implements SendEmail {

	//@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Override
	public void sendEmailFromSpring() {

		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				public void prepare(MimeMessage mimeMessage) throws Exception {
				
					mimeMessage.setRecipient(Message.RecipientType.TO,
							new InternetAddress("bandayashwanth@gmail.com"));
					mimeMessage.setText("Dear developer, This is a Test Email from Spring Java Mail Sender Impl and MimeMessagePreparator.Thanks,bykrcode");
				}
			};
			this.javaMailSender.send(preparator);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * @return the javaMailSender
	 */
	public JavaMailSenderImpl getJavaMailSender() {
		return javaMailSender;
	}

	/**
	 * @param javaMailSender the javaMailSender to set
	 */
	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}




}
