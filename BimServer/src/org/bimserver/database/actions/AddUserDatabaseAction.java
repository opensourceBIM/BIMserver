package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewUserAdded;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.templating.TemplateIdentifier;
import org.bimserver.utils.GeneratorUtils;
import org.bimserver.utils.Hashers;
import org.bimserver.webservices.Authorization;
import org.bimserver.webservices.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUserDatabaseAction extends BimDatabaseAction<User> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddUserDatabaseAction.class);
	private final String name;
	private final UserType userType;
	private final String username;
	private final boolean selfRegistration;
	private final String password;
	private boolean createSystemUser = false;
	private final BimServer bimServer;
	private Authorization authorization;

	public AddUserDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String username, String name, UserType userType,
			Authorization authorization, boolean selfRegistration) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.name = name;
		this.username = username;
		this.userType = userType;
		this.authorization = authorization;
		this.selfRegistration = selfRegistration;
		this.password = null;
	}

	public AddUserDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String username, String password, String name, UserType userType,
			Authorization authorization, boolean selfRegistration) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.password = password;
		this.name = name;
		this.username = username;
		this.userType = userType;
		this.authorization = authorization;
		this.selfRegistration = selfRegistration;
	}

	public User execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		String trimmedUserName = username.trim();
		String trimmedName = name.trim();
		if (userType == UserType.SYSTEM && !createSystemUser) {
			throw new UserException("Cannot create system users");
		}
		if (selfRegistration && userType == UserType.ADMIN) {
			throw new UserException("Cannot create admin user with self registration");
		}
		if (trimmedUserName.equals("")) {
			throw new UserException("Invalid username");
		}
		if (!MailSystem.isValidEmailAddress(trimmedUserName) && !(trimmedUserName.equals("test") || trimmedUserName.equals("system"))) {
			throw new UserException("Username must be a valid e-mail address");
		}
		if (trimmedName.equals("")) {
			throw new UserException("Invalid name");
		}
		if (getUserByUserName(trimmedUserName) != null) {
			throw new UserException("A user with the username " + trimmedUserName + " already exists");
		}
		User actingUser = null;
		if (authorization != null && !(authorization instanceof SystemAuthorization)) {
			actingUser = getUserByUoid(authorization.getUoid());
			if (actingUser == null || actingUser.getUserType() != UserType.SYSTEM) {
				if (authorization.getUoid() != -1 && actingUser.getUserType() != UserType.ADMIN) {
					throw new UserException("Only admin users can create other users");
				}
			}
		}
		final User user = StoreFactory.eINSTANCE.createUser();
		if (password != null) {
			user.setPassword(Hashers.getSha256Hash(password));
		}
		user.setToken(GeneratorUtils.generateToken());
		user.setName(trimmedName);
		user.setUsername(trimmedUserName);
		user.setCreatedOn(new Date());
		user.setCreatedBy(actingUser);
		user.setUserType(userType);
		user.setLastSeen(null);
		final String token = GeneratorUtils.generateToken();
		user.setValidationToken(Hashers.getSha256Hash(token));
		user.setValidationTokenCreated(new Date());
		
		if (!createSystemUser) {
			final NewUserAdded newUserAdded = LogFactory.eINSTANCE.createNewUserAdded();
			newUserAdded.setUser(user);
			newUserAdded.setExecutor(actingUser);
			newUserAdded.setDate(new Date());
			newUserAdded.setAccessMethod(getAccessMethod());
			getDatabaseSession().store(newUserAdded);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newUserAdded));
				}
			});
		}
		
		bimServer.updateUserSettings(getDatabaseSession(), user);
		
		getDatabaseSession().store(user);
		final ServerSettings serverSettings = getServerSettings();
		if (serverSettings != null && serverSettings.isSendConfirmationEmailAfterRegistration()) {
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					try {
						if (MailSystem.isValidEmailAddress(user.getUsername())) {
							Session mailSession = bimServer.getMailSystem().createMailSession();

							Message msg = new MimeMessage(mailSession);
							String emailSenderAddress = serverSettings.getEmailSenderAddress();
							InternetAddress addressFrom = new InternetAddress(emailSenderAddress);
							msg.setFrom(addressFrom);

							InternetAddress[] addressTo = new InternetAddress[1];
							addressTo[0] = new InternetAddress(user.getUsername());
							msg.setRecipients(Message.RecipientType.TO, addressTo);

							Map<String, Object> context = new HashMap<String, Object>();
							context.put("name", user.getName());
							context.put("username", user.getUsername());
							context.put("siteaddress", serverSettings.getSiteAddress());
							String validationLink = serverSettings.getSiteAddress() + "/validate.jsp?username=" + user.getUsername() + "&uoid=" + user.getOid() + "&token="
									+ token;
							context.put("validationlink", validationLink);
							String body = null;
							String subject = null;
							if (selfRegistration) {
								body = bimServer.getTemplateEngine().process(context, TemplateIdentifier.SELF_REGISTRATION_EMAIL_BODY);
								subject = bimServer.getTemplateEngine().process(context, TemplateIdentifier.SELF_REGISTRATION_EMAIL_SUBJECT);
							} else {
								body = bimServer.getTemplateEngine().process(context, TemplateIdentifier.ADMIN_REGISTRATION_EMAIL_BODY);
								subject = bimServer.getTemplateEngine().process(context, TemplateIdentifier.ADMIN_REGISTRATION_EMAIL_SUBJECT);
							}
							msg.setContent(body, "text/html");
							msg.setSubject(subject.trim());

							LOGGER.info("Sending registration e-mail to " + user.getUsername());

							Transport.send(msg);
						}
					} catch (Exception e) {
						LOGGER.error("", e);
					}
				}
			});
		}
		return user;
	}

	public void setCreateSystemUser() {
		createSystemUser = true;
	}
}