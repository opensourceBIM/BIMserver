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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Object Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcObjectDefinition()
 * @model
 * @generated
 */
public interface IfcObjectDefinition extends IfcRoot {
	/**
	 * Returns the value of the '<em><b>Has Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelAssigns}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelAssigns#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Assignments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Assignments</em>' reference list.
	 * @see #isSetHasAssignments()
	 * @see #unsetHasAssignments()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcObjectDefinition_HasAssignments()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelAssigns#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true"
	 * @generated
	 */
	EList<IfcRelAssigns> getHasAssignments();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasAssignments()
	 * @see #getHasAssignments()
	 * @generated
	 */
	void unsetHasAssignments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Assignments</em>' reference list is set.
	 * @see #unsetHasAssignments()
	 * @see #getHasAssignments()
	 * @generated
	 */
	boolean isSetHasAssignments();

	/**
	 * Returns the value of the '<em><b>Is Decomposed By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelDecomposes}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelDecomposes#getRelatingObject <em>Relating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Decomposed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Decomposed By</em>' reference list.
	 * @see #isSetIsDecomposedBy()
	 * @see #unsetIsDecomposedBy()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcObjectDefinition_IsDecomposedBy()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelDecomposes#getRelatingObject
	 * @model opposite="RelatingObject" unsettable="true"
	 * @generated
	 */
	EList<IfcRelDecomposes> getIsDecomposedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDecomposedBy()
	 * @see #getIsDecomposedBy()
	 * @generated
	 */
	void unsetIsDecomposedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Decomposed By</em>' reference list is set.
	 * @see #unsetIsDecomposedBy()
	 * @see #getIsDecomposedBy()
	 * @generated
	 */
	boolean isSetIsDecomposedBy();

	/**
	 * Returns the value of the '<em><b>Decomposes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelDecomposes}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelDecomposes#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decomposes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decomposes</em>' reference list.
	 * @see #isSetDecomposes()
	 * @see #unsetDecomposes()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcObjectDefinition_Decomposes()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelDecomposes#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcRelDecomposes> getDecomposes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDecomposes()
	 * @see #getDecomposes()
	 * @generated
	 */
	void unsetDecomposes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Decomposes</em>' reference list is set.
	 * @see #unsetDecomposes()
	 * @see #getDecomposes()
	 * @generated
	 */
	boolean isSetDecomposes();

	/**
	 * Returns the value of the '<em><b>Has Associations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelAssociates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Associations</em>' reference list.
	 * @see #isSetHasAssociations()
	 * @see #unsetHasAssociations()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcObjectDefinition_HasAssociations()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcRelAssociates> getHasAssociations();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	void unsetHasAssociations();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Associations</em>' reference list is set.
	 * @see #unsetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	boolean isSetHasAssociations();

} // IfcObjectDefinition
