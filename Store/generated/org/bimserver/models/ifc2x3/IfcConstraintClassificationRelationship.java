/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Constraint Classification Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship#getRelatedClassifications <em>Related Classifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraintClassificationRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcConstraintClassificationRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Classified Constraint</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcConstraint#getClassifiedAs <em>Classified As</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classified Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classified Constraint</em>' reference.
	 * @see #setClassifiedConstraint(IfcConstraint)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraintClassificationRelationship_ClassifiedConstraint()
	 * @see org.bimserver.models.ifc2x3.IfcConstraint#getClassifiedAs
	 * @model opposite="ClassifiedAs"
	 * @generated
	 */
	IfcConstraint getClassifiedConstraint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship#getClassifiedConstraint <em>Classified Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classified Constraint</em>' reference.
	 * @see #getClassifiedConstraint()
	 * @generated
	 */
	void setClassifiedConstraint(IfcConstraint value);

	/**
	 * Returns the value of the '<em><b>Related Classifications</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationNotationSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Classifications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Classifications</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcConstraintClassificationRelationship_RelatedClassifications()
	 * @model
	 * @generated
	 */
	EList<IfcClassificationNotationSelect> getRelatedClassifications();

} // IfcConstraintClassificationRelationship
