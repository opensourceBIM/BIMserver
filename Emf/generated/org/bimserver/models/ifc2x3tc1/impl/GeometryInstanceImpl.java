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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;

import org.bimserver.models.store.Bounds;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometry Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryInstanceImpl#getNormals <em>Normals</em>}</li>
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
		return Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE;
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
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__START_VERTEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVertex(Integer newStartVertex) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__START_VERTEX, newStartVertex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartIndex() {
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__START_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(Integer newStartIndex) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__START_INDEX, newStartIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrimitiveCount() {
		return (Integer) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__PRIMITIVE_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveCount(Integer newPrimitiveCount) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__PRIMITIVE_COUNT, newPrimitiveCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bounds getBounds() {
		return (Bounds) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBounds(Bounds newBounds) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__BOUNDS, newBounds);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getIndices() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndices(byte[] newIndices) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__INDICES, newIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getVertices() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__VERTICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertices(byte[] newVertices) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__VERTICES, newVertices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getNormals() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__NORMALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormals(byte[] newNormals) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_INSTANCE__NORMALS, newNormals);
	}

} //GeometryInstanceImpl
