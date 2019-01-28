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
import org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Thermal Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getBoilingPoint <em>Boiling Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getBoilingPointAsString <em>Boiling Point As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getFreezingPoint <em>Freezing Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getFreezingPointAsString <em>Freezing Point As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getThermalConductivity <em>Thermal Conductivity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcThermalMaterialPropertiesImpl#getThermalConductivityAsString <em>Thermal Conductivity As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcThermalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl
		implements IfcThermalMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcThermalMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSpecificHeatCapacity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacity(double newSpecificHeatCapacity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY,
				newSpecificHeatCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificHeatCapacityAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacityAsString(String newSpecificHeatCapacityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING,
				newSpecificHeatCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacityAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBoilingPoint() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoilingPoint(double newBoilingPoint) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT, newBoilingPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoilingPoint() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoilingPoint() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoilingPointAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoilingPointAsString(String newBoilingPointAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING,
				newBoilingPointAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoilingPointAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoilingPointAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFreezingPoint() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreezingPoint(double newFreezingPoint) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT, newFreezingPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreezingPoint() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreezingPoint() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFreezingPointAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreezingPointAsString(String newFreezingPointAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING,
				newFreezingPointAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreezingPointAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreezingPointAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThermalConductivity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalConductivity(double newThermalConductivity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY, newThermalConductivity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalConductivity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalConductivity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalConductivityAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalConductivityAsString(String newThermalConductivityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING,
				newThermalConductivityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalConductivityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalConductivityAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING);
	}

} //IfcThermalMaterialPropertiesImpl
