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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getSegmentStart <em>Segment Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getSegmentLength <em>Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getParentCurve <em>Parent Curve</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCurveSegment()
 * @model
 * @generated
 */
public interface IfcCurveSegment extends IfcSegment {
	/**
	 * Returns the value of the '<em><b>Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement</em>' reference.
	 * @see #setPlacement(IfcPlacement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCurveSegment_Placement()
	 * @model
	 * @generated
	 */
	IfcPlacement getPlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getPlacement <em>Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement</em>' reference.
	 * @see #getPlacement()
	 * @generated
	 */
	void setPlacement(IfcPlacement value);

	/**
	 * Returns the value of the '<em><b>Segment Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Start</em>' reference.
	 * @see #setSegmentStart(IfcCurveMeasureSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCurveSegment_SegmentStart()
	 * @model
	 * @generated
	 */
	IfcCurveMeasureSelect getSegmentStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getSegmentStart <em>Segment Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Start</em>' reference.
	 * @see #getSegmentStart()
	 * @generated
	 */
	void setSegmentStart(IfcCurveMeasureSelect value);

	/**
	 * Returns the value of the '<em><b>Segment Length</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Length</em>' reference.
	 * @see #setSegmentLength(IfcCurveMeasureSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCurveSegment_SegmentLength()
	 * @model
	 * @generated
	 */
	IfcCurveMeasureSelect getSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getSegmentLength <em>Segment Length</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Length</em>' reference.
	 * @see #getSegmentLength()
	 * @generated
	 */
	void setSegmentLength(IfcCurveMeasureSelect value);

	/**
	 * Returns the value of the '<em><b>Parent Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Curve</em>' reference.
	 * @see #setParentCurve(IfcCurve)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCurveSegment_ParentCurve()
	 * @model
	 * @generated
	 */
	IfcCurve getParentCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCurveSegment#getParentCurve <em>Parent Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Curve</em>' reference.
	 * @see #getParentCurve()
	 * @generated
	 */
	void setParentCurve(IfcCurve value);

} // IfcCurveSegment
