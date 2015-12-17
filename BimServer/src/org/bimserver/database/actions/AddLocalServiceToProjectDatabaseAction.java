package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddLocalServiceToProjectDatabaseAction extends BimDatabaseAction<Void> {

	private long poid;
	private Authorization authorization;
	private Service service;
	private long internalServiceOid;

	public AddLocalServiceToProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Service service, long internalServiceOid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.service = service;
		this.internalServiceOid = internalServiceOid;
		this.authorization = authorization;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, OldQuery.getDefault());
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());

		service.setUser(user);
		for (org.bimserver.models.store.Service existing : project.getServices()) {
			if (existing.getName().equals(service.getName())) {
				throw new UserException("Service name \"" + service.getName() + "\" already used in this project");
			}
		}
		service.setInternalService((InternalServicePluginConfiguration) getDatabaseSession().get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), internalServiceOid, OldQuery.getDefault()));
		project.getServices().add(service);
		service.setProject(project);
		getDatabaseSession().store(service);
		service.setProfileIdentifier("" + service.getOid());
		getDatabaseSession().store(project);
		return null;
	}
}
