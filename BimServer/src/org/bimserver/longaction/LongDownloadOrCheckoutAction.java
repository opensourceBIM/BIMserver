package org.bimserver.longaction;

import javax.activation.DataHandler;

import org.bimserver.cache.DiskCacheManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializerDataSource;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.UserException;
import org.bimserver.shared.LongActionState.ActionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongDownloadOrCheckoutAction extends LongAction<DownloadParameters> {
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
	private final DiskCacheManager diskCacheManager;

	protected LongDownloadOrCheckoutAction(DownloadParameters downloadParameters, BimDatabase bimDatabase,
			LongActionManager longActionManager, AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, long currentUoid, DiskCacheManager diskCacheManager) {
		super();
		this.bimDatabase = bimDatabase;
		this.longActionManager = longActionManager;
		this.accessMethod = accessMethod;
		this.emfSerializerFactory = emfSerializerFactory;
		this.downloadParameters = downloadParameters;
		this.currentUoid = currentUoid;
		this.diskCacheManager = diskCacheManager;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	public abstract LongActionState getState();

	public User getUser() {
		return user;
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			try {
				EmfSerializer serializer = emfSerializerFactory.create(project, user, resultType, model, checkoutResult.getProjectName() + "."
						+ checkoutResult.getRevisionNr() + "." + resultType.getExtension());
				checkoutResult.setFile(new DataHandler(new EmfSerializerDataSource(serializer)));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}

	protected void executeAction(BimDatabaseAction<IfcModel> action, DownloadParameters downloadParameters, BimDatabaseSession session,
			boolean commit) throws BimDatabaseException, UserException, NoSerializerFoundException {
		if (action == null) {
			checkoutResult = new SCheckoutResult();
			checkoutResult.setFile(new DataHandler(getDiskCacheManager().get(downloadParameters)));
		} else {
			IfcModel ifcModel = null;
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			if (commit) {
				ifcModel = session.executeAndCommitAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			} else {
				ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			}
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, EmfSerializerFactory.getInstance().getResultType(downloadParameters.getResultTypeName()));
			if (checkoutResult != null) {
				diskCacheManager.store(downloadParameters, checkoutResult.getFile());
			}
		}
		done();
	}

	public DiskCacheManager getDiskCacheManager() {
		return diskCacheManager;
	}
}