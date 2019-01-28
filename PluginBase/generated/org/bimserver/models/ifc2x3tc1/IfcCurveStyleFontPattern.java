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
package org.bimserver.models.ifc2x3tc1;

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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurveStyleFontPattern()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcCurveStyleFontPattern extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Visible Segment Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Segment Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Segment Length</em>' attribute.
	 * @see #setVisibleSegmentLength(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurveStyleFontPattern_VisibleSegmentLength()
	 * @model
	 * @generated
	 */
	double getVisibleSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getVisibleSegmentLength <em>Visible Segment Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Segment Length</em>' attribute.
	 * @see #getVisibleSegmentLength()
	 * @generated
	 */
	void setVisibleSegmentLength(double value);

	/**
	 * Returns the value of the '<em><b>Visible Segment Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Segment Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Segment Length As String</em>' attribute.
	 * @see #setVisibleSegmentLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString()
	 * @model
	 * @generated
	 */
	String getVisibleSegmentLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Segment Length As String</em>' attribute.
	 * @see #getVisibleSegmentLengthAsString()
	 * @generated
	 */
	void setVisibleSegmentLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Invisible Segment Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invisible Segment Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invisible Segment Length</em>' attribute.
	 * @see #setInvisibleSegmentLength(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurveStyleFontPattern_InvisibleSegmentLength()
	 * @model
	 * @generated
	 */
	double getInvisibleSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getInvisibleSegmentLength <em>Invisible Segment Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invisible Segment Length</em>' attribute.
	 * @see #getInvisibleSegmentLength()
	 * @generated
	 */
	void setInvisibleSegmentLength(double value);

	/**
	 * Returns the value of the '<em><b>Invisible Segment Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invisible Segment Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invisible Segment Length As String</em>' attribute.
	 * @see #setInvisibleSegmentLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString()
	 * @model
	 * @generated
	 */
	String getInvisibleSegmentLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCurveStyleFontPattern#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invisible Segment Length As String</em>' attribute.
	 * @see #getInvisibleSegmentLengthAsString()
	 * @generated
	 */
	void setInvisibleSegmentLengthAsString(String value);

} // IfcCurveStyleFontPattern
