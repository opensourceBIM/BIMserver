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
import org.bimserver.models.ifc4x3.IfcRecurrencePattern;
import org.bimserver.models.ifc4x3.IfcWorkTime;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Work Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkTimeImpl#getRecurrencePattern <em>Recurrence Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkTimeImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcWorkTimeImpl#getFinishDate <em>Finish Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWorkTimeImpl extends IfcSchedulingTimeImpl implements IfcWorkTime {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWorkTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_WORK_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRecurrencePattern getRecurrencePattern() {
		return (IfcRecurrencePattern) eGet(Ifc4x3Package.Literals.IFC_WORK_TIME__RECURRENCE_PATTERN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecurrencePattern(IfcRecurrencePattern newRecurrencePattern) {
		eSet(Ifc4x3Package.Literals.IFC_WORK_TIME__RECURRENCE_PATTERN, newRecurrencePattern);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRecurrencePattern() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_TIME__RECURRENCE_PATTERN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRecurrencePattern() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_TIME__RECURRENCE_PATTERN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartDate() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_WORK_TIME__START_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDate(String newStartDate) {
		eSet(Ifc4x3Package.Literals.IFC_WORK_TIME__START_DATE, newStartDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartDate() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_TIME__START_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartDate() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_TIME__START_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFinishDate() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_WORK_TIME__FINISH_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFinishDate(String newFinishDate) {
		eSet(Ifc4x3Package.Literals.IFC_WORK_TIME__FINISH_DATE, newFinishDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetFinishDate() {
		eUnset(Ifc4x3Package.Literals.IFC_WORK_TIME__FINISH_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFinishDate() {
		return eIsSet(Ifc4x3Package.Literals.IFC_WORK_TIME__FINISH_DATE);
	}

} //IfcWorkTimeImpl
