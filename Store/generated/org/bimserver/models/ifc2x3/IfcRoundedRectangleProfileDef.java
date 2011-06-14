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
 * A representation of the model object '<em><b>Ifc Rounded Rectangle Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedRectangleProfileDef()
 * @model
 * @generated
 */
public interface IfcRoundedRectangleProfileDef extends IfcRectangleProfileDef
{
	/**
	 * Returns the value of the '<em><b>Rounding Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounding Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounding Radius</em>' attribute.
	 * @see #setRoundingRadius(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedRectangleProfileDef_RoundingRadius()
	 * @model
	 * @generated
	 */
	float getRoundingRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius</em>' attribute.
	 * @see #getRoundingRadius()
	 * @generated
	 */
	void setRoundingRadius(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedRectangleProfileDef_RoundingRadiusAsString()
	 * @model
	 * @generated
	 */
	String getRoundingRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius As String</em>' attribute.
	 * @see #getRoundingRadiusAsString()
	 * @generated
	 */
	void setRoundingRadiusAsString(String value);

} // IfcRoundedRectangleProfileDef
