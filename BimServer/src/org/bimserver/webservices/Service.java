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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
import org.bimserver.database.actions.DeleteGuidanceProviderDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.DeleteSerializerDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.GetAllAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfRevisionDatabaseAction;
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
import org.bimserver.database.actions.SetRevisionTagDatabaseAction;
import org.bimserver.database.actions.UndeleteProjectDatabaseAction;
import org.bimserver.database.actions.UndeleteUserDatabaseAction;
import org.bimserver.database.actions.UpdateClashDetectionSettingsDatabaseAction;
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
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.ifc.compare.CompareResult.Item;
import org.bimserver.ifc.compare.CompareResult.ObjectAdded;
import org.bimserver.ifc.compare.CompareResult.ObjectDeleted;
import org.bimserver.ifc.compare.CompareResult.ObjectModified;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SGuidanceProvider;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SUser;
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
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StoreFactory;
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
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.SCheckinResult;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.SCompareResult.SObjectAdded;
import org.bimserver.shared.SCompareResult.SObjectModified;
import org.bimserver.shared.SCompareResult.SObjectRemoved;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.SDownloadResult;
import org.bimserver.shared.SGuidanceProviderPluginDescriptor;
import org.bimserver.shared.SLongAction;
import org.bimserver.shared.SMigration;
import org.bimserver.shared.SPlugin;
import org.bimserver.shared.SPlugin.SPluginState;
import org.bimserver.shared.SRevisionSummary;
import org.bimserver.shared.SSerializerPluginDescriptor;
import org.bimserver.shared.SUserSession;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.UserException;
import org.bimserver.tools.generators.GenerateUtils;
import org.bimserver.utils.FakeClosingInputStream;
import org.bimserver.utils.Hashers;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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

	public Service(BimServer bimServer, AccessMethod accessMethod,
			ServiceFactory serviceFactory) {
		this.accessMethod = accessMethod;
		this.serviceFactory = serviceFactory;
		this.bimServer = bimServer;
		activeSince = new Date();
		lastActive = new Date();
	}

	@Override
	public SCheckinResult checkinSync(final Long poid, final String comment,
			Long fileSize, DataHandler ifcFile, Boolean merge)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return checkinInternal(poid, comment, fileSize, ifcFile, true, merge);
	}

	@Override
	public SCheckinResult checkinAsync(final Long poid, final String comment,
			Long fileSize, DataHandler ifcFile, Boolean merge)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return checkinInternal(poid, comment, fileSize, ifcFile, false, merge);
	}

	private SCheckinResult checkinInternal(final Long poid,
			final String comment, Long fileSize, DataHandler ifcFile,
			Boolean sync, Boolean merge) throws UserException, ServerException {
		final BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			InputStream inputStream = ifcFile.getInputStream();
			if (ifcFile.getName() != null
					&& (ifcFile.getName().toUpperCase().endsWith(".ZIP") || ifcFile
							.getName().toUpperCase().endsWith(".IFCZIP"))) {
				ZipInputStream zipInputStream = new ZipInputStream(inputStream);
				ZipEntry nextEntry = zipInputStream.getNextEntry();
				if (nextEntry == null) {
					throw new UserException(
							"Zip files must contain exactly one IFC-file, this zip-file looks empty");
				}
				if (nextEntry.getName().toUpperCase().endsWith(".IFC")
						|| nextEntry.getName().toUpperCase()
								.endsWith(".IFCXML")) {
					IfcModelInterface model = null;
					FakeClosingInputStream fakeClosingInputStream = new FakeClosingInputStream(
							zipInputStream);
					if (nextEntry.getName().toUpperCase().endsWith(".IFC")) {
						model = readIfcStepModel(fakeClosingInputStream,
								fileSize);
					} else if (nextEntry.getName().toUpperCase()
							.endsWith(".IFCXML")) {
						model = readIfcXmlModel(fakeClosingInputStream,
								fileSize);
					}
					if (model.getSize() == 0) {
						throw new UserException(
								"Uploaded file does not seem to be a correct IFC file");
					}
					if (zipInputStream.getNextEntry() != null) {
						zipInputStream.close();
						throw new UserException(
								"Zip files may only contain one IFC-file, this zip-file contains more files");
					} else {
						zipInputStream.close();
						if (sync) {
							SCheckinResult processCheckin = processCheckinSync(
									poid, comment, fileSize, session, model,
									merge);
							return processCheckin;
						} else {
							SCheckinResult processCheckin = processCheckinAsync(
									poid, comment, fileSize, session, model,
									merge);
							return processCheckin;
						}
					}
				} else {
					throw new UserException(
							"Zip files must contain exactly one IFC-file, this zip-file seems to have one or more non-IFC files");
				}
			} else if (ifcFile.getName() == null
					|| ifcFile.getName().toUpperCase().endsWith(".IFC")
					|| ifcFile.getName().toUpperCase().endsWith(".IFCXML")) {
				IfcModelInterface model = null;
				if (ifcFile.getName() != null
						&& ifcFile.getName().toUpperCase().endsWith(".IFCXML")) {
					model = readIfcXmlModel(ifcFile.getInputStream(), fileSize);
				} else {
					model = readIfcStepModel(ifcFile.getInputStream(), fileSize);
				}
				if (model.getSize() == 0) {
					throw new UserException(
							"Uploaded file does not seem to be a correct IFC file");
				}
				SCheckinResult checkinResult = null;
				boolean correctModel = validateModel(model);
				if (correctModel) {
					if (sync) {
						checkinResult = processCheckinSync(poid, comment,
								fileSize, session, model, merge);
					} else {
						checkinResult = processCheckinAsync(poid, comment,
								fileSize, session, model, merge);
					}
					inputStream.close();
					return checkinResult;
				} else {
					throw new UserException(
							"Model isn't valid according to the MVD/IDM");
				}
			} else {
				throw new UserException(
						"Uploaded file does not seem to be a valid IFC file");
			}
		} catch (IOException e) {
			LOGGER.error("", e);
			throw new UserException("IOException", e);
		} finally {
			session.close();
		}
	}

	private boolean validateModel(IfcModelInterface model) {
		// this is where the model can be validated
		LOGGER.info("This is where the magic happens!");
		return true;
	}

	private IfcModelInterface readIfcXmlModel(InputStream inputStream,
			Long fileSize) throws UserException {
		EmfDeserializer deserializer;
		try {
			deserializer = bimServer.getPluginManager()
					.requireDeserializer("ifcxml").createDeserializer();
		} catch (DeserializeException e) {
			throw new UserException(e.getMessage());
		}
		try {
			return deserializer.read(inputStream, false, fileSize);
		} catch (DeserializeException e) {
			throw new UserException("Invalid IFC XML file", e);
		}
	}

	private IfcModelInterface readIfcStepModel(final InputStream inputStream,
			Long fileSize) throws UserException {
		EmfDeserializer deserializer;
		try {
			deserializer = bimServer.getPluginManager()
					.requireDeserializer("ifc").createDeserializer();
		} catch (DeserializeException e) {
			throw new UserException(e.getMessage());
		}
		try {
			deserializer.init(bimServer.getPluginManager()
					.requireSchemaDefinition());
		} catch (PluginException e) {
			throw new UserException(e);
		}
		try {
			InputStream in = inputStream;
			if (accessMethod == AccessMethod.SOAP) {
				/*
				 * Strangest hack ever, it seems that DelegatingInputStream
				 * (when using SOAP), sometimes gives 0 as a result of
				 * read(byte[] b, int off, Integer len), which is illegal, so
				 * this code makes sure a 0 will be interpreted as the end of
				 * the stream
				 */
				in = new InputStream() {
					@Override
					public int read() throws IOException {
						return inputStream.read();
					}

					@Override
					public int read(byte[] b, int off, int len)
							throws IOException {
						Integer read = inputStream.read(b, off, len);
						if (read == 0) {
							return -1;
						}
						return read;
					}
				};
			}
			deserializer.read(in, false, fileSize);
			return deserializer.getModel();
		} catch (Exception e) {
			throw new UserException("Invalid IFC file", e);
		} catch (OutOfMemoryError e) {
			LOGGER.error("", e);
			bimServer.getServerInfo().setErrorMessage(e.getMessage());
			throw new UserException("Out of memory", e);
		}
	}

	private SCheckinResult processCheckinSync(final Long poid,
			final String comment, Long fileSize,
			final BimDatabaseSession session, IfcModelInterface model,
			Boolean merge) throws UserException, ServerException {
		BimDatabaseAction<ConcreteRevision> action = new CheckinDatabaseAction(
				session, accessMethod, model, poid, currentUoid, comment);
		try {
			ConcreteRevision revision = session.executeAndCommitAction(action,
					DEADLOCK_RETRIES);
			SCheckinResult result = new SCheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			return result;
		} catch (Exception e) {
			handleException(e);
			return null;
		}
	}

	private SCheckinResult processCheckinAsync(final Long poid,
			final String comment, Long fileSize,
			final BimDatabaseSession session, IfcModelInterface model,
			Boolean merge) throws UserException {
		try {
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(
					session, accessMethod, poid, currentUoid, model, comment);
			GetUserByUoidDatabaseAction getUserByUoidDatabaseAction = new GetUserByUoidDatabaseAction(
					session, accessMethod, currentUoid);
			User userByUoid = session.executeAction(
					getUserByUoidDatabaseAction, DEADLOCK_RETRIES);
			ConcreteRevision revision = session.executeAndCommitAction(action,
					DEADLOCK_RETRIES);
			session.close();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(
					bimServer, null, accessMethod, model, currentUoid,
					revision.getOid(), merge);
			SCheckinResult result = new SCheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			bimServer.getLongActionManager().start(
					new LongCheckinAction(bimServer, userByUoid,
							createCheckinAction));
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
	public Integer checkoutLastRevision(Long poid, String formatIdentifier,
			Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(),
					poid, false);
			return checkout(project.getLastRevision().getOid(),
					formatIdentifier, sync);
		} catch (Exception e) {
			handleException(e);
			return -1;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer checkout(Long roid, String resultTypeName, Boolean sync)
			throws UserException, ServerException {
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
		DownloadParameters downloadParameters = new DownloadParameters(
				bimServer, roid, resultTypeName);
		LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(
				bimServer, downloadParameters, currentUoid, accessMethod);
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
	public Long addUser(String username, String name, SUserType type,
			Boolean selfRegistration) throws UserException, ServerException {
		if (!selfRegistration) {
			requireAuthenticationAndRunningServer();
		} else if (!bimServer.getSettingsManager().getSettings()
				.isAllowSelfRegistration()) {
			requireSelfregistrationAllowed();
		}
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Long> action = new AddUserDatabaseAction(
					bimServer, session, accessMethod, username, name,
					convert(type), currentUoid, selfRegistration);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return -1L;
		} finally {
			session.close();
		}
	}

	private void handleException(Exception e) throws UserException,
			ServerException {
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
	public SProject addProject(String projectName) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(
					bimServer, session, accessMethod, projectName, currentUoid);
			return convert(
					session.executeAndCommitAction(action, DEADLOCK_RETRIES),
					SProject.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(
					session, accessMethod, currentUoid, uoid, poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects() throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(
					session, accessMethod, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SProject.class);
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

	private void requireAdminAuthenticationAndRunningServer()
			throws UserException {
		requireRunningServer();
		requireAdminAuthentication();
	}

	private void updateLastActive() {
		lastActive = new Date();
	}

	private void requireRunningServer() throws UserException {
		if (bimServer.getServerInfo().getServerState() != ServerState.RUNNING) {
			throw new UserException(
					"Call cannot be executed because the server is in "
							+ bimServer.getServerInfo().getServerState()
							+ " mode");
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
		if (getCurrentUser().getUserType() != SUserType.ADMIN
				&& getCurrentUser().getUserType() != SUserType.SYSTEM) {
			throw new UserException(
					"Administrator rights required for this call");
		}
	}

	private void requireSelfregistrationAllowed() throws UserException {
		updateLastActive();
		if (currentUoid == -1) {
			throw new UserException("No self registration allowed");
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private <T> T convertEnum(Enumerator enumerator, Class<T> targetClass) {
		Object[] enumConstants = targetClass.getEnumConstants();
		for (Object t : enumConstants) {
			Enum<?> en = (Enum<?>) t;
			try {
				Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
				Object invoke = method2.invoke(en);
				if ((Integer) invoke == enumerator.getValue()) {
					return (T) t;
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> T convert(Enum enumerator, Class<T> targetClass) {
		Object[] enumConstants = targetClass.getEnumConstants();
		for (Object t : enumConstants) {
			Enum<?> en = (Enum<?>) t;
			try {
				Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
				Object invoke = method2.invoke(en);
				if ((Integer) invoke == enumerator.ordinal()) {
					return (T) t;
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private <T> List<T> convert(Collection<? extends IdEObject> list,
			Class<T> targetClass) {
		List<T> newList = new ArrayList<T>();
		if (list == null) {
			return null;
		}
		for (IdEObject eObject : list) {
			newList.add(convert(eObject, targetClass));
		}
		return newList;
	}

	@SuppressWarnings("unchecked")
	public static <T extends IdEObject> T convert(Object original,
			Class<T> targetClass, BimDatabaseSession session) {
		if (original == null) {
			return null;
		}
		EClass eClass = (EClass) StorePackage.eINSTANCE
				.getEClassifier(targetClass.getSimpleName());
		IdEObject idEObject = (IdEObject) eClass.getEPackage()
				.getEFactoryInstance().create(eClass);
		try {
			Method getOidMethod = original.getClass().getMethod("getOid");
			Long oid = (Long) getOidMethod.invoke(original);
			if (oid == 0) {
				oid = -1L;
			}
			idEObject.setOid(oid);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		for (EStructuralFeature eStructuralFeature : eClass
				.getEAllStructuralFeatures()) {
			try {
				String methodName = "get"
						+ StringUtils.firstUpperCase(eStructuralFeature
								.getName());
				if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE
						.getEBoolean()) {
					methodName = "is"
							+ StringUtils.firstUpperCase(eStructuralFeature
									.getName());
				}
				if (eStructuralFeature instanceof EReference) {
					methodName += "Id";
				}
				Method method = original.getClass().getMethod(methodName);
				Object value = method.invoke(original);
				if (eStructuralFeature instanceof EReference) {
					Long refOid = (Long) value;
					idEObject.eSet(eStructuralFeature, session.get(
							(EClass) eStructuralFeature.getEType(), refOid,
							false));
				} else {
					idEObject.eSet(eStructuralFeature, value);
				}
			} catch (SecurityException e) {
				LOGGER.error("", e);
			} catch (NoSuchMethodException e) {
				LOGGER.error("", e);
			} catch (IllegalArgumentException e) {
				LOGGER.error("", e);
			} catch (IllegalAccessException e) {
				LOGGER.error("", e);
			} catch (InvocationTargetException e) {
				LOGGER.error("", e);
			}
		}
		return (T) idEObject;
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(IdEObject original, Class<T> targetClass) {
		if (original == null) {
			return null;
		}
		try {
			Class<?> realClass = Class
					.forName("org.bimserver.interfaces.objects.S"
							+ original.eClass().getName());
			T newInstance = (T) realClass.newInstance();
			Method setOidMethod = targetClass.getMethod("setOid",
					new Class[] { long.class });
			setOidMethod.invoke(newInstance, original.getOid());
			EClass eClass = original.eClass();
			for (EStructuralFeature eStructuralFeature : eClass
					.getEAllStructuralFeatures()) {
				Object value = original.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (eStructuralFeature.getEType() instanceof EEnum) {
						Enumerator enumerator = (Enumerator) value;
						Class<?> forName = Class
								.forName("org.bimserver.interfaces.objects.S"
										+ eStructuralFeature.getEType()
												.getName());
						Object[] enumConstants = forName.getEnumConstants();
						Boolean found = false;
						for (Object t : enumConstants) {
							Enum<?> en = (Enum<?>) t;
							Method method2 = en.getDeclaringClass().getMethod(
									"getOrdinal");
							Object invoke = method2.invoke(en);
							if ((Integer) invoke == enumerator.getValue()) {
								try {
									Method method = realClass
											.getMethod(
													GenerateUtils
															.makeSetter(eStructuralFeature),
													new Class[] { forName });
									method.invoke(newInstance, t);
								} catch (NoSuchMethodException e) {
								}
								found = true;
								break;
							}
						}
						if (!found) {
							LOGGER.info(value.toString() + " not found");
						}
					} else if (eStructuralFeature.getEType() instanceof EDataType) {
						try {
							Method method = realClass.getMethod(GenerateUtils
									.makeSetter(eStructuralFeature),
									new Class[] { eStructuralFeature.getEType()
											.getInstanceClass() });
							if (value != null) {
								method.invoke(newInstance, value);
							}
						} catch (NoSuchMethodException e) {
						}
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (eStructuralFeature.isMany()) {
						List<IdEObject> list = (List<IdEObject>) value;
						List<Long> newList = new ArrayList<Long>();
						for (IdEObject val : list) {
							newList.add(val.getOid());
						}
						try {
							Method method = realClass.getMethod(GenerateUtils
									.makeSetter(eStructuralFeature),
									new Class[] { List.class });
							method.invoke(newInstance, newList);
						} catch (NoSuchMethodException e) {
						}
					} else {
						try {
							Method method = realClass.getMethod(GenerateUtils
									.makeSetter(eStructuralFeature),
									new Class[] { long.class });
							if (value == null) {
								method.invoke(newInstance, -1);
							} else {
								IdEObject referencedObject = (IdEObject) value;
								method.invoke(newInstance,
										referencedObject.getOid());
							}
						} catch (NoSuchMethodException e) {
						}
					}
				}
			}
			return newInstance;
		} catch (InstantiationException e) {
			LOGGER.error("", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("", e);
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		} catch (InvocationTargetException e) {
			LOGGER.error("", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		} catch (NoSuchMethodException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(
					session, accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SRevision.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(
					session, accessMethod, poid, false);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SCheckout.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(
					session, accessMethod, poid, true);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SCheckout.class);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(
					session, accessMethod, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SUser.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean login(String username, String password)
			throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(
					session, accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null
					&& Hashers.getSha256Hash(password).equals(
							user.getPassword())) {
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
	public List<SCheckout> getAllCheckoutsByUser(Long uoid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(
					session, accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SCheckout.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(
					session, accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SRevision.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SRevision getRevision(Long roid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(
					session, accessMethod, roid, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SRevision.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(
					session, accessMethod, roid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SCheckout.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	public Integer download(Long roid, String resultTypeName, Boolean sync)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(
				new DownloadParameters(bimServer, roid, resultTypeName), sync);
	}

	private Integer download(DownloadParameters downloadParameters, Boolean sync)
			throws UserException, ServerException {
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(
				bimServer, downloadParameters, currentUoid, accessMethod);
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
	public SDownloadResult getDownloadData(final Integer actionId)
			throws UserException, ServerException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer
				.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			longAction.waitForCompletion();
			return longAction.getCheckoutResult();
		} else {
			throw new UserException("No data found for laid " + actionId);
		}
	}

	@Override
	public LongActionState getDownloadState(Integer actionId)
			throws UserException, ServerException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) bimServer
				.getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			return longAction.getState();
		} else {
			throw new UserException("No state found for laid " + actionId);
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(
					session, accessMethod, poid, currentUoid);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(
					session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean removeUserFromProject(Long uoid, Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(
					session, accessMethod, uoid, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByOids(Set<Long> roids, Set<Long> oids,
			String resultTypeName, Boolean sync) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, resultTypeName,
				roids, oids), sync);
	}

	@Override
	public Integer downloadOfType(Long roid, String className,
			String resultTypeName, Boolean sync) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roid, className,
				resultTypeName), sync);
	}

	@Override
	public List<String> getAvailableClasses() throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(
					session, accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public DatabaseInformation getDatabaseInformation() throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(
					session, accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadByGuids(Set<Long> roids, Set<String> guids,
			String resultTypeName, Boolean sync) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		return download(new DownloadParameters(bimServer, roids, guids,
				resultTypeName), sync);
	}

	@Override
	public SUser getLoggedInUser() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return getUserByUoid(currentUoid);
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(
					session, accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SProject.class);
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
	public Boolean changePassword(Long uoid, String oldPassword,
			String newPassword) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(
					session, accessMethod, uoid, oldPassword, newPassword,
					currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(
					session, accessMethod, username);
			SUser convert = convert(
					session.executeAction(action, DEADLOCK_RETRIES),
					SUser.class);
			if (convert == null) {
				throw new UserException("User with username \"" + username
						+ "\" not found");
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(
					session, accessMethod, "system");
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
	public Boolean undeleteProject(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(
					session, accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteUser(Long uoid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(
					session, accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(
					bimServer, session, accessMethod, projectName, parentPoid,
					currentUoid);
			return convert(
					session.executeAndCommitAction(action, DEADLOCK_RETRIES),
					SProject.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(
					session, accessMethod, currentUoid, sProject);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(
					session, accessMethod, currentUoid, sRevision);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(Long roid1, Long roid2,
			SCompareType sCompareType, SCompareIdentifier sCompareIdentifier)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(
					bimServer, session, accessMethod, currentUoid, roid1,
					roid2, sCompareType, sCompareIdentifier);
			return convert(
					session.executeAndCommitAction(action, DEADLOCK_RETRIES),
					SCompareResult.class, session);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	private static UserType convert(SUserType sUserType) {
		switch (sUserType) {
		case ADMIN:
			return UserType.ADMIN;
		case ANONYMOUS:
			return UserType.ANONYMOUS;
		case USER:
			return UserType.USER;
		}
		return null;
	}

	private SCompareResult convert(CompareResult compareResult,
			Class<SCompareResult> class1, BimDatabaseSession session) {
		SCompareResult sCompareResult = new SCompareResult();
		Map<EClass, List<Item>> items = compareResult.getItems();
		for (EClass key : items.keySet()) {
			List<Item> list = items.get(key);
			for (Item item : list) {
				SDataObject dataObject = new SDataObject(item.geteObject()
						.eClass().getName(), item.geteObject().getOid(),
						getGuid(item.geteObject()), getName(item.geteObject()));
				if (item instanceof ObjectAdded) {
					sCompareResult.add(new SObjectAdded(dataObject));
				} else if (item instanceof ObjectDeleted) {
					sCompareResult.add(new SObjectRemoved(dataObject));
				} else if (item instanceof ObjectModified) {
					ObjectModified objectModified = (ObjectModified) item;
					sCompareResult.add(new SObjectModified(dataObject,
							objectModified.getFeature().getName(),
							objectModified.getOldValue() == null ? "null"
									: objectModified.getOldValue().toString(),
							objectModified.getNewValue() == null ? "null"
									: objectModified.getNewValue().toString()));
				}
			}
		}
		return sCompareResult;
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

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<SRevisionSummary> action = new GetRevisionSummaryDatabaseAction(
					session, accessMethod, roid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(
					session, accessMethod, currentUoid, poid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckoutWarnings(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(
					session, accessMethod, poid, currentUoid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasRights(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(
					session, accessMethod, getCurrentUser().getOid(), poid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer downloadProjects(Set<Long> roids, String resultTypeName,
			Boolean sync) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		return download(
				new DownloadParameters(bimServer, roids, resultTypeName), sync);
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid, String className)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<SDataObject> action = new GetDataObjectByOidDatabaseAction(
					bimServer, session, accessMethod, roid, oid,
					session.getCidForClassName(className));
			SDataObject dataObject = session.executeAction(action,
					DEADLOCK_RETRIES);
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<SDataObject> action = new GetDataObjectByGuidDatabaseAction(
					bimServer, session, accessMethod, roid, guid);
			SDataObject dataObject = session.executeAndCommitAction(action,
					DEADLOCK_RETRIES);
			return dataObject;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String className)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		BimDatabaseAction<List<SDataObject>> action = new GetDataObjectsByTypeDatabaseAction(
				bimServer, session, accessMethod, roid, className);
		try {
			List<SDataObject> dataObjects = session.executeAction(action,
					DEADLOCK_RETRIES);
			return dataObjects;
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidClash> findClashesByGuid(
			SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			return convert(session.executeAction(
					new FindClashesDatabaseAction(bimServer, session,
							accessMethod, convert(sClashDetectionSettings,
									session), currentUoid), DEADLOCK_RETRIES),
					SGuidClash.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SEidClash> findClashesByEid(
			SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			return convert(session.executeAction(
					new FindClashesDatabaseAction(bimServer, session,
							accessMethod, convert(sClashDetectionSettings,
									session), currentUoid), DEADLOCK_RETRIES),
					SEidClash.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	private ClashDetectionSettings convert(
			SClashDetectionSettings sClashDetectionSettings,
			BimDatabaseSession bimDatabaseSession) {
		ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE
				.createClashDetectionSettings();
		clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
		for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
			if (!ignoredClass.equals("none")) {
				clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
			}
		}
		for (Long poid : sClashDetectionSettings.getProjects()) {
			Project project = bimDatabaseSession.get(
					StorePackage.eINSTANCE.getProject(), poid, false);
			clashDetectionSettings.getProjects().add(project);
		}
		for (Long roid : sClashDetectionSettings.getRevisions()) {
			Revision revision = bimDatabaseSession.get(
					StorePackage.eINSTANCE.getRevision(), roid, false);
			clashDetectionSettings.getRevisions().add(revision);
		}
		return clashDetectionSettings;
	}

	@Override
	public SCheckinResult branchToNewProject(Long roid, String projectName,
			String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Revision oldRevision = session.get(
					StorePackage.eINSTANCE.getRevision(), roid, false);
			Project oldProject = oldRevision.getProject();
			User user = session.get(StorePackage.eINSTANCE.getUser(),
					currentUoid, false);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(
					user, oldProject)) {
				throw new UserException(
						"User has insufficient rights to download revisions from this project");
			}
			IfcModelSet ifcModelSet = new IfcModelSet();
			for (ConcreteRevision subRevision : oldRevision
					.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel();
				session.getMap(subModel, subRevision.getProject().getId(),
						subRevision.getId(), true);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
			IfcModelInterface model = bimServer
					.getMergerFactory()
					.createMerger()
					.merge(oldRevision.getProject(),
							ifcModelSet,
							bimServer.getSettingsManager().getSettings()
									.isIntelligentMerging());
			model.resetOids();
			Project newProject = new AddProjectDatabaseAction(bimServer,
					session, accessMethod, projectName, currentUoid).execute();
			session.commit();
			session.close();
			session = bimServer.getDatabase().createSession(true);
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(
					session, accessMethod, newProject.getOid(), currentUoid,
					model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(
						action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(
						bimServer, session, accessMethod, model, currentUoid,
						revision.getOid(), false);
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				bimServer.getLongActionManager().start(
						new LongCheckinAction(bimServer, user,
								createCheckinAction));
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
	public SCheckinResult branchToExistingProject(Long roid, Long destPoid,
			String comment) throws UserException {
		requireAuthenticationAndRunningServer();
		final BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Revision oldRevision = session.get(
					StorePackage.eINSTANCE.getRevision(), roid, false);
			Project oldProject = oldRevision.getProject();
			User user = session.get(StorePackage.eINSTANCE.getUser(),
					currentUoid, false);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(
					user, oldProject)) {
				throw new UserException(
						"User has insufficient rights to download revisions from this project");
			}
			IfcModelSet ifcModelSet = new IfcModelSet();
			for (ConcreteRevision subRevision : oldRevision
					.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel();
				session.getMap(subModel, subRevision.getProject().getId(),
						subRevision.getId(), true);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
			IfcModelInterface model = bimServer
					.getMergerFactory()
					.createMerger()
					.merge(oldRevision.getProject(),
							ifcModelSet,
							bimServer.getSettingsManager().getSettings()
									.isIntelligentMerging());
			model.resetOids();
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(
					session, accessMethod, destPoid, currentUoid, model,
					comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(
						action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(
						bimServer, session, accessMethod, model, currentUoid,
						revision.getOid(), false);
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				bimServer.getLongActionManager().start(
						new LongCheckinAction(bimServer, user,
								createCheckinAction));
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(
					session, accessMethod, currentUoid);
			List<LogAction> logs = session.executeAction(action,
					DEADLOCK_RETRIES);
			return convert(logs, SLogAction.class);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(
					session, accessMethod, currentUoid, goid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SGeoTag.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(
					session, accessMethod, currentUoid, sGeoTag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SClashDetectionSettings getClashDetectionSettings(Long cdsoid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<ClashDetectionSettings> action = new GetClashDetectionSettingsDatabaseAction(
					session, accessMethod, currentUoid, cdsoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SClashDetectionSettings.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateClashDetectionSettings(
			SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new UpdateClashDetectionSettingsDatabaseAction(
					session, accessMethod, currentUoid, sClashDetectionSettings);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(
					session, accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SUser.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(
					session, accessMethod, poid, currentUoid);
			return convert(action.execute(), SProject.class);
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

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(
					session, accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SUser.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(
					session, accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SUser.class);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), uoid,
					false);
			return convert(user.getHasRightsOn(), SProject.class);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(
					session, accessMethod, name, currentUoid);
			return (List<SProject>) convert(
					session.executeAction(action, DEADLOCK_RETRIES),
					SProject.class);
		} catch (BimDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean autologin(String username, String hash)
			throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(
					session, accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null
					&& hash.equals(Hashers.getSha256Hash(user.getUsername()
							+ user.getPassword()))) {
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
	public void setRevisionTag(Long roid, String tag) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(
					session, accessMethod, roid, tag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getSubProjects(Long poid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(
					session, accessMethod, currentUoid, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SProject.class);
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(Long uoid, SUserType userType)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(
					session, accessMethod, currentUoid, uoid, userType);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setExportTypeEnabled(String resultTypeName, Boolean enabled)
			throws UserException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(),
					currentUoid, false);
			if (user.getUserType() != UserType.ADMIN) {
				throw new UserException(
						"Only admin users can change enabled export types");
			}
			Set<String> resultTypes = bimServer.getSettingsManager()
					.getEnabledExportTypesAsSet();
			if (enabled) {
				resultTypes.add(resultTypeName);
			} else {
				resultTypes.remove(resultTypeName);
			}
			bimServer.getSettingsManager()
					.updateEnabledResultTypes(resultTypes);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(),
					currentUoid, false);
			return convert(user, SUser.class);
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
	public String getSettingCustomLogoAddress() throws UserException,
			ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getCustomLogoAddress();
	}

	@Override
	public void setSettingCustomLogoAddress(String customLogoAddress)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCustomLogoAddress(customLogoAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingEmailSenderAddress() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.getEmailSenderAddress();
	}

	@Override
	public void setSettingEmailSenderAddress(String emailSenderAddress)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setEmailSenderAddress(emailSenderAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingEnabledExportTypes() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.getEnabledExportTypes();
	}

	@Override
	public void setSettingEnabledExportTypes(Set<String> enabledExportTypeNames)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		bimServer.getSettingsManager().updateEnabledResultTypes(
				enabledExportTypeNames);
	}

	@Override
	public String getSettingRegistrationAddition() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.getRegistrationAddition();
	}

	@Override
	public void setSettingRegistrationAddition(String registrationAddition)
			throws UserException, ServerException {
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
	public void setSettingSiteAddress(String siteAddress) throws UserException,
			ServerException {
		requireAdminAuthentication();
		Settings settings = bimServer.getSettingsManager().getSettings();
		if (siteAddress.trim().isEmpty()) {
			throw new UserException("Site Address cannot be empty");
		} else if (!siteAddress.startsWith("http://")
				&& !(siteAddress.startsWith("https://"))) {
			throw new UserException(
					"Site Address must start with either \"http://\" or \"https://\"");
		}
		settings.setSiteAddress(siteAddress);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingSmtpServer() throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings().getSmtpServer();
	}

	@Override
	public void setSettingSmtpServer(String smtpServer) throws UserException,
			ServerException {
		requireAdminAuthentication();
		Settings settings = bimServer.getSettingsManager().getSettings();
		if (smtpServer.trim().isEmpty()) {
			throw new UserException("SMTP server address cannot be empty");
		}
		settings.setSmtpServer(smtpServer);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAllowSelfRegistration() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isAllowSelfRegistration();
	}

	@Override
	public void setSettingAllowSelfRegistration(Boolean allowSelfRegistration)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowSelfRegistration(allowSelfRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAllowUsersToCreateTopLevelProjects()
			throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isAllowUsersToCreateTopLevelProjects();
	}

	@Override
	public void setSettingAllowUsersToCreateTopLevelProjects(
			Boolean allowUsersToCreateTopLevelProjects) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingAutoTestClashes() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings().isAutoTestClashes();
	}

	@Override
	public void setSettingAutoTestClashes(Boolean autoTestClashes)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setAutoTestClashes(autoTestClashes);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCheckinMergingEnabled() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isCheckinMergingEnabled();
	}

	@Override
	public void setSettingCheckinMergingEnabled(Boolean checkinMergingEnabled)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCheckinMergingEnabled(checkinMergingEnabled);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingIntelligentMerging() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isIntelligentMerging();
	}

	@Override
	public void setSettingIntelligentMerging(Boolean intelligentMerging)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setIntelligentMerging(intelligentMerging);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingSendConfirmationEmailAfterRegistration()
			throws UserException, ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isSendConfirmationEmailAfterRegistration();
	}

	@Override
	public void setSettingSendConfirmationEmailAfterRegistration(
			Boolean sendConfirmationEmailAfterRegistration)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingShowVersionUpgradeAvailable() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isShowVersionUpgradeAvailable();
	}

	@Override
	public void setSettingShowVersionUpgradeAvailable(
			Boolean showVersionUpgradeAvailable) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setShowVersionUpgradeAvailable(showVersionUpgradeAvailable);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public Boolean isSettingCacheOutputFiles() throws UserException,
			ServerException {
		return bimServer.getSettingsManager().getSettings()
				.isCacheOutputFiles();
	}

	@Override
	public void setSettingCacheOutputFiles(Boolean cacheOutputFiles)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setCacheOutputFiles(cacheOutputFiles);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void loginAnonymous() throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(
					session, accessMethod, "anonymous");
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

	public static SClashDetectionSettings convert(
			ClashDetectionSettings clashDetectionSettings) {
		SClashDetectionSettings sClashDetectionSettings = new SClashDetectionSettings();
		sClashDetectionSettings.setMargin(clashDetectionSettings.getMargin());
		for (String cl : clashDetectionSettings.getIgnoredClasses()) {
			clashDetectionSettings.getIgnoredClasses().add(cl);
		}
		for (Project project : clashDetectionSettings.getProjects()) {
			sClashDetectionSettings.getProjects().add(project.getOid());
		}
		for (Revision revision : clashDetectionSettings.getRevisions()) {
			sClashDetectionSettings.getRevisions().add(revision.getOid());
		}
		return sClashDetectionSettings;
	}

	@Override
	public void sendCompareEmail(SCompareType sCompareType,
			SCompareIdentifier sCompareIdentifier, Long poid, Long roid1,
			Long roid2, String address) throws UserException, ServerException {
		SUser currentUser = getCurrentUser();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Revision revision1 = session.get(
					StorePackage.eINSTANCE.getRevision(), roid1, false);
			Revision revision2 = session.get(
					StorePackage.eINSTANCE.getRevision(), roid2, false);
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = bimServer.getSettingsManager().getSettings()
						.getEmailSenderAddress();
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
				SCompareResult compareResult = compare(roid1, roid2,
						sCompareType, sCompareIdentifier);
				String html = CompareWriter.writeCompareResult(compareResult,
						revision1.getId(), revision2.getId(), sCompareType,
						getProjectByPoid(poid), false);
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
	public void requestPasswordChange(Long uoid) throws UserException,
			ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new RequestPasswordChangeDatabaseAction(
					session, accessMethod, bimServer, uoid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void sendClashesEmail(
			SClashDetectionSettings sClashDetectionSettings, Long poid,
			Set<String> addressesTo) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new SendClashesEmailDatabaseAction(
					bimServer, session, accessMethod, currentUoid, poid,
					sClashDetectionSettings, addressesTo);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void validateAccount(Long uoid, String token, String password)
			throws UserException, ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new ValidateUserDatabaseAction(
					session, accessMethod, uoid, token, password);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SLongAction> getActiveLongActions() throws ServerException,
			ServiceException {
		requireAdminAuthenticationAndRunningServer();
		return bimServer.getLongActionManager().getActiveLongActions();
	}

	@Override
	public List<SProject> getAllReadableProjects() throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(
					session, accessMethod, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES),
					SProject.class);
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
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return session.getCreatedDate();
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	private void updateLastActive(Long uoid) throws UserException,
			ServerException {
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), uoid,
					false);
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
	public void setup(String siteAddress, String smtpServer, String adminName,
			String adminUsername, String adminPassword,
			Boolean createAnonymousUser) throws UserException, ServerException {
		setSettingSmtpServer(smtpServer);
		setSettingSiteAddress(siteAddress);

		if (adminUsername.trim().isEmpty()) {
			throw new UserException("Admin Username cannot be empty");
		}

		if (adminPassword.trim().isEmpty()) {
			throw new UserException("Admin Password cannot be empty");
		}

		bimServer.getServerInfo().update();

		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			new AddUserDatabaseAction(bimServer, session,
					AccessMethod.INTERNAL, adminUsername, adminPassword,
					adminName, UserType.ADMIN, -1, false).execute();
			if (createAnonymousUser) {
				new AddUserDatabaseAction(bimServer, session,
						AccessMethod.INTERNAL, "anonymous", "anonymous",
						"Anonymous", UserType.ANONYMOUS, -1, false).execute();
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
	public List<SSerializer> getAllSerializers(Boolean onlyEnabled)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			List<SSerializer> serializers = convert(session.executeAction(
					new GetAllSerializersDatabaseAction(session, accessMethod,
							bimServer, onlyEnabled), DEADLOCK_RETRIES),
					SSerializer.class);
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
	public void addSerializer(SSerializer serializer) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Serializer convert = convert(serializer, Serializer.class, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(
					session, accessMethod, convert), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializer serializer) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Serializer convert = convert(serializer, Serializer.class, session);
			if (convert.getGuidanceProvider() != null) {
				session.store(convert.getGuidanceProvider());
			}
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(
					session, accessMethod, convert), DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidanceProvider> getAllGuidanceProviders()
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return convert(session.executeAction(
					new GetAllGuidanceProvidersDatabaseAction(session,
							accessMethod), DEADLOCK_RETRIES),
					SGuidanceProvider.class);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addGuidanceProvider(SGuidanceProvider guidanceProvider)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			session.executeAndCommitAction(
					new AddGuidanceProviderDatabaseAction(session,
							accessMethod, convert(guidanceProvider,
									GuidanceProvider.class, session)),
					DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGuidanceProvider(SGuidanceProvider guidanceProvider)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			session.executeAndCommitAction(
					new UpdateGuidanceProviderDatabaseAction(session,
							accessMethod, convert(guidanceProvider,
									GuidanceProvider.class, session)),
					DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializer getSerializerById(Long oid) throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return convert(session.executeAction(
					new GetSerializerByIdDatabaseAction(session, accessMethod,
							oid), DEADLOCK_RETRIES), SSerializer.class);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SGuidanceProvider getGuidanceProviderById(Long oid)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return convert(session.executeAction(
					new GetGuidanceProviderByIdDatabaseAction(session,
							accessMethod, oid), DEADLOCK_RETRIES),
					SGuidanceProvider.class);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Set<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors()
			throws UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory()
				.getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteGuidanceProvider(Long ifid) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new DeleteGuidanceProviderDatabaseAction(
					session, accessMethod, ifid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSerializer(Long sid) throws UserException,
			ServerException {
		requireAdminAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			BimDatabaseAction<Void> action = new DeleteSerializerDatabaseAction(
					session, accessMethod, sid);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setSettingFooterAddition(String footerAddition)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setFooterAddition(footerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public void setSettingHeaderAddition(String headerAddition)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setHeaderAddition(headerAddition);
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public String getSettingFooterAddition() throws UserException,
			ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getFooterAddition();
	}

	@Override
	public String getSettingHeaderAddition() throws UserException,
			ServerException {
		Settings settings = bimServer.getSettingsManager().getSettings();
		return settings.getHeaderAddition();
	}

	@Override
	public SMergeIdentifier getSettingMergeIdentifier() throws UserException,
			ServerException {
		requireAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		return convert(settings.getMergeIdentifier(), SMergeIdentifier.class);
	}

	@Override
	public void setSettingMergeIdentifier(SMergeIdentifier mergeIdentifier)
			throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		Settings settings = bimServer.getSettingsManager().getSettings();
		settings.setMergeIdentifier(MergeIdentifier.valueOf(mergeIdentifier
				.name()));
		bimServer.getSettingsManager().saveSettings();
	}

	@Override
	public SSerializer getSerializerByName(String serializerName)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return convert(session.executeAction(
					new GetSerializerByNameDatabaseAction(session,
							accessMethod, serializerName), DEADLOCK_RETRIES),
					SSerializer.class);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializer getSerializerByContentType(String contentType)
			throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		BimDatabaseSession session = bimServer.getDatabase()
				.createReadOnlySession();
		try {
			return convert(session.executeAction(
					new GetSerializerByContentTypeDatabaseAction(session,
							accessMethod, contentType), DEADLOCK_RETRIES),
					SSerializer.class);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SSerializer> getEnabledSerializers() throws UserException,
			ServerException {
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
	public Boolean hasActiveSerializer(String contentType)
			throws UserException, ServerException {
		try {
			SSerializer serializer = getSerializerByContentType(contentType);
			if (serializer != null) {
				if (serializer.isEnabled()) {
					return bimServer.getPluginManager().isEnabled(
							serializer.getClassName());
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public List<SPlugin> getAllPlugins() throws UserException {
		requireAuthenticationAndRunningServer();
		List<SPlugin> result = new ArrayList<SPlugin>();
		Collection<Plugin> plugins = bimServer.getPluginManager()
				.getAllPlugins(false);
		for (Plugin plugin : plugins) {
			SPlugin sPlugin = new SPlugin();
			sPlugin.setName(plugin.getName());
			PluginContext pluginContext = bimServer.getPluginManager()
					.getPluginContext(plugin);
			sPlugin.setLocation(pluginContext.getLocation());
			sPlugin.setDescription(plugin.getDescription());
			sPlugin.setState(pluginContext.isEnabled() ? SPluginState.ENABLED
					: SPluginState.DISABLED);
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
		if (changes == null) {
			throw new UserException("No transaction active");
		}
		BimDatabaseSession session = bimServer.getDatabase()
				.createSession(true);
		try {
			Condition condition = new AttributeCondition(
					StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(
							transactionPid));
			Project project = session.querySingle(condition, Project.class,
					false);
			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(
					session, accessMethod, null, project.getOid(), currentUoid,
					"comment");
			checkinDatabaseAction.execute();
			for (Change change : changes) {
				change.execute(transactionPid, checkinDatabaseAction
						.getConcreteRevision().getId(), session);
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
		changes = null;
	}

	@Override
	public void addStringAttribute(Long oid, String className,
			String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addIntegerAttribute(Long oid, String className,
			String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addFloatAttribute(Long oid, String className,
			String attributeName, float value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addBooleanAttribute(Long oid, String className,
			String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new AddAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void addReference(Long oid, String className, String referenceName,
			Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new AddReferenceChange(oid, className, referenceName,
				referenceOid, referenceClassName));
	}

	@Override
	public Long createObject(String className) throws UserException {
		requireAuthenticationAndRunningServer();
		Long oid = bimServer.getDatabase().newOid();
		CreateObjectChange createObject = new CreateObjectChange(className, oid);
		changes.add(createObject);
		return oid;
	}

	@Override
	public void removeAttribute(Long oid, String className,
			String attributeName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new RemoveAttributeChange(oid, className, attributeName,
				index));
	}

	@Override
	public void removeObject(String className, Long oid) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new RemoveObjectChange(className, oid));
	}

	@Override
	public void removeReference(Long oid, String className,
			String referenceName, Integer index) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new RemoveReferenceChange(oid, className, referenceName,
				index));
	}

	@Override
	public void setStringAttribute(Long oid, String className,
			String attributeName, String value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setIntegerAttribute(Long oid, String className,
			String attributeName, Integer value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setBooleanAttribute(Long oid, String className,
			String attributeName, Boolean value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setFloatAttribute(Long oid, String className,
			String attributeName, float value) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetAttributeChange(oid, className, attributeName, value));
	}

	@Override
	public void setReference(Long oid, String className, String referenceName,
			Long referenceOid, String referenceClassName) throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetReferenceChange(oid, className, referenceName,
				referenceOid, referenceClassName));
	}

	@Override
	public void unsetAttribute(Long oid, String className, String attributeName)
			throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetAttributeChange(oid, className, attributeName, null));
	}

	@Override
	public void unsetReference(Long oid, String className, String referenceName)
			throws UserException {
		requireAuthenticationAndRunningServer();
		changes.add(new SetReferenceChange(oid, className, referenceName, -1,
				null));
	}

	@Override
	public Date getServerStartTime() {
		return bimServer.getServerStartTime().getTime();
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type)
			throws UserException {
		requireAuthenticationAndRunningServer();
		return bimServer.getEmfSerializerFactory()
				.getSerializerPluginDescriptor(type);
	}

	@Override
	public Set<SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors()
			throws UserException {
		requireAuthenticationAndRunningServer();
		Collection<GuidanceProviderPlugin> allGuidanceProviders = bimServer
				.getPluginManager().getAllGuidanceProviders(true);
		Set<SGuidanceProviderPluginDescriptor> descriptors = new HashSet<SGuidanceProviderPluginDescriptor>();
		for (GuidanceProviderPlugin guidanceProviderPlugin : allGuidanceProviders) {
			SGuidanceProviderPluginDescriptor descriptor = new SGuidanceProviderPluginDescriptor();
			descriptor.setClassName(guidanceProviderPlugin.getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}
}