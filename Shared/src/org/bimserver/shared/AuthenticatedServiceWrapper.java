package org.bimserver.shared;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;

public class AuthenticatedServiceWrapper {
	private final ServiceInterface service;
	private final Token token;
	private final SUser user;

	public AuthenticatedServiceWrapper(ServiceInterface service, Token token, boolean admin) throws UserException {
		this.service = service;
		this.token = token;
		if (admin) {
			this.user = service.getUserByUserName(token, "admin");
		} else {
			this.user = service.getUserOfToken(token);
		}
	}

	public SUser getCurrentUser() {
		return user;
	}

	public SProject addProject(String name) throws UserException {
		return service.addProject(token, name);
	}

	public SProject addProject(String name, long parentPoid) throws UserException {
		return service.addProjectAsSubProject(token, name, parentPoid);
	}

	public long addUser(String username, String password, String name) throws UserException {
		return service.addUser(token, username, password, name);
	}

	public CheckinResult checkinSync(long poid, String comment, long fileSize, DataHandler ifcFile) throws UserException {
		return service.checkinSync(token, poid, comment, fileSize, ifcFile);
	}

	public CheckinResult checkinAsync(long poid, String comment, long fileSize, DataHandler ifcFile) throws UserException {
		return service.checkinAsync(token, poid, comment, fileSize, ifcFile);
	}

	public CheckoutResult checkout(long roid, ResultType resultType) throws UserException {
		return service.checkout(token, roid, resultType);
	}

	public List<SCheckout> getAllCheckoutsOfProject(long poid) throws UserException {
		return service.getAllCheckoutsOfProject(token, poid);
	}

	public List<SProject> getAllProjects() throws UserException {
		return service.getAllProjects(token);
	}

	public List<SRevision> getAllRevisionsOfProject(long poid) throws UserException {
		return service.getAllRevisionsOfProject(token, poid);
	}

	public List<SUser> getAllUsers() throws UserException {
		return service.getAllUsers(token);
	}

	public CheckoutResult download(long roid, ResultType resultType) throws UserException {
		return service.download(token, roid, resultType);
	}

	public CheckoutResult downloadProjects(Set<Long> roids, ResultType resultType) throws UserException {
		return service.downloadProjects(token, roids, resultType);
	}

	public CheckoutResult downloadOfType(long roid, String className, ResultType resultType) throws UserException {
		return service.downloadOfType(token, roid, className, resultType);
	}

	public CheckoutResult downloadByOids(Set<Long> roids, Set<Long> oids, ResultType resultType) throws UserException {
		return service.downloadByOids(token, roids, oids, resultType);
	}

	public SUser getUserByUoid(long uoid) throws UserException {
		return service.getUserByUoid(token, uoid);
	}

	public List<SRevision> getAllRevisionsByUser(long uoid) throws UserException {
		return service.getAllRevisionsByUser(token, uoid);
	}

	public List<SCheckout> getAllCheckoutsByUser(long uoid) throws UserException {
		return service.getAllCheckoutsByUser(token, uoid);
	}

	public List<SCheckout> getAllCheckoutsOfRevision(long roid) throws UserException {
		return service.getAllCheckoutsOfRevision(token, roid);
	}

	public SRevision getRevision(long roid) throws UserException {
		return service.getRevision(token, roid);
	}

	public List<String> getAvailableClasses() throws UserException {
		return service.getAvailableClasses(token);
	}

	public void addUserToProject(long uoid, long poid) throws UserException {
		service.addUserToProject(token, uoid, poid);
	}

	public void removeUserFromProject(long uoid, long poid) throws UserException {
		service.removeUserFromProject(token, uoid, poid);
	}

	public boolean deleteProject(long poid) throws UserException {
		return service.deleteProject(token, poid);
	}

	public boolean deleteUser(long uoid) throws UserException {
		return service.deleteUser(token, uoid);
	}

	public boolean undeleteProject(long poid) throws UserException {
		return service.undeleteProject(token, poid);
	}

	public boolean undeleteUser(long uoid) throws UserException {
		return service.undeleteUser(token, uoid);
	}

	public DatabaseInformation getDatabaseInformation() throws UserException {
		return service.getDatabaseInformation(token);
	}

	public CheckoutResult downloadByGuids(Set<Long> roids, Set<String> guids, ResultType resultType) throws UserException {
		return service.downloadByGuids(token, roids, guids, resultType);
	}

	public ChangeSetResult processChangeSet(long poid, String comment, ChangeSet changeSet) throws UserException {
		return service.processChangeSet(token, changeSet, poid, comment);
	}

