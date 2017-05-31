package org.bimserver.changes;

import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.exceptions.UserException;

public class SetWrappedAttributeChange implements Change {

	private Long oid;
	private String attributeName;
	private String type;
	private Object value;

	public SetWrappedAttributeChange(Long oid, String attributeName, String type, Object value) {
		this.oid = oid;
		this.attributeName = attributeName;
		this.type = type;
		this.value = value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(BimServer bimServer, long roid, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession, Map<Long, HashMapVirtualObject> created, Map<Long, HashMapVirtualObject> deleted) throws UserException, BimserverLockConflictException,
			BimserverDatabaseException {
		throw new UserException("Not implemented");
	}
}