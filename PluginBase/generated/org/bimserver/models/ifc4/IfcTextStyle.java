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
	 * @see #setTextCharacterAppearance(IfcTextStyleForDefinedFont)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextStyle_TextCharacterAppearance()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTextStyleForDefinedFont getTextCharacterAppearance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Character Appearance</em>' reference.
	 * @see #isSetTextCharacterAppearance()
	 * @see #unsetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @generated
	 */
	void setTextCharacterAppearance(IfcTextStyleForDefinedFont value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @see #setTextCharacterAppearance(IfcTextStyleForDefinedFont)
	 * @generated
	 */
	void unsetTextCharacterAppearance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextCharacterAppearance <em>Text Character Appearance</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Character Appearance</em>' reference is set.
	 * @see #unsetTextCharacterAppearance()
	 * @see #getTextCharacterAppearance()
	 * @see #setTextCharacterAppearance(IfcTextStyleForDefinedFont)
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
	 * @see #setTextStyle(IfcTextStyleTextModel)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextStyle_TextStyle()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTextStyleTextModel getTextStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Style</em>' reference.
	 * @see #isSetTextStyle()
	 * @see #unsetTextStyle()
	 * @see #getTextStyle()
	 * @generated
	 */
	void setTextStyle(IfcTextStyleTextModel value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextStyle()
	 * @see #getTextStyle()
	 * @see #setTextStyle(IfcTextStyleTextModel)
	 * @generated
	 */
	void unsetTextStyle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextStyle <em>Text Style</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Style</em>' reference is set.
	 * @see #unsetTextStyle()
	 * @see #getTextStyle()
	 * @see #setTextStyle(IfcTextStyleTextModel)
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextStyle_TextFontStyle()
	 * @model
	 * @generated
	 */
	IfcTextFontSelect getTextFontStyle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getTextFontStyle <em>Text Font Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Font Style</em>' reference.
	 * @see #getTextFontStyle()
	 * @generated
	 */
	void setTextFontStyle(IfcTextFontSelect value);

	/**
	 * Returns the value of the '<em><b>Model Or Draughting</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Or Draughting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTextStyle_ModelOrDraughting()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getModelOrDraughting();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Or Draughting</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetModelOrDraughting()
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @generated
	 */
	void setModelOrDraughting(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	void unsetModelOrDraughting();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTextStyle#getModelOrDraughting <em>Model Or Draughting</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Model Or Draughting</em>' attribute is set.
	 * @see #unsetModelOrDraughting()
	 * @see #getModelOrDraughting()
	 * @see #setModelOrDraughting(Tristate)
	 * @generated
	 */
	boolean isSetModelOrDraughting();

} // IfcTextStyle
