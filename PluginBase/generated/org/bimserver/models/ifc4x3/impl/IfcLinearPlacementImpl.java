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
import org.bimserver.models.ifc4x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc4x3.IfcAxis2PlacementLinear;
import org.bimserver.models.ifc4x3.IfcLinearPlacement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Linear Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLinearPlacementImpl#getRelativePlacement <em>Relative Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLinearPlacementImpl#getCartesianPosition <em>Cartesian Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLinearPlacementImpl extends IfcObjectPlacementImpl implements IfcLinearPlacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLinearPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2PlacementLinear getRelativePlacement() {
		return (IfcAxis2PlacementLinear) eGet(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__RELATIVE_PLACEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelativePlacement(IfcAxis2PlacementLinear newRelativePlacement) {
		eSet(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__RELATIVE_PLACEMENT, newRelativePlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement3D getCartesianPosition() {
		return (IfcAxis2Placement3D) eGet(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__CARTESIAN_POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCartesianPosition(IfcAxis2Placement3D newCartesianPosition) {
		eSet(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__CARTESIAN_POSITION, newCartesianPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCartesianPosition() {
		eUnset(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__CARTESIAN_POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCartesianPosition() {
		return eIsSet(Ifc4x3Package.Literals.IFC_LINEAR_PLACEMENT__CARTESIAN_POSITION);
	}

} //IfcLinearPlacementImpl
