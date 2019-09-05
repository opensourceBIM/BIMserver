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

public interface IfcEventTime extends IfcSchedulingTime {
	/**
	 * Returns the value of the '<em><b>Actual Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Date</em>' attribute.
	 * @see #isSetActualDate()
	 * @see #unsetActualDate()
	 * @see #setActualDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventTime_ActualDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getActualDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getActualDate <em>Actual Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Date</em>' attribute.
	 * @see #isSetActualDate()
	 * @see #unsetActualDate()
	 * @see #getActualDate()
	 * @generated
	 */
	void setActualDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getActualDate <em>Actual Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActualDate()
	 * @see #getActualDate()
	 * @see #setActualDate(String)
	 * @generated
	 */
	void unsetActualDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getActualDate <em>Actual Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actual Date</em>' attribute is set.
	 * @see #unsetActualDate()
	 * @see #getActualDate()
	 * @see #setActualDate(String)
	 * @generated
	 */
	boolean isSetActualDate();

	/**
	 * Returns the value of the '<em><b>Early Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Early Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Early Date</em>' attribute.
	 * @see #isSetEarlyDate()
	 * @see #unsetEarlyDate()
	 * @see #setEarlyDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventTime_EarlyDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getEarlyDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getEarlyDate <em>Early Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Early Date</em>' attribute.
	 * @see #isSetEarlyDate()
	 * @see #unsetEarlyDate()
	 * @see #getEarlyDate()
	 * @generated
	 */
	void setEarlyDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getEarlyDate <em>Early Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEarlyDate()
	 * @see #getEarlyDate()
	 * @see #setEarlyDate(String)
	 * @generated
	 */
	void unsetEarlyDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getEarlyDate <em>Early Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Early Date</em>' attribute is set.
	 * @see #unsetEarlyDate()
	 * @see #getEarlyDate()
	 * @see #setEarlyDate(String)
	 * @generated
	 */
	boolean isSetEarlyDate();

	/**
	 * Returns the value of the '<em><b>Late Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Late Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Late Date</em>' attribute.
	 * @see #isSetLateDate()
	 * @see #unsetLateDate()
	 * @see #setLateDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventTime_LateDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLateDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getLateDate <em>Late Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Late Date</em>' attribute.
	 * @see #isSetLateDate()
	 * @see #unsetLateDate()
	 * @see #getLateDate()
	 * @generated
	 */
	void setLateDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getLateDate <em>Late Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLateDate()
	 * @see #getLateDate()
	 * @see #setLateDate(String)
	 * @generated
	 */
	void unsetLateDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getLateDate <em>Late Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Late Date</em>' attribute is set.
	 * @see #unsetLateDate()
	 * @see #getLateDate()
	 * @see #setLateDate(String)
	 * @generated
	 */
	boolean isSetLateDate();

	/**
	 * Returns the value of the '<em><b>Schedule Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule Date</em>' attribute.
	 * @see #isSetScheduleDate()
	 * @see #unsetScheduleDate()
	 * @see #setScheduleDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventTime_ScheduleDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScheduleDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getScheduleDate <em>Schedule Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Date</em>' attribute.
	 * @see #isSetScheduleDate()
	 * @see #unsetScheduleDate()
	 * @see #getScheduleDate()
	 * @generated
	 */
	void setScheduleDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getScheduleDate <em>Schedule Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduleDate()
	 * @see #getScheduleDate()
	 * @see #setScheduleDate(String)
	 * @generated
	 */
	void unsetScheduleDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEventTime#getScheduleDate <em>Schedule Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schedule Date</em>' attribute is set.
	 * @see #unsetScheduleDate()
	 * @see #getScheduleDate()
	 * @see #setScheduleDate(String)
	 * @generated
	 */
	boolean isSetScheduleDate();

} // IfcEventTime
