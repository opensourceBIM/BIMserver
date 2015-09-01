package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "ServiceInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface extends PublicInterface {
	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param file The actual file
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
		@WebParam(name = "data", partName = "checkin.data") @XmlMimeType("application/octet-stream") DataHandler data,
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
		@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration,
		@WebParam(name = "resetUrl", partName = "addUser.resetUrl") String resetUrl) throws ServerException, UserException;

	/**
	 * Add a new user
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @return The ObjectID of the created User object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addUserWithPassword")
	SUser addUserWithPassword(
			@WebParam(name = "username", partName = "addUser.username") String username,
			@WebParam(name = "password", partName = "addUser.password") String password,
			@WebParam(name = "name", partName = "addUser.name") String name,
			@WebParam(name = "type", partName = "addUser.type") SUserType type,
			@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration,
			@WebParam(name = "resetUrl", partName = "addUser.resetUrl") String resetUrl) throws ServerException, UserException;

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
	 * Delete a User, Users van be undeleted with the undeleteUser method
	 * @param uoid ObjectID of the User
	 * @return Whether the User has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteUser")
	Boolean deleteUser(
		@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * 
	 * Get a list of all Projects the user is authorized for to read from
	 * @return A list of all projects that are readable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServerException, UserException;

	/**
	 * 
	 * Get a list of all Projects the user is authorized for to write to
	 * @return A list of all projects that are writeable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWritableProjects")
	List<SProject> getAllWritableProjects() throws ServerException, UserException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServerException, UserException;

	@WebMethod(action = "getAllServicesOfProject")
	List<SService> getAllServicesOfProject(
		@WebParam(name = "poid", partName = "getAllServicesOfProject.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getAllModelCheckersOfProject")
	List<SModelCheckerInstance> getAllModelCheckersOfProject(
			@WebParam(name = "poid", partName = "getAllModelCheckersOfProject.poid") Long poid) throws ServerException, UserException;
	
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
	 * Get a User by its UserNmae (e-mail address)
	 * @param username The username (must be a valid e-mail address)
	 * @return The SUser Object if found, otherwise null
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(
		@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws ServerException, UserException;

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
	 * @param roid
	 * @param tag
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(
		@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
		@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws ServerException, UserException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
		@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws ServerException, UserException;

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
	 * @param extendedDataSchema ExtendedDataSchema to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataSchema")
	Long addExtendedDataSchema(
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

	@WebMethod(action="getServiceDescriptor")
	SServiceDescriptor getServiceDescriptor(
		@WebParam(name = "baseUrl", partName = "getServiceDescriptor.baseUrl") String baseUrl,
		@WebParam(name = "serviceIdentifier", partName = "getServiceDescriptor.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;
	
	@WebMethod(action="getAllServiceDescriptors")
	List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException;

	@WebMethod(action="getAllRepositoryExtendedDataSchemas")
	List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws ServerException, UserException;

	@WebMethod(action="getAllRepositoryModelCheckers")
	List<SModelCheckerInstance> getAllRepositoryModelCheckers() throws ServerException, UserException;

	@WebMethod(action="getAllPublicProfiles")
	List<SProfileDescriptor> getAllPublicProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPublicProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPublicProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;

	@WebMethod(action="addServiceToProject")
	Long addServiceToProject(
		@WebParam(name = "poid", partName = "addServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addServiceToProject.sService") org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException;

	@WebMethod(action="deleteService")
	void deleteService(
		@WebParam(name = "oid", partName = "deleteService.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action="getService")
	org.bimserver.interfaces.objects.SService getService(
		@WebParam(name = "soid", partName = "getService.soid") Long soid) throws ServerException, UserException;

	@WebMethod(action = "getAllPrivateProfiles")
	List<SProfileDescriptor> getAllPrivateProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPrivateProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPrivateProfiles.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "token", partName = "getAllPrivateProfiles.token") String token) throws ServerException, UserException;
	
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
	
	@WebMethod(action = "getUserSettings")
	SUserSettings getUserSettings() throws ServerException, UserException;

	@WebMethod(action = "getUserRelatedLogs")
	List<SLogAction> getUserRelatedLogs(
		@WebParam(name = "uoid", partName = "getUserRelatedLogs.uoid") Long uoid) throws ServerException, UserException;

	@WebMethod(action = "getAllRelatedProjects")
	List<SProjectSmall> getAllRelatedProjects(
		@WebParam(name = "poid", partName = "getAllRelatedProjects.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getAllModelCheckers")
	List<SModelCheckerInstance> getAllModelCheckers() throws UserException, ServerException;
	
	@WebMethod(action = "addModelChecker")
	Long addModelChecker(@WebParam(name = "modelCheckerInstance", partName = "addModelChecker.modelCheckerInstance") SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException;

	@WebMethod(action = "updateModelChecker")
	void updateModelChecker(@WebParam(name = "modelCheckerInstance", partName = "updateModelChecker.modelCheckerInstance") SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException;

	@WebMethod(action = "validateModelChecker")
	void validateModelChecker(@WebParam(name = "oid", partName = "validateModelChecker.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="addModelCheckerToProject")
	void addModelCheckerToProject(
		@WebParam(name = "poid", partName = "addModelCheckerToProject.poid") Long poid, 
		@WebParam(name = "modelCheckerOid", partName = "addModelCheckerToProject.modelCheckerOid") Long modelCheckerOid) throws ServerException, UserException;
	
	@WebMethod(action = "getModelCheckerInstance")
	SModelCheckerInstance getModelCheckerInstance(@WebParam(name = "mcioid", partName = "getModelCheckerInstance.mcioid") Long mcioid) throws UserException, ServerException;
	
	@WebMethod(action = "removeModelCheckerFromProject")
	void removeModelCheckerFromProject(
		@WebParam(name = "poid", partName = "removeModelCheckerFromProject.poid") Long poid, 
		@WebParam(name = "modelCheckerOid", partName = "removeModelCheckerFromProject.modelCheckerOid") Long modelCheckerOid) throws ServerException, UserException;

	@WebMethod(action = "removeServiceFromProject")
	void removeServiceFromProject(
			@WebParam(name = "poid", partName = "removeServiceFromProject.poid") Long poid, 
			@WebParam(name = "serviceOid", partName = "removeServiceFromProject.serviceOid") Long serviceOid) throws ServerException, UserException;
	
	@WebMethod(action = "importData")
	void importData(
		@WebParam(name = "address", partName = "importData.address") String address,
		@WebParam(name = "username", partName = "importData.username") String username,
		@WebParam(name = "password", partName = "importData.password") String password,
		@WebParam(name = "path", partName = "importData.path") String path) throws ServerException, UserException;
	
	@WebMethod(action = "getIfcHeader")
	SIfcHeader getIfcHeader(@WebParam(name = "croid", partName = "getIfcHeader.croid") Long croid) throws UserException, ServerException;
	
	@WebMethod(action = "getArea")
	Double getArea(@WebParam(name = "roid", partName = "getArea.roid") Long roid, @WebParam(name = "oid", partName = "getArea.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action = "getVolume")
	Double getVolume(@WebParam(name = "roid", partName = "getVolume.roid") Long roid, @WebParam(name = "oid", partName = "getVolume.oid") Long oid) throws UserException, ServerException;
}