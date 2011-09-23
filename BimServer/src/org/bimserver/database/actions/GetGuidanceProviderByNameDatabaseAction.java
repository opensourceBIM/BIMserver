package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class GetGuidanceProviderByNameDatabaseAction extends BimDatabaseAction<GuidanceProvider> {

	private final String guidanceProviderName;

	public GetGuidanceProviderByNameDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, String guidanceProviderName) {
		super(bimDatabaseSession, accessMethod);
		this.guidanceProviderName = guidanceProviderName;
	}

	@Override
	public GuidanceProvider execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getGuidanceProvider_Name(), new StringLiteral(guidanceProviderName));
		return getDatabaseSession().querySingle(condition, GuidanceProvider.class, false, null);
	}
}