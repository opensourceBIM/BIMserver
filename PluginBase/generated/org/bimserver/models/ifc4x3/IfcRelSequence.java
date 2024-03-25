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
 * A representation of the model object '<em><b>Ifc Rel Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelSequence#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence()
 * @model
 * @generated
 */
public interface IfcRelSequence extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Process</em>' reference.
	 * @see #setRelatingProcess(IfcProcess)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence_RelatingProcess()
	 * @see org.bimserver.models.ifc4x3.IfcProcess#getIsPredecessorTo
	 * @model opposite="IsPredecessorTo"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProcess getRelatingProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Process</em>' reference.
	 * @see #getRelatingProcess()
	 * @generated
	 */
	void setRelatingProcess(IfcProcess value);

	/**
	 * Returns the value of the '<em><b>Related Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Process</em>' reference.
	 * @see #setRelatedProcess(IfcProcess)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence_RelatedProcess()
	 * @see org.bimserver.models.ifc4x3.IfcProcess#getIsSuccessorFrom
	 * @model opposite="IsSuccessorFrom"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProcess getRelatedProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Process</em>' reference.
	 * @see #getRelatedProcess()
	 * @generated
	 */
	void setRelatedProcess(IfcProcess value);

	/**
	 * Returns the value of the '<em><b>Time Lag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Lag</em>' reference.
	 * @see #isSetTimeLag()
	 * @see #unsetTimeLag()
	 * @see #setTimeLag(IfcLagTime)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence_TimeLag()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLagTime getTimeLag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Lag</em>' reference.
	 * @see #isSetTimeLag()
	 * @see #unsetTimeLag()
	 * @see #getTimeLag()
	 * @generated
	 */
	void setTimeLag(IfcLagTime value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeLag()
	 * @see #getTimeLag()
	 * @see #setTimeLag(IfcLagTime)
	 * @generated
	 */
	void unsetTimeLag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Lag</em>' reference is set.
	 * @see #unsetTimeLag()
	 * @see #getTimeLag()
	 * @see #setTimeLag(IfcLagTime)
	 * @generated
	 */
	boolean isSetTimeLag();

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcSequenceEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcSequenceEnum
	 * @see #isSetSequenceType()
	 * @see #unsetSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence_SequenceType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSequenceEnum getSequenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcSequenceEnum
	 * @see #isSetSequenceType()
	 * @see #unsetSequenceType()
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(IfcSequenceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSequenceType()
	 * @see #getSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @generated
	 */
	void unsetSequenceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sequence Type</em>' attribute is set.
	 * @see #unsetSequenceType()
	 * @see #getSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @generated
	 */
	boolean isSetSequenceType();

	/**
	 * Returns the value of the '<em><b>User Defined Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Sequence Type</em>' attribute.
	 * @see #isSetUserDefinedSequenceType()
	 * @see #unsetUserDefinedSequenceType()
	 * @see #setUserDefinedSequenceType(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelSequence_UserDefinedSequenceType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedSequenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Sequence Type</em>' attribute.
	 * @see #isSetUserDefinedSequenceType()
	 * @see #unsetUserDefinedSequenceType()
	 * @see #getUserDefinedSequenceType()
	 * @generated
	 */
	void setUserDefinedSequenceType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedSequenceType()
	 * @see #getUserDefinedSequenceType()
	 * @see #setUserDefinedSequenceType(String)
	 * @generated
	 */
	void unsetUserDefinedSequenceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRelSequence#getUserDefinedSequenceType <em>User Defined Sequence Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Sequence Type</em>' attribute is set.
	 * @see #unsetUserDefinedSequenceType()
	 * @see #getUserDefinedSequenceType()
	 * @see #setUserDefinedSequenceType(String)
	 * @generated
	 */
	boolean isSetUserDefinedSequenceType();

} // IfcRelSequence
