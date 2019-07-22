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

import java.util.Date;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.UserRelated;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.User#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getPasswordHash <em>Password Hash</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getPasswordSalt <em>Password Salt</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getHasRightsOn <em>Has Rights On</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getUserType <em>User Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getUsername <em>Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getLastSeen <em>Last Seen</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getValidationToken <em>Validation Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getValidationTokenCreated <em>Validation Token Created</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getUserSettings <em>User Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getServices <em>Services</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getLogs <em>Logs</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getOAuthAuthorizationCodes <em>OAuth Authorization Codes</em>}</li>
 *   <li>{@link org.bimserver.models.store.User#getOAuthIssuedAuthorizationCodes <em>OAuth Issued Authorization Codes</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getUser()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface User extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Password Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Hash</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password Hash</em>' attribute.
	 * @see #setPasswordHash(byte[])
	 * @see org.bimserver.models.store.StorePackage#getUser_PasswordHash()
	 * @model
	 * @generated
	 */
	byte[] getPasswordHash();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getPasswordHash <em>Password Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Hash</em>' attribute.
	 * @see #getPasswordHash()
	 * @generated
	 */
	void setPasswordHash(byte[] value);

	/**
	 * Returns the value of the '<em><b>Password Salt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Salt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password Salt</em>' attribute.
	 * @see #setPasswordSalt(byte[])
	 * @see org.bimserver.models.store.StorePackage#getUser_PasswordSalt()
	 * @model
	 * @generated
	 */
	byte[] getPasswordSalt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getPasswordSalt <em>Password Salt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Salt</em>' attribute.
	 * @see #getPasswordSalt()
	 * @generated
	 */
	void setPasswordSalt(byte[] value);

	/**
	 * Returns the value of the '<em><b>Has Rights On</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Project}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getHasAuthorizedUsers <em>Has Authorized Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Rights On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Rights On</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_HasRightsOn()
	 * @see org.bimserver.models.store.Project#getHasAuthorizedUsers
	 * @model opposite="hasAuthorizedUsers"
	 * @generated
	 */
	EList<Project> getHasRightsOn();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ObjectState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #setState(ObjectState)
	 * @see org.bimserver.models.store.StorePackage#getUser_State()
	 * @model
	 * @generated
	 */
	ObjectState getState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.bimserver.models.store.ObjectState
	 * @see #getState()
	 * @generated
	 */
	void setState(ObjectState value);

	/**
	 * Returns the value of the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created On</em>' attribute.
	 * @see #setCreatedOn(Date)
	 * @see org.bimserver.models.store.StorePackage#getUser_CreatedOn()
	 * @model
	 * @generated
	 */
	Date getCreatedOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getCreatedOn <em>Created On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created On</em>' attribute.
	 * @see #getCreatedOn()
	 * @generated
	 */
	void setCreatedOn(Date value);

	/**
	 * Returns the value of the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created By</em>' reference.
	 * @see #setCreatedBy(User)
	 * @see org.bimserver.models.store.StorePackage#getUser_CreatedBy()
	 * @model
	 * @generated
	 */
	User getCreatedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getCreatedBy <em>Created By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created By</em>' reference.
	 * @see #getCreatedBy()
	 * @generated
	 */
	void setCreatedBy(User value);

	/**
	 * Returns the value of the '<em><b>User Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.UserType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Type</em>' attribute.
	 * @see org.bimserver.models.store.UserType
	 * @see #setUserType(UserType)
	 * @see org.bimserver.models.store.StorePackage#getUser_UserType()
	 * @model
	 * @generated
	 */
	UserType getUserType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getUserType <em>User Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Type</em>' attribute.
	 * @see org.bimserver.models.store.UserType
	 * @see #getUserType()
	 * @generated
	 */
	void setUserType(UserType value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.bimserver.models.store.StorePackage#getUser_Username()
	 * @model annotation="unique"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Last Seen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Seen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Seen</em>' attribute.
	 * @see #setLastSeen(Date)
	 * @see org.bimserver.models.store.StorePackage#getUser_LastSeen()
	 * @model
	 * @generated
	 */
	Date getLastSeen();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getLastSeen <em>Last Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Seen</em>' attribute.
	 * @see #getLastSeen()
	 * @generated
	 */
	void setLastSeen(Date value);

	/**
	 * Returns the value of the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' attribute.
	 * @see #setToken(String)
	 * @see org.bimserver.models.store.StorePackage#getUser_Token()
	 * @model
	 * @generated
	 */
	String getToken();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getToken <em>Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' attribute.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(String value);

	/**
	 * Returns the value of the '<em><b>Validation Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Token</em>' attribute.
	 * @see #setValidationToken(byte[])
	 * @see org.bimserver.models.store.StorePackage#getUser_ValidationToken()
	 * @model
	 * @generated
	 */
	byte[] getValidationToken();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getValidationToken <em>Validation Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Token</em>' attribute.
	 * @see #getValidationToken()
	 * @generated
	 */
	void setValidationToken(byte[] value);

	/**
	 * Returns the value of the '<em><b>Validation Token Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Token Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Token Created</em>' attribute.
	 * @see #setValidationTokenCreated(Date)
	 * @see org.bimserver.models.store.StorePackage#getUser_ValidationTokenCreated()
	 * @model
	 * @generated
	 */
	Date getValidationTokenCreated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getValidationTokenCreated <em>Validation Token Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Token Created</em>' attribute.
	 * @see #getValidationTokenCreated()
	 * @generated
	 */
	void setValidationTokenCreated(Date value);

	/**
	 * Returns the value of the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Settings</em>' reference.
	 * @see #setUserSettings(UserSettings)
	 * @see org.bimserver.models.store.StorePackage#getUser_UserSettings()
	 * @model
	 * @generated
	 */
	UserSettings getUserSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.User#getUserSettings <em>User Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Settings</em>' reference.
	 * @see #getUserSettings()
	 * @generated
	 */
	void setUserSettings(UserSettings value);

	/**
	 * Returns the value of the '<em><b>Schemas</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ExtendedDataSchema}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExtendedDataSchema#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schemas</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schemas</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_Schemas()
	 * @see org.bimserver.models.store.ExtendedDataSchema#getUsers
	 * @model opposite="users"
	 * @generated
	 */
	EList<ExtendedDataSchema> getSchemas();

	/**
	 * Returns the value of the '<em><b>Extended Data</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ExtendedData}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExtendedData#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Data</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_ExtendedData()
	 * @see org.bimserver.models.store.ExtendedData#getUser
	 * @model opposite="user"
	 * @generated
	 */
	EList<ExtendedData> getExtendedData();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Service}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Service#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_Services()
	 * @see org.bimserver.models.store.Service#getUser
	 * @model opposite="user"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Logs</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.log.UserRelated}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.log.UserRelated#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logs</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_Logs()
	 * @see org.bimserver.models.log.UserRelated#getUser
	 * @model opposite="user"
	 * @generated
	 */
	EList<UserRelated> getLogs();

	/**
	 * Returns the value of the '<em><b>OAuth Authorization Codes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.OAuthAuthorizationCode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OAuth Authorization Codes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OAuth Authorization Codes</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_OAuthAuthorizationCodes()
	 * @model
	 * @generated
	 */
	EList<OAuthAuthorizationCode> getOAuthAuthorizationCodes();

	/**
	 * Returns the value of the '<em><b>OAuth Issued Authorization Codes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.OAuthAuthorizationCode}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.OAuthAuthorizationCode#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OAuth Issued Authorization Codes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OAuth Issued Authorization Codes</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUser_OAuthIssuedAuthorizationCodes()
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getUser
	 * @model opposite="user"
	 * @generated
	 */
	EList<OAuthAuthorizationCode> getOAuthIssuedAuthorizationCodes();

	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see org.bimserver.models.store.StorePackage#getUser_Uuid()
	 * @model annotation="unique"
	 *        annotation="singleindex"
	 * @generated
	 */

} // User
