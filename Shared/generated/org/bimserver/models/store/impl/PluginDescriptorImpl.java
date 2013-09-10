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
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
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
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getDefaultName <em>Default Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getPluginClassName <em>Plugin Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.PluginDescriptorImpl#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PluginDescriptorImpl extends IdEObjectImpl implements
		PluginDescriptor {
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
	public String getSimpleName() {
		return (String) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__SIMPLE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleName(String newSimpleName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__SIMPLE_NAME,
				newSimpleName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultName() {
		return (String) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__DEFAULT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultName(String newDefaultName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__DEFAULT_NAME,
				newDefaultName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginClassName() {
		return (String) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginClassName(String newPluginClassName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME,
				newPluginClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__DESCRIPTION,
				newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return (String) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__LOCATION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getEnabled() {
		return (Boolean) eGet(StorePackage.Literals.PLUGIN_DESCRIPTOR__ENABLED,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(Boolean newEnabled) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__ENABLED, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginInterfaceClassName() {
		return (String) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginInterfaceClassName(String newPluginInterfaceClassName) {
		eSet(StorePackage.Literals.PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME,
				newPluginInterfaceClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PluginConfiguration> getConfigurations() {
		return (EList<PluginConfiguration>) eGet(
				StorePackage.Literals.PLUGIN_DESCRIPTOR__CONFIGURATIONS, true);
	}

} //PluginDescriptorImpl
