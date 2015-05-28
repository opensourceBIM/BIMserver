package org.bimserver.mail;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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

import com.sun.mail.handlers.message_rfc822;
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
		String smtpProps = serverSettings.getSmtpProtocol() == SmtpProtocol.SMTPS ? "mail.smtps.port" : "mail.smtp.port";
		props.put(smtpProps, serverSettings.getSmtpPort());
		
		Session mailSession = Session.getDefaultInstance(props);
		
		Transport transport = null;
		
		try {
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
		} catch (MessagingException e) {
			LOGGER.error("Error sending email " + body);
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