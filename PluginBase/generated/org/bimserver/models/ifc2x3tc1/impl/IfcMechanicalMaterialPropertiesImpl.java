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
import org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getDynamicViscosity <em>Dynamic Viscosity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getDynamicViscosityAsString <em>Dynamic Viscosity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getYoungModulus <em>Young Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getYoungModulusAsString <em>Young Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getShearModulus <em>Shear Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getShearModulusAsString <em>Shear Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getPoissonRatio <em>Poisson Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getPoissonRatioAsString <em>Poisson Ratio As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalMaterialPropertiesImpl#getThermalExpansionCoefficientAsString <em>Thermal Expansion Coefficient As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMechanicalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl
		implements IfcMechanicalMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDynamicViscosity() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosity(double newDynamicViscosity) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY, newDynamicViscosity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosity() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosity() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDynamicViscosityAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosityAsString(String newDynamicViscosityAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING,
				newDynamicViscosityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosityAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosityAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getYoungModulus() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulus(double newYoungModulus) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS, newYoungModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulus() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulus() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYoungModulusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulusAsString(String newYoungModulusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING,
				newYoungModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getShearModulus() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulus(double newShearModulus) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS, newShearModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulus() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulus() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearModulusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulusAsString(String newShearModulusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING,
				newShearModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulusAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulusAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPoissonRatio() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatio(double newPoissonRatio) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO, newPoissonRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatio() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatio() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoissonRatioAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatioAsString(String newPoissonRatioAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING,
				newPoissonRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatioAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatioAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThermalExpansionCoefficient() {
		return (Double) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficient(double newThermalExpansionCoefficient) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT,
				newThermalExpansionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficient() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficient() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalExpansionCoefficientAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficientAsString(String newThermalExpansionCoefficientAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING,
				newThermalExpansionCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficientAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficientAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING);
	}

} //IfcMechanicalMaterialPropertiesImpl
