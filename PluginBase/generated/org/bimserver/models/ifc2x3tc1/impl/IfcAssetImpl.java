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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcActorSelect;
import org.bimserver.models.ifc2x3tc1.IfcAsset;
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcCostValue;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getAssetID <em>Asset ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getTotalReplacementCost <em>Total Replacement Cost</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getResponsiblePerson <em>Responsible Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getIncorporationDate <em>Incorporation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAssetImpl#getDepreciatedValue <em>Depreciated Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAssetImpl extends IfcGroupImpl implements IfcAsset {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAssetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ASSET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssetID() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__ASSET_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssetID(String newAssetID) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__ASSET_ID, newAssetID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getOriginalValue() {
		return (IfcCostValue) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__ORIGINAL_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(IfcCostValue newOriginalValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getCurrentValue() {
		return (IfcCostValue) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__CURRENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(IfcCostValue newCurrentValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__CURRENT_VALUE, newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getTotalReplacementCost() {
		return (IfcCostValue) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalReplacementCost(IfcCostValue newTotalReplacementCost) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST, newTotalReplacementCost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getOwner() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(IfcActorSelect newOwner) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getUser() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(IfcActorSelect newUser) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPerson getResponsiblePerson() {
		return (IfcPerson) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsiblePerson(IfcPerson newResponsiblePerson) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON, newResponsiblePerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getIncorporationDate() {
		return (IfcCalendarDate) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__INCORPORATION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncorporationDate(IfcCalendarDate newIncorporationDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__INCORPORATION_DATE, newIncorporationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getDepreciatedValue() {
		return (IfcCostValue) eGet(Ifc2x3tc1Package.Literals.IFC_ASSET__DEPRECIATED_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepreciatedValue(IfcCostValue newDepreciatedValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ASSET__DEPRECIATED_VALUE, newDepreciatedValue);
	}

} //IfcAssetImpl
