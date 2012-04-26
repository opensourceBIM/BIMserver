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

import org.bimserver.models.ifc2x3tc1.IfcDerivedMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcFluidFlowProperties;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeries;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fluid Flow Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getPropertySource <em>Property Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFlowConditionTimeSeries <em>Flow Condition Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getVelocityTimeSeries <em>Velocity Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFlowrateTimeSeries <em>Flowrate Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFluid <em>Fluid</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getPressureTimeSeries <em>Pressure Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getUserDefinedPropertySource <em>User Defined Property Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getTemperatureSingleValue <em>Temperature Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getTemperatureSingleValueAsString <em>Temperature Single Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getWetBulbTemperatureSingleValue <em>Wet Bulb Temperature Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getWetBulbTemperatureSingleValueAsString <em>Wet Bulb Temperature Single Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getWetBulbTemperatureTimeSeries <em>Wet Bulb Temperature Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getTemperatureTimeSeries <em>Temperature Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFlowrateSingleValue <em>Flowrate Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFlowConditionSingleValue <em>Flow Condition Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getFlowConditionSingleValueAsString <em>Flow Condition Single Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getVelocitySingleValue <em>Velocity Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getVelocitySingleValueAsString <em>Velocity Single Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getPressureSingleValue <em>Pressure Single Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFluidFlowPropertiesImpl#getPressureSingleValueAsString <em>Pressure Single Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFluidFlowPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcFluidFlowProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFluidFlowPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySourceEnum getPropertySource() {
		return (IfcPropertySourceEnum) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PROPERTY_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertySource(IfcPropertySourceEnum newPropertySource) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PROPERTY_SOURCE, newPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getFlowConditionTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionTimeSeries(IfcTimeSeries newFlowConditionTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES, newFlowConditionTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getVelocityTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocityTimeSeries(IfcTimeSeries newVelocityTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES, newVelocityTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocityTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocityTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getFlowrateTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowrateTimeSeries(IfcTimeSeries newFlowrateTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES, newFlowrateTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowrateTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowrateTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getFluid() {
		return (IfcMaterial) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLUID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFluid(IfcMaterial newFluid) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLUID, newFluid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getPressureTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureTimeSeries(IfcTimeSeries newPressureTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES, newPressureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedPropertySource() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedPropertySource(String newUserDefinedPropertySource) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE, newUserDefinedPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedPropertySource() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedPropertySource() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTemperatureSingleValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureSingleValue(double newTemperatureSingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE, newTemperatureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureSingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureSingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemperatureSingleValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureSingleValueAsString(String newTemperatureSingleValueAsString) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING, newTemperatureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureSingleValueAsString() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureSingleValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWetBulbTemperatureSingleValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureSingleValue(double newWetBulbTemperatureSingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE, newWetBulbTemperatureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureSingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureSingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWetBulbTemperatureSingleValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureSingleValueAsString(String newWetBulbTemperatureSingleValueAsString) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING, newWetBulbTemperatureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureSingleValueAsString() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureSingleValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getWetBulbTemperatureTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureTimeSeries(IfcTimeSeries newWetBulbTemperatureTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES, newWetBulbTemperatureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getTemperatureTimeSeries() {
		return (IfcTimeSeries) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureTimeSeries(IfcTimeSeries newTemperatureTimeSeries) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES, newTemperatureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureTimeSeries() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureTimeSeries() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedMeasureValue getFlowrateSingleValue() {
		return (IfcDerivedMeasureValue) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowrateSingleValue(IfcDerivedMeasureValue newFlowrateSingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE, newFlowrateSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowrateSingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowrateSingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFlowConditionSingleValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionSingleValue(double newFlowConditionSingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE, newFlowConditionSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionSingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionSingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlowConditionSingleValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionSingleValueAsString(String newFlowConditionSingleValueAsString) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING, newFlowConditionSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionSingleValueAsString() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionSingleValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVelocitySingleValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocitySingleValue(double newVelocitySingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE, newVelocitySingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocitySingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocitySingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVelocitySingleValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocitySingleValueAsString(String newVelocitySingleValueAsString) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING, newVelocitySingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocitySingleValueAsString() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocitySingleValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPressureSingleValue() {
		return (Double) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureSingleValue(double newPressureSingleValue) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE, newPressureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureSingleValue() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureSingleValue() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPressureSingleValueAsString() {
		return (String) eGet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureSingleValueAsString(String newPressureSingleValueAsString) {
		eSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING, newPressureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureSingleValueAsString() {
		eUnset(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureSingleValueAsString() {
		return eIsSet(LogPackage.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING);
	}

} //IfcFluidFlowPropertiesImpl
