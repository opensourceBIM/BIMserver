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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcEventTime;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Event Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTimeImpl#getActualDate <em>Actual Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTimeImpl#getEarlyDate <em>Early Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTimeImpl#getLateDate <em>Late Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTimeImpl#getScheduleDate <em>Schedule Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcEventTimeImpl extends IfcSchedulingTimeImpl implements IfcEventTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEventTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_EVENT_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getActualDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_EVENT_TIME__ACTUAL_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActualDate(String newActualDate) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TIME__ACTUAL_DATE, newActualDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetActualDate() {
		eUnset(Ifc4Package.Literals.IFC_EVENT_TIME__ACTUAL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetActualDate() {
		return eIsSet(Ifc4Package.Literals.IFC_EVENT_TIME__ACTUAL_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEarlyDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_EVENT_TIME__EARLY_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEarlyDate(String newEarlyDate) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TIME__EARLY_DATE, newEarlyDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEarlyDate() {
		eUnset(Ifc4Package.Literals.IFC_EVENT_TIME__EARLY_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEarlyDate() {
		return eIsSet(Ifc4Package.Literals.IFC_EVENT_TIME__EARLY_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLateDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_EVENT_TIME__LATE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLateDate(String newLateDate) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TIME__LATE_DATE, newLateDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLateDate() {
		eUnset(Ifc4Package.Literals.IFC_EVENT_TIME__LATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLateDate() {
		return eIsSet(Ifc4Package.Literals.IFC_EVENT_TIME__LATE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScheduleDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_EVENT_TIME__SCHEDULE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScheduleDate(String newScheduleDate) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TIME__SCHEDULE_DATE, newScheduleDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetScheduleDate() {
		eUnset(Ifc4Package.Literals.IFC_EVENT_TIME__SCHEDULE_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetScheduleDate() {
		return eIsSet(Ifc4Package.Literals.IFC_EVENT_TIME__SCHEDULE_DATE);
	}

} //IfcEventTimeImpl
