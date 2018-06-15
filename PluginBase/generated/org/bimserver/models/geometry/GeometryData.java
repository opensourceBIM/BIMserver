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
package org.bimserver.models.geometry;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getMaterials <em>Materials</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getMaterialIndices <em>Material Indices</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getColor <em>Color</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#isHasTransparency <em>Has Transparency</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getReused <em>Reused</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.geometry.GeometryData#getMostUsedColor <em>Most Used Color</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData()
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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Indices()
	 * @model
	 * @generated
	 */
	byte[] getIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getIndices <em>Indices</em>}' attribute.
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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Vertices()
	 * @model
	 * @generated
	 */
	byte[] getVertices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getVertices <em>Vertices</em>}' attribute.
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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Normals()
	 * @model
	 * @generated
	 */
	byte[] getNormals();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getNormals <em>Normals</em>}' attribute.
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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Materials()
	 * @model
	 * @generated
	 */
	byte[] getMaterials();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getMaterials <em>Materials</em>}' attribute.
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
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_MaterialIndices()
	 * @model
	 * @generated
	 */
	byte[] getMaterialIndices();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getMaterialIndices <em>Material Indices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Material Indices</em>' attribute.
	 * @see #getMaterialIndices()
	 * @generated
	 */
	void setMaterialIndices(byte[] value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' reference.
	 * @see #setColor(Vector4f)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Color()
	 * @model
	 * @generated
	 */
	Vector4f getColor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getColor <em>Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' reference.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Vector4f value);

	/**
	 * Returns the value of the '<em><b>Has Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Transparency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Transparency</em>' attribute.
	 * @see #setHasTransparency(boolean)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_HasTransparency()
	 * @model
	 * @generated
	 */
	boolean isHasTransparency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#isHasTransparency <em>Has Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Transparency</em>' attribute.
	 * @see #isHasTransparency()
	 * @generated
	 */
	void setHasTransparency(boolean value);

	/**
	 * Returns the value of the '<em><b>Reused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reused</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reused</em>' attribute.
	 * @see #setReused(int)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Reused()
	 * @model
	 * @generated
	 */
	int getReused();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getReused <em>Reused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reused</em>' attribute.
	 * @see #getReused()
	 * @generated
	 */
	void setReused(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(short)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_Type()
	 * @model
	 * @generated
	 */
	short getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(short value);

	/**
	 * Returns the value of the '<em><b>Most Used Color</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Most Used Color</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Most Used Color</em>' reference.
	 * @see #setMostUsedColor(Vector4f)
	 * @see org.bimserver.models.geometry.GeometryPackage#getGeometryData_MostUsedColor()
	 * @model
	 * @generated
	 */
	Vector4f getMostUsedColor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.geometry.GeometryData#getMostUsedColor <em>Most Used Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Most Used Color</em>' reference.
	 * @see #getMostUsedColor()
	 * @generated
	 */
	void setMostUsedColor(Vector4f value);

} // GeometryData
