package org.bimserver.pb;

import org.bimserver.client.Reflector;

@SuppressWarnings("unchecked")
public class ProtocolBuffersServiceInterfaceImplementation implements org.bimserver.shared.ServiceInterface {

private Reflector reflector;

	public ProtocolBuffersServiceInterfaceImplementation(Reflector reflector) {this.reflector = reflector;}
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long arg0, java.lang.Long arg1, org.bimserver.interfaces.objects.SCompareType arg2, org.bimserver.interfaces.objects.SCompareIdentifier arg3) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCompareResult) reflector.callMethod("compare", arg0, arg1, arg2, arg3);
	}
	public void setup(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setup", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.Long createObject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("createObject", arg0);
	}
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingSendConfirmationEmailAfterRegistration");
	}
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingSendConfirmationEmailAfterRegistration", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getAllNonAuthorizedProjectsOfUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("getAllNonAuthorizedUsersOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("getAllAuthorizedUsersOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("getAllCheckoutsOfProjectAndSubProjects", arg0);
	}
	public java.lang.String getSettingRegistrationAddition() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingRegistrationAddition");
	}
	public void setSettingRegistrationAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingRegistrationAddition", arg0);
	}
	public java.lang.Boolean isSettingAllowSelfRegistration() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingAllowSelfRegistration");
	}
	public void setSettingAllowSelfRegistration(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingAllowSelfRegistration", arg0);
	}
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingAllowUsersToCreateTopLevelProjects");
	}
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingAllowUsersToCreateTopLevelProjects", arg0);
	}
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingCheckinMergingEnabled");
	}
	public void setSettingCheckinMergingEnabled(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingCheckinMergingEnabled", arg0);
	}
	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingShowVersionUpgradeAvailable");
	}
	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingShowVersionUpgradeAvailable", arg0);
	}
	public java.lang.Integer checkoutLastRevision(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("checkoutLastRevision", arg0, arg1, arg2);
	}
	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.Long> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("downloadByOids", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadOfType(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("downloadOfType", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> arg0, java.util.Set<java.lang.String> arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("downloadByGuids", arg0, arg1, arg2, arg3);
	}
	public java.lang.Integer downloadProjects(java.util.Set<java.lang.Long> arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("downloadProjects", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDownloadResult) reflector.callMethod("getDownloadData", arg0);
	}
	public org.bimserver.interfaces.objects.SLongActionState getDownloadState(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SLongActionState) reflector.callMethod("getDownloadState", arg0);
	}
	public void changeUserType(java.lang.Long arg0, org.bimserver.interfaces.objects.SUserType arg1) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("changeUserType", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("addProjectAsSubProject", arg0, arg1);
	}
	public void updateProject(org.bimserver.interfaces.objects.SProject arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateProject", arg0);
	}
	public void updateRevision(org.bimserver.interfaces.objects.SRevision arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateRevision", arg0);
	}
	public java.lang.Boolean addUserToProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("addUserToProject", arg0, arg1);
	}
	public java.lang.Boolean removeUserFromProject(java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("removeUserFromProject", arg0, arg1);
	}
	public java.lang.Boolean deleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("deleteProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getAllProjects");
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getAllReadableProjects");
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("getAllRevisionsOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("getAllCheckoutsOfProject", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("getAllRevisionsByUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("getAllCheckoutsByUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("getAllCheckoutsOfRevision", arg0);
	}
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("getProjectByPoid", arg0);
	}
	public java.util.List<java.lang.String> getAvailableClasses() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("getAvailableClasses");
	}
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDatabaseInformation) reflector.callMethod("getDatabaseInformation");
	}
	public java.util.Date getLastDatabaseReset() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("getLastDatabaseReset");
	}
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getLoggedInUser");
	}
	public java.lang.Boolean changePassword(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("changePassword", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getUserByUserName", arg0);
	}
	public java.lang.Boolean undeleteProject(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("undeleteProject", arg0);
	}
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevisionSummary) reflector.callMethod("getRevisionSummary", arg0);
	}
	public java.lang.Boolean userHasCheckinRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("userHasCheckinRights", arg0);
	}
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("getCheckoutWarnings", arg0);
	}
	public java.lang.Boolean userHasRights(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("userHasRights", arg0);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("getDataObjectByOid", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("getDataObjectByGuid", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("getDataObjectsByType", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidClash> findClashesByGuid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidClash>) reflector.callMethod("findClashesByGuid", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SEidClash> findClashesByEid(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SEidClash>) reflector.callMethod("findClashesByEid", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SClash> getLastClashes(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SClash>) reflector.callMethod("getLastClashes", arg0);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToNewProject(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("branchToNewProject", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToExistingProject(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("branchToExistingProject", arg0, arg1, arg2);
	}
	public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SClashDetectionSettings) reflector.callMethod("getClashDetectionSettings", arg0);
	}
	public void updateClashDetectionSettings(org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateClashDetectionSettings", arg0);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getUserByUoid", arg0);
	}
	public org.bimserver.interfaces.objects.SUser getAnonymousUser() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getAnonymousUser");
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getUsersProjects", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getProjectsByName", arg0);
	}
	public void setRevisionTag(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setRevisionTag", arg0, arg1);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("getSubProjects", arg0);
	}
	public void setExportTypeEnabled(java.lang.String arg0, java.lang.Boolean arg1) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setExportTypeEnabled", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SUser getCurrentUser() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getCurrentUser");
	}
	public void loginAnonymous() throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("loginAnonymous");
	}
	public java.util.Date getActiveSince() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("getActiveSince");
	}
	public java.util.Date getLastActive() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("getLastActive");
	}
	public org.bimserver.shared.Token getCurrentToken() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.shared.Token) reflector.callMethod("getCurrentToken");
	}
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("getAccessMethod");
	}
	public void requestPasswordChange(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("requestPasswordChange", arg0);
	}
	public void validateAccount(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("validateAccount", arg0, arg1, arg2);
	}
	public void sendClashesEmail(org.bimserver.interfaces.objects.SClashDetectionSettings arg0, java.lang.Long arg1, java.util.Set<java.lang.String> arg2) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("sendClashesEmail", arg0, arg1, arg2);
	}
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType arg0, org.bimserver.interfaces.objects.SCompareIdentifier arg1, java.lang.Long arg2, java.lang.Long arg3, java.lang.Long arg4, java.lang.String arg5) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("sendCompareEmail", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.String getSettingCustomLogoAddress() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingCustomLogoAddress");
	}
	public java.lang.String getSettingHeaderAddition() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingHeaderAddition");
	}
	public java.lang.String getSettingFooterAddition() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingFooterAddition");
	}
	public void setSettingCustomLogoAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingCustomLogoAddress", arg0);
	}
	public void setSettingHeaderAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingHeaderAddition", arg0);
	}
	public void setSettingFooterAddition(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingFooterAddition", arg0);
	}
	public void setSettingMergeIdentifier(org.bimserver.interfaces.objects.SMergeIdentifier arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingMergeIdentifier", arg0);
	}
	public java.lang.String getSettingEmailSenderAddress() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingEmailSenderAddress");
	}
	public void setSettingEmailSenderAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingEmailSenderAddress", arg0);
	}
	public java.lang.String getSettingEnabledExportTypes() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingEnabledExportTypes");
	}
	public void setSettingEnabledExportTypes(java.util.Set<java.lang.String> arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingEnabledExportTypes", arg0);
	}
	public java.lang.String getSettingSiteAddress() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingSiteAddress");
	}
	public void setSettingSiteAddress(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingSiteAddress", arg0);
	}
	public java.lang.String getSettingSmtpServer() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("getSettingSmtpServer");
	}
	public void setSettingSmtpServer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingSmtpServer", arg0);
	}
	public java.lang.Boolean isSettingAutoTestClashes() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingAutoTestClashes");
	}
	public void setSettingAutoTestClashes(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingAutoTestClashes", arg0);
	}
	public java.lang.Boolean isSettingIntelligentMerging() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingIntelligentMerging");
	}
	public void setSettingIntelligentMerging(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingIntelligentMerging", arg0);
	}
	public java.lang.Boolean isSettingCacheOutputFiles() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isSettingCacheOutputFiles");
	}
	public void setSettingCacheOutputFiles(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setSettingCacheOutputFiles", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUserSession>) reflector.callMethod("getActiveUserSessions");
	}
	public java.util.List<org.bimserver.interfaces.objects.SLongAction> getActiveLongActions() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLongAction>) reflector.callMethod("getActiveLongActions");
	}
	public java.util.Set<org.bimserver.interfaces.objects.SMigration> getMigrations() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<org.bimserver.interfaces.objects.SMigration>) reflector.callMethod("getMigrations");
	}
	public void migrateDatabase() throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("migrateDatabase");
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("getAllSerializers", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getEnabledSerializers() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("getEnabledSerializers");
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getEnabledDeserializers() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("getEnabledDeserializers");
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerById", arg0);
	}
	public void addSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addSerializer", arg0);
	}
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateSerializer", arg0);
	}
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateDeserializer", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider> getAllGuidanceProviders() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider>) reflector.callMethod("getAllGuidanceProviders");
	}
	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderById(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("getGuidanceProviderById", arg0);
	}
	public void addGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addGuidanceProvider", arg0);
	}
	public void updateGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateGuidanceProvider", arg0);
	}
	public void deleteGuidanceProvider(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("deleteGuidanceProvider", arg0);
	}
	public void deleteSerializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("deleteSerializer", arg0);
	}
	public void deleteDeserializer(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("deleteDeserializer", arg0);
	}
	public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier() throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SMergeIdentifier) reflector.callMethod("getSettingMergeIdentifier");
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerByName", arg0);
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("getDeserializerByName", arg0);
	}
	public java.lang.Boolean hasActiveSerializer(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("hasActiveSerializer", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor>) reflector.callMethod("getAllPlugins");
	}
	public void disablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("disablePlugin", arg0);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerByContentType", arg0);
	}
	public void startTransaction(java.lang.Integer arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("startTransaction", arg0);
	}
	public java.lang.Long commitTransaction() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("commitTransaction");
	}
	public void abortTransaction() throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("abortTransaction");
	}
	public void setStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setStringAttribute", arg0, arg1, arg2, arg3);
	}
	public void setFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setFloatAttribute", arg0, arg1, arg2, arg3);
	}
	public void setEnumAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setEnumAttribute", arg0, arg1, arg2, arg3);
	}
	public void setIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setIntegerAttribute", arg0, arg1, arg2, arg3);
	}
	public void setBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setBooleanAttribute", arg0, arg1, arg2, arg3);
	}
	public void unsetAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("unsetAttribute", arg0, arg1, arg2);
	}
	public void unsetReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("unsetReference", arg0, arg1, arg2);
	}
	public void addStringAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addStringAttribute", arg0, arg1, arg2, arg3);
	}
	public void addFloatAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addFloatAttribute", arg0, arg1, arg2, arg3);
	}
	public void addIntegerAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addIntegerAttribute", arg0, arg1, arg2, arg3);
	}
	public void addBooleanAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addBooleanAttribute", arg0, arg1, arg2, arg3);
	}
	public void removeAttribute(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("removeAttribute", arg0, arg1, arg2, arg3);
	}
	public void removeReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("removeReference", arg0, arg1, arg2, arg3);
	}
	public java.util.Date getServerStartTime() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("getServerStartTime");
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("getAllDeserializers", arg0);
	}
	public void registerNewRevisionListener() throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("registerNewRevisionListener");
	}
	public void setHttpCallback(java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setHttpCallback", arg0, arg1);
	}
	public java.util.Set<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<org.bimserver.interfaces.objects.SSerializerPluginDescriptor>) reflector.callMethod("getAllSerializerPluginDescriptors");
	}
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializerPluginDescriptor) reflector.callMethod("getSerializerPluginDescriptor", arg0);
	}
	public java.util.Set<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor>) reflector.callMethod("getAllGuidanceProviderPluginDescriptors");
	}
	public java.lang.String ping(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ping", arg0);
	}
	public java.lang.Boolean login(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("login", arg0, arg1);
	}
	public java.lang.Boolean autologin(java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("autologin", arg0, arg1);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinSync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("checkinSync", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public org.bimserver.interfaces.objects.SCheckinResult checkinAsync(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("checkinAsync", arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public java.lang.Integer checkout(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("checkout", arg0, arg1, arg2);
	}
	public java.lang.Integer download(java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("download", arg0, arg1, arg2);
	}
	public java.lang.Long addUser(java.lang.String arg0, java.lang.String arg1, org.bimserver.interfaces.objects.SUserType arg2, java.lang.Boolean arg3) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("addUser", arg0, arg1, arg2, arg3);
	}
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("addProject", arg0);
	}
	public java.lang.Boolean deleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("deleteUser", arg0);
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("getAllUsers");
	}
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("getRevision", arg0);
	}
	public void logout() throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("logout");
	}
	public java.lang.Boolean undeleteUser(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("undeleteUser", arg0);
	}
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long arg0) throws org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("getGeoTag", arg0);
	}
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("updateGeoTag", arg0);
	}
	public java.lang.Boolean isLoggedIn() throws org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("isLoggedIn");
	}
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLogAction>) reflector.callMethod("getLogs");
	}
	public void enablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("enablePlugin", arg0);
	}
	public void removeObject(java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("removeObject", arg0, arg1);
	}
	public void setReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("setReference", arg0, arg1, arg2, arg3, arg4);
	}
	public void addReference(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("addReference", arg0, arg1, arg2, arg3, arg4);
	}
}
