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
 * A representation of the model object '<em><b>Ifc Object Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getNests <em>Nests</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsNestedBy <em>Is Nested By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasContext <em>Has Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition()
 * @model
 * @generated
 */
public interface IfcObjectDefinition extends IfcRoot, IfcDefinitionSelect {
	/**
	 * Returns the value of the '<em><b>Has Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssigns}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelAssigns#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Assignments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Assignments</em>' reference list.
	 * @see #isSetHasAssignments()
	 * @see #unsetHasAssignments()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_HasAssignments()
	 * @see org.bimserver.models.ifc4.IfcRelAssigns#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssigns> getHasAssignments();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasAssignments()
	 * @see #getHasAssignments()
	 * @generated
	 */
	void unsetHasAssignments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Assignments</em>' reference list is set.
	 * @see #unsetHasAssignments()
	 * @see #getHasAssignments()
	 * @generated
	 */
	boolean isSetHasAssignments();

	/**
	 * Returns the value of the '<em><b>Nests</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelNests}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelNests#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nests</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nests</em>' reference list.
	 * @see #isSetNests()
	 * @see #unsetNests()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_Nests()
	 * @see org.bimserver.models.ifc4.IfcRelNests#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelNests> getNests();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getNests <em>Nests</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNests()
	 * @see #getNests()
	 * @generated
	 */
	void unsetNests();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getNests <em>Nests</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nests</em>' reference list is set.
	 * @see #unsetNests()
	 * @see #getNests()
	 * @generated
	 */
	boolean isSetNests();

	/**
	 * Returns the value of the '<em><b>Is Nested By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelNests}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelNests#getRelatingObject <em>Relating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Nested By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Nested By</em>' reference list.
	 * @see #isSetIsNestedBy()
	 * @see #unsetIsNestedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_IsNestedBy()
	 * @see org.bimserver.models.ifc4.IfcRelNests#getRelatingObject
	 * @model opposite="RelatingObject" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelNests> getIsNestedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsNestedBy <em>Is Nested By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsNestedBy()
	 * @see #getIsNestedBy()
	 * @generated
	 */
	void unsetIsNestedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsNestedBy <em>Is Nested By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Nested By</em>' reference list is set.
	 * @see #unsetIsNestedBy()
	 * @see #getIsNestedBy()
	 * @generated
	 */
	boolean isSetIsNestedBy();

	/**
	 * Returns the value of the '<em><b>Has Context</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDeclares}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Context</em>' reference list.
	 * @see #isSetHasContext()
	 * @see #unsetHasContext()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_HasContext()
	 * @model unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDeclares> getHasContext();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasContext <em>Has Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasContext()
	 * @see #getHasContext()
	 * @generated
	 */
	void unsetHasContext();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasContext <em>Has Context</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Context</em>' reference list is set.
	 * @see #unsetHasContext()
	 * @see #getHasContext()
	 * @generated
	 */
	boolean isSetHasContext();

	/**
	 * Returns the value of the '<em><b>Is Decomposed By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAggregates}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelAggregates#getRelatingObject <em>Relating Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Decomposed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Decomposed By</em>' reference list.
	 * @see #isSetIsDecomposedBy()
	 * @see #unsetIsDecomposedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_IsDecomposedBy()
	 * @see org.bimserver.models.ifc4.IfcRelAggregates#getRelatingObject
	 * @model opposite="RelatingObject" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAggregates> getIsDecomposedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDecomposedBy()
	 * @see #getIsDecomposedBy()
	 * @generated
	 */
	void unsetIsDecomposedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}' reference list is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAggregates}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelAggregates#getRelatedObjects <em>Related Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decomposes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decomposes</em>' reference list.
	 * @see #isSetDecomposes()
	 * @see #unsetDecomposes()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_Decomposes()
	 * @see org.bimserver.models.ifc4.IfcRelAggregates#getRelatedObjects
	 * @model opposite="RelatedObjects" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAggregates> getDecomposes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDecomposes()
	 * @see #getDecomposes()
	 * @generated
	 */
	void unsetDecomposes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}' reference list is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociates}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Associations</em>' reference list.
	 * @see #isSetHasAssociations()
	 * @see #unsetHasAssociations()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectDefinition_HasAssociations()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociates> getHasAssociations();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	void unsetHasAssociations();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectDefinition#getHasAssociations <em>Has Associations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Associations</em>' reference list is set.
	 * @see #unsetHasAssociations()
	 * @see #getHasAssociations()
	 * @generated
	 */
	boolean isSetHasAssociations();

} // IfcObjectDefinition
