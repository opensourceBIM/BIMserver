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
 * A representation of the model object '<em><b>Ifc Rational BSpline Curve With Knots</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsData <em>Weights Data</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsDataAsString <em>Weights Data As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeights <em>Weights</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsAsString <em>Weights As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRationalBSplineCurveWithKnots()
 * @model
 * @generated
 */
public interface IfcRationalBSplineCurveWithKnots extends IfcBSplineCurveWithKnots {
	/**
	 * Returns the value of the '<em><b>Weights Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weights Data</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weights Data</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRationalBSplineCurveWithKnots_WeightsData()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getWeightsData();

	/**
	 * Returns the value of the '<em><b>Weights Data As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weights Data As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weights Data As String</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRationalBSplineCurveWithKnots_WeightsDataAsString()
	 * @model unique="false"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getWeightsDataAsString();

	/**
	 * Returns the value of the '<em><b>Weights</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weights</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weights</em>' attribute.
	 * @see #isSetWeights()
	 * @see #unsetWeights()
	 * @see #setWeights(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRationalBSplineCurveWithKnots_Weights()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	double getWeights();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeights <em>Weights</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weights</em>' attribute.
	 * @see #isSetWeights()
	 * @see #unsetWeights()
	 * @see #getWeights()
	 * @generated
	 */
	void setWeights(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeights <em>Weights</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeights()
	 * @see #getWeights()
	 * @see #setWeights(double)
	 * @generated
	 */
	void unsetWeights();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeights <em>Weights</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weights</em>' attribute is set.
	 * @see #unsetWeights()
	 * @see #getWeights()
	 * @see #setWeights(double)
	 * @generated
	 */
	boolean isSetWeights();

	/**
	 * Returns the value of the '<em><b>Weights As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weights As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weights As String</em>' attribute.
	 * @see #isSetWeightsAsString()
	 * @see #unsetWeightsAsString()
	 * @see #setWeightsAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRationalBSplineCurveWithKnots_WeightsAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWeightsAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsAsString <em>Weights As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weights As String</em>' attribute.
	 * @see #isSetWeightsAsString()
	 * @see #unsetWeightsAsString()
	 * @see #getWeightsAsString()
	 * @generated
	 */
	void setWeightsAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsAsString <em>Weights As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeightsAsString()
	 * @see #getWeightsAsString()
	 * @see #setWeightsAsString(String)
	 * @generated
	 */
	void unsetWeightsAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRationalBSplineCurveWithKnots#getWeightsAsString <em>Weights As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weights As String</em>' attribute is set.
	 * @see #unsetWeightsAsString()
	 * @see #getWeightsAsString()
	 * @see #setWeightsAsString(String)
	 * @generated
	 */
	boolean isSetWeightsAsString();

} // IfcRationalBSplineCurveWithKnots
