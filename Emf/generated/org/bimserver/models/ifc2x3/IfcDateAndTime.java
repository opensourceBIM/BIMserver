/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Date And Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime()
 * @model
 * @generated
 */
public interface IfcDateAndTime extends IfcDateTimeSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Date Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Component</em>' reference.
	 * @see #isSetDateComponent()
	 * @see #unsetDateComponent()
	 * @see #setDateComponent(IfcCalendarDate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime_DateComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCalendarDate getDateComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Component</em>' reference.
	 * @see #isSetDateComponent()
	 * @see #unsetDateComponent()
	 * @see #getDateComponent()
	 * @generated
	 */
	void setDateComponent(IfcCalendarDate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDateComponent()
	 * @see #getDateComponent()
	 * @see #setDateComponent(IfcCalendarDate)
	 * @generated
	 */
	void unsetDateComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getDateComponent <em>Date Component</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Date Component</em>' reference is set.
	 * @see #unsetDateComponent()
	 * @see #getDateComponent()
	 * @see #setDateComponent(IfcCalendarDate)
	 * @generated
	 */
	boolean isSetDateComponent();

	/**
	 * Returns the value of the '<em><b>Time Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Component</em>' reference.
	 * @see #isSetTimeComponent()
	 * @see #unsetTimeComponent()
	 * @see #setTimeComponent(IfcLocalTime)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDateAndTime_TimeComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLocalTime getTimeComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Component</em>' reference.
	 * @see #isSetTimeComponent()
	 * @see #unsetTimeComponent()
	 * @see #getTimeComponent()
	 * @generated
	 */
	void setTimeComponent(IfcLocalTime value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeComponent()
	 * @see #getTimeComponent()
	 * @see #setTimeComponent(IfcLocalTime)
	 * @generated
	 */
	void unsetTimeComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDateAndTime#getTimeComponent <em>Time Component</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Component</em>' reference is set.
	 * @see #unsetTimeComponent()
	 * @see #getTimeComponent()
	 * @see #setTimeComponent(IfcLocalTime)
	 * @generated
	 */
	boolean isSetTimeComponent();

} // IfcDateAndTime
