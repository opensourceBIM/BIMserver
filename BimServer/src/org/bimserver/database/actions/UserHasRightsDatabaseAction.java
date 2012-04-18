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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class UserHasRightsDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long poid;
	private final long uoid;

	public UserHasRightsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, long poid) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
		this.poid = poid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDeadlockException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		return RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project);
	}
}