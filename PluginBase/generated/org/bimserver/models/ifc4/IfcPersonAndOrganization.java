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
 * A representation of the model object '<em><b>Ifc Person And Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getThePerson <em>The Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getTheOrganization <em>The Organization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getRoles <em>Roles</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPersonAndOrganization()
 * @model
 * @generated
 */
public interface IfcPersonAndOrganization extends IfcActorSelect, IfcObjectReferenceSelect, IfcResourceObjectSelect {
	/**
	 * Returns the value of the '<em><b>The Person</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcPerson#getEngagedIn <em>Engaged In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Person</em>' reference.
	 * @see #setThePerson(IfcPerson)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPersonAndOrganization_ThePerson()
	 * @see org.bimserver.models.ifc4.IfcPerson#getEngagedIn
	 * @model opposite="EngagedIn"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcPerson getThePerson();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getThePerson <em>The Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Person</em>' reference.
	 * @see #getThePerson()
	 * @generated
	 */
	void setThePerson(IfcPerson value);

	/**
	 * Returns the value of the '<em><b>The Organization</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcOrganization#getEngages <em>Engages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Organization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Organization</em>' reference.
	 * @see #setTheOrganization(IfcOrganization)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPersonAndOrganization_TheOrganization()
	 * @see org.bimserver.models.ifc4.IfcOrganization#getEngages
	 * @model opposite="Engages"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcOrganization getTheOrganization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getTheOrganization <em>The Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Organization</em>' reference.
	 * @see #getTheOrganization()
	 * @generated
	 */
	void setTheOrganization(IfcOrganization value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcActorRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see #isSetRoles()
	 * @see #unsetRoles()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPersonAndOrganization_Roles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcActorRole> getRoles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getRoles <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	void unsetRoles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPersonAndOrganization#getRoles <em>Roles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Roles</em>' reference list is set.
	 * @see #unsetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	boolean isSetRoles();

} // IfcPersonAndOrganization
