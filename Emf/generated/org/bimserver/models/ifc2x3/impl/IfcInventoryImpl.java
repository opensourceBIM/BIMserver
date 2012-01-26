/**
 * Copyright (C) 2011  BIMserver.org
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
public class IfcInventoryImpl extends IfcGroupImpl implements IfcInventory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcInventoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.Literals.IFC_INVENTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInventoryTypeEnum getInventoryType() {
		return (IfcInventoryTypeEnum) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInventoryType(IfcInventoryTypeEnum newInventoryType) {
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE, newInventoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInventoryType() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInventoryType() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__INVENTORY_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getJurisdiction() {
		return (IfcActorSelect) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJurisdiction(IfcActorSelect newJurisdiction) {
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION, newJurisdiction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJurisdiction() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJurisdiction() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__JURISDICTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPerson> getResponsiblePersons() {
		return (EList<IfcPerson>) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResponsiblePersons() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResponsiblePersons() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getLastUpdateDate() {
		return (IfcCalendarDate) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUpdateDate(IfcCalendarDate newLastUpdateDate) {
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, newLastUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastUpdateDate() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastUpdateDate() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getCurrentValue() {
		return (IfcCostValue) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(IfcCostValue newCurrentValue) {
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE, newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrentValue() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrentValue() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getOriginalValue() {
		return (IfcCostValue) eGet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(IfcCostValue newOriginalValue) {
		eSet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOriginalValue() {
		eUnset(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOriginalValue() {
		return eIsSet(Ifc2x3Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

} //IfcInventoryImpl
