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
import org.bimserver.models.ifc4.IfcBoundaryEdgeCondition;
import org.bimserver.models.ifc4.IfcModulusOfRotationalSubgradeReactionSelect;
import org.bimserver.models.ifc4.IfcModulusOfTranslationalSubgradeReactionSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Edge Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getTranslationalStiffnessByLengthX <em>Translational Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getTranslationalStiffnessByLengthY <em>Translational Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getTranslationalStiffnessByLengthZ <em>Translational Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}</li>
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
		return Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthX() {
		return (IfcModulusOfTranslationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect newTranslationalStiffnessByLengthX) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_X, newTranslationalStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByLengthX() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByLengthX() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthY() {
		return (IfcModulusOfTranslationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect newTranslationalStiffnessByLengthY) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Y, newTranslationalStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByLengthY() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByLengthY() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthZ() {
		return (IfcModulusOfTranslationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect newTranslationalStiffnessByLengthZ) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Z, newTranslationalStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByLengthZ() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByLengthZ() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthX() {
		return (IfcModulusOfRotationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect newRotationalStiffnessByLengthX) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X, newRotationalStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessByLengthX() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessByLengthX() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthY() {
		return (IfcModulusOfRotationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect newRotationalStiffnessByLengthY) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y, newRotationalStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessByLengthY() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessByLengthY() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthZ() {
		return (IfcModulusOfRotationalSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect newRotationalStiffnessByLengthZ) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z, newRotationalStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessByLengthZ() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessByLengthZ() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_EDGE_CONDITION__ROTATIONAL_STIFFNESS_BY_LENGTH_Z);
	}

} //IfcBoundaryEdgeConditionImpl
