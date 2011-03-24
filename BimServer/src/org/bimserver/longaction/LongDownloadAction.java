package org.bimserver.longaction;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	private BimDatabaseAction<IfcModel> action;
	private final SettingsManager settingsManager;

	public LongDownloadAction(DownloadParameters downloadParameters, long currentUoid, LongActionManager longActionManager,
			BimDatabase bimDatabase, AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager) {
		super(downloadParameters, bimDatabase, longActionManager, accessMethod, emfSerializerFactory, currentUoid);
		this.settingsManager = settingsManager;
	}

	public void execute() {
		state = ActionState.STARTED;
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD:
			executeDownload(downloadParameters);
			break;
		case DOWNLOAD_BY_OIDS:
			executeDownloadByOids(downloadParameters);
			break;
		case DOWNLOAD_BY_GUIDS:
			executeDownloadByGuids(downloadParameters);
			break;
		case DOWNLOAD_BY_TYPE:
			executeDownloadByType(downloadParameters);
			break;
		}
		state = ActionState.FINISHED;
	}

	private void executeDownload(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoid(), currentUoid);
			executeAction(action, downloadParameters, session);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	private void executeDownloadByGuids(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadByGuidsDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoids(),
					downloadParameters.getGuids(), currentUoid);
			executeAction(action, downloadParameters, session);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	private void executeDownloadByOids(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			action = new DownloadByOidsDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoids(),
					downloadParameters.getOids(), currentUoid);
			executeAction(action, downloadParameters, session);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	private void executeDownloadByType(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadOfTypeDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoid(),
					downloadParameters.getClassName(), currentUoid);
			executeAction(action, downloadParameters, session);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	@Override
	public synchronized LongActionState getState() {
		LongActionState ds = new LongActionState();
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD:
			ds.setProgress(((DownloadDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_OIDS:
			ds.setProgress(((DownloadByOidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_GUIDS:
			ds.setProgress(((DownloadByGuidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_TYPE:
			ds.setProgress(((DownloadOfTypeDatabaseAction) action).getProgress());
			break;
		}
		ds.setState(state);
		if (state == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		return ds;
	}
}