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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OAuth Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.OAuthClient#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthClient#getClientSecret <em>Client Secret</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthClient#getExpiresIn <em>Expires In</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthClient#getIssuedAt <em>Issued At</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthClient#getRegistrationEndpoint <em>Registration Endpoint</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getOAuthClient()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface OAuthClient extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Id</em>' attribute.
	 * @see #setClientId(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthClient_ClientId()
	 * @model
	 * @generated
	 */
	String getClientId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthClient#getClientId <em>Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Id</em>' attribute.
	 * @see #getClientId()
	 * @generated
	 */
	void setClientId(String value);

	/**
	 * Returns the value of the '<em><b>Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Secret</em>' attribute.
	 * @see #setClientSecret(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthClient_ClientSecret()
	 * @model
	 * @generated
	 */
	String getClientSecret();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthClient#getClientSecret <em>Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Secret</em>' attribute.
	 * @see #getClientSecret()
	 * @generated
	 */
	void setClientSecret(String value);

	/**
	 * Returns the value of the '<em><b>Expires In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expires In</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expires In</em>' attribute.
	 * @see #setExpiresIn(long)
	 * @see org.bimserver.models.store.StorePackage#getOAuthClient_ExpiresIn()
	 * @model
	 * @generated
	 */
	long getExpiresIn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthClient#getExpiresIn <em>Expires In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expires In</em>' attribute.
	 * @see #getExpiresIn()
	 * @generated
	 */
	void setExpiresIn(long value);

	/**
	 * Returns the value of the '<em><b>Issued At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issued At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issued At</em>' attribute.
	 * @see #setIssuedAt(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthClient_IssuedAt()
	 * @model
	 * @generated
	 */
	String getIssuedAt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthClient#getIssuedAt <em>Issued At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issued At</em>' attribute.
	 * @see #getIssuedAt()
	 * @generated
	 */
	void setIssuedAt(String value);

	/**
	 * Returns the value of the '<em><b>Registration Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Endpoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Endpoint</em>' attribute.
	 * @see #setRegistrationEndpoint(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthClient_RegistrationEndpoint()
	 * @model
	 * @generated
	 */
	String getRegistrationEndpoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthClient#getRegistrationEndpoint <em>Registration Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Endpoint</em>' attribute.
	 * @see #getRegistrationEndpoint()
	 * @generated
	 */
	void setRegistrationEndpoint(String value);

} // OAuthClient
