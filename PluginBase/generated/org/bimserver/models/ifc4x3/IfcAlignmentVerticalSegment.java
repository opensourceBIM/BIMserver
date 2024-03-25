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
 * A representation of the model object '<em><b>Ifc Alignment Vertical Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartDistAlong <em>Start Dist Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartDistAlongAsString <em>Start Dist Along As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getHorizontalLength <em>Horizontal Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getHorizontalLengthAsString <em>Horizontal Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartHeight <em>Start Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartHeightAsString <em>Start Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartGradient <em>Start Gradient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartGradientAsString <em>Start Gradient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getEndGradient <em>End Gradient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getEndGradientAsString <em>End Gradient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvature <em>Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvatureAsString <em>Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment()
 * @model
 * @generated
 */
public interface IfcAlignmentVerticalSegment extends IfcAlignmentParameterSegment {
	/**
	 * Returns the value of the '<em><b>Start Dist Along</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Dist Along</em>' attribute.
	 * @see #setStartDistAlong(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartDistAlong()
	 * @model
	 * @generated
	 */
	double getStartDistAlong();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartDistAlong <em>Start Dist Along</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Dist Along</em>' attribute.
	 * @see #getStartDistAlong()
	 * @generated
	 */
	void setStartDistAlong(double value);

	/**
	 * Returns the value of the '<em><b>Start Dist Along As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Dist Along As String</em>' attribute.
	 * @see #setStartDistAlongAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartDistAlongAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartDistAlongAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartDistAlongAsString <em>Start Dist Along As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Dist Along As String</em>' attribute.
	 * @see #getStartDistAlongAsString()
	 * @generated
	 */
	void setStartDistAlongAsString(String value);

	/**
	 * Returns the value of the '<em><b>Horizontal Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Length</em>' attribute.
	 * @see #setHorizontalLength(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_HorizontalLength()
	 * @model
	 * @generated
	 */
	double getHorizontalLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getHorizontalLength <em>Horizontal Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Length</em>' attribute.
	 * @see #getHorizontalLength()
	 * @generated
	 */
	void setHorizontalLength(double value);

	/**
	 * Returns the value of the '<em><b>Horizontal Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Length As String</em>' attribute.
	 * @see #setHorizontalLengthAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_HorizontalLengthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getHorizontalLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getHorizontalLengthAsString <em>Horizontal Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Length As String</em>' attribute.
	 * @see #getHorizontalLengthAsString()
	 * @generated
	 */
	void setHorizontalLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Start Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Height</em>' attribute.
	 * @see #setStartHeight(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartHeight()
	 * @model
	 * @generated
	 */
	double getStartHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartHeight <em>Start Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Height</em>' attribute.
	 * @see #getStartHeight()
	 * @generated
	 */
	void setStartHeight(double value);

	/**
	 * Returns the value of the '<em><b>Start Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Height As String</em>' attribute.
	 * @see #setStartHeightAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartHeightAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartHeightAsString <em>Start Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Height As String</em>' attribute.
	 * @see #getStartHeightAsString()
	 * @generated
	 */
	void setStartHeightAsString(String value);

	/**
	 * Returns the value of the '<em><b>Start Gradient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Gradient</em>' attribute.
	 * @see #setStartGradient(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartGradient()
	 * @model
	 * @generated
	 */
	double getStartGradient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartGradient <em>Start Gradient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Gradient</em>' attribute.
	 * @see #getStartGradient()
	 * @generated
	 */
	void setStartGradient(double value);

	/**
	 * Returns the value of the '<em><b>Start Gradient As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Gradient As String</em>' attribute.
	 * @see #setStartGradientAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_StartGradientAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartGradientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getStartGradientAsString <em>Start Gradient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Gradient As String</em>' attribute.
	 * @see #getStartGradientAsString()
	 * @generated
	 */
	void setStartGradientAsString(String value);

	/**
	 * Returns the value of the '<em><b>End Gradient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Gradient</em>' attribute.
	 * @see #setEndGradient(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_EndGradient()
	 * @model
	 * @generated
	 */
	double getEndGradient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getEndGradient <em>End Gradient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Gradient</em>' attribute.
	 * @see #getEndGradient()
	 * @generated
	 */
	void setEndGradient(double value);

	/**
	 * Returns the value of the '<em><b>End Gradient As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Gradient As String</em>' attribute.
	 * @see #setEndGradientAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_EndGradientAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEndGradientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getEndGradientAsString <em>End Gradient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Gradient As String</em>' attribute.
	 * @see #getEndGradientAsString()
	 * @generated
	 */
	void setEndGradientAsString(String value);

	/**
	 * Returns the value of the '<em><b>Radius Of Curvature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius Of Curvature</em>' attribute.
	 * @see #isSetRadiusOfCurvature()
	 * @see #unsetRadiusOfCurvature()
	 * @see #setRadiusOfCurvature(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_RadiusOfCurvature()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRadiusOfCurvature();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvature <em>Radius Of Curvature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius Of Curvature</em>' attribute.
	 * @see #isSetRadiusOfCurvature()
	 * @see #unsetRadiusOfCurvature()
	 * @see #getRadiusOfCurvature()
	 * @generated
	 */
	void setRadiusOfCurvature(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvature <em>Radius Of Curvature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadiusOfCurvature()
	 * @see #getRadiusOfCurvature()
	 * @see #setRadiusOfCurvature(double)
	 * @generated
	 */
	void unsetRadiusOfCurvature();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvature <em>Radius Of Curvature</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius Of Curvature</em>' attribute is set.
	 * @see #unsetRadiusOfCurvature()
	 * @see #getRadiusOfCurvature()
	 * @see #setRadiusOfCurvature(double)
	 * @generated
	 */
	boolean isSetRadiusOfCurvature();

	/**
	 * Returns the value of the '<em><b>Radius Of Curvature As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius Of Curvature As String</em>' attribute.
	 * @see #isSetRadiusOfCurvatureAsString()
	 * @see #unsetRadiusOfCurvatureAsString()
	 * @see #setRadiusOfCurvatureAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_RadiusOfCurvatureAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRadiusOfCurvatureAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvatureAsString <em>Radius Of Curvature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius Of Curvature As String</em>' attribute.
	 * @see #isSetRadiusOfCurvatureAsString()
	 * @see #unsetRadiusOfCurvatureAsString()
	 * @see #getRadiusOfCurvatureAsString()
	 * @generated
	 */
	void setRadiusOfCurvatureAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvatureAsString <em>Radius Of Curvature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRadiusOfCurvatureAsString()
	 * @see #getRadiusOfCurvatureAsString()
	 * @see #setRadiusOfCurvatureAsString(String)
	 * @generated
	 */
	void unsetRadiusOfCurvatureAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getRadiusOfCurvatureAsString <em>Radius Of Curvature As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Radius Of Curvature As String</em>' attribute is set.
	 * @see #unsetRadiusOfCurvatureAsString()
	 * @see #getRadiusOfCurvatureAsString()
	 * @see #setRadiusOfCurvatureAsString(String)
	 * @generated
	 */
	boolean isSetRadiusOfCurvatureAsString();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegmentTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegmentTypeEnum
	 * @see #setPredefinedType(IfcAlignmentVerticalSegmentTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentVerticalSegment_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAlignmentVerticalSegmentTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegmentTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAlignmentVerticalSegmentTypeEnum value);

} // IfcAlignmentVerticalSegment
