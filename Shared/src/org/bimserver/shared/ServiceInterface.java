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
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
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
import org.bimserver.interfaces.objects.SUserType;

//TODO: Document the rest of the interface
/**
 * This interface defines all functions that are made available via SOAP, but also used by the JSP web interface
 */
@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)
public interface ServiceInterface {
	/** This method exists only to test the underlying connection (such as SOAP)
	 *  
	 * @param in The String value ping should return
	 * @return Returns the original String value
	 */
	@WebMethod(action="ping") String ping(@WebParam(name="in") String in);
	/** Checks the given username and password with the internal database. Then a valid user is found, a new Token will be issued.
	 *  
	 * @param username
	 * @param password
	 * @return The new token when a successfull login attempt has been made, or null When the username does not exist, or the given password is incorrect
	 * @throws UserException
	 */
	@WebMethod(action="login") Token login(@WebParam(name="username") String username, @WebParam(name="password") String password) throws UserException;
	@WebMethod(action="autologin")Token autologin(@WebParam(name="username") String username, @WebParam(name="hash") String hash) throws UserException;
	@WebMethod(action="checkinSync")CheckinResult checkinSync(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="fileSize") long fileSize, @WebParam(name="ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	@WebMethod(action="checkinAsync")CheckinResult checkinAsync(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="fileSize") long fileSize, @WebParam(name="ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	@WebMethod(action="checkout")CheckoutResult checkout(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="resultType")ResultType resultType) throws UserException;
	@WebMethod(action="checkoutLastRevision")CheckoutResult checkoutLastRevision(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="download")CheckoutResult download(@WebParam(name="token") Token token, @WebParam(name="username") long roid, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="downloadByOids")CheckoutResult downloadByOids(@WebParam(name="token") Token token, @WebParam(name="roids") Set<Long> roids, @WebParam(name="oids") Set<Long> oids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="downloadOfType")CheckoutResult downloadOfType(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="className") String className, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="downloadByGuids")CheckoutResult downloadByGuids(@WebParam(name="token") Token token, @WebParam(name="roids")Set<Long> roids, @WebParam(name="guids") Set<String> guids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="downloadProjects")CheckoutResult downloadProjects(@WebParam(name="token") Token token, @WebParam(name="roids") Set<Long> roids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	@WebMethod(action="addUser")long addUser(@WebParam(name="token") Token token, @WebParam(name="username") String username, @WebParam(name="password")String password, @WebParam(name="name") String name) throws UserException;
	@WebMethod(action="changeUserType")void changeUserType(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="userType") SUserType userType) throws UserException;
	@WebMethod(action="addProject")SProject addProject(@WebParam(name="token") Token token, @WebParam(name="projectName") String projectName) throws UserException;
	@WebMethod(action="addProjectAsSubProject")SProject addProjectAsSubProject(@WebParam(name="token") Token token, @WebParam(name="projectName") String projectName, @WebParam(name="parentPoid") long parentPoid) throws UserException;
	@WebMethod(action="updateProject")void updateProject(@WebParam(name="token") Token token, @WebParam(name="sProject") SProject sProject) throws UserException;
	@WebMethod(action="updateRevision")void updateRevision(@WebParam(name="token") Token token, @WebParam(name="sRevision") SRevision sRevision) throws UserException;
	@WebMethod(action="addUserToProject")boolean addUserToProject(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="removeUserFromProject")boolean removeUserFromProject(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="deleteProject")boolean deleteProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="deleteUser")boolean deleteUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="getAllProjects")List<SProject> getAllProjects(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="getAllUsers")List<SUser> getAllUsers(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="getAllRevisionsOfProject")List<SRevision> getAllRevisionsOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getAllCheckoutsOfProject")List<SCheckout> getAllCheckoutsOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getAllRevisionsByUser")List<SRevision> getAllRevisionsByUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="getAllCheckoutsByUser")List<SCheckout> getAllCheckoutsByUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="getAllCheckoutsOfRevision")List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	@WebMethod(action="getProjectByPoid")SProject getProjectByPoid(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getRevision")SRevision getRevision(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	@WebMethod(action="processChangeSet")ChangeSetResult processChangeSet(@WebParam(name="token") Token token, @WebParam(name="changeSet") ChangeSet changeSet, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment) throws UserException;
	@WebMethod(action="getAvailableClasses")List<String> getAvailableClasses(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="getDatabaseInformation")DatabaseInformation getDatabaseInformation(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="createAnonymousToken")Token createAnonymousToken() throws UserException;
	@WebMethod(action="processChangeSetFile")ChangeSetResult processChangeSetFile(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="changeSetFile") @XmlMimeType("application/octet-stream") DataHandler changeSetFile) throws UserException;
	@WebMethod(action="getLoggedInUser")SUser getLoggedInUser(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="getAllNonAuthorizedProjectsOfUser")List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="getUserOfToken")SUser getUserOfToken(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="logout")void logout(@WebParam(name="token") Token token);
	@WebMethod(action="changePassword")boolean changePassword(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="oldPassword") String oldPassword, @WebParam(name="newPassword") String newPassword) throws UserException;
	@WebMethod(action="getUserByUserName")SUser getUserByUserName(@WebParam(name="token") Token token, @WebParam(name="username") String username) throws UserException;
	@WebMethod(action="undeleteProject")boolean undeleteProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="undeleteUser")boolean undeleteUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="compare")SCompareResult compare(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="roid1") long roid1, @WebParam(name="roid2") long roid2) throws UserException;
	@WebMethod(action="getRevisionSummary")SRevisionSummary getRevisionSummary(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	@WebMethod(action="userHasCheckinRights")boolean userHasCheckinRights(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getShowCheckoutWarning")String getShowCheckoutWarning(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="uoid") long uoid) throws UserException;
	@WebMethod(action="userHasRights")boolean userHasRights(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getDataObjectByOid")DataObject getDataObjectByOid(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="oid") long oid, @WebParam(name="className") String className) throws UserException;
	@WebMethod(action="getDataObjectByGuid")DataObject getDataObjectByGuid(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="guid") String guid) throws UserException;
	@WebMethod(action="getDataObjectsByType")List<DataObject> getDataObjectsByType(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="className") String className) throws UserException;
	@WebMethod(action="findClashesByGuid")List<SGuidClash> findClashesByGuid(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	@WebMethod(action="findClashesByEid")List<SEidClash> findClashesByEid(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	@WebMethod(action="getLastClashes")List<SClash> getLastClashes(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	@WebMethod(action="resetPassword")String resetPassword(@WebParam(name="token") Token token, @WebParam(name="emailAddress") String emailAddress) throws UserException;
	@WebMethod(action="branchToNewProject")CheckinResult branchToNewProject(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="projectName") String projectName, @WebParam(name="comment") String comment) throws UserException;
	@WebMethod(action="branchToExistingProject")CheckinResult branchToExistingProject(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="destPoid") long destPoid, @WebParam(name="comment") String comment) throws UserException;
	@WebMethod(action="getLogs")List<SLogAction> getLogs(@WebParam(name="token") Token token) throws UserException;
	@WebMethod(action="getGeoTag")SGeoTag getGeoTag(@WebParam(name="token") Token token, @WebParam(name="goid") long goid) throws UserException;
	@WebMethod(action="updateGeoTag")void updateGeoTag(@WebParam(name="token") Token token, @WebParam(name="sGeoTag") SGeoTag sGeoTag) throws UserException;
	@WebMethod(action="getClashDetectionSettings")SClashDetectionSettings getClashDetectionSettings(@WebParam(name="token") Token token, @WebParam(name="cdsoid") long cdsoid) throws UserException;
	@WebMethod(action="updateClashDetectionSettings")void updateClashDetectionSettings(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	@WebMethod(action="getUserByUoid")SUser getUserByUoid(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid);
	@WebMethod(action="getAnonymousUser")SUser getAnonymousUser(@WebParam(name="token") Token token);
	@WebMethod(action="getAllNonAuthorizedUsersOfProject")List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getAllAuthorizedUsersOfProject")List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	@WebMethod(action="getUsersProjects")List<SProject> getUsersProjects(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid);
	@WebMethod(action="getProjectByName")List<SProject> getProjectByName(@WebParam(name="token") Token token, @WebParam(name="name") String name) throws UserException;
	@WebMethod(action="setRevisionTag")void setRevisionTag(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="tag") String tag) throws UserException;
	@WebMethod(action="getSubProjects")List<SProject> getSubProjects(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
}