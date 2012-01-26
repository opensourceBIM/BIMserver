/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLagAsString <em>Time Lag As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence()
 * @model
 * @generated
 */
public interface IfcRelSequence extends IfcRelConnects {
	/**
	 * Returns the value of the '<em><b>Relating Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Process</em>' reference.
	 * @see #isSetRelatingProcess()
	 * @see #unsetRelatingProcess()
	 * @see #setRelatingProcess(IfcProcess)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence_RelatingProcess()
	 * @see org.bimserver.models.ifc2x3.IfcProcess#getIsPredecessorTo
	 * @model opposite="IsPredecessorTo" unsettable="true"
	 * @generated
	 */
	IfcProcess getRelatingProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Process</em>' reference.
	 * @see #isSetRelatingProcess()
	 * @see #unsetRelatingProcess()
	 * @see #getRelatingProcess()
	 * @generated
	 */
	void setRelatingProcess(IfcProcess value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingProcess()
	 * @see #getRelatingProcess()
	 * @see #setRelatingProcess(IfcProcess)
	 * @generated
	 */
	void unsetRelatingProcess();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Process</em>' reference is set.
	 * @see #unsetRelatingProcess()
	 * @see #getRelatingProcess()
	 * @see #setRelatingProcess(IfcProcess)
	 * @generated
	 */
	boolean isSetRelatingProcess();

	/**
	 * Returns the value of the '<em><b>Related Process</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Process</em>' reference.
	 * @see #isSetRelatedProcess()
	 * @see #unsetRelatedProcess()
	 * @see #setRelatedProcess(IfcProcess)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence_RelatedProcess()
	 * @see org.bimserver.models.ifc2x3.IfcProcess#getIsSuccessorFrom
	 * @model opposite="IsSuccessorFrom" unsettable="true"
	 * @generated
	 */
	IfcProcess getRelatedProcess();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Process</em>' reference.
	 * @see #isSetRelatedProcess()
	 * @see #unsetRelatedProcess()
	 * @see #getRelatedProcess()
	 * @generated
	 */
	void setRelatedProcess(IfcProcess value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedProcess()
	 * @see #getRelatedProcess()
	 * @see #setRelatedProcess(IfcProcess)
	 * @generated
	 */
	void unsetRelatedProcess();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Process</em>' reference is set.
	 * @see #unsetRelatedProcess()
	 * @see #getRelatedProcess()
	 * @see #setRelatedProcess(IfcProcess)
	 * @generated
	 */
	boolean isSetRelatedProcess();

	/**
	 * Returns the value of the '<em><b>Time Lag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Lag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Lag</em>' attribute.
	 * @see #isSetTimeLag()
	 * @see #unsetTimeLag()
	 * @see #setTimeLag(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence_TimeLag()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTimeLag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Lag</em>' attribute.
	 * @see #isSetTimeLag()
	 * @see #unsetTimeLag()
	 * @see #getTimeLag()
	 * @generated
	 */
	void setTimeLag(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeLag()
	 * @see #getTimeLag()
	 * @see #setTimeLag(double)
	 * @generated
	 */
	void unsetTimeLag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLag <em>Time Lag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Lag</em>' attribute is set.
	 * @see #unsetTimeLag()
	 * @see #getTimeLag()
	 * @see #setTimeLag(double)
	 * @generated
	 */
	boolean isSetTimeLag();

	/**
	 * Returns the value of the '<em><b>Time Lag As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Lag As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Lag As String</em>' attribute.
	 * @see #isSetTimeLagAsString()
	 * @see #unsetTimeLagAsString()
	 * @see #setTimeLagAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence_TimeLagAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTimeLagAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLagAsString <em>Time Lag As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Lag As String</em>' attribute.
	 * @see #isSetTimeLagAsString()
	 * @see #unsetTimeLagAsString()
	 * @see #getTimeLagAsString()
	 * @generated
	 */
	void setTimeLagAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLagAsString <em>Time Lag As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeLagAsString()
	 * @see #getTimeLagAsString()
	 * @see #setTimeLagAsString(String)
	 * @generated
	 */
	void unsetTimeLagAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getTimeLagAsString <em>Time Lag As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Lag As String</em>' attribute is set.
	 * @see #unsetTimeLagAsString()
	 * @see #getTimeLagAsString()
	 * @see #setTimeLagAsString(String)
	 * @generated
	 */
	boolean isSetTimeLagAsString();

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcSequenceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSequenceEnum
	 * @see #isSetSequenceType()
	 * @see #unsetSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelSequence_SequenceType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSequenceEnum getSequenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSequenceEnum
	 * @see #isSetSequenceType()
	 * @see #unsetSequenceType()
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(IfcSequenceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSequenceType()
	 * @see #getSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @generated
	 */
	void unsetSequenceType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getSequenceType <em>Sequence Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sequence Type</em>' attribute is set.
	 * @see #unsetSequenceType()
	 * @see #getSequenceType()
	 * @see #setSequenceType(IfcSequenceEnum)
	 * @generated
	 */
	boolean isSetSequenceType();

} // IfcRelSequence
