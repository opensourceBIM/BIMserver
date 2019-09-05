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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Recurrence Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getRecurrenceType <em>Recurrence Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getDayComponent <em>Day Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getWeekdayComponent <em>Weekday Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getMonthComponent <em>Month Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getOccurrences <em>Occurrences</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getTimePeriods <em>Time Periods</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcRecurrencePattern extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Recurrence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcRecurrenceTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recurrence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recurrence Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcRecurrenceTypeEnum
	 * @see #setRecurrenceType(IfcRecurrenceTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_RecurrenceType()
	 * @model
	 * @generated
	 */
	IfcRecurrenceTypeEnum getRecurrenceType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getRecurrenceType <em>Recurrence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recurrence Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcRecurrenceTypeEnum
	 * @see #getRecurrenceType()
	 * @generated
	 */
	void setRecurrenceType(IfcRecurrenceTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Day Component</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day Component</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Component</em>' attribute list.
	 * @see #isSetDayComponent()
	 * @see #unsetDayComponent()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_DayComponent()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getDayComponent();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getDayComponent <em>Day Component</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDayComponent()
	 * @see #getDayComponent()
	 * @generated
	 */
	void unsetDayComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getDayComponent <em>Day Component</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Day Component</em>' attribute list is set.
	 * @see #unsetDayComponent()
	 * @see #getDayComponent()
	 * @generated
	 */
	boolean isSetDayComponent();

	/**
	 * Returns the value of the '<em><b>Weekday Component</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weekday Component</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weekday Component</em>' attribute list.
	 * @see #isSetWeekdayComponent()
	 * @see #unsetWeekdayComponent()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_WeekdayComponent()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getWeekdayComponent();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getWeekdayComponent <em>Weekday Component</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWeekdayComponent()
	 * @see #getWeekdayComponent()
	 * @generated
	 */
	void unsetWeekdayComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getWeekdayComponent <em>Weekday Component</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Weekday Component</em>' attribute list is set.
	 * @see #unsetWeekdayComponent()
	 * @see #getWeekdayComponent()
	 * @generated
	 */
	boolean isSetWeekdayComponent();

	/**
	 * Returns the value of the '<em><b>Month Component</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month Component</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month Component</em>' attribute list.
	 * @see #isSetMonthComponent()
	 * @see #unsetMonthComponent()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_MonthComponent()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Long> getMonthComponent();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getMonthComponent <em>Month Component</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMonthComponent()
	 * @see #getMonthComponent()
	 * @generated
	 */
	void unsetMonthComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getMonthComponent <em>Month Component</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Month Component</em>' attribute list is set.
	 * @see #unsetMonthComponent()
	 * @see #getMonthComponent()
	 * @generated
	 */
	boolean isSetMonthComponent();

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #setPosition(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_Position()
	 * @model unsettable="true"
	 * @generated
	 */
	long getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPosition()
	 * @see #getPosition()
	 * @see #setPosition(long)
	 * @generated
	 */
	void unsetPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getPosition <em>Position</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position</em>' attribute is set.
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @see #setPosition(long)
	 * @generated
	 */
	boolean isSetPosition();

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #isSetInterval()
	 * @see #unsetInterval()
	 * @see #setInterval(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_Interval()
	 * @model unsettable="true"
	 * @generated
	 */
	long getInterval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #isSetInterval()
	 * @see #unsetInterval()
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterval()
	 * @see #getInterval()
	 * @see #setInterval(long)
	 * @generated
	 */
	void unsetInterval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getInterval <em>Interval</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interval</em>' attribute is set.
	 * @see #unsetInterval()
	 * @see #getInterval()
	 * @see #setInterval(long)
	 * @generated
	 */
	boolean isSetInterval();

	/**
	 * Returns the value of the '<em><b>Occurrences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occurrences</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurrences</em>' attribute.
	 * @see #isSetOccurrences()
	 * @see #unsetOccurrences()
	 * @see #setOccurrences(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_Occurrences()
	 * @model unsettable="true"
	 * @generated
	 */
	long getOccurrences();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getOccurrences <em>Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurrences</em>' attribute.
	 * @see #isSetOccurrences()
	 * @see #unsetOccurrences()
	 * @see #getOccurrences()
	 * @generated
	 */
	void setOccurrences(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getOccurrences <em>Occurrences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOccurrences()
	 * @see #getOccurrences()
	 * @see #setOccurrences(long)
	 * @generated
	 */
	void unsetOccurrences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getOccurrences <em>Occurrences</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Occurrences</em>' attribute is set.
	 * @see #unsetOccurrences()
	 * @see #getOccurrences()
	 * @see #setOccurrences(long)
	 * @generated
	 */
	boolean isSetOccurrences();

	/**
	 * Returns the value of the '<em><b>Time Periods</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTimePeriod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Periods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Periods</em>' reference list.
	 * @see #isSetTimePeriods()
	 * @see #unsetTimePeriods()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRecurrencePattern_TimePeriods()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTimePeriod> getTimePeriods();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getTimePeriods <em>Time Periods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimePeriods()
	 * @see #getTimePeriods()
	 * @generated
	 */
	void unsetTimePeriods();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRecurrencePattern#getTimePeriods <em>Time Periods</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Periods</em>' reference list is set.
	 * @see #unsetTimePeriods()
	 * @see #getTimePeriods()
	 * @generated
	 */
	boolean isSetTimePeriods();

} // IfcRecurrencePattern
