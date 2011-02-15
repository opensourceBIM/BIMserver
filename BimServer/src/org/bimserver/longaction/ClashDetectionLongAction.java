package org.bimserver.longaction;

import java.util.HashSet;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.SendClashesEmailDatabaseAction;
import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.Clash;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifcengine.IfcEngineFactory;
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
	private final User user;

	public ClashDetectionLongAction(User user, long actingUoid, SchemaDefinition schema, IfcEngineFactory ifcEngineFactory, BimDatabase bimDatabase, long poid) {
		this.user = user;
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
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false);
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
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false);
			ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
			clashDetectionSettings.setMargin(project.getClashDetectionSettings().getMargin());
			clashDetectionSettings.getRevisions().add(project.getLastRevision());
			FindClashesDatabaseAction findClashesDatabaseAction = new FindClashesDatabaseAction(session, AccessMethod.INTERNAL, clashDetectionSettings, schema, ifcEngineFactory, roid);
			Set<? extends Clash> clashes = findClashesDatabaseAction.execute();
			Revision revision = project.getLastRevision();
// Temporarily disabled, should be enabled when lazy loading is working
//			for (Clash clash : clashes) {
//				revision.getLastClashes().add(clash);
//				session.store(clash);
//			}
			revision.setNrClashes(clashes.size());
			revision.setState(CheckinState.DONE);
			session.store(revision);

			Set<String> emailAddresses = new HashSet<String>();
			for (Clash clash : clashes) {
				emailAddresses.add(clash.getRevision1().getUser().getUsername());
				emailAddresses.add(clash.getRevision2().getUser().getUsername());
			}
			if (!emailAddresses.isEmpty()) {
				String[] emailAddressesArray = new String[emailAddresses.size()];
				emailAddresses.toArray(emailAddressesArray);
				
				SendClashesEmailDatabaseAction sendClashesEmailDatabaseAction = new SendClashesEmailDatabaseAction(session, AccessMethod.INTERNAL, actingUoid, poid, Service.convert(clashDetectionSettings), emailAddresses);
				sendClashesEmailDatabaseAction.execute();
			}
			session.commit();
		} catch (Throwable e) {
			LOGGER.error("", e);
			try {
				BimDatabaseSession rollBackSession = bimDatabase.createSession();
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					Revision revision = rollBackSession.get(StorePackage.eINSTANCE.getRevision(), roid, false);
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

	@Override
	public String getIdentification() {
		return "ClashDetectionLongAction " + user.getName();
	}

	@Override
	public User getUser() {
		return user;
	}
}