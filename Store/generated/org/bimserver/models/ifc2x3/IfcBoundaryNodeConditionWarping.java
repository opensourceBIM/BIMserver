/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Boundary Node Condition Warping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping()
 * @model
 * @generated
 */
public interface IfcBoundaryNodeConditionWarping extends IfcBoundaryNodeCondition
{
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
	 * @see #setWarpingStiffness(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping_WarpingStiffness()
	 * @model unsettable="true"
	 * @generated
	 */
	float getWarpingStiffness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness</em>' attribute.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @generated
	 */
	void setWarpingStiffness(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(float)
	 * @generated
	 */
	void unsetWarpingStiffness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness</em>' attribute is set.
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeConditionWarping_WarpingStiffnessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWarpingStiffnessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffnessAsString()
	 * @see #getWarpingStiffnessAsString()
	 * @see #setWarpingStiffnessAsString(String)
	 * @generated
	 */
	void unsetWarpingStiffnessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeConditionWarping#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}' attribute is set.
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
