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
 * A representation of the model object '<em><b>Ifc Calendar Date</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getDayComponent <em>Day Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getMonthComponent <em>Month Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getYearComponent <em>Year Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate()
 * @model
 * @generated
 */
public interface IfcCalendarDate extends IfcDateTimeSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Day Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Component</em>' attribute.
	 * @see #isSetDayComponent()
	 * @see #unsetDayComponent()
	 * @see #setDayComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_DayComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getDayComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getDayComponent <em>Day Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Component</em>' attribute.
	 * @see #isSetDayComponent()
	 * @see #unsetDayComponent()
	 * @see #getDayComponent()
	 * @generated
	 */
	void setDayComponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getDayComponent <em>Day Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDayComponent()
	 * @see #getDayComponent()
	 * @see #setDayComponent(int)
	 * @generated
	 */
	void unsetDayComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getDayComponent <em>Day Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Day Component</em>' attribute is set.
	 * @see #unsetDayComponent()
	 * @see #getDayComponent()
	 * @see #setDayComponent(int)
	 * @generated
	 */
	boolean isSetDayComponent();

	/**
	 * Returns the value of the '<em><b>Month Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month Component</em>' attribute.
	 * @see #isSetMonthComponent()
	 * @see #unsetMonthComponent()
	 * @see #setMonthComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_MonthComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMonthComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getMonthComponent <em>Month Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month Component</em>' attribute.
	 * @see #isSetMonthComponent()
	 * @see #unsetMonthComponent()
	 * @see #getMonthComponent()
	 * @generated
	 */
	void setMonthComponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getMonthComponent <em>Month Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMonthComponent()
	 * @see #getMonthComponent()
	 * @see #setMonthComponent(int)
	 * @generated
	 */
	void unsetMonthComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getMonthComponent <em>Month Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Month Component</em>' attribute is set.
	 * @see #unsetMonthComponent()
	 * @see #getMonthComponent()
	 * @see #setMonthComponent(int)
	 * @generated
	 */
	boolean isSetMonthComponent();

	/**
	 * Returns the value of the '<em><b>Year Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year Component</em>' attribute.
	 * @see #isSetYearComponent()
	 * @see #unsetYearComponent()
	 * @see #setYearComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_YearComponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getYearComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getYearComponent <em>Year Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year Component</em>' attribute.
	 * @see #isSetYearComponent()
	 * @see #unsetYearComponent()
	 * @see #getYearComponent()
	 * @generated
	 */
	void setYearComponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getYearComponent <em>Year Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYearComponent()
	 * @see #getYearComponent()
	 * @see #setYearComponent(int)
	 * @generated
	 */
	void unsetYearComponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getYearComponent <em>Year Component</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Year Component</em>' attribute is set.
	 * @see #unsetYearComponent()
	 * @see #getYearComponent()
	 * @see #setYearComponent(int)
	 * @generated
	 */
	boolean isSetYearComponent();

} // IfcCalendarDate
