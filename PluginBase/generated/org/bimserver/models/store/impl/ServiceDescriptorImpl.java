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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getNotificationProtocol <em>Notification Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#isWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getCompanyUrl <em>Company Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getNewProfileUrl <em>New Profile Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceDescriptorImpl#getAuthorizeUrl <em>Authorize Url</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceDescriptorImpl extends IdEObjectImpl implements ServiceDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERVICE_DESCRIPTOR;
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
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUrl(String newUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__URL, newUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getToken() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToken(String newToken) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN, newToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentifier() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessMethod getNotificationProtocol() {
		return (AccessMethod) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNotificationProtocol(AccessMethod newNotificationProtocol) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL, newNotificationProtocol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Trigger getTrigger() {
		return (Trigger) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__TRIGGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTrigger(Trigger newTrigger) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__TRIGGER, newTrigger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReadRevision() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadRevision(boolean newReadRevision) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_REVISION, newReadRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getReadExtendedData() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadExtendedData(String newReadExtendedData) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__READ_EXTENDED_DATA, newReadExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWriteRevision() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWriteRevision(boolean newWriteRevision) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_REVISION, newWriteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWriteExtendedData() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWriteExtendedData(String newWriteExtendedData) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA, newWriteExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProviderName() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__PROVIDER_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProviderName(String newProviderName) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__PROVIDER_NAME, newProviderName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCompanyUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__COMPANY_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompanyUrl(String newCompanyUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__COMPANY_URL, newCompanyUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTokenUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTokenUrl(String newTokenUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__TOKEN_URL, newTokenUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNewProfileUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__NEW_PROFILE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNewProfileUrl(String newNewProfileUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__NEW_PROFILE_URL, newNewProfileUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegisterUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__REGISTER_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegisterUrl(String newRegisterUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__REGISTER_URL, newRegisterUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorizeUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE_DESCRIPTOR__AUTHORIZE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorizeUrl(String newAuthorizeUrl) {
		eSet(StorePackage.Literals.SERVICE_DESCRIPTOR__AUTHORIZE_URL, newAuthorizeUrl);
	}

} //ServiceDescriptorImpl
