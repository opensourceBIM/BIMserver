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
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OAuth Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getRegistrationUrl <em>Registration Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientSecret <em>Client Secret</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientName <em>Client Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientIcon <em>Client Icon</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientUrl <em>Client Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getClientDescription <em>Client Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getRedirectUrl <em>Redirect Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getExpiresAt <em>Expires At</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getIssuedAt <em>Issued At</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#isIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getApiUrl <em>Api Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthServerImpl#getRegistrationEndpoint <em>Registration Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OAuthServerImpl extends IdEObjectImpl implements OAuthServer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OAuthServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.OAUTH_SERVER;
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
	public String getRegistrationUrl() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__REGISTRATION_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegistrationUrl(String newRegistrationUrl) {
		eSet(StorePackage.Literals.OAUTH_SERVER__REGISTRATION_URL, newRegistrationUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientId() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientId(String newClientId) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_ID, newClientId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientSecret() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_SECRET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientSecret(String newClientSecret) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_SECRET, newClientSecret);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientName() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientName(String newClientName) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_NAME, newClientName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte[] getClientIcon() {
		return (byte[]) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_ICON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientIcon(byte[] newClientIcon) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_ICON, newClientIcon);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientUrl() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientUrl(String newClientUrl) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_URL, newClientUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClientDescription() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__CLIENT_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClientDescription(String newClientDescription) {
		eSet(StorePackage.Literals.OAUTH_SERVER__CLIENT_DESCRIPTION, newClientDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRedirectUrl() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__REDIRECT_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRedirectUrl(String newRedirectUrl) {
		eSet(StorePackage.Literals.OAUTH_SERVER__REDIRECT_URL, newRedirectUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getExpiresAt() {
		return (Date) eGet(StorePackage.Literals.OAUTH_SERVER__EXPIRES_AT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpiresAt(Date newExpiresAt) {
		eSet(StorePackage.Literals.OAUTH_SERVER__EXPIRES_AT, newExpiresAt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getIssuedAt() {
		return (Date) eGet(StorePackage.Literals.OAUTH_SERVER__ISSUED_AT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIssuedAt(Date newIssuedAt) {
		eSet(StorePackage.Literals.OAUTH_SERVER__ISSUED_AT, newIssuedAt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIncoming() {
		return (Boolean) eGet(StorePackage.Literals.OAUTH_SERVER__INCOMING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncoming(boolean newIncoming) {
		eSet(StorePackage.Literals.OAUTH_SERVER__INCOMING, newIncoming);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApiUrl() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__API_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApiUrl(String newApiUrl) {
		eSet(StorePackage.Literals.OAUTH_SERVER__API_URL, newApiUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegistrationEndpoint() {
		return (String) eGet(StorePackage.Literals.OAUTH_SERVER__REGISTRATION_ENDPOINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegistrationEndpoint(String newRegistrationEndpoint) {
		eSet(StorePackage.Literals.OAUTH_SERVER__REGISTRATION_ENDPOINT, newRegistrationEndpoint);
	}

} //OAuthServerImpl
