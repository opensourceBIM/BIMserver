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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serializer Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension <em>Default Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType <em>Default Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor()
 * @model
 * @generated
 */
public interface SerializerPluginDescriptor extends PluginDescriptor {
	/**
	 * Returns the value of the '<em><b>Default Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Extension</em>' attribute.
	 * @see #setDefaultExtension(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_DefaultExtension()
	 * @model
	 * @generated
	 */
	String getDefaultExtension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension <em>Default Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Extension</em>' attribute.
	 * @see #getDefaultExtension()
	 * @generated
	 */
	void setDefaultExtension(String value);

	/**
	 * Returns the value of the '<em><b>Default Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Content Type</em>' attribute.
	 * @see #setDefaultContentType(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginDescriptor_DefaultContentType()
	 * @model
	 * @generated
	 */
	String getDefaultContentType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType <em>Default Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Content Type</em>' attribute.
	 * @see #getDefaultContentType()
	 * @generated
	 */
	void setDefaultContentType(String value);

} // SerializerPluginDescriptor
