/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isUseCaching <em>Use Caching</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isAutoTestClashes <em>Auto Test Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isIntelligentMerging <em>Intelligent Merging</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getRegistrationAddition <em>Registration Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getEnabledExportTypes <em>Enabled Export Types</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getCustomLogoAddress <em>Custom Logo Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SettingsImpl#getSiteAddress <em>Site Address</em>}</li>
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
	public boolean isShowVersionUpgradeAvailable() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowVersionUpgradeAvailable(boolean newShowVersionUpgradeAvailable) {
		eSet(StorePackage.Literals.SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE, newShowVersionUpgradeAvailable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSendConfirmationEmailAfterRegistration() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION, true);
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
	public boolean isUseCaching() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__USE_CACHING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCaching(boolean newUseCaching) {
		eSet(StorePackage.Literals.SETTINGS__USE_CACHING, newUseCaching);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowSelfRegistration() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__ALLOW_SELF_REGISTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowSelfRegistration(boolean newAllowSelfRegistration) {
		eSet(StorePackage.Literals.SETTINGS__ALLOW_SELF_REGISTRATION, newAllowSelfRegistration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoTestClashes() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__AUTO_TEST_CLASHES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoTestClashes(boolean newAutoTestClashes) {
		eSet(StorePackage.Literals.SETTINGS__AUTO_TEST_CLASHES, newAutoTestClashes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntelligentMerging() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__INTELLIGENT_MERGING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntelligentMerging(boolean newIntelligentMerging) {
		eSet(StorePackage.Literals.SETTINGS__INTELLIGENT_MERGING, newIntelligentMerging);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUsersToCreateTopLevelProjects() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS, true);
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
	public boolean isCheckinMergingEnabled() {
		return (Boolean)eGet(StorePackage.Literals.SETTINGS__CHECKIN_MERGING_ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckinMergingEnabled(boolean newCheckinMergingEnabled) {
		eSet(StorePackage.Literals.SETTINGS__CHECKIN_MERGING_ENABLED, newCheckinMergingEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationAddition() {
		return (String)eGet(StorePackage.Literals.SETTINGS__REGISTRATION_ADDITION, true);
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
		return (String)eGet(StorePackage.Literals.SETTINGS__SMTP_SERVER, true);
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
		return (String)eGet(StorePackage.Literals.SETTINGS__EMAIL_SENDER_ADDRESS, true);
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
	public String getEnabledExportTypes() {
		return (String)eGet(StorePackage.Literals.SETTINGS__ENABLED_EXPORT_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledExportTypes(String newEnabledExportTypes) {
		eSet(StorePackage.Literals.SETTINGS__ENABLED_EXPORT_TYPES, newEnabledExportTypes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomLogoAddress() {
		return (String)eGet(StorePackage.Literals.SETTINGS__CUSTOM_LOGO_ADDRESS, true);
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
		return (String)eGet(StorePackage.Literals.SETTINGS__SITE_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSiteAddress(String newSiteAddress) {
		eSet(StorePackage.Literals.SETTINGS__SITE_ADDRESS, newSiteAddress);
	}

} //SettingsImpl
