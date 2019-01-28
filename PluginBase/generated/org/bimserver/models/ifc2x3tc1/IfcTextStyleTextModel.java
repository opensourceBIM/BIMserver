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

public interface IfcTextStyleTextModel extends IfcTextStyleSelect {
	/**
	 * Returns the value of the '<em><b>Text Indent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Indent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Indent</em>' reference.
	 * @see #isSetTextIndent()
	 * @see #unsetTextIndent()
	 * @see #setTextIndent(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_TextIndent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getTextIndent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextIndent <em>Text Indent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Indent</em>' reference.
	 * @see #isSetTextIndent()
	 * @see #unsetTextIndent()
	 * @see #getTextIndent()
	 * @generated
	 */
	void setTextIndent(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextIndent <em>Text Indent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextIndent()
	 * @see #getTextIndent()
	 * @see #setTextIndent(IfcSizeSelect)
	 * @generated
	 */
	void unsetTextIndent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextIndent <em>Text Indent</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Indent</em>' reference is set.
	 * @see #unsetTextIndent()
	 * @see #getTextIndent()
	 * @see #setTextIndent(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetTextIndent();

	/**
	 * Returns the value of the '<em><b>Text Align</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Align</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Align</em>' attribute.
	 * @see #isSetTextAlign()
	 * @see #unsetTextAlign()
	 * @see #setTextAlign(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_TextAlign()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTextAlign();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextAlign <em>Text Align</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Align</em>' attribute.
	 * @see #isSetTextAlign()
	 * @see #unsetTextAlign()
	 * @see #getTextAlign()
	 * @generated
	 */
	void setTextAlign(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextAlign <em>Text Align</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextAlign()
	 * @see #getTextAlign()
	 * @see #setTextAlign(String)
	 * @generated
	 */
	void unsetTextAlign();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextAlign <em>Text Align</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Align</em>' attribute is set.
	 * @see #unsetTextAlign()
	 * @see #getTextAlign()
	 * @see #setTextAlign(String)
	 * @generated
	 */
	boolean isSetTextAlign();

	/**
	 * Returns the value of the '<em><b>Text Decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Decoration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Decoration</em>' attribute.
	 * @see #isSetTextDecoration()
	 * @see #unsetTextDecoration()
	 * @see #setTextDecoration(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_TextDecoration()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTextDecoration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextDecoration <em>Text Decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Decoration</em>' attribute.
	 * @see #isSetTextDecoration()
	 * @see #unsetTextDecoration()
	 * @see #getTextDecoration()
	 * @generated
	 */
	void setTextDecoration(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextDecoration <em>Text Decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextDecoration()
	 * @see #getTextDecoration()
	 * @see #setTextDecoration(String)
	 * @generated
	 */
	void unsetTextDecoration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextDecoration <em>Text Decoration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Decoration</em>' attribute is set.
	 * @see #unsetTextDecoration()
	 * @see #getTextDecoration()
	 * @see #setTextDecoration(String)
	 * @generated
	 */
	boolean isSetTextDecoration();

	/**
	 * Returns the value of the '<em><b>Letter Spacing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Letter Spacing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Letter Spacing</em>' reference.
	 * @see #isSetLetterSpacing()
	 * @see #unsetLetterSpacing()
	 * @see #setLetterSpacing(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_LetterSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getLetterSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLetterSpacing <em>Letter Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Letter Spacing</em>' reference.
	 * @see #isSetLetterSpacing()
	 * @see #unsetLetterSpacing()
	 * @see #getLetterSpacing()
	 * @generated
	 */
	void setLetterSpacing(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLetterSpacing <em>Letter Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLetterSpacing()
	 * @see #getLetterSpacing()
	 * @see #setLetterSpacing(IfcSizeSelect)
	 * @generated
	 */
	void unsetLetterSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLetterSpacing <em>Letter Spacing</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Letter Spacing</em>' reference is set.
	 * @see #unsetLetterSpacing()
	 * @see #getLetterSpacing()
	 * @see #setLetterSpacing(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetLetterSpacing();

	/**
	 * Returns the value of the '<em><b>Word Spacing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Spacing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Spacing</em>' reference.
	 * @see #isSetWordSpacing()
	 * @see #unsetWordSpacing()
	 * @see #setWordSpacing(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_WordSpacing()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getWordSpacing();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getWordSpacing <em>Word Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word Spacing</em>' reference.
	 * @see #isSetWordSpacing()
	 * @see #unsetWordSpacing()
	 * @see #getWordSpacing()
	 * @generated
	 */
	void setWordSpacing(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getWordSpacing <em>Word Spacing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWordSpacing()
	 * @see #getWordSpacing()
	 * @see #setWordSpacing(IfcSizeSelect)
	 * @generated
	 */
	void unsetWordSpacing();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getWordSpacing <em>Word Spacing</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Word Spacing</em>' reference is set.
	 * @see #unsetWordSpacing()
	 * @see #getWordSpacing()
	 * @see #setWordSpacing(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetWordSpacing();

	/**
	 * Returns the value of the '<em><b>Text Transform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Transform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Transform</em>' attribute.
	 * @see #isSetTextTransform()
	 * @see #unsetTextTransform()
	 * @see #setTextTransform(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_TextTransform()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTextTransform();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextTransform <em>Text Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Transform</em>' attribute.
	 * @see #isSetTextTransform()
	 * @see #unsetTextTransform()
	 * @see #getTextTransform()
	 * @generated
	 */
	void setTextTransform(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextTransform <em>Text Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextTransform()
	 * @see #getTextTransform()
	 * @see #setTextTransform(String)
	 * @generated
	 */
	void unsetTextTransform();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getTextTransform <em>Text Transform</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Text Transform</em>' attribute is set.
	 * @see #unsetTextTransform()
	 * @see #getTextTransform()
	 * @see #setTextTransform(String)
	 * @generated
	 */
	boolean isSetTextTransform();

	/**
	 * Returns the value of the '<em><b>Line Height</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Height</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Height</em>' reference.
	 * @see #isSetLineHeight()
	 * @see #unsetLineHeight()
	 * @see #setLineHeight(IfcSizeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTextStyleTextModel_LineHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSizeSelect getLineHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLineHeight <em>Line Height</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Height</em>' reference.
	 * @see #isSetLineHeight()
	 * @see #unsetLineHeight()
	 * @see #getLineHeight()
	 * @generated
	 */
	void setLineHeight(IfcSizeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLineHeight <em>Line Height</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLineHeight()
	 * @see #getLineHeight()
	 * @see #setLineHeight(IfcSizeSelect)
	 * @generated
	 */
	void unsetLineHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel#getLineHeight <em>Line Height</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Line Height</em>' reference is set.
	 * @see #unsetLineHeight()
	 * @see #getLineHeight()
	 * @see #setLineHeight(IfcSizeSelect)
	 * @generated
	 */
	boolean isSetLineHeight();

} // IfcTextStyleTextModel
