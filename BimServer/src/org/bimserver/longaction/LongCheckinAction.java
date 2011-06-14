package org.bimserver.longaction;

import org.bimserver.MergerFactory;
import org.bimserver.ServerInfo;
import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ProgressHandler;
import org.bimserver.database.actions.CheckinPart2DatabaseAction;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongCheckinAction extends LongAction<LongCheckinActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongCheckinAction.class);
	private final CheckinPart2DatabaseAction createCheckinAction;
	private final BimDatabase bimDatabase;
	private final SchemaDefinition schema;
	private final IfcEngineFactory ifcEngineFactory;
	private final LongActionManager longActionManager;
	private final User user;
	private final FieldIgnoreMap fieldIgnoreMap;
	private final MailSystem mailSystem;
	private final SettingsManager settingsManager;
	private int progress;
	private final MergerFactory mergerFactory;
	private final PluginManager pluginManager;

	public LongCheckinAction(User user, LongActionManager longActionManager, BimDatabase bimDatabase, SchemaDefinition schema, CheckinPart2DatabaseAction createCheckinAction, IfcEngineFactory ifcEngineFactory, FieldIgnoreMap fieldIgnoreMap, SettingsManager settingsManager, MailSystem mailSystem, MergerFactory mergerFactory, PluginManager pluginManager) {
		this.user = user;
		this.longActionManager = longActionManager;
		this.bimDatabase = bimDatabase;
		this.schema = schema;
		this.createCheckinAction = createCheckinAction;
		this.ifcEngineFactory = ifcEngineFactory;
		this.fieldIgnoreMap = fieldIgnoreMap;
		this.settingsManager = settingsManager;
		this.mailSystem = mailSystem;
		this.mergerFactory = mergerFactory;
		this.pluginManager = pluginManager;
	}

	public void execute() {
		BimDatabaseSession session = bimDatabase.createSession(true);
		try {
			createCheckinAction.setDatabaseSession(session);
			session.executeAndCommitAction(createCheckinAction, 10, new ProgressHandler(){
				@Override
				public void progress(int current, int max) {
					LongCheckinAction.this.progress = current * 100 / max;
				}});
			session.close();

			BimDatabaseSession extraSession = bimDatabase.createSession(true);
			try {
				ConcreteRevision concreteRevision = (ConcreteRevision) extraSession.get(StorePackage.eINSTANCE.getConcreteRevision(),
						createCheckinAction.getCroid(), false);
				for (Revision r : concreteRevision.getRevisions()) {
					Revision latest = null;
					for (Revision r2 : r.getProject().getRevisions()) {
						if (latest == null || r2.getId() > latest.getId()) {
							latest = r2;
						}
					}
					if (latest != null) {
						latest.getProject().setLastRevision(latest);
						extraSession.store(latest.getProject());
					}
				}
				extraSession.commit();
			} finally {
				extraSession.close();
			}

			session = bimDatabase.createReadOnlySession();
			startClashDetection(session);
		} catch (OutOfMemoryError e) {
			ServerInfo.setOutOfMemory();
			return;
		} catch (Exception e) {
			LOGGER.error("", e);
			long croid = createCheckinAction.getCroid();
			try {
				BimDatabaseSession rollBackSession = bimDatabase.createSession(true);
				try {
					Throwable throwable = e;
					while (throwable.getCause() != null) {
						throwable = throwable.getCause();
					}
					ConcreteRevision concreteRevision = (ConcreteRevision) rollBackSession.get(
							StorePackage.eINSTANCE.getConcreteRevision(), croid, false);
					concreteRevision.setState(CheckinState.ERROR);
					concreteRevision.setLastError(throwable.getMessage());
					for (Revision revision : concreteRevision.getRevisions()) {
						revision.setState(CheckinState.ERROR);
						revision.setLastError(throwable.getMessage());
					}
					rollBackSession.store(concreteRevision);
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

	private void startClashDetection(BimDatabaseSession session) throws BimDeadlockException, BimDatabaseException, UserException,
			IfcEngineException, SerializerException {
		ConcreteRevision concreteRevision = (ConcreteRevision) session.get(StorePackage.eINSTANCE.getConcreteRevision(),
				createCheckinAction.getCroid(), false);
		Project project = concreteRevision.getProject();
		Project mainProject = project;
		while (mainProject.getParent() != null) {
			mainProject = mainProject.getParent();
		}
		if (mainProject.getClashDetectionSettings().isEnabled()) {
			ClashDetectionLongAction clashDetectionLongAction = new ClashDetectionLongAction(user, createCheckinAction.getActingUid(), schema, settingsManager, ifcEngineFactory, mailSystem, bimDatabase, fieldIgnoreMap, mergerFactory, mainProject.getOid(), pluginManager);
			try {
				longActionManager.start(clashDetectionLongAction);
			} catch (CannotBeScheduledException e) {
				throw new UserException("Server is shutting down", e);
			}
		}
	}

	@Override
	public String getDescription() {
		return getClass().getSimpleName() + " " + createCheckinAction.getCroid();
	}

	public User getUser() {
		return user;
	}

	public int getProgress() {
		return progress;
	}

	@Override
	public void init() {
	}

	@Override
	public LongCheckinActionKey getKey() {
		return new LongCheckinActionKey(createCheckinAction.getCroid());
	}
}