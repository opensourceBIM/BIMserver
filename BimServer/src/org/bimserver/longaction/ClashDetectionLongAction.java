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
import org.bimserver.database.store.ClashDetectionSettings;
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
			User actingUser = session.getUserByUoid(actingUoid);
			Project project = session.getProjectByPoid(poid);
			ClashDetectionSettings clashDetectionSettings = project.getClashDetectionSettings();
			clashDetectionSettings.getRevisions().add(project.getLastRevision());
			FindClashesDatabaseAction findClashesDatabaseAction = new FindClashesDatabaseAction(AccessMethod.INTERNAL, clashDetectionSettings, schema, ifcEngineFactory, roid);
			Set<? extends Clash> clashes = findClashesDatabaseAction.execute(session);
			Revision revision = project.getLastRevision();
			for (Clash clash : clashes) {
				revision.getLastClashes().add(clash);
				session.store(clash);
			}
			revision.setState(CheckinState.DONE);
			session.store(revision);
			session.commit();

			Set<String> emailAddresses = new HashSet<String>();
			for (Clash clash : clashes) {
				emailAddresses.add(clash.getRevision1().getUser().getUsername());
				emailAddresses.add(clash.getRevision2().getUser().getUsername());
			}
			String senderAddress = actingUser.getUsername();
			
			if (!emailAddresses.isEmpty()) {
				String[] emailAddressesArray = new String[emailAddresses.size()];
				emailAddresses.toArray(emailAddressesArray);
				MailSystem.getInstance().sendClashDetectionEmail(project.getOid(), actingUser.getName(), senderAddress, Service.convert(project.getClashDetectionSettings()), emailAddressesArray);
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