package org.bimserver.webservices;

import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class Authorization {
	private long uoid = -1;
	
	public Authorization() {
	}
	
	public Authorization(long uoid) {
		this.uoid = uoid;
	}
	
	public long getUoid() {
		return uoid;
	}
	
	public void setUoid(long uoid) {
		this.uoid = uoid;
	}

	public void canDownload(long roid) throws UserException {
	}

	public void canCheckin(long poid) throws UserException {
	}

	public void canReadExtendedData(long roid) throws UserException {
	}

	public void canWriteExtendedData(long roid) throws UserException {
	}
	
	public boolean hasRightsOnProjectOrSuperProjectsOrSubProjects(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		while (project != null) {
			if (hasRightsOnProjectOrSubProjects(user, project)) {
				return true;
			}
			project = project.getParent();
		}
		return false;
	}
	
	public boolean hasRightsOnProjectOrSuperProjects(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		if (hasRightsOnProject(user, project)) {
			return true;
		}
		if (project.getParent() != null) {
			if (hasRightsOnProjectOrSuperProjects(user, project.getParent())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasRightsOnProjectOrSubProjects(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		if (hasRightsOnProject(user, project)) {
			return true;
		}
		for (Project subProject : project.getSubProjects()) {
			if (hasRightsOnProjectOrSubProjects(user, subProject)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasRightsOnProject(User user, Project project) {
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.SYSTEM) {
			return true;
		}
		for (User authorizedUser : project.getHasAuthorizedUsers()) {
			if (authorizedUser == user) {
				return true;
			}
		}
		return false;
	}
}