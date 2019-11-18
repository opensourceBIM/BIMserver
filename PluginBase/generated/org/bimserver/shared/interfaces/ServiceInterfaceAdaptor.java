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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class ServiceInterfaceAdaptor implements org.bimserver.shared.interfaces.ServiceInterface {

	public java.lang.Long addExtendedDataSchema(org.bimserver.interfaces.objects.SExtendedDataSchema extendedDataSchema) throws UserException, ServerException {
		return null;
	}
	
	public void addExtendedDataToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws UserException, ServerException {
	}
	
	public void addExtendedDataToRevision(java.lang.Long roid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws UserException, ServerException {
	}
	
	public void addLocalServiceToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SService sService, java.lang.Long internalServiceOid) throws UserException, ServerException {
	}
	
	public java.lang.Long addModelChecker(org.bimserver.interfaces.objects.SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
		return null;
	}
	
	public void addModelCheckerToProject(java.lang.Long poid, java.lang.Long modelCheckerOid) throws UserException, ServerException {
	}
	
	public java.lang.Long addNewServiceToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SNewService sService, org.bimserver.interfaces.objects.SAction sAction) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String projectName, java.lang.String schema) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String projectName, java.lang.Long parentPoid, java.lang.String schema) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addServiceToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SService sService) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser addUser(java.lang.String username, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration, java.lang.String resetUrl) throws UserException, ServerException {
		return null;
	}
	
	public void addUserToExtendedDataSchema(java.lang.Long uoid, java.lang.Long edsid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean addUserToProject(java.lang.Long uoid, java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser addUserWithPassword(java.lang.String username, java.lang.String password, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration, java.lang.String resetUrl) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String bcfToJson(java.lang.Long extendedDataId) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long branchToExistingProject(java.lang.Long roid, java.lang.Long destPoid, java.lang.String comment, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long branchToNewProject(java.lang.Long roid, java.lang.String projectName, java.lang.String comment, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public void changeUserType(java.lang.Long uoid, org.bimserver.interfaces.objects.SUserType userType) throws UserException, ServerException {
	}
	
	public java.lang.Boolean checkInternetConnection() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkinAsync(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.Long fileSize, java.lang.String fileName, javax.activation.DataHandler data, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkinFromUrlAsync(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.String fileName, java.lang.String url, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SLongCheckinActionState checkinFromUrlSync(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.String fileName, java.lang.String url, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkinInitiatedAsync(java.lang.Long topicId, java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.Long fileSize, java.lang.String fileName, javax.activation.DataHandler data, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SLongCheckinActionState checkinInitiatedSync(java.lang.Long topicId, java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.Long fileSize, java.lang.String fileName, javax.activation.DataHandler data, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SLongCheckinActionState checkinSync(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.Long fileSize, java.lang.String fileName, javax.activation.DataHandler data, java.lang.Boolean merge) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkout(java.lang.Long roid, java.lang.Long serializerOid, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public void cleanupLongAction(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public java.lang.Long clone(java.lang.Long roid, java.lang.String projectName, java.lang.String comment, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long roid1, java.lang.Long roid2, org.bimserver.interfaces.objects.SCompareType sCompareType, java.lang.Long mcid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean deleteProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public void deleteService(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean deleteUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String determineIfcVersion(byte[] head, java.lang.Boolean zipped) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long download(java.util.Set<java.lang.Long> roids, java.lang.String query, java.lang.Long serializerOid, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadCompareResults(java.lang.Long serializerOid, java.lang.Long roid1, java.lang.Long roid2, java.lang.Long mcid, org.bimserver.interfaces.objects.SCompareType type, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedData> getAllExtendedDataOfRevision(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedData> getAllExtendedDataOfRevisionAndSchema(java.lang.Long roid, java.lang.Long schemaId) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> getAllExtendedDataSchemas() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllLocalProfiles(java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceDescriptor> getAllLocalServiceDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> getAllModelCheckers() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> getAllModelCheckersOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SNewService> getAllNewServicesOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllPrivateProfiles(java.lang.String notificationsUrl, java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects(java.lang.Boolean onlyTopLevel, java.lang.Boolean onlyActive) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProjectSmall> getAllProjectsSmall() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllPublicProfiles(java.lang.String notificationsUrl, java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProjectSmall> getAllRelatedProjects(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> getAllRepositoryExtendedDataSchemas(java.lang.Boolean usePre) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> getAllRepositoryModelCheckers() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceDescriptor> getAllServiceDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SService> getAllServicesOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllWritableProjects() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Double getArea(java.lang.Long roid, java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.String> getAvailableClasses() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.String> getAvailableClassesInRevision(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.Set<java.lang.String> getCheckinWarnings(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDensity getDensityThreshold(java.util.Set<java.lang.Long> roids, java.lang.Long nrTriangles, java.util.Set<java.lang.String> excludedTypes) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getDeserializerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getDeserializerByName(java.lang.String deserializerName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Long topicId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedData getExtendedData(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaFromRepository(java.lang.String namespace) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SFile getFile(java.lang.Long fileId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SFile getFileMeta(java.lang.Long fileId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long goid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.Set<java.lang.Long> getGeometryDataToReuse(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> excludedTypes, java.lang.Integer trianglesToSave) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SGeometryInfo getGeometryInfo(java.lang.Long roid, java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SIfcHeader getIfcHeader(java.lang.Long croid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedData getLastExtendedDataOfRevisionAndSchema(java.lang.Long roid, java.lang.Long schemaId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getModelBounds(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getModelBoundsForConcreteRevision(java.lang.Long croid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getModelBoundsUntransformed(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getModelBoundsUntransformedForConcreteRevision(java.lang.Long croid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelCheckerInstance getModelCheckerInstance(java.lang.Long mcioid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SVector3f getModelMaxBounds(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SVector3f getModelMinBounds(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SNewService getNewService(java.lang.Long soid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getNrPrimitives(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getNrPrimitivesTotal(java.util.Set<java.lang.Long> roids) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getOidByGuid(java.lang.Long roid, java.lang.String guid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject getProjectByUuid(java.lang.String uuid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProjectSmall getProjectSmallByPoid(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getQueryEngineById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getQueryEngineByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getQueryEngineExample(java.lang.Long qeid, java.lang.String key) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.String> getQueryEngineExampleKeys(java.lang.Long qeid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByContentType(java.lang.String contentType) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByName(java.lang.String serializerName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SService getService(java.lang.Long soid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServiceDescriptor getServiceDescriptor(java.lang.String baseUrl, java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject getSubProjectByName(java.lang.Long parentProjectId, java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(java.lang.String extension, java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Number> getTileCounts(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> excludedTypes, java.util.Set<java.lang.Long> geometryIdsToReuse, java.lang.Float minimumThreshold, java.lang.Float maximumThreshold, java.lang.Integer depth) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.STile> getTiles(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> excludedTypes, java.util.Set<java.lang.Long> geometryIdsToReuse, java.lang.Float minimumThreshold, java.lang.Float maximumThreshold, java.lang.Integer depth) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject getTopLevelProjectByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getTotalBounds(java.util.Set<java.lang.Long> roids) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBounds getTotalUntransformedBounds(java.util.Set<java.lang.Long> roids) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String username) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getUserRelatedLogs(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUserSettings getUserSettings() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Double getVolume(java.lang.Long roid, java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public void importData(java.lang.String address, java.lang.String username, java.lang.String password, java.lang.String path) throws UserException, ServerException {
	}
	
	public java.lang.Long initiateCheckin(java.lang.Long poid, java.lang.Long deserializerOid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SBounds> listBoundingBoxes(java.util.Set<java.lang.Long> roids) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long regenerateGeometry(java.lang.Long roid, java.lang.Long eoid) throws UserException, ServerException {
		return null;
	}
	
	public void removeModelCheckerFromProject(java.lang.Long poid, java.lang.Long modelCheckerOid) throws UserException, ServerException {
	}
	
	public void removeNewServiceFromProject(java.lang.Long poid, java.lang.Long serviceOid) throws UserException, ServerException {
	}
	
	public void removeServiceFromProject(java.lang.Long poid, java.lang.Long serviceOid) throws UserException, ServerException {
	}
	
	public void removeUserFromExtendedDataSchema(java.lang.Long uoid, java.lang.Long edsid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean removeUserFromProject(java.lang.Long uoid, java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType sCompareType, java.lang.Long mcid, java.lang.Long poid, java.lang.Long roid1, java.lang.Long roid2, java.lang.String address) throws UserException, ServerException {
	}
	
	public void setRevisionTag(java.lang.Long roid, java.lang.String tag) throws UserException, ServerException {
	}
	
	public java.lang.String shareRevision(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public void terminateLongRunningAction(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void triggerNewExtendedData(java.lang.Long edid, java.lang.Long soid) throws UserException, ServerException {
	}
	
	public void triggerNewRevision(java.lang.Long roid, java.lang.Long soid) throws UserException, ServerException {
	}
	
	public void triggerRevisionService(java.lang.Long roid, java.lang.Long soid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean undeleteProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean undeleteUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag sGeoTag) throws UserException, ServerException {
	}
	
	public void updateModelChecker(org.bimserver.interfaces.objects.SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
	}
	
	public void updateProject(org.bimserver.interfaces.objects.SProject sProject) throws UserException, ServerException {
	}
	
	public void updateRevision(org.bimserver.interfaces.objects.SRevision sRevision) throws UserException, ServerException {
	}
	
	public java.lang.Long uploadFile(org.bimserver.interfaces.objects.SFile file) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean userHasCheckinRights(java.lang.Long uoid, java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean userHasRights(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public void validateModelChecker(java.lang.Long oid) throws UserException, ServerException {
	}
	
}