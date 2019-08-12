/**
 * Copyright (C) 2009-2014 BIMserver.org
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

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getAllowSelfRegistration <em>Allow Self Registration</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSmtpServer <em>Smtp Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getEmailSenderAddress <em>Email Sender Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getEmailSenderName <em>Email Sender Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSiteAddress <em>Site Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isGenerateGeometryOnCheckin <em>Generate Geometry On Checkin</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isAllowOnlyWhitelisted <em>Allow Only Whitelisted</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getWhitelistedDomains <em>Whitelisted Domains</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getProtocolBuffersPort <em>Protocol Buffers Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getCacheOutputFiles <em>Cache Output Files</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getWebModules <em>Web Modules</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getWebModule <em>Web Module</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getServiceRepositoryUrl <em>Service Repository Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSessionTimeOutSeconds <em>Session Time Out Seconds</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSmtpUsername <em>Smtp Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSmtpPassword <em>Smtp Password</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getSmtpProtocol <em>Smtp Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isReuseGeometry <em>Reuse Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isAllowCreateValidatedUser <em>Allow Create Validated User</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getRenderEngineProcesses <em>Render Engine Processes</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isPluginStrictVersionChecking <em>Plugin Strict Version Checking</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isStoreLastLogin <em>Store Last Login</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isStoreServiceRuns <em>Store Service Runs</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#isOptimizeMappedItems <em>Optimize Mapped Items</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerSettings#getDefaultRenderEnginePlugin <em>Default Render Engine Plugin</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getServerSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ServerSettings extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SendConfirmationEmailAfterRegistration()
	 * @model
	 * @generated
	 */
	boolean isSendConfirmationEmailAfterRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Confirmation Email After Registration</em>' attribute.
	 * @see #isSendConfirmationEmailAfterRegistration()
	 * @generated
	 */
	void setSendConfirmationEmailAfterRegistration(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Self Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Self Registration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #setAllowSelfRegistration(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_AllowSelfRegistration()
	 * @model
	 * @generated
	 */
	Boolean getAllowSelfRegistration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getAllowSelfRegistration <em>Allow Self Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Self Registration</em>' attribute.
	 * @see #getAllowSelfRegistration()
	 * @generated
	 */
	void setAllowSelfRegistration(Boolean value);

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
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_AllowUsersToCreateTopLevelProjects()
	 * @model
	 * @generated
	 */
	boolean isAllowUsersToCreateTopLevelProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}' attribute.
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
	 * @see #setCheckinMergingEnabled(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_CheckinMergingEnabled()
	 * @model
	 * @generated
	 */
	Boolean getCheckinMergingEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkin Merging Enabled</em>' attribute.
	 * @see #getCheckinMergingEnabled()
	 * @generated
	 */
	void setCheckinMergingEnabled(Boolean value);

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
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SmtpServer()
	 * @model
	 * @generated
	 */
	String getSmtpServer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSmtpServer <em>Smtp Server</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_EmailSenderAddress()
	 * @model
	 * @generated
	 */
	String getEmailSenderAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getEmailSenderAddress <em>Email Sender Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Sender Address</em>' attribute.
	 * @see #getEmailSenderAddress()
	 * @generated
	 */
	void setEmailSenderAddress(String value);

	/**
	 * Returns the value of the '<em><b>Email Sender Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email Sender Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email Sender Name</em>' attribute.
	 * @see #setEmailSenderName(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_EmailSenderName()
	 * @model
	 * @generated
	 */
	String getEmailSenderName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getEmailSenderName <em>Email Sender Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email Sender Name</em>' attribute.
	 * @see #getEmailSenderName()
	 * @generated
	 */
	void setEmailSenderName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SiteAddress()
	 * @model
	 * @generated
	 */
	String getSiteAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSiteAddress <em>Site Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site Address</em>' attribute.
	 * @see #getSiteAddress()
	 * @generated
	 */
	void setSiteAddress(String value);

	/**
	 * Returns the value of the '<em><b>Generate Geometry On Checkin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Geometry On Checkin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Geometry On Checkin</em>' attribute.
	 * @see #setGenerateGeometryOnCheckin(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_GenerateGeometryOnCheckin()
	 * @model
	 * @generated
	 */
	boolean isGenerateGeometryOnCheckin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isGenerateGeometryOnCheckin <em>Generate Geometry On Checkin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Geometry On Checkin</em>' attribute.
	 * @see #isGenerateGeometryOnCheckin()
	 * @generated
	 */
	void setGenerateGeometryOnCheckin(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Only Whitelisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Only Whitelisted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Only Whitelisted</em>' attribute.
	 * @see #setAllowOnlyWhitelisted(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_AllowOnlyWhitelisted()
	 * @model
	 * @generated
	 */
	boolean isAllowOnlyWhitelisted();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isAllowOnlyWhitelisted <em>Allow Only Whitelisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Only Whitelisted</em>' attribute.
	 * @see #isAllowOnlyWhitelisted()
	 * @generated
	 */
	void setAllowOnlyWhitelisted(boolean value);

	/**
	 * Returns the value of the '<em><b>Whitelisted Domains</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Whitelisted Domains</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Whitelisted Domains</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_WhitelistedDomains()
	 * @model
	 * @generated
	 */
	EList<String> getWhitelistedDomains();

	/**
	 * Returns the value of the '<em><b>Hide User List For Non Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide User List For Non Admin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide User List For Non Admin</em>' attribute.
	 * @see #setHideUserListForNonAdmin(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_HideUserListForNonAdmin()
	 * @model
	 * @generated
	 */
	Boolean getHideUserListForNonAdmin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide User List For Non Admin</em>' attribute.
	 * @see #getHideUserListForNonAdmin()
	 * @generated
	 */
	void setHideUserListForNonAdmin(Boolean value);

	/**
	 * Returns the value of the '<em><b>Protocol Buffers Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol Buffers Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol Buffers Port</em>' attribute.
	 * @see #setProtocolBuffersPort(Integer)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_ProtocolBuffersPort()
	 * @model
	 * @generated
	 */
	Integer getProtocolBuffersPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getProtocolBuffersPort <em>Protocol Buffers Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Buffers Port</em>' attribute.
	 * @see #getProtocolBuffersPort()
	 * @generated
	 */
	void setProtocolBuffersPort(Integer value);

	/**
	 * Returns the value of the '<em><b>Cache Output Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Output Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Output Files</em>' attribute.
	 * @see #setCacheOutputFiles(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_CacheOutputFiles()
	 * @model
	 * @generated
	 */
	Boolean getCacheOutputFiles();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getCacheOutputFiles <em>Cache Output Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Output Files</em>' attribute.
	 * @see #getCacheOutputFiles()
	 * @generated
	 */
	void setCacheOutputFiles(Boolean value);

	/**
	 * Returns the value of the '<em><b>Web Modules</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.WebModulePluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.WebModulePluginConfiguration#getServerSettings <em>Server Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Modules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Modules</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_WebModules()
	 * @see org.bimserver.models.store.WebModulePluginConfiguration#getServerSettings
	 * @model opposite="serverSettings"
	 * @generated
	 */
	EList<WebModulePluginConfiguration> getWebModules();

	/**
	 * Returns the value of the '<em><b>Web Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Module</em>' reference.
	 * @see #setWebModule(WebModulePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_WebModule()
	 * @model
	 * @generated
	 */
	WebModulePluginConfiguration getWebModule();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getWebModule <em>Web Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Module</em>' reference.
	 * @see #getWebModule()
	 * @generated
	 */
	void setWebModule(WebModulePluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Service Repository Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Repository Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Repository Url</em>' attribute.
	 * @see #setServiceRepositoryUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_ServiceRepositoryUrl()
	 * @model
	 * @generated
	 */
	String getServiceRepositoryUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getServiceRepositoryUrl <em>Service Repository Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Repository Url</em>' attribute.
	 * @see #getServiceRepositoryUrl()
	 * @generated
	 */
	void setServiceRepositoryUrl(String value);

	/**
	 * Returns the value of the '<em><b>Send Email On New Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Email On New Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Email On New Revision</em>' attribute.
	 * @see #setSendEmailOnNewRevision(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SendEmailOnNewRevision()
	 * @model
	 * @generated
	 */
	boolean isSendEmailOnNewRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Email On New Revision</em>' attribute.
	 * @see #isSendEmailOnNewRevision()
	 * @generated
	 */
	void setSendEmailOnNewRevision(boolean value);

	/**
	 * Returns the value of the '<em><b>Session Time Out Seconds</b></em>' attribute.
	 * The default value is <code>"2592000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Time Out Seconds</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Time Out Seconds</em>' attribute.
	 * @see #setSessionTimeOutSeconds(int)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SessionTimeOutSeconds()
	 * @model default="2592000"
	 * @generated
	 */
	int getSessionTimeOutSeconds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSessionTimeOutSeconds <em>Session Time Out Seconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Time Out Seconds</em>' attribute.
	 * @see #getSessionTimeOutSeconds()
	 * @generated
	 */
	void setSessionTimeOutSeconds(int value);

	/**
	 * Returns the value of the '<em><b>Smtp Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Username</em>' attribute.
	 * @see #setSmtpUsername(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SmtpUsername()
	 * @model
	 * @generated
	 */
	String getSmtpUsername();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSmtpUsername <em>Smtp Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Username</em>' attribute.
	 * @see #getSmtpUsername()
	 * @generated
	 */
	void setSmtpUsername(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Password</em>' attribute.
	 * @see #setSmtpPassword(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SmtpPassword()
	 * @model
	 * @generated
	 */
	String getSmtpPassword();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSmtpPassword <em>Smtp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Password</em>' attribute.
	 * @see #getSmtpPassword()
	 * @generated
	 */
	void setSmtpPassword(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Port</b></em>' attribute.
	 * The default value is <code>"25"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Port</em>' attribute.
	 * @see #setSmtpPort(int)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SmtpPort()
	 * @model default="25"
	 * @generated
	 */
	int getSmtpPort();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSmtpPort <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Port</em>' attribute.
	 * @see #getSmtpPort()
	 * @generated
	 */
	void setSmtpPort(int value);

	/**
	 * Returns the value of the '<em><b>Smtp Protocol</b></em>' attribute.
	 * The default value is <code>"SMTP"</code>.
	 * The literals are from the enumeration {@link org.bimserver.models.store.SmtpProtocol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Smtp Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Smtp Protocol</em>' attribute.
	 * @see org.bimserver.models.store.SmtpProtocol
	 * @see #setSmtpProtocol(SmtpProtocol)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_SmtpProtocol()
	 * @model default="SMTP"
	 * @generated
	 */
	SmtpProtocol getSmtpProtocol();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getSmtpProtocol <em>Smtp Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Protocol</em>' attribute.
	 * @see org.bimserver.models.store.SmtpProtocol
	 * @see #getSmtpProtocol()
	 * @generated
	 */
	void setSmtpProtocol(SmtpProtocol value);

	/**
	 * Returns the value of the '<em><b>Reuse Geometry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reuse Geometry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reuse Geometry</em>' attribute.
	 * @see #setReuseGeometry(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_ReuseGeometry()
	 * @model
	 * @generated
	 */
	boolean isReuseGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isReuseGeometry <em>Reuse Geometry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reuse Geometry</em>' attribute.
	 * @see #isReuseGeometry()
	 * @generated
	 */
	void setReuseGeometry(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Create Validated User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Create Validated User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Create Validated User</em>' attribute.
	 * @see #setAllowCreateValidatedUser(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_AllowCreateValidatedUser()
	 * @model
	 * @generated
	 */
	boolean isAllowCreateValidatedUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isAllowCreateValidatedUser <em>Allow Create Validated User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Create Validated User</em>' attribute.
	 * @see #isAllowCreateValidatedUser()
	 * @generated
	 */
	void setAllowCreateValidatedUser(boolean value);

	/**
	 * Returns the value of the '<em><b>Render Engine Processes</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Render Engine Processes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Render Engine Processes</em>' attribute.
	 * @see #setRenderEngineProcesses(int)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_RenderEngineProcesses()
	 * @model default="1"
	 * @generated
	 */
	int getRenderEngineProcesses();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getRenderEngineProcesses <em>Render Engine Processes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Render Engine Processes</em>' attribute.
	 * @see #getRenderEngineProcesses()
	 * @generated
	 */
	void setRenderEngineProcesses(int value);

	/**
	 * Returns the value of the '<em><b>Plugin Strict Version Checking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Strict Version Checking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Strict Version Checking</em>' attribute.
	 * @see #setPluginStrictVersionChecking(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_PluginStrictVersionChecking()
	 * @model
	 * @generated
	 */
	boolean isPluginStrictVersionChecking();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isPluginStrictVersionChecking <em>Plugin Strict Version Checking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Strict Version Checking</em>' attribute.
	 * @see #isPluginStrictVersionChecking()
	 * @generated
	 */
	void setPluginStrictVersionChecking(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Store Last Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Last Login</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Last Login</em>' attribute.
	 * @see #setStoreLastLogin(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_StoreLastLogin()
	 * @model
	 * @generated
	 */
	boolean isStoreLastLogin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isStoreLastLogin <em>Store Last Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Last Login</em>' attribute.
	 * @see #isStoreLastLogin()
	 * @generated
	 */
	void setStoreLastLogin(boolean value);

	/**
	 * Returns the value of the '<em><b>Store Service Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Service Runs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Service Runs</em>' attribute.
	 * @see #setStoreServiceRuns(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_StoreServiceRuns()
	 * @model
	 * @generated
	 */
	boolean isStoreServiceRuns();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isStoreServiceRuns <em>Store Service Runs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Service Runs</em>' attribute.
	 * @see #isStoreServiceRuns()
	 * @generated
	 */
	void setStoreServiceRuns(boolean value);

	/**
	 * Returns the value of the '<em><b>Optimize Mapped Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optimize Mapped Items</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize Mapped Items</em>' attribute.
	 * @see #setOptimizeMappedItems(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_OptimizeMappedItems()
	 * @model
	 * @generated
	 */
	boolean isOptimizeMappedItems();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#isOptimizeMappedItems <em>Optimize Mapped Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize Mapped Items</em>' attribute.
	 * @see #isOptimizeMappedItems()
	 * @generated
	 */
	void setOptimizeMappedItems(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Render Engine Plugin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Render Engine Plugin</em>' reference.
	 * @see #setDefaultRenderEnginePlugin(PluginDescriptor)
	 * @see org.bimserver.models.store.StorePackage#getServerSettings_DefaultRenderEnginePlugin()
	 * @model
	 * @generated
	 */
	PluginDescriptor getDefaultRenderEnginePlugin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerSettings#getDefaultRenderEnginePlugin <em>Default Render Engine Plugin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Render Engine Plugin</em>' reference.
	 * @see #getDefaultRenderEnginePlugin()
	 * @generated
	 */
	void setDefaultRenderEnginePlugin(PluginDescriptor value);

} // ServerSettings
