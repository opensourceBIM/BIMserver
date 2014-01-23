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

import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Engine Plugin Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl#getUserSettings <em>User Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RenderEnginePluginConfigurationImpl extends
		PluginConfigurationImpl implements RenderEnginePluginConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderEnginePluginConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.RENDER_ENGINE_PLUGIN_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SerializerPluginConfiguration> getSerializers() {
		return (EList<SerializerPluginConfiguration>) eGet(
				StorePackage.Literals.RENDER_ENGINE_PLUGIN_CONFIGURATION__SERIALIZERS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSettings getUserSettings() {
		return (UserSettings) eGet(
				StorePackage.Literals.RENDER_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSettings(UserSettings newUserSettings) {
		eSet(StorePackage.Literals.RENDER_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS,
				newUserSettings);
	}

} //RenderEnginePluginConfigurationImpl
