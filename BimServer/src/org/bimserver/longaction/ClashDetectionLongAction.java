package org.bimserver.longaction;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.MergerFactory;
import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.actions.FindClashesDatabaseAction;
import org.bimserver.database.actions.SendClashesEmailDatabaseAction;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.PluginManager;
import org.bimserver.webservices.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class ClashDetectionLongAction extends LongAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClashDetectionLongAction.class);
	private final long actingUoid;
	private final BimDatabase bimDatabase;
	private final long poid;
	private final User user;
	private final MailSystem mailSystem;
	private final SettingsManager settingsManager;
	private final MergerFactory mergerFactory;
	private final PluginManager pluginManager;

	public ClashDetectionLongAction(User user, long actingUoid, SettingsManager settingsManager, MailSystem mailSystem, BimDatabase bimDatabase, MergerFactory mergerFactory, long poid, PluginManager pluginManager) {
		this.user = user;
		this.actingUoid = actingUoid;
		this.settingsManager = settingsManager;
		this.mailSystem = mailSystem;
		this.bimDatabase = bimDatabase;
		this.mergerFactory = mergerFactory;
		this.poid = poid;
		this.pluginManager = pluginManager;
	}

	@Override
	public void execute() {
		BimDatabaseSession session = bimDatabase.createSession(true);
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
		session = bimDatabase.createSession(true);
		try {
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, false);
			ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
			clashDetectionSettings.setMargin(project.getClashDetectionSettings().getMargin());
			clashDetectionSettings.getRevisions().add(project.getLastRevision());
			FindClashesDatabaseAction findClashesDatabaseAction = new FindClashesDatabaseAction(session, AccessMethod.INTERNAL, clashDetectionSettings, mergerFactory, roid, pluginManager);
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
				
				SendClashesEmailDatabaseAction sendClashesEmailDatabaseAction = new SendClashesEmailDatabaseAction(session, AccessMethod.INTERNAL, settingsManager, mailSystem, actingUoid, poid, Service.convert(clashDetectionSettings), emailAddresses);
				sendClashesEmailDatabaseAction.execute();
			}
			session.commit();
		} catch (Throwable e) {
			LOGGER.error("", e);
			try {
				BimDatabaseSession rollBackSession = bimDatabase.createSession(true);
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
	public String getDescription() {
		return "ClashDetectionLongAction " + user.getName();
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void init() {
	}

	@Override
	public LongActionKey getKey() {
		return new ClashDetectionLongActionKey(poid);
	}
}