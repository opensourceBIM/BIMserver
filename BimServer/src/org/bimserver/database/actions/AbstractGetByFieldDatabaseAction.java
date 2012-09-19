package org.bimserver.database.actions;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.LiteralCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;

public abstract class AbstractGetByFieldDatabaseAction<T extends IdEObject> extends AbstractGetByConditionDatabaseAction<T> {

	private EAttribute eAttribute;
	private Object value;

	public AbstractGetByFieldDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Class<T> clazz, EAttribute eAttribute, Object value) {
		super(databaseSession, accessMethod, clazz);
		this.eAttribute = eAttribute;
		this.value = value;
		setCondition(new AttributeCondition(eAttribute, LiteralCondition.from(value)));
	}
	
	@Override
	public T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		T result = super.execute();
		if (result == null) {
			throw new UserException("No " + getClazz().getSimpleName() + " found where " + eAttribute.getName() + " = " + value);
		}
		return result;
	}
}
