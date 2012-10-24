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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Geometry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Geometry#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.bimserver.models.store.Geometry#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.bimserver.models.store.Geometry#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.store.Geometry#getNormals <em>Normals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getGeometry()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Geometry extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' reference.
	 * @see #setBounds(Bounds)
	 * @see org.bimserver.models.store.StorePackage#getGeometry_Bounds()
	 * @model
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Geometry#getBounds <em>Bounds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Bounds value);

	/**
	 * Returns the value of the '<em><b>Indices</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indices</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indices</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getGeometry_Indices()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getIndices();

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getGeometry_Vertices()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getVertices();

	/**
	 * Returns the value of the '<em><b>Normals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normals</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getGeometry_Normals()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getNormals();

} // Geometry
