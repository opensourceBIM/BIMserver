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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Service Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getAuthorizationUrl <em>Authorization Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getResourceUrl <em>Resource Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.bimserver.models.store.NewServiceDescriptor#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface NewServiceDescriptor extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getProvider <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_AuthorizationUrl()
	 * @model
	 * @generated
	 */
	String getAuthorizationUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getAuthorizationUrl <em>Authorization Url</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_TokenUrl()
	 * @model
	 * @generated
	 */
	String getTokenUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getTokenUrl <em>Token Url</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_ResourceUrl()
	 * @model
	 * @generated
	 */
	String getResourceUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getResourceUrl <em>Resource Url</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_RegisterUrl()
	 * @model
	 * @generated
	 */
	String getRegisterUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.NewServiceDescriptor#getRegisterUrl <em>Register Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register Url</em>' attribute.
	 * @see #getRegisterUrl()
	 * @generated
	 */
	void setRegisterUrl(String value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_Inputs()
	 * @model
	 * @generated
	 */
	EList<String> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getNewServiceDescriptor_Outputs()
	 * @model
	 * @generated
	 */
	EList<String> getOutputs();

} // NewServiceDescriptor
