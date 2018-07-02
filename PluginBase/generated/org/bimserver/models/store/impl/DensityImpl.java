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

import org.bimserver.models.store.Density;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Density</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getGeometryInfoId <em>Geometry Info Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getTriangles <em>Triangles</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getDensity <em>Density</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DensityImpl extends IdEObjectImpl implements Density {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DensityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.DENSITY;
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
	public String getType() {
		return (String) eGet(StorePackage.Literals.DENSITY__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(StorePackage.Literals.DENSITY__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getGeometryInfoId() {
		return (Long) eGet(StorePackage.Literals.DENSITY__GEOMETRY_INFO_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeometryInfoId(long newGeometryInfoId) {
		eSet(StorePackage.Literals.DENSITY__GEOMETRY_INFO_ID, newGeometryInfoId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTriangles() {
		return (Long) eGet(StorePackage.Literals.DENSITY__TRIANGLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriangles(long newTriangles) {
		eSet(StorePackage.Literals.DENSITY__TRIANGLES, newTriangles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVolume() {
		return (Float) eGet(StorePackage.Literals.DENSITY__VOLUME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(float newVolume) {
		eSet(StorePackage.Literals.DENSITY__VOLUME, newVolume);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDensity() {
		return (Float) eGet(StorePackage.Literals.DENSITY__DENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDensity(float newDensity) {
		eSet(StorePackage.Literals.DENSITY__DENSITY, newDensity);
	}

} //DensityImpl
