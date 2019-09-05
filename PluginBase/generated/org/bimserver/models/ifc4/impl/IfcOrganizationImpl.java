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
package org.bimserver.models.ifc4.impl;

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
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcActorRole;
import org.bimserver.models.ifc4.IfcAddress;
import org.bimserver.models.ifc4.IfcOrganization;
import org.bimserver.models.ifc4.IfcOrganizationRelationship;
import org.bimserver.models.ifc4.IfcPersonAndOrganization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Organization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getIsRelatedBy <em>Is Related By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getRelates <em>Relates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOrganizationImpl#getEngages <em>Engages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOrganizationImpl extends IdEObjectImpl implements IfcOrganization {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOrganizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_ORGANIZATION;
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
	public String getIdentification() {
		return (String) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4Package.Literals.IFC_ORGANIZATION__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentification() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentification() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_ORGANIZATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_ORGANIZATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcActorRole> getRoles() {
		return (EList<IfcActorRole>) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__ROLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRoles() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRoles() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcAddress> getAddresses() {
		return (EList<IfcAddress>) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__ADDRESSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAddresses() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAddresses() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcOrganizationRelationship> getIsRelatedBy() {
		return (EList<IfcOrganizationRelationship>) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__IS_RELATED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsRelatedBy() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__IS_RELATED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsRelatedBy() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__IS_RELATED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcOrganizationRelationship> getRelates() {
		return (EList<IfcOrganizationRelationship>) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__RELATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRelates() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__RELATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRelates() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__RELATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPersonAndOrganization> getEngages() {
		return (EList<IfcPersonAndOrganization>) eGet(Ifc4Package.Literals.IFC_ORGANIZATION__ENGAGES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEngages() {
		eUnset(Ifc4Package.Literals.IFC_ORGANIZATION__ENGAGES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEngages() {
		return eIsSet(Ifc4Package.Literals.IFC_ORGANIZATION__ENGAGES);
	}

} //IfcOrganizationImpl
