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
import org.bimserver.models.ifc2x3.IfcConstructionResource;
import org.bimserver.models.ifc2x3.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3.IfcResourceConsumptionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Construction Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionResourceImpl#getResourceIdentifier <em>Resource Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionResourceImpl#getResourceGroup <em>Resource Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionResourceImpl#getResourceConsumption <em>Resource Consumption</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstructionResourceImpl#getBaseQuantity <em>Base Quantity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstructionResourceImpl extends IfcResourceImpl implements IfcConstructionResource
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstructionResourceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConstructionResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceIdentifier()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceIdentifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceIdentifier(String newResourceIdentifier)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceIdentifier(), newResourceIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceIdentifier()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceIdentifier()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceIdentifier());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceGroup()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceGroup(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceGroup(String newResourceGroup)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceGroup(), newResourceGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceGroup()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceGroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceGroup()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceGroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcResourceConsumptionEnum getResourceConsumption()
	{
		return (IfcResourceConsumptionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceConsumption(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceConsumption(IfcResourceConsumptionEnum newResourceConsumption)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_ResourceConsumption(), newResourceConsumption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit getBaseQuantity()
	{
		return (IfcMeasureWithUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_BaseQuantity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseQuantity(IfcMeasureWithUnit newBaseQuantity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_BaseQuantity(), newBaseQuantity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBaseQuantity()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_BaseQuantity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBaseQuantity()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstructionResource_BaseQuantity());
	}

} //IfcConstructionResourceImpl
