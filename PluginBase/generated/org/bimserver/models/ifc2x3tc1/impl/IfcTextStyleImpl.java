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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCharacterStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcTextFontSelect;
import org.bimserver.models.ifc2x3tc1.IfcTextStyle;
import org.bimserver.models.ifc2x3tc1.IfcTextStyleSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleImpl#getTextCharacterAppearance <em>Text Character Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleImpl#getTextStyle <em>Text Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTextStyleImpl#getTextFontStyle <em>Text Font Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextStyleImpl extends IfcPresentationStyleImpl implements IfcTextStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCharacterStyleSelect getTextCharacterAppearance() {
		return (IfcCharacterStyleSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextCharacterAppearance(IfcCharacterStyleSelect newTextCharacterAppearance) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE, newTextCharacterAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextCharacterAppearance() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextCharacterAppearance() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleSelect getTextStyle() {
		return (IfcTextStyleSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextStyle(IfcTextStyleSelect newTextStyle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, newTextStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextStyle() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextStyle() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextFontSelect getTextFontStyle() {
		return (IfcTextFontSelect) eGet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextFontStyle(IfcTextFontSelect newTextFontStyle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, newTextFontStyle);
	}

} //IfcTextStyleImpl
