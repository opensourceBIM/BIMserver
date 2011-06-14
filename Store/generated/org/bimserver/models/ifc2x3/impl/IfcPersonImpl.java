/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorRole;
import org.bimserver.models.ifc2x3.IfcAddress;
import org.bimserver.models.ifc2x3.IfcPerson;
import org.bimserver.models.ifc2x3.IfcPersonAndOrganization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getFamilyName <em>Family Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getGivenName <em>Given Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getMiddleNames <em>Middle Names</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getPrefixTitles <em>Prefix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getSuffixTitles <em>Suffix Titles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPersonImpl#getEngagedIn <em>Engaged In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPersonImpl extends IdEObjectImpl implements IfcPerson
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPersonImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcPerson();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_Id(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPerson_Id(), newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_Id());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_Id());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFamilyName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_FamilyName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamilyName(String newFamilyName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPerson_FamilyName(), newFamilyName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFamilyName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_FamilyName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFamilyName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_FamilyName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGivenName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_GivenName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGivenName(String newGivenName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPerson_GivenName(), newGivenName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGivenName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_GivenName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGivenName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_GivenName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getMiddleNames()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_MiddleNames(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMiddleNames()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_MiddleNames());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMiddleNames()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_MiddleNames());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPrefixTitles()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_PrefixTitles(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrefixTitles()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_PrefixTitles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrefixTitles()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_PrefixTitles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSuffixTitles()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_SuffixTitles(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuffixTitles()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_SuffixTitles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuffixTitles()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_SuffixTitles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorRole> getRoles()
	{
		return (EList<IfcActorRole>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_Roles(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRoles()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_Roles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRoles()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_Roles());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAddress> getAddresses()
	{
		return (EList<IfcAddress>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_Addresses(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAddresses()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPerson_Addresses());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAddresses()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPerson_Addresses());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPersonAndOrganization> getEngagedIn()
	{
		return (EList<IfcPersonAndOrganization>)eGet(Ifc2x3Package.eINSTANCE.getIfcPerson_EngagedIn(), true);
	}

} //IfcPersonImpl
