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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActorSelect;
import org.bimserver.models.ifc4x3.IfcAsset;
import org.bimserver.models.ifc4x3.IfcCostValue;
import org.bimserver.models.ifc4x3.IfcPerson;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getTotalReplacementCost <em>Total Replacement Cost</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getResponsiblePerson <em>Responsible Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getIncorporationDate <em>Incorporation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAssetImpl#getDepreciatedValue <em>Depreciated Value</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcAsset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentification() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_Identification(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentification(String newIdentification) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_Identification(), newIdentification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIdentification() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_Identification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIdentification() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_Identification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getOriginalValue() {
		return (IfcCostValue) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_OriginalValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOriginalValue(IfcCostValue newOriginalValue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_OriginalValue(), newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOriginalValue() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_OriginalValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOriginalValue() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_OriginalValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getCurrentValue() {
		return (IfcCostValue) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_CurrentValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentValue(IfcCostValue newCurrentValue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_CurrentValue(), newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCurrentValue() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_CurrentValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCurrentValue() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_CurrentValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getTotalReplacementCost() {
		return (IfcCostValue) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalReplacementCost(IfcCostValue newTotalReplacementCost) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost(), newTotalReplacementCost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalReplacementCost() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalReplacementCost() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getOwner() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_Owner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(IfcActorSelect newOwner) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_Owner(), newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOwner() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_Owner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_Owner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getUser() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_User(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUser(IfcActorSelect newUser) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_User(), newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUser() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_User());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUser() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_User());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPerson getResponsiblePerson() {
		return (IfcPerson) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResponsiblePerson(IfcPerson newResponsiblePerson) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson(), newResponsiblePerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResponsiblePerson() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResponsiblePerson() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIncorporationDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_IncorporationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncorporationDate(String newIncorporationDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_IncorporationDate(), newIncorporationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIncorporationDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_IncorporationDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIncorporationDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_IncorporationDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue getDepreciatedValue() {
		return (IfcCostValue) eGet(Ifc4x3Package.eINSTANCE.getIfcAsset_DepreciatedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepreciatedValue(IfcCostValue newDepreciatedValue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcAsset_DepreciatedValue(), newDepreciatedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDepreciatedValue() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcAsset_DepreciatedValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDepreciatedValue() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcAsset_DepreciatedValue());
	}

} //IfcAssetImpl
