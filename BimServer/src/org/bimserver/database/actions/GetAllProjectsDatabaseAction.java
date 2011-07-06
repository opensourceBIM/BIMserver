package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private final long actingUoid;

	public GetAllProjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
	}

	@Override
	public Set<Project> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Not notStoreProject = new Not(new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(Database.STORE_PROJECT_NAME)));
		HasReferenceToCondition authorized = new HasReferenceToCondition(StorePackage.eINSTANCE.getProject_HasAuthorizedUsers(), user);
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getProject()).and(notStoreProject);
		if (user.getUserType() != UserType.ADMIN && user.getUserType() != UserType.SYSTEM) {
			condition = condition.and(authorized);
			condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getProject_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		Map<Long, Project> results = (Map<Long, Project>) getDatabaseSession().query(condition, Project.class, false);
		Set<Project> resultSet = CollectionUtils.mapToSet(results);
		for (Project project : results.values()) {
			addParentProjects(resultSet, project);
		}
		return resultSet;
	}

	private void addParentProjects(Set<Project> resultSet, Project project) {
		if (project.getParent() != null) {
			if (!resultSet.contains(project.getParent())) {
				resultSet.add(project.getParent());
			}
			addParentProjects(resultSet, project.getParent());
		}
	}
}