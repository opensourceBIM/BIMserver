/**
 * Copyright (C) 2011  BIMserver.org
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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Data Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#isValidate <em>Validate</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getSettings <em>Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getUsers <em>Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExtendedDataSchema#getExtendedData <em>Extended Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ExtendedDataSchema extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(byte[])
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Data()
	 * @model
	 * @generated
	 */
	byte[] getData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(byte[] value);

	/**
	 * Returns the value of the '<em><b>Validate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate</em>' attribute.
	 * @see #setValidate(boolean)
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Validate()
	 * @model
	 * @generated
	 */
	boolean isValidate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#isValidate <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate</em>' attribute.
	 * @see #isValidate()
	 * @generated
	 */
	void setValidate(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.ExtendedDataSchemaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.ExtendedDataSchemaType
	 * @see #setType(ExtendedDataSchemaType)
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Type()
	 * @model
	 * @generated
	 */
	ExtendedDataSchemaType getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.ExtendedDataSchemaType
	 * @see #getType()
	 * @generated
	 */
	void setType(ExtendedDataSchemaType value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ServerSettings#getSchemas <em>Schemas</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(ServerSettings)
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Settings()
	 * @see org.bimserver.models.store.ServerSettings#getSchemas
	 * @model opposite="schemas"
	 * @generated
	 */
	ServerSettings getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExtendedDataSchema#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(ServerSettings value);

	/**
	 * Returns the value of the '<em><b>Users</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.User}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.User#getSchemas <em>Schemas</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_Users()
	 * @see org.bimserver.models.store.User#getSchemas
	 * @model opposite="schemas"
	 * @generated
	 */
	EList<User> getUsers();

	/**
	 * Returns the value of the '<em><b>Extended Data</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ExtendedData}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExtendedData#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Data</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getExtendedDataSchema_ExtendedData()
	 * @see org.bimserver.models.store.ExtendedData#getSchema
	 * @model opposite="schema"
	 * @generated
	 */
	EList<ExtendedData> getExtendedData();

} // ExtendedDataSchema
