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
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.*;
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
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SDeserializer;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SIfcEngine;
import org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SModelCompare;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMerger;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectIDM;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEngine;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
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
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.GuidClash;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.ModelCompare;
import org.bimserver.models.store.ModelMerger;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.QueryEngine;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.shared.CompareWriter;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.MultiplexingInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
	private final ServiceInterfaceFactory serviceFactory;
	private final SConverter converter = new SConverter();

	private final BimServer bimServer;
	private final AccessMethod accessMethod;
	private final String remoteAddress;
	private Set<Change> changes = null;

	private Long currentUoid = -1L;
	private UserType currentUserType = null;
	private Date activeSince;
	private Date lastActive;
	private Token token;
	private long transactionPoid;

	public Service(BimServer bimServer, AccessMethod accessMethod, String remoteAddress, ServiceInterfaceFactory serviceFactory) {
		this.accessMethod = accessMethod;
		this.remoteAddress = remoteAddress;
		this.serviceFactory = serviceFactory;
		this.bimServer = bimServer;
		activeSince = new Date();
		lastActive = new Date();
	}

	@Override
	public Integer checkin(final Long poid, final String comment, String deserializerName, Long fileSize, DataHandler dataHandler, Boolean merge, Boolean sync)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
			username = user.getName();
			userUsername = user.getUsername();
		} finally {
			session.close();
		}
		try {
			File homeDirIncoming = new File(bimServer.getHomeDir(), "incoming");
			if (!homeDirIncoming.isDirectory()) {
				homeDirIncoming.mkdir();
			}
			File userDirIncoming = new File(homeDirIncoming, userUsername);
			if (!userDirIncoming.exists()) {
				userDirIncoming.mkdir();
			}
			InputStream inputStream = null;
			String fileName = dataHandler.getName();
			if (fileName == null || fileName.trim().equals("")) {
				inputStream = dataHandler.getInputStream();
			} else {
				if (fileName.contains("/")) {
					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
				}
				if (fileName.contains("\\")) {
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				}
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				fileName = dateFormat.format(new Date()) + "-" + fileName;
				File file = new File(userDirIncoming, fileName);
				inputStream = new MultiplexingInputStream(dataHandler.getInputStream(), new FileOutputStream(file));
			}
			try {
				EmfDeserializer deserializer = bimServer.getEmfDeserializerFactory().createDeserializer(deserializerName);
				if (deserializer == null) {
					throw new UserException("Deserializer " + deserializerName + " not found");
				}
				try {
					deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, false, fileSize);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(bimServer, null, accessMethod, poid, currentUoid, model, comment, merge, true);
				LongCheckinAction longAction = new LongCheckinAction(bimServer, username, userUsername, currentUoid, checkinDatabaseAction);
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
	public SCheckinResult getCheckinState(Integer actionId) throws ServerException, UserException {
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
	public Integer checkoutLastRevision(Long poid, String formatIdentifier, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			return checkout(project.getLastRevision().getOid(), formatIdentifier, sync);
		} catch (Exception e) {
			handleException(e);
			return -1;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer checkout(Long roid, String serializerName, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		EmfSerializer serializer = bimServer.getEmfSerializerFactory().get(serializerName);
		if (!serializer.getClass().getSimpleName().equals("IfcStepSerializer") && !serializer.getClass().getSimpleName().equals("IfcXmlSerializer")) {
			throw new UserException("Only IFC or IFCXML allowed when checking out");
		}
		DownloadParameters downloadParameters = new DownloadParameters(bimServer, roid, serializerName, -1);
		DatabaseSession session = bimServer.getDatabase().createSession();
		User user = null;
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(bimServer, user.getName(), user.getUsername(), downloadParameters, currentUoid, accessMethod);
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

	@Override
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration) throws ServerException, UserException {
		if (!selfRegistration) {
			requireAuthenticationAndRunningServer();
		} else if (!bimServer.getSettingsManager().getSettings().getAllowSelfRegistration()) {
			requireSelfregistrationAllowed();
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new AddUserDatabaseAction(bimServer, session, accessMethod, username, name, converter.convertFromSObject(type), currentUoid,
					selfRegistration);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	private void handleException(Exception e) throws ServerException, UserException {
		if (e instanceof UserException) {
			throw (UserException) e;
		} else if (e instanceof ServerException) {
			LOGGER.error("", e);
			throw (ServerException) e;
		} else if (e instanceof BimserverDatabaseException) {
			LOGGER.error("", e);
			throw new ServerException("Database error", e);
		}
		LOGGER.error("", e);
		throw new ServerException("Unknown error", e);
	}

	@Override
	public SProject addProject(String projectName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, currentUoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(session, accessMethod, currentUoid, uoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, accessMethod, currentUoid);
			return converter.convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
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
		if (currentUoid == -1) {
			throw new UserException("Authentication required for this call");
		}
	}

	private void requireAdminAuthentication() throws UserException {
		updateLastActive();
		if (currentUoid == -1) {
			throw new UserException("Authentication required for this call");
		}
		if (currentUserType != UserType.ADMIN && currentUserType != UserType.SYSTEM) {
			throw new UserException("Administrator rights required for this call");
		}
	}

	private void requireSelfregistrationAllowed() throws UserException {
		updateLastActive();
		if (currentUoid == -1) {
			throw new UserException("No self registration allowed");
		}
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, accessMethod, poid);
			return converter.convertToSListRevision(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, false);
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, true);
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(session, accessMethod, currentUoid);
			return converter.convertToSListUser(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean login(String username, String password) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			LoginDatabaseAction loginDatabaseAction = new LoginDatabaseAction(session, this, accessMethod, username, password);
			return session.executeAndCommitAction(loginDatabaseAction);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListRevision(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SRevision getRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, accessMethod, roid, currentUoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, accessMethod, roid);
			return converter.convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	public Integer download(Long roid, String resultTypeName, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, resultTypeName, showOwn ? -1 : currentUoid), sync);
	}

	@Override
	public Integer downloadCompareResults(String serializerName, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException,
			UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromCompare(roid1, roid2, converter.convertFromSObject(type), mcid, serializerName), sync);
	}

	private Integer download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		User user = null;
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(bimServer, user.getName(), user.getUsername(), downloadParameters, currentUoid, accessMethod);
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
	public SDownloadResult getDownloadData(final Integer actionId) throws ServerException, UserException {
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
	public SLongActionState getDownloadState(Integer actionId) throws ServerException, UserException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			return converter.convertToSObject(longAction.getState());
		} else {
			throw new UserException("No state found for laid " + actionId);
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(session, accessMethod, bimServer, poid, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteUser(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean removeUserFromProject(Long uoid, Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(session, accessMethod, uoid, poid, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByOids(Set<Long> roids, Set<Long> oids, String serializerName, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromOids(bimServer, serializerName, roids, oids), sync);
	}

	@Override
	public Integer downloadByTypes(Set<Long> roids, Set<String> classNames, String serializerName, Boolean includeAllSubtypes, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromClassNames(bimServer, roids, classNames, includeAllSubtypes, serializerName), sync);
	}

	@Override
	public List<String> getAvailableClasses() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(session, accessMethod);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SDatabaseInformation getDatabaseInformation() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(session, accessMethod);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByGuids(Set<Long> roids, Set<String> guids, String serializerName, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromGuids(bimServer, roids, guids, serializerName), sync);
	}

	@Override
	public SUser getLoggedInUser() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return getUserByUoid(currentUoid);
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void logout() throws UserException {
		requireAuthenticationAndRunningServer();
		currentUoid = -1L;
	}

	@Override
	public Boolean changePassword(Long uoid, String oldPassword, String newPassword) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(session, accessMethod, uoid, oldPassword, newPassword, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, username);
			SUser convert = converter.convertToSObject(session.executeAndCommitAction(action));
			if (convert == null) {
				throw new UserException("User with username \"" + username + "\" not found");
			}
			return convert;
		} catch (Exception e) {
			handleException(e);
			return null;
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
				currentUoid = user.getOid();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteUser(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, parentPoid, currentUoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(session, accessMethod, currentUoid, sProject);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(session, accessMethod, currentUoid, sRevision);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(Long roid1, Long roid2, SCompareType sCompareType, Long mcid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(bimServer, session, accessMethod, currentUoid, roid1, roid2,
					converter.convertFromSObject(sCompareType), mcid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, accessMethod, roid);
			RevisionSummary revisionSummary = session.executeAndCommitAction(action);
			return converter.convertToSObject(revisionSummary);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(session, accessMethod, currentUoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckoutWarnings(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckinWarnings(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckinWarningsDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasRights(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(session, accessMethod, getCurrentUser(session).getOid(), poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadRevisions(Set<Long> roids, String resultTypeName, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromRoids(bimServer, roids, resultTypeName), sync);
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid, String className) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByOidDatabaseAction(bimServer, session, accessMethod, roid, oid, session.getCidForClassName(className));
			SDataObject dataObject = converter.convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByGuidDatabaseAction(bimServer, session, accessMethod, roid, guid);
			SDataObject dataObject = converter.convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String className) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		BimDatabaseAction<List<DataObject>> action = new GetDataObjectsByTypeDatabaseAction(bimServer, session, accessMethod, roid, className);
		try {
			List<DataObject> dataObjects = session.executeAndCommitAction(action);
			return converter.convertToSListDataObject(dataObjects);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidClash> findClashesByGuid(SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSListGuidClash(session.executeAndCommitAction(new FindClashesDatabaseAction<GuidClash>(bimServer, session, accessMethod, converter
					.convertFromSObject(sClashDetectionSettings, session), currentUoid)));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SEidClash> findClashesByEid(SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSListEidClash(session.executeAndCommitAction(new FindClashesDatabaseAction<EidClash>(bimServer, session, accessMethod, converter
					.convertFromSObject(sClashDetectionSettings, session), currentUoid)));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckinResult branchToNewProject(Long roid, String projectName, String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, accessMethod, bimServer, currentUoid, roid, projectName, comment);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SCheckinResult branchToExistingProject(Long roid, Long destPoid, String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, accessMethod, bimServer, currentUoid, roid, destPoid, comment);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SLogAction> getLogs() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(session, accessMethod, currentUoid);
			List<LogAction> logs = session.executeAndCommitAction(action);
			return converter.convertToSListLogAction(logs);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(Long goid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(session, accessMethod, currentUoid, goid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(session, accessMethod, currentUoid, sGeoTag);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SClashDetectionSettings getClashDetectionSettings(Long cdsoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<ClashDetectionSettings> action = new GetClashDetectionSettingsDatabaseAction(session, accessMethod, currentUoid, cdsoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateClashDetectionSettings(SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateClashDetectionSettingsDatabaseAction(session, accessMethod, currentUoid, sClashDetectionSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SClash> getLastClashes(Long roid) throws UserException {
		requireAuthenticationAndRunningServer();
		return null;
	}

	@Override
	public SUser getUserByUoid(Long uoid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, accessMethod, poid, currentUoid);
			return converter.convertToSObject(action.execute());
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public String ping(String in) {
		return in;
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(converter.convertToSSetUser((session.executeAndCommitAction(action))));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(converter.convertToSSetUser(session.executeAndCommitAction(action)));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getUsersProjects(Long uoid) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), uoid, false, null);
			return new ArrayList<SProject>(converter.convertToSSetProject(user.getHasRightsOn()));
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, accessMethod, name, currentUoid);
			return (List<SProject>) converter.convertToSListProject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean autologin(String username, String hash) throws ServerException, UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			AutologinDatabaseAction action = new AutologinDatabaseAction(session, this, accessMethod, username, hash);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public void setRevisionTag(Long roid, String tag) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, accessMethod, currentUoid, poid);
			return converter.convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(Long uoid, SUserType userType) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(session, accessMethod, currentUoid, uoid, userType);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private SUser getCurrentUser(DatabaseSession databaseSession) throws UserException {
		if (currentUoid == -1) {
			return null;
		}
		User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
		return converter.convertToSObject(user);
	}

	@Override
	public SUser getCurrentUser() throws UserException {
		if (currentUoid == -1) {
			return null;
		}
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
			return converter.convertToSObject(user);
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
		return currentUoid != -1;
	}

	@Override
	public String getSettingCustomLogoAddress() throws ServerException, UserException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getCustomLogoAddress();
	}

	@Override
	public void setSettingCustomLogoAddress(String customLogoAddress) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCustomLogoAddress(customLogoAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingEmailSenderAddress() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getEmailSenderAddress();
	}

	@Override
	public void setSettingProtocolBuffersPort(Integer port) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setProtocolBuffersPort(port);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Integer getSettingProtocolBuffersPort() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getProtocolBuffersPort();
	}

	@Override
	public void setSettingEmailSenderAddress(String emailSenderAddress) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setEmailSenderAddress(emailSenderAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingRegistrationAddition() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getRegistrationAddition();
	}

	@Override
	public void setSettingRegistrationAddition(String registrationAddition) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setRegistrationAddition(registrationAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingSiteAddress() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getSiteAddress();
	}

	@Override
	public void setSettingSiteAddress(String siteAddress) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		Settings settings = bimServer.getSettingsManager().getSettings();
		if (siteAddress.trim().isEmpty()) {
			throw new UserException("Site Address cannot be empty");
		} else if (!siteAddress.startsWith("http://") && !(siteAddress.startsWith("https://"))) {
			throw new UserException("Site Address must start with either \"http://\" or \"https://\"");
		}
		settings.setSiteAddress(siteAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingSmtpServer() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getSmtpServer();
	}

	@Override
	public void setSettingSmtpServer(String smtpServer) throws ServerException, UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		Settings settings = bimServer.getSettingsManager().getSettings();
		if (smtpServer.trim().isEmpty()) {
			throw new UserException("SMTP server address cannot be empty");
		}
		settings.setSmtpServer(smtpServer);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAllowSelfRegistration() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getAllowSelfRegistration();
	}

	@Override
	public Boolean isSettingHideUserListForNonAdmin() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getHideUserListForNonAdmin();
	}

	@Override
	public void setSettingHideUserListForNonAdmin(Boolean hideUserListForNonAdmin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setHideUserListForNonAdmin(hideUserListForNonAdmin);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void setSettingAllowSelfRegistration(Boolean allowSelfRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowSelfRegistration(allowSelfRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().isAllowUsersToCreateTopLevelProjects();
	}

	@Override
	public void setSettingAllowUsersToCreateTopLevelProjects(Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCheckinMergingEnabled() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getCheckinMergingEnabled();
	}

	@Override
	public void setSettingCheckinMergingEnabled(Boolean checkinMergingEnabled) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCheckinMergingEnabled(checkinMergingEnabled);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingIntelligentMerging() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getIntelligentMerging();
	}

	@Override
	public void setSettingIntelligentMerging(Boolean intelligentMerging) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setIntelligentMerging(intelligentMerging);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().isSendConfirmationEmailAfterRegistration();
	}

	@Override
	public void setSettingSendConfirmationEmailAfterRegistration(Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingShowVersionUpgradeAvailable() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getShowVersionUpgradeAvailable();
	}

	@Override
	public void setSettingShowVersionUpgradeAvailable(Boolean showVersionUpgradeAvailable) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setShowVersionUpgradeAvailable(showVersionUpgradeAvailable);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCacheOutputFiles() throws ServerException, UserException {
		return bimServer.getSettingsManager().getSettings().getCacheOutputFiles();
	}

	@Override
	public void setSettingCacheOutputFiles(Boolean cacheOutputFiles) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCacheOutputFiles(cacheOutputFiles);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public List<SUserSession> getActiveUserSessions() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public Token getCurrentToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	@Override
	public SAccessMethod getAccessMethod() {
		return SAccessMethod.valueOf(accessMethod.getName());
	}

	@Override
	public void sendCompareEmail(SCompareType sCompareType, Long mcid, Long poid, Long roid1, Long roid2, String address) throws ServerException,
			UserException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SUser currentUser = getCurrentUser(session);
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, false, null);
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, false, null);
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = bimServer.getSettingsManager().getSettings().getEmailSenderAddress();
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
		} finally {
			session.close();
		}
	}

	@Override
	public void requestPasswordChange(String username) throws ServerException, UserException {
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
	public void sendClashesEmail(SClashDetectionSettings sClashDetectionSettings, Long poid, Set<String> addressesTo) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new SendClashesEmailDatabaseAction(bimServer, session, accessMethod, currentUoid, poid, sClashDetectionSettings, addressesTo);
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
		return converter.convertToSListLongAction(bimServer.getLongActionManager().getActiveLongActions());
	}

	@Override
	public List<SProject> getAllReadableProjects() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(session, accessMethod, currentUoid);
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
	public void setup(String siteAddress, String smtpServer, String adminName, String adminUsername, String adminPassword) throws ServerException, UserException {
		setSettingSmtpServer(smtpServer);
		setSettingSiteAddress(siteAddress);

		if (adminUsername.trim().isEmpty()) {
			throw new UserException("Admin Username cannot be empty");
		}

		if (adminPassword.trim().isEmpty()) {
			throw new UserException("Admin Password cannot be empty");
		}

		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			new AddUserDatabaseAction(bimServer, session, AccessMethod.INTERNAL, adminUsername, adminPassword, adminName, UserType.ADMIN, -1, false).execute();
			session.commit();
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
	public List<SSerializer> getAllSerializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SSerializer> serializers = converter.convertToSListSerializer(session.executeAndCommitAction(new GetAllSerializersDatabaseAction(session, accessMethod, bimServer,
					onlyEnabled)));
			Collections.sort(serializers, new SSerializerComparator());
			return serializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SDeserializer> getAllDeserializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SDeserializer> deserializers = converter.convertToSListDeserializer(session.executeAndCommitAction(new GetAllDeserializersDatabaseAction(session, accessMethod,
					bimServer, onlyEnabled)));
			Collections.sort(deserializers, new SDeserializerComparator());
			return deserializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addSerializer(SSerializer serializer) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Serializer convert = converter.convertFromSObject(serializer, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addDeserializer(SDeserializer deserializer) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Deserializer convert = converter.convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new AddDeserializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializer serializer) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Serializer convert = converter.convertFromSObject(serializer, session);
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateDeserializer(SDeserializer deserializer) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			Deserializer convert = converter.convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SObjectIDM> getAllObjectIDMs(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSListObjectIDM(session.executeAndCommitAction(new GetAllObjectIDMsDatabaseAction(session, accessMethod, bimServer, onlyEnabled)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addObjectIDM(SObjectIDM objectIDM) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddObjectIDMDatabaseAction(session, accessMethod, converter.convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateObjectIDM(SObjectIDM objectIDM) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
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
	public SSerializer getSerializerById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public SDeserializer getDeserializerById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public SObjectIDM getObjectIDMById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteObjectIDM(Long ifid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
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
		requireAdminAuthenticationAndRunningServer();
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
		requireAdminAuthenticationAndRunningServer();
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
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setFooterAddition(footerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void setSettingHeaderAddition(String headerAddition) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setHeaderAddition(headerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingFooterAddition() throws ServerException, UserException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getFooterAddition();
	}

	@Override
	public String getSettingHeaderAddition() throws ServerException, UserException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getHeaderAddition();
	}

	@Override
	public SMergeIdentifier getSettingMergeIdentifier() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		return converter.convertToSObject(settings.getMergeIdentifier());
	}

	@Override
	public void setSettingMergeIdentifier(SMergeIdentifier mergeIdentifier) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setMergeIdentifier(MergeIdentifier.valueOf(mergeIdentifier.name()));
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public SSerializer getSerializerByName(String serializerName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public SObjectIDM getObjectIDMByName(String ObjectIDMName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public SDeserializer getDeserializerByName(String deserializerName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
	public SSerializer getSerializerByContentType(String contentType) throws ServerException, UserException {
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
		try {
			SSerializer serializer = getSerializerByContentType(contentType);
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
		requireAuthenticationAndRunningServer();
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		Collection<Plugin> plugins = bimServer.getPluginManager().getAllPlugins(false);
		for (Plugin plugin : plugins) {
			SPluginDescriptor sPlugin = new SPluginDescriptor();
			sPlugin.setName(plugin.getClass().getName());
			PluginContext pluginContext = bimServer.getPluginManager().getPluginContext(plugin);
			sPlugin.setLocation(pluginContext.getLocation());
			sPlugin.setDescription(plugin.getDescription());
			sPlugin.setEnabled(pluginContext.isEnabled());
			result.add(sPlugin);
		}
		Collections.sort(result, new SPluginComparator());
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
	public void startTransaction(Long poid) throws UserException {
		requireAuthenticationAndRunningServer();
		changes = new LinkedHashSet<Change>();
		transactionPoid = poid;
	}

	@Override
	public Long commitTransaction(String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		DatabaseSession session = bimServer.getDatabase().createSession();
		CommitTransactionDatabaseAction action = new CommitTransactionDatabaseAction(session, accessMethod, changes, currentUoid, transactionPoid, comment);
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
	public void addStringAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long oid, String className, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addDoubleAttribute(Long oid, String className, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addBooleanAttribute(Long oid, String className, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addReference(Long oid, String className, String referenceName, Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new AddReferenceChange(oid, className, referenceName, referenceOid, referenceClassName));
	}

	@Override
	public Long createObject(String className) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		Long oid = bimServer.getDatabase().newOid();
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
	public void removeAttribute(Long oid, String className, String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveAttributeChange(oid, className, attributeName, index));
	}

	@Override
	public void removeObject(String className, Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveObjectChange(className, oid));
	}

	@Override
	public void removeReference(Long oid, String className, String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new RemoveReferenceChange(oid, className, referenceName, index));
	}

	@Override
	public void setStringAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setIntegerAttribute(Long oid, String className, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setBooleanAttribute(Long oid, String className, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setDoubleAttribute(Long oid, String className, String attributeName, Double value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setEnumAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setReference(Long oid, String className, String referenceName, Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetReferenceChange(oid, className, referenceName, referenceOid, referenceClassName));
	}

	@Override
	public void unsetAttribute(Long oid, String className, String attributeName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, null));
	}

	@Override
	public void unsetReference(Long oid, String className, String referenceName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenTransaction();
		changes.add(new SetReferenceChange(oid, className, referenceName, -1, null));
	}

	@Override
	public Date getServerStartTime() {
		return bimServer.getServerStartTime().getTime();
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getSerializerPluginDescriptor(type);
	}

	@Override
	public List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws UserException {
		requireAuthenticationAndRunningServer();
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
	public void setHttpCallback(Long uoid, String address) throws UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			SetHttpCallbackUrlDatabaseAction action = new SetHttpCallbackUrlDatabaseAction(session, accessMethod, bimServer, currentUoid, uoid, address);
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadQuery(Long roid, Long qeid, String code, Boolean sync, String serializerName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromQuery(roid, qeid, code, serializerName), sync);
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
		requireAuthenticationAndRunningServer();
		List<SDeserializerPluginDescriptor> descriptors = new ArrayList<SDeserializerPluginDescriptor>();
		for (DeserializerPlugin deserializerPlugin : bimServer.getPluginManager().getAllDeserializerPlugins(true)) {
			SDeserializerPluginDescriptor descriptor = new SDeserializerPluginDescriptor();
			descriptor.setDefaultName(deserializerPlugin.getDefaultDeserializerName());
			descriptor.setPluginClassName(deserializerPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}

	@Override
	public List<String> getAvailableClassesInRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
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
			BimDatabaseAction<List<DataObject>> action = new GetDataObjectsDatabaseAction(session, accessMethod, bimServer, roid);
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
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllIfcEnginePluginDescriptors();
	}

	@Override
	public List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllQueryEnginePluginDescriptors();
	}

	@Override
	public List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllModelComparePluginDescriptors();
	}

	@Override
	public List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllModelMergerPluginDescriptors();
	}

	@Override
	public List<SIfcEngine> getAllIfcEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SIfcEngine> ifcEngines = converter.convertToSListIfcEngine(session.executeAndCommitAction(new GetAllIfcEnginesDatabaseAction(session, accessMethod, bimServer,
					onlyEnabled)));
			Collections.sort(ifcEngines, new SIfcEngineComparator());
			return ifcEngines;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SQueryEngine> getAllQueryEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SQueryEngine> queryEngines = converter.convertToSListQueryEngine(session.executeAndCommitAction(new GetAllQueryEnginesDatabaseAction(session, accessMethod,
					bimServer, onlyEnabled)));
			Collections.sort(queryEngines, new SQueryEngineComparator());
			return queryEngines;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SModelCompare> getAllModelCompares(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SModelCompare> modelCompares = converter.convertToSListModelCompare(session.executeAndCommitAction(new GetAllModelComparesDatabaseAction(session, accessMethod,
					bimServer, onlyEnabled)));
			Collections.sort(modelCompares, new SModelCompareComparator());
			return modelCompares;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SModelMerger> getAllModelMergers(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<SModelMerger> modelMergers = converter.convertToSListModelMerger(session.executeAndCommitAction(new GetAllModelMergersDatabaseAction(session, accessMethod,
					bimServer, onlyEnabled)));
			Collections.sort(modelMergers, new SModelMergerComparator());
			return modelMergers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void updateIfcEngine(SIfcEngine ifcEngine) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IfcEngine convert = converter.convertFromSObject(ifcEngine, session);
			session.executeAndCommitAction(new UpdateIfcEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateQueryEngine(SQueryEngine queryEngine) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			QueryEngine convert = converter.convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new UpdateQueryEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelCompare(SModelCompare modelCompare) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelCompare convert = converter.convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new UpdateModelCompareDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelMerger(SModelMerger modelMerger) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelMerger convert = converter.convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new UpdateModelMergerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteIfcEngine(Long iid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
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
		requireAdminAuthenticationAndRunningServer();
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
		requireAdminAuthenticationAndRunningServer();
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
		requireAdminAuthenticationAndRunningServer();
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
	public SIfcEngine getIfcEngineByName(String name) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetIfcEngineByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SQueryEngine getQueryEngineByName(String name) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SModelMerger getModelMergerById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelMergerByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SModelCompare getModelCompareById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelCompareByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SModelCompare getModelCompareByName(String name) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelCompareByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SModelMerger getModelMergerByName(String name) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetModelMergerByNameDatabaseAction(session, accessMethod, name)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SIfcEngine getIfcEngineById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetIfcEngineByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SQueryEngine getQueryEngineById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return converter.convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, accessMethod, oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addIfcEngine(SIfcEngine ifcEngine) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			IfcEngine convert = converter.convertFromSObject(ifcEngine, session);
			session.executeAndCommitAction(new AddIfcEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addQueryEngine(SQueryEngine queryEngine) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			QueryEngine convert = converter.convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new AddQueryEngineDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCompare(SModelCompare modelCompare) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelCompare convert = converter.convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new AddModelCompareDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelMerger(SModelMerger modelMerger) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ModelMerger convert = converter.convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new AddModelMergerDatabaseAction(session, accessMethod, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSuggestedDeserializerForExtension(String extension) throws ServerException, UserException {
		requireAuthentication();
		for (DeserializerPlugin deserializerPlugin : bimServer.getPluginManager().getAllDeserializerPlugins(true)) {
			if (deserializerPlugin.canHandleExtension(extension)) {
				DatabaseSession session = bimServer.getDatabase().createSession();
				try {
					Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getDeserializer_ClassName(), new StringLiteral(deserializerPlugin.getClass().getName()));
					Deserializer deserializer = session.querySingle(condition, Deserializer.class, false, null);
					if (deserializer != null) {
						return deserializer.getName();
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
		currentUserType = user.getUserType();
		currentUoid = user.getOid();
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
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedData convert = converter.convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToRevisionDatabaseAction(session, accessMethod, roid, convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addExtendedDataToProject(Long poid, SExtendedData extendedData) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			ExtendedData convert = converter.convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToProjectDatabaseAction(session, accessMethod, poid, convert));
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
			return converter.convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, accessMethod, oid)));
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
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String getQueryEngineExample(Long qeid, String key) throws ServerException, UserException {
		SQueryEngine queryEngineById = getQueryEngineById(qeid);
		QueryEnginePlugin queryEngine = bimServer.getPluginManager().getQueryEngine(queryEngineById.getClassName(), true);
		return queryEngine.getExample(key);
	}

	@Override
	public List<String> getQueryEngineExampleKeys(Long qeid) throws ServerException, UserException {
		SQueryEngine queryEngineById = getQueryEngineById(qeid);
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

	public SIfcEngine getDefaultIfcEngine() throws ServerException, UserException{
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultIfcEngine());
	}

	public SQueryEngine getDefaultQueryEngine() throws ServerException, UserException{
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultQueryEngine());
	}

	public SModelCompare getDefaultModelCompare() throws ServerException, UserException{
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultModelCompare());
	}

	public SModelMerger getDefaultModelMerger() throws ServerException, UserException{
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultModelMerger());
	}

	public SSerializer getDefaultSerializer() throws ServerException, UserException {
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultSerializer());
	}

	public SObjectIDM getDefaultObjectIDM() throws ServerException, UserException {
		return converter.convertToSObject(bimServer.getSettingsManager().getSettings().getDefaultObjectIDM());
	}

	public void setDefaultIfcEngine(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultIfcEngine(find(settings.getIfcEngines(), oid));
		bimServer.getSettingsManager().saveSettings();
	}
	
	public void setDefaultQueryEngine(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultQueryEngine(find(settings.getQueryengines(), oid));
		bimServer.getSettingsManager().saveSettings();
	}

	public void setDefaultModelCompare(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultModelCompare(find(settings.getModelcompares(), oid));
		bimServer.getSettingsManager().saveSettings();
	}
	
	public void setDefaultModelMerger(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultModelMerger(find(settings.getModelmergers(), oid));
		bimServer.getSettingsManager().saveSettings();
	}
	
	public void setDefaultSerializer(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultSerializer(find(settings.getSerializers(), oid));
		bimServer.getSettingsManager().saveSettings();
	}
	
	public void setDefaultObjectIDM(long oid) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setDefaultObjectIDM(find(settings.getObjectIDMs(), oid));
		bimServer.getSettingsManager().saveSettings();
	}
}