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

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSession;
import org.bimserver.models.store.UserType;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Session</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getRemoteAddress <em>Remote Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getActiveSince <em>Active Since</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getLastActive <em>Last Active</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSessionImpl#getAccessMethod <em>Access Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserSessionImpl extends IdEObjectImpl implements UserSession {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserSessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.USER_SESSION;
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
	public User getUser() {
		return (User) eGet(StorePackage.Literals.USER_SESSION__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.USER_SESSION__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return (String) eGet(StorePackage.Literals.USER_SESSION__USERNAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		eSet(StorePackage.Literals.USER_SESSION__USERNAME, newUsername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(StorePackage.Literals.USER_SESSION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.USER_SESSION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserType getType() {
		return (UserType) eGet(StorePackage.Literals.USER_SESSION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(UserType newType) {
		eSet(StorePackage.Literals.USER_SESSION__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteAddress() {
		return (String) eGet(
				StorePackage.Literals.USER_SESSION__REMOTE_ADDRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteAddress(String newRemoteAddress) {
		eSet(StorePackage.Literals.USER_SESSION__REMOTE_ADDRESS,
				newRemoteAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getActiveSince() {
		return (Date) eGet(StorePackage.Literals.USER_SESSION__ACTIVE_SINCE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveSince(Date newActiveSince) {
		eSet(StorePackage.Literals.USER_SESSION__ACTIVE_SINCE, newActiveSince);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastActive() {
		return (Date) eGet(StorePackage.Literals.USER_SESSION__LAST_ACTIVE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastActive(Date newLastActive) {
		eSet(StorePackage.Literals.USER_SESSION__LAST_ACTIVE, newLastActive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethod getAccessMethod() {
		return (AccessMethod) eGet(
				StorePackage.Literals.USER_SESSION__ACCESS_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessMethod(AccessMethod newAccessMethod) {
		eSet(StorePackage.Literals.USER_SESSION__ACCESS_METHOD, newAccessMethod);
	}

} //UserSessionImpl
