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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToInCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfProjectDatabaseAction extends BimDatabaseAction<List<Checkout>> {

	private final long poid;
	private final boolean checkSubProjects;

	public GetAllCheckoutsOfProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, boolean checkSubProjects) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.checkSubProjects = checkSubProjects;
	}

	@Override
	public List<Checkout> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		Set<Project> projects = new HashSet<Project>();
		if (checkSubProjects) {
			getSubProjects(project, projects);
		} else {
			projects.add(project);
		}
		Condition condition = new HasReferenceToInCondition(StorePackage.eINSTANCE.getCheckout_Project(), projects);
		Map<Long, Checkout> query = getDatabaseSession().query(condition, Checkout.class, OldQuery.getDefault());
		return CollectionUtils.mapToList(query);
	}
	
	private void getSubProjects(Project project, Set<Project> projects) {
		projects.add(project);
		Iterator<Project> iterator = project.getSubProjects().iterator();
		while (iterator.hasNext()) {
			Project subProject = iterator.next();
			getSubProjects(subProject, projects);
		}
	}
}