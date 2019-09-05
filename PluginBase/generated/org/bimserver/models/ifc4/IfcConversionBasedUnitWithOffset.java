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

public interface IfcConversionBasedUnitWithOffset extends IfcConversionBasedUnit {
	/**
	 * Returns the value of the '<em><b>Conversion Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Offset</em>' attribute.
	 * @see #setConversionOffset(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnitWithOffset_ConversionOffset()
	 * @model
	 * @generated
	 */
	double getConversionOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnitWithOffset#getConversionOffset <em>Conversion Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Offset</em>' attribute.
	 * @see #getConversionOffset()
	 * @generated
	 */
	void setConversionOffset(double value);

	/**
	 * Returns the value of the '<em><b>Conversion Offset As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Offset As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversion Offset As String</em>' attribute.
	 * @see #setConversionOffsetAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcConversionBasedUnitWithOffset_ConversionOffsetAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getConversionOffsetAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcConversionBasedUnitWithOffset#getConversionOffsetAsString <em>Conversion Offset As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Offset As String</em>' attribute.
	 * @see #getConversionOffsetAsString()
	 * @generated
	 */
	void setConversionOffsetAsString(String value);

} // IfcConversionBasedUnitWithOffset
