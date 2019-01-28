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

public interface IfcTextStyleWithBoxCharacteristics extends IfcTextStyleSelect {
	/**
	 * Returns the value of the '<em><b>Box Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Height</em>' attribute.
	 * @see #isSetBoxHeight()
	 * @see #unsetBoxHeight()
	 * @see #setBoxHeight(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBoxHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeight <em>Box Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Height</em>' attribute.
	 * @see #isSetBoxHeight()
	 * @see #unsetBoxHeight()
	 * @see #getBoxHeight()
	 * @generated
	 */
	void setBoxHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeight <em>Box Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxHeight()
	 * @see #getBoxHeight()
	 * @see #setBoxHeight(double)
	 * @generated
	 */
	void unsetBoxHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeight <em>Box Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Height</em>' attribute is set.
	 * @see #unsetBoxHeight()
	 * @see #getBoxHeight()
	 * @see #setBoxHeight(double)
	 * @generated
	 */
	boolean isSetBoxHeight();

	/**
	 * Returns the value of the '<em><b>Box Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Height As String</em>' attribute.
	 * @see #isSetBoxHeightAsString()
	 * @see #unsetBoxHeightAsString()
	 * @see #setBoxHeightAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoxHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeightAsString <em>Box Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Height As String</em>' attribute.
	 * @see #isSetBoxHeightAsString()
	 * @see #unsetBoxHeightAsString()
	 * @see #getBoxHeightAsString()
	 * @generated
	 */
	void setBoxHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeightAsString <em>Box Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxHeightAsString()
	 * @see #getBoxHeightAsString()
	 * @see #setBoxHeightAsString(String)
	 * @generated
	 */
	void unsetBoxHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxHeightAsString <em>Box Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Height As String</em>' attribute is set.
	 * @see #unsetBoxHeightAsString()
	 * @see #getBoxHeightAsString()
	 * @see #setBoxHeightAsString(String)
	 * @generated
	 */
	boolean isSetBoxHeightAsString();

