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
import org.bimserver.models.ifc4.IfcCurveStyleFontAndScaling;
import org.bimserver.models.ifc4.IfcCurveStyleFontSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style Font And Scaling</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontAndScalingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontAndScalingImpl#getCurveFont <em>Curve Font</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontAndScalingImpl#getCurveFontScaling <em>Curve Font Scaling</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontAndScalingImpl#getCurveFontScalingAsString <em>Curve Font Scaling As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveStyleFontAndScalingImpl extends IfcPresentationItemImpl implements IfcCurveStyleFontAndScaling {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleFontAndScalingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveStyleFontSelect getCurveFont() {
		return (IfcCurveStyleFontSelect) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveFont(IfcCurveStyleFontSelect newCurveFont) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT, newCurveFont);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCurveFontScaling() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT_SCALING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveFontScaling(double newCurveFontScaling) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT_SCALING, newCurveFontScaling);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCurveFontScalingAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT_SCALING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveFontScalingAsString(String newCurveFontScalingAsString) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_AND_SCALING__CURVE_FONT_SCALING_AS_STRING, newCurveFontScalingAsString);
	}

} //IfcCurveStyleFontAndScalingImpl
