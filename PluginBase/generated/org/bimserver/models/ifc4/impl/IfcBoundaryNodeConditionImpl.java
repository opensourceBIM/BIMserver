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
import org.bimserver.models.ifc4.IfcBoundaryNodeCondition;
import org.bimserver.models.ifc4.IfcRotationalStiffnessSelect;
import org.bimserver.models.ifc4.IfcTranslationalStiffnessSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessX <em>Translational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessY <em>Translational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getTranslationalStiffnessZ <em>Translational Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessX <em>Rotational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}</li>
 * </ul>
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
		return Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessX() {
		return (IfcTranslationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessX(IfcTranslationalStiffnessSelect newTranslationalStiffnessX) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_X, newTranslationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessX() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessX() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessY() {
		return (IfcTranslationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessY(IfcTranslationalStiffnessSelect newTranslationalStiffnessY) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Y, newTranslationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessY() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessY() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTranslationalStiffnessSelect getTranslationalStiffnessZ() {
		return (IfcTranslationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect newTranslationalStiffnessZ) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Z, newTranslationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessZ() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessZ() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__TRANSLATIONAL_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessX() {
		return (IfcRotationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessX(IfcRotationalStiffnessSelect newRotationalStiffnessX) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X, newRotationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessX() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessX() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessY() {
		return (IfcRotationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessY(IfcRotationalStiffnessSelect newRotationalStiffnessY) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y, newRotationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessY() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessY() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessSelect getRotationalStiffnessZ() {
		return (IfcRotationalStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalStiffnessZ(IfcRotationalStiffnessSelect newRotationalStiffnessZ) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z, newRotationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalStiffnessZ() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalStiffnessZ() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION__ROTATIONAL_STIFFNESS_Z);
	}

} //IfcBoundaryNodeConditionImpl
