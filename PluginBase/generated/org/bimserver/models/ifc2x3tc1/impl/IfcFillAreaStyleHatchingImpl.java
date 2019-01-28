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
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcCurveStyle;
import org.bimserver.models.ifc2x3tc1.IfcFillAreaStyleHatching;
import org.bimserver.models.ifc2x3tc1.IfcHatchLineDistanceSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style Hatching</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAppearance <em>Hatch Line Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getStartOfNextHatchLine <em>Start Of Next Hatch Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getPointOfReferenceHatchLine <em>Point Of Reference Hatch Line</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getPatternStart <em>Pattern Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAngle <em>Hatch Line Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFillAreaStyleHatchingImpl#getHatchLineAngleAsString <em>Hatch Line Angle As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFillAreaStyleHatchingImpl extends IfcGeometricRepresentationItemImpl
		implements IfcFillAreaStyleHatching {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleHatchingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyle getHatchLineAppearance() {
		return (IfcCurveStyle) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_APPEARANCE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAppearance(IfcCurveStyle newHatchLineAppearance) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_APPEARANCE, newHatchLineAppearance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHatchLineDistanceSelect getStartOfNextHatchLine() {
		return (IfcHatchLineDistanceSelect) eGet(
				Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__START_OF_NEXT_HATCH_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOfNextHatchLine(IfcHatchLineDistanceSelect newStartOfNextHatchLine) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__START_OF_NEXT_HATCH_LINE, newStartOfNextHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPointOfReferenceHatchLine() {
		return (IfcCartesianPoint) eGet(
				Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOfReferenceHatchLine(IfcCartesianPoint newPointOfReferenceHatchLine) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE,
				newPointOfReferenceHatchLine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPointOfReferenceHatchLine() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPointOfReferenceHatchLine() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__POINT_OF_REFERENCE_HATCH_LINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPatternStart() {
		return (IfcCartesianPoint) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternStart(IfcCartesianPoint newPatternStart) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START, newPatternStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPatternStart() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPatternStart() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__PATTERN_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHatchLineAngle() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngle(double newHatchLineAngle) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE, newHatchLineAngle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHatchLineAngleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHatchLineAngleAsString(String newHatchLineAngleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FILL_AREA_STYLE_HATCHING__HATCH_LINE_ANGLE_AS_STRING,
				newHatchLineAngleAsString);
	}

} //IfcFillAreaStyleHatchingImpl
