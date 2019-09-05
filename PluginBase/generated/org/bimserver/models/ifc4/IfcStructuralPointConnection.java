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

public interface IfcStructuralPointConnection extends IfcStructuralConnection {
	/**
	 * Returns the value of the '<em><b>Condition Coordinate System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Coordinate System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Coordinate System</em>' reference.
	 * @see #isSetConditionCoordinateSystem()
	 * @see #unsetConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStructuralPointConnection_ConditionCoordinateSystem()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getConditionCoordinateSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralPointConnection#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Coordinate System</em>' reference.
	 * @see #isSetConditionCoordinateSystem()
	 * @see #unsetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @generated
	 */
	void setConditionCoordinateSystem(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcStructuralPointConnection#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetConditionCoordinateSystem();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcStructuralPointConnection#getConditionCoordinateSystem <em>Condition Coordinate System</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Condition Coordinate System</em>' reference is set.
	 * @see #unsetConditionCoordinateSystem()
	 * @see #getConditionCoordinateSystem()
	 * @see #setConditionCoordinateSystem(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetConditionCoordinateSystem();

} // IfcStructuralPointConnection
