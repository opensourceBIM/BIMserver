/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProcess#getOperatesOn <em>Operates On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProcess#getIsSuccessorFrom <em>Is Successor From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProcess#getIsPredecessorTo <em>Is Predecessor To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProcess()
 * @model
 * @generated
 */
public interface IfcProcess extends IfcObject {
	/**
	 * Returns the value of the '<em><b>Operates On</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getRelatingProcess <em>Relating Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operates On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operates On</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProcess_OperatesOn()
	 * @see org.bimserver.models.ifc2x3.IfcRelAssignsToProcess#getRelatingProcess
	 * @model opposite="RelatingProcess"
	 * @generated
	 */
	EList<IfcRelAssignsToProcess> getOperatesOn();

	/**
	 * Returns the value of the '<em><b>Is Successor From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelSequence}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess <em>Related Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Successor From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Successor From</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProcess_IsSuccessorFrom()
	 * @see org.bimserver.models.ifc2x3.IfcRelSequence#getRelatedProcess
	 * @model opposite="RelatedProcess"
	 * @generated
	 */
	EList<IfcRelSequence> getIsSuccessorFrom();

	/**
	 * Returns the value of the '<em><b>Is Predecessor To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelSequence}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess <em>Relating Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Predecessor To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Predecessor To</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProcess_IsPredecessorTo()
	 * @see org.bimserver.models.ifc2x3.IfcRelSequence#getRelatingProcess
	 * @model opposite="RelatingProcess"
	 * @generated
	 */
	EList<IfcRelSequence> getIsPredecessorTo();

} // IfcProcess
