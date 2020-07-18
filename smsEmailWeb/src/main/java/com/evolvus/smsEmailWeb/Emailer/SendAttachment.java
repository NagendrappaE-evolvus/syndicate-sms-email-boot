package com.evolvus.smsEmailWeb.Emailer;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;

import com.evolvus.smsEmailWeb.ApiService.ApiServiceImpl;
import com.evolvus.smsEmailWeb.bean.MailAndSmsApiBean;

public class SendAttachment {

	private static final Logger logger = Logger.getLogger(ApiServiceImpl.class);

	public String SMTP_HOST;
	public String SMTP_USER;
	public String SMTP_PWD;

	public static void test(String[] args) {
		SendAttachment demo = new SendAttachment();
	}

	public Object[] sendEmail(String recipients[], String subject, byte[] message, String from,
			byte[] statementTemplate, MailAndSmsApiBean mailAndSmsApiBean) throws MessagingException {
		logger.info("sendEmail starts:::::::" + subject + "," + from + "," + ","
				+ mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailFrom());

		boolean status = false;
		Object[] object = new Object[2];
		String messageId = "";
		Session session;
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailHost());
		properties.put("mail.smtp.port", mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailPort());
		properties.put("mail.smtp.from", mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailFrom());
		properties.put("mail.smtp.auth", "true");
		logger.info("inside sendEmail:::::::" + properties.getProperty("mail.smtp.ssl.trust"));
		logger.info("inside sendEmail:::::::" + properties.getProperty("mail.smtp.host"));
		logger.info("inside sendEmail:::::::" + properties.getProperty("mail.smtp.port"));
		logger.info("inside sendEmail:::::::" + properties.getProperty("mail.smtp.from"));
		logger.info("inside sendEmail:::::::" + properties.getProperty("mail.smtp.auth"));
		Authenticator authenticator = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SMTP_USER, SMTP_PWD);
			}
		};
		session = Session.getInstance(properties, authenticator);

		try {
			MimeMessage messages = new MimeMessage(session);
			messages.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
			}
			messages.setRecipients(Message.RecipientType.TO, addressTo);

			messages.setSubject(subject);
			messages.setSentDate(new Date());
			MimeBodyPart messagePart = new MimeBodyPart();

			String contentType = "text/html";

			MimeBodyPart mimePart = new MimeBodyPart();
			mimePart.setDataHandler(new DataHandler(new ByteArrayDataSource(statementTemplate, contentType)));
			mimePart.setDisposition(Part.INLINE);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(mimePart);

			messages.setContent(multipart);
			logger.info("inside send:::::::");

			Transport.send(messages);
			logger.info("end transport send:::::::" + messages.getMessageID());
			messageId = messages.getMessageID();

			status = true;
		} catch (MessagingException e) {

			e.printStackTrace();
			status = false;
			logger.error("inside error mail trigger fail:::::::" + status);
		}
		object[0] = status;
		object[1] = messageId;

		logger.info("end send email method::::::" + object[0]);
		logger.info("end send email method::::::" + object[1]);
		return object;
	}

	class TransportListenerImpl implements TransportListener {

		public void messageDelivered(TransportEvent arg0) {
			System.out.println("message delivered : " + arg0.getValidUnsentAddresses());
		}

		public void messageNotDelivered(TransportEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("message not delivered : " + arg0.getInvalidAddresses());
		}

		public void messagePartiallyDelivered(TransportEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("message Partially Delivered : " + arg0.getInvalidAddresses());

		}

	}

}
