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
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllModelComparesDatabaseAction extends GetAllDatabaseAction<ModelComparePluginConfiguration> {

	private final boolean onlyEnabled;
	private final BimServer bimServer;

	public GetAllModelComparesDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean onlyEnabled) {
		super(databaseSession, accessMethod, ModelComparePluginConfiguration.class, StorePackage.eINSTANCE.getModelComparePluginConfiguration());
		this.bimServer = bimServer;
		this.onlyEnabled = onlyEnabled;
	}

	@Override
	public List<ModelComparePluginConfiguration> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getModelComparePluginConfiguration());
		Map<Long, ModelComparePluginConfiguration> result = getDatabaseSession().query(condition, ModelComparePluginConfiguration.class, OldQuery.getDefault());
		List<ModelComparePluginConfiguration> mapToList = CollectionUtils.mapToList(result);
		if (onlyEnabled) {
			Iterator<ModelComparePluginConfiguration> iterator = mapToList.iterator();
			while (iterator.hasNext()) {
				ModelComparePluginConfiguration modelCompare = iterator.next();
				if (!bimServer.getPluginManager().isEnabled(modelCompare.getPluginDescriptor().getPluginClassName()) || !modelCompare.getEnabled()) {
					iterator.remove();
				}
			}
		}
		return mapToList;
	}
}