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

public interface IfcCShapeProfileDef extends IfcParameterizedProfileDef {
	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_Depth()
	 * @model
	 * @generated
	 */
	double getDepth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(double value);

	/**
	 * Returns the value of the '<em><b>Depth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth As String</em>' attribute.
	 * @see #setDepthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_DepthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getDepthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getDepthAsString <em>Depth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth As String</em>' attribute.
	 * @see #getDepthAsString()
	 * @generated
	 */
	void setDepthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_Width()
	 * @model
	 * @generated
	 */
	double getWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(double value);

	/**
	 * Returns the value of the '<em><b>Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width As String</em>' attribute.
	 * @see #setWidthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_WidthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getWidthAsString <em>Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width As String</em>' attribute.
	 * @see #getWidthAsString()
	 * @generated
	 */
	void setWidthAsString(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_WallThickness()
	 * @model
	 * @generated
	 */
	double getWallThickness();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getWallThickness <em>Wall Thickness</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_WallThicknessAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getWallThicknessAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getWallThicknessAsString <em>Wall Thickness As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wall Thickness As String</em>' attribute.
	 * @see #getWallThicknessAsString()
	 * @generated
	 */
	void setWallThicknessAsString(String value);

	/**
	 * Returns the value of the '<em><b>Girth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Girth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Girth</em>' attribute.
	 * @see #setGirth(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_Girth()
	 * @model
	 * @generated
	 */
	double getGirth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getGirth <em>Girth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Girth</em>' attribute.
	 * @see #getGirth()
	 * @generated
	 */
	void setGirth(double value);

	/**
	 * Returns the value of the '<em><b>Girth As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Girth As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Girth As String</em>' attribute.
	 * @see #setGirthAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_GirthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getGirthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getGirthAsString <em>Girth As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Girth As String</em>' attribute.
	 * @see #getGirthAsString()
	 * @generated
	 */
	void setGirthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Internal Fillet Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Fillet Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Fillet Radius</em>' attribute.
	 * @see #isSetInternalFilletRadius()
	 * @see #unsetInternalFilletRadius()
	 * @see #setInternalFilletRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_InternalFilletRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getInternalFilletRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Fillet Radius</em>' attribute.
	 * @see #isSetInternalFilletRadius()
	 * @see #unsetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @generated
	 */
	void setInternalFilletRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @see #setInternalFilletRadius(double)
	 * @generated
	 */
	void unsetInternalFilletRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadius <em>Internal Fillet Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Fillet Radius</em>' attribute is set.
	 * @see #unsetInternalFilletRadius()
	 * @see #getInternalFilletRadius()
	 * @see #setInternalFilletRadius(double)
	 * @generated
	 */
	boolean isSetInternalFilletRadius();

	/**
	 * Returns the value of the '<em><b>Internal Fillet Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Fillet Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Fillet Radius As String</em>' attribute.
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCShapeProfileDef_InternalFilletRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getInternalFilletRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Fillet Radius As String</em>' attribute.
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @generated
	 */
	void setInternalFilletRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @generated
	 */
	void unsetInternalFilletRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCShapeProfileDef#getInternalFilletRadiusAsString <em>Internal Fillet Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Fillet Radius As String</em>' attribute is set.
	 * @see #unsetInternalFilletRadiusAsString()
	 * @see #getInternalFilletRadiusAsString()
	 * @see #setInternalFilletRadiusAsString(String)
	 * @generated
	 */
	boolean isSetInternalFilletRadiusAsString();

} // IfcCShapeProfileDef
