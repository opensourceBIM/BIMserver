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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geometry Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.GeometryInstance#getStartVertex <em>Start Vertex</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeometryInstance#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.bimserver.models.store.GeometryInstance#getPrimitiveCount <em>Primitive Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getGeometryInstance()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface GeometryInstance extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getGeometryInstance_StartVertex()
	 * @model
	 * @generated
	 */
	Integer getStartVertex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeometryInstance#getStartVertex <em>Start Vertex</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getGeometryInstance_StartIndex()
	 * @model
	 * @generated
	 */
	Integer getStartIndex();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeometryInstance#getStartIndex <em>Start Index</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getGeometryInstance_PrimitiveCount()
	 * @model
	 * @generated
	 */
	Integer getPrimitiveCount();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.GeometryInstance#getPrimitiveCount <em>Primitive Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Count</em>' attribute.
	 * @see #getPrimitiveCount()
	 * @generated
	 */
	void setPrimitiveCount(Integer value);

} // GeometryInstance
