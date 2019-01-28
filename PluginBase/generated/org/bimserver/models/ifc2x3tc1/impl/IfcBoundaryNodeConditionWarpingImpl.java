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
import org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeConditionWarping;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionWarpingImpl#getWarpingStiffness <em>Warping Stiffness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryNodeConditionWarpingImpl#getWarpingStiffnessAsString <em>Warping Stiffness As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundaryNodeConditionWarpingImpl extends IfcBoundaryNodeConditionImpl
		implements IfcBoundaryNodeConditionWarping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryNodeConditionWarpingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWarpingStiffness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingStiffness(double newWarpingStiffness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS, newWarpingStiffness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingStiffness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingStiffness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarpingStiffnessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingStiffnessAsString(String newWarpingStiffnessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS_AS_STRING,
				newWarpingStiffnessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingStiffnessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingStiffnessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS_AS_STRING);
	}

} //IfcBoundaryNodeConditionWarpingImpl
