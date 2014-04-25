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
 * A representation of the model object '<em><b>Geometry Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getMinBounds <em>Min Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getMaxBounds <em>Max Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getPrimitiveCount <em>Primitive Count</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getData <em>Data</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface GeometryInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Min Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Bounds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Bounds</em>' reference.
	 * @see #setMinBounds(Vector3f)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_MinBounds()
	 * @model
	 * @generated
	 */
	Vector3f getMinBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getMinBounds <em>Min Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Bounds</em>' reference.
	 * @see #getMinBounds()
	 * @generated
	 */
	void setMinBounds(Vector3f value);

	/**
	 * Returns the value of the '<em><b>Max Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Bounds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Bounds</em>' reference.
	 * @see #setMaxBounds(Vector3f)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_MaxBounds()
	 * @model
	 * @generated
	 */
	Vector3f getMaxBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getMaxBounds <em>Max Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Bounds</em>' reference.
	 * @see #getMaxBounds()
	 * @generated
	 */
	void setMaxBounds(Vector3f value);

	/**
	 * Returns the value of the '<em><b>Start Vertex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Vertex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Vertex</em>' attribute.
	 * @see #setStartVertex(Integer)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_StartVertex()
	 * @model
	 * @generated
	 */
	Integer getStartVertex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getStartVertex <em>Start Vertex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Vertex</em>' attribute.
	 * @see #getStartVertex()
	 * @generated
	 */
	void setStartVertex(Integer value);

	/**
	 * Returns the value of the '<em><b>Start Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Index</em>' attribute.
	 * @see #setStartIndex(Integer)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_StartIndex()
	 * @model
	 * @generated
	 */
	Integer getStartIndex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getStartIndex <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Index</em>' attribute.
	 * @see #getStartIndex()
	 * @generated
	 */
	void setStartIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Primitive Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Count</em>' attribute.
	 * @see #setPrimitiveCount(Integer)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_PrimitiveCount()
	 * @model
	 * @generated
	 */
	Integer getPrimitiveCount();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getPrimitiveCount <em>Primitive Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Count</em>' attribute.
	 * @see #getPrimitiveCount()
	 * @generated
	 */
	void setPrimitiveCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(GeometryData)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_Data()
	 * @model
	 * @generated
	 */
	GeometryData getData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(GeometryData value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(GeometryInstance)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_Instance()
	 * @model
	 * @generated
	 */
	GeometryInstance getInstance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(GeometryInstance value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' attribute.
	 * @see #setTransformation(byte[])
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getGeometryInfo_Transformation()
	 * @model
	 * @generated
	 */
	byte[] getTransformation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.GeometryInfo#getTransformation <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' attribute.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(byte[] value);

} // GeometryInfo
