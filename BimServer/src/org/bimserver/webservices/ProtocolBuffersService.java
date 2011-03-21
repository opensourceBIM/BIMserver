package org.bimserver.webservices;

import org.bimserver.pb.Service.*;
import org.bimserver.pb.Service.Void;
import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public class ProtocolBuffersService implements BlockingInterface {

	@Override
	public AddProjectResponse addProject(RpcController controller, AddProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddProjectAsSubProjectResponse addProjectAsSubProject(RpcController controller, AddProjectAsSubProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddUserResponse addUser(RpcController controller, AddUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddUserToProjectResponse addUserToProject(RpcController controller, AddUserToProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutologinResponse autologin(RpcController controller, AutologinRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BranchToExistingProjectResponse branchToExistingProject(RpcController controller, BranchToExistingProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BranchToNewProjectResponse branchToNewProject(RpcController controller, BranchToNewProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChangePasswordResponse changePassword(RpcController controller, ChangePasswordRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void changeUserType(RpcController controller, ChangeUserTypeRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckinAsyncResponse checkinAsync(RpcController controller, CheckinAsyncRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckinSyncResponse checkinSync(RpcController controller, CheckinSyncRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckoutResponse checkout(RpcController controller, CheckoutRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckoutLastRevisionResponse checkoutLastRevision(RpcController controller, CheckoutLastRevisionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompareResponse compare(RpcController controller, CompareRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteProjectResponse deleteProject(RpcController controller, DeleteProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteUserResponse deleteUser(RpcController controller, DeleteUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadResponse download(RpcController controller, DownloadRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadByGuidsResponse downloadByGuids(RpcController controller, DownloadByGuidsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadByOidsResponse downloadByOids(RpcController controller, DownloadByOidsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadOfTypeResponse downloadOfType(RpcController controller, DownloadOfTypeRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DownloadProjectsResponse downloadProjects(RpcController controller, DownloadProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindClashesByEidResponse findClashesByEid(RpcController controller, FindClashesByEidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindClashesByGuidResponse findClashesByGuid(RpcController controller, FindClashesByGuidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAccessMethodResponse getAccessMethod(RpcController controller, GetAccessMethodRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetActiveLongActionsResponse getActiveLongActions(RpcController controller, GetActiveLongActionsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetActiveSinceResponse getActiveSince(RpcController controller, GetActiveSinceRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetActiveUserSessionsResponse getActiveUserSessions(RpcController controller, GetActiveUserSessionsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllAuthorizedUsersOfProjectResponse getAllAuthorizedUsersOfProject(RpcController controller, GetAllAuthorizedUsersOfProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllCheckoutsByUserResponse getAllCheckoutsByUser(RpcController controller, GetAllCheckoutsByUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllCheckoutsOfProjectResponse getAllCheckoutsOfProject(RpcController controller, GetAllCheckoutsOfProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllCheckoutsOfProjectAndSubProjectsResponse getAllCheckoutsOfProjectAndSubProjects(RpcController controller, GetAllCheckoutsOfProjectAndSubProjectsRequest request)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllCheckoutsOfRevisionResponse getAllCheckoutsOfRevision(RpcController controller, GetAllCheckoutsOfRevisionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllNonAuthorizedProjectsOfUserResponse getAllNonAuthorizedProjectsOfUser(RpcController controller, GetAllNonAuthorizedProjectsOfUserRequest request)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllNonAuthorizedUsersOfProjectResponse getAllNonAuthorizedUsersOfProject(RpcController controller, GetAllNonAuthorizedUsersOfProjectRequest request)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllProjectsResponse getAllProjects(RpcController controller, GetAllProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllReadableProjectsResponse getAllReadableProjects(RpcController controller, GetAllReadableProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllResultTypesResponse getAllResultTypes(RpcController controller, GetAllResultTypesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllRevisionsByUserResponse getAllRevisionsByUser(RpcController controller, GetAllRevisionsByUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllRevisionsOfProjectResponse getAllRevisionsOfProject(RpcController controller, GetAllRevisionsOfProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAllUsersResponse getAllUsers(RpcController controller, GetAllUsersRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAnonymousUserResponse getAnonymousUser(RpcController controller, GetAnonymousUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAvailableClassesResponse getAvailableClasses(RpcController controller, GetAvailableClassesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetClashDetectionSettingsResponse getClashDetectionSettings(RpcController controller, GetClashDetectionSettingsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCurrentTokenResponse getCurrentToken(RpcController controller, GetCurrentTokenRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCurrentUserResponse getCurrentUser(RpcController controller, GetCurrentUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDataObjectByGuidResponse getDataObjectByGuid(RpcController controller, GetDataObjectByGuidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDataObjectByOidResponse getDataObjectByOid(RpcController controller, GetDataObjectByOidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDataObjectsByTypeResponse getDataObjectsByType(RpcController controller, GetDataObjectsByTypeRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDatabaseInformationResponse getDatabaseInformation(RpcController controller, GetDatabaseInformationRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDownloadDataResponse getDownloadData(RpcController controller, GetDownloadDataRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetDownloadStateResponse getDownloadState(RpcController controller, GetDownloadStateRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetEnabledResultTypesResponse getEnabledResultTypes(RpcController controller, GetEnabledResultTypesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetGeoTagResponse getGeoTag(RpcController controller, GetGeoTagRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLastActiveResponse getLastActive(RpcController controller, GetLastActiveRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLastClashesResponse getLastClashes(RpcController controller, GetLastClashesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLastDatabaseResetResponse getLastDatabaseReset(RpcController controller, GetLastDatabaseResetRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLoggedInUserResponse getLoggedInUser(RpcController controller, GetLoggedInUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetLogsResponse getLogs(RpcController controller, GetLogsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetMigrationsResponse getMigrations(RpcController controller, GetMigrationsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetProjectByNameResponse getProjectByName(RpcController controller, GetProjectByNameRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetProjectByPoidResponse getProjectByPoid(RpcController controller, GetProjectByPoidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRevisionResponse getRevision(RpcController controller, GetRevisionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRevisionSummaryResponse getRevisionSummary(RpcController controller, GetRevisionSummaryRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingCustomLogoAddressResponse getSettingCustomLogoAddress(RpcController controller, GetSettingCustomLogoAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingEmailSenderAddressResponse getSettingEmailSenderAddress(RpcController controller, GetSettingEmailSenderAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingEnabledExportTypesResponse getSettingEnabledExportTypes(RpcController controller, GetSettingEnabledExportTypesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingRegistrationAdditionResponse getSettingRegistrationAddition(RpcController controller, GetSettingRegistrationAdditionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingSiteAddressResponse getSettingSiteAddress(RpcController controller, GetSettingSiteAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSettingSmtpServerResponse getSettingSmtpServer(RpcController controller, GetSettingSmtpServerRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetShowCheckoutWarningResponse getShowCheckoutWarning(RpcController controller, GetShowCheckoutWarningRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSubProjectsResponse getSubProjects(RpcController controller, GetSubProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUserByUoidResponse getUserByUoid(RpcController controller, GetUserByUoidRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUserByUserNameResponse getUserByUserName(RpcController controller, GetUserByUserNameRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetUsersProjectsResponse getUsersProjects(RpcController controller, GetUsersProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsExportTypeEnabledResponse isExportTypeEnabled(RpcController controller, IsExportTypeEnabledRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsLoggedInResponse isLoggedIn(RpcController controller, IsLoggedInRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingAllowSelfRegistrationResponse isSettingAllowSelfRegistration(RpcController controller, IsSettingAllowSelfRegistrationRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingAllowUsersToCreateTopLevelProjectsResponse isSettingAllowUsersToCreateTopLevelProjects(RpcController controller,
			IsSettingAllowUsersToCreateTopLevelProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingAutoTestClashesResponse isSettingAutoTestClashes(RpcController controller, IsSettingAutoTestClashesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingCheckinMergingEnabledResponse isSettingCheckinMergingEnabled(RpcController controller, IsSettingCheckinMergingEnabledRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingIntelligentMergingResponse isSettingIntelligentMerging(RpcController controller, IsSettingIntelligentMergingRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingSendConfirmationEmailAfterRegistrationResponse isSettingSendConfirmationEmailAfterRegistration(RpcController controller,
			IsSettingSendConfirmationEmailAfterRegistrationRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingShowVersionUpgradeAvailableResponse isSettingShowVersionUpgradeAvailable(RpcController controller, IsSettingShowVersionUpgradeAvailableRequest request)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IsSettingUseCachingResponse isSettingUseCaching(RpcController controller, IsSettingUseCachingRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginResponse login(RpcController controller, LoginRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void loginAnonymous(RpcController controller, LoginAnonymousRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void logout(RpcController controller, LogoutRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void migrateDatabase(RpcController controller, MigrateDatabaseRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PingResponse ping(RpcController controller, PingRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemoveUserFromProjectResponse removeUserFromProject(RpcController controller, RemoveUserFromProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void requestPasswordChange(RpcController controller, RequestPasswordChangeRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void sendClashesEmail(RpcController controller, SendClashesEmailRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void sendCompareEmail(RpcController controller, SendCompareEmailRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setExportTypeEnabled(RpcController controller, SetExportTypeEnabledRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setRevisionTag(RpcController controller, SetRevisionTagRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingAllowSelfRegistration(RpcController controller, SetSettingAllowSelfRegistrationRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingAllowUsersToCreateTopLevelProjects(RpcController controller, SetSettingAllowUsersToCreateTopLevelProjectsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingAutoTestClashes(RpcController controller, SetSettingAutoTestClashesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingCheckinMergingEnabled(RpcController controller, SetSettingCheckinMergingEnabledRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingCustomLogoAddress(RpcController controller, SetSettingCustomLogoAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingEmailSenderAddress(RpcController controller, SetSettingEmailSenderAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingEnabledExportTypes(RpcController controller, SetSettingEnabledExportTypesRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingIntelligentMerging(RpcController controller, SetSettingIntelligentMergingRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingRegistrationAddition(RpcController controller, SetSettingRegistrationAdditionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingSendConfirmationEmailAfterRegistration(RpcController controller, SetSettingSendConfirmationEmailAfterRegistrationRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingShowVersionUpgradeAvailable(RpcController controller, SetSettingShowVersionUpgradeAvailableRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingSiteAddress(RpcController controller, SetSettingSiteAddressRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingSmtpServer(RpcController controller, SetSettingSmtpServerRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setSettingUseCaching(RpcController controller, SetSettingUseCachingRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void setup(RpcController controller, SetupRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UndeleteProjectResponse undeleteProject(RpcController controller, UndeleteProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UndeleteUserResponse undeleteUser(RpcController controller, UndeleteUserRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void updateClashDetectionSettings(RpcController controller, UpdateClashDetectionSettingsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void updateGeoTag(RpcController controller, UpdateGeoTagRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void updateProject(RpcController controller, UpdateProjectRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void updateRevision(RpcController controller, UpdateRevisionRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserHasCheckinRightsResponse userHasCheckinRights(RpcController controller, UserHasCheckinRightsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserHasRightsResponse userHasRights(RpcController controller, UserHasRightsRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void validateAccount(RpcController controller, ValidateAccountRequest request) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
