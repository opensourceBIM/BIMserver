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

public interface IfcWorkTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Recurrence Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recurrence Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recurrence Pattern</em>' reference.
	 * @see #isSetRecurrencePattern()
	 * @see #unsetRecurrencePattern()
	 * @see #setRecurrencePattern(IfcRecurrencePattern)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkTime_RecurrencePattern()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcRecurrencePattern getRecurrencePattern();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRecurrencePattern()
	 * @see #getRecurrencePattern()
	 * @see #setRecurrencePattern(IfcRecurrencePattern)
	 * @generated
	 */
	void unsetRecurrencePattern();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getRecurrencePattern <em>Recurrence Pattern</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #setStart(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkTime_Start()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStart();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #getStart()
	 * @generated
	 */
	void setStart(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStart()
	 * @see #getStart()
	 * @see #setStart(String)
	 * @generated
	 */
	void unsetStart();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getStart <em>Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start</em>' attribute is set.
	 * @see #unsetStart()
	 * @see #getStart()
	 * @see #setStart(String)
	 * @generated
	 */
	boolean isSetStart();

	/**
	 * Returns the value of the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish</em>' attribute.
	 * @see #isSetFinish()
	 * @see #unsetFinish()
	 * @see #setFinish(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkTime_Finish()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFinish();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getFinish <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish</em>' attribute.
	 * @see #isSetFinish()
	 * @see #unsetFinish()
	 * @see #getFinish()
	 * @generated
	 */
	void setFinish(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getFinish <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinish()
	 * @see #getFinish()
	 * @see #setFinish(String)
	 * @generated
	 */
	void unsetFinish();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkTime#getFinish <em>Finish</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish</em>' attribute is set.
	 * @see #unsetFinish()
	 * @see #getFinish()
	 * @see #setFinish(String)
	 * @generated
	 */
	boolean isSetFinish();

} // IfcWorkTime
