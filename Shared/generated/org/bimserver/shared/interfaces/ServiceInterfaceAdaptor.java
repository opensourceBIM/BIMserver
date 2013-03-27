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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class ServiceInterfaceAdaptor implements ServiceInterface {

	public void addExtendedDataSchema(org.bimserver.interfaces.objects.SExtendedDataSchema extendedDataSchema) throws UserException, ServerException {
	}
	
	public void addExtendedDataToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws UserException, ServerException {
	}
	
	public void addExtendedDataToRevision(java.lang.Long roid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws UserException, ServerException {
	}
	
	public void addLocalServiceToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SService sService, java.lang.Long internalServiceOid) throws UserException, ServerException {
	}
	
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String projectName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String projectName, java.lang.Long parentPoid) throws UserException, ServerException {
		return null;
	}
	
	public void addServiceToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SService sService) throws UserException, ServerException {
	}
	
	public org.bimserver.interfaces.objects.SUser addUser(java.lang.String username, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration) throws UserException, ServerException {
		return null;
	}
	
	public void addUserToExtendedDataSchema(java.lang.Long uoid, java.lang.Long edsid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean addUserToProject(java.lang.Long uoid, java.lang.Long poid) throws UserException, ServerException {
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
	
	public java.lang.Long checkin(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.Long fileSize, java.lang.String fileName, javax.activation.DataHandler ifcFile, java.lang.Boolean merge, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkinFromUrl(java.lang.Long poid, java.lang.String comment, java.lang.Long deserializerOid, java.lang.String fileName, java.lang.String url, java.lang.Boolean merge, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkout(java.lang.Long roid, java.lang.Long serializerOid, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long checkoutLastRevision(java.lang.Long poid, java.lang.Long serializerOid, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public void cleanupLongAction(java.lang.Long actionId) throws UserException, ServerException {
	}
	
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long roid1, java.lang.Long roid2, org.bimserver.interfaces.objects.SCompareType sCompareType, java.lang.Long mcid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer count(java.lang.Long roid, java.lang.String className) throws UserException, ServerException {
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
	
	public java.lang.Long download(java.lang.Long roid, java.lang.Long serializerOid, java.lang.Boolean showOwn, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadByGuids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> guids, java.lang.Long serializerOid, java.lang.Boolean deep, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadByNames(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> names, java.lang.Long serializerOid, java.lang.Boolean deep, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadByOids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.Long> oids, java.lang.Long serializerOid, java.lang.Boolean sync, java.lang.Boolean deep) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadByTypes(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> classNames, java.lang.Long serializerOid, java.lang.Boolean includeAllSubtypes, java.lang.Boolean useObjectIDM, java.lang.Boolean deep, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadCompareResults(java.lang.Long serializerOid, java.lang.Long roid1, java.lang.Long roid2, java.lang.Long mcid, org.bimserver.interfaces.objects.SCompareType type, java.lang.Boolean sync) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadQuery(java.lang.Long roid, java.lang.Long qeid, java.lang.String code, java.lang.Boolean sync, java.lang.Long serializerOid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long downloadRevisions(java.util.Set<java.lang.Long> roids, java.lang.Long serializerOid, java.lang.Boolean sync) throws UserException, ServerException {
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
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> getAllExtendedDataSchemas() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllLocalProfiles(java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceDescriptor> getAllLocalServiceDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllPrivateProfiles(java.lang.String notificationsUrl, java.lang.String serviceIdentifier, java.lang.String token) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects(java.lang.Boolean onlyTopLevel) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getAllPublicProfiles(java.lang.String notificationsUrl, java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> getAllRepositoryExtendedDataSchemas() throws UserException, ServerException {
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
	
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Long actionId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedData getExtendedData(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaByNamespace(java.lang.String namespace) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaFromRepository(java.lang.String namespace) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SFile getFile(java.lang.Long fileId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long goid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SLongActionState getLongActionState(java.lang.Long actionId) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getOidByGuid(java.lang.Long roid, java.lang.String guid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String name) throws UserException, ServerException {
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
	
	public org.bimserver.interfaces.objects.SService getService(java.lang.Long soid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServiceDescriptor getServiceDescriptor(java.lang.String url) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(java.lang.String extension) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String username) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUserSettings getUserSettings() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long uoid) throws UserException, ServerException {
		return null;
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
	
	public void triggerNewExtendedData(java.lang.Long edid, java.lang.Long soid) throws UserException, ServerException {
	}
	
	public void triggerNewRevision(java.lang.Long roid, java.lang.Long soid) throws UserException, ServerException {
	}
	
	public java.lang.Boolean undeleteProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean undeleteUser(java.lang.Long uoid) throws UserException, ServerException {
		return null;
	}
	
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag sGeoTag) throws UserException, ServerException {
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
	
}