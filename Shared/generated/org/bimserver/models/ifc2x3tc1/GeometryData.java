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
package org.bimserver.models.ifc2x3tc1;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geometry Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryData#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryData#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryData#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryData#getMaterials <em>Materials</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryData#getMaterialIndices <em>Material Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface GeometryData extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indices</em>' attribute.
	 * @see #setIndices(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData_Indices()
	 * @model
	 * @generated
	 */
	byte[] getIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryData#getIndices <em>Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indices</em>' attribute.
	 * @see #getIndices()
	 * @generated
	 */
	void setIndices(byte[] value);

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' attribute.
	 * @see #setVertices(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData_Vertices()
	 * @model
	 * @generated
	 */
	byte[] getVertices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryData#getVertices <em>Vertices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertices</em>' attribute.
	 * @see #getVertices()
	 * @generated
	 */
	void setVertices(byte[] value);

	/**
	 * Returns the value of the '<em><b>Normals</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normals</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normals</em>' attribute.
	 * @see #setNormals(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData_Normals()
	 * @model
	 * @generated
	 */
	byte[] getNormals();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryData#getNormals <em>Normals</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normals</em>' attribute.
	 * @see #getNormals()
	 * @generated
	 */
	void setNormals(byte[] value);

	/**
	 * Returns the value of the '<em><b>Materials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Materials</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Materials</em>' attribute.
	 * @see #setMaterials(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData_Materials()
	 * @model
	 * @generated
	 */
	byte[] getMaterials();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryData#getMaterials <em>Materials</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Materials</em>' attribute.
	 * @see #getMaterials()
	 * @generated
	 */
	void setMaterials(byte[] value);

	/**
	 * Returns the value of the '<em><b>Material Indices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Material Indices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Material Indices</em>' attribute.
	 * @see #setMaterialIndices(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryData_MaterialIndices()
	 * @model
	 * @generated
	 */
	byte[] getMaterialIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryData#getMaterialIndices <em>Material Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Material Indices</em>' attribute.
	 * @see #getMaterialIndices()
	 * @generated
	 */
	void setMaterialIndices(byte[] value);

} // GeometryData
