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
import org.bimserver.models.ifc2x3tc1.IfcCostSchedule;
import org.bimserver.models.ifc2x3tc1.IfcCostScheduleTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Cost Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getSubmittedBy <em>Submitted By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getPreparedBy <em>Prepared By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getSubmittedOn <em>Submitted On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getTargetUsers <em>Target Users</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getUpdateDate <em>Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcCostScheduleImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCostScheduleImpl extends IfcControlImpl implements IfcCostSchedule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCostScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getSubmittedBy() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubmittedBy(IfcActorSelect newSubmittedBy) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_BY, newSubmittedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubmittedBy() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubmittedBy() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getPreparedBy() {
		return (IfcActorSelect) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREPARED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreparedBy(IfcActorSelect newPreparedBy) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREPARED_BY, newPreparedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreparedBy() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREPARED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreparedBy() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREPARED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getSubmittedOn() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubmittedOn(IfcDateTimeSelect newSubmittedOn) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_ON, newSubmittedOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSubmittedOn() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubmittedOn() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__SUBMITTED_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__STATUS, newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatus() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatus() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcActorSelect> getTargetUsers() {
		return (EList<IfcActorSelect>) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__TARGET_USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetUsers() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__TARGET_USERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetUsers() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__TARGET_USERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getUpdateDate() {
		return (IfcDateTimeSelect) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__UPDATE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateDate(IfcDateTimeSelect newUpdateDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__UPDATE_DATE, newUpdateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpdateDate() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpdateDate() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__UPDATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__ID, newID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostScheduleTypeEnum getPredefinedType() {
		return (IfcCostScheduleTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcCostScheduleTypeEnum newPredefinedType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_COST_SCHEDULE__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcCostScheduleImpl
