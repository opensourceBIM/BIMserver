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

import org.bimserver.models.ifc2x3.impl.IfcGroupImpl;

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
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

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
		return Ifc2x3Package.Literals.IFC_INVENTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInventoryTypeEnum getInventoryType()
	{
		return (IfcInventoryTypeEnum)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInventoryType(IfcInventoryTypeEnum newInventoryType)
	{
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE, newInventoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getJurisdiction()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJurisdiction(IfcActorSelect newJurisdiction)
	{
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION, newJurisdiction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getResponsiblePersons()
	{
		return (EList<IfcPerson>)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getLastUpdateDate()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUpdateDate(IfcCalendarDate newLastUpdateDate)
	{
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, newLastUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getCurrentValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(IfcCostValue newCurrentValue)
	{
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE, newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrentValue()
	{
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrentValue()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getOriginalValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(IfcCostValue newOriginalValue)
	{
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOriginalValue()
	{
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOriginalValue()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

} //IfcInventoryImpl
