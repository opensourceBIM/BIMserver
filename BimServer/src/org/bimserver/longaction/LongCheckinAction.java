package org.bimserver.longaction;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCheckinAction extends LongAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongCheckinAction.class);
	private final CheckinPart2DatabaseAction createCheckinAction;
	private final BimDatabase bimDatabase;
	private final SchemaDefinition schema;
	private final IfcEngineFactory ifcEngineFactory;
	private final LongActionManager longActionManager;

	public LongCheckinAction(LongActionManager longActionManager, BimDatabase bimDatabase, SchemaDefinition schema, CheckinPart2DatabaseAction createCheckinAction, IfcEngineFactory ifcEngineFactory) {
		this.longActionManager = longActionManager;
		this.bimDatabase = bimDatabase;
		this.schema = schema;
		this.createCheckinAction = createCheckinAction;
		this.ifcEngineFactory = ifcEngineFactory;
	}

	public void execute() {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			session.executeAndCommitAction(createCheckinAction, 10);
			session.close();
			
			BimDatabaseSession extraSession = bimDatabase.createSession();
			try {
				ConcreteRevision concreteRevision2 = extraSession.getConcreteRevision(createCheckinAction.getCroid());
				for (Revision r : concreteRevision2.getRevisions()) {
					Revision latest = null;
					for (Revision r2 : r.getProject().getRevisions()) {
						if (latest == null || r2.getId() > latest.getId()) {
							latest = r2;
						}
					}
					if (latest != null) {
						latest.getProject().setLastRevision(latest);
						extraSession.store(latest.getProject(), new CommitSet(Database.STORE_PROJECT_ID, -1));
					}
				}
				extraSession.commit();
			} finally {
				extraSession.close();
			}
			
			session = bimDatabase.createReadOnlySession();
			startClashDetection(session);
		} catch (Exception e) {
			LOGGER.error("", e);
			long croid = createCheckinAction.getCroid();
			try {
				BimDatabaseSession rollBackSession = bimDatabase.createSession();
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					ConcreteRevision concreteRevision = rollBackSession.getConcreteRevision(croid);
					concreteRevision.setState(CheckinState.ERROR);
					concreteRevision.setLastError(throwable.getMessage());
					for (Revision revision : concreteRevision.getRevisions()) {
						revision.setState(CheckinState.ERROR);
						revision.setLastError(throwable.getMessage());
					}
					rollBackSession.store(concreteRevision, new CommitSet(Database.STORE_PROJECT_ID, -1));
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

	private void startClashDetection(BimDatabaseSession session) throws BimDeadlockException, BimDatabaseException, UserException, IfcEngineException, SerializerException {
		ConcreteRevision concreteRevision = session.getConcreteRevision(createCheckinAction.getCroid());
		Project project = concreteRevision.getProject();
		Project mainProject = project;
		while (mainProject.getParent() != null) {
			mainProject = mainProject.getParent();
		}
		if (mainProject.getClashDetectionSettings().isEnabled()) {
			ClashDetectionLongAction clashDetectionLongAction = new ClashDetectionLongAction(createCheckinAction.getActingUid(), schema, ifcEngineFactory, bimDatabase, mainProject.getOid());
			longActionManager.start(clashDetectionLongAction);
		}
	}
}