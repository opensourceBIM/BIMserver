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

public interface IfcRoundedRectangleProfileDef extends IfcRectangleProfileDef {
	/**
	 * Returns the value of the '<em><b>Rounding Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounding Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounding Radius</em>' attribute.
	 * @see #setRoundingRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRoundedRectangleProfileDef_RoundingRadius()
	 * @model
	 * @generated
	 */
	double getRoundingRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius</em>' attribute.
	 * @see #getRoundingRadius()
	 * @generated
	 */
	void setRoundingRadius(double value);

	/**
	 * Returns the value of the '<em><b>Rounding Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounding Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounding Radius As String</em>' attribute.
	 * @see #setRoundingRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRoundedRectangleProfileDef_RoundingRadiusAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRoundingRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius As String</em>' attribute.
	 * @see #getRoundingRadiusAsString()
	 * @generated
	 */
	void setRoundingRadiusAsString(String value);

} // IfcRoundedRectangleProfileDef
