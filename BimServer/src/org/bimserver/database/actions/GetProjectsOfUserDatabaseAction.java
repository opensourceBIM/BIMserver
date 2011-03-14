package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

public class GetProjectsOfUserDatabaseAction extends BimDatabaseAction<List<Project>>{

	private final long actingUoid;

	public GetProjectsOfUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public List<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		if (user != null) {
			List<Project> result = new ArrayList<Project>();
			for (Project project : user.getHasRightsOn()) {
				if (project.getState() == ObjectState.ACTIVE || user.getUserType() == UserType.ADMIN) {
					result.add(project);
				}
			}
			return result;
		} else {
			throw new UserException("User with id " + actingUoid + " does not exist");
		}
	}
}