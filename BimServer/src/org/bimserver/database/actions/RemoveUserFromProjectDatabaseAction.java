package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.UserRemovedFromProject;
import org.bimserver.shared.UserException;

public class RemoveUserFromProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private final long poid;
	private final long actingUoid;

	public RemoveUserFromProjectDatabaseAction(AccessMethod accessMethod, long uoid, long poid, long actingUoid) {
		super(accessMethod);
		this.uoid = uoid;
		this.poid = poid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		User user = bimDatabaseSession.getUserByUoid(uoid);
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		if (actingUser.getUserType() == UserType.ADMIN || project.getHasAuthorizedUsers().contains(actingUser)) {
			project.getHasAuthorizedUsers().remove(user);
			user.getHasRightsOn().remove(project);
			UserRemovedFromProject userRemovedFromProject = LogFactory.eINSTANCE.createUserRemovedFromProject();
			userRemovedFromProject.setDate(new Date());
			userRemovedFromProject.setExecutor(actingUser);
			userRemovedFromProject.setAccessMethod(getAccessMethod());
			userRemovedFromProject.setProject(project);
			userRemovedFromProject.setUser(user);
			CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
			bimDatabaseSession.store(userRemovedFromProject, commitSet);
			bimDatabaseSession.store(user, commitSet);
			bimDatabaseSession.store(project, commitSet);
			return true;
		} else {
			throw new UserException("Insufficient rights to remove user from project");
		}
	}
}