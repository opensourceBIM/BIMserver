package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;

public class GetAvailableClassesInRevisionDatabaseAction extends BimDatabaseAction<List<String>> {

	private final long roid;

	public GetAvailableClassesInRevisionDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public List<String> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		return getDatabaseSession().getAvailableClassesInRevision(revision.getProject().getId(), revision.getId());
	}
}