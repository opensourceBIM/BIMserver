package org.bimserver.mail;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.googlecode.cqengine.query.simple.In;
import org.bimserver.BimServer;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.SmtpProtocol;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	public void send() throws MessagingException, UserException {
		ServerSettings serverSettings = bimServer.getServerSettingsCache().getServerSettings();

		Properties props = new Properties();
		props.setProperty("mail.smtp.connectiontimeout", Integer.toString(10000));
		props.setProperty("mail.smtp.timeout", Integer.toString(10000));
		props.setProperty("mail.smtp.writetimeout", Integer.toString(10000));
		props.setProperty("mail.smtp.host", serverSettings.getSmtpServer());
		props.setProperty("mail.smtp.port", Integer.toString(serverSettings.getSmtpPort()));
		props.setProperty("mail.smtp.auth", Boolean.toString(serverSettings.getSmtpUsername() != null));

		if (serverSettings.getSmtpProtocol() == SmtpProtocol.SMTPS) {
			props.setProperty("mail.smtp.ssl.enable", "true");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");
		}
		if (serverSettings.getSmtpProtocol() == SmtpProtocol.STARTTLS) {
			props.setProperty("mail.smtp.starttls.enable","true");
		}

		Session session = null;
		
		if (serverSettings.getSmtpUsername() != null) {
			session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(serverSettings.getSmtpUsername(), serverSettings.getSmtpPassword());
				}
			});
		} else {
			session = Session.getInstance(props);
		}
		
		try {
			Message message = new MimeMessage(session);
			message.setSubject(subject);
			message.setRecipients(to, addressTo);
			message.setContent(body, contentType);
			message.setFrom(from);
			
			Transport.send(message, addressTo);
		} catch (MessagingException e) {
			LOGGER.error("Error sending email " + body + " " + e.getMessage());
			throw new UserException("Error sending email " + e.getMessage());
		}
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