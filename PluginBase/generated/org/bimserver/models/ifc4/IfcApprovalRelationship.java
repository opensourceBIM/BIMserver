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
 * A representation of the model object '<em><b>Ifc Approval Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatedApprovals <em>Related Approvals</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApprovalRelationship()
 * @model
 * @generated
 */
public interface IfcApprovalRelationship extends IfcResourceLevelRelationship {
	/**
	 * Returns the value of the '<em><b>Relating Approval</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcApproval#getRelates <em>Relates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Approval</em>' reference.
	 * @see #setRelatingApproval(IfcApproval)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApprovalRelationship_RelatingApproval()
	 * @see org.bimserver.models.ifc4.IfcApproval#getRelates
	 * @model opposite="Relates"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcApproval getRelatingApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Approval</em>' reference.
	 * @see #getRelatingApproval()
	 * @generated
	 */
	void setRelatingApproval(IfcApproval value);

	/**
	 * Returns the value of the '<em><b>Related Approvals</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcApproval}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcApproval#getIsRelatedWith <em>Is Related With</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Approvals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Approvals</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApprovalRelationship_RelatedApprovals()
	 * @see org.bimserver.models.ifc4.IfcApproval#getIsRelatedWith
	 * @model opposite="IsRelatedWith"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcApproval> getRelatedApprovals();

} // IfcApprovalRelationship
