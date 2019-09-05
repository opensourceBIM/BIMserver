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
 * A representation of the model object '<em><b>Ifc Structural Load Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficients <em>Self Weight Coefficients</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficientsAsString <em>Self Weight Coefficients As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadCase()
 * @model
 * @generated
 */
public interface IfcStructuralLoadCase extends IfcStructuralLoadGroup {
	/**
	 * Returns the value of the '<em><b>Self Weight Coefficients</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Weight Coefficients</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Weight Coefficients</em>' attribute list.
	 * @see #isSetSelfWeightCoefficients()
	 * @see #unsetSelfWeightCoefficients()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadCase_SelfWeightCoefficients()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getSelfWeightCoefficients();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficients <em>Self Weight Coefficients</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSelfWeightCoefficients()
	 * @see #getSelfWeightCoefficients()
	 * @generated
	 */
	void unsetSelfWeightCoefficients();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficients <em>Self Weight Coefficients</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Self Weight Coefficients</em>' attribute list is set.
	 * @see #unsetSelfWeightCoefficients()
	 * @see #getSelfWeightCoefficients()
	 * @generated
	 */
	boolean isSetSelfWeightCoefficients();

	/**
	 * Returns the value of the '<em><b>Self Weight Coefficients As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Weight Coefficients As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Weight Coefficients As String</em>' attribute list.
	 * @see #isSetSelfWeightCoefficientsAsString()
	 * @see #unsetSelfWeightCoefficientsAsString()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralLoadCase_SelfWeightCoefficientsAsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getSelfWeightCoefficientsAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficientsAsString <em>Self Weight Coefficients As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSelfWeightCoefficientsAsString()
	 * @see #getSelfWeightCoefficientsAsString()
	 * @generated
	 */
	void unsetSelfWeightCoefficientsAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralLoadCase#getSelfWeightCoefficientsAsString <em>Self Weight Coefficients As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Self Weight Coefficients As String</em>' attribute list is set.
	 * @see #unsetSelfWeightCoefficientsAsString()
	 * @see #getSelfWeightCoefficientsAsString()
	 * @generated
	 */
	boolean isSetSelfWeightCoefficientsAsString();

} // IfcStructuralLoadCase
