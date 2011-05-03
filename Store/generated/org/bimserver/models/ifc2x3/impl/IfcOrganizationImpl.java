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
import org.bimserver.models.ifc2x3.IfcOrganization;
import org.bimserver.models.ifc2x3.IfcOrganizationRelationship;
import org.bimserver.models.ifc2x3.IfcPersonAndOrganization;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Organization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getIsRelatedBy <em>Is Related By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getRelates <em>Relates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl#getEngages <em>Engages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOrganizationImpl extends IdEObjectImpl implements IfcOrganization
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOrganizationImpl()
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
		return Ifc2x3Package.Literals.IFC_ORGANIZATION;
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
		return (String)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		eSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetId()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ORGANIZATION__ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetId()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ORGANIZATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorRole> getRoles()
	{
		return (EList<IfcActorRole>)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ROLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRoles()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ORGANIZATION__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRoles()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ROLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAddress> getAddresses()
	{
		return (EList<IfcAddress>)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ADDRESSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAddresses()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ORGANIZATION__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAddresses()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcOrganizationRelationship> getIsRelatedBy()
	{
		return (EList<IfcOrganizationRelationship>)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__IS_RELATED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcOrganizationRelationship> getRelates()
	{
		return (EList<IfcOrganizationRelationship>)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__RELATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPersonAndOrganization> getEngages()
	{
		return (EList<IfcPersonAndOrganization>)eGet(Ifc2x3Package.Literals.IFC_ORGANIZATION__ENGAGES, true);
	}

} //IfcOrganizationImpl
