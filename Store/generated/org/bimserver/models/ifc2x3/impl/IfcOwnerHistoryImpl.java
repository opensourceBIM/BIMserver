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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcApplication;
import org.bimserver.models.ifc2x3.IfcChangeActionEnum;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3.IfcStateEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Owner History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getOwningUser <em>Owning User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getOwningApplication <em>Owning Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getChangeAction <em>Change Action</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getLastModifiedDate <em>Last Modified Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getLastModifyingUser <em>Last Modifying User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getLastModifyingApplication <em>Last Modifying Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOwnerHistoryImpl extends IdEObjectImpl implements IfcOwnerHistory
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOwnerHistoryImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcOwnerHistory();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPersonAndOrganization getOwningUser()
	{
		return (IfcPersonAndOrganization)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_OwningUser(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningUser(IfcPersonAndOrganization newOwningUser)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_OwningUser(), newOwningUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApplication getOwningApplication()
	{
		return (IfcApplication)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_OwningApplication(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningApplication(IfcApplication newOwningApplication)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_OwningApplication(), newOwningApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStateEnum getState()
	{
		return (IfcStateEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_State(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(IfcStateEnum newState)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_State(), newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChangeActionEnum getChangeAction()
	{
		return (IfcChangeActionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeAction(IfcChangeActionEnum newChangeAction)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction(), newChangeAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLastModifiedDate()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifiedDate(int newLastModifiedDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate(), newLastModifiedDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifiedDate()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifiedDate()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPersonAndOrganization getLastModifyingUser()
	{
		return (IfcPersonAndOrganization)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifyingUser(IfcPersonAndOrganization newLastModifyingUser)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser(), newLastModifyingUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifyingUser()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifyingUser()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApplication getLastModifyingApplication()
	{
		return (IfcApplication)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifyingApplication(IfcApplication newLastModifyingApplication)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication(), newLastModifyingApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifyingApplication()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifyingApplication()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCreationDate()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_CreationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(int newCreationDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcOwnerHistory_CreationDate(), newCreationDate);
	}

} //IfcOwnerHistoryImpl
