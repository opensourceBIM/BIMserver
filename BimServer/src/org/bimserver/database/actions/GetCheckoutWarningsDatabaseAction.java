package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.UserException;

public class GetCheckoutWarningsDatabaseAction extends BimDatabaseAction<Set<String>> {

	private final long poid;
	private final long uoid;

	public GetCheckoutWarningsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.poid = poid;
		this.uoid = uoid;
	}

	@Override
	public Set<String> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(uoid);
		Set<String> warnings = new HashSet<String>();
		checkInterleavingCommits(project, user, warnings);
		checkOtherUsersCheckouts(project, user, warnings);
		return warnings;
	}

	private void checkInterleavingCommits(Project project, User user, Set<String> warnings) {
		Checkout lastOwnActiveCheckout = null;
		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user && checkout.isActive()) {
				lastOwnActiveCheckout = checkout;
			}
		}
		if (lastOwnActiveCheckout != null) {
			Project mainProject = project;
			while (mainProject.getParent() != null) {
				mainProject = mainProject.getParent();
			}
			int newRevisionsAfterCheckout = 0;
			for (Revision virtualRevision : mainProject.getRevisions()) {
				if (lastOwnActiveCheckout.getDate().before(virtualRevision.getDate()) && lastOwnActiveCheckout.getRevision() != virtualRevision) {
					newRevisionsAfterCheckout++;
				}
			}
			if (newRevisionsAfterCheckout == 1) {
				warnings.add("Warning, after your last checkout of this project (revision " + lastOwnActiveCheckout.getRevision().getId() + "), a new revision has been checked-in");
			} else if (newRevisionsAfterCheckout > 1) {
				warnings.add("Warning, after your last checkout of this project (revision " + lastOwnActiveCheckout.getRevision().getId() + "), " + newRevisionsAfterCheckout + " new revisions have been checked-in");
			}
		}
	}

	private void checkOtherUsersCheckouts(Project project, User user, Set<String> warnings) {
		int activeCheckouts = 0;
		for (Project p : getAllRelatedProjects(project)) {
			for (Checkout checkout : p.getCheckouts()) {
				if (checkout.isActive() && checkout.getUser() != user) {
					activeCheckouts++;
				}
			}
		}
		if (activeCheckouts == 1) {
			warnings.add("Warning, another user is possibly working on this model because there is one active checkout");
		} else if (activeCheckouts > 1) {
			warnings.add("Warning, other users are possibly working on this model because there are " + activeCheckouts + " active checkouts");
		}
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