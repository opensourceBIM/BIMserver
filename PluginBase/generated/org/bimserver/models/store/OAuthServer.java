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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OAuth Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getRegistrationUrl <em>Registration Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientSecret <em>Client Secret</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientName <em>Client Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientIcon <em>Client Icon</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientUrl <em>Client Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getClientDescription <em>Client Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getRedirectUrl <em>Redirect Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getExpiresAt <em>Expires At</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getIssuedAt <em>Issued At</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#isIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getApiUrl <em>Api Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.OAuthServer#getRegistrationEndpoint <em>Registration Endpoint</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getOAuthServer()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface OAuthServer extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Registration Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Url</em>' attribute.
	 * @see #setRegistrationUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_RegistrationUrl()
	 * @model
	 * @generated
	 */
	String getRegistrationUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getRegistrationUrl <em>Registration Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Url</em>' attribute.
	 * @see #getRegistrationUrl()
	 * @generated
	 */
	void setRegistrationUrl(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientId()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getClientId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientId <em>Client Id</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientSecret()
	 * @model
	 * @generated
	 */
	String getClientSecret();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientSecret <em>Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Secret</em>' attribute.
	 * @see #getClientSecret()
	 * @generated
	 */
	void setClientSecret(String value);

	/**
	 * Returns the value of the '<em><b>Client Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Name</em>' attribute.
	 * @see #setClientName(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientName()
	 * @model
	 * @generated
	 */
	String getClientName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientName <em>Client Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Name</em>' attribute.
	 * @see #getClientName()
	 * @generated
	 */
	void setClientName(String value);

	/**
	 * Returns the value of the '<em><b>Client Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Icon</em>' attribute.
	 * @see #setClientIcon(byte[])
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientIcon()
	 * @model
	 * @generated
	 */
	byte[] getClientIcon();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientIcon <em>Client Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Icon</em>' attribute.
	 * @see #getClientIcon()
	 * @generated
	 */
	void setClientIcon(byte[] value);

	/**
	 * Returns the value of the '<em><b>Client Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Url</em>' attribute.
	 * @see #setClientUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientUrl()
	 * @model
	 * @generated
	 */
	String getClientUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientUrl <em>Client Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Url</em>' attribute.
	 * @see #getClientUrl()
	 * @generated
	 */
	void setClientUrl(String value);

	/**
	 * Returns the value of the '<em><b>Client Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Description</em>' attribute.
	 * @see #setClientDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ClientDescription()
	 * @model
	 * @generated
	 */
	String getClientDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getClientDescription <em>Client Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Description</em>' attribute.
	 * @see #getClientDescription()
	 * @generated
	 */
	void setClientDescription(String value);

	/**
	 * Returns the value of the '<em><b>Redirect Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redirect Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redirect Url</em>' attribute.
	 * @see #setRedirectUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_RedirectUrl()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getRedirectUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getRedirectUrl <em>Redirect Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redirect Url</em>' attribute.
	 * @see #getRedirectUrl()
	 * @generated
	 */
	void setRedirectUrl(String value);

	/**
	 * Returns the value of the '<em><b>Expires At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expires At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expires At</em>' attribute.
	 * @see #setExpiresAt(Date)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ExpiresAt()
	 * @model
	 * @generated
	 */
	Date getExpiresAt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getExpiresAt <em>Expires At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expires At</em>' attribute.
	 * @see #getExpiresAt()
	 * @generated
	 */
	void setExpiresAt(Date value);

	/**
	 * Returns the value of the '<em><b>Issued At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issued At</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issued At</em>' attribute.
	 * @see #setIssuedAt(Date)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_IssuedAt()
	 * @model
	 * @generated
	 */
	Date getIssuedAt();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getIssuedAt <em>Issued At</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issued At</em>' attribute.
	 * @see #getIssuedAt()
	 * @generated
	 */
	void setIssuedAt(Date value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' attribute.
	 * @see #setIncoming(boolean)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_Incoming()
	 * @model
	 * @generated
	 */
	boolean isIncoming();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#isIncoming <em>Incoming</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' attribute.
	 * @see #isIncoming()
	 * @generated
	 */
	void setIncoming(boolean value);

	/**
	 * Returns the value of the '<em><b>Api Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Api Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Url</em>' attribute.
	 * @see #setApiUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_ApiUrl()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getApiUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getApiUrl <em>Api Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Url</em>' attribute.
	 * @see #getApiUrl()
	 * @generated
	 */
	void setApiUrl(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getOAuthServer_RegistrationEndpoint()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getRegistrationEndpoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.OAuthServer#getRegistrationEndpoint <em>Registration Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Endpoint</em>' attribute.
	 * @see #getRegistrationEndpoint()
	 * @generated
	 */
	void setRegistrationEndpoint(String value);

} // OAuthServer
