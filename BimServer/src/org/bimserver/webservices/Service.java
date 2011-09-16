package org.bimserver.webservices;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLvDEADLOCK_RETRIES
 * http://www.gnu.org/licenses/gpl-DEADLOCK_RETRIES.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version DEADLOCK_RETRIES of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * Long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.bimserver.BimServer;
import org.bimserver.ServerInfo.ServerState;
import org.bimserver.changes.AddAttributeChange;
import org.bimserver.changes.AddReferenceChange;
import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveAttributeChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.RemoveReferenceChange;
import org.bimserver.changes.SetAttributeChange;
import org.bimserver.changes.SetReferenceChange;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.AddGuidanceProviderDatabaseAction;
import org.bimserver.database.actions.AddProjectDatabaseAction;
import org.bimserver.database.actions.AddSerializerDatabaseAction;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.AddUserToProjectDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.ChangePasswordDatabaseAction;
import org.bimserver.database.actions.ChangeUserTypeDatabaseAction;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.database.actions.CheckinPart1DatabaseAction;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.database.actions.CompareDatabaseAction;
import org.bimserver.database.actions.DeleteDeserializerDatabaseAction;
import org.bimserver.database.actions.DeleteGuidanceProviderDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.DeleteSerializerDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.GetAllAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfRevisionDatabaseAction;
import org.bimserver.database.actions.GetAllDeserializersDatabaseAction;
import org.bimserver.database.actions.GetAllGuidanceProvidersDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllReadableProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllSerializersDatabaseAction;
import org.bimserver.database.actions.GetAllUsersDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesDatabaseAction;
import org.bimserver.database.actions.GetCheckoutWarningsDatabaseAction;
import org.bimserver.database.actions.GetClashDetectionSettingsDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByGuidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByOidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsByTypeDatabaseAction;
import org.bimserver.database.actions.GetDatabaseInformationAction;
import org.bimserver.database.actions.GetDeserializerByNameDatabaseAction;
import org.bimserver.database.actions.GetGeoTagDatabaseAction;
import org.bimserver.database.actions.GetGuidanceProviderByIdDatabaseAction;
import org.bimserver.database.actions.GetLogsDatabaseAction;
import org.bimserver.database.actions.GetProjectByPoidDatabaseAction;
import org.bimserver.database.actions.GetProjectsByNameDatabaseAction;
import org.bimserver.database.actions.GetRevisionDatabaseAction;
import org.bimserver.database.actions.GetRevisionSummaryDatabaseAction;
import org.bimserver.database.actions.GetSerializerByContentTypeDatabaseAction;
import org.bimserver.database.actions.GetSerializerByIdDatabaseAction;
import org.bimserver.database.actions.GetSerializerByNameDatabaseAction;
import org.bimserver.database.actions.GetSubProjectsDatabaseAction;
import org.bimserver.database.actions.GetUserByUoidDatabaseAction;
import org.bimserver.database.actions.GetUserByUserNameDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromProjectDatabaseAction;
import org.bimserver.database.actions.RequestPasswordChangeDatabaseAction;
import org.bimserver.database.actions.SendClashesEmailDatabaseAction;
import org.bimserver.database.actions.SetHttpCallbackUrlDatabaseAction;
import org.bimserver.database.actions.SetRevisionTagDatabaseAction;
import org.bimserver.database.actions.UndeleteProjectDatabaseAction;
import org.bimserver.database.actions.UndeleteUserDatabaseAction;
import org.bimserver.database.actions.UpdateClashDetectionSettingsDatabaseAction;
import org.bimserver.database.actions.UpdateDeserializerDatabaseAction;
import org.bimserver.database.actions.UpdateGeoTagDatabaseAction;
import org.bimserver.database.actions.UpdateGuidanceProviderDatabaseAction;
import org.bimserver.database.actions.UpdateProjectDatabaseAction;
import org.bimserver.database.actions.UpdateRevisionDatabaseAction;
import org.bimserver.database.actions.UpdateSerializerDatabaseAction;
import org.bimserver.database.actions.UserHasCheckinRightsDatabaseAction;
import org.bimserver.database.actions.UserHasRightsDatabaseAction;
import org.bimserver.database.actions.ValidateUserDatabaseAction;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.IntegerLiteral;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.ifc.compare.CompareResult.Item;
import org.bimserver.ifc.compare.CompareResult.ObjectAdded;
import org.bimserver.ifc.compare.CompareResult.ObjectDeleted;
import org.bimserver.ifc.compare.CompareResult.ObjectModified;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDeserializer;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SGuidanceProvider;
import org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongAction;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSession;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.GuidClash;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.objects.DatabaseInformation;
import org.bimserver.shared.objects.LongActionState;
import org.bimserver.shared.objects.SCheckoutResult;
import org.bimserver.shared.objects.SCompareResult;
import org.bimserver.shared.objects.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.objects.SCompareResult.SCompareType;
import org.bimserver.shared.objects.SCompareResult.SObjectAdded;
import org.bimserver.shared.objects.SCompareResult.SObjectModified;
import org.bimserver.shared.objects.SCompareResult.SObjectRemoved;
import org.bimserver.shared.objects.SDownloadResult;
import org.bimserver.utils.Hashers;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service implements ServiceInterface {
	private static final Integer DEFAULT_LOGIN_ERROR_TIMEOUT = 3000;
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
	public static final Integer DEADLOCK_RETRIES = 10;
	private final ServiceFactory serviceFactory;

	private final BimServer bimServer;
	private final AccessMethod accessMethod;
	private Set<Change> changes = null;

	private Long currentUoid = -1L;
	private Date activeSince;
	private Date lastActive;
	private Token token;
	private Integer transactionPid;

	private SConverter converter = new SConverter();

	public Service(BimServer bimServer, AccessMethod accessMethod, ServiceFactory serviceFactory) {
		this.accessMethod = accessMethod;
		this.serviceFactory = serviceFactory;
		this.bimServer = bimServer;
		activeSince = new Date();
		lastActive = new Date();
	}

	@Override
	public SCheckinResult checkinSync(final Long poid, final String comment, String deserializerName, Long fileSize, DataHandler ifcFile, Boolean merge) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		return checkinInternal(poid, comment, deserializerName, fileSize, ifcFile, true, merge);
	}

	@Override
	public SCheckinResult checkinAsync(final Long poid, final String comment, String deserializerName, Long fileSize, DataHandler ifcFile, Boolean merge) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		return checkinInternal(poid, comment, deserializerName, fileSize, ifcFile, false, merge);
	}

	private SCheckinResult checkinInternal(final Long poid, final String comment, String deserializerName, Long fileSize, DataHandler dataHandler, Boolean sync, Boolean merge)
			throws UserException, ServerException {
		final BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			InputStream inputStream = dataHandler.getInputStream();
			EmfDeserializer deserializer = bimServer.getEmfDeserializerFactory().createDeserializer(deserializerName);
			try {
				deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
			} catch (PluginException e) {
				throw new UserException(e);
			}
			IfcModelInterface model = deserializer.read(dataHandler.getInputStream(), dataHandler.getName(), false, fileSize);
			SCheckinResult checkinResult = null;
			if (sync) {
				checkinResult = processCheckinSync(poid, comment, fileSize, session, model, merge);
			} else {
				checkinResult = processCheckinAsync(poid, comment, fileSize, session, model, merge);
			}
			inputStream.close();
			return checkinResult;
		} catch (IOException e) {
			LOGGER.error("", e);
			throw new UserException("IOException", e);
		} catch (DeserializeException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}

	private SCheckinResult processCheckinSync(final Long poid, final String comment, Long fileSize, final BimDatabaseSession session, IfcModelInterface model, Boolean merge)
			throws UserException, ServerException {
		BimDatabaseAction<ConcreteRevision> action = new CheckinDatabaseAction(session, accessMethod, model, poid, currentUoid, comment);
		try {
			ConcreteRevision concreteRevision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			for (Revision revision : concreteRevision.getRevisions()) {
				NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
				newRevisionAdded.setDate(new Date());
				newRevisionAdded.setExecutor(action.getUserByUoid(currentUoid));
				newRevisionAdded.setRevision(revision);
				newRevisionAdded.setAccessMethod(action.getAccessMethod());
				bimServer.getNotificationsManager().notify(newRevisionAdded);
			}
			SCheckinResult result = new SCheckinResult();
			result.setRid(concreteRevision.getId());
			result.setProjectId(concreteRevision.getProject().getOid());
//			result.setProjectName(concreteRevision.getProject().getName());
			return result;
		} catch (Exception e) {
			handleException(e);
			return null;
		}
	}

	private SCheckinResult processCheckinAsync(final Long poid, final String comment, Long fileSize, final BimDatabaseSession session, IfcModelInterface model, Boolean merge)
			throws UserException {
		try {
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(session, accessMethod, poid, currentUoid, model, comment);
			GetUserByUoidDatabaseAction getUserByUoidDatabaseAction = new GetUserByUoidDatabaseAction(session, accessMethod, currentUoid);
			User userByUoid = session.executeAction(getUserByUoidDatabaseAction, DEADLOCK_RETRIES);
			ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			session.close();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, null, accessMethod, model, currentUoid, revision.getOid(), merge);
			SCheckinResult result = new SCheckinResult();
			result.setRid(revision.getId());
			result.setProjectId(revision.getProject().getOid());
//			result.setProjectName(revision.getProject().getName());
			bimServer.getLongActionManager().start(new LongCheckinAction(bimServer, userByUoid, createCheckinAction));
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
			new ServerException("Unknown error", e);
		}
		return null;
	}

	@Override
	public Integer checkoutLastRevision(Long poid, String formatIdentifier, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false);
			return checkout(project.getLastRevision().getOid(), formatIdentifier, sync);
		} catch (Exception e) {
			handleException(e);
			return -1;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer checkout(Long roid, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		// TODO
		// ResultType serializerDescriptor =
		// EmfSerializerFactory.getInstance().getResultType(resultTypeName);
		// if (serializerDescriptor.getSerializerClass() !=
		// IfcStepSerializer.class && serializerDescriptor.getSerializerClass()
		// != IfcXmlSerializer.class) {
		// throw new
		// UserException("Only IFC or IFCXML allowed when checking out");
		// }
		DownloadParameters downloadParameters = new DownloadParameters(bimServer, roid, resultTypeName);
		LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(bimServer, downloadParameters, currentUoid, accessMethod);
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
	public Long addUser(String username, String name, SUserType type, Boolean selfRegistration) throws UserException, ServerException {
		if (!selfRegistration) {
			requireAuthenticationAndRunningServer();
		} else if (!bimServer.getSettingsManager().getSettings().isAllowSelfRegistration()) {
			requireSelfregistrationAllowed();
		}
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Long> action = new AddUserDatabaseAction(bimServer, session, accessMethod, username, name, converter.convertFromSObject(type), currentUoid,
					selfRegistration);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return -1L;
		} finally {
			session.close();
		}
	}

	private void handleException(Exception e) throws UserException, ServerException {
		if (e instanceof UserException) {
			throw (UserException) e;
		} else if (e instanceof ServerException) {
			LOGGER.error("", e);
			throw (ServerException) e;
		} else if (e instanceof BimDatabaseException) {
			LOGGER.error("", e);
			throw new ServerException("Database error", e);
		}
		LOGGER.error("", e);
		throw new ServerException("Unknown error", e);
	}

	@Override
	public SProject addProject(String projectName) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, currentUoid);
			return converter.convertToSObject(session.executeAndCommitAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(session, accessMethod, currentUoid, uoid, poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, accessMethod, currentUoid);
			return converter.convertToSListProject(session.executeAction(action, DEADLOCK_RETRIES));
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
		if (getCurrentUser().getUserType() != SUserType.ADMIN && getCurrentUser().getUserType() != SUserType.SYSTEM) {
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
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, accessMethod, poid);
			return converter.convertToSListRevision(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, false);
			return converter.convertToSListCheckout(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, accessMethod, poid, true);
			return converter.convertToSListCheckout(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(session, accessMethod, currentUoid);
			return converter.convertToSListUser(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean login(String username, String password) throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && Hashers.getSha256Hash(password).equals(user.getPassword())) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				} else if (user.getUserType() == UserType.SYSTEM) {
					throw new UserException("System user cannot login");
				}
				this.currentUoid = user.getOid();
				updateLastActive(user.getOid());
				return true;
			} else {
				try {
					Thread.sleep(DEFAULT_LOGIN_ERROR_TIMEOUT);
				} catch (InterruptedException e) {
					LOGGER.error("", e);
				}
				throw new UserException("Invalid username/password combination");
			}
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListCheckout(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListRevision(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SRevision getRevision(Long roid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, accessMethod, roid, currentUoid);
			return converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, accessMethod, roid);
			return converter.convertToSListCheckout(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	public Integer download(Long roid, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, resultTypeName), sync);
	}

	private Integer download(DownloadParameters downloadParameters, Boolean sync) throws UserException, ServerException {
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(bimServer, downloadParameters, currentUoid, accessMethod);
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
	public SDownloadResult getDownloadData(final Integer actionId) throws UserException, ServerException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			longAction.waitForCompletion();
			SCheckoutResult result = longAction.getCheckoutResult();
			bimServer.getLongActionManager().remove(actionId);
			return result;
		} else {
			throw new UserException("No data found for laid " + actionId);
		}
	}

	@Override
	public LongActionState getDownloadState(Integer actionId) throws UserException, ServerException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			return longAction.getState();
		} else {
			throw new UserException("No state found for laid " + actionId);
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteUser(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean removeUserFromProject(Long uoid, Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(session, accessMethod, uoid, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByOids(Set<Long> roids, Set<Long> oids, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, resultTypeName, roids, oids), sync);
	}

	@Override
	public Integer downloadOfType(Long roid, String className, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, className, resultTypeName), sync);
	}

	@Override
	public List<String> getAvailableClasses() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(session, accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public DatabaseInformation getDatabaseInformation() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(session, accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByGuids(Set<Long> roids, Set<String> guids, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roids, guids, resultTypeName), sync);
	}

	@Override
	public SUser getLoggedInUser() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return getUserByUoid(currentUoid);
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSListProject(session.executeAction(action, DEADLOCK_RETRIES));
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
	public Boolean changePassword(Long uoid, String oldPassword, String newPassword) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(session, accessMethod, uoid, oldPassword, newPassword, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, username);
			SUser convert = converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
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
	public Boolean loginAsSystem() throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, "system");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
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
	public Boolean undeleteProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteUser(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, parentPoid, currentUoid);
			return converter.convertToSObject(session.executeAndCommitAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(session, accessMethod, currentUoid, sProject);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(session, accessMethod, currentUoid, sRevision);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private static String getName(EObject eObject) {
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			if (ifcRoot.getName() != null) {
				return ifcRoot.getName();
			}
		}
		return null;
	}

	private static String getGuid(EObject eObject) {
		if (eObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) eObject;
			if (ifcRoot.getGlobalId() != null) {
				return ifcRoot.getGlobalId().getWrappedValue();
			}
		}
		return null;
	}

	public static SCompareResult convertCompareResults(CompareResult compareResult, Class<SCompareResult> class1, BimDatabaseSession session) {
		SCompareResult sCompareResult = new SCompareResult();
		Map<EClass, List<Item>> items = compareResult.getItems();
		for (EClass key : items.keySet()) {
			List<Item> list = items.get(key);
			for (Item item : list) {
				SDataObject dataObject = new SDataObject();
				dataObject.setType(item.geteObject().eClass().getName());
				dataObject.setOid(item.geteObject().getOid());
				dataObject.setGuid(getGuid(item.geteObject()));
				dataObject.setName(getName(item.geteObject()));
				if (item instanceof ObjectAdded) {
					sCompareResult.add(new SObjectAdded(dataObject));
				} else if (item instanceof ObjectDeleted) {
					sCompareResult.add(new SObjectRemoved(dataObject));
				} else if (item instanceof ObjectModified) {
					ObjectModified objectModified = (ObjectModified) item;
					sCompareResult.add(new SObjectModified(dataObject, objectModified.getFeature().getName(), objectModified.getOldValue() == null ? "null" : objectModified
							.getOldValue().toString(), objectModified.getNewValue() == null ? "null" : objectModified.getNewValue().toString()));
				}
			}
		}
		return sCompareResult;
	}

	@Override
	public SCompareResult compare(Long roid1, Long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(bimServer, session, accessMethod, currentUoid, roid1, roid2, sCompareType, sCompareIdentifier);
			return convertCompareResults(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SCompareResult.class, session);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, accessMethod, roid);
			return converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(session, accessMethod, currentUoid, poid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckoutWarnings(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(session, accessMethod, poid, currentUoid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasRights(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(session, accessMethod, getCurrentUser().getOid(), poid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadProjects(Set<Long> roids, String resultTypeName, Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roids, resultTypeName), sync);
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid, String className) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<SDataObject> action = new GetDataObjectByOidDatabaseAction(bimServer, session, accessMethod, roid, oid, session.getCidForClassName(className));
			SDataObject dataObject = session.executeAction(action, DEADLOCK_RETRIES);
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<SDataObject> action = new GetDataObjectByGuidDatabaseAction(bimServer, session, accessMethod, roid, guid);
			SDataObject dataObject = session.executeAction(action, DEADLOCK_RETRIES);
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String className) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		BimDatabaseAction<List<SDataObject>> action = new GetDataObjectsByTypeDatabaseAction(bimServer, session, accessMethod, roid, className);
		try {
			List<SDataObject> dataObjects = session.executeAction(action, DEADLOCK_RETRIES);
			return dataObjects;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidClash> findClashesByGuid(SClashDetectionSettings sClashDetectionSettings) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			return converter.convertToSListGuidClash(session.executeAction(
					new FindClashesDatabaseAction<GuidClash>(bimServer, session, accessMethod, converter.convertFromSObject(sClashDetectionSettings, session), currentUoid),
					DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SEidClash> findClashesByEid(SClashDetectionSettings sClashDetectionSettings) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			return converter.convertToSListEidClash(session.executeAction(
					new FindClashesDatabaseAction<EidClash>(bimServer, session, accessMethod, converter.convertFromSObject(sClashDetectionSettings, session), currentUoid),
					DEADLOCK_RETRIES));
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
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Revision oldRevision = session.get(StorePackage.eINSTANCE.getRevision(), roid, false);
			Project oldProject = oldRevision.getProject();
			User user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			IfcModelSet ifcModelSet = new IfcModelSet();
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel();
				session.getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
			IfcModelInterface model = bimServer.getMergerFactory().createMerger()
					.merge(oldRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
			model.resetOids();
			Project newProject = new AddProjectDatabaseAction(bimServer, session, accessMethod, projectName, currentUoid).execute();
			session.commit();
			session.close();
			session = bimServer.getDatabase().createSession(true);
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(session, accessMethod, newProject.getOid(), currentUoid, model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, session, accessMethod, model, currentUoid, revision.getOid(), false);
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setProjectId(revision.getProject().getOid());
//				result.setProjectName(revision.getProject().getName());
				bimServer.getLongActionManager().start(new LongCheckinAction(bimServer, user, createCheckinAction));
				return result;
			} catch (UserException e) {
				throw e;
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SCheckinResult branchToExistingProject(Long roid, Long destPoid, String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		final BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Revision oldRevision = session.get(StorePackage.eINSTANCE.getRevision(), roid, false);
			Project oldProject = oldRevision.getProject();
			User user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			IfcModelSet ifcModelSet = new IfcModelSet();
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel();
				session.getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
			IfcModelInterface model = bimServer.getMergerFactory().createMerger()
					.merge(oldRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
			model.resetOids();
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(session, accessMethod, destPoid, currentUoid, model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, session, accessMethod, model, currentUoid, revision.getOid(), false);
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setProjectId(revision.getProject().getOid());
//				result.setProjectName(revision.getProject().getName());
				bimServer.getLongActionManager().start(new LongCheckinAction(bimServer, user, createCheckinAction));
				return result;
			} catch (UserException e) {
				throw e;
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SLogAction> getLogs() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(session, accessMethod, currentUoid);
			List<LogAction> logs = session.executeAction(action, DEADLOCK_RETRIES);
			return converter.convertToSListLogAction(logs);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(Long goid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(session, accessMethod, currentUoid, goid);
			return converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(session, accessMethod, currentUoid, sGeoTag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SClashDetectionSettings getClashDetectionSettings(Long cdsoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<ClashDetectionSettings> action = new GetClashDetectionSettingsDatabaseAction(session, accessMethod, currentUoid, cdsoid);
			return converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateClashDetectionSettings(SClashDetectionSettings sClashDetectionSettings) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateClashDetectionSettingsDatabaseAction(session, accessMethod, currentUoid, sClashDetectionSettings);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
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
	public SUser getUserByUoid(Long uoid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, accessMethod, uoid);
			return converter.convertToSObject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
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

	@Override
	public SUser getAnonymousUser() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return getUserByUserName("anonymous");
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(converter.convertToSSetUser((session.executeAction(action, DEADLOCK_RETRIES))));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(session, accessMethod, poid);
			return new ArrayList<SUser>(converter.convertToSSetUser(session.executeAction(action, DEADLOCK_RETRIES)));
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
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), uoid, false);
			return new ArrayList<SProject>(converter.convertToSSetProject(user.getHasRightsOn()));
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, accessMethod, name, currentUoid);
			return (List<SProject>) converter.convertToSListProject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (BimDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean autologin(String username, String hash) throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && hash.equals(Hashers.getSha256Hash(user.getUsername() + user.getPassword()))) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				} else if (user.getUserType() == UserType.SYSTEM) {
					throw new UserException("System user cannot login");
				}
				currentUoid = user.getOid();
				updateLastActive(user.getOid());
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
	public void setRevisionTag(Long roid, String tag) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(session, accessMethod, roid, tag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getSubProjects(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, accessMethod, currentUoid, poid);
			return converter.convertToSListProject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(Long uoid, SUserType userType) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(session, accessMethod, currentUoid, uoid, userType);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setExportTypeEnabled(String resultTypeName, Boolean enabled) throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			if (user.getUserType() != UserType.ADMIN) {
				throw new UserException("Only admin users can change enabled export types");
			}
			Set<String> resultTypes = bimServer.getSettingsManager().getEnabledExportTypesAsSet();
			if (enabled) {
				resultTypes.add(resultTypeName);
			} else {
				resultTypes.remove(resultTypeName);
			}
			bimServer.getSettingsManager().updateEnabledResultTypes(resultTypes);
			bimServer.getSettingsManager().saveSettings();
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getCurrentUser() throws UserException {
		if (currentUoid == -1) {
			return null;
		}
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			return converter.convertToSObject(user);
		} finally {
			session.close();
		}
	}

	public void close() {
	}

	@Override
	public Boolean isLoggedIn() {
		return currentUoid != -1;
	}

	@Override
	public String getSettingCustomLogoAddress() throws UserException, ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getCustomLogoAddress();
	}

	@Override
	public void setSettingCustomLogoAddress(String customLogoAddress) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCustomLogoAddress(customLogoAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingEmailSenderAddress() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getEmailSenderAddress();
	}

	@Override
	public void setSettingEmailSenderAddress(String emailSenderAddress) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setEmailSenderAddress(emailSenderAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingEnabledExportTypes() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getEnabledExportTypes();
	}

	@Override
	public void setSettingEnabledExportTypes(Set<String> enabledExportTypeNames) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		bimServer.getSettingsManager().updateEnabledResultTypes(enabledExportTypeNames);
	}

	@Override
	public String getSettingRegistrationAddition() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getRegistrationAddition();
	}

	@Override
	public void setSettingRegistrationAddition(String registrationAddition) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setRegistrationAddition(registrationAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingSiteAddress() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getSiteAddress();
	}

	@Override
	public void setSettingSiteAddress(String siteAddress) throws UserException, ServerException {
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
	public String getSettingSmtpServer() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getSmtpServer();
	}

	@Override
	public void setSettingSmtpServer(String smtpServer) throws UserException, ServerException {
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
	public Boolean isSettingAllowSelfRegistration() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isAllowSelfRegistration();
	}

	@Override
	public void setSettingAllowSelfRegistration(Boolean allowSelfRegistration) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowSelfRegistration(allowSelfRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAllowUsersToCreateTopLevelProjects() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isAllowUsersToCreateTopLevelProjects();
	}

	@Override
	public void setSettingAllowUsersToCreateTopLevelProjects(Boolean allowUsersToCreateTopLevelProjects) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAutoTestClashes() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isAutoTestClashes();
	}

	@Override
	public void setSettingAutoTestClashes(Boolean autoTestClashes) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAutoTestClashes(autoTestClashes);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCheckinMergingEnabled() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isCheckinMergingEnabled();
	}

	@Override
	public void setSettingCheckinMergingEnabled(Boolean checkinMergingEnabled) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCheckinMergingEnabled(checkinMergingEnabled);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingIntelligentMerging() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isIntelligentMerging();
	}

	@Override
	public void setSettingIntelligentMerging(Boolean intelligentMerging) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setIntelligentMerging(intelligentMerging);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingSendConfirmationEmailAfterRegistration() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isSendConfirmationEmailAfterRegistration();
	}

	@Override
	public void setSettingSendConfirmationEmailAfterRegistration(Boolean sendConfirmationEmailAfterRegistration) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingShowVersionUpgradeAvailable() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isShowVersionUpgradeAvailable();
	}

	@Override
	public void setSettingShowVersionUpgradeAvailable(Boolean showVersionUpgradeAvailable) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setShowVersionUpgradeAvailable(showVersionUpgradeAvailable);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCacheOutputFiles() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().isCacheOutputFiles();
	}

	@Override
	public void setSettingCacheOutputFiles(Boolean cacheOutputFiles) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCacheOutputFiles(cacheOutputFiles);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void loginAnonymous() throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, accessMethod, "anonymous");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			currentUoid = user.getOid();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUserSession> getActiveUserSessions() throws ServiceException {
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
	public void sendCompareEmail(SCompareType sCompareType, SCompareIdentifier sCompareIdentifier, Long poid, Long roid1, Long roid2, String address) throws UserException,
			ServerException {
		SUser currentUser = getCurrentUser();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, false);
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, false);
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
				SCompareResult compareResult = compare(roid1, roid2, sCompareType, sCompareIdentifier);
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
	public void requestPasswordChange(Long uoid) throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(session, accessMethod, bimServer, uoid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void sendClashesEmail(SClashDetectionSettings sClashDetectionSettings, Long poid, Set<String> addressesTo) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new SendClashesEmailDatabaseAction(bimServer, session, accessMethod, currentUoid, poid, sClashDetectionSettings, addressesTo);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void validateAccount(Long uoid, String token, String password) throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new ValidateUserDatabaseAction(session, accessMethod, uoid, token, password);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SLongAction> getActiveLongActions() throws ServerException, ServiceException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getLongActionManager().getActiveLongActions();
	}

	@Override
	public List<SProject> getAllReadableProjects() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(session, accessMethod, currentUoid);
			return converter.convertToSListProject(session.executeAction(action, DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Date getLastDatabaseReset() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return session.getCreatedDate();
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	private void updateLastActive(Long uoid) throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), uoid, false);
			user.setLastSeen(new Date());
			session.store(user);
			session.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setup(String siteAddress, String smtpServer, String adminName, String adminUsername, String adminPassword, Boolean createAnonymousUser) throws UserException,
			ServerException {
		setSettingSmtpServer(smtpServer);
		setSettingSiteAddress(siteAddress);

		if (adminUsername.trim().isEmpty()) {
			throw new UserException("Admin Username cannot be empty");
		}

		if (adminPassword.trim().isEmpty()) {
			throw new UserException("Admin Password cannot be empty");
		}

		bimServer.getServerInfo().update();

		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			new AddUserDatabaseAction(bimServer, session, AccessMethod.INTERNAL, adminUsername, adminPassword, adminName, UserType.ADMIN, -1, false).execute();
			if (createAnonymousUser) {
				new AddUserDatabaseAction(bimServer, session, AccessMethod.INTERNAL, "anonymous", "anonymous", "Anonymous", UserType.ANONYMOUS, -1, false).execute();
			}
			session.commit();
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	@Override
	public Set<SMigration> getMigrations() throws UserException {
		requireAuthentication();
		Migrator migrator = bimServer.getDatabase().getMigrator();
		return migrator.getMigrations();
	}

	@Override
	public void migrateDatabase() throws ServerException, UserException {
		requireAuthentication();
		try {
			bimServer.getDatabase().getMigrator().migrate();
			bimServer.getServerInfo().update();
		} catch (MigrationException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} catch (InconsistentModelsException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		}
	}

	@Override
	public List<SSerializer> getAllSerializers(Boolean onlyEnabled) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			List<SSerializer> serializers = converter.convertToSListSerializer(session.executeAction(new GetAllSerializersDatabaseAction(session, accessMethod, bimServer,
					onlyEnabled), DEADLOCK_RETRIES));
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
	public List<SDeserializer> getAllDeserializers(Boolean onlyEnabled) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			List<SDeserializer> deserializers = converter.convertToSListDeserializer(session.executeAction(new GetAllDeserializersDatabaseAction(session, accessMethod, bimServer,
					onlyEnabled), DEADLOCK_RETRIES));
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
	public void addSerializer(SSerializer serializer) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Serializer convert = converter.convertFromSObject(serializer, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(session, accessMethod, convert), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializer serializer) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Serializer convert = converter.convertFromSObject(serializer, session);
			if (convert.getGuidanceProvider() != null) {
				session.store(convert.getGuidanceProvider());
			}
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(session, accessMethod, convert), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateDeserializer(SDeserializer deserializer) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Deserializer convert = converter.convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, accessMethod, convert), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidanceProvider> getAllGuidanceProviders() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSListGuidanceProvider(session.executeAction(new GetAllGuidanceProvidersDatabaseAction(session, accessMethod), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addGuidanceProvider(SGuidanceProvider guidanceProvider) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			session.executeAndCommitAction(new AddGuidanceProviderDatabaseAction(session, accessMethod, converter.convertFromSObject(guidanceProvider, session)), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGuidanceProvider(SGuidanceProvider guidanceProvider) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			session.executeAndCommitAction(new UpdateGuidanceProviderDatabaseAction(session, accessMethod, converter.convertFromSObject(guidanceProvider, session)),
					DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializer getSerializerById(Long oid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSObject(session.executeAction(new GetSerializerByIdDatabaseAction(session, accessMethod, oid), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SGuidanceProvider getGuidanceProviderById(Long oid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSObject(session.executeAction(new GetGuidanceProviderByIdDatabaseAction(session, accessMethod, oid), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Set<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory().getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteGuidanceProvider(Long ifid) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new DeleteGuidanceProviderDatabaseAction(session, accessMethod, ifid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSerializer(Long sid) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new DeleteSerializerDatabaseAction(session, accessMethod, sid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDeserializer(Long sid) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<Void> action = new DeleteDeserializerDatabaseAction(session, accessMethod, sid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingFooterAddition(String footerAddition) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setFooterAddition(footerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void setSettingHeaderAddition(String headerAddition) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setHeaderAddition(headerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingFooterAddition() throws UserException, ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getFooterAddition();
	}

	@Override
	public String getSettingHeaderAddition() throws UserException, ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getHeaderAddition();
	}

	@Override
	public SMergeIdentifier getSettingMergeIdentifier() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		return converter.convertToSObject(settings.getMergeIdentifier());
	}

	@Override
	public void setSettingMergeIdentifier(SMergeIdentifier mergeIdentifier) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setMergeIdentifier(MergeIdentifier.valueOf(mergeIdentifier.name()));
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public SSerializer getSerializerByName(String serializerName) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSObject(session.executeAction(new GetSerializerByNameDatabaseAction(session, accessMethod, serializerName), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializer getDeserializerByName(String deserializerName) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSObject(session.executeAction(new GetDeserializerByNameDatabaseAction(session, accessMethod, deserializerName), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializer getSerializerByContentType(String contentType) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			return converter.convertToSObject(session.executeAction(new GetSerializerByContentTypeDatabaseAction(session, accessMethod, contentType), DEADLOCK_RETRIES));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SSerializer> getEnabledSerializers() throws UserException, ServerException {
		List<SSerializer> serializers = getAllSerializers(true);
		List<SSerializer> result = new ArrayList<SSerializer>();
		for (SSerializer serializer : serializers) {
			if (serializer.isEnabled()) {
				result.add(serializer);
			}
		}
		return result;
	}

	@Override
	public List<SDeserializer> getEnabledDeserializers() throws UserException, ServerException {
		List<SDeserializer> deserializers = getAllDeserializers(true);
		List<SDeserializer> result = new ArrayList<SDeserializer>();
		for (SDeserializer deserializer : deserializers) {
			if (deserializer.isEnabled()) {
				result.add(deserializer);
			}
		}
		return result;
	}

	@Override
	public Boolean hasActiveSerializer(String contentType) throws UserException, ServerException {
		try {
			SSerializer serializer = getSerializerByContentType(contentType);
			if (serializer != null) {
				if (serializer.isEnabled()) {
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
	public void startTransaction(Integer pid) throws UserException {
		requireAuthenticationAndRunningServer();
		changes = new LinkedHashSet<Change>();
		transactionPid = pid;
	}

	@Override
	public Long commitTransaction() throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(transactionPid));
			Project project = session.querySingle(condition, Project.class, false);
			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(session, accessMethod, null, project.getOid(), currentUoid, "comment");
			checkinDatabaseAction.execute();
			for (Change change : changes) {
				change.execute(transactionPid, checkinDatabaseAction.getConcreteRevision().getId(), session);
			}
			session.commit();
			return checkinDatabaseAction.getRevision().getOid();
		} catch (BimDeadlockException e) {
		} catch (BimDatabaseException e) {
		} finally {
			session.close();
		}
		return -1L;
	}

	@Override
	public void abortTransaction() throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes = null;
	}

	@Override
	public void addStringAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long oid, String className, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addFloatAttribute(Long oid, String className, String attributeName, Float value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addBooleanAttribute(Long oid, String className, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addReference(Long oid, String className, String referenceName, Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new AddReferenceChange(oid, className, referenceName, referenceOid, referenceClassName));
	}

	@Override
	public Long createObject(String className) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		Long oid = bimServer.getDatabase().newOid();
		CreateObjectChange createObject = new CreateObjectChange(className, oid);
		changes.add(createObject);
		return oid;
	}

	private void requireOpenStransaction() throws UserException {
		if (changes == null) {
			throw new UserException("No open transaction");
		}
	}

	@Override
	public void removeAttribute(Long oid, String className, String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new RemoveAttributeChange(oid, className, attributeName, index));
	}

	@Override
	public void removeObject(String className, Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new RemoveObjectChange(className, oid));
	}

	@Override
	public void removeReference(Long oid, String className, String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new RemoveReferenceChange(oid, className, referenceName, index));
	}

	@Override
	public void setStringAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setIntegerAttribute(Long oid, String className, String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setBooleanAttribute(Long oid, String className, String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setFloatAttribute(Long oid, String className, String attributeName, Float value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setEnumAttribute(Long oid, String className, String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setReference(Long oid, String className, String referenceName, Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetReferenceChange(oid, className, referenceName, referenceOid, referenceClassName));
	}

	@Override
	public void unsetAttribute(Long oid, String className, String attributeName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
		changes.add(new SetAttributeChange(oid, className, attributeName, null));
	}

	@Override
	public void unsetReference(Long oid, String className, String referenceName) throws UserException {
		requireAuthenticationAndRunningServer();
		requireOpenStransaction();
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
	public Set<SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws UserException {
		requireAuthenticationAndRunningServer();
		Collection<GuidanceProviderPlugin> allGuidanceProviders = bimServer.getPluginManager().getAllGuidanceProviders(true);
		Set<SGuidanceProviderPluginDescriptor> descriptors = new HashSet<SGuidanceProviderPluginDescriptor>();
		for (GuidanceProviderPlugin guidanceProviderPlugin : allGuidanceProviders) {
			SGuidanceProviderPluginDescriptor descriptor = new SGuidanceProviderPluginDescriptor();
			descriptor.setClassName(guidanceProviderPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}

	@Override
	public void registerNewRevisionListener() {
	}

	@Override
	public void setHttpCallback(Long uoid, String address) throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			SetHttpCallbackUrlDatabaseAction action = new SetHttpCallbackUrlDatabaseAction(session, accessMethod, currentUoid, uoid, address);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
		} finally {
			session.close();
		}
	}
}