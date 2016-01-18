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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.PluginUpdateInformation;
import org.bimserver.models.store.PluginVersion;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Update Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.PluginUpdateInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginUpdateInformationImpl#getCurrentVersion <em>Current Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginUpdateInformationImpl#getAvailableVersions <em>Available Versions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginUpdateInformationImpl extends IdEObjectImpl implements PluginUpdateInformation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginUpdateInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PLUGIN_UPDATE_INFORMATION;
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
	public String getName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_UPDATE_INFORMATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.PLUGIN_UPDATE_INFORMATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginVersion getCurrentVersion() {
		return (PluginVersion) eGet(StorePackage.Literals.PLUGIN_UPDATE_INFORMATION__CURRENT_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentVersion(PluginVersion newCurrentVersion) {
		eSet(StorePackage.Literals.PLUGIN_UPDATE_INFORMATION__CURRENT_VERSION, newCurrentVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PluginVersion> getAvailableVersions() {
		return (EList<PluginVersion>) eGet(StorePackage.Literals.PLUGIN_UPDATE_INFORMATION__AVAILABLE_VERSIONS, true);
	}

} //PluginUpdateInformationImpl
