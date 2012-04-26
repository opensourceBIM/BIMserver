/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Dimensional Exponents</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getLengthExponent <em>Length Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getMassExponent <em>Mass Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getTimeExponent <em>Time Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getElectricCurrentExponent <em>Electric Current Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcDimensionalExponentsImpl#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDimensionalExponentsImpl extends IdEObjectImpl implements IfcDimensionalExponents {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDimensionalExponentsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS;
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
	public int getLengthExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__LENGTH_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthExponent(int newLengthExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__LENGTH_EXPONENT, newLengthExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMassExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__MASS_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMassExponent(int newMassExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__MASS_EXPONENT, newMassExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__TIME_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeExponent(int newTimeExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__TIME_EXPONENT, newTimeExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getElectricCurrentExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__ELECTRIC_CURRENT_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectricCurrentExponent(int newElectricCurrentExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__ELECTRIC_CURRENT_EXPONENT, newElectricCurrentExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThermodynamicTemperatureExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__THERMODYNAMIC_TEMPERATURE_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermodynamicTemperatureExponent(int newThermodynamicTemperatureExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__THERMODYNAMIC_TEMPERATURE_EXPONENT, newThermodynamicTemperatureExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAmountOfSubstanceExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__AMOUNT_OF_SUBSTANCE_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmountOfSubstanceExponent(int newAmountOfSubstanceExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__AMOUNT_OF_SUBSTANCE_EXPONENT, newAmountOfSubstanceExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLuminousIntensityExponent() {
		return (Integer) eGet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__LUMINOUS_INTENSITY_EXPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousIntensityExponent(int newLuminousIntensityExponent) {
		eSet(LogPackage.Literals.IFC_DIMENSIONAL_EXPONENTS__LUMINOUS_INTENSITY_EXPONENT, newLuminousIntensityExponent);
	}

} //IfcDimensionalExponentsImpl
