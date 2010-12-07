package org.bimserver.longaction;

import java.util.HashSet;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ServerSettings;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.mail.MailSystem;
import org.bimserver.webservices.Service;
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
			session.store(revision);
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
			FindClashesDatabaseAction findClashesDatabaseAction = new FindClashesDatabaseAction(AccessMethod.INTERNAL, project.getClashDetectionSettings(), schema, ifcEngineFactory, roid);
			Set<? extends Clash> clashes = findClashesDatabaseAction.execute(session);
			Revision revision = project.getLastRevision();
			for (Clash clash : clashes) {
				revision.getLastClashes().add(clash);
				session.store(clash);
			}
			revision.setState(CheckinState.DONE);
			session.store(revision);
			session.commit();

			Set<User> users = new HashSet<User>();
			for (Clash clash : clashes) {
				users.add(clash.getRevision1().getUser());
				users.add(clash.getRevision2().getUser());
			}
			User actingUser = session.getUserByUoid(actingUoid);
			String senderAddress = actingUser.getUsername();
			String url = ServerSettings.getSettings().getSiteAddress() + "clashes.jsp?";
			MailSystem.getInstance().sendClashDetectionEmail(actingUser.getName(), senderAddress, url, Service.convert(project.getClashDetectionSettings()));
			
//			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(AccessMethod.INTERNAL, revision.getOid(), actingUoid);
//			IfcModel model = action.execute(session);
//			IfcStepSerializer ifcStepSerializer = new IfcStepSerializer(project, session.getUserByUoid(actingUoid), "", model, schema);
//			byte[] bytes = ifcStepSerializer.getBytes();
//			FailSafeIfcEngine failSafeIfcEngine = ifcEngineFactory.createFailSafeIfcEngine();
//			try {
//				IfcEngineModel ifcEngineModel = failSafeIfcEngine.openModel(bytes);
//				try {
//					Set<EidClash> clashes = ifcEngineModel.findClashesByEid(project.getClashDetectionSettings().getMargin());
//					for (Clash clash : clashes) {
//						IfcRoot object1 = (IfcRoot) newModel.get(clash.getEid1());
//						clash.setName1(object1.getName());
//						clash.setType1(object1.eClass().getName());
//						clash.setRevision1(oidToRoidMap.get(clash.getEid1()));
//						IfcRoot object2 = (IfcRoot) newModel.get(clash.getEid2());
//						clash.setName2(object2.getName());
//						clash.setType2(object2.eClass().getName());
//						clash.setRevision2(oidToRoidMap.get(clash.getEid2()));
//						revision.getLastClashes().add(clash);
//					}
//					session.store(clashes);
//				} finally {
//					try {
//						ifcEngineModel.close();
//					} catch (IfcEngineException e) {
//						LOGGER.error("", e);
//					}
//				}
//				revision.setState(CheckinState.DONE);
//				session.store(revision);
//				session.commit();
//			} finally {
//				failSafeIfcEngine.close();
//			}
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
					rollBackSession.store(revision);
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