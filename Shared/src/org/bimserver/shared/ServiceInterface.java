package org.bimserver.shared;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * Long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlMimeType;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SDeserializer;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SGuidanceProvider;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.SCompareResult.SCompareType;

//TODO: Document the rest of the interface
/**
 * This interface defines all functions that are made available via SOAP, but
 * also used by the JSP web interface
 */
@WebService(name = "soap")
@Path("/")
@Produces("application/xml")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface {
	@GET
	@Path("/ping")
	@Produces("application/text")
	@WebMethod(action = "ping")
	String ping(@QueryParam("in") @WebParam(name = "in", partName = "ping.in") String in);

	@GET
	@Path("/login")
	@Produces("application/xml")
	@WebMethod(action = "login")
	Boolean login(@QueryParam("username") @WebParam(name = "username", partName = "login.username") String username,
			@QueryParam("password") @WebParam(name = "password", partName = "login.password") String password) throws UserException,
			ServerException;

	@WebMethod(action = "autologin")
	Boolean autologin(@WebParam(name = "username", partName = "autologin.username") String username,
			@WebParam(name = "hash", partName = "autologin.hash") String hash) throws UserException, ServerException;

	@WebMethod(action = "checkinSync")
	SCheckinResult checkinSync(@WebParam(name = "poid", partName = "checkinSync.poid") Long poid,
			@WebParam(name = "comment", partName = "checkinSync.comment") String comment,
			@WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@WebParam(name = "ifcFile", partName = "checkinSync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@WebParam(name = "merge", partName = "checkinSync.merge") Boolean merge) throws UserException, ServerException;

	@WebMethod(action = "checkinAsync")
	SCheckinResult checkinAsync(@WebParam(name = "poid", partName = "checlinAsync.poid") Long poid,
			@WebParam(name = "comment", partName = "checkinAsync.comment") String comment,
			@WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@WebParam(name = "ifcFile", partName = "checkinAsync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@WebParam(name = "merge", partName = "checkinAsync.merge") Boolean merge) throws UserException, ServerException;

	@WebMethod(action = "checkout")
	Integer checkout(@WebParam(name = "roid", partName = "checkout.roid") Long roid,
			@WebParam(name = "formatIdentifier", partName = "checkout.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException, ServerException;

	@WebMethod(action = "checkoutLastRevision")
	Integer checkoutLastRevision(@QueryParam("poid") @WebParam(name = "poid", partName = "checkoutLastRevision.poid") Long poid,
			@QueryParam("resultType") @WebParam(name = "formatIdentifier", partName = "checkoutLastRevision.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException, ServerException;

	@GET
	@Path("/download")
	@Produces("application/xml")
	@WebMethod(action = "download")
	Integer download(@QueryParam("roid") @WebParam(name = "roid", partName = "download.roid") Long roid,
			@QueryParam("resultType") @WebParam(name = "formatIdentifier", partName = "download.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException, ServerException;

	@WebMethod(action = "downloadByOids")
	Integer downloadByOids(@WebParam(name = "roids", partName = "downloadByOids.roids") Set<Long> roids,
			@WebParam(name = "oids", partName = "downloadByOids.oids") Set<Long> oids,
			@WebParam(name = "formatIdentifier", partName = "downloadByOids.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException,
			ServerException;

	@WebMethod(action = "downloadOfType")
	Integer downloadOfType(@WebParam(name = "roid", partName = "downloadOfType.roid") Long roid,
			@WebParam(name = "className", partName = "downloadOfType.className") String className,
			@WebParam(name = "formatIdentifier", partName = "downloadOfType.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException,
			ServerException;

	@WebMethod(action = "downloadByGuids")
	Integer downloadByGuids(@WebParam(name = "roids", partName = "downloadByGuids.roids") Set<Long> roids,
			@WebParam(name = "guids", partName = "downloadByGuids.guids") Set<String> guids,
			@WebParam(name = "formatIdentifier", partName = "downloadByGuids.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException,
			ServerException;

	@WebMethod(action = "downloadProjects")
	Integer downloadProjects(@WebParam(name = "roids", partName = "downloadProjects.roids") Set<Long> roids,
			@WebParam(name = "formatIdentifier", partName = "downloadProjects.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws UserException,
			ServerException;

	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId)
			throws UserException, ServerException;

	@WebMethod(action = "getDownloadState")
	LongActionState getDownloadState(@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId)
			throws UserException, ServerException;

	@WebMethod(action = "addUser")
	Long addUser(@WebParam(name = "username", partName = "addUser.username") String username,
			@WebParam(name = "name", partName = "addUser.name") String name,
			@WebParam(name = "type", partName = "addUser.type") SUserType type,
			@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration) throws UserException,
			ServerException;

	@WebMethod(action = "changeUserType")
	void changeUserType(@WebParam(name = "uoid", partName = "changeUserType.uoid") Long uoid,
			@WebParam(name = "userType", partName = "changeUserType.userType") SUserType userType) throws UserException, ServerException;

	@WebMethod(action = "addProject")
	SProject addProject(@WebParam(name = "projectName", partName = "addProject.projectName") String projectName) throws UserException,
			ServerException;

	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(@WebParam(name = "projectName", partName = "addProjectAsSubProject.projectName") String projectName,
			@WebParam(name = "parentPoid", partName = "addProjectAsSubProject.parentPoid") Long parentPoid) throws UserException,
			ServerException;

	@WebMethod(action = "updateProject")
	void updateProject(@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws UserException,
			ServerException;

	@WebMethod(action = "updateRevision")
	void updateRevision(@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws UserException,
			ServerException;

	@WebMethod(action = "addUserToProject")
	Boolean addUserToProject(@WebParam(name = "uoid", partName = "addUserToProject.uoid") Long uoid,
			@WebParam(name = "poid", partName = "addUserToProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "removeUserFromProject")
	Boolean removeUserFromProject(@WebParam(name = "uoid", partName = "removeProjectFromUser.uoid") Long uoid,
			@WebParam(name = "poid", partName = "removeUserFromProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "deleteProject")
	Boolean deleteProject(@WebParam(name = "poid", partName = "deleteProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "deleteUser")
	Boolean deleteUser(@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws UserException, ServerException;

	@GET
	@Path("/getAllProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws UserException, ServerException;

	@GET
	@Path("/getAllReadableProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws UserException, ServerException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws UserException, ServerException;

	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces("application/xml")
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(
			@QueryParam("poid") @WebParam(name = "poid", partName = "getAllRevisionsOfProject.poid") Long poid) throws UserException,
			ServerException;

	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(@WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid)
			throws UserException, ServerException;

	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(@WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid)
			throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(@WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid)
			throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid)
			throws UserException, ServerException;

	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "getRevision")
	SRevision getRevision(@WebParam(name = "roid", partName = "getRevision.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws UserException, ServerException;

	@WebMethod(action = "getDatabaseInformation")
	DatabaseInformation getDatabaseInformation() throws UserException, ServerException;

	@WebMethod(action = "getLastDatabaseReset")
	Date getLastDatabaseReset() throws UserException, ServerException;

	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws UserException, ServerException;

	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid)
			throws UserException, ServerException;

	@WebMethod(action = "logout")
	void logout() throws UserException, ServerException;

	@WebMethod(action = "changePassword")
	Boolean changePassword(@WebParam(name = "uoid", partName = "changePassword.uoid") Long uoid,
			@WebParam(name = "oldPassword", partName = "changePassword.oldPassword") String oldPassword,
			@WebParam(name = "newPassword", partName = "changePassword.newPassword") String newPassword) throws UserException,
			ServerException;

	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws UserException,
			ServerException;

	@WebMethod(action = "undeleteProject")
	Boolean undeleteProject(@WebParam(name = "poid", partName = "undeleteProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws UserException, ServerException;

	@WebMethod(action = "compare")
	SCompareResult compare(@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
			@WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType, @WebParam(name = "sCompareIdentifier", partName = "compare.sCompareIdentifier") SCompareIdentifier sCompareIdentifier) throws UserException,
			ServerException;

	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws UserException,
			ServerException;

	@WebMethod(action = "userHasCheckinRights")
	Boolean userHasCheckinRights(@WebParam(name = "poid", partName = "userHasCheckinRights.poid") Long poid) throws UserException,
			ServerException;

	@WebMethod(action = "getShowCheckoutWarning")
	Set<String> getCheckoutWarnings(@WebParam(name = "poid", partName = "getShowCheckoutWarning.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "userHasRights")
	Boolean userHasRights(@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
			@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid,
			@WebParam(name = "className", partName = "getDataObjectByOid.className") String className) throws UserException,
			ServerException;

	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(@WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
			@WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws UserException, ServerException;

	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
			@WebParam(name = "className", partName = "getDataObjectsByType.className") String className) throws UserException,
			ServerException;

	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByGuid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByEid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(@WebParam(name = "roid", partName = "getLastClashes.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
			@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
			@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment) throws UserException, ServerException;

	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(@WebParam(name = "roid", partName = "branchToExistingProject.roid") Long roid,
			@WebParam(name = "destPoid", partName = "branchToExistingProject.destPoid") Long destPoid,
			@WebParam(name = "comment", partName = "branchToExistingProject.comment") String comment) throws UserException, ServerException;

	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws UserException, ServerException;

	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws UserException, ServerException;

	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(@WebParam(name = "cdsoid", partName = "getClashDetectionSettings.cdsoid") Long cdsoid)
			throws UserException, ServerException;

	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(
			@WebParam(name = "sClashDetectionSettings", partName = "updateClashDetectionSettings.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws UserException, ServerException;

	@WebMethod(action = "getAnonymousUser")
	SUser getAnonymousUser() throws UserException, ServerException;

	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid)
			throws UserException, ServerException;

	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid)
			throws UserException, ServerException;

	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws UserException,
			ServerException;

	@WebMethod(action = "getProjectsByName")
	List<SProject> getProjectsByName(@WebParam(name = "name", partName = "getProjectsByName.name") String name) throws UserException,
			ServerException;

	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
			@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws UserException, ServerException;

	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(@WebParam(name = "poid", partName = "getSubProjects.poid") Long poid) throws UserException,
			ServerException;

	@WebMethod(action = "setExportTypeEnabled")
	void setExportTypeEnabled(@WebParam(name = "resultTypeName", partName = "setExportTypeEnabled.resultTypeName") String resultTypeName,
			Boolean enabled) throws UserException, ServerException;

	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws UserException, ServerException;

	@WebMethod(action = "isLoggedIn")
	Boolean isLoggedIn() throws UserException, ServerException;

	@WebMethod(action = "loginAnonymous")
	void loginAnonymous() throws UserException, ServerException;

	@WebMethod(action = "getActiveSince")
	Date getActiveSince() throws UserException, ServerException;

	@WebMethod(action = "getLastActive")
	Date getLastActive() throws UserException, ServerException;

	@WebMethod(action = "getCurrentToken")
	Token getCurrentToken() throws UserException, ServerException;

	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws UserException,
			ServerException;

	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(@WebParam(name = "uoid", partName = "requestPasswordChange.uoid") Long uoid) throws UserException,
			ServerException;

	@WebMethod(action = "validateAccount")
	void validateAccount(@WebParam(name = "uoid", partName = "validateAccount.uoid") Long uoid,
			@WebParam(name = "token", partName = "validateAccount.token") String token,
			@WebParam(name = "password", partName = "validateAccount.password") String password) throws UserException, ServerException;

	@WebMethod(action = "sendClashesEmail")
	void sendClashesEmail(
			@WebParam(name = "sClashDetectionSettings", partName = "sendClashesEmail.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "addressesTo", partName = "sendClashesEmail.addressesTo") Set<String> addressesTo) throws UserException,
			ServerException;

	@WebMethod(action = "sendCompareEmail")
	void sendCompareEmail(
			@WebParam(name = "sCompareType", partName = "sendClashesEmail.sCompareType") SCompareType sCompareType,
			@WebParam(name = "sCompareIdentifier", partName = "sendClashesEmail.sCompareIdentifier") SCompareIdentifier sCompareIdentifier,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
			@WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws UserException, ServerException;
	
	@WebMethod(action = "setup")
	void setup(@WebParam(name = "siteAddress", partName = "setup.siteAddress") String siteAddress,
			@WebParam(name = "smtpServer", partName = "setup.smtpServer") String smtpServer,
			@WebParam(name = "adminName", partName = "setup.adminName") String adminName,
			@WebParam(name = "adminUsername", partName = "setup.adminUsername") String adminUsername,
			@WebParam(name = "adminPassword", partName = "setup.adminPassword") String adminPassword,
			@WebParam(name = "createAnonymousUser", partName = "setup.createAnonymousUser") Boolean createAnonymousUser) throws UserException, ServerException;

	@WebMethod(action = "getSettingsCustomLogoAddress")
	String getSettingCustomLogoAddress() throws UserException, ServerException;

	@WebMethod(action = "getSettingHeaderAddition")
	String getSettingHeaderAddition() throws UserException, ServerException;

	@WebMethod(action = "getSettingFooterAddition")
	String getSettingFooterAddition() throws UserException, ServerException;

	@WebMethod(action = "setSettingsCustomLogoAddress")
	void setSettingCustomLogoAddress(
			@WebParam(name = "customLogoAddress", partName = "setSettingsCustomLogoAddress.customLogoAddress") String customLogoAddress)
			throws UserException, ServerException;

	@WebMethod(action = "setSettingHeaderAddition")
	void setSettingHeaderAddition (
			@WebParam(name = "headerAddition", partName = "setSettingHeaderAddition.headerAddition") String headerAddition)
			throws UserException, ServerException;

	@WebMethod(action = "setSettingFooterAddition")
	void setSettingFooterAddition(
			@WebParam(name = "footerAddition", partName = "setSettingFooterAddition.footerAddition") String footerAddition)
			throws UserException, ServerException;

	@WebMethod(action = "setSettingMergeIdentifier")
	void setSettingMergeIdentifier(
			@WebParam(name = "mergeIdentifier", partName = "setSettingMergeIdentifier.mergeIdentifier") SMergeIdentifier mergeIdentifier)
			throws UserException, ServerException;

	@WebMethod(action = "getSettingsEmailSenderAddress")
	String getSettingEmailSenderAddress() throws UserException, ServerException;

	@WebMethod(action = "setSettingsEmailSenderAddress")
	void setSettingEmailSenderAddress(
			@WebParam(name = "emailSenderAddress", partName = "setSettingsEmailSenderAddress.emailSenderAddress") String emailSenderAddress)
			throws UserException, ServerException;

	@WebMethod(action = "getSettingsEnabledExportTypes")
	String getSettingEnabledExportTypes() throws UserException, ServerException;

	@WebMethod(action = "setSettingsEnabledExportTypes")
	void setSettingEnabledExportTypes(
			@WebParam(name = "enabledExportTypeNames", partName = "setSettingsEnabledExportTypes.enabledExportTypeNames") Set<String> enabledExportTypeNames)
			throws UserException, ServerException;

	@WebMethod(action = "getSettingsRegistrationAddition")
	String getSettingRegistrationAddition() throws UserException, ServerException;

	@WebMethod(action = "setSettingsRegistrationAddition")
	void setSettingRegistrationAddition(
			@WebParam(name = "registrationAddition", partName = "setSettingsRegistrationAddition.registrationAddition") String registrationAddition)
			throws UserException, ServerException;

	@WebMethod(action = "getSettingsSiteAddress")
	String getSettingSiteAddress() throws UserException, ServerException;

	@WebMethod(action = "setSettingsSiteAddress")
	void setSettingSiteAddress(@WebParam(name = "siteAddress", partName = "setSettingsSiteAddress.siteAddress") String siteAddress)
			throws UserException, ServerException;

	@WebMethod(action = "getSettingsSmtpServer")
	String getSettingSmtpServer() throws UserException, ServerException;

	@WebMethod(action = "setSettingsSmtpServer")
	void setSettingSmtpServer(@WebParam(name = "smtpServer", partName = "setSettingsSmtpServer.smtpServer") String smtpServer)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingAllowSelfRegistration")
	Boolean isSettingAllowSelfRegistration() throws UserException, ServerException;

	@WebMethod(action = "setSettingAllowSelfRegistration")
	void setSettingAllowSelfRegistration(
			@WebParam(name = "allowSelfRegistration", partName = "setSettingAllowSelfRegistration.allowSelfRegistration") Boolean allowSelfRegistration)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingAllowUsersToCreateTopLevelProjects")
	Boolean isSettingAllowUsersToCreateTopLevelProjects() throws UserException, ServerException;

	@WebMethod(action = "setSettingAllowUsersToCreateTopLevelProjects")
	void setSettingAllowUsersToCreateTopLevelProjects(
			@WebParam(name = "allowUsersToCreateTopLevelProjects", partName = "setSettingAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects") Boolean allowUsersToCreateTopLevelProjects)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingAutoTestClashes")
	Boolean isSettingAutoTestClashes() throws UserException, ServerException;

	@WebMethod(action = "setSettingAutoTestClashes")
	void setSettingAutoTestClashes(
			@WebParam(name = "autoTestClashes", partName = "setSettingAutoTestClashes.autoTestClashes") Boolean autoTestClashes)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingCheckinMergingEnabled")
	Boolean isSettingCheckinMergingEnabled() throws UserException, ServerException;

	@WebMethod(action = "setSettingCheckinMergingEnabled")
	void setSettingCheckinMergingEnabled(
			@WebParam(name = "checkinMergingEnabled", partName = "setSettingCheckinMergingEnabled.checkinMergingEnabled") Boolean checkinMergingEnabled)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingIntelligentMerging")
	Boolean isSettingIntelligentMerging() throws UserException, ServerException;

	@WebMethod(action = "setSettingIntelligentMerging")
	void setSettingIntelligentMerging(
			@WebParam(name = "intelligentMerging", partName = "setSettingIntelligentMerging.intelligentMerging") Boolean intelligentMerging)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingSendConfirmationEmailAfterRegistration")
	Boolean isSettingSendConfirmationEmailAfterRegistration() throws UserException, ServerException;

	@WebMethod(action = "setSettingSendConfirmationEmailAfterRegistration")
	void setSettingSendConfirmationEmailAfterRegistration(
			@WebParam(name = "sendConfirmationEmailAfterRegistration", partName = "setSettingSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration") Boolean sendConfirmationEmailAfterRegistration)
			throws UserException, ServerException;

	@WebMethod(action = "isSettingShowVersionUpgradeAvailable")
	Boolean isSettingShowVersionUpgradeAvailable() throws UserException, ServerException;

	@WebMethod(action = "setSettingShowVersionUpgradeAvailable")
	void setSettingShowVersionUpgradeAvailable(
			@WebParam(name = "showVersionUpgradeAvailable", partName = "setSettingShowVersionUpgradeAvailable.showVersionUpgradeAvailable") Boolean showVersionUpgradeAvailable)
			throws UserException, ServerException;

	@WebMethod(action = "isCacheOutputFiles")
	Boolean isSettingCacheOutputFiles() throws UserException, ServerException;

	@WebMethod(action = "setCacheOutputFiles")
	void setSettingCacheOutputFiles(@WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles)
			throws UserException, ServerException;
	
	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws UserException, ServerException;

	@WebMethod(action = "getActiveUserSessions")
	List<SUserSession> getActiveUserSessions() throws ServerException, ServiceException;

	@WebMethod(action = "getActiveLongActions")
	List<SLongAction> getActiveLongActions() throws ServerException, ServiceException;

	@WebMethod(action = "getPendingMigrations")
	Set<SMigration> getMigrations() throws UserException;

	@WebMethod(action = "migrateDatabase")
	void migrateDatabase() throws ServerException, UserException;

	@WebMethod(action = "getAllSerializers")
	List<SSerializer> getAllSerializers(Boolean onlyEnabled) throws UserException, ServerException;
	
	@WebMethod(action = "getEnabledSerializers")
	List<SSerializer> getEnabledSerializers() throws UserException, ServerException;

	@WebMethod(action = "getEnabledSerializers")
	List<SDeserializer> getEnabledDeserializers() throws UserException, ServerException;
	
	@WebMethod(action = "getSerializerById")
	SSerializer getSerializerById(Long oid) throws UserException, ServerException;
	
	@WebMethod(action = "addSerializer")
	void addSerializer(SSerializer serializer) throws UserException, ServerException;
	
	@WebMethod(action = "updateSerializer")
	void updateSerializer(SSerializer serializer) throws UserException, ServerException;
	
	@WebMethod(action = "getAllGuidanceProviders")
	List<SGuidanceProvider> getAllGuidanceProviders() throws UserException, ServerException;
	
	@WebMethod(action = "getGuidanceProviderById")
	SGuidanceProvider getGuidanceProviderById(Long oid) throws UserException, ServerException;
	
	@WebMethod(action = "addGuidanceProvider")
	void addGuidanceProvider(SGuidanceProvider guidanceProvider) throws UserException, ServerException;
	
	@WebMethod(action = "updateGuidanceProvider")
	void updateGuidanceProvider(SGuidanceProvider guidanceProvider) throws UserException, ServerException;
	
	@WebMethod(action = "deleteGuidanceProvider")
	void deleteGuidanceProvider(Long ifid) throws UserException, ServerException;

	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(Long sid) throws UserException, ServerException;
	
	@WebMethod(action = "getAllSerializerClassNames")
	Set<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException;

	@WebMethod(action = "getSettingMergeIdentifier")
	SMergeIdentifier getSettingMergeIdentifier() throws UserException,
			ServerException;

	@WebMethod(action = "getSerializerByName")
	SSerializer getSerializerByName(
			@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws UserException, ServerException;
	
	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(String contentType) throws UserException, ServerException;
	
	@WebMethod(action = "getAllPlugins")
	List<SPlugin> getAllPlugins() throws UserException;
	
	@WebMethod(action = "enablePlugin")
	void enablePlugin(String name) throws UserException;
	
	@WebMethod(action = "disablePlugin")
	void disablePlugin(String name) throws UserException;

	@WebMethod(action = "getSerializerByContentType")
	SSerializer getSerializerByContentType(
			@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws UserException, ServerException;
	
	@WebMethod(action = "startTransaction")
	void startTransaction(
			@WebParam(name = "pid", partName = "startTransaction.pid") Integer pid) throws UserException;

	@WebMethod(action = "commitTransaction")
	Long commitTransaction() throws UserException;
	
	@WebMethod(action = "abortTransaction")
	void abortTransaction() throws UserException;
	
	@WebMethod(action = "createObject")
	Long createObject(
			@WebParam(name = "className", partName = "createObject.className") String className) throws UserException;
	
	@WebMethod(action = "removeObject")
	void removeObject(
			@WebParam(name = "className", partName = "removeObject.className") String className, 
			@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws UserException;
	
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
			@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws UserException;
	
	@WebMethod(action = "setFloatAttribute")
	void setFloatAttribute(
			@WebParam(name = "oid", partName = "setFloatAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setFloatAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setFloatAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setFloatAttribute.value") float value) throws UserException;

	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
			@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws UserException;

	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
			@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws UserException;

	@WebMethod(action = "setReference")
	void setReference(
			@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
			@WebParam(name = "className", partName = "setReference.className") String className, 
			@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid, 
			@WebParam(name = "referenceClassName", partName = "setReference.referenceClassName") String referenceClassName) throws UserException;
	
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
			@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "unsetAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws UserException;
	
	@WebMethod(action = "unsetReference")
	void unsetReference(
			@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
			@WebParam(name = "className", partName = "unsetReference.className") String className,
			@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws UserException;
	
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
			@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws UserException;

	@WebMethod(action = "addFloatAttribute")
	void addFloatAttribute(
			@WebParam(name = "oid", partName = "addFloatAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addFloatAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addFloatAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addFloatAttribute.value") float value) throws UserException;

	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
			@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws UserException;

	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
			@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws UserException;

	@WebMethod(action = "addReference")
	void addReference(
			@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
			@WebParam(name = "className", partName = "addReference.className") String className, 
			@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid,
			@WebParam(name = "referenceClassName", partName = "addReference.referenceClassName") String referenceClassName) throws UserException;
	
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
			@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "removeAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
			@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws UserException;
	
	@WebMethod(action = "removeReference")
	void removeReference(
			@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
			@WebParam(name = "className", partName = "removeReference.className") String className, 
			@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
			@WebParam(name = "index", partName = "removeReference.index") Integer index) throws UserException;
	
	@WebMethod(action = "getServerStartTime")
	Date getServerStartTime();
	
	SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException;
	
	Set<SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws UserException;

	List<SDeserializer> getAllDeserializers(Boolean onlyEnabled) throws UserException, ServerException;
}