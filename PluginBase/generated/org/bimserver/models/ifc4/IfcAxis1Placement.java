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

public interface IfcAxis1Placement extends IfcPlacement {
	/**
	 * Returns the value of the '<em><b>Axis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' reference.
	 * @see #isSetAxis()
	 * @see #unsetAxis()
	 * @see #setAxis(IfcDirection)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAxis1Placement_Axis()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getAxis();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcAxis1Placement#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' reference.
	 * @see #isSetAxis()
	 * @see #unsetAxis()
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcAxis1Placement#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxis()
	 * @see #getAxis()
	 * @see #setAxis(IfcDirection)
	 * @generated
	 */
	void unsetAxis();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcAxis1Placement#getAxis <em>Axis</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis</em>' reference is set.
	 * @see #unsetAxis()
	 * @see #getAxis()
	 * @see #setAxis(IfcDirection)
	 * @generated
	 */
	boolean isSetAxis();

} // IfcAxis1Placement
