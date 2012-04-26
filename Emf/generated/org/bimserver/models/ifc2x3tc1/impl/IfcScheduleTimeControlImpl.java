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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3tc1.IfcRelAssignsTasks;
import org.bimserver.models.ifc2x3tc1.IfcScheduleTimeControl;
import org.bimserver.models.ifc2x3tc1.LogPackage;
import org.bimserver.models.ifc2x3tc1.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Schedule Time Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getEarlyStart <em>Early Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getLateStart <em>Late Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getEarlyFinish <em>Early Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getLateFinish <em>Late Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getScheduleDuration <em>Schedule Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getScheduleDurationAsString <em>Schedule Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getActualDuration <em>Actual Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getActualDurationAsString <em>Actual Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getRemainingTime <em>Remaining Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getRemainingTimeAsString <em>Remaining Time As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getFreeFloat <em>Free Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getFreeFloatAsString <em>Free Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getIsCritical <em>Is Critical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getStartFloat <em>Start Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getStartFloatAsString <em>Start Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getFinishFloat <em>Finish Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getFinishFloatAsString <em>Finish Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getCompletionAsString <em>Completion As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcScheduleTimeControlImpl#getScheduleTimeControlAssigned <em>Schedule Time Control Assigned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcScheduleTimeControlImpl extends IfcControlImpl implements IfcScheduleTimeControl {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcScheduleTimeControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getActualStart() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualStart(IfcDateTimeSelect newActualStart) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START, newActualStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualStart() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualStart() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getEarlyStart() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarlyStart(IfcDateTimeSelect newEarlyStart) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START, newEarlyStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEarlyStart() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEarlyStart() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getLateStart() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLateStart(IfcDateTimeSelect newLateStart) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START, newLateStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLateStart() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLateStart() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getScheduleStart() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleStart(IfcDateTimeSelect newScheduleStart) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START, newScheduleStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleStart() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleStart() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_START);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getActualFinish() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualFinish(IfcDateTimeSelect newActualFinish) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH, newActualFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualFinish() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualFinish() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getEarlyFinish() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarlyFinish(IfcDateTimeSelect newEarlyFinish) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH, newEarlyFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEarlyFinish() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEarlyFinish() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__EARLY_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getLateFinish() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLateFinish(IfcDateTimeSelect newLateFinish) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH, newLateFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLateFinish() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLateFinish() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__LATE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getScheduleFinish() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleFinish(IfcDateTimeSelect newScheduleFinish) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH, newScheduleFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleFinish() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleFinish() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_FINISH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getScheduleDuration() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleDuration(double newScheduleDuration) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION, newScheduleDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleDuration() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleDuration() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScheduleDurationAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleDurationAsString(String newScheduleDurationAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING, newScheduleDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleDurationAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleDurationAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getActualDuration() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualDuration(double newActualDuration) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION, newActualDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualDuration() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualDuration() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualDurationAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualDurationAsString(String newActualDurationAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING, newActualDurationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActualDurationAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActualDurationAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__ACTUAL_DURATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRemainingTime() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingTime(double newRemainingTime) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME, newRemainingTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRemainingTime() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRemainingTime() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemainingTimeAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingTimeAsString(String newRemainingTimeAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING, newRemainingTimeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRemainingTimeAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRemainingTimeAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__REMAINING_TIME_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFreeFloat() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeFloat(double newFreeFloat) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT, newFreeFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreeFloat() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreeFloat() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFreeFloatAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeFloatAsString(String newFreeFloatAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING, newFreeFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreeFloatAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreeFloatAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FREE_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalFloat() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloat(double newTotalFloat) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT, newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloat() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloat() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTotalFloatAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalFloatAsString(String newTotalFloatAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING, newTotalFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalFloatAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalFloatAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__TOTAL_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsCritical() {
		return (Tristate) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCritical(Tristate newIsCritical) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL, newIsCritical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsCritical() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsCritical() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__IS_CRITICAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getStatusTime() {
		return (IfcDateTimeSelect) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusTime(IfcDateTimeSelect newStatusTime) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME, newStatusTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStatusTime() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStatusTime() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__STATUS_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartFloat() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFloat(double newStartFloat) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT, newStartFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartFloat() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartFloat() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartFloatAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFloatAsString(String newStartFloatAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING, newStartFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartFloatAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartFloatAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__START_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFinishFloat() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishFloat(double newFinishFloat) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT, newFinishFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishFloat() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishFloat() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFinishFloatAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinishFloatAsString(String newFinishFloatAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING, newFinishFloatAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFinishFloatAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFinishFloatAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__FINISH_FLOAT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompletion() {
		return (Double) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletion(double newCompletion) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION, newCompletion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompletion() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompletion() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompletionAsString() {
		return (String) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionAsString(String newCompletionAsString) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING, newCompletionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompletionAsString() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompletionAsString() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__COMPLETION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsTasks getScheduleTimeControlAssigned() {
		return (IfcRelAssignsTasks) eGet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduleTimeControlAssigned(IfcRelAssignsTasks newScheduleTimeControlAssigned) {
		eSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED, newScheduleTimeControlAssigned);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScheduleTimeControlAssigned() {
		eUnset(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScheduleTimeControlAssigned() {
		return eIsSet(LogPackage.Literals.IFC_SCHEDULE_TIME_CONTROL__SCHEDULE_TIME_CONTROL_ASSIGNED);
	}

} //IfcScheduleTimeControlImpl
