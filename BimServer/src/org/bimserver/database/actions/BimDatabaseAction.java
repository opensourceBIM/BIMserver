package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.IntegerLiteral;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public abstract class BimDatabaseAction<T> {
	private final Set<ProgressListener> progressListeners = new HashSet<ProgressListener>();
	private DatabaseSession databaseSession;
	private final AccessMethod accessMethod;

	public abstract T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException;

	public BimDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		this.databaseSession = databaseSession;
		this.accessMethod = accessMethod;
	}

	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
	
	public DatabaseSession getDatabaseSession() {
		return databaseSession;
	}
	
	public Project getProjectByPoid(long poid) throws BimserverDatabaseException {
		return databaseSession.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
	}

	public User getUserByUoid(long uoid) throws BimserverDatabaseException {
		return databaseSession.get(StorePackage.eINSTANCE.getUser(), uoid, Query.getDefault());
	}
	
	public User getAdminUser() throws BimserverDatabaseException, BimserverLockConflictException {
		return getUserByUserName("admin");
	}

	public void setProgress(String state, int progress) {
		for (ProgressListener progressListener : progressListeners) {
			progressListener.updateProgress(state, progress);
		}
	}
	
	public void addProgressListener(ProgressListener progressListener) {
		progressListeners.add(progressListener);
	}
	
	public void removeProgressListener(ProgressListener progressListener) {
		progressListeners.remove(progressListener);
	}
	
	public User getSystemUser() throws BimserverDatabaseException, BimserverLockConflictException {
		return getUserByUserName("system");
	}
	
	public Project getProjectById(int pid) throws BimserverDatabaseException, BimserverLockConflictException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(pid));
		return databaseSession.querySingle(condition, Project.class, Query.getDefault());
	}

	public Set<Project> getProjectsByName(String projectName) throws BimserverDatabaseException, BimserverLockConflictException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(projectName));
		return CollectionUtils.mapToSet(databaseSession.query(condition, Project.class, Query.getDefault()));
	}

	public User getUserByUserName(String username) throws BimserverDatabaseException, BimserverLockConflictException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral(username));
		return databaseSession.querySingle(condition, User.class, Query.getDefault());
	}

	public Revision getRevisionByRoid(long roid) throws BimserverDatabaseException {
		return (Revision) databaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
	}

	public ConcreteRevision getConcreteRevision(long croid) throws BimserverLockConflictException, BimserverDatabaseException {
		return (ConcreteRevision) databaseSession.get(StorePackage.eINSTANCE.getConcreteRevision(), croid, Query.getDefault());
	}

	public void setDatabaseSession(DatabaseSession session) {
		this.databaseSession = session;
	}
}