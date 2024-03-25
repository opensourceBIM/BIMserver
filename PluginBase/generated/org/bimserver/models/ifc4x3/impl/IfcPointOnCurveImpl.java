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
import org.bimserver.models.ifc4x3.IfcCurve;
import org.bimserver.models.ifc4x3.IfcPointOnCurve;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Point On Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointOnCurveImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointOnCurveImpl#getPointParameter <em>Point Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPointOnCurveImpl#getPointParameterAsString <em>Point Parameter As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPointOnCurveImpl extends IfcPointImpl implements IfcPointOnCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPointOnCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_POINT_ON_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getBasisCurve() {
		return (IfcCurve) eGet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__BASIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBasisCurve(IfcCurve newBasisCurve) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__BASIS_CURVE, newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPointParameter() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__POINT_PARAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPointParameter(double newPointParameter) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__POINT_PARAMETER, newPointParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPointParameterAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__POINT_PARAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPointParameterAsString(String newPointParameterAsString) {
		eSet(Ifc4x3Package.Literals.IFC_POINT_ON_CURVE__POINT_PARAMETER_AS_STRING, newPointParameterAsString);
	}

} //IfcPointOnCurveImpl
