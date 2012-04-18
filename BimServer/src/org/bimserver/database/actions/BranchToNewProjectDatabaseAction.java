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

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class BranchToNewProjectDatabaseAction extends BimDatabaseAction<CheckinResult> {
	private final BimServer bimServer;
	private final Long currentUoid;
	private final Long roid;
	private final String projectName;
	private final String comment;
	
	public BranchToNewProjectDatabaseAction(DatabaseSession session, AccessMethod accessMethod, BimServer bimServer, Long currentUoid, Long roid, String projectName,
			String comment) {
		super(session, accessMethod);
		this.bimServer = bimServer;
		this.currentUoid = currentUoid;
		this.roid = roid;
		this.projectName = projectName;
		this.comment = comment;
	}

	@Override
	public CheckinResult execute() throws UserException, BimserverDeadlockException, BimserverDatabaseException {
		Revision oldRevision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
		Project oldProject = oldRevision.getProject();
		final User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, null);
			subModel.setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		final IfcModelInterface model = bimServer.getMergerFactory().createMerger().merge(oldRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().getIntelligentMerging());
		model.resetOids();
		final Project newProject = new AddProjectDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), projectName, currentUoid).execute();
		CheckinDatabaseAction createCheckinAction = new CheckinDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), newProject.getOid(), currentUoid, model, comment, false, true);
		ConcreteRevision execute = createCheckinAction.execute();
		CheckinResult checkinResult = StoreFactory.eINSTANCE.createCheckinResult();
		checkinResult.setProject(newProject);
		checkinResult.setRevision(execute.getRevisions().get(0));
		return checkinResult;
	}
}