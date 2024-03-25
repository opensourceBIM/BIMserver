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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcEvent;
import org.bimserver.models.ifc4x3.IfcEventTime;
import org.bimserver.models.ifc4x3.IfcEventTriggerTypeEnum;
import org.bimserver.models.ifc4x3.IfcEventTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcEventImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcEventImpl#getEventTriggerType <em>Event Trigger Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcEventImpl#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcEventImpl#getEventOccurenceTime <em>Event Occurence Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcEventImpl extends IfcProcessImpl implements IfcEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTypeEnum getPredefinedType() {
		return (IfcEventTypeEnum) eGet(Ifc4x3Package.Literals.IFC_EVENT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcEventTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_EVENT__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.Literals.IFC_EVENT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_EVENT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTriggerTypeEnum getEventTriggerType() {
		return (IfcEventTriggerTypeEnum) eGet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_TRIGGER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventTriggerType(IfcEventTriggerTypeEnum newEventTriggerType) {
		eSet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_TRIGGER_TYPE, newEventTriggerType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEventTriggerType() {
		eUnset(Ifc4x3Package.Literals.IFC_EVENT__EVENT_TRIGGER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEventTriggerType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_TRIGGER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedEventTriggerType() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_EVENT__USER_DEFINED_EVENT_TRIGGER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedEventTriggerType(String newUserDefinedEventTriggerType) {
		eSet(Ifc4x3Package.Literals.IFC_EVENT__USER_DEFINED_EVENT_TRIGGER_TYPE, newUserDefinedEventTriggerType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedEventTriggerType() {
		eUnset(Ifc4x3Package.Literals.IFC_EVENT__USER_DEFINED_EVENT_TRIGGER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedEventTriggerType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_EVENT__USER_DEFINED_EVENT_TRIGGER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTime getEventOccurenceTime() {
		return (IfcEventTime) eGet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_OCCURENCE_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventOccurenceTime(IfcEventTime newEventOccurenceTime) {
		eSet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_OCCURENCE_TIME, newEventOccurenceTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEventOccurenceTime() {
		eUnset(Ifc4x3Package.Literals.IFC_EVENT__EVENT_OCCURENCE_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEventOccurenceTime() {
		return eIsSet(Ifc4x3Package.Literals.IFC_EVENT__EVENT_OCCURENCE_TIME);
	}

} //IfcEventImpl
