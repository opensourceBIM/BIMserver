package org.bimserver.database.actions;

import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;

public abstract class ProjectBasedDatabaseAction<T> extends BimDatabaseAction<T> {

	public ProjectBasedDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}

	public abstract String getFileName();

	public abstract long getPoid();

	public abstract String doneMessage();
}
