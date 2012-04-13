package org.bimserver.shared;

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
import org.bimserver.interfaces.objects.SIfcEngine;
import org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor;
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
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

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
	 * 
	 * Available as REST call
	 * 
	 * @param in A random string
	 * @return The string passed as "in"
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/ping")
	@Produces({"text/plain"})
	@WebMethod(action = "ping")
	String ping(
			@QueryParam("in") @WebParam(name = "in", partName = "ping.in") String in) throws ServerException, UserException;

	/**
	 * Login with a username/password combination
	 * @param username The username (must be a valid e-mail address)
	 * @param password The password
	 * @return True when successful, false if not
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "login")
	Boolean login(
			@WebParam(name = "username", partName = "login.username") String username,
			@WebParam(name = "password", partName = "login.password") String password) throws ServerException, UserException;

	/**
	 * Login with an autologin hash (useful for the "remember-me" functionality in web-interfaces)
	 * @param username The username (must be a valid e-mail address)
	 * @param hash The hash (which is computed as sha256(username + sha256(password))
	 * @return True when successful, false if not
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "autologin")
	Boolean autologin(
			@WebParam(name = "username", partName = "autologin.username") String username,
			@WebParam(name = "hash", partName = "autologin.hash") String hash) throws ServerException, UserException;

	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * Available as REST call
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerName Name of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param ifcFile The actual file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/checkin")
	@Produces("text/plain")
	@WebMethod(action = "checkin")
	Integer checkin(@WebParam(name = "poid", partName = "checkinSync.poid") Long poid,
			@QueryParam("comment") @WebParam(name = "comment", partName = "checkinSync.comment") String comment,
			@QueryParam("deserializerName") @WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@QueryParam("fileSize") @WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@QueryParam("ifcFile") @WebParam(name = "ifcFile", partName = "checkinSync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@QueryParam("merge") @WebParam(name = "merge", partName = "checkinSync.merge") Boolean merge,
			@QueryParam("sync") @WebParam(name = "sync", partName = "checkin.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Get the current state of a running checkin
	 * @param actionId The ID returned by the checkin function
	 * @return An object with information about the checkin state
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getCheckinState")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getCheckinState")
	SCheckinResult getCheckinState(
			@QueryParam("actionID") @WebParam(name = "actionID", partName = "getCheckinState.actionID") Integer actionId) throws ServerException, UserException;
	
	/**
	 * Checkout an existing model, cehckout is the same as download, except a "checkout" will tell the server and other users you are working on it
	 * 
	 * Available as REST call
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState method
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/checkout")
	@Produces("text/plain")
	@WebMethod(action = "checkout")
	Integer checkout(
			@QueryParam("roid") @WebParam(name = "roid", partName = "checkout.roid") Long roid,
			@QueryParam("serializerName") @WebParam(name = "serializerName", partName = "checkout.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "checkout.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Same as checkout, only this will automatically select the last revision to checkout
	 * 
	 * Available as REST call
	 *
	 * @param poid Project ObjectID
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/checkoutLastRevision")
	@Produces("text/plain")
	@WebMethod(action = "checkoutLastRevision")
	Integer checkoutLastRevision(
			@QueryParam("poid") @WebParam(name = "poid", partName = "checkoutLastRevision.poid") Long poid,
			@QueryParam("serializerName") @WebParam(name = "serializerName", partName = "checkoutLastRevision.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "checkoutLastRevision.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a single revision of a model in a serialized format
	 * 
	 * Available as REST call
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerName  Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param showOwn Whether to return revisions created by the current user
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/download")
	@Produces({"text/plain"})
	@WebMethod(action = "download")
	Integer download(
			@QueryParam("roid") @WebParam(name = "roid", partName = "download.roid") Long roid,
			@QueryParam("serializerName") @WebParam(name = "serializerName", partName = "download.serializerName") String serializerName,
			@QueryParam("showOwn") @WebParam(name = "showOwn", partName = "download.showOwn") Boolean showOwn,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a compare of a model
	 * @param roid1
	 * @param roid2
	 * @param identifier
	 * @param type
	 * @param sync
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadCompareResults")
	Integer downloadCompareResults(
			@WebParam(name = "serializerName", partName = "downloadByOids.serializerName") String serializerName,
			@WebParam(name = "roid1", partName = "downloadByOids.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "downloadByOids.roid2") Long roid2,
			@WebParam(name = "identifier", partName = "downloadByOids.identifier") SCompareIdentifier identifier,
			@WebParam(name = "type", partName = "downloadByOids.type") SCompareType type,
			@WebParam(name = "sync", partName = "downloadByOids.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of Object IDs 
	 * @param roids A set of Revision ObjectIDs
	 * @param oids A set of ObjectIDs
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByOids")
	Integer downloadByOids(
			@WebParam(name = "roids", partName = "downloadCompareResults.roids") Set<Long> roids,
			@WebParam(name = "oids", partName = "downloadCompareResults.oids") Set<Long> oids,
			@WebParam(name = "serializerName", partName = "downloadCompareResults.serializerName") String serializerName,
			@WebParam(name = "sync", partName = "downloadCompareResults.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in serialized format by giving a set of revisions and a set of class names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param classNames A set of class names to filter on (e.g. "IfcWindow")
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param includeAllSubtypes Whether to query all (recursive) subtypes of each gives class
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByTypes")
	Integer downloadByTypes(
			@WebParam(name = "roids", partName = "downloadByTypes.roids") Set<Long> roids,
			@WebParam(name = "classNames", partName = "downloadByTypes.classNames") Set<String> classNames,
			@WebParam(name = "serializerName", partName = "downloadByTypes.serializerName") String serializerName,
			@WebParam(name = "includeAllSubtypes", partName = "downloadByTypes.includeAllSubtypes") Boolean includeAllSubtypes,
			@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisins and a set of guids to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param guids A set of IFC guids
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByGuids")
	Integer downloadByGuids(
			@WebParam(name = "roids", partName = "downloadByGuids.roids") Set<Long> roids,
			@WebParam(name = "guids", partName = "downloadByGuids.guids") Set<String> guids,
			@WebParam(name = "serializerName", partName = "downloadByGuids.serializerName") String serializerName,
			@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisions
	 * @param roids A set of Revision ObjectIDs
	 * @param serializerName Name of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadRevisions")
	Integer downloadRevisions(
			@WebParam(name = "roids", partName = "downloadRevisions.roids") Set<Long> roids,
			@WebParam(name = "serializerName", partName = "downloadRevisions.serializerName") String serializerName,
			@WebParam(name = "sync", partName = "downloadRevisions.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Get the data for a download/checkout
	 * 
	 * Available as REST call
	 * 
	 * @param actionId The actionId returned by one of the download or checkout methods
	 * @return An SDownloadResult containing the serialized data
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getDownloadData")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(
			@QueryParam("actionId") @WebParam(name = "actionId", partName = "getDownloadData.actionId") Integer actionId) throws ServerException, UserException;

	/**
	 * Get the current state of a download/checkout
	 * @param actionId The ID returned by a download or checkout method
	 * @return A SLongActionState object containing details about the download/checkout 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDownloadState")
	SLongActionState getDownloadState(
			@WebParam(name = "actionId", partName = "getDownloadState.actionId") Integer actionId) throws ServerException, UserException;

	/**
	 * Add a new user
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @return The ObjectID of the created User object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUser")
	SUser addUser(
			@WebParam(name = "username", partName = "addUser.username") String username,
			@WebParam(name = "name", partName = "addUser.name") String name,
			@WebParam(name = "type", partName = "addUser.type") SUserType type,
			@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration) throws ServerException, UserException;

	/**
	 * Change the type of a user
	 * @param uoid The User's ObjectID
	 * @param userType The new type
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "changeUserType")
	void changeUserType(
			@WebParam(name = "uoid", partName = "changeUserType.uoid") Long uoid,
			@WebParam(name = "userType", partName = "changeUserType.userType") SUserType userType) throws ServerException, UserException;

	/**
	 * Add a new project
	 * @param projectName Name of the project, must be a unique name within all root-projects
	 * @return The created Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addProject")
	SProject addProject(
			@WebParam(name = "projectName", partName = "addProject.projectName") String projectName) throws ServerException, UserException;

	/**
	 * Add a new project as a subproject of another project
	 * @param projectName Name of the project, must be a unique name within the parent project
	 * @param parentPoid The ObjectID of the parent project
	 * @return The created Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(
			@WebParam(name = "projectName", partName = "addProjectAsSubProject.projectName") String projectName,
			@WebParam(name = "parentPoid", partName = "addProjectAsSubProject.parentPoid") Long parentPoid) throws ServerException, UserException;

	/**
	 * Update project properties
	 * @param sProject A Project object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateProject")
	void updateProject(
			@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws ServerException, UserException;

	/**
	 * Update a revision, not much can be changed afterwards, actually only the tag
	 * @param sRevision The Revision object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateRevision")
	void updateRevision(
			@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws ServerException, UserException;

	/**
	 * Add a user to a project (authorization wise)
	 * @param uoid The ObejctID of the User
	 * @param poid The ObjectID of the Project
	 * @return Whether the User has been added to the Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserToProject")
	Boolean addUserToProject(
			@WebParam(name = "uoid", partName = "addUserToProject.uoid") Long uoid,
			@WebParam(name = "poid", partName = "addUserToProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Remove a user from a project (authorization wise)
	 * @param uoid ObjectID of the User
	 * @param poid ObjectID of the Project
	 * @return Whether the User has been removed from the Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeUserFromProject")
	Boolean removeUserFromProject(
			@WebParam(name = "uoid", partName = "removeProjectFromUser.uoid") Long uoid,
			@WebParam(name = "poid", partName = "removeUserFromProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Delete a Project, Projects can be undeleted with the undeleteProject method
	 * @param poid ObjectID of the Project to delete
	 * @return Whether the Project has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteProject")
	Boolean deleteProject(
			@WebParam(name = "poid", partName = "deleteProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Delete a User, Users van be undeleted with the undeleteUser method
	 * @param uoid ObjectID of the User
	 * @return Whether the User has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteUser")
	Boolean deleteUser(
			@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of all Projects the user is authorized for
	 * 
	 * Available as REST call
	 * 
	 * @return A list of Projects
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getAllProjects")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws ServerException, UserException;

	/**
	 * 
	 * Available as REST call
	 * 
	 * Get a list of all Projects the user is authorized for to read from
	 * @return A list of all projects that are readable for the current user
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getAllReadableProjects")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServerException, UserException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServerException, UserException;

	/**
	 * Get a list of all Revisions of a Project
	 * 
	 * Available as REST call
	 * 
	 * @param poid ObjectID of the Project
	 * @return A list of all Revisions
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(
			@QueryParam("poid") @WebParam(name = "poid", partName = "getAllRevisionsOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param poid The ObjectID of the Project
	 * @return A list of Checkouts belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid)	throws ServerException, UserException;

	/**
	 * @param uoid ObjectID of the Project
	 * @return A list of Revisions belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(
			@WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * @param uoid ObjectID of the User
	 * @return A list of Checkouts belonging to the given User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(
			@WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of Checkouts belonging to the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(
			@WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid) throws ServerException, UserException;

	/**
	 * @param poid ObjectID of the Project
	 * @return The Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(
			@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return The Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRevision")
	SRevision getRevision(
			@WebParam(name = "roid", partName = "getRevision.roid") Long roid) throws ServerException, UserException;

	/**
	 * @return A list of available classes in the BIMserver, only classes from the IFC model will be returned
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of classes of which a least one instance is available in the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClassesInRevision")
	List<String> getAvailableClassesInRevision(Long roid) throws ServerException, UserException;
	
	/**
	 * Get information about the BIMserver database
	 * @return A SDatabaseInformation Object containing the information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDatabaseInformation")
	SDatabaseInformation getDatabaseInformation() throws ServerException, UserException;

	/**
	 * @return When the last database reset occurred
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLastDatabaseReset")
	Date getLastDatabaseReset() throws ServerException, UserException;

	/**
	 * @return The User that it currently loggedin on this ServiceInterface
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws ServerException, UserException;

	/**
	 * Get a list of all Projects the given User does not have authorization for
	 * @param uoid
	 * @return The list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(
			@WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Logout from this ServiceInterface (beware, the ServiceInterface is not closed and is still usable)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "logout")
	void logout() throws ServerException, UserException;

	/**
	 * Close this ServiceInterface instance (it is important to close ServiceInterfaces for obvious reasons)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "close")
	void close() throws ServerException, UserException;
	
	/**
	 * Change a User's password, not the preferred way, use requestPasswordChange for a safer version
	 * @param uoid The ObjectID of the User
	 * @param oldPassword The old password
	 * @param newPassword The new password
	 * @return Whether the password was successfully changed
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "changePassword")
	Boolean changePassword(
			@WebParam(name = "uoid", partName = "changePassword.uoid") Long uoid,
			@WebParam(name = "oldPassword", partName = "changePassword.oldPassword") String oldPassword,
			@WebParam(name = "newPassword", partName = "changePassword.newPassword") String newPassword) throws ServerException, UserException;

	/**
	 * Get a User by its UserNmae (e-mail address)
	 * @param username The username (must be a valid e-mail address)
	 * @return The SUser Object if found, otherwise null
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(
			@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws ServerException, UserException;

	/**
	 * Undelete a previously deleted Project, Projets can be deleted with the deleteProject method
	 * @param poid The ObjectID of the Project to undelete
	 * @return Whether the Project was successfully undeleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "undeleteProject")
	Boolean undeleteProject(
			@WebParam(name = "poid", partName = "undeleteProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Undelete a previously deleted User, Users can be deleted with the deleteUser method
	 * @param uoid
	 * @return Whether the deletion was successfull
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(
			@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Compare two models
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @return The result of the compare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compare")
	SCompareResult compare(
			@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
			@WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType, 
			@WebParam(name = "sCompareIdentifier", partName = "compare.sCompareIdentifier") SCompareIdentifier sCompareIdentifier) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A summary of the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(
			@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws ServerException, UserException;		

	/**
	 * @param poid ObjectID of the Project
	 * @return Whether the current use has checkin rights on the given Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "userHasCheckinRights")
	Boolean userHasCheckinRights(
			@WebParam(name = "poid", partName = "userHasCheckinRights.poid") Long poid) throws ServerException, UserException;

	/**
	 * Checkout warnings are given to users when checkouts are done by other users
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckoutWarnings")
	Set<String> getCheckoutWarnings(
			@WebParam(name = "poid", partName = "getCheckoutWarnings.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param poid ObjectID of the Project
	 * @return Whether the current User has rights on the given Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "userHasRights")
	Boolean userHasRights(
			@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(
			@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
			@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid,
			@WebParam(name = "className", partName = "getDataObjectByOid.className") String className) throws ServerException, UserException;

	/**
	 * Get DataObjects based on a list of GUIDs
	 * 
	 * Available as REST call
	 * 
	 * @param roid ObjectID of the Revision
	 * @param guid An IFC GUID
	 * @return The object with the given GUID in the given Revision, of null if not found
	 * @throws ServerException, UserException
	 */
	@GET
	@Path("/getDataObjectByGuid")
	@Produces({"application/xml", "application/json"})
	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(
			@QueryParam("roid") @WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
			@QueryParam("guid") @WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @param className Name of the class to query (e.g. "IfcWindow")
	 * @return A list of DataObjects from the given Revision matching the given class
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(
			@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
			@WebParam(name = "className", partName = "getDataObjectsByType.className") String className) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of DataObjects from the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDataObjects")
	List<SDataObject> getDataObjects(Long roid) throws ServerException, UserException;

	/**
	 * Perform clashdetection
	 * @param sClashDetectionSettings The settings for the ClashDetection, these include the Revisions to use
	 * @return A list of GuidClash objects describing the found clashes
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByGuid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException;

	/**
	 * @param sClashDetectionSettings The settings for the ClashDetection, these include the Revisions to use
	 * @return A list of EidClash objects describing the found clashes
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByEid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException;

	/**
	 * Get previously calculated clashes
	 * @param roid ObjectID of the Revision
	 * @return A list of Clash objects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(
			@WebParam(name = "roid", partName = "getLastClashes.roid") Long roid) throws ServerException, UserException;

	/**
	 * Branch a given Revision as a new Revision on a new Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param projectName Name of the to be created Project
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(
			@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
			@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
			@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment) throws ServerException, UserException;

	/**
	 * Branch a given Revision as a new Revision in the given Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param destPoid ObjectID of the Project to which a branch should be made
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(
			@WebParam(name = "roid", partName = "branchToExistingProject.roid") Long roid,
			@WebParam(name = "destPoid", partName = "branchToExistingProject.destPoid") Long destPoid,
			@WebParam(name = "comment", partName = "branchToExistingProject.comment") String comment) throws ServerException, UserException;

	/**
	 * @param goid The ObjectID of the GeoTag
	 * @return The GeoTag object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(
			@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws ServerException, UserException;

	/**
	 * @param sGeoTag A GeoTag object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(
			@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws ServerException, UserException;

	/**
	 * @param cdsoid The ObjectID of the ClashDetectionSettings object
	 * @return The ClashDetectionSettings object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(
			@WebParam(name = "cdsoid", partName = "getClashDetectionSettings.cdsoid") Long cdsoid) throws ServerException, UserException;

	/**
	 * @param sClashDetectionSettings A ClashDetectionSettings object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(
			@WebParam(name = "sClashDetectionSettings", partName = "updateClashDetectionSettings.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings) throws ServerException, UserException;

	/**
	 * @param uoid The ObjectID of the User
	 * @return The User with the given User ObjectID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(
			@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of all Users not authoriazed on the given Project
	 * @param poid The ObjectID of the Project
	 * @return A list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(
			@WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param poid
	 * @return A list of all users authorized on the given project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(
			@WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param uoid
	 * @return A list of projects a user has been authorized for
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(
			@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * @param name
	 * @return A list of projects with the given name (can be multiple because subprojects are also returned)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectsByName")
	List<SProject> getProjectsByName(
			@WebParam(name = "name", partName = "getProjectsByName.name") String name) throws ServerException, UserException;

	/**
	 * @param roid
	 * @param tag
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(
			@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
			@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws ServerException, UserException;

	/**
	 * @param poid
	 * @return A list of all subprojects of the given project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(
			@WebParam(name = "poid", partName = "getSubProjects.poid") Long poid) throws ServerException, UserException;

	/**
	 * @return The currently logged-in User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws ServerException, UserException;

	/**
	 * @return Whether this ServiceInterface is logged-in
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isLoggedIn")
	Boolean isLoggedIn() throws ServerException, UserException;

	/**
	 * @return Since when this ServiceInterface session has been active
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getActiveSince")
	Date getActiveSince() throws ServerException, UserException;

	/**
	 * @return When the session has been active for the last
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLastActive")
	Date getLastActive() throws ServerException, UserException;

	/**
	 * @return The Token used for this session
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCurrentToken")
	Token getCurrentToken() throws ServerException, UserException;

	/**
	 * @return The method of access this ServiceInterface is using (SOAP, REST, PB etc...)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws ServerException, UserException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws ServerException, UserException;

	/**
	 * Request a password change, an e-mail will be send with a validation url
	 * @param username The username of the user to change tot password for
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(
			@WebParam(name = "username", partName = "requestPasswordChange.username") String username) throws ServerException, UserException;

	/**
	 * @param uoid The ObejctID of the User
	 * @param token The token generated by requestPasswordChange
	 * @param password The new password
	 * @return A User object if the change is successful, null otherwise
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "validateAccount")
	SUser validateAccount(
			@WebParam(name = "uoid", partName = "validateAccount.uoid") Long uoid,
			@WebParam(name = "token", partName = "validateAccount.token") String token,
			@WebParam(name = "password", partName = "validateAccount.password") String password) throws ServerException, UserException;

	/**
	 * Send an e-mail to a set of Users with the results of a clashdetection
	 * @param sClashDetectionSettings The settings to use for the ClashDetection
	 * @param poid ObjectID of the Project
	 * @param addressesTo A set of String containing the e-mail addresses
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "sendClashesEmail")
	void sendClashesEmail(
			@WebParam(name = "sClashDetectionSettings", partName = "sendClashesEmail.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "addressesTo", partName = "sendClashesEmail.addressesTo") Set<String> addressesTo) throws ServerException, UserException;

	/**
	 * Send an e-mail with the results of a compare
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sCompareIdentifier How to identify equal objects (by Guid or by Name)
	 * @param poid The ObjectID of the Project
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param address The e-mail address to send the e-mail to
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "sendCompareEmail")
	void sendCompareEmail(
			@WebParam(name = "sCompareType", partName = "sendClashesEmail.sCompareType") SCompareType sCompareType,
			@WebParam(name = "sCompareIdentifier", partName = "sendClashesEmail.sCompareIdentifier") SCompareIdentifier sCompareIdentifier,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
			@WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws ServerException, UserException;
	
	/**
	 * Setup this BIMserver
	 * @param siteAddress The address the server will be reachable at (for example: http://demo.bimserver.org)
	 * @param smtpServer The address of the SMTP server that wil be used for sending e-mails
	 * @param adminName Name of the admin User (e.g. "Administrator")
	 * @param adminUsername Username of the admin User (must be a valid e-mail address)
	 * @param adminPassword Password of the admin User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setup")
	void setup(@WebParam(name = "siteAddress", partName = "setup.siteAddress") String siteAddress,
			@WebParam(name = "smtpServer", partName = "setup.smtpServer") String smtpServer,
			@WebParam(name = "adminName", partName = "setup.adminName") String adminName,
			@WebParam(name = "adminUsername", partName = "setup.adminUsername") String adminUsername,
			@WebParam(name = "adminPassword", partName = "setup.adminPassword") String adminPassword) throws ServerException, UserException;

	/**
	 * @return The location of a custom Logo (URL) for the BIMserver
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingsCustomLogoAddress")
	String getSettingCustomLogoAddress() throws ServerException, UserException;

	/**
	 * @param customLogoAddress The new location for the custom logo
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsCustomLogoAddress")
	void setSettingCustomLogoAddress(
			@WebParam(name = "customLogoAddress", partName = "setSettingsCustomLogoAddress.customLogoAddress") String customLogoAddress) throws ServerException, UserException;

	/**
	 * @return An addition to the JSP header
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingHeaderAddition")
	String getSettingHeaderAddition() throws ServerException, UserException;

	
	/**
	 * @param headerAddition The new header addition
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingHeaderAddition")
	void setSettingHeaderAddition (
			@WebParam(name = "headerAddition", partName = "setSettingHeaderAddition.headerAddition") String headerAddition) throws ServerException, UserException;

	/**
	 * @return An addition to the JSP footer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingFooterAddition")
	String getSettingFooterAddition() throws ServerException, UserException;

	/**
	 * @param footerAddition The new footer addition
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingFooterAddition")
	void setSettingFooterAddition(
			@WebParam(name = "footerAddition", partName = "setSettingFooterAddition.footerAddition") String footerAddition) throws ServerException, UserException;

	/**
	 * @param mergeIdentifier
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingMergeIdentifier")
	void setSettingMergeIdentifier(
			@WebParam(name = "mergeIdentifier", partName = "setSettingMergeIdentifier.mergeIdentifier") SMergeIdentifier mergeIdentifier) throws ServerException, UserException;

	@WebMethod(action = "getSettingsEmailSenderAddress")
	String getSettingEmailSenderAddress() throws ServerException, UserException;

	/**
	 * @param emailSenderAddress The new e-mail address e-mail will be sent from
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsEmailSenderAddress")
	void setSettingEmailSenderAddress(
			@WebParam(name = "emailSenderAddress", partName = "setSettingsEmailSenderAddress.emailSenderAddress") String emailSenderAddress) throws ServerException, UserException;

	/**
	 * @return The registration addition text
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingsRegistrationAddition")
	String getSettingRegistrationAddition() throws ServerException, UserException;

	/**
	 * @param registrationAddition The new registration addition text
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsRegistrationAddition")
	void setSettingRegistrationAddition(
			@WebParam(name = "registrationAddition", partName = "setSettingsRegistrationAddition.registrationAddition") String registrationAddition) throws ServerException, UserException;

	/**
	 * @return The port on which the ProtocolBuffers server runs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingProtocolBuffersPort")
	Integer getSettingProtocolBuffersPort() throws ServerException, UserException;

	/**
	 * @param port Set the port the ProtocolBuffers server runs on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsProtocolBuffersPort")
	void setSettingProtocolBuffersPort(
			@WebParam(name = "port", partName = "setSettingsProtocolBuffersPort.port") Integer port) throws ServerException, UserException;
	
	/**
	 * @return The address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingsSiteAddress")
	String getSettingSiteAddress() throws ServerException, UserException;

	/**
	 * @param siteAddress The new address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsSiteAddress")
	void setSettingSiteAddress(
			@WebParam(name = "siteAddress", partName = "setSettingsSiteAddress.siteAddress") String siteAddress) throws ServerException, UserException;

	/**
	 * @return Address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingsSmtpServer")
	String getSettingSmtpServer() throws ServerException, UserException;

	/**
	 * @param smtpServer New address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingsSmtpServer")
	void setSettingSmtpServer(
			@WebParam(name = "smtpServer", partName = "setSettingsSmtpServer.smtpServer") String smtpServer) throws ServerException, UserException;

	/**
	 * @return Whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingAllowSelfRegistration")
	Boolean isSettingAllowSelfRegistration() throws ServerException, UserException;

	/**
	 * @param allowSelfRegistration Change whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingAllowSelfRegistration")
	void setSettingAllowSelfRegistration(
			@WebParam(name = "allowSelfRegistration", partName = "setSettingAllowSelfRegistration.allowSelfRegistration") Boolean allowSelfRegistration)throws ServerException, UserException;

	/**
	 * @return Whether to hide user lists (pricacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingHideUserListForNonAdmin")
	Boolean isSettingHideUserListForNonAdmin() throws ServerException, UserException;

	/**
	 * @param hideUserListForNonAdmin Set whether user lists should be hidden (privacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingHideUserListForNonAdmin")
	void setSettingHideUserListForNonAdmin(
			@WebParam(name = "hideUserListForNonAdmin", partName = "setSettingHideUserListForNonAdmin.hideUserListForNonAdmin") Boolean hideUserListForNonAdmin) throws ServerException, UserException;

	/**
	 * @return Whether a user can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingAllowUsersToCreateTopLevelProjects")
	Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServerException, UserException;

	/**
	 * @param allowUsersToCreateTopLevelProjects Set if users can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingAllowUsersToCreateTopLevelProjects")
	void setSettingAllowUsersToCreateTopLevelProjects(
			@WebParam(name = "allowUsersToCreateTopLevelProjects", partName = "setSettingAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects") Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException;

	/**
	 * @return Whether the BIMserver should do checkin merging (warning: this will alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingCheckinMergingEnabled")
	Boolean isSettingCheckinMergingEnabled() throws ServerException, UserException;

	/**
	 * @param checkinMergingEnabled Set whether the BIMserver should do checkin merging (warning: this wil alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingCheckinMergingEnabled")
	void setSettingCheckinMergingEnabled(
			@WebParam(name = "checkinMergingEnabled", partName = "setSettingCheckinMergingEnabled.checkinMergingEnabled") Boolean checkinMergingEnabled) throws ServerException, UserException;

	/**
	 * @return Whether intelligent merging is on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingIntelligentMerging")
	Boolean isSettingIntelligentMerging() throws ServerException, UserException;

	/**
	 * @param intelligentMerging Set intelligent merging on/off
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingIntelligentMerging")
	void setSettingIntelligentMerging(
			@WebParam(name = "intelligentMerging", partName = "setSettingIntelligentMerging.intelligentMerging") Boolean intelligentMerging) throws ServerException, UserException;

	/**
	 * @return Whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingSendConfirmationEmailAfterRegistration")
	Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServerException, UserException;

	/**
	 * @param sendConfirmationEmailAfterRegistration Set whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingSendConfirmationEmailAfterRegistration")
	void setSettingSendConfirmationEmailAfterRegistration(
			@WebParam(name = "sendConfirmationEmailAfterRegistration", partName = "setSettingSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration") Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException;

	/**
	 * @return Whether it should be shown to the user that a new version of the BIMserver is available
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingShowVersionUpgradeAvailable")
	Boolean isSettingShowVersionUpgradeAvailable() throws ServerException, UserException;

	/**
	 * @param showVersionUpgradeAvailable Set whether it should be shown to the user that a new version of the BIMserver is available
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingShowVersionUpgradeAvailable")
	void setSettingShowVersionUpgradeAvailable(
			@WebParam(name = "showVersionUpgradeAvailable", partName = "setSettingShowVersionUpgradeAvailable.showVersionUpgradeAvailable") Boolean showVersionUpgradeAvailable) throws ServerException, UserException;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isCacheOutputFiles")
	Boolean isSettingCacheOutputFiles() throws ServerException, UserException;

	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setCacheOutputFiles")
	void setSettingCacheOutputFiles(
			@WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles) throws ServerException, UserException;
	
	/**
	 * @return A list with all Log objects, Log objects contain information about action performed on the BIMserver like ProjectAdded, UserAdded etc...
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws ServerException, UserException;

	/**
	 * @return A list with the currently active User sessions
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getActiveUserSessions")
	List<SUserSession> getActiveUserSessions() throws ServerException, UserException;

	/**
	 * @return A list with the currently running Long actions
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getActiveLongActions")
	List<SLongAction> getActiveLongActions() throws ServerException, UserException;

	/**
	 * @return A list of all Migrations (either executed or not)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getMigrations")
	List<SMigration> getMigrations() throws ServerException, UserException;

	/**
	 * This will try to upgrade the database to the latest revision, this method will do nothing if the database schema is already up-to-date
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "migrateDatabase")
	void migrateDatabase() throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializers")
	List<SSerializer> getAllSerializers(
			@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	

	/**
	 * @param onlyEnabled Whether to only include enabled IFC engines
	 * @return A list of IfcEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllIfcEngines")
	List<SIfcEngine> getAllIfcEngines(
			@WebParam(name = "onlyEnabled", partName = "getAllIfcEngines.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerById")
	SSerializer getSerializerById(
			@WebParam(name = "oid", partName = "getSerializerById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIfcEngineById")
	SIfcEngine getIfcEngineById(
			@WebParam(name = "oid", partName = "getIfcEngineById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerById")
	SDeserializer getDeserializerById(
			@WebParam(name = "oid", partName = "getDeserializerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param serializer Serializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addSerializer")
	void addSerializer(
			@WebParam(name = "serializer", partName = "addSerializer.serializer") SSerializer serializer) throws ServerException, UserException;
	
	/**
	 * @param ifcEngine IfcEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addIfcEngine")
	void addIfcEngine(
			@WebParam(name = "ifcEngine", partName = "addIfcEngine.ifcEngine") SIfcEngine ifcEngine) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addSerializer")
	void addDeserializer(
			@WebParam(name = "deserializer", partName = "addDeserializer.deserializer") SDeserializer deserializer) throws ServerException, UserException;

	/**
	 * @param serializer Serializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateSerializer")
	void updateSerializer(
			@WebParam(name = "serializer", partName = "updateSerializer.serializer") SSerializer serializer) throws ServerException, UserException;

	/**
	 * @param ifcEngine IfcEngine to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateIfcEngine")
	void updateIfcEngine(
			@WebParam(name = "ifcEngine", partName = "updateIfcEngine.ifcEngine") SIfcEngine ifcEngine) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateDeserializer")
	void updateDeserializer(
			@WebParam(name = "deserializer", partName = "updateDeserializer.deserializer") SDeserializer deserializer) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to include only enabled ObjectIDMs
	 * @return A list of ObjectIDMs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllObjectIDMs")
	List<SObjectIDM> getAllObjectIDMs(
			@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMById")
	SObjectIDM getObjectIDMById(
			@WebParam(name = "oid", partName = "getObjectIDMById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addObjectIDM")
	void addObjectIDM(
			@WebParam(name = "objectIDM", partName = "addObjectIDM.objectIDM") SObjectIDM objectIDM) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateObjectIDM")
	void updateObjectIDM(
			@WebParam(name = "objectIDM", partName = "updateObjectIDM.objectIDM") SObjectIDM objectIDM) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteObjectIDM")
	void deleteObjectIDM(
			@WebParam(name = "oid", partName = "deleteObjectIDM.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param sid ObjectID of the Serializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(
			@WebParam(name = "sid", partName = "deleteSerializer.sid") Long sid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the IfcEngine to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteIfcEngine")
	void deleteIfcEngine(
			@WebParam(name = "iid", partName = "deleteIfcEngine.iid") Long iid) throws ServerException, UserException;
	
	/**
	 * @param sid ObjectID of the Deserializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteDeserializer")
	void deleteDeserializer(
			@WebParam(name = "sid", partName = "deleteDeserializer.sid") Long sid) throws ServerException, UserException;

	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializerPluginDescriptors")
	List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllIfcEnginePluginDescriptors")
	List<SIfcEnginePluginDescriptor> getAllIfcEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all DeserializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializerClassNames")
	List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return A settings that determines how to merge
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingMergeIdentifier")
	SMergeIdentifier getSettingMergeIdentifier() throws ServerException, UserException;

	/**
	 * @param serializerName Name of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByName")
	SSerializer getSerializerByName(
			@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws ServerException, UserException;

	/**
	 * @param name Name of the IfcEngine
	 * @return IfcEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIfcEngineByName")
	SIfcEngine getIfcEngineByName(
			@WebParam(name = "serializerName", partName = "getIfcEngineByName.name") String name) throws ServerException, UserException;

	/**
	 * @param objectIDMName Name of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMByName")
	SObjectIDM getObjectIDMByName(
			@WebParam(name = "objectIDMName", partName = "getObjectIDMByName.objectIDMName") String objectIDMName) throws ServerException, UserException;

	/**
	 * @param deserializerName Name of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerByName")
	SDeserializer getDeserializerByName(
			@WebParam(name = "deserializerName", partName = "getDeserializerByName.deserializerName") String deserializerName) throws ServerException, UserException;

	/**
	 * @param contentType Content type
	 * @return Whether there is an active Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(String contentType) throws ServerException, UserException;
	
	/**
	 * @return A list of all plugins
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllPlugins")
	List<SPluginDescriptor> getAllPlugins() throws ServerException, UserException;
	
	/**
	 * @param name Name of the plugin to enable
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "enablePlugin")
	void enablePlugin(String name) throws ServerException, UserException;
	
	/**
	 * @param name Name of the plugin to disable
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "disablePlugin")
	void disablePlugin(String name) throws ServerException, UserException;

	/**
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByContentType")
	SSerializer getSerializerByContentType(
			@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws ServerException, UserException;
	
	/**
	 * @param pid ObjectID of the Project to start a transaction on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "startTransaction")
	void startTransaction(
			@WebParam(name = "poid", partName = "startTransaction.poid") Long poid) throws ServerException, UserException;

	/**
	 * Commit the current transaction, changes will be saved, a transaction must be started by startTransaction first
	 * @param comment Comment describing what has changed
	 * @return ObjectID of the Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "commitTransaction")
	Long commitTransaction(
			@WebParam(name = "comment", partName = "commitTransaction.comment") String comment) throws ServerException, UserException;
	
	/**
	 * Abort the current transaction, changes will not be saved
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "abortTransaction")
	void abortTransaction() throws ServerException, UserException;
	
	/**
	 * Create a new Object
	 * @param className The type of the new object
	 * @return The ObjectID of the newly created object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "createObject")
	Long createObject(
			@WebParam(name = "className", partName = "createObject.className") String className) throws ServerException, UserException;
	
	/**
	 * Remove an object
	 * @param className ClassName of the Object, this parameter is required for performance reasons only, but is required 
	 * @param oid ObjectID of the object to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeObject")
	void removeObject(
			@WebParam(name = "className", partName = "removeObject.className") String className, 
			@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
			@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttribute")
	void setDoubleAttribute(
			@WebParam(name = "oid", partName = "setDoubleAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setDoubleAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setDoubleAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Enum value (name of the enum item)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setEnumAttribute")
	void setEnumAttribute(
			@WebParam(name = "oid", partName = "setEnumAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setEnumAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setEnumAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setEnumAttribute.value") String value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
			@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
			@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @param referenceClassName Type of the newly referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setReference")
	void setReference(
			@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
			@WebParam(name = "className", partName = "setReference.className") String className, 
			@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid, 
			@WebParam(name = "referenceClassName", partName = "setReference.referenceClassName") String referenceClassName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to unset
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
			@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "unsetAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference to unset (null)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetReference")
	void unsetReference(
			@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
			@WebParam(name = "className", partName = "unsetReference.className") String className,
			@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
			@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDoubleAttribute")
	void addDoubleAttribute(
			@WebParam(name = "oid", partName = "addDoubleAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addDoubleAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addDoubleAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
			@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
			@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference to add a reference to
	 * @param referenceOid ObjectID of the newly referenced Object
	 * @param referenceClassName Type of the newly referenced Object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addReference")
	void addReference(
			@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
			@WebParam(name = "className", partName = "addReference.className") String className, 
			@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid,
			@WebParam(name = "referenceClassName", partName = "addReference.referenceClassName") String referenceClassName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param attributeName Name of the attribute from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
			@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "removeAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
			@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param className Type of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeReference")
	void removeReference(
			@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
			@WebParam(name = "className", partName = "removeReference.className") String className, 
			@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
			@WebParam(name = "index", partName = "removeReference.index") Integer index) throws ServerException, UserException;
	
	/**
	 * @return The Date when the BIMserver was last started
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getServerStartTime")
	Date getServerStartTime() throws ServerException, UserException;
	
	/**
	 * @param type The type
	 * @return SSerializerPluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerPluginDescriptor")
	SSerializerPluginDescriptor getSerializerPluginDescriptor(
			@WebParam(name = "type", partName = "getSerializerPluginDescriptor.type") String type) throws ServerException, UserException;
	
	/**
	 * @return A list of available IDMPlugins
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllObjectIDMPluginDescriptors")
	List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled deserializers
	 * @return A list of all available deserializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializers")
	List<SDeserializer> getAllDeserializers(
			@WebParam(name = "oid", partName = "removeReference.oid") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param uoid ObjectID of the User to change the callBack URL for
	 * @param address Address of the callback server (e.g. localhost:2000)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setHttpCallback")
	void setHttpCallback(
			@WebParam(name = "uoid", partName = "setHttpCallback.uoid") Long uoid, 
			@WebParam(name = "address", partName = "setHttpCallback.address") String address) throws ServerException, UserException;
	
	/**
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return SCompileResult
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compile")
	SCompileResult compile(
			@WebParam(name = "code", partName = "compile.code") String code) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision to perform this query on
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return SRunResult
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compileAndRun")
	SRunResult compileAndRun(
			@WebParam(name = "roid", partName = "compileAndRun.roid") Long roid, 
			@WebParam(name = "code", partName = "compileAndRun.code") String code) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision to perform this query on
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return A download id, which can be used in getDownloadState and getDownloadData
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compileAndDownload")
	Integer compileAndDownload(
			@WebParam(name = "roid", partName = "compileAndDownload.roid") Long roid, 
			@WebParam(name = "code", partName = "compileAndDownload.code") String code) throws ServerException, UserException;
	
	/**
	 * Thsi will return the content of the .proto file (equivalent for SOAP's WSDL) for the ProtocolBuffers interface
	 * @return Returns a serialized version of the .proto file for the ServiceInterface
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProtocolBuffersFile")
	String getProtocolBuffersFile() throws ServerException, UserException;
	
	/**
	 * Get information about this BIMserver's state
	 * @return A SServerInfo object containing information about the current state
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getServerInfo")
	SServerInfo getServerInfo() throws ServerException, UserException;
	
	/**
	 * Get the actual version of this BIMserver
	 * @return A SVersion object containg the version information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getVersion")
	SVersion getVersion() throws ServerException, UserException;
	
	/**
	 * Check which version of BIMserver is the latest available (will download an XML file from bimserver.org)
	 * @return A SVersion object containing the version information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLatestVersion")
	SVersion getLatestVersion() throws ServerException, UserException;
	
	/**
	 * Check whether an upgrade of the BIMserver is available (will download an XML file from bimserver.org)
	 * @return Whether a new version is available
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "upgradePossible")
	Boolean upgradePossible() throws ServerException, UserException;

	/**
	 * Get the remove address (which is actually the address the server thinks the client is connecting from)
	 * @return A string with a hostname or ip address
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRemoteAddress")
	String getRemoteAddress() throws ServerException, UserException;

	/**
	 * @return The BIMserver log (can be big)
	 * @throws ServerException 
	 */
	@WebMethod(action = "getServerLog")
	String getServerLog() throws ServerException, UserException;
	
	/**
	 * @return The name of the suggested deserializer
	 * @throws ServerException 
	 */
	@WebMethod(action = "getSuggestedDeserializerForExtension")
	String getSuggestedDeserializerForExtension(String extension) throws ServerException, UserException;

	/**
	 * Checkin warnings are given to users
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckinWarnings")
	Set<String> getCheckinWarnings(@WebParam(name = "poid", partName = "getCheckinWarnings.poid") Long poid) throws ServerException, UserException;
}