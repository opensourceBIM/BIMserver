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
import org.bimserver.models.ifc4x3.IfcCompositeCurveSegment;
import org.bimserver.models.ifc4x3.IfcCurve;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Composite Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCompositeCurveSegmentImpl#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCompositeCurveSegmentImpl#getParentCurve <em>Parent Curve</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCompositeCurveSegmentImpl extends IfcSegmentImpl implements IfcCompositeCurveSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCompositeCurveSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_COMPOSITE_CURVE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSameSense() {
		return (Tristate) eGet(Ifc4x3Package.Literals.IFC_COMPOSITE_CURVE_SEGMENT__SAME_SENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSameSense(Tristate newSameSense) {
		eSet(Ifc4x3Package.Literals.IFC_COMPOSITE_CURVE_SEGMENT__SAME_SENSE, newSameSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getParentCurve() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_COMPOSITE_CURVE_SEGMENT__PARENT_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentCurve(IfcCurve newParentCurve) {
		eSet(Ifc4x3Package.Literals.IFC_COMPOSITE_CURVE_SEGMENT__PARENT_CURVE, newParentCurve);
	}

} //IfcCompositeCurveSegmentImpl
