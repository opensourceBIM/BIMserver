/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessX <em>Linear Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessY <em>Linear Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessZ <em>Linear Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessX <em>Rotational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBoundaryNodeConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryNodeCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryNodeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessX() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessX(double newLinearStiffnessX) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_X, newLinearStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessX() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessX() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessXAsString(String newLinearStiffnessXAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_XAS_STRING, newLinearStiffnessXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessXAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessXAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessY() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessY(double newLinearStiffnessY) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Y, newLinearStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessY() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessY() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessYAsString(String newLinearStiffnessYAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_YAS_STRING, newLinearStiffnessYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessYAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessYAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessZ() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessZ(double newLinearStiffnessZ) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Z, newLinearStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessZ() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessZ() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessZAsString(String newLinearStiffnessZAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_ZAS_STRING, newLinearStiffnessZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessZAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessZAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__LINEAR_STIFFNESS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessX() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessX(double newRotationalStiffnessX) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X, newRotationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessX() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessX() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessXAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessXAsString(String newRotationalStiffnessXAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_XAS_STRING, newRotationalStiffnessXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessXAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessXAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessY() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessY(double newRotationalStiffnessY) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y, newRotationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessY() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessY() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessYAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessYAsString(String newRotationalStiffnessYAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_YAS_STRING, newRotationalStiffnessYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessYAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessYAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessZ() {
		return (Double) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessZ(double newRotationalStiffnessZ) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z, newRotationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessZ() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessZ() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessZAsString() {
		return (String) eGet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessZAsString(String newRotationalStiffnessZAsString) {
		eSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_ZAS_STRING, newRotationalStiffnessZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessZAsString() {
		eUnset(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessZAsString() {
		return eIsSet(LogPackage.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_ZAS_STRING);
	}

} //IfcBoundaryNodeConditionImpl
