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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.EList;

public class GetAllAuthorizedUsersOfProjectDatabaseAction extends BimDatabaseAction<Set<User>>{

	private final long poid;

	public GetAllAuthorizedUsersOfProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
	}
	
	@Override
	public Set<User> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		EList<User> users = getProjectByPoid(poid).getHasAuthorizedUsers();
		return new HashSet<User>(users);
	}
}