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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Time Series Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesSchedule()
 * @model
 * @generated
 */
public interface IfcTimeSeriesSchedule extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Applicable Dates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDateTimeSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Dates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Dates</em>' reference list.
	 * @see #isSetApplicableDates()
	 * @see #unsetApplicableDates()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesSchedule_ApplicableDates()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcDateTimeSelect> getApplicableDates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableDates()
	 * @see #getApplicableDates()
	 * @generated
	 */
	void unsetApplicableDates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Dates</em>' reference list is set.
	 * @see #unsetApplicableDates()
	 * @see #getApplicableDates()
	 * @generated
	 */
	boolean isSetApplicableDates();

	/**
	 * Returns the value of the '<em><b>Time Series Schedule Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcTimeSeriesScheduleTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series Schedule Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series Schedule Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeriesScheduleTypeEnum
	 * @see #isSetTimeSeriesScheduleType()
	 * @see #unsetTimeSeriesScheduleType()
	 * @see #setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesSchedule_TimeSeriesScheduleType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTimeSeriesScheduleTypeEnum getTimeSeriesScheduleType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series Schedule Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeriesScheduleTypeEnum
	 * @see #isSetTimeSeriesScheduleType()
	 * @see #unsetTimeSeriesScheduleType()
	 * @see #getTimeSeriesScheduleType()
	 * @generated
	 */
	void setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeSeriesScheduleType()
	 * @see #getTimeSeriesScheduleType()
	 * @see #setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum)
	 * @generated
	 */
	void unsetTimeSeriesScheduleType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Series Schedule Type</em>' attribute is set.
	 * @see #unsetTimeSeriesScheduleType()
	 * @see #getTimeSeriesScheduleType()
	 * @see #setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum)
	 * @generated
	 */
	boolean isSetTimeSeriesScheduleType();

	/**
	 * Returns the value of the '<em><b>Time Series</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series</em>' reference.
	 * @see #isSetTimeSeries()
	 * @see #unsetTimeSeries()
	 * @see #setTimeSeries(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesSchedule_TimeSeries()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTimeSeries getTimeSeries();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series</em>' reference.
	 * @see #isSetTimeSeries()
	 * @see #unsetTimeSeries()
	 * @see #getTimeSeries()
	 * @generated
	 */
	void setTimeSeries(IfcTimeSeries value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeSeries()
	 * @see #getTimeSeries()
	 * @see #setTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	void unsetTimeSeries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Series</em>' reference is set.
	 * @see #unsetTimeSeries()
	 * @see #getTimeSeries()
	 * @see #setTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	boolean isSetTimeSeries();

} // IfcTimeSeriesSchedule
