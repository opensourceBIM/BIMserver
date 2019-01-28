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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetAreaDatabaseAction extends BimDatabaseAction<Double> {

	private BimServer bimServer;
	private long roid;
	private long oid;

	public GetAreaDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long oid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.oid = oid;
	}

	@Override
	public Double execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		Revision revision = getDatabaseSession().get(roid, OldQuery.getDefault());
		
		IfcProduct ifcProduct = getDatabaseSession().get(oid, new OldQuery(bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema()), revision.getProject().getId(), revision.getId(), revision.getOid()));
		return ifcProduct.getGeometry().getArea();
	}
}