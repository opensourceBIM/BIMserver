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

import org.bimserver.models.ifc2x3tc1.IfcFuelProperties;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fuel Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getCombustionTemperature <em>Combustion Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getCombustionTemperatureAsString <em>Combustion Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getCarbonContent <em>Carbon Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getCarbonContentAsString <em>Carbon Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getLowerHeatingValue <em>Lower Heating Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getLowerHeatingValueAsString <em>Lower Heating Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getHigherHeatingValue <em>Higher Heating Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFuelPropertiesImpl#getHigherHeatingValueAsString <em>Higher Heating Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFuelPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcFuelProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFuelPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_FUEL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCombustionTemperature() {
		return (Double) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTemperature(double newCombustionTemperature) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE, newCombustionTemperature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCombustionTemperature() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCombustionTemperature() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCombustionTemperatureAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCombustionTemperatureAsString(String newCombustionTemperatureAsString) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING, newCombustionTemperatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCombustionTemperatureAsString() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCombustionTemperatureAsString() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__COMBUSTION_TEMPERATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCarbonContent() {
		return (Double) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCarbonContent(double newCarbonContent) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT, newCarbonContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCarbonContent() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCarbonContent() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCarbonContentAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCarbonContentAsString(String newCarbonContentAsString) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING, newCarbonContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCarbonContentAsString() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCarbonContentAsString() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__CARBON_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLowerHeatingValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerHeatingValue(double newLowerHeatingValue) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE, newLowerHeatingValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerHeatingValue() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerHeatingValue() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerHeatingValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerHeatingValueAsString(String newLowerHeatingValueAsString) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING, newLowerHeatingValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerHeatingValueAsString() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerHeatingValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__LOWER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHigherHeatingValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigherHeatingValue(double newHigherHeatingValue) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE, newHigherHeatingValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHigherHeatingValue() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHigherHeatingValue() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHigherHeatingValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHigherHeatingValueAsString(String newHigherHeatingValueAsString) {
		eSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING, newHigherHeatingValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHigherHeatingValueAsString() {
		eUnset(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHigherHeatingValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FUEL_PROPERTIES__HIGHER_HEATING_VALUE_AS_STRING);
	}

} //IfcFuelPropertiesImpl
