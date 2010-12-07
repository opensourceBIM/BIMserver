package org.bimserver.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.ServerSettings;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSystem {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailSystem.class);
	private static final MailSystem INSTANCE = new MailSystem();
	
	private MailSystem() {
	}
	
	public static MailSystem getInstance() {
		return INSTANCE;
	}
	
	public Session createMailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());
		props.put("mail.smtp.localhost", "bimserver.org");
	
		Session mailSession = Session.getDefaultInstance(props);
		return mailSession;
	}
	
	public void sendClashDetectionEmail(String senderName, String senderAddress, String url, SClashDetectionSettings sClashDetectionSettings, String... addressesTo) {
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		Session mailSession = createMailSession();
	
		MimeMessage msg = new MimeMessage(mailSession);
	
		InternetAddress addressFrom;
		try {
			addressFrom = new InternetAddress(senderAddress);
			addressFrom.setPersonal(senderName);
			msg.setFrom(addressFrom);
			
			InternetAddress[] addressesToArray = new InternetAddress[addressesTo.length];
			int i=0;
			for (String addressTo : addressesTo) {
				addressesToArray[i++] = new InternetAddress(addressTo);
			}
			msg.setRecipients(Message.RecipientType.TO, addressesToArray);
			
			msg.setSubject("BIMserver Clash Detection");
//		String url = WebUtils.getWebServer(request.getRequestURL().toString());
			
			StringBuilder poidsString = new StringBuilder();
			for (Long poid : sClashDetectionSettings.getProjects()) {
				poidsString.append(poid + ";");
			}
			
			StringBuilder ignoreString = new StringBuilder();
			for (String ignore : sClashDetectionSettings.getIgnoredClasses()) {
				ignoreString.append(ignore + ";");
			}
			
			StringBuilder revisionsString = new StringBuilder();
			for (Long roid : sClashDetectionSettings.getRevisions()) {
				revisionsString.append(roid + ";");
			}
			
			msg.setContent("<a href=\"http://" + url + "project.jsp?tab=cd&poids=" + poidsString + "&margin=" + sClashDetectionSettings.getMargin() + "&revisions=" + revisionsString + "&ignore=" + ignoreString + "\">Click here for clash detection results</a>", "text/html");
			Transport.send(msg);
		} catch (AddressException e) {
			LOGGER.error("", e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("", e);
		} catch (MessagingException e) {
			LOGGER.error("", e);
		}
	}
}
