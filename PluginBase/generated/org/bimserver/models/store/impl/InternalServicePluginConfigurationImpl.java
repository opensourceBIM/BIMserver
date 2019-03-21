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

import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Service Plugin Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl#isRemoteAccessible <em>Remote Accessible</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl#getUserSettings <em>User Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl#isPublicProfile <em>Public Profile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalServicePluginConfigurationImpl extends PluginConfigurationImpl implements InternalServicePluginConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalServicePluginConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRemoteAccessible() {
		return (Boolean) eGet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__REMOTE_ACCESSIBLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemoteAccessible(boolean newRemoteAccessible) {
		eSet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__REMOTE_ACCESSIBLE, newRemoteAccessible);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserSettings getUserSettings() {
		return (UserSettings) eGet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__USER_SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserSettings(UserSettings newUserSettings) {
		eSet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__USER_SETTINGS, newUserSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPublicProfile() {
		return (Boolean) eGet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__PUBLIC_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublicProfile(boolean newPublicProfile) {
		eSet(StorePackage.Literals.INTERNAL_SERVICE_PLUGIN_CONFIGURATION__PUBLIC_PROFILE, newPublicProfile);
	}

} //InternalServicePluginConfigurationImpl
