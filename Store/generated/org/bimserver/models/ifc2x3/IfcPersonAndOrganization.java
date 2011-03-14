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
 * A representation of the model object '<em><b>Ifc Person And Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getThePerson <em>The Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getTheOrganization <em>The Organization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getRoles <em>Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPersonAndOrganization()
 * @model
 * @generated
 */
public interface IfcPersonAndOrganization extends IfcActorSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>The Person</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPerson#getEngagedIn <em>Engaged In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Person</em>' reference.
	 * @see #setThePerson(IfcPerson)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPersonAndOrganization_ThePerson()
	 * @see org.bimserver.models.ifc2x3.IfcPerson#getEngagedIn
	 * @model opposite="EngagedIn"
	 * @generated
	 */
	IfcPerson getThePerson();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getThePerson <em>The Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Person</em>' reference.
	 * @see #getThePerson()
	 * @generated
	 */
	void setThePerson(IfcPerson value);

	/**
	 * Returns the value of the '<em><b>The Organization</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcOrganization#getEngages <em>Engages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Organization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Organization</em>' reference.
	 * @see #setTheOrganization(IfcOrganization)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPersonAndOrganization_TheOrganization()
	 * @see org.bimserver.models.ifc2x3.IfcOrganization#getEngages
	 * @model opposite="Engages"
	 * @generated
	 */
	IfcOrganization getTheOrganization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getTheOrganization <em>The Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Organization</em>' reference.
	 * @see #getTheOrganization()
	 * @generated
	 */
	void setTheOrganization(IfcOrganization value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcActorRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see #isSetRoles()
	 * @see #unsetRoles()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPersonAndOrganization_Roles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcActorRole> getRoles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getRoles <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	void unsetRoles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPersonAndOrganization#getRoles <em>Roles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Roles</em>' reference list is set.
	 * @see #unsetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	boolean isSetRoles();

} // IfcPersonAndOrganization
