package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class GetDeserializerByNameDatabaseAction extends BimDatabaseAction<Deserializer> {

	private final String name;

	public GetDeserializerByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String name) {
		super(bimDatabaseSession, accessMethod);
		this.name = name;
	}

	@Override
	public Deserializer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getDeserializer_Name(), new StringLiteral(name));
		return getDatabaseSession().querySingle(condition, Deserializer.class, false, null);
	}
}