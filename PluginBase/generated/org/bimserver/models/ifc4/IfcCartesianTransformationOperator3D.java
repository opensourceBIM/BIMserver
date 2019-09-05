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

public interface IfcCartesianTransformationOperator3D extends IfcCartesianTransformationOperator {
	/**
	 * Returns the value of the '<em><b>Axis3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis3</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis3</em>' reference.
	 * @see #isSetAxis3()
	 * @see #unsetAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCartesianTransformationOperator3D_Axis3()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDirection getAxis3();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis3</em>' reference.
	 * @see #isSetAxis3()
	 * @see #unsetAxis3()
	 * @see #getAxis3()
	 * @generated
	 */
	void setAxis3(IfcDirection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAxis3()
	 * @see #getAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @generated
	 */
	void unsetAxis3();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCartesianTransformationOperator3D#getAxis3 <em>Axis3</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Axis3</em>' reference is set.
	 * @see #unsetAxis3()
	 * @see #getAxis3()
	 * @see #setAxis3(IfcDirection)
	 * @generated
	 */
	boolean isSetAxis3();

} // IfcCartesianTransformationOperator3D
