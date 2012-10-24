package org.bimserver.webservices;

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
import java.util.LinkedHashSet;
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
import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveAttributeChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.RemoveReferenceChange;
import org.bimserver.changes.SetAttributeChange;
import org.bimserver.changes.SetReferenceChange;
import org.bimserver.client.BimServerClient;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
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
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SCheckinResult;
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
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SExtendedDataSchemaType;
import org.bimserver.interfaces.objects.SExternalServiceUpdate;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
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
import org.bimserver.interfaces.objects.SPercentageChange;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
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
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.interfaces.objects.STrigger;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSession;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.IfcEnginePluginConfiguration;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.UserType;
import org.bimserver.notifications.RunningExternalService;
import org.bimserver.notifications.TokenAuthorization;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.servlets.EndPoint;
import org.bimserver.shared.compare.CompareWriter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.utils.MultiplexingInputStream;
import org.bimserver.utils.NetUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
	private final PublicInterfaceFactory serviceFactory;
	private final SConverter converter = new SConverter();

	private final BimServer bimServer;
	private final AccessMethod accessMethod;
	private final String remoteAddress;
	private Set<Change> changes = null;

	private Authorization authorization;

	private Date activeSince;
	private Date lastActive;
	private SToken token;
	private long transactionPoid;

	public Service(BimServer bimServer, AccessMethod accessMethod, String remoteAddress, PublicInterfaceFactory serviceFactory, SToken token) {
		this.accessMethod = accessMethod;
		this.remoteAddress = remoteAddress;
		this.serviceFactory = serviceFactory;
		this.bimServer = bimServer;
		this.token = token;
		activeSince = new Date();
		lastActive = new Date();
	}

	@Override
	public Long checkin(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge, Boolean sync)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
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
				DeserializerPluginConfiguration deserializerObject = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, false, null);
				if (deserializerObject == null) {
					throw new UserException("Deserializer with oid " + deserializerOid + " not found");
				}
				Deserializer deserializer = bimServer.getEmfDeserializerFactory().createDeserializer(deserializerObject.getClassName());
				try {
					deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, true, fileSize);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(bimServer, null, accessMethod, poid, authorization, model, comment, merge, true);
				LongCheckinAction longAction = new LongCheckinAction(bimServer, username, userUsername, authorization, checkinDatabaseAction);
				bimServer.getLongActionManager().start(longAction);
				if (sync) {
					longAction.waitForCompletion();
				}
				return longAction.getId();
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
	public SCheckinResult getCheckinState(Long actionId) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			LongCheckinAction longAction = (LongCheckinAction) bimServer.getLongActionManager().getLongAction(actionId);
			if (longAction != null) {
				return converter.convertToSObject(longAction.getCheckinResult());
			} else {
				throw new UserException("No state found for laid " + actionId);
			}
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			throw new UserException(e);
		}
	}

	@Override
	public Long checkoutLastRevision(Long poid, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
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
		org.bimserver.plugins.serializers.Serializer serializer = bimServer.getEmfSerializerFactory().get(serializerOid);
		if (serializer == null) {
			throw new UserException("No serializer with id " + serializerOid + " could be found");
		}
		if (!serializer.getClass().getSimpleName().equals("IfcStepSerializer") && !serializer.getClass().getSimpleName().equals("IfcXmlSerializer")) {
			throw new UserException("Only IFC or IFCXML allowed when checking out");
		}
		DownloadParameters downloadParameters = new DownloadParameters(bimServer, roid, serializerOid, -1);
		DatabaseSession session = bimServer.getDatabase().createSession();
		User user = null;
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(bimServer, user.getName(), user.getUsername(), downloadParameters, authorization, accessMethod);
		try {
			bimServer.getLongActionManager().start(longDownloadAction);
		} catch (CannotBeScheduledException e) {
			LOGGER.error("", e);
		}
		if (sync) {
			longDownloadAction.waitForCompletion();
		}
		return longDownloadAction.getId();
	}

	private UserSettings getUserSettings(DatabaseSession session) throws BimserverLockConflictException, BimserverDatabaseException {
		User user = session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
		return user.getUserSettings();
	}

	private ServerSettings getServerSettings(DatabaseSession session) throws BimserverDatabaseException {
		IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), false, null);
		List<ServerSettings> settingsList = allOfType.getAll(ServerSettings.class);
		if (settingsList.size() == 1) {
			ServerSettings settings = settingsList.get(0);
			return settings;
		}
		return null;
	}

	@Override
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			if (!selfRegistration) {
				requireRealUserAuthentication();
			} else if (!getServerSettings(session).getAllowSelfRegistration()) {
				requireSelfregistrationAllowed();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(bimServer, session, accessMethod, username, name, converter.convertFromSObject(type), authorization,
					selfRegistration);
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			List<SProject> convertToSListProject = converter.convertToSListProject(session.executeAndCommitAction(action));
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

	private void updateLastActive() {
		lastActive = new Date();
	}

	private void requireRunningServer() throws UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.RUNNING) {
			throw new UserException("Call cannot be executed because the server is in " + bimServer.getServerInfo().getServerState() + " mode");
		}
	}

	private void requireAuthentication() throws UserException {
		updateLastActive();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
	}
	
	private void requireRealUserAuthentication() throws UserException {
		requireRunningServer();
		updateLastActive();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (authorization instanceof TokenAuthorization) {
			throw new UserException("Real authentication required (this session has token authentication)");
		}
	}

	private void requireAdminAuthentication() throws UserException {
		updateLastActive();
		if (authorization == null) {
			throw new UserException("Authentication required for this call");
		}
		if (authorization instanceof UserAuthorization) {
			UserType userType = ((UserAuthorization) authorization).getUserType();
			if (userType != UserType.ADMIN && userType != UserType.SYSTEM) {
				throw new UserException("Administrator rights required for this call");
			}
		} else {
			throw new UserException("Administrator rights required for this call");
		}
	}

	private void requireSelfregistrationAllowed() throws UserException {
		updateLastActive();
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
			List<SRevision> convertToSListRevision = converter.convertToSListRevision(session.executeAndCommitAction(action));
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
			List<org.bimserver.interfaces.objects.SService> convertToSListRevision = converter.convertToSListService(session.executeAndCommitAction(action));
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
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
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
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
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
			List<SUser> convertToSListUser = converter.convertToSListUser(session.executeAndCommitAction(action));
			Collections.sort(convertToSListUser, new SUserComparator());
			return convertToSListUser;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SToken login(String username, String password) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LoginDatabaseAction loginDatabaseAction = new LoginDatabaseAction(session, this, accessMethod, username, password);
			Boolean result = session.executeAndCommitAction(loginDatabaseAction);
			if (result) {
				return getCurrentToken();
			} else {
				return null;
			}
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
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
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
			List<SRevision> convertToSListRevision = converter.convertToSListRevision(session.executeAndCommitAction(action));
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public Long download(Long roid, Long serializerOid, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, serializerOid, showOwn ? -1 : authorization.getUoid()), sync);
	}

	@Override
	public Long downloadCompareResults(Long serializerOid, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromCompare(roid1, roid2, converter.convertFromSObject(type), mcid, serializerOid), sync);
	}

	private Long download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		User user = null;
		for (long roid : downloadParameters.getRoids()) {
			authorization.canDownload(roid);
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(bimServer, user.getName(), user.getUsername(), downloadParameters, authorization, accessMethod);
		try {
			bimServer.getLongActionManager().start(longDownloadAction);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		if (sync) {
			longDownloadAction.waitForCompletion();
		}
		return longDownloadAction.getId();
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
	public SLongActionState getDownloadState(Long actionId) throws ServerException, UserException {
		Object longAction2 = bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction2 != null) {
			LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) longAction2;
			LongActionState state = longAction.getState();
			return converter.convertToSObject(state);
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
	public Long downloadByOids(Set<Long> roids, Set<Long> oids, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromOids(bimServer, serializerOid, roids, oids), sync);
	}

	@Override
	public Long downloadByTypes(Set<Long> roids, Set<String> classNames, Long serializerOid, Boolean includeAllSubtypes, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromClassNames(bimServer, roids, classNames, includeAllSubtypes, serializerOid), sync);
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long downloadByGuids(Set<Long> roids, Set<String> guids, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromGuids(bimServer, roids, guids, serializerOid), sync);
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
			return converter.convertToSListProject(session.executeAndCommitAction(action));
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
			SUser convert = converter.convertToSObject(session.executeAndCommitAction(action));
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

	/*
	 * Do not add this method to the ServiceInterface, it will allow everyone to
	 * login as system
	 */
	public Boolean loginAsSystem() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, "system");
			User user = session.executeAndCommitAction(action);
			if (user != null) {
				authorization = new UserAuthorization(user);
				return true;
			} else {
				return false;
			}
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(bimServer, session, accessMethod, authorization, roid1, roid2,
					converter.convertFromSObject(sCompareType), mcid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, accessMethod, roid);
			RevisionSummary revisionSummary = session.executeAndCommitAction(action);
			return converter.convertToSObject(revisionSummary);
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
			SDataObject dataObject = converter.convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
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
			SDataObject dataObject = converter.convertToSObject(session.executeAndCommitAction(action));
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
			return converter.convertToSListDataObject(dataObjects);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckinResult branchToNewProject(Long roid, String projectName, String comment) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, accessMethod, bimServer, authorization, roid, projectName, comment);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckinResult branchToExistingProject(Long roid, Long destPoid, String comment) throws UserException, ServerException {
		requireRealUserAuthentication();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, accessMethod, bimServer, authorization, roid, destPoid, comment);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
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
			List<SLogAction> convertToSListLogAction = converter.convertToSListLogAction(logs);
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String ping(String in) {
		return in;
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(converter.convertToSSetUser((session.executeAndCommitAction(action))));
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
			return new ArrayList<SUser>(converter.convertToSSetUser(session.executeAndCommitAction(action)));
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
			return converter.convertToSListProject(session.executeAndCommitAction(action));
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
			return (List<SProject>) converter.convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SToken autologin(String username, String hash) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AutologinDatabaseAction action = new AutologinDatabaseAction(session, this, accessMethod, username, hash);
			Boolean result = session.executeAndCommitAction(action);
			if (result) {
				return getCurrentToken();
			} else {
				return null;
			}
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
			List<SProject> convertToSListProject = converter.convertToSListProject(session.executeAndCommitAction(action));
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
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
			return converter.convertToSObject(user);
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
			User user = session.get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), false, null);
			return converter.convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void close() {
		serviceFactory.remove(token);
	}

	@Override
	public Boolean isLoggedIn() {
		return authorization != null;
	}

	@Override
	public String getSettingCustomLogoAddress() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getCustomLogoAddress();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingCustomLogoAddress(String customLogoAddress) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setCustomLogoAddress(customLogoAddress);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingEmailSenderAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getEmailSenderAddress();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getServiceRepositoryUrl() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getServiceRepositoryUrl();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setServiceRepositoryUrl(String url) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setServiceRepositoryUrl(url);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingProtocolBuffersPort(Integer port) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setProtocolBuffersPort(port);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Integer getSettingProtocolBuffersPort() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getProtocolBuffersPort();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingEmailSenderAddress(String emailSenderAddress) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (emailSenderAddress.trim().isEmpty()) {
			throw new UserException("Email sender address cannot be empty");
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setEmailSenderAddress(emailSenderAddress);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingRegistrationAddition() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getRegistrationAddition();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingRegistrationAddition(String registrationAddition) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setRegistrationAddition(registrationAddition);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingSiteAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getSiteAddress();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingSiteAddress(String siteAddress) throws ServerException, UserException {
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
			ServerSettings settings = getServerSettings(session);
			settings.setSiteAddress(siteAddress);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingSmtpServer() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getSmtpServer();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingSmtpServer(String smtpServer) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (smtpServer.trim().isEmpty()) {
			throw new UserException("SMTP server address cannot be empty");
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setSmtpServer(smtpServer);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingAllowSelfRegistration() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getAllowSelfRegistration();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingHideUserListForNonAdmin() throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getHideUserListForNonAdmin();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingHideUserListForNonAdmin(Boolean hideUserListForNonAdmin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setHideUserListForNonAdmin(hideUserListForNonAdmin);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingAllowSelfRegistration(Boolean allowSelfRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setAllowSelfRegistration(allowSelfRegistration);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.isAllowUsersToCreateTopLevelProjects();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingAllowUsersToCreateTopLevelProjects(Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingCheckinMergingEnabled() throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getCheckinMergingEnabled();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingCheckinMergingEnabled(Boolean checkinMergingEnabled) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setCheckinMergingEnabled(checkinMergingEnabled);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.isSendConfirmationEmailAfterRegistration();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingSendConfirmationEmailAfterRegistration(Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingShowVersionUpgradeAvailable() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getShowVersionUpgradeAvailable();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingShowVersionUpgradeAvailable(Boolean showVersionUpgradeAvailable) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setShowVersionUpgradeAvailable(showVersionUpgradeAvailable);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSettingCacheOutputFiles() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getCacheOutputFiles();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingCacheOutputFiles(Boolean cacheOutputFiles) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setCacheOutputFiles(cacheOutputFiles);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUserSession> getActiveUserSessions() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return serviceFactory.getActiveUserSessions();
	}

	@Override
	public Date getActiveSince() {
		return activeSince;
	}

	@Override
	public Date getLastActive() {
		return lastActive;
	}

	@Override
	public SToken getCurrentToken() {
		return token;
	}

	public void setToken(SToken token) {
		this.token = token;
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
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, false, null);
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, false, null);
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = getServerSettings(session).getEmailSenderAddress();
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
	public void requestPasswordChange(String username) throws ServerException, UserException {
		// No authentication required because you should be able to do this wihout logging in...
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(session, accessMethod, bimServer, username);
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
			return converter.convertToSObject(session.executeAndCommitAction(action));
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
			return converter.convertToSListLongAction(bimServer.getLongActionManager().getActiveLongActions());
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
			return converter.convertToSListProject(session.executeAndCommitAction(action));
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
		List<SMigration> list = new ArrayList<SMigration>(converter.convertToSSetMigration(migrator.getMigrations()));
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
			List<SSerializerPluginConfiguration> serializers = converter.convertToSListSerializerPluginConfiguration(getUserSettings(session).getSerializers());
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
			List<SDeserializerPluginConfiguration> deserializers = converter.convertToSListDeserializerPluginConfiguration(getUserSettings(session).getDeserializers());
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
			SerializerPluginConfiguration convert = converter.convertFromSObject(serializer, session);
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
			DeserializerPluginConfiguration convert = converter.convertFromSObject(deserializer, session);
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
			SerializerPluginConfiguration convert = converter.convertFromSObject(serializer, session);
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
			DeserializerPluginConfiguration convert = converter.convertFromSObject(deserializer, session);
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
			List<SObjectIDMPluginConfiguration> objectIdms = converter.convertToSListObjectIDMPluginConfiguration(getUserSettings(session).getObjectIDMs());
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
			session.executeAndCommitAction(new AddObjectIDMDatabaseAction(session, accessMethod, authorization, converter.convertFromSObject(objectIDM, session)));
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
			session.executeAndCommitAction(new UpdateObjectIDMDatabaseAction(session, accessMethod, converter.convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetSerializerByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetDeserializerByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetObjectIDMByIdDatabaseAction(session, accessMethod, oid)));
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
		return bimServer.getEmfSerializerFactory().getAllSerializerPluginDescriptors();
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
	public void setSettingFooterAddition(String footerAddition) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setFooterAddition(footerAddition);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingHeaderAddition(String headerAddition) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			settings.setHeaderAddition(headerAddition);
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingFooterAddition() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getFooterAddition();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSettingHeaderAddition() throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ServerSettings settings = getServerSettings(session);
			return settings.getHeaderAddition();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByName(String serializerName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetSerializerByNameDatabaseAction(session, accessMethod, serializerName)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetObjectIDMByNameDatabaseAction(session, accessMethod, ObjectIDMName)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetDeserializerByNameDatabaseAction(session, accessMethod, deserializerName)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetSerializerByContentTypeDatabaseAction(session, accessMethod, contentType)));
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
			SPluginDescriptor sPlugin = new SPluginDescriptor();
			sPlugin.setDefaultName(plugin.getClass().getName());
			PluginContext pluginContext = bimServer.getPluginManager().getPluginContext(plugin);
			sPlugin.setLocation(pluginContext.getLocation());
			sPlugin.setDescription(plugin.getDescription());
			sPlugin.setEnabled(pluginContext.isEnabled());
			result.add(sPlugin);
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
	public void startTransaction(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		changes = new LinkedHashSet<Change>();
		getProjectByPoid(poid); // Throws exception
		transactionPoid = poid;
	}

	@Override
	public Long commitTransaction(String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		DatabaseSession session = bimServer.getDatabase().createSession();
		CommitTransactionDatabaseAction action = new CommitTransactionDatabaseAction(bimServer, session, accessMethod, changes, authorization, transactionPoid, comment);
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
	public void abortTransaction() throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes = null;
	}

	@Override
	public void addStringAttribute(Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addDoubleAttribute(Long oid, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addBooleanAttribute(Long oid, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, attributeName, value));
	}

	@Override
	public void addReference(Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddReferenceChange(oid, referenceName, referenceOid));
	}

	@Override
	public Long createObject(String className) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		EClass eClass = ((Database) bimServer.getDatabase()).getEClassForName(className);
		Long oid = bimServer.getDatabase().newOid(eClass);
		CreateObjectChange createObject = new CreateObjectChange(className, oid);
		changes.add(createObject);
		return oid;
	}

	private void requireOpenTransaction() throws UserException {
		if (changes == null) {
			throw new UserException("No open transaction");
		}
	}

	@Override
	public void removeAttribute(Long oid, String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveAttributeChange(oid, attributeName, index));
	}

	@Override
	public void removeObject(Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveObjectChange(oid));
	}

	@Override
	public void removeReference(Long oid, String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveReferenceChange(oid, referenceName, index));
	}

	@Override
	public void setStringAttribute(Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getStringAttribute(Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(oid, attributeName);
	}
	
	@Override
	public void setIntegerAttribute(Long oid, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, value));
	}
	
	public Integer getIntegerAttribute(Long oid, String attributeName) throws ServerException ,UserException {
		requireAuthenticationAndRunningServer();
		return (Integer)getAttribute(oid, attributeName);
	};

	@Override
	public void setBooleanAttribute(Long oid, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Boolean getBooleanAttribute(Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (Boolean)getAttribute(oid, attributeName);
	}

	@Override
	public void setDoubleAttribute(Long oid, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public Double getDoubleAttribute(Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (Double)getAttribute(oid, attributeName);
	}

	private Object getAttribute(Long oid, String attributeName) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IdEObject object = session.get(session.getEClassForOid(oid), oid, false, null);
			return object.eGet(object.eClass().getEStructuralFeature(attributeName));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setEnumAttribute(Long oid, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, value));
	}
	
	@Override
	public String getEnumAttribute(Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(oid, attributeName);
	}

	@Override
	public void setReference(Long oid, String referenceName, Long referenceOid) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetReferenceChange(oid, referenceName, referenceOid));
	}
	
	@Override
	public Long getReference(Long oid, String referenceName) throws ServerException, UserException {
		IdEObject idEObject = (IdEObject) getAttribute(oid, referenceName);
		return idEObject.getOid();
	}

	@Override
	public void unsetAttribute(Long oid, String attributeName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, attributeName, null));
	}

	@Override
	public void unsetReference(Long oid, String referenceName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetReferenceChange(oid, referenceName, -1));
	}

	@Override
	public Date getServerStartTime() {
		return bimServer.getServerStartTime().getTime();
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getSerializerPluginDescriptor(type);
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
		return converter.convertToSObject(bimServer.getServerInfo());
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
			return converter.convertToSListDataObject(session.executeAndCommitAction(action));
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
	public List<SIfcEnginePluginDescriptor> getAllIfcEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getAllIfcEnginePluginDescriptors();
	}

	@Override
	public List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getAllQueryEnginePluginDescriptors();
	}

	@Override
	public List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getAllServicePluginDescriptors();
	}

	@Override
	public List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getAllModelComparePluginDescriptors();
	}

	@Override
	public List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return bimServer.getEmfSerializerFactory().getAllModelMergerPluginDescriptors();
	}

	@Override
	public List<SIfcEnginePluginConfiguration> getAllIfcEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SIfcEnginePluginConfiguration> ifcEngines = converter.convertToSListIfcEnginePluginConfiguration(getUserSettings(session).getIfcEngines());
			Collections.sort(ifcEngines, new SPluginConfigurationComparator());
			return ifcEngines;
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
			List<SQueryEnginePluginConfiguration> queryEngines = converter.convertToSListQueryEnginePluginConfiguration(getUserSettings(session).getQueryengines());
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
			List<SModelComparePluginConfiguration> modelCompares = converter.convertToSListModelComparePluginConfiguration(getUserSettings(session).getModelcompares());
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
			List<SModelMergerPluginConfiguration> modelMergers = converter.convertToSListModelMergerPluginConfiguration(getUserSettings(session).getModelmergers());
			Collections.sort(modelMergers, new SPluginConfigurationComparator());
			return modelMergers;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateIfcEngine(SIfcEnginePluginConfiguration ifcEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IfcEnginePluginConfiguration convert = converter.convertFromSObject(ifcEngine, session);
			session.executeAndCommitAction(new UpdateIfcEngineDatabaseAction(session, accessMethod, convert));
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
			QueryEnginePluginConfiguration convert = converter.convertFromSObject(queryEngine, session);
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
			ModelComparePluginConfiguration convert = converter.convertFromSObject(modelCompare, session);
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
			ModelMergerPluginConfiguration convert = converter.convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new UpdateModelMergerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteIfcEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteIfcEngineDatabaseAction(session, accessMethod, iid);
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
	public SIfcEnginePluginConfiguration getIfcEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetIfcEngineByNameDatabaseAction(session, accessMethod, name)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, accessMethod, name)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelMergerByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelCompareByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelCompareByNameDatabaseAction(session, accessMethod, name)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelMergerByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SIfcEnginePluginConfiguration getIfcEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetIfcEngineByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addIfcEngine(SIfcEnginePluginConfiguration ifcEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IfcEnginePluginConfiguration convert = converter.convertFromSObject(ifcEngine, session);
			session.executeAndCommitAction(new AddIfcEngineDatabaseAction(session, accessMethod, authorization, convert));
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
			QueryEnginePluginConfiguration convert = converter.convertFromSObject(queryEngine, session);
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
			ModelComparePluginConfiguration convert = converter.convertFromSObject(modelCompare, session);
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
			ModelMergerPluginConfiguration convert = converter.convertFromSObject(modelMerger, session);
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
		requireAuthenticationAndRunningServer();
		for (DeserializerPlugin deserializerPlugin : bimServer.getPluginManager().getAllDeserializerPlugins(true)) {
			if (deserializerPlugin.canHandleExtension(extension)) {
				DatabaseSession session = bimServer.getDatabase().createSession();
				try {
					UserSettings userSettings = getUserSettings(session);
					for (DeserializerPluginConfiguration deserializer : userSettings.getDeserializers()) {
						if (deserializer.getClassName().equals(deserializerPlugin.getClass().getName())) {
							return converter.convertToSObject(deserializer);
						}
					}
				} catch (BimserverDatabaseException e) {
					LOGGER.error("", e);
				} finally {
					session.close();
				}
			}
		}
		return null;
	}

	public void setCurrentUser(User user) {
		authorization = new UserAuthorization(user);
	}

	@Override
	public void addExtendedDataSchema(SExtendedDataSchema extendedDataSchema) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedDataSchema convert = converter.convertFromSObject(extendedDataSchema, session);
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
			ExtendedData convert = converter.convertFromSObject(extendedData, session);
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
			ExtendedData convert = converter.convertFromSObject(extendedData, session);
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByIdDatabaseAction(session, accessMethod, oid)));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, accessMethod, authorization, oid)));
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
			List<SExtendedDataSchema> serializers = converter.convertToSListExtendedDataSchema(session.executeAndCommitAction(new GetAllExtendedDataSchemasDatabaseAction(session,
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

	public SIfcEnginePluginConfiguration getDefaultIfcEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return converter.convertToSObject(settings.getDefaultIfcEngine());
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
			return converter.convertToSObject(settings.getDefaultQueryEngine());
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
			return converter.convertToSObject(settings.getDefaultModelCompare());
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
			return converter.convertToSObject(settings.getDefaultModelMerger());
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
			return converter.convertToSObject(settings.getDefaultSerializer());
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
			return converter.convertToSObject(settings.getDefaultObjectIDM());
		} catch (BimserverDatabaseException e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultIfcEngine(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultIfcEngine(find(settings.getIfcEngines(), oid));
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultQueryEngine(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultQueryEngine(find(settings.getQueryengines(), oid));
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelCompare(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultModelCompare(find(settings.getModelcompares(), oid));
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelMerger(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultModelMerger(find(settings.getModelmergers(), oid));
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultSerializer(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultSerializer(find(settings.getSerializers(), oid));
			session.store(settings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultObjectIDM(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			settings.setDefaultObjectIDM(find(settings.getObjectIDMs(), oid));
			session.store(settings);
			session.commit();
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
		return converter.convertToSListServiceDescriptor(bimServer.getNotificationsManager().getInternalServices().values());
	}
	
	@Override
	public List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SServiceDescriptor> sServiceDescriptors = new ArrayList<SServiceDescriptor>();
			String content = NetUtils.getContent(new URL(getServiceRepositoryUrl() + "/services"), 5000);
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
			org.bimserver.models.store.Service externalProfile = session.get(StorePackage.eINSTANCE.getService(), soid, false, null);
			return converter.convertToSObject(externalProfile);
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
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			sService.setUserId(getCurrentUser().getOid());
			org.bimserver.models.store.Service service = converter.convertFromSObject(sService, session);
			for (org.bimserver.models.store.Service existing : project.getServices()) {
				if (existing.getName().equals(service.getName())) {
					throw new UserException("Service name \"" + service.getName() + "\" already used in this project");
				}
			}
			service.setInternalService((InternalServicePluginConfiguration) session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), internalServiceOid, false, null));
			project.getServices().add(service);
			service.setProject(project);
			session.store(service);
			service.setProfileIdentifier("" + service.getOid());
			session.store(project);
			session.commit();
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
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			sService.setUserId(getCurrentUser().getOid());
			org.bimserver.models.store.Service service = converter.convertFromSObject(sService, session);
			for (org.bimserver.models.store.Service existing : project.getServices()) {
				if (existing.getName().equals(service.getName())) {
					throw new UserException("Service name \"" + service.getName() + "\" already used in this project");
				}
			}
			project.getServices().add(service);
			service.setProject(project);
			session.store(service);
			session.store(project);
			session.commit();
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
		for (String name : bimServer.getServicesMap().keySet()) {
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
		SService sService = bimServer.getServicesMap().get(serviceInterfaceName);
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
		SService serviceInterface = bimServer.getServicesMap().get(serviceInterfaceName);
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
		SService serviceInterface = bimServer.getServicesMap().get(serviceInterfaceName);
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

	public void setAuthorization(TokenAuthorization authorization) {
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByNamespaceDatabaseAction(session, accessMethod, nameSpace)));
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
			SInternalServicePluginConfiguration convertToSObject = converter
					.convertToSObject(session.executeAndCommitAction(new GetByIdDatabaseAction<InternalServicePluginConfiguration>(session, accessMethod, oid, StorePackage.eINSTANCE.getInternalServicePluginConfiguration())));
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
			InternalServicePluginConfiguration convertFromSObject = converter.convertFromSObject(internalService, session);
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
			session.executeAndCommitAction(new AddInternalServiceDatabaseAction(session, accessMethod, authorization, converter.convertFromSObject(internalService, session)));
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
			List<SInternalServicePluginConfiguration> services = converter.convertToSListInternalServicePluginConfiguration(services2);
			Collections.sort(services, new SPluginConfigurationComparator());
			return services;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void registerAll(Long endPointId) throws ServerException, UserException {
		requireRealUserAuthentication();
		EndPoint endPoint = bimServer.getEndPointManager().get(endPointId);
		bimServer.getNotificationsManager().register(getCurrentUser().getOid(), endPoint);
	}
	
	@Override
	public List<SProfileDescriptor> getAllPublicProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClient client = new BimServerClient(notificationsUrl, bimServer.getServicesMap());
			client.connectJson(false);
			NotificationInterface notificationInterface = client.getNotificationInterface();
			return notificationInterface.getPublicProfiles(serviceIdentifier);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllPrivateProfiles(String notificationsUrl, String serviceIdentifier, String token) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClient client = new BimServerClient(notificationsUrl, bimServer.getServicesMap());
			client.connectJson(false);
			NotificationInterface notificationInterface = client.getNotificationInterface();
			return notificationInterface.getPrivateProfiles(serviceIdentifier, token);
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
			User user = session.querySingle(condition, User.class, false, null);
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					if (internalServicePluginConfiguration.getClassName().equals(serviceIdentifier) && internalServicePluginConfiguration.isRemoteAccessible()) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);
						
						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return descriptors;
	}

	@Override
	public SObjectDefinition getPluginObjectDefinition(String className) throws ServerException, UserException {
		return converter.convertToSObject(bimServer.getPluginManager().getPlugin(className, false).getSettingsDefinition());
	}

	public SObjectType getPluginSettings(Long poid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, false, null);
			ObjectType settings = pluginConfiguration.getSettings();
			return converter.convertToSObject(settings);
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
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, false, null);
			ObjectType convertedSettings = converter.convertFromSObject(settings, session);
			pluginConfiguration.setSettings(convertedSettings);
			session.store(convertedSettings, true);
			session.store(pluginConfiguration);
			session.commit();
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
			IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), false, null);
			return converter.convertToSObject(allOfType.getAll(ServerSettings.class).get(0));
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
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
			return converter.convertToSListExtendedData(revision.getExtendedData());
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
			org.bimserver.models.store.File file = (org.bimserver.models.store.File)session.get(StorePackage.eINSTANCE.getFile(), fileId, false, null);
			return converter.convertToSObject(file);
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
			org.bimserver.models.store.File convertFromSObject = converter.convertFromSObject(file, session);
			long oid = session.store(convertFromSObject);
			session.commit();
			return oid;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void triggerNewRevision(Long roid, Long soid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			org.bimserver.models.store.Service service = (org.bimserver.models.store.Service)session.get(StorePackage.eINSTANCE.getService(), soid, false, null);
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
			SNewRevisionAdded newRevisionNotification = new SNewRevisionAdded();
			newRevisionNotification.setRevisionId(revision.getOid());
			newRevisionNotification.setProjectId(revision.getProject().getOid());
			bimServer.getNotificationsManager().trigger(bimServer.getServerSettings(session).getSiteAddress(), newRevisionNotification, service);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void externalServiceUpdate(String uuid, SExternalServiceUpdate sExternalServiceUpdate) throws ServerException, UserException {
		RunningExternalService runningExternalService = bimServer.getNotificationsManager().getRunningExternalService(uuid);
		if (sExternalServiceUpdate instanceof SPercentageChange) {
			SPercentageChange sPercentageChange = (SPercentageChange)sExternalServiceUpdate;
			runningExternalService.updatePercentage(sPercentageChange.getPercentage());
		}
	}
	
	@Override
	public SBounds getBoundsOfRevision(Long roid) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
			return converter.convertToSObject(revision.getGeometry().getBounds());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}