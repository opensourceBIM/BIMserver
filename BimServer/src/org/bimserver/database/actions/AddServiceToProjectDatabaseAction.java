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
import org.bimserver.webservices.Authorization;

public class AddServiceToProjectDatabaseAction extends BimDatabaseAction<Void> {

	private long poid;
	private Authorization authorization;
	private Service service;

	public AddServiceToProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Service service, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.service = service;
		this.authorization = authorization;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, false, null);
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), User.class, authorization.getUoid());
		service.setUser(user);
		for (org.bimserver.models.store.Service existing : project.getServices()) {
			if (existing.getName().equals(service.getName())) {
				throw new UserException("Service name \"" + service.getName() + "\" already used in this project");
			}
		}
		project.getServices().add(service);
		service.setProject(project);
		getDatabaseSession().store(service);
		getDatabaseSession().store(project);
		return null;
	}
}