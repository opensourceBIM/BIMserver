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
		return Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlacement getPosition() {
		return (IfcPlacement) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(IfcPlacement newPosition) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsX() {
		return (EList<Double>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsXAsString() {
		return (EList<String>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsXAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsY() {
		return (EList<Double>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsYAsString() {
		return (EList<String>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsYAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getCoefficientsZ() {
		return (EList<Double>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getCoefficientsZAsString() {
		return (EList<String>) eGet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCoefficientsZAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCoefficientsZAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcPolynomialCurve_CoefficientsZAsString());
	}

} //IfcPolynomialCurveImpl
