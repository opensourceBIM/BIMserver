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
 * A representation of the model object '<em><b>Ifc Rel Assigns</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssigns#getRelatedObjects <em>Related Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelAssigns#getRelatedObjectsType <em>Related Objects Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssigns()
 * @model
 * @generated
 */
public interface IfcRelAssigns extends IfcRelationship {
	/**
	 * Returns the value of the '<em><b>Related Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcObjectDefinition}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcObjectDefinition#getHasAssignments <em>Has Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Objects</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssigns_RelatedObjects()
	 * @see org.bimserver.models.ifc2x3.IfcObjectDefinition#getHasAssignments
	 * @model opposite="HasAssignments"
	 * @generated
	 */
	EList<IfcObjectDefinition> getRelatedObjects();

	/**
	 * Returns the value of the '<em><b>Related Objects Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcObjectTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Objects Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Objects Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcObjectTypeEnum
	 * @see #setRelatedObjectsType(IfcObjectTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelAssigns_RelatedObjectsType()
	 * @model
	 * @generated
	 */
	IfcObjectTypeEnum getRelatedObjectsType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelAssigns#getRelatedObjectsType <em>Related Objects Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Objects Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcObjectTypeEnum
	 * @see #getRelatedObjectsType()
	 * @generated
	 */
	void setRelatedObjectsType(IfcObjectTypeEnum value);

} // IfcRelAssigns
