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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.WebServiceContext;

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
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.database.actions.CheckinPart1DatabaseAction;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.database.actions.CompareDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidDatabaseAction;
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
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.file.compare.CompareResult;
import org.bimserver.ifc.file.compare.CompareResult.Item;
import org.bimserver.ifc.file.reader.FastIfcFileReader;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.rights.RightsManager;
import org.bimserver.services.TokenManager;
import org.bimserver.shared.ChangeSet;
import org.bimserver.shared.ChangeSetResult;
import org.bimserver.shared.CheckinResult;
import org.bimserver.shared.CheckoutResult;
import org.bimserver.shared.DataObject;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SRevisionSummary;
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

public class Service implements ServiceInterface {
	public static final int DEADLOCK_RETRIES = 10;
	private final SchemaDefinition schema;
	private final TokenManager tokenManager;
	private final BimDatabase bimDatabase;
	private final EmfSerializerFactory emfSerializerFactory;

	@Resource
	public WebServiceContext context;
	private final LongActionManager longActionManager;
	private final AccessMethod accessMethod;
	private final IfcEngineFactory ifcEngineFactory;

	public Service(BimDatabase bimDatabase, EmfSerializerFactory emfSerializerFactory, SchemaDefinition schema, TokenManager tokenManager, LongActionManager longActionManager,
			AccessMethod accessMethod, IfcEngineFactory ifcEngineFactory) {
		this.bimDatabase = bimDatabase;
		this.emfSerializerFactory = emfSerializerFactory;
		this.schema = schema;
		this.tokenManager = tokenManager;
		this.longActionManager = longActionManager;
		this.accessMethod = accessMethod;
		this.ifcEngineFactory = ifcEngineFactory;
	}

	@Override
	public CheckinResult checkinSync(final Token token, final long poid, final String comment, long fileSize, DataHandler ifcFile) throws UserException {
		return checkinInternal(token, poid, comment, fileSize, ifcFile, true);
	}

	@Override
	public CheckinResult checkinAsync(final Token token, final long poid, final String comment, long fileSize, DataHandler ifcFile) throws UserException {
		return checkinInternal(token, poid, comment, fileSize, ifcFile, false);
	}

