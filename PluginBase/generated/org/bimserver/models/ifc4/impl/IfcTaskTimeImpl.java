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
import org.bimserver.models.ifc4.IfcTaskDurationEnum;
import org.bimserver.models.ifc4.IfcTaskTime;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Task Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getDurationType <em>Duration Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getScheduleDuration <em>Schedule Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getEarlyStart <em>Early Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getEarlyFinish <em>Early Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getLateStart <em>Late Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getLateFinish <em>Late Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getFreeFloat <em>Free Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getIsCritical <em>Is Critical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getActualDuration <em>Actual Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getRemainingTime <em>Remaining Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTaskTimeImpl#getCompletionAsString <em>Completion As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTaskTimeImpl extends IfcSchedulingTimeImpl implements IfcTaskTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTaskTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TASK_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskDurationEnum getDurationType() {
		return (IfcTaskDurationEnum) eGet(Ifc4Package.Literals.IFC_TASK_TIME__DURATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDurationType(IfcTaskDurationEnum newDurationType) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__DURATION_TYPE, newDurationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDurationType() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__DURATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDurationType() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__DURATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleDuration() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleDuration(String newScheduleDuration) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_DURATION, newScheduleDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleDuration() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleDuration() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleStart() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleStart(String newScheduleStart) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_START, newScheduleStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleStart() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleStart() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleFinish() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleFinish(String newScheduleFinish) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_FINISH, newScheduleFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleFinish() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleFinish() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEarlyStart() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarlyStart(String newEarlyStart) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_START, newEarlyStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEarlyStart() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEarlyStart() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEarlyFinish() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarlyFinish(String newEarlyFinish) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_FINISH, newEarlyFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEarlyFinish() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEarlyFinish() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLateStart() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLateStart(String newLateStart) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_START, newLateStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLateStart() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLateStart() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLateFinish() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLateFinish(String newLateFinish) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_FINISH, newLateFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLateFinish() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLateFinish() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFreeFloat() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__FREE_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFreeFloat(String newFreeFloat) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__FREE_FLOAT, newFreeFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFreeFloat() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFreeFloat() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalFloat() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__TOTAL_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalFloat(String newTotalFloat) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__TOTAL_FLOAT, newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalFloat() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalFloat() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsCritical() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_TASK_TIME__IS_CRITICAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCritical(Tristate newIsCritical) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__IS_CRITICAL, newIsCritical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsCritical() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__IS_CRITICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsCritical() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__IS_CRITICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatusTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__STATUS_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatusTime(String newStatusTime) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__STATUS_TIME, newStatusTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatusTime() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatusTime() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualDuration() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualDuration(String newActualDuration) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_DURATION, newActualDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualDuration() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualDuration() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualStart() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualStart(String newActualStart) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_START, newActualStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualStart() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualStart() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualFinish() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualFinish(String newActualFinish) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_FINISH, newActualFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualFinish() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualFinish() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemainingTime() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__REMAINING_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemainingTime(String newRemainingTime) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__REMAINING_TIME, newRemainingTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRemainingTime() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRemainingTime() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCompletion() {
		return (Double) eGet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletion(double newCompletion) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION, newCompletion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletion() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletion() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCompletionAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletionAsString(String newCompletionAsString) {
		eSet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION_AS_STRING, newCompletionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletionAsString() {
		eUnset(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletionAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_TASK_TIME__COMPLETION_AS_STRING);
	}

} //IfcTaskTimeImpl
