package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetLastRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final int pid;

	public GetLastRevisionDatabaseAction(AccessMethod accessMethod, int pid) {
		super(accessMethod);
		this.pid = pid;
	}

	@Override
	public Revision execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectById(pid);
		if (project != null) {
			return project.getLastRevision();
		} else {
			throw new UserException("There is no project with id " + pid);
		}
	}
}