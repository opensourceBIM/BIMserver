package org.bimserver;

import java.util.Properties;

import javax.mail.Session;

public class MailSystem {
	public static Session createMailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());
		props.put("mail.smtp.localhost", "bimserver.org");
	
		Session mailSession = Session.getDefaultInstance(props);
		return mailSession;
	}
}
