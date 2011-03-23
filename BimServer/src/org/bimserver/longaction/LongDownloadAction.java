package org.bimserver.longaction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.activation.DataHandler;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	enum DownloadType {
		DOWNLOAD, DOWNLOAD_BY_OIDS, DOWNLOAD_BY_GUIDS, DOWNLOAD_BY_TYPE
	};

	class DownloadParameters {
		private Set<Long> roids;
		private Set<Long> oids;
		private Set<String> guids;
		private String className;
		private ResultType resultType;
		private String id;

		public String getId() {
			if (id == null) {
				id = UUID.randomUUID().toString();
			}
			return id;
		}

		public Set<Long> getRoids() {
			return roids;
		}

		public void setRoids(Set<Long> roids) {
			this.roids = roids;
		}

		public Long getRoid() {
			if (roids == null)
				return null;
			Iterator<Long> iterator = roids.iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		public void setRoid(Long roid) {
			this.roids = new HashSet<Long>();
			roids.add(roid);
		}

		public Set<Long> getOids() {
			return oids;
		}

		public void setOids(Set<Long> oids) {
			this.oids = oids;
		}

		public Set<String> getGuids() {
			return guids;
		}

		public void setGuids(Set<String> guids) {
			this.guids = guids;
		}

		public ResultType getResultType() {
			return resultType;
		}

		public void setResultType(ResultType resultType) {
			this.resultType = resultType;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	private final BimDatabase bimDatabase;
	private final LongActionManager longActionManager;
	private final AccessMethod accessMethod;
	private final EmfSerializerFactory emfSerializerFactory;
	private SCheckoutResult checkoutResult;
	private User user;
	private BimDatabaseAction<IfcModel> action;
	private final long currentUoid;
	private ActionState state = ActionState.UNKNOWN;
	private final SettingsManager settingsManager;
	private final DownloadType downloadType;
	private final DownloadParameters downloadParameters;

	private LongDownloadAction(DownloadType downloadType, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, long currentUoid) {
		super();
		this.downloadType = downloadType;
		this.longActionManager = longActionManager;
		this.bimDatabase = bimDatabase;
		this.accessMethod = accessMethod;
		this.emfSerializerFactory = emfSerializerFactory;
		this.settingsManager = settingsManager;
		this.currentUoid = currentUoid;
		this.downloadParameters = new DownloadParameters();
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
	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	private SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			EmfSerializer serializer;
			try {
				serializer = emfSerializerFactory.create(project, user, resultType, model, checkoutResult.getProjectName() + "."
						+ checkoutResult.getRevisionNr() + "." + resultType.getDefaultExtension());
				checkoutResult.setFile(new DataHandler(serializer));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}

	public boolean isRunning() {
		return longActionManager.isRunning(this);
	}

	@Override
	public String getIdentification() {
		return downloadParameters.getId();
	}

	@Override
	public User getUser() {
		return user;
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