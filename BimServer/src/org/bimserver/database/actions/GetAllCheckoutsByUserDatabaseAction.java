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

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsByUserDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long uoid;

	public GetAllCheckoutsByUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
	}

	@Override
	public Set<Checkout> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(uoid);
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_User(), user);
//		condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getCheckout_Active(), new BooleanLiteral(true)));
		Map<Long, Checkout> query = (Map<Long, Checkout>) getDatabaseSession().query(condition, Checkout.class, false, null);
		return CollectionUtils.mapToSet(query);
	}
}