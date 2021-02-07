package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
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

import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDensity;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGeometryInfo;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SNewService;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.STile;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "ServiceInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface extends PublicInterface {

	@WebMethod(action = "initiateCheckin")
	Long initiateCheckin(
		@WebParam(name = "poid", partName = "initiateCheckin.poid") Long poid,
		@WebParam(name = "deserializerOid", partName = "initiateCheckin.deserializerOid") Long deserializerOid) throws ServerException, UserException;
	
	/**
	 * Terminate a long running action
	 * 
	 * @param topicId The actionId returned by one of the download or checkout methods
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "terminateLongRunningAction")
	void terminateLongRunningAction(
		@WebParam(name = "topicId", partName = "getDownloadData.topicId") Long topicId) throws ServerException, UserException;

	/**
	 * Checkout an existing model, checkout is the same as download, except a "checkout" will tell the server and other users you are working on it
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkout")
	Long checkout(
		@WebParam(name = "roid", partName = "checkout.roid") Long roid,
		@WebParam(name = "serializerOid", partName = "checkout.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "checkout.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Download a model in serialized format by giving a set of revisions and a set of class names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param query The query to use (JSON). If you are using the BIMserver API over JSON, make sure this is a JSON encoded String (for example in JS run JSON.stringify specifically for this field)
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializers
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the NotificationRegistryInterface.getProgress method, ServiceInterface.getDownloadData and the download servlet (/download)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "download")
	Long download(
		@WebParam(name = "roids", partName = "download.roids") Set<Long> roids,
		@WebParam(name = "query", partName = "download.query") String query,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Get the data for a download/checkout
	 * 
	 * @param topicId The topicId returned by one of the download or checkout methods
	 * @return An SDownloadResult containing the serialized data
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(
		@WebParam(name = "topicId", partName = "getDownloadData.topicId") Long topicId) throws ServerException, UserException;

	/**
	 * @param serializerName Name of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByName")
	SSerializerPluginConfiguration getSerializerByName(
		@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerById")
	SDeserializerPluginConfiguration getDeserializerById(
		@WebParam(name = "oid", partName = "getDeserializerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param deserializerName Name of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDeserializerByName")
	SDeserializerPluginConfiguration getDeserializerByName(
		@WebParam(name = "deserializerName", partName = "getDeserializerByName.deserializerName") String deserializerName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerById")
	SSerializerPluginConfiguration getSerializerById(
		@WebParam(name = "oid", partName = "getSerializerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByContentType")
	SSerializerPluginConfiguration getSerializerByContentType(
		@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws ServerException, UserException;

	/**
	 * @param name Name of the QueryEngine
	 * @return QueryEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineByName")
	SQueryEnginePluginConfiguration getQueryEngineByName(
		@WebParam(name = "name", partName = "getQueryEngineByName.name") String name) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the QueryEngine
	 * @return QueryEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineById")
	SQueryEnginePluginConfiguration getQueryEngineById(
		@WebParam(name = "oid", partName = "getQueryEngineById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * Get a suggested deserializer for the given file extension and project
	 * 
	 * @param extension File extension without the dot(.), for example "ifc"
	 * @param poid ProjectID of the project, this is relevant because a project has a specific schema, so we are looking for a deserializer that can handle this schema
	 * @return The name of the suggested deserializer
	 * @throws ServerException 
	 */
	@WebMethod(action = "getSuggestedDeserializerForExtension")
	SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(
		@WebParam(name = "extension", partName = "getSuggestedDeserializerForExtension.extension") String extension,
		@WebParam(name = "poid", partName = "getSuggestedDeserializerForExtension.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * @param roid ObjectID of the Revision
	 * @param extendedData ExtendedData to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addExtendedDataToRevision")
	void addExtendedDataToRevision(
		@WebParam(name = "roid", partName = "addExtendedDataToRevision.roid") Long roid,
		@WebParam(name = "extendedData", partName = "addExtendedDataToRevision.extendedData") SExtendedData extendedData) throws ServerException, UserException;

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
	 * @param roid ObjectID of the Revision
	 * @return ExtendedData
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllExtendedDataOfRevisionAndSchema")
	List<SExtendedData> getAllExtendedDataOfRevisionAndSchema(
		@WebParam(name = "roid", partName = "getAllExtendedDataOfRevision.roid") Long roid,
		@WebParam(name = "schemaId", partName = "getAllExtendedDataOfRevision.schemaId") Long schemaId) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return ExtendedData
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLastExtendedDataOfRevisionAndSchema")
	SExtendedData getLastExtendedDataOfRevisionAndSchema(
			@WebParam(name = "roid", partName = "getAllExtendedDataOfRevision.roid") Long roid,
			@WebParam(name = "schemaId", partName = "getAllExtendedDataOfRevision.schemaId") Long schemaId) throws ServerException, UserException;
	
	/**
	 * @param poid ObjectID of the Project
	 * @return The Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(
		@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param uuid UUID of the Project
	 * @return The Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectByUuid")
	SProject getProjectByUuid(
		@WebParam(name = "uuid", partName = "getProjectByUuid.uuid") String uuid) throws ServerException, UserException;
	
	/**
	 * @param poid ObjectID of the Project
	 * @return The Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectSmallByPoid")
	SProjectSmall getProjectSmallByPoid(
			@WebParam(name = "poid", partName = "getProjectSmallByPoid.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * @param roid ObjectID of the Revision
	 * @return The Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRevision")
	SRevision getRevision(
		@WebParam(name = "roid", partName = "getRevision.roid") Long roid) throws ServerException, UserException;

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
	 * Branch a given Revision as a new Revision on a new Project, branching is always synchronous
	 * @param roid ObjectID of the Revision to branch
	 * @param projectName Name of the to be created Project
	 * @param comment A comment describing the new Revision
	 * @return The result of this branch, you can use getCheckinState with this ID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "clone")
	Long clone(
		@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
		@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
		@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment,
		@WebParam(name = "sync", partName = "branchToNewProject.sync") Boolean sync) throws ServerException, UserException;

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
	 * @param name
	 * @return A list of projects with the given name (can be multiple because subprojects are also returned)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectsByName")
	List<SProject> getProjectsByName(
		@WebParam(name = "name", partName = "getProjectsByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name
	 * @return Get the (top level) project with the given name, there can be only one, because top-level projects always are unique
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getTopLevelProjectByName")
	SProject getTopLevelProjectByName(
		@WebParam(name = "name", partName = "getTopLevelProjectByName.name") String name) throws ServerException, UserException;

	/**
	 * @param poid
	 * @return A list of all subprojects of the given project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(
		@WebParam(name = "poid", partName = "getSubProjects.poid") Long poid) throws ServerException, UserException;
	

	/**
	 * @param oid ObjectID of the ExtendedDataSchema
	 * @return ExtendedDataSchema
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getExtendedDataSchemaById")
	SExtendedDataSchema getExtendedDataSchemaById(
		@WebParam(name = "oid", partName = "getExtendedDataSchemaById.oid") Long oid) throws ServerException, UserException;
	
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
	
	/**
	 * Get a list of all Projects the user is authorized for
	 * 
	 * @return A list of Projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects(
		@WebParam(name = "onlyTopLevel", partName = "getAllProjects.onlyTopLevel") Boolean onlyTopLevel,
		@WebParam(name = "onlyActive", partName = "getAllProjects.onlyActive") Boolean onlyActive) throws ServerException, UserException;

	/**
	 * Add a new project
	 * @param projectName Name of the project, must be a unique name within all root-projects
	 * @param schema Schema of the project, you can only checkin models of this schema (available options are: "ifc2x3tc1" and "ifc4")
	 * @return The created Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addProject")
	SProject addProject(
		@WebParam(name = "projectName", partName = "addProject.projectName") String projectName,
		@WebParam(name = "schema", partName = "addProject.schema") String schema) throws ServerException, UserException;

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
		@WebParam(name = "parentPoid", partName = "addProjectAsSubProject.parentPoid") Long parentPoid,
		@WebParam(name = "schema", partName = "addProjectAsSubProject.schema") String schema) throws ServerException, UserException;

	/**
	 * Delete a Project, Projects can be undeleted with the undeleteProject method
	 * @param poid ObjectID of the Project to delete
	 * @return Whether the Project has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteProject")
	Boolean deleteProject(
		@WebParam(name = "poid", partName = "deleteProject.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getExtendedDataSchemaByName")
	SExtendedDataSchema getExtendedDataSchemaByName(
		@WebParam(name = "name", partName = "getExtendedDataSchemaByName.name") String name) throws UserException, ServerException;

	@WebMethod(action = "getAllProjectsSmall")
	List<SProjectSmall> getAllProjectsSmall() throws ServerException, UserException;

	/**
	 * Checkin a new model by sending a serialized form, the call will wait for completion before returning
	 *
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param fileName Name of the file
	 * @param data The actual data
	 * @param merge Whether to use checkin merging (this will alter your model!) DEPRICATED
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinSync")
	SLongCheckinActionState checkinSync(
		@WebParam(name = "poid", partName = "checkin.poid") Long poid,
		@WebParam(name = "comment", partName = "checkin.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkin.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileSize", partName = "checkin.fileSize") Long fileSize,
		@WebParam(name = "fileName", partName = "checkin.fileName") String fileName,
		@WebParam(name = "data", partName = "checkin.data") @XmlMimeType("application/octet-stream") DataHandler data,
		@WebParam(name = "merge", partName = "checkin.merge") Boolean merge) throws ServerException, UserException;

	/**
	 * Checkin a new model by sending a serialized form, the call will return immediately and not wait for completion
	 *
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param fileName Name of the file
	 * @param data The actual data
	 * @param merge Whether to use checkin merging (this will alter your model!) DEPRICATED
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	 @WebMethod(action = "checkinAsync")
	Long checkinAsync(
		@WebParam(name = "poid", partName = "checkin.poid") Long poid,
		@WebParam(name = "comment", partName = "checkin.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkin.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileSize", partName = "checkin.fileSize") Long fileSize,
		@WebParam(name = "fileName", partName = "checkin.fileName") String fileName,
		@WebParam(name = "data", partName = "checkin.data") @XmlMimeType("application/octet-stream") DataHandler data,
		@WebParam(name = "merge", partName = "checkin.merge") Boolean merge) throws ServerException, UserException;

	@WebMethod(action = "checkinInitiatedSync")
	SLongCheckinActionState checkinInitiatedSync(
		@WebParam(name = "topicId", partName = "checkinInitiated.topicId") Long topicId,
		@WebParam(name = "poid", partName = "checkinInitiated.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinInitiated.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinInitiated.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileSize", partName = "checkinInitiated.fileSize") Long fileSize,
		@WebParam(name = "fileName", partName = "checkinInitiated.fileName") String fileName,
		@WebParam(name = "data", partName = "checkinInitiated.data") @XmlMimeType("application/octet-stream") DataHandler data,
		@WebParam(name = "merge", partName = "checkinInitiated.merge") Boolean merge) throws ServerException, UserException;

	@WebMethod(action = "checkinInitiatedAsync")
	Long checkinInitiatedAsync(
		@WebParam(name = "topicId", partName = "checkinInitiated.topicId") Long topicId,
		@WebParam(name = "poid", partName = "checkinInitiated.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinInitiated.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinInitiated.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileSize", partName = "checkinInitiated.fileSize") Long fileSize,
		@WebParam(name = "fileName", partName = "checkinInitiated.fileName") String fileName,
		@WebParam(name = "data", partName = "checkinInitiated.data") @XmlMimeType("application/octet-stream") DataHandler data,
		@WebParam(name = "merge", partName = "checkinInitiated.merge") Boolean merge) throws ServerException, UserException;
	
	/**
	 * Checkin a new model from an URL, the call will wait for completion before returning
	 *
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileName Name of the file
	 * @param url A URL to the 'file'
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinFromUrlSync")
	SLongCheckinActionState checkinFromUrlSync(
		@WebParam(name = "poid", partName = "checkinFromUrl.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinFromUrl.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinFromUrl.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileName", partName = "checkinFromUrl.fileName") String fileName,
		@WebParam(name = "url", partName = "checkinFromUrl.url") String url,
		@WebParam(name = "merge", partName = "checkinFromUrl.merge") Boolean merge) throws ServerException, UserException;

	/**
	 * Checkin a new model from an URL, the call will return immediately and not wait for completion
	 *
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileName Name of the file
	 * @param url A URL to the 'file'
	 * @param merge Whether to use checkin merging (this will alter your model!)
	 * @return An id, which you can use for the getCheckinState method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinFromUrlAsync")
	Long checkinFromUrlAsync(
		@WebParam(name = "poid", partName = "checkinFromUrl.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinFromUrl.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinFromUrl.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileName", partName = "checkinFromUrl.fileName") String fileName,
		@WebParam(name = "url", partName = "checkinFromUrl.url") String url,
		@WebParam(name = "merge", partName = "checkinFromUrl.merge") Boolean merge) throws ServerException, UserException;

	/**
	 * Download a compare of a model
	 * 
	 * @param serializerOid The ObjectID of the Serializer configuration to use
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param mcid The ObjectID of the Model Compare plugin configuration
	 * @param type How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param sync Whether to call this method synchronously
	 * @return A topicId, which you can use for the NotificationRegistryInterface.getProgress method, ServiceInterface.getDownloadData and the download servlet (/download)
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
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @param name The name (e.g. "Bill Gates")
	 * @param type Type of user
	 * @param selfRegistration Whether this is a self-registration (for example e-mails will be different)
	 * @param resetUrl Reset URL (webbased clients can provide a url that handles the activation of the account)
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
	 * Add a new user with a given password
	 * 
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
	 * 
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
	 * 
	 * @param sProject A Project object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateProject")
	void updateProject(
		@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws ServerException, UserException;

	/**
	 * Update a revision, not much can be changed afterwards, actually only the tag
	 * 
	 * @param sRevision The Revision object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateRevision")
	void updateRevision(
		@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws ServerException, UserException;

	/**
	 * Add a user to a project (authorization wise)
	 * 
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
	 * 
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
	 * 
	 * @param uoid ObjectID of the User
	 * @return Whether the User has been deleted
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteUser")
	Boolean deleteUser(
		@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of all Projects the user is authorized for to read from
	 * 
	 * @return A list of all projects that are readable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServerException, UserException;

	/**
	 * Get a list of all Projects the user is authorized for to write to
	 * 
	 * @return A list of all projects that are writeable for the current user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWritableProjects")
	List<SProject> getAllWritableProjects() throws ServerException, UserException;

	/**
	 * Get a list of all users
	 * 
	 * @return All users
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServerException, UserException;

	/**
	 * Get a list of all the services attached to the given project
	 * 
	 * @param poid Project-ID of the Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllServicesOfProject")
	List<SService> getAllServicesOfProject(
		@WebParam(name = "poid", partName = "getAllServicesOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Get a list of all the services attached to the given project
	 * 
	 * @param poid Project-ID of the Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllNewServicesOfProject")
	List<SNewService> getAllNewServicesOfProject(
			@WebParam(name = "poid", partName = "getAllNewServicesOfProject.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * Get a list of all the model checkers attached to the given Project
	 * 
	 * @param poid Project-ID of the Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllModelCheckersOfProject")
	List<SModelCheckerInstance> getAllModelCheckersOfProject(
			@WebParam(name = "poid", partName = "getAllModelCheckersOfProject.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * Get all checkouts of the given project
	 * 
	 * @param poid The ObjectID of the Project
	 * @return A list of Checkouts belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(
		@WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid)	throws ServerException, UserException;

	/**
	 * Get a list of revisions a user has committed
	 * 
	 * @param uoid ObjectID of the Project
	 * @return A list of Revisions belonging to this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(
		@WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of checkouts by the given user
	 * 
	 * @param uoid ObjectID of the User
	 * @return A list of Checkouts belonging to the given User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(
		@WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of checkouts on the given revision
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A list of Checkouts belonging to the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(
		@WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid) throws ServerException, UserException;

	/**
	 * Returns a list of all available classes
	 * 
	 * @return A list of available classes in the BIMserver, only classes from the IFC model will be returned
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws ServerException, UserException;

	/**
	 * Returns a list of all the classes that are used in the given revision
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A list of classes of which a least one instance is available in the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAvailableClassesInRevision")
	List<String> getAvailableClassesInRevision(
		@WebParam(name = "roid", partName = "getAvailableClassesInRevision.roid") Long roid) throws ServerException, UserException;

	/**
	 * Get a list of all Projects the given User does not have authorization for
	 * 
	 * @param uoid
	 * @return The list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(
		@WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a User by its UserNmae (e-mail address)
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @return The SUser Object if found, otherwise null
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(
		@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws ServerException, UserException;

	/**
	 * Undelete a previously deleted User, Users can be deleted with the deleteUser method
	 * 
	 * @param uoid
	 * @return Whether the deletion was successfull
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(
		@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Compare two models
	 * 
	 * @param roid1 The ObjectID of the first Revision
	 * @param roid2 The ObjectID of the second Revision
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
	 * @param mcid The ObjectID of the Model Compare plugin configuration
	 * @return The result of the compare as an SCompareResult object, consisting of a List of SCompareContainer objects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "compare")
	SCompareResult compare(
		@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
		@WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
		@WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType, 
		@WebParam(name = "mcid", partName = "compare.mcid") Long mcid) throws ServerException, UserException;

	/**
	 * Get a revision summary
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A summary of the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(
		@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws ServerException, UserException;		

	/**
	 * Check whether the given user has rights on the given project
	 * 
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
	 * 
	 * @param poid ObjectID of the Project
	 * @return A set of String containing possible warnings for this Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCheckoutWarnings")
	Set<String> getCheckoutWarnings(
		@WebParam(name = "poid", partName = "getCheckoutWarnings.poid") Long poid) throws ServerException, UserException;

	/**
	 * Returns whether the currents user has rights on the given project
	 * 
	 * @param poid ObjectID of the Project
	 * @return Whether the current User has rights on the given Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "userHasRights")
	Boolean userHasRights(
		@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws ServerException, UserException;

	/**
	 * Get the GeoTag attached to the given Project
	 * 
	 * @param goid The ObjectID of the GeoTag
	 * @return The GeoTag object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(
		@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws ServerException, UserException;

	/**
	 * Update the GeoTag of a project
	 * 
	 * @param sGeoTag A GeoTag object containing the new properties
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(
		@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws ServerException, UserException;

	/**
	 * Get a user by its User ObjectID
	 * 
	 * @param uoid The ObjectID of the User
	 * @return The User with the given User ObjectID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(
		@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of all Users not authoriazed on the given Project
	 * 
	 * @param poid The ObjectID of the Project
	 * @return A list of Users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(
		@WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Get a list of users that have been authorized on the given project
	 * 
	 * @param poid
	 * @return A list of all users authorized on the given project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(
		@WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * Get a list of projects a user is authorized on
	 * 
	 * @param uoid
	 * @return A list of projects a user has been authorized for
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(
		@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Set a tag on a specific revision
	 * 
	 * @param roid The Revision ObjectID
	 * @param tag Tag
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(
		@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
		@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws ServerException, UserException;

	/**
	 * Get a list of all checkouts of the given project and it's sub projects
	 * 
	 * @param poid Project-ID of the given Project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
		@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws ServerException, UserException;

	/**
	 * Send an e-mail with the results of a compare
	 * 
	 * @param sCompareType How to compare (All, Only Added, Only Modified or Only Deleted)
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
	 * Get a list of query engine example keys (which you can then use for getQueryEngineExample)
	 * 
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExampleKeys")
	List<String> getQueryEngineExampleKeys(
		@WebParam(name = "qeid", partName = "getQueryEngineExampleKeys.qeid") Long qeid) throws ServerException, UserException;

	/**
	 * Returns a query engine example (get the key from getQueryEngineExampleKeys)
	 * 
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getQueryEngineExample")
	String getQueryEngineExample(
		@WebParam(name = "qeid", partName = "getQueryEngineExample.qeid") Long qeid,
		@WebParam(name = "key", partName = "getQueryEngineExample.key") String key) throws ServerException, UserException;

	/**
	 * Add an extended data schema. 
	 * 
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
	 * @param poid ObjectID of the Project
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
	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllExtendedDataSchemas")
	List<SExtendedDataSchema> getAllExtendedDataSchemas () throws ServerException, UserException;

	/**
	 * @param baseUrl
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceDescriptor")
	SServiceDescriptor getServiceDescriptor(
		@WebParam(name = "baseUrl", partName = "getServiceDescriptor.baseUrl") String baseUrl,
		@WebParam(name = "serviceIdentifier", partName = "getServiceDescriptor.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;
	
	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllServiceDescriptors")
	List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllRepositoryExtendedDataSchemas")
	List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas(@WebParam(name = "usePre", partName = "getAllRepositoryExtendedDataSchemas.usePre") Boolean usePre) throws ServerException, UserException;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllRepositoryModelCheckers")
	List<SModelCheckerInstance> getAllRepositoryModelCheckers() throws ServerException, UserException;

	/**
	 * @param notificationsUrl
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getAllPublicProfiles")
	List<SProfileDescriptor> getAllPublicProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPublicProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPublicProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;

	/**
	 * @param poid
	 * @param sService
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="addServiceToProject")
	Long addServiceToProject(
		@WebParam(name = "poid", partName = "addServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addServiceToProject.sService") org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException;

	/**
	 * @param oid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="deleteService")
	void deleteService(
		@WebParam(name = "oid", partName = "deleteService.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param soid
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getService")
	org.bimserver.interfaces.objects.SService getService(
		@WebParam(name = "soid", partName = "getService.soid") Long soid) throws ServerException, UserException;

	/**
	 * @param soid
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getNewService")
	org.bimserver.interfaces.objects.SNewService getNewService(
			@WebParam(name = "soid", partName = "getNewService.soid") Long soid) throws ServerException, UserException;
	
	/**
	 * @param notificationsUrl
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllPrivateProfiles")
	List<SProfileDescriptor> getAllPrivateProfiles(
		@WebParam(name = "notificationsUrl", partName = "getAllPrivateProfiles.notificationsUrl") String notificationsUrl, 
		@WebParam(name = "serviceIdentifier", partName = "getAllPrivateProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;
	
	/**
	 * @param file
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "uploadFile")
	Long uploadFile(
		@WebParam(name = "file", partName = "uploadFile.file") SFile file) throws ServerException, UserException;

	/**
	 * @param fileId
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getFile")
	SFile getFile(
		@WebParam(name = "fileId", partName = "getFile.fileId") Long fileId) throws ServerException, UserException;

	/**
	 * @param fileId
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getFileMeta")
	SFile getFileMeta(
		@WebParam(name = "fileId", partName = "getFileMeta.fileId") Long fileId) throws ServerException, UserException;
	
	/**
	 * @param roid
	 * @param soid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "triggerNewRevision")
	void triggerNewRevision(
		@WebParam(name = "roid", partName = "triggerNewRevision.roid") Long roid, 
		@WebParam(name = "soid", partName = "triggerNewRevision.soid") Long soid) throws ServerException, UserException;

	/**
	 * @param roid
	 * @param soid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "triggerRevisionService")
	void triggerRevisionService(
		@WebParam(name = "roid", partName = "triggerRevisionService.roid") Long roid, 
		@WebParam(name = "soid", partName = "triggerRevisionService.soid") Long soid) throws ServerException, UserException;

	/**
	 * @param edid
	 * @param soid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "triggerNewExtendedData")
	void triggerNewExtendedData(
		@WebParam(name = "edid", partName = "triggerNewExtendedData.edid") Long edid,
		@WebParam(name = "soid", partName = "triggerNewExtendedData.soid") Long soid) throws ServerException, UserException;

	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllLocalServiceDescriptors")
	List<SServiceDescriptor> getAllLocalServiceDescriptors() throws ServerException, UserException;

	/**
	 * @param serviceIdentifier
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllLocalProfiles")
	List<SProfileDescriptor> getAllLocalProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getAllLocalProfiles.serviceIdentifier") String serviceIdentifier) throws ServerException, UserException;

	/**
	 * Add a local service to a project
	 * 
	 * @param poid
	 * @param sService
	 * @param internalServiceOid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "addLocalServiceToProject")
	void addLocalServiceToProject(
		@WebParam(name = "poid", partName = "addLocalServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addLocalServiceToProject.sService") SService sService,
		@WebParam(name = "internalServiceOid", partName = "addLocalServiceToProject.internalServiceOid") Long internalServiceOid) throws ServerException, UserException;
	
	/**
	 * Share a revision
	 * 
	 * @param roid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "shareRevision")
	String shareRevision(
		@WebParam(name = "roid", partName = "shareRevision.roid") Long roid) throws UserException, ServerException;

	/**
	 * Get the oid of the given GUID, will throw a UserException if the GUID was not found
	 * 
	 * @param roid Revision in which to look
	 * @param guid GUID
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getOidByGuid")
	Long getOidByGuid(
		@WebParam(name = "roid", partName = "getOidByGuid.roid") Long roid, 
		@WebParam(name = "guid", partName = "getOidByGuid.guid") String guid) throws ServerException, UserException;

	/**
	 * Cleanup a long running action, this is important to keep memory usage of BIMserver down
	 * 
	 * @param topicId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "cleanupLongAction")
	void cleanupLongAction(
		@WebParam(name = "topicId", partName = "cleanupLongAction.topicId") Long topicId) throws UserException, ServerException;
	
	/**
	 * Get the user settings of the current user
	 * 
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getUserSettings")
	SUserSettings getUserSettings() throws ServerException, UserException;

	/**
	 * Get all log entries linked to the given user
	 * 
	 * @param uoid
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getUserRelatedLogs")
	List<SLogAction> getUserRelatedLogs(
		@WebParam(name = "uoid", partName = "getUserRelatedLogs.uoid") Long uoid) throws ServerException, UserException;

	/**
	 * Get a list of a project's related projects. Will search through all the parent/child relations, recursively
	 * 
	 * @param poid The projectID of the project
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getAllRelatedProjects")
	List<SProjectSmall> getAllRelatedProjects(
		@WebParam(name = "poid", partName = "getAllRelatedProjects.poid") Long poid) throws ServerException, UserException;

	/**
	 * Get all model checkers
	 * 
	 * @return A list of model checkers
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getAllModelCheckers")
	List<SModelCheckerInstance> getAllModelCheckers() throws UserException, ServerException;
	
	/**
	 * @param modelCheckerInstance
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "addModelChecker")
	Long addModelChecker(@WebParam(name = "modelCheckerInstance", partName = "addModelChecker.modelCheckerInstance") SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException;

	/**
	 * @param modelCheckerInstance
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "updateModelChecker")
	void updateModelChecker(@WebParam(name = "modelCheckerInstance", partName = "updateModelChecker.modelCheckerInstance") SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException;

	/**
	 * Validate a model checker
	 * 
	 * @param oid
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "validateModelChecker")
	void validateModelChecker(@WebParam(name = "oid", partName = "validateModelChecker.oid") Long oid) throws UserException, ServerException;

	/**
	 * Add a model checker to a project
	 * 
	 * @param poid Project-ID
	 * @param modelCheckerOid ModelChecker ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="addModelCheckerToProject")
	void addModelCheckerToProject(
		@WebParam(name = "poid", partName = "addModelCheckerToProject.poid") Long poid, 
		@WebParam(name = "modelCheckerOid", partName = "addModelCheckerToProject.modelCheckerOid") Long modelCheckerOid) throws ServerException, UserException;
	
	/**
	 * Get a model checker instance by it's id
	 * 
	 * @param mcioid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getModelCheckerInstance")
	SModelCheckerInstance getModelCheckerInstance(@WebParam(name = "mcioid", partName = "getModelCheckerInstance.mcioid") Long mcioid) throws UserException, ServerException;
	
	/**
	 * Remove the given model checker from the given project
	 * 
	 * @param poid Project-ID
	 * @param modelCheckerOid Model Checker ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "removeModelCheckerFromProject")
	void removeModelCheckerFromProject(
		@WebParam(name = "poid", partName = "removeModelCheckerFromProject.poid") Long poid, 
		@WebParam(name = "modelCheckerOid", partName = "removeModelCheckerFromProject.modelCheckerOid") Long modelCheckerOid) throws ServerException, UserException;

	/**
	 * Remove the given service from the given project
	 * 
	 * @param poid Project-ID
	 * @param serviceOid Service-ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "removeServiceFromProject")
	void removeServiceFromProject(
		@WebParam(name = "poid", partName = "removeServiceFromProject.poid") Long poid, 
		@WebParam(name = "serviceOid", partName = "removeServiceFromProject.serviceOid") Long serviceOid) throws ServerException, UserException;
	
	/**
	 * Remove the given service from the given project
	 * 
	 * @param poid Project-ID
	 * @param serviceOid Service-ID
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "removeNewServiceFromProject")
	void removeNewServiceFromProject(
		@WebParam(name = "poid", partName = "removeNewServiceFromProject.poid") Long poid, 
		@WebParam(name = "serviceOid", partName = "removeNewServiceFromProject.serviceOid") Long serviceOid) throws ServerException, UserException;
	
	/**
	 * Import data from another BIMserver, mainly used for migrations. EXPERIMENTAL CODE!
	 * 
	 * @param address Address of the other BIMserver (http(s)://host:port/[contextpath])
	 * @param username Username of the admin user on the remote server
	 * @param password Password of the admin user on the remote server
	 * @param path A local path pointing to a copy of the incoming directory of the original server
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "importData")
	void importData(
		@WebParam(name = "address", partName = "importData.address") String address,
		@WebParam(name = "username", partName = "importData.username") String username,
		@WebParam(name = "password", partName = "importData.password") String password,
		@WebParam(name = "path", partName = "importData.path") String path) throws ServerException, UserException;
	
	/**
	 * Get the IfcHeader of the given ConcreteRevision-ID
	 * 
	 * @param croid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getIfcHeader")
	SIfcHeader getIfcHeader(@WebParam(name = "croid", partName = "getIfcHeader.croid") Long croid) throws UserException, ServerException;
	
	/**
	 * Get the area of the given object
	 * 
	 * @param roid Revision-ID of the revision this object belongs to
	 * @param oid Object-ID of the object
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getArea")
	Double getArea(@WebParam(name = "roid", partName = "getArea.roid") Long roid, @WebParam(name = "oid", partName = "getArea.oid") Long oid) throws UserException, ServerException;

	/**
	 * Get the volume of the given object
	 * 
	 * @param roid Revision-ID of the revision this object belongs to
	 * @param oid Object-ID of the object
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getVolume")
	Double getVolume(@WebParam(name = "roid", partName = "getVolume.roid") Long roid, @WebParam(name = "oid", partName = "getVolume.oid") Long oid) throws UserException, ServerException;
	
	/**
	 * @param roid Revision-ID of the revision this object belongs to
	 * @param oid Object-ID of the object (IfcProduct subtype)
	 * @return SGeometryInfo with basic info about geometry
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getGeometryInfo")
	SGeometryInfo getGeometryInfo(@WebParam(name = "roid", partName = "getGeometryInfo.roid") Long roid, @WebParam(name = "oid", partName = "getGeometryInfo.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action = "getNrPrimitives")
	Long getNrPrimitives(@WebParam(name = "roid", partName = "getNrPrimitives.roid") Long roid) throws ServerException, UserException;
	
	@WebMethod(action = "getNrPrimitivesTotal")
	Long getNrPrimitivesTotal(@WebParam(name = "roids", partName = "getNrPrimitivesTotal.roids") Set<Long> roids) throws ServerException, UserException;
	
	/**
	 * @param poid
	 * @param sService
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="addNewServiceToProject")
	Long addNewServiceToProject(
		@WebParam(name = "poid", partName = "addNewServiceToProject.poid") Long poid, 
		@WebParam(name = "sService", partName = "addNewServiceToProject.sService") org.bimserver.interfaces.objects.SNewService sService,
		@WebParam(name = "sAction", partName = "addNewServiceToProject.sAction") org.bimserver.interfaces.objects.SAction sAction) throws ServerException, UserException;
	
	@WebMethod(action = "bcfToJson")
	String bcfToJson(
		@WebParam(name = "extendedDataId", partName = "bcfToJson.extendedDataId") Long extendedDataId) throws ServerException, UserException;

	/**
	 * @param name
	 * @return A list of projects with the given name (can be multiple because subprojects are also returned)
	 * @throws UserException 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSubProjectByName")
	SProject getSubProjectByName(
		@WebParam(name = "parentProjectId", partName = "getSubProjectByName.parentProjectId") Long parentProjectId, 
		@WebParam(name = "name", partName = "getSubProjectByName.name") String name) throws UserException, ServerException;
	
	@WebMethod(action = "checkInternetConnection")
	Boolean checkInternetConnection() throws UserException, ServerException;

	@WebMethod(action = "getTotalBounds")
	SBounds getTotalBounds(@WebParam(name = "roids", partName = "getTotalBounds.roids") Set<Long> roids) throws ServerException, UserException;

	@WebMethod(action = "getTotalUntransformedBounds")
	SBounds getTotalUntransformedBounds(@WebParam(name = "roids", partName = "getTotalUntransformedBounds.roids") Set<Long> roids) throws ServerException, UserException;
	
	@WebMethod(action = "getModelMinBounds")
	SVector3f getModelMinBounds(@WebParam(name = "roid", partName = "getModelMinBounds.roid") Long roid) throws ServerException, UserException;

	@WebMethod(action = "getModelMaxBounds")
	SVector3f getModelMaxBounds(@WebParam(name = "roid", partName = "getModelMaxBounds.roid") Long roid) throws ServerException, UserException;
	
	@WebMethod(action = "getModelBounds")
	SBounds getModelBounds(@WebParam(name = "roid", partName = "getModelBounds.roid") Long roid) throws ServerException, UserException;
	
	@WebMethod(action = "getModelBoundsForConcreteRevision")
	SBounds getModelBoundsForConcreteRevision(@WebParam(name = "croid", partName = "getModelBoundsForConcreteRevision.croid") Long croid) throws ServerException, UserException;
	
	@WebMethod(action = "regenerateGeometry")
	Long regenerateGeometry(
		@WebParam(name = "roid", partName = "regenerateGeometry.roid") Long roid,
		@WebParam(name = "eoid", partName = "regenerateGeometry.eoid") Long eoid) throws ServerException, UserException;

	@WebMethod(action = "getModelBoundsUntransformed")
	SBounds getModelBoundsUntransformed(
		@WebParam(name = "roid", partName = "getModelBoundsUntransformed.roid") Long roid) throws ServerException, UserException;

	@WebMethod(action = "getModelBoundsUntransformedForConcreteRevision")
	SBounds getModelBoundsUntransformedForConcreteRevision(
			@WebParam(name = "croid", partName = "getModelBoundsUntransformedForConcreteRevision.croid") Long croid) throws ServerException, UserException;
	
	@WebMethod(action = "getDensityThreshold")
	SDensity getDensityThreshold(
		@WebParam(name = "roids", partName = "getDensityThreshold.roids") Set<Long> roids, 
		@WebParam(name = "nrTriangles", partName = "getDensityThreshold.nrTriangles") Long nrTriangles,
		@WebParam(name = "excludedTypes", partName = "getDensityThreshold.excludedTypes") Set<String> excludedTypes) throws ServerException, UserException;
	
	@WebMethod(action = "getTileCounts")
	List<Number> getTileCounts(
		@WebParam(name = "roids", partName = "getTileCounts.roids") Set<Long> roids, 
		@WebParam(name = "excludedTypes", partName = "getTileCounts.excludedTypes") Set<String> excludedTypes,
		@WebParam(name = "geometryIdsToReuse", partName = "getTileCounts.geometryIdsToReuse") Set<Long> geometryIdsToReuse,
		@WebParam(name = "minimumThreshold", partName = "getTileCounts.minimumThreshold") Float minimumThreshold,
		@WebParam(name = "maximumThreshold", partName = "getTileCounts.maximumThreshold") Float maximumThreshold,
		@WebParam(name = "depth", partName = "getTileCounts.depth") Integer depth) throws ServerException, UserException;
	
	@WebMethod(action = "getGeometryDataToReuse")
	Set<Long> getGeometryDataToReuse(
		@WebParam(name = "roids", partName = "getGeometryDataToReuse.roids") Set<Long> roids,
		@WebParam(name = "excludedTypes", partName = "getGeometryDataToReuse.excludedTypes") Set<String> excludedTypes,
		@WebParam(name = "trianglesToSave", partName = "getGeometryDataToReuse.trianglesToSave") Integer trianglesToSave) throws UserException, ServerException;

	@WebMethod(action = "listBoundingBoxes")
	List<SBounds> listBoundingBoxes(
		@WebParam(name = "roids", partName = "getGeometryDataToReuse.roids") Set<Long> roids) throws ServerException, UserException;
	
	@WebMethod(action = "determineIfcVersion")
	String determineIfcVersion(
		@WebParam(name = "head", partName = "determineIfcVersion.head") byte[] head, 
		@WebParam(name = "zipped", partName = "determineIfcVersion.zipped") Boolean zipped) throws UserException, ServiceException;

	@WebMethod(action = "getTiles")
	List<STile> getTiles(
		@WebParam(name = "roids", partName = "getTiles.roids") Set<Long> roids, 
		@WebParam(name = "excludedTypes", partName = "getTiles.excludedTypes") Set<String> excludedTypes,
		@WebParam(name = "geometryIdsToReuse", partName = "getTiles.geometryIdsToReuse") Set<Long> geometryIdsToReuse,
		@WebParam(name = "minimumThreshold", partName = "getTiles.minimumThreshold") Float minimumThreshold,
		@WebParam(name = "maximumThreshold", partName = "getTiles.maximumThreshold") Float maximumThreshold,
		@WebParam(name = "depth", partName = "getTiles.depth") Integer depth) throws ServerException, UserException;
}