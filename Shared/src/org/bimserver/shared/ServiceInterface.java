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

//TODO: Document the rest of the interface
/**
 * This interface defines all functions that are made available via SOAP, but also used by the JSP web interface
 */
@WebService
@SOAPBinding(style=Style.RPC, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)
public interface ServiceInterface {
	/** This method exists only to test the underlying connection (such as SOAP)
	 *  
	 * @param in The String value ping should return
	 * @return Returns the original String value
	 */
	String ping(@WebParam(name="in") String in);
	/** Checks the given username and password with the internal database. Then a valid user is found, a new Token will be issued.
	 *  
	 * @param username
	 * @param password
	 * @return The new token when a succesfull login attempt has been made, or null When the username does not exist, or the given password is incorrect
	 * @throws UserException
	 */
	@WebMethod Token login(@WebParam(name="username") String username, @WebParam(name="password") String password) throws UserException;
	Token autologin(@WebParam(name="username") String username, @WebParam(name="hash") String hash) throws UserException;
	CheckinResult checkinSync(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="fileSize") long fileSize, @WebParam(name="ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	CheckinResult checkinAsync(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="fileSize") long fileSize, @WebParam(name="ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;
	CheckoutResult checkout(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="resultType")ResultType resultType) throws UserException;
	CheckoutResult checkoutLastRevision(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="resultType") ResultType resultType) throws UserException;
	CheckoutResult download(@WebParam(name="token") Token token, @WebParam(name="username") long roid, @WebParam(name="resultType") ResultType resultType) throws UserException;
	CheckoutResult downloadByOids(@WebParam(name="token") Token token, @WebParam(name="roids") Set<Long> roids, @WebParam(name="oids") Set<Long> oids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	CheckoutResult downloadOfType(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="className") String className, @WebParam(name="resultType") ResultType resultType) throws UserException;
	CheckoutResult downloadByGuids(@WebParam(name="token") Token token, @WebParam(name="roids")Set<Long> roids, @WebParam(name="guids") Set<String> guids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	CheckoutResult downloadProjects(@WebParam(name="token") Token token, @WebParam(name="roids") Set<Long> roids, @WebParam(name="resultType") ResultType resultType) throws UserException;
	long addUser(@WebParam(name="token") Token token, @WebParam(name="username") String username, @WebParam(name="password")String password, @WebParam(name="name") String name) throws UserException;
	SProject addProject(@WebParam(name="token") Token token, @WebParam(name="projectName") String projectName) throws UserException;
	SProject addProjectAsSubProject(@WebParam(name="token") Token token, @WebParam(name="projectName") String projectName, @WebParam(name="parentPoid") long parentPoid) throws UserException;
	void updateProject(@WebParam(name="token") Token token, @WebParam(name="sProject") SProject sProject) throws UserException;
	void updateRevision(@WebParam(name="token") Token token, @WebParam(name="sRevision") SRevision sRevision) throws UserException;
	boolean addUserToProject(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	boolean removeUserFromProject(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	boolean deleteProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	boolean deleteUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	List<SProject> getAllProjects(@WebParam(name="token") Token token) throws UserException;
	List<SUser> getAllUsers(@WebParam(name="token") Token token) throws UserException;
	List<SRevision> getAllRevisionsOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	List<SCheckout> getAllCheckoutsOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	List<SRevision> getAllRevisionsByUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	List<SCheckout> getAllCheckoutsByUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	SProject getProjectByPoid(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	SRevision getRevision(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	ChangeSetResult processChangeSet(@WebParam(name="token") Token token, @WebParam(name="changeSet") ChangeSet changeSet, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment) throws UserException;
	List<String> getAvailableClasses(@WebParam(name="token") Token token) throws UserException;
	DatabaseInformation getDatabaseInformation(@WebParam(name="token") Token token) throws UserException;
	Token createAnonymousToken() throws UserException;
	ChangeSetResult processChangeSetFile(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="comment") String comment, @WebParam(name="changeSetFile") @XmlMimeType("application/octet-stream") DataHandler changeSetFile) throws UserException;
	SUser getLoggedInUser(@WebParam(name="token") Token token) throws UserException;
	List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	SUser getUserOfToken(@WebParam(name="token") Token token) throws UserException;
	void logout(@WebParam(name="token") Token token);
	boolean changePassword(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="oldPassword") String oldPassword, @WebParam(name="newPassword") String newPassword) throws UserException;
	SUser getUserByUserName(@WebParam(name="token") Token token, @WebParam(name="username") String username) throws UserException;
	boolean undeleteProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	boolean undeleteUser(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid) throws UserException;
	SCompareResult compare(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="roid1") long roid1, @WebParam(name="roid2") long roid2) throws UserException;
	SRevisionSummary getRevisionSummary(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	boolean userHasCheckinRights(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid, @WebParam(name="poid") long poid) throws UserException;
	String getShowCheckoutWarning(@WebParam(name="token") Token token, @WebParam(name="poid") long poid, @WebParam(name="uoid") long uoid) throws UserException;
	boolean userHasRights(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	DataObject getDataObjectByOid(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="oid") long oid, @WebParam(name="className") String className) throws UserException;
	DataObject getDataObjectByGuid(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="guid") String guid) throws UserException;
	List<DataObject> getDataObjectsByType(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="className") String className) throws UserException;
	List<SGuidClash> findClashesByGuid(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	List<SEidClash> findClashesByEid(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	List<SClash> getLastClashes(@WebParam(name="token") Token token, @WebParam(name="roid") long roid) throws UserException;
	String resetPassword(@WebParam(name="token") Token token, @WebParam(name="emailAddress") String emailAddress) throws UserException;
	CheckinResult branchToNewProject(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="projectName") String projectName, @WebParam(name="comment") String comment) throws UserException;
	CheckinResult branchToExistingProject(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="destPoid") long destPoid, @WebParam(name="comment") String comment) throws UserException;
	List<SLogAction> getLogs(@WebParam(name="token") Token token) throws UserException;
	SGeoTag getGeoTag(@WebParam(name="token") Token token, @WebParam(name="goid") long goid) throws UserException;
	void updateGeoTag(@WebParam(name="token") Token token, @WebParam(name="sGeoTag") SGeoTag sGeoTag) throws UserException;
	SClashDetectionSettings getClashDetectionSettings(@WebParam(name="token") Token token, @WebParam(name="cdsoid") long cdsoid) throws UserException;
	void updateClashDetectionSettings(@WebParam(name="token") Token token, @WebParam(name="sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws UserException;
	SUser getUserByUoid(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid);
	SUser getAnonymousUser(@WebParam(name="token") Token token);
	List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
	List<SProject> getUsersProjects(@WebParam(name="token") Token token, @WebParam(name="uoid") long uoid);
	List<SProject> getProjectByName(@WebParam(name="token") Token token, @WebParam(name="name") String name) throws UserException;
	void setRevisionTag(@WebParam(name="token") Token token, @WebParam(name="roid") long roid, @WebParam(name="tag") String tag) throws UserException;
	List<SProject> getSubProjects(@WebParam(name="token") Token token, @WebParam(name="poid") long poid) throws UserException;
}