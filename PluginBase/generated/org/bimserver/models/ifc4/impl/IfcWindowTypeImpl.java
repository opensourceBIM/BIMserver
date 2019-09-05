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
import org.bimserver.models.ifc4.IfcWindowType;
import org.bimserver.models.ifc4.IfcWindowTypeEnum;
import org.bimserver.models.ifc4.IfcWindowTypePartitioningEnum;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowTypeImpl#getPartitioningType <em>Partitioning Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowTypeImpl#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowTypeImpl#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWindowTypeImpl extends IfcBuildingElementTypeImpl implements IfcWindowType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_WINDOW_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowTypeEnum getPredefinedType() {
		return (IfcWindowTypeEnum) eGet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcWindowTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowTypePartitioningEnum getPartitioningType() {
		return (IfcWindowTypePartitioningEnum) eGet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARTITIONING_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitioningType(IfcWindowTypePartitioningEnum newPartitioningType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARTITIONING_TYPE, newPartitioningType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getParameterTakesPrecedence() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARAMETER_TAKES_PRECEDENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameterTakesPrecedence(Tristate newParameterTakesPrecedence) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARAMETER_TAKES_PRECEDENCE, newParameterTakesPrecedence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetParameterTakesPrecedence() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARAMETER_TAKES_PRECEDENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetParameterTakesPrecedence() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__PARAMETER_TAKES_PRECEDENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedPartitioningType() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW_TYPE__USER_DEFINED_PARTITIONING_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedPartitioningType(String newUserDefinedPartitioningType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__USER_DEFINED_PARTITIONING_TYPE, newUserDefinedPartitioningType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedPartitioningType() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW_TYPE__USER_DEFINED_PARTITIONING_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedPartitioningType() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW_TYPE__USER_DEFINED_PARTITIONING_TYPE);
	}

} //IfcWindowTypeImpl
