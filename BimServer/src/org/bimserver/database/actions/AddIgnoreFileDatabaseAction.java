package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IgnoreFile;

public class AddIgnoreFileDatabaseAction extends AddDatabaseAction {

	public AddIgnoreFileDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IgnoreFile ignoreFile) {
		super(bimDatabaseSession, accessMethod, ignoreFile);
	}
}