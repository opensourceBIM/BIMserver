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
import org.bimserver.models.store.ObjectIDMPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllObjectIDMsDatabaseAction extends GetAllDatabaseAction<ObjectIDMPluginConfiguration> {

	private boolean onlyEnabled;
	private BimServer bimServer;

	public GetAllObjectIDMsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean onlyEnabled) {
		super(databaseSession, accessMethod, ObjectIDMPluginConfiguration.class, StorePackage.eINSTANCE.getObjectIDMPluginConfiguration());
		this.bimServer = bimServer;
		this.onlyEnabled = onlyEnabled;
	}
	
	public List<ObjectIDMPluginConfiguration> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration());
		Map<Long, ObjectIDMPluginConfiguration> result = getDatabaseSession().query(condition, ObjectIDMPluginConfiguration.class, OldQuery.getDefault());
		List<ObjectIDMPluginConfiguration> mapToList = CollectionUtils.mapToList(result);
		if (onlyEnabled) {
			Iterator<ObjectIDMPluginConfiguration> iterator = mapToList.iterator();
			while (iterator.hasNext()) {
				ObjectIDMPluginConfiguration objectIdm = iterator.next();
				if (!bimServer.getPluginManager().isEnabled(objectIdm.getPluginDescriptor().getPluginClassName()) || !objectIdm.getEnabled()) {
					iterator.remove();
				}
			}
		}
		return mapToList;
	}
}