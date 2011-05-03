package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class RemoveUserFromProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;
	private final long actingUoid;

	public RemoveUserFromProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, long poid,
			long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.poid = poid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Anonymous user has no rights to remove users from any project");
		} else if (RightsManager.hasRightsOnProject(actingUser, project)) {
			if (user.getUserType() == UserType.ADMIN) {
				int nrAdmins = 0;
				for (User authUser : project.getHasAuthorizedUsers()) {
					if (authUser.getUserType() == UserType.ADMIN) {
						nrAdmins++;
					}
				}
				if (nrAdmins == 1) {
					throw new UserException(
							"User cannot be removed from this project because it is the only admin user with authorization on this project");
				}
			}
			project.getHasAuthorizedUsers().remove(user);
			user.getHasRightsOn().remove(project);
			UserRemovedFromProject userRemovedFromProject = LogFactory.eINSTANCE.createUserRemovedFromProject();
			userRemovedFromProject.setDate(new Date());
			userRemovedFromProject.setExecutor(actingUser);
			userRemovedFromProject.setAccessMethod(getAccessMethod());
			userRemovedFromProject.setProject(project);
			userRemovedFromProject.setUser(user);
			getDatabaseSession().store(userRemovedFromProject);
			getDatabaseSession().store(user);
			getDatabaseSession().store(project);
			return true;
		} else {
			throw new UserException("Insufficient rights to remove user from project");
		}
	}
}