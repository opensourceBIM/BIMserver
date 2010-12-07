package org.bimserver.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.ServerInitializer;
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
	
	public void sendClashDetectionEmail(long poid, String senderName, String senderAddress, SClashDetectionSettings sClashDetectionSettings, String... addressesTo) {
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		Session mailSession = createMailSession();
	
		MimeMessage msg = new MimeMessage(mailSession);
	
		try {
			InternetAddress addressFrom = new InternetAddress(senderAddress);
			addressFrom.setPersonal(senderName);
			msg.setFrom(addressFrom);
			
			Set<InternetAddress> addresses = new HashSet<InternetAddress>();
			for (String addressTo : addressesTo) {
				if (addressTo.contains("@") && addressTo.contains(".")) {
					addresses.add(new InternetAddress(addressTo));
				}
			}
			Address addressesArray[] = new Address[addresses.size()];
			addresses.toArray(addressesArray);
			msg.setRecipients(Message.RecipientType.TO, addressesArray);
			
			msg.setSubject("BIMserver Clash Detection");
			
			StringBuilder ignoreString = new StringBuilder();
			for (String ignore : sClashDetectionSettings.getIgnoredClasses()) {
				ignoreString.append(ignore + ";");
			}
			
			StringBuilder revisionsString = new StringBuilder();
			for (Long roid : sClashDetectionSettings.getRevisions()) {
				revisionsString.append(roid + ";");
			}

			if (!addresses.isEmpty()) {
				msg.setContent("<a href=\"" + ServerSettings.getSettings().getSiteAddress() + ServerInitializer.getServletContext().getContextPath() + "/project.jsp?tab=cd&poid=" + poid + "&margin=" + sClashDetectionSettings.getMargin() + "&revisions=" + revisionsString + "&ignored=" + ignoreString + "\">Click here for clash detection results</a>", "text/html");
			}
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