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
import org.bimserver.models.ifc4x3.IfcDoorType;
import org.bimserver.models.ifc4x3.IfcDoorTypeEnum;
import org.bimserver.models.ifc4x3.IfcDoorTypeOperationEnum;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorTypeImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorTypeImpl#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcDoorTypeImpl#getUserDefinedOperationType <em>User Defined Operation Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorTypeImpl extends IfcBuiltElementTypeImpl implements IfcDoorType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_DOOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorTypeEnum getPredefinedType() {
		return (IfcDoorTypeEnum) eGet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcDoorTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorTypeOperationEnum getOperationType() {
		return (IfcDoorTypeOperationEnum) eGet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationType(IfcDoorTypeOperationEnum newOperationType) {
		eSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__OPERATION_TYPE, newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getParameterTakesPrecedence() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PARAMETER_TAKES_PRECEDENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameterTakesPrecedence(Tristate newParameterTakesPrecedence) {
		eSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PARAMETER_TAKES_PRECEDENCE, newParameterTakesPrecedence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetParameterTakesPrecedence() {
		eUnset(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PARAMETER_TAKES_PRECEDENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetParameterTakesPrecedence() {
		return eIsSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__PARAMETER_TAKES_PRECEDENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedOperationType() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__USER_DEFINED_OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedOperationType(String newUserDefinedOperationType) {
		eSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__USER_DEFINED_OPERATION_TYPE, newUserDefinedOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedOperationType() {
		eUnset(Ifc4x3Package.Literals.IFC_DOOR_TYPE__USER_DEFINED_OPERATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedOperationType() {
		return eIsSet(Ifc4x3Package.Literals.IFC_DOOR_TYPE__USER_DEFINED_OPERATION_TYPE);
	}

} //IfcDoorTypeImpl
