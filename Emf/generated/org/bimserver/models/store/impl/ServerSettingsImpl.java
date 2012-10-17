/**
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
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getUseCaching <em>Use Caching</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getRegistrationAddition <em>Registration Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getCustomLogoAddress <em>Custom Logo Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getWhitelistedDomains <em>Whitelisted Domains</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getProtocolBuffersPort <em>Protocol Buffers Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getHeaderAddition <em>Header Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getFooterAddition <em>Footer Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getCacheOutputFiles <em>Cache Output Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServerSettingsImpl#getServiceRepositoryUrl <em>Service Repository Url</em>}</li>
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
	public Boolean getShowVersionUpgradeAvailable() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowVersionUpgradeAvailable(Boolean newShowVersionUpgradeAvailable) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, newShowVersionUpgradeAvailable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSendConfirmationEmailAfterRegistration() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendConfirmationEmailAfterRegistration(boolean newSendConfirmationEmailAfterRegistration) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION, newSendConfirmationEmailAfterRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getUseCaching() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__USE_CACHING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCaching(Boolean newUseCaching) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__USE_CACHING, newUseCaching);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAllowSelfRegistration() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_SELF_REGISTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowSelfRegistration(Boolean newAllowSelfRegistration) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_SELF_REGISTRATION, newAllowSelfRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUsersToCreateTopLevelProjects() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowUsersToCreateTopLevelProjects(boolean newAllowUsersToCreateTopLevelProjects) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS, newAllowUsersToCreateTopLevelProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCheckinMergingEnabled() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__CHECKIN_MERGING_ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckinMergingEnabled(Boolean newCheckinMergingEnabled) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__CHECKIN_MERGING_ENABLED, newCheckinMergingEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationAddition() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__REGISTRATION_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationAddition(String newRegistrationAddition) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__REGISTRATION_ADDITION, newRegistrationAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpServer() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__SMTP_SERVER, true);
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
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailSenderAddress(String newEmailSenderAddress) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__EMAIL_SENDER_ADDRESS, newEmailSenderAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomLogoAddress() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__CUSTOM_LOGO_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomLogoAddress(String newCustomLogoAddress) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__CUSTOM_LOGO_ADDRESS, newCustomLogoAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSiteAddress() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__SITE_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteAddress(String newSiteAddress) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SITE_ADDRESS, newSiteAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getWhitelistedDomains() {
		return (EList<String>) eGet(StorePackage.Literals.SERVER_SETTINGS__WHITELISTED_DOMAINS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getHideUserListForNonAdmin() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideUserListForNonAdmin(Boolean newHideUserListForNonAdmin) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN, newHideUserListForNonAdmin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getProtocolBuffersPort() {
		return (Integer) eGet(StorePackage.Literals.SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolBuffersPort(Integer newProtocolBuffersPort) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT, newProtocolBuffersPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeaderAddition() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__HEADER_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderAddition(String newHeaderAddition) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__HEADER_ADDITION, newHeaderAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFooterAddition() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__FOOTER_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterAddition(String newFooterAddition) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__FOOTER_ADDITION, newFooterAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCacheOutputFiles() {
		return (Boolean) eGet(StorePackage.Literals.SERVER_SETTINGS__CACHE_OUTPUT_FILES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheOutputFiles(Boolean newCacheOutputFiles) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__CACHE_OUTPUT_FILES, newCacheOutputFiles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceRepositoryUrl() {
		return (String) eGet(StorePackage.Literals.SERVER_SETTINGS__SERVICE_REPOSITORY_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceRepositoryUrl(String newServiceRepositoryUrl) {
		eSet(StorePackage.Literals.SERVER_SETTINGS__SERVICE_REPOSITORY_URL, newServiceRepositoryUrl);
	}

} //ServerSettingsImpl
