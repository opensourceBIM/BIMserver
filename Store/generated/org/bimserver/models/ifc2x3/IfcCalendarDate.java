/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
public interface IfcCalendarDate extends IfcDateTimeSelect, IfcObjectReferenceSelect
{
	/**
	 * Returns the value of the '<em><b>Day Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Component</em>' attribute.
	 * @see #setDayComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_DayComponent()
	 * @model
	 * @generated
	 */
	int getDayComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getDayComponent <em>Day Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Component</em>' attribute.
	 * @see #getDayComponent()
	 * @generated
	 */
	void setDayComponent(int value);

	/**
	 * Returns the value of the '<em><b>Month Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month Component</em>' attribute.
	 * @see #setMonthComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_MonthComponent()
	 * @model
	 * @generated
	 */
	int getMonthComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getMonthComponent <em>Month Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month Component</em>' attribute.
	 * @see #getMonthComponent()
	 * @generated
	 */
	void setMonthComponent(int value);

	/**
	 * Returns the value of the '<em><b>Year Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year Component</em>' attribute.
	 * @see #setYearComponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCalendarDate_YearComponent()
	 * @model
	 * @generated
	 */
	int getYearComponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCalendarDate#getYearComponent <em>Year Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year Component</em>' attribute.
	 * @see #getYearComponent()
	 * @generated
	 */
	void setYearComponent(int value);

} // IfcCalendarDate
