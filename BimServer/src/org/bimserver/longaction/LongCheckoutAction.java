package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.CheckoutDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ActionState;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class LongCheckoutAction extends LongDownloadOrCheckoutAction {

	private CheckoutDatabaseAction action;
	private DatabaseSession session;

	public LongCheckoutAction(BimServer bimServer, String username, String userUsername, DownloadParameters downloadParameters, Authorization authorization, AccessMethod accessMethod) {
		super(bimServer, username, userUsername, downloadParameters, accessMethod, authorization);
	}

	@Override
	public void execute() {
		changeActionState(ActionState.STARTED, "Starting checkout", 0);
		try {
			executeAction(action, downloadParameters, session, true);
		} catch (Exception e) {
			if (e instanceof UserException) {
				//
			} else {
				LOGGER.error("", e);
			}
		} finally {
			session.close();
			changeActionState(ActionState.FINISHED, "Checkout finished", 100);
		}
	}

	@Override
	public String getDescription() {
		return "Checkout";
	}
	
	@Override
	public void init() {
		session = getBimServer().getDatabase().createSession();
		action = new CheckoutDatabaseAction(session, accessMethod, getAuthorization(), downloadParameters.getRoid());
	}
}