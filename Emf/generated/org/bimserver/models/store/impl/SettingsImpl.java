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

import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.ObjectIDM;
import org.bimserver.models.store.Plugin;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getUseCaching <em>Use Caching</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getAutoTestClashes <em>Auto Test Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getIntelligentMerging <em>Intelligent Merging</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getRegistrationAddition <em>Registration Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getCustomLogoAddress <em>Custom Logo Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getProtocolBuffersPort <em>Protocol Buffers Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getObjectIDMs <em>Object ID Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getHeaderAddition <em>Header Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getFooterAddition <em>Footer Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getMergeIdentifier <em>Merge Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getCacheOutputFiles <em>Cache Output Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getIfcEngines <em>Ifc Engines</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getDeserializers <em>Deserializers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SettingsImpl extends IdEObjectImpl implements Settings {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SETTINGS;
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
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowVersionUpgradeAvailable(Boolean newShowVersionUpgradeAvailable) {
		eSet(StorePackage.Literals.SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, newShowVersionUpgradeAvailable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSendConfirmationEmailAfterRegistration() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendConfirmationEmailAfterRegistration(boolean newSendConfirmationEmailAfterRegistration) {
		eSet(StorePackage.Literals.SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION, newSendConfirmationEmailAfterRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getUseCaching() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__USE_CACHING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCaching(Boolean newUseCaching) {
		eSet(StorePackage.Literals.SETTINGS__USE_CACHING, newUseCaching);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAllowSelfRegistration() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__ALLOW_SELF_REGISTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowSelfRegistration(Boolean newAllowSelfRegistration) {
		eSet(StorePackage.Literals.SETTINGS__ALLOW_SELF_REGISTRATION, newAllowSelfRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAutoTestClashes() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__AUTO_TEST_CLASHES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoTestClashes(Boolean newAutoTestClashes) {
		eSet(StorePackage.Literals.SETTINGS__AUTO_TEST_CLASHES, newAutoTestClashes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIntelligentMerging() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__INTELLIGENT_MERGING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntelligentMerging(Boolean newIntelligentMerging) {
		eSet(StorePackage.Literals.SETTINGS__INTELLIGENT_MERGING, newIntelligentMerging);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUsersToCreateTopLevelProjects() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowUsersToCreateTopLevelProjects(boolean newAllowUsersToCreateTopLevelProjects) {
		eSet(StorePackage.Literals.SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS, newAllowUsersToCreateTopLevelProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCheckinMergingEnabled() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__CHECKIN_MERGING_ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckinMergingEnabled(Boolean newCheckinMergingEnabled) {
		eSet(StorePackage.Literals.SETTINGS__CHECKIN_MERGING_ENABLED, newCheckinMergingEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationAddition() {
		return (String) eGet(StorePackage.Literals.SETTINGS__REGISTRATION_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationAddition(String newRegistrationAddition) {
		eSet(StorePackage.Literals.SETTINGS__REGISTRATION_ADDITION, newRegistrationAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpServer() {
		return (String) eGet(StorePackage.Literals.SETTINGS__SMTP_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpServer(String newSmtpServer) {
		eSet(StorePackage.Literals.SETTINGS__SMTP_SERVER, newSmtpServer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmailSenderAddress() {
		return (String) eGet(StorePackage.Literals.SETTINGS__EMAIL_SENDER_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmailSenderAddress(String newEmailSenderAddress) {
		eSet(StorePackage.Literals.SETTINGS__EMAIL_SENDER_ADDRESS, newEmailSenderAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomLogoAddress() {
		return (String) eGet(StorePackage.Literals.SETTINGS__CUSTOM_LOGO_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomLogoAddress(String newCustomLogoAddress) {
		eSet(StorePackage.Literals.SETTINGS__CUSTOM_LOGO_ADDRESS, newCustomLogoAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSiteAddress() {
		return (String) eGet(StorePackage.Literals.SETTINGS__SITE_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteAddress(String newSiteAddress) {
		eSet(StorePackage.Literals.SETTINGS__SITE_ADDRESS, newSiteAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getHideUserListForNonAdmin() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideUserListForNonAdmin(Boolean newHideUserListForNonAdmin) {
		eSet(StorePackage.Literals.SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN, newHideUserListForNonAdmin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getProtocolBuffersPort() {
		return (Integer) eGet(StorePackage.Literals.SETTINGS__PROTOCOL_BUFFERS_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocolBuffersPort(Integer newProtocolBuffersPort) {
		eSet(StorePackage.Literals.SETTINGS__PROTOCOL_BUFFERS_PORT, newProtocolBuffersPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Serializer> getSerializers() {
		return (EList<Serializer>) eGet(StorePackage.Literals.SETTINGS__SERIALIZERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ObjectIDM> getObjectIDMs() {
		return (EList<ObjectIDM>) eGet(StorePackage.Literals.SETTINGS__OBJECT_ID_MS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeaderAddition() {
		return (String) eGet(StorePackage.Literals.SETTINGS__HEADER_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderAddition(String newHeaderAddition) {
		eSet(StorePackage.Literals.SETTINGS__HEADER_ADDITION, newHeaderAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFooterAddition() {
		return (String) eGet(StorePackage.Literals.SETTINGS__FOOTER_ADDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooterAddition(String newFooterAddition) {
		eSet(StorePackage.Literals.SETTINGS__FOOTER_ADDITION, newFooterAddition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeIdentifier getMergeIdentifier() {
		return (MergeIdentifier) eGet(StorePackage.Literals.SETTINGS__MERGE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMergeIdentifier(MergeIdentifier newMergeIdentifier) {
		eSet(StorePackage.Literals.SETTINGS__MERGE_IDENTIFIER, newMergeIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCacheOutputFiles() {
		return (Boolean) eGet(StorePackage.Literals.SETTINGS__CACHE_OUTPUT_FILES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheOutputFiles(Boolean newCacheOutputFiles) {
		eSet(StorePackage.Literals.SETTINGS__CACHE_OUTPUT_FILES, newCacheOutputFiles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcEngine> getIfcEngines() {
		return (EList<IfcEngine>) eGet(StorePackage.Literals.SETTINGS__IFC_ENGINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Plugin> getPlugins() {
		return (EList<Plugin>) eGet(StorePackage.Literals.SETTINGS__PLUGINS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Deserializer> getDeserializers() {
		return (EList<Deserializer>) eGet(StorePackage.Literals.SETTINGS__DESERIALIZERS, true);
	}

} //SettingsImpl
