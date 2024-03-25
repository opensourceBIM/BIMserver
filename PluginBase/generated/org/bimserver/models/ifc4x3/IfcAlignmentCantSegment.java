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
 * A representation of the model object '<em><b>Ifc Alignment Cant Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartDistAlong <em>Start Dist Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartDistAlongAsString <em>Start Dist Along As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getHorizontalLength <em>Horizontal Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getHorizontalLengthAsString <em>Horizontal Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantLeft <em>Start Cant Left</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantLeftAsString <em>Start Cant Left As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeft <em>End Cant Left</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeftAsString <em>End Cant Left As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantRight <em>Start Cant Right</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantRightAsString <em>Start Cant Right As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRight <em>End Cant Right</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRightAsString <em>End Cant Right As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment()
 * @model
 * @generated
 */
public interface IfcAlignmentCantSegment extends IfcAlignmentParameterSegment {
	/**
	 * Returns the value of the '<em><b>Start Dist Along</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Dist Along</em>' attribute.
	 * @see #setStartDistAlong(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartDistAlong()
	 * @model
	 * @generated
	 */
	double getStartDistAlong();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartDistAlong <em>Start Dist Along</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartDistAlongAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartDistAlongAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartDistAlongAsString <em>Start Dist Along As String</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_HorizontalLength()
	 * @model
	 * @generated
	 */
	double getHorizontalLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getHorizontalLength <em>Horizontal Length</em>}' attribute.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_HorizontalLengthAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getHorizontalLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getHorizontalLengthAsString <em>Horizontal Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Length As String</em>' attribute.
	 * @see #getHorizontalLengthAsString()
	 * @generated
	 */
	void setHorizontalLengthAsString(String value);

	/**
	 * Returns the value of the '<em><b>Start Cant Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Cant Left</em>' attribute.
	 * @see #setStartCantLeft(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartCantLeft()
	 * @model
	 * @generated
	 */
	double getStartCantLeft();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantLeft <em>Start Cant Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Cant Left</em>' attribute.
	 * @see #getStartCantLeft()
	 * @generated
	 */
	void setStartCantLeft(double value);

	/**
	 * Returns the value of the '<em><b>Start Cant Left As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Cant Left As String</em>' attribute.
	 * @see #setStartCantLeftAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartCantLeftAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartCantLeftAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantLeftAsString <em>Start Cant Left As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Cant Left As String</em>' attribute.
	 * @see #getStartCantLeftAsString()
	 * @generated
	 */
	void setStartCantLeftAsString(String value);

	/**
	 * Returns the value of the '<em><b>End Cant Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Cant Left</em>' attribute.
	 * @see #isSetEndCantLeft()
	 * @see #unsetEndCantLeft()
	 * @see #setEndCantLeft(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_EndCantLeft()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEndCantLeft();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeft <em>End Cant Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Cant Left</em>' attribute.
	 * @see #isSetEndCantLeft()
	 * @see #unsetEndCantLeft()
	 * @see #getEndCantLeft()
	 * @generated
	 */
	void setEndCantLeft(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeft <em>End Cant Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndCantLeft()
	 * @see #getEndCantLeft()
	 * @see #setEndCantLeft(double)
	 * @generated
	 */
	void unsetEndCantLeft();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeft <em>End Cant Left</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Cant Left</em>' attribute is set.
	 * @see #unsetEndCantLeft()
	 * @see #getEndCantLeft()
	 * @see #setEndCantLeft(double)
	 * @generated
	 */
	boolean isSetEndCantLeft();

	/**
	 * Returns the value of the '<em><b>End Cant Left As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Cant Left As String</em>' attribute.
	 * @see #isSetEndCantLeftAsString()
	 * @see #unsetEndCantLeftAsString()
	 * @see #setEndCantLeftAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_EndCantLeftAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEndCantLeftAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeftAsString <em>End Cant Left As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Cant Left As String</em>' attribute.
	 * @see #isSetEndCantLeftAsString()
	 * @see #unsetEndCantLeftAsString()
	 * @see #getEndCantLeftAsString()
	 * @generated
	 */
	void setEndCantLeftAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeftAsString <em>End Cant Left As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndCantLeftAsString()
	 * @see #getEndCantLeftAsString()
	 * @see #setEndCantLeftAsString(String)
	 * @generated
	 */
	void unsetEndCantLeftAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantLeftAsString <em>End Cant Left As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Cant Left As String</em>' attribute is set.
	 * @see #unsetEndCantLeftAsString()
	 * @see #getEndCantLeftAsString()
	 * @see #setEndCantLeftAsString(String)
	 * @generated
	 */
	boolean isSetEndCantLeftAsString();

	/**
	 * Returns the value of the '<em><b>Start Cant Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Cant Right</em>' attribute.
	 * @see #setStartCantRight(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartCantRight()
	 * @model
	 * @generated
	 */
	double getStartCantRight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantRight <em>Start Cant Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Cant Right</em>' attribute.
	 * @see #getStartCantRight()
	 * @generated
	 */
	void setStartCantRight(double value);

	/**
	 * Returns the value of the '<em><b>Start Cant Right As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Cant Right As String</em>' attribute.
	 * @see #setStartCantRightAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_StartCantRightAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartCantRightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getStartCantRightAsString <em>Start Cant Right As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Cant Right As String</em>' attribute.
	 * @see #getStartCantRightAsString()
	 * @generated
	 */
	void setStartCantRightAsString(String value);

	/**
	 * Returns the value of the '<em><b>End Cant Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Cant Right</em>' attribute.
	 * @see #isSetEndCantRight()
	 * @see #unsetEndCantRight()
	 * @see #setEndCantRight(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_EndCantRight()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEndCantRight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRight <em>End Cant Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Cant Right</em>' attribute.
	 * @see #isSetEndCantRight()
	 * @see #unsetEndCantRight()
	 * @see #getEndCantRight()
	 * @generated
	 */
	void setEndCantRight(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRight <em>End Cant Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndCantRight()
	 * @see #getEndCantRight()
	 * @see #setEndCantRight(double)
	 * @generated
	 */
	void unsetEndCantRight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRight <em>End Cant Right</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Cant Right</em>' attribute is set.
	 * @see #unsetEndCantRight()
	 * @see #getEndCantRight()
	 * @see #setEndCantRight(double)
	 * @generated
	 */
	boolean isSetEndCantRight();

	/**
	 * Returns the value of the '<em><b>End Cant Right As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Cant Right As String</em>' attribute.
	 * @see #isSetEndCantRightAsString()
	 * @see #unsetEndCantRightAsString()
	 * @see #setEndCantRightAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_EndCantRightAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEndCantRightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRightAsString <em>End Cant Right As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Cant Right As String</em>' attribute.
	 * @see #isSetEndCantRightAsString()
	 * @see #unsetEndCantRightAsString()
	 * @see #getEndCantRightAsString()
	 * @generated
	 */
	void setEndCantRightAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRightAsString <em>End Cant Right As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndCantRightAsString()
	 * @see #getEndCantRightAsString()
	 * @see #setEndCantRightAsString(String)
	 * @generated
	 */
	void unsetEndCantRightAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getEndCantRightAsString <em>End Cant Right As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Cant Right As String</em>' attribute is set.
	 * @see #unsetEndCantRightAsString()
	 * @see #getEndCantRightAsString()
	 * @see #setEndCantRightAsString(String)
	 * @generated
	 */
	boolean isSetEndCantRightAsString();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegmentTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentCantSegmentTypeEnum
	 * @see #setPredefinedType(IfcAlignmentCantSegmentTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCantSegment_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAlignmentCantSegmentTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCantSegment#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcAlignmentCantSegmentTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAlignmentCantSegmentTypeEnum value);

} // IfcAlignmentCantSegment
