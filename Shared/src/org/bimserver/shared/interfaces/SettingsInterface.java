package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface SettingsInterface extends PublicInterface {
	@WebMethod(action = "getSettingEmailSenderAddress")
	String getSettingEmailSenderAddress() throws ServerException, UserException;

	/**
	 * @param emailSenderAddress The new e-mail address e-mail will be sent from
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingEmailSenderAddress")
	void setSettingEmailSenderAddress(
		@WebParam(name = "emailSenderAddress", partName = "setSettingsEmailSenderAddress.emailSenderAddress") String emailSenderAddress) throws ServerException, UserException;

	/**
	 * @return The port on which the ProtocolBuffers server runs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingProtocolBuffersPort")
	Integer getSettingProtocolBuffersPort() throws ServerException, UserException;

	/**
	 * @param port Set the port the ProtocolBuffers server runs on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingProtocolBuffersPort")
	void setSettingProtocolBuffersPort(
		@WebParam(name = "port", partName = "setSettingsProtocolBuffersPort.port") Integer port) throws ServerException, UserException;
	
	/**
	 * @return The address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingSiteAddress")
	String getSettingSiteAddress() throws ServerException, UserException;

	/**
	 * @param siteAddress The new address the BIMserver is running on (used for links in e-mail for example)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingSiteAddress")
	void setSettingSiteAddress(
		@WebParam(name = "siteAddress", partName = "setSettingsSiteAddress.siteAddress") String siteAddress) throws ServerException, UserException;

	/**
	 * @return Address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSettingSmtpServer")
	String getSettingSmtpServer() throws ServerException, UserException;

	/**
	 * @param smtpServer New address of the SMTP server used for sending e-mails
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingSmtpServer")
	void setSettingSmtpServer(
		@WebParam(name = "smtpServer", partName = "setSettingsSmtpServer.smtpServer") String smtpServer) throws ServerException, UserException;

	/**
	 * @return Whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingAllowSelfRegistration")
	Boolean isSettingAllowSelfRegistration() throws ServerException, UserException;

	/**
	 * @param allowSelfRegistration Change whether self-registration is enabled
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingAllowSelfRegistration")
	void setSettingAllowSelfRegistration(
		@WebParam(name = "allowSelfRegistration", partName = "setSettingAllowSelfRegistration.allowSelfRegistration") Boolean allowSelfRegistration)throws ServerException, UserException;

	/**
	 * @return Whether to hide user lists (pricacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingHideUserListForNonAdmin")
	Boolean isSettingHideUserListForNonAdmin() throws ServerException, UserException;

	/**
	 * @param hideUserListForNonAdmin Set whether user lists should be hidden (privacy)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingHideUserListForNonAdmin")
	void setSettingHideUserListForNonAdmin(
		@WebParam(name = "hideUserListForNonAdmin", partName = "setSettingHideUserListForNonAdmin.hideUserListForNonAdmin") Boolean hideUserListForNonAdmin) throws ServerException, UserException;

	/**
	 * @return Whether a user can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingAllowUsersToCreateTopLevelProjects")
	Boolean isSettingAllowUsersToCreateTopLevelProjects() throws ServerException, UserException;

	/**
	 * @param allowUsersToCreateTopLevelProjects Set if users can create top level projects
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingAllowUsersToCreateTopLevelProjects")
	void setSettingAllowUsersToCreateTopLevelProjects(
		@WebParam(name = "allowUsersToCreateTopLevelProjects", partName = "setSettingAllowUsersToCreateTopLevelProjects.allowUsersToCreateTopLevelProjects") Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException;

	/**
	 * @return Whether the BIMserver should do checkin merging (warning: this will alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingCheckinMergingEnabled")
	Boolean isSettingCheckinMergingEnabled() throws ServerException, UserException;

	/**
	 * @param checkinMergingEnabled Set whether the BIMserver should do checkin merging (warning: this wil alter your models)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingCheckinMergingEnabled")
	void setSettingCheckinMergingEnabled(
		@WebParam(name = "checkinMergingEnabled", partName = "setSettingCheckinMergingEnabled.checkinMergingEnabled") Boolean checkinMergingEnabled) throws ServerException, UserException;

	/**
	 * @return Whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingSendConfirmationEmailAfterRegistration")
	Boolean isSettingSendConfirmationEmailAfterRegistration() throws ServerException, UserException;

	/**
	 * @param sendConfirmationEmailAfterRegistration Set whether a confirmation e-mail should be send after registration
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingSendConfirmationEmailAfterRegistration")
	void setSettingSendConfirmationEmailAfterRegistration(
		@WebParam(name = "sendConfirmationEmailAfterRegistration", partName = "setSettingSendConfirmationEmailAfterRegistration.sendConfirmationEmailAfterRegistration") Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingCacheOutputFiles")
	Boolean isSettingCacheOutputFiles() throws ServerException, UserException;

	/**
	 * @return Whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isSettingGenerateGeometryOnCheckin")
	Boolean isSettingGenerateGeometryOnCheckin() throws ServerException, UserException;
	
	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingCacheOutputFiles")
	void setSettingCacheOutputFiles(
		@WebParam(name = "cacheOutputFiles", partName = "setCacheOutputFiles.cacheOutputFiles") Boolean cacheOutputFiles) throws ServerException, UserException;

	/**
	 * @param cacheOutputFiles Set whether output files (serialized version) should be cached on disk
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setSettingGenerateGeometryOnCheckin")
	void setSettingGenerateGeometryOnCheckin(
		@WebParam(name = "generateGeometryOnCheckin", partName = "setSettingGenerateGeometryOnCheckin.generateGeometryOnCheckin") Boolean generateGeometryOnCheckin) throws ServerException, UserException;

	@WebMethod(action="getServiceRepositoryUrl")
	String getServiceRepositoryUrl() throws ServerException, UserException;

	@WebMethod(action="setServiceRepositoryUrl")
	void setServiceRepositoryUrl(
		@WebParam(name = "url", partName = "setServiceRepositoryUrl.url") String url) throws ServerException, UserException;
	
	@WebMethod(action = "getServerSettings")
	SServerSettings getServerSettings() throws ServerException, UserException;

	@WebMethod(action = "setServerSettings")
	void setServerSettings(
		@WebParam(name = "serverSettings", partName = "setServerSettings.serverSettings") SServerSettings serverSettings) throws ServerException, UserException;
	
	@WebMethod(action = "setWhiteListedDomains")
	void setWhiteListedDomains(
		@WebParam(name = "domains", partName = "setWhiteListedDomains.domains") List<String> domains) throws ServerException, UserException;
}