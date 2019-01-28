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
package org.bimserver.models.ifc2x3tc1;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Time Series Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTimeSeriesSchedule()
 * @model
 * @generated
 */
public interface IfcTimeSeriesSchedule extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Applicable Dates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Dates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Dates</em>' reference list.
	 * @see #isSetApplicableDates()
	 * @see #unsetApplicableDates()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTimeSeriesSchedule_ApplicableDates()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcDateTimeSelect> getApplicableDates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableDates()
	 * @see #getApplicableDates()
	 * @generated
	 */
	void unsetApplicableDates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getApplicableDates <em>Applicable Dates</em>}' reference list is set.
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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesScheduleTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series Schedule Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series Schedule Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcTimeSeriesScheduleTypeEnum
	 * @see #setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTimeSeriesSchedule_TimeSeriesScheduleType()
	 * @model
	 * @generated
	 */
	IfcTimeSeriesScheduleTypeEnum getTimeSeriesScheduleType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series Schedule Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcTimeSeriesScheduleTypeEnum
	 * @see #getTimeSeriesScheduleType()
	 * @generated
	 */
	void setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Time Series</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series</em>' reference.
	 * @see #setTimeSeries(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcTimeSeriesSchedule_TimeSeries()
	 * @model
	 * @generated
	 */
	IfcTimeSeries getTimeSeries();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule#getTimeSeries <em>Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Series</em>' reference.
	 * @see #getTimeSeries()
	 * @generated
	 */
	void setTimeSeries(IfcTimeSeries value);

} // IfcTimeSeriesSchedule
