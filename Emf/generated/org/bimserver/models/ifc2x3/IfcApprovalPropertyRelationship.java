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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Approval Property Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApprovedProperties <em>Approved Properties</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApproval <em>Approval</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalPropertyRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcApprovalPropertyRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Approved Properties</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approved Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approved Properties</em>' reference list.
	 * @see #isSetApprovedProperties()
	 * @see #unsetApprovedProperties()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalPropertyRelationship_ApprovedProperties()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcProperty> getApprovedProperties();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApprovedProperties <em>Approved Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovedProperties()
	 * @see #getApprovedProperties()
	 * @generated
	 */
	void unsetApprovedProperties();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApprovedProperties <em>Approved Properties</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approved Properties</em>' reference list is set.
	 * @see #unsetApprovedProperties()
	 * @see #getApprovedProperties()
	 * @generated
	 */
	boolean isSetApprovedProperties();

	/**
	 * Returns the value of the '<em><b>Approval</b></em>' reference.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalPropertyRelationship_Approval()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcApproval getApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApproval <em>Approval</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApproval <em>Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApproval()
	 * @see #getApproval()
	 * @see #setApproval(IfcApproval)
	 * @generated
	 */
	void unsetApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalPropertyRelationship#getApproval <em>Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approval</em>' reference is set.
	 * @see #unsetApproval()
	 * @see #getApproval()
	 * @see #setApproval(IfcApproval)
	 * @generated
	 */
	boolean isSetApproval();

} // IfcApprovalPropertyRelationship
