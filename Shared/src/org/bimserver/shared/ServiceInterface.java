package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SCompareIdentifier;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SCompileResult;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SDeserializer;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SObjectIDM;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SRunResult;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSession;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.shared.exceptions.ServiceException;

/**
 * This interface defines all functions that are made available via SOAP and Protocol Buffers, but
 * also used by the JSP web interface
 */
@WebService(name = "soap")
@Path("/")
@Produces({"application/xml", "application/json"})
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface {
	/**
	 * Method to test the connection, will return the given string
	 * @param in A random string
	 * @return The string passed as "in"
	 * @throws ServiceException
	 */
	@GET
	@Path("/ping")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "ping")
	String ping(
			@QueryParam("in") @WebParam(name = "in", partName = "ping.in") String in) throws ServiceException;

	/**
	 * Login with a username/password combination
	 * @param username The username (must be a valid e-mail address)
	 * @param password The password
	 * @return True when successful, false if not
	 * @throws ServiceException
	 */
	@GET
	@Path("/login")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "login")
	Boolean login(
			@QueryParam("username") @WebParam(name = "username", partName = "login.username") String username,
			@QueryParam("password") @WebParam(name = "password", partName = "login.password") String password) throws ServiceException;

	/**
	 * Login with an autologin hash (useful for the "remember-me" functionality in web-interfaces)
	 * @param username The username (must be a valid e-mail address)
	 * @param hash The hash (which is computed as sha256(username + sha256(password))
	 * @return True when successful, false if not
	 * @throws ServiceException
	 */
	@WebMethod(action = "autologin")
	Boolean autologin(
			@WebParam(name = "username", partName = "autologin.username") String username,
			@WebParam(name = "hash", partName = "autologin.hash") String hash) throws ServiceException;

	/**
	 * Checkin a new model by sending a serialized form
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerName Name of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param ifcFile The actual file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServiceException
	 */
	@WebMethod(action = "checkin")
	Integer checkin(@WebParam(name = "poid", partName = "checkinSync.poid") Long poid,
			@WebParam(name = "comment", partName = "checkinSync.comment") String comment,
			@WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@WebParam(name = "ifcFile", partName = "checkinSync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@WebParam(name = "merge", partName = "checkinSync.merge") Boolean merge,
			@WebParam(name = "sync", partName = "checkin.sync") Boolean sync) throws ServiceException;

	/**
	 * Get the current state of a running checkin
	 * @param actionId The ID returned by the checkin function
	 * @return An object with information about the checkin state
	 * @throws ServiceException
	 */
	@WebMethod(action = "getCheckinState")
	SCheckinResult getCheckinState(
			@WebParam(name = "actionID", partName = "getCheckinState.actionID") Integer actionId) throws ServiceException;
	
	/**
	 * Checkout an existing model, cehckout is the same as download, except a "checkout" will tell the server and other users you are working on it
	 * @param roid Revision ObjectID
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState method
	 * @throws ServiceException
	 */
	@WebMethod(action = "checkout")
	Integer checkout(
			@WebParam(name = "roid", partName = "checkout.roid") Long roid,
			@WebParam(name = "serializerName", partName = "checkout.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "checkout.sync") Boolean sync) throws ServiceException;

	/**
	 * Same as checkout, only this will automatically select the last revision to checkout
	 * @param poid Project ObjectID
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param syncWhether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@WebMethod(action = "checkoutLastRevision")
	Integer checkoutLastRevision(
			@QueryParam("poid") @WebParam(name = "poid", partName = "checkoutLastRevision.poid") Long poid,
			@QueryParam("serializerName") @WebParam(name = "serializerName", partName = "checkoutLastRevision.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "checkoutLastRevision.sync") Boolean sync) throws ServiceException;

	/**
	 * Download a single revision of a model in a serialized format
	 * @param roid Revision ObjectID
	 * @param serializerName  Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@GET
	@Path("/download")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "download")
	Integer download(
			@QueryParam("roid") @WebParam(name = "roid", partName = "download.roid") Long roid,
			@QueryParam("serializerName") @WebParam(name = "serializerName", partName = "download.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of Object IDs 
	 * @param roids A set of Revision ObjectIDs
	 * @param oids A set of ObjectIDs
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@WebMethod(action = "downloadByOids")
	Integer downloadByOids(
			@WebParam(name = "roids", partName = "downloadByOids.roids") Set<Long> roids,
			@WebParam(name = "oids", partName = "downloadByOids.oids") Set<Long> oids,
			@WebParam(name = "serializerName", partName = "downloadByOids.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	/**
	 * Download a model in serialized format by giving a set of revisions and a set of class names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param classNames A set of class names to filter on (e.g. "IfcWindow")
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param includeAllSubtypes Whether to query all (recursive) subtypes of each gives class
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@WebMethod(action = "downloadByTypes")
	Integer downloadByTypes(
			@WebParam(name = "roids", partName = "downloadByTypes.roids") Set<Long> roids,
			@WebParam(name = "classNames", partName = "downloadByTypes.classNames") Set<String> classNames,
			@WebParam(name = "serializerName", partName = "downloadByTypes.serializerName") String serializerName,
			@WebParam(name = "includeAllSubtypes", partName = "downloadByTypes.includeAllSubtypes") Boolean includeAllSubtypes,
			@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	/**
	 * Download a model in a serialized format by giving a set of revisins and a set of guids to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param guids A set of IFC guids
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@WebMethod(action = "downloadByGuids")
	Integer downloadByGuids(
			@WebParam(name = "roids", partName = "downloadByGuids.roids") Set<Long> roids,
			@WebParam(name = "guids", partName = "downloadByGuids.guids") Set<String> guids,
			@WebParam(name = "serializerName", partName = "downloadByGuids.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	/**
	 * Download a model in a serialized format by giving a set of revisions
	 * @param roids A set of Revision ObjectIDs
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServiceException
	 */
	@WebMethod(action = "downloadProjects")
	Integer downloadProjects(
			@WebParam(name = "roids", partName = "downloadProjects.roids") Set<Long> roids,
			@WebParam(name = "serializerName", partName = "downloadProjects.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;
	
	/**
	 * Get the data for a download/checkout
	 * @param actionId The actionId returned by one of the download or checkout methods
	 * @return An SDownloadResult containing the serialized data
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(
			@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId) throws ServiceException;

	/**
	 * Get the current state of a download/checkout
	 * @param actionId The ID returned by a download or checkout method
	 * @return A SLongActionState object containing details about the download/checkout 
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDownloadState")
	SLongActionState getDownloadState(
			@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId) throws ServiceException;

	/**
	 * Add a new user
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @return The ObjectID of the created User object
	 * @throws ServiceException
	 */
	@WebMethod(action = "addUser")
	Long addUser(
			@WebParam(name = "username", partName = "addUser.username") String username,
			@WebParam(name = "name", partName = "addUser.name") String name,
			@WebParam(name = "type", partName = "addUser.type") SUserType type,
			@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration) throws ServiceException;

	/**
	 * Change the type of a user
	 * @param uoid The User's ObjectID
	 * @param userType The new type
	 * @throws ServiceException
	 */
	@WebMethod(action = "changeUserType")
	void changeUserType(
			@WebParam(name = "uoid", partName = "changeUserType.uoid") Long uoid,
			@WebParam(name = "userType", partName = "changeUserType.userType") SUserType userType) throws ServiceException;

	/**
	 * Add a new project
	 * @param projectName Name of the project, must be a unique name within all root-projects
	 * @return The created Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "addProject")
	SProject addProject(
			@WebParam(name = "projectName", partName = "addProject.projectName") String projectName) throws ServiceException;

	/**
	 * Add a new project as a subproject of another project
	 * @param projectName Name of the project, must be a unique name within the parent project
	 * @param parentPoid The ObjectID of the parent project
	 * @return The created Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(
			@WebParam(name = "projectName", partName = "addProjectAsSubProject.projectName") String projectName,
			@WebParam(name = "parentPoid", partName = "addProjectAsSubProject.parentPoid") Long parentPoid) throws ServiceException;

	/**
	 * Update project properties
	 * @param sProject A Project object containing the new properties
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateProject")
	void updateProject(
			@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws ServiceException;

	/**
	 * Update a revision, not much can be changed afterwards, actually only the tag
	 * @param sRevision The Revision object containing the new properties
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateRevision")
	void updateRevision(
			@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws ServiceException;

	/**
	 * Add a user to a project (authorization wise)
	 * @param uoid The ObejctID of the User
	 * @param poid The ObjectID of the Project
	 * @return Whether the User has been added to the Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "addUserToProject")
	Boolean addUserToProject(
			@WebParam(name = "uoid", partName = "addUserToProject.uoid") Long uoid,
			@WebParam(name = "poid", partName = "addUserToProject.poid") Long poid) throws ServiceException;

	/**
	 * Remove a user from a project (authorization wise)
	 * @param uoid ObjectID of the User
	 * @param poid ObjectID of the Project
	 * @return Whether the User has been removed from the Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "removeUserFromProject")
	Boolean removeUserFromProject(
			@WebParam(name = "uoid", partName = "removeProjectFromUser.uoid") Long uoid,
			@WebParam(name = "poid", partName = "removeUserFromProject.poid") Long poid) throws ServiceException;

	/**
	 * Delete a Project, Projects can be undeleted with the undeleteProject method
	 * @param poid ObjectID of the Project to delete
	 * @return Whether the Project has been deleted
	 * @throws ServiceException
	 */
	@WebMethod(action = "deleteProject")
	Boolean deleteProject(
			@WebParam(name = "poid", partName = "deleteProject.poid") Long poid) throws ServiceException;

	/**
	 * Delete a User, Users van be undeleted with the undeleteUser method
	 * @param uoid ObjectID of the User
	 * @return Whether the User has been deleted
	 * @throws ServiceException
	 */
	@WebMethod(action = "deleteUser")
	Boolean deleteUser(
			@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws ServiceException;

	/**
	 * Get a list of all Projects the user is authorized for
	 * @return A list of Projects
	 * @throws ServiceException
	 */
	@GET
	@Path("/getAllProjects")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws ServiceException;

	/**
	 * Get a list of all Projects the user is authorized for to read from
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getAllReadableProjects")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServiceException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServiceException;

	/**
	 * Get a list of all Revisions of a Project
	 * @param poid ObjectID of the Project
	 * @return A list of all Revisions
	 * @throws ServiceException
	 */
	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(
			@QueryParam("poid") @WebParam(name = "poid", partName = "getAllRevisionsOfProject.poid") Long poid) throws ServiceException;

	/**
	 * @param poid The ObjectID of the Project
	 * @return A list of Checkouts belonging to this Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid)	throws ServiceException;

	/**
	 * @param uoid ObjectID of the Project
	 * @return A list of Revisions belonging to this Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(
			@WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid) throws ServiceException;

	/**
	 * @param uoid ObjectID of the User
	 * @return A list of Checkouts belonging to the given User
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(
			@WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of Checkouts belonging to the given Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(
			@WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid) throws ServiceException;

	/**
	 * @param poid ObjectID of the Project
	 * @return The Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(
			@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return The Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "getRevision")
	SRevision getRevision(
			@WebParam(name = "roid", partName = "getRevision.roid") Long roid) throws ServiceException;

	/**
	 * @return A list of available classes in the BIMserver, only classes from the IFC model will be returned
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of classes of which a least one instance is available in the given Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAvailableClassesInRevision")
	List<String> getAvailableClassesInRevision(long roid) throws ServiceException;
	
	/**
	 * Get information about the BIMserver database
	 * @return A SDatabaseInformation Object containing the information
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDatabaseInformation")
	SDatabaseInformation getDatabaseInformation() throws ServiceException;

	/**
	 * @return When the last database reset occurred
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLastDatabaseReset")
	Date getLastDatabaseReset() throws ServiceException;

	/**
	 * @return The User that it currently loggedin on this ServiceInterface
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws ServiceException;

	/**
	 * Get a list of all Projects the given User does not have authorization for
	 * @param uoid
	 * @return The list of Users
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(
			@WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid) throws ServiceException;

	/**
	 * Logout from this ServiceInterface (beware, the ServiceInterface is not closed and is still usable)
	 * @throws ServiceException
	 */
	@WebMethod(action = "logout")
	void logout() throws ServiceException;

	/**
	 * Close this ServiceInterface instance (it is important to close ServiceInterfaces for obvious reasons)
	 * @throws ServiceException
	 */
	@WebMethod(action = "close")
	void close() throws ServiceException;
	
	/**
	 * Change a User's password, not the preferred way, use requestPasswordChange for a safer version
	 * @param uoid The ObjectID of the User
	 * @param oldPassword The old password
	 * @param newPassword The new password
	 * @return Whether the password was successfully changed
	 * @throws ServiceException
	 */
	@WebMethod(action = "changePassword")
	Boolean changePassword(
			@WebParam(name = "uoid", partName = "changePassword.uoid") Long uoid,
			@WebParam(name = "oldPassword", partName = "changePassword.oldPassword") String oldPassword,
			@WebParam(name = "newPassword", partName = "changePassword.newPassword") String newPassword) throws ServiceException;

	/**
	 * Get a User by its UserNmae (e-mail address)
	 * @param username The username (must be a valid e-mail address)
	 * @return The SUser Object if found, otherwise null
	 * @throws ServiceException
	 */
	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(
			@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws ServiceException;

	/**
	 * Undelete a previously deleted Project, Projets can be deleted with the deleteProject method
	 * @param poid The ObjectID of the Project to undelete
	 * @return Whether the Project was successfully undeleted
	 * @throws ServiceException
	 */
	@WebMethod(action = "undeleteProject")
	Boolean undeleteProject(
			@WebParam(name = "poid", partName = "undeleteProject.poid") Long poid) throws ServiceException;

	/**
	 * Undelete a previously deleted User, Users can be deleted with the deleteUser method
	 * @param uoid
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(
			@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws ServiceException;

	/**
	 * Compare two models
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @return The result of the compare
	 * @throws ServiceException
	 */
	@WebMethod(action = "compare")
	SCompareResult compare(
			@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
			@WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType, 
			@WebParam(name = "sCompareIdentifier", partName = "compare.sCompareIdentifier") SCompareIdentifier sCompareIdentifier) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A summary of the given Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(
			@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws ServiceException;		

	/**
	 * @param poid ObjectID of the Project
	 * @return Whether the current use has checkin rights on the given Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "userHasCheckinRights")
	Boolean userHasCheckinRights(
			@WebParam(name = "poid", partName = "userHasCheckinRights.poid") Long poid) throws ServiceException;

	/**
	 * Checkout warnings are given to users when checkouts are done by other users
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "getShowCheckoutWarning")
	Set<String> getCheckoutWarnings(
			@WebParam(name = "poid", partName = "getShowCheckoutWarning.poid") Long poid) throws ServiceException;

	/**
	 * @param poid ObjectID of the Project
	 * @return Whether the current User has rights on the given Project
	 * @throws ServiceException
	 */
	@WebMethod(action = "userHasRights")
	Boolean userHasRights(
			@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws ServiceException;

	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(
			@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
			@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid,
			@WebParam(name = "className", partName = "getDataObjectByOid.className") String className) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @param guid An IFC GUID
	 * @return The object with the given GUID in the given Revision, of null if not found
	 * @throws ServiceException
	 */
	@GET
	@Path("/getDataObjectByGuid")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(
			@QueryParam("roid") @WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
			@QueryParam("guid") @WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @param className Name of the class to query (e.g. "IfcWindow")
	 * @return A list of DataObjects from the given Revision matching the given class
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(
			@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
			@WebParam(name = "className", partName = "getDataObjectsByType.className") String className) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of DataObjects from the given Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDataObjects")
	List<SDataObject> getDataObjects(long roid) throws ServiceException;

	/**
	 * Perform clashdetection
	 * @param sClashDetectionSettings The settings for the ClashDetection, these include the Revisions to use
	 * @return A list of GuidClash objects describing the found clashes
	 * @throws ServiceException
	 */
	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByGuid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServiceException;

	/**
	 * @param sClashDetectionSettings The settings for the ClashDetection, these include the Revisions to use
	 * @return A list of EidClash objects describing the found clashes
	 * @throws ServiceException
	 */
	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByEid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServiceException;

	/**
	 * Get previously calculated clashes
	 * @param roid ObjectID of the Revision
	 * @return A list of Clash objects
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(
			@WebParam(name = "roid", partName = "getLastClashes.roid") Long roid) throws ServiceException;

	/**
	 * Branch a given Revision as a new Revision on a new Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param projectName Name of the to be created Project
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServiceException
	 */
	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(
			@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
			@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
			@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment) throws ServiceException;

	/**
	 * Branch a given Revision as a new Revision in the given Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param destPoid ObjectID of the Project to which a branch should be made
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServiceException
	 */
	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(
			@WebParam(name = "roid", partName = "branchToExistingProject.roid") Long roid,
			@WebParam(name = "destPoid", partName = "branchToExistingProject.destPoid") Long destPoid,
			@WebParam(name = "comment", partName = "branchToExistingProject.comment") String comment) throws ServiceException;

	/**
	 * @param goid The ObjectID of the GeoTag
	 * @return The GeoTag object
	 * @throws ServiceException
	 */
	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(
			@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws ServiceException;

	/**
	 * @param sGeoTag A GeoTag object containing the new properties
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(
			@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws ServiceException;

	/**
	 * @param cdsoid The ObjectID of the ClashDetectionSettings object
	 * @return The ClashDetectionSettings object
	 * @throws ServiceException
	 */
	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(
			@WebParam(name = "cdsoid", partName = "getClashDetectionSettings.cdsoid") Long cdsoid) throws ServiceException;

	/**
	 * @param sClashDetectionSettings A ClashDetectionSettings object containing the new properties
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(
			@WebParam(name = "sClashDetectionSettings", partName = "updateClashDetectionSettings.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServiceException;

	/**
	 * @param uoid The ObjectID of the User
	 * @return The User with the given User ObjectID
	 * @throws ServiceException
	 */
	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(
			@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws ServiceException;

	/**
	 * Get a list of all Users not authoriazed on the given Project
	 * @param poid The ObjectID of the Project
	 * @return A list of Users
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(
			@WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid) throws ServiceException;

	/**
	 * @param poid
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(
			@WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid) throws ServiceException;

	/**
	 * @param uoid
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(
			@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws ServiceException;

	/**
	 * @param name
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "getProjectsByName")
	List<SProject> getProjectsByName(
			@WebParam(name = "name", partName = "getProjectsByName.name") String name) throws ServiceException;

	/**
	 * @param roid
	 * @param tag
	 * @throws ServiceException
	 */
	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(
			@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
			@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws ServiceException;

	/**
	 * @param poid
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(
			@WebParam(name = "poid", partName = "getSubProjects.poid") Long poid) throws ServiceException;

	/**
	 * @return The currently logged-in User
	 * @throws ServiceException
	 */
	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws ServiceException;

	/**
	 * @return Whether this ServiceInterface is logged-in
	 * @throws ServiceException
	 */
	@WebMethod(action = "isLoggedIn")
	Boolean isLoggedIn() throws ServiceException;

	/**
	 * @return Since when this ServiceInterface session has been active
	 * @throws ServiceException
	 */
	@WebMethod(action = "getActiveSince")
	Date getActiveSince() throws ServiceException;

	/**
	 * @return When the session has been active for the last
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLastActive")
	Date getLastActive() throws ServiceException;

	/**
	 * @return The Token used for this session
	 * @throws ServiceException
	 */
	@WebMethod(action = "getCurrentToken")
	Token getCurrentToken() throws ServiceException;

	/**
	 * @return The method of access this ServiceInterface is using (SOAP, REST, PB etc...)
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws ServiceException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws ServiceException;

	/**
	 * Request a password change, an e-mail will be send with a validation url
	 * @param uoid The ObjectID of the User for which to change the password
	 * @throws ServiceException
	 */
	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(
			@WebParam(name = "uoid", partName = "requestPasswordChange.uoid") Long uoid) throws ServiceException;

	/**
	 * @param uoid The ObejctID of the User
	 * @param token The token generated by requestPasswordChange
	 * @param password The new password
	 * @return A User object if the change is successful, null otherwise
	 * @throws ServiceException
	 */
	@WebMethod(action = "validateAccount")
	SUser validateAccount(
			@WebParam(name = "uoid", partName = "validateAccount.uoid") Long uoid,
			@WebParam(name = "token", partName = "validateAccount.token") String token,
			@WebParam(name = "password", partName = "validateAccount.password") String password) throws ServiceException;

	/**
	 * Send an e-mail to a set of Users with the results of a clashdetection
	 * @param sClashDetectionSettings The settings to use for the ClashDetection
	 * @param poid ObjectID of the Project
	 * @param addressesTo A set of String containing the e-mail addresses
	 * @throws ServiceException
	 */
	@WebMethod(action = "sendClashesEmail")
	void sendClashesEmail(
			@WebParam(name = "sClashDetectionSettings", partName = "sendClashesEmail.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "addressesTo", partName = "sendClashesEmail.addressesTo") Set<String> addressesTo) throws ServiceException;

	/**
	 * Send an e-mail with the results of a compare
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @param poid The ObjectID of the Project
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param address The e-mail address to send the e-mail to
	 * @throws ServiceException
	 */
	@WebMethod(action = "sendCompareEmail")
	void sendCompareEmail(
			@WebParam(name = "sCompareType", partName = "sendClashesEmail.sCompareType") SCompareType sCompareType,
			@WebParam(name = "sCompareIdentifier", partName = "sendClashesEmail.sCompareIdentifier") SCompareIdentifier sCompareIdentifier,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
			@WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws ServiceException;
	
	/**
	 * Setup this BIMserver
	 * @param siteAddress The address the server will be reachable at (for example: http://demo.bimserver.org)
	 * @param smtpServer The address of the SMTP server that wil be used for sending e-mails
	 * @param adminName Name of the admin User (e.g. "Administrator")
	 * @param adminUsername Username of the admin User (must be a valid e-mail address)
	 * @param adminPassword Password of the admin User
	 * @throws ServiceException
	 */
	@WebMethod(action = "setup")
	void setup(@WebParam(name = "siteAddress", partName = "setup.siteAddress") String siteAddress,
			@WebParam(name = "smtpServer", partName = "setup.smtpServer") String smtpServer,
			@WebParam(name = "adminName", partName = "setup.adminName") String adminName,
			@WebParam(name = "adminUsername", partName = "setup.adminUsername") String adminUsername,
			@WebParam(name = "adminPassword", partName = "setup.adminPassword") String adminPassword) throws ServiceException;

	/**
	 * @return The location of a custom Logo (URL) for the BIMserver
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingsCustomLogoAddress")
	String getSettingCustomLogoAddress() throws ServiceException;

	/**
	 * @param customLogoAddress The new location for the custom logo
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsCustomLogoAddress")
	void setSettingCustomLogoAddress(
			@WebParam(name = "customLogoAddress", partName = "setSettingsCustomLogoAddress.customLogoAddress") String customLogoAddress) throws ServiceException;

	/**
	 * @return An addition to the JSP header
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingHeaderAddition")
	String getSettingHeaderAddition() throws ServiceException;

	
	/**
	 * @param headerAddition The new header addition
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingHeaderAddition")
	void setSettingHeaderAddition (
			@WebParam(name = "headerAddition", partName = "setSettingHeaderAddition.headerAddition") String headerAddition) throws ServiceException;

	/**
	 * @return An addition to the JSP footer
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingFooterAddition")
	String getSettingFooterAddition() throws ServiceException;

	/**
	 * @param footerAddition The new footer addition
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingFooterAddition")
	void setSettingFooterAddition(
			@WebParam(name = "footerAddition", partName = "setSettingFooterAddition.footerAddition") String footerAddition) throws ServiceException;

	/**
	 * @param mergeIdentifier
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingMergeIdentifier")
	void setSettingMergeIdentifier(
			@WebParam(name = "mergeIdentifier", partName = "setSettingMergeIdentifier.mergeIdentifier") SMergeIdentifier mergeIdentifier) throws ServiceException;

	@WebMethod(action = "getSettingsEmailSenderAddress")
	String getSettingEmailSenderAddress() throws ServiceException;

	/**
	 * @param emailSenderAddress The new e-mail address e-mail will be sent from
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsEmailSenderAddress")
	void setSettingEmailSenderAddress(
			@WebParam(name = "emailSenderAddress", partName = "setSettingsEmailSenderAddress.emailSenderAddress") String emailSenderAddress) throws ServiceException;

	/**
	 * @return The registration addition text
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingsRegistrationAddition")
	String getSettingRegistrationAddition() throws ServiceException;

	/**
	 * @param registrationAddition The new registration addition text
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsRegistrationAddition")
	void setSettingRegistrationAddition(
			@WebParam(name = "registrationAddition", partName = "setSettingsRegistrationAddition.registrationAddition") String registrationAddition) throws ServiceException;

	/**
	 * @return The port on which the ProtocolBuffers server runs
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingProtocolBuffersPort")
	Integer getSettingProtocolBuffersPort() throws ServiceException;

	/**
	 * @param port Set the port the ProtocolBuffers server runs on
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsProtocolBuffersPort")
	void setSettingProtocolBuffersPort(
			@WebParam(name = "port", partName = "setSettingsProtocolBuffersPort.port") Integer port) throws ServiceException;
	
	/**
	 * @return The address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingsSiteAddress")
	String getSettingSiteAddress() throws ServiceException;

	/**
	 * @param siteAddress The new address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsSiteAddress")
	void setSettingSiteAddress(
			@WebParam(name = "siteAddress", partName = "setSettingsSiteAddress.siteAddress") String siteAddress) throws ServiceException;

	/**
	 * @return Address of the SMTP server used for sending e-mails
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingsSmtpServer")
	String getSettingSmtpServer() throws ServiceException;

	/**
	 * @param smtpServer New address of the SMTP server used for sending e-mails
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingsSmtpServer")
	void setSettingSmtpServer(
			@WebParam(name = "smtpServer", partName = "setSettingsSmtpServer.smtpServer") String smtpServer) throws ServiceException;

	/**
	 * @return Whether self-registration is enabled
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingAllowSelfRegistration")
	Boolean isSettingAllowSelfRegistration() throws ServiceException;

	/**
	 * @param allowSelfRegistration Change whether self-registration is enabled
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingAllowSelfRegistration")
	void setSettingAllowSelfRegistration(
			@WebParam(name = "allowSelfRegistration", partName = "setSettingAllowSelfRegistration.allowSelfRegistration") Boolean allowSelfRegistration)throws ServiceException;

	/**
	 * @return Whether to hide user lists (pricacy)
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingHideUserListForNonAdmin")
	Boolean isSettingHideUserListForNonAdmin() throws ServiceException;

	/**
	 * @param hideUserListForNonAdmin Set whether user lists should be hidden (privacy)
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingHideUserListForNonAdmin")
	void setSettingHideUserListForNonAdmin(
			@WebParam(name = "hideUserListForNonAdmin", partName = "setSettingHideUserListForNonAdmin.hideUserListForNonAdmin") Boolean hideUserListForNonAdmin) throws ServiceException;

	/**
	 * @return Whether a user can create top level projects
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingAllowUsersToCreateTopLevelProjects")
	Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServiceException;

	/**
	 * @param allowUsersToCreateTopLevelProjects Set if users can create top level projects
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingAllowUsersToCreateTopLevelProjects")
	void setSettingAllowUsersToCreateTopLevelProjects(
			@WebParam(name = "allowUsersToCreateTopLevelProjects", partName = "setSettingAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects") Boolean allowUsersToCreateTopLevelProjects) throws ServiceException;

	/**
	 * @return Whether clash detection will be automatically performed after each checkin
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingAutoTestClashes")
	Boolean isSettingAutoTestClashes() throws ServiceException;

	/**
	 * @param autoTestClashes Set whether clash detection will be automatically performed after each checkin
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingAutoTestClashes")
	void setSettingAutoTestClashes(
			@WebParam(name = "autoTestClashes", partName = "setSettingAutoTestClashes.autoTestClashes") Boolean autoTestClashes) throws ServiceException;

	/**
	 * @return Whether the BIMserver should do checkin merging (warning: this will alter your models)
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingCheckinMergingEnabled")
	Boolean isSettingCheckinMergingEnabled() throws ServiceException;

	/**
	 * @param checkinMergingEnabled Set whether the BIMserver should do checkin merging (warning: this wil alter your models)
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingCheckinMergingEnabled")
	void setSettingCheckinMergingEnabled(
			@WebParam(name = "checkinMergingEnabled", partName = "setSettingCheckinMergingEnabled.checkinMergingEnabled") Boolean checkinMergingEnabled) throws ServiceException;

	/**
	 * @return Whether intelligent merging is on
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingIntelligentMerging")
	Boolean isSettingIntelligentMerging() throws ServiceException;

	/**
	 * @param intelligentMerging Set intelligent merging on/off
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingIntelligentMerging")
	void setSettingIntelligentMerging(
			@WebParam(name = "intelligentMerging", partName = "setSettingIntelligentMerging.intelligentMerging") Boolean intelligentMerging) throws ServiceException;

	/**
	 * @return Whether a confirmation e-mail should be send after registration
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingSendConfirmationEmailAfterRegistration")
	Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServiceException;

	/**
	 * @param sendConfirmationEmailAfterRegistration Set whether a confirmation e-mail should be send after registration
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingSendConfirmationEmailAfterRegistration")
	void setSettingSendConfirmationEmailAfterRegistration(
			@WebParam(name = "sendConfirmationEmailAfterRegistration", partName = "setSettingSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration") Boolean sendConfirmationEmailAfterRegistration) throws ServiceException;

	/**
	 * @return Whether it should be shown to the user that a new version of the BIMserver is available
	 * @throws ServiceException
	 */
	@WebMethod(action = "isSettingShowVersionUpgradeAvailable")
	Boolean isSettingShowVersionUpgradeAvailable() throws ServiceException;

	/**
	 * @param showVersionUpgradeAvailable Set whether it should be shown to the user that a new version of the BIMserver is available
	 * @throws ServiceException
	 */
	@WebMethod(action = "setSettingShowVersionUpgradeAvailable")
	void setSettingShowVersionUpgradeAvailable(
			@WebParam(name = "showVersionUpgradeAvailable", partName = "setSettingShowVersionUpgradeAvailable.showVersionUpgradeAvailable") Boolean showVersionUpgradeAvailable) throws ServiceException;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServiceException
	 */
	@WebMethod(action = "isCacheOutputFiles")
	Boolean isSettingCacheOutputFiles() throws ServiceException;

	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServiceException
	 */
	@WebMethod(action = "setCacheOutputFiles")
	void setSettingCacheOutputFiles(
			@WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles) throws ServiceException;
	
	/**
	 * @return A list with all Log objects, Log objects contain information about action performed on the BIMserver like ProjectAdded, UserAdded etc...
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws ServiceException;

	/**
	 * @return A list with the currently active User sessions
	 * @throws ServiceException
	 */
	@WebMethod(action = "getActiveUserSessions")
	List<SUserSession> getActiveUserSessions() throws ServiceException;

	/**
	 * @return A list with the currently running Long actions
	 * @throws ServiceException
	 */
	@WebMethod(action = "getActiveLongActions")
	List<SLongAction> getActiveLongActions() throws ServiceException;

	/**
	 * @return A list of all Migrations (either executed or not)
	 * @throws ServiceException
	 */
	@WebMethod(action = "getMigrations")
	List<SMigration> getMigrations() throws ServiceException;

	/**
	 * This will try to upgrade the database to the latest revision, this method will do nothing if the database schema is already up-to-date
	 * @throws ServiceException
	 */
	@WebMethod(action = "migrateDatabase")
	void migrateDatabase() throws ServiceException;

	/**
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllSerializers")
	List<SSerializer> getAllSerializers(
			@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the Serializer
	 * @return Serializer
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSerializerById")
	SSerializer getSerializerById(
			@WebParam(name = "oid", partName = "getSerializerById.oid") Long oid) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the Deserializer
	 * @return Deserializer
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDeserializerById")
	SDeserializer getDeserializerById(
			@WebParam(name = "oid", partName = "getDeserializerById.oid") Long oid) throws ServiceException;

	/**
	 * @param serializer Serializer to add
	 * @throws ServiceException
	 */
	@WebMethod(action = "addSerializer")
	void addSerializer(
			@WebParam(name = "serializer", partName = "addSerializer.serializer") SSerializer serializer) throws ServiceException;
	
	/**
	 * @param deserializer Deserializer to add
	 * @throws ServiceException
	 */
	@WebMethod(action = "addSerializer")
	void addDeserializer(
			@WebParam(name = "deserializer", partName = "addDeserializer.deserializer") SDeserializer deserializer) throws ServiceException;

	/**
	 * @param serializer Serializer to update
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateSerializer")
	void updateSerializer(
			@WebParam(name = "serializer", partName = "updateSerializer.serializer") SSerializer serializer) throws ServiceException;
	
	/**
	 * @param deserializer Deserializer to update
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateDeserializer")
	void updateDeserializer(
			@WebParam(name = "deserializer", partName = "updateDeserializer.deserializer") SDeserializer deserializer) throws ServiceException;

	/**
	 * @param onlyEnabled Whether to include only enabled ObjectIDMs
	 * @return A list of ObjectIDMs
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllObjectIDMs")
	List<SObjectIDM> getAllObjectIDMs(
			@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServiceException
	 */
	@WebMethod(action = "getObjectIDMById")
	SObjectIDM getObjectIDMById(
			@WebParam(name = "oid", partName = "getObjectIDMById.oid") Long oid) throws ServiceException;
	
	/**
	 * @param objectIDM The ObjectIDM to add
	 * @throws ServiceException
	 */
	@WebMethod(action = "addObjectIDM")
	void addObjectIDM(
			@WebParam(name = "objectIDM", partName = "addObjectIDM.objectIDM") SObjectIDM objectIDM) throws ServiceException;
	
	/**
	 * @param objectIDM The ObjectIDM to update
	 * @throws ServiceException
	 */
	@WebMethod(action = "updateObjectIDM")
	void updateObjectIDM(
			@WebParam(name = "objectIDM", partName = "updateObjectIDM.objectIDM") SObjectIDM objectIDM) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM to delete
	 * @throws ServiceException
	 */
	@WebMethod(action = "deleteObjectIDM")
	void deleteObjectIDM(
			@WebParam(name = "oid", partName = "deleteObjectIDM.oid") Long oid) throws ServiceException;

	/**
	 * @param sid ObjectID of the Serializer to delete
	 * @throws ServiceException
	 */
	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(
			@WebParam(name = "sid", partName = "deleteSerializer.sid") Long sid) throws ServiceException;
	
	/**
	 * @param sid ObjectID of the Deserializer to delete
	 * @throws ServiceException
	 */
	@WebMethod(action = "deleteDeserializer")
	void deleteDeserializer(
			@WebParam(name = "sid", partName = "deleteDeserializer.sid") Long sid) throws ServiceException;

	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllSerializerClassNames")
	List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws ServiceException;

	/**
	 * @return List of all DeserializerPluginDescriptors
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllDeserializerClassNames")
	List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServiceException;

	/**
	 * @return A settings that determines how to merge
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSettingMergeIdentifier")
	SMergeIdentifier getSettingMergeIdentifier() throws ServiceException;

	/**
	 * @param serializerName Name of the Serializer
	 * @return Serializer
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSerializerByName")
	SSerializer getSerializerByName(
			@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws ServiceException;

	/**
	 * @param objectIDMName Name of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServiceException
	 */
	@WebMethod(action = "getObjectIDMByName")
	SObjectIDM getObjectIDMByName(
			@WebParam(name = "objectIDMName", partName = "getObjectIDMByName.objectIDMName") String objectIDMName) throws ServiceException;

	/**
	 * @param deserializerName Name of the Deserializer
	 * @return Deserializer
	 * @throws ServiceException
	 */
	@WebMethod(action = "getDeserializerByName")
	SDeserializer getDeserializerByName(
			@WebParam(name = "deserializerName", partName = "getDeserializerByName.deserializerName") String deserializerName) throws ServiceException;

	/**
	 * @param contentType Content type
	 * @return Whether there is an active Serializer supporting the given ContentType
	 * @throws ServiceException
	 */
	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(String contentType) throws ServiceException;
	
	/**
	 * @return A list of all plugins
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllPlugins")
	List<SPluginDescriptor> getAllPlugins() throws ServiceException;
	
	/**
	 * @param name Name of the plugin to enable
	 * @throws ServiceException
	 */
	@WebMethod(action = "enablePlugin")
	void enablePlugin(String name) throws ServiceException;
	
	/**
	 * @param name Name of the plugin to disable
	 * @throws ServiceException
	 */
	@WebMethod(action = "disablePlugin")
	void disablePlugin(String name) throws ServiceException;

	/**
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSerializerByContentType")
	SSerializer getSerializerByContentType(
			@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws ServiceException;
	
	/**
	 * @param pid ObjectID of the Project to start a transaction on
	 * @throws ServiceException
	 */
	@WebMethod(action = "startTransaction")
	void startTransaction(
			@WebParam(name = "pid", partName = "startTransaction.pid") Integer pid) throws ServiceException;

	/**
	 * Commit the current transaction, changes will be saved, a transaction must be started by startTransaction first
	 * @param comment Comment describing what has changed
	 * @return ObjectID of the Revision
	 * @throws ServiceException
	 */
	@WebMethod(action = "commitTransaction")
	Long commitTransaction(
			@WebParam(name = "comment", partName = "commitTransaction.comment") String comment) throws ServiceException;
	
	/**
	 * Abort the current transaction, changes will not be saved
	 * @throws ServiceException
	 */
	@WebMethod(action = "abortTransaction")
	void abortTransaction() throws ServiceException;
	
	/**
	 * Create a new Object
	 * @param className The type of the new object
	 * @return The ObjectID of the newly created object
	 * @throws ServiceException
	 */
	@WebMethod(action = "createObject")
	Long createObject(
			@WebParam(name = "className", partName = "createObject.className") String className) throws ServiceException;
	
	/**
	 * Remove an object
	 * @param className ClassName of the Object, this parameter is required for performance reasons only, but is required 
	 * @param oid ObjectID of the object to remove
	 * @throws ServiceException
	 */
	@WebMethod(action = "removeObject")
	void removeObject(
			@WebParam(name = "className", partName = "removeObject.className") String className, 
			@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServiceException
	 */
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
			@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServiceException
	 */
	@WebMethod(action = "setDoubleAttribute")
	void setDoubleAttribute(
			@WebParam(name = "oid", partName = "setDoubleAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setDoubleAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setDoubleAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setDoubleAttribute.value") Double value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Enum value (name of the enum item)
	 * @throws ServiceException
	 */
	@WebMethod(action = "setEnumAttribute")
	void setEnumAttribute(
			@WebParam(name = "oid", partName = "setEnumAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setEnumAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setEnumAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setEnumAttribute.value") String value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServiceException
	 */
	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
			@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServiceException
	 */
	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
			@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @param referenceClassName Type of the newly referred object
	 * @throws ServiceException
	 */
	@WebMethod(action = "setReference")
	void setReference(
			@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
			@WebParam(name = "className", partName = "setReference.className") String className, 
			@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid, 
			@WebParam(name = "referenceClassName", partName = "setReference.referenceClassName") String referenceClassName) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to unset
	 * @throws ServiceException
	 */
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
			@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "unsetAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference to unset (null)
	 * @throws ServiceException
	 */
	@WebMethod(action = "unsetReference")
	void unsetReference(
			@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
			@WebParam(name = "className", partName = "unsetReference.className") String className,
			@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New String value
	 * @throws ServiceException
	 */
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
			@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Double value
	 * @throws ServiceException
	 */
	@WebMethod(action = "addDoubleAttribute")
	void addDoubleAttribute(
			@WebParam(name = "oid", partName = "addDoubleAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addDoubleAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addDoubleAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addDoubleAttribute.value") Double value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Integer value
	 * @throws ServiceException
	 */
	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
			@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Boolean value
	 * @throws ServiceException
	 */
	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
			@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws ServiceException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference to add a reference to
	 * @param referenceOid ObjectID of the newly referenced Object
	 * @param referenceClassName Type of the newly referenced Object
	 * @throws ServiceException
	 */
	@WebMethod(action = "addReference")
	void addReference(
			@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
			@WebParam(name = "className", partName = "addReference.className") String className, 
			@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid,
			@WebParam(name = "referenceClassName", partName = "addReference.referenceClassName") String referenceClassName) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServiceException
	 */
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
			@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "removeAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
			@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws ServiceException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServiceException
	 */
	@WebMethod(action = "removeReference")
	void removeReference(
			@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
			@WebParam(name = "className", partName = "removeReference.className") String className, 
			@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
			@WebParam(name = "index", partName = "removeReference.index") Integer index) throws ServiceException;
	
	/**
	 * @return The Date when the BIMserver was last started
	 * @throws ServiceException
	 */
	@WebMethod(action = "getServerStartTime")
	Date getServerStartTime() throws ServiceException;
	
	/**
	 * @param type The type
	 * @return SSerializerPluginDescriptor
	 * @throws ServiceException
	 */
	@WebMethod(action = "getSerializerPluginDescriptor")
	SSerializerPluginDescriptor getSerializerPluginDescriptor(
			@WebParam(name = "type", partName = "getSerializerPluginDescriptor.type") String type) throws ServiceException;
	
	/**
	 * @return A list of available IDMPlugins
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllObjectIDMPluginDescriptors")
	List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws ServiceException;

	/**
	 * @param onlyEnabled Whether to only include enabled deserializers
	 * @return A list of all available deserializers
	 * @throws ServiceException
	 */
	@WebMethod(action = "getAllDeserializers")
	List<SDeserializer> getAllDeserializers(
			@WebParam(name = "oid", partName = "removeReference.oid") Boolean onlyEnabled) throws ServiceException;
	
	/**
	 * @param uoid ObjectID of the User to change the callBack URL for
	 * @param address Address of the callback server (e.g. localhost:2000)
	 * @throws ServiceException
	 */
	@WebMethod(action = "setHttpCallback")
	void setHttpCallback(
			@WebParam(name = "uoid", partName = "setHttpCallback.uoid") Long uoid, 
			@WebParam(name = "address", partName = "setHttpCallback.address") String address) throws ServiceException;
	
	/**
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return SCompileResult
	 * @throws ServiceException
	 */
	@WebMethod(action = "compile")
	SCompileResult compile(
			@WebParam(name = "code", partName = "compile.code") String code) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision to perform this query on
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return SRunResult
	 * @throws ServiceException
	 */
	@WebMethod(action = "compileAndRun")
	SRunResult compileAndRun(
			@WebParam(name = "roid", partName = "compileAndRun.roid") long roid, 
			@WebParam(name = "code", partName = "compileAndRun.code") String code) throws ServiceException;

	/**
	 * @param roid ObjectID of the Revision to perform this query on
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return A download id, which can be used in getDownloadState and getDownloadData
	 * @throws ServiceException
	 */
	@WebMethod(action = "compileAndDownload")
	Integer compileAndDownload(
			@WebParam(name = "roid", partName = "compileAndDownload.roid") long roid, 
			@WebParam(name = "code", partName = "compileAndDownload.code") String code) throws ServiceException;
	
	/**
	 * Thsi will return the content of the .proto file (equivalent for SOAP's WSDL) for the ProtocolBuffers interface
	 * @return
	 * @throws ServiceException
	 */
	@WebMethod(action = "getProtocolBuffersFile")
	String getProtocolBuffersFile() throws ServiceException;
	
	/**
	 * Get information about this BIMserver's state
	 * @return A SServerInfo object containing information about the current state
	 * @throws ServiceException
	 */
	@WebMethod(action = "getServerInfo")
	SServerInfo getServerInfo() throws ServiceException;
	
	/**
	 * Get the actual version of this BIMserver
	 * @return A SVersion object containg the version information
	 * @throws ServiceException
	 */
	@WebMethod(action = "getVersion")
	SVersion getVersion() throws ServiceException;
	
	/**
	 * Check which version of BIMserver is the latest available (will download an XML file from bimserver.org)
	 * @return A SVersion object containing the version information
	 * @throws ServiceException
	 */
	@WebMethod(action = "getLatestVersion")
	SVersion getLatestVersion() throws ServiceException;
	
	/**
	 * Check whether an upgrade of the BIMserver is available (will download an XML file from bimserver.org)
	 * @return Whether a new version is available
	 * @throws ServiceException
	 */
	@WebMethod(action = "upgradePossible")
	Boolean upgradePossible() throws ServiceException;

	/**
	 * Get the remove address (which is actually the address the server thinks the client is connecting from)
	 * @return A string with a hostname or ip address
	 * @throws ServiceException
	 */
	@WebMethod(action = "getRemoteAddress")
	String getRemoteAddress() throws ServiceException;
}