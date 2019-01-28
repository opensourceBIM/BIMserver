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
import org.bimserver.models.ifc2x3tc1.IfcAddress;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getFamilyName <em>Family Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getMiddleNames <em>Middle Names</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getPrefixTitles <em>Prefix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getSuffixTitles <em>Suffix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPersonImpl#getEngagedIn <em>Engaged In</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPersonImpl extends IdEObjectImpl implements IfcPerson {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PERSON;
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
	public String getId() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PERSON__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamilyName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__FAMILY_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyName(String newFamilyName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PERSON__FAMILY_NAME, newFamilyName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFamilyName() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__FAMILY_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFamilyName() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__FAMILY_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGivenName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__GIVEN_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGivenName(String newGivenName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PERSON__GIVEN_NAME, newGivenName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGivenName() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__GIVEN_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGivenName() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__GIVEN_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMiddleNames() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__MIDDLE_NAMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMiddleNames() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__MIDDLE_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMiddleNames() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__MIDDLE_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPrefixTitles() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__PREFIX_TITLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrefixTitles() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__PREFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrefixTitles() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__PREFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSuffixTitles() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__SUFFIX_TITLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuffixTitles() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__SUFFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuffixTitles() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__SUFFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorRole> getRoles() {
		return (EList<IfcActorRole>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__ROLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRoles() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRoles() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAddress> getAddresses() {
		return (EList<IfcAddress>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__ADDRESSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAddresses() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAddresses() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPersonAndOrganization> getEngagedIn() {
		return (EList<IfcPersonAndOrganization>) eGet(Ifc2x3tc1Package.Literals.IFC_PERSON__ENGAGED_IN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEngagedIn() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_PERSON__ENGAGED_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEngagedIn() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_PERSON__ENGAGED_IN);
	}

} //IfcPersonImpl
