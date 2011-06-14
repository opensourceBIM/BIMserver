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
import org.bimserver.models.ifc2x3.IfcCalendarDate;
import org.bimserver.models.ifc2x3.IfcCostValue;
import org.bimserver.models.ifc2x3.IfcInventory;
import org.bimserver.models.ifc2x3.IfcInventoryTypeEnum;
import org.bimserver.models.ifc2x3.IfcPerson;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Inventory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getInventoryType <em>Inventory Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getJurisdiction <em>Jurisdiction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getResponsiblePersons <em>Responsible Persons</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getLastUpdateDate <em>Last Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcInventoryImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcInventoryImpl extends IfcGroupImpl implements IfcInventory
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcInventoryImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcInventory();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInventoryTypeEnum getInventoryType()
	{
		return (IfcInventoryTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_InventoryType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInventoryType(IfcInventoryTypeEnum newInventoryType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcInventory_InventoryType(), newInventoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getJurisdiction()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_Jurisdiction(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJurisdiction(IfcActorSelect newJurisdiction)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcInventory_Jurisdiction(), newJurisdiction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getResponsiblePersons()
	{
		return (EList<IfcPerson>)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_ResponsiblePersons(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getLastUpdateDate()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_LastUpdateDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUpdateDate(IfcCalendarDate newLastUpdateDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcInventory_LastUpdateDate(), newLastUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getCurrentValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_CurrentValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(IfcCostValue newCurrentValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcInventory_CurrentValue(), newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrentValue()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcInventory_CurrentValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrentValue()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcInventory_CurrentValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getOriginalValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcInventory_OriginalValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(IfcCostValue newOriginalValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcInventory_OriginalValue(), newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOriginalValue()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcInventory_OriginalValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOriginalValue()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcInventory_OriginalValue());
	}

} //IfcInventoryImpl
