package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

public class UndeleteProjectDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long poid;

	public UndeleteProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(actingUoid);
		final Project project = getProjectByPoid(poid);
		if (actingUser.getUserType() == UserType.ADMIN || actingUser.getHasRightsOn().contains(project)) {
			project.setState(ObjectState.ACTIVE);
			ProjectUndeleted projectUndeleted = LogFactory.eINSTANCE.createProjectUndeleted();
			projectUndeleted.setAccessMethod(getAccessMethod());
			projectUndeleted.setDate(new Date());
			projectUndeleted.setExecutor(actingUser);
			projectUndeleted.setProject(project);
			getDatabaseSession().store(project);
			getDatabaseSession().store(projectUndeleted);
			return true;
		} else {
			throw new UserException("No rights to undelete this project");
		}
	}
}