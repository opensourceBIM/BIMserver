/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Curve Style Font Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getVisibleSegmentLength <em>Visible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getInvisibleSegmentLength <em>Invisible Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontPattern()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcCurveStyleFontPattern extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Visible Segment Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Segment Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Segment Length</em>' attribute.
	 * @see #setVisibleSegmentLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontPattern_VisibleSegmentLength()
	 * @model
	 * @generated
	 */
	float getVisibleSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getVisibleSegmentLength <em>Visible Segment Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Segment Length</em>' attribute.
	 * @see #getVisibleSegmentLength()
	 * @generated
	 */
	void setVisibleSegmentLength(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString()
	 * @model
	 * @generated
	 */
	String getVisibleSegmentLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getVisibleSegmentLengthAsString <em>Visible Segment Length As String</em>}' attribute.
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
	 * @see #setInvisibleSegmentLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontPattern_InvisibleSegmentLength()
	 * @model
	 * @generated
	 */
	float getInvisibleSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getInvisibleSegmentLength <em>Invisible Segment Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invisible Segment Length</em>' attribute.
	 * @see #getInvisibleSegmentLength()
	 * @generated
	 */
	void setInvisibleSegmentLength(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString()
	 * @model
	 * @generated
	 */
	String getInvisibleSegmentLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCurveStyleFontPattern#getInvisibleSegmentLengthAsString <em>Invisible Segment Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invisible Segment Length As String</em>' attribute.
	 * @see #getInvisibleSegmentLengthAsString()
	 * @generated
	 */
	void setInvisibleSegmentLengthAsString(String value);

} // IfcCurveStyleFontPattern
