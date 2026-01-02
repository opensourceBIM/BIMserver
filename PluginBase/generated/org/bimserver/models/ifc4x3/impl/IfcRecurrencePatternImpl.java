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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcRecurrencePattern;
import org.bimserver.models.ifc4x3.IfcRecurrenceTypeEnum;
import org.bimserver.models.ifc4x3.IfcTimePeriod;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Recurrence Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getRecurrenceType <em>Recurrence Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getDayComponent <em>Day Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getWeekdayComponent <em>Weekday Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getMonthComponent <em>Month Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getInterval <em>Interval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getOccurrences <em>Occurrences</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRecurrencePatternImpl#getTimePeriods <em>Time Periods</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRecurrencePatternImpl extends IdEObjectImpl implements IfcRecurrencePattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRecurrencePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRecurrenceTypeEnum getRecurrenceType() {
		return (IfcRecurrenceTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_RecurrenceType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecurrenceType(IfcRecurrenceTypeEnum newRecurrenceType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_RecurrenceType(), newRecurrenceType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getDayComponent() {
		return (EList<Long>) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_DayComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDayComponent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_DayComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDayComponent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_DayComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getWeekdayComponent() {
		return (EList<Long>) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_WeekdayComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWeekdayComponent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_WeekdayComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWeekdayComponent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_WeekdayComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getMonthComponent() {
		return (EList<Long>) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_MonthComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMonthComponent() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_MonthComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMonthComponent() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_MonthComponent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getPosition() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(long newPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPosition() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Position());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPosition() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Position());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getInterval() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Interval(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterval(long newInterval) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Interval(), newInterval);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInterval() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Interval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInterval() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Interval());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getOccurrences() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Occurrences(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOccurrences(long newOccurrences) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Occurrences(), newOccurrences);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOccurrences() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Occurrences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOccurrences() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_Occurrences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcTimePeriod> getTimePeriods() {
		return (EList<IfcTimePeriod>) eGet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_TimePeriods(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTimePeriods() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_TimePeriods());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTimePeriods() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRecurrencePattern_TimePeriods());
	}

} //IfcRecurrencePatternImpl
