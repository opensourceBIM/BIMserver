/**
 * Copyright (C) 2009-2013 BIMserver.org
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Task Time Recurring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTaskTimeRecurring#getRecurrance <em>Recurrance</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTimeRecurring()
 * @model
 * @generated
 */
public interface IfcTaskTimeRecurring extends IfcTaskTime {
	/**
	 * Returns the value of the '<em><b>Recurrance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recurrance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recurrance</em>' reference.
	 * @see #setRecurrance(IfcRecurrencePattern)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTaskTimeRecurring_Recurrance()
	 * @model
	 * @generated
	 */
	IfcRecurrencePattern getRecurrance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTaskTimeRecurring#getRecurrance <em>Recurrance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recurrance</em>' reference.
	 * @see #getRecurrance()
	 * @generated
	 */
	void setRecurrance(IfcRecurrencePattern value);

} // IfcTaskTimeRecurring
