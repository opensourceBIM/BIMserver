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
package org.bimserver.models.store.impl;

import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEngineImpl extends PluginImpl implements IfcEngine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEngineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.IFC_ENGINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Serializer> getSerializers() {
		return (EList<Serializer>) eGet(StorePackage.Literals.IFC_ENGINE__SERIALIZERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSettings getSettings() {
		return (UserSettings) eGet(StorePackage.Literals.IFC_ENGINE__SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(UserSettings newSettings) {
		eSet(StorePackage.Literals.IFC_ENGINE__SETTINGS, newSettings);
	}

} //IfcEngineImpl
