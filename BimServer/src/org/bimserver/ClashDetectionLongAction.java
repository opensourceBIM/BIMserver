package org.bimserver;

import java.io.File;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.ifcengine.IfcEngineModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClashDetectionLongAction extends LongAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClashDetectionLongAction.class);
	private final long actingUoid;
	private final SchemaDefinition schema;
	private final IfcEngineFactory ifcEngineFactory;
	private final BimDatabase bimDatabase;
	private final long poid;

	public ClashDetectionLongAction(long actingUoid, SchemaDefinition schema, IfcEngineFactory ifcEngineFactory, BimDatabase bimDatabase, long poid) {
		this.actingUoid = actingUoid;
		this.schema = schema;
		this.ifcEngineFactory = ifcEngineFactory;
		this.bimDatabase = bimDatabase;
		this.poid = poid;
	}

	@Override
	public void execute() {
		BimDatabaseSession session = bimDatabase.createSession();
		long roid = -1;
		try {
			Project project = session.getProjectByPoid(poid);
			Revision revision = project.getLastRevision();
			revision.setState(CheckinState.SEARCHING_CLASHES);
			roid = revision.getOid();
			session.store(revision, new CommitSet(Database.STORE_PROJECT_ID, -1));
			session.commit();
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		session = bimDatabase.createSession();
		try {
			Project project = session.getProjectByPoid(poid);
			Revision revision = project.getLastRevision();
			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(AccessMethod.SOAP, revision.getOid(), actingUoid);
			IfcModel model = action.execute(session);
			File file = FindClashesDatabaseAction.createTempFile();
			IfcStepSerializer ifcStepSerializer = new IfcStepSerializer(project, session.getUserByUoid(actingUoid), file.getName(), model, schema);
			ifcStepSerializer.writeToFile(file);
			FailSafeIfcEngine failSafeIfcEngine = ifcEngineFactory.createFailSafeIfcEngine();
			try {	
				IfcEngineModel ifcEngineModel = failSafeIfcEngine.openModel(file);
				try {
					Set<EidClash> clashes = ifcEngineModel.findClashesByEid(project.getClashDetectionSettings().getMargin());
					for (Clash clash : clashes) {
						revision.getLastClashes().add(clash);
					}
					session.store(clashes, Database.STORE_PROJECT_ID, -1);
				} finally {
					try {
						ifcEngineModel.close();
					} catch (IfcEngineException e) {
						e.printStackTrace();
					}
				}
				revision.setState(CheckinState.DONE);
				CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
				session.store(revision, commitSet);
				session.commit();
			} finally {
				failSafeIfcEngine.close();
			}
		} catch (Throwable e) {
			LOGGER.error("", e);
			try {
				BimDatabaseSession rollBackSession = bimDatabase.createSession();
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					Revision revision = rollBackSession.getVirtualRevision(roid);
					revision.setState(CheckinState.CLASHES_ERROR);
					revision.setLastError(throwable.getMessage());
					rollBackSession.store(revision, new CommitSet(Database.STORE_PROJECT_ID, -1));
					rollBackSession.commit();
				} finally {
					rollBackSession.close();
				}
			} catch (BimDeadlockException e1) {
				LOGGER.error("", e1);
			} catch (BimDatabaseException e1) {
				LOGGER.error("", e1);
			}
		} finally {
			session.close();
		}
	}
}
