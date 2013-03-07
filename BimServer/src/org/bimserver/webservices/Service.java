package org.bimserver.webservices;

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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.changes.AddAttributeChange;
import org.bimserver.changes.AddReferenceChange;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveAttributeChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.RemoveReferenceChange;
import org.bimserver.changes.SetAttributeChange;
import org.bimserver.changes.SetReferenceChange;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.database.actions.*;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SBimServerInfo;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SExtendedDataSchemaType;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SJavaInfo;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRemoteServiceUpdate;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SServiceField;
import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.interfaces.objects.SServiceParameter;
import org.bimserver.interfaces.objects.SServicePluginDescriptor;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.interfaces.objects.SSystemInfo;
import org.bimserver.interfaces.objects.STrigger;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.LongAction;
import org.bimserver.longaction.LongBranchAction;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.UserType;
import org.bimserver.notifications.ChangeProgressTopicOnProjectTopic;
import org.bimserver.notifications.ChangeProgressTopicOnRevisionTopic;
import org.bimserver.notifications.NewExtendedDataNotification;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopic;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopicKey;
import org.bimserver.notifications.ProgressOnRevisionTopic;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.notifications.TopicRegisterException;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.shared.compare.CompareWriter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.utils.Formatters;
import org.bimserver.utils.MultiplexingInputStream;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

	private final BimServer bimServer;
	private final AccessMethod accessMethod;
	private final String remoteAddress;
	private Authorization authorization;

	public Service(BimServer bimServer, AccessMethod accessMethod, String remoteAddress, Authorization authorization) {
		this.accessMethod = accessMethod;
		this.remoteAddress = remoteAddress;
		this.bimServer = bimServer;
		this.authorization = authorization;
	}

	@Override
	public Long checkin(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge, Boolean sync)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			username = user.getName();
			userUsername = user.getUsername();
			File homeDirIncoming = new File(bimServer.getHomeDir(), "incoming");
			if (!homeDirIncoming.isDirectory()) {
				homeDirIncoming.mkdir();
			}
			File userDirIncoming = new File(homeDirIncoming, userUsername);
			if (!userDirIncoming.exists()) {
				userDirIncoming.mkdir();
			}
			if (fileName.contains("/")) {
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
			}
			if (fileName.contains("\\")) {
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			fileName = dateFormat.format(new Date()) + "-" + fileName;
			File file = new File(userDirIncoming, fileName);
			InputStream inputStream = new MultiplexingInputStream(dataHandler.getInputStream(), new FileOutputStream(file));
			try {
				DeserializerPluginConfiguration deserializerObject = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, Query.getDefault());
				if (deserializerObject == null) {
					throw new UserException("Deserializer with oid " + deserializerOid + " not found");
				}
				Deserializer deserializer = bimServer.getDeserializerFactory().createDeserializer(deserializerOid);
				try {
					deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, fileSize);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(bimServer, null, accessMethod, poid, authorization, model, comment, merge);
				LongCheckinAction longAction = new LongCheckinAction(bimServer, username, userUsername, authorization, checkinDatabaseAction);
				bimServer.getLongActionManager().start(longAction);
				if (sync) {
					longAction.waitForCompletion();
				}
				return longAction.getProgressTopic().getKey().getId();
			} catch (UserException e) {
				throw e;
			} catch (DeserializeException e) {
				throw new UserException(e);
			} finally {
				inputStream.close();
			}
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Long checkinFromUrl(Long poid, String comment, Long deserializerOid, String fileName, String urlString, Boolean merge, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			username = user.getName();
			userUsername = user.getUsername();
			File homeDirIncoming = new File(bimServer.getHomeDir(), "incoming");
			if (!homeDirIncoming.isDirectory()) {
				homeDirIncoming.mkdir();
			}
			File userDirIncoming = new File(homeDirIncoming, userUsername);
			if (!userDirIncoming.exists()) {
				userDirIncoming.mkdir();
			}
			
			URL url = new URL(urlString);
			InputStream input = url.openStream();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			fileName = dateFormat.format(new Date()) + "-" + fileName;
			File file = new File(userDirIncoming, fileName);
			InputStream inputStream = new MultiplexingInputStream(input, new FileOutputStream(file));
			try {
				DeserializerPluginConfiguration deserializerObject = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, Query.getDefault());
				if (deserializerObject == null) {
					throw new UserException("Deserializer with oid " + deserializerOid + " not found");
				}
				Deserializer deserializer = bimServer.getDeserializerFactory().createDeserializer(deserializerOid);
				try {
					deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, 0);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(bimServer, null, accessMethod, poid, authorization, model, comment, merge);
				LongCheckinAction longAction = new LongCheckinAction(bimServer, username, userUsername, authorization, checkinDatabaseAction);
				bimServer.getLongActionManager().start(longAction);
				if (sync) {
					longAction.waitForCompletion();
				}
				return longAction.getProgressTopic().getKey().getId();
			} catch (UserException e) {
				throw e;
			} catch (DeserializeException e) {
				throw new UserException(e);
			} finally {
				inputStream.close();
			}
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long checkoutLastRevision(Long poid, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			return checkout(project.getLastRevision().getOid(), serializerOid, sync);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long checkout(Long roid, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		authorization.canDownload(roid);
		DatabaseSession session = bimServer.getDatabase().createSession();
		User user = null;
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = (SerializerPluginConfiguration) session.get(serializerOid, Query.getDefault());
//			org.bimserver.plugins.serializers.Serializer serializer = bimServer.getEmfSerializerFactory().get(serializerOid).createSerializer(new org.bimserver.plugins.serializers.PluginConfiguration());
			if (serializerPluginConfiguration == null) {
				throw new UserException("No serializer with id " + serializerOid + " could be found");
			}
			if (!serializerPluginConfiguration.getClassName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializer") && !serializerPluginConfiguration.getClassName().equals("org.bimserver.ifc.xml.serializer.IfcXmlSerializer")) {
				throw new UserException("Only IFC or IFCXML allowed when checking out");
			}
			DownloadParameters downloadParameters = new DownloadParameters(bimServer, roid, serializerOid, -1);
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(bimServer, user.getName(), user.getUsername(), downloadParameters, authorization, accessMethod);
			try {
				bimServer.getLongActionManager().start(longDownloadAction);
			} catch (CannotBeScheduledException e) {
				LOGGER.error("", e);
			}
			if (sync) {
				longDownloadAction.waitForCompletion();
			}
			return longDownloadAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	private UserSettings getUserSettings(DatabaseSession session) throws BimserverLockConflictException, BimserverDatabaseException {
		User user = session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		return user.getUserSettings();
	}

	@Override
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			if (!selfRegistration) {
				requireRealUserAuthentication();
			} else if (!bimServer.getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireSelfregistrationAllowed();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(bimServer, session, accessMethod, username, name, bimServer.getSConverter().convertFromSObject(type), authorization,
					selfRegistration);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	private <T> T handleException(Exception e) throws ServerException, UserException {
		if (e instanceof UserException) {
			throw (UserException) e;
		} else if (e instanceof ServerException) {
			LOGGER.error("", e);
			throw (ServerException) e;
		} else if (e instanceof BimserverConcurrentModificationDatabaseException) {
			throw new ServerException("Concurrent modification of object, please try again", e);
		} else if (e instanceof BimserverDatabaseException) {
			LOGGER.error("", e);
			throw new ServerException("Database error", e);
		}
		LOGGER.error("", e);
		throw new ServerException("Unknown error: " + e.getMessage(), e);
	}

	@Override
	public SProject addProject(String projectName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, authorization);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(bimServer, session, accessMethod, authorization, uoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects(Boolean onlyTopLevel) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, accessMethod, onlyTopLevel, authorization);
			List<SProject> convertToSListProject = bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	private void requireAuthenticationAndRunningServer() throws UserException {
		requireRunningServer();
		requireAuthentication();
	}

	private void requireAdminAuthenticationAndRunningServer() throws UserException {
		requireRunningServer();
		requireAdminAuthentication();
	}

	private void requireRunningServer() throws UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.RUNNING) {
			throw new UserException("Call cannot be executed because the server is in " + bimServer.getServerInfo().getServerState() + " mode");
		}
	}

	private void requireAuthentication() throws UserException {
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
	}
	
	private void requireRealUserAuthentication() throws UserException {
		requireRunningServer();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (authorization instanceof ExplicitRightsAuthorization) {
			throw new UserException("Real authentication required (this session has token authentication)");
		}
		if (authorization instanceof AnonymousAuthorization) {
			throw new UserException("Anonymous has no rights for this call");
		}
	}

	private void requireAdminAuthentication() throws UserException {
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (!(authorization instanceof AdminAuthorization) && !(authorization instanceof SystemAuthorization)) {
			throw new UserException("Administrator rights required for this call");
		}
	}

	private void requireSelfregistrationAllowed() throws UserException {
		if (authorization == null) {
			throw new UserException("No self registration allowed");
		}
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, accessMethod, poid);
			List<SRevision> convertToSListRevision = bimServer.getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SRevisionComparator(true));
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<org.bimserver.interfaces.objects.SService> getAllServicesOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<org.bimserver.models.store.Service>> action = new GetAllServicesOfProjectDatabaseAction(session, accessMethod, poid);
			List<org.bimserver.interfaces.objects.SService> convertToSListRevision = bimServer.getSConverter().convertToSListService(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SServiceComparator());
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, false);
			return bimServer.getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, true);
			return bimServer.getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(session, accessMethod, authorization);
			List<SUser> convertToSListUser = bimServer.getSConverter().convertToSListUser(session.executeAndCommitAction(action));
			Collections.sort(convertToSListUser, new SUserComparator());
			return convertToSListUser;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String login(String username, String password) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LoginDatabaseAction loginDatabaseAction = new LoginDatabaseAction(bimServer, session, this, accessMethod, username, password);
			return session.executeAndCommitAction(loginDatabaseAction);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, accessMethod, uoid);
			return bimServer.getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(session, accessMethod, uoid);
			List<SRevision> convertToSListRevision = bimServer.getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SRevisionComparator(true));
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevision getRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, accessMethod, roid, authorization);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, accessMethod, roid);
			return bimServer.getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void cleanupLongAction(Long actionId) throws UserException, ServerException {
		bimServer.getLongActionManager().remove(actionId);
	}
	
	public Long download(Long roid, Long serializerOid, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, serializerOid, showOwn ? -1 : authorization.getUoid()), sync);
	}

	@Override
	public Long downloadCompareResults(Long serializerOid, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromCompare(roid1, roid2, bimServer.getSConverter().convertFromSObject(type), mcid, serializerOid), sync);
	}

	private Long download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		User user = null;
		for (long roid : downloadParameters.getRoids()) {
			authorization.canDownload(roid);
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(bimServer, user == null ? "Unknown" : user.getName(), user == null ? "Unknown" : user.getUsername(), downloadParameters, authorization, accessMethod);
		try {
			bimServer.getLongActionManager().start(longDownloadAction);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		if (sync) {
			longDownloadAction.waitForCompletion();
		}
		return longDownloadAction.getProgressTopic().getKey().getId();
	}

	@Override
	public SDownloadResult getDownloadData(final Long actionId) throws ServerException, UserException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			longAction.waitForCompletion();
			SCheckoutResult result = longAction.getCheckoutResult();
			return result;
		} else {
			throw new UserException("No data found for laid " + actionId);
		}
	}

	@Override
	public SLongActionState getLongActionState(Long actionId) throws ServerException, UserException {
		LongAction<?> longAction = bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			return bimServer.getSConverter().convertToSObject(longAction.getState());
		} else {
			throw new UserException("No state found for laid " + actionId);
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(bimServer, session, accessMethod, poid, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(session, accessMethod, authorization, uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean removeUserFromProject(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(bimServer, session, accessMethod, uoid, poid, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long downloadByOids(Set<Long> roids, Set<Long> oids, Long serializerOid, Boolean sync, Boolean deep) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromOids(bimServer, serializerOid, roids, oids, deep), sync);
	}

	@Override
	public Long downloadByTypes(Set<Long> roids, Set<String> classNames, Long serializerOid, Boolean includeAllSubtypes, Boolean useObjectIDM, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DownloadParameters fromClassNames = DownloadParameters.fromClassNames(bimServer, roids, classNames, includeAllSubtypes, serializerOid, deep);
		fromClassNames.setUseObjectIDM(useObjectIDM);
		return download(fromClassNames, sync);
	}

	@Override
	public List<String> getAvailableClasses() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(session, accessMethod);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SDatabaseInformation getDatabaseInformation() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(session, accessMethod);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long downloadByGuids(Set<Long> roids, Set<String> guids, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromGuids(bimServer, roids, guids, serializerOid, deep), sync);
	}

	@Override
	public Long downloadByNames(Set<Long> roids, Set<String> names, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromNames(bimServer, roids, names, serializerOid, deep), sync);
	}

	@Override
	public SUser getLoggedInUser() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return getUserByUoid(authorization.getUoid());
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(session, accessMethod, uoid);
			return bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void logout() throws UserException {
		requireAuthenticationAndRunningServer();
		authorization = null;
	}

	@Override
	public Boolean changePassword(Long uoid, String oldPassword, String newPassword) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(bimServer, session, accessMethod, uoid, oldPassword, newPassword, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, username);
			SUser convert = bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
			if (convert == null) {
				throw new UserException("User with username \"" + username + "\" not found");
			}
			return convert;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(bimServer, session, accessMethod, poid, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(bimServer, session, accessMethod, authorization, uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, parentPoid, authorization);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(bimServer, session, accessMethod, authorization, sProject);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(bimServer, session, accessMethod, authorization, sRevision);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(Long roid1, Long roid2, SCompareType sCompareType, Long mcid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(bimServer, session, accessMethod, authorization, -1, roid1, roid2,
					bimServer.getSConverter().convertFromSObject(sCompareType), mcid);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, accessMethod, roid);
			RevisionSummary revisionSummary = session.executeAndCommitAction(action);
			return bimServer.getSConverter().convertToSObject(revisionSummary);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(session, accessMethod, authorization, uoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckoutWarnings(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(session, accessMethod, poid, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckinWarnings(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckinWarningsDatabaseAction(session, accessMethod, poid, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasRights(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(session, accessMethod, getCurrentUser(session).getOid(), authorization, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long downloadRevisions(Set<Long> roids, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromRoids(bimServer, roids, serializerOid), sync);
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByOidDatabaseAction(bimServer, session, accessMethod, roid, oid, authorization);
			SDataObject dataObject = bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public Long getOidByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Long> action = new GetOidByGuidDatabaseAction(session, accessMethod, roid, guid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByGuidDatabaseAction(bimServer, session, accessMethod, roid, guid, authorization);
			SDataObject dataObject = bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String className) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		BimDatabaseAction<List<DataObject>> action = new GetDataObjectsByTypeDatabaseAction(bimServer, session, accessMethod, roid, className, authorization);
		try {
			List<DataObject> dataObjects = session.executeAndCommitAction(action);
			return bimServer.getSConverter().convertToSListDataObject(dataObjects);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToNewProject(Long roid, String projectName, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, accessMethod, bimServer, authorization, roid, projectName, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longAction = new LongBranchAction(bimServer, username, userUsername, authorization, action);
			bimServer.getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToExistingProject(Long roid, Long destPoid, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, accessMethod, bimServer, authorization, roid, destPoid, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longBranchAction = new LongBranchAction(bimServer, username, userUsername, authorization, action);
			bimServer.getLongActionManager().start(longBranchAction);
			if (sync) {
				longBranchAction.waitForCompletion();
			}
			return longBranchAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SLogAction> getLogs() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(session, accessMethod, authorization);
			List<LogAction> logs = session.executeAndCommitAction(action);
			List<SLogAction> convertToSListLogAction = bimServer.getSConverter().convertToSListLogAction(logs);
			Collections.sort(convertToSListLogAction, new SLogComparator(true));
			return convertToSListLogAction;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(Long goid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(session, accessMethod, authorization, goid);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(bimServer, session, accessMethod, authorization, sGeoTag);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUoid(Long uoid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, accessMethod, uoid);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, accessMethod, poid, authorization);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(bimServer.getSConverter().convertToSSetUser((session.executeAndCommitAction(action))));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(bimServer.getSConverter().convertToSSetUser(session.executeAndCommitAction(action)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getUsersProjects(Long uoid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetProjectsOfUserDatabaseAction action = new GetProjectsOfUserDatabaseAction(session, accessMethod, authorization, uoid);
			return bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, accessMethod, name, authorization);
			return (List<SProject>) bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String autologin(String username, String hash) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AutologinDatabaseAction action = new AutologinDatabaseAction(bimServer, session, this, accessMethod, username, hash);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setRevisionTag(Long roid, String tag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(session, accessMethod, roid, tag);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, accessMethod, authorization, poid);
			List<SProject> convertToSListProject = bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(Long uoid, SUserType userType) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(bimServer, session, accessMethod, authorization, uoid, userType);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private SUser getCurrentUser(DatabaseSession databaseSession) throws UserException, ServerException {
		if (authorization == null) {
			return null;
		}
		try {
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			return bimServer.getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SUser getCurrentUser() throws UserException, ServerException {
		if (authorization == null) {
			return null;
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			return bimServer.getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isLoggedIn() {
		return authorization != null;
	}

	@Override
	public String getSettingEmailSenderAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getEmailSenderAddress();
	}

	@Override
	public String getServiceRepositoryUrl() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl();
	}

	@Override
	public void setServiceRepositoryUrl(final String url) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setServiceRepositoryUrl(url);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingProtocolBuffersPort(final Integer port) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setProtocolBuffersPort(port);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Integer getSettingProtocolBuffersPort() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getProtocolBuffersPort();
	}

	@Override
	public void setSettingEmailSenderAddress(final String emailSenderAddress) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (emailSenderAddress.trim().isEmpty()) {
			throw new UserException("Email sender address cannot be empty");
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setEmailSenderAddress(emailSenderAddress);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingSiteAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getSiteAddress();
	}

	@Override
	public void setSettingSiteAddress(final String siteAddress) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (siteAddress.trim().isEmpty()) {
			throw new UserException("Site Address cannot be empty");
		} else if (!siteAddress.startsWith("http://") && !(siteAddress.startsWith("https://"))) {
			throw new UserException("Site Address must start with either \"http://\" or \"https://\"");
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSiteAddress(siteAddress);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingSmtpServer() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getSmtpServer();
	}

	@Override
	public void setSettingSmtpServer(final String smtpServer) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (smtpServer.trim().isEmpty()) {
			throw new UserException("SMTP server address cannot be empty");
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSmtpServer(smtpServer);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingAllowSelfRegistration() throws ServerException, UserException {
		return bimServer.getServerSettingsCache().getServerSettings().getAllowSelfRegistration();
	}

	@Override
	public Boolean isSettingHideUserListForNonAdmin() throws ServerException, UserException {
		requireAuthentication();
		return bimServer.getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin();
	}

	@Override
	public void setSettingHideUserListForNonAdmin(final Boolean hideUserListForNonAdmin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setHideUserListForNonAdmin(hideUserListForNonAdmin);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingAllowSelfRegistration(final Boolean allowSelfRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setAllowSelfRegistration(allowSelfRegistration);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServerException, UserException {
		requireAuthentication();
		return bimServer.getServerSettingsCache().getServerSettings().isAllowUsersToCreateTopLevelProjects();
	}

	@Override
	public void setSettingAllowUsersToCreateTopLevelProjects(final Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingCheckinMergingEnabled() throws ServerException, UserException {
		requireAuthentication();
		return bimServer.getServerSettingsCache().getServerSettings().getCheckinMergingEnabled();
	}

	@Override
	public void setSettingCheckinMergingEnabled(final Boolean checkinMergingEnabled) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setCheckinMergingEnabled(checkinMergingEnabled);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().isSendConfirmationEmailAfterRegistration();
	}

	@Override
	public void setSettingSendConfirmationEmailAfterRegistration(final Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingCacheOutputFiles() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().getCacheOutputFiles();
	}

	@Override
	public Boolean isSettingGenerateGeometryOnCheckin() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin();
	}
	
	@Override
	public void setSettingCacheOutputFiles(final Boolean cacheOutputFiles) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setCacheOutputFiles(cacheOutputFiles);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setSettingGenerateGeometryOnCheckin(final Boolean generateGeometryOnCheckin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setGenerateGeometryOnCheckin(generateGeometryOnCheckin);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SAccessMethod getAccessMethod() {
		return SAccessMethod.valueOf(accessMethod.getName());
	}

	@Override
	public void sendCompareEmail(SCompareType sCompareType, Long mcid, Long poid, Long roid1, Long roid2, String address) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SUser currentUser = getCurrentUser(session);
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, Query.getDefault());
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, Query.getDefault());
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = bimServer.getServerSettingsCache().getServerSettings().getEmailSenderAddress();
			}

			Session mailSession = bimServer.getMailSystem().createMailSession();

			Message msg = new MimeMessage(mailSession);

			try {
				InternetAddress addressFrom = new InternetAddress(senderAddress);
				addressFrom.setPersonal(senderName);
				msg.setFrom(addressFrom);

				InternetAddress[] addressTo = new InternetAddress[1];
				addressTo[0] = new InternetAddress(address);
				msg.setRecipients(Message.RecipientType.TO, addressTo);

				msg.setSubject("BIMserver Model Comparator");
				SCompareResult compareResult = compare(roid1, roid2, sCompareType, mcid);
				String html = CompareWriter.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), sCompareType, getProjectByPoid(poid), false);
				msg.setContent(html, "text/html");
				Transport.send(msg);
			} catch (AddressException e) {
				throw new UserException(e);
			} catch (UnsupportedEncodingException e) {
				throw new UserException(e);
			} catch (MessagingException e) {
				throw new UserException(e);
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void requestPasswordChange(String username, String resetUrl) throws ServerException, UserException {
		// No authentication required because you should be able to do this wihout logging in...
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(session, accessMethod, bimServer, username, resetUrl);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser validateAccount(Long uoid, String token, String password) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new ValidateUserDatabaseAction(session, accessMethod, uoid, token, password);
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SLongAction> getActiveLongActions() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		try {
			return bimServer.getSConverter().convertToSListLongAction(bimServer.getLongActionManager().getActiveLongActions());
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProject> getAllReadableProjects() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(session, accessMethod, authorization);
			return bimServer.getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Date getLastDatabaseReset() throws ServerException, UserException {
		requireRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return session.getCreatedDate();
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void setup(String siteAddress, String smtpServer, String smtpSender, String adminName, String adminUsername, String adminPassword) throws ServerException, UserException {
		setSettingSmtpServer(smtpServer);
		setSettingSiteAddress(siteAddress);
		setSettingEmailSenderAddress(smtpSender);

		if (adminUsername.trim().isEmpty()) {
			throw new UserException("Admin Username cannot be empty");
		}

		if (adminPassword.trim().isEmpty()) {
			throw new UserException("Admin Password cannot be empty");
		}

		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AddUserDatabaseAction addUserDatabaseAction = new AddUserDatabaseAction(bimServer, session, AccessMethod.INTERNAL, adminUsername, adminPassword, adminName, UserType.ADMIN, authorization, false);
			session.executeAndCommitAction(addUserDatabaseAction);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		bimServer.getServerInfoManager().update();
	}

	@Override
	public List<SMigration> getMigrations() throws UserException {
		Migrator migrator = bimServer.getDatabase().getMigrator();
		List<SMigration> list = new ArrayList<SMigration>(bimServer.getSConverter().convertToSSetMigration(migrator.getMigrations()));
		Collections.sort(list, new SMigrationComparator());
		return list;
	}

	@Override
	public void migrateDatabase() throws ServerException, UserException {
		try {
			bimServer.getDatabase().getMigrator().migrate();
			bimServer.getServerInfoManager().update();
		} catch (MigrationException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} catch (InconsistentModelsException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		}
	}

	@Override
	public List<SSerializerPluginConfiguration> getAllSerializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SSerializerPluginConfiguration> serializers = bimServer.getSConverter().convertToSListSerializerPluginConfiguration(getUserSettings(session).getSerializers());
			Collections.sort(serializers, new SPluginConfigurationComparator());
			return serializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SDeserializerPluginConfiguration> getAllDeserializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SDeserializerPluginConfiguration> deserializers = bimServer.getSConverter().convertToSListDeserializerPluginConfiguration(getUserSettings(session).getDeserializers());
			Collections.sort(deserializers, new SPluginConfigurationComparator());
			return deserializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(serializer, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new AddDeserializerDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(serializer, session);
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SObjectIDMPluginConfiguration> getAllObjectIDMs(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SObjectIDMPluginConfiguration> objectIdms = bimServer.getSConverter().convertToSListObjectIDMPluginConfiguration(getUserSettings(session).getObjectIDMs());
			Collections.sort(objectIdms, new SPluginConfigurationComparator());
			return objectIdms;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addObjectIDM(SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddObjectIDMDatabaseAction(session, accessMethod, authorization, bimServer.getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateObjectIDM(SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			session.executeAndCommitAction(new UpdateObjectIDMDatabaseAction(session, accessMethod, bimServer.getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerById(Long oid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializerPluginConfiguration getDeserializerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SObjectIDMPluginConfiguration getObjectIDMById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteObjectIDM(Long ifid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteObjectIDMDatabaseAction(session, accessMethod, ifid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSerializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteSerializerDatabaseAction(session, accessMethod, sid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDeserializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteDeserializerDatabaseAction(session, accessMethod, sid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByName(String serializerName) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByNameDatabaseAction(session, accessMethod, serializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SObjectIDMPluginConfiguration getObjectIDMByName(String ObjectIDMName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByNameDatabaseAction(session, accessMethod, ObjectIDMName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializerPluginConfiguration getDeserializerByName(String deserializerName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByNameDatabaseAction(session, accessMethod, deserializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByContentType(String contentType) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service should be able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByContentTypeDatabaseAction(session, accessMethod, contentType)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByPluginClassName(String pluginClassName) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service should be able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByPluginClassNameDatabaseAction(session, accessMethod, pluginClassName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean hasActiveSerializer(String contentType) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			SSerializerPluginConfiguration serializer = getSerializerByContentType(contentType);
			if (serializer != null) {
				if (serializer.getEnabled()) {
					return bimServer.getPluginManager().isEnabled(serializer.getClassName());
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public List<SPluginDescriptor> getAllPlugins() throws UserException {
		requireRealUserAuthentication();
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		Collection<Plugin> plugins = bimServer.getPluginManager().getAllPlugins(false);
		for (Plugin plugin : plugins) {
			SPluginDescriptor sPluginDescriptor = new SPluginDescriptor();
			sPluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
			sPluginDescriptor.setDefaultName(plugin.getClass().getName());
			PluginContext pluginContext = bimServer.getPluginManager().getPluginContext(plugin);
			sPluginDescriptor.setLocation(pluginContext.getLocation());
			sPluginDescriptor.setDescription(plugin.getDescription());
			sPluginDescriptor.setEnabled(pluginContext.isEnabled());
			result.add(sPluginDescriptor);
		}
		Collections.sort(result, new SPluginDescriptorComparator());
		return result;
	}

	@Override
	public void disablePlugin(String name) throws UserException {
		requireAdminAuthenticationAndRunningServer();
		bimServer.getPluginManager().disablePlugin(name);
	}

	@Override
	public void enablePlugin(String name) throws UserException {
		requireAdminAuthenticationAndRunningServer();
		bimServer.getPluginManager().enablePlugin(name);
	}

	@Override
	public Long startTransaction(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		int pid = -1;
		int rid = -1;
		try {
			Project project = (Project) session.get(poid, Query.getDefault());
			pid = project.getId();
			if (project.getLastRevision() != null) {
				Revision revision = project.getLastRevision();
				ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
				rid = lastConcreteRevision.getId();
			}
			LongTransaction longTransaction = bimServer.getLongTransactionManager().newLongTransaction(poid, pid, rid);
			return longTransaction.getTid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long commitTransaction(Long tid, String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		LongTransaction longTransaction = bimServer.getLongTransactionManager().get(tid);
		if (longTransaction == null) {
			throw new UserException("No transaction with tid " + tid + " was found");
		}
		CommitTransactionDatabaseAction action = new CommitTransactionDatabaseAction(bimServer, session, accessMethod, authorization, longTransaction, comment);
		try {
			session.executeAndCommitAction(action);
			return action.getRevision().getOid();
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return -1L;
	}

	@Override
	public void abortTransaction(Long tid) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).close();
	}

	@Override
	public void addStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public void setDoubleAttributes(Long tid, Long oid, String attributeName, List<Double> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setIntegerAttributes(Long tid, Long oid, String attributeName, List<Integer> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setLongAttributes(Long tid, Long oid, String attributeName, List<Long> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void setBooleanAttributes(Long tid, Long oid, String attributeName, List<Boolean> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
	}

	@Override
	public void addBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new AddReferenceChange(oid, referenceName, referenceOid));
	}

	@Override
	public Long createObject(Long tid, String className) throws UserException {
		requireAuthenticationAndRunningServer();
		EClass eClass = ((Database) bimServer.getDatabase()).getEClassForName(className);
		if (eClass == null) {
			throw new UserException("Unknown type: \"" + className + "\"");
		}
		Long oid = bimServer.getDatabase().newOid(eClass);
		CreateObjectChange createObject = new CreateObjectChange(className, oid, eClass);
		LongTransaction longTransaction = bimServer.getLongTransactionManager().get(tid);
		if (longTransaction == null) {
			throw new UserException("No transaction with tid " + tid + " was found");
		}
		longTransaction.add(createObject);
		return oid;
	}

	@Override
	public void removeAttribute(Long tid, Long oid, String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new RemoveAttributeChange(oid, attributeName, index));
	}

	@Override
	public void removeObject(Long tid, Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new RemoveObjectChange(oid, bimServer.getDatabase().getEClassForOid(oid)));
	}

	@Override
	public void removeReference(Long tid, Long oid, String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new RemoveReferenceChange(oid, referenceName, index));
	}

	@Override
	public void setStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getStringAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public void setIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}

	@Override
	public void setByteArrayAttribute(Long tid, Long oid, String attributeName, Byte[] value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public void setLongAttribute(Long tid, Long oid, String attributeName, Long value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	public Integer getIntegerAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Integer)getAttribute(tid, oid, attributeName);
	}

	public Long getLongAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Long)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException {
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Boolean getBooleanAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Boolean)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException {
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Double getDoubleAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Double)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public List<Double> getDoubleAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Double>)getAttribute(tid, oid, attributeName);
	}

	public List<Boolean> getBooleanAttributes(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (List<Boolean>)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public byte[] getByteArrayAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (byte[])getAttribute(tid, oid, attributeName);
	}

	@Override
	public List<byte[]> getByteArrayAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<byte[]>)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public List<Integer> getIntegerAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Integer>)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public List<String> getStringAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<String>)getAttribute(tid, oid, attributeName);
	}
	
	private Object getAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LongTransaction transaction = bimServer.getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			return object.eGet(object.eClass().getEStructuralFeature(attributeName));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setEnumAttribute(Long tid, Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getEnumAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(tid, oid, attributeName);
	}

	@Override
	public void setReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, referenceOid));
	}
	
	@Override
	public Long getReference(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LongTransaction transaction = bimServer.getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			IdEObject ref = (IdEObject) object.eGet(object.eClass().getEStructuralFeature(referenceName));
			if (ref == null) {
				return -1L;
			}
			return ref.getOid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getReferences(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LongTransaction transaction = bimServer.getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new Query(transaction.getPid(), transaction.getRid(), null, Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			List<IdEObject> list = (List<IdEObject>) object.eGet(object.eClass().getEStructuralFeature(referenceName));
			List<Long> oidList = new ArrayList<>();
			for (IdEObject idEObject : list) {
				oidList.add(idEObject.getOid());
			}
			return oidList;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void unsetAttribute(Long tid, Long oid, String attributeName) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, null));
	}

	@Override
	public void unsetReference(Long tid, Long oid, String referenceName) throws UserException {
		requireAuthenticationAndRunningServer();
		bimServer.getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, -1));
	}

	@Override
	public Date getServerStartTime() {
		return bimServer.getServerStartTime().getTime();
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getSerializerPluginDescriptor(type);
	}

	@Override
	public List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws UserException {
		requireRealUserAuthentication();
		Collection<ObjectIDMPlugin> allObjectIDMs = bimServer.getPluginManager().getAllObjectIDMPlugins(true);
		List<SObjectIDMPluginDescriptor> descriptors = new ArrayList<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPlugin ObjectIDMPlugin : allObjectIDMs) {
			SObjectIDMPluginDescriptor descriptor = new SObjectIDMPluginDescriptor();
			descriptor.setClassName(ObjectIDMPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}

	@Override
	public Long downloadQuery(Long roid, Long qeid, String code, Boolean sync, Long serializerOid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromQuery(roid, qeid, code, serializerOid), sync);
	}

	@Override
	public String getProtocolBuffersFile() throws ServerException, UserException {
		File file = bimServer.getResourceFetcher().getFile("service.proto");
		try {
			return FileUtils.readFileToString(file);
		} catch (IOException e) {
			throw new ServerException(e);
		}
	}

	@Override
	public SServerInfo getServerInfo() {
		return bimServer.getSConverter().convertToSObject(bimServer.getServerInfo());
	}

	@Override
	public SVersion getVersion() throws ServerException, UserException {
		return bimServer.getVersionChecker().getLocalVersion();
	}

	@Override
	public SVersion getLatestVersion() throws ServerException, UserException {
		return bimServer.getVersionChecker().getOnlineVersion();
	}

	@Override
	public Boolean upgradePossible() {
		return bimServer.getVersionChecker().updateNeeded();
	}

	@Override
	public List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SDeserializerPluginDescriptor> descriptors = new ArrayList<SDeserializerPluginDescriptor>();
		for (DeserializerPlugin deserializerPlugin : bimServer.getPluginManager().getAllDeserializerPlugins(true)) {
			SDeserializerPluginDescriptor descriptor = new SDeserializerPluginDescriptor();
			descriptor.setDefaultName(deserializerPlugin.getDefaultName());
			descriptor.setPluginClassName(deserializerPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}

	@Override
	public List<String> getAvailableClassesInRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesInRevisionDatabaseAction(session, accessMethod, roid);
			return session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SDataObject> getDataObjects(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<DataObject>> action = new GetDataObjectsDatabaseAction(session, accessMethod, bimServer, roid, authorization);
			return bimServer.getSConverter().convertToSListDataObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String getRemoteAddress() throws ServerException, UserException {
		return remoteAddress;
	}

	@Override
	public String getServerLog() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		try {
			return FileUtils.readFileToString(new File(bimServer.getHomeDir(), "logs/bimserver.log"));
		} catch (IOException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		}
	}

	@Override
	public List<SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllRenderEnginePluginDescriptors();
	}

	@Override
	public List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllQueryEnginePluginDescriptors();
	}

	@Override
	public List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllServicePluginDescriptors();
	}

	@Override
	public List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllModelComparePluginDescriptors();
	}

	@Override
	public List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getSerializerFactory().getAllModelMergerPluginDescriptors();
	}

	@Override
	public List<SRenderEnginePluginConfiguration> getAllRenderEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SRenderEnginePluginConfiguration> renderEngines = bimServer.getSConverter().convertToSListRenderEnginePluginConfiguration(getUserSettings(session).getRenderEngines());
			Collections.sort(renderEngines, new SPluginConfigurationComparator());
			return renderEngines;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SQueryEnginePluginConfiguration> getAllQueryEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SQueryEnginePluginConfiguration> queryEngines = bimServer.getSConverter().convertToSListQueryEnginePluginConfiguration(getUserSettings(session).getQueryengines());
			Collections.sort(queryEngines, new SPluginConfigurationComparator());
			return queryEngines;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelComparePluginConfiguration> getAllModelCompares(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SModelComparePluginConfiguration> modelCompares = bimServer.getSConverter().convertToSListModelComparePluginConfiguration(getUserSettings(session).getModelcompares());
			Collections.sort(modelCompares, new SPluginConfigurationComparator());
			return modelCompares;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelMergerPluginConfiguration> getAllModelMergers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SModelMergerPluginConfiguration> modelMergers = bimServer.getSConverter().convertToSListModelMergerPluginConfiguration(getUserSettings(session).getModelmergers());
			Collections.sort(modelMergers, new SPluginConfigurationComparator());
			return modelMergers;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(renderEngine, session);
			session.executeAndCommitAction(new UpdateRenderEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new UpdateQueryEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new UpdateModelCompareDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new UpdateModelMergerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteRenderEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteRenderEngineDatabaseAction(session, accessMethod, iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteQueryEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteQueryEngineDatabaseAction(session, accessMethod, iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteModelCompare(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteModelCompareDatabaseAction(session, accessMethod, iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteModelMerger(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteModelMergerDatabaseAction(session, accessMethod, iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRenderEnginePluginConfiguration getRenderEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRenderEnginePluginConfiguration getRenderEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(renderEngine, session);
			session.executeAndCommitAction(new AddRenderEngineDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new AddQueryEngineDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = bimServer.getSConverter().convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new AddModelCompareDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = bimServer.getSConverter().convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new AddModelMergerDatabaseAction(session, accessMethod, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(String extension) throws ServerException, UserException {
		// Token authenticated users should also be able to call this method
		try {
			requireAuthenticationAndRunningServer();
			for (DeserializerPlugin deserializerPlugin : bimServer.getPluginManager().getAllDeserializerPlugins(true)) {
				if (deserializerPlugin.canHandleExtension(extension)) {
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						UserSettings userSettings = getUserSettings(session);
						for (DeserializerPluginConfiguration deserializer : userSettings.getDeserializers()) {
							if (deserializer.getClassName().equals(deserializerPlugin.getClass().getName())) {
								return bimServer.getSConverter().convertToSObject(deserializer);
							}
						}
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					} finally {
						session.close();
					}
				}
			}
		} catch (Exception e) {
			handleException(e);
		}
		return null;
	}

	@Override
	public void addExtendedDataSchema(SExtendedDataSchema extendedDataSchema) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedDataSchema convert = bimServer.getSConverter().convertFromSObject(extendedDataSchema, session);
			session.executeAndCommitAction(new AddExtendedDataSchemaDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addUserToExtendedDataSchema(Long uoid, Long edsid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new AddUserToExtendedDataSchemaDatabaseAction(session, accessMethod, uoid, edsid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeUserFromExtendedDataSchema(Long uoid, Long edsid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RemoveUserFromExtendedDataSchemaDatabaseAction(session, accessMethod, uoid, edsid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addExtendedDataToRevision(Long roid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedData convert = bimServer.getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToRevisionDatabaseAction(bimServer, session, accessMethod, roid, authorization, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addExtendedDataToProject(Long poid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedData convert = bimServer.getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToProjectDatabaseAction(bimServer, session, accessMethod, poid, convert, authorization));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SExtendedDataSchema getExtendedDataSchemaById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SExtendedData getExtendedData(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, accessMethod, authorization, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SExtendedDataSchema> getAllExtendedDataSchemas() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SExtendedDataSchema> serializers = bimServer.getSConverter().convertToSListExtendedDataSchema(session.executeAndCommitAction(new GetAllExtendedDataSchemasDatabaseAction(session,
					accessMethod)));
			return serializers;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getQueryEngineExample(Long qeid, String key) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getQueryEngineById(qeid);
		QueryEnginePlugin queryEngine = bimServer.getPluginManager().getQueryEngine(queryEngineById.getClassName(), true);
		return queryEngine.getExample(key);
	}

	@Override
	public List<String> getQueryEngineExampleKeys(Long qeid) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getQueryEngineById(qeid);
		QueryEnginePlugin queryEngine = bimServer.getPluginManager().getQueryEngine(queryEngineById.getClassName(), true);
		return new ArrayList<String>(queryEngine.getExampleKeys());
	}

	private <T extends IdEObject> T find(List<T> list, long oid) {
		for (T t : list) {
			if (t.getOid() == oid) {
				return t;
			}
		}
		return null;
	}

	public SRenderEnginePluginConfiguration getDefaultRenderEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultRenderEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SQueryEnginePluginConfiguration getDefaultQueryEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultQueryEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelComparePluginConfiguration getDefaultModelCompare() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultModelCompare());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelMergerPluginConfiguration getDefaultModelMerger() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultModelMerger());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SSerializerPluginConfiguration getDefaultSerializer() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultSerializer());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return bimServer.getSConverter().convertToSObject(settings.getDefaultObjectIDM());
		} catch (BimserverDatabaseException e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultRenderEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultRenderEngine(find(userSettings.getRenderEngines(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultQueryEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultQueryEngine(find(userSettings.getQueryengines(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelCompare(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelCompare(find(userSettings.getModelcompares(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelMerger(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelMerger(find(userSettings.getModelmergers(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultSerializer(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultSerializer(find(userSettings.getSerializers(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultObjectIDM(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, accessMethod, authorization, new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultObjectIDM(find(userSettings.getObjectIDMs(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SServiceDescriptor getServiceDescriptor(String url) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			String content = NetUtils.getContent(new URL(url + "?doc"), 5000);
			JSONObject service = new JSONObject(new JSONTokener(content));
			SServiceDescriptor sServiceDescriptor = new SServiceDescriptor();
			sServiceDescriptor.setName(service.getString("name"));
			sServiceDescriptor.setIdentifier(service.getString("identifier"));
			sServiceDescriptor.setDescription(service.getString("description"));
			sServiceDescriptor.setNotificationProtocol(SAccessMethod.valueOf(service.getString("notificationProtocol")));
			sServiceDescriptor.setTrigger(STrigger.valueOf(service.getString("trigger")));
			sServiceDescriptor.setUrl(service.getString("url"));
			sServiceDescriptor.setProviderName(service.getString("providerName"));

			JSONObject rights = service.getJSONObject("rights");

			sServiceDescriptor.setReadRevision(rights.getBoolean("readRevision"));
			sServiceDescriptor.setReadExtendedData(rights.getString("readExtendedData"));
			sServiceDescriptor.setWriteRevision(rights.getBoolean("writeRevision"));
			sServiceDescriptor.setWriteExtendedData(rights.getString("writeExtendedData"));
			return sServiceDescriptor;
		} catch (MalformedURLException e) {
			throw new UserException("Invalid URL");
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SServiceDescriptor> getAllLocalServiceDescriptors() throws ServerException, UserException {
		return bimServer.getSConverter().convertToSListServiceDescriptor(bimServer.getNotificationsManager().getInternalServices().values());
	}
	
	@Override
	public List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SServiceDescriptor> sServiceDescriptors = new ArrayList<SServiceDescriptor>();
			URL url = new URL(getServiceRepositoryUrl() + "/services");
			String content = NetUtils.getContent(url, 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray services = root.getJSONArray("services");
			for (int i = 0; i < services.length(); i++) {
				JSONObject service = services.getJSONObject(i);
				SServiceDescriptor sServiceDescriptor = new SServiceDescriptor();
				sServiceDescriptor.setName(service.getString("name"));
				sServiceDescriptor.setIdentifier(service.getString("identifier"));
				sServiceDescriptor.setDescription(service.getString("description"));
				sServiceDescriptor.setNotificationProtocol(SAccessMethod.valueOf(service.getString("notificationProtocol")));
				sServiceDescriptor.setTrigger(STrigger.valueOf(service.getString("trigger")));
				sServiceDescriptor.setUrl(service.getString("url"));
				sServiceDescriptor.setProviderName(service.getString("providerName"));

				JSONObject rights = service.getJSONObject("rights");

				sServiceDescriptor.setReadRevision(rights.has("readRevision") && rights.getBoolean("readRevision"));
				sServiceDescriptor.setReadExtendedData(rights.has("readExtendedData") ? rights.getString("readExtendedData") : null);
				sServiceDescriptor.setWriteRevision(rights.has("writeRevision") && rights.getBoolean("writeRevision"));
				sServiceDescriptor.setWriteExtendedData(rights.has("writeExtendedData") ? rights.getString("writeExtendedData") : null);
				sServiceDescriptors.add(sServiceDescriptor);
			}
			return sServiceDescriptors;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SExtendedDataSchema> extendedDataSchemas = new ArrayList<SExtendedDataSchema>();
			String content = NetUtils.getContent(new URL(getServiceRepositoryUrl() + "/extendeddataschemas"), 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray extendedDataSchemasJson = root.getJSONArray("extendeddataschemas");
			for (int i = 0; i < extendedDataSchemasJson.length(); i++) {
				JSONObject extendedDataSchemaJson = extendedDataSchemasJson.getJSONObject(i);
				
				SExtendedDataSchema sExtendedDataSchema = new SExtendedDataSchema();
				sExtendedDataSchema.setName(extendedDataSchemaJson.getString("name"));
				sExtendedDataSchema.setNamespace(extendedDataSchemaJson.getString("namespace"));
				sExtendedDataSchema.setUrl(extendedDataSchemaJson.getString("url"));
				sExtendedDataSchema.setDescription(extendedDataSchemaJson.getString("description"));
				sExtendedDataSchema.setType(SExtendedDataSchemaType.valueOf(extendedDataSchemaJson.getString("type")));

				extendedDataSchemas.add(sExtendedDataSchema);
			}
			return extendedDataSchemas;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	public org.bimserver.interfaces.objects.SService getService(Long soid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			org.bimserver.models.store.Service externalProfile = session.get(StorePackage.eINSTANCE.getService(), soid, Query.getDefault());
			return bimServer.getSConverter().convertToSObject(externalProfile);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addLocalServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService, Long internalServiceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AddLocalServiceToProjectDatabaseAction action = new AddLocalServiceToProjectDatabaseAction(session, accessMethod, poid, bimServer.getSConverter().convertFromSObject(sService, session), internalServiceOid, authorization);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void addServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AddServiceToProjectDatabaseAction action = new AddServiceToProjectDatabaseAction(session, accessMethod, poid, bimServer.getSConverter().convertFromSObject(sService, session), authorization);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SServiceInterface> getServiceInterfaces() throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SServiceInterface> sServiceInterfaces = new ArrayList<SServiceInterface>();
		for (String name : bimServer.getServicesMap().keySetName()) {
			SServiceInterface sServiceInterface = new SServiceInterface();
			sServiceInterface.setName(name);
			sServiceInterfaces.add(sServiceInterface);
		}
		return sServiceInterfaces;
	}

	@Override
	public List<SServiceMethod> getServiceMethods(String serviceInterfaceName) throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SServiceMethod> sServiceMethods = new ArrayList<SServiceMethod>();
		SService sService = bimServer.getServicesMap().getByName(serviceInterfaceName);
		if (sService == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		for (SMethod sMethod : sService.getMethods()) {
			SServiceMethod sServiceMethod = new SServiceMethod();
			sServiceMethod.setName(sMethod.getName());
			sServiceMethod.setDoc(sMethod.getDoc());
			sServiceMethod.setReturnDoc(sMethod.getReturnDoc());
			// sServiceMethod.setReturnType(sMethod.getReturnType().getName());
			sServiceMethods.add(sServiceMethod);
		}
		return sServiceMethods;
	}

	@Override
	public List<SServiceType> getServiceTypes(String serviceInterfaceName) throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SServiceType> sServiceTypes = new ArrayList<SServiceType>();
		SService serviceInterface = bimServer.getServicesMap().getByName(serviceInterfaceName);
		if (serviceInterface == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		for (SClass sType : serviceInterface.getTypes()) {
			SServiceType sServiceType = new SServiceType();
			sServiceType.setName(sType.getName());
			sServiceTypes.add(sServiceType);
		}
		return sServiceTypes;
	}

	// TODO Recursion to same type will result in endless loop
	public SServiceType createSServiceType(SClass sClass) throws UserException, ServerException {
		requireRealUserAuthentication();
		if (sClass == null) {
			return null;
		}
		SServiceType sServiceType = new SServiceType();
		sServiceType.setName(sClass.getName());
		sServiceType.setSimpleName(sClass.getSimpleName());
		for (SField field : sClass.getAllFields()) {
			SServiceField sServiceField = new SServiceField();
			sServiceField.setName(field.getName());
			sServiceField.setType(createSServiceType(field.getType()));
			sServiceField.setGenericType(createSServiceType(field.getGenericType()));
			sServiceField.setDoc(field.getDoc());
			sServiceType.getFields().add(sServiceField);
		}
		return sServiceType;
	}

	@Override
	public List<SServiceParameter> getServiceMethodParameters(String serviceInterfaceName, String serviceMethodName) throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SServiceParameter> sServiceParameters = new ArrayList<SServiceParameter>();
		SService serviceInterface = bimServer.getServicesMap().getByName(serviceInterfaceName);
		if (serviceInterface == null) {
			throw new UserException("Service \"" + serviceInterfaceName + "\" not found");
		}
		SMethod sMethod = serviceInterface.getSMethod(serviceMethodName);
		if (sMethod == null) {
			throw new UserException("Method \"" + serviceMethodName + "\" not found in \"" + serviceInterfaceName + "\"");
		}
		for (SParameter sParameter : sMethod.getParameters()) {
			SServiceParameter sServiceParameter = new SServiceParameter();
			sServiceParameter.setName(sParameter.getName());
			sServiceParameter.setDoc(sParameter.getDoc());
			sServiceParameter.setType(createSServiceType(sParameter.getType()));
			sServiceParameter.setGenericType(createSServiceType(sParameter.getGenericType()));
			sServiceParameters.add(sServiceParameter);
		}
		return sServiceParameters;
	}

	@Override
	public void deleteService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteServiceDatabaseAction(session, accessMethod, oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public SExtendedDataSchema getExtendedDataSchemaByNamespace(String nameSpace) throws UserException, ServerException {
		// Not checking for real authentication here because a remote service should be able to use an exs
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByNamespaceDatabaseAction(session, accessMethod, nameSpace)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SInternalServicePluginConfiguration getInternalServiceById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SInternalServicePluginConfiguration convertToSObject = bimServer.getSConverter().convertToSObject(session.executeAndCommitAction(new GetByIdDatabaseAction<InternalServicePluginConfiguration>(session, accessMethod, oid, StorePackage.eINSTANCE.getInternalServicePluginConfiguration())));
			return convertToSObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			InternalServicePluginConfiguration convertFromSObject = bimServer.getSConverter().convertFromSObject(internalService, session);
			session.executeAndCommitAction(new UpdateDatabaseAction<InternalServicePluginConfiguration>(session, accessMethod, convertFromSObject));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddInternalServiceDatabaseAction(session, accessMethod, authorization, bimServer.getSConverter().convertFromSObject(internalService, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteInternalService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			session.executeAndCommitAction(new DeleteInternalServiceDatabaseAction(session, accessMethod, oid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SInternalServicePluginConfiguration> getAllInternalServices(Boolean onlyEnabled) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings userSettings = getUserSettings(session);
			EList<InternalServicePluginConfiguration> services2 = userSettings.getServices();
			List<SInternalServicePluginConfiguration> services = bimServer.getSConverter().convertToSListInternalServicePluginConfiguration(services2);
			Collections.sort(services, new SPluginConfigurationComparator());
			return services;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

//	public void registerAll(Long endPointId) throws ServerException, UserException {
//		requireAuthentication();
//		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
//		if (getCurrentUser() == null) {
//			bimServer.getNotificationsManager().register(-1, endPoint);
//		} else {
//			bimServer.getNotificationsManager().register(getCurrentUser().getOid(), endPoint);
//		}
//	}
	
	@Override
	public List<SProfileDescriptor> getAllPublicProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, bimServer.getServicesMap(), bimServer.getJsonSocketReflectorFactory(), bimServer.getReflectorFactory());
			BimServerClient client = factory.create();
			return client.getRemoteServiceInterface().getPublicProfiles(serviceIdentifier);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllPrivateProfiles(String notificationsUrl, String serviceIdentifier, String token) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, bimServer.getServicesMap(), bimServer.getJsonSocketReflectorFactory(), bimServer.getReflectorFactory());
			BimServerClient client = factory.create();
			return client.getRemoteServiceInterface().getPrivateProfiles(serviceIdentifier, token);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllLocalProfiles(String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		List<SProfileDescriptor> descriptors = new ArrayList<SProfileDescriptor>();
		try {
			SUser currentUser = getCurrentUser();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(currentUser.getToken()));
			User user = session.querySingle(condition, User.class, Query.getDefault());
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					if (internalServicePluginConfiguration.getClassName().equals(serviceIdentifier)) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);
						
						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return descriptors;
	}

	@Override
	public SObjectDefinition getPluginObjectDefinition(String className) throws ServerException, UserException {
		return bimServer.getSConverter().convertToSObject(bimServer.getPluginManager().getPlugin(className, false).getSettingsDefinition());
	}

	public SObjectType getPluginSettings(Long poid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, Query.getDefault());
			ObjectType settings = pluginConfiguration.getSettings();
			return bimServer.getSConverter().convertToSObject(settings);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setPluginSettings(Long poid, SObjectType settings) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ObjectType convertedSettings = bimServer.getSConverter().convertFromSObject(settings, session);
			SetPluginSettingsDatabaseAction action = new SetPluginSettingsDatabaseAction(session, accessMethod, poid, convertedSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	@WebMethod(action = "getServerSettings")
	public SServerSettings getServerSettings() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), Query.getDefault());
			return bimServer.getSConverter().convertToSObject(allOfType.getAll(ServerSettings.class).get(0));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SExtendedDataSchema getExtendedDataSchemaFromRepository(String namespace) throws UserException, ServerException {
		requireRealUserAuthentication();
		try {
			String content = NetUtils.getContent(new URL(getServiceRepositoryUrl() + "/extendeddataschemas?namespace=" + namespace), 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			SExtendedDataSchema sExtendedDataSchema = new SExtendedDataSchema();
			sExtendedDataSchema.setName(root.getString("name"));
			sExtendedDataSchema.setNamespace(root.getString("namespace"));
			sExtendedDataSchema.setUrl(root.getString("url"));
			sExtendedDataSchema.setType(SExtendedDataSchemaType.valueOf(root.getString("type")));
			return sExtendedDataSchema;
		} catch (Exception e) {
			return handleException(e);
		}
	}
	
	@Override
	public List<SExtendedData> getAllExtendedDataOfRevision(Long roid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			return bimServer.getSConverter().convertToSListExtendedData(revision.getExtendedData());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SFile getFile(Long fileId) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			org.bimserver.models.store.File file = (org.bimserver.models.store.File)session.get(StorePackage.eINSTANCE.getFile(), fileId, Query.getDefault());
			return bimServer.getSConverter().convertToSObject(file);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long uploadFile(SFile file) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			org.bimserver.models.store.File convertFromSObject = bimServer.getSConverter().convertFromSObject(file, session);
			UploadFileDatabaseAction action = new UploadFileDatabaseAction(session, accessMethod, convertFromSObject);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void triggerNewExtendedData(Long edid, Long soid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
//			org.bimserver.models.store.Service service = (org.bimserver.models.store.Service)session.get(StorePackage.eINSTANCE.getService(), soid, Query.getDefault());
			ExtendedData extendedData = (ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), edid, Query.getDefault());
			SExtendedDataAddedToRevision newExtendedData = new SExtendedDataAddedToRevision();
			newExtendedData.setRevisionId(extendedData.getRevision().getOid());
			newExtendedData.setExtendedDataId(edid);
			bimServer.getNotificationsManager().notify(new NewExtendedDataNotification(edid, soid));
//			bimServer.getNotificationsManager().triggerNewRevision(bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), newExtendedData, extendedData.getRevision().getProject(), extendedData.getRevision().getOid(), Trigger.NEW_EXTENDED_DATA, service);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void triggerNewRevision(Long roid, Long soid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
//			org.bimserver.models.store.Service service = (org.bimserver.models.store.Service)session.get(StorePackage.eINSTANCE.getService(), soid, Query.getDefault());
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			SNewRevisionAdded newRevisionNotification = new SNewRevisionAdded();
			newRevisionNotification.setRevisionId(revision.getOid());
			newRevisionNotification.setProjectId(revision.getProject().getOid());
			
			bimServer.getNotificationsManager().notify(new NewRevisionNotification(revision.getProject().getOid(), revision.getOid()));
//			bimServer.getNotificationsManager().triggerNewRevision(bimServer.getServerSettingsCache().getServerSettings().getSiteAddress(), newRevisionNotification, revision.getProject(), roid, Trigger.NEW_REVISION, service);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void externalServiceUpdate(String uuid, SRemoteServiceUpdate sExternalServiceUpdate) throws ServerException, UserException {
//		RunningExternalService runningExternalService = bimServer.getRunningServicesManager().getRunningExternalService(uuid);
//		if (sExternalServiceUpdate instanceof SPercentageChange) {
//			SPercentageChange sPercentageChange = (SPercentageChange)sExternalServiceUpdate;
//			runningExternalService.updatePercentage(sPercentageChange.getPercentage());
//		}
	}
	
	@Override
	public void setWhiteListedDomains(final List<String> domains) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, accessMethod, new ServerSettingsSetter() {
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.getWhitelistedDomains().clear();
					serverSettings.getWhitelistedDomains().addAll(domains);
				}
			});
			session.executeAndCommitAction(action);
			bimServer.getServerSettingsCache().updateCache();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setServerSettings(SServerSettings serverSettings) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetServerSettingsDatabaseAction action = new SetServerSettingsDatabaseAction(session, accessMethod, serverSettings);
			session.executeAndCommitAction(action);
			bimServer.getServerSettingsCache().updateCache();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Integer clearOutputFileCache() {
		return bimServer.getDiskCacheManager().cleanup();
	}

	@Override
	public SSystemInfo getSystemInfo() {
		SSystemInfo systemInfo = new SSystemInfo();
		systemInfo.setCpucores(Runtime.getRuntime().availableProcessors());
		systemInfo.setDatetime(new GregorianCalendar().getTime());
		systemInfo.setOsname(System.getProperty("os.name"));
		systemInfo.setOsversion(System.getProperty("os.version"));
		systemInfo.setUserName(System.getProperty("user.name"));
		systemInfo.setUserHome(System.getProperty("user.home"));
		systemInfo.setUserDir(System.getProperty("user.dir"));
		return systemInfo;
	}

	@Override
	public SJavaInfo getJavaInfo() {
		SJavaInfo javaInfo = new SJavaInfo();
		javaInfo.setHeapTotal(Runtime.getRuntime().totalMemory());
		javaInfo.setHeapUsed(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		javaInfo.setHeapFree(Runtime.getRuntime().freeMemory());
		javaInfo.setHeapMax(Runtime.getRuntime().maxMemory());
		javaInfo.setThreads(Thread.activeCount());
		javaInfo.setJavaHome(System.getProperty("java.home"));
		javaInfo.setJavaVersion(System.getProperty("java.version"));
		javaInfo.setJavaVendor(System.getProperty("java.vendor"));
		javaInfo.setJavaVendorurl(System.getProperty("java.vendor.url"));
		javaInfo.setJavavmVersion(System.getProperty("java.vm.version"));
		javaInfo.setJavavmVendor(System.getProperty("java.vm.vendor"));
		javaInfo.setJavavmName(System.getProperty("java.vm.name"));
		javaInfo.setJavaspecVersion(System.getProperty("java.specification.version"));
		javaInfo.setJavaspecVendor(System.getProperty("java.specification.vendor"));
		javaInfo.setJavaspecName(System.getProperty("java.specification.name"));
		javaInfo.setJavaClassVersion(System.getProperty("java.class.version"));
		
		for (String classp : System.getProperty("java.class.path").split(File.pathSeparator)) {
			javaInfo.getJavaClasspath().add(classp);
		}
		for (String classp : System.getProperty("java.library.path").split(File.pathSeparator)) {
			javaInfo.getJavaLibrarypath().add(classp);
		}
		javaInfo.setJavaIoTmp(System.getProperty("java.io.tmpdir"));
		javaInfo.setJavaCompiler(System.getProperty("java.compiler"));
		javaInfo.setJavaExtdir(System.getProperty("java.ext.dirs"));
		javaInfo.setJavaFileSeparator(System.getProperty("file.separator"));
		javaInfo.setJavaPathSeparator(System.getProperty("path.separator"));
		javaInfo.setJavaLineSeparator(System.getProperty("line.separator"));
		
		return javaInfo;
	}

	@Override
	public SBimServerInfo getBimServerInfo() throws ServerException, UserException {
		SBimServerInfo bimServerInfo = new SBimServerInfo();
		SVersion version = bimServer.getVersionChecker().getLocalVersion();
		SVersion latestVersion = bimServer.getVersionChecker().getOnlineVersion();
		
		SDatabaseInformation databaseInformation = getDatabaseInformation();
		
		bimServerInfo.setCurrentVersion(version.getMajor() + "." + version.getMinor() + "." + version.getRevision());
		bimServerInfo.setCurrentDate(version.getDate());
		bimServerInfo.setLatestVersion(latestVersion.getMajor() + "." + latestVersion.getMinor() + "." + latestVersion.getRevision());
		bimServerInfo.setLatestDate(latestVersion.getDate());
		bimServerInfo.setCheckouts(databaseInformation.getNumberOfCheckouts());
		bimServerInfo.setRevisions(databaseInformation.getNumberOfRevisions());
		bimServerInfo.setUsers(databaseInformation.getNumberOfUsers());
		bimServerInfo.setProjects(databaseInformation.getNumberOfProjects());
		bimServerInfo.setSchemaVersion(databaseInformation.getSchemaVersion());
		bimServerInfo.setServerLogUrl(bimServer.getServerSettingsCache().getServerSettings().getSiteAddress() + "/download?action=getfile&file=serverlog");
		bimServerInfo.setStarted(getServerStartTime());
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(getServerStartTime());
		bimServerInfo.setUptime(Formatters.timeSpanToString(gc, new GregorianCalendar()));
		
		return bimServerInfo;
	}

	@Override
	public String shareRevision(Long roid) {
		ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(roid, -1, -1, -1);
		return authorization.asHexToken(bimServer.getEncryptionKey());
	}
	
	public Integer count(Long roid, String className) throws UserException ,ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			CountDatabaseAction action = new CountDatabaseAction(session, accessMethod, roid, className, authorization);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUserSettings getUserSettings() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
			return bimServer.getSConverter().convertToSObject(user.getUserSettings());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void registerProgressHandler(Long topicId, Long endPointId) throws UserException {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = bimServer.getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic == null) {
			throw new UserException("Topic with id " + topicId + " not found");
		}
		try {
			progressTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			throw new UserException(e);
		}
	}
	
	@Override
	public void unregisterProgressHandler(Long topicId, Long endPointId) throws UserException, ServerException {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = bimServer.getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic == null) {
			throw new UserException("Topic with id " + topicId + " not found");
		}
		try {
			progressTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void updateProgressTopic(Long topicId, SLongActionState state) throws UserException, ServerException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			bimServer.getNotificationsManager().getProgressTopic(topicId).updateProgress(bimServer.getSConverter().convertFromSObject(state, session));
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void registerNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = bimServer.getNotificationsManager().getOrCreateNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
		try {
			newRevisionOnSpecificProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void unregisterNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) throws ServerException, UserException {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			bimServer.getNotificationsManager().getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid)).unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public Long registerProgressTopic(SProgressTopicType type, String description) throws UserException, ServerException {
		return bimServer.getNotificationsManager().createProgressTopic(getCurrentUser().getOid(), type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnRevisionTopic(SProgressTopicType type, Long poid, Long roid, String description) throws UserException, ServerException {
		return bimServer.getNotificationsManager().createProgressOnRevisionTopic(getCurrentUser().getOid(), poid, roid, type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnProjectTopic(SProgressTopicType type, Long poid, String description) throws UserException, ServerException {
		return bimServer.getNotificationsManager().createProgressOnProjectTopic(getCurrentUser().getOid(), poid, type, description).getKey().getId();
	}

	@Override
	public void unregisterProgressTopic(Long topicId) {
		bimServer.getNotificationsManager().unregister(topicId);
	}

	@Override
	public void registerNewProjectHandler(Long endPointId) {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			bimServer.getNotificationsManager().getNewProjectTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewProjectHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			bimServer.getNotificationsManager().getNewProjectTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void registerNewUserHandler(Long endPointId) {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			bimServer.getNotificationsManager().getNewUserTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewUserHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			bimServer.getNotificationsManager().getNewUserTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public List<Long> getProgressTopicsOnProject(Long poid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<Long> list = new ArrayList<Long>();
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			List<Long> revisionOids = new ArrayList<Long>();
			for (Revision revision : project.getRevisions()) {
				revisionOids.add(revision.getOid());
			}
			Set<ProgressTopic> progressOnProjectTopics = bimServer.getNotificationsManager().getProgressOnProjectTopics(poid, revisionOids);
			if (progressOnProjectTopics != null) {
				for (ProgressTopic topic : progressOnProjectTopics) {
					list.add(topic.getKey().getId());
				}
			}
			return list;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Long> getProgressTopicsOnRevision(Long poid, Long roid) {
		List<Long> list = new ArrayList<Long>();
		for (ProgressOnRevisionTopic topic : bimServer.getNotificationsManager().getProgressOnRevisionTopics(poid, roid)) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public List<Long> getProgressTopicsOnServer() {
		List<Long> list = new ArrayList<Long>();
		for (ProgressTopic topic : bimServer.getNotificationsManager().getProgressOnServerTopics()) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public SLongActionState getProgress(Long topicId) throws UserException, ServerException {
		ProgressTopic progressTopic = bimServer.getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic != null) {
			return bimServer.getSConverter().convertToSObject(progressTopic.getLastProgress());
		}
		return null;
	}
	
	@Override
	public void registerChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = bimServer.getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void registerChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = bimServer.getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = bimServer.getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = bimServer.getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
}