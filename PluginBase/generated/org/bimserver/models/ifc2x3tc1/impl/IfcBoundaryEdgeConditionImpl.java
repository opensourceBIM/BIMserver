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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcBoundaryEdgeCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Edge Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundaryEdgeConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryEdgeCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryEdgeConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByLengthX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthX(double newLinearStiffnessByLengthX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_X,
				newLinearStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthXAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthXAsString(String newLinearStiffnessByLengthXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_XAS_STRING,
				newLinearStiffnessByLengthXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByLengthY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthY(double newLinearStiffnessByLengthY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Y,
				newLinearStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthYAsString(String newLinearStiffnessByLengthYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_YAS_STRING,
				newLinearStiffnessByLengthYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByLengthZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthZ(double newLinearStiffnessByLengthZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Z,
				newLinearStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthZAsString(String newLinearStiffnessByLengthZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_ZAS_STRING,
				newLinearStiffnessByLengthZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__LINEAR_STIFFNESS_BY_LENGTH_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessByLengthX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthX(double newRotationalStiffnessByLengthX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X,
				newRotationalStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthXAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthXAsString(String newRotationalStiffnessByLengthXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_XAS_STRING,
				newRotationalStiffnessByLengthXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessByLengthY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthY(double newRotationalStiffnessByLengthY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y,
				newRotationalStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthYAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthYAsString(String newRotationalStiffnessByLengthYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_YAS_STRING,
				newRotationalStiffnessByLengthYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRotationalStiffnessByLengthZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthZ(double newRotationalStiffnessByLengthZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z,
				newRotationalStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthZAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthZAsString(String newRotationalStiffnessByLengthZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_ZAS_STRING,
				newRotationalStiffnessByLengthZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_ZAS_STRING);
	}

} //IfcBoundaryEdgeConditionImpl
