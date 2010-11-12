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

import java.util.Date;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
 * This interface defines all functions that are made available via SOAP, but
 * also used by the JSP web interface
 */
@WebService(name="soap")
@Path("/")
@Produces("application/xml")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
public interface ServiceInterface {
	@GET
	@Path("/ping")
	@Produces("application/text")
	@WebMethod(action = "ping")
	String ping(@QueryParam("in") @WebParam(name = "in") String in);

	@GET
	@Path("/login")
	@Produces("application/xml")
	@WebMethod(action = "login")
	boolean login(@QueryParam("username") @WebParam(name = "username") String username, @QueryParam("password") @WebParam(name = "password") String password) throws UserException;

	@WebMethod(action = "autologin")
	boolean autologin(@WebParam(name = "username") String username, @WebParam(name = "hash") String hash) throws UserException;

	@WebMethod(action = "checkinSync")
	SCheckinResult checkinSync(@WebParam(name = "poid") long poid, @WebParam(name = "comment") String comment,
			@WebParam(name = "fileSize") long fileSize, @WebParam(name = "ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;

	@WebMethod(action = "checkinAsync")
	SCheckinResult checkinAsync(@WebParam(name = "poid") long poid, @WebParam(name = "comment") String comment,
			@WebParam(name = "fileSize") long fileSize, @WebParam(name = "ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile) throws UserException;

	@WebMethod(action = "checkout")
	SCheckoutResult checkout(@WebParam(name = "roid") long roid, @WebParam(name = "resultType") ResultType resultType) throws UserException;

	@WebMethod(action = "checkoutLastRevision")
	SCheckoutResult checkoutLastRevision(@QueryParam("poid") @WebParam(name = "poid") long poid, @QueryParam("resultType") @WebParam(name = "resultType") ResultType resultType)
			throws UserException;

	@GET
	@Path("/download")
	@Produces("application/xml")
	@WebMethod(action = "download")
	SDownloadResult download(@QueryParam("roid") @WebParam(name = "roid") long roid, @QueryParam("resultType") @WebParam(name = "resultType") ResultType resultType)
			throws UserException;

	@WebMethod(action = "downloadByOids")
	SDownloadResult downloadByOids(@WebParam(name = "roids") Set<Long> roids, @WebParam(name = "oids") Set<Long> oids,
			@WebParam(name = "resultType") ResultType resultType) throws UserException;

	@WebMethod(action = "downloadOfType")
	SDownloadResult downloadOfType(@WebParam(name = "roid") long roid, @WebParam(name = "className") String className,
			@WebParam(name = "resultType") ResultType resultType) throws UserException;

	@WebMethod(action = "downloadByGuids")
	SDownloadResult downloadByGuids(@WebParam(name = "roids") Set<Long> roids, @WebParam(name = "guids") Set<String> guids,
			@WebParam(name = "resultType") ResultType resultType) throws UserException;

	@WebMethod(action = "downloadProjects")
	SDownloadResult downloadProjects(@WebParam(name = "roids") Set<Long> roids, @WebParam(name = "resultType") ResultType resultType)
			throws UserException;

	@WebMethod(action = "addUser")
	long addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password,
			@WebParam(name = "name") String name) throws UserException;

	@WebMethod(action = "changeUserType")
	void changeUserType(@WebParam(name = "uoid") long uoid, @WebParam(name = "userType") SUserType userType) throws UserException;

	@WebMethod(action = "addProject")
	SProject addProject(@WebParam(name = "projectName") String projectName) throws UserException;

	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(@WebParam(name = "projectName") String projectName, @WebParam(name = "parentPoid") long parentPoid)
			throws UserException;

	@WebMethod(action = "updateProject")
	void updateProject(@WebParam(name = "sProject") SProject sProject) throws UserException;

	@WebMethod(action = "updateRevision")
	void updateRevision(@WebParam(name = "sRevision") SRevision sRevision) throws UserException;

	@WebMethod(action = "addUserToProject")
	boolean addUserToProject(@WebParam(name = "uoid") long uoid, @WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "removeUserFromProject")
	boolean removeUserFromProject(@WebParam(name = "uoid") long uoid, @WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "deleteProject")
	boolean deleteProject(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "deleteUser")
	boolean deleteUser(@WebParam(name = "uoid") long uoid) throws UserException;

	@GET
	@Path("/getAllProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws UserException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws UserException;

	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces("application/xml")
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(@QueryParam("poid") @WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(@WebParam(name = "uoid") long uoid) throws UserException;

	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(@WebParam(name = "uoid") long uoid) throws UserException;

	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name = "roid") long roid) throws UserException;

	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getRevision")
	SRevision getRevision(@WebParam(name = "roid") long roid) throws UserException;

	@WebMethod(action = "processChangeSet")
	ChangeSetResult processChangeSet(@WebParam(name = "changeSet") ChangeSet changeSet, @WebParam(name = "poid") long poid,
			@WebParam(name = "comment") String comment) throws UserException;

	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws UserException;

	@WebMethod(action = "getDatabaseInformation")
	DatabaseInformation getDatabaseInformation() throws UserException;

	@WebMethod(action = "processChangeSetFile")
	ChangeSetResult processChangeSetFile(@WebParam(name = "poid") long poid, @WebParam(name = "comment") String comment,
			@WebParam(name = "changeSetFile") @XmlMimeType("application/octet-stream") DataHandler changeSetFile) throws UserException;

	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws UserException;

	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name = "uoid") long uoid) throws UserException;

	@WebMethod(action = "getUserOfToken")
	SUser getUserOfToken() throws UserException;

	@WebMethod(action = "logout")
	void logout();

	@WebMethod(action = "changePassword")
	boolean changePassword(@WebParam(name = "uoid") long uoid, @WebParam(name = "oldPassword") String oldPassword,
			@WebParam(name = "newPassword") String newPassword) throws UserException;

	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(@WebParam(name = "username") String username) throws UserException;

	@WebMethod(action = "undeleteProject")
	boolean undeleteProject(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "undeleteUser")
	boolean undeleteUser(@WebParam(name = "uoid") long uoid) throws UserException;

	@WebMethod(action = "compare")
	SCompareResult compare(@WebParam(name = "roid1") long roid1, @WebParam(name = "roid2") long roid2)
			throws UserException;

	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(@WebParam(name = "roid") long roid) throws UserException;

	@WebMethod(action = "userHasCheckinRights")
	boolean userHasCheckinRights(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getShowCheckoutWarning")
	String getShowCheckoutWarning(@WebParam(name = "poid") long poid, @WebParam(name = "uoid") long uoid) throws UserException;

	@WebMethod(action = "userHasRights")
	boolean userHasRights(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getDataObjectByOid")
	DataObject getDataObjectByOid(@WebParam(name = "roid") long roid, @WebParam(name = "oid") long oid,
			@WebParam(name = "className") String className) throws UserException;

	@WebMethod(action = "getDataObjectByGuid")
	DataObject getDataObjectByGuid(@WebParam(name = "roid") long roid, @WebParam(name = "guid") String guid) throws UserException;

	@WebMethod(action = "getDataObjectsByType")
	List<DataObject> getDataObjectsByType(@WebParam(name = "roid") long roid, @WebParam(name = "className") String className)
			throws UserException;

	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(@WebParam(name = "sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException;

	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(@WebParam(name = "sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException;

	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(@WebParam(name = "roid") long roid) throws UserException;

	@WebMethod(action = "resetPassword")
	String resetPassword(@WebParam(name = "emailAddress") String emailAddress) throws UserException;

	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(@WebParam(name = "roid") long roid, @WebParam(name = "projectName") String projectName,
			@WebParam(name = "comment") String comment) throws UserException;

	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(@WebParam(name = "roid") long roid, @WebParam(name = "destPoid") long destPoid,
			@WebParam(name = "comment") String comment) throws UserException;

	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws UserException;

	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(@WebParam(name = "goid") long goid) throws UserException;

	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(@WebParam(name = "sGeoTag") SGeoTag sGeoTag) throws UserException;

	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(@WebParam(name = "cdsoid") long cdsoid) throws UserException;

	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(@WebParam(name = "sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException;

	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(@WebParam(name = "uoid") long uoid);

	@WebMethod(action = "getAnonymousUser")
	SUser getAnonymousUser();

	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(@WebParam(name = "uoid") long uoid);

	@WebMethod(action = "getProjectByName")
	List<SProject> getProjectByName(@WebParam(name = "name") String name) throws UserException;

	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(@WebParam(name = "roid") long roid, @WebParam(name = "tag") String tag) throws UserException;

	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(@WebParam(name = "poid") long poid) throws UserException;

	@WebMethod(action = "isExportTypeEnabled")
	boolean isExportTypeEnabled(@WebParam(name = "resultType") ResultType resultType) throws UserException;

	@WebMethod(action = "setExportTypeEnabled")
	void setExportTypeEnabled(@WebParam(name = "resultType") ResultType resultType, boolean enabled) throws UserException;

	SUser getCurrentUser();

	boolean isLoggedIn();

	void loginAnonymous() throws UserException;
	
	List<SUserSession> getActiveUserSessions();

	Date getActiveSince();

	Date getLastActive();

	Token getCurrentToken();
}