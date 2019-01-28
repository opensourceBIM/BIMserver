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
import org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelaxation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Steel Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getYieldStress <em>Yield Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getYieldStressAsString <em>Yield Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStress <em>Ultimate Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStressAsString <em>Ultimate Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStrain <em>Ultimate Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStrainAsString <em>Ultimate Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getHardeningModule <em>Hardening Module</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getHardeningModuleAsString <em>Hardening Module As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getProportionalStress <em>Proportional Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getProportionalStressAsString <em>Proportional Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getPlasticStrain <em>Plastic Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getPlasticStrainAsString <em>Plastic Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcMechanicalSteelMaterialPropertiesImpl#getRelaxations <em>Relaxations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcMechanicalSteelMaterialPropertiesImpl extends IfcMechanicalMaterialPropertiesImpl
		implements IfcMechanicalSteelMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalSteelMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getYieldStress() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStress(double newYieldStress) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS, newYieldStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStress() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStress() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYieldStressAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStressAsString(String newYieldStressAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING,
				newYieldStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStressAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStressAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUltimateStress() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStress(double newUltimateStress) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS, newUltimateStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStress() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStress() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStressAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStressAsString(String newUltimateStressAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING,
				newUltimateStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStressAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStressAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUltimateStrain() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrain(double newUltimateStrain) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN, newUltimateStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrain() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrain() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStrainAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrainAsString(String newUltimateStrainAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING,
				newUltimateStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrainAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrainAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHardeningModule() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModule(double newHardeningModule) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE, newHardeningModule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModule() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModule() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHardeningModuleAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModuleAsString(String newHardeningModuleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING,
				newHardeningModuleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModuleAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModuleAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProportionalStress() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStress(double newProportionalStress) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS,
				newProportionalStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStress() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStress() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProportionalStressAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStressAsString(String newProportionalStressAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING,
				newProportionalStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStressAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStressAsString() {
		return eIsSet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPlasticStrain() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrain(double newPlasticStrain) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN, newPlasticStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrain() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrain() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticStrainAsString() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrainAsString(String newPlasticStrainAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING,
				newPlasticStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrainAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrainAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelaxation> getRelaxations() {
		return (EList<IfcRelaxation>) eGet(
				Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelaxations() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelaxations() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS);
	}

} //IfcMechanicalSteelMaterialPropertiesImpl