	/**
	 * Returns the value of the '<em><b>Box Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Width</em>' attribute.
	 * @see #isSetBoxWidth()
	 * @see #unsetBoxWidth()
	 * @see #setBoxWidth(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxWidth()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBoxWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidth <em>Box Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Width</em>' attribute.
	 * @see #isSetBoxWidth()
	 * @see #unsetBoxWidth()
	 * @see #getBoxWidth()
	 * @generated
	 */
	void setBoxWidth(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidth <em>Box Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxWidth()
	 * @see #getBoxWidth()
	 * @see #setBoxWidth(double)
	 * @generated
	 */
	void unsetBoxWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidth <em>Box Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Width</em>' attribute is set.
	 * @see #unsetBoxWidth()
	 * @see #getBoxWidth()
	 * @see #setBoxWidth(double)
	 * @generated
	 */
	boolean isSetBoxWidth();

	/**
	 * Returns the value of the '<em><b>Box Width As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Width As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Width As String</em>' attribute.
	 * @see #isSetBoxWidthAsString()
	 * @see #unsetBoxWidthAsString()
	 * @see #setBoxWidthAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoxWidthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidthAsString <em>Box Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Width As String</em>' attribute.
	 * @see #isSetBoxWidthAsString()
	 * @see #unsetBoxWidthAsString()
	 * @see #getBoxWidthAsString()
	 * @generated
	 */
	void setBoxWidthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidthAsString <em>Box Width As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxWidthAsString()
	 * @see #getBoxWidthAsString()
	 * @see #setBoxWidthAsString(String)
	 * @generated
	 */
	void unsetBoxWidthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxWidthAsString <em>Box Width As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Width As String</em>' attribute is set.
	 * @see #unsetBoxWidthAsString()
	 * @see #getBoxWidthAsString()
	 * @see #setBoxWidthAsString(String)
	 * @generated
	 */
	boolean isSetBoxWidthAsString();

	/**
	 * Returns the value of the '<em><b>Box Slant Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Slant Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Slant Angle</em>' attribute.
	 * @see #isSetBoxSlantAngle()
	 * @see #unsetBoxSlantAngle()
	 * @see #setBoxSlantAngle(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBoxSlantAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngle <em>Box Slant Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Slant Angle</em>' attribute.
	 * @see #isSetBoxSlantAngle()
	 * @see #unsetBoxSlantAngle()
	 * @see #getBoxSlantAngle()
	 * @generated
	 */
	void setBoxSlantAngle(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngle <em>Box Slant Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxSlantAngle()
	 * @see #getBoxSlantAngle()
	 * @see #setBoxSlantAngle(double)
	 * @generated
	 */
	void unsetBoxSlantAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngle <em>Box Slant Angle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Slant Angle</em>' attribute is set.
	 * @see #unsetBoxSlantAngle()
	 * @see #getBoxSlantAngle()
	 * @see #setBoxSlantAngle(double)
	 * @generated
	 */
	boolean isSetBoxSlantAngle();

	/**
	 * Returns the value of the '<em><b>Box Slant Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Slant Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Slant Angle As String</em>' attribute.
	 * @see #isSetBoxSlantAngleAsString()
	 * @see #unsetBoxSlantAngleAsString()
	 * @see #setBoxSlantAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoxSlantAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngleAsString <em>Box Slant Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Slant Angle As String</em>' attribute.
	 * @see #isSetBoxSlantAngleAsString()
	 * @see #unsetBoxSlantAngleAsString()
	 * @see #getBoxSlantAngleAsString()
	 * @generated
	 */
	void setBoxSlantAngleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngleAsString <em>Box Slant Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxSlantAngleAsString()
	 * @see #getBoxSlantAngleAsString()
	 * @see #setBoxSlantAngleAsString(String)
	 * @generated
	 */
	void unsetBoxSlantAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxSlantAngleAsString <em>Box Slant Angle As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Slant Angle As String</em>' attribute is set.
	 * @see #unsetBoxSlantAngleAsString()
	 * @see #getBoxSlantAngleAsString()
	 * @see #setBoxSlantAngleAsString(String)
	 * @generated
	 */
	boolean isSetBoxSlantAngleAsString();

	/**
	 * Returns the value of the '<em><b>Box Rotate Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Rotate Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Rotate Angle</em>' attribute.
	 * @see #isSetBoxRotateAngle()
	 * @see #unsetBoxRotateAngle()
	 * @see #setBoxRotateAngle(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBoxRotateAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngle <em>Box Rotate Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Rotate Angle</em>' attribute.
	 * @see #isSetBoxRotateAngle()
	 * @see #unsetBoxRotateAngle()
	 * @see #getBoxRotateAngle()
	 * @generated
	 */
	void setBoxRotateAngle(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngle <em>Box Rotate Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxRotateAngle()
	 * @see #getBoxRotateAngle()
	 * @see #setBoxRotateAngle(double)
	 * @generated
	 */
	void unsetBoxRotateAngle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngle <em>Box Rotate Angle</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Rotate Angle</em>' attribute is set.
	 * @see #unsetBoxRotateAngle()
	 * @see #getBoxRotateAngle()
	 * @see #setBoxRotateAngle(double)
	 * @generated
	 */
	boolean isSetBoxRotateAngle();

	/**
	 * Returns the value of the '<em><b>Box Rotate Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Box Rotate Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Box Rotate Angle As String</em>' attribute.
	 * @see #isSetBoxRotateAngleAsString()
	 * @see #unsetBoxRotateAngleAsString()
	 * @see #setBoxRotateAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoxRotateAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngleAsString <em>Box Rotate Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Box Rotate Angle As String</em>' attribute.
	 * @see #isSetBoxRotateAngleAsString()
	 * @see #unsetBoxRotateAngleAsString()
	 * @see #getBoxRotateAngleAsString()
	 * @generated
	 */
	void setBoxRotateAngleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngleAsString <em>Box Rotate Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoxRotateAngleAsString()
	 * @see #getBoxRotateAngleAsString()
	 * @see #setBoxRotateAngleAsString(String)
	 * @generated
	 */
	void unsetBoxRotateAngleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getBoxRotateAngleAsString <em>Box Rotate Angle As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Box Rotate Angle As String</em>' attribute is set.
	 * @see #unsetBoxRotateAngleAsString()
	 * @see #getBoxRotateAngleAsString()
	 * @see #setBoxRotateAngleAsString(String)
	 * @generated
	 */
	boolean isSetBoxRotateAngleAsString();

	/**
	 * Returns the value of the '<em><b>Character Spacing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Character Spacing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Character Spacing</em>' reference.
	 * @see #isSetCharacterSpacing()
	 * @see #unsetCharacterSpacing()
	 * @see #setCharacterSpacing(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleWithBoxCharacteristics_CharacterSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getCharacterSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getCharacterSpacing <em>Character Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Character Spacing</em>' reference.
	 * @see #isSetCharacterSpacing()
	 * @see #unsetCharacterSpacing()
	 * @see #getCharacterSpacing()
	 * @generated
	 */
	void setCharacterSpacing(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getCharacterSpacing <em>Character Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCharacterSpacing()
	 * @see #getCharacterSpacing()
	 * @see #setCharacterSpacing(IfcSizeSelect)
	 * @generated
	 */
	void unsetCharacterSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleWithBoxCharacteristics#getCharacterSpacing <em>Character Spacing</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Character Spacing</em>' reference is set.
	 * @see #unsetCharacterSpacing()
	 * @see #getCharacterSpacing()
	 * @see #setCharacterSpacing(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetCharacterSpacing();

} // IfcTextStyleWithBoxCharacteristics
