package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetRevisionDatabaseAction extends BimDatabaseAction<Revision> {

	private final long roid;
	private final long actingUoid;

	public GetRevisionDatabaseAction(AccessMethod accessMethod, long roid, long actingUoid) {
		super(accessMethod);
		this.roid = roid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Revision execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = bimDatabaseSession.getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision does not exist");
		}
		Project project = revision.getProject();
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			return revision;
		}
		throw new UserException("User has no rights on this revision's project");
	}
}