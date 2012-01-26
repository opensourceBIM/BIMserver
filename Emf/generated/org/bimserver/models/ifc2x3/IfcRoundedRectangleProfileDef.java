/**
 * Copyright (C) 2011  BIMserver.org
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
	 * @see #isSetRoundingRadius()
	 * @see #unsetRoundingRadius()
	 * @see #setRoundingRadius(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedRectangleProfileDef_RoundingRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRoundingRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius</em>' attribute.
	 * @see #isSetRoundingRadius()
	 * @see #unsetRoundingRadius()
	 * @see #getRoundingRadius()
	 * @generated
	 */
	void setRoundingRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRoundingRadius()
	 * @see #getRoundingRadius()
	 * @see #setRoundingRadius(double)
	 * @generated
	 */
	void unsetRoundingRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadius <em>Rounding Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rounding Radius</em>' attribute is set.
	 * @see #unsetRoundingRadius()
	 * @see #getRoundingRadius()
	 * @see #setRoundingRadius(double)
	 * @generated
	 */
	boolean isSetRoundingRadius();

	/**
	 * Returns the value of the '<em><b>Rounding Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounding Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounding Radius As String</em>' attribute.
	 * @see #isSetRoundingRadiusAsString()
	 * @see #unsetRoundingRadiusAsString()
	 * @see #setRoundingRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoundedRectangleProfileDef_RoundingRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRoundingRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding Radius As String</em>' attribute.
	 * @see #isSetRoundingRadiusAsString()
	 * @see #unsetRoundingRadiusAsString()
	 * @see #getRoundingRadiusAsString()
	 * @generated
	 */
	void setRoundingRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRoundingRadiusAsString()
	 * @see #getRoundingRadiusAsString()
	 * @see #setRoundingRadiusAsString(String)
	 * @generated
	 */
	void unsetRoundingRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRoundedRectangleProfileDef#getRoundingRadiusAsString <em>Rounding Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rounding Radius As String</em>' attribute is set.
	 * @see #unsetRoundingRadiusAsString()
	 * @see #getRoundingRadiusAsString()
	 * @see #setRoundingRadiusAsString(String)
	 * @generated
	 */
	boolean isSetRoundingRadiusAsString();

} // IfcRoundedRectangleProfileDef
