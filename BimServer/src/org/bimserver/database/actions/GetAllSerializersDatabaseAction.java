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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllSerializersDatabaseAction extends GetAllDatabaseAction<SerializerPluginConfiguration> {

	private final boolean onlyEnabled;
	private final BimServer bimServer;

	public GetAllSerializersDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean onlyEnabled) {
		super(databaseSession, accessMethod, SerializerPluginConfiguration.class, StorePackage.eINSTANCE.getSerializerPluginConfiguration());
		this.bimServer = bimServer;
		this.onlyEnabled = onlyEnabled;
	}

	@Override
	public List<SerializerPluginConfiguration> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getSerializerPluginConfiguration());
		Map<Long, SerializerPluginConfiguration> result = getDatabaseSession().query(condition, SerializerPluginConfiguration.class, OldQuery.getDefault());
		List<SerializerPluginConfiguration> mapToList = CollectionUtils.mapToList(result);
		if (onlyEnabled) {
			Iterator<SerializerPluginConfiguration> iterator = mapToList.iterator();
			while (iterator.hasNext()) {
				SerializerPluginConfiguration serializer = iterator.next();
				if (!bimServer.getPluginManager().isEnabled(serializer.getPluginDescriptor().getPluginClassName()) || !serializer.getEnabled()) {
					iterator.remove();
				}
			}
		}
		return mapToList;
	}
}