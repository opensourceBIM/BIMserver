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

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.*;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
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
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SServicePluginDescriptor;
import org.bimserver.interfaces.objects.STrigger;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.LongAction;
import org.bimserver.longaction.LongBranchAction;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CompareResult;
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
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.notifications.ChangeProgressTopicOnProjectTopic;
import org.bimserver.notifications.ChangeProgressTopicOnRevisionTopic;
import org.bimserver.notifications.ChangeProgressTopicOnServerTopic;
import org.bimserver.notifications.NewExtendedDataNotification;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopic;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopicKey;
import org.bimserver.notifications.ProgressOnRevisionTopic;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.notifications.TopicRegisterException;
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
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.MultiplexingInputStream;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service extends GenericServiceImpl implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

	public Service(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long checkin(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge, Boolean sync)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = getBimServer().getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			username = user.getName();
			userUsername = user.getUsername();
			File homeDirIncoming = new File(getBimServer().getHomeDir(), "incoming");
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
				Deserializer deserializer = getBimServer().getDeserializerFactory().createDeserializer(deserializerOid);
				try {
					deserializer.init(getBimServer().getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, fileSize);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, merge);
				LongCheckinAction longAction = new LongCheckinAction(getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
				getBimServer().getLongActionManager().start(longAction);
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
		final DatabaseSession session = getBimServer().getDatabase().createSession();
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			username = user.getName();
			userUsername = user.getUsername();
			File homeDirIncoming = new File(getBimServer().getHomeDir(), "incoming");
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
				Deserializer deserializer = getBimServer().getDeserializerFactory().createDeserializer(deserializerOid);
				try {
					deserializer.init(getBimServer().getPluginManager().requireSchemaDefinition());
				} catch (PluginException e) {
					throw new UserException(e);
				}
				IfcModelInterface model = deserializer.read(inputStream, fileName, 0);
				if (model.size() == 0) {
					throw new DeserializeException("Cannot checkin empty model");
				}
				CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, merge);
				LongCheckinAction longAction = new LongCheckinAction(getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
				getBimServer().getLongActionManager().start(longAction);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		getAuthorization().canDownload(roid);
		DatabaseSession session = getBimServer().getDatabase().createSession();
		User user = null;
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = (SerializerPluginConfiguration) session.get(serializerOid, Query.getDefault());
//			org.bimserver.plugins.serializers.Serializer serializer = getBimServer().getEmfSerializerFactory().get(serializerOid).createSerializer(new org.bimserver.plugins.serializers.PluginConfiguration());
			if (serializerPluginConfiguration == null) {
				throw new UserException("No serializer with id " + serializerOid + " could be found");
			}
			if (!serializerPluginConfiguration.getClassName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializer") && !serializerPluginConfiguration.getClassName().equals("org.bimserver.ifc.xml.serializer.IfcXmlSerializer")) {
				throw new UserException("Only IFC or IFCXML allowed when checking out");
			}
			DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), roid, serializerOid, -1);
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(getBimServer(), user.getName(), user.getUsername(), downloadParameters, getAuthorization(), getInternalAccessMethod());
			try {
				getBimServer().getLongActionManager().start(longDownloadAction);
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
		User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
		return user.getUserSettings();
	}

	@Override
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			if (!selfRegistration) {
				requireRealUserAuthentication();
			} else if (!getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireSelfregistrationAllowed();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), username, name, getBimServer().getSConverter().convertFromSObject(type), getAuthorization(),
					selfRegistration);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProject(String projectName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid, poid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, getInternalAccessMethod(), onlyTopLevel, getAuthorization());
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<SRevision> convertToSListRevision = getBimServer().getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<org.bimserver.models.store.Service>> action = new GetAllServicesOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<org.bimserver.interfaces.objects.SService> convertToSListRevision = getBimServer().getSConverter().convertToSListService(session.executeAndCommitAction(action));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, false);
			return getBimServer().getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, true);
			return getBimServer().getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			List<SUser> convertToSListUser = getBimServer().getSConverter().convertToSListUser(session.executeAndCommitAction(action));
			Collections.sort(convertToSListUser, new SUserComparator());
			return convertToSListUser;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			return getBimServer().getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			List<SRevision> convertToSListRevision = getBimServer().getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, getInternalAccessMethod(), roid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, getInternalAccessMethod(), roid);
			return getBimServer().getSConverter().convertToSListCheckout(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void cleanupLongAction(Long actionId) throws UserException, ServerException {
		getBimServer().getLongActionManager().remove(actionId);
	}
	
	public Long download(Long roid, Long serializerOid, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(getBimServer(), roid, serializerOid, showOwn ? -1 : getAuthorization().getUoid()), sync);
	}

	@Override
	public Long downloadCompareResults(Long serializerOid, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromCompare(roid1, roid2, getBimServer().getSConverter().convertFromSObject(type), mcid, serializerOid), sync);
	}

	private Long download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		User user = null;
		for (long roid : downloadParameters.getRoids()) {
			getAuthorization().canDownload(roid);
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(getBimServer(), user == null ? "Unknown" : user.getName(), user == null ? "Unknown" : user.getUsername(), downloadParameters, getAuthorization(), getInternalAccessMethod());
		try {
			getBimServer().getLongActionManager().start(longDownloadAction);
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
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) getBimServer().getLongActionManager().getLongAction(actionId);
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
		LongAction<?> longAction = getBimServer().getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			return getBimServer().getSConverter().convertToSObject(longAction.getState());
		} else {
			throw new UserException("No state found for laid " + actionId);
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), uoid, poid, getAuthorization());
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
		return download(DownloadParameters.fromOids(getBimServer(), serializerOid, roids, oids, deep), sync);
	}

	@Override
	public Long downloadByTypes(Set<Long> roids, Set<String> classNames, Long serializerOid, Boolean includeAllSubtypes, Boolean useObjectIDM, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DownloadParameters fromClassNames = DownloadParameters.fromClassNames(getBimServer(), roids, classNames, includeAllSubtypes, serializerOid, deep);
		fromClassNames.setUseObjectIDM(useObjectIDM);
		return download(fromClassNames, sync);
	}

	@Override
	public List<String> getAvailableClasses() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(session, getInternalAccessMethod());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long downloadByGuids(Set<Long> roids, Set<String> guids, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromGuids(getBimServer(), roids, guids, serializerOid, deep), sync);
	}

	@Override
	public Long downloadByNames(Set<Long> roids, Set<String> names, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromNames(getBimServer(), roids, names, serializerOid, deep), sync);
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean changePassword(Long uoid, String oldPassword, String newPassword) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(getBimServer(), session, getInternalAccessMethod(), uoid, oldPassword, newPassword, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, getInternalAccessMethod(), username);
			SUser convert = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, parentPoid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sProject);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sRevision);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), -1, roid1, roid2,
					getBimServer().getSConverter().convertFromSObject(sCompareType), mcid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, getInternalAccessMethod(), roid);
			RevisionSummary revisionSummary = session.executeAndCommitAction(action);
			return getBimServer().getSConverter().convertToSObject(revisionSummary);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid, poid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckinWarningsDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(session, getInternalAccessMethod(), getCurrentUser(session).getOid(), getAuthorization(), poid);
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
		return download(DownloadParameters.fromRoids(getBimServer(), roids, serializerOid), sync);
	}

	public Long getOidByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Long> action = new GetOidByGuidDatabaseAction(session, getInternalAccessMethod(), roid, guid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToNewProject(Long roid, String projectName, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, projectName, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longAction);
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
		final DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, destPoid, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longBranchAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longBranchAction);
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
	public SGeoTag getGeoTag(Long goid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), goid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sGeoTag);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, getInternalAccessMethod(), uoid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			return new ArrayList<SUser>(getBimServer().getSConverter().convertToSSetUser((session.executeAndCommitAction(action))));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			return new ArrayList<SUser>(getBimServer().getSConverter().convertToSSetUser(session.executeAndCommitAction(action)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getUsersProjects(Long uoid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetProjectsOfUserDatabaseAction action = new GetProjectsOfUserDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid);
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, getInternalAccessMethod(), name, getAuthorization());
			return (List<SProject>) getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setRevisionTag(Long roid, String tag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(session, getInternalAccessMethod(), roid, tag);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), poid);
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid, userType);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private SUser getCurrentUser(DatabaseSession databaseSession) throws UserException, ServerException {
		if (getAuthorization() == null) {
			return null;
		}
		try {
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public void sendCompareEmail(SCompareType sCompareType, Long mcid, Long poid, Long roid1, Long roid2, String address) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SUser currentUser = getCurrentUser(session);
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, Query.getDefault());
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, Query.getDefault());
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = getBimServer().getServerSettingsCache().getServerSettings().getEmailSenderAddress();
			}

			Session mailSession = getBimServer().getMailSystem().createMailSession();

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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(session, getInternalAccessMethod(), getBimServer(), username, resetUrl);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser validateAccount(Long uoid, String token, String password) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<User> action = new ValidateUserDatabaseAction(session, getInternalAccessMethod(), uoid, token, password);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SProject> getAllReadableProjects() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}


	@Override
	public List<SSerializerPluginConfiguration> getAllSerializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SSerializerPluginConfiguration> serializers = getBimServer().getSConverter().convertToSListSerializerPluginConfiguration(getUserSettings(session).getSerializers());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SDeserializerPluginConfiguration> deserializers = getBimServer().getSConverter().convertToSListDeserializerPluginConfiguration(getUserSettings(session).getDeserializers());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(serializer, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new AddDeserializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(serializer, session);
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SObjectIDMPluginConfiguration> getAllObjectIDMs(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SObjectIDMPluginConfiguration> objectIdms = getBimServer().getSConverter().convertToSListObjectIDMPluginConfiguration(getUserSettings(session).getObjectIDMs());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddObjectIDMDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), getBimServer().getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateObjectIDM(SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new UpdateObjectIDMDatabaseAction(session, getInternalAccessMethod(), getBimServer().getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerById(Long oid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
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
		return getBimServer().getSerializerFactory().getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteObjectIDM(Long ifid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteObjectIDMDatabaseAction(session, getInternalAccessMethod(), ifid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteSerializerDatabaseAction(session, getInternalAccessMethod(), sid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteDeserializerDatabaseAction(session, getInternalAccessMethod(), sid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByNameDatabaseAction(session, getInternalAccessMethod(), serializerName)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByNameDatabaseAction(session, getInternalAccessMethod(), ObjectIDMName)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByNameDatabaseAction(session, getInternalAccessMethod(), deserializerName)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByContentTypeDatabaseAction(session, getInternalAccessMethod(), contentType)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByPluginClassNameDatabaseAction(session, getInternalAccessMethod(), pluginClassName)));
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
					return getBimServer().getPluginManager().isEnabled(serializer.getClassName());
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getSerializerPluginDescriptor(type);
	}

	@Override
	public List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws UserException {
		requireRealUserAuthentication();
		Collection<ObjectIDMPlugin> allObjectIDMs = getBimServer().getPluginManager().getAllObjectIDMPlugins(true);
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
	public List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SDeserializerPluginDescriptor> descriptors = new ArrayList<SDeserializerPluginDescriptor>();
		for (DeserializerPlugin deserializerPlugin : getBimServer().getPluginManager().getAllDeserializerPlugins(true)) {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesInRevisionDatabaseAction(session, getInternalAccessMethod(), roid);
			return session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllRenderEnginePluginDescriptors();
	}

	@Override
	public List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllQueryEnginePluginDescriptors();
	}

	@Override
	public List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllServicePluginDescriptors();
	}

	@Override
	public List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllModelComparePluginDescriptors();
	}

	@Override
	public List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllModelMergerPluginDescriptors();
	}

	@Override
	public List<SRenderEnginePluginConfiguration> getAllRenderEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SRenderEnginePluginConfiguration> renderEngines = getBimServer().getSConverter().convertToSListRenderEnginePluginConfiguration(getUserSettings(session).getRenderEngines());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SQueryEnginePluginConfiguration> queryEngines = getBimServer().getSConverter().convertToSListQueryEnginePluginConfiguration(getUserSettings(session).getQueryengines());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SModelComparePluginConfiguration> modelCompares = getBimServer().getSConverter().convertToSListModelComparePluginConfiguration(getUserSettings(session).getModelcompares());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SModelMergerPluginConfiguration> modelMergers = getBimServer().getSConverter().convertToSListModelMergerPluginConfiguration(getUserSettings(session).getModelmergers());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(renderEngine, session);
			session.executeAndCommitAction(new UpdateRenderEngineDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new UpdateQueryEngineDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new UpdateModelCompareDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new UpdateModelMergerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteRenderEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteRenderEngineDatabaseAction(session, getInternalAccessMethod(), iid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteQueryEngineDatabaseAction(session, getInternalAccessMethod(), iid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteModelCompareDatabaseAction(session, getInternalAccessMethod(), iid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteModelMergerDatabaseAction(session, getInternalAccessMethod(), iid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRenderEnginePluginConfiguration getRenderEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(renderEngine, session);
			session.executeAndCommitAction(new AddRenderEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new AddQueryEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new AddModelCompareDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new AddModelMergerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
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
			for (DeserializerPlugin deserializerPlugin : getBimServer().getPluginManager().getAllDeserializerPlugins(true)) {
				if (deserializerPlugin.canHandleExtension(extension)) {
					DatabaseSession session = getBimServer().getDatabase().createSession();
					try {
						UserSettings userSettings = getUserSettings(session);
						for (DeserializerPluginConfiguration deserializer : userSettings.getDeserializers()) {
							if (deserializer.getClassName().equals(deserializerPlugin.getClass().getName())) {
								return getBimServer().getSConverter().convertToSObject(deserializer);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ExtendedDataSchema convert = getBimServer().getSConverter().convertFromSObject(extendedDataSchema, session);
			session.executeAndCommitAction(new AddExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addUserToExtendedDataSchema(Long uoid, Long edsid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new AddUserToExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), uoid, edsid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new RemoveUserFromExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), uoid, edsid);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ExtendedData convert = getBimServer().getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addExtendedDataToProject(Long poid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ExtendedData convert = getBimServer().getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, convert, getAuthorization()));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SExtendedDataSchema getExtendedDataSchemaById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), oid)));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SExtendedDataSchema> serializers = getBimServer().getSConverter().convertToSListExtendedDataSchema(session.executeAndCommitAction(new GetAllExtendedDataSchemasDatabaseAction(session,
					getInternalAccessMethod())));
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
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(queryEngineById.getClassName(), true);
		return queryEngine.getExample(key);
	}

	@Override
	public List<String> getQueryEngineExampleKeys(Long qeid) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getQueryEngineById(qeid);
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(queryEngineById.getClassName(), true);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultRenderEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SQueryEnginePluginConfiguration getDefaultQueryEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultQueryEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelComparePluginConfiguration getDefaultModelCompare() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultModelCompare());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelMergerPluginConfiguration getDefaultModelMerger() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultModelMerger());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SSerializerPluginConfiguration getDefaultSerializer() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultSerializer());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultObjectIDM());
		} catch (BimserverDatabaseException e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultRenderEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
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
		return getBimServer().getSConverter().convertToSListServiceDescriptor(getBimServer().getNotificationsManager().getInternalServices().values());
	}
	
	@Override
	public List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SServiceDescriptor> sServiceDescriptors = new ArrayList<SServiceDescriptor>();
			URL url = new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/services");
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
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/extendeddataschemas"), 5000);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			org.bimserver.models.store.Service externalProfile = session.get(StorePackage.eINSTANCE.getService(), soid, Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(externalProfile);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addLocalServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService, Long internalServiceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			AddLocalServiceToProjectDatabaseAction action = new AddLocalServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid, getBimServer().getSConverter().convertFromSObject(sService, session), internalServiceOid, getAuthorization());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			AddServiceToProjectDatabaseAction action = new AddServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid, getBimServer().getSConverter().convertFromSObject(sService, session), getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}



	@Override
	public void deleteService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteServiceDatabaseAction(session, getInternalAccessMethod(), oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public SExtendedDataSchema getExtendedDataSchemaByNamespace(String nameSpace) throws UserException, ServerException {
		// Not checking for real authentication here because a remote service should be able to use an exs
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByNamespaceDatabaseAction(session, getInternalAccessMethod(), nameSpace)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SInternalServicePluginConfiguration getInternalServiceById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SInternalServicePluginConfiguration convertToSObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetByIdDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), oid, StorePackage.eINSTANCE.getInternalServicePluginConfiguration())));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			InternalServicePluginConfiguration convertFromSObject = getBimServer().getSConverter().convertFromSObject(internalService, session);
			session.executeAndCommitAction(new UpdateDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), convertFromSObject));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddInternalServiceDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), getBimServer().getSConverter().convertFromSObject(internalService, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteInternalService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new DeleteInternalServiceDatabaseAction(session, getInternalAccessMethod(), oid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SInternalServicePluginConfiguration> getAllInternalServices(Boolean onlyEnabled) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings userSettings = getUserSettings(session);
			EList<InternalServicePluginConfiguration> services2 = userSettings.getServices();
			List<SInternalServicePluginConfiguration> services = getBimServer().getSConverter().convertToSListInternalServicePluginConfiguration(services2);
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
//		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
//		if (getCurrentUser() == null) {
//			getBimServer().getNotificationsManager().register(-1, endPoint);
//		} else {
//			getBimServer().getNotificationsManager().register(getCurrentUser().getOid(), endPoint);
//		}
//	}
	
	@Override
	public List<SProfileDescriptor> getAllPublicProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory());
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
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory());
			BimServerClient client = factory.create();
			return client.getRemoteServiceInterface().getPrivateProfiles(serviceIdentifier, token);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllLocalProfiles(String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		return getBimServer().getSConverter().convertToSObject(getBimServer().getPluginManager().getPlugin(className, false).getSettingsDefinition());
	}

	public SObjectType getPluginSettings(Long poid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, Query.getDefault());
			ObjectType settings = pluginConfiguration.getSettings();
			return getBimServer().getSConverter().convertToSObject(settings);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setPluginSettings(Long poid, SObjectType settings) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ObjectType convertedSettings = getBimServer().getSConverter().convertFromSObject(settings, session);
			SetPluginSettingsDatabaseAction action = new SetPluginSettingsDatabaseAction(session, getInternalAccessMethod(), poid, convertedSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SExtendedDataSchema getExtendedDataSchemaFromRepository(String namespace) throws UserException, ServerException {
		requireRealUserAuthentication();
		try {
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/extendeddataschemas?namespace=" + namespace), 5000);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			return getBimServer().getSConverter().convertToSListExtendedData(revision.getExtendedData());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SFile getFile(Long fileId) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			org.bimserver.models.store.File file = (org.bimserver.models.store.File)session.get(StorePackage.eINSTANCE.getFile(), fileId, Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(file);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long uploadFile(SFile file) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			org.bimserver.models.store.File convertFromSObject = getBimServer().getSConverter().convertFromSObject(file, session);
			UploadFileDatabaseAction action = new UploadFileDatabaseAction(session, getInternalAccessMethod(), convertFromSObject);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void triggerNewExtendedData(Long edid, Long soid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
//			org.bimserver.models.store.Service service = (org.bimserver.models.store.Service)session.get(StorePackage.eINSTANCE.getService(), soid, Query.getDefault());
			ExtendedData extendedData = (ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), edid, Query.getDefault());
			SExtendedDataAddedToRevision newExtendedData = new SExtendedDataAddedToRevision();
			newExtendedData.setRevisionId(extendedData.getRevision().getOid());
			newExtendedData.setExtendedDataId(edid);
			getBimServer().getNotificationsManager().notify(new NewExtendedDataNotification(edid, soid));
//			getBimServer().getNotificationsManager().triggerNewRevision(getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress(), newExtendedData, extendedData.getRevision().getProject(), extendedData.getRevision().getOid(), Trigger.NEW_EXTENDED_DATA, service);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void triggerNewRevision(Long roid, Long soid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			getBimServer().getNotificationsManager().notify(new NewRevisionNotification(revision.getProject().getOid(), revision.getOid(), soid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public String shareRevision(Long roid) {
		ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(roid, -1, -1, -1);
		return authorization.asHexToken(getBimServer().getEncryptionKey());
	}
	
	public Integer count(Long roid, String className) throws UserException ,ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			CountDatabaseAction action = new CountDatabaseAction(session, getInternalAccessMethod(), roid, className, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUserSettings getUserSettings() throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(user.getUserSettings());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void registerProgressHandler(Long topicId, Long endPointId) throws UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
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
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			getBimServer().getNotificationsManager().getProgressTopic(topicId).updateProgress(getBimServer().getSConverter().convertFromSObject(state, session));
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void registerNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = getBimServer().getNotificationsManager().getOrCreateNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
		try {
			newRevisionOnSpecificProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void unregisterNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid)).unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public Long registerProgressTopic(SProgressTopicType type, String description) throws UserException, ServerException {
		return getBimServer().getNotificationsManager().createProgressTopic(getCurrentUser().getOid(), type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnRevisionTopic(SProgressTopicType type, Long poid, Long roid, String description) throws UserException, ServerException {
		return getBimServer().getNotificationsManager().createProgressOnRevisionTopic(getCurrentUser().getOid(), poid, roid, type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnProjectTopic(SProgressTopicType type, Long poid, String description) throws UserException, ServerException {
		return getBimServer().getNotificationsManager().createProgressOnProjectTopic(getCurrentUser().getOid(), poid, type, description).getKey().getId();
	}

	@Override
	public void unregisterProgressTopic(Long topicId) {
		getBimServer().getNotificationsManager().unregister(topicId);
	}

	@Override
	public void registerNewProjectHandler(Long endPointId) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewProjectTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewProjectHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewProjectTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void registerNewUserHandler(Long endPointId) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewUserTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewUserHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewUserTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public List<Long> getProgressTopicsOnProject(Long poid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<Long> list = new ArrayList<Long>();
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			List<Long> revisionOids = new ArrayList<Long>();
			for (Revision revision : project.getRevisions()) {
				revisionOids.add(revision.getOid());
			}
			Set<ProgressTopic> progressOnProjectTopics = getBimServer().getNotificationsManager().getProgressOnProjectTopics(poid, revisionOids);
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
		for (ProgressOnRevisionTopic topic : getBimServer().getNotificationsManager().getProgressOnRevisionTopics(poid, roid)) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public List<Long> getProgressTopicsOnServer() {
		List<Long> list = new ArrayList<Long>();
		for (ProgressTopic topic : getBimServer().getNotificationsManager().getProgressOnServerTopics()) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public SLongActionState getProgress(Long topicId) throws UserException, ServerException {
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic != null) {
			return getBimServer().getSConverter().convertToSObject(progressTopic.getLastProgress());
		}
		return null;
	}
	
	@Override
	public void registerChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void registerChangeProgressOnServer(Long endPointId) throws ServerException, UserException {
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = getBimServer().getNotificationsManager().getChangeProgressTopicOnServerTopic();
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressTopicOnServerTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnServer(Long endPointId) throws ServerException, UserException {
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = getBimServer().getNotificationsManager().getChangeProgressTopicOnServerTopic();
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressTopicOnServerTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void registerChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
}