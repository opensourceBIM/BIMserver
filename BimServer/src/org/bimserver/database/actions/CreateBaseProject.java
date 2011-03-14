package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.shared.UserException;

public class CreateBaseProject extends BimDatabaseAction<Project>{

	public CreateBaseProject(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		super(bimDatabaseSession, accessMethod);
	}

	@Override
	public Project execute() throws UserException, BimDatabaseException, BimDeadlockException {
		final Project project = StoreFactory.eINSTANCE.createProject();
		project.setName(Database.STORE_PROJECT_NAME);
		project.setCreatedDate(new Date());
		getDatabaseSession().store(project);
		return project;
	}
}