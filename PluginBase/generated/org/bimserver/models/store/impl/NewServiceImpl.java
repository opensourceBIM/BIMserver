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
import org.bimserver.models.store.Action;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.ServiceStatus;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getAuthorizationUrl <em>Authorization Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getResourceUrl <em>Resource Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getOauthCode <em>Oauth Code</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getSerializer <em>Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getAccessToken <em>Access Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.NewServiceImpl#getStateJson <em>State Json</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewServiceImpl extends IdEObjectImpl implements NewService {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.NEW_SERVICE;
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
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.NEW_SERVICE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProvider() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvider(String newProvider) {
		eSet(StorePackage.Literals.NEW_SERVICE__PROVIDER, newProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.NEW_SERVICE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthorizationUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__AUTHORIZATION_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthorizationUrl(String newAuthorizationUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE__AUTHORIZATION_URL, newAuthorizationUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTokenUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__TOKEN_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTokenUrl(String newTokenUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE__TOKEN_URL, newTokenUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__RESOURCE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceUrl(String newResourceUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE__RESOURCE_URL, newResourceUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegisterUrl() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__REGISTER_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegisterUrl(String newRegisterUrl) {
		eSet(StorePackage.Literals.NEW_SERVICE__REGISTER_URL, newRegisterUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInput() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__INPUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput(String newInput) {
		eSet(StorePackage.Literals.NEW_SERVICE__INPUT, newInput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOauthCode() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__OAUTH_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOauthCode(String newOauthCode) {
		eSet(StorePackage.Literals.NEW_SERVICE__OAUTH_CODE, newOauthCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceStatus getStatus() {
		return (ServiceStatus) eGet(StorePackage.Literals.NEW_SERVICE__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(ServiceStatus newStatus) {
		eSet(StorePackage.Literals.NEW_SERVICE__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SerializerPluginConfiguration getSerializer() {
		return (SerializerPluginConfiguration) eGet(StorePackage.Literals.NEW_SERVICE__SERIALIZER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSerializer(SerializerPluginConfiguration newSerializer) {
		eSet(StorePackage.Literals.NEW_SERVICE__SERIALIZER, newSerializer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOutput() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__OUTPUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutput(String newOutput) {
		eSet(StorePackage.Literals.NEW_SERVICE__OUTPUT, newOutput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action getAction() {
		return (Action) eGet(StorePackage.Literals.NEW_SERVICE__ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAction(Action newAction) {
		eSet(StorePackage.Literals.NEW_SERVICE__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAccessToken() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__ACCESS_TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccessToken(String newAccessToken) {
		eSet(StorePackage.Literals.NEW_SERVICE__ACCESS_TOKEN, newAccessToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.NEW_SERVICE__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.NEW_SERVICE__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStateJson() {
		return (String) eGet(StorePackage.Literals.NEW_SERVICE__STATE_JSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStateJson(String newStateJson) {
		eSet(StorePackage.Literals.NEW_SERVICE__STATE_JSON, newStateJson);
	}

} //NewServiceImpl
