/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc2x3tc1;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Dimensional Exponents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcDimensionalExponents extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Length Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Exponent</em>' attribute.
	 * @see #setLengthExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_LengthExponent()
	 * @model
	 * @generated
	 */
	int getLengthExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Exponent</em>' attribute.
	 * @see #getLengthExponent()
	 * @generated
	 */
	void setLengthExponent(int value);

	/**
	 * Returns the value of the '<em><b>Mass Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mass Exponent</em>' attribute.
	 * @see #setMassExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_MassExponent()
	 * @model
	 * @generated
	 */
	int getMassExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mass Exponent</em>' attribute.
	 * @see #getMassExponent()
	 * @generated
	 */
	void setMassExponent(int value);

	/**
	 * Returns the value of the '<em><b>Time Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Exponent</em>' attribute.
	 * @see #setTimeExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_TimeExponent()
	 * @model
	 * @generated
	 */
	int getTimeExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Exponent</em>' attribute.
	 * @see #getTimeExponent()
	 * @generated
	 */
	void setTimeExponent(int value);

	/**
	 * Returns the value of the '<em><b>Electric Current Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electric Current Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #setElectricCurrentExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_ElectricCurrentExponent()
	 * @model
	 * @generated
	 */
	int getElectricCurrentExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #getElectricCurrentExponent()
	 * @generated
	 */
	void setElectricCurrentExponent(int value);

	/**
	 * Returns the value of the '<em><b>Thermodynamic Temperature Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermodynamic Temperature Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #setThermodynamicTemperatureExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_ThermodynamicTemperatureExponent()
	 * @model
	 * @generated
	 */
	int getThermodynamicTemperatureExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #getThermodynamicTemperatureExponent()
	 * @generated
	 */
	void setThermodynamicTemperatureExponent(int value);

	/**
	 * Returns the value of the '<em><b>Amount Of Substance Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount Of Substance Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #setAmountOfSubstanceExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_AmountOfSubstanceExponent()
	 * @model
	 * @generated
	 */
	int getAmountOfSubstanceExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #getAmountOfSubstanceExponent()
	 * @generated
	 */
	void setAmountOfSubstanceExponent(int value);

	/**
	 * Returns the value of the '<em><b>Luminous Intensity Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #setLuminousIntensityExponent(int)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDimensionalExponents_LuminousIntensityExponent()
	 * @model
	 * @generated
	 */
	int getLuminousIntensityExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #getLuminousIntensityExponent()
	 * @generated
	 */
	void setLuminousIntensityExponent(int value);

} // IfcDimensionalExponents
