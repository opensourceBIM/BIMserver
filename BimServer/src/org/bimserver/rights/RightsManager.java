package org.bimserver.rights;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;

public class RightsManager {
	
	public static boolean hasRightsOnProjectOrSuperProjectsOrSubProjects(User user, Project project) {
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
	
	public static boolean hasRightsOnProjectOrSuperProjects(User user, Project project) {
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
	
	public static boolean hasRightsOnProjectOrSubProjects(User user, Project project) {
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
	
	public static boolean hasRightsOnProject(User user, Project project) {
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