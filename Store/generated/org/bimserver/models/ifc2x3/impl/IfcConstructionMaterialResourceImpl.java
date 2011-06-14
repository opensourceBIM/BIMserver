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
import org.bimserver.models.ifc2x3.IfcConstructionMaterialResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Material Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getUsageRatio <em>Usage Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl#getUsageRatioAsString <em>Usage Ratio As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstructionMaterialResourceImpl extends IfcConstructionResourceImpl implements IfcConstructionMaterialResource
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionMaterialResourceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getSuppliers()
	{
		return (EList<IfcActorSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuppliers()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppliers()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_Suppliers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUsageRatio()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatio(float newUsageRatio)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio(), newUsageRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatio()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatio()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageRatioAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageRatioAsString(String newUsageRatioAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString(), newUsageRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsageRatioAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsageRatioAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionMaterialResource_UsageRatioAsString());
	}

} //IfcConstructionMaterialResourceImpl
