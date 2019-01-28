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
import org.bimserver.models.ifc2x3tc1.IfcColour;
import org.bimserver.models.ifc2x3tc1.IfcCurveFontOrScaledCurveFontSelect;
import org.bimserver.models.ifc2x3tc1.IfcCurveStyle;
import org.bimserver.models.ifc2x3tc1.IfcSizeSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleImpl#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleImpl#getCurveWidth <em>Curve Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleImpl#getCurveColour <em>Curve Colour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveStyleImpl extends IfcPresentationStyleImpl implements IfcCurveStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveFontOrScaledCurveFontSelect getCurveFont() {
		return (IfcCurveFontOrScaledCurveFontSelect) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_FONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveFont(IfcCurveFontOrScaledCurveFontSelect newCurveFont) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_FONT, newCurveFont);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveFont() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_FONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveFont() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_FONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getCurveWidth() {
		return (IfcSizeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveWidth(IfcSizeSelect newCurveWidth) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH, newCurveWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveWidth() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveWidth() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColour getCurveColour() {
		return (IfcColour) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveColour(IfcColour newCurveColour) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR, newCurveColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveColour() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveColour() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR);
	}

} //IfcCurveStyleImpl
