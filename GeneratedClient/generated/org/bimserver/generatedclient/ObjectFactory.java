
package org.bimserver.generatedclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bimserver.generatedclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SUser_QNAME = new QName("http://shared.bimserver.org/", "sUser");
    private final static QName _SGeoTag_QNAME = new QName("http://shared.bimserver.org/", "sGeoTag");
    private final static QName _SendClashesEmail_QNAME = new QName("http://shared.bimserver.org/", "sendClashesEmail");
    private final static QName _RemoveUserFromProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "removeUserFromProjectResponse");
    private final static QName _GetActiveSince_QNAME = new QName("http://shared.bimserver.org/", "getActiveSince");
    private final static QName _GetUserByUoidResponse_QNAME = new QName("http://shared.bimserver.org/", "getUserByUoidResponse");
    private final static QName _DownloadByOidsResponse_QNAME = new QName("http://shared.bimserver.org/", "downloadByOidsResponse");
    private final static QName _GetLogsResponse_QNAME = new QName("http://shared.bimserver.org/", "getLogsResponse");
    private final static QName _SetExportTypeEnabled_QNAME = new QName("http://shared.bimserver.org/", "setExportTypeEnabled");
    private final static QName _CheckoutResponse_QNAME = new QName("http://shared.bimserver.org/", "checkoutResponse");
    private final static QName _SDownloadResult_QNAME = new QName("http://shared.bimserver.org/", "sDownloadResult");
    private final static QName _AutologinResponse_QNAME = new QName("http://shared.bimserver.org/", "autologinResponse");
    private final static QName _GetProjectByPoid_QNAME = new QName("http://shared.bimserver.org/", "getProjectByPoid");
    private final static QName _IsLoggedInResponse_QNAME = new QName("http://shared.bimserver.org/", "isLoggedInResponse");
    private final static QName _GetCurrentToken_QNAME = new QName("http://shared.bimserver.org/", "getCurrentToken");
    private final static QName _GetLoggedInUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getLoggedInUserResponse");
    private final static QName _GetRevisionResponse_QNAME = new QName("http://shared.bimserver.org/", "getRevisionResponse");
    private final static QName _GetSubProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "getSubProjectsResponse");
    private final static QName _UpdateClashDetectionSettings_QNAME = new QName("http://shared.bimserver.org/", "updateClashDetectionSettings");
    private final static QName _GetActiveUserSessions_QNAME = new QName("http://shared.bimserver.org/", "getActiveUserSessions");
    private final static QName _GetLastClashes_QNAME = new QName("http://shared.bimserver.org/", "getLastClashes");
    private final static QName _GetShowCheckoutWarning_QNAME = new QName("http://shared.bimserver.org/", "getShowCheckoutWarning");
    private final static QName _BranchToNewProject_QNAME = new QName("http://shared.bimserver.org/", "branchToNewProject");
    private final static QName _GetDataObjectsByType_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectsByType");
    private final static QName _Autologin_QNAME = new QName("http://shared.bimserver.org/", "autologin");
    private final static QName _FindClashesByEid_QNAME = new QName("http://shared.bimserver.org/", "findClashesByEid");
    private final static QName _SetRevisionTag_QNAME = new QName("http://shared.bimserver.org/", "setRevisionTag");
    private final static QName _RequestPasswordChangeResponse_QNAME = new QName("http://shared.bimserver.org/", "requestPasswordChangeResponse");
    private final static QName _GetAllRevisionsByUser_QNAME = new QName("http://shared.bimserver.org/", "getAllRevisionsByUser");
    private final static QName _AddProjectAsSubProject_QNAME = new QName("http://shared.bimserver.org/", "addProjectAsSubProject");
    private final static QName _SClashDetectionSettings_QNAME = new QName("http://shared.bimserver.org/", "sClashDetectionSettings");
    private final static QName _GetAllNonAuthorizedUsersOfProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllNonAuthorizedUsersOfProjectResponse");
    private final static QName _GetAllRevisionsByUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllRevisionsByUserResponse");
    private final static QName _GetAllNonAuthorizedProjectsOfUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllNonAuthorizedProjectsOfUserResponse");
    private final static QName _GetDatabaseInformation_QNAME = new QName("http://shared.bimserver.org/", "getDatabaseInformation");
    private final static QName _SendCompareEmailResponse_QNAME = new QName("http://shared.bimserver.org/", "sendCompareEmailResponse");
    private final static QName _LoginAnonymous_QNAME = new QName("http://shared.bimserver.org/", "loginAnonymous");
    private final static QName _SendCompareEmail_QNAME = new QName("http://shared.bimserver.org/", "sendCompareEmail");
    private final static QName _GetAllNonAuthorizedProjectsOfUser_QNAME = new QName("http://shared.bimserver.org/", "getAllNonAuthorizedProjectsOfUser");
    private final static QName _AddProjectAsSubProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "addProjectAsSubProjectResponse");
    private final static QName _SendClashesEmailResponse_QNAME = new QName("http://shared.bimserver.org/", "sendClashesEmailResponse");
    private final static QName _UndeleteProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "undeleteProjectResponse");
    private final static QName _BranchToNewProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "branchToNewProjectResponse");
    private final static QName _UpdateProject_QNAME = new QName("http://shared.bimserver.org/", "updateProject");
    private final static QName _DeleteProject_QNAME = new QName("http://shared.bimserver.org/", "deleteProject");
    private final static QName _UndeleteUser_QNAME = new QName("http://shared.bimserver.org/", "undeleteUser");
    private final static QName _GetClashDetectionSettings_QNAME = new QName("http://shared.bimserver.org/", "getClashDetectionSettings");
    private final static QName _GetEnabledResultTypes_QNAME = new QName("http://shared.bimserver.org/", "getEnabledResultTypes");
    private final static QName _GetAnonymousUser_QNAME = new QName("http://shared.bimserver.org/", "getAnonymousUser");
    private final static QName _GetActiveUserSessionsResponse_QNAME = new QName("http://shared.bimserver.org/", "getActiveUserSessionsResponse");
    private final static QName _GetActiveSinceResponse_QNAME = new QName("http://shared.bimserver.org/", "getActiveSinceResponse");
    private final static QName _AddUserToProject_QNAME = new QName("http://shared.bimserver.org/", "addUserToProject");
    private final static QName _DownloadByOids_QNAME = new QName("http://shared.bimserver.org/", "downloadByOids");
    private final static QName _GetAvailableClassesResponse_QNAME = new QName("http://shared.bimserver.org/", "getAvailableClassesResponse");
    private final static QName _UpdateClashDetectionSettingsResponse_QNAME = new QName("http://shared.bimserver.org/", "updateClashDetectionSettingsResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://shared.bimserver.org/", "deleteUser");
    private final static QName _GetGeoTagResponse_QNAME = new QName("http://shared.bimserver.org/", "getGeoTagResponse");
    private final static QName _GetAllCheckoutsByUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsByUserResponse");
    private final static QName _GetLastClashesResponse_QNAME = new QName("http://shared.bimserver.org/", "getLastClashesResponse");
    private final static QName _UserHasRightsResponse_QNAME = new QName("http://shared.bimserver.org/", "userHasRightsResponse");
    private final static QName _CheckoutLastRevision_QNAME = new QName("http://shared.bimserver.org/", "checkoutLastRevision");
    private final static QName _GetUsersProjects_QNAME = new QName("http://shared.bimserver.org/", "getUsersProjects");
    private final static QName _Checkout_QNAME = new QName("http://shared.bimserver.org/", "checkout");
    private final static QName _GetAllCheckoutsOfProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfProjectResponse");
    private final static QName _GetLoggedInUser_QNAME = new QName("http://shared.bimserver.org/", "getLoggedInUser");
    private final static QName _GetLastActive_QNAME = new QName("http://shared.bimserver.org/", "getLastActive");
    private final static QName _BranchToExistingProject_QNAME = new QName("http://shared.bimserver.org/", "branchToExistingProject");
    private final static QName _GetLastActiveResponse_QNAME = new QName("http://shared.bimserver.org/", "getLastActiveResponse");
    private final static QName _FindClashesByGuidResponse_QNAME = new QName("http://shared.bimserver.org/", "findClashesByGuidResponse");
    private final static QName _GetClashDetectionSettingsResponse_QNAME = new QName("http://shared.bimserver.org/", "getClashDetectionSettingsResponse");
    private final static QName _GetProjectByPoidResponse_QNAME = new QName("http://shared.bimserver.org/", "getProjectByPoidResponse");
    private final static QName _GetSubProjects_QNAME = new QName("http://shared.bimserver.org/", "getSubProjects");
    private final static QName _SetExportTypeEnabledResponse_QNAME = new QName("http://shared.bimserver.org/", "setExportTypeEnabledResponse");
    private final static QName _DownloadProjects_QNAME = new QName("http://shared.bimserver.org/", "downloadProjects");
    private final static QName _GetRevisionSummary_QNAME = new QName("http://shared.bimserver.org/", "getRevisionSummary");
    private final static QName _GetDataObjectsByTypeResponse_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectsByTypeResponse");
    private final static QName _GetAllProjects_QNAME = new QName("http://shared.bimserver.org/", "getAllProjects");
    private final static QName _AddProject_QNAME = new QName("http://shared.bimserver.org/", "addProject");
    private final static QName _CheckinAsyncResponse_QNAME = new QName("http://shared.bimserver.org/", "checkinAsyncResponse");
    private final static QName _UserHasCheckinRights_QNAME = new QName("http://shared.bimserver.org/", "userHasCheckinRights");
    private final static QName _GetAllAuthorizedUsersOfProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllAuthorizedUsersOfProjectResponse");
    private final static QName _GetAnonymousUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getAnonymousUserResponse");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllUsersResponse");
    private final static QName _GetDatabaseInformationResponse_QNAME = new QName("http://shared.bimserver.org/", "getDatabaseInformationResponse");
    private final static QName _Login_QNAME = new QName("http://shared.bimserver.org/", "login");
    private final static QName _UpdateGeoTagResponse_QNAME = new QName("http://shared.bimserver.org/", "updateGeoTagResponse");
    private final static QName _GetGeoTag_QNAME = new QName("http://shared.bimserver.org/", "getGeoTag");
    private final static QName _IsExportTypeEnabled_QNAME = new QName("http://shared.bimserver.org/", "isExportTypeEnabled");
    private final static QName _LogoutResponse_QNAME = new QName("http://shared.bimserver.org/", "logoutResponse");
    private final static QName _ServiceException_QNAME = new QName("http://shared.bimserver.org/", "ServiceException");
    private final static QName _SetRevisionTagResponse_QNAME = new QName("http://shared.bimserver.org/", "setRevisionTagResponse");
    private final static QName _GetCurrentTokenResponse_QNAME = new QName("http://shared.bimserver.org/", "getCurrentTokenResponse");
    private final static QName _DeleteProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "deleteProjectResponse");
    private final static QName _SDataObject_QNAME = new QName("http://shared.bimserver.org/", "sDataObject");
    private final static QName _Download_QNAME = new QName("http://shared.bimserver.org/", "download");
    private final static QName _GetAllProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllProjectsResponse");
    private final static QName _IsLoggedIn_QNAME = new QName("http://shared.bimserver.org/", "isLoggedIn");
    private final static QName _DownloadOfTypeResponse_QNAME = new QName("http://shared.bimserver.org/", "downloadOfTypeResponse");
    private final static QName _Logout_QNAME = new QName("http://shared.bimserver.org/", "logout");
    private final static QName _UpdateGeoTag_QNAME = new QName("http://shared.bimserver.org/", "updateGeoTag");
    private final static QName _GetAllCheckoutsOfProjectAndSubProjects_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfProjectAndSubProjects");
    private final static QName _GetAllCheckoutsOfProjectAndSubProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfProjectAndSubProjectsResponse");
    private final static QName _GetDataObjectByGuid_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectByGuid");
    private final static QName _GetAllReadableProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllReadableProjectsResponse");
    private final static QName _GetAccessMethod_QNAME = new QName("http://shared.bimserver.org/", "getAccessMethod");
    private final static QName _GetAllAuthorizedUsersOfProject_QNAME = new QName("http://shared.bimserver.org/", "getAllAuthorizedUsersOfProject");
    private final static QName _CheckoutLastRevisionResponse_QNAME = new QName("http://shared.bimserver.org/", "checkoutLastRevisionResponse");
    private final static QName _GetRevision_QNAME = new QName("http://shared.bimserver.org/", "getRevision");
    private final static QName _GetDataObjectByOid_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectByOid");
    private final static QName _DownloadByGuids_QNAME = new QName("http://shared.bimserver.org/", "downloadByGuids");
    private final static QName _UserHasCheckinRightsResponse_QNAME = new QName("http://shared.bimserver.org/", "userHasCheckinRightsResponse");
    private final static QName _SProject_QNAME = new QName("http://shared.bimserver.org/", "sProject");
    private final static QName _LoginResponse_QNAME = new QName("http://shared.bimserver.org/", "loginResponse");
    private final static QName _GetUserByUoid_QNAME = new QName("http://shared.bimserver.org/", "getUserByUoid");
    private final static QName _GetActiveLongActions_QNAME = new QName("http://shared.bimserver.org/", "getActiveLongActions");
    private final static QName _DownloadResponse_QNAME = new QName("http://shared.bimserver.org/", "downloadResponse");
    private final static QName _FindClashesByEidResponse_QNAME = new QName("http://shared.bimserver.org/", "findClashesByEidResponse");
    private final static QName _PingResponse_QNAME = new QName("http://shared.bimserver.org/", "pingResponse");
    private final static QName _GetAllCheckoutsOfRevision_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfRevision");
    private final static QName _GetUserByUserNameResponse_QNAME = new QName("http://shared.bimserver.org/", "getUserByUserNameResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://shared.bimserver.org/", "deleteUserResponse");
    private final static QName _SClash_QNAME = new QName("http://shared.bimserver.org/", "sClash");
    private final static QName _Token_QNAME = new QName("http://shared.bimserver.org/", "token");
    private final static QName _UndeleteProject_QNAME = new QName("http://shared.bimserver.org/", "undeleteProject");
    private final static QName _SLogAction_QNAME = new QName("http://shared.bimserver.org/", "sLogAction");
    private final static QName _RemoveUserFromProject_QNAME = new QName("http://shared.bimserver.org/", "removeUserFromProject");
    private final static QName _RequestPasswordChange_QNAME = new QName("http://shared.bimserver.org/", "requestPasswordChange");
    private final static QName _SRevision_QNAME = new QName("http://shared.bimserver.org/", "sRevision");
    private final static QName _BranchToExistingProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "branchToExistingProjectResponse");
    private final static QName _GetAllNonAuthorizedUsersOfProject_QNAME = new QName("http://shared.bimserver.org/", "getAllNonAuthorizedUsersOfProject");
    private final static QName _IsExportTypeEnabledResponse_QNAME = new QName("http://shared.bimserver.org/", "isExportTypeEnabledResponse");
    private final static QName _GetCurrentUser_QNAME = new QName("http://shared.bimserver.org/", "getCurrentUser");
    private final static QName _ValidateAccountResponse_QNAME = new QName("http://shared.bimserver.org/", "validateAccountResponse");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "updateProjectResponse");
    private final static QName _AddProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "addProjectResponse");
    private final static QName _LoginAnonymousResponse_QNAME = new QName("http://shared.bimserver.org/", "loginAnonymousResponse");
    private final static QName _GetAvailableClasses_QNAME = new QName("http://shared.bimserver.org/", "getAvailableClasses");
    private final static QName _UndeleteUserResponse_QNAME = new QName("http://shared.bimserver.org/", "undeleteUserResponse");
    private final static QName _GetAllCheckoutsOfProject_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfProject");
    private final static QName _GetAllCheckoutsByUser_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsByUser");
    private final static QName _CheckinSync_QNAME = new QName("http://shared.bimserver.org/", "checkinSync");
    private final static QName _GetUsersProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "getUsersProjectsResponse");
    private final static QName _GetAllRevisionsOfProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllRevisionsOfProjectResponse");
    private final static QName _GetRevisionSummaryResponse_QNAME = new QName("http://shared.bimserver.org/", "getRevisionSummaryResponse");
    private final static QName _ChangePasswordResponse_QNAME = new QName("http://shared.bimserver.org/", "changePasswordResponse");
    private final static QName _SDataValue_QNAME = new QName("http://shared.bimserver.org/", "sDataValue");
    private final static QName _CheckinAsync_QNAME = new QName("http://shared.bimserver.org/", "checkinAsync");
    private final static QName _ChangePassword_QNAME = new QName("http://shared.bimserver.org/", "changePassword");
    private final static QName _GetDataObjectByOidResponse_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectByOidResponse");
    private final static QName _GetAllResultTypes_QNAME = new QName("http://shared.bimserver.org/", "getAllResultTypes");
    private final static QName _SCheckout_QNAME = new QName("http://shared.bimserver.org/", "sCheckout");
    private final static QName _ServerException_QNAME = new QName("http://shared.bimserver.org/", "ServerException");
    private final static QName _GetAllResultTypesResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllResultTypesResponse");
    private final static QName _Compare_QNAME = new QName("http://shared.bimserver.org/", "compare");
    private final static QName _GetAllReadableProjects_QNAME = new QName("http://shared.bimserver.org/", "getAllReadableProjects");
    private final static QName _GetAllUsers_QNAME = new QName("http://shared.bimserver.org/", "getAllUsers");
    private final static QName _ChangeUserTypeResponse_QNAME = new QName("http://shared.bimserver.org/", "changeUserTypeResponse");
    private final static QName _GetAllCheckoutsOfRevisionResponse_QNAME = new QName("http://shared.bimserver.org/", "getAllCheckoutsOfRevisionResponse");
    private final static QName _FindClashesByGuid_QNAME = new QName("http://shared.bimserver.org/", "findClashesByGuid");
    private final static QName _DownloadProjectsResponse_QNAME = new QName("http://shared.bimserver.org/", "downloadProjectsResponse");
    private final static QName _SEidClash_QNAME = new QName("http://shared.bimserver.org/", "sEidClash");
    private final static QName _ChangeUserType_QNAME = new QName("http://shared.bimserver.org/", "changeUserType");
    private final static QName _ValidateAccount_QNAME = new QName("http://shared.bimserver.org/", "validateAccount");
    private final static QName _GetProjectByName_QNAME = new QName("http://shared.bimserver.org/", "getProjectByName");
    private final static QName _GetAllRevisionsOfProject_QNAME = new QName("http://shared.bimserver.org/", "getAllRevisionsOfProject");
    private final static QName _GetLogs_QNAME = new QName("http://shared.bimserver.org/", "getLogs");
    private final static QName _DownloadByGuidsResponse_QNAME = new QName("http://shared.bimserver.org/", "downloadByGuidsResponse");
    private final static QName _GetUserByUserName_QNAME = new QName("http://shared.bimserver.org/", "getUserByUserName");
    private final static QName _UpdateRevision_QNAME = new QName("http://shared.bimserver.org/", "updateRevision");
    private final static QName _GetCurrentUserResponse_QNAME = new QName("http://shared.bimserver.org/", "getCurrentUserResponse");
    private final static QName _GetAccessMethodResponse_QNAME = new QName("http://shared.bimserver.org/", "getAccessMethodResponse");
    private final static QName _GetDataObjectByGuidResponse_QNAME = new QName("http://shared.bimserver.org/", "getDataObjectByGuidResponse");
    private final static QName _CheckinSyncResponse_QNAME = new QName("http://shared.bimserver.org/", "checkinSyncResponse");
    private final static QName _Ping_QNAME = new QName("http://shared.bimserver.org/", "ping");
    private final static QName _SGuidClash_QNAME = new QName("http://shared.bimserver.org/", "sGuidClash");
    private final static QName _DownloadOfType_QNAME = new QName("http://shared.bimserver.org/", "downloadOfType");
    private final static QName _GetProjectByNameResponse_QNAME = new QName("http://shared.bimserver.org/", "getProjectByNameResponse");
    private final static QName _GetActiveLongActionsResponse_QNAME = new QName("http://shared.bimserver.org/", "getActiveLongActionsResponse");
    private final static QName _AddUserToProjectResponse_QNAME = new QName("http://shared.bimserver.org/", "addUserToProjectResponse");
    private final static QName _GetEnabledResultTypesResponse_QNAME = new QName("http://shared.bimserver.org/", "getEnabledResultTypesResponse");
    private final static QName _UserException_QNAME = new QName("http://shared.bimserver.org/", "UserException");
    private final static QName _AddUserResponse_QNAME = new QName("http://shared.bimserver.org/", "addUserResponse");
    private final static QName _CompareResponse_QNAME = new QName("http://shared.bimserver.org/", "compareResponse");
    private final static QName _UserHasRights_QNAME = new QName("http://shared.bimserver.org/", "userHasRights");
    private final static QName _AddUser_QNAME = new QName("http://shared.bimserver.org/", "addUser");
    private final static QName _GetShowCheckoutWarningResponse_QNAME = new QName("http://shared.bimserver.org/", "getShowCheckoutWarningResponse");
    private final static QName _UpdateRevisionResponse_QNAME = new QName("http://shared.bimserver.org/", "updateRevisionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bimserver.generatedclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEnabledResultTypesResponse }
     * 
     */
    public GetEnabledResultTypesResponse createGetEnabledResultTypesResponse() {
        return new GetEnabledResultTypesResponse();
    }

    /**
     * Create an instance of {@link AddUserToProjectResponse }
     * 
     */
    public AddUserToProjectResponse createAddUserToProjectResponse() {
        return new AddUserToProjectResponse();
    }

    /**
     * Create an instance of {@link GetActiveLongActionsResponse }
     * 
     */
    public GetActiveLongActionsResponse createGetActiveLongActionsResponse() {
        return new GetActiveLongActionsResponse();
    }

    /**
     * Create an instance of {@link GetProjectByNameResponse }
     * 
     */
    public GetProjectByNameResponse createGetProjectByNameResponse() {
        return new GetProjectByNameResponse();
    }

    /**
     * Create an instance of {@link DownloadOfType }
     * 
     */
    public DownloadOfType createDownloadOfType() {
        return new DownloadOfType();
    }

    /**
     * Create an instance of {@link UserHasRights }
     * 
     */
    public UserHasRights createUserHasRights() {
        return new UserHasRights();
    }

    /**
     * Create an instance of {@link CompareResponse }
     * 
     */
    public CompareResponse createCompareResponse() {
        return new CompareResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link UserException }
     * 
     */
    public UserException createUserException() {
        return new UserException();
    }

    /**
     * Create an instance of {@link UpdateRevisionResponse }
     * 
     */
    public UpdateRevisionResponse createUpdateRevisionResponse() {
        return new UpdateRevisionResponse();
    }

    /**
     * Create an instance of {@link GetShowCheckoutWarningResponse }
     * 
     */
    public GetShowCheckoutWarningResponse createGetShowCheckoutWarningResponse() {
        return new GetShowCheckoutWarningResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetProjectByName }
     * 
     */
    public GetProjectByName createGetProjectByName() {
        return new GetProjectByName();
    }

    /**
     * Create an instance of {@link GetAllRevisionsOfProject }
     * 
     */
    public GetAllRevisionsOfProject createGetAllRevisionsOfProject() {
        return new GetAllRevisionsOfProject();
    }

    /**
     * Create an instance of {@link ValidateAccount }
     * 
     */
    public ValidateAccount createValidateAccount() {
        return new ValidateAccount();
    }

    /**
     * Create an instance of {@link ChangeUserType }
     * 
     */
    public ChangeUserType createChangeUserType() {
        return new ChangeUserType();
    }

    /**
     * Create an instance of {@link GetCurrentUserResponse }
     * 
     */
    public GetCurrentUserResponse createGetCurrentUserResponse() {
        return new GetCurrentUserResponse();
    }

    /**
     * Create an instance of {@link UpdateRevision }
     * 
     */
    public UpdateRevision createUpdateRevision() {
        return new UpdateRevision();
    }

    /**
     * Create an instance of {@link GetUserByUserName }
     * 
     */
    public GetUserByUserName createGetUserByUserName() {
        return new GetUserByUserName();
    }

    /**
     * Create an instance of {@link GetLogs }
     * 
     */
    public GetLogs createGetLogs() {
        return new GetLogs();
    }

    /**
     * Create an instance of {@link DownloadByGuidsResponse }
     * 
     */
    public DownloadByGuidsResponse createDownloadByGuidsResponse() {
        return new DownloadByGuidsResponse();
    }

    /**
     * Create an instance of {@link GetAccessMethodResponse }
     * 
     */
    public GetAccessMethodResponse createGetAccessMethodResponse() {
        return new GetAccessMethodResponse();
    }

    /**
     * Create an instance of {@link SGuidClash }
     * 
     */
    public SGuidClash createSGuidClash() {
        return new SGuidClash();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link CheckinSyncResponse }
     * 
     */
    public CheckinSyncResponse createCheckinSyncResponse() {
        return new CheckinSyncResponse();
    }

    /**
     * Create an instance of {@link GetDataObjectByGuidResponse }
     * 
     */
    public GetDataObjectByGuidResponse createGetDataObjectByGuidResponse() {
        return new GetDataObjectByGuidResponse();
    }

    /**
     * Create an instance of {@link GetAllResultTypesResponse }
     * 
     */
    public GetAllResultTypesResponse createGetAllResultTypesResponse() {
        return new GetAllResultTypesResponse();
    }

    /**
     * Create an instance of {@link ServerException }
     * 
     */
    public ServerException createServerException() {
        return new ServerException();
    }

    /**
     * Create an instance of {@link SCheckout }
     * 
     */
    public SCheckout createSCheckout() {
        return new SCheckout();
    }

    /**
     * Create an instance of {@link GetAllResultTypes }
     * 
     */
    public GetAllResultTypes createGetAllResultTypes() {
        return new GetAllResultTypes();
    }

    /**
     * Create an instance of {@link GetDataObjectByOidResponse }
     * 
     */
    public GetDataObjectByOidResponse createGetDataObjectByOidResponse() {
        return new GetDataObjectByOidResponse();
    }

    /**
     * Create an instance of {@link GetAllReadableProjects }
     * 
     */
    public GetAllReadableProjects createGetAllReadableProjects() {
        return new GetAllReadableProjects();
    }

    /**
     * Create an instance of {@link Compare }
     * 
     */
    public Compare createCompare() {
        return new Compare();
    }

    /**
     * Create an instance of {@link ChangeUserTypeResponse }
     * 
     */
    public ChangeUserTypeResponse createChangeUserTypeResponse() {
        return new ChangeUserTypeResponse();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link SEidClash }
     * 
     */
    public SEidClash createSEidClash() {
        return new SEidClash();
    }

    /**
     * Create an instance of {@link DownloadProjectsResponse }
     * 
     */
    public DownloadProjectsResponse createDownloadProjectsResponse() {
        return new DownloadProjectsResponse();
    }

    /**
     * Create an instance of {@link FindClashesByGuid }
     * 
     */
    public FindClashesByGuid createFindClashesByGuid() {
        return new FindClashesByGuid();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfRevisionResponse }
     * 
     */
    public GetAllCheckoutsOfRevisionResponse createGetAllCheckoutsOfRevisionResponse() {
        return new GetAllCheckoutsOfRevisionResponse();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsByUser }
     * 
     */
    public GetAllCheckoutsByUser createGetAllCheckoutsByUser() {
        return new GetAllCheckoutsByUser();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfProject }
     * 
     */
    public GetAllCheckoutsOfProject createGetAllCheckoutsOfProject() {
        return new GetAllCheckoutsOfProject();
    }

    /**
     * Create an instance of {@link GetRevisionSummaryResponse }
     * 
     */
    public GetRevisionSummaryResponse createGetRevisionSummaryResponse() {
        return new GetRevisionSummaryResponse();
    }

    /**
     * Create an instance of {@link GetAllRevisionsOfProjectResponse }
     * 
     */
    public GetAllRevisionsOfProjectResponse createGetAllRevisionsOfProjectResponse() {
        return new GetAllRevisionsOfProjectResponse();
    }

    /**
     * Create an instance of {@link GetUsersProjectsResponse }
     * 
     */
    public GetUsersProjectsResponse createGetUsersProjectsResponse() {
        return new GetUsersProjectsResponse();
    }

    /**
     * Create an instance of {@link CheckinSync }
     * 
     */
    public CheckinSync createCheckinSync() {
        return new CheckinSync();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link CheckinAsync }
     * 
     */
    public CheckinAsync createCheckinAsync() {
        return new CheckinAsync();
    }

    /**
     * Create an instance of {@link SDataValue }
     * 
     */
    public SDataValue createSDataValue() {
        return new SDataValue();
    }

    /**
     * Create an instance of {@link IsExportTypeEnabledResponse }
     * 
     */
    public IsExportTypeEnabledResponse createIsExportTypeEnabledResponse() {
        return new IsExportTypeEnabledResponse();
    }

    /**
     * Create an instance of {@link GetCurrentUser }
     * 
     */
    public GetCurrentUser createGetCurrentUser() {
        return new GetCurrentUser();
    }

    /**
     * Create an instance of {@link SRevision }
     * 
     */
    public SRevision createSRevision() {
        return new SRevision();
    }

    /**
     * Create an instance of {@link BranchToExistingProjectResponse }
     * 
     */
    public BranchToExistingProjectResponse createBranchToExistingProjectResponse() {
        return new BranchToExistingProjectResponse();
    }

    /**
     * Create an instance of {@link GetAllNonAuthorizedUsersOfProject }
     * 
     */
    public GetAllNonAuthorizedUsersOfProject createGetAllNonAuthorizedUsersOfProject() {
        return new GetAllNonAuthorizedUsersOfProject();
    }

    /**
     * Create an instance of {@link AddProjectResponse }
     * 
     */
    public AddProjectResponse createAddProjectResponse() {
        return new AddProjectResponse();
    }

    /**
     * Create an instance of {@link UpdateProjectResponse }
     * 
     */
    public UpdateProjectResponse createUpdateProjectResponse() {
        return new UpdateProjectResponse();
    }

    /**
     * Create an instance of {@link ValidateAccountResponse }
     * 
     */
    public ValidateAccountResponse createValidateAccountResponse() {
        return new ValidateAccountResponse();
    }

    /**
     * Create an instance of {@link UndeleteUserResponse }
     * 
     */
    public UndeleteUserResponse createUndeleteUserResponse() {
        return new UndeleteUserResponse();
    }

    /**
     * Create an instance of {@link GetAvailableClasses }
     * 
     */
    public GetAvailableClasses createGetAvailableClasses() {
        return new GetAvailableClasses();
    }

    /**
     * Create an instance of {@link LoginAnonymousResponse }
     * 
     */
    public LoginAnonymousResponse createLoginAnonymousResponse() {
        return new LoginAnonymousResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link GetUserByUserNameResponse }
     * 
     */
    public GetUserByUserNameResponse createGetUserByUserNameResponse() {
        return new GetUserByUserNameResponse();
    }

    /**
     * Create an instance of {@link Token }
     * 
     */
    public Token createToken() {
        return new Token();
    }

    /**
     * Create an instance of {@link SClash }
     * 
     */
    public SClash createSClash() {
        return new SClash();
    }

    /**
     * Create an instance of {@link UndeleteProject }
     * 
     */
    public UndeleteProject createUndeleteProject() {
        return new UndeleteProject();
    }

    /**
     * Create an instance of {@link SLogAction }
     * 
     */
    public SLogAction createSLogAction() {
        return new SLogAction();
    }

    /**
     * Create an instance of {@link RemoveUserFromProject }
     * 
     */
    public RemoveUserFromProject createRemoveUserFromProject() {
        return new RemoveUserFromProject();
    }

    /**
     * Create an instance of {@link RequestPasswordChange }
     * 
     */
    public RequestPasswordChange createRequestPasswordChange() {
        return new RequestPasswordChange();
    }

    /**
     * Create an instance of {@link UserHasCheckinRightsResponse }
     * 
     */
    public UserHasCheckinRightsResponse createUserHasCheckinRightsResponse() {
        return new UserHasCheckinRightsResponse();
    }

    /**
     * Create an instance of {@link DownloadByGuids }
     * 
     */
    public DownloadByGuids createDownloadByGuids() {
        return new DownloadByGuids();
    }

    /**
     * Create an instance of {@link GetRevision }
     * 
     */
    public GetRevision createGetRevision() {
        return new GetRevision();
    }

    /**
     * Create an instance of {@link GetDataObjectByOid }
     * 
     */
    public GetDataObjectByOid createGetDataObjectByOid() {
        return new GetDataObjectByOid();
    }

    /**
     * Create an instance of {@link GetActiveLongActions }
     * 
     */
    public GetActiveLongActions createGetActiveLongActions() {
        return new GetActiveLongActions();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetUserByUoid }
     * 
     */
    public GetUserByUoid createGetUserByUoid() {
        return new GetUserByUoid();
    }

    /**
     * Create an instance of {@link SProject }
     * 
     */
    public SProject createSProject() {
        return new SProject();
    }

    /**
     * Create an instance of {@link FindClashesByEidResponse }
     * 
     */
    public FindClashesByEidResponse createFindClashesByEidResponse() {
        return new FindClashesByEidResponse();
    }

    /**
     * Create an instance of {@link DownloadResponse }
     * 
     */
    public DownloadResponse createDownloadResponse() {
        return new DownloadResponse();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfRevision }
     * 
     */
    public GetAllCheckoutsOfRevision createGetAllCheckoutsOfRevision() {
        return new GetAllCheckoutsOfRevision();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link UpdateGeoTag }
     * 
     */
    public UpdateGeoTag createUpdateGeoTag() {
        return new UpdateGeoTag();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link GetAllReadableProjectsResponse }
     * 
     */
    public GetAllReadableProjectsResponse createGetAllReadableProjectsResponse() {
        return new GetAllReadableProjectsResponse();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfProjectAndSubProjects }
     * 
     */
    public GetAllCheckoutsOfProjectAndSubProjects createGetAllCheckoutsOfProjectAndSubProjects() {
        return new GetAllCheckoutsOfProjectAndSubProjects();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfProjectAndSubProjectsResponse }
     * 
     */
    public GetAllCheckoutsOfProjectAndSubProjectsResponse createGetAllCheckoutsOfProjectAndSubProjectsResponse() {
        return new GetAllCheckoutsOfProjectAndSubProjectsResponse();
    }

    /**
     * Create an instance of {@link GetDataObjectByGuid }
     * 
     */
    public GetDataObjectByGuid createGetDataObjectByGuid() {
        return new GetDataObjectByGuid();
    }

    /**
     * Create an instance of {@link GetAllAuthorizedUsersOfProject }
     * 
     */
    public GetAllAuthorizedUsersOfProject createGetAllAuthorizedUsersOfProject() {
        return new GetAllAuthorizedUsersOfProject();
    }

    /**
     * Create an instance of {@link GetAccessMethod }
     * 
     */
    public GetAccessMethod createGetAccessMethod() {
        return new GetAccessMethod();
    }

    /**
     * Create an instance of {@link CheckoutLastRevisionResponse }
     * 
     */
    public CheckoutLastRevisionResponse createCheckoutLastRevisionResponse() {
        return new CheckoutLastRevisionResponse();
    }

    /**
     * Create an instance of {@link IsLoggedIn }
     * 
     */
    public IsLoggedIn createIsLoggedIn() {
        return new IsLoggedIn();
    }

    /**
     * Create an instance of {@link GetAllProjectsResponse }
     * 
     */
    public GetAllProjectsResponse createGetAllProjectsResponse() {
        return new GetAllProjectsResponse();
    }

    /**
     * Create an instance of {@link SDataObject }
     * 
     */
    public SDataObject createSDataObject() {
        return new SDataObject();
    }

    /**
     * Create an instance of {@link Download }
     * 
     */
    public Download createDownload() {
        return new Download();
    }

    /**
     * Create an instance of {@link DownloadOfTypeResponse }
     * 
     */
    public DownloadOfTypeResponse createDownloadOfTypeResponse() {
        return new DownloadOfTypeResponse();
    }

    /**
     * Create an instance of {@link GetAllAuthorizedUsersOfProjectResponse }
     * 
     */
    public GetAllAuthorizedUsersOfProjectResponse createGetAllAuthorizedUsersOfProjectResponse() {
        return new GetAllAuthorizedUsersOfProjectResponse();
    }

    /**
     * Create an instance of {@link UserHasCheckinRights }
     * 
     */
    public UserHasCheckinRights createUserHasCheckinRights() {
        return new UserHasCheckinRights();
    }

    /**
     * Create an instance of {@link CheckinAsyncResponse }
     * 
     */
    public CheckinAsyncResponse createCheckinAsyncResponse() {
        return new CheckinAsyncResponse();
    }

    /**
     * Create an instance of {@link AddProject }
     * 
     */
    public AddProject createAddProject() {
        return new AddProject();
    }

    /**
     * Create an instance of {@link GetAllProjects }
     * 
     */
    public GetAllProjects createGetAllProjects() {
        return new GetAllProjects();
    }

    /**
     * Create an instance of {@link GetDataObjectsByTypeResponse }
     * 
     */
    public GetDataObjectsByTypeResponse createGetDataObjectsByTypeResponse() {
        return new GetDataObjectsByTypeResponse();
    }

    /**
     * Create an instance of {@link GetDatabaseInformationResponse }
     * 
     */
    public GetDatabaseInformationResponse createGetDatabaseInformationResponse() {
        return new GetDatabaseInformationResponse();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link GetAnonymousUserResponse }
     * 
     */
    public GetAnonymousUserResponse createGetAnonymousUserResponse() {
        return new GetAnonymousUserResponse();
    }

    /**
     * Create an instance of {@link IsExportTypeEnabled }
     * 
     */
    public IsExportTypeEnabled createIsExportTypeEnabled() {
        return new IsExportTypeEnabled();
    }

    /**
     * Create an instance of {@link GetGeoTag }
     * 
     */
    public GetGeoTag createGetGeoTag() {
        return new GetGeoTag();
    }

    /**
     * Create an instance of {@link UpdateGeoTagResponse }
     * 
     */
    public UpdateGeoTagResponse createUpdateGeoTagResponse() {
        return new UpdateGeoTagResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link DeleteProjectResponse }
     * 
     */
    public DeleteProjectResponse createDeleteProjectResponse() {
        return new DeleteProjectResponse();
    }

    /**
     * Create an instance of {@link GetCurrentTokenResponse }
     * 
     */
    public GetCurrentTokenResponse createGetCurrentTokenResponse() {
        return new GetCurrentTokenResponse();
    }

    /**
     * Create an instance of {@link SetRevisionTagResponse }
     * 
     */
    public SetRevisionTagResponse createSetRevisionTagResponse() {
        return new SetRevisionTagResponse();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link GetLastActive }
     * 
     */
    public GetLastActive createGetLastActive() {
        return new GetLastActive();
    }

    /**
     * Create an instance of {@link GetLastActiveResponse }
     * 
     */
    public GetLastActiveResponse createGetLastActiveResponse() {
        return new GetLastActiveResponse();
    }

    /**
     * Create an instance of {@link BranchToExistingProject }
     * 
     */
    public BranchToExistingProject createBranchToExistingProject() {
        return new BranchToExistingProject();
    }

    /**
     * Create an instance of {@link GetProjectByPoidResponse }
     * 
     */
    public GetProjectByPoidResponse createGetProjectByPoidResponse() {
        return new GetProjectByPoidResponse();
    }

    /**
     * Create an instance of {@link GetClashDetectionSettingsResponse }
     * 
     */
    public GetClashDetectionSettingsResponse createGetClashDetectionSettingsResponse() {
        return new GetClashDetectionSettingsResponse();
    }

    /**
     * Create an instance of {@link FindClashesByGuidResponse }
     * 
     */
    public FindClashesByGuidResponse createFindClashesByGuidResponse() {
        return new FindClashesByGuidResponse();
    }

    /**
     * Create an instance of {@link GetRevisionSummary }
     * 
     */
    public GetRevisionSummary createGetRevisionSummary() {
        return new GetRevisionSummary();
    }

    /**
     * Create an instance of {@link DownloadProjects }
     * 
     */
    public DownloadProjects createDownloadProjects() {
        return new DownloadProjects();
    }

    /**
     * Create an instance of {@link SetExportTypeEnabledResponse }
     * 
     */
    public SetExportTypeEnabledResponse createSetExportTypeEnabledResponse() {
        return new SetExportTypeEnabledResponse();
    }

    /**
     * Create an instance of {@link GetSubProjects }
     * 
     */
    public GetSubProjects createGetSubProjects() {
        return new GetSubProjects();
    }

    /**
     * Create an instance of {@link DownloadByOids }
     * 
     */
    public DownloadByOids createDownloadByOids() {
        return new DownloadByOids();
    }

    /**
     * Create an instance of {@link AddUserToProject }
     * 
     */
    public AddUserToProject createAddUserToProject() {
        return new AddUserToProject();
    }

    /**
     * Create an instance of {@link GetActiveSinceResponse }
     * 
     */
    public GetActiveSinceResponse createGetActiveSinceResponse() {
        return new GetActiveSinceResponse();
    }

    /**
     * Create an instance of {@link GetActiveUserSessionsResponse }
     * 
     */
    public GetActiveUserSessionsResponse createGetActiveUserSessionsResponse() {
        return new GetActiveUserSessionsResponse();
    }

    /**
     * Create an instance of {@link GetAnonymousUser }
     * 
     */
    public GetAnonymousUser createGetAnonymousUser() {
        return new GetAnonymousUser();
    }

    /**
     * Create an instance of {@link UpdateClashDetectionSettingsResponse }
     * 
     */
    public UpdateClashDetectionSettingsResponse createUpdateClashDetectionSettingsResponse() {
        return new UpdateClashDetectionSettingsResponse();
    }

    /**
     * Create an instance of {@link GetAvailableClassesResponse }
     * 
     */
    public GetAvailableClassesResponse createGetAvailableClassesResponse() {
        return new GetAvailableClassesResponse();
    }

    /**
     * Create an instance of {@link UserHasRightsResponse }
     * 
     */
    public UserHasRightsResponse createUserHasRightsResponse() {
        return new UserHasRightsResponse();
    }

    /**
     * Create an instance of {@link GetLastClashesResponse }
     * 
     */
    public GetLastClashesResponse createGetLastClashesResponse() {
        return new GetLastClashesResponse();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsByUserResponse }
     * 
     */
    public GetAllCheckoutsByUserResponse createGetAllCheckoutsByUserResponse() {
        return new GetAllCheckoutsByUserResponse();
    }

    /**
     * Create an instance of {@link GetGeoTagResponse }
     * 
     */
    public GetGeoTagResponse createGetGeoTagResponse() {
        return new GetGeoTagResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link GetLoggedInUser }
     * 
     */
    public GetLoggedInUser createGetLoggedInUser() {
        return new GetLoggedInUser();
    }

    /**
     * Create an instance of {@link GetAllCheckoutsOfProjectResponse }
     * 
     */
    public GetAllCheckoutsOfProjectResponse createGetAllCheckoutsOfProjectResponse() {
        return new GetAllCheckoutsOfProjectResponse();
    }

    /**
     * Create an instance of {@link Checkout }
     * 
     */
    public Checkout createCheckout() {
        return new Checkout();
    }

    /**
     * Create an instance of {@link GetUsersProjects }
     * 
     */
    public GetUsersProjects createGetUsersProjects() {
        return new GetUsersProjects();
    }

    /**
     * Create an instance of {@link CheckoutLastRevision }
     * 
     */
    public CheckoutLastRevision createCheckoutLastRevision() {
        return new CheckoutLastRevision();
    }

    /**
     * Create an instance of {@link GetAllNonAuthorizedProjectsOfUserResponse }
     * 
     */
    public GetAllNonAuthorizedProjectsOfUserResponse createGetAllNonAuthorizedProjectsOfUserResponse() {
        return new GetAllNonAuthorizedProjectsOfUserResponse();
    }

    /**
     * Create an instance of {@link GetAllRevisionsByUserResponse }
     * 
     */
    public GetAllRevisionsByUserResponse createGetAllRevisionsByUserResponse() {
        return new GetAllRevisionsByUserResponse();
    }

    /**
     * Create an instance of {@link AddProjectAsSubProjectResponse }
     * 
     */
    public AddProjectAsSubProjectResponse createAddProjectAsSubProjectResponse() {
        return new AddProjectAsSubProjectResponse();
    }

    /**
     * Create an instance of {@link GetAllNonAuthorizedProjectsOfUser }
     * 
     */
    public GetAllNonAuthorizedProjectsOfUser createGetAllNonAuthorizedProjectsOfUser() {
        return new GetAllNonAuthorizedProjectsOfUser();
    }

    /**
     * Create an instance of {@link SendCompareEmail }
     * 
     */
    public SendCompareEmail createSendCompareEmail() {
        return new SendCompareEmail();
    }

    /**
     * Create an instance of {@link LoginAnonymous }
     * 
     */
    public LoginAnonymous createLoginAnonymous() {
        return new LoginAnonymous();
    }

    /**
     * Create an instance of {@link SendCompareEmailResponse }
     * 
     */
    public SendCompareEmailResponse createSendCompareEmailResponse() {
        return new SendCompareEmailResponse();
    }

    /**
     * Create an instance of {@link GetDatabaseInformation }
     * 
     */
    public GetDatabaseInformation createGetDatabaseInformation() {
        return new GetDatabaseInformation();
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
    }

    /**
     * Create an instance of {@link BranchToNewProjectResponse }
     * 
     */
    public BranchToNewProjectResponse createBranchToNewProjectResponse() {
        return new BranchToNewProjectResponse();
    }

    /**
     * Create an instance of {@link UndeleteProjectResponse }
     * 
     */
    public UndeleteProjectResponse createUndeleteProjectResponse() {
        return new UndeleteProjectResponse();
    }

    /**
     * Create an instance of {@link SendClashesEmailResponse }
     * 
     */
    public SendClashesEmailResponse createSendClashesEmailResponse() {
        return new SendClashesEmailResponse();
    }

    /**
     * Create an instance of {@link GetEnabledResultTypes }
     * 
     */
    public GetEnabledResultTypes createGetEnabledResultTypes() {
        return new GetEnabledResultTypes();
    }

    /**
     * Create an instance of {@link GetClashDetectionSettings }
     * 
     */
    public GetClashDetectionSettings createGetClashDetectionSettings() {
        return new GetClashDetectionSettings();
    }

    /**
     * Create an instance of {@link UndeleteUser }
     * 
     */
    public UndeleteUser createUndeleteUser() {
        return new UndeleteUser();
    }

    /**
     * Create an instance of {@link DeleteProject }
     * 
     */
    public DeleteProject createDeleteProject() {
        return new DeleteProject();
    }

    /**
     * Create an instance of {@link GetShowCheckoutWarning }
     * 
     */
    public GetShowCheckoutWarning createGetShowCheckoutWarning() {
        return new GetShowCheckoutWarning();
    }

    /**
     * Create an instance of {@link GetLastClashes }
     * 
     */
    public GetLastClashes createGetLastClashes() {
        return new GetLastClashes();
    }

    /**
     * Create an instance of {@link GetActiveUserSessions }
     * 
     */
    public GetActiveUserSessions createGetActiveUserSessions() {
        return new GetActiveUserSessions();
    }

    /**
     * Create an instance of {@link GetDataObjectsByType }
     * 
     */
    public GetDataObjectsByType createGetDataObjectsByType() {
        return new GetDataObjectsByType();
    }

    /**
     * Create an instance of {@link BranchToNewProject }
     * 
     */
    public BranchToNewProject createBranchToNewProject() {
        return new BranchToNewProject();
    }

    /**
     * Create an instance of {@link Autologin }
     * 
     */
    public Autologin createAutologin() {
        return new Autologin();
    }

    /**
     * Create an instance of {@link GetAllNonAuthorizedUsersOfProjectResponse }
     * 
     */
    public GetAllNonAuthorizedUsersOfProjectResponse createGetAllNonAuthorizedUsersOfProjectResponse() {
        return new GetAllNonAuthorizedUsersOfProjectResponse();
    }

    /**
     * Create an instance of {@link SClashDetectionSettings }
     * 
     */
    public SClashDetectionSettings createSClashDetectionSettings() {
        return new SClashDetectionSettings();
    }

    /**
     * Create an instance of {@link AddProjectAsSubProject }
     * 
     */
    public AddProjectAsSubProject createAddProjectAsSubProject() {
        return new AddProjectAsSubProject();
    }

    /**
     * Create an instance of {@link GetAllRevisionsByUser }
     * 
     */
    public GetAllRevisionsByUser createGetAllRevisionsByUser() {
        return new GetAllRevisionsByUser();
    }

    /**
     * Create an instance of {@link RequestPasswordChangeResponse }
     * 
     */
    public RequestPasswordChangeResponse createRequestPasswordChangeResponse() {
        return new RequestPasswordChangeResponse();
    }

    /**
     * Create an instance of {@link SetRevisionTag }
     * 
     */
    public SetRevisionTag createSetRevisionTag() {
        return new SetRevisionTag();
    }

    /**
     * Create an instance of {@link FindClashesByEid }
     * 
     */
    public FindClashesByEid createFindClashesByEid() {
        return new FindClashesByEid();
    }

    /**
     * Create an instance of {@link IsLoggedInResponse }
     * 
     */
    public IsLoggedInResponse createIsLoggedInResponse() {
        return new IsLoggedInResponse();
    }

    /**
     * Create an instance of {@link GetProjectByPoid }
     * 
     */
    public GetProjectByPoid createGetProjectByPoid() {
        return new GetProjectByPoid();
    }

    /**
     * Create an instance of {@link GetLoggedInUserResponse }
     * 
     */
    public GetLoggedInUserResponse createGetLoggedInUserResponse() {
        return new GetLoggedInUserResponse();
    }

    /**
     * Create an instance of {@link GetCurrentToken }
     * 
     */
    public GetCurrentToken createGetCurrentToken() {
        return new GetCurrentToken();
    }

    /**
     * Create an instance of {@link GetSubProjectsResponse }
     * 
     */
    public GetSubProjectsResponse createGetSubProjectsResponse() {
        return new GetSubProjectsResponse();
    }

    /**
     * Create an instance of {@link GetRevisionResponse }
     * 
     */
    public GetRevisionResponse createGetRevisionResponse() {
        return new GetRevisionResponse();
    }

    /**
     * Create an instance of {@link UpdateClashDetectionSettings }
     * 
     */
    public UpdateClashDetectionSettings createUpdateClashDetectionSettings() {
        return new UpdateClashDetectionSettings();
    }

    /**
     * Create an instance of {@link RemoveUserFromProjectResponse }
     * 
     */
    public RemoveUserFromProjectResponse createRemoveUserFromProjectResponse() {
        return new RemoveUserFromProjectResponse();
    }

    /**
     * Create an instance of {@link SendClashesEmail }
     * 
     */
    public SendClashesEmail createSendClashesEmail() {
        return new SendClashesEmail();
    }

    /**
     * Create an instance of {@link SGeoTag }
     * 
     */
    public SGeoTag createSGeoTag() {
        return new SGeoTag();
    }

    /**
     * Create an instance of {@link SUser }
     * 
     */
    public SUser createSUser() {
        return new SUser();
    }

    /**
     * Create an instance of {@link GetUserByUoidResponse }
     * 
     */
    public GetUserByUoidResponse createGetUserByUoidResponse() {
        return new GetUserByUoidResponse();
    }

    /**
     * Create an instance of {@link GetActiveSince }
     * 
     */
    public GetActiveSince createGetActiveSince() {
        return new GetActiveSince();
    }

    /**
     * Create an instance of {@link DownloadByOidsResponse }
     * 
     */
    public DownloadByOidsResponse createDownloadByOidsResponse() {
        return new DownloadByOidsResponse();
    }

    /**
     * Create an instance of {@link AutologinResponse }
     * 
     */
    public AutologinResponse createAutologinResponse() {
        return new AutologinResponse();
    }

    /**
     * Create an instance of {@link SDownloadResult }
     * 
     */
    public SDownloadResult createSDownloadResult() {
        return new SDownloadResult();
    }

    /**
     * Create an instance of {@link CheckoutResponse }
     * 
     */
    public CheckoutResponse createCheckoutResponse() {
        return new CheckoutResponse();
    }

    /**
     * Create an instance of {@link SetExportTypeEnabled }
     * 
     */
    public SetExportTypeEnabled createSetExportTypeEnabled() {
        return new SetExportTypeEnabled();
    }

    /**
     * Create an instance of {@link GetLogsResponse }
     * 
     */
    public GetLogsResponse createGetLogsResponse() {
        return new GetLogsResponse();
    }

    /**
     * Create an instance of {@link SUserSession }
     * 
     */
    public SUserSession createSUserSession() {
        return new SUserSession();
    }

    /**
     * Create an instance of {@link SRevisionSummary }
     * 
     */
    public SRevisionSummary createSRevisionSummary() {
        return new SRevisionSummary();
    }

    /**
     * Create an instance of {@link SCheckinResult }
     * 
     */
    public SCheckinResult createSCheckinResult() {
        return new SCheckinResult();
    }

    /**
     * Create an instance of {@link SLongAction }
     * 
     */
    public SLongAction createSLongAction() {
        return new SLongAction();
    }

    /**
     * Create an instance of {@link DatabaseInformation }
     * 
     */
    public DatabaseInformation createDatabaseInformation() {
        return new DatabaseInformation();
    }

    /**
     * Create an instance of {@link SCompareResult }
     * 
     */
    public SCompareResult createSCompareResult() {
        return new SCompareResult();
    }

    /**
     * Create an instance of {@link SCheckoutResult }
     * 
     */
    public SCheckoutResult createSCheckoutResult() {
        return new SCheckoutResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sUser")
    public JAXBElement<SUser> createSUser(SUser value) {
        return new JAXBElement<SUser>(_SUser_QNAME, SUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SGeoTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sGeoTag")
    public JAXBElement<SGeoTag> createSGeoTag(SGeoTag value) {
        return new JAXBElement<SGeoTag>(_SGeoTag_QNAME, SGeoTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendClashesEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sendClashesEmail")
    public JAXBElement<SendClashesEmail> createSendClashesEmail(SendClashesEmail value) {
        return new JAXBElement<SendClashesEmail>(_SendClashesEmail_QNAME, SendClashesEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUserFromProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "removeUserFromProjectResponse")
    public JAXBElement<RemoveUserFromProjectResponse> createRemoveUserFromProjectResponse(RemoveUserFromProjectResponse value) {
        return new JAXBElement<RemoveUserFromProjectResponse>(_RemoveUserFromProjectResponse_QNAME, RemoveUserFromProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveSince }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveSince")
    public JAXBElement<GetActiveSince> createGetActiveSince(GetActiveSince value) {
        return new JAXBElement<GetActiveSince>(_GetActiveSince_QNAME, GetActiveSince.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUoidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUserByUoidResponse")
    public JAXBElement<GetUserByUoidResponse> createGetUserByUoidResponse(GetUserByUoidResponse value) {
        return new JAXBElement<GetUserByUoidResponse>(_GetUserByUoidResponse_QNAME, GetUserByUoidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadByOidsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadByOidsResponse")
    public JAXBElement<DownloadByOidsResponse> createDownloadByOidsResponse(DownloadByOidsResponse value) {
        return new JAXBElement<DownloadByOidsResponse>(_DownloadByOidsResponse_QNAME, DownloadByOidsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLogsResponse")
    public JAXBElement<GetLogsResponse> createGetLogsResponse(GetLogsResponse value) {
        return new JAXBElement<GetLogsResponse>(_GetLogsResponse_QNAME, GetLogsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetExportTypeEnabled }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "setExportTypeEnabled")
    public JAXBElement<SetExportTypeEnabled> createSetExportTypeEnabled(SetExportTypeEnabled value) {
        return new JAXBElement<SetExportTypeEnabled>(_SetExportTypeEnabled_QNAME, SetExportTypeEnabled.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkoutResponse")
    public JAXBElement<CheckoutResponse> createCheckoutResponse(CheckoutResponse value) {
        return new JAXBElement<CheckoutResponse>(_CheckoutResponse_QNAME, CheckoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SDownloadResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sDownloadResult")
    public JAXBElement<SDownloadResult> createSDownloadResult(SDownloadResult value) {
        return new JAXBElement<SDownloadResult>(_SDownloadResult_QNAME, SDownloadResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutologinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "autologinResponse")
    public JAXBElement<AutologinResponse> createAutologinResponse(AutologinResponse value) {
        return new JAXBElement<AutologinResponse>(_AutologinResponse_QNAME, AutologinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByPoid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getProjectByPoid")
    public JAXBElement<GetProjectByPoid> createGetProjectByPoid(GetProjectByPoid value) {
        return new JAXBElement<GetProjectByPoid>(_GetProjectByPoid_QNAME, GetProjectByPoid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsLoggedInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "isLoggedInResponse")
    public JAXBElement<IsLoggedInResponse> createIsLoggedInResponse(IsLoggedInResponse value) {
        return new JAXBElement<IsLoggedInResponse>(_IsLoggedInResponse_QNAME, IsLoggedInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getCurrentToken")
    public JAXBElement<GetCurrentToken> createGetCurrentToken(GetCurrentToken value) {
        return new JAXBElement<GetCurrentToken>(_GetCurrentToken_QNAME, GetCurrentToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoggedInUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLoggedInUserResponse")
    public JAXBElement<GetLoggedInUserResponse> createGetLoggedInUserResponse(GetLoggedInUserResponse value) {
        return new JAXBElement<GetLoggedInUserResponse>(_GetLoggedInUserResponse_QNAME, GetLoggedInUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRevisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getRevisionResponse")
    public JAXBElement<GetRevisionResponse> createGetRevisionResponse(GetRevisionResponse value) {
        return new JAXBElement<GetRevisionResponse>(_GetRevisionResponse_QNAME, GetRevisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getSubProjectsResponse")
    public JAXBElement<GetSubProjectsResponse> createGetSubProjectsResponse(GetSubProjectsResponse value) {
        return new JAXBElement<GetSubProjectsResponse>(_GetSubProjectsResponse_QNAME, GetSubProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClashDetectionSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateClashDetectionSettings")
    public JAXBElement<UpdateClashDetectionSettings> createUpdateClashDetectionSettings(UpdateClashDetectionSettings value) {
        return new JAXBElement<UpdateClashDetectionSettings>(_UpdateClashDetectionSettings_QNAME, UpdateClashDetectionSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveUserSessions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveUserSessions")
    public JAXBElement<GetActiveUserSessions> createGetActiveUserSessions(GetActiveUserSessions value) {
        return new JAXBElement<GetActiveUserSessions>(_GetActiveUserSessions_QNAME, GetActiveUserSessions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastClashes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLastClashes")
    public JAXBElement<GetLastClashes> createGetLastClashes(GetLastClashes value) {
        return new JAXBElement<GetLastClashes>(_GetLastClashes_QNAME, GetLastClashes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShowCheckoutWarning }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getShowCheckoutWarning")
    public JAXBElement<GetShowCheckoutWarning> createGetShowCheckoutWarning(GetShowCheckoutWarning value) {
        return new JAXBElement<GetShowCheckoutWarning>(_GetShowCheckoutWarning_QNAME, GetShowCheckoutWarning.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchToNewProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "branchToNewProject")
    public JAXBElement<BranchToNewProject> createBranchToNewProject(BranchToNewProject value) {
        return new JAXBElement<BranchToNewProject>(_BranchToNewProject_QNAME, BranchToNewProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectsByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectsByType")
    public JAXBElement<GetDataObjectsByType> createGetDataObjectsByType(GetDataObjectsByType value) {
        return new JAXBElement<GetDataObjectsByType>(_GetDataObjectsByType_QNAME, GetDataObjectsByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autologin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "autologin")
    public JAXBElement<Autologin> createAutologin(Autologin value) {
        return new JAXBElement<Autologin>(_Autologin_QNAME, Autologin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindClashesByEid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "findClashesByEid")
    public JAXBElement<FindClashesByEid> createFindClashesByEid(FindClashesByEid value) {
        return new JAXBElement<FindClashesByEid>(_FindClashesByEid_QNAME, FindClashesByEid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRevisionTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "setRevisionTag")
    public JAXBElement<SetRevisionTag> createSetRevisionTag(SetRevisionTag value) {
        return new JAXBElement<SetRevisionTag>(_SetRevisionTag_QNAME, SetRevisionTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPasswordChangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "requestPasswordChangeResponse")
    public JAXBElement<RequestPasswordChangeResponse> createRequestPasswordChangeResponse(RequestPasswordChangeResponse value) {
        return new JAXBElement<RequestPasswordChangeResponse>(_RequestPasswordChangeResponse_QNAME, RequestPasswordChangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRevisionsByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllRevisionsByUser")
    public JAXBElement<GetAllRevisionsByUser> createGetAllRevisionsByUser(GetAllRevisionsByUser value) {
        return new JAXBElement<GetAllRevisionsByUser>(_GetAllRevisionsByUser_QNAME, GetAllRevisionsByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProjectAsSubProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addProjectAsSubProject")
    public JAXBElement<AddProjectAsSubProject> createAddProjectAsSubProject(AddProjectAsSubProject value) {
        return new JAXBElement<AddProjectAsSubProject>(_AddProjectAsSubProject_QNAME, AddProjectAsSubProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SClashDetectionSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sClashDetectionSettings")
    public JAXBElement<SClashDetectionSettings> createSClashDetectionSettings(SClashDetectionSettings value) {
        return new JAXBElement<SClashDetectionSettings>(_SClashDetectionSettings_QNAME, SClashDetectionSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNonAuthorizedUsersOfProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllNonAuthorizedUsersOfProjectResponse")
    public JAXBElement<GetAllNonAuthorizedUsersOfProjectResponse> createGetAllNonAuthorizedUsersOfProjectResponse(GetAllNonAuthorizedUsersOfProjectResponse value) {
        return new JAXBElement<GetAllNonAuthorizedUsersOfProjectResponse>(_GetAllNonAuthorizedUsersOfProjectResponse_QNAME, GetAllNonAuthorizedUsersOfProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRevisionsByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllRevisionsByUserResponse")
    public JAXBElement<GetAllRevisionsByUserResponse> createGetAllRevisionsByUserResponse(GetAllRevisionsByUserResponse value) {
        return new JAXBElement<GetAllRevisionsByUserResponse>(_GetAllRevisionsByUserResponse_QNAME, GetAllRevisionsByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNonAuthorizedProjectsOfUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllNonAuthorizedProjectsOfUserResponse")
    public JAXBElement<GetAllNonAuthorizedProjectsOfUserResponse> createGetAllNonAuthorizedProjectsOfUserResponse(GetAllNonAuthorizedProjectsOfUserResponse value) {
        return new JAXBElement<GetAllNonAuthorizedProjectsOfUserResponse>(_GetAllNonAuthorizedProjectsOfUserResponse_QNAME, GetAllNonAuthorizedProjectsOfUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDatabaseInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDatabaseInformation")
    public JAXBElement<GetDatabaseInformation> createGetDatabaseInformation(GetDatabaseInformation value) {
        return new JAXBElement<GetDatabaseInformation>(_GetDatabaseInformation_QNAME, GetDatabaseInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCompareEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sendCompareEmailResponse")
    public JAXBElement<SendCompareEmailResponse> createSendCompareEmailResponse(SendCompareEmailResponse value) {
        return new JAXBElement<SendCompareEmailResponse>(_SendCompareEmailResponse_QNAME, SendCompareEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginAnonymous }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "loginAnonymous")
    public JAXBElement<LoginAnonymous> createLoginAnonymous(LoginAnonymous value) {
        return new JAXBElement<LoginAnonymous>(_LoginAnonymous_QNAME, LoginAnonymous.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCompareEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sendCompareEmail")
    public JAXBElement<SendCompareEmail> createSendCompareEmail(SendCompareEmail value) {
        return new JAXBElement<SendCompareEmail>(_SendCompareEmail_QNAME, SendCompareEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNonAuthorizedProjectsOfUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllNonAuthorizedProjectsOfUser")
    public JAXBElement<GetAllNonAuthorizedProjectsOfUser> createGetAllNonAuthorizedProjectsOfUser(GetAllNonAuthorizedProjectsOfUser value) {
        return new JAXBElement<GetAllNonAuthorizedProjectsOfUser>(_GetAllNonAuthorizedProjectsOfUser_QNAME, GetAllNonAuthorizedProjectsOfUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProjectAsSubProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addProjectAsSubProjectResponse")
    public JAXBElement<AddProjectAsSubProjectResponse> createAddProjectAsSubProjectResponse(AddProjectAsSubProjectResponse value) {
        return new JAXBElement<AddProjectAsSubProjectResponse>(_AddProjectAsSubProjectResponse_QNAME, AddProjectAsSubProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendClashesEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sendClashesEmailResponse")
    public JAXBElement<SendClashesEmailResponse> createSendClashesEmailResponse(SendClashesEmailResponse value) {
        return new JAXBElement<SendClashesEmailResponse>(_SendClashesEmailResponse_QNAME, SendClashesEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeleteProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "undeleteProjectResponse")
    public JAXBElement<UndeleteProjectResponse> createUndeleteProjectResponse(UndeleteProjectResponse value) {
        return new JAXBElement<UndeleteProjectResponse>(_UndeleteProjectResponse_QNAME, UndeleteProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchToNewProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "branchToNewProjectResponse")
    public JAXBElement<BranchToNewProjectResponse> createBranchToNewProjectResponse(BranchToNewProjectResponse value) {
        return new JAXBElement<BranchToNewProjectResponse>(_BranchToNewProjectResponse_QNAME, BranchToNewProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "deleteProject")
    public JAXBElement<DeleteProject> createDeleteProject(DeleteProject value) {
        return new JAXBElement<DeleteProject>(_DeleteProject_QNAME, DeleteProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "undeleteUser")
    public JAXBElement<UndeleteUser> createUndeleteUser(UndeleteUser value) {
        return new JAXBElement<UndeleteUser>(_UndeleteUser_QNAME, UndeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClashDetectionSettings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getClashDetectionSettings")
    public JAXBElement<GetClashDetectionSettings> createGetClashDetectionSettings(GetClashDetectionSettings value) {
        return new JAXBElement<GetClashDetectionSettings>(_GetClashDetectionSettings_QNAME, GetClashDetectionSettings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEnabledResultTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getEnabledResultTypes")
    public JAXBElement<GetEnabledResultTypes> createGetEnabledResultTypes(GetEnabledResultTypes value) {
        return new JAXBElement<GetEnabledResultTypes>(_GetEnabledResultTypes_QNAME, GetEnabledResultTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnonymousUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAnonymousUser")
    public JAXBElement<GetAnonymousUser> createGetAnonymousUser(GetAnonymousUser value) {
        return new JAXBElement<GetAnonymousUser>(_GetAnonymousUser_QNAME, GetAnonymousUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveUserSessionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveUserSessionsResponse")
    public JAXBElement<GetActiveUserSessionsResponse> createGetActiveUserSessionsResponse(GetActiveUserSessionsResponse value) {
        return new JAXBElement<GetActiveUserSessionsResponse>(_GetActiveUserSessionsResponse_QNAME, GetActiveUserSessionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveSinceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveSinceResponse")
    public JAXBElement<GetActiveSinceResponse> createGetActiveSinceResponse(GetActiveSinceResponse value) {
        return new JAXBElement<GetActiveSinceResponse>(_GetActiveSinceResponse_QNAME, GetActiveSinceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addUserToProject")
    public JAXBElement<AddUserToProject> createAddUserToProject(AddUserToProject value) {
        return new JAXBElement<AddUserToProject>(_AddUserToProject_QNAME, AddUserToProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadByOids }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadByOids")
    public JAXBElement<DownloadByOids> createDownloadByOids(DownloadByOids value) {
        return new JAXBElement<DownloadByOids>(_DownloadByOids_QNAME, DownloadByOids.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableClassesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAvailableClassesResponse")
    public JAXBElement<GetAvailableClassesResponse> createGetAvailableClassesResponse(GetAvailableClassesResponse value) {
        return new JAXBElement<GetAvailableClassesResponse>(_GetAvailableClassesResponse_QNAME, GetAvailableClassesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClashDetectionSettingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateClashDetectionSettingsResponse")
    public JAXBElement<UpdateClashDetectionSettingsResponse> createUpdateClashDetectionSettingsResponse(UpdateClashDetectionSettingsResponse value) {
        return new JAXBElement<UpdateClashDetectionSettingsResponse>(_UpdateClashDetectionSettingsResponse_QNAME, UpdateClashDetectionSettingsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGeoTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getGeoTagResponse")
    public JAXBElement<GetGeoTagResponse> createGetGeoTagResponse(GetGeoTagResponse value) {
        return new JAXBElement<GetGeoTagResponse>(_GetGeoTagResponse_QNAME, GetGeoTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsByUserResponse")
    public JAXBElement<GetAllCheckoutsByUserResponse> createGetAllCheckoutsByUserResponse(GetAllCheckoutsByUserResponse value) {
        return new JAXBElement<GetAllCheckoutsByUserResponse>(_GetAllCheckoutsByUserResponse_QNAME, GetAllCheckoutsByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastClashesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLastClashesResponse")
    public JAXBElement<GetLastClashesResponse> createGetLastClashesResponse(GetLastClashesResponse value) {
        return new JAXBElement<GetLastClashesResponse>(_GetLastClashesResponse_QNAME, GetLastClashesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserHasRightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "userHasRightsResponse")
    public JAXBElement<UserHasRightsResponse> createUserHasRightsResponse(UserHasRightsResponse value) {
        return new JAXBElement<UserHasRightsResponse>(_UserHasRightsResponse_QNAME, UserHasRightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckoutLastRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkoutLastRevision")
    public JAXBElement<CheckoutLastRevision> createCheckoutLastRevision(CheckoutLastRevision value) {
        return new JAXBElement<CheckoutLastRevision>(_CheckoutLastRevision_QNAME, CheckoutLastRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUsersProjects")
    public JAXBElement<GetUsersProjects> createGetUsersProjects(GetUsersProjects value) {
        return new JAXBElement<GetUsersProjects>(_GetUsersProjects_QNAME, GetUsersProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Checkout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkout")
    public JAXBElement<Checkout> createCheckout(Checkout value) {
        return new JAXBElement<Checkout>(_Checkout_QNAME, Checkout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfProjectResponse")
    public JAXBElement<GetAllCheckoutsOfProjectResponse> createGetAllCheckoutsOfProjectResponse(GetAllCheckoutsOfProjectResponse value) {
        return new JAXBElement<GetAllCheckoutsOfProjectResponse>(_GetAllCheckoutsOfProjectResponse_QNAME, GetAllCheckoutsOfProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoggedInUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLoggedInUser")
    public JAXBElement<GetLoggedInUser> createGetLoggedInUser(GetLoggedInUser value) {
        return new JAXBElement<GetLoggedInUser>(_GetLoggedInUser_QNAME, GetLoggedInUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastActive }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLastActive")
    public JAXBElement<GetLastActive> createGetLastActive(GetLastActive value) {
        return new JAXBElement<GetLastActive>(_GetLastActive_QNAME, GetLastActive.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchToExistingProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "branchToExistingProject")
    public JAXBElement<BranchToExistingProject> createBranchToExistingProject(BranchToExistingProject value) {
        return new JAXBElement<BranchToExistingProject>(_BranchToExistingProject_QNAME, BranchToExistingProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLastActiveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLastActiveResponse")
    public JAXBElement<GetLastActiveResponse> createGetLastActiveResponse(GetLastActiveResponse value) {
        return new JAXBElement<GetLastActiveResponse>(_GetLastActiveResponse_QNAME, GetLastActiveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindClashesByGuidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "findClashesByGuidResponse")
    public JAXBElement<FindClashesByGuidResponse> createFindClashesByGuidResponse(FindClashesByGuidResponse value) {
        return new JAXBElement<FindClashesByGuidResponse>(_FindClashesByGuidResponse_QNAME, FindClashesByGuidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClashDetectionSettingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getClashDetectionSettingsResponse")
    public JAXBElement<GetClashDetectionSettingsResponse> createGetClashDetectionSettingsResponse(GetClashDetectionSettingsResponse value) {
        return new JAXBElement<GetClashDetectionSettingsResponse>(_GetClashDetectionSettingsResponse_QNAME, GetClashDetectionSettingsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByPoidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getProjectByPoidResponse")
    public JAXBElement<GetProjectByPoidResponse> createGetProjectByPoidResponse(GetProjectByPoidResponse value) {
        return new JAXBElement<GetProjectByPoidResponse>(_GetProjectByPoidResponse_QNAME, GetProjectByPoidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getSubProjects")
    public JAXBElement<GetSubProjects> createGetSubProjects(GetSubProjects value) {
        return new JAXBElement<GetSubProjects>(_GetSubProjects_QNAME, GetSubProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetExportTypeEnabledResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "setExportTypeEnabledResponse")
    public JAXBElement<SetExportTypeEnabledResponse> createSetExportTypeEnabledResponse(SetExportTypeEnabledResponse value) {
        return new JAXBElement<SetExportTypeEnabledResponse>(_SetExportTypeEnabledResponse_QNAME, SetExportTypeEnabledResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadProjects")
    public JAXBElement<DownloadProjects> createDownloadProjects(DownloadProjects value) {
        return new JAXBElement<DownloadProjects>(_DownloadProjects_QNAME, DownloadProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRevisionSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getRevisionSummary")
    public JAXBElement<GetRevisionSummary> createGetRevisionSummary(GetRevisionSummary value) {
        return new JAXBElement<GetRevisionSummary>(_GetRevisionSummary_QNAME, GetRevisionSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectsByTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectsByTypeResponse")
    public JAXBElement<GetDataObjectsByTypeResponse> createGetDataObjectsByTypeResponse(GetDataObjectsByTypeResponse value) {
        return new JAXBElement<GetDataObjectsByTypeResponse>(_GetDataObjectsByTypeResponse_QNAME, GetDataObjectsByTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllProjects")
    public JAXBElement<GetAllProjects> createGetAllProjects(GetAllProjects value) {
        return new JAXBElement<GetAllProjects>(_GetAllProjects_QNAME, GetAllProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addProject")
    public JAXBElement<AddProject> createAddProject(AddProject value) {
        return new JAXBElement<AddProject>(_AddProject_QNAME, AddProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckinAsyncResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkinAsyncResponse")
    public JAXBElement<CheckinAsyncResponse> createCheckinAsyncResponse(CheckinAsyncResponse value) {
        return new JAXBElement<CheckinAsyncResponse>(_CheckinAsyncResponse_QNAME, CheckinAsyncResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserHasCheckinRights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "userHasCheckinRights")
    public JAXBElement<UserHasCheckinRights> createUserHasCheckinRights(UserHasCheckinRights value) {
        return new JAXBElement<UserHasCheckinRights>(_UserHasCheckinRights_QNAME, UserHasCheckinRights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAuthorizedUsersOfProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllAuthorizedUsersOfProjectResponse")
    public JAXBElement<GetAllAuthorizedUsersOfProjectResponse> createGetAllAuthorizedUsersOfProjectResponse(GetAllAuthorizedUsersOfProjectResponse value) {
        return new JAXBElement<GetAllAuthorizedUsersOfProjectResponse>(_GetAllAuthorizedUsersOfProjectResponse_QNAME, GetAllAuthorizedUsersOfProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnonymousUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAnonymousUserResponse")
    public JAXBElement<GetAnonymousUserResponse> createGetAnonymousUserResponse(GetAnonymousUserResponse value) {
        return new JAXBElement<GetAnonymousUserResponse>(_GetAnonymousUserResponse_QNAME, GetAnonymousUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDatabaseInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDatabaseInformationResponse")
    public JAXBElement<GetDatabaseInformationResponse> createGetDatabaseInformationResponse(GetDatabaseInformationResponse value) {
        return new JAXBElement<GetDatabaseInformationResponse>(_GetDatabaseInformationResponse_QNAME, GetDatabaseInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGeoTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateGeoTagResponse")
    public JAXBElement<UpdateGeoTagResponse> createUpdateGeoTagResponse(UpdateGeoTagResponse value) {
        return new JAXBElement<UpdateGeoTagResponse>(_UpdateGeoTagResponse_QNAME, UpdateGeoTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGeoTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getGeoTag")
    public JAXBElement<GetGeoTag> createGetGeoTag(GetGeoTag value) {
        return new JAXBElement<GetGeoTag>(_GetGeoTag_QNAME, GetGeoTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExportTypeEnabled }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "isExportTypeEnabled")
    public JAXBElement<IsExportTypeEnabled> createIsExportTypeEnabled(IsExportTypeEnabled value) {
        return new JAXBElement<IsExportTypeEnabled>(_IsExportTypeEnabled_QNAME, IsExportTypeEnabled.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRevisionTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "setRevisionTagResponse")
    public JAXBElement<SetRevisionTagResponse> createSetRevisionTagResponse(SetRevisionTagResponse value) {
        return new JAXBElement<SetRevisionTagResponse>(_SetRevisionTagResponse_QNAME, SetRevisionTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getCurrentTokenResponse")
    public JAXBElement<GetCurrentTokenResponse> createGetCurrentTokenResponse(GetCurrentTokenResponse value) {
        return new JAXBElement<GetCurrentTokenResponse>(_GetCurrentTokenResponse_QNAME, GetCurrentTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "deleteProjectResponse")
    public JAXBElement<DeleteProjectResponse> createDeleteProjectResponse(DeleteProjectResponse value) {
        return new JAXBElement<DeleteProjectResponse>(_DeleteProjectResponse_QNAME, DeleteProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SDataObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sDataObject")
    public JAXBElement<SDataObject> createSDataObject(SDataObject value) {
        return new JAXBElement<SDataObject>(_SDataObject_QNAME, SDataObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Download }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "download")
    public JAXBElement<Download> createDownload(Download value) {
        return new JAXBElement<Download>(_Download_QNAME, Download.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllProjectsResponse")
    public JAXBElement<GetAllProjectsResponse> createGetAllProjectsResponse(GetAllProjectsResponse value) {
        return new JAXBElement<GetAllProjectsResponse>(_GetAllProjectsResponse_QNAME, GetAllProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsLoggedIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "isLoggedIn")
    public JAXBElement<IsLoggedIn> createIsLoggedIn(IsLoggedIn value) {
        return new JAXBElement<IsLoggedIn>(_IsLoggedIn_QNAME, IsLoggedIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadOfTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadOfTypeResponse")
    public JAXBElement<DownloadOfTypeResponse> createDownloadOfTypeResponse(DownloadOfTypeResponse value) {
        return new JAXBElement<DownloadOfTypeResponse>(_DownloadOfTypeResponse_QNAME, DownloadOfTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGeoTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateGeoTag")
    public JAXBElement<UpdateGeoTag> createUpdateGeoTag(UpdateGeoTag value) {
        return new JAXBElement<UpdateGeoTag>(_UpdateGeoTag_QNAME, UpdateGeoTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfProjectAndSubProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfProjectAndSubProjects")
    public JAXBElement<GetAllCheckoutsOfProjectAndSubProjects> createGetAllCheckoutsOfProjectAndSubProjects(GetAllCheckoutsOfProjectAndSubProjects value) {
        return new JAXBElement<GetAllCheckoutsOfProjectAndSubProjects>(_GetAllCheckoutsOfProjectAndSubProjects_QNAME, GetAllCheckoutsOfProjectAndSubProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfProjectAndSubProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfProjectAndSubProjectsResponse")
    public JAXBElement<GetAllCheckoutsOfProjectAndSubProjectsResponse> createGetAllCheckoutsOfProjectAndSubProjectsResponse(GetAllCheckoutsOfProjectAndSubProjectsResponse value) {
        return new JAXBElement<GetAllCheckoutsOfProjectAndSubProjectsResponse>(_GetAllCheckoutsOfProjectAndSubProjectsResponse_QNAME, GetAllCheckoutsOfProjectAndSubProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectByGuid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectByGuid")
    public JAXBElement<GetDataObjectByGuid> createGetDataObjectByGuid(GetDataObjectByGuid value) {
        return new JAXBElement<GetDataObjectByGuid>(_GetDataObjectByGuid_QNAME, GetDataObjectByGuid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReadableProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllReadableProjectsResponse")
    public JAXBElement<GetAllReadableProjectsResponse> createGetAllReadableProjectsResponse(GetAllReadableProjectsResponse value) {
        return new JAXBElement<GetAllReadableProjectsResponse>(_GetAllReadableProjectsResponse_QNAME, GetAllReadableProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccessMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAccessMethod")
    public JAXBElement<GetAccessMethod> createGetAccessMethod(GetAccessMethod value) {
        return new JAXBElement<GetAccessMethod>(_GetAccessMethod_QNAME, GetAccessMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAuthorizedUsersOfProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllAuthorizedUsersOfProject")
    public JAXBElement<GetAllAuthorizedUsersOfProject> createGetAllAuthorizedUsersOfProject(GetAllAuthorizedUsersOfProject value) {
        return new JAXBElement<GetAllAuthorizedUsersOfProject>(_GetAllAuthorizedUsersOfProject_QNAME, GetAllAuthorizedUsersOfProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckoutLastRevisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkoutLastRevisionResponse")
    public JAXBElement<CheckoutLastRevisionResponse> createCheckoutLastRevisionResponse(CheckoutLastRevisionResponse value) {
        return new JAXBElement<CheckoutLastRevisionResponse>(_CheckoutLastRevisionResponse_QNAME, CheckoutLastRevisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getRevision")
    public JAXBElement<GetRevision> createGetRevision(GetRevision value) {
        return new JAXBElement<GetRevision>(_GetRevision_QNAME, GetRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectByOid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectByOid")
    public JAXBElement<GetDataObjectByOid> createGetDataObjectByOid(GetDataObjectByOid value) {
        return new JAXBElement<GetDataObjectByOid>(_GetDataObjectByOid_QNAME, GetDataObjectByOid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadByGuids }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadByGuids")
    public JAXBElement<DownloadByGuids> createDownloadByGuids(DownloadByGuids value) {
        return new JAXBElement<DownloadByGuids>(_DownloadByGuids_QNAME, DownloadByGuids.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserHasCheckinRightsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "userHasCheckinRightsResponse")
    public JAXBElement<UserHasCheckinRightsResponse> createUserHasCheckinRightsResponse(UserHasCheckinRightsResponse value) {
        return new JAXBElement<UserHasCheckinRightsResponse>(_UserHasCheckinRightsResponse_QNAME, UserHasCheckinRightsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sProject")
    public JAXBElement<SProject> createSProject(SProject value) {
        return new JAXBElement<SProject>(_SProject_QNAME, SProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUoid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUserByUoid")
    public JAXBElement<GetUserByUoid> createGetUserByUoid(GetUserByUoid value) {
        return new JAXBElement<GetUserByUoid>(_GetUserByUoid_QNAME, GetUserByUoid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveLongActions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveLongActions")
    public JAXBElement<GetActiveLongActions> createGetActiveLongActions(GetActiveLongActions value) {
        return new JAXBElement<GetActiveLongActions>(_GetActiveLongActions_QNAME, GetActiveLongActions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadResponse")
    public JAXBElement<DownloadResponse> createDownloadResponse(DownloadResponse value) {
        return new JAXBElement<DownloadResponse>(_DownloadResponse_QNAME, DownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindClashesByEidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "findClashesByEidResponse")
    public JAXBElement<FindClashesByEidResponse> createFindClashesByEidResponse(FindClashesByEidResponse value) {
        return new JAXBElement<FindClashesByEidResponse>(_FindClashesByEidResponse_QNAME, FindClashesByEidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfRevision")
    public JAXBElement<GetAllCheckoutsOfRevision> createGetAllCheckoutsOfRevision(GetAllCheckoutsOfRevision value) {
        return new JAXBElement<GetAllCheckoutsOfRevision>(_GetAllCheckoutsOfRevision_QNAME, GetAllCheckoutsOfRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUserByUserNameResponse")
    public JAXBElement<GetUserByUserNameResponse> createGetUserByUserNameResponse(GetUserByUserNameResponse value) {
        return new JAXBElement<GetUserByUserNameResponse>(_GetUserByUserNameResponse_QNAME, GetUserByUserNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SClash }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sClash")
    public JAXBElement<SClash> createSClash(SClash value) {
        return new JAXBElement<SClash>(_SClash_QNAME, SClash.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Token }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "token")
    public JAXBElement<Token> createToken(Token value) {
        return new JAXBElement<Token>(_Token_QNAME, Token.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeleteProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "undeleteProject")
    public JAXBElement<UndeleteProject> createUndeleteProject(UndeleteProject value) {
        return new JAXBElement<UndeleteProject>(_UndeleteProject_QNAME, UndeleteProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SLogAction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sLogAction")
    public JAXBElement<SLogAction> createSLogAction(SLogAction value) {
        return new JAXBElement<SLogAction>(_SLogAction_QNAME, SLogAction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUserFromProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "removeUserFromProject")
    public JAXBElement<RemoveUserFromProject> createRemoveUserFromProject(RemoveUserFromProject value) {
        return new JAXBElement<RemoveUserFromProject>(_RemoveUserFromProject_QNAME, RemoveUserFromProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPasswordChange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "requestPasswordChange")
    public JAXBElement<RequestPasswordChange> createRequestPasswordChange(RequestPasswordChange value) {
        return new JAXBElement<RequestPasswordChange>(_RequestPasswordChange_QNAME, RequestPasswordChange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sRevision")
    public JAXBElement<SRevision> createSRevision(SRevision value) {
        return new JAXBElement<SRevision>(_SRevision_QNAME, SRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchToExistingProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "branchToExistingProjectResponse")
    public JAXBElement<BranchToExistingProjectResponse> createBranchToExistingProjectResponse(BranchToExistingProjectResponse value) {
        return new JAXBElement<BranchToExistingProjectResponse>(_BranchToExistingProjectResponse_QNAME, BranchToExistingProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNonAuthorizedUsersOfProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllNonAuthorizedUsersOfProject")
    public JAXBElement<GetAllNonAuthorizedUsersOfProject> createGetAllNonAuthorizedUsersOfProject(GetAllNonAuthorizedUsersOfProject value) {
        return new JAXBElement<GetAllNonAuthorizedUsersOfProject>(_GetAllNonAuthorizedUsersOfProject_QNAME, GetAllNonAuthorizedUsersOfProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsExportTypeEnabledResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "isExportTypeEnabledResponse")
    public JAXBElement<IsExportTypeEnabledResponse> createIsExportTypeEnabledResponse(IsExportTypeEnabledResponse value) {
        return new JAXBElement<IsExportTypeEnabledResponse>(_IsExportTypeEnabledResponse_QNAME, IsExportTypeEnabledResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getCurrentUser")
    public JAXBElement<GetCurrentUser> createGetCurrentUser(GetCurrentUser value) {
        return new JAXBElement<GetCurrentUser>(_GetCurrentUser_QNAME, GetCurrentUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "validateAccountResponse")
    public JAXBElement<ValidateAccountResponse> createValidateAccountResponse(ValidateAccountResponse value) {
        return new JAXBElement<ValidateAccountResponse>(_ValidateAccountResponse_QNAME, ValidateAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateProjectResponse")
    public JAXBElement<UpdateProjectResponse> createUpdateProjectResponse(UpdateProjectResponse value) {
        return new JAXBElement<UpdateProjectResponse>(_UpdateProjectResponse_QNAME, UpdateProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addProjectResponse")
    public JAXBElement<AddProjectResponse> createAddProjectResponse(AddProjectResponse value) {
        return new JAXBElement<AddProjectResponse>(_AddProjectResponse_QNAME, AddProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginAnonymousResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "loginAnonymousResponse")
    public JAXBElement<LoginAnonymousResponse> createLoginAnonymousResponse(LoginAnonymousResponse value) {
        return new JAXBElement<LoginAnonymousResponse>(_LoginAnonymousResponse_QNAME, LoginAnonymousResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableClasses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAvailableClasses")
    public JAXBElement<GetAvailableClasses> createGetAvailableClasses(GetAvailableClasses value) {
        return new JAXBElement<GetAvailableClasses>(_GetAvailableClasses_QNAME, GetAvailableClasses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UndeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "undeleteUserResponse")
    public JAXBElement<UndeleteUserResponse> createUndeleteUserResponse(UndeleteUserResponse value) {
        return new JAXBElement<UndeleteUserResponse>(_UndeleteUserResponse_QNAME, UndeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfProject")
    public JAXBElement<GetAllCheckoutsOfProject> createGetAllCheckoutsOfProject(GetAllCheckoutsOfProject value) {
        return new JAXBElement<GetAllCheckoutsOfProject>(_GetAllCheckoutsOfProject_QNAME, GetAllCheckoutsOfProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsByUser")
    public JAXBElement<GetAllCheckoutsByUser> createGetAllCheckoutsByUser(GetAllCheckoutsByUser value) {
        return new JAXBElement<GetAllCheckoutsByUser>(_GetAllCheckoutsByUser_QNAME, GetAllCheckoutsByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckinSync }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkinSync")
    public JAXBElement<CheckinSync> createCheckinSync(CheckinSync value) {
        return new JAXBElement<CheckinSync>(_CheckinSync_QNAME, CheckinSync.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUsersProjectsResponse")
    public JAXBElement<GetUsersProjectsResponse> createGetUsersProjectsResponse(GetUsersProjectsResponse value) {
        return new JAXBElement<GetUsersProjectsResponse>(_GetUsersProjectsResponse_QNAME, GetUsersProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRevisionsOfProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllRevisionsOfProjectResponse")
    public JAXBElement<GetAllRevisionsOfProjectResponse> createGetAllRevisionsOfProjectResponse(GetAllRevisionsOfProjectResponse value) {
        return new JAXBElement<GetAllRevisionsOfProjectResponse>(_GetAllRevisionsOfProjectResponse_QNAME, GetAllRevisionsOfProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRevisionSummaryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getRevisionSummaryResponse")
    public JAXBElement<GetRevisionSummaryResponse> createGetRevisionSummaryResponse(GetRevisionSummaryResponse value) {
        return new JAXBElement<GetRevisionSummaryResponse>(_GetRevisionSummaryResponse_QNAME, GetRevisionSummaryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SDataValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sDataValue")
    public JAXBElement<SDataValue> createSDataValue(SDataValue value) {
        return new JAXBElement<SDataValue>(_SDataValue_QNAME, SDataValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckinAsync }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkinAsync")
    public JAXBElement<CheckinAsync> createCheckinAsync(CheckinAsync value) {
        return new JAXBElement<CheckinAsync>(_CheckinAsync_QNAME, CheckinAsync.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectByOidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectByOidResponse")
    public JAXBElement<GetDataObjectByOidResponse> createGetDataObjectByOidResponse(GetDataObjectByOidResponse value) {
        return new JAXBElement<GetDataObjectByOidResponse>(_GetDataObjectByOidResponse_QNAME, GetDataObjectByOidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResultTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllResultTypes")
    public JAXBElement<GetAllResultTypes> createGetAllResultTypes(GetAllResultTypes value) {
        return new JAXBElement<GetAllResultTypes>(_GetAllResultTypes_QNAME, GetAllResultTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCheckout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sCheckout")
    public JAXBElement<SCheckout> createSCheckout(SCheckout value) {
        return new JAXBElement<SCheckout>(_SCheckout_QNAME, SCheckout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "ServerException")
    public JAXBElement<ServerException> createServerException(ServerException value) {
        return new JAXBElement<ServerException>(_ServerException_QNAME, ServerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResultTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllResultTypesResponse")
    public JAXBElement<GetAllResultTypesResponse> createGetAllResultTypesResponse(GetAllResultTypesResponse value) {
        return new JAXBElement<GetAllResultTypesResponse>(_GetAllResultTypesResponse_QNAME, GetAllResultTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Compare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "compare")
    public JAXBElement<Compare> createCompare(Compare value) {
        return new JAXBElement<Compare>(_Compare_QNAME, Compare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllReadableProjects }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllReadableProjects")
    public JAXBElement<GetAllReadableProjects> createGetAllReadableProjects(GetAllReadableProjects value) {
        return new JAXBElement<GetAllReadableProjects>(_GetAllReadableProjects_QNAME, GetAllReadableProjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeUserTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "changeUserTypeResponse")
    public JAXBElement<ChangeUserTypeResponse> createChangeUserTypeResponse(ChangeUserTypeResponse value) {
        return new JAXBElement<ChangeUserTypeResponse>(_ChangeUserTypeResponse_QNAME, ChangeUserTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCheckoutsOfRevisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllCheckoutsOfRevisionResponse")
    public JAXBElement<GetAllCheckoutsOfRevisionResponse> createGetAllCheckoutsOfRevisionResponse(GetAllCheckoutsOfRevisionResponse value) {
        return new JAXBElement<GetAllCheckoutsOfRevisionResponse>(_GetAllCheckoutsOfRevisionResponse_QNAME, GetAllCheckoutsOfRevisionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindClashesByGuid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "findClashesByGuid")
    public JAXBElement<FindClashesByGuid> createFindClashesByGuid(FindClashesByGuid value) {
        return new JAXBElement<FindClashesByGuid>(_FindClashesByGuid_QNAME, FindClashesByGuid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadProjectsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadProjectsResponse")
    public JAXBElement<DownloadProjectsResponse> createDownloadProjectsResponse(DownloadProjectsResponse value) {
        return new JAXBElement<DownloadProjectsResponse>(_DownloadProjectsResponse_QNAME, DownloadProjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEidClash }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sEidClash")
    public JAXBElement<SEidClash> createSEidClash(SEidClash value) {
        return new JAXBElement<SEidClash>(_SEidClash_QNAME, SEidClash.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeUserType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "changeUserType")
    public JAXBElement<ChangeUserType> createChangeUserType(ChangeUserType value) {
        return new JAXBElement<ChangeUserType>(_ChangeUserType_QNAME, ChangeUserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "validateAccount")
    public JAXBElement<ValidateAccount> createValidateAccount(ValidateAccount value) {
        return new JAXBElement<ValidateAccount>(_ValidateAccount_QNAME, ValidateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getProjectByName")
    public JAXBElement<GetProjectByName> createGetProjectByName(GetProjectByName value) {
        return new JAXBElement<GetProjectByName>(_GetProjectByName_QNAME, GetProjectByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRevisionsOfProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAllRevisionsOfProject")
    public JAXBElement<GetAllRevisionsOfProject> createGetAllRevisionsOfProject(GetAllRevisionsOfProject value) {
        return new JAXBElement<GetAllRevisionsOfProject>(_GetAllRevisionsOfProject_QNAME, GetAllRevisionsOfProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getLogs")
    public JAXBElement<GetLogs> createGetLogs(GetLogs value) {
        return new JAXBElement<GetLogs>(_GetLogs_QNAME, GetLogs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadByGuidsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadByGuidsResponse")
    public JAXBElement<DownloadByGuidsResponse> createDownloadByGuidsResponse(DownloadByGuidsResponse value) {
        return new JAXBElement<DownloadByGuidsResponse>(_DownloadByGuidsResponse_QNAME, DownloadByGuidsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getUserByUserName")
    public JAXBElement<GetUserByUserName> createGetUserByUserName(GetUserByUserName value) {
        return new JAXBElement<GetUserByUserName>(_GetUserByUserName_QNAME, GetUserByUserName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRevision }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateRevision")
    public JAXBElement<UpdateRevision> createUpdateRevision(UpdateRevision value) {
        return new JAXBElement<UpdateRevision>(_UpdateRevision_QNAME, UpdateRevision.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getCurrentUserResponse")
    public JAXBElement<GetCurrentUserResponse> createGetCurrentUserResponse(GetCurrentUserResponse value) {
        return new JAXBElement<GetCurrentUserResponse>(_GetCurrentUserResponse_QNAME, GetCurrentUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccessMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getAccessMethodResponse")
    public JAXBElement<GetAccessMethodResponse> createGetAccessMethodResponse(GetAccessMethodResponse value) {
        return new JAXBElement<GetAccessMethodResponse>(_GetAccessMethodResponse_QNAME, GetAccessMethodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataObjectByGuidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getDataObjectByGuidResponse")
    public JAXBElement<GetDataObjectByGuidResponse> createGetDataObjectByGuidResponse(GetDataObjectByGuidResponse value) {
        return new JAXBElement<GetDataObjectByGuidResponse>(_GetDataObjectByGuidResponse_QNAME, GetDataObjectByGuidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckinSyncResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "checkinSyncResponse")
    public JAXBElement<CheckinSyncResponse> createCheckinSyncResponse(CheckinSyncResponse value) {
        return new JAXBElement<CheckinSyncResponse>(_CheckinSyncResponse_QNAME, CheckinSyncResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SGuidClash }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "sGuidClash")
    public JAXBElement<SGuidClash> createSGuidClash(SGuidClash value) {
        return new JAXBElement<SGuidClash>(_SGuidClash_QNAME, SGuidClash.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadOfType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "downloadOfType")
    public JAXBElement<DownloadOfType> createDownloadOfType(DownloadOfType value) {
        return new JAXBElement<DownloadOfType>(_DownloadOfType_QNAME, DownloadOfType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getProjectByNameResponse")
    public JAXBElement<GetProjectByNameResponse> createGetProjectByNameResponse(GetProjectByNameResponse value) {
        return new JAXBElement<GetProjectByNameResponse>(_GetProjectByNameResponse_QNAME, GetProjectByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetActiveLongActionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getActiveLongActionsResponse")
    public JAXBElement<GetActiveLongActionsResponse> createGetActiveLongActionsResponse(GetActiveLongActionsResponse value) {
        return new JAXBElement<GetActiveLongActionsResponse>(_GetActiveLongActionsResponse_QNAME, GetActiveLongActionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addUserToProjectResponse")
    public JAXBElement<AddUserToProjectResponse> createAddUserToProjectResponse(AddUserToProjectResponse value) {
        return new JAXBElement<AddUserToProjectResponse>(_AddUserToProjectResponse_QNAME, AddUserToProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEnabledResultTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getEnabledResultTypesResponse")
    public JAXBElement<GetEnabledResultTypesResponse> createGetEnabledResultTypesResponse(GetEnabledResultTypesResponse value) {
        return new JAXBElement<GetEnabledResultTypesResponse>(_GetEnabledResultTypesResponse_QNAME, GetEnabledResultTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "UserException")
    public JAXBElement<UserException> createUserException(UserException value) {
        return new JAXBElement<UserException>(_UserException_QNAME, UserException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "compareResponse")
    public JAXBElement<CompareResponse> createCompareResponse(CompareResponse value) {
        return new JAXBElement<CompareResponse>(_CompareResponse_QNAME, CompareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserHasRights }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "userHasRights")
    public JAXBElement<UserHasRights> createUserHasRights(UserHasRights value) {
        return new JAXBElement<UserHasRights>(_UserHasRights_QNAME, UserHasRights.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShowCheckoutWarningResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "getShowCheckoutWarningResponse")
    public JAXBElement<GetShowCheckoutWarningResponse> createGetShowCheckoutWarningResponse(GetShowCheckoutWarningResponse value) {
        return new JAXBElement<GetShowCheckoutWarningResponse>(_GetShowCheckoutWarningResponse_QNAME, GetShowCheckoutWarningResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRevisionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shared.bimserver.org/", name = "updateRevisionResponse")
    public JAXBElement<UpdateRevisionResponse> createUpdateRevisionResponse(UpdateRevisionResponse value) {
        return new JAXBElement<UpdateRevisionResponse>(_UpdateRevisionResponse_QNAME, UpdateRevisionResponse.class, null, value);
    }

}
