package org.bimserver.database.actions;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private ConcreteRevision concreteRevision;
	private final boolean merge;
	private final BimServer bimServer;
	private final boolean clean;
	private Project project;
	private Authorization authorization;
	private RevisionSummaryContainer revisionSummaryContainerEntities;
	private RevisionSummaryContainer revisionSummaryContainerRelations;
	private RevisionSummaryContainer revisionSummaryContainerPrimitives;
	private RevisionSummaryContainer revisionSummaryContainerOther;
	private Map<EClass, Integer> map = new HashMap<EClass, Integer>();

	public CheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, IfcModelInterface model,
			String comment, boolean merge, boolean clean) {
		super(databaseSession, accessMethod, model);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.merge = merge;
		this.clean = clean;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverDatabaseException {
		try {
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
			concreteRevision = createNewConcreteRevision(getDatabaseSession(), getModel() == null ? 0 : getModel().getSize(), project, user, comment.trim());
			project.getConcreteRevisions().add(concreteRevision);
			if (getModel() != null) {
				concreteRevision.setChecksum(getModel().getChecksum());
			}
			final NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			Revision revision = concreteRevision.getRevisions().get(0);
			
			revision.setSummary(createSummary(getModel()));
			
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
			if (nrConcreteRevisionsBefore != 0 && !merge && clean) {
				// There already was a revision, lets delete it (only when not
				// merging)
				getDatabaseSession().planClearProject(project.getId(), concreteRevision.getId() - 1, concreteRevision.getId());
			}
			if (ifcModel != null) {
				getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			}
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newRevisionAdded));
				}
			});
			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(newRevisionAdded);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
			if (e instanceof BimserverDatabaseException) {
				// Let this one slide
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

	private RevisionSummary createSummary(IfcModelInterface model) throws BimserverDatabaseException {
		RevisionSummary revisionSummary = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummary());
		revisionSummaryContainerEntities = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummary.getList().add(revisionSummaryContainerEntities);
		revisionSummaryContainerRelations = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummary.getList().add(revisionSummaryContainerRelations);
		revisionSummaryContainerPrimitives = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummary.getList().add(revisionSummaryContainerPrimitives);
		revisionSummaryContainerOther = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerOther.setName("Rest");
		revisionSummary.getList().add(revisionSummaryContainerOther);
		
		for (EClass eClass : getDatabaseSession().getClasses()) {
			add(revisionSummary, eClass, model.count(eClass));
		}
		for (EClass eClass : map.keySet()) {
			RevisionSummaryContainer subMap = null;
			if (Ifc2x3tc1Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerEntities;
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerRelations;
			} else if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerPrimitives;
			} else {
				subMap = revisionSummaryContainerOther;
			}
			RevisionSummaryType createRevisionSummaryType = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryType());
			createRevisionSummaryType.setCount(map.get(eClass));
			createRevisionSummaryType.setName(eClass.getName());
			subMap.getTypes().add(createRevisionSummaryType);
		}
		return revisionSummary;
	}

	public void add(RevisionSummary revisionSummary, EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		if (!map.containsKey(eClass)) {
			map.put(eClass, count);
		}
		map.put(eClass, count);
	}
	
	private IfcModelInterface checkinMerge(Revision lastRevision) throws BimserverLockConflictException, BimserverDatabaseException, UserException {
		IfcModelInterface ifcModel;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision subRevision : lastRevision.getConcreteRevisions()) {
			if (concreteRevision != subRevision) {
				IfcModel subModel = new IfcModel();
				getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, null);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface newModel = new IfcModel();
		newModel.setDate(new Date());
		newModel.fixOids(getDatabaseSession());
		IfcModelInterface oldModel;
		try {
			oldModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(project, ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}

		oldModel.setObjectOids();
		newModel.setObjectOids();
		oldModel.indexGuids();
		newModel.indexGuids();
		newModel.fixOids(new IncrementingOidProvider(oldModel.getHighestOid() + 1));

		RevisionMerger revisionMerger = new RevisionMerger(oldModel, (IfcModel) newModel);
		try {
			ifcModel = revisionMerger.merge();
		} catch (IfcModelInterfaceException e) {
			throw new UserException(e);
		}
		revisionMerger.cleanupUnmodified();

		for (IdEObject idEObject : ifcModel.getValues()) {
			((IdEObjectImpl) idEObject).setRid(concreteRevision.getId());
			((IdEObjectImpl) idEObject).setPid(concreteRevision.getProject().getId());
		}
		return ifcModel;
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

	public Project getProject() {
		return project;
	}
}