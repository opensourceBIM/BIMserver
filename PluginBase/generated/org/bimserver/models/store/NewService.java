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
 * A representation of the model object '<em><b>New Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.NewService#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getAuthorizationUrl <em>Authorization Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getResourceUrl <em>Resource Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getInput <em>Input</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getOauthCode <em>Oauth Code</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getSerializer <em>Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getOutput <em>Output</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getAction <em>Action</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getAccessToken <em>Access Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewService#getStateJson <em>State Json</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getNewService()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface NewService extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getNewService_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Authorization Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authorization Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authorization Url</em>' attribute.
	 * @see #setAuthorizationUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_AuthorizationUrl()
	 * @model
	 * @generated
	 */
	String getAuthorizationUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getAuthorizationUrl <em>Authorization Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorization Url</em>' attribute.
	 * @see #getAuthorizationUrl()
	 * @generated
	 */
	void setAuthorizationUrl(String value);

	/**
	 * Returns the value of the '<em><b>Token Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Url</em>' attribute.
	 * @see #setTokenUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_TokenUrl()
	 * @model
	 * @generated
	 */
	String getTokenUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getTokenUrl <em>Token Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Url</em>' attribute.
	 * @see #getTokenUrl()
	 * @generated
	 */
	void setTokenUrl(String value);

	/**
	 * Returns the value of the '<em><b>Resource Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Url</em>' attribute.
	 * @see #setResourceUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_ResourceUrl()
	 * @model
	 * @generated
	 */
	String getResourceUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getResourceUrl <em>Resource Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Url</em>' attribute.
	 * @see #getResourceUrl()
	 * @generated
	 */
	void setResourceUrl(String value);

	/**
	 * Returns the value of the '<em><b>Register Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Register Url</em>' attribute.
	 * @see #setRegisterUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_RegisterUrl()
	 * @model
	 * @generated
	 */
	String getRegisterUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getRegisterUrl <em>Register Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register Url</em>' attribute.
	 * @see #getRegisterUrl()
	 * @generated
	 */
	void setRegisterUrl(String value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Input()
	 * @model
	 * @generated
	 */
	String getInput();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(String value);

	/**
	 * Returns the value of the '<em><b>Oauth Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oauth Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oauth Code</em>' attribute.
	 * @see #setOauthCode(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_OauthCode()
	 * @model
	 * @generated
	 */
	String getOauthCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getOauthCode <em>Oauth Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oauth Code</em>' attribute.
	 * @see #getOauthCode()
	 * @generated
	 */
	void setOauthCode(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ServiceStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.bimserver.models.store.ServiceStatus
	 * @see #setStatus(ServiceStatus)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Status()
	 * @model
	 * @generated
	 */
	ServiceStatus getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.bimserver.models.store.ServiceStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ServiceStatus value);

	/**
	 * Returns the value of the '<em><b>Serializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializer</em>' reference.
	 * @see #setSerializer(SerializerPluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Serializer()
	 * @model
	 * @generated
	 */
	SerializerPluginConfiguration getSerializer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getSerializer <em>Serializer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serializer</em>' reference.
	 * @see #getSerializer()
	 * @generated
	 */
	void setSerializer(SerializerPluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Output()
	 * @model
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Action()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Token</em>' attribute.
	 * @see #setAccessToken(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_AccessToken()
	 * @model
	 * @generated
	 */
	String getAccessToken();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getAccessToken <em>Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Token</em>' attribute.
	 * @see #getAccessToken()
	 * @generated
	 */
	void setAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getNewService_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>State Json</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Json</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Json</em>' attribute.
	 * @see #setStateJson(String)
	 * @see org.bimserver.models.store.StorePackage#getNewService_StateJson()
	 * @model
	 * @generated
	 */
	String getStateJson();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewService#getStateJson <em>State Json</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Json</em>' attribute.
	 * @see #getStateJson()
	 * @generated
	 */
	void setStateJson(String value);

} // NewService
