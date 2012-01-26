/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Approval Actor Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getActor <em>Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getApproval <em>Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalActorRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcApprovalActorRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #isSetActor()
	 * @see #unsetActor()
	 * @see #setActor(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalActorRelationship_Actor()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getActor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #isSetActor()
	 * @see #unsetActor()
	 * @see #getActor()
	 * @generated
	 */
	void setActor(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActor()
	 * @see #getActor()
	 * @see #setActor(IfcActorSelect)
	 * @generated
	 */
	void unsetActor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getActor <em>Actor</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actor</em>' reference is set.
	 * @see #unsetActor()
	 * @see #getActor()
	 * @see #setActor(IfcActorSelect)
	 * @generated
	 */
	boolean isSetActor();

	/**
	 * Returns the value of the '<em><b>Approval</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcApproval#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approval</em>' reference.
	 * @see #isSetApproval()
	 * @see #unsetApproval()
	 * @see #setApproval(IfcApproval)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalActorRelationship_Approval()
	 * @see org.bimserver.models.ifc2x3.IfcApproval#getActors
	 * @model opposite="Actors" unsettable="true"
	 * @generated
	 */
	IfcApproval getApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getApproval <em>Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approval</em>' reference.
	 * @see #isSetApproval()
	 * @see #unsetApproval()
	 * @see #getApproval()
	 * @generated
	 */
	void setApproval(IfcApproval value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getApproval <em>Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApproval()
	 * @see #getApproval()
	 * @see #setApproval(IfcApproval)
	 * @generated
	 */
	void unsetApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getApproval <em>Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approval</em>' reference is set.
	 * @see #unsetApproval()
	 * @see #getApproval()
	 * @see #setApproval(IfcApproval)
	 * @generated
	 */
	boolean isSetApproval();

	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #isSetRole()
	 * @see #unsetRole()
	 * @see #setRole(IfcActorRole)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalActorRelationship_Role()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorRole getRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #isSetRole()
	 * @see #unsetRole()
	 * @see #getRole()
	 * @generated
	 */
	void setRole(IfcActorRole value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRole()
	 * @see #getRole()
	 * @see #setRole(IfcActorRole)
	 * @generated
	 */
	void unsetRole();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalActorRelationship#getRole <em>Role</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Role</em>' reference is set.
	 * @see #unsetRole()
	 * @see #getRole()
	 * @see #setRole(IfcActorRole)
	 * @generated
	 */
	boolean isSetRole();

} // IfcApprovalActorRelationship
