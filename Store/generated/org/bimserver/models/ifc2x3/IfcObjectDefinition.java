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
 * A representation of the model object '<em><b>Ifc Object Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectDefinition()
 * @model
 * @generated
 */
public interface IfcObjectDefinition extends IfcRoot
{
	/**
	 * Returns the value of the '<em><b>Has Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssigns}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelAssigns#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Assignments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Assignments</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectDefinition_HasAssignments()
	 * @see org.bimserver.models.ifc2x3.IfcRelAssigns#getRelatedObjects
	 * @model opposite="RelatedObjects"
	 * @generated
	 */
	EList<IfcRelAssigns> getHasAssignments();

	/**
	 * Returns the value of the '<em><b>Is Decomposed By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelDecomposes}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatingObject <em>Relating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Decomposed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Decomposed By</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectDefinition_IsDecomposedBy()
	 * @see org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatingObject
	 * @model opposite="RelatingObject"
	 * @generated
	 */
	EList<IfcRelDecomposes> getIsDecomposedBy();

	/**
	 * Returns the value of the '<em><b>Decomposes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelDecomposes}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decomposes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decomposes</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectDefinition_Decomposes()
	 * @see org.bimserver.models.ifc2x3.IfcRelDecomposes#getRelatedObjects
	 * @model opposite="RelatedObjects" upper="2"
	 * @generated
	 */
	EList<IfcRelDecomposes> getDecomposes();

	/**
	 * Returns the value of the '<em><b>Has Associations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelAssociates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Associations</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectDefinition_HasAssociations()
	 * @model
	 * @generated
	 */
	EList<IfcRelAssociates> getHasAssociations();

} // IfcObjectDefinition
