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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcRectangleHollowProfileDef extends IfcRectangleProfileDef {
	/**
	 * Returns the value of the '<em><b>Wall Thickness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness</em>' attribute.
	 * @see #setWallThickness(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_WallThickness()
	 * @model
	 * @generated
	 */
	double getWallThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness</em>' attribute.
	 * @see #getWallThickness()
	 * @generated
	 */
	void setWallThickness(double value);

	/**
	 * Returns the value of the '<em><b>Wall Thickness As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wall Thickness As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #setWallThicknessAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_WallThicknessAsString()
	 * @model
	 * @generated
	 */
	String getWallThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #getWallThicknessAsString()
	 * @generated
	 */
	void setWallThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Inner Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Fillet Radius</em>' attribute.
	 * @see #isSetInnerFilletRadius()
	 * @see #unsetInnerFilletRadius()
	 * @see #setInnerFilletRadius(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_InnerFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getInnerFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Fillet Radius</em>' attribute.
	 * @see #isSetInnerFilletRadius()
	 * @see #unsetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @generated
	 */
	void setInnerFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @see #setInnerFilletRadius(double)
	 * @generated
	 */
	void unsetInnerFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadius <em>Inner Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Fillet Radius</em>' attribute is set.
	 * @see #unsetInnerFilletRadius()
	 * @see #getInnerFilletRadius()
	 * @see #setInnerFilletRadius(double)
	 * @generated
	 */
	boolean isSetInnerFilletRadius();

	/**
	 * Returns the value of the '<em><b>Inner Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Fillet Radius As String</em>' attribute.
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInnerFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Fillet Radius As String</em>' attribute.
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @generated
	 */
	void setInnerFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetInnerFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Fillet Radius As String</em>' attribute is set.
	 * @see #unsetInnerFilletRadiusAsString()
	 * @see #getInnerFilletRadiusAsString()
	 * @see #setInnerFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetInnerFilletRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Outer Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Fillet Radius</em>' attribute.
	 * @see #isSetOuterFilletRadius()
	 * @see #unsetOuterFilletRadius()
	 * @see #setOuterFilletRadius(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_OuterFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOuterFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Fillet Radius</em>' attribute.
	 * @see #isSetOuterFilletRadius()
	 * @see #unsetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @generated
	 */
	void setOuterFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @see #setOuterFilletRadius(double)
	 * @generated
	 */
	void unsetOuterFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadius <em>Outer Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Outer Fillet Radius</em>' attribute is set.
	 * @see #unsetOuterFilletRadius()
	 * @see #getOuterFilletRadius()
	 * @see #setOuterFilletRadius(double)
	 * @generated
	 */
	boolean isSetOuterFilletRadius();

	/**
	 * Returns the value of the '<em><b>Outer Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Fillet Radius As String</em>' attribute.
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getOuterFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Fillet Radius As String</em>' attribute.
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @generated
	 */
	void setOuterFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetOuterFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRectangleHollowProfileDef#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Outer Fillet Radius As String</em>' attribute is set.
	 * @see #unsetOuterFilletRadiusAsString()
	 * @see #getOuterFilletRadiusAsString()
	 * @see #setOuterFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetOuterFilletRadiusAsString();

} // IfcRectangleHollowProfileDef
