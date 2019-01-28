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

public interface IfcTextStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Text Character Appearance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Character Appearance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Character Appearance</em>' reference.
	 * @see #isSetTextCharacterAppearance()
	 * @see #unsetTextCharacterAppearance()
	 * @see #setTextCharacterAppearance(IfcCharacterStyleSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyle_TextCharacterAppearance()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCharacterStyleSelect getTextCharacterAppearance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Character Appearance</em>' reference.
	 * @see #isSetTextCharacterAppearance()
	 * @see #unsetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @generated
	 */
	void setTextCharacterAppearance(IfcCharacterStyleSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @see #setTextCharacterAppearance(IfcCharacterStyleSelect)
	 * @generated
	 */
	void unsetTextCharacterAppearance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Character Appearance</em>' reference is set.
	 * @see #unsetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @see #setTextCharacterAppearance(IfcCharacterStyleSelect)
	 * @generated
	 */
	boolean isSetTextCharacterAppearance();

	/**
	 * Returns the value of the '<em><b>Text Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Style</em>' reference.
	 * @see #isSetTextStyle()
	 * @see #unsetTextStyle()
	 * @see #setTextStyle(IfcTextStyleSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyle_TextStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTextStyleSelect getTextStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Style</em>' reference.
	 * @see #isSetTextStyle()
	 * @see #unsetTextStyle()
	 * @see #getTextStyle()
	 * @generated
	 */
	void setTextStyle(IfcTextStyleSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextStyle()
	 * @see #getTextStyle()
	 * @see #setTextStyle(IfcTextStyleSelect)
	 * @generated
	 */
	void unsetTextStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Style</em>' reference is set.
	 * @see #unsetTextStyle()
	 * @see #getTextStyle()
	 * @see #setTextStyle(IfcTextStyleSelect)
	 * @generated
	 */
	boolean isSetTextStyle();

	/**
	 * Returns the value of the '<em><b>Text Font Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Font Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Font Style</em>' reference.
	 * @see #setTextFontStyle(IfcTextFontSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyle_TextFontStyle()
	 * @model
	 * @generated
	 */
	IfcTextFontSelect getTextFontStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyle#getTextFontStyle <em>Text Font Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Font Style</em>' reference.
	 * @see #getTextFontStyle()
	 * @generated
	 */
	void setTextFontStyle(IfcTextFontSelect value);

} // IfcTextStyle
