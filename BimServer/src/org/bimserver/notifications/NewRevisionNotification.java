package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.client.Channel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.models.store.User;
import org.bimserver.plugins.modelchecker.ModelCheckException;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncBimsie1RemoteServiceInterface;
import org.bimserver.shared.interfaces.async.AsyncBimsie1RemoteServiceInterface.NewRevisionCallback;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.templating.TemplateIdentifier;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewRevisionNotification extends Notification {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewRevisionNotification.class);
	private long roid;
	private long poid;
	private long soid;

	public NewRevisionNotification(BimServer bimServer, long poid, long roid, long soid) {
		super(bimServer);
		this.poid = poid;
		this.roid = roid;
		this.soid = soid;
	}

	public NewRevisionNotification(BimServer bimServer, long poid, long roid) {
		super(bimServer);
		this.poid = poid;
		this.roid = roid;
		this.soid = -1;
	}

	@Override
	public void process() throws BimserverDatabaseException, UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			if (getBimServer().getServerSettingsCache().getServerSettings().isSendEmailOnNewRevision()) {
				sendEmail(session, project, revision);
			}
			for (Service service : project.getServices()) {
				if (soid == -1 || service.getOid() == soid) {
					triggerNewRevision(session, getBimServer().getNotificationsManager(), getBimServer(), getBimServer().getNotificationsManager().getSiteAddress(), project, roid, Trigger.NEW_REVISION, service);
				}
			}
			if (soid == -1) {
				// Only execute if we are not triggering a specific service with this notification
				NewRevisionTopic newRevisionTopic = getBimServer().getNotificationsManager().getNewRevisionTopic();
				if (newRevisionTopic != null) {
					newRevisionTopic.process(session, poid, roid, this);
				}
				NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = getBimServer().getNotificationsManager().getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
				if (newRevisionOnSpecificProjectTopic != null) {
					newRevisionOnSpecificProjectTopic.process(session, poid, roid, this);
				}
			}
		} finally {
			session.close();
		}
	}
	
	private void sendEmail(DatabaseSession session, Project project, Revision revision) {
		Set<User> users = getUsers(session, project);
		for (User user : users) {
			String body = null;
			try {
				if (MailSystem.isValidEmailAddress(user.getUsername())) {
					Session mailSession = getBimServer().getMailSystem().createMailSession();
					ServerSettings serverSettings = getBimServer().getServerSettingsCache().getServerSettings();
					
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
					context.put("revisionId", revision.getId());
					context.put("comment", revision.getComment());
					context.put("projectName", project.getName());
					String subject = null;
					body = getBimServer().getTemplateEngine().process(context, TemplateIdentifier.NEW_REVISION_EMAIL_BODY);
					subject = getBimServer().getTemplateEngine().process(context, TemplateIdentifier.NEW_REVISION_EMAIL_SUBJECT);
					msg.setContent(body, "text/html");
					msg.setSubject(subject.trim());
					
					LOGGER.info("Sending new revision e-mail to " + user.getUsername());
					
					Transport.send(msg);
				}
			} catch (Exception e) {
				LOGGER.error(body);
				LOGGER.error("", e);
			}
		}
	}

	private Set<User> getUsers(DatabaseSession session, Project project) {
		Set<Project> relatedProjects = getRelatedProjects(project);
		Set<User> users = new HashSet<User>();
		for (Project relatedProject : relatedProjects) {
			for (User user : relatedProject.getHasAuthorizedUsers()) {
				users.add(user);
			}
		}
		return users;
	}
	
	private Set<Project> getRelatedProjects(Project project) {
		Set<Project> projects = new HashSet<Project>();
		Project rootProject = getRootProject(project);
		getAllSubProjects(projects, rootProject);
		return projects;
	}

	private Project getRootProject(Project project) {
		if (project.getParent() != null) {
			return getRootProject(project.getParent());
		}
		return project;
	}
	
	private void getAllSubProjects(Set<Project> projects, Project project) {
		projects.add(project);
		for (Project subProject : project.getSubProjects()) {
			getAllSubProjects(projects, subProject);
		}
	}

	public void triggerNewRevision(DatabaseSession session, NotificationsManager notificationsManager, final BimServer bimServer, String siteAddress, Project project, final long roid, Trigger trigger, final Service service) throws UserException, ServerException {
		if (service.getTrigger() == trigger) {
			Channel channel = null;
			try {
				IfcModelInterface model = null;
				for (ModelCheckerInstance modelCheckerInstance : service.getModelCheckers()) {
					if (modelCheckerInstance.isValid()) {
						ModelCheckerPlugin modelCheckerPlugin = bimServer.getPluginManager().getModelCheckerPlugin(modelCheckerInstance.getModelCheckerPluginClassName(), true);
						if (modelCheckerPlugin != null) {
							ModelChecker modelChecker = modelCheckerPlugin.createModelChecker(null);
							ModelCheckerResult result;
							try {
								if (model == null) {
									model = new IfcModel();
									Revision revision;
									try {
										revision = session.get(roid, Query.getDefault());
										session.getMap(model, new Query(project.getId(), revision.getId(), null, Deep.NO));
									} catch (BimserverDatabaseException e) {
										LOGGER.error("", e);
									}
								}
								result = modelChecker.check(model, modelCheckerInstance.getCompiled());
								if (!result.isValid()) {
									LOGGER.info("Not triggering");
									return;
								}
							} catch (ModelCheckException e) {
								LOGGER.info("Not triggering");
								return;
							}
						}
					}
				}
				channel = notificationsManager.getChannel(service);
				final Bimsie1RemoteServiceInterface remoteServiceInterface = channel.get(Bimsie1RemoteServiceInterface.class);
				long writeProjectPoid = service.getWriteRevision() == null ? -1 : service.getWriteRevision().getOid();
				long writeExtendedDataRoid = service.getWriteExtendedData() != null ? roid : -1;
				long readRevisionRoid = service.isReadRevision() ? roid : -1;
				long readExtendedDataRoid = service.getReadExtendedData() != null ? roid : -1;
				final ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(service.getUser().getOid(), service.getOid(), readRevisionRoid, writeProjectPoid, readExtendedDataRoid, writeExtendedDataRoid);
				ServiceInterface newService = bimServer.getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
				((org.bimserver.webservices.impl.ServiceImpl)newService).setAuthorization(authorization); // TODO redundant?
				
				AsyncBimsie1RemoteServiceInterface asyncRemoteServiceInterface = new AsyncBimsie1RemoteServiceInterface(remoteServiceInterface, bimServer.getExecutorService());
				asyncRemoteServiceInterface.newRevision(poid, roid, service.getOid(), service.getServiceIdentifier(), service.getProfileIdentifier(), service.getToken(), authorization.asHexToken(bimServer.getEncryptionKey()), bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), new NewRevisionCallback(){
					@Override
					public void success() {
					}

					@Override
					public void error(Throwable e) {
						LOGGER.error("", e);
					}});
			} catch (ChannelConnectionException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			} finally {
				if (channel != null) {
					channel.disconnect(); // TODO This is interesting, when sending async, is this not going to break?
				}
			}
		}
	}
}