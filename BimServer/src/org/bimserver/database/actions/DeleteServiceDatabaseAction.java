package org.bimserver.database.actions;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class DeleteServiceDatabaseAction extends DeleteDatabaseAction<Service> {

	public DeleteServiceDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getService(), oid);
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Service object = getDatabaseSession().get(geteClass(), getOid(), false, null);
		User user = object.getUser();
		user.getServices().remove(object);
		Project project = object.getProject();
		project.getServices().remove(object);
		getDatabaseSession().store(project);
		getDatabaseSession().store(user);
		return super.execute();
	}
}