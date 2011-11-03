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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isUseCaching <em>Use Caching</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAutoTestClashes <em>Auto Test Clashes</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isIntelligentMerging <em>Intelligent Merging</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getRegistrationAddition <em>Registration Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getCustomLogoAddress <em>Custom Logo Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getProtocolBuffersPort <em>Protocol Buffers Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getObjectIDMs <em>Object ID Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getHeaderAddition <em>Header Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getFooterAddition <em>Footer Addition</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getMergeIdentifier <em>Merge Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#isCacheOutputFiles <em>Cache Output Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getIfcEngines <em>Ifc Engines</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.bimserver.models.store.Settings#getDeserializers <em>Deserializers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Settings extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Show Version Upgrade Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Version Upgrade Available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Version Upgrade Available</em>' attribute.
	 * @see #setShowVersionUpgradeAvailable(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_ShowVersionUpgradeAvailable()
	 * @model
	 * @generated
	 */
	boolean isShowVersionUpgradeAvailable();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Version Upgrade Available</em>' attribute.
	 * @see #isShowVersionUpgradeAvailable()
	 * @generated
	 */
	void setShowVersionUpgradeAvailable(boolean value);

	/**
	 * Returns the value of the '<em><b>Send Confirmation Email After Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Confirmation Email After Registration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Confirmation Email After Registration</em>' attribute.
	 * @see #setSendConfirmationEmailAfterRegistration(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SendConfirmationEmailAfterRegistration()
	 * @model
	 * @generated
	 */
	boolean isSendConfirmationEmailAfterRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Confirmation Email After Registration</em>' attribute.
	 * @see #isSendConfirmationEmailAfterRegistration()
	 * @generated
	 */
	void setSendConfirmationEmailAfterRegistration(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Caching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Caching</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Caching</em>' attribute.
	 * @see #setUseCaching(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_UseCaching()
	 * @model
	 * @generated
	 */
	boolean isUseCaching();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isUseCaching <em>Use Caching</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Caching</em>' attribute.
	 * @see #isUseCaching()
	 * @generated
	 */
	void setUseCaching(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Self Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Self Registration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #setAllowSelfRegistration(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AllowSelfRegistration()
	 * @model
	 * @generated
	 */
	boolean isAllowSelfRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAllowSelfRegistration <em>Allow Self Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #isAllowSelfRegistration()
	 * @generated
	 */
	void setAllowSelfRegistration(boolean value);

	/**
	 * Returns the value of the '<em><b>Auto Test Clashes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Test Clashes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Test Clashes</em>' attribute.
	 * @see #setAutoTestClashes(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AutoTestClashes()
	 * @model
	 * @generated
	 */
	boolean isAutoTestClashes();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAutoTestClashes <em>Auto Test Clashes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Test Clashes</em>' attribute.
	 * @see #isAutoTestClashes()
	 * @generated
	 */
	void setAutoTestClashes(boolean value);

	/**
	 * Returns the value of the '<em><b>Intelligent Merging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intelligent Merging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intelligent Merging</em>' attribute.
	 * @see #setIntelligentMerging(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_IntelligentMerging()
	 * @model
	 * @generated
	 */
	boolean isIntelligentMerging();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isIntelligentMerging <em>Intelligent Merging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intelligent Merging</em>' attribute.
	 * @see #isIntelligentMerging()
	 * @generated
	 */
	void setIntelligentMerging(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Users To Create Top Level Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Users To Create Top Level Projects</em>' attribute.
	 * @see #setAllowUsersToCreateTopLevelProjects(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_AllowUsersToCreateTopLevelProjects()
	 * @model
	 * @generated
	 */
	boolean isAllowUsersToCreateTopLevelProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Users To Create Top Level Projects</em>' attribute.
	 * @see #isAllowUsersToCreateTopLevelProjects()
	 * @generated
	 */
	void setAllowUsersToCreateTopLevelProjects(boolean value);

	/**
	 * Returns the value of the '<em><b>Checkin Merging Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkin Merging Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkin Merging Enabled</em>' attribute.
	 * @see #setCheckinMergingEnabled(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_CheckinMergingEnabled()
	 * @model
	 * @generated
	 */
	boolean isCheckinMergingEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkin Merging Enabled</em>' attribute.
	 * @see #isCheckinMergingEnabled()
	 * @generated
	 */
	void setCheckinMergingEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Registration Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Addition</em>' attribute.
	 * @see #setRegistrationAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_RegistrationAddition()
	 * @model
	 * @generated
	 */
	String getRegistrationAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getRegistrationAddition <em>Registration Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Addition</em>' attribute.
	 * @see #getRegistrationAddition()
	 * @generated
	 */
	void setRegistrationAddition(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Server</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Server</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Server</em>' attribute.
	 * @see #setSmtpServer(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SmtpServer()
	 * @model
	 * @generated
	 */
	String getSmtpServer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getSmtpServer <em>Smtp Server</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Server</em>' attribute.
	 * @see #getSmtpServer()
	 * @generated
	 */
	void setSmtpServer(String value);

	/**
	 * Returns the value of the '<em><b>Email Sender Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email Sender Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email Sender Address</em>' attribute.
	 * @see #setEmailSenderAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_EmailSenderAddress()
	 * @model
	 * @generated
	 */
	String getEmailSenderAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getEmailSenderAddress <em>Email Sender Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Sender Address</em>' attribute.
	 * @see #getEmailSenderAddress()
	 * @generated
	 */
	void setEmailSenderAddress(String value);

	/**
	 * Returns the value of the '<em><b>Custom Logo Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Logo Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Logo Address</em>' attribute.
	 * @see #setCustomLogoAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_CustomLogoAddress()
	 * @model
	 * @generated
	 */
	String getCustomLogoAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getCustomLogoAddress <em>Custom Logo Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Logo Address</em>' attribute.
	 * @see #getCustomLogoAddress()
	 * @generated
	 */
	void setCustomLogoAddress(String value);

	/**
	 * Returns the value of the '<em><b>Site Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site Address</em>' attribute.
	 * @see #setSiteAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_SiteAddress()
	 * @model
	 * @generated
	 */
	String getSiteAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getSiteAddress <em>Site Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site Address</em>' attribute.
	 * @see #getSiteAddress()
	 * @generated
	 */
	void setSiteAddress(String value);

	/**
	 * Returns the value of the '<em><b>Hide User List For Non Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide User List For Non Admin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide User List For Non Admin</em>' attribute.
	 * @see #setHideUserListForNonAdmin(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_HideUserListForNonAdmin()
	 * @model
	 * @generated
	 */
	boolean isHideUserListForNonAdmin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide User List For Non Admin</em>' attribute.
	 * @see #isHideUserListForNonAdmin()
	 * @generated
	 */
	void setHideUserListForNonAdmin(boolean value);

	/**
	 * Returns the value of the '<em><b>Protocol Buffers Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol Buffers Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol Buffers Port</em>' attribute.
	 * @see #setProtocolBuffersPort(int)
	 * @see org.bimserver.models.store.StorePackage#getSettings_ProtocolBuffersPort()
	 * @model
	 * @generated
	 */
	int getProtocolBuffersPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getProtocolBuffersPort <em>Protocol Buffers Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Buffers Port</em>' attribute.
	 * @see #getProtocolBuffersPort()
	 * @generated
	 */
	void setProtocolBuffersPort(int value);

	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Serializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_Serializers()
	 * @see org.bimserver.models.store.Serializer#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Serializer> getSerializers();

	/**
	 * Returns the value of the '<em><b>Object ID Ms</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ObjectIDM}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ObjectIDM#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object ID Ms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object ID Ms</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_ObjectIDMs()
	 * @see org.bimserver.models.store.ObjectIDM#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ObjectIDM> getObjectIDMs();

	/**
	 * Returns the value of the '<em><b>Header Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Addition</em>' attribute.
	 * @see #setHeaderAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_HeaderAddition()
	 * @model
	 * @generated
	 */
	String getHeaderAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getHeaderAddition <em>Header Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Addition</em>' attribute.
	 * @see #getHeaderAddition()
	 * @generated
	 */
	void setHeaderAddition(String value);

	/**
	 * Returns the value of the '<em><b>Footer Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer Addition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footer Addition</em>' attribute.
	 * @see #setFooterAddition(String)
	 * @see org.bimserver.models.store.StorePackage#getSettings_FooterAddition()
	 * @model
	 * @generated
	 */
	String getFooterAddition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getFooterAddition <em>Footer Addition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footer Addition</em>' attribute.
	 * @see #getFooterAddition()
	 * @generated
	 */
	void setFooterAddition(String value);

	/**
	 * Returns the value of the '<em><b>Merge Identifier</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.MergeIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge Identifier</em>' attribute.
	 * @see org.bimserver.models.store.MergeIdentifier
	 * @see #setMergeIdentifier(MergeIdentifier)
	 * @see org.bimserver.models.store.StorePackage#getSettings_MergeIdentifier()
	 * @model
	 * @generated
	 */
	MergeIdentifier getMergeIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#getMergeIdentifier <em>Merge Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merge Identifier</em>' attribute.
	 * @see org.bimserver.models.store.MergeIdentifier
	 * @see #getMergeIdentifier()
	 * @generated
	 */
	void setMergeIdentifier(MergeIdentifier value);

	/**
	 * Returns the value of the '<em><b>Cache Output Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Output Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Output Files</em>' attribute.
	 * @see #setCacheOutputFiles(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSettings_CacheOutputFiles()
	 * @model
	 * @generated
	 */
	boolean isCacheOutputFiles();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Settings#isCacheOutputFiles <em>Cache Output Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Output Files</em>' attribute.
	 * @see #isCacheOutputFiles()
	 * @generated
	 */
	void setCacheOutputFiles(boolean value);

	/**
	 * Returns the value of the '<em><b>Ifc Engines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.IfcEngine}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IfcEngine#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Engines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Engines</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_IfcEngines()
	 * @see org.bimserver.models.store.IfcEngine#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<IfcEngine> getIfcEngines();

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Plugin}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Plugin#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugins</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_Plugins()
	 * @see org.bimserver.models.store.Plugin#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Plugin> getPlugins();

	/**
	 * Returns the value of the '<em><b>Deserializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Deserializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Deserializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deserializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deserializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getSettings_Deserializers()
	 * @see org.bimserver.models.store.Deserializer#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Deserializer> getDeserializers();

} // Settings
