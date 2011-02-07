package org.bimserver.mail;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.bimserver.settings.ServerSettings;

public class MailSystem {
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

	public static boolean isValidEmailAddress(String aEmailAddress) {
		if (aEmailAddress == null) {
			return false;
		}
		try {
			new InternetAddress(aEmailAddress);
			if (!hasNameAndDomain(aEmailAddress)) {
				return false;
			}
		} catch (AddressException ex) {
			return false;
		}
		return true;
	}

	private static boolean hasNameAndDomain(String aEmailAddress) {
		String[] tokens = aEmailAddress.split("@");
		return tokens.length == 2 && !tokens[0].isEmpty() && !tokens[1].isEmpty();
	}
}