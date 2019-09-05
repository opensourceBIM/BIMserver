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

public interface IfcResourceTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Schedule Work</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Work</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Work</em>' attribute.
	 * @see #isSetScheduleWork()
	 * @see #unsetScheduleWork()
	 * @see #setScheduleWork(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleWork()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleWork();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleWork <em>Schedule Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Work</em>' attribute.
	 * @see #isSetScheduleWork()
	 * @see #unsetScheduleWork()
	 * @see #getScheduleWork()
	 * @generated
	 */
	void setScheduleWork(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleWork <em>Schedule Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleWork()
	 * @see #getScheduleWork()
	 * @see #setScheduleWork(String)
	 * @generated
	 */
	void unsetScheduleWork();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleWork <em>Schedule Work</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Work</em>' attribute is set.
	 * @see #unsetScheduleWork()
	 * @see #getScheduleWork()
	 * @see #setScheduleWork(String)
	 * @generated
	 */
	boolean isSetScheduleWork();

	/**
	 * Returns the value of the '<em><b>Schedule Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Usage</em>' attribute.
	 * @see #isSetScheduleUsage()
	 * @see #unsetScheduleUsage()
	 * @see #setScheduleUsage(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleUsage()
	 * @model unsettable="true"
	 * @generated
	 */
	double getScheduleUsage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsage <em>Schedule Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Usage</em>' attribute.
	 * @see #isSetScheduleUsage()
	 * @see #unsetScheduleUsage()
	 * @see #getScheduleUsage()
	 * @generated
	 */
	void setScheduleUsage(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsage <em>Schedule Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleUsage()
	 * @see #getScheduleUsage()
	 * @see #setScheduleUsage(double)
	 * @generated
	 */
	void unsetScheduleUsage();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsage <em>Schedule Usage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Usage</em>' attribute is set.
	 * @see #unsetScheduleUsage()
	 * @see #getScheduleUsage()
	 * @see #setScheduleUsage(double)
	 * @generated
	 */
	boolean isSetScheduleUsage();

	/**
	 * Returns the value of the '<em><b>Schedule Usage As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Usage As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Usage As String</em>' attribute.
	 * @see #isSetScheduleUsageAsString()
	 * @see #unsetScheduleUsageAsString()
	 * @see #setScheduleUsageAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleUsageAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getScheduleUsageAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsageAsString <em>Schedule Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Usage As String</em>' attribute.
	 * @see #isSetScheduleUsageAsString()
	 * @see #unsetScheduleUsageAsString()
	 * @see #getScheduleUsageAsString()
	 * @generated
	 */
	void setScheduleUsageAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsageAsString <em>Schedule Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleUsageAsString()
	 * @see #getScheduleUsageAsString()
	 * @see #setScheduleUsageAsString(String)
	 * @generated
	 */
	void unsetScheduleUsageAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleUsageAsString <em>Schedule Usage As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Usage As String</em>' attribute is set.
	 * @see #unsetScheduleUsageAsString()
	 * @see #getScheduleUsageAsString()
	 * @see #setScheduleUsageAsString(String)
	 * @generated
	 */
	boolean isSetScheduleUsageAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleStart <em>Schedule Start</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleStart <em>Schedule Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleStart()
	 * @see #getScheduleStart()
	 * @see #setScheduleStart(String)
	 * @generated
	 */
	void unsetScheduleStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleStart <em>Schedule Start</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleFinish <em>Schedule Finish</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleFinish <em>Schedule Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @see #setScheduleFinish(String)
	 * @generated
	 */
	void unsetScheduleFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleFinish <em>Schedule Finish</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Schedule Contour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Contour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Contour</em>' attribute.
	 * @see #isSetScheduleContour()
	 * @see #unsetScheduleContour()
	 * @see #setScheduleContour(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ScheduleContour()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleContour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleContour <em>Schedule Contour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Contour</em>' attribute.
	 * @see #isSetScheduleContour()
	 * @see #unsetScheduleContour()
	 * @see #getScheduleContour()
	 * @generated
	 */
	void setScheduleContour(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleContour <em>Schedule Contour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleContour()
	 * @see #getScheduleContour()
	 * @see #setScheduleContour(String)
	 * @generated
	 */
	void unsetScheduleContour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getScheduleContour <em>Schedule Contour</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Contour</em>' attribute is set.
	 * @see #unsetScheduleContour()
	 * @see #getScheduleContour()
	 * @see #setScheduleContour(String)
	 * @generated
	 */
	boolean isSetScheduleContour();

	/**
	 * Returns the value of the '<em><b>Leveling Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leveling Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leveling Delay</em>' attribute.
	 * @see #isSetLevelingDelay()
	 * @see #unsetLevelingDelay()
	 * @see #setLevelingDelay(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_LevelingDelay()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLevelingDelay();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getLevelingDelay <em>Leveling Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leveling Delay</em>' attribute.
	 * @see #isSetLevelingDelay()
	 * @see #unsetLevelingDelay()
	 * @see #getLevelingDelay()
	 * @generated
	 */
	void setLevelingDelay(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getLevelingDelay <em>Leveling Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevelingDelay()
	 * @see #getLevelingDelay()
	 * @see #setLevelingDelay(String)
	 * @generated
	 */
	void unsetLevelingDelay();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getLevelingDelay <em>Leveling Delay</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Leveling Delay</em>' attribute is set.
	 * @see #unsetLevelingDelay()
	 * @see #getLevelingDelay()
	 * @see #setLevelingDelay(String)
	 * @generated
	 */
	boolean isSetLevelingDelay();

	/**
	 * Returns the value of the '<em><b>Is Over Allocated</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Over Allocated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Over Allocated</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsOverAllocated()
	 * @see #unsetIsOverAllocated()
	 * @see #setIsOverAllocated(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_IsOverAllocated()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getIsOverAllocated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getIsOverAllocated <em>Is Over Allocated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Over Allocated</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #isSetIsOverAllocated()
	 * @see #unsetIsOverAllocated()
	 * @see #getIsOverAllocated()
	 * @generated
	 */
	void setIsOverAllocated(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getIsOverAllocated <em>Is Over Allocated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsOverAllocated()
	 * @see #getIsOverAllocated()
	 * @see #setIsOverAllocated(Tristate)
	 * @generated
	 */
	void unsetIsOverAllocated();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getIsOverAllocated <em>Is Over Allocated</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Over Allocated</em>' attribute is set.
	 * @see #unsetIsOverAllocated()
	 * @see #getIsOverAllocated()
	 * @see #setIsOverAllocated(Tristate)
	 * @generated
	 */
	boolean isSetIsOverAllocated();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_StatusTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatusTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getStatusTime <em>Status Time</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getStatusTime <em>Status Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatusTime()
	 * @see #getStatusTime()
	 * @see #setStatusTime(String)
	 * @generated
	 */
	void unsetStatusTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getStatusTime <em>Status Time</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Actual Work</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Work</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Work</em>' attribute.
	 * @see #isSetActualWork()
	 * @see #unsetActualWork()
	 * @see #setActualWork(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ActualWork()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualWork();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualWork <em>Actual Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Work</em>' attribute.
	 * @see #isSetActualWork()
	 * @see #unsetActualWork()
	 * @see #getActualWork()
	 * @generated
	 */
	void setActualWork(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualWork <em>Actual Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualWork()
	 * @see #getActualWork()
	 * @see #setActualWork(String)
	 * @generated
	 */
	void unsetActualWork();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualWork <em>Actual Work</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Work</em>' attribute is set.
	 * @see #unsetActualWork()
	 * @see #getActualWork()
	 * @see #setActualWork(String)
	 * @generated
	 */
	boolean isSetActualWork();

	/**
	 * Returns the value of the '<em><b>Actual Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Usage</em>' attribute.
	 * @see #isSetActualUsage()
	 * @see #unsetActualUsage()
	 * @see #setActualUsage(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ActualUsage()
	 * @model unsettable="true"
	 * @generated
	 */
	double getActualUsage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsage <em>Actual Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Usage</em>' attribute.
	 * @see #isSetActualUsage()
	 * @see #unsetActualUsage()
	 * @see #getActualUsage()
	 * @generated
	 */
	void setActualUsage(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsage <em>Actual Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualUsage()
	 * @see #getActualUsage()
	 * @see #setActualUsage(double)
	 * @generated
	 */
	void unsetActualUsage();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsage <em>Actual Usage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Usage</em>' attribute is set.
	 * @see #unsetActualUsage()
	 * @see #getActualUsage()
	 * @see #setActualUsage(double)
	 * @generated
	 */
	boolean isSetActualUsage();

	/**
	 * Returns the value of the '<em><b>Actual Usage As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Usage As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Usage As String</em>' attribute.
	 * @see #isSetActualUsageAsString()
	 * @see #unsetActualUsageAsString()
	 * @see #setActualUsageAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ActualUsageAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getActualUsageAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsageAsString <em>Actual Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Usage As String</em>' attribute.
	 * @see #isSetActualUsageAsString()
	 * @see #unsetActualUsageAsString()
	 * @see #getActualUsageAsString()
	 * @generated
	 */
	void setActualUsageAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsageAsString <em>Actual Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualUsageAsString()
	 * @see #getActualUsageAsString()
	 * @see #setActualUsageAsString(String)
	 * @generated
	 */
	void unsetActualUsageAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualUsageAsString <em>Actual Usage As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Usage As String</em>' attribute is set.
	 * @see #unsetActualUsageAsString()
	 * @see #getActualUsageAsString()
	 * @see #setActualUsageAsString(String)
	 * @generated
	 */
	boolean isSetActualUsageAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ActualStart()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualStart <em>Actual Start</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualStart <em>Actual Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualStart()
	 * @see #getActualStart()
	 * @see #setActualStart(String)
	 * @generated
	 */
	void unsetActualStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualStart <em>Actual Start</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_ActualFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualFinish <em>Actual Finish</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualFinish <em>Actual Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualFinish()
	 * @see #getActualFinish()
	 * @see #setActualFinish(String)
	 * @generated
	 */
	void unsetActualFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getActualFinish <em>Actual Finish</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Remaining Work</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Work</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Work</em>' attribute.
	 * @see #isSetRemainingWork()
	 * @see #unsetRemainingWork()
	 * @see #setRemainingWork(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_RemainingWork()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRemainingWork();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingWork <em>Remaining Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Work</em>' attribute.
	 * @see #isSetRemainingWork()
	 * @see #unsetRemainingWork()
	 * @see #getRemainingWork()
	 * @generated
	 */
	void setRemainingWork(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingWork <em>Remaining Work</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingWork()
	 * @see #getRemainingWork()
	 * @see #setRemainingWork(String)
	 * @generated
	 */
	void unsetRemainingWork();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingWork <em>Remaining Work</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Work</em>' attribute is set.
	 * @see #unsetRemainingWork()
	 * @see #getRemainingWork()
	 * @see #setRemainingWork(String)
	 * @generated
	 */
	boolean isSetRemainingWork();

	/**
	 * Returns the value of the '<em><b>Remaining Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Usage</em>' attribute.
	 * @see #isSetRemainingUsage()
	 * @see #unsetRemainingUsage()
	 * @see #setRemainingUsage(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_RemainingUsage()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRemainingUsage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsage <em>Remaining Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Usage</em>' attribute.
	 * @see #isSetRemainingUsage()
	 * @see #unsetRemainingUsage()
	 * @see #getRemainingUsage()
	 * @generated
	 */
	void setRemainingUsage(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsage <em>Remaining Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingUsage()
	 * @see #getRemainingUsage()
	 * @see #setRemainingUsage(double)
	 * @generated
	 */
	void unsetRemainingUsage();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsage <em>Remaining Usage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Usage</em>' attribute is set.
	 * @see #unsetRemainingUsage()
	 * @see #getRemainingUsage()
	 * @see #setRemainingUsage(double)
	 * @generated
	 */
	boolean isSetRemainingUsage();

	/**
	 * Returns the value of the '<em><b>Remaining Usage As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Usage As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Usage As String</em>' attribute.
	 * @see #isSetRemainingUsageAsString()
	 * @see #unsetRemainingUsageAsString()
	 * @see #setRemainingUsageAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_RemainingUsageAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRemainingUsageAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsageAsString <em>Remaining Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Usage As String</em>' attribute.
	 * @see #isSetRemainingUsageAsString()
	 * @see #unsetRemainingUsageAsString()
	 * @see #getRemainingUsageAsString()
	 * @generated
	 */
	void setRemainingUsageAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsageAsString <em>Remaining Usage As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingUsageAsString()
	 * @see #getRemainingUsageAsString()
	 * @see #setRemainingUsageAsString(String)
	 * @generated
	 */
	void unsetRemainingUsageAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getRemainingUsageAsString <em>Remaining Usage As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Usage As String</em>' attribute is set.
	 * @see #unsetRemainingUsageAsString()
	 * @see #getRemainingUsageAsString()
	 * @see #setRemainingUsageAsString(String)
	 * @generated
	 */
	boolean isSetRemainingUsageAsString();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_Completion()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCompletion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletion <em>Completion</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletion <em>Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletion()
	 * @see #getCompletion()
	 * @see #setCompletion(double)
	 * @generated
	 */
	void unsetCompletion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletion <em>Completion</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcResourceTime_CompletionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCompletionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletionAsString <em>Completion As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletionAsString <em>Completion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	void unsetCompletionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcResourceTime#getCompletionAsString <em>Completion As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Completion As String</em>' attribute is set.
	 * @see #unsetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	boolean isSetCompletionAsString();

} // IfcResourceTime
