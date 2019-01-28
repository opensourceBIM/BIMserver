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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Cost Schedule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedBy <em>Submitted By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPreparedBy <em>Prepared By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getTargetUsers <em>Target Users</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getUpdateDate <em>Update Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getID <em>ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule()
 * @model
 * @generated
 */
public interface IfcCostSchedule extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Submitted By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submitted By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submitted By</em>' reference.
	 * @see #isSetSubmittedBy()
	 * @see #unsetSubmittedBy()
	 * @see #setSubmittedBy(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_SubmittedBy()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getSubmittedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedBy <em>Submitted By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submitted By</em>' reference.
	 * @see #isSetSubmittedBy()
	 * @see #unsetSubmittedBy()
	 * @see #getSubmittedBy()
	 * @generated
	 */
	void setSubmittedBy(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedBy <em>Submitted By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubmittedBy()
	 * @see #getSubmittedBy()
	 * @see #setSubmittedBy(IfcActorSelect)
	 * @generated
	 */
	void unsetSubmittedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedBy <em>Submitted By</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Submitted By</em>' reference is set.
	 * @see #unsetSubmittedBy()
	 * @see #getSubmittedBy()
	 * @see #setSubmittedBy(IfcActorSelect)
	 * @generated
	 */
	boolean isSetSubmittedBy();

	/**
	 * Returns the value of the '<em><b>Prepared By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prepared By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prepared By</em>' reference.
	 * @see #isSetPreparedBy()
	 * @see #unsetPreparedBy()
	 * @see #setPreparedBy(IfcActorSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_PreparedBy()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getPreparedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPreparedBy <em>Prepared By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prepared By</em>' reference.
	 * @see #isSetPreparedBy()
	 * @see #unsetPreparedBy()
	 * @see #getPreparedBy()
	 * @generated
	 */
	void setPreparedBy(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPreparedBy <em>Prepared By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPreparedBy()
	 * @see #getPreparedBy()
	 * @see #setPreparedBy(IfcActorSelect)
	 * @generated
	 */
	void unsetPreparedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPreparedBy <em>Prepared By</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Prepared By</em>' reference is set.
	 * @see #unsetPreparedBy()
	 * @see #getPreparedBy()
	 * @see #setPreparedBy(IfcActorSelect)
	 * @generated
	 */
	boolean isSetPreparedBy();

	/**
	 * Returns the value of the '<em><b>Submitted On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submitted On</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submitted On</em>' reference.
	 * @see #isSetSubmittedOn()
	 * @see #unsetSubmittedOn()
	 * @see #setSubmittedOn(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_SubmittedOn()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getSubmittedOn();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submitted On</em>' reference.
	 * @see #isSetSubmittedOn()
	 * @see #unsetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @generated
	 */
	void setSubmittedOn(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @see #setSubmittedOn(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetSubmittedOn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getSubmittedOn <em>Submitted On</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Submitted On</em>' reference is set.
	 * @see #unsetSubmittedOn()
	 * @see #getSubmittedOn()
	 * @see #setSubmittedOn(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetSubmittedOn();

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_Status()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getStatus <em>Status</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getStatus <em>Status</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Target Users</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcActorSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Users</em>' reference list.
	 * @see #isSetTargetUsers()
	 * @see #unsetTargetUsers()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_TargetUsers()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcActorSelect> getTargetUsers();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getTargetUsers <em>Target Users</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTargetUsers()
	 * @see #getTargetUsers()
	 * @generated
	 */
	void unsetTargetUsers();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getTargetUsers <em>Target Users</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target Users</em>' reference list is set.
	 * @see #unsetTargetUsers()
	 * @see #getTargetUsers()
	 * @generated
	 */
	boolean isSetTargetUsers();

	/**
	 * Returns the value of the '<em><b>Update Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Update Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Update Date</em>' reference.
	 * @see #isSetUpdateDate()
	 * @see #unsetUpdateDate()
	 * @see #setUpdateDate(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_UpdateDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getUpdateDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Update Date</em>' reference.
	 * @see #isSetUpdateDate()
	 * @see #unsetUpdateDate()
	 * @see #getUpdateDate()
	 * @generated
	 */
	void setUpdateDate(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUpdateDate()
	 * @see #getUpdateDate()
	 * @see #setUpdateDate(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetUpdateDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getUpdateDate <em>Update Date</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Update Date</em>' reference is set.
	 * @see #unsetUpdateDate()
	 * @see #getUpdateDate()
	 * @see #setUpdateDate(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetUpdateDate();

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcCostScheduleTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcCostScheduleTypeEnum
	 * @see #setPredefinedType(IfcCostScheduleTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCostSchedule_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcCostScheduleTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcCostSchedule#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcCostScheduleTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcCostScheduleTypeEnum value);

} // IfcCostSchedule
