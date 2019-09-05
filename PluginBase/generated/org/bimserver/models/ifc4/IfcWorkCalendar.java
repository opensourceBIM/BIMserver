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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Work Calendar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkCalendar#getWorkingTimes <em>Working Times</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkCalendar#getExceptionTimes <em>Exception Times</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkCalendar#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkCalendar()
 * @model
 * @generated
 */
public interface IfcWorkCalendar extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Working Times</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcWorkTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Working Times</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Working Times</em>' reference list.
	 * @see #isSetWorkingTimes()
	 * @see #unsetWorkingTimes()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkCalendar_WorkingTimes()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcWorkTime> getWorkingTimes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getWorkingTimes <em>Working Times</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWorkingTimes()
	 * @see #getWorkingTimes()
	 * @generated
	 */
	void unsetWorkingTimes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getWorkingTimes <em>Working Times</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Working Times</em>' reference list is set.
	 * @see #unsetWorkingTimes()
	 * @see #getWorkingTimes()
	 * @generated
	 */
	boolean isSetWorkingTimes();

	/**
	 * Returns the value of the '<em><b>Exception Times</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcWorkTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Times</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Times</em>' reference list.
	 * @see #isSetExceptionTimes()
	 * @see #unsetExceptionTimes()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkCalendar_ExceptionTimes()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcWorkTime> getExceptionTimes();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getExceptionTimes <em>Exception Times</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExceptionTimes()
	 * @see #getExceptionTimes()
	 * @generated
	 */
	void unsetExceptionTimes();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getExceptionTimes <em>Exception Times</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exception Times</em>' reference list is set.
	 * @see #unsetExceptionTimes()
	 * @see #getExceptionTimes()
	 * @generated
	 */
	boolean isSetExceptionTimes();

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcWorkCalendarTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWorkCalendarTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcWorkCalendarTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkCalendar_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcWorkCalendarTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcWorkCalendarTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcWorkCalendarTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcWorkCalendarTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkCalendar#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcWorkCalendarTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

} // IfcWorkCalendar
