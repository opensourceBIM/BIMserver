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
 * A representation of the model object '<em><b>Plugin Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.PluginBundle#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundle#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundle#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundle#getAvailableVersions <em>Available Versions</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundle#getInstalledVersion <em>Installed Version</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getPluginBundle()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface PluginBundle extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' attribute.
	 * @see #setOrganization(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundle_Organization()
	 * @model
	 * @generated
	 */
	String getOrganization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundle#getOrganization <em>Organization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' attribute.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getPluginBundle_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundle#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Latest Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Version</em>' reference.
	 * @see #setLatestVersion(PluginBundleVersion)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundle_LatestVersion()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	PluginBundleVersion getLatestVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundle#getLatestVersion <em>Latest Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Version</em>' reference.
	 * @see #getLatestVersion()
	 * @generated
	 */
	void setLatestVersion(PluginBundleVersion value);

	/**
	 * Returns the value of the '<em><b>Available Versions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.PluginBundleVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Versions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Versions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getPluginBundle_AvailableVersions()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	EList<PluginBundleVersion> getAvailableVersions();

	/**
	 * Returns the value of the '<em><b>Installed Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installed Version</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installed Version</em>' reference.
	 * @see #setInstalledVersion(PluginBundleVersion)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundle_InstalledVersion()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	PluginBundleVersion getInstalledVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundle#getInstalledVersion <em>Installed Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installed Version</em>' reference.
	 * @see #getInstalledVersion()
	 * @generated
	 */
	void setInstalledVersion(PluginBundleVersion value);

} // PluginBundle
