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
 * A representation of the model object '<em><b>Ifc Alignment Horizontal Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartPoint <em>Start Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartDirection <em>Start Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartDirectionAsString <em>Start Direction As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartRadiusOfCurvature <em>Start Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartRadiusOfCurvatureAsString <em>Start Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getEndRadiusOfCurvature <em>End Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getEndRadiusOfCurvatureAsString <em>End Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getSegmentLength <em>Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getSegmentLengthAsString <em>Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeight <em>Gravity Center Line Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeightAsString <em>Gravity Center Line Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment()
 * @model
 * @generated
 */
public interface IfcAlignmentHorizontalSegment extends IfcAlignmentParameterSegment {
	/**
	 * Returns the value of the '<em><b>Start Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Point</em>' reference.
	 * @see #setStartPoint(IfcCartesianPoint)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_StartPoint()
	 * @model
	 * @generated
	 */
	IfcCartesianPoint getStartPoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartPoint <em>Start Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Point</em>' reference.
	 * @see #getStartPoint()
	 * @generated
	 */
	void setStartPoint(IfcCartesianPoint value);

	/**
	 * Returns the value of the '<em><b>Start Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Direction</em>' attribute.
	 * @see #setStartDirection(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_StartDirection()
	 * @model
	 * @generated
	 */
	double getStartDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartDirection <em>Start Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Direction</em>' attribute.
	 * @see #getStartDirection()
	 * @generated
	 */
	void setStartDirection(double value);

	/**
	 * Returns the value of the '<em><b>Start Direction As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Direction As String</em>' attribute.
	 * @see #setStartDirectionAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_StartDirectionAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartDirectionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartDirectionAsString <em>Start Direction As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Direction As String</em>' attribute.
	 * @see #getStartDirectionAsString()
	 * @generated
	 */
	void setStartDirectionAsString(String value);

	/**
	 * Returns the value of the '<em><b>Start Radius Of Curvature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Radius Of Curvature</em>' attribute.
	 * @see #setStartRadiusOfCurvature(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_StartRadiusOfCurvature()
	 * @model
	 * @generated
	 */
	double getStartRadiusOfCurvature();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartRadiusOfCurvature <em>Start Radius Of Curvature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Radius Of Curvature</em>' attribute.
	 * @see #getStartRadiusOfCurvature()
	 * @generated
	 */
	void setStartRadiusOfCurvature(double value);

	/**
	 * Returns the value of the '<em><b>Start Radius Of Curvature As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Radius Of Curvature As String</em>' attribute.
	 * @see #setStartRadiusOfCurvatureAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_StartRadiusOfCurvatureAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartRadiusOfCurvatureAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getStartRadiusOfCurvatureAsString <em>Start Radius Of Curvature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Radius Of Curvature As String</em>' attribute.
	 * @see #getStartRadiusOfCurvatureAsString()
	 * @generated
	 */
	void setStartRadiusOfCurvatureAsString(String value);

	/**
	 * Returns the value of the '<em><b>End Radius Of Curvature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Radius Of Curvature</em>' attribute.
	 * @see #setEndRadiusOfCurvature(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_EndRadiusOfCurvature()
	 * @model
	 * @generated
	 */
	double getEndRadiusOfCurvature();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getEndRadiusOfCurvature <em>End Radius Of Curvature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Radius Of Curvature</em>' attribute.
	 * @see #getEndRadiusOfCurvature()
	 * @generated
	 */
	void setEndRadiusOfCurvature(double value);

	/**
	 * Returns the value of the '<em><b>End Radius Of Curvature As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Radius Of Curvature As String</em>' attribute.
	 * @see #setEndRadiusOfCurvatureAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_EndRadiusOfCurvatureAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEndRadiusOfCurvatureAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getEndRadiusOfCurvatureAsString <em>End Radius Of Curvature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Radius Of Curvature As String</em>' attribute.
	 * @see #getEndRadiusOfCurvatureAsString()
	 * @generated
	 */
	void setEndRadiusOfCurvatureAsString(String value);

	/**
	 * Returns the value of the '<em><b>Segment Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Length</em>' attribute.
	 * @see #setSegmentLength(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_SegmentLength()
	 * @model
	 * @generated
	 */
	double getSegmentLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getSegmentLength <em>Segment Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Length</em>' attribute.
	 * @see #getSegmentLength()
	 * @generated
	 */
	void setSegmentLength(double value);

	/**
	 * Returns the value of the '<em><b>Segment Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment Length As String</em>' attribute.
	 * @see #setSegmentLengthAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_SegmentLengthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSegmentLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getSegmentLengthAsString <em>Segment Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment Length As String</em>' attribute.
	 * @see #getSegmentLengthAsString()
	 * @generated
	 */
	void setSegmentLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Gravity Center Line Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gravity Center Line Height</em>' attribute.
	 * @see #isSetGravityCenterLineHeight()
	 * @see #unsetGravityCenterLineHeight()
	 * @see #setGravityCenterLineHeight(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_GravityCenterLineHeight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getGravityCenterLineHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeight <em>Gravity Center Line Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gravity Center Line Height</em>' attribute.
	 * @see #isSetGravityCenterLineHeight()
	 * @see #unsetGravityCenterLineHeight()
	 * @see #getGravityCenterLineHeight()
	 * @generated
	 */
	void setGravityCenterLineHeight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeight <em>Gravity Center Line Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGravityCenterLineHeight()
	 * @see #getGravityCenterLineHeight()
	 * @see #setGravityCenterLineHeight(double)
	 * @generated
	 */
	void unsetGravityCenterLineHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeight <em>Gravity Center Line Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Gravity Center Line Height</em>' attribute is set.
	 * @see #unsetGravityCenterLineHeight()
	 * @see #getGravityCenterLineHeight()
	 * @see #setGravityCenterLineHeight(double)
	 * @generated
	 */
	boolean isSetGravityCenterLineHeight();

	/**
	 * Returns the value of the '<em><b>Gravity Center Line Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gravity Center Line Height As String</em>' attribute.
	 * @see #isSetGravityCenterLineHeightAsString()
	 * @see #unsetGravityCenterLineHeightAsString()
	 * @see #setGravityCenterLineHeightAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_GravityCenterLineHeightAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getGravityCenterLineHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeightAsString <em>Gravity Center Line Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gravity Center Line Height As String</em>' attribute.
	 * @see #isSetGravityCenterLineHeightAsString()
	 * @see #unsetGravityCenterLineHeightAsString()
	 * @see #getGravityCenterLineHeightAsString()
	 * @generated
	 */
	void setGravityCenterLineHeightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeightAsString <em>Gravity Center Line Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGravityCenterLineHeightAsString()
	 * @see #getGravityCenterLineHeightAsString()
	 * @see #setGravityCenterLineHeightAsString(String)
	 * @generated
	 */
	void unsetGravityCenterLineHeightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getGravityCenterLineHeightAsString <em>Gravity Center Line Height As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Gravity Center Line Height As String</em>' attribute is set.
	 * @see #unsetGravityCenterLineHeightAsString()
	 * @see #getGravityCenterLineHeightAsString()
	 * @see #setGravityCenterLineHeightAsString(String)
	 * @generated
	 */
	boolean isSetGravityCenterLineHeightAsString();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegmentTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegmentTypeEnum
	 * @see #setPredefinedType(IfcAlignmentHorizontalSegmentTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegment_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAlignmentHorizontalSegmentTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegmentTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAlignmentHorizontalSegmentTypeEnum value);

} // IfcAlignmentHorizontalSegment
