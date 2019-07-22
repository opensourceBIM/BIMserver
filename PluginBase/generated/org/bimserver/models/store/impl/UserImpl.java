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
package org.bimserver.models.store.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.log.UserRelated;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.UserType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getPasswordHash <em>Password Hash</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getPasswordSalt <em>Password Salt</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getHasRightsOn <em>Has Rights On</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getCreatedOn <em>Created On</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getUserType <em>User Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getLastSeen <em>Last Seen</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getValidationToken <em>Validation Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getValidationTokenCreated <em>Validation Token Created</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getUserSettings <em>User Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getLogs <em>Logs</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getOAuthAuthorizationCodes <em>OAuth Authorization Codes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserImpl#getOAuthIssuedAuthorizationCodes <em>OAuth Issued Authorization Codes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserImpl extends IdEObjectImpl implements User {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.USER;
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
	@Override
	public String getName() {
		return (String) eGet(StorePackage.Literals.USER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.USER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getPasswordHash() {
		return (byte[]) eGet(StorePackage.Literals.USER__PASSWORD_HASH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPasswordHash(byte[] newPasswordHash) {
		eSet(StorePackage.Literals.USER__PASSWORD_HASH, newPasswordHash);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getPasswordSalt() {
		return (byte[]) eGet(StorePackage.Literals.USER__PASSWORD_SALT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPasswordSalt(byte[] newPasswordSalt) {
		eSet(StorePackage.Literals.USER__PASSWORD_SALT, newPasswordSalt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Project> getHasRightsOn() {
		return (EList<Project>) eGet(StorePackage.Literals.USER__HAS_RIGHTS_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectState getState() {
		return (ObjectState) eGet(StorePackage.Literals.USER__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(ObjectState newState) {
		eSet(StorePackage.Literals.USER__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getCreatedOn() {
		return (Date) eGet(StorePackage.Literals.USER__CREATED_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedOn(Date newCreatedOn) {
		eSet(StorePackage.Literals.USER__CREATED_ON, newCreatedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User getCreatedBy() {
		return (User) eGet(StorePackage.Literals.USER__CREATED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedBy(User newCreatedBy) {
		eSet(StorePackage.Literals.USER__CREATED_BY, newCreatedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserType getUserType() {
		return (UserType) eGet(StorePackage.Literals.USER__USER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserType(UserType newUserType) {
		eSet(StorePackage.Literals.USER__USER_TYPE, newUserType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUsername() {
		return (String) eGet(StorePackage.Literals.USER__USERNAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsername(String newUsername) {
		eSet(StorePackage.Literals.USER__USERNAME, newUsername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getLastSeen() {
		return (Date) eGet(StorePackage.Literals.USER__LAST_SEEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastSeen(Date newLastSeen) {
		eSet(StorePackage.Literals.USER__LAST_SEEN, newLastSeen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getToken() {
		return (String) eGet(StorePackage.Literals.USER__TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToken(String newToken) {
		eSet(StorePackage.Literals.USER__TOKEN, newToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getValidationToken() {
		return (byte[]) eGet(StorePackage.Literals.USER__VALIDATION_TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationToken(byte[] newValidationToken) {
		eSet(StorePackage.Literals.USER__VALIDATION_TOKEN, newValidationToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getValidationTokenCreated() {
		return (Date) eGet(StorePackage.Literals.USER__VALIDATION_TOKEN_CREATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationTokenCreated(Date newValidationTokenCreated) {
		eSet(StorePackage.Literals.USER__VALIDATION_TOKEN_CREATED, newValidationTokenCreated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserSettings getUserSettings() {
		return (UserSettings) eGet(StorePackage.Literals.USER__USER_SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserSettings(UserSettings newUserSettings) {
		eSet(StorePackage.Literals.USER__USER_SETTINGS, newUserSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ExtendedDataSchema> getSchemas() {
		return (EList<ExtendedDataSchema>) eGet(StorePackage.Literals.USER__SCHEMAS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ExtendedData> getExtendedData() {
		return (EList<ExtendedData>) eGet(StorePackage.Literals.USER__EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Service> getServices() {
		return (EList<Service>) eGet(StorePackage.Literals.USER__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<UserRelated> getLogs() {
		return (EList<UserRelated>) eGet(StorePackage.Literals.USER__LOGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<OAuthAuthorizationCode> getOAuthAuthorizationCodes() {
		return (EList<OAuthAuthorizationCode>) eGet(StorePackage.Literals.USER__OAUTH_AUTHORIZATION_CODES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<OAuthAuthorizationCode> getOAuthIssuedAuthorizationCodes() {
		return (EList<OAuthAuthorizationCode>) eGet(StorePackage.Literals.USER__OAUTH_ISSUED_AUTHORIZATION_CODES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

} //UserImpl
