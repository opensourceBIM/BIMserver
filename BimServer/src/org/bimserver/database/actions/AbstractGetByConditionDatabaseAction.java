package org.bimserver.database.actions;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;

public abstract class AbstractGetByConditionDatabaseAction<T extends IdEObject> extends BimDatabaseAction<T> {

	private Condition condition;
	private Class<T> clazz;

	public AbstractGetByConditionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Class<T> clazz) {
		super(databaseSession, accessMethod);
		this.clazz = clazz;
	}

	@Override
	public T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		return getDatabaseSession().querySingle(condition, clazz, false, null);
	}
	
	protected void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
}