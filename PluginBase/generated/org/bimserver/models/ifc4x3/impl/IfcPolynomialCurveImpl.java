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
import org.bimserver.models.ifc4x3.IfcPlacement;
import org.bimserver.models.ifc4x3.IfcPolynomialCurve;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Polynomial Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsX <em>Coefficients X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsXAsString <em>Coefficients XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsY <em>Coefficients Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsYAsString <em>Coefficients YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsZ <em>Coefficients Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcPolynomialCurveImpl#getCoefficientsZAsString <em>Coefficients ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPolynomialCurveImpl extends IfcCurveImpl implements IfcPolynomialCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPolynomialCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlacement getPosition() {
		return (IfcPlacement) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(IfcPlacement newPosition) {
		eSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__POSITION, newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsX() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsX() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsX() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsXAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsXAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsXAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsY() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsY() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsY() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsYAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsYAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsYAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsZ() {
		return (EList<Double>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsZ() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsZ() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsZAsString() {
		return (EList<String>) eGet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsZAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsZAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_POLYNOMIAL_CURVE__COEFFICIENTS_ZAS_STRING);
	}

} //IfcPolynomialCurveImpl
