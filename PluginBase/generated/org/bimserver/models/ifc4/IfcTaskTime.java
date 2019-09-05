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
package org.bimserver.models.ifc4;

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

public interface IfcTaskTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Duration Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcTaskDurationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTaskDurationEnum
	 * @see #isSetDurationType()
	 * @see #unsetDurationType()
	 * @see #setDurationType(IfcTaskDurationEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_DurationType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTaskDurationEnum getDurationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getDurationType <em>Duration Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTaskDurationEnum
	 * @see #isSetDurationType()
	 * @see #unsetDurationType()
	 * @see #getDurationType()
	 * @generated
	 */
	void setDurationType(IfcTaskDurationEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getDurationType <em>Duration Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDurationType()
	 * @see #getDurationType()
	 * @see #setDurationType(IfcTaskDurationEnum)
	 * @generated
	 */
	void unsetDurationType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getDurationType <em>Duration Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration Type</em>' attribute is set.
	 * @see #unsetDurationType()
	 * @see #getDurationType()
	 * @see #setDurationType(IfcTaskDurationEnum)
	 * @generated
	 */
	boolean isSetDurationType();

	/**
	 * Returns the value of the '<em><b>Schedule Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Duration</em>' attribute.
	 * @see #isSetScheduleDuration()
	 * @see #unsetScheduleDuration()
	 * @see #setScheduleDuration(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ScheduleDuration()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleDuration <em>Schedule Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Duration</em>' attribute.
	 * @see #isSetScheduleDuration()
	 * @see #unsetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @generated
	 */
	void setScheduleDuration(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleDuration <em>Schedule Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @see #setScheduleDuration(String)
	 * @generated
	 */
	void unsetScheduleDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleDuration <em>Schedule Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Duration</em>' attribute is set.
	 * @see #unsetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @see #setScheduleDuration(String)
	 * @generated
	 */
	boolean isSetScheduleDuration();

	/**
	 * Returns the value of the '<em><b>Schedule Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Start</em>' attribute.
	 * @see #isSetScheduleStart()
	 * @see #unsetScheduleStart()
	 * @see #setScheduleStart(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ScheduleStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleStart <em>Schedule Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Start</em>' attribute.
	 * @see #isSetScheduleStart()
	 * @see #unsetScheduleStart()
	 * @see #getScheduleStart()
	 * @generated
	 */
	void setScheduleStart(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleStart <em>Schedule Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleStart()
	 * @see #getScheduleStart()
	 * @see #setScheduleStart(String)
	 * @generated
	 */
	void unsetScheduleStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleStart <em>Schedule Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Start</em>' attribute is set.
	 * @see #unsetScheduleStart()
	 * @see #getScheduleStart()
	 * @see #setScheduleStart(String)
	 * @generated
	 */
	boolean isSetScheduleStart();

	/**
	 * Returns the value of the '<em><b>Schedule Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Finish</em>' attribute.
	 * @see #isSetScheduleFinish()
	 * @see #unsetScheduleFinish()
	 * @see #setScheduleFinish(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ScheduleFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleFinish <em>Schedule Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Finish</em>' attribute.
	 * @see #isSetScheduleFinish()
	 * @see #unsetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @generated
	 */
	void setScheduleFinish(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleFinish <em>Schedule Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @see #setScheduleFinish(String)
	 * @generated
	 */
	void unsetScheduleFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getScheduleFinish <em>Schedule Finish</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Finish</em>' attribute is set.
	 * @see #unsetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @see #setScheduleFinish(String)
	 * @generated
	 */
	boolean isSetScheduleFinish();

	/**
	 * Returns the value of the '<em><b>Early Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Early Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Early Start</em>' attribute.
	 * @see #isSetEarlyStart()
	 * @see #unsetEarlyStart()
	 * @see #setEarlyStart(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_EarlyStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEarlyStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyStart <em>Early Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Early Start</em>' attribute.
	 * @see #isSetEarlyStart()
	 * @see #unsetEarlyStart()
	 * @see #getEarlyStart()
	 * @generated
	 */
	void setEarlyStart(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyStart <em>Early Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEarlyStart()
	 * @see #getEarlyStart()
	 * @see #setEarlyStart(String)
	 * @generated
	 */
	void unsetEarlyStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyStart <em>Early Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Early Start</em>' attribute is set.
	 * @see #unsetEarlyStart()
	 * @see #getEarlyStart()
	 * @see #setEarlyStart(String)
	 * @generated
	 */
	boolean isSetEarlyStart();

	/**
	 * Returns the value of the '<em><b>Early Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Early Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Early Finish</em>' attribute.
	 * @see #isSetEarlyFinish()
	 * @see #unsetEarlyFinish()
	 * @see #setEarlyFinish(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_EarlyFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEarlyFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyFinish <em>Early Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Early Finish</em>' attribute.
	 * @see #isSetEarlyFinish()
	 * @see #unsetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @generated
	 */
	void setEarlyFinish(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyFinish <em>Early Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @see #setEarlyFinish(String)
	 * @generated
	 */
	void unsetEarlyFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getEarlyFinish <em>Early Finish</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Early Finish</em>' attribute is set.
	 * @see #unsetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @see #setEarlyFinish(String)
	 * @generated
	 */
	boolean isSetEarlyFinish();

	/**
	 * Returns the value of the '<em><b>Late Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Late Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Late Start</em>' attribute.
	 * @see #isSetLateStart()
	 * @see #unsetLateStart()
	 * @see #setLateStart(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_LateStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLateStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateStart <em>Late Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Late Start</em>' attribute.
	 * @see #isSetLateStart()
	 * @see #unsetLateStart()
	 * @see #getLateStart()
	 * @generated
	 */
	void setLateStart(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateStart <em>Late Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLateStart()
	 * @see #getLateStart()
	 * @see #setLateStart(String)
	 * @generated
	 */
	void unsetLateStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateStart <em>Late Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Late Start</em>' attribute is set.
	 * @see #unsetLateStart()
	 * @see #getLateStart()
	 * @see #setLateStart(String)
	 * @generated
	 */
	boolean isSetLateStart();

	/**
	 * Returns the value of the '<em><b>Late Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Late Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Late Finish</em>' attribute.
	 * @see #isSetLateFinish()
	 * @see #unsetLateFinish()
	 * @see #setLateFinish(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_LateFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLateFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateFinish <em>Late Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Late Finish</em>' attribute.
	 * @see #isSetLateFinish()
	 * @see #unsetLateFinish()
	 * @see #getLateFinish()
	 * @generated
	 */
	void setLateFinish(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateFinish <em>Late Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLateFinish()
	 * @see #getLateFinish()
	 * @see #setLateFinish(String)
	 * @generated
	 */
	void unsetLateFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getLateFinish <em>Late Finish</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Late Finish</em>' attribute is set.
	 * @see #unsetLateFinish()
	 * @see #getLateFinish()
	 * @see #setLateFinish(String)
	 * @generated
	 */
	boolean isSetLateFinish();

	/**
	 * Returns the value of the '<em><b>Free Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Float</em>' attribute.
	 * @see #isSetFreeFloat()
	 * @see #unsetFreeFloat()
	 * @see #setFreeFloat(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_FreeFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFreeFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getFreeFloat <em>Free Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Float</em>' attribute.
	 * @see #isSetFreeFloat()
	 * @see #unsetFreeFloat()
	 * @see #getFreeFloat()
	 * @generated
	 */
	void setFreeFloat(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getFreeFloat <em>Free Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFreeFloat()
	 * @see #getFreeFloat()
	 * @see #setFreeFloat(String)
	 * @generated
	 */
	void unsetFreeFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getFreeFloat <em>Free Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Free Float</em>' attribute is set.
	 * @see #unsetFreeFloat()
	 * @see #getFreeFloat()
	 * @see #setFreeFloat(String)
	 * @generated
	 */
	boolean isSetFreeFloat();

	/**
	 * Returns the value of the '<em><b>Total Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #setTotalFloat(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_TotalFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTotalFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @generated
	 */
	void setTotalFloat(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(String)
	 * @generated
	 */
	void unsetTotalFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getTotalFloat <em>Total Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float</em>' attribute is set.
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(String)
	 * @generated
	 */
	boolean isSetTotalFloat();

	/**
	 * Returns the value of the '<em><b>Is Critical</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Critical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Critical</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsCritical()
	 * @see #unsetIsCritical()
	 * @see #setIsCritical(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_IsCritical()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getIsCritical();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getIsCritical <em>Is Critical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Critical</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsCritical()
	 * @see #unsetIsCritical()
	 * @see #getIsCritical()
	 * @generated
	 */
	void setIsCritical(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getIsCritical <em>Is Critical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsCritical()
	 * @see #getIsCritical()
	 * @see #setIsCritical(Tristate)
	 * @generated
	 */
	void unsetIsCritical();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getIsCritical <em>Is Critical</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Critical</em>' attribute is set.
	 * @see #unsetIsCritical()
	 * @see #getIsCritical()
	 * @see #setIsCritical(Tristate)
	 * @generated
	 */
	boolean isSetIsCritical();

	/**
	 * Returns the value of the '<em><b>Status Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Time</em>' attribute.
	 * @see #isSetStatusTime()
	 * @see #unsetStatusTime()
	 * @see #setStatusTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_StatusTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatusTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getStatusTime <em>Status Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Time</em>' attribute.
	 * @see #isSetStatusTime()
	 * @see #unsetStatusTime()
	 * @see #getStatusTime()
	 * @generated
	 */
	void setStatusTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getStatusTime <em>Status Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatusTime()
	 * @see #getStatusTime()
	 * @see #setStatusTime(String)
	 * @generated
	 */
	void unsetStatusTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getStatusTime <em>Status Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status Time</em>' attribute is set.
	 * @see #unsetStatusTime()
	 * @see #getStatusTime()
	 * @see #setStatusTime(String)
	 * @generated
	 */
	boolean isSetStatusTime();

	/**
	 * Returns the value of the '<em><b>Actual Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Duration</em>' attribute.
	 * @see #isSetActualDuration()
	 * @see #unsetActualDuration()
	 * @see #setActualDuration(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ActualDuration()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualDuration <em>Actual Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Duration</em>' attribute.
	 * @see #isSetActualDuration()
	 * @see #unsetActualDuration()
	 * @see #getActualDuration()
	 * @generated
	 */
	void setActualDuration(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualDuration <em>Actual Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualDuration()
	 * @see #getActualDuration()
	 * @see #setActualDuration(String)
	 * @generated
	 */
	void unsetActualDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualDuration <em>Actual Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Duration</em>' attribute is set.
	 * @see #unsetActualDuration()
	 * @see #getActualDuration()
	 * @see #setActualDuration(String)
	 * @generated
	 */
	boolean isSetActualDuration();

	/**
	 * Returns the value of the '<em><b>Actual Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Start</em>' attribute.
	 * @see #isSetActualStart()
	 * @see #unsetActualStart()
	 * @see #setActualStart(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ActualStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualStart <em>Actual Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Start</em>' attribute.
	 * @see #isSetActualStart()
	 * @see #unsetActualStart()
	 * @see #getActualStart()
	 * @generated
	 */
	void setActualStart(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualStart <em>Actual Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualStart()
	 * @see #getActualStart()
	 * @see #setActualStart(String)
	 * @generated
	 */
	void unsetActualStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualStart <em>Actual Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Start</em>' attribute is set.
	 * @see #unsetActualStart()
	 * @see #getActualStart()
	 * @see #setActualStart(String)
	 * @generated
	 */
	boolean isSetActualStart();

	/**
	 * Returns the value of the '<em><b>Actual Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Finish</em>' attribute.
	 * @see #isSetActualFinish()
	 * @see #unsetActualFinish()
	 * @see #setActualFinish(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_ActualFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualFinish <em>Actual Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Finish</em>' attribute.
	 * @see #isSetActualFinish()
	 * @see #unsetActualFinish()
	 * @see #getActualFinish()
	 * @generated
	 */
	void setActualFinish(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualFinish <em>Actual Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualFinish()
	 * @see #getActualFinish()
	 * @see #setActualFinish(String)
	 * @generated
	 */
	void unsetActualFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getActualFinish <em>Actual Finish</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Finish</em>' attribute is set.
	 * @see #unsetActualFinish()
	 * @see #getActualFinish()
	 * @see #setActualFinish(String)
	 * @generated
	 */
	boolean isSetActualFinish();

	/**
	 * Returns the value of the '<em><b>Remaining Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Time</em>' attribute.
	 * @see #isSetRemainingTime()
	 * @see #unsetRemainingTime()
	 * @see #setRemainingTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_RemainingTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRemainingTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getRemainingTime <em>Remaining Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Time</em>' attribute.
	 * @see #isSetRemainingTime()
	 * @see #unsetRemainingTime()
	 * @see #getRemainingTime()
	 * @generated
	 */
	void setRemainingTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getRemainingTime <em>Remaining Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingTime()
	 * @see #getRemainingTime()
	 * @see #setRemainingTime(String)
	 * @generated
	 */
	void unsetRemainingTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getRemainingTime <em>Remaining Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Time</em>' attribute is set.
	 * @see #unsetRemainingTime()
	 * @see #getRemainingTime()
	 * @see #setRemainingTime(String)
	 * @generated
	 */
	boolean isSetRemainingTime();

	/**
	 * Returns the value of the '<em><b>Completion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion</em>' attribute.
	 * @see #isSetCompletion()
	 * @see #unsetCompletion()
	 * @see #setCompletion(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_Completion()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCompletion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletion <em>Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion</em>' attribute.
	 * @see #isSetCompletion()
	 * @see #unsetCompletion()
	 * @see #getCompletion()
	 * @generated
	 */
	void setCompletion(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletion <em>Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletion()
	 * @see #getCompletion()
	 * @see #setCompletion(double)
	 * @generated
	 */
	void unsetCompletion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletion <em>Completion</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Completion</em>' attribute is set.
	 * @see #unsetCompletion()
	 * @see #getCompletion()
	 * @see #setCompletion(double)
	 * @generated
	 */
	boolean isSetCompletion();

	/**
	 * Returns the value of the '<em><b>Completion As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion As String</em>' attribute.
	 * @see #isSetCompletionAsString()
	 * @see #unsetCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTime_CompletionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCompletionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletionAsString <em>Completion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion As String</em>' attribute.
	 * @see #isSetCompletionAsString()
	 * @see #unsetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @generated
	 */
	void setCompletionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletionAsString <em>Completion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	void unsetCompletionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTaskTime#getCompletionAsString <em>Completion As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Completion As String</em>' attribute is set.
	 * @see #unsetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	boolean isSetCompletionAsString();

} // IfcTaskTime
