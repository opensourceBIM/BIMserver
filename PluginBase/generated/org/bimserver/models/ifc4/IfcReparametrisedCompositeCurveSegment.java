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

public interface IfcReparametrisedCompositeCurveSegment extends IfcCompositeCurveSegment {
	/**
	 * Returns the value of the '<em><b>Param Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Length</em>' attribute.
	 * @see #setParamLength(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReparametrisedCompositeCurveSegment_ParamLength()
	 * @model
	 * @generated
	 */
	double getParamLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReparametrisedCompositeCurveSegment#getParamLength <em>Param Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Length</em>' attribute.
	 * @see #getParamLength()
	 * @generated
	 */
	void setParamLength(double value);

	/**
	 * Returns the value of the '<em><b>Param Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Length As String</em>' attribute.
	 * @see #setParamLengthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcReparametrisedCompositeCurveSegment_ParamLengthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getParamLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcReparametrisedCompositeCurveSegment#getParamLengthAsString <em>Param Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Length As String</em>' attribute.
	 * @see #getParamLengthAsString()
	 * @generated
	 */
	void setParamLengthAsString(String value);

} // IfcReparametrisedCompositeCurveSegment
