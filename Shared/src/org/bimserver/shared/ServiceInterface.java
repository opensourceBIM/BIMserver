package org.bimserver.shared;

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
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SCompareIdentifier;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SCompileResult;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SDeserializer;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SGuidanceProvider;
import org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SMergeIdentifier;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SRunResult;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSession;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.shared.exceptions.ServiceException;

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
	String ping(@QueryParam("in") @WebParam(name = "in", partName = "ping.in") String in) throws ServiceException;

	@GET
	@Path("/login")
	@Produces("application/xml")
	@WebMethod(action = "login")
	Boolean login(@QueryParam("username") @WebParam(name = "username", partName = "login.username") String username,
			@QueryParam("password") @WebParam(name = "password", partName = "login.password") String password) throws ServiceException;

	@WebMethod(action = "autologin")
	Boolean autologin(@WebParam(name = "username", partName = "autologin.username") String username,
			@WebParam(name = "hash", partName = "autologin.hash") String hash) throws ServiceException;

	@WebMethod(action = "checkinSync")
	SCheckinResult checkinSync(@WebParam(name = "poid", partName = "checkinSync.poid") Long poid,
			@WebParam(name = "comment", partName = "checkinSync.comment") String comment,
			@WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@WebParam(name = "ifcFile", partName = "checkinSync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@WebParam(name = "merge", partName = "checkinSync.merge") Boolean merge) throws ServiceException;

	@WebMethod(action = "checkinAsync")
	SCheckinResult checkinAsync(@WebParam(name = "poid", partName = "checlinAsync.poid") Long poid,
			@WebParam(name = "comment", partName = "checkinAsync.comment") String comment,
			@WebParam(name = "deserializerName", partName = "checkinSync.deserializerName") String deserializerName,
			@WebParam(name = "fileSize", partName = "checkinSync.fileSize") Long fileSize,
			@WebParam(name = "ifcFile", partName = "checkinAsync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile,
			@WebParam(name = "merge", partName = "checkinAsync.merge") Boolean merge) throws ServiceException;

	@WebMethod(action = "checkout")
	Integer checkout(@WebParam(name = "roid", partName = "checkout.roid") Long roid,
			@WebParam(name = "formatIdentifier", partName = "checkout.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "checkoutLastRevision")
	Integer checkoutLastRevision(@QueryParam("poid") @WebParam(name = "poid", partName = "checkoutLastRevision.poid") Long poid,
			@QueryParam("resultType") @WebParam(name = "formatIdentifier", partName = "checkoutLastRevision.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@GET
	@Path("/download")
	@Produces("application/xml")
	@WebMethod(action = "download")
	Integer download(@QueryParam("roid") @WebParam(name = "roid", partName = "download.roid") Long roid,
			@QueryParam("resultType") @WebParam(name = "formatIdentifier", partName = "download.serializerName") String serializerName,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "downloadByOids")
	Integer downloadByOids(@WebParam(name = "roids", partName = "downloadByOids.roids") Set<Long> roids,
			@WebParam(name = "oids", partName = "downloadByOids.oids") Set<Long> oids,
			@WebParam(name = "formatIdentifier", partName = "downloadByOids.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "downloadOfType")
	Integer downloadOfType(@WebParam(name = "roid", partName = "downloadOfType.roid") Long roid,
			@WebParam(name = "className", partName = "downloadOfType.className") String className,
			@WebParam(name = "formatIdentifier", partName = "downloadOfType.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "downloadByGuids")
	Integer downloadByGuids(@WebParam(name = "roids", partName = "downloadByGuids.roids") Set<Long> roids,
			@WebParam(name = "guids", partName = "downloadByGuids.guids") Set<String> guids,
			@WebParam(name = "formatIdentifier", partName = "downloadByGuids.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "downloadProjects")
	Integer downloadProjects(@WebParam(name = "roids", partName = "downloadProjects.roids") Set<Long> roids,
			@WebParam(name = "formatIdentifier", partName = "downloadProjects.formatIdentifier") String formatIdentifier,
			@QueryParam("sync") @WebParam(name = "sync", partName = "download.sync") Boolean sync) throws ServiceException;

	@WebMethod(action = "getDownloadData")
	SDownloadResult getDownloadData(@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId)
			throws ServiceException;

	@WebMethod(action = "getDownloadState")
	SLongActionState getDownloadState(@WebParam(name = "actionID", partName = "downloadProjects.actionID") Integer actionId)
			throws ServiceException;

	@WebMethod(action = "addUser")
	Long addUser(@WebParam(name = "username", partName = "addUser.username") String username,
			@WebParam(name = "name", partName = "addUser.name") String name,
			@WebParam(name = "type", partName = "addUser.type") SUserType type,
			@WebParam(name = "selfRegistration", partName = "addUser.selfRegistration") Boolean selfRegistration) throws ServiceException;

	@WebMethod(action = "changeUserType")
	void changeUserType(@WebParam(name = "uoid", partName = "changeUserType.uoid") Long uoid,
			@WebParam(name = "userType", partName = "changeUserType.userType") SUserType userType) throws ServiceException;

	@WebMethod(action = "addProject")
	SProject addProject(@WebParam(name = "projectName", partName = "addProject.projectName") String projectName) throws ServiceException;

	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(@WebParam(name = "projectName", partName = "addProjectAsSubProject.projectName") String projectName,
			@WebParam(name = "parentPoid", partName = "addProjectAsSubProject.parentPoid") Long parentPoid) throws ServiceException;

	@WebMethod(action = "updateProject")
	void updateProject(@WebParam(name = "sProject", partName = "updateProject.sProject") SProject sProject) throws ServiceException;

	@WebMethod(action = "updateRevision")
	void updateRevision(@WebParam(name = "sRevision", partName = "updateRevision.sRevision") SRevision sRevision) throws ServiceException;

	@WebMethod(action = "addUserToProject")
	Boolean addUserToProject(@WebParam(name = "uoid", partName = "addUserToProject.uoid") Long uoid,
			@WebParam(name = "poid", partName = "addUserToProject.poid") Long poid) throws ServiceException;

	@WebMethod(action = "removeUserFromProject")
	Boolean removeUserFromProject(@WebParam(name = "uoid", partName = "removeProjectFromUser.uoid") Long uoid,
			@WebParam(name = "poid", partName = "removeUserFromProject.poid") Long poid) throws ServiceException;

	@WebMethod(action = "deleteProject")
	Boolean deleteProject(@WebParam(name = "poid", partName = "deleteProject.poid") Long poid) throws ServiceException;

	@WebMethod(action = "deleteUser")
	Boolean deleteUser(@WebParam(name = "uoid", partName = "deleteUser.uoid") Long uoid) throws ServiceException;

	@GET
	@Path("/getAllProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws ServiceException;

	@GET
	@Path("/getAllReadableProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllReadableProjects")
	List<SProject> getAllReadableProjects() throws ServiceException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws ServiceException;

	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces("application/xml")
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(
			@QueryParam("poid") @WebParam(name = "poid", partName = "getAllRevisionsOfProject.poid") Long poid) throws ServiceException;

	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(@WebParam(name = "poid", partName = "getAllCheckoutsOfProject.poid") Long poid)
			throws ServiceException;

	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(@WebParam(name = "uoid", partName = "getAllRevisionsOfUser.uoid") Long uoid)
			throws ServiceException;

	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(@WebParam(name = "uoid", partName = "getAllCheckoutsByUser.uoid") Long uoid)
			throws ServiceException;

	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name = "roid", partName = "getAllCheckoutsOfRevision.roid") Long roid)
			throws ServiceException;

	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(@WebParam(name = "poid", partName = "getProjectByPoid.poid") Long poid) throws ServiceException;

	@WebMethod(action = "getRevision")
	SRevision getRevision(@WebParam(name = "roid", partName = "getRevision.roid") Long roid) throws ServiceException;

	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws ServiceException;

	@WebMethod(action = "getDatabaseInformation")
	SDatabaseInformation getDatabaseInformation() throws ServiceException;

	@WebMethod(action = "getLastDatabaseReset")
	Date getLastDatabaseReset() throws ServiceException;

	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws ServiceException;

	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name = "uoid", partName = "getAllNonAuthorizedProjectsOfUser.uoid") Long uoid)
			throws ServiceException;

	@WebMethod(action = "logout")
	void logout() throws ServiceException;

	@WebMethod(action = "changePassword")
	Boolean changePassword(@WebParam(name = "uoid", partName = "changePassword.uoid") Long uoid,
			@WebParam(name = "oldPassword", partName = "changePassword.oldPassword") String oldPassword,
			@WebParam(name = "newPassword", partName = "changePassword.newPassword") String newPassword) throws ServiceException;

	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(@WebParam(name = "username", partName = "getUserByUserName.username") String username) throws ServiceException;

	@WebMethod(action = "undeleteProject")
	Boolean undeleteProject(@WebParam(name = "poid", partName = "undeleteProject.poid") Long poid) throws ServiceException;

	@WebMethod(action = "undeleteUser")
	Boolean undeleteUser(@WebParam(name = "uoid", partName = "undeleteUser.uoid") Long uoid) throws ServiceException;

	@WebMethod(action = "compare")
	SCompareResult compare(@WebParam(name = "roid1", partName = "compare.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "compare.roid2") Long roid2,
			@WebParam(name = "sCompareType", partName = "compare.sCompareType") SCompareType sCompareType, @WebParam(name = "sCompareIdentifier", partName = "compare.sCompareIdentifier") SCompareIdentifier sCompareIdentifier) throws ServiceException;

	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(@WebParam(name = "roid", partName = "getRevisionSummary.roid") Long roid) throws ServiceException;		

	@WebMethod(action = "userHasCheckinRights")
	Boolean userHasCheckinRights(@WebParam(name = "poid", partName = "userHasCheckinRights.poid") Long poid) throws ServiceException;

	@WebMethod(action = "getShowCheckoutWarning")
	Set<String> getCheckoutWarnings(@WebParam(name = "poid", partName = "getShowCheckoutWarning.poid") Long poid) throws ServiceException;

	@WebMethod(action = "userHasRights")
	Boolean userHasRights(@WebParam(name = "poid", partName = "userHasRights.poid") Long poid) throws ServiceException;

	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
			@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid,
			@WebParam(name = "className", partName = "getDataObjectByOid.className") String className) throws ServiceException;

	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(@WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
			@WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws ServiceException;

	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
			@WebParam(name = "className", partName = "getDataObjectsByType.className") String className) throws ServiceException;

	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByGuid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws ServiceException;

	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(
			@WebParam(name = "sClashDetectionSettings", partName = "findClashesByEid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws ServiceException;

	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(@WebParam(name = "roid", partName = "getLastClashes.roid") Long roid) throws ServiceException;

	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(@WebParam(name = "roid", partName = "branchToNewProject.roid") Long roid,
			@WebParam(name = "projectName", partName = "branchToNewProject.projectName") String projectName,
			@WebParam(name = "comment", partName = "branchToNewProject.comment") String comment) throws ServiceException;

	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(@WebParam(name = "roid", partName = "branchToExistingProject.roid") Long roid,
			@WebParam(name = "destPoid", partName = "branchToExistingProject.destPoid") Long destPoid,
			@WebParam(name = "comment", partName = "branchToExistingProject.comment") String comment) throws ServiceException;

	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(@WebParam(name = "goid", partName = "getGeoTag.goid") Long goid) throws ServiceException;

	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(@WebParam(name = "sGeoTag", partName = "updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws ServiceException;

	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(@WebParam(name = "cdsoid", partName = "getClashDetectionSettings.cdsoid") Long cdsoid)
			throws ServiceException;

	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(
			@WebParam(name = "sClashDetectionSettings", partName = "updateClashDetectionSettings.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws ServiceException;

	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(@WebParam(name = "uoid", partName = "getUserByUoid.uoid") Long uoid) throws ServiceException;

	@WebMethod(action = "getAnonymousUser")
	SUser getAnonymousUser() throws ServiceException;

	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name = "poid", partName = "getAllNonAuthorizedUsersOfProject.poid") Long poid)
			throws ServiceException;

	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name = "poid", partName = "getAllAuthorizedUsersOfProject.poid") Long poid)
			throws ServiceException;

	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(@WebParam(name = "uoid", partName = "getUsersProjects.uoid") Long uoid) throws ServiceException;

	@WebMethod(action = "getProjectsByName")
	List<SProject> getProjectsByName(@WebParam(name = "name", partName = "getProjectsByName.name") String name) throws ServiceException;

	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(@WebParam(name = "roid", partName = "setRevisionTag.roid") Long roid,
			@WebParam(name = "tag", partName = "setRevisionTag.tag") String tag) throws ServiceException;

	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(@WebParam(name = "poid", partName = "getSubProjects.poid") Long poid) throws ServiceException;

	@WebMethod(action = "setExportTypeEnabled")
	void setExportTypeEnabled(@WebParam(name = "resultTypeName", partName = "setExportTypeEnabled.resultTypeName") String resultTypeName,
			Boolean enabled) throws ServiceException;

	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws ServiceException;

	@WebMethod(action = "isLoggedIn")
	Boolean isLoggedIn() throws ServiceException;

	@WebMethod(action = "loginAnonymous")
	void loginAnonymous() throws ServiceException;

	@WebMethod(action = "getActiveSince")
	Date getActiveSince() throws ServiceException;

	@WebMethod(action = "getLastActive")
	Date getLastActive() throws ServiceException;

	@WebMethod(action = "getCurrentToken")
	Token getCurrentToken() throws ServiceException;

	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws ServiceException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(
			@WebParam(name = "poid", partName = "getAllCheckoutsOfProjectAndSubProjects.poid") Long poid) throws ServiceException;

	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(@WebParam(name = "uoid", partName = "requestPasswordChange.uoid") Long uoid) throws ServiceException;

	@WebMethod(action = "validateAccount")
	void validateAccount(@WebParam(name = "uoid", partName = "validateAccount.uoid") Long uoid,
			@WebParam(name = "token", partName = "validateAccount.token") String token,
			@WebParam(name = "password", partName = "validateAccount.password") String password) throws ServiceException;

	@WebMethod(action = "sendClashesEmail")
	void sendClashesEmail(
			@WebParam(name = "sClashDetectionSettings", partName = "sendClashesEmail.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "addressesTo", partName = "sendClashesEmail.addressesTo") Set<String> addressesTo) throws ServiceException;

	@WebMethod(action = "sendCompareEmail")
	void sendCompareEmail(
			@WebParam(name = "sCompareType", partName = "sendClashesEmail.sCompareType") SCompareType sCompareType,
			@WebParam(name = "sCompareIdentifier", partName = "sendClashesEmail.sCompareIdentifier") SCompareIdentifier sCompareIdentifier,
			@WebParam(name = "poid", partName = "sendClashesEmail.poid") Long poid,
			@WebParam(name = "roid1", partName = "sendClashesEmail.roid1") Long roid1,
			@WebParam(name = "roid2", partName = "sendClashesEmail.roid2") Long roid2,
			@WebParam(name = "address", partName = "sendClashesEmail.address") String address) throws ServiceException;
	
	@WebMethod(action = "setup")
	void setup(@WebParam(name = "siteAddress", partName = "setup.siteAddress") String siteAddress,
			@WebParam(name = "smtpServer", partName = "setup.smtpServer") String smtpServer,
			@WebParam(name = "adminName", partName = "setup.adminName") String adminName,
			@WebParam(name = "adminUsername", partName = "setup.adminUsername") String adminUsername,
			@WebParam(name = "adminPassword", partName = "setup.adminPassword") String adminPassword,
			@WebParam(name = "createAnonymousUser", partName = "setup.createAnonymousUser") Boolean createAnonymousUser) throws ServiceException;

	@WebMethod(action = "getSettingsCustomLogoAddress")
	String getSettingCustomLogoAddress() throws ServiceException;

	@WebMethod(action = "getSettingHeaderAddition")
	String getSettingHeaderAddition() throws ServiceException;

	@WebMethod(action = "getSettingFooterAddition")
	String getSettingFooterAddition() throws ServiceException;

	@WebMethod(action = "setSettingsCustomLogoAddress")
	void setSettingCustomLogoAddress(
			@WebParam(name = "customLogoAddress", partName = "setSettingsCustomLogoAddress.customLogoAddress") String customLogoAddress)
			throws ServiceException;

	@WebMethod(action = "setSettingHeaderAddition")
	void setSettingHeaderAddition (
			@WebParam(name = "headerAddition", partName = "setSettingHeaderAddition.headerAddition") String headerAddition)
			throws ServiceException;

	@WebMethod(action = "setSettingFooterAddition")
	void setSettingFooterAddition(
			@WebParam(name = "footerAddition", partName = "setSettingFooterAddition.footerAddition") String footerAddition)
			throws ServiceException;

	@WebMethod(action = "setSettingMergeIdentifier")
	void setSettingMergeIdentifier(
			@WebParam(name = "mergeIdentifier", partName = "setSettingMergeIdentifier.mergeIdentifier") SMergeIdentifier mergeIdentifier)
			throws ServiceException;

	@WebMethod(action = "getSettingsEmailSenderAddress")
	String getSettingEmailSenderAddress() throws ServiceException;

	@WebMethod(action = "setSettingsEmailSenderAddress")
	void setSettingEmailSenderAddress(
			@WebParam(name = "emailSenderAddress", partName = "setSettingsEmailSenderAddress.emailSenderAddress") String emailSenderAddress)
			throws ServiceException;

	@WebMethod(action = "getSettingsEnabledExportTypes")
	String getSettingEnabledExportTypes() throws ServiceException;

	@WebMethod(action = "setSettingsEnabledExportTypes")
	void setSettingEnabledExportTypes(
			@WebParam(name = "enabledExportTypeNames", partName = "setSettingsEnabledExportTypes.enabledExportTypeNames") Set<String> enabledExportTypeNames)
			throws ServiceException;

	@WebMethod(action = "getSettingsRegistrationAddition")
	String getSettingRegistrationAddition() throws ServiceException;

	@WebMethod(action = "setSettingsRegistrationAddition")
	void setSettingRegistrationAddition(
			@WebParam(name = "registrationAddition", partName = "setSettingsRegistrationAddition.registrationAddition") String registrationAddition)
			throws ServiceException;

	@WebMethod(action = "getSettingsSiteAddress")
	String getSettingSiteAddress() throws ServiceException;

	@WebMethod(action = "setSettingsSiteAddress")
	void setSettingSiteAddress(@WebParam(name = "siteAddress", partName = "setSettingsSiteAddress.siteAddress") String siteAddress)
			throws ServiceException;

	@WebMethod(action = "getSettingsSmtpServer")
	String getSettingSmtpServer() throws ServiceException;

	@WebMethod(action = "setSettingsSmtpServer")
	void setSettingSmtpServer(@WebParam(name = "smtpServer", partName = "setSettingsSmtpServer.smtpServer") String smtpServer)
			throws ServiceException;

	@WebMethod(action = "isSettingAllowSelfRegistration")
	Boolean isSettingAllowSelfRegistration() throws ServiceException;

	@WebMethod(action = "setSettingAllowSelfRegistration")
	void setSettingAllowSelfRegistration(
			@WebParam(name = "allowSelfRegistration", partName = "setSettingAllowSelfRegistration.allowSelfRegistration") Boolean allowSelfRegistration)
			throws ServiceException;

	@WebMethod(action = "isSettingAllowUsersToCreateTopLevelProjects")
	Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServiceException;

	@WebMethod(action = "setSettingAllowUsersToCreateTopLevelProjects")
	void setSettingAllowUsersToCreateTopLevelProjects(
			@WebParam(name = "allowUsersToCreateTopLevelProjects", partName = "setSettingAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects") Boolean allowUsersToCreateTopLevelProjects)
			throws ServiceException;

	@WebMethod(action = "isSettingAutoTestClashes")
	Boolean isSettingAutoTestClashes() throws ServiceException;

	@WebMethod(action = "setSettingAutoTestClashes")
	void setSettingAutoTestClashes(
			@WebParam(name = "autoTestClashes", partName = "setSettingAutoTestClashes.autoTestClashes") Boolean autoTestClashes)
			throws ServiceException;

	@WebMethod(action = "isSettingCheckinMergingEnabled")
	Boolean isSettingCheckinMergingEnabled() throws ServiceException;

	@WebMethod(action = "setSettingCheckinMergingEnabled")
	void setSettingCheckinMergingEnabled(
			@WebParam(name = "checkinMergingEnabled", partName = "setSettingCheckinMergingEnabled.checkinMergingEnabled") Boolean checkinMergingEnabled)
			throws ServiceException;

	@WebMethod(action = "isSettingIntelligentMerging")
	Boolean isSettingIntelligentMerging() throws ServiceException;

	@WebMethod(action = "setSettingIntelligentMerging")
	void setSettingIntelligentMerging(
			@WebParam(name = "intelligentMerging", partName = "setSettingIntelligentMerging.intelligentMerging") Boolean intelligentMerging)
			throws ServiceException;

	@WebMethod(action = "isSettingSendConfirmationEmailAfterRegistration")
	Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServiceException;

	@WebMethod(action = "setSettingSendConfirmationEmailAfterRegistration")
	void setSettingSendConfirmationEmailAfterRegistration(
			@WebParam(name = "sendConfirmationEmailAfterRegistration", partName = "setSettingSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration") Boolean sendConfirmationEmailAfterRegistration)
			throws ServiceException;

	@WebMethod(action = "isSettingShowVersionUpgradeAvailable")
	Boolean isSettingShowVersionUpgradeAvailable() throws ServiceException;

	@WebMethod(action = "setSettingShowVersionUpgradeAvailable")
	void setSettingShowVersionUpgradeAvailable(
			@WebParam(name = "showVersionUpgradeAvailable", partName = "setSettingShowVersionUpgradeAvailable.showVersionUpgradeAvailable") Boolean showVersionUpgradeAvailable)
			throws ServiceException;

	@WebMethod(action = "isCacheOutputFiles")
	Boolean isSettingCacheOutputFiles() throws ServiceException;

	@WebMethod(action = "setCacheOutputFiles")
	void setSettingCacheOutputFiles(@WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles)
			throws ServiceException;
	
	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws ServiceException;

	@WebMethod(action = "getActiveUserSessions")
	List<SUserSession> getActiveUserSessions() throws ServiceException;

	@WebMethod(action = "getActiveLongActions")
	List<SLongAction> getActiveLongActions() throws ServiceException;

	@WebMethod(action = "getPendingMigrations")
	Set<SMigration> getMigrations() throws ServiceException;

	@WebMethod(action = "migrateDatabase")
	void migrateDatabase() throws ServiceException;

	@WebMethod(action = "getAllSerializers")
	List<SSerializer> getAllSerializers(Boolean onlyEnabled) throws ServiceException;
	
	@WebMethod(action = "getEnabledSerializers")
	List<SSerializer> getEnabledSerializers() throws ServiceException;

	@WebMethod(action = "getEnabledSerializers")
	List<SDeserializer> getEnabledDeserializers() throws ServiceException;
	
	@WebMethod(action = "getSerializerById")
	SSerializer getSerializerById(Long oid) throws ServiceException;
	
	@WebMethod(action = "addSerializer")
	void addSerializer(SSerializer serializer) throws ServiceException;
	
	@WebMethod(action = "updateSerializer")
	void updateSerializer(SSerializer serializer) throws ServiceException;
	
	@WebMethod(action = "updateDeserializer")
	void updateDeserializer(SDeserializer deserializer) throws ServiceException;

	@WebMethod(action = "getAllGuidanceProviders")
	List<SGuidanceProvider> getAllGuidanceProviders() throws ServiceException;
	
	@WebMethod(action = "getGuidanceProviderById")
	SGuidanceProvider getGuidanceProviderById(Long oid) throws ServiceException;
	
	@WebMethod(action = "addGuidanceProvider")
	void addGuidanceProvider(SGuidanceProvider guidanceProvider) throws ServiceException;
	
	@WebMethod(action = "updateGuidanceProvider")
	void updateGuidanceProvider(SGuidanceProvider guidanceProvider) throws ServiceException;
	
	@WebMethod(action = "deleteGuidanceProvider")
	void deleteGuidanceProvider(Long ifid) throws ServiceException;

	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(Long sid) throws ServiceException;
	
	@WebMethod(action = "deleteDeserializer")
	void deleteDeserializer(Long sid) throws ServiceException;

	@WebMethod(action = "getAllSerializerClassNames")
	Set<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws ServiceException;

	@WebMethod(action = "getSettingMergeIdentifier")
	SMergeIdentifier getSettingMergeIdentifier() throws ServiceException;

	@WebMethod(action = "getSerializerByName")
	SSerializer getSerializerByName(
			@WebParam(name = "serializerName", partName = "getSerializerByName.serializerName") String serializerName) throws ServiceException;

	@WebMethod(action = "getGuidanceProviderByName")
	SGuidanceProvider getGuidanceProviderByName(
			@WebParam(name = "guidanceProviderName", partName = "getGuidanceProviderByName.guidanceProviderName") String guidanceProviderName) throws ServiceException;

	@WebMethod(action = "getDeserializerByName")
	SDeserializer getDeserializerByName(
			@WebParam(name = "deserializerName", partName = "getDeserializerByName.deserializerName") String deserializerName) throws ServiceException;

	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(String contentType) throws ServiceException;
	
	@WebMethod(action = "getAllPlugins")
	List<SPluginDescriptor> getAllPlugins() throws ServiceException;
	
	@WebMethod(action = "enablePlugin")
	void enablePlugin(String name) throws ServiceException;
	
	@WebMethod(action = "disablePlugin")
	void disablePlugin(String name) throws ServiceException;

	@WebMethod(action = "getSerializerByContentType")
	SSerializer getSerializerByContentType(
			@WebParam(name = "contentType", partName = "getSerializerByContentType.contentType") String contentType) throws ServiceException;
	
	@WebMethod(action = "startTransaction")
	void startTransaction(
			@WebParam(name = "pid", partName = "startTransaction.pid") Integer pid) throws ServiceException;

	@WebMethod(action = "commitTransaction")
	Long commitTransaction() throws ServiceException;
	
	@WebMethod(action = "abortTransaction")
	void abortTransaction() throws ServiceException;
	
	@WebMethod(action = "createObject")
	Long createObject(
			@WebParam(name = "className", partName = "createObject.className") String className) throws ServiceException;
	
	@WebMethod(action = "removeObject")
	void removeObject(
			@WebParam(name = "className", partName = "removeObject.className") String className, 
			@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws ServiceException;
	
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
			@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws ServiceException;
	
	@WebMethod(action = "setFloatAttribute")
	void setFloatAttribute(
			@WebParam(name = "oid", partName = "setFloatAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setFloatAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setFloatAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setFloatAttribute.value") Float value) throws ServiceException;

	@WebMethod(action = "setEnumAttribute")
	void setEnumAttribute(
			@WebParam(name = "oid", partName = "setEnumAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setEnumAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setEnumAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setEnumAttribute.value") String value) throws ServiceException;

	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
			@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws ServiceException;

	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
			@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "setBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
			@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws ServiceException;

	@WebMethod(action = "setReference")
	void setReference(
			@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
			@WebParam(name = "className", partName = "setReference.className") String className, 
			@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid, 
			@WebParam(name = "referenceClassName", partName = "setReference.referenceClassName") String referenceClassName) throws ServiceException;
	
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
			@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "unsetAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws ServiceException;
	
	@WebMethod(action = "unsetReference")
	void unsetReference(
			@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
			@WebParam(name = "className", partName = "unsetReference.className") String className,
			@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws ServiceException;
	
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
			@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addStringAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws ServiceException;

	@WebMethod(action = "addFloatAttribute")
	void addFloatAttribute(
			@WebParam(name = "oid", partName = "addFloatAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addFloatAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addFloatAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addFloatAttribute.value") Float value) throws ServiceException;

	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
			@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addIntegerAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws ServiceException;

	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
			@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "addBooleanAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
			@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws ServiceException;

	@WebMethod(action = "addReference")
	void addReference(
			@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
			@WebParam(name = "className", partName = "addReference.className") String className, 
			@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
			@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid,
			@WebParam(name = "referenceClassName", partName = "addReference.referenceClassName") String referenceClassName) throws ServiceException;
	
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
			@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
			@WebParam(name = "className", partName = "removeAttribute.className") String className, 
			@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
			@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws ServiceException;
	
	@WebMethod(action = "removeReference")
	void removeReference(
			@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
			@WebParam(name = "className", partName = "removeReference.className") String className, 
			@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
			@WebParam(name = "index", partName = "removeReference.index") Integer index) throws ServiceException;
	
	@WebMethod(action = "getServerStartTime")
	Date getServerStartTime() throws ServiceException;
	
	@WebMethod(action = "getSerializerPluginDescriptor")
	SSerializerPluginDescriptor getSerializerPluginDescriptor(@WebParam(name = "type", partName = "getSerializerPluginDescriptor.type") String type) throws ServiceException;
	
	@WebMethod(action = "getAllGuidanceProviderPluginDescriptors")
	Set<SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() throws ServiceException;

	@WebMethod(action = "getAllDeserializers")
	List<SDeserializer> getAllDeserializers(@WebParam(name = "oid", partName = "removeReference.oid") Boolean onlyEnabled) throws ServiceException;
	
	@WebMethod(action = "registerNewRevisionListener")
	void registerNewRevisionListener() throws ServiceException;
	
	@WebMethod(action = "setHttpCallback")
	void setHttpCallback(
			@WebParam(name = "uoid", partName = "setHttpCallback.uoid") Long uoid, 
			@WebParam(name = "address", partName = "setHttpCallback.address") String address) throws ServiceException;
	
	@WebMethod(action = "compile")
	SCompileResult compile(@WebParam(name = "code", partName = "compile.code") String code) throws ServiceException;

	@WebMethod(action = "compileAndRun")
	SRunResult compileAndRun(@WebParam(name = "roid", partName = "compileAndRun.roid") long roid, @WebParam(name = "code", partName = "compileAndRun.code") String code) throws ServiceException;

	@WebMethod(action = "compileAndDownload")
	Integer compileAndDownload(@WebParam(name = "roid", partName = "compileAndDownload.roid") long roid, @WebParam(name = "code", partName = "compileAndDownload.code") String code) throws ServiceException;
	
	@WebMethod(action = "getProtocolBuffersFile")
	String getProtocolBuffersFile() throws ServiceException;
	
	@WebMethod(action = "getServerInfo")
	SServerInfo getServerInfo() throws ServiceException;
	
	@WebMethod(action = "getVersion")
	SVersion getVersion() throws ServiceException;
	
	@WebMethod(action = "getLatestVersion")
	SVersion getLatestVersion() throws ServiceException;
	
	@WebMethod(action = "upgradePossible")
	Boolean upgradePossible() throws ServiceException;
}