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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getActive <em>Active</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.IfcEngineImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEngineImpl extends IdEObjectImpl implements IfcEngine {
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
		return (String) eGet(StorePackage.Literals.IFC_ENGINE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.IFC_ENGINE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getActive() {
		return (Boolean) eGet(StorePackage.Literals.IFC_ENGINE__ACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(Boolean newActive) {
		eSet(StorePackage.Literals.IFC_ENGINE__ACTIVE, newActive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String) eGet(StorePackage.Literals.IFC_ENGINE__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(StorePackage.Literals.IFC_ENGINE__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getEnabled() {
		return (Boolean) eGet(StorePackage.Literals.IFC_ENGINE__ENABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(Boolean newEnabled) {
		eSet(StorePackage.Literals.IFC_ENGINE__ENABLED, newEnabled);
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
	public Settings getSettings() {
		return (Settings) eGet(StorePackage.Literals.IFC_ENGINE__SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(Settings newSettings) {
		eSet(StorePackage.Literals.IFC_ENGINE__SETTINGS, newSettings);
	}

} //IfcEngineImpl
