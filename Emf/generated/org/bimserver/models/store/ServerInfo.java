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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ServerInfo#getServerState <em>Server State</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServerInfo#getErrorMessage <em>Error Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getServerInfo()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ServerInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Server State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ServerState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server State</em>' attribute.
	 * @see org.bimserver.models.store.ServerState
	 * @see #setServerState(ServerState)
	 * @see org.bimserver.models.store.StorePackage#getServerInfo_ServerState()
	 * @model
	 * @generated
	 */
	ServerState getServerState();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerInfo#getServerState <em>Server State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server State</em>' attribute.
	 * @see org.bimserver.models.store.ServerState
	 * @see #getServerState()
	 * @generated
	 */
	void setServerState(ServerState value);

	/**
	 * Returns the value of the '<em><b>Error Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Message</em>' attribute.
	 * @see #setErrorMessage(String)
	 * @see org.bimserver.models.store.StorePackage#getServerInfo_ErrorMessage()
	 * @model
	 * @generated
	 */
	String getErrorMessage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServerInfo#getErrorMessage <em>Error Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Message</em>' attribute.
	 * @see #getErrorMessage()
	 * @generated
	 */
	void setErrorMessage(String value);

} // ServerInfo
