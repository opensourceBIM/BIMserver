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
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long arg0, java.lang.Long arg1, org.bimserver.interfaces.objects.SCompareType arg2, org.bimserver.interfaces.objects.SCompareIdentifier arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCompareResult) reflector.callMethod("ServiceInterface", "compare", org.bimserver.interfaces.objects.SCompareResult.class, arg0, arg1, arg2, arg3);
	}
	public void setup(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setup", void.class, arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public void close() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "close", void.class);
	}
	public org.bimserver.interfaces.objects.SCompileResult compile(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCompileResult) reflector.callMethod("ServiceInterface", "compile", org.bimserver.interfaces.objects.SCompileResult.class, arg0);
	}
	public java.lang.Long createObject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "createObject", java.lang.Long.class, arg0);
	}
	public org.bimserver.interfaces.objects.SVersion getLatestVersion() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getLatestVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
	public org.bimserver.interfaces.objects.SVersion getVersion() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SMigration> getMigrations() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SMigration>) reflector.callMethod("ServiceInterface", "getMigrations", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("ServiceInterface", "getAccessMethod", org.bimserver.interfaces.objects.SAccessMethod.class);
	}
	public void removeAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingSendConfirmationEmailAfterRegistration", java.lang.Boolean.class);
	}
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSendConfirmationEmailAfterRegistration", void.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getAllDeserializers", java.util.List.class, arg0);
	}
	public void registerNewRevisionListener() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "registerNewRevisionListener", void.class);
	}
	public void setHttpCallback(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setHttpCallback", void.class, arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SRunResult compileAndRun(long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRunResult) reflector.callMethod("ServiceInterface", "compileAndRun", org.bimserver.interfaces.objects.SRunResult.class, arg0, arg1);
	}
	public java.lang.Integer compileAndDownload(long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "compileAndDownload", java.lang.Integer.class, arg0, arg1);
	}
	public java.lang.String getProtocolBuffersFile() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getProtocolBuffersFile", java.lang.String.class);
	}
	public org.bimserver.interfaces.objects.SServerInfo getServerInfo() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SServerInfo) reflector.callMethod("ServiceInterface", "getServerInfo", org.bimserver.interfaces.objects.SServerInfo.class);
	}
	public java.lang.Boolean upgradePossible() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "upgradePossible", java.lang.Boolean.class);
	}
	public java.lang.String getRemoteAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getRemoteAddress", java.lang.String.class);
	}
	public java.util.List<java.lang.String> getAvailableClassesInRevision(long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClassesInRevision", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedProjectsOfUser", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedUsersOfProject", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllAuthorizedUsersOfProject", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProjectAndSubProjects", java.util.List.class, arg0);
	}
	public java.lang.String getSettingRegistrationAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingRegistrationAddition", java.lang.String.class);
	}
	public void setSettingRegistrationAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingRegistrationAddition", void.class, arg0);
	}
	public java.lang.Boolean isSettingAllowSelfRegistration() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowSelfRegistration", java.lang.Boolean.class);
	}
	public void setSettingAllowSelfRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAllowSelfRegistration", void.class, arg0);
	}
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowUsersToCreateTopLevelProjects", java.lang.Boolean.class);
	}
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAllowUsersToCreateTopLevelProjects", void.class, arg0);
	}
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCheckinMergingEnabled", java.lang.Boolean.class);
	}
	public void setSettingCheckinMergingEnabled(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCheckinMergingEnabled", void.class, arg0);
	}
	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingShowVersionUpgradeAvailable", java.lang.Boolean.class);
	}
	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingShowVersionUpgradeAvailable", void.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllSerializerPluginDescriptors", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllDeserializerPluginDescriptors", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializerPluginDescriptor) reflector.callMethod("ServiceInterface", "getSerializerPluginDescriptor", org.bimserver.interfaces.objects.SSerializerPluginDescriptor.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllGuidanceProviderPluginDescriptors", java.util.List.class);
	}
	public java.lang.Boolean autologin(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "autologin", java.lang.Boolean.class, arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinSync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "checkinSync", org.bimserver.interfaces.objects.SCheckinResult.class, arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinAsync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "checkinAsync", org.bimserver.interfaces.objects.SCheckinResult.class, arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.Integer download(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "download", java.lang.Integer.class, arg0, arg1, arg2);
	}
	public java.lang.Long addUser(java.lang.String arg0, java.lang.String arg1, org.bimserver.interfaces.objects.SUserType arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "addUser", java.lang.Long.class, arg0, arg1, arg2, arg3);
	}
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProject", org.bimserver.interfaces.objects.SProject.class, arg0);
	}
	public java.lang.Boolean deleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteUser", java.lang.Boolean.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllUsers", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("ServiceInterface", "getRevision", org.bimserver.interfaces.objects.SRevision.class, arg0);
	}
	public void logout() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "logout", void.class);
	}
	public java.lang.Boolean undeleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteUser", java.lang.Boolean.class, arg0);
	}
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("ServiceInterface", "getGeoTag", org.bimserver.interfaces.objects.SGeoTag.class, arg0);
	}
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateGeoTag", void.class, arg0);
	}
	public java.lang.Boolean isLoggedIn() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isLoggedIn", java.lang.Boolean.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SLogAction>) reflector.callMethod("ServiceInterface", "getLogs", java.util.List.class);
	}
	public void enablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "enablePlugin", void.class, arg0);
	}
	public void removeObject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeObject", void.class, arg0, arg1);
	}
	public void setReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setReference", void.class, arg0, arg1, arg2, arg3, arg4);
	}
	public void addReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addReference", void.class, arg0, arg1, arg2, arg3, arg4);
	}
	public java.lang.Boolean login(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "login", java.lang.Boolean.class, arg0, arg1);
	}
	public java.lang.String ping(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "ping", java.lang.String.class, arg0);
	}
	public java.lang.Integer checkout(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkout", java.lang.Integer.class, arg0, arg1, arg2);
	}
	public java.lang.Integer checkoutLastRevision(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkoutLastRevision", java.lang.Integer.class, arg0, arg1, arg2);
	}
	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.Long> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByOids", java.lang.Integer.class, arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadByTypes(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.String> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByTypes", java.lang.Integer.class, arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.String> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByGuids", java.lang.Integer.class, arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadProjects(java.util.Set<java.lang.Long> arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadProjects", java.lang.Integer.class, arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDownloadResult) reflector.callMethod("ServiceInterface", "getDownloadData", org.bimserver.interfaces.objects.SDownloadResult.class, arg0);
	}
	public org.bimserver.interfaces.objects.SLongActionState getDownloadState(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SLongActionState) reflector.callMethod("ServiceInterface", "getDownloadState", org.bimserver.interfaces.objects.SLongActionState.class, arg0);
	}
	public void changeUserType(java.lang.Long arg0, org.bimserver.interfaces.objects.SUserType arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "changeUserType", void.class, arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProjectAsSubProject", org.bimserver.interfaces.objects.SProject.class, arg0, arg1);
	}
	public void updateProject(org.bimserver.interfaces.objects.SProject arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateProject", void.class, arg0);
	}
	public void updateRevision(org.bimserver.interfaces.objects.SRevision arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateRevision", void.class, arg0);
	}
	public java.lang.Boolean addUserToProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "addUserToProject", java.lang.Boolean.class, arg0, arg1);
	}
	public java.lang.Boolean removeUserFromProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "removeUserFromProject", java.lang.Boolean.class, arg0, arg1);
	}
	public java.lang.Boolean deleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteProject", java.lang.Boolean.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllProjects", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllReadableProjects", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsOfProject", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProject", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsByUser", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsByUser", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfRevision", java.util.List.class, arg0);
	}
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "getProjectByPoid", org.bimserver.interfaces.objects.SProject.class, arg0);
	}
	public java.util.List<java.lang.String> getAvailableClasses() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClasses", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDatabaseInformation) reflector.callMethod("ServiceInterface", "getDatabaseInformation", org.bimserver.interfaces.objects.SDatabaseInformation.class);
	}
	public java.util.Date getLastDatabaseReset() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastDatabaseReset", java.util.Date.class);
	}
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getLoggedInUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public java.lang.Boolean changePassword(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "changePassword", java.lang.Boolean.class, arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUserName", org.bimserver.interfaces.objects.SUser.class, arg0);
	}
	public java.lang.Boolean undeleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteProject", java.lang.Boolean.class, arg0);
	}
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRevisionSummary) reflector.callMethod("ServiceInterface", "getRevisionSummary", org.bimserver.interfaces.objects.SRevisionSummary.class, arg0);
	}
	public java.lang.Boolean userHasCheckinRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasCheckinRights", java.lang.Boolean.class, arg0);
	}
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("ServiceInterface", "getCheckoutWarnings", java.util.Set.class, arg0);
	}
	public java.lang.Boolean userHasRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasRights", java.lang.Boolean.class, arg0);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByOid", org.bimserver.interfaces.objects.SDataObject.class, arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByGuid", org.bimserver.interfaces.objects.SDataObject.class, arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjectsByType", java.util.List.class, arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjects(long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjects", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidClash> findClashesByGuid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidClash>) reflector.callMethod("ServiceInterface", "findClashesByGuid", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SEidClash> findClashesByEid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SEidClash>) reflector.callMethod("ServiceInterface", "findClashesByEid", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SClash> getLastClashes(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SClash>) reflector.callMethod("ServiceInterface", "getLastClashes", java.util.List.class, arg0);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToNewProject(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToNewProject", org.bimserver.interfaces.objects.SCheckinResult.class, arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToExistingProject(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToExistingProject", org.bimserver.interfaces.objects.SCheckinResult.class, arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SClashDetectionSettings) reflector.callMethod("ServiceInterface", "getClashDetectionSettings", org.bimserver.interfaces.objects.SClashDetectionSettings.class, arg0);
	}
	public void updateClashDetectionSettings(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateClashDetectionSettings", void.class, arg0);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUoid", org.bimserver.interfaces.objects.SUser.class, arg0);
	}
	public org.bimserver.interfaces.objects.SUser getAnonymousUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getAnonymousUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getUsersProjects", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getProjectsByName", java.util.List.class, arg0);
	}
	public void setRevisionTag(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setRevisionTag", void.class, arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getSubProjects", java.util.List.class, arg0);
	}
	public void setExportTypeEnabled(java.lang.String arg0, java.lang.Boolean arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setExportTypeEnabled", void.class, arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SUser getCurrentUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getCurrentUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public void loginAnonymous() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "loginAnonymous", void.class);
	}
	public java.util.Date getActiveSince() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getActiveSince", java.util.Date.class);
	}
	public java.util.Date getLastActive() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastActive", java.util.Date.class);
	}
	public org.bimserver.shared.Token getCurrentToken() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.shared.Token) reflector.callMethod("ServiceInterface", "getCurrentToken", org.bimserver.shared.Token.class);
	}
	public void requestPasswordChange(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "requestPasswordChange", void.class, arg0);
	}
	public void validateAccount(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "validateAccount", void.class, arg0, arg1, arg2);
	}
	public void sendClashesEmail(org.bimserver.interfaces.objects.SClashDetectionSettings arg0, java.lang.Long arg1, java.util.Set<java.lang.String> arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "sendClashesEmail", void.class, arg0, arg1, arg2);
	}
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType arg0, org.bimserver.interfaces.objects.SCompareIdentifier arg1, java.lang.Long arg2, java.lang.Long arg3, java.lang.Long arg4, java.lang.String arg5) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "sendCompareEmail", void.class, arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.String getSettingCustomLogoAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingCustomLogoAddress", java.lang.String.class);
	}
	public java.lang.String getSettingHeaderAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingHeaderAddition", java.lang.String.class);
	}
	public java.lang.String getSettingFooterAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingFooterAddition", java.lang.String.class);
	}
	public void setSettingCustomLogoAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCustomLogoAddress", void.class, arg0);
	}
	public void setSettingHeaderAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingHeaderAddition", void.class, arg0);
	}
	public void setSettingFooterAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingFooterAddition", void.class, arg0);
	}
	public void setSettingMergeIdentifier(org.bimserver.interfaces.objects.SMergeIdentifier arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingMergeIdentifier", void.class, arg0);
	}
	public java.lang.String getSettingEmailSenderAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEmailSenderAddress", java.lang.String.class);
	}
	public void setSettingEmailSenderAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingEmailSenderAddress", void.class, arg0);
	}
	public java.lang.String getSettingEnabledExportTypes() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEnabledExportTypes", java.lang.String.class);
	}
	public void setSettingEnabledExportTypes(java.util.Set<java.lang.String> arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingEnabledExportTypes", void.class, arg0);
	}
	public java.lang.String getSettingSiteAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSiteAddress", java.lang.String.class);
	}
	public void setSettingSiteAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSiteAddress", void.class, arg0);
	}
	public java.lang.String getSettingSmtpServer() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSmtpServer", java.lang.String.class);
	}
	public void setSettingSmtpServer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSmtpServer", void.class, arg0);
	}
	public java.lang.Boolean isSettingAutoTestClashes() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAutoTestClashes", java.lang.Boolean.class);
	}
	public void setSettingAutoTestClashes(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAutoTestClashes", void.class, arg0);
	}
	public java.lang.Boolean isSettingIntelligentMerging() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingIntelligentMerging", java.lang.Boolean.class);
	}
	public void setSettingIntelligentMerging(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingIntelligentMerging", void.class, arg0);
	}
	public java.lang.Boolean isSettingCacheOutputFiles() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCacheOutputFiles", java.lang.Boolean.class);
	}
	public void setSettingCacheOutputFiles(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCacheOutputFiles", void.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUserSession>) reflector.callMethod("ServiceInterface", "getActiveUserSessions", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SLongAction> getActiveLongActions() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SLongAction>) reflector.callMethod("ServiceInterface", "getActiveLongActions", java.util.List.class);
	}
	public void migrateDatabase() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "migrateDatabase", void.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getAllSerializers", java.util.List.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getEnabledSerializers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getEnabledSerializers", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getEnabledDeserializers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getEnabledDeserializers", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerById", org.bimserver.interfaces.objects.SSerializer.class, arg0);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerById", org.bimserver.interfaces.objects.SDeserializer.class, arg0);
	}
	public void addSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addSerializer", void.class, arg0);
	}
	public void addDeserializer(org.bimserver.interfaces.objects.SDeserializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addDeserializer", void.class, arg0);
	}
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateSerializer", void.class, arg0);
	}
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateDeserializer", void.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider> getAllGuidanceProviders() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider>) reflector.callMethod("ServiceInterface", "getAllGuidanceProviders", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("ServiceInterface", "getGuidanceProviderById", org.bimserver.interfaces.objects.SGuidanceProvider.class, arg0);
	}
	public void addGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addGuidanceProvider", void.class, arg0);
	}
	public void updateGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateGuidanceProvider", void.class, arg0);
	}
	public void deleteGuidanceProvider(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteGuidanceProvider", void.class, arg0);
	}
	public void deleteSerializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteSerializer", void.class, arg0);
	}
	public void deleteDeserializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteDeserializer", void.class, arg0);
	}
	public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SMergeIdentifier) reflector.callMethod("ServiceInterface", "getSettingMergeIdentifier", org.bimserver.interfaces.objects.SMergeIdentifier.class);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByName", org.bimserver.interfaces.objects.SSerializer.class, arg0);
	}
	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("ServiceInterface", "getGuidanceProviderByName", org.bimserver.interfaces.objects.SGuidanceProvider.class, arg0);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerByName", org.bimserver.interfaces.objects.SDeserializer.class, arg0);
	}
	public java.lang.Boolean hasActiveSerializer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "hasActiveSerializer", java.lang.Boolean.class, arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllPlugins", java.util.List.class);
	}
	public void disablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "disablePlugin", void.class, arg0);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByContentType", org.bimserver.interfaces.objects.SSerializer.class, arg0);
	}
	public void startTransaction(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "startTransaction", void.class, arg0);
	}
	public java.lang.Long commitTransaction() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "commitTransaction", java.lang.Long.class);
	}
	public void abortTransaction() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "abortTransaction", void.class);
	}
	public void setStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setStringAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void setFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setFloatAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void setEnumAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setEnumAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void setIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setIntegerAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void setBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setBooleanAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void unsetAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "unsetAttribute", void.class, arg0, arg1, arg2);
	}
	public void unsetReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "unsetReference", void.class, arg0, arg1, arg2);
	}
	public void addStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addStringAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void addFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addFloatAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void addIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addIntegerAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void addBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addBooleanAttribute", void.class, arg0, arg1, arg2, arg3);
	}
	public void removeReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeReference", void.class, arg0, arg1, arg2, arg3);
	}
	public java.util.Date getServerStartTime() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getServerStartTime", java.util.Date.class);
	}
}
