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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcObjectPlacement;
import org.bimserver.models.ifc4x3.IfcProduct;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Object Placement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectPlacementImpl#getPlacementRelTo <em>Placement Rel To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectPlacementImpl#getPlacesObject <em>Places Object</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcObjectPlacementImpl#getReferencedByPlacements <em>Referenced By Placements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcObjectPlacementImpl extends IdEObjectImpl implements IfcObjectPlacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcObjectPlacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcObjectPlacement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectPlacement getPlacementRelTo() {
		return (IfcObjectPlacement) eGet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacementRelTo(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPlacementRelTo(IfcObjectPlacement newPlacementRelTo) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacementRelTo(), newPlacementRelTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlacementRelTo() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacementRelTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlacementRelTo() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacementRelTo());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcProduct> getPlacesObject() {
		return (EList<IfcProduct>) eGet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacesObject(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPlacesObject() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacesObject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPlacesObject() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_PlacesObject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcObjectPlacement> getReferencedByPlacements() {
		return (EList<IfcObjectPlacement>) eGet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_ReferencedByPlacements(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedByPlacements() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_ReferencedByPlacements());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedByPlacements() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcObjectPlacement_ReferencedByPlacements());
	}

} //IfcObjectPlacementImpl
