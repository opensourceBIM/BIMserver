package org.bimserver.pb;

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
import org.bimserver.shared.pb.Reflector;

@SuppressWarnings("unchecked")
public class ServiceInterfaceReflectorImpl implements org.bimserver.shared.ServiceInterface {

private Reflector reflector;

	public ServiceInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public java.util.Date getActiveSince() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getActiveSince", java.util.Date.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor> getAllIfcEnginePluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllIfcEnginePluginDescriptors", java.util.List.class);
	}
	public java.lang.String getSettingSmtpServer() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSmtpServer", java.lang.String.class);
	}
	public void setSettingEmailSenderAddress(java.lang.String emailSenderAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingEmailSenderAddress", void.class, emailSenderAddress);
	}
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String projectName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProject", org.bimserver.interfaces.objects.SProject.class, projectName);
	}
	public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SMergeIdentifier) reflector.callMethod("ServiceInterface", "getSettingMergeIdentifier", org.bimserver.interfaces.objects.SMergeIdentifier.class);
	}
	public void deleteDeserializer(java.lang.Long sid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteDeserializer", void.class, sid);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long roid, java.lang.Long oid, java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByOid", org.bimserver.interfaces.objects.SDataObject.class, roid, oid, className);
	}
	public java.lang.Boolean isSettingIntelligentMerging() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingIntelligentMerging", java.lang.Boolean.class);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerById", org.bimserver.interfaces.objects.SDeserializer.class, oid);
	}
	public void setSettingProtocolBuffersPort(java.lang.Integer port) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingProtocolBuffersPort", void.class, port);
	}
	public void setBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setBooleanAttribute", void.class, oid, className, attributeName, value);
	}
	public void setSettingAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingAllowSelfRegistration", void.class, allowSelfRegistration);
	}
	public void deleteIfcEngine(java.lang.Long iid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteIfcEngine", void.class, iid);
	}
	public java.util.List<java.lang.String> getAvailableClassesInRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClassesInRevision", java.util.List.class, arg0);
	}
	public void addIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addIntegerAttribute", void.class, oid, className, attributeName, value);
	}
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingSendConfirmationEmailAfterRegistration", java.lang.Boolean.class);
	}
	public java.lang.String getSettingCustomLogoAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingCustomLogoAddress", java.lang.String.class);
	}
	public void addBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addBooleanAttribute", void.class, oid, className, attributeName, value);
	}
	public java.lang.String getServerLog() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getServerLog", java.lang.String.class);
	}
	public void setStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setStringAttribute", void.class, oid, className, attributeName, value);
	}
	public void setSettingCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCheckinMergingEnabled", void.class, checkinMergingEnabled);
	}
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDM> getAllObjectIDMs(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SObjectIDM>) reflector.callMethod("ServiceInterface", "getAllObjectIDMs", java.util.List.class, onlyEnabled);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsByUser", java.util.List.class, uoid);
	}
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Integer actionId) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDownloadResult) reflector.callMethod("ServiceInterface", "getDownloadData", org.bimserver.interfaces.objects.SDownloadResult.class, actionId);
	}
	public void sendClashesEmail(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings, java.lang.Long poid, java.util.Set<java.lang.String> addressesTo) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "sendClashesEmail", void.class, sClashDetectionSettings, poid, addressesTo);
	}
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getLoggedInUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public java.lang.String getSettingSiteAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSiteAddress", java.lang.String.class);
	}
	public java.lang.String getSettingRegistrationAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingRegistrationAddition", java.lang.String.class);
	}
	public void setRevisionTag(java.lang.Long roid, java.lang.String tag) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setRevisionTag", void.class, roid, tag);
	}
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("ServiceInterface", "getRevision", org.bimserver.interfaces.objects.SRevision.class, roid);
	}
	public void deleteObjectIDM(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteObjectIDM", void.class, oid);
	}
	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingShowVersionUpgradeAvailable", java.lang.Boolean.class);
	}
	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.Long> oids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByOids", java.lang.Integer.class, roids, oids, serializerName, sync);
	}
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long goid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("ServiceInterface", "getGeoTag", org.bimserver.interfaces.objects.SGeoTag.class, goid);
	}
	public java.lang.Boolean autologin(java.lang.String username, java.lang.String hash) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "autologin", java.lang.Boolean.class, username, hash);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUoid", org.bimserver.interfaces.objects.SUser.class, uoid);
	}
	public java.lang.Integer getSettingProtocolBuffersPort() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "getSettingProtocolBuffersPort", java.lang.Integer.class);
	}
	public void setSettingMergeIdentifier(org.bimserver.interfaces.objects.SMergeIdentifier mergeIdentifier) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingMergeIdentifier", void.class, mergeIdentifier);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsOfProject", java.util.List.class, poid);
	}
	public void addObjectIDM(org.bimserver.interfaces.objects.SObjectIDM objectIDM) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addObjectIDM", void.class, objectIDM);
	}
	public java.lang.Boolean isSettingAutoTestClashes() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAutoTestClashes", java.lang.Boolean.class);
	}
	public org.bimserver.interfaces.objects.SCheckinResult getCheckinState(java.lang.Integer actionID) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "getCheckinState", org.bimserver.interfaces.objects.SCheckinResult.class, actionID);
	}
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer serializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateSerializer", void.class, serializer);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUserSession>) reflector.callMethod("ServiceInterface", "getActiveUserSessions", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SIfcEngine> getAllIfcEngines(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SIfcEngine>) reflector.callMethod("ServiceInterface", "getAllIfcEngines", java.util.List.class, onlyEnabled);
	}
	public java.lang.Boolean deleteUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteUser", java.lang.Boolean.class, uoid);
	}
	public void addStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addStringAttribute", void.class, oid, className, attributeName, value);
	}
	public void addIfcEngine(org.bimserver.interfaces.objects.SIfcEngine ifcEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addIfcEngine", void.class, ifcEngine);
	}
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType sCompareType, org.bimserver.interfaces.objects.SCompareIdentifier sCompareIdentifier, java.lang.Long poid, java.lang.Long roid1, java.lang.Long roid2, java.lang.String address) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "sendCompareEmail", void.class, sCompareType, sCompareIdentifier, poid, roid1, roid2, address);
	}
	public void setSettingHideUserListForNonAdmin(java.lang.Boolean hideUserListForNonAdmin) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingHideUserListForNonAdmin", void.class, hideUserListForNonAdmin);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getProjectsByName", java.util.List.class, name);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllReadableProjects", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getUsersProjects", java.util.List.class, uoid);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProject", java.util.List.class, poid);
	}
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean allowUsersToCreateTopLevelProjects) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingAllowUsersToCreateTopLevelProjects", void.class, allowUsersToCreateTopLevelProjects);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllDeserializerPluginDescriptors", java.util.List.class);
	}
	public java.lang.String ping(java.lang.String in) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "ping", java.lang.String.class, in);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfRevision", java.util.List.class, roid);
	}
	public java.util.Date getLastDatabaseReset() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastDatabaseReset", java.util.Date.class);
	}
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag sGeoTag) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateGeoTag", void.class, sGeoTag);
	}
	public java.lang.Boolean userHasCheckinRights(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasCheckinRights", java.lang.Boolean.class, poid);
	}
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("ServiceInterface", "getAccessMethod", org.bimserver.interfaces.objects.SAccessMethod.class);
	}
	public java.lang.String getSettingEmailSenderAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEmailSenderAddress", java.lang.String.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidClash> findClashesByGuid(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidClash>) reflector.callMethod("ServiceInterface", "findClashesByGuid", java.util.List.class, sClashDetectionSettings);
	}
	public java.lang.Boolean isSettingCacheOutputFiles() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCacheOutputFiles", java.lang.Boolean.class);
	}
	public java.lang.Boolean addUserToProject(java.lang.Long uoid, java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "addUserToProject", java.lang.Boolean.class, uoid, poid);
	}
	public org.bimserver.interfaces.objects.SVersion getVersion() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
	public java.util.List<java.lang.String> getAvailableClasses() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClasses", java.util.List.class);
	}
	public void setSettingSmtpServer(java.lang.String smtpServer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSmtpServer", void.class, smtpServer);
	}
	public void deleteSerializer(java.lang.Long sid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteSerializer", void.class, sid);
	}
	public void setSettingFooterAddition(java.lang.String footerAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingFooterAddition", void.class, footerAddition);
	}
	public org.bimserver.interfaces.objects.SObjectIDM getObjectIDMById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SObjectIDM) reflector.callMethod("ServiceInterface", "getObjectIDMById", org.bimserver.interfaces.objects.SObjectIDM.class, oid);
	}
	public org.bimserver.interfaces.objects.SServerInfo getServerInfo() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SServerInfo) reflector.callMethod("ServiceInterface", "getServerInfo", org.bimserver.interfaces.objects.SServerInfo.class);
	}
	public org.bimserver.interfaces.objects.SCompileResult compile(java.lang.String code) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCompileResult) reflector.callMethod("ServiceInterface", "compile", org.bimserver.interfaces.objects.SCompileResult.class, code);
	}
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLogAction>) reflector.callMethod("ServiceInterface", "getLogs", java.util.List.class);
	}
	public java.lang.Integer branchToNewProject(java.lang.Long roid, java.lang.String projectName, java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "branchToNewProject", java.lang.Integer.class, roid, projectName, comment);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long roid, java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjectsByType", java.util.List.class, roid, className);
	}
	public java.lang.String getRemoteAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getRemoteAddress", java.lang.String.class);
	}
	public void setReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setReference", void.class, oid, className, referenceName, referenceOid, referenceClassName);
	}
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean sendConfirmationEmailAfterRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSendConfirmationEmailAfterRegistration", void.class, sendConfirmationEmailAfterRegistration);
	}
	public void addSerializer(org.bimserver.interfaces.objects.SSerializer serializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addSerializer", void.class, serializer);
	}
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String projectName, java.lang.Long parentPoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProjectAsSubProject", org.bimserver.interfaces.objects.SProject.class, projectName, parentPoid);
	}
	public void removeObject(java.lang.String className, java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeObject", void.class, className, oid);
	}
	public java.lang.Integer downloadByTypes(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> classNames, java.lang.String serializerName, java.lang.Boolean includeAllSubtypes, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByTypes", java.lang.Integer.class, roids, classNames, serializerName, includeAllSubtypes, sync);
	}
	public java.lang.Integer branchToExistingProject(java.lang.Long roid, java.lang.Long destPoid, java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "branchToExistingProject", java.lang.Integer.class, roid, destPoid, comment);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllUsers", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String contentType) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByContentType", org.bimserver.interfaces.objects.SSerializer.class, contentType);
	}
	public java.lang.Boolean undeleteUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteUser", java.lang.Boolean.class, uoid);
	}
	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> guids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByGuids", java.lang.Integer.class, roids, guids, serializerName, sync);
	}
	public void logout() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "logout", void.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SClash> getLastClashes(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SClash>) reflector.callMethod("ServiceInterface", "getLastClashes", java.util.List.class, roid);
	}
	public java.lang.Integer download(java.lang.Long roid, java.lang.String serializerName, java.lang.Boolean showOwn, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "download", java.lang.Integer.class, roid, serializerName, showOwn, sync);
	}
	public java.lang.Integer checkin(java.lang.Long poid, java.lang.String comment, java.lang.String deserializerName, java.lang.Long fileSize, javax.activation.DataHandler ifcFile, java.lang.Boolean merge, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkin", java.lang.Integer.class, poid, comment, deserializerName, fileSize, ifcFile, merge, sync);
	}
	public void unsetReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "unsetReference", void.class, oid, className, referenceName);
	}
	public org.bimserver.interfaces.objects.SIfcEngine getIfcEngineById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SIfcEngine) reflector.callMethod("ServiceInterface", "getIfcEngineById", org.bimserver.interfaces.objects.SIfcEngine.class, oid);
	}
	public void setDoubleAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Double value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDoubleAttribute", void.class, oid, className, attributeName, value);
	}
	public void addReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addReference", void.class, oid, className, referenceName, referenceOid, referenceClassName);
	}
	public void setSettingIntelligentMerging(java.lang.Boolean intelligentMerging) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingIntelligentMerging", void.class, intelligentMerging);
	}
	public void updateRevision(org.bimserver.interfaces.objects.SRevision sRevision) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateRevision", void.class, sRevision);
	}
	public java.lang.Integer checkout(java.lang.Long roid, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkout", java.lang.Integer.class, roid, serializerName, sync);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllProjects", java.util.List.class);
	}
	public void setIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setIntegerAttribute", void.class, oid, className, attributeName, value);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedUsersOfProject", java.util.List.class, poid);
	}
	public java.lang.String getProtocolBuffersFile() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getProtocolBuffersFile", java.lang.String.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProjectAndSubProjects", java.util.List.class, poid);
	}
	public java.lang.Integer downloadRevisions(java.util.Set<java.lang.Long> roids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadRevisions", java.lang.Integer.class, roids, serializerName, sync);
	}
	public java.lang.Integer compileAndDownload(java.lang.Long roid, java.lang.String code) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "compileAndDownload", java.lang.Integer.class, roid, code);
	}
	public void disablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "disablePlugin", void.class, arg0);
	}
	public void setSettingSiteAddress(java.lang.String siteAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSiteAddress", void.class, siteAddress);
	}
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer deserializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateDeserializer", void.class, deserializer);
	}
	public org.bimserver.interfaces.objects.SLongActionState getDownloadState(java.lang.Integer actionId) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SLongActionState) reflector.callMethod("ServiceInterface", "getDownloadState", org.bimserver.interfaces.objects.SLongActionState.class, actionId);
	}
	public org.bimserver.interfaces.objects.SUser validateAccount(java.lang.Long uoid, java.lang.String token, java.lang.String password) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "validateAccount", org.bimserver.interfaces.objects.SUser.class, uoid, token, password);
	}
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("ServiceInterface", "getCheckoutWarnings", java.util.Set.class, poid);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllSerializerPluginDescriptors", java.util.List.class);
	}
	public void setHttpCallback(java.lang.Long uoid, java.lang.String address) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setHttpCallback", void.class, uoid, address);
	}
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDatabaseInformation) reflector.callMethod("ServiceInterface", "getDatabaseInformation", org.bimserver.interfaces.objects.SDatabaseInformation.class);
	}
	public java.lang.Integer downloadCompareResults(java.lang.String serializerName, java.lang.Long roid1, java.lang.Long roid2, org.bimserver.interfaces.objects.SCompareIdentifier identifier, org.bimserver.interfaces.objects.SCompareType type, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadCompareResults", java.lang.Integer.class, serializerName, roid1, roid2, identifier, type, sync);
	}
	public void removeAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer index) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeAttribute", void.class, oid, className, attributeName, index);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getAllSerializers", java.util.List.class, onlyEnabled);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getAllDeserializers", java.util.List.class, oid);
	}
	public void enablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "enablePlugin", void.class, arg0);
	}
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String type) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializerPluginDescriptor) reflector.callMethod("ServiceInterface", "getSerializerPluginDescriptor", org.bimserver.interfaces.objects.SSerializerPluginDescriptor.class, type);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String serializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByName", org.bimserver.interfaces.objects.SSerializer.class, serializerName);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjects", java.util.List.class, arg0);
	}
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevisionSummary) reflector.callMethod("ServiceInterface", "getRevisionSummary", org.bimserver.interfaces.objects.SRevisionSummary.class, roid);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerById", org.bimserver.interfaces.objects.SSerializer.class, oid);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedProjectsOfUser", java.util.List.class, uoid);
	}
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllPlugins", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String username) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUserName", org.bimserver.interfaces.objects.SUser.class, username);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String deserializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerByName", org.bimserver.interfaces.objects.SDeserializer.class, deserializerName);
	}
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowUsersToCreateTopLevelProjects", java.lang.Boolean.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SMigration> getMigrations() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SMigration>) reflector.callMethod("ServiceInterface", "getMigrations", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getSubProjects", java.util.List.class, poid);
	}
	public java.lang.Boolean isSettingAllowSelfRegistration() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowSelfRegistration", java.lang.Boolean.class);
	}
	public org.bimserver.interfaces.objects.SUser getCurrentUser() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getCurrentUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public void removeReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Integer index) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeReference", void.class, oid, className, referenceName, index);
	}
	public void setSettingCacheOutputFiles(java.lang.Boolean cacheOutputFiles) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCacheOutputFiles", void.class, cacheOutputFiles);
	}
	public void setEnumAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setEnumAttribute", void.class, oid, className, attributeName, value);
	}
	public java.lang.Boolean login(java.lang.String username, java.lang.String password) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "login", java.lang.Boolean.class, username, password);
	}
	public org.bimserver.shared.Token getCurrentToken() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.shared.Token) reflector.callMethod("ServiceInterface", "getCurrentToken", org.bimserver.shared.Token.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllAuthorizedUsersOfProject", java.util.List.class, poid);
	}
	public void setSettingHeaderAddition(java.lang.String headerAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingHeaderAddition", void.class, headerAddition);
	}
	public void setSettingAutoTestClashes(java.lang.Boolean autoTestClashes) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingAutoTestClashes", void.class, autoTestClashes);
	}
	public void setSettingRegistrationAddition(java.lang.String registrationAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingRegistrationAddition", void.class, registrationAddition);
	}
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllObjectIDMPluginDescriptors", java.util.List.class);
	}
	public java.lang.Boolean hasActiveSerializer(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "hasActiveSerializer", java.lang.Boolean.class, arg0);
	}
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCheckinMergingEnabled", java.lang.Boolean.class);
	}
	public void abortTransaction() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "abortTransaction", void.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SEidClash> findClashesByEid(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SEidClash>) reflector.callMethod("ServiceInterface", "findClashesByEid", java.util.List.class, sClashDetectionSettings);
	}
	public java.util.List<org.bimserver.interfaces.objects.SLongAction> getActiveLongActions() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLongAction>) reflector.callMethod("ServiceInterface", "getActiveLongActions", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsByUser", java.util.List.class, uoid);
	}
	public org.bimserver.interfaces.objects.SRunResult compileAndRun(java.lang.Long roid, java.lang.String code) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRunResult) reflector.callMethod("ServiceInterface", "compileAndRun", org.bimserver.interfaces.objects.SRunResult.class, roid, code);
	}
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "getProjectByPoid", org.bimserver.interfaces.objects.SProject.class, poid);
	}
	public java.lang.String getSettingHeaderAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingHeaderAddition", java.lang.String.class);
	}
	public java.lang.Boolean changePassword(java.lang.Long uoid, java.lang.String oldPassword, java.lang.String newPassword) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "changePassword", java.lang.Boolean.class, uoid, oldPassword, newPassword);
	}
	public org.bimserver.interfaces.objects.SUser addUser(java.lang.String username, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "addUser", org.bimserver.interfaces.objects.SUser.class, username, name, type, selfRegistration);
	}
	public void close() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "close", void.class);
	}
	public void requestPasswordChange(java.lang.String username) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "requestPasswordChange", void.class, username);
	}
	public java.lang.Boolean upgradePossible() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "upgradePossible", java.lang.Boolean.class);
	}
	public java.lang.Boolean userHasRights(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasRights", java.lang.Boolean.class, poid);
	}
	public java.lang.Integer checkoutLastRevision(java.lang.Long poid, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkoutLastRevision", java.lang.Integer.class, poid, serializerName, sync);
	}
	public void setSettingCustomLogoAddress(java.lang.String customLogoAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCustomLogoAddress", void.class, customLogoAddress);
	}
	public void setup(java.lang.String siteAddress, java.lang.String smtpServer, java.lang.String adminName, java.lang.String adminUsername, java.lang.String adminPassword) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setup", void.class, siteAddress, smtpServer, adminName, adminUsername, adminPassword);
	}
	public void updateObjectIDM(org.bimserver.interfaces.objects.SObjectIDM objectIDM) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateObjectIDM", void.class, objectIDM);
	}
	public java.lang.Boolean isSettingHideUserListForNonAdmin() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingHideUserListForNonAdmin", java.lang.Boolean.class);
	}
	public void updateProject(org.bimserver.interfaces.objects.SProject sProject) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateProject", void.class, sProject);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long roid, java.lang.String guid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByGuid", org.bimserver.interfaces.objects.SDataObject.class, roid, guid);
	}
	public java.lang.Long commitTransaction(java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "commitTransaction", java.lang.Long.class, comment);
	}
	public void unsetAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "unsetAttribute", void.class, oid, className, attributeName);
	}
	public org.bimserver.interfaces.objects.SObjectIDM getObjectIDMByName(java.lang.String objectIDMName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SObjectIDM) reflector.callMethod("ServiceInterface", "getObjectIDMByName", org.bimserver.interfaces.objects.SObjectIDM.class, objectIDMName);
	}
	public java.lang.Long createObject(java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "createObject", java.lang.Long.class, className);
	}
	public void addDoubleAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Double value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addDoubleAttribute", void.class, oid, className, attributeName, value);
	}
	public java.lang.Boolean deleteProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteProject", java.lang.Boolean.class, poid);
	}
	public void changeUserType(java.lang.Long uoid, org.bimserver.interfaces.objects.SUserType userType) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "changeUserType", void.class, uoid, userType);
	}
	public org.bimserver.interfaces.objects.SIfcEngine getIfcEngineByName(java.lang.String serializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SIfcEngine) reflector.callMethod("ServiceInterface", "getIfcEngineByName", org.bimserver.interfaces.objects.SIfcEngine.class, serializerName);
	}
	public void updateIfcEngine(org.bimserver.interfaces.objects.SIfcEngine ifcEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateIfcEngine", void.class, ifcEngine);
	}
	public java.lang.String getSettingFooterAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingFooterAddition", java.lang.String.class);
	}
	public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(java.lang.Long cdsoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SClashDetectionSettings) reflector.callMethod("ServiceInterface", "getClashDetectionSettings", org.bimserver.interfaces.objects.SClashDetectionSettings.class, cdsoid);
	}
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long roid1, java.lang.Long roid2, org.bimserver.interfaces.objects.SCompareType sCompareType, org.bimserver.interfaces.objects.SCompareIdentifier sCompareIdentifier) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCompareResult) reflector.callMethod("ServiceInterface", "compare", org.bimserver.interfaces.objects.SCompareResult.class, roid1, roid2, sCompareType, sCompareIdentifier);
	}
	public void addDeserializer(org.bimserver.interfaces.objects.SDeserializer deserializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addDeserializer", void.class, deserializer);
	}
	public void migrateDatabase() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "migrateDatabase", void.class);
	}
	public java.lang.Boolean removeUserFromProject(java.lang.Long uoid, java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "removeUserFromProject", java.lang.Boolean.class, uoid, poid);
	}
	public void startTransaction(java.lang.Integer pid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "startTransaction", void.class, pid);
	}
	public java.util.Date getLastActive() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastActive", java.util.Date.class);
	}
	public java.lang.Boolean undeleteProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteProject", java.lang.Boolean.class, poid);
	}
	public java.util.Date getServerStartTime() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getServerStartTime", java.util.Date.class);
	}
	public java.lang.Boolean isLoggedIn() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isLoggedIn", java.lang.Boolean.class);
	}
	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean showVersionUpgradeAvailable) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingShowVersionUpgradeAvailable", void.class, showVersionUpgradeAvailable);
	}
	public void updateClashDetectionSettings(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateClashDetectionSettings", void.class, sClashDetectionSettings);
	}
	public org.bimserver.interfaces.objects.SVersion getLatestVersion() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getLatestVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
}
