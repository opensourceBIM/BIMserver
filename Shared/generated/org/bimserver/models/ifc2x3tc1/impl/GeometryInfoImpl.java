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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.Vector3f;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometry Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getMinBounds <em>Min Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getMaxBounds <em>Max Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInfoImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
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
		return Ifc2x3tc1Package.Literals.GEOMETRY_INFO;
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
		return (Vector3f) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__MIN_BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinBounds(Vector3f newMinBounds) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__MIN_BOUNDS, newMinBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3f getMaxBounds() {
		return (Vector3f) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__MAX_BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBounds(Vector3f newMaxBounds) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__MAX_BOUNDS, newMaxBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartVertex() {
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__START_VERTEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVertex(Integer newStartVertex) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__START_VERTEX, newStartVertex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__START_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__START_INDEX, newStartIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrimitiveCount() {
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveCount(Integer newPrimitiveCount) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__PRIMITIVE_COUNT, newPrimitiveCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryData getData() {
		return (GeometryData) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(GeometryData newData) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__DATA, newData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryInstance getInstance() {
		return (GeometryInstance) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(GeometryInstance newInstance) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__INSTANCE, newInstance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getTransformation() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__TRANSFORMATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(byte[] newTransformation) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INFO__TRANSFORMATION, newTransformation);
	}

} //GeometryInfoImpl
