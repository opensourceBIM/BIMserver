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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc BSpline Curve With Knots</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getKnotMultiplicities <em>Knot Multiplicities</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getKnots <em>Knots</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getKnotsAsString <em>Knots As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getKnotSpec <em>Knot Spec</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getUpperIndexOnKnots <em>Upper Index On Knots</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots()
 * @model
 * @generated
 */
public interface IfcBSplineCurveWithKnots extends IfcBSplineCurve {
	/**
	 * Returns the value of the '<em><b>Knot Multiplicities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knot Multiplicities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knot Multiplicities</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots_KnotMultiplicities()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getKnotMultiplicities();

	/**
	 * Returns the value of the '<em><b>Knots</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knots</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knots</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots_Knots()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getKnots();

	/**
	 * Returns the value of the '<em><b>Knots As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knots As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knots As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots_KnotsAsString()
	 * @model unique="false"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getKnotsAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots_KnotSpec()
	 * @model
	 * @generated
	 */
	IfcKnotType getKnotSpec();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getKnotSpec <em>Knot Spec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Knot Spec</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcKnotType
	 * @see #getKnotSpec()
	 * @generated
	 */
	void setKnotSpec(IfcKnotType value);

	/**
	 * Returns the value of the '<em><b>Upper Index On Knots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Index On Knots</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Index On Knots</em>' attribute.
	 * @see #isSetUpperIndexOnKnots()
	 * @see #unsetUpperIndexOnKnots()
	 * @see #setUpperIndexOnKnots(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineCurveWithKnots_UpperIndexOnKnots()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getUpperIndexOnKnots();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getUpperIndexOnKnots <em>Upper Index On Knots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Index On Knots</em>' attribute.
	 * @see #isSetUpperIndexOnKnots()
	 * @see #unsetUpperIndexOnKnots()
	 * @see #getUpperIndexOnKnots()
	 * @generated
	 */
	void setUpperIndexOnKnots(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getUpperIndexOnKnots <em>Upper Index On Knots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpperIndexOnKnots()
	 * @see #getUpperIndexOnKnots()
	 * @see #setUpperIndexOnKnots(long)
	 * @generated
	 */
	void unsetUpperIndexOnKnots();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBSplineCurveWithKnots#getUpperIndexOnKnots <em>Upper Index On Knots</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Upper Index On Knots</em>' attribute is set.
	 * @see #unsetUpperIndexOnKnots()
	 * @see #getUpperIndexOnKnots()
	 * @see #setUpperIndexOnKnots(long)
	 * @generated
	 */
	boolean isSetUpperIndexOnKnots();

} // IfcBSplineCurveWithKnots
