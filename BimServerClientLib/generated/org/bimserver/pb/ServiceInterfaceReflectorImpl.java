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
		return (org.bimserver.interfaces.objects.SCompareResult) reflector.callMethod("ServiceInterface", "compare", arg0, arg1, arg2, arg3);
	}
	public org.bimserver.interfaces.objects.SCompileResult compile(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCompileResult) reflector.callMethod("ServiceInterface", "compile", arg0);
	}
	public void setup(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setup", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.Long createObject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "createObject", arg0);
	}
	public java.util.Set<org.bimserver.interfaces.objects.SMigration> getMigrations() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Set<org.bimserver.interfaces.objects.SMigration>) reflector.callMethod("ServiceInterface", "getMigrations");
	}
	public java.lang.Integer checkoutLastRevision(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkoutLastRevision", arg0, arg1, arg2);
	}
	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.Long> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByOids", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadOfType(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadOfType", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.String> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByGuids", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadProjects(java.util.Set<java.lang.Long> arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadProjects", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDownloadResult) reflector.callMethod("ServiceInterface", "getDownloadData", arg0);
	}
	public org.bimserver.interfaces.objects.SLongActionState getDownloadState(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SLongActionState) reflector.callMethod("ServiceInterface", "getDownloadState", arg0);
	}
	public void changeUserType(java.lang.Long arg0, org.bimserver.interfaces.objects.SUserType arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "changeUserType", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProjectAsSubProject", arg0, arg1);
	}
	public void updateProject(org.bimserver.interfaces.objects.SProject arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateProject", arg0);
	}
	public void updateRevision(org.bimserver.interfaces.objects.SRevision arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateRevision", arg0);
	}
	public java.lang.Boolean addUserToProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "addUserToProject", arg0, arg1);
	}
	public java.lang.Boolean removeUserFromProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "removeUserFromProject", arg0, arg1);
	}
	public java.lang.Boolean deleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllProjects");
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllReadableProjects");
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsByUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsByUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfRevision", arg0);
	}
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "getProjectByPoid", arg0);
	}
	public java.util.List<java.lang.String> getAvailableClasses() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClasses");
	}
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDatabaseInformation) reflector.callMethod("ServiceInterface", "getDatabaseInformation");
	}
	public java.util.Date getLastDatabaseReset() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastDatabaseReset");
	}
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getLoggedInUser");
	}
	public java.lang.Boolean changePassword(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "changePassword", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUserName", arg0);
	}
	public java.lang.Boolean undeleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteProject", arg0);
	}
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRevisionSummary) reflector.callMethod("ServiceInterface", "getRevisionSummary", arg0);
	}
	public java.lang.Boolean userHasCheckinRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasCheckinRights", arg0);
	}
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("ServiceInterface", "getCheckoutWarnings", arg0);
	}
	public java.lang.Boolean userHasRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasRights", arg0);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByOid", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByGuid", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjectsByType", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidClash> findClashesByGuid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidClash>) reflector.callMethod("ServiceInterface", "findClashesByGuid", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SEidClash> findClashesByEid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SEidClash>) reflector.callMethod("ServiceInterface", "findClashesByEid", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SClash> getLastClashes(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SClash>) reflector.callMethod("ServiceInterface", "getLastClashes", arg0);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToNewProject(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToNewProject", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToExistingProject(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToExistingProject", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SClashDetectionSettings) reflector.callMethod("ServiceInterface", "getClashDetectionSettings", arg0);
	}
	public void updateClashDetectionSettings(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateClashDetectionSettings", arg0);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUoid", arg0);
	}
	public org.bimserver.interfaces.objects.SUser getAnonymousUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getAnonymousUser");
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getUsersProjects", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getProjectsByName", arg0);
	}
	public void setRevisionTag(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setRevisionTag", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getSubProjects", arg0);
	}
	public void setExportTypeEnabled(java.lang.String arg0, java.lang.Boolean arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setExportTypeEnabled", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SUser getCurrentUser() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getCurrentUser");
	}
	public void loginAnonymous() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "loginAnonymous");
	}
	public java.util.Date getActiveSince() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getActiveSince");
	}
	public java.util.Date getLastActive() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastActive");
	}
	public org.bimserver.shared.Token getCurrentToken() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.shared.Token) reflector.callMethod("ServiceInterface", "getCurrentToken");
	}
	public void requestPasswordChange(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "requestPasswordChange", arg0);
	}
	public void validateAccount(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "validateAccount", arg0, arg1, arg2);
	}
	public void sendClashesEmail(org.bimserver.interfaces.objects.SClashDetectionSettings arg0, java.lang.Long arg1, java.util.Set<java.lang.String> arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "sendClashesEmail", arg0, arg1, arg2);
	}
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType arg0, org.bimserver.interfaces.objects.SCompareIdentifier arg1, java.lang.Long arg2, java.lang.Long arg3, java.lang.Long arg4, java.lang.String arg5) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "sendCompareEmail", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.String getSettingCustomLogoAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingCustomLogoAddress");
	}
	public java.lang.String getSettingHeaderAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingHeaderAddition");
	}
	public java.lang.String getSettingFooterAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingFooterAddition");
	}
	public void setSettingCustomLogoAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCustomLogoAddress", arg0);
	}
	public void setSettingHeaderAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingHeaderAddition", arg0);
	}
	public void setSettingFooterAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingFooterAddition", arg0);
	}
	public void setSettingMergeIdentifier(org.bimserver.interfaces.objects.SMergeIdentifier arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingMergeIdentifier", arg0);
	}
	public java.lang.String getSettingEmailSenderAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEmailSenderAddress");
	}
	public void setSettingEmailSenderAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingEmailSenderAddress", arg0);
	}
	public java.lang.String getSettingEnabledExportTypes() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEnabledExportTypes");
	}
	public void setSettingEnabledExportTypes(java.util.Set<java.lang.String> arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingEnabledExportTypes", arg0);
	}
	public java.lang.String getSettingSiteAddress() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSiteAddress");
	}
	public void setSettingSiteAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSiteAddress", arg0);
	}
	public java.lang.String getSettingSmtpServer() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSmtpServer");
	}
	public void setSettingSmtpServer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSmtpServer", arg0);
	}
	public java.lang.Boolean isSettingAutoTestClashes() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAutoTestClashes");
	}
	public void setSettingAutoTestClashes(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAutoTestClashes", arg0);
	}
	public java.lang.Boolean isSettingIntelligentMerging() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingIntelligentMerging");
	}
	public void setSettingIntelligentMerging(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingIntelligentMerging", arg0);
	}
	public java.lang.Boolean isSettingCacheOutputFiles() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCacheOutputFiles");
	}
	public void setSettingCacheOutputFiles(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCacheOutputFiles", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUserSession>) reflector.callMethod("ServiceInterface", "getActiveUserSessions");
	}
	public java.util.List<org.bimserver.interfaces.objects.SLongAction> getActiveLongActions() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SLongAction>) reflector.callMethod("ServiceInterface", "getActiveLongActions");
	}
	public void migrateDatabase() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "migrateDatabase");
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getAllSerializers", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getEnabledSerializers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getEnabledSerializers");
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getEnabledDeserializers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getEnabledDeserializers");
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerById", arg0);
	}
	public void addSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addSerializer", arg0);
	}
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateSerializer", arg0);
	}
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateDeserializer", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider> getAllGuidanceProviders() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider>) reflector.callMethod("ServiceInterface", "getAllGuidanceProviders");
	}
	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("ServiceInterface", "getGuidanceProviderById", arg0);
	}
	public void addGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addGuidanceProvider", arg0);
	}
	public void updateGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateGuidanceProvider", arg0);
	}
	public void deleteGuidanceProvider(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteGuidanceProvider", arg0);
	}
	public void deleteSerializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteSerializer", arg0);
	}
	public void deleteDeserializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "deleteDeserializer", arg0);
	}
	public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SMergeIdentifier) reflector.callMethod("ServiceInterface", "getSettingMergeIdentifier");
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByName", arg0);
	}
	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("ServiceInterface", "getGuidanceProviderByName", arg0);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerByName", arg0);
	}
	public java.lang.Boolean hasActiveSerializer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "hasActiveSerializer", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllPlugins");
	}
	public void disablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "disablePlugin", arg0);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByContentType", arg0);
	}
	public void startTransaction(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "startTransaction", arg0);
	}
	public java.lang.Long commitTransaction() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "commitTransaction");
	}
	public void abortTransaction() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "abortTransaction");
	}
	public void setStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setStringAttribute", arg0, arg1, arg2, arg3);
	}
	public void setFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setFloatAttribute", arg0, arg1, arg2, arg3);
	}
	public void setEnumAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setEnumAttribute", arg0, arg1, arg2, arg3);
	}
	public void setIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setIntegerAttribute", arg0, arg1, arg2, arg3);
	}
	public void setBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setBooleanAttribute", arg0, arg1, arg2, arg3);
	}
	public void unsetAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "unsetAttribute", arg0, arg1, arg2);
	}
	public void unsetReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "unsetReference", arg0, arg1, arg2);
	}
	public void addStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addStringAttribute", arg0, arg1, arg2, arg3);
	}
	public void addFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addFloatAttribute", arg0, arg1, arg2, arg3);
	}
	public void addIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addIntegerAttribute", arg0, arg1, arg2, arg3);
	}
	public void addBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addBooleanAttribute", arg0, arg1, arg2, arg3);
	}
	public void removeReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeReference", arg0, arg1, arg2, arg3);
	}
	public java.util.Date getServerStartTime() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getServerStartTime");
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getAllDeserializers", arg0);
	}
	public void registerNewRevisionListener() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "registerNewRevisionListener");
	}
	public void setHttpCallback(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setHttpCallback", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SRunResult compileAndRun(long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRunResult) reflector.callMethod("ServiceInterface", "compileAndRun", arg0, arg1);
	}
	public java.lang.Integer compileAndDownload(long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "compileAndDownload", arg0, arg1);
	}
	public java.lang.String getProtocolBuffersFile() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getProtocolBuffersFile");
	}
	public java.lang.String ping(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "ping", arg0);
	}
	public java.lang.Boolean login(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "login", arg0, arg1);
	}
	public java.lang.Integer download(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "download", arg0, arg1, arg2);
	}
	public java.lang.Long addUser(java.lang.String arg0, java.lang.String arg1, org.bimserver.interfaces.objects.SUserType arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "addUser", arg0, arg1, arg2, arg3);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinSync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "checkinSync", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.Boolean autologin(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "autologin", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinAsync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "checkinAsync", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllUsers");
	}
	public java.lang.Boolean deleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteUser", arg0);
	}
	public void logout() throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "logout");
	}
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("ServiceInterface", "getRevision", arg0);
	}
	public java.lang.Boolean undeleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteUser", arg0);
	}
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("ServiceInterface", "getGeoTag", arg0);
	}
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "updateGeoTag", arg0);
	}
	public java.lang.Boolean isLoggedIn() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isLoggedIn");
	}
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SLogAction>) reflector.callMethod("ServiceInterface", "getLogs");
	}
	public void enablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "enablePlugin", arg0);
	}
	public void removeObject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeObject", arg0, arg1);
	}
	public void setReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setReference", arg0, arg1, arg2, arg3, arg4);
	}
	public void addReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "addReference", arg0, arg1, arg2, arg3, arg4);
	}
	public void removeAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "removeAttribute", arg0, arg1, arg2, arg3);
	}
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingSendConfirmationEmailAfterRegistration");
	}
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingSendConfirmationEmailAfterRegistration", arg0);
	}
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("ServiceInterface", "getAccessMethod");
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedProjectsOfUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedUsersOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllAuthorizedUsersOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProjectAndSubProjects", arg0);
	}
	public java.lang.String getSettingRegistrationAddition() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingRegistrationAddition");
	}
	public void setSettingRegistrationAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingRegistrationAddition", arg0);
	}
	public java.lang.Boolean isSettingAllowSelfRegistration() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowSelfRegistration");
	}
	public void setSettingAllowSelfRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAllowSelfRegistration", arg0);
	}
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowUsersToCreateTopLevelProjects");
	}
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingAllowUsersToCreateTopLevelProjects", arg0);
	}
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCheckinMergingEnabled");
	}
	public void setSettingCheckinMergingEnabled(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingCheckinMergingEnabled", arg0);
	}
	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingShowVersionUpgradeAvailable");
	}
	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("ServiceInterface", "setSettingShowVersionUpgradeAvailable", arg0);
	}
	public java.util.Set<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Set<org.bimserver.interfaces.objects.SSerializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllSerializerPluginDescriptors");
	}
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServiceException {
		return (org.bimserver.interfaces.objects.SSerializerPluginDescriptor) reflector.callMethod("ServiceInterface", "getSerializerPluginDescriptor", arg0);
	}
	public java.util.Set<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws org.bimserver.shared.exceptions.ServiceException {
		return (java.util.Set<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllGuidanceProviderPluginDescriptors");
	}
	public java.lang.Integer checkout(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServiceException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkout", arg0, arg1, arg2);
	}
}
