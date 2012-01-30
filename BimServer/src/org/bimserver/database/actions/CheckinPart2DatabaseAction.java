package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinPart2DatabaseAction extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinPart2DatabaseAction.class);
	private final IfcModelInterface ifcModel;
	private final long actingUoid;
	private final long croid;
	private final boolean merge;
	private final BimServer bimServer;
	private Project project;
	private ConcreteRevision concreteRevision;
	private final boolean clean;

	public CheckinPart2DatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcModelInterface ifcModel, long actingUoid, long croid, boolean merge, boolean clean) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.ifcModel = ifcModel;
		this.actingUoid = actingUoid;
		this.croid = croid;
		this.merge = merge;
		this.clean = clean;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		concreteRevision = getConcreteRevision(croid);
		try {
			project = concreteRevision.getProject();
			Revision lastRevision = project.getLastRevision();
			IfcModelInterface ifcModel = null;
			if (merge && lastRevision != null) {
				IfcModelSet ifcModelSet = new IfcModelSet();
				for (ConcreteRevision subRevision : lastRevision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, null);
					subModel.setDate(subRevision.getDate());
					ifcModelSet.add(subModel);
				}
				getIfcModel().setDate(new Date());
				IfcModelInterface newModel = getIfcModel();
				newModel.fixOids(getDatabaseSession());
				IfcModelInterface oldModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().getIntelligentMerging());
				
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
				ifcModel = getIfcModel();
			}
			if (project.getConcreteRevisions().size() != 0 && !merge && clean) {
				// There already was a revision, lets delete it (only when not merging)
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
		} catch (Throwable e) {
			if (e instanceof BimDeadlockException) {
				// Let this one slide
				throw (BimDeadlockException)e;
			}
			LOGGER.error("", e);
			for (Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.ERROR);
				revision.setLastError(e.getMessage());
			}
			throw new UserException(e);
		}
		return null;
	}

	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}
	
	public Project getProject() {
		return project;
	}
	
	public IfcModelInterface getIfcModel() {
		return ifcModel;
	}

	public long getActingUid() {
		return actingUoid;
	}

	public long getCroid() {
		return croid;
	}
}