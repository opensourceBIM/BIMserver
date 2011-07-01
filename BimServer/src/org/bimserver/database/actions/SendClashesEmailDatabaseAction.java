package org.bimserver.database.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.UserException;
import org.bimserver.templating.TemplateIdentifier;

public class SendClashesEmailDatabaseAction extends BimDatabaseAction<Void> {

	private final SClashDetectionSettings sClashDetectionSettings;
	private final long actingUoid;
	private final long poid;
	private final Set<String> addressesTo;
	private final BimServer bimServer;

	public SendClashesEmailDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long poid, SClashDetectionSettings sClashDetectionSettings, Set<String> addressesTo) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.actingUoid = actingUoid;
		this.poid = poid;
		this.sClashDetectionSettings = sClashDetectionSettings;
		this.addressesTo = addressesTo;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		try {
			User user = getUserByUoid(actingUoid);
			String senderAddress = bimServer.getSettingsManager().getSettings().getEmailSenderAddress();
			Session mailSession = bimServer.getMailSystem().createMailSession();

			MimeMessage msg = new MimeMessage(mailSession);
			InternetAddress addressFrom = new InternetAddress(senderAddress);
			msg.setFrom(addressFrom);

			Set<InternetAddress> addresses = new HashSet<InternetAddress>();
			for (String addressTo : addressesTo) {
				if (MailSystem.isValidEmailAddress(addressTo)) {
					addresses.add(new InternetAddress(addressTo));
				}
			}
			Address addressesArray[] = new Address[addresses.size()];
			addresses.toArray(addressesArray);
			msg.setRecipients(Message.RecipientType.TO, addressesArray);

			StringBuilder ignoreString = new StringBuilder();
			for (String ignore : sClashDetectionSettings.getIgnoredClasses()) {
				ignoreString.append(ignore + ";");
			}

			StringBuilder revisionsString = new StringBuilder();
			for (Long roid : sClashDetectionSettings.getRevisions()) {
				revisionsString.append(roid + ";");
			}

			String link = "<a href=\"" + bimServer.getSettingsManager().getSettings().getSiteAddress() + bimServer.getSettingsManager().getSettings().getSiteAddress() + "/project.jsp?tab=cd&poid="
					+ poid + "&margin=" + sClashDetectionSettings.getMargin() + "&revisions=" + revisionsString + "&ignored=" + ignoreString
					+ "\">Click here for clash detection results</a>";
			
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("name", user.getName());
			context.put("username", user.getUsername());
			context.put("siteaddress", bimServer.getSettingsManager().getSettings().getSiteAddress());
			context.put("url", link);
			
			String body = bimServer.getTemplateEngine().process(context, TemplateIdentifier.CLASH_DETECTION_EMAIL_BODY);
			String subject = bimServer.getTemplateEngine().process(context, TemplateIdentifier.CLASH_DETECTION_EMAIL_SUBJECT);

			msg.setSubject(subject);
			msg.setContent(body, "text/html");

			if (!addresses.isEmpty()) {
				Transport.send(msg);
			}
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
}