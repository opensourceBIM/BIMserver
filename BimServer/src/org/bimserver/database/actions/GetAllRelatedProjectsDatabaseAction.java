package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class GetAllRelatedProjectsDatabaseAction extends BimDatabaseAction<List<SProjectSmall>> {

	private Long poid;

	public GetAllRelatedProjectsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long poid) {
		super(databaseSession, accessMethod);
		this.poid = poid;
	}

	@Override
	public List<SProjectSmall> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<SProjectSmall> list = new ArrayList<SProjectSmall>();
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
		Project rootProject = getRootProject(project);
		addProjects(list, rootProject);
		return list;
	}
	
	private Project getRootProject(Project project) {
		if (project.getParent() != null) {
			return getRootProject(project.getParent());
		} else {
			return project;
		}
	}
	
	private void addProjects(List<SProjectSmall> list, Project project) {
		list.add(createSmallProject(project));
		List<Project> subProjects = new ArrayList<Project>(project.getSubProjects());
		Collections.sort(subProjects, new Comparator<Project>(){
			@Override
			public int compare(Project o1, Project o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		for (Project subProject : subProjects) {
			addProjects(list, subProject);
		}
	}
	
	private SProjectSmall createSmallProject(Project project) {
		SProjectSmall small = new SProjectSmall();
		small.setName(project.getName());
		small.setOid(project.getOid());
		small.setParentId(project.getParent() == null ? -1 : project.getParent().getOid());
		return small;
	}
}