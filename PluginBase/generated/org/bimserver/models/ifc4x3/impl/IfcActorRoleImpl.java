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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActorRole;
import org.bimserver.models.ifc4x3.IfcExternalReferenceRelationship;
import org.bimserver.models.ifc4x3.IfcRoleEnum;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Actor Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorRoleImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorRoleImpl#getUserDefinedRole <em>User Defined Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorRoleImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcActorRoleImpl#getHasExternalReference <em>Has External Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcActorRoleImpl extends IdEObjectImpl implements IfcActorRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcActorRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcActorRole();
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
	@Override
	public IfcRoleEnum getRole() {
		return (IfcRoleEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcActorRole_Role(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRole(IfcRoleEnum newRole) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_Role(), newRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedRole() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedRole(String newUserDefinedRole) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole(), newUserDefinedRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedRole() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedRole() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_UserDefinedRole());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcActorRole_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActorRole_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcExternalReferenceRelationship> getHasExternalReference() {
		return (EList<IfcExternalReferenceRelationship>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcActorRole_HasExternalReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasExternalReference() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcActorRole_HasExternalReference());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasExternalReference() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcActorRole_HasExternalReference());
	}

} //IfcActorRoleImpl
