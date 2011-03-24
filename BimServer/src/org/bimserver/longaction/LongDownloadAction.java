package org.bimserver.longaction;

import java.util.Set;

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
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;
import org.bimserver.shared.ResultType;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	enum DownloadType {
		DOWNLOAD, DOWNLOAD_BY_OIDS, DOWNLOAD_BY_GUIDS, DOWNLOAD_BY_TYPE
	};

	private BimDatabaseAction<IfcModel> action;
	private final SettingsManager settingsManager;
	private final DownloadType downloadType;

	private LongDownloadAction(DownloadType downloadType, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, long currentUoid) {
		super(bimDatabase, longActionManager, accessMethod, emfSerializerFactory, currentUoid);
		this.downloadType = downloadType;
		this.settingsManager = settingsManager;
	}

	public LongDownloadAction(long roid, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, ResultType resultType) {
		this(DownloadType.DOWNLOAD, longActionManager, bimDatabase, accessMethod, emfSerializerFactory, settingsManager, currentUoid);
		downloadParameters.setRoid(roid);
		downloadParameters.setResultType(resultType);
	}

	public LongDownloadAction(Set<Long> roids, Set<String> guids, long currentUoid, LongActionManager longActionManager,
			BimDatabase bimDatabase, AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager,
			ResultType resultType) {
		this(DownloadType.DOWNLOAD_BY_GUIDS, longActionManager, bimDatabase, accessMethod, emfSerializerFactory, settingsManager,
				currentUoid);
		downloadParameters.setRoids(roids);
		downloadParameters.setGuids(guids);
		downloadParameters.setResultType(resultType);
	}

	public LongDownloadAction(Set<Long> roids, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, Set<Long> oids,
			ResultType resultType) {
		this(DownloadType.DOWNLOAD_BY_OIDS, longActionManager, bimDatabase, accessMethod, emfSerializerFactory, settingsManager,
				currentUoid);
		downloadParameters.setRoids(roids);
		downloadParameters.setOids(oids);
		downloadParameters.setResultType(resultType);
	}

	public LongDownloadAction(long roid, String className, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, ResultType resultType) {
		this(DownloadType.DOWNLOAD_BY_TYPE, longActionManager, bimDatabase, accessMethod, emfSerializerFactory, settingsManager,
				currentUoid);
		downloadParameters.setRoid(roid);
		downloadParameters.setClassName(className);
		downloadParameters.setResultType(resultType);
	}

	public void execute() {
		state = ActionState.STARTED;
		switch (downloadType) {
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
	}

	private void executeDownload(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoid(), currentUoid);
			IfcModel ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters.getResultType());
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
			state = ActionState.FINISHED;
		}
	}

	private void executeDownloadByGuids(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadByGuidsDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoids(),
					downloadParameters.getGuids(), currentUoid);
			IfcModel ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters.getResultType());
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
			state = ActionState.FINISHED;
		}
	}

	private void executeDownloadByOids(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			action = new DownloadByOidsDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoids(),
					downloadParameters.getOids(), currentUoid);
			IfcModel ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters.getResultType());
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
			state = ActionState.FINISHED;
		}
	}

	private void executeDownloadByType(DownloadParameters downloadParameters) {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			action = new DownloadOfTypeDatabaseAction(session, accessMethod, settingsManager, downloadParameters.getRoid(),
					downloadParameters.getClassName(), currentUoid);
			IfcModel ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters.getResultType());
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
			state = ActionState.FINISHED;
		}
	}

	@Override
	public synchronized LongActionState getState() {
		LongActionState ds = new LongActionState();
		switch (downloadType) {
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