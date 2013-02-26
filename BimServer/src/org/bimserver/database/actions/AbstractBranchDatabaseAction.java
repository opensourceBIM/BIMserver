package org.bimserver.database.actions;

import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;

public abstract class AbstractBranchDatabaseAction extends BimDatabaseAction<ConcreteRevision> {

	public AbstractBranchDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}

	public abstract Long getPoid();
	public abstract Long getRoid();
}
