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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.geometry.GeometryGenerationReport;
import org.bimserver.geometry.StreamingGeometryGenerator;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.File;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import com.google.common.base.Charsets;

public class RegenerateGeometryDatabaseAction extends ProjectBasedDatabaseAction<Void> {

	private BimServer bimServer;
	private long roid;
	private long uoid;
	private long poid;
	private String renderEngineName;
	private Long eoid;

	public RegenerateGeometryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, long roid, long uoid, Long eoid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.roid = roid;
		this.uoid = uoid;
		this.eoid = eoid;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		ProgressListener progressListener = new ProgressListener() {
			@Override
			public void updateProgress(String state, int percentage) {
				setProgress("Generating geometry...", percentage);
			}
		};

		GeometryGenerationReport report = new GeometryGenerationReport();
		
		report.setOriginalIfcFileName("rerun");
		report.setOriginalIfcFileSize(-1);
		report.setOriginalDeserializer("rerun");
		
		StreamingGeometryGenerator streamingGeometryGenerator = new StreamingGeometryGenerator(bimServer, progressListener, eoid, report);
		Revision revision = getDatabaseSession().get(roid, OldQuery.getDefault());
		ConcreteRevision concreteRevision = revision.getConcreteRevisions().get(0);
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);

		QueryContext queryContext = new QueryContext(getDatabaseSession(), packageMetaData, revision.getProject().getId(), revision.getId(), roid, concreteRevision.getOid(), highestStopId);
		try {
			GenerateGeometryResult generateGeometry = streamingGeometryGenerator.generateGeometry(uoid, getDatabaseSession(), queryContext, 1000); // TODO get the actual amount of products
			
			for (Revision other : concreteRevision.getRevisions()) {
				other.setHasGeometry(true);
			}
			
			concreteRevision.setMultiplierToMm(generateGeometry.getMultiplierToMm());
			concreteRevision.setBounds(generateGeometry.getBounds());
			concreteRevision.setBoundsUntransformed(generateGeometry.getBoundsUntransformed());
			
			byte[] htmlBytes = report.toHtml().getBytes(Charsets.UTF_8);
			byte[] jsonBytes = report.toJson().toString().getBytes(Charsets.UTF_8);

			storeExtendedData(htmlBytes, "text/html", "html", revision);
			storeExtendedData(jsonBytes, "application/json", "json", revision);
			
			getDatabaseSession().store(revision);
			getDatabaseSession().store(concreteRevision);
			
			renderEngineName = streamingGeometryGenerator.getRenderEngineName();
		} catch (GeometryGeneratingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void storeExtendedData(byte[] bytes, String mime, String extension, final Revision revision) throws BimserverDatabaseException {
		ExtendedData extendedData = getDatabaseSession().create(ExtendedData.class);
		File file = getDatabaseSession().create(File.class);
		file.setData(bytes);
		file.setFilename("geometrygenerationreport." + extension);
		file.setMime(mime);
		file.setSize(bytes.length);
		User actingUser = getUserByUoid(uoid);
		extendedData.setUser(actingUser);
		extendedData.setTitle("Geometry generation report (" + mime + ")");
		extendedData.setAdded(new Date());
		extendedData.setSize(file.getData().length);
		extendedData.setFile(file);
		revision.getExtendedData().add(extendedData);
		extendedData.setProject(revision.getProject());
		extendedData.setRevision(revision);
		
		getDatabaseSession().store(file);
		getDatabaseSession().store(extendedData);
		
		if (extendedData.getSchema() != null) {
			getDatabaseSession().store(extendedData.getSchema());
		}
	}
	
	public String doneMessage() {
		return "Geometry successfully regenerated using " + renderEngineName;
	}

	@Override
	public String getFileName() {
		return "test";
	}

	@Override
	public long getPoid() {
		return poid;
	}
}