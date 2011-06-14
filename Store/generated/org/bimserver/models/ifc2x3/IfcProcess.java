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
public interface IfcProcess extends IfcObject
{
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
