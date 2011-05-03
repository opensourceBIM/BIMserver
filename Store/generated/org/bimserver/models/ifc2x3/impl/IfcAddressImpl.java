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
import org.bimserver.models.ifc2x3.IfcAddress;
import org.bimserver.models.ifc2x3.IfcAddressTypeEnum;
import org.bimserver.models.ifc2x3.IfcOrganization;
import org.bimserver.models.ifc2x3.IfcPerson;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getUserDefinedPurpose <em>User Defined Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getOfPerson <em>Of Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAddressImpl#getOfOrganization <em>Of Organization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAddressImpl extends IdEObjectImpl implements IfcAddress
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
	protected IfcAddressImpl()
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
		return Ifc2x3Package.Literals.IFC_ADDRESS;
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
	public IfcAddressTypeEnum getPurpose()
	{
		return (IfcAddressTypeEnum)eGet(Ifc2x3Package.Literals.IFC_ADDRESS__PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(IfcAddressTypeEnum newPurpose)
	{
		eSet(Ifc2x3Package.Literals.IFC_ADDRESS__PURPOSE, newPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ADDRESS__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.Literals.IFC_ADDRESS__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ADDRESS__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ADDRESS__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedPurpose()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_ADDRESS__USER_DEFINED_PURPOSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedPurpose(String newUserDefinedPurpose)
	{
		eSet(Ifc2x3Package.Literals.IFC_ADDRESS__USER_DEFINED_PURPOSE, newUserDefinedPurpose);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedPurpose()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ADDRESS__USER_DEFINED_PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedPurpose()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ADDRESS__USER_DEFINED_PURPOSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getOfPerson()
	{
		return (EList<IfcPerson>)eGet(Ifc2x3Package.Literals.IFC_ADDRESS__OF_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcOrganization> getOfOrganization()
	{
		return (EList<IfcOrganization>)eGet(Ifc2x3Package.Literals.IFC_ADDRESS__OF_ORGANIZATION, true);
	}

} //IfcAddressImpl
