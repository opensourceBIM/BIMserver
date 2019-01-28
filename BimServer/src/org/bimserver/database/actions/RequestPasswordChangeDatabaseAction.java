package org.bimserver.database.actions;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.mail.EmailMessage;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.templating.TemplateIdentifier;
import org.bimserver.utils.GeneratorUtils;
import org.bimserver.utils.Hashers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestPasswordChangeDatabaseAction extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestPasswordChangeDatabaseAction.class);
	private final BimServer bimServer;
	private final String username;
	private String resetUrl;
	private Boolean includeSiteAddress;

	public RequestPasswordChangeDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String username, String resetUrl, Boolean includeSiteAddress) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.username = username;
		this.resetUrl = resetUrl;
		this.includeSiteAddress = includeSiteAddress;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		final User user = getUserByUserName(username);
		if (user == null) {
			throw new UserException("User with username \"" + username + "\" not found");
		}
		final String token = GeneratorUtils.generateToken();
		user.setValidationToken(Hashers.getSha256Hash(token));
		user.setValidationTokenCreated(new Date());
		getDatabaseSession().store(user);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				if (MailSystem.isValidEmailAddress(user.getUsername())) {
					EmailMessage message = bimServer.getMailSystem().createMessage();
					
					String body = null;
					String subject = null;
					try {
						InternetAddress addressFrom = new InternetAddress(bimServer.getServerSettingsCache().getServerSettings().getEmailSenderAddress());
						message.setFrom(addressFrom);
						
						InternetAddress[] addressTo = new InternetAddress[1];
						addressTo[0] = new InternetAddress(user.getUsername());
						message.setRecipients(Message.RecipientType.TO, addressTo);
						
						Map<String, Object> context = new HashMap<String, Object>();
						context.put("name", user.getName());
						context.put("username", user.getUsername());
						if (includeSiteAddress) {
							context.put("siteaddress", bimServer.getServerSettingsCache().getServerSettings().getSiteAddress());
						}
						context.put("validationlink", resetUrl + "&username=" + user.getUsername() + "&uoid=" + user.getOid() + "&validationtoken=" + token + (includeSiteAddress ? ("&address=" + bimServer.getServerSettingsCache().getServerSettings().getSiteAddress()) : ""));
						body = bimServer.getTemplateEngine().process(context, TemplateIdentifier.PASSWORD_RESET_EMAIL_BODY);
						subject = bimServer.getTemplateEngine().process(context, TemplateIdentifier.PASSWORD_RESET_EMAIL_SUBJECT);
						message.setContent(body, "text/html");
						message.setSubject(subject.trim());
						message.send();
					} catch (Exception e) {
						LOGGER.error(body);
						throw new UserException(e.getMessage());
					}
				}
			}
		});
		return null;
	}
}