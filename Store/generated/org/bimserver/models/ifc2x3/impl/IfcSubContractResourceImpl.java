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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorSelect;
import org.bimserver.models.ifc2x3.IfcSubContractResource;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sub Contract Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSubContractResourceImpl#getSubContractor <em>Sub Contractor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSubContractResourceImpl#getJobDescription <em>Job Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSubContractResourceImpl extends IfcConstructionResourceImpl implements IfcSubContractResource
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSubContractResourceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSubContractResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getSubContractor()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_SubContractor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubContractor(IfcActorSelect newSubContractor)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_SubContractor(), newSubContractor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubContractor()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_SubContractor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubContractor()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_SubContractor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_JobDescription(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobDescription(String newJobDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_JobDescription(), newJobDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJobDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_JobDescription());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJobDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSubContractResource_JobDescription());
	}

} //IfcSubContractResourceImpl
