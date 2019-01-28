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
import org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum;
import org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties;
import org.bimserver.models.ifc2x3tc1.IfcThermalLoadSourceEnum;
import org.bimserver.models.ifc2x3tc1.IfcThermalLoadTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcTimeSeries;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space Thermal Load Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getApplicableValueRatio <em>Applicable Value Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getApplicableValueRatioAsString <em>Applicable Value Ratio As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getThermalLoadSource <em>Thermal Load Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getPropertySource <em>Property Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getSourceDescription <em>Source Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getMaximumValue <em>Maximum Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getMaximumValueAsString <em>Maximum Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getMinimumValue <em>Minimum Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getMinimumValueAsString <em>Minimum Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getThermalLoadTimeSeriesValues <em>Thermal Load Time Series Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getUserDefinedThermalLoadSource <em>User Defined Thermal Load Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getUserDefinedPropertySource <em>User Defined Property Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceThermalLoadPropertiesImpl#getThermalLoadType <em>Thermal Load Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSpaceThermalLoadPropertiesImpl extends IfcPropertySetDefinitionImpl
		implements IfcSpaceThermalLoadProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceThermalLoadPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getApplicableValueRatio() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicableValueRatio(double newApplicableValueRatio) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO,
				newApplicableValueRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableValueRatio() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableValueRatio() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicableValueRatioAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicableValueRatioAsString(String newApplicableValueRatioAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO_AS_STRING,
				newApplicableValueRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetApplicableValueRatioAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetApplicableValueRatioAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__APPLICABLE_VALUE_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalLoadSourceEnum getThermalLoadSource() {
		return (IfcThermalLoadSourceEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalLoadSource(IfcThermalLoadSourceEnum newThermalLoadSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_SOURCE, newThermalLoadSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySourceEnum getPropertySource() {
		return (IfcPropertySourceEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__PROPERTY_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertySource(IfcPropertySourceEnum newPropertySource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__PROPERTY_SOURCE, newPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceDescription() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__SOURCE_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceDescription(String newSourceDescription) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__SOURCE_DESCRIPTION, newSourceDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSourceDescription() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__SOURCE_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSourceDescription() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__SOURCE_DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MAXIMUM_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumValue(double newMaximumValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MAXIMUM_VALUE, newMaximumValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MAXIMUM_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumValueAsString(String newMaximumValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MAXIMUM_VALUE_AS_STRING,
				newMaximumValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumValue() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumValue(double newMinimumValue) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE, newMinimumValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumValue() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumValue() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumValueAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumValueAsString(String newMinimumValueAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE_AS_STRING,
				newMinimumValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumValueAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumValueAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__MINIMUM_VALUE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getThermalLoadTimeSeriesValues() {
		return (IfcTimeSeries) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TIME_SERIES_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalLoadTimeSeriesValues(IfcTimeSeries newThermalLoadTimeSeriesValues) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TIME_SERIES_VALUES,
				newThermalLoadTimeSeriesValues);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalLoadTimeSeriesValues() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TIME_SERIES_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalLoadTimeSeriesValues() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TIME_SERIES_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedThermalLoadSource() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_THERMAL_LOAD_SOURCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedThermalLoadSource(String newUserDefinedThermalLoadSource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_THERMAL_LOAD_SOURCE,
				newUserDefinedThermalLoadSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedThermalLoadSource() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_THERMAL_LOAD_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedThermalLoadSource() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_THERMAL_LOAD_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedPropertySource() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedPropertySource(String newUserDefinedPropertySource) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE,
				newUserDefinedPropertySource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedPropertySource() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedPropertySource() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__USER_DEFINED_PROPERTY_SOURCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalLoadTypeEnum getThermalLoadType() {
		return (IfcThermalLoadTypeEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalLoadType(IfcThermalLoadTypeEnum newThermalLoadType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_THERMAL_LOAD_PROPERTIES__THERMAL_LOAD_TYPE, newThermalLoadType);
	}

} //IfcSpaceThermalLoadPropertiesImpl
