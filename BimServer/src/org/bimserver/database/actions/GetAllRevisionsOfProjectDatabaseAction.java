package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetAllRevisionsOfProjectDatabaseAction extends BimDatabaseAction<Set<Revision>> {

	private final long poid;

	public GetAllRevisionsOfProjectDatabaseAction(AccessMethod accessMethod, long poid) {
		super(accessMethod);
		this.poid = poid;
	}

	@Override
	public Set<Revision> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		return new HashSet<Revision>(project.getRevisions());
	}
}