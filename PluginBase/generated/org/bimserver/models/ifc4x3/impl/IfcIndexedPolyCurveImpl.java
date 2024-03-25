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
import org.bimserver.models.ifc4x3.IfcCartesianPointList;
import org.bimserver.models.ifc4x3.IfcIndexedPolyCurve;
import org.bimserver.models.ifc4x3.IfcSegmentIndexSelect;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Indexed Poly Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIndexedPolyCurveImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIndexedPolyCurveImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcIndexedPolyCurveImpl#getSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcIndexedPolyCurveImpl extends IfcBoundedCurveImpl implements IfcIndexedPolyCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcIndexedPolyCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPointList getPoints() {
		return (IfcCartesianPointList) eGet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__POINTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPoints(IfcCartesianPointList newPoints) {
		eSet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__POINTS, newPoints);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcSegmentIndexSelect> getSegments() {
		return (EList<IfcSegmentIndexSelect>) eGet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SEGMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSegments() {
		eUnset(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SEGMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSegments() {
		return eIsSet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SEGMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSelfIntersect() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelfIntersect(Tristate newSelfIntersect) {
		eSet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SELF_INTERSECT, newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSelfIntersect() {
		eUnset(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SELF_INTERSECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSelfIntersect() {
		return eIsSet(Ifc4x3Package.Literals.IFC_INDEXED_POLY_CURVE__SELF_INTERSECT);
	}

} //IfcIndexedPolyCurveImpl
