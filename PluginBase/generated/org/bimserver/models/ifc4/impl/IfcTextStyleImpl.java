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
import org.bimserver.models.ifc4.IfcTextFontSelect;
import org.bimserver.models.ifc4.IfcTextStyle;
import org.bimserver.models.ifc4.IfcTextStyleForDefinedFont;
import org.bimserver.models.ifc4.IfcTextStyleTextModel;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleImpl#getTextCharacterAppearance <em>Text Character Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleImpl#getTextStyle <em>Text Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleImpl#getTextFontStyle <em>Text Font Style</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleImpl#getModelOrDraughting <em>Model Or Draughting</em>}</li>
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
		return Ifc4Package.Literals.IFC_TEXT_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyleForDefinedFont getTextCharacterAppearance() {
		return (IfcTextStyleForDefinedFont) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextCharacterAppearance(IfcTextStyleForDefinedFont newTextCharacterAppearance) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE, newTextCharacterAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextCharacterAppearance() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextCharacterAppearance() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_CHARACTER_APPEARANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyleTextModel getTextStyle() {
		return (IfcTextStyleTextModel) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextStyle(IfcTextStyleTextModel newTextStyle) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE, newTextStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTextStyle() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTextStyle() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextFontSelect getTextFontStyle() {
		return (IfcTextFontSelect) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTextFontStyle(IfcTextFontSelect newTextFontStyle) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE__TEXT_FONT_STYLE, newTextFontStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getModelOrDraughting() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE__MODEL_OR_DRAUGHTING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelOrDraughting(Tristate newModelOrDraughting) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE__MODEL_OR_DRAUGHTING, newModelOrDraughting);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetModelOrDraughting() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE__MODEL_OR_DRAUGHTING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetModelOrDraughting() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE__MODEL_OR_DRAUGHTING);
	}

} //IfcTextStyleImpl
