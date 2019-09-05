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

public interface IfcEventType extends IfcTypeProcess {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcEventTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTypeEnum
	 * @see #setPredefinedType(IfcEventTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcEventTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcEventTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Event Trigger Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcEventTriggerTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Trigger Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTriggerTypeEnum
	 * @see #setEventTriggerType(IfcEventTriggerTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventType_EventTriggerType()
	 * @model
	 * @generated
	 */
	IfcEventTriggerTypeEnum getEventTriggerType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventType#getEventTriggerType <em>Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Trigger Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTriggerTypeEnum
	 * @see #getEventTriggerType()
	 * @generated
	 */
	void setEventTriggerType(IfcEventTriggerTypeEnum value);

	/**
	 * Returns the value of the '<em><b>User Defined Event Trigger Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Event Trigger Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Event Trigger Type</em>' attribute.
	 * @see #isSetUserDefinedEventTriggerType()
	 * @see #unsetUserDefinedEventTriggerType()
	 * @see #setUserDefinedEventTriggerType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEventType_UserDefinedEventTriggerType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedEventTriggerType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEventType#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Event Trigger Type</em>' attribute.
	 * @see #isSetUserDefinedEventTriggerType()
	 * @see #unsetUserDefinedEventTriggerType()
	 * @see #getUserDefinedEventTriggerType()
	 * @generated
	 */
	void setUserDefinedEventTriggerType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEventType#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedEventTriggerType()
	 * @see #getUserDefinedEventTriggerType()
	 * @see #setUserDefinedEventTriggerType(String)
	 * @generated
	 */
	void unsetUserDefinedEventTriggerType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEventType#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Event Trigger Type</em>' attribute is set.
	 * @see #unsetUserDefinedEventTriggerType()
	 * @see #getUserDefinedEventTriggerType()
	 * @see #setUserDefinedEventTriggerType(String)
	 * @generated
	 */
	boolean isSetUserDefinedEventTriggerType();

} // IfcEventType
