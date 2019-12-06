package org.bimserver.database.actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.GeometryCache;
import org.bimserver.GeometryGenerator;
import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.PostCommitAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.geometry.Density;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DensityCollection;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private final boolean merge;
	private ConcreteRevision concreteRevision;
	private Project project;
	private Authorization authorization;
	private final GeometryCache geometryCache = new GeometryCache();
	private String fileName;
	private long fileSize;
	private IfcModelInterface model;
	private long newServiceId;
	private long topicId;

	public CheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, IfcModelInterface model, String comment, String fileName, boolean merge, long newServiceId, long topicId) {
		super(bimServer, databaseSession, accessMethod);
		this.poid = poid;
		this.authorization = authorization;
		this.model = model;
		this.comment = comment;
		this.fileName = fileName;
		this.merge = merge;
		this.newServiceId = newServiceId;
		this.topicId = topicId;
	}
	
	public IfcModelInterface getModel() {
		return model;
	}
	
	@Override
	public ConcreteRevision execute() throws UserException, BimserverDatabaseException {
		try {
			if (fileSize == -1) {
				setProgress("Deserializing IFC file...", -1);
			} else {
				setProgress("Deserializing IFC file...", 0);
			}
			if (getModel().size() == 0) {
				throw new DeserializeException(DeserializerErrorCode.EMPTY_MODEL_CANNOT_BE_CHECKED_IN, "Cannot checkin empty model");
			}
			authorization.canCheckin(poid);
			project = getProjectByPoid(poid);
			int nrConcreteRevisionsBefore = project.getConcreteRevisions().size();
			User user = getUserByUoid(authorization.getUoid());
			if (project == null) {
				throw new UserException("Project with poid " + poid + " not found");
			}
			if (!authorization.hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
			if (getModel() != null) {
				checkCheckSum(project, getModel());
			}
			
			long size = 0;
			if (getModel() != null) {
				for (IdEObject idEObject : getModel().getValues()) {
					if (idEObject.eClass().getEAnnotation("hidden") == null) {
						size++;
					}
				}
				getModel().fixInverseMismatches();
			}
			
			for (ModelCheckerInstance modelCheckerInstance : project.getModelCheckers()) {
				if (modelCheckerInstance.isValid()) {
					ModelCheckerPlugin modelCheckerPlugin = getBimServer().getPluginManager().getModelCheckerPlugin(modelCheckerInstance.getModelCheckerPluginClassName(), true);
					if (modelCheckerPlugin != null) {
						ModelChecker modelChecker = modelCheckerPlugin.createModelChecker(null);
						ModelCheckerResult result = modelChecker.check(getModel(), modelCheckerInstance.getCompiled());
						if (!result.isValid()) {
							throw new UserException("Model is not valid according to " + modelCheckerInstance.getName());
						}
					}
				}
			}
			
			CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), size, project, user, comment.trim());
			concreteRevision = result.getConcreteRevision();
			IfcHeader ifcHeader = getModel().getModelMetaData().getIfcHeader();
			if (ifcHeader != null) {
				getDatabaseSession().store(ifcHeader);
				concreteRevision.setIfcHeader(ifcHeader);
			}
			project.getConcreteRevisions().add(concreteRevision);
			if (getModel() != null) {
				concreteRevision.setChecksum(getModel().getModelMetaData().getChecksum());
			}
			final NewRevisionAdded newRevisionAdded = getDatabaseSession().create(NewRevisionAdded.class);
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			final Revision revision = concreteRevision.getRevisions().get(0);
			
			if (newServiceId != -1) {
				NewService newService = getDatabaseSession().get(newServiceId, OldQuery.getDefault());
				revision.getServicesLinked().add(newService);
			}

			concreteRevision.setSummary(new SummaryMap(getModel()).toRevisionSummary(getDatabaseSession()));

			// If this revision is being created by an external service, store a link to the service in the revision
			if (authorization instanceof ExplicitRightsAuthorization) {
				ExplicitRightsAuthorization explicitRightsAuthorization = (ExplicitRightsAuthorization)authorization;
				if (explicitRightsAuthorization.getSoid() != -1) {
					Service service = getDatabaseSession().get(explicitRightsAuthorization.getSoid(), OldQuery.getDefault());
					revision.setService(service);
				}
			}
			
			newRevisionAdded.setRevision(revision);
			newRevisionAdded.setProject(project);
			newRevisionAdded.setAccessMethod(getAccessMethod());

			Revision lastRevision = project.getLastRevision();
			IfcModelInterface ifcModel = null;
			if (merge && lastRevision != null) {
				ifcModel = checkinMerge(lastRevision);
			} else {
				ifcModel = getModel();
			}

			ifcModel.fixOidsFlat(getDatabaseSession());

			if (getBimServer().getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin()) {
				setProgress("Generating Geometry...", -1);
				
				UserSettings userSettings = user.getUserSettings();
				RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
				if (defaultRenderEngine == null) {
					throw new UserException("No default render engine has been selected for this user");
				}
				
				RenderEnginePool pool = getBimServer().getRenderEnginePools().getRenderEnginePool(model.getPackageMetaData().getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName(), getBimServer().getPluginSettingsCache().getPluginSettings(defaultRenderEngine.getOid()));

				GenerateGeometryResult generateGeometry = new GeometryGenerator(getBimServer()).generateGeometry(pool, getBimServer().getPluginManager(), getDatabaseSession(), ifcModel, project.getId(), concreteRevision.getId(), true, geometryCache);

				// TODO OUTDATED!!!
				
				// TODO deduplicate (this is duplicated 4 times now!)
				concreteRevision.setMultiplierToMm(generateGeometry.getMultiplierToMm());
				concreteRevision.setBounds(generateGeometry.getBounds());
				concreteRevision.setBoundsUntransformed(generateGeometry.getBoundsUntransformed());
				
				DensityCollection densityCollection = getDatabaseSession().create(DensityCollection.class);
				concreteRevision.eSet(StorePackage.eINSTANCE.getConcreteRevision_DensityCollection(), densityCollection);
				
				Collections.sort(generateGeometry.getDensities(), new Comparator<Density>(){
					@Override
					public int compare(Density o1, Density o2) {
						return (int) ((o1.getDensityValue() - o2.getDensityValue()) * 10000000);
					}});
				for (Density density : generateGeometry.getDensities()) {
					org.bimserver.models.store.Density dbDensity = getDatabaseSession().create(org.bimserver.models.store.Density.class);
					dbDensity.setDensity(density.getDensityValue());
					dbDensity.setGeometryInfoId(density.getGeometryInfoId());
					dbDensity.setTrianglesBelow(density.getNrPrimitives());
					dbDensity.setVolume(density.getVolume());
					densityCollection.getDensities().add(dbDensity);
				}

				for (Revision other : concreteRevision.getRevisions()) {
					other.setHasGeometry(true);
				}
			}

			if (nrConcreteRevisionsBefore != 0 && !merge) {
				// There already was a revision, lets delete it (only when not merging)
				concreteRevision.setClear(true);
			}
			Set<EClass> eClasses = ifcModel.getUsedClasses();
			Map<String, Long> startOids = getDatabaseSession().getStartOids();
			if (startOids == null) {
				throw new BimserverDatabaseException("No objects changed");
			}
			
			OidCounters oidCounters = new OidCounters();
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					oidCounters.put(eClass, oid);
				}
			}
			
			concreteRevision.setOidCounters(oidCounters.getBytes());

			if (ifcModel != null) {
				getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			}
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					try {
						clearCheckinInProgress();
					} catch (BimserverDatabaseException | ServiceException e) {
						LOGGER.error("", e);
					}
					getBimServer().getNotificationsManager().notify(new NewRevisionNotification(getBimServer(), project.getOid(), revision.getOid(), authorization));
				}
			});

			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
			try {
				clearCheckinInProgress();
			} catch (ServiceException e1) {
				LOGGER.error("", e1);
			}
			if (e instanceof BimserverDatabaseException) {
				throw (BimserverDatabaseException) e;
			}
			if (e instanceof UserException) {
				throw (UserException) e;
			}
			LOGGER.error("", e);
			throw new UserException(e);
		}
		return concreteRevision;
	}
	
	private void clearCheckinInProgress() throws BimserverDatabaseException, ServiceException {
		try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.READ_WRITE)) {
			Project project = tmpSession.get(poid, OldQuery.getDefault());
			project.setCheckinInProgress(0);
			tmpSession.store(project);
			tmpSession.commit();
		}
	}

	public String getFileName() {
		return fileName;
	}
	
	private IfcModelInterface checkinMerge(Revision lastRevision) throws BimserverLockConflictException, BimserverDatabaseException, UserException {
//		IfcModelSet ifcModelSet = new IfcModelSet();
//		for (ConcreteRevision subRevision : lastRevision.getConcreteRevisions()) {
//			if (concreteRevision != subRevision) {
//				IfcModel subModel = new IfcModel();
//				Query query = new Query(subRevision.getProject().getId(), subRevision.getId(), Deep.YES);
//				getDatabaseSession().getMap(subModel, query);
//				subModel.getModelMetaData().setDate(subRevision.getDate());
//				ifcModelSet.add(subModel);
//			}
//		}
//		IfcModelInterface newModel = new IfcModel();
//		newModel.getModelMetaData().setDate(new Date());
//		IfcModelInterface oldModel = new IfcModel();
//		try {
//			oldModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(project, ifcModelSet, new ModelHelper(oldModel));
//		} catch (MergeException e) {
//			throw new UserException(e);
//		}
//
//		oldModel.setObjectOids();
//		newModel.setObjectOids();
//		oldModel.indexGuids();
//		newModel.indexGuids();
//		newModel.fixOids(new IncrementingOidProvider(oldModel.getHighestOid() + 1));
//
//		RevisionMerger revisionMerger = new RevisionMerger(oldModel, (IfcModel) newModel);
//		IfcModelInterface ifcModel;
//		try {
//			ifcModel = revisionMerger.merge();
//		} catch (IfcModelInterfaceException e) {
//			throw new UserException(e);
//		}
//		revisionMerger.cleanupUnmodified();
//
//		for (IdEObject idEObject : ifcModel.getValues()) {
//			((IdEObjectImpl) idEObject).setRid(concreteRevision.getId());
//			((IdEObjectImpl) idEObject).setPid(concreteRevision.getProject().getId());
//		}
		return null;
	}

	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}

	public Revision getRevision() {
		return concreteRevision.getRevisions().get(0);
	}

	public long getCroid() {
		return concreteRevision.getOid();
	}

	public long getActingUid() {
		return authorization.getUoid();
	}

	public long getPoid() {
		return poid;
	}
}