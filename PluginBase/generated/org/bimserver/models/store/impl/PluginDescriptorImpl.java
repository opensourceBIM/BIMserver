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
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#isInstallForNewUsers <em>Install For New Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getPluginBundleVersion <em>Plugin Bundle Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginDescriptorImpl extends IdEObjectImpl implements PluginDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PLUGIN_DESCRIPTOR;
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
	public String getName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluginClassName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginClassName(String newPluginClassName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME, newPluginClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getEnabled() {
		return (Boolean) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(Boolean newEnabled) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__ENABLED, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPluginInterfaceClassName() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginInterfaceClassName(String newPluginInterfaceClassName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME, newPluginInterfaceClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<PluginConfiguration> getConfigurations() {
		return (EList<PluginConfiguration>) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__CONFIGURATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentifier() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__IDENTIFIER, newIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInstallForNewUsers() {
		return (Boolean) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__INSTALL_FOR_NEW_USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallForNewUsers(boolean newInstallForNewUsers) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__INSTALL_FOR_NEW_USERS, newInstallForNewUsers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundleVersion getPluginBundleVersion() {
		return (PluginBundleVersion) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_BUNDLE_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPluginBundleVersion(PluginBundleVersion newPluginBundleVersion) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_BUNDLE_VERSION, newPluginBundleVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectType getSettings() {
		return (ObjectType) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSettings(ObjectType newSettings) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__SETTINGS, newSettings);
	}

} //PluginDescriptorImpl
