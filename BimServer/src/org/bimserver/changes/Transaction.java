package org.bimserver.changes;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
	private int newRid;

	public Transaction(BimServer bimServer, Revision previousRevision, Project project, ConcreteRevision concreteRevision, DatabaseSession databaseSession) {
		this.bimServer = bimServer;
		this.previousRevision = previousRevision;
		this.project = project;
		this.concreteRevision = concreteRevision;
		this.databaseSession = databaseSession;
		this.newRid = concreteRevision.getId();
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
		if (!created.containsKey(object.getOid())) {
			updated.put(object.getOid(), object);
		}
	}
	
	public void deleted(HashMapVirtualObject object) {
		deleted.put(object.getOid(), object);
	}
	
	public Collection<HashMapVirtualObject> getDeleted() {
		return deleted.values();
	}

	public int getNewRid() {
		return newRid;
	}
}