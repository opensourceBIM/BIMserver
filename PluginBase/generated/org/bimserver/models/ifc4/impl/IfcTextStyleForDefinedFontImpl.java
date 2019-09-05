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
import org.bimserver.models.ifc4.IfcColour;
import org.bimserver.models.ifc4.IfcTextStyleForDefinedFont;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style For Defined Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleForDefinedFontImpl#getColour <em>Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTextStyleForDefinedFontImpl#getBackgroundColour <em>Background Colour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTextStyleForDefinedFontImpl extends IfcPresentationItemImpl implements IfcTextStyleForDefinedFont {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleForDefinedFontImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColour getColour() {
		return (IfcColour) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColour(IfcColour newColour) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__COLOUR, newColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColour getBackgroundColour() {
		return (IfcColour) eGet(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__BACKGROUND_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackgroundColour(IfcColour newBackgroundColour) {
		eSet(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__BACKGROUND_COLOUR, newBackgroundColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBackgroundColour() {
		eUnset(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__BACKGROUND_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBackgroundColour() {
		return eIsSet(Ifc4Package.Literals.IFC_TEXT_STYLE_FOR_DEFINED_FONT__BACKGROUND_COLOUR);
	}

} //IfcTextStyleForDefinedFontImpl
