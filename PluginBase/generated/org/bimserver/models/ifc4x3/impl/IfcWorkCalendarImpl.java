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
import org.bimserver.models.ifc4x3.IfcWorkCalendar;
import org.bimserver.models.ifc4x3.IfcWorkCalendarTypeEnum;
import org.bimserver.models.ifc4x3.IfcWorkTime;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Work Calendar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkCalendarImpl#getWorkingTimes <em>Working Times</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkCalendarImpl#getExceptionTimes <em>Exception Times</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkCalendarImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWorkCalendarImpl extends IfcControlImpl implements IfcWorkCalendar {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWorkCalendarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_WORK_CALENDAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcWorkTime> getWorkingTimes() {
		return (EList<IfcWorkTime>) eGet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__WORKING_TIMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWorkingTimes() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__WORKING_TIMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWorkingTimes() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__WORKING_TIMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcWorkTime> getExceptionTimes() {
		return (EList<IfcWorkTime>) eGet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__EXCEPTION_TIMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetExceptionTimes() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__EXCEPTION_TIMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetExceptionTimes() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__EXCEPTION_TIMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkCalendarTypeEnum getPredefinedType() {
		return (IfcWorkCalendarTypeEnum) eGet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcWorkCalendarTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_CALENDAR__PREDEFINED_TYPE);
	}

} //IfcWorkCalendarImpl
