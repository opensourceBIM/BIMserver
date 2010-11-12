package org.bimserver;

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
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.AddProjectDatabaseAction;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.AddUserToProjectDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.ChangePasswordDatabaseAction;
import org.bimserver.database.actions.ChangeUserTypeDatabaseAction;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.database.actions.CheckinPart1DatabaseAction;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.database.actions.CompareDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.GetAllAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfRevisionDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllUsersDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesDatabaseAction;
import org.bimserver.database.actions.GetClashDetectionSettingsDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByGuidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByOidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsByTypeDatabaseAction;
import org.bimserver.database.actions.GetDatabaseInformationAction;
import org.bimserver.database.actions.GetGeoTagDatabaseAction;
import org.bimserver.database.actions.GetLogsDatabaseAction;
import org.bimserver.database.actions.GetRevisionDatabaseAction;
import org.bimserver.database.actions.GetRevisionSummaryDatabaseAction;
import org.bimserver.database.actions.GetShowCheckoutWarningDatabaseAction;
import org.bimserver.database.actions.GetSubProjectsDatabaseAction;
import org.bimserver.database.actions.GetUserByNameDatabaseAction;
import org.bimserver.database.actions.ProcessChangeSetDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromProjectDatabaseAction;
import org.bimserver.database.actions.ResetPasswordDatabaseAction;
import org.bimserver.database.actions.SetRevisionTagDatabaseAction;
import org.bimserver.database.actions.UndeleteProjectDatabaseAction;
import org.bimserver.database.actions.UndeleteUserDatabaseAction;
import org.bimserver.database.actions.UpdateClashDetectionSettingsDatabaseAction;
import org.bimserver.database.actions.UpdateGeoTagDatabaseAction;
import org.bimserver.database.actions.UpdateProjectDatabaseAction;
import org.bimserver.database.actions.UpdateRevisionDatabaseAction;
import org.bimserver.database.actions.UserHasCheckinRightsDatabaseAction;
import org.bimserver.database.actions.UserHasRightsDatabaseAction;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.ObjectState;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.generators.GenerateUtils;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.file.compare.CompareResult;
import org.bimserver.ifc.file.compare.CompareResult.Item;
import org.bimserver.ifc.file.reader.FastIfcFileReader;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.ChangeSet;
import org.bimserver.shared.ChangeSetResult;
import org.bimserver.shared.DataObject;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckinResult;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SRevisionSummary;
import org.bimserver.shared.SUserSession;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.UserException;
import org.bimserver.utils.Hashers;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service implements ServiceInterface {
	private static final int DEFAULT_LOGIN_ERROR_TIMEOUT = 3000;
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
	public static final int DEADLOCK_RETRIES = 10;
	private final SchemaDefinition schema;
	private final BimDatabase bimDatabase;
	private final EmfSerializerFactory emfSerializerFactory;
	private final ServiceFactory serviceFactory;

	private final LongActionManager longActionManager;
	private final AccessMethod accessMethod;
	private final IfcEngineFactory ifcEngineFactory;
	
	private long currentUoid = -1;
	private Date activeSince;
	private Date lastActive;
	private Token token;

	public Service(BimDatabase bimDatabase, EmfSerializerFactory emfSerializerFactory, SchemaDefinition schema, LongActionManager longActionManager,
			AccessMethod accessMethod, IfcEngineFactory ifcEngineFactory, ServiceFactory serviceFactory) {
		this.bimDatabase = bimDatabase;
		this.emfSerializerFactory = emfSerializerFactory;
		this.schema = schema;
		this.longActionManager = longActionManager;
		this.accessMethod = accessMethod;
		this.ifcEngineFactory = ifcEngineFactory;
		this.serviceFactory = serviceFactory;
		activeSince = new Date();
		lastActive = new Date();
	}

	@Override
	public SCheckinResult checkinSync(final long poid, final String comment, long fileSize, DataHandler ifcFile) throws UserException {
		requireAuthentication();
		return checkinInternal(poid, comment, fileSize, ifcFile, true);
	}

	@Override
	public SCheckinResult checkinAsync(final long poid, final String comment, long fileSize, DataHandler ifcFile) throws UserException {
		requireAuthentication();
		return checkinInternal(poid, comment, fileSize, ifcFile, false);
	}

	private SCheckinResult checkinInternal(final long poid, final String comment, long fileSize, DataHandler ifcFile, boolean sync) throws UserException {
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			InputStream inputStream = ifcFile.getInputStream();
			if (ifcFile.getName() != null && (ifcFile.getName().toUpperCase().endsWith(".ZIP") || ifcFile.getName().toUpperCase().endsWith(".IFCZIP"))) {
				ZipInputStream zipInputStream = new ZipInputStream(inputStream);
				ZipEntry nextEntry = zipInputStream.getNextEntry();
				if (nextEntry == null) {
					throw new UserException("Zip files must contain exactly one IFC-file, this zip-file looks empty");
				}
				if (nextEntry.getName().toUpperCase().endsWith(".IFC")) {
					IfcModel model = readModel(zipInputStream, fileSize);
					if (model.getSize() == 0) {
						throw new UserException("Uploaded file does not seem to be a correct IFC file");
					}
					if (zipInputStream.getNextEntry() != null) {
						zipInputStream.close();
						throw new UserException("Zip files may only contain one IFC-file, this zip-file contains more files");
					} else {
						zipInputStream.close();
						if (sync) {
							SCheckinResult processCheckin = processCheckinSync(poid, comment, fileSize, session, model);
							return processCheckin;
						} else {
							SCheckinResult processCheckin = processCheckinAsync(poid, comment, fileSize, session, model);
							return processCheckin;
						}
					}
				} else {
					throw new UserException("Zip files must contain exactly one IFC-file, this zip-file seems to have one or more non-IFC files");
				}
			} else if ((ifcFile.getName() != null && ifcFile.getName().toUpperCase().endsWith(".IFC")) || ifcFile.getName() == null) {
				IfcModel model = readModel(ifcFile.getInputStream(), fileSize);
				if (model.getSize() == 0) {
					throw new UserException("Uploaded file does not seem to be a correct IFC file");
				}
				SCheckinResult checkinResult = null;
				if (sync) {
					checkinResult = processCheckinSync(poid, comment, fileSize, session, model);
				} else {
					checkinResult = processCheckinAsync(poid, comment, fileSize, session, model);
				}
				inputStream.close();
				return checkinResult;
			} else {
				throw new UserException("Uploaded file does not seem to be a valid IFC file");
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	private IfcModel readModel(final InputStream inputStream, long fileSize) throws UserException {
		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
		try {
			/*
			 * Strangest hack ever, it seems that DelegatingInputStream (when
			 * using SOAP), sometimes gives 0 as a result of read(byte[] b, int
			 * off, int len), which is illegal, so this code makes sure a 0 will
			 * be interpreted as the end of the stream
			 */
			InputStream between = new InputStream() {
				@Override
				public int read() throws IOException {
					return inputStream.read();
				}

				@Override
				public int read(byte[] b, int off, int len) throws IOException {
					int read = inputStream.read(b, off, len);
					if (read == 0) {
						return -1;
					}
					return read;
				}
			};
			fastIfcFileReader.read(between, fileSize);
			return fastIfcFileReader.getModel();
		} catch (IncorrectIfcFileException e) {
			throw new UserException("Invalid IFC File", e);
		} catch (Exception e) {
			throw new UserException("Invalid IFC File", e);
		} catch (OutOfMemoryError e) {
			LOGGER.error("", e);
			ServerInfo.setErrorMessage(e.getMessage());
			throw new UserException("Out of memory.", e);
		}
	}

	private SCheckinResult processCheckinSync(final long poid, final String comment, long fileSize, final BimDatabaseSession session, IfcModel model)
			throws UserException {
		BimDatabaseAction<ConcreteRevision> action = new CheckinDatabaseAction(accessMethod, model, poid, currentUoid, comment);
		try {
			ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			SCheckinResult result = new SCheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private SCheckinResult processCheckinAsync(final long poid, final String comment, long fileSize, final BimDatabaseSession session, IfcModel model)
			throws UserException {
		try {
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, poid, currentUoid, model, comment);
			ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			session.close();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, currentUoid, revision.getOid());
			SCheckinResult result = new SCheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public SCheckoutResult checkoutLastRevision(long poid, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return checkout(session.getProjectByPoid(poid).getLastRevision().getOid(), resultType);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckoutResult checkout(long roid, ResultType resultType) throws UserException {
		requireAuthentication();
		if (resultType != ResultType.IFC && resultType != ResultType.IFCXML) {
			throw new UserException("Only IFC or IFCXML allowed when checking out");
		}
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new CheckoutDatabaseAction(accessMethod, currentUoid, roid);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(currentUoid), session.executeAndCommitAction(
					action, DEADLOCK_RETRIES), resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public long addUser(String username, String password, String name) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Long> action = new AddUserDatabaseAction(accessMethod, username, password, name, UserType.USER, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProject(String projectName) throws UserException {
		requireAuthentication();
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(accessMethod, projectName, currentUoid);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean addUserToProject(long uoid, long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(accessMethod, currentUoid, uoid, poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects() throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(accessMethod, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	private void requireAuthentication() throws UserException {
		if (currentUoid == -1) {
			throw new UserException("Authentication required for this call");
		}
	}

	private <T> List<T> convert(Collection<? extends IdEObject> list, Class<T> targetClass, BimDatabaseSession bimDatabaseSession) {
		List<T> newList = new ArrayList<T>();
		if (list == null) {
			return null;
		}
		for (IdEObject eObject : list) {
			newList.add(convert(eObject, targetClass, bimDatabaseSession));
		}
		return newList;
	}

	@SuppressWarnings("unchecked")
	private <T> T convert(IdEObject original, Class<T> targetClass, BimDatabaseSession bimDatabaseSession) {
		if (original == null) {
			return null;
		}
		try {
			Class<?> realClass = Class.forName("org.bimserver.interfaces.objects.S" + original.eClass().getName());
			T newInstance = (T) realClass.newInstance();
			Method setOidMethod = targetClass.getMethod("setOid", new Class[] { long.class });
			setOidMethod.invoke(newInstance, original.getOid());
			EClass eClass = original.eClass();
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				Object value = original.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (eStructuralFeature.getEType() instanceof EEnum) {
						Enumerator enumerator = (Enumerator) value;
						Class<?> forName = Class.forName("org.bimserver.interfaces.objects.S" + eStructuralFeature.getEType().getName());
						Object[] enumConstants = forName.getEnumConstants();
						boolean found = false;
						for (Object t : enumConstants) {
							Enum<?> en = (Enum<?>) t;
							Method method2 = en.getDeclaringClass().getMethod("getOrdinal");
							Object invoke = method2.invoke(en);
							if ((Integer) invoke == enumerator.getValue()) {
								try {
									Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { forName });
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
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { eStructuralFeature.getEType().getInstanceClass() });
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
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { List.class });
							method.invoke(newInstance, newList);
						} catch (NoSuchMethodException e) {
						}
					} else {
						try {
							Method method = realClass.getMethod(GenerateUtils.makeSetter(eStructuralFeature), new Class[] { long.class });
							if (value == null) {
								method.invoke(newInstance, -1);
							} else {
								IdEObject referencedObject = (IdEObject) value;
								method.invoke(newInstance, referencedObject.getOid());
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
	public List<SRevision> getAllRevisionsOfProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SRevision.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SCheckout.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws UserException {
		requireAuthentication();
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(accessMethod, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean login(String username, String password) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && user.getPassword().equals(Hashers.getSha256Hash(password))) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				}
				this.currentUoid = user.getOid();
				BimDatabaseSession session2 = bimDatabase.createSession();
				try {
					session2.updateLastActive(user.getOid());
					try {
						session2.commit();
					} catch (BimDeadlockException e) {
						LOGGER.error("", e);
					}
				} finally {
					session2.close();
				}
				return true;
			} else {
				try {
					Thread.sleep(DEFAULT_LOGIN_ERROR_TIMEOUT);
				} catch (InterruptedException e) {
					LOGGER.error("", e);
				}
				throw new UserException("Invalid username/password combination");
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SCheckout.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SRevision.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevision getRevision(long roid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(accessMethod, roid, currentUoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SRevision.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(long roid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(accessMethod, roid);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SCheckout.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	public SCheckoutResult download(long roid, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(accessMethod, roid, currentUoid);
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			SCheckoutResult checkoutResult = convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(currentUoid),
					ifcModel, resultType);
			return checkoutResult;
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteUser(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(int pid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(accessMethod, pid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean removeUserFromProject(long uoid, long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(accessMethod, uoid, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public ChangeSetResult processChangeSet(ChangeSet changeSet, long poid, String comment) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<ChangeSetResult> action = new ProcessChangeSetDatabaseAction(accessMethod, changeSet, poid, currentUoid, comment);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckoutResult downloadByOids(Set<Long> roids, Set<Long> oids, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadByOidsDatabaseAction(accessMethod, roids, oids, currentUoid);
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roids.iterator().next()).getProject(), session.getUserByUoid(currentUoid), ifcModel,
					resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error " + e.getMessage(), e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	private SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType) throws UserException, NoSerializerFoundException {
		requireAuthentication();
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			EmfSerializer serializer;
			try {
				serializer = emfSerializerFactory.create(project, user, resultType, model, checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "."
						+ resultType.getDefaultExtension());
				checkoutResult.setFile(new DataHandler(serializer));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}

	@Override
	public SCheckoutResult downloadOfType(long roid, String className, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadOfTypeDatabaseAction(accessMethod, roid, className, currentUoid);
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(currentUoid), ifcModel, resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<String> getAvailableClasses() throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public DatabaseInformation getDatabaseInformation() throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(accessMethod);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckoutResult downloadByGuids(Set<Long> roids, Set<String> guids, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadByGuidsDatabaseAction(accessMethod, roids, guids, currentUoid);
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roids.iterator().next()).getProject(), session.getUserByUoid(currentUoid), ifcModel,
					resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public ChangeSetResult processChangeSetFile(long poid, String comment, DataHandler changeSetFile) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ChangeSet.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			ChangeSet changeSet = (ChangeSet) unmarshaller.unmarshal(changeSetFile.getInputStream());
			BimDatabaseAction<ChangeSetResult> action = new ProcessChangeSetDatabaseAction(accessMethod, changeSet, poid, currentUoid, comment);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (JAXBException e1) {
			throw new UserException("Error", e1);
		} catch (IOException e) {
			throw new UserException("Error", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SUser getLoggedInUser() throws UserException {
		requireAuthentication();
		return getUserByUoid(currentUoid);
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(accessMethod, uoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void logout() throws UserException {
		requireAuthentication();
		currentUoid = -1;
	}

	@Override
	public boolean changePassword(long uoid, String oldPassword, String newPassword) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(accessMethod, uoid, oldPassword, newPassword, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, username);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	public boolean loginAsAdmin() throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, "admin");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null) {
				currentUoid = user.getOid();
				return true;
			} else {
				return false;
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean undeleteProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(accessMethod, poid, currentUoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean undeleteUser(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(accessMethod, currentUoid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, long parentPoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(accessMethod, projectName, parentPoid, currentUoid);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(accessMethod, currentUoid, sProject);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(accessMethod, currentUoid, sRevision);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(long roid1, long roid2) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(accessMethod, currentUoid, roid1, roid2);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SCompareResult.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	private static SCompareResult.Type convert(CompareResult.Type type) {
		if (type == CompareResult.Type.ADDED) {
			return SCompareResult.Type.ADDED;
		} else if (type == CompareResult.Type.DELETED) {
			return SCompareResult.Type.DELETED;
		} else if (type == CompareResult.Type.MODIFIED) {
			return SCompareResult.Type.MODIFIED;
		}
		return null;
	}

	private SCompareResult convert(CompareResult compareResult, Class<SCompareResult> class1, BimDatabaseSession session) {
		SCompareResult sCompareResult = new SCompareResult();
		Map<EClass, List<Item>> items = compareResult.getItems();
		for (EClass key : items.keySet()) {
			List<Item> list = items.get(key);
			for (Item item : list) {
				DataObject dataObject = new DataObject(item.eObject.eClass().getName(), 0, getGuid(item.eObject), getName(item.eObject));
				SCompareResult.Item item2 = new SCompareResult.Item(dataObject, convert(item.type));
				sCompareResult.add(item2);
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
	public SRevisionSummary getRevisionSummary(long roid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<SRevisionSummary> action = new GetRevisionSummaryDatabaseAction(accessMethod, roid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean userHasCheckinRights(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(accessMethod, currentUoid, poid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getShowCheckoutWarning(long poid, long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<String> action = new GetShowCheckoutWarningDatabaseAction(accessMethod, poid, uoid);
			return session.executeAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean userHasRights(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(accessMethod, getCurrentUser().getOid(), poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckoutResult downloadProjects(Set<Long> roids, ResultType resultType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadProjectsDatabaseAction(accessMethod, roids, currentUoid);
			Project project = session.getRevisionByRoid(roids.iterator().next()).getProject();
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			User userByUoid = session.getUserByUoid(currentUoid);
			SCheckoutResult checkoutResult = convertModelToCheckoutResult(project, userByUoid, ifcModel, resultType);
			return checkoutResult;
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public DataObject getDataObjectByOid(long roid, long oid, String className) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByOidDatabaseAction(accessMethod, roid, oid, session.getCidForClassName(className));
			DataObject dataObject = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return dataObject;
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public DataObject getDataObjectByGuid(long roid, String guid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByGuidDatabaseAction(accessMethod, roid, guid);
			DataObject dataObject = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return dataObject;
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<DataObject> getDataObjectsByType(long roid, String className) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		BimDatabaseAction<List<DataObject>> action = new GetDataObjectsByTypeDatabaseAction(accessMethod, roid, className);
		try {
			List<DataObject> dataObjects = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return dataObjects;
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public String resetPassword(String emailAddress) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<String> action = new ResetPasswordDatabaseAction(accessMethod, emailAddress);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SGuidClash> findClashesByGuid(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.executeAction(new FindClashesDatabaseAction(accessMethod, sClashDetectionSettings, schema, ifcEngineFactory, currentUoid),
					DEADLOCK_RETRIES), SGuidClash.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SEidClash> findClashesByEid(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.executeAction(new FindClashesDatabaseAction(accessMethod, sClashDetectionSettings, schema, ifcEngineFactory, currentUoid),
					DEADLOCK_RETRIES), SEidClash.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCheckinResult branchToNewProject(long roid, String projectName, String comment) throws UserException {
		requireAuthentication();
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			Revision oldRevision = session.getVirtualRevision(roid);
			Project oldProject = oldRevision.getProject();
			User user = session.getUserByUoid(currentUoid);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			LinkedHashSet<IfcModel> ifcModels = new LinkedHashSet<IfcModel>();
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel(session.getMap(subRevision.getProject().getId(), subRevision.getId()).getMap());
				subModel.setDate(subRevision.getDate());
				ifcModels.add(subModel);
			}
			IfcModel model = BimDatabaseAction.merge(oldRevision.getProject(), ifcModels);
			Project newProject = new AddProjectDatabaseAction(accessMethod, projectName, currentUoid).execute(session);
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, newProject.getOid(), currentUoid, model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, currentUoid, revision.getOid());
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
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
	public SCheckinResult branchToExistingProject(long roid, long destPoid, String comment) throws UserException {
		requireAuthentication();
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			Revision oldRevision = session.getVirtualRevision(roid);
			Project oldProject = oldRevision.getProject();
			User user = session.getUserByUoid(currentUoid);
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			LinkedHashSet<IfcModel> ifcModels = new LinkedHashSet<IfcModel>();
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel(session.getMap(subRevision.getProject().getId(), subRevision.getId()).getMap());
				subModel.setDate(subRevision.getDate());
				ifcModels.add(subModel);
			}
			IfcModel model = BimDatabaseAction.merge(oldRevision.getProject(), ifcModels);
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, destPoid, currentUoid, model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, currentUoid, revision.getOid());
				SCheckinResult result = new SCheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
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
	public List<SLogAction> getLogs() throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(accessMethod, currentUoid);
			List<LogAction> logs = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return convert(logs, SLogAction.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(long goid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(accessMethod, currentUoid, goid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SGeoTag.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(accessMethod, currentUoid, sGeoTag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SClashDetectionSettings getClashDetectionSettings(long cdsoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<ClashDetectionSettings> action = new GetClashDetectionSettingsDatabaseAction(accessMethod, currentUoid, cdsoid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SClashDetectionSettings.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateClashDetectionSettings(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateClashDetectionSettingsDatabaseAction(accessMethod, currentUoid, sClashDetectionSettings);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SClash> getLastClashes(long roid) throws UserException {
		requireAuthentication();
		return null;
	}

	@Override
	public SUser getUserByUoid(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getUserByUoid(uoid), SUser.class, session);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getProjectByPoid(poid), SProject.class, session);
		} finally {
			session.close();
		}
	}

	@Override
	public String ping(String in) {
		return in;
	}

	@Override
	public SUser getAnonymousUser() throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getAnonymousUser(), SUser.class, session);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return null;
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(accessMethod, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getUsersProjects(long uoid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			User user = session.getUserByUoid(uoid);
			return convert(user.getHasRightsOn(), SProject.class, session);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectByName(String name) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getProjectsByName(name), SProject.class, session);
		} catch (BimDeadlockException e) {
			throw new UserException(e);
		} catch (BimDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean autologin(String username, String hash) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && hash.equals(Hashers.getSha256Hash(user.getUsername() + user.getPassword()))) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				}
				currentUoid = user.getOid();
				BimDatabaseSession session2 = bimDatabase.createSession();
				try {
					session2.updateLastActive(user.getOid());
					try {
						session2.commit();
					} catch (BimDeadlockException e) {
						LOGGER.error("", e);
					}
				} finally {
					session2.close();
				}
				return true;
			} else {
				return false;
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setRevisionTag(long roid, String tag) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(accessMethod, roid, tag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getSubProjects(long poid) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(accessMethod, currentUoid, poid);
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(long uoid, SUserType userType) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(accessMethod, currentUoid, uoid, userType);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean isExportTypeEnabled(ResultType resultType) throws UserException {
		requireAuthentication();
		return emfSerializerFactory.resultTypeEnabled(resultType);
	}

	@Override
	public void setExportTypeEnabled(ResultType resultType, boolean enabled) throws UserException {
		requireAuthentication();
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			User user = session.getUserByUoid(currentUoid);
			if (user.getUserType() != UserType.ADMIN) {
				throw new UserException("Only admin users can change enabled export types");
			}
			Set<ResultType> resultTypes = ServerSettings.getSettings().getEnabledExportTypesAsSet();
			if (enabled) {
				resultTypes.add(resultType);
			} else {
				resultTypes.remove(resultType);
			}
			ServerSettings.getSettings().updateEnabledResultTypes(resultTypes);
			ServerSettings.getSettings().save();
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getCurrentUser() throws UserException {
		requireAuthentication();
		if (currentUoid == -1) {
			return null;
		}
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			User user = session.getUserByUoid(currentUoid);
			return convert(user, SUser.class, session);
		} finally {
			session.close();
		}
	}

	public void close() {
	}

	@Override
	public boolean isLoggedIn() {
		return currentUoid != -1;
	}

	@Override
	public void loginAnonymous() throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, "anonymous");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			currentUoid = user.getOid();
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUserSession> getActiveUserSessions() throws UserException {
		requireAuthentication();
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
}