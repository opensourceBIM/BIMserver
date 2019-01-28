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
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SGeometryInfo;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EStructuralFeature;

public class GetGeometryInfoDatabaseAction extends BimDatabaseAction<SGeometryInfo> {

	private BimServer bimServer;
	private long roid;
	private long oid;

	public GetGeometryInfoDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long oid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.oid = oid;
	}

	@Override
	public SGeometryInfo execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		Revision revision = getDatabaseSession().get(roid, OldQuery.getDefault());
		Project project = revision.getProject();
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(project.getSchema());
		
		IdEObject ifcProduct = getDatabaseSession().get(oid, new OldQuery(packageMetaData, project.getId(), revision.getId(), revision.getOid()));
		if (ifcProduct == null) {
			throw new UserException("Object with oid " + oid + " not found");
		}
		EStructuralFeature geometryFeature = packageMetaData.getEClass("IfcProduct").getEStructuralFeature("geometry");
		GeometryInfo geometry = (GeometryInfo) ifcProduct.eGet(geometryFeature);
		SGeometryInfo convertToSObject = bimServer.getSConverter().convertToSObject(geometry);
		return convertToSObject;
	}
}