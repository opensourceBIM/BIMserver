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
 * A representation of the model object '<em><b>Ifc Circle Hollow Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircleHollowProfileDef()
 * @model
 * @generated
 */
public interface IfcCircleHollowProfileDef extends IfcCircleProfileDef {
	/**
	 * Returns the value of the '<em><b>Wall Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness</em>' attribute.
	 * @see #isSetWallThickness()
	 * @see #unsetWallThickness()
	 * @see #setWallThickness(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircleHollowProfileDef_WallThickness()
	 * @model unsettable="true"
	 * @generated
	 */
	double getWallThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness</em>' attribute.
	 * @see #isSetWallThickness()
	 * @see #unsetWallThickness()
	 * @see #getWallThickness()
	 * @generated
	 */
	void setWallThickness(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWallThickness()
	 * @see #getWallThickness()
	 * @see #setWallThickness(double)
	 * @generated
	 */
	void unsetWallThickness();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Wall Thickness</em>' attribute is set.
	 * @see #unsetWallThickness()
	 * @see #getWallThickness()
	 * @see #setWallThickness(double)
	 * @generated
	 */
	boolean isSetWallThickness();

	/**
	 * Returns the value of the '<em><b>Wall Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #isSetWallThicknessAsString()
	 * @see #unsetWallThicknessAsString()
	 * @see #setWallThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCircleHollowProfileDef_WallThicknessAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWallThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #isSetWallThicknessAsString()
	 * @see #unsetWallThicknessAsString()
	 * @see #getWallThicknessAsString()
	 * @generated
	 */
	void setWallThicknessAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWallThicknessAsString()
	 * @see #getWallThicknessAsString()
	 * @see #setWallThicknessAsString(String)
	 * @generated
	 */
	void unsetWallThicknessAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCircleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Wall Thickness As String</em>' attribute is set.
	 * @see #unsetWallThicknessAsString()
	 * @see #getWallThicknessAsString()
	 * @see #setWallThicknessAsString(String)
	 * @generated
	 */
	boolean isSetWallThicknessAsString();

} // IfcCircleHollowProfileDef
