package org.bimserver.longaction;

import org.bimserver.BimServer;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.webservices.Authorization;

public class LongBranchAction extends LongAction<LongCheckinActionKey> {

	public LongBranchAction(BimServer bimServer, String username, String userUsername, Authorization authorization, BimDatabaseAction<ConcreteRevision> action) {
		super(bimServer, username, userUsername, authorization);
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void init() {
	}

	@Override
	public void execute() {
	}
}