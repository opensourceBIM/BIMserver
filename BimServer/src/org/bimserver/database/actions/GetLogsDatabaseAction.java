package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

public class GetLogsDatabaseAction extends BimDatabaseAction<List<LogAction>> {

	private final long actingUoid;

	public GetLogsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public List<LogAction> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		if (user.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can retrieve log");
		}
		Map<Long, LogAction> query = getDatabaseSession().query(new IsOfTypeCondition(LogPackage.eINSTANCE.getLogAction()), LogAction.class, false);
		ArrayList<LogAction> list = new ArrayList<LogAction>(query.values());
		return list;
	}
}