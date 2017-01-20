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
package org.bimserver.models.ifc4;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Surface With Knots</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getUMultiplicities <em>UMultiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getVMultiplicities <em>VMultiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getUKnots <em>UKnots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getUKnotsAsString <em>UKnots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getVKnots <em>VKnots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getVKnotsAsString <em>VKnots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getKnotSpec <em>Knot Spec</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots()
 * @model
 * @generated
 */
public interface IfcBSplineSurfaceWithKnots extends IfcBSplineSurface {
	/**
	 * Returns the value of the '<em><b>UMultiplicities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UMultiplicities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UMultiplicities</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_UMultiplicities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getUMultiplicities();

	/**
	 * Returns the value of the '<em><b>VMultiplicities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VMultiplicities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VMultiplicities</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_VMultiplicities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getVMultiplicities();

	/**
	 * Returns the value of the '<em><b>UKnots</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UKnots</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UKnots</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_UKnots()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getUKnots();

	/**
	 * Returns the value of the '<em><b>UKnots As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UKnots As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UKnots As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_UKnotsAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getUKnotsAsString();

	/**
	 * Returns the value of the '<em><b>VKnots</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VKnots</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VKnots</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_VKnots()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getVKnots();

	/**
	 * Returns the value of the '<em><b>VKnots As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VKnots As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VKnots As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_VKnotsAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getVKnotsAsString();

	/**
	 * Returns the value of the '<em><b>Knot Spec</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcKnotType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knot Spec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knot Spec</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcKnotType
	 * @see #setKnotSpec(IfcKnotType)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceWithKnots_KnotSpec()
	 * @model
	 * @generated
	 */
	IfcKnotType getKnotSpec();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineSurfaceWithKnots#getKnotSpec <em>Knot Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Knot Spec</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcKnotType
	 * @see #getKnotSpec()
	 * @generated
	 */
	void setKnotSpec(IfcKnotType value);

} // IfcBSplineSurfaceWithKnots
