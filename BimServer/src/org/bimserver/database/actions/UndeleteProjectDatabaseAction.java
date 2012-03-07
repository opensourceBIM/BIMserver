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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class UndeleteProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long poid;

	public UndeleteProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(actingUoid);
		final Project project = getProjectByPoid(poid);
		if (actingUser.getUserType() == UserType.ADMIN || actingUser.getHasRightsOn().contains(project)) {
			project.setState(ObjectState.ACTIVE);
			ProjectUndeleted projectUndeleted = LogFactory.eINSTANCE.createProjectUndeleted();
			projectUndeleted.setAccessMethod(getAccessMethod());
			projectUndeleted.setDate(new Date());
			projectUndeleted.setExecutor(actingUser);
			projectUndeleted.setProject(project);
			getDatabaseSession().store(project);
			getDatabaseSession().store(projectUndeleted);
			return true;
		} else {
			throw new UserException("No rights to undelete this project");
		}
	}
}