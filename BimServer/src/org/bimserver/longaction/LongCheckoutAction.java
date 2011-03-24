package org.bimserver.longaction;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;

public class LongCheckoutAction extends LongDownloadOrCheckoutAction {

	private CheckoutDatabaseAction action;

	public LongCheckoutAction(DownloadParameters downloadParameters, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase,
			AccessMethod accessMethod, EmfSerializerFactory emfSerializerFactory) {
		super(downloadParameters, bimDatabase, longActionManager, accessMethod, emfSerializerFactory, currentUoid);
	}

	@Override
	public void execute() {
		state = ActionState.STARTED;
		BimDatabaseSession session = bimDatabase.createSession();
		try {
			action = new CheckoutDatabaseAction(session, accessMethod, currentUoid, downloadParameters.getRoid());
			executeAction(action, downloadParameters, session);
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