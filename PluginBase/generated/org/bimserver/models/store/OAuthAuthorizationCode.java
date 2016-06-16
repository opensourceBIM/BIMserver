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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OAuth Authorization Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.OAuthAuthorizationCode#getOauthServer <em>Oauth Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthAuthorizationCode#getCode <em>Code</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthAuthorizationCode#getAuthorization <em>Authorization</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getOAuthAuthorizationCode()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface OAuthAuthorizationCode extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Oauth Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oauth Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oauth Server</em>' reference.
	 * @see #setOauthServer(OAuthServer)
	 * @see org.bimserver.models.store.StorePackage#getOAuthAuthorizationCode_OauthServer()
	 * @model
	 * @generated
	 */
	OAuthServer getOauthServer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthAuthorizationCode#getOauthServer <em>Oauth Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oauth Server</em>' reference.
	 * @see #getOauthServer()
	 * @generated
	 */
	void setOauthServer(OAuthServer value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthAuthorizationCode_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthAuthorizationCode#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Authorization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authorization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authorization</em>' reference.
	 * @see #setAuthorization(Authorization)
	 * @see org.bimserver.models.store.StorePackage#getOAuthAuthorizationCode_Authorization()
	 * @model
	 * @generated
	 */
	Authorization getAuthorization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthAuthorizationCode#getAuthorization <em>Authorization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorization</em>' reference.
	 * @see #getAuthorization()
	 * @generated
	 */
	void setAuthorization(Authorization value);

} // OAuthAuthorizationCode
