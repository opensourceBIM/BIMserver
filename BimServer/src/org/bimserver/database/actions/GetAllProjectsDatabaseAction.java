package org.bimserver.database.actions;

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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.AndCondition;
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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetAllProjectsDatabaseAction extends BimDatabaseAction<Set<Project>> {

	private Authorization authorization;
	private boolean onlyTopLevel;
	private Boolean onlyActive;

	public GetAllProjectsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, boolean onlyTopLevel, Boolean onlyActive, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.onlyTopLevel = onlyTopLevel;
		this.onlyActive = onlyActive;
		this.authorization = authorization;
	}

	@Override
	public Set<Project> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(authorization.getUoid());
		Not notStoreProject = new Not(new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(Database.STORE_PROJECT_NAME)));
		HasReferenceToCondition authorized = new HasReferenceToCondition(StorePackage.eINSTANCE.getProject_HasAuthorizedUsers(), user);
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getProject()).and(notStoreProject);
//		if (onlyTopLevel) {
//			condition = new AndCondition(condition, new HasReferenceToCondition(StorePackage.eINSTANCE.getProject_Parent(), null));
//		}
		if (onlyActive) {
			condition = new AndCondition(condition, new AttributeCondition(StorePackage.eINSTANCE.getProject_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		if (user.getUserType() != UserType.ADMIN && user.getUserType() != UserType.SYSTEM) {
			condition = condition.and(authorized);
			condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getProject_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		Map<Long, Project> results = getDatabaseSession().query(condition, Project.class, OldQuery.getDefault());
		Set<Project> resultSet = new HashSet<Project>();
		for (Project p : results.values()) {
			if (p.getParent() == null || !onlyTopLevel) {
				resultSet.add(p);
			}
		}
		for (Project project : results.values()) {
			addParentProjects(resultSet, project);
		}
		return resultSet;
	}

	private void addParentProjects(Set<Project> resultSet, Project project) {
		if (project.getParent() != null) {
			if (!resultSet.contains(project.getParent())) {
				if ((project.getParent() != null && project.getParent().getParent() == null) || !onlyTopLevel) {
					resultSet.add(project.getParent());
				}
			}
			addParentProjects(resultSet, project.getParent());
		}
	}
}