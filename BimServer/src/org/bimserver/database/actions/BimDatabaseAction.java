package org.bimserver.database.actions;

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
import org.bimserver.shared.UserException;
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
		return (Project) bimDatabaseSession.get(StorePackage.eINSTANCE.getProject(), poid, false);
	}

	public User getUserByUoid(long uoid) {
		return (User) bimDatabaseSession.get(StorePackage.eINSTANCE.getUser(), uoid, false);
	}
	
	public User getAdminUser() throws BimDatabaseException, BimDeadlockException {
		return getUserByUserName("admin");
	}
	
	public Project getProjectById(int pid) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Id(), new IntegerLiteral(pid));
		return bimDatabaseSession.querySingle(condition, Project.class, false);
	}

	public Set<Project> getProjectsByName(String projectName) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(projectName));
		return CollectionUtils.mapToSet(bimDatabaseSession.query(condition, Project.class, false));
	}

	public User getUserByUserName(String username) throws BimDatabaseException, BimDeadlockException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral(username));
		return bimDatabaseSession.querySingle(condition, User.class, false);
	}

	public Revision getVirtualRevision(long roid) throws BimDeadlockException, BimDatabaseException {
		IdEObject idEObject = bimDatabaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, false);
		return (Revision) idEObject;
	}

	public Revision getRevisionByRoid(long roid) {
		return (Revision) bimDatabaseSession.get(StorePackage.eINSTANCE.getRevision(), roid, false);
	}

	public ConcreteRevision getConcreteRevision(long roid) throws BimDeadlockException, BimDatabaseException {
		return (ConcreteRevision) bimDatabaseSession.get(StorePackage.eINSTANCE.getConcreteRevision(), roid, false);
	}

	public User getAnonymousUser() throws BimDatabaseException, BimDeadlockException {
		return getUserByUserName("anonymous");
	}
	
	public void setDatabaseSession(BimDatabaseSession session) {
		this.bimDatabaseSession = session;
	}
}