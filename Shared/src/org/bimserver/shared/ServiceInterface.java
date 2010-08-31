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
import javax.xml.bind.annotation.XmlMimeType;

import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;

//TODO: Document the rest of the interface
/**
 * This interface defines all functions that are made available via SOAP, but also used by the JSP web interface
 */
public interface ServiceInterface {
	/** This method exists only to test the underlying connection (such as SOAP)
	 *  
	 * @param in The String value ping should return
	 * @return Returns the original String value
	 */
	String ping(String in);
	/** Checks the given username and password with the internal database. Then a valid user is found, a new Token will be issued.
	 *  
	 * @param username
	 * @param password
	 * @return The new token when a succesfull login attempt has been made, or null When the username does not exist, or the given password is incorrect
	 * @throws UserException
	 */
	Token login(String username, String password) throws UserException;
	Token autologin(String username, String hash) throws UserException;
	CheckinResult checkinSync(Token token, long poid, String comment, long fileSize, @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	CheckinResult checkinAsync(Token token, long poid, String comment, long fileSize, @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	CheckoutResult checkout(Token token, long roid, ResultType resultType) throws UserException;
	CheckoutResult checkoutLastRevision(Token token, long poid, ResultType resultType) throws UserException;
	CheckoutResult download(Token token, long roid, ResultType resultType) throws UserException;
	CheckoutResult downloadByOids(Token token, Set<Long> roids, Set<Long> oids, ResultType resultType) throws UserException;
	CheckoutResult downloadOfType(Token token, long roid, String className, ResultType resultType) throws UserException;
	CheckoutResult downloadByGuids(Token token, Set<Long> roids, Set<String> guids, ResultType resultType) throws UserException;
	CheckoutResult downloadProjects(Token token, Set<Long> roids, ResultType resultType) throws UserException;
	long addUser(Token token, String username, String password, String name) throws UserException;
	SProject addProject(Token token, String projectName) throws UserException;
	SProject addProject(Token token, String projectName, long parentPoid) throws UserException;
	void updateProject(Token token, SProject sProject) throws UserException;
	void updateRevision(Token token, SRevision sRevision) throws UserException;
	boolean addUserToProject(Token token, long uoid, long poid) throws UserException;
	boolean removeUserFromProject(Token token, long uoid, long poid) throws UserException;
	boolean deleteProject(Token token, long poid) throws UserException;
	boolean deleteUser(Token token, long uoid) throws UserException;
	List<SProject> getAllProjects(Token token) throws UserException;
	List<SUser> getAllUsers(Token token) throws UserException;
	List<SRevision> getAllRevisionsOfProject(Token token, long poid) throws UserException;
	List<SCheckout> getAllCheckoutsOfProject(Token token, long poid) throws UserException;
	List<SRevision> getAllRevisionsByUser(Token token, long uoid) throws UserException;
	List<SCheckout> getAllCheckoutsByUser(Token token, long uoid) throws UserException;
	List<SCheckout> getAllCheckoutsOfRevision(Token token, long roid) throws UserException;
	SProject getProjectByPoid(Token token, long poid) throws UserException;
	SRevision getRevision(Token token, long roid) throws UserException;
	ChangeSetResult processChangeSet(Token token, ChangeSet changeSet, long poid, String comment) throws UserException;
	List<String> getAvailableClasses(Token token) throws UserException;
	DatabaseInformation getDatabaseInformation(Token token) throws UserException;
	Token createAnonymousToken() throws UserException;
	ChangeSetResult processChangeSetFile(Token token, long poid, String comment, @XmlMimeType("application/octet-stream") DataHandler changeSetFile) throws UserException;
	SUser getLoggedInUser(Token token) throws UserException;
	List<SProject> getAllNonAuthorizedProjectsOfUser(Token token, long uoid) throws UserException;
	SUser getUserOfToken(Token token) throws UserException;
	void logout(Token token);
	boolean changePassword(Token token, long uoid, String oldPassword, String newPassword) throws UserException;
	SUser getUserByUserName(String username) throws UserException;
	boolean undeleteProject(Token token, long poid) throws UserException;
	boolean undeleteUser(Token token, long uoid) throws UserException;
	SCompareResult compare(Token token, long uoid, long roid1, long roid2) throws UserException;
	SRevisionSummary getRevisionSummary(Token token, long roid) throws UserException;
	boolean userHasCheckinRights(Token token, long uoid, long poid) throws UserException;
	String getShowCheckoutWarning(Token token, long poid, long uoid) throws UserException;
	boolean userHasRights(Token token, long poid) throws UserException;
	DataObject getDataObjectByOid(Token token, long roid, long oid, String className) throws UserException;
	DataObject getDataObjectByGuid(Token token, long roid, String guid) throws UserException;
	List<DataObject> getDataObjectsByType(Token token, long roid, String className) throws UserException;
	List<SGuidClash> findClashesByGuid(Token token, SClashDetectionSettings sClashDetectionSettings) throws UserException;
	List<SEidClash> findClashesByEid(Token token, SClashDetectionSettings sClashDetectionSettings) throws UserException;
	List<SClash> getLastClashes(Token token, long roid) throws UserException;
	String resetPassword(String emailAddress) throws UserException;
	CheckinResult branchToNewProject(Token token, long roid, String projectName, String comment) throws UserException;
	CheckinResult branchToExistingProject(Token token, long roid, long destPoid, String comment) throws UserException;
	List<SLogAction> getLogs(Token token) throws UserException;
	SGeoTag getGeoTag(Token token, long goid) throws UserException;
	void updateGeoTag(Token token, SGeoTag sGeoTag) throws UserException;
	SClashDetectionSettings getClashDetectionSettings(Token token, long cdsoid) throws UserException;
	void updateClashDetectionSettings(Token token, SClashDetectionSettings sClashDetectionSettings) throws UserException;
	SUser getUserByUoid(Token token, long uoid);
	SUser getAnonymousUser(Token token);
	List<SUser> getAllNonAuthorizedUsersOfProject(Token token, long poid) throws UserException;
	List<SUser> getAllAuthorizedUsersOfProject(Token token, long poid) throws UserException;
	List<SProject> getUsersProjects(long uoid);
	List<SProject> getProjectByName(String name) throws UserException;
	void setRevisionTag(long roid, String tag) throws UserException;
	List<SProject> getSubProjects(Token token, long poid) throws UserException;
}