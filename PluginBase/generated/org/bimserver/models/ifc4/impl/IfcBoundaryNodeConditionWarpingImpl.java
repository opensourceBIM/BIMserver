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
import org.bimserver.models.ifc4.IfcBoundaryNodeConditionWarping;
import org.bimserver.models.ifc4.IfcWarpingStiffnessSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition Warping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryNodeConditionWarpingImpl#getWarpingStiffness <em>Warping Stiffness</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundaryNodeConditionWarpingImpl extends IfcBoundaryNodeConditionImpl implements IfcBoundaryNodeConditionWarping {
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
		return Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWarpingStiffnessSelect getWarpingStiffness() {
		return (IfcWarpingStiffnessSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarpingStiffness(IfcWarpingStiffnessSelect newWarpingStiffness) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS, newWarpingStiffness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWarpingStiffness() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWarpingStiffness() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_NODE_CONDITION_WARPING__WARPING_STIFFNESS);
	}

} //IfcBoundaryNodeConditionWarpingImpl
