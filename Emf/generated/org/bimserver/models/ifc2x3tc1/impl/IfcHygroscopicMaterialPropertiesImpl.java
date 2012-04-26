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

import org.bimserver.models.ifc2x3tc1.IfcHygroscopicMaterialProperties;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Hygroscopic Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactor <em>Upper Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactorAsString <em>Upper Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactor <em>Lower Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactorAsString <em>Lower Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacity <em>Isothermal Moisture Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacityAsString <em>Isothermal Moisture Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeability <em>Vapor Permeability</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeabilityAsString <em>Vapor Permeability As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivity <em>Moisture Diffusivity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivityAsString <em>Moisture Diffusivity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcHygroscopicMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcHygroscopicMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcHygroscopicMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUpperVaporResistanceFactor() {
		return (Double) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactor(double newUpperVaporResistanceFactor) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR, newUpperVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactor() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactor() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpperVaporResistanceFactorAsString() {
		return (String) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactorAsString(String newUpperVaporResistanceFactorAsString) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING, newUpperVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactorAsString() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactorAsString() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLowerVaporResistanceFactor() {
		return (Double) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactor(double newLowerVaporResistanceFactor) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR, newLowerVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactor() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactor() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerVaporResistanceFactorAsString() {
		return (String) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactorAsString(String newLowerVaporResistanceFactorAsString) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING, newLowerVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactorAsString() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactorAsString() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIsothermalMoistureCapacity() {
		return (Double) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacity(double newIsothermalMoistureCapacity) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY, newIsothermalMoistureCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacity() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacity() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsothermalMoistureCapacityAsString() {
		return (String) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacityAsString(String newIsothermalMoistureCapacityAsString) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING, newIsothermalMoistureCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacityAsString() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacityAsString() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVaporPermeability() {
		return (Double) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeability(double newVaporPermeability) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY, newVaporPermeability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeability() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeability() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVaporPermeabilityAsString() {
		return (String) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeabilityAsString(String newVaporPermeabilityAsString) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING, newVaporPermeabilityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeabilityAsString() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeabilityAsString() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMoistureDiffusivity() {
		return (Double) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivity(double newMoistureDiffusivity) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY, newMoistureDiffusivity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivity() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivity() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMoistureDiffusivityAsString() {
		return (String) eGet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivityAsString(String newMoistureDiffusivityAsString) {
		eSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING, newMoistureDiffusivityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivityAsString() {
		eUnset(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivityAsString() {
		return eIsSet(LogPackage.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING);
	}

} //IfcHygroscopicMaterialPropertiesImpl
