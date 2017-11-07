package org.bimserver.database.actions;

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
import org.bimserver.models.store.Revision;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

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

		QueryContext queryContext = new QueryContext(getDatabaseSession(), packageMetaData, revision.getProject().getId(), revision.getId(), roid, highestStopId);
		try {
			GenerateGeometryResult generateGeometry = streamingGeometryGenerator.generateGeometry(uoid, getDatabaseSession(), queryContext);
			
			for (Revision other : concreteRevision.getRevisions()) {
				other.setHasGeometry(true);
			}
			
			concreteRevision.setMinBounds(generateGeometry.getMinBoundsAsVector3f());
			concreteRevision.setMaxBounds(generateGeometry.getMaxBoundsAsVector3f());
			
			getDatabaseSession().store(concreteRevision);
			
			renderEngineName = streamingGeometryGenerator.getRenderEngineName();
		} catch (GeometryGeneratingException e) {
			e.printStackTrace();
		}
		return null;
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