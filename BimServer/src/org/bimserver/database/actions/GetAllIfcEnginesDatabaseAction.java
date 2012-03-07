package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllIfcEnginesDatabaseAction extends GetAllDatabaseAction<IfcEngine> {

	private final boolean onlyEnabled;
	private final BimServer bimServer;

	public GetAllIfcEnginesDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, BimServer bimServer, boolean onlyEnabled) {
		super(bimDatabaseSession, accessMethod, IfcEngine.class, StorePackage.eINSTANCE.getIfcEngine());
		this.bimServer = bimServer;
		this.onlyEnabled = onlyEnabled;
	}

	@Override
	public List<IfcEngine> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getIfcEngine());
		Map<Long, IfcEngine> result = getDatabaseSession().query(condition, IfcEngine.class, false, null);
		List<IfcEngine> mapToList = CollectionUtils.mapToList(result);
		if (onlyEnabled) {
			Iterator<IfcEngine> iterator = mapToList.iterator();
			while (iterator.hasNext()) {
				IfcEngine ifcEngine = iterator.next();
				if (!bimServer.getPluginManager().isEnabled(ifcEngine.getClassName())) {
					iterator.remove();
				}
			}
		}
		return mapToList;
	}
}