package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;

public class LongCheckoutAction extends LongDownloadOrCheckoutAction {

	private CheckoutDatabaseAction action;
	private BimDatabaseSession session;

	public LongCheckoutAction(BimServer bimServer, User user, DownloadParameters downloadParameters, long currentUoid, AccessMethod accessMethod) {
		super(bimServer, user, downloadParameters, accessMethod, currentUoid);
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
		LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
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