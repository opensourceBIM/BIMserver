package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogAction;
import org.bimserver.database.store.log.LogPackage;
import org.bimserver.shared.UserException;

public class GetLogsDatabaseAction extends BimDatabaseAction<List<LogAction>> {

	private final long actingUoid;

	public GetLogsDatabaseAction(AccessMethod accessMethod, long actingUoid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public List<LogAction> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (user.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can retrieve log");
		}
		Map<Long, LogAction> query = bimDatabaseSession.query(Database.STORE_PROJECT_ID, -1, new IsOfTypeCondition(LogPackage.eINSTANCE.getLogAction()), LogAction.class);
		ArrayList<LogAction> list = new ArrayList<LogAction>(query.values());
		return list;
	}
}