	private CheckinResult checkinInternal(final Token token, final long poid, final String comment, long fileSize, DataHandler ifcFile, boolean sync) throws UserException {
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			InputStream inputStream = ifcFile.getInputStream();
			if (ifcFile.getName() != null && ifcFile.getName().toUpperCase().endsWith(".ZIP")) {
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
							CheckinResult processCheckin = processCheckinSync(token, poid, comment, fileSize, session, model);
							return processCheckin;
						} else {
							CheckinResult processCheckin = processCheckinAsync(token, poid, comment, fileSize, session, model);
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
				CheckinResult checkinResult = null;
				if (sync) {
					checkinResult = processCheckinSync(token, poid, comment, fileSize, session, model);
				} else {
					checkinResult = processCheckinAsync(token, poid, comment, fileSize, session, model);
				}
				inputStream.close();
				return checkinResult;
			} else {
				throw new UserException("Uploaded file does not seem to be a valid IFC file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	private IfcModel readModel(final InputStream inputStream, long fileSize) throws UserException {
		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
		try {
			/*
			 * Strangest hack ever, it seems that DelegatingInputStream (when using SOAP), sometimes gives 0 as a result of read(byte[] b, int off, int len),
			 * which is illegal, so this code makes sure a 0 will be interpreted as the end of the stream
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
			e.printStackTrace();
			ServerInfo.setErrorMessage(e.getMessage());
			throw new UserException("Out of memory.", e);
		}
	}

	private CheckinResult processCheckinSync(final Token token, final long poid, final String comment, long fileSize, final BimDatabaseSession session, IfcModel model)
			throws UserException {
		BimDatabaseAction<ConcreteRevision> action = new CheckinDatabaseAction(accessMethod, model, poid, tokenManager.getUoid(token), comment);
		try {
			ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			CheckinResult result = new CheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private CheckinResult processCheckinAsync(final Token token, final long poid, final String comment, long fileSize, final BimDatabaseSession session, IfcModel model)
			throws UserException {
		BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, poid, tokenManager.getUoid(token), model, comment);
		try {
			ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			session.close();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, tokenManager.getUoid(token), revision.getOid());
			CheckinResult result = new CheckinResult();
			result.setRid(revision.getId());
			result.setPoid(revision.getProject().getOid());
			result.setProjectName(revision.getProject().getName());
			longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public CheckoutResult checkoutLastRevision(Token token, long poid, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return checkout(token, session.getProjectByPoid(poid).getLastRevision().getOid(), resultType);
		} finally {
			session.close();
		}
	}

	@Override
	public CheckoutResult checkout(Token token, long roid, ResultType resultType) throws UserException {
		if (resultType != ResultType.IFC && resultType != ResultType.IFCXML) {
			throw new UserException("Only IFC or IFCXML allowed when checking out");
		}
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new CheckoutDatabaseAction(accessMethod, tokenManager.getUoid(token), roid);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(tokenManager.getUoid(token)), session.executeAndCommitAction(
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
	public long addUser(Token token, String username, String password, String name) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Long> action = new AddUserDatabaseAction(accessMethod, username, password, name, UserType.USER, tokenManager.getUoid(token));
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProject(Token token, String projectName) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(accessMethod, projectName, tokenManager.getUoid(token));
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean addUserToProject(Token token, long uoid, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(accessMethod, tokenManager.getUoid(token), uoid, poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects(Token token) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(accessMethod, tokenManager.getUoid(token));
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	private <T> List<T> convert(Collection<? extends IdEObject> list, Class<T> targetClass, BimDatabaseSession bimDatabaseSession) {
		List<T> newList = new ArrayList<T>();
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
			Class realClass = Class.forName("org.bimserver.interfaces.objects.S" + original.eClass().getName());
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
							Enum en = (Enum) t;
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
							System.out.println(value.toString() + " not found");
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
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Token token, long poid) throws UserException {
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
	public List<SCheckout> getAllCheckoutsOfProject(Token token, long poid) throws UserException {
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
	public List<SUser> getAllUsers(Token token) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(accessMethod, tokenManager.getUoid(token));
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SUser.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public Token login(String username, String password) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && user.getPassword().equals(Hashers.getSha256Hash(password))) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				}
				BimDatabaseSession session2 = bimDatabase.createSession();
				try {
					session2.updateLastActive(user.getOid());
					try {
						session2.commit();
					} catch (BimDeadlockException e) {
						e.printStackTrace();
					}
				} finally {
					session2.close();
				}
				return tokenManager.newToken(user.getOid());
			} else {
				return null;
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Token token, long uoid) throws UserException {
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
	public List<SRevision> getAllRevisionsByUser(Token token, long uoid) throws UserException {
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
	public SRevision getRevision(Token token, long roid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(accessMethod, roid, tokenManager.getUoid(token));
			return convert(session.executeAction(action, DEADLOCK_RETRIES), SRevision.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Token token, long roid) throws UserException {
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

	public CheckoutResult download(Token token, long roid, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(accessMethod, roid, tokenManager.getUoid(token));
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			CheckoutResult checkoutResult = convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(tokenManager.getUoid(token)),
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
	public boolean deleteProject(Token token, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(accessMethod, poid, tokenManager.getUoid(token));
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteUser(Token token, long uoid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(accessMethod, tokenManager.getUoid(token), uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Token token, int pid) throws UserException {
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
	public boolean removeUserFromProject(Token token, long uoid, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(accessMethod, uoid, poid, tokenManager.getUoid(token));
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public ChangeSetResult processChangeSet(Token token, ChangeSet changeSet, long poid, String comment) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<ChangeSetResult> action = new ProcessChangeSetDatabaseAction(accessMethod, changeSet, poid, tokenManager.getUoid(token), comment);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public CheckoutResult downloadByOid(Token token, long roid, long oid, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadByOidDatabaseAction(accessMethod, roid, oid, tokenManager.getUoid(token));
			IfcModel ifcModel = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(tokenManager.getUoid(token)), ifcModel, resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error " + e.getMessage(), e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	private CheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType) throws UserException, NoSerializerFoundException {
		CheckoutResult checkoutResult = new CheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			EmfSerializer serializer = emfSerializerFactory.create(project, user, resultType, model, checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "."
					+ resultType.getDefaultExtension());
			checkoutResult.setFile(new DataHandler(serializer));
		}
		return checkoutResult;
	}

	@Override
	public CheckoutResult downloadOfType(Token token, long roid, String className, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadOfTypeDatabaseAction(accessMethod, roid, className, tokenManager.getUoid(token));
			IfcModel ifcModel = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roid).getProject(), session.getUserByUoid(tokenManager.getUoid(token)), ifcModel, resultType);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} catch (NoSerializerFoundException e) {
			throw new UserException("Serialize error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<String> getAvailableClasses(Token token) throws UserException {
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
	public DatabaseInformation getDatabaseInformation(Token token) throws UserException {
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

	public TokenManager getTokenManager() {
		return tokenManager;
	}

	@Override
	public Token createAnonymousToken() throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, "anonymous");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			return tokenManager.newToken(user.getOid());
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public CheckoutResult downloadByGuids(Token token, Set<Long> roids, Set<String> guids, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadByGuidsDatabaseAction(accessMethod, roids, guids, tokenManager.getUoid(token));
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			return convertModelToCheckoutResult(session.getRevisionByRoid(roids.iterator().next()).getProject(), session.getUserByUoid(tokenManager.getUoid(token)), ifcModel,
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
	public ChangeSetResult processChangeSetFile(Token token, long poid, String comment, DataHandler changeSetFile) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ChangeSet.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			ChangeSet changeSet = (ChangeSet) unmarshaller.unmarshal(changeSetFile.getInputStream());
			BimDatabaseAction<ChangeSetResult> action = new ProcessChangeSetDatabaseAction(accessMethod, changeSet, poid, tokenManager.getUoid(token), comment);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (JAXBException e1) {
			throw new UserException("Error", e1);
		} catch (IOException e) {
			throw new UserException("Error", e);
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SUser getLoggedInUser(Token token) throws UserException {
		return getUserByUoid(token, tokenManager.getUoid(token));
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Token token, long uoid) throws UserException {
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
	public SUser getUserOfToken(Token token) throws UserException {
		return getUserByUoid(token, tokenManager.getUoid(token));
	}

	@Override
	public void logout(Token token) {
		tokenManager.remove(token);
	}

	@Override
	public boolean changePassword(Token token, long uoid, String oldPassword, String newPassword) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new ChangePasswordDatabaseAction(accessMethod, uoid, oldPassword, newPassword, tokenManager.getUoid(token));
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws UserException {
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

	public Token loginAsAdmin() throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, "admin");
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null) {
				return tokenManager.newToken(user.getOid());
			} else {
				return null;
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean undeleteProject(Token token, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(accessMethod, poid, tokenManager.getUoid(token));
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean undeleteUser(Token token, long uoid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(accessMethod, tokenManager.getUoid(token), uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProject(Token token, String projectName, long parentPoid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(accessMethod, projectName, parentPoid, tokenManager.getUoid(token));
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SProject.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(Token token, SProject sProject) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(accessMethod, tokenManager.getUoid(token), sProject);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(Token token, SRevision sRevision) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(accessMethod, tokenManager.getUoid(token), sRevision);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(Token token, long uoid, long roid1, long roid2) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(accessMethod, uoid, roid1, roid2);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SCompareResult.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	public static SCompareResult.Type convert(CompareResult.Type type) {
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
	public SRevisionSummary getRevisionSummary(Token token, long roid) throws UserException {
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
	public boolean userHasCheckinRights(Token token, long uoid, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(accessMethod, uoid, poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getShowCheckoutWarning(Token token, long poid, long uoid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<String> action = new GetShowCheckoutWarningDatabaseAction(accessMethod, poid, uoid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public boolean userHasRights(Token token, long poid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(accessMethod, getUserOfToken(token).getOid(), poid);
			return session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public CheckoutResult downloadProjects(Token token, Set<Long> roids, ResultType resultType) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadProjectsDatabaseAction(accessMethod, roids, tokenManager.getUoid(token));
			Project project = session.getRevisionByRoid(roids.iterator().next()).getProject();
			IfcModel ifcModel = session.executeAction(action, DEADLOCK_RETRIES);
			User userByUoid = session.getUserByUoid(tokenManager.getUoid(token));
			CheckoutResult checkoutResult = convertModelToCheckoutResult(project, userByUoid, ifcModel, resultType);
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
	public DataObject getDataObjectByOid(Token token, long roid, long oid, String className) throws UserException {
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
	public DataObject getDataObjectByGuid(Token token, long roid, String guid) throws UserException {
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
	public List<DataObject> getDataObjectsByType(Token token, long roid, String className) throws UserException {
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
	public List<SClash> findClashes(Token token, SClashDetectionSettings sClashDetectionSettings) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.executeAction(new FindClashesDatabaseAction(accessMethod, sClashDetectionSettings, schema, ifcEngineFactory, tokenManager.getUoid(token)),
					DEADLOCK_RETRIES), SClash.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public CheckinResult branchToNewProject(Token token, long roid, String projectName, String comment) throws UserException {
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			Revision oldRevision = session.getVirtualRevision(roid);
			Project oldProject = oldRevision.getProject();
			User user = session.getUserByUoid(tokenManager.getUoid(token));
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			IfcModel model = new IfcModel((int) oldRevision.getSize());
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				BimDatabaseAction.merge(subRevision.getProject(), model, new IfcModel(session.getMap(subRevision.getProject().getId(), subRevision.getId()).getMap()));
			}
			Project newProject = new AddProjectDatabaseAction(accessMethod, projectName, tokenManager.getUoid(token)).execute(session);
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, newProject.getOid(), tokenManager.getUoid(token), model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, tokenManager.getUoid(token), revision.getOid());
				CheckinResult result = new CheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
				return result;
			} catch (UserException e) {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (BimDeadlockException e2) {
			e2.printStackTrace();
		} catch (BimDatabaseException e2) {
			e2.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public CheckinResult branchToExistingProject(Token token, long roid, long destPoid, String comment) throws UserException {
		final BimDatabaseSession session = bimDatabase.createSession();
		try {
			Revision oldRevision = session.getVirtualRevision(roid);
			Project oldProject = oldRevision.getProject();
			User user = session.getUserByUoid(tokenManager.getUoid(token));
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			IfcModel model = new IfcModel((int) oldRevision.getSize());
			for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
				BimDatabaseAction.merge(subRevision.getProject(), model, new IfcModel(session.getMap(subRevision.getProject().getId(), subRevision.getId()).getMap()));
			}
			BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(accessMethod, destPoid, tokenManager.getUoid(token), model, comment);
			try {
				ConcreteRevision revision = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
				session.close();
				CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(accessMethod, model, tokenManager.getUoid(token), revision.getOid());
				CheckinResult result = new CheckinResult();
				result.setRid(revision.getId());
				result.setPoid(revision.getProject().getOid());
				result.setProjectName(revision.getProject().getName());
				longActionManager.start(new LongCheckinAction(longActionManager, bimDatabase, schema, createCheckinAction, ifcEngineFactory));
				return result;
			} catch (UserException e) {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (BimDeadlockException e2) {
			e2.printStackTrace();
		} catch (BimDatabaseException e2) {
			e2.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SLogAction> getLogs(Token token) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(accessMethod, tokenManager.getUoid(token));
			List<LogAction> logs = session.executeAndCommitAction(action, DEADLOCK_RETRIES);
			return convert(logs, SLogAction.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(Token token, long goid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(accessMethod, tokenManager.getUoid(token), goid);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SGeoTag.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(Token token, SGeoTag sGeoTag) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(accessMethod, tokenManager.getUoid(token), sGeoTag);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public SClashDetectionSettings getClashDetectionSettings(Token token, long cdsoid) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<ClashDetectionSettings> action = new GetClashDetectionSettingsDatabaseAction(accessMethod, tokenManager.getUoid(token), cdsoid);
			return convert(session.executeAndCommitAction(action, DEADLOCK_RETRIES), SClashDetectionSettings.class, session);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateClashDetectionSettings(Token token, SClashDetectionSettings sClashDetectionSettings) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<Void> action = new UpdateClashDetectionSettingsDatabaseAction(accessMethod, tokenManager.getUoid(token), sClashDetectionSettings);
			session.executeAndCommitAction(action, DEADLOCK_RETRIES);
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SClash> getLastClashes(Token token, long roid) throws UserException {
		return null;
	}

	@Override
	public SUser getUserByUoid(Token token, long uoid) {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getUserByUoid(uoid), SUser.class, session);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Token token, long poid) throws UserException {
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
	public SUser getAnonymousUser(Token token) {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			return convert(session.getAnonymousUser(), SUser.class, session);
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Token token, long poid) throws UserException {
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
	public List<SUser> getAllAuthorizedUsersOfProject(Token token, long poid) throws UserException {
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
	public List<SProject> getUsersProjects(long uoid) {
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
	public Token autologin(String username, String hash) throws UserException {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			BimDatabaseAction<User> action = new GetUserByNameDatabaseAction(accessMethod, username);
			User user = session.executeAction(action, DEADLOCK_RETRIES);
			if (user != null && hash.equals(Hashers.getSha256Hash(user.getUsername() + user.getPassword()))) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				}
				BimDatabaseSession session2 = bimDatabase.createSession();
				try {
					session2.updateLastActive(user.getOid());
					try {
						session2.commit();
					} catch (BimDeadlockException e) {
						e.printStackTrace();
					}
				} finally {
					session2.close();
				}
				return tokenManager.newToken(user.getOid());
			} else {
				return null;
			}
		} catch (BimDatabaseException e) {
			throw new UserException("Database error", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setRevisionTag(long roid, String tag) throws UserException {
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
}