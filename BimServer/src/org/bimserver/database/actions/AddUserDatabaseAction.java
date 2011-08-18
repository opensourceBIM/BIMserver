package org.bimserver.database.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewUserAdded;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;
import org.bimserver.templating.TemplateIdentifier;
import org.bimserver.utils.GeneratorUtils;
import org.bimserver.utils.Hashers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUserDatabaseAction extends BimDatabaseAction<Long> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddUserDatabaseAction.class);
	private final String name;
	private final UserType userType;
	private final String username;
	private final long createrUoid;
	private final boolean selfRegistration;
	private final String password;
	private boolean createSystemUser = false;
	private final BimServer bimServer;

	public AddUserDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String username, String name, UserType userType, long createrUoid, boolean selfRegistration) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.name = name;
		this.username = username;
		this.userType = userType;
		this.createrUoid = createrUoid;
		this.selfRegistration = selfRegistration;
		this.password = null;
	}

	public AddUserDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String username, String password, String name, UserType userType, long createrUoid, boolean selfRegistration) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.password = password;
		this.name = name;
		this.username = username;
		this.userType = userType;
		this.createrUoid = createrUoid;
		this.selfRegistration = selfRegistration;
	}

	public Long execute() throws UserException, BimDatabaseException, BimDeadlockException {
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
		if (!MailSystem.isValidEmailAddress(trimmedUserName) && !(trimmedUserName.equals("test") || trimmedUserName.equals("system") || trimmedUserName.equals("anonymous"))) {
			throw new UserException("Username must be a valid e-mail address");
		}
		if (trimmedName.equals("")) {
			throw new UserException("Invalid name");
		}
		if (getUserByUserName(trimmedUserName) != null) {
			throw new UserException("A user with the username " + trimmedUserName + " already exists");
		}
		User actingUser = getUserByUoid(createrUoid);
		if (actingUser == null || actingUser.getUserType() != UserType.SYSTEM) {
			if (createrUoid != -1 && actingUser.getUserType() != UserType.ADMIN) {
				throw new UserException("Only admin users can create other users");
			}
		}
		final User user = StoreFactory.eINSTANCE.createUser();
		if (password != null) {
			user.setPassword(Hashers.getSha256Hash(password));
		}
		user.setName(trimmedName);
		user.setUsername(trimmedUserName);
		user.setCreatedOn(new Date());
		user.setCreatedBy(getUserByUoid(createrUoid));
		user.setUserType(userType);
		user.setLastSeen(null);
		final String token = GeneratorUtils.generateToken();
		user.setValidationToken(Hashers.getSha256Hash(token));
		user.setValidationTokenCreated(new Date());
		NewUserAdded newUserAdded = LogFactory.eINSTANCE.createNewUserAdded();
		newUserAdded.setUser(user);
		newUserAdded.setExecutor(actingUser);
		newUserAdded.setDate(new Date());
		newUserAdded.setAccessMethod(getAccessMethod());
		getDatabaseSession().store(user);
		getDatabaseSession().store(newUserAdded);
		getDatabaseSession().addPostCommitAction(new PostCommitAction(){
			@Override
			public void execute() throws UserException {
				try {
					SettingsManager settingsManager = bimServer.getSettingsManager();
					if (settingsManager != null && settingsManager.getSettings().isSendConfirmationEmailAfterRegistration()) {
						if (MailSystem.isValidEmailAddress(user.getUsername()) && createrUoid != -1) {
							Session mailSession = bimServer.getMailSystem().createMailSession();
							
							Message msg = new MimeMessage(mailSession);
							String emailSenderAddress = settingsManager.getSettings().getEmailSenderAddress();
							InternetAddress addressFrom = new InternetAddress(emailSenderAddress);
							msg.setFrom(addressFrom);
							
							InternetAddress[] addressTo = new InternetAddress[1];
							addressTo[0] = new InternetAddress(user.getUsername());
							msg.setRecipients(Message.RecipientType.TO, addressTo);
							
							Map<String, Object> context = new HashMap<String, Object>();
							context.put("name", user.getName());
							context.put("username", user.getUsername());
							context.put("siteaddress", settingsManager.getSettings().getSiteAddress());
							context.put("validationlink", settingsManager.getSettings().getSiteAddress() + "/validate.jsp?uoid=" + user.getOid() + "&token=" + token);
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
							Transport.send(msg);
						}
					}
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
		return user.getOid();
	}
	
	public void setCreateSystemUser() {
		createSystemUser  = true;
	}
}