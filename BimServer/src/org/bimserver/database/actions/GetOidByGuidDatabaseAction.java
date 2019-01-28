package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;

public class GetOidByGuidDatabaseAction extends BimDatabaseAction<Long>{

	private final String guid;
	private final long roid;

	public GetOidByGuidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long roid, String guid) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.guid = guid;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision virtualRevision = getRevisionByRoid(roid);
		ObjectIdentifier objectIdentifier = null;
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			objectIdentifier = getDatabaseSession().getOidOfGuid(concreteRevision.getProject().getSchema(), guid, concreteRevision.getProject().getId(), concreteRevision.getId());
			if (objectIdentifier != null) {
				long oidOfGuid = objectIdentifier.getOid();
				if (oidOfGuid != -1) {
					break;
				}
			}
		}
		if (objectIdentifier == null) {
			throw new UserException("Guid " + guid + " not found in this revision/project");
		}
		
		return objectIdentifier.getOid();
	}
}