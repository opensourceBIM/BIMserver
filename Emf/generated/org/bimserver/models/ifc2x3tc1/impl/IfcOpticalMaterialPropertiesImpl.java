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

import org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Optical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleTransmittance <em>Visible Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarTransmittance <em>Solar Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceFront <em>Solar Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceBack <em>Solar Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcOpticalMaterialPropertiesImpl#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOpticalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcOpticalMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOpticalMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVisibleTransmittance() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleTransmittance(double newVisibleTransmittance) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE, newVisibleTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleTransmittance() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleTransmittance() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleTransmittanceAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleTransmittanceAsString(String newVisibleTransmittanceAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE_AS_STRING, newVisibleTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleTransmittanceAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleTransmittanceAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSolarTransmittance() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarTransmittance(double newSolarTransmittance) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE, newSolarTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarTransmittance() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarTransmittance() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarTransmittanceAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarTransmittanceAsString(String newSolarTransmittanceAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE_AS_STRING, newSolarTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarTransmittanceAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarTransmittanceAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThermalIrTransmittance() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrTransmittance(double newThermalIrTransmittance) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE, newThermalIrTransmittance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrTransmittance() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrTransmittance() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrTransmittanceAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrTransmittanceAsString(String newThermalIrTransmittanceAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE_AS_STRING, newThermalIrTransmittanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrTransmittanceAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrTransmittanceAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_TRANSMITTANCE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThermalIrEmissivityBack() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityBack(double newThermalIrEmissivityBack) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK, newThermalIrEmissivityBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityBack() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityBack() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrEmissivityBackAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityBackAsString(String newThermalIrEmissivityBackAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK_AS_STRING, newThermalIrEmissivityBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityBackAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityBackAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_BACK_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThermalIrEmissivityFront() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityFront(double newThermalIrEmissivityFront) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT, newThermalIrEmissivityFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityFront() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityFront() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalIrEmissivityFrontAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalIrEmissivityFrontAsString(String newThermalIrEmissivityFrontAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT_AS_STRING, newThermalIrEmissivityFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalIrEmissivityFrontAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalIrEmissivityFrontAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__THERMAL_IR_EMISSIVITY_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVisibleReflectanceBack() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceBack(double newVisibleReflectanceBack) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK, newVisibleReflectanceBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceBack() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceBack() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleReflectanceBackAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceBackAsString(String newVisibleReflectanceBackAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK_AS_STRING, newVisibleReflectanceBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceBackAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceBackAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_BACK_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVisibleReflectanceFront() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceFront(double newVisibleReflectanceFront) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT, newVisibleReflectanceFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceFront() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceFront() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibleReflectanceFrontAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleReflectanceFrontAsString(String newVisibleReflectanceFrontAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT_AS_STRING, newVisibleReflectanceFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisibleReflectanceFrontAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisibleReflectanceFrontAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__VISIBLE_REFLECTANCE_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSolarReflectanceFront() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceFront(double newSolarReflectanceFront) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT, newSolarReflectanceFront);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceFront() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceFront() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarReflectanceFrontAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceFrontAsString(String newSolarReflectanceFrontAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT_AS_STRING, newSolarReflectanceFrontAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceFrontAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceFrontAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_FRONT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSolarReflectanceBack() {
		return (Double) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceBack(double newSolarReflectanceBack) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK, newSolarReflectanceBack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceBack() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceBack() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolarReflectanceBackAsString() {
		return (String) eGet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolarReflectanceBackAsString(String newSolarReflectanceBackAsString) {
		eSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK_AS_STRING, newSolarReflectanceBackAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSolarReflectanceBackAsString() {
		eUnset(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSolarReflectanceBackAsString() {
		return eIsSet(LogPackage.Literals.IFC_OPTICAL_MATERIAL_PROPERTIES__SOLAR_REFLECTANCE_BACK_AS_STRING);
	}

} //IfcOpticalMaterialPropertiesImpl
