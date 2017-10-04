package org.bimserver.changes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.HashMapVirtualObject;

public class Transaction {
	private Map<Long, HashMapVirtualObject> created = new HashMap<>();
	private Map<Long, HashMapVirtualObject> updated = new HashMap<>();
	private Map<Long, HashMapVirtualObject> deleted = new HashMap<>();
	private Revision previousRevision;
	private Project project;
	private ConcreteRevision concreteRevision;
	private DatabaseSession databaseSession;
	private BimServer bimServer;

	public Transaction(BimServer bimServer, Revision previousRevision, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession) {
		this.bimServer = bimServer;
		this.previousRevision = previousRevision;
		this.project = project;
		this.concreteRevision = concreteRevision;
		this.databaseSession = databaseSession;
	}
	
	public DatabaseSession getDatabaseSession() {
		return databaseSession;
	}
	
	public Project getProject() {
		return project;
	}
	
	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}
	
	public Revision getPreviousRevision() {
		return previousRevision;
	}

	public BimServer getBimServer() {
		return bimServer;
	}

	public HashMapVirtualObject get(long oid) {
		if (created.containsKey(oid)) {
			return created.get(oid);
		} else if (updated.containsKey(oid)) {
			return updated.get(oid);
		}
		return null;
	}

	public void created(HashMapVirtualObject object) {
		created.put(object.getOid(), object);
	}

	public Collection<HashMapVirtualObject> getCreated() {
		return created.values();
	}

	public Collection<HashMapVirtualObject> getUpdated() {
		return updated.values();
	}

	public void updated(HashMapVirtualObject object) {
		updated.put(object.getOid(), object);
	}
}