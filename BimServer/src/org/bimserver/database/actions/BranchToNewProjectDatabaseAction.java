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

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class BranchToNewProjectDatabaseAction extends AbstractBranchDatabaseAction {
	private final BimServer bimServer;
	private final Long roid;
	private final String projectName;
	private final String comment;
	private Authorization authorization;

	public BranchToNewProjectDatabaseAction(DatabaseSession session, AccessMethod accessMethod, BimServer bimServer, Authorization authorization, Long roid, String projectName,
			String comment) {
		super(session, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.roid = roid;
		this.projectName = projectName;
		this.comment = comment;
	}
	
	@Override
	public Long getPoid() {
		return -1L;
	}

	@Override
	public Long getRoid() {
		return roid;
	}
	
	@Override
	public ConcreteRevision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision oldRevision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
		Project oldProject = oldRevision.getProject();
		final User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), Query.getDefault());
		if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		PackageMetaData lastMetaData = null;
		for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(subRevision.getProject().getSchema());
			if (lastMetaData != null && lastMetaData != packageMetaData) {
				throw new UserException("Branching not possible for revision with multiple schemas");
			}
			IfcModel subModel = new BasicIfcModel(packageMetaData, null);
			getDatabaseSession().getMap(subModel, new Query(packageMetaData, subRevision.getProject().getId(), subRevision.getId(), -1, Deep.NO));
			subModel.getModelMetaData().setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface model = new BasicIfcModel(lastMetaData, null);
		try {
			model = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(oldRevision.getProject(), ifcModelSet, new ModelHelper(bimServer.getMetaDataManager(), model));
		} catch (MergeException e) {
			throw new UserException(e);
		}
		model.resetOids();
		final Project newProject = new AddProjectDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), projectName, "ifc2x3tc1", authorization).execute();
		CheckinDatabaseAction createCheckinAction = new CheckinDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), newProject.getOid(), authorization, model, comment, comment, false);
		return createCheckinAction.execute();
	}
}