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
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometry Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryDataImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryDataImpl#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryDataImpl#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryDataImpl#getMaterials <em>Materials</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.GeometryDataImpl#getMaterialIndices <em>Material Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeometryDataImpl extends IdEObjectImpl implements GeometryData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.GEOMETRY_DATA;
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
	public byte[] getIndices() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndices(byte[] newIndices) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__INDICES, newIndices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getVertices() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__VERTICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVertices(byte[] newVertices) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__VERTICES, newVertices);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getNormals() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__NORMALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormals(byte[] newNormals) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__NORMALS, newNormals);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getMaterials() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__MATERIALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaterials(byte[] newMaterials) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__MATERIALS, newMaterials);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getMaterialIndices() {
		return (byte[]) eGet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__MATERIAL_INDICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaterialIndices(byte[] newMaterialIndices) {
		eSet(Ifc2x3tc1Package.Literals.GEOMETRY_DATA__MATERIAL_INDICES, newMaterialIndices);
	}

} //GeometryDataImpl
