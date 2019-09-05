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

public interface IfcCostSchedule extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcCostScheduleTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcCostScheduleTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcCostScheduleTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCostSchedule_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCostScheduleTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcCostScheduleTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcCostScheduleTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCostScheduleTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcCostScheduleTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #setStatus(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCostSchedule_Status()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getStatus <em>Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status</em>' attribute is set.
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	boolean isSetStatus();

	/**
	 * Returns the value of the '<em><b>Submitted On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submitted On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submitted On</em>' attribute.
	 * @see #isSetSubmittedOn()
	 * @see #unsetSubmittedOn()
	 * @see #setSubmittedOn(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCostSchedule_SubmittedOn()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSubmittedOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submitted On</em>' attribute.
	 * @see #isSetSubmittedOn()
	 * @see #unsetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @generated
	 */
	void setSubmittedOn(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @see #setSubmittedOn(String)
	 * @generated
	 */
	void unsetSubmittedOn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Submitted On</em>' attribute is set.
	 * @see #unsetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @see #setSubmittedOn(String)
	 * @generated
	 */
	boolean isSetSubmittedOn();

	/**
	 * Returns the value of the '<em><b>Update Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Date</em>' attribute.
	 * @see #isSetUpdateDate()
	 * @see #unsetUpdateDate()
	 * @see #setUpdateDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCostSchedule_UpdateDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUpdateDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Date</em>' attribute.
	 * @see #isSetUpdateDate()
	 * @see #unsetUpdateDate()
	 * @see #getUpdateDate()
	 * @generated
	 */
	void setUpdateDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpdateDate()
	 * @see #getUpdateDate()
	 * @see #setUpdateDate(String)
	 * @generated
	 */
	void unsetUpdateDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Update Date</em>' attribute is set.
	 * @see #unsetUpdateDate()
	 * @see #getUpdateDate()
	 * @see #setUpdateDate(String)
	 * @generated
	 */
	boolean isSetUpdateDate();

} // IfcCostSchedule
