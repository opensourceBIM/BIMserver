package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Action;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ServiceStatus;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddNewServiceToProjectDatabaseAction extends BimDatabaseAction<Long> {

	private long poid;
	private NewService service;
	private Action action;

	public AddNewServiceToProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, NewService service, Action action, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.service = service;
		this.action = action;
	}

	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, OldQuery.getDefault());
//		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
//		service.setUser(user);
		for (org.bimserver.models.store.Service existing : project.getServices()) {
			if (existing.getName().equals(service.getName())) {
				throw new UserException("Service name \"" + service.getName() + "\" already used in this project");
			}
		}
		service.setAction(action);
		service.setStatus(ServiceStatus.NEW);
		if (service.getAuthorizationUrl() == null) {
			service.setStatus(ServiceStatus.NO_AUTHENTICATION);
		}
		project.getNewServices().add(service);
		service.setProject(project);
		long serviceOid = getDatabaseSession().store(service);
		getDatabaseSession().store(action);
		getDatabaseSession().store(project);
		return serviceOid;
	}
}