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
import org.bimserver.models.ifc4.IfcAsset;
import org.bimserver.models.ifc4.IfcCostValue;
import org.bimserver.models.ifc4.IfcPerson;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getTotalReplacementCost <em>Total Replacement Cost</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getResponsiblePerson <em>Responsible Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getIncorporationDate <em>Incorporation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAssetImpl#getDepreciatedValue <em>Depreciated Value</em>}</li>
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
		return Ifc4Package.Literals.IFC_ASSET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentification() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASSET__IDENTIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4Package.Literals.IFC_ASSET__IDENTIFICATION, newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentification() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentification() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__IDENTIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getOriginalValue() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_ASSET__ORIGINAL_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalValue(IfcCostValue newOriginalValue) {
		eSet(Ifc4Package.Literals.IFC_ASSET__ORIGINAL_VALUE, newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOriginalValue() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__ORIGINAL_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOriginalValue() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__ORIGINAL_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getCurrentValue() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_ASSET__CURRENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentValue(IfcCostValue newCurrentValue) {
		eSet(Ifc4Package.Literals.IFC_ASSET__CURRENT_VALUE, newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurrentValue() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurrentValue() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__CURRENT_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getTotalReplacementCost() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalReplacementCost(IfcCostValue newTotalReplacementCost) {
		eSet(Ifc4Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST, newTotalReplacementCost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalReplacementCost() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalReplacementCost() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__TOTAL_REPLACEMENT_COST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getOwner() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_ASSET__OWNER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(IfcActorSelect newOwner) {
		eSet(Ifc4Package.Literals.IFC_ASSET__OWNER, newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOwner() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getUser() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_ASSET__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUser(IfcActorSelect newUser) {
		eSet(Ifc4Package.Literals.IFC_ASSET__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUser() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUser() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPerson getResponsiblePerson() {
		return (IfcPerson) eGet(Ifc4Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResponsiblePerson(IfcPerson newResponsiblePerson) {
		eSet(Ifc4Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON, newResponsiblePerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResponsiblePerson() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResponsiblePerson() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__RESPONSIBLE_PERSON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIncorporationDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_ASSET__INCORPORATION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncorporationDate(String newIncorporationDate) {
		eSet(Ifc4Package.Literals.IFC_ASSET__INCORPORATION_DATE, newIncorporationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIncorporationDate() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__INCORPORATION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIncorporationDate() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__INCORPORATION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getDepreciatedValue() {
		return (IfcCostValue) eGet(Ifc4Package.Literals.IFC_ASSET__DEPRECIATED_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepreciatedValue(IfcCostValue newDepreciatedValue) {
		eSet(Ifc4Package.Literals.IFC_ASSET__DEPRECIATED_VALUE, newDepreciatedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDepreciatedValue() {
		eUnset(Ifc4Package.Literals.IFC_ASSET__DEPRECIATED_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDepreciatedValue() {
		return eIsSet(Ifc4Package.Literals.IFC_ASSET__DEPRECIATED_VALUE);
	}

} //IfcAssetImpl
