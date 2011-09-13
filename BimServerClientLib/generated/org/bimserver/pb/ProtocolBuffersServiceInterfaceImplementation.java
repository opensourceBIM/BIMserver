package org.bimserver.pb;

import org.bimserver.client.Reflector;

@SuppressWarnings("unused")
public class ProtocolBuffersServiceInterfaceImplementation implements org.bimserver.shared.ServiceInterface {

private Reflector reflector;

public ProtocolBuffersServiceInterfaceImplementation(Reflector reflector) {this.reflector = reflector;}
public org.bimserver.shared.SCompareResult compare(
java.lang.Long arg0, java.lang.Long arg1, org.bimserver.shared.SCompareResult.SCompareType arg2, org.bimserver.shared.SCompareResult.SCompareIdentifier arg3) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SCompareResult) reflector.callMethod("compare", arg0, arg1, arg2, arg3);
}
public void setup(
java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.Boolean arg5) throws org.bimserver.shared.ServerException {
reflector.callMethod("setup", arg0, arg1, arg2, arg3, arg4, arg5);
}
public java.lang.Long createObject(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Long) reflector.callMethod("createObject", arg0);
}
public void removeAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("removeAttribute", arg0, arg1, arg2, arg3);
}
public java.util.Set getMigrations(
) throws org.bimserver.shared.ServerException {
return (java.util.Set) reflector.callMethod("getMigrations");
}
public java.util.List getAllNonAuthorizedProjectsOfUser(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllNonAuthorizedProjectsOfUser", arg0);
}
public java.util.List getAllNonAuthorizedUsersOfProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllNonAuthorizedUsersOfProject", arg0);
}
public java.util.List getAllAuthorizedUsersOfProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllAuthorizedUsersOfProject", arg0);
}
public java.util.List getAllCheckoutsOfProjectAndSubProjects(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllCheckoutsOfProjectAndSubProjects", arg0);
}
public java.lang.String getSettingRegistrationAddition(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingRegistrationAddition");
}
public void setSettingRegistrationAddition(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingRegistrationAddition", arg0);
}
public java.lang.Boolean isSettingAllowSelfRegistration(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingAllowSelfRegistration");
}
public void setSettingAllowSelfRegistration(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingAllowSelfRegistration", arg0);
}
public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingAllowUsersToCreateTopLevelProjects");
}
public void setSettingAllowUsersToCreateTopLevelProjects(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingAllowUsersToCreateTopLevelProjects", arg0);
}
public java.lang.Boolean isSettingCheckinMergingEnabled(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingCheckinMergingEnabled");
}
public void setSettingCheckinMergingEnabled(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingCheckinMergingEnabled", arg0);
}
public java.lang.Boolean isSettingShowVersionUpgradeAvailable(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingShowVersionUpgradeAvailable");
}
public void setSettingShowVersionUpgradeAvailable(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingShowVersionUpgradeAvailable", arg0);
}
public java.util.Set getAllSerializerPluginDescriptors(
) throws org.bimserver.shared.ServerException {
return (java.util.Set) reflector.callMethod("getAllSerializerPluginDescriptors");
}
public org.bimserver.shared.SSerializerPluginDescriptor getSerializerPluginDescriptor(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SSerializerPluginDescriptor) reflector.callMethod("getSerializerPluginDescriptor", arg0);
}
public java.util.Set getAllGuidanceProviderPluginDescriptors(
) throws org.bimserver.shared.ServerException {
return (java.util.Set) reflector.callMethod("getAllGuidanceProviderPluginDescriptors");
}
public java.lang.Integer checkout(
java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("checkout", arg0, arg1, arg2);
}
public java.lang.Boolean autologin(
java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("autologin", arg0, arg1);
}
public java.lang.String ping(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("ping", arg0);
}
public java.lang.Integer download(
java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("download", arg0, arg1, arg2);
}
public org.bimserver.shared.SCheckinResult checkinAsync(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SCheckinResult) reflector.callMethod("checkinAsync", arg0, arg1, arg2, arg3, arg4, arg5);
}
public java.lang.Boolean login(
java.lang.String arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("login", arg0, arg1);
}
public org.bimserver.shared.SCheckinResult checkinSync(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, javax.activation.DataHandler arg4, java.lang.Boolean arg5) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SCheckinResult) reflector.callMethod("checkinSync", arg0, arg1, arg2, arg3, arg4, arg5);
}
public java.lang.Long addUser(
java.lang.String arg0, java.lang.String arg1, org.bimserver.interfaces.objects.SUserType arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
return (java.lang.Long) reflector.callMethod("addUser", arg0, arg1, arg2, arg3);
}
public org.bimserver.interfaces.objects.SProject addProject(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("addProject", arg0);
}
public java.util.List getAllUsers(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllUsers");
}
public java.lang.Boolean deleteUser(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("deleteUser", arg0);
}
public void logout(
) throws org.bimserver.shared.ServerException {
reflector.callMethod("logout");
}
public org.bimserver.interfaces.objects.SRevision getRevision(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("getRevision", arg0);
}
public java.lang.Boolean undeleteUser(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("undeleteUser", arg0);
}
public org.bimserver.interfaces.objects.SGeoTag getGeoTag(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("getGeoTag", arg0);
}
public void updateGeoTag(
org.bimserver.interfaces.objects.SGeoTag arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateGeoTag", arg0);
}
public java.lang.Boolean isLoggedIn(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isLoggedIn");
}
public void enablePlugin(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("enablePlugin", arg0);
}
public java.util.List getLogs(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getLogs");
}
public void setReference(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.ServerException {
reflector.callMethod("setReference", arg0, arg1, arg2, arg3, arg4);
}
public void removeObject(
java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.ServerException {
reflector.callMethod("removeObject", arg0, arg1);
}
public void addReference(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Long arg3, java.lang.String arg4) throws org.bimserver.shared.ServerException {
reflector.callMethod("addReference", arg0, arg1, arg2, arg3, arg4);
}
public java.lang.Integer checkoutLastRevision(
java.lang.Long arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("checkoutLastRevision", arg0, arg1, arg2);
}
public java.lang.Integer downloadByOids(
java.util.Set arg0, java.util.Set arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("downloadByOids", arg0, arg1, arg2, arg3);
}
public java.lang.Integer downloadOfType(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("downloadOfType", arg0, arg1, arg2, arg3);
}
public java.lang.Integer downloadByGuids(
java.util.Set arg0, java.util.Set arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("downloadByGuids", arg0, arg1, arg2, arg3);
}
public java.lang.Integer downloadProjects(
java.util.Set arg0, java.lang.String arg1, java.lang.Boolean arg2) throws org.bimserver.shared.ServerException {
return (java.lang.Integer) reflector.callMethod("downloadProjects", arg0, arg1, arg2);
}
public org.bimserver.shared.SDownloadResult getDownloadData(
java.lang.Integer arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SDownloadResult) reflector.callMethod("getDownloadData", arg0);
}
public org.bimserver.shared.LongActionState getDownloadState(
java.lang.Integer arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.LongActionState) reflector.callMethod("getDownloadState", arg0);
}
public void changeUserType(
java.lang.Long arg0, org.bimserver.interfaces.objects.SUserType arg1) throws org.bimserver.shared.ServerException {
reflector.callMethod("changeUserType", arg0, arg1);
}
public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(
java.lang.String arg0, java.lang.Long arg1) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("addProjectAsSubProject", arg0, arg1);
}
public void updateProject(
org.bimserver.interfaces.objects.SProject arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateProject", arg0);
}
public void updateRevision(
org.bimserver.interfaces.objects.SRevision arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateRevision", arg0);
}
public java.lang.Boolean addUserToProject(
java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("addUserToProject", arg0, arg1);
}
public java.lang.Boolean removeUserFromProject(
java.lang.Long arg0, java.lang.Long arg1) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("removeUserFromProject", arg0, arg1);
}
public java.lang.Boolean deleteProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("deleteProject", arg0);
}
public java.util.List getAllProjects(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllProjects");
}
public java.util.List getAllReadableProjects(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllReadableProjects");
}
public java.util.List getAllRevisionsOfProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllRevisionsOfProject", arg0);
}
public java.util.List getAllCheckoutsOfProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllCheckoutsOfProject", arg0);
}
public java.util.List getAllRevisionsByUser(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllRevisionsByUser", arg0);
}
public java.util.List getAllCheckoutsByUser(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllCheckoutsByUser", arg0);
}
public java.util.List getAllCheckoutsOfRevision(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllCheckoutsOfRevision", arg0);
}
public org.bimserver.interfaces.objects.SProject getProjectByPoid(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("getProjectByPoid", arg0);
}
public java.util.List getAvailableClasses(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAvailableClasses");
}
public org.bimserver.shared.DatabaseInformation getDatabaseInformation(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.DatabaseInformation) reflector.callMethod("getDatabaseInformation");
}
public java.util.Date getLastDatabaseReset(
) throws org.bimserver.shared.ServerException {
return (java.util.Date) reflector.callMethod("getLastDatabaseReset");
}
public org.bimserver.interfaces.objects.SUser getLoggedInUser(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getLoggedInUser");
}
public java.lang.Boolean changePassword(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("changePassword", arg0, arg1, arg2);
}
public org.bimserver.interfaces.objects.SUser getUserByUserName(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getUserByUserName", arg0);
}
public java.lang.Boolean undeleteProject(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("undeleteProject", arg0);
}
public org.bimserver.shared.SRevisionSummary getRevisionSummary(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SRevisionSummary) reflector.callMethod("getRevisionSummary", arg0);
}
public java.lang.Boolean userHasCheckinRights(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("userHasCheckinRights", arg0);
}
public java.util.Set getCheckoutWarnings(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.Set) reflector.callMethod("getCheckoutWarnings", arg0);
}
public java.lang.Boolean userHasRights(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("userHasRights", arg0);
}
public org.bimserver.shared.SDataObject getDataObjectByOid(
java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SDataObject) reflector.callMethod("getDataObjectByOid", arg0, arg1, arg2);
}
public org.bimserver.shared.SDataObject getDataObjectByGuid(
java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SDataObject) reflector.callMethod("getDataObjectByGuid", arg0, arg1);
}
public java.util.List getDataObjectsByType(
java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getDataObjectsByType", arg0, arg1);
}
public java.util.List findClashesByGuid(
org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("findClashesByGuid", arg0);
}
public java.util.List findClashesByEid(
org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("findClashesByEid", arg0);
}
public java.util.List getLastClashes(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getLastClashes", arg0);
}
public org.bimserver.shared.SCheckinResult branchToNewProject(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SCheckinResult) reflector.callMethod("branchToNewProject", arg0, arg1, arg2);
}
public org.bimserver.shared.SCheckinResult branchToExistingProject(
java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.SCheckinResult) reflector.callMethod("branchToExistingProject", arg0, arg1, arg2);
}
public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SClashDetectionSettings) reflector.callMethod("getClashDetectionSettings", arg0);
}
public void updateClashDetectionSettings(
org.bimserver.interfaces.objects.SClashDetectionSettings arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateClashDetectionSettings", arg0);
}
public org.bimserver.interfaces.objects.SUser getUserByUoid(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getUserByUoid", arg0);
}
public org.bimserver.interfaces.objects.SUser getAnonymousUser(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getAnonymousUser");
}
public java.util.List getUsersProjects(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getUsersProjects", arg0);
}
public java.util.List getProjectsByName(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getProjectsByName", arg0);
}
public void setRevisionTag(
java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
reflector.callMethod("setRevisionTag", arg0, arg1);
}
public java.util.List getSubProjects(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getSubProjects", arg0);
}
public void setExportTypeEnabled(
java.lang.String arg0, java.lang.Boolean arg1) throws org.bimserver.shared.ServerException {
reflector.callMethod("setExportTypeEnabled", arg0, arg1);
}
public org.bimserver.interfaces.objects.SUser getCurrentUser(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("getCurrentUser");
}
public void loginAnonymous(
) throws org.bimserver.shared.ServerException {
reflector.callMethod("loginAnonymous");
}
public java.util.Date getActiveSince(
) throws org.bimserver.shared.ServerException {
return (java.util.Date) reflector.callMethod("getActiveSince");
}
public java.util.Date getLastActive(
) throws org.bimserver.shared.ServerException {
return (java.util.Date) reflector.callMethod("getLastActive");
}
public org.bimserver.shared.Token getCurrentToken(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.shared.Token) reflector.callMethod("getCurrentToken");
}
public void requestPasswordChange(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("requestPasswordChange", arg0);
}
public void validateAccount(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
reflector.callMethod("validateAccount", arg0, arg1, arg2);
}
public void sendClashesEmail(
org.bimserver.interfaces.objects.SClashDetectionSettings arg0, java.lang.Long arg1, java.util.Set arg2) throws org.bimserver.shared.ServerException {
reflector.callMethod("sendClashesEmail", arg0, arg1, arg2);
}
public void sendCompareEmail(
org.bimserver.shared.SCompareResult.SCompareType arg0, org.bimserver.shared.SCompareResult.SCompareIdentifier arg1, java.lang.Long arg2, java.lang.Long arg3, java.lang.Long arg4, java.lang.String arg5) throws org.bimserver.shared.ServerException {
reflector.callMethod("sendCompareEmail", arg0, arg1, arg2, arg3, arg4, arg5);
}
public java.lang.String getSettingCustomLogoAddress(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingCustomLogoAddress");
}
public java.lang.String getSettingHeaderAddition(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingHeaderAddition");
}
public java.lang.String getSettingFooterAddition(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingFooterAddition");
}
public void setSettingCustomLogoAddress(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingCustomLogoAddress", arg0);
}
public void setSettingHeaderAddition(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingHeaderAddition", arg0);
}
public void setSettingFooterAddition(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingFooterAddition", arg0);
}
public void setSettingMergeIdentifier(
org.bimserver.interfaces.objects.SMergeIdentifier arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingMergeIdentifier", arg0);
}
public java.lang.String getSettingEmailSenderAddress(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingEmailSenderAddress");
}
public void setSettingEmailSenderAddress(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingEmailSenderAddress", arg0);
}
public java.lang.String getSettingEnabledExportTypes(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingEnabledExportTypes");
}
public void setSettingEnabledExportTypes(
java.util.Set arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingEnabledExportTypes", arg0);
}
public java.lang.String getSettingSiteAddress(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingSiteAddress");
}
public void setSettingSiteAddress(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingSiteAddress", arg0);
}
public java.lang.String getSettingSmtpServer(
) throws org.bimserver.shared.ServerException {
return (java.lang.String) reflector.callMethod("getSettingSmtpServer");
}
public void setSettingSmtpServer(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingSmtpServer", arg0);
}
public java.lang.Boolean isSettingAutoTestClashes(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingAutoTestClashes");
}
public void setSettingAutoTestClashes(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingAutoTestClashes", arg0);
}
public java.lang.Boolean isSettingIntelligentMerging(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingIntelligentMerging");
}
public void setSettingIntelligentMerging(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingIntelligentMerging", arg0);
}
public java.lang.Boolean isSettingCacheOutputFiles(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingCacheOutputFiles");
}
public void setSettingCacheOutputFiles(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingCacheOutputFiles", arg0);
}
public java.util.List getActiveUserSessions(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getActiveUserSessions");
}
public java.util.List getActiveLongActions(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getActiveLongActions");
}
public void migrateDatabase(
) throws org.bimserver.shared.ServerException {
reflector.callMethod("migrateDatabase");
}
public java.util.List getAllSerializers(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllSerializers", arg0);
}
public java.util.List getEnabledSerializers(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getEnabledSerializers");
}
public java.util.List getEnabledDeserializers(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getEnabledDeserializers");
}
public org.bimserver.interfaces.objects.SSerializer getSerializerById(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerById", arg0);
}
public void addSerializer(
org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("addSerializer", arg0);
}
public void updateSerializer(
org.bimserver.interfaces.objects.SSerializer arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateSerializer", arg0);
}
public void updateDeserializer(
org.bimserver.interfaces.objects.SDeserializer arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateDeserializer", arg0);
}
public java.util.List getAllGuidanceProviders(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllGuidanceProviders");
}
public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderById(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SGuidanceProvider) reflector.callMethod("getGuidanceProviderById", arg0);
}
public void addGuidanceProvider(
org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("addGuidanceProvider", arg0);
}
public void updateGuidanceProvider(
org.bimserver.interfaces.objects.SGuidanceProvider arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("updateGuidanceProvider", arg0);
}
public void deleteGuidanceProvider(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("deleteGuidanceProvider", arg0);
}
public void deleteSerializer(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("deleteSerializer", arg0);
}
public void deleteDeserializer(
java.lang.Long arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("deleteDeserializer", arg0);
}
public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SMergeIdentifier) reflector.callMethod("getSettingMergeIdentifier");
}
public org.bimserver.interfaces.objects.SSerializer getSerializerByName(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerByName", arg0);
}
public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("getDeserializerByName", arg0);
}
public java.lang.Boolean hasActiveSerializer(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("hasActiveSerializer", arg0);
}
public java.util.List getAllPlugins(
) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllPlugins");
}
public void disablePlugin(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("disablePlugin", arg0);
}
public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(
java.lang.String arg0) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("getSerializerByContentType", arg0);
}
public void startTransaction(
java.lang.Integer arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("startTransaction", arg0);
}
public java.lang.Long commitTransaction(
) throws org.bimserver.shared.ServerException {
return (java.lang.Long) reflector.callMethod("commitTransaction");
}
public void abortTransaction(
) throws org.bimserver.shared.ServerException {
reflector.callMethod("abortTransaction");
}
public void setStringAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("setStringAttribute", arg0, arg1, arg2, arg3);
}
public void setFloatAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("setFloatAttribute", arg0, arg1, arg2, arg3);
}
public void setEnumAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("setEnumAttribute", arg0, arg1, arg2, arg3);
}
public void setIntegerAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("setIntegerAttribute", arg0, arg1, arg2, arg3);
}
public void setBooleanAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("setBooleanAttribute", arg0, arg1, arg2, arg3);
}
public void unsetAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
reflector.callMethod("unsetAttribute", arg0, arg1, arg2);
}
public void unsetReference(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2) throws org.bimserver.shared.ServerException {
reflector.callMethod("unsetReference", arg0, arg1, arg2);
}
public void addStringAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("addStringAttribute", arg0, arg1, arg2, arg3);
}
public void addFloatAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Float arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("addFloatAttribute", arg0, arg1, arg2, arg3);
}
public void addIntegerAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("addIntegerAttribute", arg0, arg1, arg2, arg3);
}
public void addBooleanAttribute(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Boolean arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("addBooleanAttribute", arg0, arg1, arg2, arg3);
}
public void removeReference(
java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.Integer arg3) throws org.bimserver.shared.ServerException {
reflector.callMethod("removeReference", arg0, arg1, arg2, arg3);
}
public java.util.Date getServerStartTime(
) throws org.bimserver.shared.ServerException {
return (java.util.Date) reflector.callMethod("getServerStartTime");
}
public java.util.List getAllDeserializers(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
return (java.util.List) reflector.callMethod("getAllDeserializers", arg0);
}
public void registerNewRevisionListener(
) throws org.bimserver.shared.ServerException {
reflector.callMethod("registerNewRevisionListener");
}
public void setHttpCallback(
java.lang.Long arg0, java.lang.String arg1) throws org.bimserver.shared.ServerException {
reflector.callMethod("setHttpCallback", arg0, arg1);
}
public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod(
) throws org.bimserver.shared.ServerException {
return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("getAccessMethod");
}
public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration(
) throws org.bimserver.shared.ServerException {
return (java.lang.Boolean) reflector.callMethod("isSettingSendConfirmationEmailAfterRegistration");
}
public void setSettingSendConfirmationEmailAfterRegistration(
java.lang.Boolean arg0) throws org.bimserver.shared.ServerException {
reflector.callMethod("setSettingSendConfirmationEmailAfterRegistration", arg0);
}
}
