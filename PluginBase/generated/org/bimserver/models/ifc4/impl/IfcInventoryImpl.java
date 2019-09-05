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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcActorSelect;
import org.bimserver.models.ifc4.IfcCostValue;
import org.bimserver.models.ifc4.IfcInventory;
import org.bimserver.models.ifc4.IfcInventoryTypeEnum;
import org.bimserver.models.ifc4.IfcPerson;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Inventory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getJurisdiction <em>Jurisdiction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getResponsiblePersons <em>Responsible Persons</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getLastUpdateDate <em>Last Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcInventoryImpl#getOriginalValue <em>Original Value</em>}</li>
 * </ul>
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
		return Ifc4Package.Literals.IFC_INVENTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInventoryTypeEnum getPredefinedType() {
		return (IfcInventoryTypeEnum) eGet(Ifc4Package.Literals.IFC_INVENTORY__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcInventoryTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_INVENTORY__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getJurisdiction() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_INVENTORY__JURISDICTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJurisdiction(IfcActorSelect newJurisdiction) {
		eSet(Ifc4Package.Literals.IFC_INVENTORY__JURISDICTION, newJurisdiction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetJurisdiction() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__JURISDICTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetJurisdiction() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__JURISDICTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPerson> getResponsiblePersons() {
		return (EList<IfcPerson>) eGet(Ifc4Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResponsiblePersons() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResponsiblePersons() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__RESPONSIBLE_PERSONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLastUpdateDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastUpdateDate(String newLastUpdateDate) {
		eSet(Ifc4Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE, newLastUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLastUpdateDate() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLastUpdateDate() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__LAST_UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getCurrentValue() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_INVENTORY__CURRENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentValue(IfcCostValue newCurrentValue) {
		eSet(Ifc4Package.Literals.IFC_INVENTORY__CURRENT_VALUE, newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurrentValue() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurrentValue() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getOriginalValue() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalValue(IfcCostValue newOriginalValue) {
		eSet(Ifc4Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOriginalValue() {
		eUnset(Ifc4Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOriginalValue() {
		return eIsSet(Ifc4Package.Literals.IFC_INVENTORY__ORIGINAL_VALUE);
	}

} //IfcInventoryImpl
