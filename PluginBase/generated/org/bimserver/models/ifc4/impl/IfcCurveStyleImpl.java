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
import org.bimserver.models.ifc4.IfcCurveFontOrScaledCurveFontSelect;
import org.bimserver.models.ifc4.IfcCurveStyle;
import org.bimserver.models.ifc4.IfcSizeSelect;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleImpl#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleImpl#getCurveWidth <em>Curve Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleImpl#getCurveColour <em>Curve Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleImpl#getModelOrDraughting <em>Model Or Draughting</em>}</li>
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
		return Ifc4Package.Literals.IFC_CURVE_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveFontOrScaledCurveFontSelect getCurveFont() {
		return (IfcCurveFontOrScaledCurveFontSelect) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_FONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveFont(IfcCurveFontOrScaledCurveFontSelect newCurveFont) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_FONT, newCurveFont);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurveFont() {
		eUnset(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_FONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurveFont() {
		return eIsSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_FONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSizeSelect getCurveWidth() {
		return (IfcSizeSelect) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveWidth(IfcSizeSelect newCurveWidth) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH, newCurveWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurveWidth() {
		eUnset(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurveWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColour getCurveColour() {
		return (IfcColour) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveColour(IfcColour newCurveColour) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR, newCurveColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurveColour() {
		eUnset(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurveColour() {
		return eIsSet(Ifc4Package.Literals.IFC_CURVE_STYLE__CURVE_COLOUR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getModelOrDraughting() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE__MODEL_OR_DRAUGHTING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelOrDraughting(Tristate newModelOrDraughting) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE__MODEL_OR_DRAUGHTING, newModelOrDraughting);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetModelOrDraughting() {
		eUnset(Ifc4Package.Literals.IFC_CURVE_STYLE__MODEL_OR_DRAUGHTING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetModelOrDraughting() {
		return eIsSet(Ifc4Package.Literals.IFC_CURVE_STYLE__MODEL_OR_DRAUGHTING);
	}

} //IfcCurveStyleImpl
