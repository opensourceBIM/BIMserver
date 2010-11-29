package org.bimserver.mail;

import java.util.Properties;

import javax.mail.Session;

import org.bimserver.ServerSettings;

public class MailSystem {
	public static Session createMailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());
		props.put("mail.smtp.localhost", "bimserver.org");
	
		Session mailSession = Session.getDefaultInstance(props);
		return mailSession;
	}
}
