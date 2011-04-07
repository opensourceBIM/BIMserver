package org.bimserver.longaction;

import java.io.File;

import javax.activation.DataHandler;

import org.bimserver.ServerInitializer;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
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

public abstract class LongDownloadOrCheckoutAction extends LongAction {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	protected final BimDatabase bimDatabase;
	protected final LongActionManager longActionManager;
	protected final AccessMethod accessMethod;
	protected final EmfSerializerFactory emfSerializerFactory;
	protected final DownloadParameters downloadParameters;
	protected final long currentUoid;
	protected ActionState state = ActionState.UNKNOWN;
	protected SCheckoutResult checkoutResult;
	protected User user;

	protected LongDownloadOrCheckoutAction(DownloadParameters downloadParameters, BimDatabase bimDatabase,
			LongActionManager longActionManager, AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, long currentUoid) {
		super();
		this.bimDatabase = bimDatabase;
		this.longActionManager = longActionManager;
		this.accessMethod = accessMethod;
		this.emfSerializerFactory = emfSerializerFactory;
		this.downloadParameters = downloadParameters;
		this.currentUoid = currentUoid;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	public String getIdentification() {
		return downloadParameters.getId();
	}

	public abstract LongActionState getState();

	public User getUser() {
		return user;
	}

	public boolean isRunning() {
		return longActionManager.isRunning(this);
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType)
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

	protected void executeAction(BimDatabaseAction<IfcModel> action, DownloadParameters downloadParameters, BimDatabaseSession session,
			boolean commit) throws BimDatabaseException, UserException, NoSerializerFoundException {
		IfcModel ifcModel = null;
		Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
		user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
		if (commit) {
			ifcModel = session.executeAndCommitAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
		} else {
			ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
		}
		checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters.getResultType());
		if (checkoutResult != null) {
			try {
				File homeDir = ServerInitializer.getHomeDir();
				File cachedir = new File(homeDir.getAbsolutePath() + File.separator + "cache");
				if (!cachedir.exists()) {
					cachedir.mkdir();
				}
				ResultType resultType = downloadParameters.getResultType();
				File cachefile = new File(cachedir.getAbsolutePath() + File.separator + getIdentification());
				EmfSerializer serializer = emfSerializerFactory.create(revision.getProject(), user, resultType, ifcModel,
						checkoutResult.getProjectName() + "." + checkoutResult.getRevisionNr() + "." + resultType.getDefaultExtension());
				serializer.writeToFile(cachefile);
			} catch (SerializerException e) {
				LOGGER.error("", e);
			} finally {
				checkoutResult = null;
			}
		}
	}
}