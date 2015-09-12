package org.bimserver.database.actions;

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

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.GeometryCache;
import org.bimserver.GeometryGenerator;
import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.Query;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.User;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
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
	private final BimServer bimServer;
	private ConcreteRevision concreteRevision;
	private Project project;
	private Authorization authorization;
	private final GeometryCache geometryCache = new GeometryCache();
	private String fileName;
	private long fileSize;

	public CheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, IfcModelInterface ifcModel,
			String comment, String fileName, boolean merge) {
		super(databaseSession, accessMethod, ifcModel);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.fileName = fileName;
		this.merge = merge;
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
				throw new DeserializeException("Cannot checkin empty model");
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
				checkCheckSum(project);
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
					ModelCheckerPlugin modelCheckerPlugin = bimServer.getPluginManager().getModelCheckerPlugin(modelCheckerInstance.getModelCheckerPluginClassName(), true);
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

			concreteRevision.setSummary(new SummaryMap(getModel()).toRevisionSummary(getDatabaseSession()));

			// If this revision is being created by an external service, store a link to the service in the revision
			if (authorization instanceof ExplicitRightsAuthorization) {
				ExplicitRightsAuthorization explicitRightsAuthorization = (ExplicitRightsAuthorization)authorization;
				if (explicitRightsAuthorization.getSoid() != -1) {
					Service service = getDatabaseSession().get(explicitRightsAuthorization.getSoid(), Query.getDefault());
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

			ifcModel.fixOids(getDatabaseSession());

			if (bimServer.getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin()) {
				setProgress("Generating Geometry...", -1);
				new GeometryGenerator(bimServer).generateGeometry(authorization.getUoid(), bimServer.getPluginManager(), getDatabaseSession(), ifcModel, project.getId(), concreteRevision.getId(), true, geometryCache);
				for (Revision other : concreteRevision.getRevisions()) {
					other.setHasGeometry(true);
				}
			}

			if (nrConcreteRevisionsBefore != 0 && !merge) {
				// There already was a revision, lets delete it (only when not merging)
				concreteRevision.setClear(true);
			}
			Set<EClass> eClasses = ifcModel.getUsedClasses();
			Map<EClass, Long> startOids = getDatabaseSession().getStartOids();
			int s = 0;
			for (EClass eClass : eClasses) {
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					s++;
				}
			}
			ByteBuffer buffer = ByteBuffer.allocate(10 * s);
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					buffer.putShort(getDatabaseSession().getCid(eClass));
					buffer.putLong(oid);
				}
			}
			
			concreteRevision.setOidCounters(buffer.array());

			if (ifcModel != null) {
				getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			}
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new NewRevisionNotification(bimServer, project.getOid(), revision.getOid()));
				}
			});

			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
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