package org.bimserver.database.actions;

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
		
		if (htmlSchema == null) {
			htmlSchema = createExtendedDataSchema(getDatabaseSession(), "GEOMETRY_GENERATION_REPORT_HTML_1_1", "text/html");
		}
		if (jsonSchema == null) {
			jsonSchema = createExtendedDataSchema(getDatabaseSession(), "GEOMETRY_GENERATION_REPORT_JSON_1_1", "application/json");
		}
		
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
	
	private ExtendedDataSchema createExtendedDataSchema(DatabaseSession databaseSession, String name, String contentType) throws BimserverDatabaseException {
		ExtendedDataSchema extendedDataSchema = databaseSession.create(ExtendedDataSchema.class);
		extendedDataSchema.setName(name);
		extendedDataSchema.setContentType(contentType);
		return extendedDataSchema;
	}
}
