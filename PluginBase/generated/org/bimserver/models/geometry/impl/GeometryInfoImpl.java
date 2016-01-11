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
package org.bimserver.models.geometry.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector3f;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getMinBounds <em>Min Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getMaxBounds <em>Max Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.impl.GeometryInfoImpl#getVolume <em>Volume</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometryInfoImpl extends IdEObjectImpl implements GeometryInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeometryPackage.Literals.GEOMETRY_INFO;
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
	public Vector3f getMinBounds() {
		return (Vector3f) eGet(GeometryPackage.Literals.GEOMETRY_INFO__MIN_BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinBounds(Vector3f newMinBounds) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__MIN_BOUNDS, newMinBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3f getMaxBounds() {
		return (Vector3f) eGet(GeometryPackage.Literals.GEOMETRY_INFO__MAX_BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBounds(Vector3f newMaxBounds) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__MAX_BOUNDS, newMaxBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartVertex() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__START_VERTEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVertex(Integer newStartVertex) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__START_VERTEX, newStartVertex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__START_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__START_INDEX, newStartIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrimitiveCount() {
		return (Integer) eGet(GeometryPackage.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveCount(Integer newPrimitiveCount) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, newPrimitiveCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryData getData() {
		return (GeometryData) eGet(GeometryPackage.Literals.GEOMETRY_INFO__DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(GeometryData newData) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getTransformation() {
		return (byte[]) eGet(GeometryPackage.Literals.GEOMETRY_INFO__TRANSFORMATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(byte[] newTransformation) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__TRANSFORMATION, newTransformation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArea() {
		return (Double) eGet(GeometryPackage.Literals.GEOMETRY_INFO__AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(double newArea) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__AREA, newArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVolume() {
		return (Double) eGet(GeometryPackage.Literals.GEOMETRY_INFO__VOLUME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(double newVolume) {
		eSet(GeometryPackage.Literals.GEOMETRY_INFO__VOLUME, newVolume);
	}

} //GeometryInfoImpl
