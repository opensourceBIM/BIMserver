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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class GetLogsDatabaseAction extends BimDatabaseAction<List<LogAction>> {

	private final long actingUoid;

	public GetLogsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public List<LogAction> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		if (user.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can retrieve log");
		}
		Map<Long, LogAction> query = getDatabaseSession().query(new IsOfTypeCondition(LogPackage.eINSTANCE.getLogAction()), LogAction.class, false, null);
		ArrayList<LogAction> list = new ArrayList<LogAction>(query.values());
		return list;
	}
}