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
import org.bimserver.models.ifc4x3.IfcGridPlacement;
import org.bimserver.models.ifc4x3.IfcGridPlacementDirectionSelect;
import org.bimserver.models.ifc4x3.IfcVirtualGridIntersection;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridPlacementImpl#getPlacementLocation <em>Placement Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcGridPlacementImpl#getPlacementRefDirection <em>Placement Ref Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGridPlacementImpl extends IfcObjectPlacementImpl implements IfcGridPlacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_GRID_PLACEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVirtualGridIntersection getPlacementLocation() {
		return (IfcVirtualGridIntersection) eGet(Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlacementLocation(IfcVirtualGridIntersection newPlacementLocation) {
		eSet(Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_LOCATION, newPlacementLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGridPlacementDirectionSelect getPlacementRefDirection() {
		return (IfcGridPlacementDirectionSelect) eGet(
				Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_REF_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlacementRefDirection(IfcGridPlacementDirectionSelect newPlacementRefDirection) {
		eSet(Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_REF_DIRECTION, newPlacementRefDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlacementRefDirection() {
		eUnset(Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_REF_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlacementRefDirection() {
		return eIsSet(Ifc4x3Package.Literals.IFC_GRID_PLACEMENT__PLACEMENT_REF_DIRECTION);
	}

} //IfcGridPlacementImpl
