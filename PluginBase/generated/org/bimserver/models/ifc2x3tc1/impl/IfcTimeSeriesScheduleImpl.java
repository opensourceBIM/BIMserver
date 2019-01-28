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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeries;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeriesSchedule;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeriesScheduleTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Time Series Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTimeSeriesScheduleImpl#getApplicableDates <em>Applicable Dates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTimeSeriesScheduleImpl#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTimeSeriesScheduleImpl#getTimeSeries <em>Time Series</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTimeSeriesScheduleImpl extends IfcControlImpl implements IfcTimeSeriesSchedule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTimeSeriesScheduleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDateTimeSelect> getApplicableDates() {
		return (EList<IfcDateTimeSelect>) eGet(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__APPLICABLE_DATES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableDates() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__APPLICABLE_DATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableDates() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__APPLICABLE_DATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesScheduleTypeEnum getTimeSeriesScheduleType() {
		return (IfcTimeSeriesScheduleTypeEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__TIME_SERIES_SCHEDULE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum newTimeSeriesScheduleType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__TIME_SERIES_SCHEDULE_TYPE, newTimeSeriesScheduleType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSeries(IfcTimeSeries newTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TIME_SERIES_SCHEDULE__TIME_SERIES, newTimeSeries);
	}

} //IfcTimeSeriesScheduleImpl
