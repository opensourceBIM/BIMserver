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

import org.bimserver.models.store.GeometryInstance;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometry Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.GeometryInstanceImpl#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeometryInstanceImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.GeometryInstanceImpl#getPrimitiveCount <em>Primitive Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeometryInstanceImpl extends IdEObjectImpl implements GeometryInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.GEOMETRY_INSTANCE;
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
	public Integer getStartVertex() {
		return (Integer) eGet(StorePackage.Literals.GEOMETRY_INSTANCE__START_VERTEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVertex(Integer newStartVertex) {
		eSet(StorePackage.Literals.GEOMETRY_INSTANCE__START_VERTEX, newStartVertex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return (Integer) eGet(StorePackage.Literals.GEOMETRY_INSTANCE__START_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		eSet(StorePackage.Literals.GEOMETRY_INSTANCE__START_INDEX, newStartIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrimitiveCount() {
		return (Integer) eGet(StorePackage.Literals.GEOMETRY_INSTANCE__PRIMITIVE_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveCount(Integer newPrimitiveCount) {
		eSet(StorePackage.Literals.GEOMETRY_INSTANCE__PRIMITIVE_COUNT, newPrimitiveCount);
	}

} //GeometryInstanceImpl
