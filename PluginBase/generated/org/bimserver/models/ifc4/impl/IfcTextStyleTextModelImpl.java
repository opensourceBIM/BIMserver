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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcSizeSelect;
import org.bimserver.models.ifc4.IfcTextStyleTextModel;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style Text Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getTextIndent <em>Text Indent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getTextAlign <em>Text Align</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getTextDecoration <em>Text Decoration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getLetterSpacing <em>Letter Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getWordSpacing <em>Word Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getTextTransform <em>Text Transform</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleTextModelImpl#getLineHeight <em>Line Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextStyleTextModelImpl extends IfcPresentationItemImpl implements IfcTextStyleTextModel {
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
		return Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSizeSelect getTextIndent() {
		return (IfcSizeSelect) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextIndent(IfcSizeSelect newTextIndent) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT, newTextIndent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextIndent() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextIndent() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_INDENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextAlign() {
		return (String) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextAlign(String newTextAlign) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN, newTextAlign);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextAlign() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextAlign() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_ALIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextDecoration() {
		return (String) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextDecoration(String newTextDecoration) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION, newTextDecoration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextDecoration() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextDecoration() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_DECORATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSizeSelect getLetterSpacing() {
		return (IfcSizeSelect) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLetterSpacing(IfcSizeSelect newLetterSpacing) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING, newLetterSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLetterSpacing() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLetterSpacing() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LETTER_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSizeSelect getWordSpacing() {
		return (IfcSizeSelect) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWordSpacing(IfcSizeSelect newWordSpacing) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING, newWordSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWordSpacing() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWordSpacing() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__WORD_SPACING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTextTransform() {
		return (String) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextTransform(String newTextTransform) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM, newTextTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextTransform() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextTransform() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__TEXT_TRANSFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSizeSelect getLineHeight() {
		return (IfcSizeSelect) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLineHeight(IfcSizeSelect newLineHeight) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT, newLineHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLineHeight() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLineHeight() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_TEXT_MODEL__LINE_HEIGHT);
	}

} //IfcTextStyleTextModelImpl
