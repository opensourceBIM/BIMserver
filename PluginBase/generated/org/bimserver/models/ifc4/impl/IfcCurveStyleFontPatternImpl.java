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
import org.bimserver.models.ifc4.IfcCurveStyleFontPattern;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontPatternImpl#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCurveStyleFontPatternImpl#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveStyleFontPatternImpl extends IfcPresentationItemImpl implements IfcCurveStyleFontPattern {
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
		return Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getVisibleSegmentLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibleSegmentLength(double newVisibleSegmentLength) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH, newVisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVisibleSegmentLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibleSegmentLengthAsString(String newVisibleSegmentLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__VISIBLE_SEGMENT_LENGTH_AS_STRING, newVisibleSegmentLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getInvisibleSegmentLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvisibleSegmentLength(double newInvisibleSegmentLength) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH, newInvisibleSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInvisibleSegmentLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvisibleSegmentLengthAsString(String newInvisibleSegmentLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_CURVE_STYLE_FONT_PATTERN__INVISIBLE_SEGMENT_LENGTH_AS_STRING, newInvisibleSegmentLengthAsString);
	}

} //IfcCurveStyleFontPatternImpl
