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
import org.bimserver.models.ifc4.IfcDoor;
import org.bimserver.models.ifc4.IfcDoorTypeEnum;
import org.bimserver.models.ifc4.IfcDoorTypeOperationEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Door</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDoorImpl#getUserDefinedOperationType <em>User Defined Operation Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDoorImpl extends IfcBuildingElementImpl implements IfcDoor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDoorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DOOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallHeight() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallHeight(double newOverallHeight) {
		eSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT, newOverallHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallHeight() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallHeight() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallHeightAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallHeightAsString(String newOverallHeightAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT_AS_STRING, newOverallHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallHeightAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallHeightAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidth(double newOverallWidth) {
		eSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH, newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallWidth() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidthAsString(String newOverallWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH_AS_STRING, newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallWidthAsString() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallWidthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__OVERALL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorTypeEnum getPredefinedType() {
		return (IfcDoorTypeEnum) eGet(Ifc4Package.Literals.IFC_DOOR__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcDoorTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_DOOR__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorTypeOperationEnum getOperationType() {
		return (IfcDoorTypeOperationEnum) eGet(Ifc4Package.Literals.IFC_DOOR__OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationType(IfcDoorTypeOperationEnum newOperationType) {
		eSet(Ifc4Package.Literals.IFC_DOOR__OPERATION_TYPE, newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOperationType() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__OPERATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOperationType() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__OPERATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedOperationType() {
		return (String) eGet(Ifc4Package.Literals.IFC_DOOR__USER_DEFINED_OPERATION_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedOperationType(String newUserDefinedOperationType) {
		eSet(Ifc4Package.Literals.IFC_DOOR__USER_DEFINED_OPERATION_TYPE, newUserDefinedOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedOperationType() {
		eUnset(Ifc4Package.Literals.IFC_DOOR__USER_DEFINED_OPERATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedOperationType() {
		return eIsSet(Ifc4Package.Literals.IFC_DOOR__USER_DEFINED_OPERATION_TYPE);
	}

} //IfcDoorImpl
