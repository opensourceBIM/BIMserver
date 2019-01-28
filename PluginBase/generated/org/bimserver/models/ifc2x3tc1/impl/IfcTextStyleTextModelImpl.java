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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcSizeSelect;
import org.bimserver.models.ifc2x3tc1.IfcTextStyleTextModel;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style Text Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getTextIndent <em>Text Indent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getTextAlign <em>Text Align</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getTextDecoration <em>Text Decoration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getLetterSpacing <em>Letter Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getWordSpacing <em>Word Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getTextTransform <em>Text Transform</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleTextModelImpl#getLineHeight <em>Line Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextStyleTextModelImpl extends IdEObjectImpl implements IfcTextStyleTextModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleTextModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getTextIndent() {
		return (IfcSizeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextIndent(IfcSizeSelect newTextIndent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT, newTextIndent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextIndent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextIndent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextAlign() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextAlign(String newTextAlign) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN, newTextAlign);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextAlign() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextAlign() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextDecoration() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextDecoration(String newTextDecoration) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION, newTextDecoration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextDecoration() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextDecoration() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getLetterSpacing() {
		return (IfcSizeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLetterSpacing(IfcSizeSelect newLetterSpacing) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING, newLetterSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLetterSpacing() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLetterSpacing() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getWordSpacing() {
		return (IfcSizeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordSpacing(IfcSizeSelect newWordSpacing) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING, newWordSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWordSpacing() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWordSpacing() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextTransform() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextTransform(String newTextTransform) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM, newTextTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextTransform() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextTransform() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getLineHeight() {
		return (IfcSizeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineHeight(IfcSizeSelect newLineHeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT, newLineHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLineHeight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLineHeight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT);
	}

} //IfcTextStyleTextModelImpl
