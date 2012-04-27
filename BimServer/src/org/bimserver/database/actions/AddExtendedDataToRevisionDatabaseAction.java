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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;

public class AddExtendedDataToRevisionDatabaseAction extends AddDatabaseAction<ExtendedData> {

	private final Long roid;

	public AddExtendedDataToRevisionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, ExtendedData extendedData) {
		super(databaseSession, accessMethod, extendedData);
		this.roid = roid;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		getIdEObject().setAdded(new Date());
		super.execute();
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision with roid " + roid + " not found");
		}
		revision.getExtendedData().add(getIdEObject());
		getDatabaseSession().store(revision);
		return null;
	}
}