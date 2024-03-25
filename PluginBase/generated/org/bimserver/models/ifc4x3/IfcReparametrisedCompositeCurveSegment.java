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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Reparametrised Composite Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcReparametrisedCompositeCurveSegment#getParamLength <em>Param Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcReparametrisedCompositeCurveSegment#getParamLengthAsString <em>Param Length As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcReparametrisedCompositeCurveSegment()
 * @model
 * @generated
 */
public interface IfcReparametrisedCompositeCurveSegment extends IfcCompositeCurveSegment {
	/**
	 * Returns the value of the '<em><b>Param Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Length</em>' attribute.
	 * @see #setParamLength(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcReparametrisedCompositeCurveSegment_ParamLength()
	 * @model
	 * @generated
	 */
	double getParamLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcReparametrisedCompositeCurveSegment#getParamLength <em>Param Length</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Length As String</em>' attribute.
	 * @see #setParamLengthAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcReparametrisedCompositeCurveSegment_ParamLengthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getParamLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcReparametrisedCompositeCurveSegment#getParamLengthAsString <em>Param Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Length As String</em>' attribute.
	 * @see #getParamLengthAsString()
	 * @generated
	 */
	void setParamLengthAsString(String value);

} // IfcReparametrisedCompositeCurveSegment
