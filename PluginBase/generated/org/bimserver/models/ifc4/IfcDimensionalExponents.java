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
package org.bimserver.models.ifc4;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Dimensional Exponents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents()
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
	 * @see #setLengthExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_LengthExponent()
	 * @model
	 * @generated
	 */
	long getLengthExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getLengthExponent <em>Length Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Exponent</em>' attribute.
	 * @see #getLengthExponent()
	 * @generated
	 */
	void setLengthExponent(long value);

	/**
	 * Returns the value of the '<em><b>Mass Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mass Exponent</em>' attribute.
	 * @see #setMassExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_MassExponent()
	 * @model
	 * @generated
	 */
	long getMassExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getMassExponent <em>Mass Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mass Exponent</em>' attribute.
	 * @see #getMassExponent()
	 * @generated
	 */
	void setMassExponent(long value);

	/**
	 * Returns the value of the '<em><b>Time Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Exponent</em>' attribute.
	 * @see #setTimeExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_TimeExponent()
	 * @model
	 * @generated
	 */
	long getTimeExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getTimeExponent <em>Time Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Exponent</em>' attribute.
	 * @see #getTimeExponent()
	 * @generated
	 */
	void setTimeExponent(long value);

	/**
	 * Returns the value of the '<em><b>Electric Current Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electric Current Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #setElectricCurrentExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_ElectricCurrentExponent()
	 * @model
	 * @generated
	 */
	long getElectricCurrentExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getElectricCurrentExponent <em>Electric Current Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Electric Current Exponent</em>' attribute.
	 * @see #getElectricCurrentExponent()
	 * @generated
	 */
	void setElectricCurrentExponent(long value);

	/**
	 * Returns the value of the '<em><b>Thermodynamic Temperature Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermodynamic Temperature Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #setThermodynamicTemperatureExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_ThermodynamicTemperatureExponent()
	 * @model
	 * @generated
	 */
	long getThermodynamicTemperatureExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getThermodynamicTemperatureExponent <em>Thermodynamic Temperature Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermodynamic Temperature Exponent</em>' attribute.
	 * @see #getThermodynamicTemperatureExponent()
	 * @generated
	 */
	void setThermodynamicTemperatureExponent(long value);

	/**
	 * Returns the value of the '<em><b>Amount Of Substance Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount Of Substance Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #setAmountOfSubstanceExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_AmountOfSubstanceExponent()
	 * @model
	 * @generated
	 */
	long getAmountOfSubstanceExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getAmountOfSubstanceExponent <em>Amount Of Substance Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount Of Substance Exponent</em>' attribute.
	 * @see #getAmountOfSubstanceExponent()
	 * @generated
	 */
	void setAmountOfSubstanceExponent(long value);

	/**
	 * Returns the value of the '<em><b>Luminous Intensity Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Intensity Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #setLuminousIntensityExponent(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDimensionalExponents_LuminousIntensityExponent()
	 * @model
	 * @generated
	 */
	long getLuminousIntensityExponent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDimensionalExponents#getLuminousIntensityExponent <em>Luminous Intensity Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Luminous Intensity Exponent</em>' attribute.
	 * @see #getLuminousIntensityExponent()
	 * @generated
	 */
	void setLuminousIntensityExponent(long value);

} // IfcDimensionalExponents
