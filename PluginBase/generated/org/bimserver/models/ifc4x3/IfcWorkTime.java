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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Work Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWorkTime#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWorkTime#getFinishDate <em>Finish Date</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWorkTime()
 * @model
 * @generated
 */
public interface IfcWorkTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Recurrence Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recurrence Pattern</em>' reference.
	 * @see #isSetRecurrencePattern()
	 * @see #unsetRecurrencePattern()
	 * @see #setRecurrencePattern(IfcRecurrencePattern)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWorkTime_RecurrencePattern()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcRecurrencePattern getRecurrencePattern();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recurrence Pattern</em>' reference.
	 * @see #isSetRecurrencePattern()
	 * @see #unsetRecurrencePattern()
	 * @see #getRecurrencePattern()
	 * @generated
	 */
	void setRecurrencePattern(IfcRecurrencePattern value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRecurrencePattern()
	 * @see #getRecurrencePattern()
	 * @see #setRecurrencePattern(IfcRecurrencePattern)
	 * @generated
	 */
	void unsetRecurrencePattern();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Recurrence Pattern</em>' reference is set.
	 * @see #unsetRecurrencePattern()
	 * @see #getRecurrencePattern()
	 * @see #setRecurrencePattern(IfcRecurrencePattern)
	 * @generated
	 */
	boolean isSetRecurrencePattern();

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #isSetStartDate()
	 * @see #unsetStartDate()
	 * @see #setStartDate(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWorkTime_StartDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStartDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #isSetStartDate()
	 * @see #unsetStartDate()
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartDate()
	 * @see #getStartDate()
	 * @see #setStartDate(String)
	 * @generated
	 */
	void unsetStartDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getStartDate <em>Start Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Date</em>' attribute is set.
	 * @see #unsetStartDate()
	 * @see #getStartDate()
	 * @see #setStartDate(String)
	 * @generated
	 */
	boolean isSetStartDate();

	/**
	 * Returns the value of the '<em><b>Finish Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Date</em>' attribute.
	 * @see #isSetFinishDate()
	 * @see #unsetFinishDate()
	 * @see #setFinishDate(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWorkTime_FinishDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFinishDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getFinishDate <em>Finish Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Date</em>' attribute.
	 * @see #isSetFinishDate()
	 * @see #unsetFinishDate()
	 * @see #getFinishDate()
	 * @generated
	 */
	void setFinishDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getFinishDate <em>Finish Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinishDate()
	 * @see #getFinishDate()
	 * @see #setFinishDate(String)
	 * @generated
	 */
	void unsetFinishDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcWorkTime#getFinishDate <em>Finish Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish Date</em>' attribute is set.
	 * @see #unsetFinishDate()
	 * @see #getFinishDate()
	 * @see #setFinishDate(String)
	 * @generated
	 */
	boolean isSetFinishDate();

} // IfcWorkTime
