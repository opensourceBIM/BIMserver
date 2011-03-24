package org.bimserver.longaction;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;
import org.bimserver.shared.ResultType;

public class LongCheckoutAction extends LongDownloadOrCheckoutAction {

	private CheckoutDatabaseAction action;

	public LongCheckoutAction(long roid, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory, ResultType resultType) {
		super(bimDatabase, longActionManager, accessMethod, emfSerializerFactory, currentUoid);
		downloadParameters.setResultType(resultType);
		downloadParameters.setRoid(roid);
	}

	@Override
	public void execute() {
		state = ActionState.STARTED;
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			action = new CheckoutDatabaseAction(session, accessMethod, currentUoid, downloadParameters.getRoid());
			Revision revision = session.get(StorePackage.eINSTANCE.getRevision(), downloadParameters.getRoid(), false);
			user = session.get(StorePackage.eINSTANCE.getUser(), currentUoid, false);
			checkoutResult = convertModelToCheckoutResult(revision.getProject(), user,
					session.executeAndCommitAction(action, org.bimserver.webservices.Service.DEADLOCK_RETRIES),
					downloadParameters.getResultType());
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
		ds.setProgress(action.getProgress());
		if (state == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		ds.setState(state);
		return ds;
	}

}