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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcApplication;
import org.bimserver.models.ifc4x3.IfcChangeActionEnum;
import org.bimserver.models.ifc4x3.IfcOwnerHistory;
import org.bimserver.models.ifc4x3.IfcPersonAndOrganization;
import org.bimserver.models.ifc4x3.IfcStateEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Owner History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getOwningUser <em>Owning User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getOwningApplication <em>Owning Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getChangeAction <em>Change Action</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getLastModifiedDate <em>Last Modified Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getLastModifyingUser <em>Last Modifying User</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getLastModifyingApplication <em>Last Modifying Application</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOwnerHistoryImpl#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOwnerHistoryImpl extends IdEObjectImpl implements IfcOwnerHistory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOwnerHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcOwnerHistory();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPersonAndOrganization getOwningUser() {
		return (IfcPersonAndOrganization) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_OwningUser(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningUser(IfcPersonAndOrganization newOwningUser) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_OwningUser(), newOwningUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApplication getOwningApplication() {
		return (IfcApplication) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_OwningApplication(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningApplication(IfcApplication newOwningApplication) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_OwningApplication(), newOwningApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStateEnum getState() {
		return (IfcStateEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_State(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(IfcStateEnum newState) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_State(), newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetState() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_State());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetState() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_State());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcChangeActionEnum getChangeAction() {
		return (IfcChangeActionEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChangeAction(IfcChangeActionEnum newChangeAction) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction(), newChangeAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetChangeAction() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetChangeAction() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_ChangeAction());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getLastModifiedDate() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastModifiedDate(long newLastModifiedDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate(), newLastModifiedDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLastModifiedDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLastModifiedDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifiedDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPersonAndOrganization getLastModifyingUser() {
		return (IfcPersonAndOrganization) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastModifyingUser(IfcPersonAndOrganization newLastModifyingUser) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser(), newLastModifyingUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLastModifyingUser() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLastModifyingUser() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingUser());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApplication getLastModifyingApplication() {
		return (IfcApplication) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastModifyingApplication(IfcApplication newLastModifyingApplication) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication(), newLastModifyingApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLastModifyingApplication() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLastModifyingApplication() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_LastModifyingApplication());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCreationDate() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_CreationDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationDate(long newCreationDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcOwnerHistory_CreationDate(), newCreationDate);
	}

} //IfcOwnerHistoryImpl
