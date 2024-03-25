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
import org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Seventh Order Polynomial Spiral</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getSepticTerm <em>Septic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getSepticTermAsString <em>Septic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getSexticTerm <em>Sextic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getSexticTermAsString <em>Sextic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuinticTerm <em>Quintic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuinticTermAsString <em>Quintic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuarticTerm <em>Quartic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuarticTermAsString <em>Quartic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getCubicTerm <em>Cubic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getCubicTermAsString <em>Cubic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuadraticTerm <em>Quadratic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getQuadraticTermAsString <em>Quadratic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getLinearTerm <em>Linear Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getLinearTermAsString <em>Linear Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSeventhOrderPolynomialSpiralImpl#getConstantTermAsString <em>Constant Term As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSeventhOrderPolynomialSpiralImpl extends IfcSpiralImpl implements IfcSeventhOrderPolynomialSpiral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSeventhOrderPolynomialSpiralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSepticTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEPTIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSepticTerm(double newSepticTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEPTIC_TERM, newSepticTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSepticTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEPTIC_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSepticTermAsString(String newSepticTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEPTIC_TERM_AS_STRING, newSepticTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSexticTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSexticTerm(double newSexticTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM, newSexticTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSexticTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSexticTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSexticTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSexticTermAsString(String newSexticTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM_AS_STRING, newSexticTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSexticTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSexticTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__SEXTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getQuinticTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuinticTerm(double newQuinticTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM, newQuinticTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuinticTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuinticTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuinticTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuinticTermAsString(String newQuinticTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM_AS_STRING,
				newQuinticTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuinticTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuinticTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUINTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getQuarticTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuarticTerm(double newQuarticTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM, newQuarticTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuarticTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuarticTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuarticTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuarticTermAsString(String newQuarticTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM_AS_STRING,
				newQuarticTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuarticTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuarticTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUARTIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCubicTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCubicTerm(double newCubicTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM, newCubicTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCubicTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCubicTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCubicTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCubicTermAsString(String newCubicTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM_AS_STRING, newCubicTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCubicTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCubicTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CUBIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getQuadraticTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuadraticTerm(double newQuadraticTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM, newQuadraticTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuadraticTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuadraticTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuadraticTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuadraticTermAsString(String newQuadraticTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM_AS_STRING,
				newQuadraticTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetQuadraticTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetQuadraticTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__QUADRATIC_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearTerm(double newLinearTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM, newLinearTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearTermAsString(String newLinearTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM_AS_STRING, newLinearTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__LINEAR_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConstantTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantTerm(double newConstantTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM, newConstantTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstantTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstantTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConstantTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantTermAsString(String newConstantTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM_AS_STRING,
				newConstantTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstantTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstantTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SEVENTH_ORDER_POLYNOMIAL_SPIRAL__CONSTANT_TERM_AS_STRING);
	}

} //IfcSeventhOrderPolynomialSpiralImpl
