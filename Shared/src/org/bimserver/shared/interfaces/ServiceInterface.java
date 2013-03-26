package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SServicePluginDescriptor;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

/**
 * This interface defines all functions that are made available via SOAP and Protocol Buffers, but
 * also used by the JSP web interface
 */
@WebService(name = "serviceinterface")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface extends PublicInterface {
	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param ifcFile The actual file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkin")
	Long checkin(
		@WebParam(name = "poid", partName = "checkin.poid") Long poid,
		@WebParam(name = "comment", partName = "checkin.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkin.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileSize", partName = "checkin.fileSize") Long fileSize,
		@WebParam(name = "fileName", partName = "checkin.fileName") String fileName,
		@WebParam(name = "ifcFile", partName = "checkin.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
		@WebParam(name = "merge", partName = "checkin.merge") Boolean merge,
		@WebParam(name = "sync", partName = "checkin.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param url A URL to the file
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinFromUrl")
	Long checkinFromUrl(
		@WebParam(name = "poid", partName = "checkinFromUrl.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinFromUrl.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinFromUrl.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileName", partName = "checkinFromUrl.fileName") String fileName,
		@WebParam(name = "url", partName = "checkinFromUrl.url") String url,
		@WebParam(name = "merge", partName = "checkinFromUrl.merge") Boolean merge,
		@WebParam(name = "sync", partName = "checkinFromUrl.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Checkout an existing model, cehckout is the same as download, except a "checkout" will tell the server and other users you are working on it
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkout")
	Long checkout(
		@WebParam(name = "roid", partName = "checkout.roid") Long roid,
		@WebParam(name = "serializerOid", partName = "checkout.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "checkout.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Same as checkout, only this will automatically select the last revision to checkout
	 * 
	 * @param poid Project ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkoutLastRevision")
	Long checkoutLastRevision(
		@WebParam(name = "poid", partName = "checkoutLastRevision.poid") Long poid,
		@WebParam(name = "serializerOid", partName = "checkoutLastRevision.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "checkoutLastRevision.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a single revision of a model in a serialized format
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param showOwn Whether to return revisions created by the current user
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "download")
	Long download(
		@WebParam(name = "roid", partName = "download.roid") Long roid,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "showOwn", partName = "download.showOwn") Boolean showOwn,
		@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;

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
	Long downloadCompareResults(
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "roid1", partName = "downloadByOids.roid1") Long roid1,
		@WebParam(name = "roid2", partName = "downloadByOids.roid2") Long roid2,
		@WebParam(name = "mcid", partName = "downloadByOids.mcid") Long mcid,
		@WebParam(name = "type", partName = "downloadByOids.type") SCompareType type,
		@WebParam(name = "sync", partName = "downloadByOids.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of Object IDs
	 * NOTE: This is a potentially slow method because the classes of the objects are not given
	 * @param roids A set of Revision ObjectIDs
	 * @param oids A set of ObjectIDs
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByOids")
	Long downloadByOids(
		@WebParam(name = "roids", partName = "downloadCompareResults.roids") Set<Long> roids,
		@WebParam(name = "oids", partName = "downloadCompareResults.oids") Set<Long> oids,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "downloadCompareResults.sync") Boolean sync,
		@WebParam(name = "deep", partName = "downloadCompareResults.deep") Boolean deep) throws ServerException, UserException;

	/**
	 * Download a model in serialized format by giving a set of revisions and a set of class names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param classNames A set of class names to filter on (e.g. "IfcWindow")
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param includeAllSubtypes Whether to query all (recursive) subtypes of each gives class
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByTypes")
	Long downloadByTypes(
		@WebParam(name = "roids", partName = "downloadByTypes.roids") Set<Long> roids,
		@WebParam(name = "classNames", partName = "downloadByTypes.classNames") Set<String> classNames,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "includeAllSubtypes", partName = "downloadByTypes.includeAllSubtypes") Boolean includeAllSubtypes,
		@WebParam(name = "useObjectIDM", partName = "downloadByTypes.useObjectIDM") Boolean useObjectIDM,
		@WebParam(name = "deep", partName = "downloadByTypes.deep") Boolean deep,
		@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of guids to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param guids A set of IFC guids
	 * @param serializerOid OID of the serializer to use
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByGuids")
	Long downloadByGuids(
		@WebParam(name = "roids", partName = "downloadByGuids.roids") Set<Long> roids,
		@WebParam(name = "guids", partName = "downloadByGuids.guids") Set<String> guids,
		@WebParam(name = "serializerOid", partName = "downloadByGuids.serializerOid") Long serializerOid,
		@WebParam(name = "deep", partName = "downloadByGuids.deep") Boolean deep,
		@WebParam(name = "sync", partName = "downloadByGuids.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param names A set of names, the names should be exact matches for now
	 * @param serializerOid OID of the serializer to use
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByNames")
	Long downloadByNames(
		@WebParam(name = "roids", partName = "downloadByNames.roids") Set<Long> roids,
		@WebParam(name = "names", partName = "downloadByNames.names") Set<String> names,
		@WebParam(name = "serializerOid", partName = "downloadByNames.serializerOid") Long serializerOid,
		@WebParam(name = "deep", partName = "downloadByNames.deep") Boolean deep,
		@WebParam(name = "sync", partName = "downloadByNames.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Download a model in a serialized format by giving a set of revisions
	 * @param roids A set of Revision ObjectIDs
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return An id, which you can use for the getDownloadState and getDownloadData methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadRevisions")
	Long downloadRevisions(
		@WebParam(name = "roids", partName = "downloadRevisions.roids") Set<Long> roids,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "downloadRevisions.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Get the data for a download/checkout
	 * 
	 * @param actionId The actionId returned by one of the download or checkout methods
	 * @return An SDownloadResult containing the serialized data
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(
		@WebParam(name = "actionId", partName = "getDownloadData.actionId") Long actionId) throws ServerException, UserException;

	/**
	 * Get the current state of a download/checkout
	 * @param actionId The ID returned by a download or checkout method
	 * @return A SLongActionState object containing details about the download/checkout 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLongActionState")
	SLongActionState getLongActionState(
		@WebParam(name = "actionId", partName = "getLongActionState.actionId") Long actionId) throws ServerException, UserException;

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
	 * Update project properties, the only three properties that can be updated with this call are "name", "description" and "exportLengthMeasurePrefix"
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
	 * @return A list of Projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects(
		@WebParam(name = "onlyTopLevel", partName = "getAllProjects.onlyTopLevel") Boolean onlyTopLevel) throws ServerException, UserException;

	/**
	 * 
	 * Get a list of all Projects the user is authorized for to read from
	 * @return A list of all projects that are readable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServerException, UserException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServerException, UserException;

	/**
	 * Get a list of all Revisions of a Project
	 * 
	 * @param poid ObjectID of the Project
	 * @return A list of all Revisions
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(
		@WebParam(name = "poid", partName = "getAllRevisionsOfProject.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getAllServicesOfProject")
	List<SService> getAllServicesOfProject(
		@WebParam(name = "poid", partName = "getAllServicesOfProject.poid") Long poid) throws ServerException, UserException;
	
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
	List<String> getAvailableClassesInRevision(
		@WebParam(name = "roid", partName = "getAvailableClassesInRevision.roid") Long roid) throws ServerException, UserException;

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
		@WebParam(name = "mcid", partName = "compare.mcid") Long mcid) throws ServerException, UserException;

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
		@WebParam(name = "uoid", partName = "userHasCheckinRights.uoid") Long uoid, 
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

	/**
	 * Branch a given Revision as a new Revision on a new Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param projectName Name of the to be created Project
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "branchToNewProject")
	Long branchToNewProject(
		@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
		@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
		@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment,
		@WebParam(name = "sync", partName = "branchToNewProject.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Branch a given Revision as a new Revision in the given Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param destPoid ObjectID of the Project to which a branch should be made
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "branchToExistingProject")
	Long branchToExistingProject(
		@WebParam(name = "roid", partName = "branchToExistingProject.roid") Long roid,
		@WebParam(name = "destPoid", partName = "branchToExistingProject.destPoid") Long destPoid,
		@WebParam(name = "comment", partName = "branchToExistingProject.comment") String comment,
		@WebParam(name = "sync", partName = "branchToNewProject.sync") Boolean sync) throws ServerException, UserException;

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
		@WebParam(name = "username", partName = "requestPasswordChange.username") String username,
		@WebParam(name = "resetUrl", partName = "requestPasswordChange.resetUrl") String resetUrl) throws ServerException, UserException;

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
		@WebParam(name = "mcid", partName = "sendClashesEmail.mcid") Long mcid,
		@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
		@WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
		@WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
		@WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializers")
	List<SSerializerPluginConfiguration> getAllSerializers(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled IFC engines
	 * @return A list of RenderEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRenderEngines")
	List<SRenderEnginePluginConfiguration> getAllRenderEngines(
		@WebParam(name = "onlyEnabled", partName = "getAllRenderEngines.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllQueryEngines")
	List<SQueryEnginePluginConfiguration> getAllQueryEngines(
		@WebParam(name = "onlyEnabled", partName = "getAllQueryEngines.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled model mergers
	 * @return A list of SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelMergers")
	List<SModelMergerPluginConfiguration> getAllModelMergers(
		@WebParam(name = "onlyEnabled", partName = "getAllModelMergers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled model compare
	 * @return A list of SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelCompares")
	List<SModelComparePluginConfiguration> getAllModelCompares(
		@WebParam(name = "onlyEnabled", partName = "getAllModelCompares.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExampleKeys")
	List<String> getQueryEngineExampleKeys(
		@WebParam(name = "qeid", partName = "getQueryEngineExampleKeys.qeid") Long qeid) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExample")
	String getQueryEngineExample(
		@WebParam(name = "qeid", partName = "getQueryEngineExample.qeid") Long qeid,
		@WebParam(name = "key", partName = "getQueryEngineExample.key") String key) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerById")
	SSerializerPluginConfiguration getSerializerById(
		@WebParam(name = "oid", partName = "getSerializerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ExtendedDataSchema
	 * @return ExtendedDataSchema
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getExtendedDataSchemaById")
	SExtendedDataSchema getExtendedDataSchemaById(
		@WebParam(name = "oid", partName = "getExtendedDataSchemaById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ExtendedData
	 * @return ExtendedData
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getExtendedData")
	SExtendedData getExtendedData(
		@WebParam(name = "oid", partName = "getExtendedData.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return ExtendedData
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllExtendedDataOfRevision")
	List<SExtendedData> getAllExtendedDataOfRevision(
		@WebParam(name = "roid", partName = "getAllExtendedDataOfRevision.roid") Long roid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the RenderEngine
	 * @return RenderEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRenderEngineById")
	SRenderEnginePluginConfiguration getRenderEngineById(
		@WebParam(name = "oid", partName = "getRenderEngineById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the QueryEngine
	 * @return QueryEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineById")
	SQueryEnginePluginConfiguration getQueryEngineById(
		@WebParam(name = "oid", partName = "getQueryEngineById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ModelMerger
	 * @return SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelMergerById")
	SModelMergerPluginConfiguration getModelMergerById(
		@WebParam(name = "oid", partName = "getModelMergerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ModelCompare
	 * @return SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelCompareById")
	SModelComparePluginConfiguration getModelCompareById(
		@WebParam(name = "oid", partName = "getModelCompareById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerById")
	SDeserializerPluginConfiguration getDeserializerById(
		@WebParam(name = "oid", partName = "getDeserializerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param serializer Serializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addSerializer")
	void addSerializer(
		@WebParam(name = "serializer", partName = "addSerializer.serializer") SSerializerPluginConfiguration serializer) throws ServerException, UserException;

	/**
	 * @param extendedDataSchema ExtendedDataSchema to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataSchema")
	void addExtendedDataSchema(
		@WebParam(name = "extendedDataSchema", partName = "addExtendedDataSchema.extendedDataSchema") SExtendedDataSchema extendedDataSchema) throws ServerException, UserException;

	/**
	 * @param uoid ObjectID of the User
	 * @param edsid ObjectID of the ExtendedDataSchema
	 * @throws UserException 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserToExtendedDataSchema")
	void addUserToExtendedDataSchema(
		@WebParam(name = "uoid", partName = "addUserToExtendedDataSchema.uoid") Long uoid,
		@WebParam(name = "edsid", partName = "addUserToExtendedDataSchema.edsid") Long edsid) throws ServerException, UserException;
	
	/**
	 * @param uoid ObjectID of the User
	 * @param edsid ObjectID of the ExtendedDataSchema
	 * @throws UserException 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeUserFromExtendedDataSchema")
	void removeUserFromExtendedDataSchema(
		@WebParam(name = "uoid", partName = "removeUserFromExtendedDataSchema.uoid") Long uoid,
		@WebParam(name = "edsid", partName = "removeUserFromExtendedDataSchema.edsid") Long edsid) throws ServerException, UserException;
	
	/**
	 * @param roid ObjectID of the Revision
	 * @param extendedData ExtendedData to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataToRevision")
	void addExtendedDataToRevision(
		@WebParam(name = "roid", partName = "addExtendedDataToRevision.roid") Long roid,
		@WebParam(name = "extendedData", partName = "addExtendedDataToRevision.extendedData") SExtendedData extendedData) throws ServerException, UserException;

	@WebMethod(action = "getExtendedDataSchemaByNamespace")
	SExtendedDataSchema getExtendedDataSchemaByNamespace(
		@WebParam(name = "namespace", partName = "getExtendedDataSchemaByNamespace.namespace") String namespace) throws UserException, ServerException;

	@WebMethod(action = "getExtendedDataSchemaFromRepository")
	SExtendedDataSchema getExtendedDataSchemaFromRepository(
		@WebParam(name = "namespace", partName = "getExtendedDataSchemaFromRepository.namespace") String namespace) throws UserException, ServerException;
	
	/**
	 * @param roid ObjectID of the Revision
	 * @param extendedData ExtendedData to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataToProject")
	void addExtendedDataToProject(
		@WebParam(name = "poid", partName = "addExtendedDataToProject.poid") Long poid,
		@WebParam(name = "extendedData", partName = "addExtendedDataToProject.extendedData") SExtendedData extendedData) throws ServerException, UserException;
	
	/**
	 * @param renderEngine RenderEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addRenderEngine")
	void addRenderEngine(
		@WebParam(name = "renderEngine", partName = "addRenderEngine.renderEngine") SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException;

	/**
	 * @param queryEngine QueryEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addQueryEngine")
	void addQueryEngine(
		@WebParam(name = "queryEngine", partName = "addQueryEngine.queryEngine") SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException;

	/**
	 * @param modelMerger ModelMerger to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelMerger")
	void addModelMerger(
		@WebParam(name = "modelMerger", partName = "addModelMerger.modelMerger") SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException;

	/**
	 * @param modelCompare ModelCompare to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelCompare")
	void addModelCompare(
		@WebParam(name = "modelCompare", partName = "addModelCompare.modelCompare") SModelComparePluginConfiguration modelCompare) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDeserializer")
	void addDeserializer(
		@WebParam(name = "deserializer", partName = "addDeserializer.deserializer") SDeserializerPluginConfiguration deserializer) throws ServerException, UserException;

	/**
	 * @param serializer Serializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateSerializer")
	void updateSerializer(
		@WebParam(name = "serializer", partName = "updateSerializer.serializer") SSerializerPluginConfiguration serializer) throws ServerException, UserException;

	/**
	 * @param renderEngine RenderEngine to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateRenderEngine")
	void updateRenderEngine(
		@WebParam(name = "renderEngine", partName = "updateRenderEngine.renderEngine") SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException;

	/**
	 * @param queryEngine QueryEngine to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateQueryEngine")
	void updateQueryEngine(
		@WebParam(name = "queryEngine", partName = "updateQueryEngine.queryEngine") SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException;

	/**
	 * @param modelMerger ModelMerger to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateModelMerger")
	void updateModelMerger(
		@WebParam(name = "modelMerger", partName = "updateModelMerger.modelMerger") SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException;

	/**
	 * @param modelCompare ModelCompare to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateModelCompare")
	void updateModelCompare(
		@WebParam(name = "modelCompare", partName = "updateModelCompare.modelCompare") SModelComparePluginConfiguration modelCompare) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateDeserializer")
	void updateDeserializer(
		@WebParam(name = "deserializer", partName = "updateDeserializer.deserializer") SDeserializerPluginConfiguration deserializer) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to include only enabled ObjectIDMs
	 * @return A list of ObjectIDMs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllObjectIDMs")
	List<SObjectIDMPluginConfiguration> getAllObjectIDMs(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMById")
	SObjectIDMPluginConfiguration getObjectIDMById(
		@WebParam(name = "oid", partName = "getObjectIDMById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addObjectIDM")
	void addObjectIDM(
		@WebParam(name = "objectIDM", partName = "addObjectIDM.objectIDM") SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateObjectIDM")
	void updateObjectIDM(
		@WebParam(name = "objectIDM", partName = "updateObjectIDM.objectIDM") SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException;
	
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
	 * @param iid ObjectID of the RenderEngine to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteRenderEngine")
	void deleteRenderEngine(
		@WebParam(name = "iid", partName = "deleteRenderEngine.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the ModelMerger to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteModelMerger")
	void deleteModelMerger(
		@WebParam(name = "iid", partName = "deleteModelMerger.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the ModelCompare to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteModelCompare")
	void deleteModelCompare(
		@WebParam(name = "iid", partName = "deleteModelCompare.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the QueryEngine to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteQueryEngine")
	void deleteQueryEngine(
		@WebParam(name = "iid", partName = "deleteQueryEngine.iid") Long iid) throws ServerException, UserException;

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
	@WebMethod(action = "getAllRenderEnginePluginDescriptors")
	List<SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all DeserializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializerPluginDescriptors")
	List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all QueryEnginePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllQueryEnginePluginDescriptors")
	List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all getAllServicePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllServicePluginDescriptors")
	List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @return List of all SModelComparePluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelComparePluginDescriptors")
	List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SModelMergerPluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelMergerPluginDescriptors")
	List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @param serializerName Name of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByName")
	SSerializerPluginConfiguration getSerializerByName(
		@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws ServerException, UserException;

	/**
	 * @param name Name of the RenderEngine
	 * @return RenderEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRenderEngineByName")
	SRenderEnginePluginConfiguration getRenderEngineByName(
		@WebParam(name = "name", partName = "getRenderEngineByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name Name of the QueryEngine
	 * @return QueryEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineByName")
	SQueryEnginePluginConfiguration getQueryEngineByName(
		@WebParam(name = "name", partName = "getQueryEngineByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name Name of the ModelMerger
	 * @return SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelMergerByName")
	SModelMergerPluginConfiguration getModelMergerByName(
		@WebParam(name = "name", partName = "getModelMergerByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name Name of the ModelCompare
	 * @return SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelCompareByName")
	SModelComparePluginConfiguration getModelCompareByName(
		@WebParam(name = "name", partName = "getModelCompareByName.name") String name) throws ServerException, UserException;

	/**
	 * @param objectIDMName Name of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMByName")
	SObjectIDMPluginConfiguration getObjectIDMByName(
		@WebParam(name = "objectIDMName", partName = "getObjectIDMByName.objectIDMName") String objectIDMName) throws ServerException, UserException;

	/**
	 * @param deserializerName Name of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerByName")
	SDeserializerPluginConfiguration getDeserializerByName(
		@WebParam(name = "deserializerName", partName = "getDeserializerByName.deserializerName") String deserializerName) throws ServerException, UserException;

	/**
	 * @param contentType Content type
	 * @return Whether there is an active Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(
		@WebParam(name = "contentType", partName = "hasActiveSerializer.contentType") String contentType) throws ServerException, UserException;
	
	/**
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByContentType")
	SSerializerPluginConfiguration getSerializerByContentType(
		@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws ServerException, UserException;

	/**
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByPluginClassName")
	SSerializerPluginConfiguration getSerializerByPluginClassName(
		@WebParam(name = "pluginClassName", partName = "getSerializerByPluginClassName.pluginClassName") String pluginClassName) throws ServerException, UserException;
	
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
	List<SDeserializerPluginConfiguration> getAllDeserializers(
		@WebParam(name = "onlyEnabled", partName = "getAllDeserializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param roid ObjectID of the Revision to perform this query on
	 * @param code The Java code, should be an implementation of the QueryInterface interface
	 * @return SRunResult
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadQuery")
	Long downloadQuery(
		@WebParam(name = "roid", partName = "downloadQuery.roid") Long roid, 
		@WebParam(name = "qeid", partName = "downloadQuery.qeid") Long qeid, 
		@WebParam(name = "code", partName = "downloadQuery.code") String code,
		@WebParam(name = "sync", partName = "downloadQuery.sync") Boolean sync,
		@WebParam(name = "serializerOid", partName = "downloadQuery.serializerOid") Long serializerOid) throws ServerException, UserException;

	/**
	 * @return The name of the suggested deserializer
	 * @throws ServerException 
	 */
	@WebMethod(action = "getSuggestedDeserializerForExtension")
	SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(
		@WebParam(name = "extension", partName = "getSuggestedDeserializerForExtension.extension") String extension) throws ServerException, UserException;

	/**
	 * Checkin warnings are given to users
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckinWarnings")
	Set<String> getCheckinWarnings(
		@WebParam(name = "poid", partName = "getCheckinWarnings.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * @return A list of ExtendedDataSchemas
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllExtendedDataSchemas")
	List<SExtendedDataSchema> getAllExtendedDataSchemas () throws ServerException, UserException;
	
	@WebMethod(action="getDefaultRenderEngine")
	SRenderEnginePluginConfiguration getDefaultRenderEngine() throws ServerException, UserException;

	@WebMethod(action="getDefaultQueryEngine")
	SQueryEnginePluginConfiguration getDefaultQueryEngine() throws ServerException, UserException;

	@WebMethod(action="getDefaultModelCompare")
	SModelComparePluginConfiguration getDefaultModelCompare() throws ServerException, UserException;

	@WebMethod(action="getDefaultModelMerger")
	SModelMergerPluginConfiguration getDefaultModelMerger() throws ServerException, UserException;

	@WebMethod(action="getDefaultSerializer")
	SSerializerPluginConfiguration getDefaultSerializer() throws ServerException, UserException;

	@WebMethod(action="getDefaultObjectIDM")
	SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException;

	@WebMethod(action="setDefaultRenderEngine")
	void setDefaultRenderEngine(
		@WebParam(name = "oid", partName = "setDefaultRenderEngine.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultQueryEngine")
	void setDefaultQueryEngine(
		@WebParam(name = "oid", partName = "setDefaultQueryEngine.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultModelCompare")
	void setDefaultModelCompare(
		@WebParam(name = "oid", partName = "setDefaultModelCompare.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultModelMerger")
	void setDefaultModelMerger(
		@WebParam(name = "oid", partName = "setDefaultModelMerger.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultSerializer")
	void setDefaultSerializer(
		@WebParam(name = "oid", partName = "setDefaultSerializer.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultObjectIDM")
	void setDefaultObjectIDM(
		@WebParam(name = "oid", partName = "setDefaultObjectIDM.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="getServiceDescriptor")
	SServiceDescriptor getServiceDescriptor(
		@WebParam(name = "url", partName = "getServiceDescriptor.url") String url) throws ServerException, UserException;
	
	@WebMethod(action="getAllServiceDescriptors")
	List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException;

	@WebMethod(action="getAllRepositoryExtendedDataSchemas")
	List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws ServerException, UserException;

	@WebMethod(action="getAllPublicProfiles")
	List<SProfileDescriptor> getAllPublicProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPublicProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPublicProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;

	@WebMethod(action="addServiceToProject")
	void addServiceToProject(
		@WebParam(name = "poid", partName = "addServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addServiceToProject.sService") org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException;

	@WebMethod(action="deleteService")
	void deleteService(
		@WebParam(name = "oid", partName = "deleteService.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action="getService")
	org.bimserver.interfaces.objects.SService getService(
		@WebParam(name = "soid", partName = "getService.soid") Long soid) throws ServerException, UserException;

	@WebMethod(action="getInternalServiceById")
	SInternalServicePluginConfiguration getInternalServiceById(
		@WebParam(name = "oid", partName = "getEServiceById.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="updateInternalService")
	void updateInternalService(
		@WebParam(name = "internalService", partName = "updateInternalService.internalService") SInternalServicePluginConfiguration internalService) throws ServerException, UserException;
	
	@WebMethod(action="addInternalService")
	void addInternalService(
		@WebParam(name = "internalService", partName = "addInternalService.internalService") SInternalServicePluginConfiguration internalService) throws ServerException, UserException;
	
	@WebMethod(action="deleteInternalService")
	void deleteInternalService(
		@WebParam(name = "oid", partName = "deleteInternalService.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="getAllInternalServices")
	List<SInternalServicePluginConfiguration> getAllInternalServices(
		@WebParam(name = "onlyEnabled", partName = "getAllInternalServices.onlyEnabled") Boolean onlyEnabled) throws UserException, ServerException;
	
	@WebMethod(action = "getAllPrivateProfiles")
	List<SProfileDescriptor> getAllPrivateProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPrivateProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPrivateProfiles.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "token", partName = "getAllPrivateProfiles.token") String token) throws ServerException, UserException;
	
	@WebMethod(action = "getPluginObjectDefinition")
	SObjectDefinition getPluginObjectDefinition(
		@WebParam(name = "className", partName = "getPluginObjectDefinition.className") String className) throws ServerException, UserException;

	@WebMethod(action = "setPluginSettings")
	void setPluginSettings(
		@WebParam(name = "poid", partName = "setPluginSettings.poid") Long poid, 
		@WebParam(name = "settings", partName = "setPluginSettings.settings") SObjectType settings) throws ServerException, UserException;

	@WebMethod(action = "getPluginSettings")
	SObjectType getPluginSettings(
		@WebParam(name = "poid", partName = "getPluginSettings.poid") Long poid) throws ServerException, UserException;
	
	@WebMethod(action = "uploadFile")
	Long uploadFile(
		@WebParam(name = "file", partName = "uploadFile.file") SFile file) throws ServerException, UserException;

	@WebMethod(action = "getFile")
	SFile getFile(
		@WebParam(name = "fileId", partName = "getFile.fileId") Long fileId) throws ServerException, UserException;
	
	@WebMethod(action = "triggerNewRevision")
	void triggerNewRevision(
		@WebParam(name = "roid", partName = "triggerNewRevision.roid") Long roid, 
		@WebParam(name = "soid", partName = "triggerNewRevision.soid") Long soid) throws ServerException, UserException;

	@WebMethod(action = "triggerNewExtendedData")
	void triggerNewExtendedData(
		@WebParam(name = "edid", partName = "triggerNewExtendedData.edid") Long edid, 
		@WebParam(name = "soid", partName = "triggerNewExtendedData.soid") Long soid) throws ServerException, UserException;

	@WebMethod(action = "getAllLocalServiceDescriptors")
	List<SServiceDescriptor> getAllLocalServiceDescriptors() throws ServerException, UserException;

	@WebMethod(action = "getAllLocalProfiles")
	List<SProfileDescriptor> getAllLocalProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getAllLocalProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;

	@WebMethod(action = "addLocalServiceToProject")
	void addLocalServiceToProject(
		@WebParam(name = "poid", partName = "addLocalServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addLocalServiceToProject.sService") SService sService,
		@WebParam(name = "internalServiceOid", partName = "addLocalServiceToProject.internalServiceOid") Long internalServiceOid) throws ServerException, UserException;
	
	@WebMethod(action = "shareRevision")
	String shareRevision(
		@WebParam(name = "roid", partName = "shareRevision.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "getOidByGuid")
	Long getOidByGuid(
		@WebParam(name = "roid", partName = "getOidByGuid.roid") Long roid, 
		@WebParam(name = "guid", partName = "getOidByGuid.guid") String guid) throws ServerException, UserException;

	@WebMethod(action = "cleanupLongAction")
	void cleanupLongAction(
		@WebParam(name = "actionId", partName = "cleanupLongAction.actionId") Long actionId) throws UserException, ServerException;
	
	@WebMethod(action = "count")
	Integer count(
		@WebParam(name = "roid", partName = "count.roid") Long roid,
		@WebParam(name = "className", partName = "count.className") String className) throws UserException, ServerException;
	
	@WebMethod(action = "getUserSettings")
	SUserSettings getUserSettings() throws ServerException, UserException;
	
	@WebMethod(action = "registerProgressTopic")
	Long registerProgressTopic(
		@WebParam(name = "type", partName = "registerProgressTopic.type") SProgressTopicType type,
		@WebParam(name = "description", partName = "registerProgressTopic.description") String description) throws UserException, ServerException;

	@WebMethod(action = "updateProgressTopic")
	void updateProgressTopic(
		@WebParam(name = "topicId", partName = "registerProgressTopic.topicId") Long topicId, 
		@WebParam(name = "state", partName = "registerProgressTopic.state") SLongActionState state) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterProgressTopic")
	void unregisterProgressTopic(
		@WebParam(name = "topicId", partName = "unregisterProgressTopic.topicId") Long topicId) throws UserException, ServerException;
	
	@WebMethod(action = "registerProgressHandler")
	void registerProgressHandler(
		@WebParam(name = "topicId", partName = "registerProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "registerProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "registerNewRevisionOnSpecificProjectHandler")
	void registerNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "registerNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "registerNewProjectHandler")
	void registerNewProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "unregisterNewProjectHandler")
	void unregisterNewProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "registerNewUserHandler")
	void registerNewUserHandler(
			@WebParam(name = "endPointId", partName = "registerNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterNewUserHandler")
	void unregisterNewUserHandler(
			@WebParam(name = "endPointId", partName = "unregisterNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterNewRevisionOnSpecificProjectHandler")
	void unregisterNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "unregisterNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "unregisterProgressHandler")
	void unregisterProgressHandler(
		@WebParam(name = "topicId", partName = "unregisterProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "unregisterProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "getProgress")
	SLongActionState getProgress(
		@WebParam(name = "topicId", partName = "getProgress.topicId") Long topicId) throws UserException, ServerException;
	
	@WebMethod(action = "getProgressTopicsOnRevision")
	List<Long> getProgressTopicsOnRevision(
		@WebParam(name = "poid", partName = "getProgressTopicsOnRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "getProgressTopicsOnRevision.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "getProgressTopicsOnProject")
	List<Long> getProgressTopicsOnProject(
		@WebParam(name = "poid", partName = "getProgressTopicsOnProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "getProgressTopicsOnServer")
	List<Long> getProgressTopicsOnServer() throws UserException, ServerException;
	
	@WebMethod(action = "registerProgressOnRevisionTopic")
	Long registerProgressOnRevisionTopic(
		@WebParam(name = "type", partName = "registerProgressOnRevisionTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnRevisionTopic.poid") Long poid, 
		@WebParam(name = "roid", partName = "registerProgressOnRevisionTopic.roid") Long roid, 
		@WebParam(name = "description", partName = "registerProgressOnRevisionTopic.description") String description) throws UserException, ServerException;

	@WebMethod(action = "registerProgressOnProjectTopic")
	Long registerProgressOnProjectTopic(
		@WebParam(name = "type", partName = "registerProgressOnProjectTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnProjectTopic.poid") Long poid, 
		@WebParam(name = "description", partName = "registerProgressOnProjectTopic.description") String description) throws UserException, ServerException;
	
	@WebMethod(action = "registerChangeProgressOnProject")
	void registerChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "registerChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;
	
	@WebMethod(action = "registerChangeProgressOnServer")
	void registerChangeProgressOnServer(
			@WebParam(name = "endPointId", partName = "registerChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	@WebMethod(action = "unregisterChangeProgressOnServer")
	void unregisterChangeProgressOnServer(
			@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	@WebMethod(action = "registerChangeProgressOnRevision")
	void registerChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnRevision.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "registerChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "registerChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
	
	@WebMethod(action = "unregisterChangeProgressOnProject")
	void unregisterChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "unregisterChangeProgressOnRevision")
	void unregisterChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnRevision.endPointId") Long endPointId, 
		@WebParam(name = "roid", partName = "unregisterChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
}