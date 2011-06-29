package org.bimserver.longaction;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	private BimDatabaseAction<? extends IfcModelInterface> action;
	private BimDatabaseSession session;

	public LongDownloadAction(BimServer bimServer, DownloadParameters downloadParameters, long currentUoid, AccessMethod accessMethod) {
		super(bimServer, downloadParameters, accessMethod, currentUoid);
	}

	public void execute() {
		state = ActionState.STARTED;
		try {
			executeAction(action, downloadParameters, session, false);
 		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		state = ActionState.FINISHED;
	}

	public void init() {
		if (getBimServer().getDiskCacheManager().contains(downloadParameters)) {
			return;
		}
		session = getBimServer().getDatabase().createReadOnlySession();
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD:
			action = new DownloadDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), currentUoid);
			break;
		case DOWNLOAD_BY_OIDS:
			action = new DownloadByOidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getOids(), currentUoid);
			break;
		case DOWNLOAD_BY_GUIDS:
			action = new DownloadByGuidsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), downloadParameters.getGuids(), currentUoid);
			break;
		case DOWNLOAD_OF_TYPE:
			action = new DownloadOfTypeDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoid(), downloadParameters.getClassName(), currentUoid);
			break;
		case DOWNLOAD_PROJECTS:
			action = new DownloadProjectsDatabaseAction(getBimServer(), session, accessMethod, downloadParameters.getRoids(), currentUoid);
			break;
		}
	}

	@Override
	public synchronized LongActionState getState() {
		LongActionState ds = new LongActionState();
		if (action == null) {
			ds.setState(state);
			ds.setProgress(100);
			return ds;
		}
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
		case DOWNLOAD_OF_TYPE:
			ds.setProgress(((DownloadOfTypeDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_PROJECTS:
			ds.setProgress(((DownloadProjectsDatabaseAction) action).getProgress());
			break;
		}
		ds.setState(state);
		if (state == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		return ds;
	}

	@Override
	public String getDescription() {
		return "Download";
	}

	@Override
	public DownloadParameters getKey() {
		return downloadParameters;
	}
}