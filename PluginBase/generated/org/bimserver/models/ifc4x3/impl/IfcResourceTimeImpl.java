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
import org.bimserver.models.ifc4x3.IfcResourceTime;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Resource Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleWork <em>Schedule Work</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleUsage <em>Schedule Usage</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleUsageAsString <em>Schedule Usage As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getScheduleContour <em>Schedule Contour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getLevelingDelay <em>Leveling Delay</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getIsOverAllocated <em>Is Over Allocated</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getActualWork <em>Actual Work</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getActualUsage <em>Actual Usage</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getActualUsageAsString <em>Actual Usage As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getRemainingWork <em>Remaining Work</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getRemainingUsage <em>Remaining Usage</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getRemainingUsageAsString <em>Remaining Usage As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcResourceTimeImpl#getCompletionAsString <em>Completion As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcResourceTimeImpl extends IfcSchedulingTimeImpl implements IfcResourceTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcResourceTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcResourceTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleWork() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleWork(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleWork(String newScheduleWork) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleWork(), newScheduleWork);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleWork() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleWork() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScheduleUsage() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleUsage(double newScheduleUsage) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsage(), newScheduleUsage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleUsage() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleUsage() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleUsageAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsageAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleUsageAsString(String newScheduleUsageAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsageAsString(), newScheduleUsageAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleUsageAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleUsageAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleStart(String newScheduleStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleStart(), newScheduleStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleFinish(String newScheduleFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleFinish(), newScheduleFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleContour() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleContour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleContour(String newScheduleContour) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleContour(), newScheduleContour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleContour() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleContour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleContour() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ScheduleContour());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLevelingDelay() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_LevelingDelay(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevelingDelay(String newLevelingDelay) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_LevelingDelay(), newLevelingDelay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLevelingDelay() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_LevelingDelay());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLevelingDelay() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_LevelingDelay());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getIsOverAllocated() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_IsOverAllocated(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOverAllocated(Tristate newIsOverAllocated) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_IsOverAllocated(), newIsOverAllocated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsOverAllocated() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_IsOverAllocated());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsOverAllocated() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_IsOverAllocated());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatusTime() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_StatusTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatusTime(String newStatusTime) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_StatusTime(), newStatusTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStatusTime() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_StatusTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStatusTime() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_StatusTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualWork() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualWork(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualWork(String newActualWork) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualWork(), newActualWork);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualWork() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualWork() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getActualUsage() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualUsage(double newActualUsage) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsage(), newActualUsage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualUsage() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualUsage() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualUsageAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsageAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualUsageAsString(String newActualUsageAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsageAsString(), newActualUsageAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualUsageAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualUsageAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualStart() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualStart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualStart(String newActualStart) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualStart(), newActualStart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualStart() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualStart() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualStart());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualFinish() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualFinish(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualFinish(String newActualFinish) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualFinish(), newActualFinish);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualFinish() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualFinish() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_ActualFinish());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemainingWork() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingWork(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemainingWork(String newRemainingWork) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingWork(), newRemainingWork);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRemainingWork() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRemainingWork() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingWork());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRemainingUsage() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemainingUsage(double newRemainingUsage) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsage(), newRemainingUsage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRemainingUsage() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRemainingUsage() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRemainingUsageAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsageAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRemainingUsageAsString(String newRemainingUsageAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsageAsString(), newRemainingUsageAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRemainingUsageAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRemainingUsageAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_RemainingUsageAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCompletion() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_Completion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletion(double newCompletion) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_Completion(), newCompletion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletion() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_Completion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletion() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_Completion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCompletionAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_CompletionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompletionAsString(String newCompletionAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_CompletionAsString(), newCompletionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCompletionAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcResourceTime_CompletionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCompletionAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcResourceTime_CompletionAsString());
	}

} //IfcResourceTimeImpl
