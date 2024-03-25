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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCurve;
import org.bimserver.models.ifc4x3.IfcCurveMeasureSelect;
import org.bimserver.models.ifc4x3.IfcCurveSegment;
import org.bimserver.models.ifc4x3.IfcPlacement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveSegmentImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveSegmentImpl#getSegmentStart <em>Segment Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveSegmentImpl#getSegmentLength <em>Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCurveSegmentImpl#getParentCurve <em>Parent Curve</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCurveSegmentImpl extends IfcSegmentImpl implements IfcCurveSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCurveSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_CURVE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlacement getPlacement() {
		return (IfcPlacement) eGet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__PLACEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlacement(IfcPlacement newPlacement) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__PLACEMENT, newPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveMeasureSelect getSegmentStart() {
		return (IfcCurveMeasureSelect) eGet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__SEGMENT_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSegmentStart(IfcCurveMeasureSelect newSegmentStart) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__SEGMENT_START, newSegmentStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveMeasureSelect getSegmentLength() {
		return (IfcCurveMeasureSelect) eGet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSegmentLength(IfcCurveMeasureSelect newSegmentLength) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__SEGMENT_LENGTH, newSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getParentCurve() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__PARENT_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentCurve(IfcCurve newParentCurve) {
		eSet(Ifc4x3Package.Literals.IFC_CURVE_SEGMENT__PARENT_CURVE, newParentCurve);
	}

} //IfcCurveSegmentImpl
