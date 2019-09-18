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

import java.util.Date;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.File;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class AddGeometryReports extends BimDatabaseAction<Void> {

	private byte[] htmlBytes;
	private byte[] jsonBytes;
	private long timeToGenerateMs;
	private long uoid;
	private long roid;

	public AddGeometryReports(DatabaseSession databaseSession, AccessMethod accessMethod, byte[] htmlBytes, byte[] jsonBytes, long timeToGenerateMs, long uoid, long roid) {
		super(databaseSession, accessMethod);
		this.htmlBytes = htmlBytes;
		this.jsonBytes = jsonBytes;
		this.timeToGenerateMs = timeToGenerateMs;
		this.uoid = uoid;
		this.roid = roid;
	}

	@Override
	public Void execute()
			throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		ExtendedDataSchema htmlSchema = (ExtendedDataSchema) getDatabaseSession().querySingle(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), "GEOMETRY_GENERATION_REPORT_HTML_1_1");
		ExtendedDataSchema jsonSchema = (ExtendedDataSchema) getDatabaseSession().querySingle(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), "GEOMETRY_GENERATION_REPORT_JSON_1_1");
		
		storeExtendedData(getDatabaseSession(), htmlSchema, htmlBytes, "text/html", "html", timeToGenerateMs);
		storeExtendedData(getDatabaseSession(), jsonSchema, jsonBytes, "application/json", "json", timeToGenerateMs);
		
		return null;
	}
	
	private void storeExtendedData(DatabaseSession databaseSession, ExtendedDataSchema extendedDataSchema, byte[] bytes, String mime, String extension, long timeToGenerateMs) throws BimserverDatabaseException {
		Revision revision = databaseSession.get(roid, OldQuery.getDefault());
		ExtendedData extendedData = databaseSession.create(ExtendedData.class);
		File file = databaseSession.create(File.class);
		file.setData(bytes);
		file.setFilename("geometrygenerationreport." + extension);
		file.setMime(mime);
		file.setSize(bytes.length);
		User actingUser = databaseSession.get(StorePackage.eINSTANCE.getUser(), uoid, OldQuery.getDefault());
		extendedData.setUser(actingUser);
		extendedData.setSchema(extendedDataSchema);
		extendedData.setTitle("Geometry generation report (" + mime + ")");
		extendedData.setTimeToGenerate(timeToGenerateMs);
		extendedData.setAdded(new Date());
		extendedData.setSize(file.getData().length);
		extendedData.setFile(file);
		revision.getExtendedData().add(extendedData);
		extendedData.setProject(revision.getProject());
		extendedData.setRevision(revision);
		
		databaseSession.store(file);
		databaseSession.store(extendedData);
		databaseSession.store(revision);
		databaseSession.store(revision.getProject());
		
		if (extendedData.getSchema() != null) {
			databaseSession.store(extendedData.getSchema());
		}
	}
}
