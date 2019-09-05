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
import org.bimserver.models.ifc4.IfcCompositeCurve;
import org.bimserver.models.ifc4.IfcCompositeCurveSegment;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Composite Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCompositeCurveImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCompositeCurveImpl#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCompositeCurveImpl#getClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcCompositeCurveImpl#getNSegments <em>NSegments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCompositeCurveImpl extends IfcBoundedCurveImpl implements IfcCompositeCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCompositeCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_COMPOSITE_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcCompositeCurveSegment> getSegments() {
		return (EList<IfcCompositeCurveSegment>) eGet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__SEGMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSelfIntersect() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelfIntersect(Tristate newSelfIntersect) {
		eSet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__SELF_INTERSECT, newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getClosedCurve() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__CLOSED_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClosedCurve(Tristate newClosedCurve) {
		eSet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__CLOSED_CURVE, newClosedCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClosedCurve() {
		eUnset(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__CLOSED_CURVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClosedCurve() {
		return eIsSet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__CLOSED_CURVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNSegments() {
		return (Long) eGet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__NSEGMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNSegments(long newNSegments) {
		eSet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__NSEGMENTS, newNSegments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNSegments() {
		eUnset(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__NSEGMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNSegments() {
		return eIsSet(Ifc4Package.Literals.IFC_COMPOSITE_CURVE__NSEGMENTS);
	}

} //IfcCompositeCurveImpl
