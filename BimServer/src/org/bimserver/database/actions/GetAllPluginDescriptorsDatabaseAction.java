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
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetAllPluginDescriptorsDatabaseAction extends BimDatabaseAction<List<SPluginDescriptor>>{

	private final SPluginType pluginType;
	private BimServer bimServer;

	public GetAllPluginDescriptorsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, SPluginType searchedType) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.pluginType = searchedType;
	}

	@Override
	public List<SPluginDescriptor> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		IfcModelInterface allOfType = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), OldQuery.getDefault());
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		for (PluginDescriptor pluginDescriptor : allOfType.getAll(PluginDescriptor.class)) {
			SPluginType encounteredType = bimServer.getPluginManager().getPluginTypeFromClass(pluginDescriptor.getPluginInterfaceClassName());
			if(encounteredType.equals(pluginType)){
				result.add(bimServer.getSConverter().convertToSObject(pluginDescriptor));
			}
		}
		return result;
	}
}