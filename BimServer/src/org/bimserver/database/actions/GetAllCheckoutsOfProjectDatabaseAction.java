package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToInCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllCheckoutsOfProjectDatabaseAction extends BimDatabaseAction<Set<Checkout>> {

	private final long poid;
	private final boolean checkSubProjects;

	public GetAllCheckoutsOfProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, boolean checkSubProjects) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
		this.checkSubProjects = checkSubProjects;
	}

	@Override
	public Set<Checkout> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectByPoid(poid);
		Set<Project> projects = new HashSet<Project>();
		if (checkSubProjects) {
			getSubProjects(project, projects);
		} else {
			projects.add(project);
		}
		Condition condition = new HasReferenceToInCondition(StorePackage.eINSTANCE.getCheckout_Project(), projects);
		Map<Long, Checkout> query = (Map<Long, Checkout>) getDatabaseSession().query(condition, Checkout.class, false);
		return CollectionUtils.mapToSet(query);
	}
	
	private void getSubProjects(Project project, Set<Project> projects) {
		projects.add(project);
		for (Project subProject : project.getSubProjects()) {
			getSubProjects(subProject, projects);
		}
	}
}