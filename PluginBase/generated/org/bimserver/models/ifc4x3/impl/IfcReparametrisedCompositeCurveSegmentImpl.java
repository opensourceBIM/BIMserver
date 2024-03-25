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
import org.bimserver.models.ifc4x3.IfcReparametrisedCompositeCurveSegment;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reparametrised Composite Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReparametrisedCompositeCurveSegmentImpl#getParamLength <em>Param Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReparametrisedCompositeCurveSegmentImpl#getParamLengthAsString <em>Param Length As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcReparametrisedCompositeCurveSegmentImpl extends IfcCompositeCurveSegmentImpl
		implements IfcReparametrisedCompositeCurveSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReparametrisedCompositeCurveSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getParamLength() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT__PARAM_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParamLength(double newParamLength) {
		eSet(Ifc4x3Package.Literals.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT__PARAM_LENGTH, newParamLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParamLengthAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT__PARAM_LENGTH_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParamLengthAsString(String newParamLengthAsString) {
		eSet(Ifc4x3Package.Literals.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT__PARAM_LENGTH_AS_STRING,
				newParamLengthAsString);
	}

} //IfcReparametrisedCompositeCurveSegmentImpl
