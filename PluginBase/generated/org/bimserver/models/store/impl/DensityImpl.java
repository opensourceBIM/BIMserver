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
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getTrianglesBelow <em>Triangles Below</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DensityImpl#getTrianglesAbove <em>Triangles Above</em>}</li>
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
	@Override
	public String getType() {
		return (String) eGet(StorePackage.Literals.DENSITY__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		eSet(StorePackage.Literals.DENSITY__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getGeometryInfoId() {
		return (Long) eGet(StorePackage.Literals.DENSITY__GEOMETRY_INFO_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeometryInfoId(long newGeometryInfoId) {
		eSet(StorePackage.Literals.DENSITY__GEOMETRY_INFO_ID, newGeometryInfoId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getTrianglesBelow() {
		return (Long) eGet(StorePackage.Literals.DENSITY__TRIANGLES_BELOW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTrianglesBelow(long newTrianglesBelow) {
		eSet(StorePackage.Literals.DENSITY__TRIANGLES_BELOW, newTrianglesBelow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getTrianglesAbove() {
		return (Long) eGet(StorePackage.Literals.DENSITY__TRIANGLES_ABOVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTrianglesAbove(long newTrianglesAbove) {
		eSet(StorePackage.Literals.DENSITY__TRIANGLES_ABOVE, newTrianglesAbove);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getVolume() {
		return (Float) eGet(StorePackage.Literals.DENSITY__VOLUME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVolume(float newVolume) {
		eSet(StorePackage.Literals.DENSITY__VOLUME, newVolume);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getDensity() {
		return (Float) eGet(StorePackage.Literals.DENSITY__DENSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDensity(float newDensity) {
		eSet(StorePackage.Literals.DENSITY__DENSITY, newDensity);
	}

} //DensityImpl
