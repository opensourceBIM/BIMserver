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
import org.bimserver.models.store.NewServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Service Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getAuthorizationUrl <em>Authorization Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getResourceUrl <em>Resource Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewServiceDescriptorImpl extends IdEObjectImpl implements NewServiceDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewServiceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.NEW_SERVICE_DESCRIPTOR;
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
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProvider() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvider(String newProvider) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__PROVIDER, newProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorizationUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__AUTHORIZATION_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorizationUrl(String newAuthorizationUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__AUTHORIZATION_URL, newAuthorizationUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTokenUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__TOKEN_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTokenUrl(String newTokenUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__TOKEN_URL, newTokenUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__RESOURCE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUrl(String newResourceUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__RESOURCE_URL, newResourceUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegisterUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__REGISTER_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegisterUrl(String newRegisterUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__REGISTER_URL, newRegisterUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getInputs() {
		return (EList<String>) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__INPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getOutputs() {
		return (EList<String>) eGet(StorePackage.Literals.NEW_SERVICE_DESCRIPTOR__OUTPUTS, true);
	}

} //NewServiceDescriptorImpl
