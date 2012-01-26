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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Dimensional Exponents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents()
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
	 * @see #isSetLengthExponent()
	 * @see #unsetLengthExponent()
	 * @see #setLengthExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_LengthExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getLengthExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Exponent</em>' attribute.
	 * @see #isSetLengthExponent()
	 * @see #unsetLengthExponent()
	 * @see #getLengthExponent()
	 * @generated
	 */
	void setLengthExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLengthExponent()
	 * @see #getLengthExponent()
	 * @see #setLengthExponent(int)
	 * @generated
	 */
	void unsetLengthExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Length Exponent</em>' attribute is set.
	 * @see #unsetLengthExponent()
	 * @see #getLengthExponent()
	 * @see #setLengthExponent(int)
	 * @generated
	 */
	boolean isSetLengthExponent();

	/**
	 * Returns the value of the '<em><b>Mass Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mass Exponent</em>' attribute.
	 * @see #isSetMassExponent()
	 * @see #unsetMassExponent()
	 * @see #setMassExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_MassExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMassExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mass Exponent</em>' attribute.
	 * @see #isSetMassExponent()
	 * @see #unsetMassExponent()
	 * @see #getMassExponent()
	 * @generated
	 */
	void setMassExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMassExponent()
	 * @see #getMassExponent()
	 * @see #setMassExponent(int)
	 * @generated
	 */
	void unsetMassExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mass Exponent</em>' attribute is set.
	 * @see #unsetMassExponent()
	 * @see #getMassExponent()
	 * @see #setMassExponent(int)
	 * @generated
	 */
	boolean isSetMassExponent();

	/**
	 * Returns the value of the '<em><b>Time Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Exponent</em>' attribute.
	 * @see #isSetTimeExponent()
	 * @see #unsetTimeExponent()
	 * @see #setTimeExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_TimeExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getTimeExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Exponent</em>' attribute.
	 * @see #isSetTimeExponent()
	 * @see #unsetTimeExponent()
	 * @see #getTimeExponent()
	 * @generated
	 */
	void setTimeExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeExponent()
	 * @see #getTimeExponent()
	 * @see #setTimeExponent(int)
	 * @generated
	 */
	void unsetTimeExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Exponent</em>' attribute is set.
	 * @see #unsetTimeExponent()
	 * @see #getTimeExponent()
	 * @see #setTimeExponent(int)
	 * @generated
	 */
	boolean isSetTimeExponent();

	/**
	 * Returns the value of the '<em><b>Electric Current Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electric Current Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #isSetElectricCurrentExponent()
	 * @see #unsetElectricCurrentExponent()
	 * @see #setElectricCurrentExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_ElectricCurrentExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getElectricCurrentExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #isSetElectricCurrentExponent()
	 * @see #unsetElectricCurrentExponent()
	 * @see #getElectricCurrentExponent()
	 * @generated
	 */
	void setElectricCurrentExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElectricCurrentExponent()
	 * @see #getElectricCurrentExponent()
	 * @see #setElectricCurrentExponent(int)
	 * @generated
	 */
	void unsetElectricCurrentExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Electric Current Exponent</em>' attribute is set.
	 * @see #unsetElectricCurrentExponent()
	 * @see #getElectricCurrentExponent()
	 * @see #setElectricCurrentExponent(int)
	 * @generated
	 */
	boolean isSetElectricCurrentExponent();

	/**
	 * Returns the value of the '<em><b>Thermodynamic Temperature Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermodynamic Temperature Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #isSetThermodynamicTemperatureExponent()
	 * @see #unsetThermodynamicTemperatureExponent()
	 * @see #setThermodynamicTemperatureExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_ThermodynamicTemperatureExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getThermodynamicTemperatureExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #isSetThermodynamicTemperatureExponent()
	 * @see #unsetThermodynamicTemperatureExponent()
	 * @see #getThermodynamicTemperatureExponent()
	 * @generated
	 */
	void setThermodynamicTemperatureExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermodynamicTemperatureExponent()
	 * @see #getThermodynamicTemperatureExponent()
	 * @see #setThermodynamicTemperatureExponent(int)
	 * @generated
	 */
	void unsetThermodynamicTemperatureExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermodynamic Temperature Exponent</em>' attribute is set.
	 * @see #unsetThermodynamicTemperatureExponent()
	 * @see #getThermodynamicTemperatureExponent()
	 * @see #setThermodynamicTemperatureExponent(int)
	 * @generated
	 */
	boolean isSetThermodynamicTemperatureExponent();

	/**
	 * Returns the value of the '<em><b>Amount Of Substance Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount Of Substance Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #isSetAmountOfSubstanceExponent()
	 * @see #unsetAmountOfSubstanceExponent()
	 * @see #setAmountOfSubstanceExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_AmountOfSubstanceExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getAmountOfSubstanceExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #isSetAmountOfSubstanceExponent()
	 * @see #unsetAmountOfSubstanceExponent()
	 * @see #getAmountOfSubstanceExponent()
	 * @generated
	 */
	void setAmountOfSubstanceExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAmountOfSubstanceExponent()
	 * @see #getAmountOfSubstanceExponent()
	 * @see #setAmountOfSubstanceExponent(int)
	 * @generated
	 */
	void unsetAmountOfSubstanceExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Amount Of Substance Exponent</em>' attribute is set.
	 * @see #unsetAmountOfSubstanceExponent()
	 * @see #getAmountOfSubstanceExponent()
	 * @see #setAmountOfSubstanceExponent(int)
	 * @generated
	 */
	boolean isSetAmountOfSubstanceExponent();

	/**
	 * Returns the value of the '<em><b>Luminous Intensity Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #isSetLuminousIntensityExponent()
	 * @see #unsetLuminousIntensityExponent()
	 * @see #setLuminousIntensityExponent(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionalExponents_LuminousIntensityExponent()
	 * @model unsettable="true"
	 * @generated
	 */
	int getLuminousIntensityExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #isSetLuminousIntensityExponent()
	 * @see #unsetLuminousIntensityExponent()
	 * @see #getLuminousIntensityExponent()
	 * @generated
	 */
	void setLuminousIntensityExponent(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLuminousIntensityExponent()
	 * @see #getLuminousIntensityExponent()
	 * @see #setLuminousIntensityExponent(int)
	 * @generated
	 */
	void unsetLuminousIntensityExponent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Luminous Intensity Exponent</em>' attribute is set.
	 * @see #unsetLuminousIntensityExponent()
	 * @see #getLuminousIntensityExponent()
	 * @see #setLuminousIntensityExponent(int)
	 * @generated
	 */
	boolean isSetLuminousIntensityExponent();

} // IfcDimensionalExponents
