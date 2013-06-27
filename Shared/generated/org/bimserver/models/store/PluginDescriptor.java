/**
 * Copyright (C) 2009-2013 BIMserver.org
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
 * A representation of the model object '<em><b>Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getDefaultName <em>Default Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface PluginDescriptor extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_DefaultName()
	 * @model
	 * @generated
	 */
	String getDefaultName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getDefaultName <em>Default Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Name</em>' attribute.
	 * @see #getDefaultName()
	 * @generated
	 */
	void setDefaultName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_PluginClassName()
	 * @model
	 * @generated
	 */
	String getPluginClassName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Class Name</em>' attribute.
	 * @see #getPluginClassName()
	 * @generated
	 */
	void setPluginClassName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(Boolean)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Enabled()
	 * @model
	 * @generated
	 */
	Boolean getEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #getEnabled()
	 * @generated
	 */
	void setEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Plugin Interface Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Interface Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Interface Class Name</em>' attribute.
	 * @see #setPluginInterfaceClassName(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_PluginInterfaceClassName()
	 * @model
	 * @generated
	 */
	String getPluginInterfaceClassName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Interface Class Name</em>' attribute.
	 * @see #getPluginInterfaceClassName()
	 * @generated
	 */
	void setPluginInterfaceClassName(String value);

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.PluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.PluginConfiguration#getPluginDescriptor <em>Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Configurations()
	 * @see org.bimserver.models.store.PluginConfiguration#getPluginDescriptor
	 * @model opposite="pluginDescriptor"
	 * @generated
	 */
	EList<PluginConfiguration> getConfigurations();

} // PluginDescriptor
