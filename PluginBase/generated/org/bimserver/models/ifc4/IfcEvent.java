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

public interface IfcEvent extends IfcProcess {
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
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcEventTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEvent_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcEventTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcEventTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcEventTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcEventTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

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
	 * @see #isSetEventTriggerType()
	 * @see #unsetEventTriggerType()
	 * @see #setEventTriggerType(IfcEventTriggerTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEvent_EventTriggerType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcEventTriggerTypeEnum getEventTriggerType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventTriggerType <em>Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Trigger Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcEventTriggerTypeEnum
	 * @see #isSetEventTriggerType()
	 * @see #unsetEventTriggerType()
	 * @see #getEventTriggerType()
	 * @generated
	 */
	void setEventTriggerType(IfcEventTriggerTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventTriggerType <em>Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEventTriggerType()
	 * @see #getEventTriggerType()
	 * @see #setEventTriggerType(IfcEventTriggerTypeEnum)
	 * @generated
	 */
	void unsetEventTriggerType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventTriggerType <em>Event Trigger Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Event Trigger Type</em>' attribute is set.
	 * @see #unsetEventTriggerType()
	 * @see #getEventTriggerType()
	 * @see #setEventTriggerType(IfcEventTriggerTypeEnum)
	 * @generated
	 */
	boolean isSetEventTriggerType();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEvent_UserDefinedEventTriggerType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedEventTriggerType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedEventTriggerType()
	 * @see #getUserDefinedEventTriggerType()
	 * @see #setUserDefinedEventTriggerType(String)
	 * @generated
	 */
	void unsetUserDefinedEventTriggerType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Event Trigger Type</em>' attribute is set.
	 * @see #unsetUserDefinedEventTriggerType()
	 * @see #getUserDefinedEventTriggerType()
	 * @see #setUserDefinedEventTriggerType(String)
	 * @generated
	 */
	boolean isSetUserDefinedEventTriggerType();

	/**
	 * Returns the value of the '<em><b>Event Occurence Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Occurence Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Occurence Time</em>' reference.
	 * @see #isSetEventOccurenceTime()
	 * @see #unsetEventOccurenceTime()
	 * @see #setEventOccurenceTime(IfcEventTime)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEvent_EventOccurenceTime()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcEventTime getEventOccurenceTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventOccurenceTime <em>Event Occurence Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Occurence Time</em>' reference.
	 * @see #isSetEventOccurenceTime()
	 * @see #unsetEventOccurenceTime()
	 * @see #getEventOccurenceTime()
	 * @generated
	 */
	void setEventOccurenceTime(IfcEventTime value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventOccurenceTime <em>Event Occurence Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEventOccurenceTime()
	 * @see #getEventOccurenceTime()
	 * @see #setEventOccurenceTime(IfcEventTime)
	 * @generated
	 */
	void unsetEventOccurenceTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEvent#getEventOccurenceTime <em>Event Occurence Time</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Event Occurence Time</em>' reference is set.
	 * @see #unsetEventOccurenceTime()
	 * @see #getEventOccurenceTime()
	 * @see #setEventOccurenceTime(IfcEventTime)
	 * @generated
	 */
	boolean isSetEventOccurenceTime();

} // IfcEvent
