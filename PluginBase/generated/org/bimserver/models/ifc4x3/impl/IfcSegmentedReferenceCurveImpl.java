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
import org.bimserver.models.ifc4x3.IfcBoundedCurve;
import org.bimserver.models.ifc4x3.IfcPlacement;
import org.bimserver.models.ifc4x3.IfcSegmentedReferenceCurve;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Segmented Reference Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSegmentedReferenceCurveImpl#getBaseCurve <em>Base Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSegmentedReferenceCurveImpl#getEndPoint <em>End Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSegmentedReferenceCurveImpl extends IfcCompositeCurveImpl implements IfcSegmentedReferenceCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSegmentedReferenceCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundedCurve getBaseCurve() {
		return (IfcBoundedCurve) eGet(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__BASE_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseCurve(IfcBoundedCurve newBaseCurve) {
		eSet(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__BASE_CURVE, newBaseCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlacement getEndPoint() {
		return (IfcPlacement) eGet(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__END_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndPoint(IfcPlacement newEndPoint) {
		eSet(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__END_POINT, newEndPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndPoint() {
		eUnset(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__END_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndPoint() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEGMENTED_REFERENCE_CURVE__END_POINT);
	}

} //IfcSegmentedReferenceCurveImpl
