package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.IntegerLiteral;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public abstract class BimDatabaseAction<T> {
	private BimDatabaseSession bimDatabaseSession;
	private final AccessMethod accessMethod;

	public abstract T execute() throws UserException, BimDeadlockException, BimDatabaseException;

	public BimDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod) {
		this.bimDatabaseSession = bimDatabaseSession;
		this.accessMethod = accessMethod;
	}

	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
	
	public BimDatabaseSession getDatabaseSession() {
		return bimDatabaseSession;
	}
	
	public Project getProjectByPoid(long poid) {
		return (Project) bimDatabaseSession.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
	}

	public User getUserByUoid(long uoid) {
		return (User) bimDatabaseSession.get(StorePackage.eINSTANCE.getUser(), uoid, false, null);
	}
	
	public User getAdminUser() throws BimDatabaseException, BimDeadlockException {
		return getUserByUserName("admin");
	}
	
	public Project getProjectById(int pid) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(pid));
		return bimDatabaseSession.querySingle(condition, Project.class, false, null);
	}

	public Set<Project> getProjectsByName(String projectName) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(projectName));
		return CollectionUtils.mapToSet(bimDatabaseSession.query(condition, Project.class, false, null));
	}

	public User getUserByUserName(String username) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral(username));
		return bimDatabaseSession.querySingle(condition, User.class, false, null);
	}

	public Revision getVirtualRevision(long roid) throws BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
		return (Revision) idEObject;
	}

	public Revision getRevisionByRoid(long roid) {
		return (Revision) bimDatabaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
	}

	public ConcreteRevision getConcreteRevision(long croid) throws BimDeadlockException, BimDatabaseException {
		return (ConcreteRevision) bimDatabaseSession.get(StorePackage.eINSTANCE.getConcreteRevision(), croid, false, null);
	}

	public void setDatabaseSession(BimDatabaseSession session) {
		this.bimDatabaseSession = session;
	}
}