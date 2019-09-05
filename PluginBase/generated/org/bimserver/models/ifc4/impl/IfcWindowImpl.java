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
import org.bimserver.models.ifc4.IfcWindow;
import org.bimserver.models.ifc4.IfcWindowTypeEnum;
import org.bimserver.models.ifc4.IfcWindowTypePartitioningEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getOverallHeight <em>Overall Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getOverallHeightAsString <em>Overall Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getOverallWidth <em>Overall Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getOverallWidthAsString <em>Overall Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getPartitioningType <em>Partitioning Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcWindowImpl#getUserDefinedPartitioningType <em>User Defined Partitioning Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWindowImpl extends IfcBuildingElementImpl implements IfcWindow {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_WINDOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallHeight() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallHeight(double newOverallHeight) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT, newOverallHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallHeight() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallHeight() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallHeightAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallHeightAsString(String newOverallHeightAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT_AS_STRING, newOverallHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallHeightAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallHeightAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getOverallWidth() {
		return (Double) eGet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidth(double newOverallWidth) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH, newOverallWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallWidth() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallWidth() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOverallWidthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverallWidthAsString(String newOverallWidthAsString) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH_AS_STRING, newOverallWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOverallWidthAsString() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOverallWidthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__OVERALL_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowTypeEnum getPredefinedType() {
		return (IfcWindowTypeEnum) eGet(Ifc4Package.Literals.IFC_WINDOW__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcWindowTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowTypePartitioningEnum getPartitioningType() {
		return (IfcWindowTypePartitioningEnum) eGet(Ifc4Package.Literals.IFC_WINDOW__PARTITIONING_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartitioningType(IfcWindowTypePartitioningEnum newPartitioningType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__PARTITIONING_TYPE, newPartitioningType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPartitioningType() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__PARTITIONING_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPartitioningType() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__PARTITIONING_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDefinedPartitioningType() {
		return (String) eGet(Ifc4Package.Literals.IFC_WINDOW__USER_DEFINED_PARTITIONING_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDefinedPartitioningType(String newUserDefinedPartitioningType) {
		eSet(Ifc4Package.Literals.IFC_WINDOW__USER_DEFINED_PARTITIONING_TYPE, newUserDefinedPartitioningType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUserDefinedPartitioningType() {
		eUnset(Ifc4Package.Literals.IFC_WINDOW__USER_DEFINED_PARTITIONING_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUserDefinedPartitioningType() {
		return eIsSet(Ifc4Package.Literals.IFC_WINDOW__USER_DEFINED_PARTITIONING_TYPE);
	}

} //IfcWindowImpl
