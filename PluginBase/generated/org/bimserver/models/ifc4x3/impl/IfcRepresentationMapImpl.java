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
import org.bimserver.models.ifc4x3.IfcAxis2Placement;
import org.bimserver.models.ifc4x3.IfcMappedItem;
import org.bimserver.models.ifc4x3.IfcRepresentation;
import org.bimserver.models.ifc4x3.IfcRepresentationMap;
import org.bimserver.models.ifc4x3.IfcShapeAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Representation Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationMapImpl#getMappingOrigin <em>Mapping Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationMapImpl#getMappedRepresentation <em>Mapped Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationMapImpl#getHasShapeAspects <em>Has Shape Aspects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcRepresentationMapImpl#getMapUsage <em>Map Usage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRepresentationMapImpl extends IdEObjectImpl implements IfcRepresentationMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRepresentationMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcRepresentationMap();
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
	public IfcAxis2Placement getMappingOrigin() {
		return (IfcAxis2Placement) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MappingOrigin(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingOrigin(IfcAxis2Placement newMappingOrigin) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MappingOrigin(), newMappingOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentation getMappedRepresentation() {
		return (IfcRepresentation) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MappedRepresentation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedRepresentation(IfcRepresentation newMappedRepresentation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MappedRepresentation(), newMappedRepresentation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcShapeAspect> getHasShapeAspects() {
		return (EList<IfcShapeAspect>) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_HasShapeAspects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasShapeAspects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_HasShapeAspects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasShapeAspects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_HasShapeAspects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcMappedItem> getMapUsage() {
		return (EList<IfcMappedItem>) eGet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MapUsage(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMapUsage() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MapUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMapUsage() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcRepresentationMap_MapUsage());
	}

} //IfcRepresentationMapImpl
