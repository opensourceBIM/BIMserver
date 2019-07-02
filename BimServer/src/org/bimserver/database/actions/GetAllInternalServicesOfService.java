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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetAllInternalServicesOfService extends BimDatabaseAction<Set<InternalServicePluginConfiguration>> {

	private String serviceName;
	private SUser sUser;

	public GetAllInternalServicesOfService(DatabaseSession session, AccessMethod internalAccessMethod, BimServer bimServer, SUser sUser, String serviceName) {
		super(session, internalAccessMethod);
		this.sUser = sUser;
		this.serviceName = serviceName;
	}

	@Override
	public Set<InternalServicePluginConfiguration> execute()
			throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		Set<InternalServicePluginConfiguration> configs = new HashSet<>();
		// TODO use indices
		List<InternalServicePluginConfiguration> allOfType = new ArrayList<>(getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), InternalServicePluginConfiguration.class, OldQuery.getDefault()));
		for (InternalServicePluginConfiguration internalServicePluginConfiguration : allOfType) {
			if (internalServicePluginConfiguration.getPluginDescriptor().getName().equals(serviceName) && internalServicePluginConfiguration.getUserSettings().getOid() == getUserByUoid(sUser.getOid()).getUserSettings().getOid()) {
				configs.add(internalServicePluginConfiguration);
			}
		}
		return configs;
	}
}
