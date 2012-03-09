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

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.PostCommitAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.mail.MailSystem;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinDatabaseAction.class);
	private final long actingUid;
	private final String comment;
	private final long poid;
	private ConcreteRevision concreteRevision;
	private final boolean merge;
	private final BimServer bimServer;
	private final boolean clean;
	private Project project;

	public CheckinDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actingUid, IfcModelInterface model, String comment, boolean merge, boolean clean) {
		super(bimDatabaseSession, accessMethod, model);
		this.bimServer = bimServer;
		this.poid = poid;
		this.actingUid = actingUid;
		this.comment = comment;
		this.merge = merge;
		this.clean = clean;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimDeadlockException, BimDatabaseException {
		try {
			project = getProjectByPoid(poid);
			User user = getUserByUoid(actingUid);
			if (project == null) {
				throw new UserException("Project with poid " + poid + " not found");
			}
			if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
			if (getModel() != null) {
				checkCheckSum(project);
			}
			if (!project.getRevisions().isEmpty() && project.getRevisions().get(project.getRevisions().size() - 1).getState() == CheckinState.STORING) {
				throw new UserException("Another checkin on this project is currently running, please wait and try again");
			}
			concreteRevision = createNewConcreteRevision(getDatabaseSession(), getModel() == null ? 0 : getModel().getSize(), poid, actingUid, comment.trim(), CheckinState.STORING);
			if (getModel() != null) {
				concreteRevision.setChecksum(getModel().getChecksum());
			}
			NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
			newRevisionAdded.setAccessMethod(getAccessMethod());
			getDatabaseSession().store(newRevisionAdded);
			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);

			Revision lastRevision = project.getLastRevision();
			IfcModelInterface ifcModel = null;
			if (merge && lastRevision != null) {
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
				IfcModelInterface oldModel = bimServer.getMergerFactory().createMerger()
						.merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().getIntelligentMerging());

				oldModel.setObjectOids();
				newModel.setObjectOids();
				oldModel.indexGuids();
				newModel.indexGuids();
				newModel.fixOids(new IncrementingOidProvider(oldModel.getHighestOid() + 1));

				RevisionMerger revisionMerger = new RevisionMerger(oldModel, (IfcModel) newModel);
				ifcModel = revisionMerger.merge();
				revisionMerger.cleanupUnmodified();

				for (IdEObject idEObject : ifcModel.getValues()) {
					idEObject.setRid(concreteRevision.getId());
					idEObject.setPid(concreteRevision.getProject().getId());
				}
			} else {
				ifcModel = getModel();
			}
			if (project.getConcreteRevisions().size() != 0 && !merge && clean) {
				// There already was a revision, lets delete it (only when not
				// merging)
				getDatabaseSession().clearProject(project.getId(), concreteRevision.getId() - 1, concreteRevision.getId());
			}
			if (ifcModel != null) {
				getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			}
			for (final Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.DONE);
				getDatabaseSession().store(revision);
				getDatabaseSession().addPostCommitAction(new PostCommitAction() {
					@Override
					public void execute() throws UserException {
						NewRevisionNotification newRevisionNotification = StoreFactory.eINSTANCE.createNewRevisionNotification();
						newRevisionNotification.setRevision(revision);
						bimServer.getNotificationsManager().notify(newRevisionNotification);
					}
				});
			}
			concreteRevision.setState(CheckinState.DONE);
			getDatabaseSession().store(concreteRevision);
			
//			for (Revision revision : createCheckinAction.getConcreteRevision(createCheckinAction.getCroid()).getRevisions()) {
//				NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
//				newRevisionAdded.setDate(new Date());
//				newRevisionAdded.setExecutor(user);
//				newRevisionAdded.setRevision(revision);
//				newRevisionAdded.setAccessMethod(createCheckinAction.getAccessMethod());
//
//				bimServer.getNotificationsManager().notify(newRevisionAdded);
//			}
		} catch (Throwable e) {
			if (e instanceof BimDeadlockException) {
				// Let this one slide
				throw (BimDeadlockException) e;
			}
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return concreteRevision;
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
		return actingUid;
	}

	public Project getProject() {
		return project;
	}

	public void rollback(Throwable e) {
		long croid = getCroid();
		try {
			BimDatabaseSession rollBackSession = bimServer.getDatabase().createSession(true);
			try {
				Throwable throwable = e;
				while (throwable.getCause() != null) {
					throwable = throwable.getCause();
				}
				ConcreteRevision concreteRevision = (ConcreteRevision) rollBackSession.get(StorePackage.eINSTANCE.getConcreteRevision(), croid, false, null);
				concreteRevision.setState(CheckinState.ERROR);
				concreteRevision.setLastError(throwable.getMessage());
				for (Revision revision : concreteRevision.getRevisions()) {
					revision.setState(CheckinState.ERROR);
					revision.setLastError(throwable.getMessage());
				}
				rollBackSession.store(concreteRevision);
				rollBackSession.commit();
			} finally {
				rollBackSession.close();
			}
		} catch (BimDeadlockException e1) {
			LOGGER.error("", e1);
		} catch (BimDatabaseException e1) {
			LOGGER.error("", e1);
		}
	}
}