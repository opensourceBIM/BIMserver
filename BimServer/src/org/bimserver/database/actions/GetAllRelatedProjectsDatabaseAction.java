package org.bimserver.database.actions;

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