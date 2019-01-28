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
 * A representation of the model object '<em><b>Ifc Work Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDurationAsString <em>Duration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloatAsString <em>Total Float As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getFinishTime <em>Finish Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getWorkControlType <em>Work Control Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getUserDefinedControlType <em>User Defined Control Type</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl()
 * @model
 * @generated
 */
public interface IfcWorkControl extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' reference.
	 * @see #setCreationDate(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_CreationDate()
	 * @model
	 * @generated
	 */
	IfcDateTimeSelect getCreationDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getCreationDate <em>Creation Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' reference.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(IfcDateTimeSelect value);

	/**
	 * Returns the value of the '<em><b>Creators</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcPerson}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creators</em>' reference list.
	 * @see #isSetCreators()
	 * @see #unsetCreators()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_Creators()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPerson> getCreators();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getCreators <em>Creators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreators()
	 * @see #getCreators()
	 * @generated
	 */
	void unsetCreators();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getCreators <em>Creators</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creators</em>' reference list is set.
	 * @see #unsetCreators()
	 * @see #getCreators()
	 * @generated
	 */
	boolean isSetCreators();

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #setPurpose(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_Purpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	void unsetPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Purpose</em>' attribute is set.
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	boolean isSetPurpose();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #setDuration(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_Duration()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	boolean isSetDuration();

	/**
	 * Returns the value of the '<em><b>Duration As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration As String</em>' attribute.
	 * @see #isSetDurationAsString()
	 * @see #unsetDurationAsString()
	 * @see #setDurationAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_DurationAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDurationAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDurationAsString <em>Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration As String</em>' attribute.
	 * @see #isSetDurationAsString()
	 * @see #unsetDurationAsString()
	 * @see #getDurationAsString()
	 * @generated
	 */
	void setDurationAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDurationAsString <em>Duration As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDurationAsString()
	 * @see #getDurationAsString()
	 * @see #setDurationAsString(String)
	 * @generated
	 */
	void unsetDurationAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getDurationAsString <em>Duration As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration As String</em>' attribute is set.
	 * @see #unsetDurationAsString()
	 * @see #getDurationAsString()
	 * @see #setDurationAsString(String)
	 * @generated
	 */
	boolean isSetDurationAsString();

	/**
	 * Returns the value of the '<em><b>Total Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #setTotalFloat(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_TotalFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTotalFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @generated
	 */
	void setTotalFloat(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(double)
	 * @generated
	 */
	void unsetTotalFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float</em>' attribute is set.
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(double)
	 * @generated
	 */
	boolean isSetTotalFloat();

	/**
	 * Returns the value of the '<em><b>Total Float As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Float As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Float As String</em>' attribute.
	 * @see #isSetTotalFloatAsString()
	 * @see #unsetTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_TotalFloatAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTotalFloatAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float As String</em>' attribute.
	 * @see #isSetTotalFloatAsString()
	 * @see #unsetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @generated
	 */
	void setTotalFloatAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @generated
	 */
	void unsetTotalFloatAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getTotalFloatAsString <em>Total Float As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float As String</em>' attribute is set.
	 * @see #unsetTotalFloatAsString()
	 * @see #getTotalFloatAsString()
	 * @see #setTotalFloatAsString(String)
	 * @generated
	 */
	boolean isSetTotalFloatAsString();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' reference.
	 * @see #setStartTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_StartTime()
	 * @model
	 * @generated
	 */
	IfcDateTimeSelect getStartTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getStartTime <em>Start Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' reference.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(IfcDateTimeSelect value);

	/**
	 * Returns the value of the '<em><b>Finish Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Time</em>' reference.
	 * @see #isSetFinishTime()
	 * @see #unsetFinishTime()
	 * @see #setFinishTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_FinishTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDateTimeSelect getFinishTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getFinishTime <em>Finish Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Time</em>' reference.
	 * @see #isSetFinishTime()
	 * @see #unsetFinishTime()
	 * @see #getFinishTime()
	 * @generated
	 */
	void setFinishTime(IfcDateTimeSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getFinishTime <em>Finish Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinishTime()
	 * @see #getFinishTime()
	 * @see #setFinishTime(IfcDateTimeSelect)
	 * @generated
	 */
	void unsetFinishTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getFinishTime <em>Finish Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish Time</em>' reference is set.
	 * @see #unsetFinishTime()
	 * @see #getFinishTime()
	 * @see #setFinishTime(IfcDateTimeSelect)
	 * @generated
	 */
	boolean isSetFinishTime();

	/**
	 * Returns the value of the '<em><b>Work Control Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcWorkControlTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Control Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Control Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcWorkControlTypeEnum
	 * @see #isSetWorkControlType()
	 * @see #unsetWorkControlType()
	 * @see #setWorkControlType(IfcWorkControlTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_WorkControlType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcWorkControlTypeEnum getWorkControlType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getWorkControlType <em>Work Control Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Control Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcWorkControlTypeEnum
	 * @see #isSetWorkControlType()
	 * @see #unsetWorkControlType()
	 * @see #getWorkControlType()
	 * @generated
	 */
	void setWorkControlType(IfcWorkControlTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getWorkControlType <em>Work Control Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWorkControlType()
	 * @see #getWorkControlType()
	 * @see #setWorkControlType(IfcWorkControlTypeEnum)
	 * @generated
	 */
	void unsetWorkControlType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getWorkControlType <em>Work Control Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Work Control Type</em>' attribute is set.
	 * @see #unsetWorkControlType()
	 * @see #getWorkControlType()
	 * @see #setWorkControlType(IfcWorkControlTypeEnum)
	 * @generated
	 */
	boolean isSetWorkControlType();

	/**
	 * Returns the value of the '<em><b>User Defined Control Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Control Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Control Type</em>' attribute.
	 * @see #isSetUserDefinedControlType()
	 * @see #unsetUserDefinedControlType()
	 * @see #setUserDefinedControlType(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWorkControl_UserDefinedControlType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedControlType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getUserDefinedControlType <em>User Defined Control Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Control Type</em>' attribute.
	 * @see #isSetUserDefinedControlType()
	 * @see #unsetUserDefinedControlType()
	 * @see #getUserDefinedControlType()
	 * @generated
	 */
	void setUserDefinedControlType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getUserDefinedControlType <em>User Defined Control Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedControlType()
	 * @see #getUserDefinedControlType()
	 * @see #setUserDefinedControlType(String)
	 * @generated
	 */
	void unsetUserDefinedControlType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcWorkControl#getUserDefinedControlType <em>User Defined Control Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Control Type</em>' attribute is set.
	 * @see #unsetUserDefinedControlType()
	 * @see #getUserDefinedControlType()
	 * @see #setUserDefinedControlType(String)
	 * @generated
	 */
	boolean isSetUserDefinedControlType();

} // IfcWorkControl
