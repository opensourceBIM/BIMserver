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
import org.bimserver.models.log.AccessMethod;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.UserSession#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getUsername <em>Username</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getRemoteAddress <em>Remote Address</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getActiveSince <em>Active Since</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getLastActive <em>Last Active</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSession#getAccessMethod <em>Access Method</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getUserSession()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface UserSession extends IdEObject {
	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_User()
	 * @model
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

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
	 * @see org.bimserver.models.store.StorePackage#getUserSession_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getUserSession_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.UserType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.UserType
	 * @see #setType(UserType)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_Type()
	 * @model
	 * @generated
	 */
	UserType getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.UserType
	 * @see #getType()
	 * @generated
	 */
	void setType(UserType value);

	/**
	 * Returns the value of the '<em><b>Remote Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Address</em>' attribute.
	 * @see #setRemoteAddress(String)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_RemoteAddress()
	 * @model
	 * @generated
	 */
	String getRemoteAddress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getRemoteAddress <em>Remote Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Address</em>' attribute.
	 * @see #getRemoteAddress()
	 * @generated
	 */
	void setRemoteAddress(String value);

	/**
	 * Returns the value of the '<em><b>Active Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Since</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Since</em>' attribute.
	 * @see #setActiveSince(Date)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_ActiveSince()
	 * @model
	 * @generated
	 */
	Date getActiveSince();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getActiveSince <em>Active Since</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Since</em>' attribute.
	 * @see #getActiveSince()
	 * @generated
	 */
	void setActiveSince(Date value);

	/**
	 * Returns the value of the '<em><b>Last Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Active</em>' attribute.
	 * @see #setLastActive(Date)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_LastActive()
	 * @model
	 * @generated
	 */
	Date getLastActive();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getLastActive <em>Last Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Active</em>' attribute.
	 * @see #getLastActive()
	 * @generated
	 */
	void setLastActive(Date value);

	/**
	 * Returns the value of the '<em><b>Access Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.log.AccessMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Method</em>' attribute.
	 * @see org.bimserver.models.log.AccessMethod
	 * @see #setAccessMethod(AccessMethod)
	 * @see org.bimserver.models.store.StorePackage#getUserSession_AccessMethod()
	 * @model
	 * @generated
	 */
	AccessMethod getAccessMethod();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSession#getAccessMethod <em>Access Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Method</em>' attribute.
	 * @see org.bimserver.models.log.AccessMethod
	 * @see #getAccessMethod()
	 * @generated
	 */
	void setAccessMethod(AccessMethod value);

} // UserSession
