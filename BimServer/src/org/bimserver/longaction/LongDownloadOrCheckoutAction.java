package org.bimserver.longaction;

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializerDataSource;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongDownloadOrCheckoutAction extends LongAction<DownloadParameters> {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	protected final AccessMethod accessMethod;
	protected final DownloadParameters downloadParameters;
	protected final long currentUoid;
	protected ActionState state = ActionState.UNKNOWN;
	protected SCheckoutResult checkoutResult;
	protected User user;
	private final BimServer bimServer;

	protected LongDownloadOrCheckoutAction(BimServer bimServer, DownloadParameters downloadParameters, AccessMethod accessMethod, long currentUoid) {
		super();
		this.bimServer = bimServer;
		this.accessMethod = accessMethod;
		this.downloadParameters = downloadParameters;
		this.currentUoid = currentUoid;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	public abstract LongActionState getState();

	public User getUser() {
		return user;
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModelInterface model, DownloadParameters downloadParameters)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			try {
				EmfSerializer serializer = getBimServer().getEmfSerializerFactory().create(project, user, model, downloadParameters);
				if (serializer == null) {
					throw new UserException("Error, no serializer found");
				}
				checkoutResult.setFile(new DataHandler(new EmfSerializerDataSource(serializer)));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}

	protected void executeAction(BimDatabaseAction<? extends IfcModelInterface> action, DownloadParameters downloadParameters, BimDatabaseSession session,
			boolean commit) throws BimDatabaseException, UserException, NoSerializerFoundException {
		if (action == null) {
			checkoutResult = new SCheckoutResult();
			checkoutResult.setFile(new DataHandler(getBimServer().getDiskCacheManager().get(downloadParameters)));
		} else {
			IfcModelInterface ifcModel = null;
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			revision.getProject().getGeoTag().load(); // Little hack to make sure this is lazily loaded, because after the executeAndCommitAction the session won't be usable
			if (commit) {
				ifcModel = session.executeAndCommitAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			} else {
				ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			}
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, downloadParameters);
			if (checkoutResult != null) {
				getBimServer().getDiskCacheManager().store(downloadParameters, checkoutResult.getFile());
			}
		}
		done();
	}

	public BimServer getBimServer() {
		return bimServer;
	}
}