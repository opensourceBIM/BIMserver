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
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Schedule Time Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualStart <em>Actual Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyStart <em>Early Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateStart <em>Late Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleStart <em>Schedule Start</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualFinish <em>Actual Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyFinish <em>Early Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateFinish <em>Late Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleFinish <em>Schedule Finish</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDuration <em>Schedule Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDurationAsString <em>Schedule Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDuration <em>Actual Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDurationAsString <em>Actual Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTime <em>Remaining Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTimeAsString <em>Remaining Time As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloat <em>Free Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloatAsString <em>Free Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getIsCritical <em>Is Critical</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStatusTime <em>Status Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloat <em>Start Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloatAsString <em>Start Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloat <em>Finish Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloatAsString <em>Finish Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletion <em>Completion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletionAsString <em>Completion As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleTimeControlAssigned <em>Schedule Time Control Assigned</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl()
 * @model
 * @generated
 */
public interface IfcScheduleTimeControl extends IfcControl
{
	/**
	 * Returns the value of the '<em><b>Actual Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Start</em>' reference.
	 * @see #isSetActualStart()
	 * @see #unsetActualStart()
	 * @see #setActualStart(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ActualStart()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getActualStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualStart <em>Actual Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Start</em>' reference.
	 * @see #isSetActualStart()
	 * @see #unsetActualStart()
	 * @see #getActualStart()
	 * @generated
	 */
	void setActualStart(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualStart <em>Actual Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualStart()
	 * @see #getActualStart()
	 * @see #setActualStart(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetActualStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualStart <em>Actual Start</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Start</em>' reference is set.
	 * @see #unsetActualStart()
	 * @see #getActualStart()
	 * @see #setActualStart(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetActualStart();

	/**
	 * Returns the value of the '<em><b>Early Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Early Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Early Start</em>' reference.
	 * @see #isSetEarlyStart()
	 * @see #unsetEarlyStart()
	 * @see #setEarlyStart(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_EarlyStart()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getEarlyStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyStart <em>Early Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Early Start</em>' reference.
	 * @see #isSetEarlyStart()
	 * @see #unsetEarlyStart()
	 * @see #getEarlyStart()
	 * @generated
	 */
	void setEarlyStart(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyStart <em>Early Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEarlyStart()
	 * @see #getEarlyStart()
	 * @see #setEarlyStart(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetEarlyStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyStart <em>Early Start</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Early Start</em>' reference is set.
	 * @see #unsetEarlyStart()
	 * @see #getEarlyStart()
	 * @see #setEarlyStart(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetEarlyStart();

	/**
	 * Returns the value of the '<em><b>Late Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Late Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Late Start</em>' reference.
	 * @see #isSetLateStart()
	 * @see #unsetLateStart()
	 * @see #setLateStart(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_LateStart()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getLateStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateStart <em>Late Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Late Start</em>' reference.
	 * @see #isSetLateStart()
	 * @see #unsetLateStart()
	 * @see #getLateStart()
	 * @generated
	 */
	void setLateStart(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateStart <em>Late Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLateStart()
	 * @see #getLateStart()
	 * @see #setLateStart(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetLateStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateStart <em>Late Start</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Late Start</em>' reference is set.
	 * @see #unsetLateStart()
	 * @see #getLateStart()
	 * @see #setLateStart(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetLateStart();

	/**
	 * Returns the value of the '<em><b>Schedule Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Start</em>' reference.
	 * @see #isSetScheduleStart()
	 * @see #unsetScheduleStart()
	 * @see #setScheduleStart(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ScheduleStart()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getScheduleStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleStart <em>Schedule Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Start</em>' reference.
	 * @see #isSetScheduleStart()
	 * @see #unsetScheduleStart()
	 * @see #getScheduleStart()
	 * @generated
	 */
	void setScheduleStart(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleStart <em>Schedule Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleStart()
	 * @see #getScheduleStart()
	 * @see #setScheduleStart(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetScheduleStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleStart <em>Schedule Start</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Start</em>' reference is set.
	 * @see #unsetScheduleStart()
	 * @see #getScheduleStart()
	 * @see #setScheduleStart(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetScheduleStart();

	/**
	 * Returns the value of the '<em><b>Actual Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Finish</em>' reference.
	 * @see #isSetActualFinish()
	 * @see #unsetActualFinish()
	 * @see #setActualFinish(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ActualFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getActualFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualFinish <em>Actual Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Finish</em>' reference.
	 * @see #isSetActualFinish()
	 * @see #unsetActualFinish()
	 * @see #getActualFinish()
	 * @generated
	 */
	void setActualFinish(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualFinish <em>Actual Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualFinish()
	 * @see #getActualFinish()
	 * @see #setActualFinish(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetActualFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualFinish <em>Actual Finish</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Finish</em>' reference is set.
	 * @see #unsetActualFinish()
	 * @see #getActualFinish()
	 * @see #setActualFinish(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetActualFinish();

	/**
	 * Returns the value of the '<em><b>Early Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Early Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Early Finish</em>' reference.
	 * @see #isSetEarlyFinish()
	 * @see #unsetEarlyFinish()
	 * @see #setEarlyFinish(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_EarlyFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getEarlyFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyFinish <em>Early Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Early Finish</em>' reference.
	 * @see #isSetEarlyFinish()
	 * @see #unsetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @generated
	 */
	void setEarlyFinish(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyFinish <em>Early Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @see #setEarlyFinish(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetEarlyFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getEarlyFinish <em>Early Finish</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Early Finish</em>' reference is set.
	 * @see #unsetEarlyFinish()
	 * @see #getEarlyFinish()
	 * @see #setEarlyFinish(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetEarlyFinish();

	/**
	 * Returns the value of the '<em><b>Late Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Late Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Late Finish</em>' reference.
	 * @see #isSetLateFinish()
	 * @see #unsetLateFinish()
	 * @see #setLateFinish(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_LateFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getLateFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateFinish <em>Late Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Late Finish</em>' reference.
	 * @see #isSetLateFinish()
	 * @see #unsetLateFinish()
	 * @see #getLateFinish()
	 * @generated
	 */
	void setLateFinish(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateFinish <em>Late Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLateFinish()
	 * @see #getLateFinish()
	 * @see #setLateFinish(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetLateFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getLateFinish <em>Late Finish</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Late Finish</em>' reference is set.
	 * @see #unsetLateFinish()
	 * @see #getLateFinish()
	 * @see #setLateFinish(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetLateFinish();

	/**
	 * Returns the value of the '<em><b>Schedule Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Finish</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Finish</em>' reference.
	 * @see #isSetScheduleFinish()
	 * @see #unsetScheduleFinish()
	 * @see #setScheduleFinish(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ScheduleFinish()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getScheduleFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleFinish <em>Schedule Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Finish</em>' reference.
	 * @see #isSetScheduleFinish()
	 * @see #unsetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @generated
	 */
	void setScheduleFinish(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleFinish <em>Schedule Finish</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @see #setScheduleFinish(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetScheduleFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleFinish <em>Schedule Finish</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Finish</em>' reference is set.
	 * @see #unsetScheduleFinish()
	 * @see #getScheduleFinish()
	 * @see #setScheduleFinish(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetScheduleFinish();

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
	 * @see #setScheduleDuration(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ScheduleDuration()
	 * @model unsettable="true"
	 * @generated
	 */
	float getScheduleDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDuration <em>Schedule Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Duration</em>' attribute.
	 * @see #isSetScheduleDuration()
	 * @see #unsetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @generated
	 */
	void setScheduleDuration(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDuration <em>Schedule Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @see #setScheduleDuration(float)
	 * @generated
	 */
	void unsetScheduleDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDuration <em>Schedule Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Duration</em>' attribute is set.
	 * @see #unsetScheduleDuration()
	 * @see #getScheduleDuration()
	 * @see #setScheduleDuration(float)
	 * @generated
	 */
	boolean isSetScheduleDuration();

	/**
	 * Returns the value of the '<em><b>Schedule Duration As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Duration As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Duration As String</em>' attribute.
	 * @see #isSetScheduleDurationAsString()
	 * @see #unsetScheduleDurationAsString()
	 * @see #setScheduleDurationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ScheduleDurationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleDurationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDurationAsString <em>Schedule Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Duration As String</em>' attribute.
	 * @see #isSetScheduleDurationAsString()
	 * @see #unsetScheduleDurationAsString()
	 * @see #getScheduleDurationAsString()
	 * @generated
	 */
	void setScheduleDurationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDurationAsString <em>Schedule Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleDurationAsString()
	 * @see #getScheduleDurationAsString()
	 * @see #setScheduleDurationAsString(String)
	 * @generated
	 */
	void unsetScheduleDurationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleDurationAsString <em>Schedule Duration As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Duration As String</em>' attribute is set.
	 * @see #unsetScheduleDurationAsString()
	 * @see #getScheduleDurationAsString()
	 * @see #setScheduleDurationAsString(String)
	 * @generated
	 */
	boolean isSetScheduleDurationAsString();

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
	 * @see #setActualDuration(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ActualDuration()
	 * @model unsettable="true"
	 * @generated
	 */
	float getActualDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDuration <em>Actual Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Duration</em>' attribute.
	 * @see #isSetActualDuration()
	 * @see #unsetActualDuration()
	 * @see #getActualDuration()
	 * @generated
	 */
	void setActualDuration(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDuration <em>Actual Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualDuration()
	 * @see #getActualDuration()
	 * @see #setActualDuration(float)
	 * @generated
	 */
	void unsetActualDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDuration <em>Actual Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Duration</em>' attribute is set.
	 * @see #unsetActualDuration()
	 * @see #getActualDuration()
	 * @see #setActualDuration(float)
	 * @generated
	 */
	boolean isSetActualDuration();

	/**
	 * Returns the value of the '<em><b>Actual Duration As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Duration As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Duration As String</em>' attribute.
	 * @see #isSetActualDurationAsString()
	 * @see #unsetActualDurationAsString()
	 * @see #setActualDurationAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ActualDurationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualDurationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDurationAsString <em>Actual Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Duration As String</em>' attribute.
	 * @see #isSetActualDurationAsString()
	 * @see #unsetActualDurationAsString()
	 * @see #getActualDurationAsString()
	 * @generated
	 */
	void setActualDurationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDurationAsString <em>Actual Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualDurationAsString()
	 * @see #getActualDurationAsString()
	 * @see #setActualDurationAsString(String)
	 * @generated
	 */
	void unsetActualDurationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getActualDurationAsString <em>Actual Duration As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Duration As String</em>' attribute is set.
	 * @see #unsetActualDurationAsString()
	 * @see #getActualDurationAsString()
	 * @see #setActualDurationAsString(String)
	 * @generated
	 */
	boolean isSetActualDurationAsString();

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
	 * @see #setRemainingTime(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_RemainingTime()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRemainingTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTime <em>Remaining Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Time</em>' attribute.
	 * @see #isSetRemainingTime()
	 * @see #unsetRemainingTime()
	 * @see #getRemainingTime()
	 * @generated
	 */
	void setRemainingTime(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTime <em>Remaining Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingTime()
	 * @see #getRemainingTime()
	 * @see #setRemainingTime(float)
	 * @generated
	 */
	void unsetRemainingTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTime <em>Remaining Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Time</em>' attribute is set.
	 * @see #unsetRemainingTime()
	 * @see #getRemainingTime()
	 * @see #setRemainingTime(float)
	 * @generated
	 */
	boolean isSetRemainingTime();

	/**
	 * Returns the value of the '<em><b>Remaining Time As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Time As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Time As String</em>' attribute.
	 * @see #isSetRemainingTimeAsString()
	 * @see #unsetRemainingTimeAsString()
	 * @see #setRemainingTimeAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_RemainingTimeAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRemainingTimeAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTimeAsString <em>Remaining Time As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Time As String</em>' attribute.
	 * @see #isSetRemainingTimeAsString()
	 * @see #unsetRemainingTimeAsString()
	 * @see #getRemainingTimeAsString()
	 * @generated
	 */
	void setRemainingTimeAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTimeAsString <em>Remaining Time As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRemainingTimeAsString()
	 * @see #getRemainingTimeAsString()
	 * @see #setRemainingTimeAsString(String)
	 * @generated
	 */
	void unsetRemainingTimeAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getRemainingTimeAsString <em>Remaining Time As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Remaining Time As String</em>' attribute is set.
	 * @see #unsetRemainingTimeAsString()
	 * @see #getRemainingTimeAsString()
	 * @see #setRemainingTimeAsString(String)
	 * @generated
	 */
	boolean isSetRemainingTimeAsString();

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
	 * @see #setFreeFloat(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_FreeFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFreeFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloat <em>Free Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Float</em>' attribute.
	 * @see #isSetFreeFloat()
	 * @see #unsetFreeFloat()
	 * @see #getFreeFloat()
	 * @generated
	 */
	void setFreeFloat(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloat <em>Free Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFreeFloat()
	 * @see #getFreeFloat()
	 * @see #setFreeFloat(float)
	 * @generated
	 */
	void unsetFreeFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloat <em>Free Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Free Float</em>' attribute is set.
	 * @see #unsetFreeFloat()
	 * @see #getFreeFloat()
	 * @see #setFreeFloat(float)
	 * @generated
	 */
	boolean isSetFreeFloat();

	/**
	 * Returns the value of the '<em><b>Free Float As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Float As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Float As String</em>' attribute.
	 * @see #isSetFreeFloatAsString()
	 * @see #unsetFreeFloatAsString()
	 * @see #setFreeFloatAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_FreeFloatAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFreeFloatAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloatAsString <em>Free Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Float As String</em>' attribute.
	 * @see #isSetFreeFloatAsString()
	 * @see #unsetFreeFloatAsString()
	 * @see #getFreeFloatAsString()
	 * @generated
	 */
	void setFreeFloatAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloatAsString <em>Free Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFreeFloatAsString()
	 * @see #getFreeFloatAsString()
	 * @see #setFreeFloatAsString(String)
	 * @generated
	 */
	void unsetFreeFloatAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFreeFloatAsString <em>Free Float As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Free Float As String</em>' attribute is set.
	 * @see #unsetFreeFloatAsString()
	 * @see #getFreeFloatAsString()
	 * @see #setFreeFloatAsString(String)
	 * @generated
	 */
	boolean isSetFreeFloatAsString();

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
	 * @see #setTotalFloat(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_TotalFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	float getTotalFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @generated
	 */
	void setTotalFloat(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(float)
	 * @generated
	 */
	void unsetTotalFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloat <em>Total Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float</em>' attribute is set.
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(float)
	 * @generated
	 */
	boolean isSetTotalFloat();

	/**
	 * Returns the value of the '<em><b>Total Float As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Float As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Float As String</em>' attribute.
	 * @see #isSetTotalFloatAsString()
	 * @see #unsetTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_TotalFloatAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTotalFloatAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float As String</em>' attribute.
	 * @see #isSetTotalFloatAsString()
	 * @see #unsetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @generated
	 */
	void setTotalFloatAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @generated
	 */
	void unsetTotalFloatAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float As String</em>' attribute is set.
	 * @see #unsetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @generated
	 */
	boolean isSetTotalFloatAsString();

	/**
	 * Returns the value of the '<em><b>Is Critical</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Critical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Critical</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #setIsCritical(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_IsCritical()
	 * @model
	 * @generated
	 */
	Tristate getIsCritical();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getIsCritical <em>Is Critical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Critical</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #getIsCritical()
	 * @generated
	 */
	void setIsCritical(Tristate value);

	/**
	 * Returns the value of the '<em><b>Status Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Time</em>' reference.
	 * @see #isSetStatusTime()
	 * @see #unsetStatusTime()
	 * @see #setStatusTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_StatusTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getStatusTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStatusTime <em>Status Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Time</em>' reference.
	 * @see #isSetStatusTime()
	 * @see #unsetStatusTime()
	 * @see #getStatusTime()
	 * @generated
	 */
	void setStatusTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStatusTime <em>Status Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatusTime()
	 * @see #getStatusTime()
	 * @see #setStatusTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetStatusTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStatusTime <em>Status Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status Time</em>' reference is set.
	 * @see #unsetStatusTime()
	 * @see #getStatusTime()
	 * @see #setStatusTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetStatusTime();

	/**
	 * Returns the value of the '<em><b>Start Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Float</em>' attribute.
	 * @see #isSetStartFloat()
	 * @see #unsetStartFloat()
	 * @see #setStartFloat(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_StartFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	float getStartFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloat <em>Start Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Float</em>' attribute.
	 * @see #isSetStartFloat()
	 * @see #unsetStartFloat()
	 * @see #getStartFloat()
	 * @generated
	 */
	void setStartFloat(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloat <em>Start Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartFloat()
	 * @see #getStartFloat()
	 * @see #setStartFloat(float)
	 * @generated
	 */
	void unsetStartFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloat <em>Start Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Float</em>' attribute is set.
	 * @see #unsetStartFloat()
	 * @see #getStartFloat()
	 * @see #setStartFloat(float)
	 * @generated
	 */
	boolean isSetStartFloat();

	/**
	 * Returns the value of the '<em><b>Start Float As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Float As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Float As String</em>' attribute.
	 * @see #isSetStartFloatAsString()
	 * @see #unsetStartFloatAsString()
	 * @see #setStartFloatAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_StartFloatAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStartFloatAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloatAsString <em>Start Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Float As String</em>' attribute.
	 * @see #isSetStartFloatAsString()
	 * @see #unsetStartFloatAsString()
	 * @see #getStartFloatAsString()
	 * @generated
	 */
	void setStartFloatAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloatAsString <em>Start Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartFloatAsString()
	 * @see #getStartFloatAsString()
	 * @see #setStartFloatAsString(String)
	 * @generated
	 */
	void unsetStartFloatAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getStartFloatAsString <em>Start Float As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Float As String</em>' attribute is set.
	 * @see #unsetStartFloatAsString()
	 * @see #getStartFloatAsString()
	 * @see #setStartFloatAsString(String)
	 * @generated
	 */
	boolean isSetStartFloatAsString();

	/**
	 * Returns the value of the '<em><b>Finish Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Float</em>' attribute.
	 * @see #isSetFinishFloat()
	 * @see #unsetFinishFloat()
	 * @see #setFinishFloat(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_FinishFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	float getFinishFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloat <em>Finish Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Float</em>' attribute.
	 * @see #isSetFinishFloat()
	 * @see #unsetFinishFloat()
	 * @see #getFinishFloat()
	 * @generated
	 */
	void setFinishFloat(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloat <em>Finish Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinishFloat()
	 * @see #getFinishFloat()
	 * @see #setFinishFloat(float)
	 * @generated
	 */
	void unsetFinishFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloat <em>Finish Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish Float</em>' attribute is set.
	 * @see #unsetFinishFloat()
	 * @see #getFinishFloat()
	 * @see #setFinishFloat(float)
	 * @generated
	 */
	boolean isSetFinishFloat();

	/**
	 * Returns the value of the '<em><b>Finish Float As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish Float As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Float As String</em>' attribute.
	 * @see #isSetFinishFloatAsString()
	 * @see #unsetFinishFloatAsString()
	 * @see #setFinishFloatAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_FinishFloatAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFinishFloatAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloatAsString <em>Finish Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Float As String</em>' attribute.
	 * @see #isSetFinishFloatAsString()
	 * @see #unsetFinishFloatAsString()
	 * @see #getFinishFloatAsString()
	 * @generated
	 */
	void setFinishFloatAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloatAsString <em>Finish Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinishFloatAsString()
	 * @see #getFinishFloatAsString()
	 * @see #setFinishFloatAsString(String)
	 * @generated
	 */
	void unsetFinishFloatAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getFinishFloatAsString <em>Finish Float As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish Float As String</em>' attribute is set.
	 * @see #unsetFinishFloatAsString()
	 * @see #getFinishFloatAsString()
	 * @see #setFinishFloatAsString(String)
	 * @generated
	 */
	boolean isSetFinishFloatAsString();

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
	 * @see #setCompletion(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_Completion()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCompletion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletion <em>Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion</em>' attribute.
	 * @see #isSetCompletion()
	 * @see #unsetCompletion()
	 * @see #getCompletion()
	 * @generated
	 */
	void setCompletion(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletion <em>Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletion()
	 * @see #getCompletion()
	 * @see #setCompletion(float)
	 * @generated
	 */
	void unsetCompletion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletion <em>Completion</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Completion</em>' attribute is set.
	 * @see #unsetCompletion()
	 * @see #getCompletion()
	 * @see #setCompletion(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_CompletionAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCompletionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletionAsString <em>Completion As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletionAsString <em>Completion As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	void unsetCompletionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getCompletionAsString <em>Completion As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Completion As String</em>' attribute is set.
	 * @see #unsetCompletionAsString()
	 * @see #getCompletionAsString()
	 * @see #setCompletionAsString(String)
	 * @generated
	 */
	boolean isSetCompletionAsString();

	/**
	 * Returns the value of the '<em><b>Schedule Time Control Assigned</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelAssignsTasks#getTimeForTask <em>Time For Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Time Control Assigned</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Time Control Assigned</em>' reference.
	 * @see #setScheduleTimeControlAssigned(IfcRelAssignsTasks)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcScheduleTimeControl_ScheduleTimeControlAssigned()
	 * @see org.bimserver.models.ifc2x3.IfcRelAssignsTasks#getTimeForTask
	 * @model opposite="TimeForTask"
	 * @generated
	 */
	IfcRelAssignsTasks getScheduleTimeControlAssigned();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcScheduleTimeControl#getScheduleTimeControlAssigned <em>Schedule Time Control Assigned</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Time Control Assigned</em>' reference.
	 * @see #getScheduleTimeControlAssigned()
	 * @generated
	 */
	void setScheduleTimeControlAssigned(IfcRelAssignsTasks value);

} // IfcScheduleTimeControl
