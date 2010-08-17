package org.bimserver;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.shared.UserException;

public class LongCheckinAction extends LongAction {

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
			createCheckinAction.execute(session);
			runClashDetection(session);
			session.commit();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} catch (IfcEngineException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void runClashDetection(BimDatabaseSession session) throws BimDeadlockException, BimDatabaseException, UserException, IfcEngineException, SerializerException {
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