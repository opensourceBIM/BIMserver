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
import org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveStyleFontPatternImpl extends IdEObjectImpl implements IfcCurveStyleFontPattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveStyleFontPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN;
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
	public double getVisibleSegmentLength() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLength(double newVisibleSegmentLength) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH, newVisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleSegmentLengthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleSegmentLengthAsString(String newVisibleSegmentLengthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH_AS_STRING,
				newVisibleSegmentLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInvisibleSegmentLength() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLength(double newInvisibleSegmentLength) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH,
				newInvisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvisibleSegmentLengthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvisibleSegmentLengthAsString(String newInvisibleSegmentLengthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH_AS_STRING,
				newInvisibleSegmentLengthAsString);
	}

} //IfcCurveStyleFontPatternImpl
