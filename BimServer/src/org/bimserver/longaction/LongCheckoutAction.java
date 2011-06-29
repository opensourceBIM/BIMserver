package org.bimserver.longaction;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;

public class LongCheckoutAction extends LongDownloadOrCheckoutAction {

	private CheckoutDatabaseAction action;
	private BimDatabaseSession session;

	public LongCheckoutAction(BimServer bimServer, DownloadParameters downloadParameters, long currentUoid, AccessMethod accessMethod) {
		super(bimServer, downloadParameters, accessMethod, currentUoid);
	}

	@Override
	public void execute() {
		state = ActionState.STARTED;
		try {
			executeAction(action, downloadParameters, session, true);
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

	@Override
	public String getDescription() {
		return "Checkout";
	}
	
	@Override
	public void init() {
		session = getBimServer().getDatabase().createSession(true);
		action = new CheckoutDatabaseAction(session, accessMethod, currentUoid, downloadParameters.getRoid());
	}

	@Override
	public DownloadParameters getKey() {
		return downloadParameters;
	}
}