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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class UpdateIfcEngineDatabaseAction extends UpdateDatabaseAction<IfcEngine> {

	private final IfcEngine ifcEngine;

	public UpdateIfcEngineDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcEngine ifcEngine) {
		super(bimDatabaseSession, accessMethod, ifcEngine);
		this.ifcEngine = ifcEngine;
	}
	
	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		IfcEngine oldIfcEngine = getDatabaseSession().get(StorePackage.eINSTANCE.getIfcEngine(), ifcEngine.getOid(), false, null);
		if (oldIfcEngine.getActive() == true && ifcEngine.getActive() == false && !oldIfcEngine.getSerializers().isEmpty()) {
			throw new UserException("Cannot disable render engine with serializers");
		}
		return super.execute();
	}
}