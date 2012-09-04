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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.QueryPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.QueryPluginDescriptor#getDefaultName <em>Default Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getQueryPluginDescriptor()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface QueryPluginDescriptor extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Class Name</em>' attribute.
	 * @see #setPluginClassName(String)
	 * @see org.bimserver.models.store.StorePackage#getQueryPluginDescriptor_PluginClassName()
	 * @model
	 * @generated
	 */
	String getPluginClassName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.QueryPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Class Name</em>' attribute.
	 * @see #getPluginClassName()
	 * @generated
	 */
	void setPluginClassName(String value);

	/**
	 * Returns the value of the '<em><b>Default Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Name</em>' attribute.
	 * @see #setDefaultName(String)
	 * @see org.bimserver.models.store.StorePackage#getQueryPluginDescriptor_DefaultName()
	 * @model
	 * @generated
	 */
	String getDefaultName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.QueryPluginDescriptor#getDefaultName <em>Default Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Name</em>' attribute.
	 * @see #getDefaultName()
	 * @generated
	 */
	void setDefaultName(String value);

} // QueryPluginDescriptor
