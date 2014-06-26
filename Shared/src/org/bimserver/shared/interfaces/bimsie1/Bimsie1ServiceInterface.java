package org.bimserver.shared.interfaces.bimsie1;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;

@WebService(name = "Bimsie1ServiceInterface", targetNamespace="org.buildingsmart.bimsie1")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface Bimsie1ServiceInterface extends PublicInterface {
	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param fileSize The size of the file in bytes
	 * @param ifcFile The actual file
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
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
		@WebParam(name = "sync", partName = "checkin.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Checkin a new model by sending a serialized form
	 * 
	 * @param poid The Project's ObjectID
	 * @param comment A comment
	 * @param deserializerOid ObjectId of the deserializer to use, use getAllDeserializers to get a list of available deserializers
	 * @param url A URL to the file
	 * @param sync Whether the call should return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkinFromUrl")
	Long checkinFromUrl(
		@WebParam(name = "poid", partName = "checkinFromUrl.poid") Long poid,
		@WebParam(name = "comment", partName = "checkinFromUrl.comment") String comment,
		@WebParam(name = "deserializerOid", partName = "checkinFromUrl.deserializerOid") Long deserializerOid,
		@WebParam(name = "fileName", partName = "checkinFromUrl.fileName") String fileName,
		@WebParam(name = "url", partName = "checkinFromUrl.url") String url,
		@WebParam(name = "sync", partName = "checkinFromUrl.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Checkout an existing model, checkout is the same as download, except a "checkout" will tell the server and other users you are working on it
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "checkout")
	Long checkout(
		@WebParam(name = "roid", partName = "checkout.roid") Long roid,
		@WebParam(name = "serializerOid", partName = "checkout.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "checkout.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Download a single revision of a model in a serialized format
	 * 
	 * @param roid Revision ObjectID
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param showOwn Whether to return revisions created by the current user
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "download")
	Long download(
		@WebParam(name = "roid", partName = "download.roid") Long roid,
		@WebParam(name = "serializerOid", partName = "download.serializerOid") Long serializerOid,
		@WebParam(name = "showOwn", partName = "download.showOwn") Boolean showOwn,
		@WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServerException, UserException;
	
	/**
	 * Download a model in a serialized format by giving a set of revisions and a set of Object IDs
	 * @param roids A set of Revision ObjectIDs
	 * @param oids A set of ObjectIDs
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
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
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByTypes")
	Long downloadByTypes(
		@WebParam(name = "roids", partName = "downloadByTypes.roids") Set<Long> roids,
		@WebParam(name = "schema", partName = "downloadByTypes.schema") String schema,
		@WebParam(name = "classNames", partName = "downloadByTypes.classNames") Set<String> classNames,
		@WebParam(name = "serializerOid", partName = "downloadByTypes.serializerOid") Long serializerOid,
		@WebParam(name = "includeAllSubtypes", partName = "downloadByTypes.includeAllSubtypes") Boolean includeAllSubtypes,
		@WebParam(name = "useObjectIDM", partName = "downloadByTypes.useObjectIDM") Boolean useObjectIDM,
		@WebParam(name = "deep", partName = "downloadByTypes.deep") Boolean deep,
		@WebParam(name = "sync", partName = "downloadByTypes.sync") Boolean sync) throws ServerException, UserException;

	/**
	 * Download a model in serialized format by giving a set of revisions and a set of class names to filter on
	 * @param roids A set of Revision ObjectIDs
	 * @param classNames A set of class names to filter on (e.g. "IfcWindow")
	 * @param serializerOid ObjectId of the serializer to use, use getAllSerializers to find availble serializeres
	 * @param includeAllSubtypes Whether to query all (recursive) subtypes of each gives class
	 * @param sync Whether to return immediately (async) or wait for completion (sync)
	 * @return A topicId, which you can use for the Bimsie1NotificationRegistryInterface.getProgress method
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "downloadByJsonQuery")
	Long downloadByJsonQuery(
		@WebParam(name = "roids", partName = "downloadByTypes.roids") Set<Long> roids,
		@WebParam(name = "jsonQuery", partName = "downloadByTypes.jsonQuery") String jsonQuery,
		@WebParam(name = "serializerOid", partName = "downloadByTypes.serializerOid") Long serializerOid,
		@WebParam(name = "sync", partName = "downloadByTypes.sync") Boolean sync) throws ServerException, UserException;
	
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
	 * Terminate a long running action
	 * 
	 * @param actionId The actionId returned by one of the download or checkout methods
	 * @return An SDownloadResult containing the serialized data
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "terminateLongRunningAction")
	void terminateLongRunningAction(
			@WebParam(name = "actionId", partName = "getDownloadData.actionId") Long actionId) throws ServerException, UserException;
	
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
	 * @param poid ObjectID of the Project
	 * @return The Project
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(
		@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws ServerException, UserException;

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

	@WebMethod(action = "getExtendedDataSchemaByNamespace")
	SExtendedDataSchema getExtendedDataSchemaByNamespace(
		@WebParam(name = "namespace", partName = "getExtendedDataSchemaByNamespace.namespace") String namespace) throws UserException, ServerException;

	@WebMethod(action = "getAllProjectsSmall")
	List<SProjectSmall> getAllProjectsSmall() throws ServerException, UserException;
}