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
import org.bimserver.models.ifc4.IfcPerson;
import org.bimserver.models.ifc4.IfcPersonAndOrganization;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getFamilyName <em>Family Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getMiddleNames <em>Middle Names</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getPrefixTitles <em>Prefix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getSuffixTitles <em>Suffix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPersonImpl#getEngagedIn <em>Engaged In</em>}</li>
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
		return Ifc4Package.Literals.IFC_PERSON;
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
		return (String) eGet(Ifc4Package.Literals.IFC_PERSON__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4Package.Literals.IFC_PERSON__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentification() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentification() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFamilyName() {
		return (String) eGet(Ifc4Package.Literals.IFC_PERSON__FAMILY_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFamilyName(String newFamilyName) {
		eSet(Ifc4Package.Literals.IFC_PERSON__FAMILY_NAME, newFamilyName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFamilyName() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__FAMILY_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFamilyName() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__FAMILY_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGivenName() {
		return (String) eGet(Ifc4Package.Literals.IFC_PERSON__GIVEN_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGivenName(String newGivenName) {
		eSet(Ifc4Package.Literals.IFC_PERSON__GIVEN_NAME, newGivenName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGivenName() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__GIVEN_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGivenName() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__GIVEN_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getMiddleNames() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_PERSON__MIDDLE_NAMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMiddleNames() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__MIDDLE_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMiddleNames() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__MIDDLE_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getPrefixTitles() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_PERSON__PREFIX_TITLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPrefixTitles() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__PREFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPrefixTitles() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__PREFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSuffixTitles() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_PERSON__SUFFIX_TITLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSuffixTitles() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__SUFFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSuffixTitles() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__SUFFIX_TITLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcActorRole> getRoles() {
		return (EList<IfcActorRole>) eGet(Ifc4Package.Literals.IFC_PERSON__ROLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRoles() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRoles() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcAddress> getAddresses() {
		return (EList<IfcAddress>) eGet(Ifc4Package.Literals.IFC_PERSON__ADDRESSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAddresses() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAddresses() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPersonAndOrganization> getEngagedIn() {
		return (EList<IfcPersonAndOrganization>) eGet(Ifc4Package.Literals.IFC_PERSON__ENGAGED_IN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEngagedIn() {
		eUnset(Ifc4Package.Literals.IFC_PERSON__ENGAGED_IN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEngagedIn() {
		return eIsSet(Ifc4Package.Literals.IFC_PERSON__ENGAGED_IN);
	}

} //IfcPersonImpl
