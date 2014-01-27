package org.bimserver.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.SmtpProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.smtp.SMTPTransport;

public class EmailMessage {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailMessage.class);
	private BimServer bimServer;
	private String subject;
	private InternetAddress from;
	private RecipientType to;
	private InternetAddress[] addressTo;
	private String body;
	private String contentType;

	public EmailMessage(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public void send() throws MessagingException {
		Properties props = new Properties();
		ServerSettings serverSettings = bimServer.getServerSettingsCache().getServerSettings();
		props.put("mail.smtp.localhost", "bimserver.org");
		Session mailSession = Session.getDefaultInstance(props);
		
		Transport transport = null;
		
		if (serverSettings.getSmtpProtocol() == SmtpProtocol.SMTP) {
			transport = new SMTPTransport(mailSession, new URLName(serverSettings.getSmtpServer()));
			transport.connect(serverSettings.getSmtpServer(), null, null);
		} else if (serverSettings.getSmtpProtocol() == SmtpProtocol.SMTPS) {
			transport = new SMTPSSLTransport(mailSession, new URLName(serverSettings.getSmtpServer()));
			String username = serverSettings.getSmtpUsername();
			String password = serverSettings.getSmtpPassword();
			try {
				transport.connect(serverSettings.getSmtpServer(), username, password);
			} catch (MessagingException e) {
				LOGGER.error("", e);
			}
		}
		
		Message message = new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setRecipients(to, addressTo);
		message.setContent(body, contentType);
		message.setFrom(from);
		
		transport.sendMessage(message, addressTo);
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String body, String contentType) {
		this.body = body;
		this.contentType = contentType;
	}

	public void setRecipients(RecipientType to, InternetAddress[] addressTo) {
		this.to = to;
		this.addressTo = addressTo;
	}

	public void setFrom(InternetAddress from) {
		this.from = from;
	}
}