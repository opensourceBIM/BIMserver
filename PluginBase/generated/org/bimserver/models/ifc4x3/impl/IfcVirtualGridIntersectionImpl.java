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
import org.bimserver.models.ifc4x3.IfcGridAxis;
import org.bimserver.models.ifc4x3.IfcVirtualGridIntersection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Virtual Grid Intersection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVirtualGridIntersectionImpl#getIntersectingAxes <em>Intersecting Axes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVirtualGridIntersectionImpl#getOffsetDistances <em>Offset Distances</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcVirtualGridIntersectionImpl#getOffsetDistancesAsString <em>Offset Distances As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcVirtualGridIntersectionImpl extends IdEObjectImpl implements IfcVirtualGridIntersection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcVirtualGridIntersectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_VIRTUAL_GRID_INTERSECTION;
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
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcGridAxis> getIntersectingAxes() {
		return (EList<IfcGridAxis>) eGet(Ifc4x3Package.Literals.IFC_VIRTUAL_GRID_INTERSECTION__INTERSECTING_AXES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getOffsetDistances() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_VIRTUAL_GRID_INTERSECTION__OFFSET_DISTANCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getOffsetDistancesAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_VIRTUAL_GRID_INTERSECTION__OFFSET_DISTANCES_AS_STRING,
				true);
	}

} //IfcVirtualGridIntersectionImpl
