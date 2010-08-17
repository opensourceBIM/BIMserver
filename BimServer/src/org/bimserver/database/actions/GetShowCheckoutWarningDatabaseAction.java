package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetShowCheckoutWarningDatabaseAction extends BimDatabaseAction<String> {

	private final long poid;
	private final long uoid;

	public GetShowCheckoutWarningDatabaseAction(AccessMethod accessMethod, long poid, long uoid) {
		super(accessMethod);
		this.poid = poid;
		this.uoid = uoid;
	}

	@Override
	public String execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		User user = bimDatabaseSession.getUserByUoid(uoid);
		Checkout lastCheckout = null;
		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user && checkout.isActive()) {
				lastCheckout = checkout;
			}
		}
		if (lastCheckout != null) {
			Project mainProject = project;
			while (mainProject.getParent() != null) {
				mainProject = mainProject.getParent();
			}
			for (Revision virtualRevision : mainProject.getRevisions()) {
				if (lastCheckout.getRevision().getDate().before(virtualRevision.getDate()) && lastCheckout.getRevision() != virtualRevision) {
					String warning = "Warning, after your last checkout of this project (revision " + lastCheckout.getRevision().getId() + "), at least one other user has checked-in a newer revision";
					return warning;
				}
			}
		}
		for (Project p : getAllRelatedProjects(project)) {
			for (Checkout checkout : p.getCheckouts()) {
				if (checkout.isActive() && checkout.getUser() != user) {
					String warning = "Warning, another using is possibly working on this model because there is at least one active checkout";
					return warning;
				}
			}
		}
		return null;
	}
	
	private Set<Project> getAllRelatedProjects(Project project) {
		Set<Project> projects = new HashSet<Project>();
		getAllRelatedProjects(projects, project);
		return projects;
	}
	
	private void getAllRelatedProjects(Set<Project> projects, Project project) {
		if (projects.contains(project)) {
			return;
		}
		projects.add(project);
		if (project.getParent() != null) {
			getAllRelatedProjects(projects, project.getParent());
		}
		for (Project subProject : project.getSubProjects()) {
			getAllRelatedProjects(projects, subProject);
		}
	}
}