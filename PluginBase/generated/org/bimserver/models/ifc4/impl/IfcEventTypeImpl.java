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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcEventTriggerTypeEnum;
import org.bimserver.models.ifc4.IfcEventType;
import org.bimserver.models.ifc4.IfcEventTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Event Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTypeImpl#getEventTriggerType <em>Event Trigger Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcEventTypeImpl#getUserDefinedEventTriggerType <em>User Defined Event Trigger Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcEventTypeImpl extends IfcTypeProcessImpl implements IfcEventType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEventTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_EVENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTypeEnum getPredefinedType() {
		return (IfcEventTypeEnum) eGet(Ifc4Package.Literals.IFC_EVENT_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcEventTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTriggerTypeEnum getEventTriggerType() {
		return (IfcEventTriggerTypeEnum) eGet(Ifc4Package.Literals.IFC_EVENT_TYPE__EVENT_TRIGGER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventTriggerType(IfcEventTriggerTypeEnum newEventTriggerType) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TYPE__EVENT_TRIGGER_TYPE, newEventTriggerType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedEventTriggerType() {
		return (String) eGet(Ifc4Package.Literals.IFC_EVENT_TYPE__USER_DEFINED_EVENT_TRIGGER_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedEventTriggerType(String newUserDefinedEventTriggerType) {
		eSet(Ifc4Package.Literals.IFC_EVENT_TYPE__USER_DEFINED_EVENT_TRIGGER_TYPE, newUserDefinedEventTriggerType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedEventTriggerType() {
		eUnset(Ifc4Package.Literals.IFC_EVENT_TYPE__USER_DEFINED_EVENT_TRIGGER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedEventTriggerType() {
		return eIsSet(Ifc4Package.Literals.IFC_EVENT_TYPE__USER_DEFINED_EVENT_TRIGGER_TYPE);
	}

} //IfcEventTypeImpl
