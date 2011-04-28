package org.bimserver.database.actions;

import java.util.List;
import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;
import org.eclipse.emf.ecore.EClass;

public class GetAllDatabaseAction<T extends IdEObject> extends BimDatabaseAction<List<T>> {

	private final Class<T> clazz;
	private final EClass eClass;

	public GetAllDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Class<T> clazz, EClass eClass) {
		super(bimDatabaseSession, accessMethod);
		this.clazz = clazz;
		this.eClass = eClass;
	}

	@Override
	public List<T> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new IsOfTypeCondition(eClass);
		Map<Long, T> result = getDatabaseSession().query(condition, clazz, false);
		return CollectionUtils.mapToList(result);
	}
}