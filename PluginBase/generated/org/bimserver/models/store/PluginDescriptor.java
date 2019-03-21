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
 * A representation of the model object '<em><b>Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#isInstallForNewUsers <em>Install For New Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getPluginBundleVersion <em>Plugin Bundle Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginDescriptor#getSettings <em>Settings</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface PluginDescriptor extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @model annotation="singleindex"
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

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Identifier()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Install For New Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Install For New Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Install For New Users</em>' attribute.
	 * @see #setInstallForNewUsers(boolean)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_InstallForNewUsers()
	 * @model
	 * @generated
	 */
	boolean isInstallForNewUsers();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#isInstallForNewUsers <em>Install For New Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install For New Users</em>' attribute.
	 * @see #isInstallForNewUsers()
	 * @generated
	 */
	void setInstallForNewUsers(boolean value);

	/**
	 * Returns the value of the '<em><b>Plugin Bundle Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Bundle Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Bundle Version</em>' reference.
	 * @see #setPluginBundleVersion(PluginBundleVersion)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_PluginBundleVersion()
	 * @model
	 * @generated
	 */
	PluginBundleVersion getPluginBundleVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getPluginBundleVersion <em>Plugin Bundle Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Bundle Version</em>' reference.
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	void setPluginBundleVersion(PluginBundleVersion value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(ObjectType)
	 * @see org.bimserver.models.store.StorePackage#getPluginDescriptor_Settings()
	 * @model
	 * @generated
	 */
	ObjectType getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginDescriptor#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(ObjectType value);

} // PluginDescriptor
