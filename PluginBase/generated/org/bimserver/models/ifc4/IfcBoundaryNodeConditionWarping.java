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

public interface IfcBoundaryNodeConditionWarping extends IfcBoundaryNodeCondition {
	/**
	 * Returns the value of the '<em><b>Warping Stiffness</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Warping Stiffness</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warping Stiffness</em>' reference.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #setWarpingStiffness(IfcWarpingStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeConditionWarping_WarpingStiffness()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcWarpingStiffnessSelect getWarpingStiffness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warping Stiffness</em>' reference.
	 * @see #isSetWarpingStiffness()
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @generated
	 */
	void setWarpingStiffness(IfcWarpingStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(IfcWarpingStiffnessSelect)
	 * @generated
	 */
	void unsetWarpingStiffness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeConditionWarping#getWarpingStiffness <em>Warping Stiffness</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Warping Stiffness</em>' reference is set.
	 * @see #unsetWarpingStiffness()
	 * @see #getWarpingStiffness()
	 * @see #setWarpingStiffness(IfcWarpingStiffnessSelect)
	 * @generated
	 */
	boolean isSetWarpingStiffness();

} // IfcBoundaryNodeConditionWarping
