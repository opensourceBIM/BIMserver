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
import org.bimserver.models.store.PluginBundle;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleImpl#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleImpl#getAvailableVersions <em>Available Versions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginBundleImpl#getInstalledVersion <em>Installed Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginBundleImpl extends IdEObjectImpl implements PluginBundle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginBundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PLUGIN_BUNDLE;
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
	public String getOrganization() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE__ORGANIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrganization(String newOrganization) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE__ORGANIZATION, newOrganization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_BUNDLE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundleVersion getLatestVersion() {
		return (PluginBundleVersion) eGet(StorePackage.Literals.PLUGIN_BUNDLE__LATEST_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLatestVersion(PluginBundleVersion newLatestVersion) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE__LATEST_VERSION, newLatestVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<PluginBundleVersion> getAvailableVersions() {
		return (EList<PluginBundleVersion>) eGet(StorePackage.Literals.PLUGIN_BUNDLE__AVAILABLE_VERSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundleVersion getInstalledVersion() {
		return (PluginBundleVersion) eGet(StorePackage.Literals.PLUGIN_BUNDLE__INSTALLED_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstalledVersion(PluginBundleVersion newInstalledVersion) {
		eSet(StorePackage.Literals.PLUGIN_BUNDLE__INSTALLED_VERSION, newInstalledVersion);
	}

} //PluginBundleImpl
