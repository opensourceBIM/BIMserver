package org.bimserver.longaction;

import java.util.UUID;

import javax.activation.DataHandler;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.log.AccessMethod;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongDownloadAction extends LongAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	private final BimDatabase bimDatabase;
	private final LongActionManager longActionManager;
	private final AccessMethod accessMethod;
	private final EmfSerializerFactory emfSerializerFactory;
	private final ResultType resultType;
	private SCheckoutResult checkoutResult;
	private User user;
	private final long roid;
	private final long currentUoid;
	private final String id;

	public LongDownloadAction(long roid, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, ResultType resultType) {
		super();
		this.longActionManager = longActionManager;
		this.bimDatabase = bimDatabase;
		this.accessMethod = accessMethod;
		this.emfSerializerFactory = emfSerializerFactory;
		this.resultType = resultType;
		this.roid = roid;
		this.currentUoid = currentUoid;
		this.id = UUID.randomUUID().toString();
	}

	public void execute() {
		BimDatabaseSession session = bimDatabase.createReadOnlySession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(session, accessMethod, roid, currentUoid);
			IfcModel ifcModel = session.executeAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES);
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), roid, false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user, ifcModel, resultType);
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

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
		return id;
	}

	public User getUser() {
		return user;
	}
}