	public ChangeSetResult processChangeSetFile(int pid, String comment, DataHandler changeSetFile) throws UserException {
		return service.processChangeSetFile(token, pid, comment, changeSetFile);
	}

	public List<SProject> getAllNonAuthorizedProjectsOfUser(long uoid) throws UserException {
		return service.getAllNonAuthorizedProjectsOfUser(token, uoid);
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(long poid) throws UserException {
		return service.getAllNonAuthorizedUsersOfProject(token, poid);
	}

	public List<SUser> getAllAuthorizedUsersOfProject(long poid) throws UserException {
		return service.getAllAuthorizedUsersOfProject(token, poid);
	}

	public SUser getLoggedInUser() throws UserException {
		return service.getLoggedInUser(token);
	}

	public void logout() {
		service.logout(token);
	}

	public boolean changePassword(long uoid, String oldPassword, String newPassword) throws UserException {
		return service.changePassword(token, uoid, oldPassword, newPassword);
	}

	public void updateProject(SProject sProject) throws UserException {
		service.updateProject(token, sProject);
	}

	public void updateRevision(SRevision sRevision) throws UserException {
		service.updateRevision(token, sRevision);
	}

	public SCompareResult compare(long roid1, long roid2) throws UserException {
		return service.compare(token, user.getOid(), roid1, roid2);
	}

	public SRevisionSummary getRevisionSummary(long roid) throws UserException {
		return service.getRevisionSummary(token, roid);
	}

	public boolean userHasCheckinRights(long poid) throws UserException {
		return service.userHasCheckinRights(token, user.getOid(), poid);
	}

	public String getShowCheckoutWarning(long poid, long uoid) throws UserException {
		return service.getShowCheckoutWarning(token, poid, uoid);
	}

	public boolean userHasRights(long poid) throws UserException {
		return service.userHasRights(token, poid);
	}

	public DataObject getDataObjectByOid(long roid, long oid, String className) throws UserException {
		return service.getDataObjectByOid(token, roid, oid, className);
	}

	public DataObject getDataObjectByGuid(long roid, String guid) throws UserException {
		return service.getDataObjectByGuid(token, roid, guid);
	}

	public List<DataObject> getDataObjectsByType(long roid, String className) throws UserException {
		return service.getDataObjectsByType(token, roid, className);
	}

	public String resetPassword(String emailAddress) throws UserException {
		return service.resetPassword(token, emailAddress);
	}

	public List<SGuidClash> findClashesByGuid(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		return service.findClashesByGuid(token, sClashDetectionSettings);
	}

	public List<SEidClash> findClashesByEid(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		return service.findClashesByEid(token, sClashDetectionSettings);
	}

	public CheckinResult branch(long roid, String projectName, String comment) throws UserException {
		return service.branchToNewProject(token, roid, projectName, comment);
	}

	public CheckinResult branch(long roid, long destPoid, String comment) throws UserException {
		return service.branchToExistingProject(token, roid, destPoid, comment);
	}

	public List<SLogAction> getLogs() throws UserException {
		return service.getLogs(token);
	}

	public SGeoTag getGeoTag(long goid) throws UserException {
		return service.getGeoTag(token, goid);
	}

	public void updateGeoTag(SGeoTag geoTag) throws UserException {
		service.updateGeoTag(token, geoTag);
	}

	public SClashDetectionSettings getClashDetectionSettings(long cdsoid) throws UserException {
		return service.getClashDetectionSettings(token, cdsoid);
	}

	public void updateClashDetectionSettings(SClashDetectionSettings sClashDetectionSettings) throws UserException {
		service.updateClashDetectionSettings(token, sClashDetectionSettings);
	}

	public List<SProject> getUsersProjects(long uoid) {
		return service.getUsersProjects(token, uoid);
	}

	public SProject getProjectByPoid(long poid) throws UserException {
		return service.getProjectByPoid(token, poid);
	}

	public SUser getAnonymousUser() {
		return service.getAnonymousUser(token);
	}

	public SUser getUserByUsername(String username) throws UserException {
		return service.getUserByUserName(token, username);
	}

	public void setRevisionTag(long roid, String tag) throws UserException {
		service.setRevisionTag(token,roid, tag);
	}
	
	public List<SProject> getSubProjects(long poid) throws UserException {
		return service.getSubProjects(token, poid);
	}
	
	public void changeUserType(long uoid, SUserType userType) throws UserException {
		service.changeUserType(token, uoid, userType);
	}
}