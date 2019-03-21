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
package org.bimserver.models.store;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * A representation of the model object '<em><b>Density</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.Density#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.Density#getGeometryInfoId <em>Geometry Info Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.Density#getTrianglesBelow <em>Triangles Below</em>}</li>
 *   <li>{@link org.bimserver.models.store.Density#getTrianglesAbove <em>Triangles Above</em>}</li>
 *   <li>{@link org.bimserver.models.store.Density#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.bimserver.models.store.Density#getDensity <em>Density</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getDensity()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Density extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.bimserver.models.store.StorePackage#getDensity_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Geometry Info Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geometry Info Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geometry Info Id</em>' attribute.
	 * @see #setGeometryInfoId(long)
	 * @see org.bimserver.models.store.StorePackage#getDensity_GeometryInfoId()
	 * @model
	 * @generated
	 */
	long getGeometryInfoId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getGeometryInfoId <em>Geometry Info Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geometry Info Id</em>' attribute.
	 * @see #getGeometryInfoId()
	 * @generated
	 */
	void setGeometryInfoId(long value);

	/**
	 * Returns the value of the '<em><b>Triangles Below</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triangles Below</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triangles Below</em>' attribute.
	 * @see #setTrianglesBelow(long)
	 * @see org.bimserver.models.store.StorePackage#getDensity_TrianglesBelow()
	 * @model
	 * @generated
	 */
	long getTrianglesBelow();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getTrianglesBelow <em>Triangles Below</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triangles Below</em>' attribute.
	 * @see #getTrianglesBelow()
	 * @generated
	 */
	void setTrianglesBelow(long value);

	/**
	 * Returns the value of the '<em><b>Triangles Above</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triangles Above</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triangles Above</em>' attribute.
	 * @see #setTrianglesAbove(long)
	 * @see org.bimserver.models.store.StorePackage#getDensity_TrianglesAbove()
	 * @model
	 * @generated
	 */
	long getTrianglesAbove();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getTrianglesAbove <em>Triangles Above</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triangles Above</em>' attribute.
	 * @see #getTrianglesAbove()
	 * @generated
	 */
	void setTrianglesAbove(long value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(float)
	 * @see org.bimserver.models.store.StorePackage#getDensity_Volume()
	 * @model
	 * @generated
	 */
	float getVolume();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(float value);

	/**
	 * Returns the value of the '<em><b>Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Density</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Density</em>' attribute.
	 * @see #setDensity(float)
	 * @see org.bimserver.models.store.StorePackage#getDensity_Density()
	 * @model
	 * @generated
	 */
	float getDensity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Density#getDensity <em>Density</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Density</em>' attribute.
	 * @see #getDensity()
	 * @generated
	 */
	void setDensity(float value);

} // Density
