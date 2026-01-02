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
import org.bimserver.models.ifc4x3.IfcTaskDurationEnum;
import org.bimserver.models.ifc4x3.IfcTaskTime;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Task Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getDurationType <em>Duration Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getScheduleDuration <em>Schedule Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getEarlyStart <em>Early Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getEarlyFinish <em>Early Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getLateStart <em>Late Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getLateFinish <em>Late Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getFreeFloat <em>Free Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getIsCritical <em>Is Critical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getActualDuration <em>Actual Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getRemainingTime <em>Remaining Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcTaskTimeImpl#getCompletionAsString <em>Completion As String</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcTaskTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskDurationEnum getDurationType() {
		return (IfcTaskDurationEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_DurationType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDurationType(IfcTaskDurationEnum newDurationType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_DurationType(), newDurationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDurationType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_DurationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDurationType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_DurationType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleDuration() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleDuration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleDuration(String newScheduleDuration) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleDuration(), newScheduleDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleDuration() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleDuration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleDuration() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleDuration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleStart(String newScheduleStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleStart(), newScheduleStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleFinish(String newScheduleFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleFinish(), newScheduleFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ScheduleFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEarlyStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarlyStart(String newEarlyStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyStart(), newEarlyStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEarlyStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEarlyStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEarlyFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarlyFinish(String newEarlyFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyFinish(), newEarlyFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEarlyFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEarlyFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_EarlyFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLateStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLateStart(String newLateStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateStart(), newLateStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLateStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLateStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLateFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLateFinish(String newLateFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateFinish(), newLateFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLateFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLateFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_LateFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFreeFloat() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_FreeFloat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFreeFloat(String newFreeFloat) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_FreeFloat(), newFreeFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFreeFloat() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_FreeFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFreeFloat() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_FreeFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTotalFloat() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_TotalFloat(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalFloat(String newTotalFloat) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_TotalFloat(), newTotalFloat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTotalFloat() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTotalFloat() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_TotalFloat());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsCritical() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_IsCritical(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCritical(Tristate newIsCritical) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_IsCritical(), newIsCritical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsCritical() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_IsCritical());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsCritical() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_IsCritical());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatusTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_StatusTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatusTime(String newStatusTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_StatusTime(), newStatusTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatusTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_StatusTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatusTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_StatusTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualDuration() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualDuration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualDuration(String newActualDuration) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualDuration(), newActualDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualDuration() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualDuration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualDuration() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualDuration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualStart(String newActualStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualStart(), newActualStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualFinish(String newActualFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualFinish(), newActualFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_ActualFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemainingTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_RemainingTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemainingTime(String newRemainingTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_RemainingTime(), newRemainingTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRemainingTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_RemainingTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRemainingTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_RemainingTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCompletion() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_Completion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletion(double newCompletion) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_Completion(), newCompletion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletion() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_Completion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletion() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_Completion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCompletionAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_CompletionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletionAsString(String newCompletionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_CompletionAsString(), newCompletionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletionAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcTaskTime_CompletionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletionAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcTaskTime_CompletionAsString());
	}

} //IfcTaskTimeImpl
