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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcElectricCurrentEnum;
import org.bimserver.models.ifc2x3tc1.IfcElectricalBaseProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Electrical Base Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getElectricCurrentType <em>Electric Current Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getInputVoltage <em>Input Voltage</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getInputVoltageAsString <em>Input Voltage As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getInputFrequency <em>Input Frequency</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getInputFrequencyAsString <em>Input Frequency As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getFullLoadCurrent <em>Full Load Current</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getFullLoadCurrentAsString <em>Full Load Current As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getMinimumCircuitCurrent <em>Minimum Circuit Current</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getMinimumCircuitCurrentAsString <em>Minimum Circuit Current As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getMaximumPowerInput <em>Maximum Power Input</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getMaximumPowerInputAsString <em>Maximum Power Input As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getRatedPowerInput <em>Rated Power Input</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getRatedPowerInputAsString <em>Rated Power Input As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcElectricalBasePropertiesImpl#getInputPhase <em>Input Phase</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcElectricalBasePropertiesImpl extends IfcEnergyPropertiesImpl implements IfcElectricalBaseProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcElectricalBasePropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricCurrentEnum getElectricCurrentType() {
		return (IfcElectricCurrentEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__ELECTRIC_CURRENT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElectricCurrentType(IfcElectricCurrentEnum newElectricCurrentType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__ELECTRIC_CURRENT_TYPE, newElectricCurrentType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElectricCurrentType() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__ELECTRIC_CURRENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElectricCurrentType() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__ELECTRIC_CURRENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInputVoltage() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_VOLTAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVoltage(double newInputVoltage) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_VOLTAGE, newInputVoltage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputVoltageAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_VOLTAGE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVoltageAsString(String newInputVoltageAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_VOLTAGE_AS_STRING,
				newInputVoltageAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInputFrequency() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_FREQUENCY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputFrequency(double newInputFrequency) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_FREQUENCY, newInputFrequency);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputFrequencyAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_FREQUENCY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputFrequencyAsString(String newInputFrequencyAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_FREQUENCY_AS_STRING,
				newInputFrequencyAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFullLoadCurrent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullLoadCurrent(double newFullLoadCurrent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT, newFullLoadCurrent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFullLoadCurrent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFullLoadCurrent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullLoadCurrentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullLoadCurrentAsString(String newFullLoadCurrentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT_AS_STRING,
				newFullLoadCurrentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFullLoadCurrentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFullLoadCurrentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__FULL_LOAD_CURRENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumCircuitCurrent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumCircuitCurrent(double newMinimumCircuitCurrent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT,
				newMinimumCircuitCurrent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumCircuitCurrent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumCircuitCurrent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumCircuitCurrentAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumCircuitCurrentAsString(String newMinimumCircuitCurrentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT_AS_STRING,
				newMinimumCircuitCurrentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumCircuitCurrentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumCircuitCurrentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MINIMUM_CIRCUIT_CURRENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumPowerInput() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPowerInput(double newMaximumPowerInput) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT, newMaximumPowerInput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPowerInput() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPowerInput() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumPowerInputAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPowerInputAsString(String newMaximumPowerInputAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT_AS_STRING,
				newMaximumPowerInputAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumPowerInputAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumPowerInputAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__MAXIMUM_POWER_INPUT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRatedPowerInput() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedPowerInput(double newRatedPowerInput) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT, newRatedPowerInput);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRatedPowerInput() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRatedPowerInput() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRatedPowerInputAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRatedPowerInputAsString(String newRatedPowerInputAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT_AS_STRING,
				newRatedPowerInputAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRatedPowerInputAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRatedPowerInputAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__RATED_POWER_INPUT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getInputPhase() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_PHASE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPhase(long newInputPhase) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ELECTRICAL_BASE_PROPERTIES__INPUT_PHASE, newInputPhase);
	}

} //IfcElectricalBasePropertiesImpl
