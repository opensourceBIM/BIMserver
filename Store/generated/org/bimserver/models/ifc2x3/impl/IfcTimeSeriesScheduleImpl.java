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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcTimeSeries;
import org.bimserver.models.ifc2x3.IfcTimeSeriesSchedule;
import org.bimserver.models.ifc2x3.IfcTimeSeriesScheduleTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Time Series Schedule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesScheduleImpl#getApplicableDates <em>Applicable Dates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesScheduleImpl#getTimeSeriesScheduleType <em>Time Series Schedule Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesScheduleImpl#getTimeSeries <em>Time Series</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTimeSeriesScheduleImpl extends IfcControlImpl implements IfcTimeSeriesSchedule
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTimeSeriesScheduleImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDateTimeSelect> getApplicableDates()
	{
		return (EList<IfcDateTimeSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_ApplicableDates(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableDates()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_ApplicableDates());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableDates()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_ApplicableDates());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesScheduleTypeEnum getTimeSeriesScheduleType()
	{
		return (IfcTimeSeriesScheduleTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_TimeSeriesScheduleType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSeriesScheduleType(IfcTimeSeriesScheduleTypeEnum newTimeSeriesScheduleType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_TimeSeriesScheduleType(), newTimeSeriesScheduleType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getTimeSeries()
	{
		return (IfcTimeSeries)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_TimeSeries(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeSeries(IfcTimeSeries newTimeSeries)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesSchedule_TimeSeries(), newTimeSeries);
	}

} //IfcTimeSeriesScheduleImpl
