package org.bimserver.webservices.impl;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.collections.comparators.ComparatorChain;
import org.bimserver.BimServerImporter;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.AddExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.AddExtendedDataToProjectDatabaseAction;
import org.bimserver.database.actions.AddLocalServiceToProjectDatabaseAction;
import org.bimserver.database.actions.AddModelCheckerDatabaseAction;
import org.bimserver.database.actions.AddModelCheckerToProjectDatabaseAction;
import org.bimserver.database.actions.AddServiceToProjectDatabaseAction;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.AddUserToExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.AddUserToProjectDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.ChangeUserTypeDatabaseAction;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.database.actions.CompareDatabaseAction;
import org.bimserver.database.actions.DeleteServiceDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.GetAllAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfRevisionDatabaseAction;
import org.bimserver.database.actions.GetAllExtendedDataSchemasDatabaseAction;
import org.bimserver.database.actions.GetAllModelCheckersDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllReadableProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRelatedProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllServicesOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllUsersDatabaseAction;
import org.bimserver.database.actions.GetAllWritableProjectsDatabaseAction;
import org.bimserver.database.actions.GetAreaDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesInRevisionDatabaseAction;
import org.bimserver.database.actions.GetCheckinWarningsDatabaseAction;
import org.bimserver.database.actions.GetCheckoutWarningsDatabaseAction;
import org.bimserver.database.actions.GetGeoTagDatabaseAction;
import org.bimserver.database.actions.GetIfcHeaderDatabaseAction;
import org.bimserver.database.actions.GetModelCheckerOidDatabaseAction;
import org.bimserver.database.actions.GetOidByGuidDatabaseAction;
import org.bimserver.database.actions.GetProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetRevisionSummaryDatabaseAction;
import org.bimserver.database.actions.GetUserByUoidDatabaseAction;
import org.bimserver.database.actions.GetUserByUserNameDatabaseAction;
import org.bimserver.database.actions.GetVolumeDatabaseAction;
import org.bimserver.database.actions.RemoveModelCheckerFromProjectDatabaseAction;
import org.bimserver.database.actions.RemoveServiceFromProjectDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromProjectDatabaseAction;
import org.bimserver.database.actions.SetRevisionTagDatabaseAction;
import org.bimserver.database.actions.UndeleteUserDatabaseAction;
import org.bimserver.database.actions.UpdateGeoTagDatabaseAction;
import org.bimserver.database.actions.UpdateModelCheckerDatabaseAction;
import org.bimserver.database.actions.UpdateProjectDatabaseAction;
import org.bimserver.database.actions.UpdateRevisionDatabaseAction;
import org.bimserver.database.actions.UploadFileDatabaseAction;
import org.bimserver.database.actions.UserHasCheckinRightsDatabaseAction;
import org.bimserver.database.actions.UserHasRightsDatabaseAction;
import org.bimserver.database.actions.ValidateModelCheckerDatabaseAction;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SExtendedDataSchemaType;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.STrigger;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.DownloadParameters.DownloadType;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.mail.EmailMessage;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.notifications.NewExtendedDataOnRevisionNotification;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.compare.CompareWriter;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.MultiplexingInputStream;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.CheckoutComparator;
import org.bimserver.webservices.SRevisionComparator;
import org.bimserver.webservices.SServiceComparator;
import org.bimserver.webservices.SUserComparator;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class ServiceImpl extends GenericServiceImpl implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);

	public ServiceImpl(ServiceMap serviceMap) {
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
			Project project = session.get(poid, Query.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}
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
			String cacheFileName = dateFormat.format(new Date()) + "-" + fileName;
			File file = new File(userDirIncoming, cacheFileName);
			DeserializerPluginConfiguration deserializerObject = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, Query.getDefault());
			if (deserializerObject == null) {
				throw new UserException("Deserializer with oid " + deserializerOid + " not found");
			}
			InputStream inputStream = new MultiplexingInputStream(dataHandler.getInputStream(), new FileOutputStream(file));
			Deserializer deserializer = getBimServer().getDeserializerFactory().createDeserializer(deserializerOid);
			deserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData(project.getSchema()));
			
			IfcModelInterface model = deserializer.read(inputStream, fileName, 0, null);
			
			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, fileName, merge);
			LongCheckinAction longAction = new LongCheckinAction(getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
			getBimServer().getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
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
			URLConnection openConnection = url.openConnection();
			InputStream input = openConnection.getInputStream();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			if (fileName == null) {
				if (urlString.contains("/")) {
					fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
				} else {
					fileName = urlString;
				}
				fileName = URLDecoder.decode(fileName, Charsets.UTF_8.name());
			} else {
				fileName = dateFormat.format(new Date()) + "-" + fileName;
			}
			File file = new File(userDirIncoming, fileName);
			DeserializerPluginConfiguration deserializerObject = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, Query.getDefault());
			if (deserializerObject == null) {
				throw new UserException("Deserializer with oid " + deserializerOid + " not found");
			}
			InputStream inputStream = new MultiplexingInputStream(input, new FileOutputStream(file));
			Deserializer deserializer = getBimServer().getDeserializerFactory().createDeserializer(deserializerOid);
			deserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData("ifc2x3tc1"));

			IfcModelInterface model = deserializer.read(inputStream, fileName, 0, null);
			
			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, fileName, merge);
			LongCheckinAction longAction = new LongCheckinAction(getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
			getBimServer().getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
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
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration, String resetUrl) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			if (selfRegistration) {
				requireSelfregistrationAllowed();
			} else if (!getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireRealUserAuthentication();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), username, name, getBimServer().getSConverter().convertFromSObject(type), getAuthorization(),
					selfRegistration, resetUrl);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser addUserWithPassword(String username, String password, String name, SUserType type, Boolean selfRegistration, String resetUrl) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			if (selfRegistration) {
				requireSelfregistrationAllowed();
			} else if (!getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireRealUserAuthentication();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), username, password, name, getBimServer().getSConverter().convertFromSObject(type), getAuthorization(),
					selfRegistration, resetUrl);
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
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, false);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
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
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, true);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws ServerException, UserException {
		if (getBimServer().getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin()) {
			if (getCurrentUser().getUserType() != SUserType.ADMIN) {
				throw new UserException("Admin rights required to list users");
			}
		}
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
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
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
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, getInternalAccessMethod(), roid);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public void cleanupLongAction(Long actionId) throws UserException, ServerException {
		getBimServer().getLongActionManager().remove(actionId);
	}
	
	@Override
	public Long downloadCompareResults(Long serializerOid, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), DownloadType.DOWNLOAD_COMPARE);
		downloadParameters.setModelCompareIdentifier(mcid);
		downloadParameters.setCompareType(getBimServer().getSConverter().convertFromSObject(type));
		downloadParameters.setSerializerOid(serializerOid);
		Set<Long> roids = new HashSet<>();
		roids.add(roid1);
		roids.add(roid2);
		downloadParameters.setRoids(roids);
		
		return ((Bimsie1ServiceImpl)getServiceMap().getBimsie1ServiceInterface()).download(downloadParameters, sync);
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

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		if (getBimServer().getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin()) {
			if (getCurrentUser().getUserType() != SUserType.ADMIN) {
				throw new UserException("Admin rights required to list users");
			}
		}
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

			EmailMessage message = getBimServer().getMailSystem().createMessage();

			try {
				InternetAddress addressFrom = new InternetAddress(senderAddress);
				addressFrom.setPersonal(senderName);
				message.setFrom(addressFrom);

				InternetAddress[] addressTo = new InternetAddress[1];
				addressTo[0] = new InternetAddress(address);
				message.setRecipients(Message.RecipientType.TO, addressTo);

				message.setSubject("BIMserver Model Comparator");
				SCompareResult compareResult = compare(roid1, roid2, sCompareType, mcid);
				String html = CompareWriter.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), sCompareType, getServiceMap().getBimsie1ServiceInterface().getProjectByPoid(poid), false);
				message.setContent(html, "text/html");
				message.send();
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
	public List<SProject> getAllWritableProjects() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllWritableProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<String> getAvailableClassesInRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesInRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid);
			return session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long addExtendedDataSchema(SExtendedDataSchema extendedDataSchema) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ExtendedDataSchema convert = getBimServer().getSConverter().convertFromSObject(extendedDataSchema, session);
			return session.executeAndCommitAction(new AddExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			return handleException(e);
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
		SQueryEnginePluginConfiguration queryEngineById = getServiceMap().getBimsie1ServiceInterface().getQueryEngineById(qeid);
		SPluginDescriptor pluginDescriptor = getServiceMap().getPluginInterface().getPluginDescriptor(queryEngineById.getPluginDescriptorId());
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(pluginDescriptor.getPluginClassName(), true);
		return queryEngine.getExample(key);
	}

	@Override
	public List<String> getQueryEngineExampleKeys(Long qeid) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getServiceMap().getBimsie1ServiceInterface().getQueryEngineById(qeid);
		SPluginDescriptor pluginDescriptor = getServiceMap().getPluginInterface().getPluginDescriptor(queryEngineById.getPluginDescriptorId());
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(pluginDescriptor.getPluginClassName(), true);
		return new ArrayList<String>(queryEngine.getExampleKeys());
	}

	@Override
	public SServiceDescriptor getServiceDescriptor(String baseUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(baseUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(), getBimServer().getMetaDataManager());
			BimServerClientInterface client = factory.create();
			SServiceDescriptor service = client.getRemoteServiceInterface().getService(serviceIdentifier);
			if (service == null) {
				throw new UserException("No service found with identifier " + serviceIdentifier);
			}
			service.setUrl(baseUrl);
			return service;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SServiceDescriptor> getAllLocalServiceDescriptors() throws ServerException, UserException {
		return sort(getBimServer().getSConverter().convertToSListServiceDescriptor(getBimServer().getInternalServicesManager().getInternalServices(getAuthorization().getUoid()).values()));
	}
	
	@Override
	public List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SServiceDescriptor> sServiceDescriptors = new ArrayList<SServiceDescriptor>();
			URL url = new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/services.json");
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
				sServiceDescriptor.setCompanyUrl(service.getString("companyUrl"));
				sServiceDescriptor.setTokenUrl(service.getString("tokenUrl"));
				sServiceDescriptor.setNewProfileUrl(service.getString("newProfileUrl"));
				sServiceDescriptor.setProviderName(service.getString("providerName"));

				JSONObject rights = service.getJSONObject("rights");

				sServiceDescriptor.setReadRevision(rights.has("readRevision") && rights.getBoolean("readRevision"));
				sServiceDescriptor.setReadExtendedData(rights.has("readExtendedData") ? rights.getString("readExtendedData") : null);
				sServiceDescriptor.setWriteRevision(rights.has("writeRevision") && rights.getBoolean("writeRevision"));
				sServiceDescriptor.setWriteExtendedData(rights.has("writeExtendedData") ? rights.getString("writeExtendedData") : null);
				sServiceDescriptors.add(sServiceDescriptor);
			}
			
			sort(sServiceDescriptors);
			return sServiceDescriptors;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private List<SServiceDescriptor> sort(List<SServiceDescriptor> sServiceDescriptors) {
		ComparatorChain comparatorChain = new ComparatorChain();
		comparatorChain.addComparator(new Comparator<SServiceDescriptor>() {
			@Override
			public int compare(SServiceDescriptor o1, SServiceDescriptor o2) {
				return o1.getProviderName().compareTo(o2.getProviderName());
			}
		});
		comparatorChain.addComparator(new Comparator<SServiceDescriptor>(){
			@Override
			public int compare(SServiceDescriptor o1, SServiceDescriptor o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		Collections.sort(sServiceDescriptors, comparatorChain);
		return sServiceDescriptors;
	}

	@Override
	public List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SExtendedDataSchema> extendedDataSchemas = new ArrayList<SExtendedDataSchema>();
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/extendeddataschemas.json"), 5000);
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

	@Override
	public List<SModelCheckerInstance> getAllRepositoryModelCheckers() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SModelCheckerInstance> modelCheckers = new ArrayList<SModelCheckerInstance>();
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/modelcheckers"), 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray modelCheckersJson = root.getJSONArray("modelcheckers");
			for (int i = 0; i < modelCheckersJson.length(); i++) {
				JSONObject modelCheckerJson = modelCheckersJson.getJSONObject(i);
				
				SModelCheckerInstance sModelChecker = new SModelCheckerInstance();
				sModelChecker.setName(modelCheckerJson.getString("name"));
				sModelChecker.setCode(modelCheckerJson.getString("code"));
				sModelChecker.setDescription(modelCheckerJson.getString("description"));
				sModelChecker.setModelCheckerPluginClassName(modelCheckerJson.getString("modelCheckerPluginClassName"));
			
				modelCheckers.add(sModelChecker);
			}
			return modelCheckers;
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
	public Long addServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			AddServiceToProjectDatabaseAction action = new AddServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid, getBimServer().getSConverter().convertFromSObject(sService, session), getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
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

	@Override
	public List<SProfileDescriptor> getAllPublicProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(), getBimServer().getMetaDataManager());
			BimServerClientInterface client = factory.create();
			return client.getRemoteServiceInterface().getPublicProfiles(serviceIdentifier);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllPrivateProfiles(String notificationsUrl, String serviceIdentifier, String token) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(), getBimServer().getMetaDataManager());
			BimServerClientInterface client = factory.create();
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
					if (serviceIdentifier.equals("" + internalServicePluginConfiguration.getOid())) {
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
			ExtendedData extendedData = (ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), edid, Query.getDefault());
			SExtendedDataAddedToRevision newExtendedData = new SExtendedDataAddedToRevision();
			newExtendedData.setRevisionId(extendedData.getRevision().getOid());
			newExtendedData.setExtendedDataId(edid);
			getBimServer().getNotificationsManager().notify(new NewExtendedDataOnRevisionNotification(getBimServer(), edid, extendedData.getRevision().getProject().getOid(), extendedData.getRevision().getOid(), soid));
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
			getBimServer().getNotificationsManager().notify(new NewRevisionNotification(getBimServer(), revision.getProject().getOid(), revision.getOid(), soid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public String shareRevision(Long roid) throws UserException, ServerException {
		ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(getBimServer(), getCurrentUser().getOid(), -1, new long[]{roid}, -1, -1, -1);
		return authorization.asHexToken(getBimServer().getEncryptionKey());
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
	public List<SProjectSmall> getAllRelatedProjects(Long poid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetAllRelatedProjectsDatabaseAction action = new GetAllRelatedProjectsDatabaseAction(getBimServer(), session, getAuthorization(), getInternalAccessMethod(), poid);
			return action.execute();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SLogAction> getUserRelatedLogs(Long uoid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<LogAction> logActions = new ArrayList<LogAction>();
			User user = session.get(getAuthorization().getUoid(), Query.getDefault());
			IfcModelInterface projectsModel = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Query.getDefault());
			logActions.addAll(user.getLogs());
			for (IdEObject idEObject : projectsModel.getValues()) {
				if (idEObject instanceof Project) {
					Project project = (Project)idEObject;
					if ((user.getUserType() == UserType.ADMIN || (project.getState() == ObjectState.ACTIVE) && getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
						logActions.addAll(project.getLogs());
					}
				}
			}
			Collections.sort(logActions, new Comparator<LogAction>(){
				@Override
				public int compare(LogAction o1, LogAction o2) {
					return o1.getDate().compareTo(o2.getDate());
				}});
			return getBimServer().getSConverter().convertToSListLogAction(logActions);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SModelCheckerInstance getModelCheckerInstance(Long mcioid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetModelCheckerOidDatabaseAction action = new GetModelCheckerOidDatabaseAction(session, getInternalAccessMethod(), mcioid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Long addModelChecker(SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelCheckerInstance convert = getBimServer().getSConverter().convertFromSObject(modelCheckerInstance, session);
			return session.executeAndCommitAction(new AddModelCheckerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelCheckerInstance> getAllModelCheckers() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSListModelCheckerInstance(session.executeAndCommitAction(new GetAllModelCheckersDatabaseAction(session,
					getInternalAccessMethod())));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelChecker(SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateModelCheckerDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getBimServer().getSConverter().convertFromSObject(modelCheckerInstance, session));
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void validateModelChecker(Long oid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new ValidateModelCheckerDatabaseAction(getBimServer(), session, getInternalAccessMethod(), oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SModelCheckerInstance> getAllModelCheckersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Project project = session.get(poid, Query.getDefault());
			return getBimServer().getSConverter().convertToSListModelCheckerInstance(project.getModelCheckers());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCheckerToProject(Long poid, Long modelCheckerOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelCheckerInstance modelChecker = session.get(modelCheckerOid, Query.getDefault());
			AddModelCheckerToProjectDatabaseAction action = new AddModelCheckerToProjectDatabaseAction(session, getInternalAccessMethod(), poid, modelChecker, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeModelCheckerFromProject(Long poid, Long modelCheckerOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveModelCheckerFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), modelCheckerOid, poid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void removeServiceFromProject(Long poid, Long serviceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveServiceFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), serviceOid, poid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void importData(String address, String username, String password, String path) {
		new BimServerImporter(getBimServer(), address, username, password, path).start();
	}

	@Override
	public SIfcHeader getIfcHeader(Long croid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<SIfcHeader> action = new GetIfcHeaderDatabaseAction(getBimServer(), session, getInternalAccessMethod(), croid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Double getArea(Long roid, Long oid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Double> action = new GetAreaDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Double getVolume(Long roid, Long oid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Double> action = new GetVolumeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}