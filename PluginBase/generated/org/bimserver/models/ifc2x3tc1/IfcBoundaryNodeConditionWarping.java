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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcBoundaryNodeConditionWarping extends IfcBoundaryNodeCondition {
	/**
	 * Returns the value of the '<em><b>Warping Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Stiffness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Stiffness</em>' attribute.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #setWarpingStiffness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeConditionWarping_WarpingStiffness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWarpingStiffness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness</em>' attribute.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @generated
	 */
	void setWarpingStiffness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(double)
	 * @generated
	 */
	void unsetWarpingStiffness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness</em>' attribute is set.
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(double)
	 * @generated
	 */
	boolean isSetWarpingStiffness();

	/**
	 * Returns the value of the '<em><b>Warping Stiffness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Stiffness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Stiffness As String</em>' attribute.
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeConditionWarping_WarpingStiffnessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWarpingStiffnessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness As String</em>' attribute.
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @generated
	 */
	void setWarpingStiffnessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @generated
	 */
	void unsetWarpingStiffnessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness As String</em>' attribute is set.
	 * @see #unsetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @generated
	 */
	boolean isSetWarpingStiffnessAsString();

} // IfcBoundaryNodeConditionWarping
