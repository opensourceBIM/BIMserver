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
import org.bimserver.models.ifc2x3.IfcAsset;
import org.bimserver.models.ifc2x3.IfcCalendarDate;
import org.bimserver.models.ifc2x3.IfcCostValue;
import org.bimserver.models.ifc2x3.IfcPerson;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asset</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getAssetID <em>Asset ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getOriginalValue <em>Original Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getTotalReplacementCost <em>Total Replacement Cost</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getResponsiblePerson <em>Responsible Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getIncorporationDate <em>Incorporation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAssetImpl#getDepreciatedValue <em>Depreciated Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAssetImpl extends IfcGroupImpl implements IfcAsset
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAssetImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcAsset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssetID()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_AssetID(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssetID(String newAssetID)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_AssetID(), newAssetID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getOriginalValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_OriginalValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalValue(IfcCostValue newOriginalValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_OriginalValue(), newOriginalValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getCurrentValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_CurrentValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(IfcCostValue newCurrentValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_CurrentValue(), newCurrentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getTotalReplacementCost()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalReplacementCost(IfcCostValue newTotalReplacementCost)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_TotalReplacementCost(), newTotalReplacementCost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getOwner()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_Owner(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(IfcActorSelect newOwner)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_Owner(), newOwner);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getUser()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_User(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(IfcActorSelect newUser)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_User(), newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPerson getResponsiblePerson()
	{
		return (IfcPerson)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsiblePerson(IfcPerson newResponsiblePerson)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_ResponsiblePerson(), newResponsiblePerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getIncorporationDate()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_IncorporationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncorporationDate(IfcCalendarDate newIncorporationDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_IncorporationDate(), newIncorporationDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue getDepreciatedValue()
	{
		return (IfcCostValue)eGet(Ifc2x3Package.eINSTANCE.getIfcAsset_DepreciatedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepreciatedValue(IfcCostValue newDepreciatedValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsset_DepreciatedValue(), newDepreciatedValue);
	}

} //IfcAssetImpl
