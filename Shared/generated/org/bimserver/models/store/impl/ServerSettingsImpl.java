/**
 * Copyright (C) 2009-2013 BIMserver.org
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
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.SmtpProtocol;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.WebModulePluginConfiguration;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getEmailSenderName <em>Email Sender Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isGenerateGeometryOnCheckin <em>Generate Geometry On Checkin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isAllowOnlyWhitelisted <em>Allow Only Whitelisted</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getWhitelistedDomains <em>Whitelisted Domains</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getProtocolBuffersPort <em>Protocol Buffers Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getCacheOutputFiles <em>Cache Output Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getWebModules <em>Web Modules</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getWebModule <em>Web Module</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getServiceRepositoryUrl <em>Service Repository Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSessionTimeOutSeconds <em>Session Time Out Seconds</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpUsername <em>Smtp Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpPassword <em>Smtp Password</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpProtocol <em>Smtp Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isReuseGeometry <em>Reuse Geometry</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerSettingsImpl extends IdEObjectImpl implements ServerSettings {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERVER_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSendConfirmationEmailAfterRegistration() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendConfirmationEmailAfterRegistration(
			boolean newSendConfirmationEmailAfterRegistration) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION,
				newSendConfirmationEmailAfterRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAllowSelfRegistration() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__ALLOW_SELF_REGISTRATION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowSelfRegistration(Boolean newAllowSelfRegistration) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_SELF_REGISTRATION,
				newAllowSelfRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUsersToCreateTopLevelProjects() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowUsersToCreateTopLevelProjects(
			boolean newAllowUsersToCreateTopLevelProjects) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS,
				newAllowUsersToCreateTopLevelProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCheckinMergingEnabled() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__CHECKIN_MERGING_ENABLED,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckinMergingEnabled(Boolean newCheckinMergingEnabled) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__CHECKIN_MERGING_ENABLED,
				newCheckinMergingEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpServer() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SMTP_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpServer(String newSmtpServer) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SMTP_SERVER, newSmtpServer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailSenderAddress() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_ADDRESS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailSenderAddress(String newEmailSenderAddress) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_ADDRESS,
				newEmailSenderAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailSenderName() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailSenderName(String newEmailSenderName) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_NAME,
				newEmailSenderName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSiteAddress() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SITE_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteAddress(String newSiteAddress) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SITE_ADDRESS,
				newSiteAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateGeometryOnCheckin() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__GENERATE_GEOMETRY_ON_CHECKIN,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateGeometryOnCheckin(
			boolean newGenerateGeometryOnCheckin) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__GENERATE_GEOMETRY_ON_CHECKIN,
				newGenerateGeometryOnCheckin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowOnlyWhitelisted() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__ALLOW_ONLY_WHITELISTED,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowOnlyWhitelisted(boolean newAllowOnlyWhitelisted) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_ONLY_WHITELISTED,
				newAllowOnlyWhitelisted);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getWhitelistedDomains() {
		return (EList<String>) eGet(
				StorePackage.Literals.SERVER_SETTINGS__WHITELISTED_DOMAINS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getHideUserListForNonAdmin() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideUserListForNonAdmin(Boolean newHideUserListForNonAdmin) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN,
				newHideUserListForNonAdmin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getProtocolBuffersPort() {
		return (Integer) eGet(
				StorePackage.Literals.SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolBuffersPort(Integer newProtocolBuffersPort) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT,
				newProtocolBuffersPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCacheOutputFiles() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__CACHE_OUTPUT_FILES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheOutputFiles(Boolean newCacheOutputFiles) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__CACHE_OUTPUT_FILES,
				newCacheOutputFiles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<WebModulePluginConfiguration> getWebModules() {
		return (EList<WebModulePluginConfiguration>) eGet(
				StorePackage.Literals.SERVER_SETTINGS__WEB_MODULES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebModulePluginConfiguration getWebModule() {
		return (WebModulePluginConfiguration) eGet(
				StorePackage.Literals.SERVER_SETTINGS__WEB_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebModule(WebModulePluginConfiguration newWebModule) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__WEB_MODULE, newWebModule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceRepositoryUrl() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SERVICE_REPOSITORY_URL,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceRepositoryUrl(String newServiceRepositoryUrl) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SERVICE_REPOSITORY_URL,
				newServiceRepositoryUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSendEmailOnNewRevision() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SEND_EMAIL_ON_NEW_REVISION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendEmailOnNewRevision(boolean newSendEmailOnNewRevision) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SEND_EMAIL_ON_NEW_REVISION,
				newSendEmailOnNewRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSessionTimeOutSeconds() {
		return (Integer) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SESSION_TIME_OUT_SECONDS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionTimeOutSeconds(int newSessionTimeOutSeconds) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SESSION_TIME_OUT_SECONDS,
				newSessionTimeOutSeconds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpUsername() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SMTP_USERNAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpUsername(String newSmtpUsername) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SMTP_USERNAME,
				newSmtpUsername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpPassword() {
		return (String) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SMTP_PASSWORD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpPassword(String newSmtpPassword) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SMTP_PASSWORD,
				newSmtpPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSmtpPort() {
		return (Integer) eGet(StorePackage.Literals.SERVER_SETTINGS__SMTP_PORT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpPort(int newSmtpPort) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SMTP_PORT, newSmtpPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmtpProtocol getSmtpProtocol() {
		return (SmtpProtocol) eGet(
				StorePackage.Literals.SERVER_SETTINGS__SMTP_PROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpProtocol(SmtpProtocol newSmtpProtocol) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SMTP_PROTOCOL,
				newSmtpProtocol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReuseGeometry() {
		return (Boolean) eGet(
				StorePackage.Literals.SERVER_SETTINGS__REUSE_GEOMETRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReuseGeometry(boolean newReuseGeometry) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__REUSE_GEOMETRY,
				newReuseGeometry);
	}

} //ServerSettingsImpl
