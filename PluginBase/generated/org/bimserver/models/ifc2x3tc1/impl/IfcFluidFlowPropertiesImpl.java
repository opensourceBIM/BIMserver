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
import org.bimserver.models.ifc2x3tc1.IfcDerivedMeasureValue;
import org.bimserver.models.ifc2x3tc1.IfcFluidFlowProperties;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeries;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fluid Flow Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
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
		return Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySourceEnum getPropertySource() {
		return (IfcPropertySourceEnum) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PROPERTY_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertySource(IfcPropertySourceEnum newPropertySource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PROPERTY_SOURCE, newPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getFlowConditionTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionTimeSeries(IfcTimeSeries newFlowConditionTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES,
				newFlowConditionTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getVelocityTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocityTimeSeries(IfcTimeSeries newVelocityTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES, newVelocityTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocityTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocityTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getFlowrateTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowrateTimeSeries(IfcTimeSeries newFlowrateTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES, newFlowrateTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowrateTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowrateTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getFluid() {
		return (IfcMaterial) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLUID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFluid(IfcMaterial newFluid) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLUID, newFluid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getPressureTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureTimeSeries(IfcTimeSeries newPressureTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES, newPressureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedPropertySource() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedPropertySource(String newUserDefinedPropertySource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE,
				newUserDefinedPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedPropertySource() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedPropertySource() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTemperatureSingleValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureSingleValue(double newTemperatureSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE, newTemperatureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemperatureSingleValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureSingleValueAsString(String newTemperatureSingleValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING,
				newTemperatureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureSingleValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureSingleValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWetBulbTemperatureSingleValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureSingleValue(double newWetBulbTemperatureSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE,
				newWetBulbTemperatureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWetBulbTemperatureSingleValueAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureSingleValueAsString(String newWetBulbTemperatureSingleValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING,
				newWetBulbTemperatureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureSingleValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureSingleValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getWetBulbTemperatureTimeSeries() {
		return (IfcTimeSeries) eGet(
				Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWetBulbTemperatureTimeSeries(IfcTimeSeries newWetBulbTemperatureTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES,
				newWetBulbTemperatureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWetBulbTemperatureTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWetBulbTemperatureTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__WET_BULB_TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getTemperatureTimeSeries() {
		return (IfcTimeSeries) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemperatureTimeSeries(IfcTimeSeries newTemperatureTimeSeries) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES, newTemperatureTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTemperatureTimeSeries() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTemperatureTimeSeries() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__TEMPERATURE_TIME_SERIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedMeasureValue getFlowrateSingleValue() {
		return (IfcDerivedMeasureValue) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowrateSingleValue(IfcDerivedMeasureValue newFlowrateSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE, newFlowrateSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowrateSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowrateSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOWRATE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFlowConditionSingleValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionSingleValue(double newFlowConditionSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE,
				newFlowConditionSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlowConditionSingleValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConditionSingleValueAsString(String newFlowConditionSingleValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING,
				newFlowConditionSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFlowConditionSingleValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFlowConditionSingleValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__FLOW_CONDITION_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVelocitySingleValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocitySingleValue(double newVelocitySingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE, newVelocitySingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocitySingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocitySingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVelocitySingleValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocitySingleValueAsString(String newVelocitySingleValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING,
				newVelocitySingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVelocitySingleValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVelocitySingleValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__VELOCITY_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPressureSingleValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureSingleValue(double newPressureSingleValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE, newPressureSingleValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureSingleValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureSingleValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPressureSingleValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPressureSingleValueAsString(String newPressureSingleValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING,
				newPressureSingleValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPressureSingleValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPressureSingleValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FLUID_FLOW_PROPERTIES__PRESSURE_SINGLE_VALUE_AS_STRING);
	}

} //IfcFluidFlowPropertiesImpl
