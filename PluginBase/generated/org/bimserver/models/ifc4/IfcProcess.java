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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcProcess#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProcess#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProcess#getOperatesOn <em>Operates On</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess()
 * @model
 * @generated
 */
public interface IfcProcess extends IfcObject, IfcProcessSelect {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #setIdentification(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess_Identification()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #isSetIdentification()
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	void unsetIdentification();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIdentification <em>Identification</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identification</em>' attribute is set.
	 * @see #unsetIdentification()
	 * @see #getIdentification()
	 * @see #setIdentification(String)
	 * @generated
	 */
	boolean isSetIdentification();

	/**
	 * Returns the value of the '<em><b>Long Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Description</em>' attribute.
	 * @see #isSetLongDescription()
	 * @see #unsetLongDescription()
	 * @see #setLongDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess_LongDescription()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Description</em>' attribute.
	 * @see #isSetLongDescription()
	 * @see #unsetLongDescription()
	 * @see #getLongDescription()
	 * @generated
	 */
	void setLongDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getLongDescription <em>Long Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongDescription()
	 * @see #getLongDescription()
	 * @see #setLongDescription(String)
	 * @generated
	 */
	void unsetLongDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getLongDescription <em>Long Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Long Description</em>' attribute is set.
	 * @see #unsetLongDescription()
	 * @see #getLongDescription()
	 * @see #setLongDescription(String)
	 * @generated
	 */
	boolean isSetLongDescription();

	/**
	 * Returns the value of the '<em><b>Is Predecessor To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelSequence}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Predecessor To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Predecessor To</em>' reference list.
	 * @see #isSetIsPredecessorTo()
	 * @see #unsetIsPredecessorTo()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess_IsPredecessorTo()
	 * @see org.bimserver.models.ifc4.IfcRelSequence#getRelatingProcess
	 * @model opposite="RelatingProcess" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSequence> getIsPredecessorTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsPredecessorTo()
	 * @see #getIsPredecessorTo()
	 * @generated
	 */
	void unsetIsPredecessorTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Predecessor To</em>' reference list is set.
	 * @see #unsetIsPredecessorTo()
	 * @see #getIsPredecessorTo()
	 * @generated
	 */
	boolean isSetIsPredecessorTo();

	/**
	 * Returns the value of the '<em><b>Is Successor From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelSequence}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelSequence#getRelatedProcess <em>Related Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Successor From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Successor From</em>' reference list.
	 * @see #isSetIsSuccessorFrom()
	 * @see #unsetIsSuccessorFrom()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess_IsSuccessorFrom()
	 * @see org.bimserver.models.ifc4.IfcRelSequence#getRelatedProcess
	 * @model opposite="RelatedProcess" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSequence> getIsSuccessorFrom();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsSuccessorFrom()
	 * @see #getIsSuccessorFrom()
	 * @generated
	 */
	void unsetIsSuccessorFrom();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Successor From</em>' reference list is set.
	 * @see #unsetIsSuccessorFrom()
	 * @see #getIsSuccessorFrom()
	 * @generated
	 */
	boolean isSetIsSuccessorFrom();

	/**
	 * Returns the value of the '<em><b>Operates On</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssignsToProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operates On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operates On</em>' reference list.
	 * @see #isSetOperatesOn()
	 * @see #unsetOperatesOn()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProcess_OperatesOn()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToProcess> getOperatesOn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getOperatesOn <em>Operates On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOperatesOn()
	 * @see #getOperatesOn()
	 * @generated
	 */
	void unsetOperatesOn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProcess#getOperatesOn <em>Operates On</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Operates On</em>' reference list is set.
	 * @see #unsetOperatesOn()
	 * @see #getOperatesOn()
	 * @generated
	 */
	boolean isSetOperatesOn();

} // IfcProcess
