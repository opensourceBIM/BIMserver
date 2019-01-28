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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcActorRole;
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcApproval;
import org.bimserver.models.ifc2x3tc1.IfcApprovalActorRelationship;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Approval Actor Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcApprovalActorRelationshipImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcApprovalActorRelationshipImpl#getApproval <em>Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcApprovalActorRelationshipImpl#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcApprovalActorRelationshipImpl extends IdEObjectImpl implements IfcApprovalActorRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcApprovalActorRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getActor() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActor(IfcActorSelect newActor) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__ACTOR, newActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApproval getApproval() {
		return (IfcApproval) eGet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__APPROVAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApproval(IfcApproval newApproval) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__APPROVAL, newApproval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorRole getRole() {
		return (IfcActorRole) eGet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__ROLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(IfcActorRole newRole) {
		eSet(Ifc2x3tc1Package.Literals.IFC_APPROVAL_ACTOR_RELATIONSHIP__ROLE, newRole);
	}

} //IfcApprovalActorRelationshipImpl
