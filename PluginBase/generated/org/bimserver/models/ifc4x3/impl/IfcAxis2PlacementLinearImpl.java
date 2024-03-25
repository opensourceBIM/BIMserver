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
import org.bimserver.models.ifc4x3.IfcAxis2PlacementLinear;
import org.bimserver.models.ifc4x3.IfcDirection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Axis2 Placement Linear</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAxis2PlacementLinearImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAxis2PlacementLinearImpl#getRefDirection <em>Ref Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAxis2PlacementLinearImpl extends IfcPlacementImpl implements IfcAxis2PlacementLinear {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAxis2PlacementLinearImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getAxis() {
		return (IfcDirection) eGet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__AXIS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis(IfcDirection newAxis) {
		eSet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__AXIS, newAxis);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAxis() {
		eUnset(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__AXIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAxis() {
		return eIsSet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__AXIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection getRefDirection() {
		return (IfcDirection) eGet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__REF_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefDirection(IfcDirection newRefDirection) {
		eSet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__REF_DIRECTION, newRefDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRefDirection() {
		eUnset(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__REF_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRefDirection() {
		return eIsSet(Ifc4x3Package.Literals.IFC_AXIS2_PLACEMENT_LINEAR__REF_DIRECTION);
	}

} //IfcAxis2PlacementLinearImpl
