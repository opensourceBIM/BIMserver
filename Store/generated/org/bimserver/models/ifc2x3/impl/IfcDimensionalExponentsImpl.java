/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDimensionalExponents;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Dimensional Exponents</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getLengthExponent <em>Length Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getMassExponent <em>Mass Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getTimeExponent <em>Time Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getElectricCurrentExponent <em>Electric Current Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}</li>
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
		return Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents();
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
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_LengthExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthExponent(int newLengthExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_LengthExponent(), newLengthExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMassExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_MassExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMassExponent(int newMassExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_MassExponent(), newMassExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_TimeExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeExponent(int newTimeExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_TimeExponent(), newTimeExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getElectricCurrentExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_ElectricCurrentExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectricCurrentExponent(int newElectricCurrentExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_ElectricCurrentExponent(), newElectricCurrentExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThermodynamicTemperatureExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_ThermodynamicTemperatureExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermodynamicTemperatureExponent(int newThermodynamicTemperatureExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_ThermodynamicTemperatureExponent(), newThermodynamicTemperatureExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAmountOfSubstanceExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_AmountOfSubstanceExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmountOfSubstanceExponent(int newAmountOfSubstanceExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_AmountOfSubstanceExponent(), newAmountOfSubstanceExponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLuminousIntensityExponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_LuminousIntensityExponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLuminousIntensityExponent(int newLuminousIntensityExponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcDimensionalExponents_LuminousIntensityExponent(), newLuminousIntensityExponent);
	}

} //IfcDimensionalExponentsImpl
