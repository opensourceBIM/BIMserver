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
package org.bimserver.models.ifc2x3tc1;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Mechanical Steel Material Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStress <em>Yield Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStressAsString <em>Yield Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStress <em>Ultimate Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStressAsString <em>Ultimate Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrain <em>Ultimate Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrainAsString <em>Ultimate Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModule <em>Hardening Module</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModuleAsString <em>Hardening Module As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStress <em>Proportional Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStressAsString <em>Proportional Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrain <em>Plastic Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrainAsString <em>Plastic Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getRelaxations <em>Relaxations</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties()
 * @model
 * @generated
 */
public interface IfcMechanicalSteelMaterialProperties extends IfcMechanicalMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Yield Stress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yield Stress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yield Stress</em>' attribute.
	 * @see #isSetYieldStress()
	 * @see #unsetYieldStress()
	 * @see #setYieldStress(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_YieldStress()
	 * @model unsettable="true"
	 * @generated
	 */
	double getYieldStress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStress <em>Yield Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yield Stress</em>' attribute.
	 * @see #isSetYieldStress()
	 * @see #unsetYieldStress()
	 * @see #getYieldStress()
	 * @generated
	 */
	void setYieldStress(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStress <em>Yield Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYieldStress()
	 * @see #getYieldStress()
	 * @see #setYieldStress(double)
	 * @generated
	 */
	void unsetYieldStress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStress <em>Yield Stress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Yield Stress</em>' attribute is set.
	 * @see #unsetYieldStress()
	 * @see #getYieldStress()
	 * @see #setYieldStress(double)
	 * @generated
	 */
	boolean isSetYieldStress();

	/**
	 * Returns the value of the '<em><b>Yield Stress As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yield Stress As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yield Stress As String</em>' attribute.
	 * @see #isSetYieldStressAsString()
	 * @see #unsetYieldStressAsString()
	 * @see #setYieldStressAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_YieldStressAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getYieldStressAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStressAsString <em>Yield Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yield Stress As String</em>' attribute.
	 * @see #isSetYieldStressAsString()
	 * @see #unsetYieldStressAsString()
	 * @see #getYieldStressAsString()
	 * @generated
	 */
	void setYieldStressAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStressAsString <em>Yield Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYieldStressAsString()
	 * @see #getYieldStressAsString()
	 * @see #setYieldStressAsString(String)
	 * @generated
	 */
	void unsetYieldStressAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getYieldStressAsString <em>Yield Stress As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Yield Stress As String</em>' attribute is set.
	 * @see #unsetYieldStressAsString()
	 * @see #getYieldStressAsString()
	 * @see #setYieldStressAsString(String)
	 * @generated
	 */
	boolean isSetYieldStressAsString();

	/**
	 * Returns the value of the '<em><b>Ultimate Stress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ultimate Stress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ultimate Stress</em>' attribute.
	 * @see #isSetUltimateStress()
	 * @see #unsetUltimateStress()
	 * @see #setUltimateStress(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_UltimateStress()
	 * @model unsettable="true"
	 * @generated
	 */
	double getUltimateStress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStress <em>Ultimate Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ultimate Stress</em>' attribute.
	 * @see #isSetUltimateStress()
	 * @see #unsetUltimateStress()
	 * @see #getUltimateStress()
	 * @generated
	 */
	void setUltimateStress(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStress <em>Ultimate Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUltimateStress()
	 * @see #getUltimateStress()
	 * @see #setUltimateStress(double)
	 * @generated
	 */
	void unsetUltimateStress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStress <em>Ultimate Stress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ultimate Stress</em>' attribute is set.
	 * @see #unsetUltimateStress()
	 * @see #getUltimateStress()
	 * @see #setUltimateStress(double)
	 * @generated
	 */
	boolean isSetUltimateStress();

	/**
	 * Returns the value of the '<em><b>Ultimate Stress As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ultimate Stress As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ultimate Stress As String</em>' attribute.
	 * @see #isSetUltimateStressAsString()
	 * @see #unsetUltimateStressAsString()
	 * @see #setUltimateStressAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_UltimateStressAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUltimateStressAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStressAsString <em>Ultimate Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ultimate Stress As String</em>' attribute.
	 * @see #isSetUltimateStressAsString()
	 * @see #unsetUltimateStressAsString()
	 * @see #getUltimateStressAsString()
	 * @generated
	 */
	void setUltimateStressAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStressAsString <em>Ultimate Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUltimateStressAsString()
	 * @see #getUltimateStressAsString()
	 * @see #setUltimateStressAsString(String)
	 * @generated
	 */
	void unsetUltimateStressAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStressAsString <em>Ultimate Stress As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ultimate Stress As String</em>' attribute is set.
	 * @see #unsetUltimateStressAsString()
	 * @see #getUltimateStressAsString()
	 * @see #setUltimateStressAsString(String)
	 * @generated
	 */
	boolean isSetUltimateStressAsString();

	/**
	 * Returns the value of the '<em><b>Ultimate Strain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ultimate Strain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ultimate Strain</em>' attribute.
	 * @see #isSetUltimateStrain()
	 * @see #unsetUltimateStrain()
	 * @see #setUltimateStrain(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_UltimateStrain()
	 * @model unsettable="true"
	 * @generated
	 */
	double getUltimateStrain();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrain <em>Ultimate Strain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ultimate Strain</em>' attribute.
	 * @see #isSetUltimateStrain()
	 * @see #unsetUltimateStrain()
	 * @see #getUltimateStrain()
	 * @generated
	 */
	void setUltimateStrain(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrain <em>Ultimate Strain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUltimateStrain()
	 * @see #getUltimateStrain()
	 * @see #setUltimateStrain(double)
	 * @generated
	 */
	void unsetUltimateStrain();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrain <em>Ultimate Strain</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ultimate Strain</em>' attribute is set.
	 * @see #unsetUltimateStrain()
	 * @see #getUltimateStrain()
	 * @see #setUltimateStrain(double)
	 * @generated
	 */
	boolean isSetUltimateStrain();

	/**
	 * Returns the value of the '<em><b>Ultimate Strain As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ultimate Strain As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ultimate Strain As String</em>' attribute.
	 * @see #isSetUltimateStrainAsString()
	 * @see #unsetUltimateStrainAsString()
	 * @see #setUltimateStrainAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUltimateStrainAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrainAsString <em>Ultimate Strain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ultimate Strain As String</em>' attribute.
	 * @see #isSetUltimateStrainAsString()
	 * @see #unsetUltimateStrainAsString()
	 * @see #getUltimateStrainAsString()
	 * @generated
	 */
	void setUltimateStrainAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrainAsString <em>Ultimate Strain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUltimateStrainAsString()
	 * @see #getUltimateStrainAsString()
	 * @see #setUltimateStrainAsString(String)
	 * @generated
	 */
	void unsetUltimateStrainAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getUltimateStrainAsString <em>Ultimate Strain As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ultimate Strain As String</em>' attribute is set.
	 * @see #unsetUltimateStrainAsString()
	 * @see #getUltimateStrainAsString()
	 * @see #setUltimateStrainAsString(String)
	 * @generated
	 */
	boolean isSetUltimateStrainAsString();

	/**
	 * Returns the value of the '<em><b>Hardening Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hardening Module</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hardening Module</em>' attribute.
	 * @see #isSetHardeningModule()
	 * @see #unsetHardeningModule()
	 * @see #setHardeningModule(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_HardeningModule()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHardeningModule();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModule <em>Hardening Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hardening Module</em>' attribute.
	 * @see #isSetHardeningModule()
	 * @see #unsetHardeningModule()
	 * @see #getHardeningModule()
	 * @generated
	 */
	void setHardeningModule(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModule <em>Hardening Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHardeningModule()
	 * @see #getHardeningModule()
	 * @see #setHardeningModule(double)
	 * @generated
	 */
	void unsetHardeningModule();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModule <em>Hardening Module</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Hardening Module</em>' attribute is set.
	 * @see #unsetHardeningModule()
	 * @see #getHardeningModule()
	 * @see #setHardeningModule(double)
	 * @generated
	 */
	boolean isSetHardeningModule();

	/**
	 * Returns the value of the '<em><b>Hardening Module As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hardening Module As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hardening Module As String</em>' attribute.
	 * @see #isSetHardeningModuleAsString()
	 * @see #unsetHardeningModuleAsString()
	 * @see #setHardeningModuleAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHardeningModuleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModuleAsString <em>Hardening Module As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hardening Module As String</em>' attribute.
	 * @see #isSetHardeningModuleAsString()
	 * @see #unsetHardeningModuleAsString()
	 * @see #getHardeningModuleAsString()
	 * @generated
	 */
	void setHardeningModuleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModuleAsString <em>Hardening Module As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHardeningModuleAsString()
	 * @see #getHardeningModuleAsString()
	 * @see #setHardeningModuleAsString(String)
	 * @generated
	 */
	void unsetHardeningModuleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getHardeningModuleAsString <em>Hardening Module As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Hardening Module As String</em>' attribute is set.
	 * @see #unsetHardeningModuleAsString()
	 * @see #getHardeningModuleAsString()
	 * @see #setHardeningModuleAsString(String)
	 * @generated
	 */
	boolean isSetHardeningModuleAsString();

	/**
	 * Returns the value of the '<em><b>Proportional Stress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proportional Stress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proportional Stress</em>' attribute.
	 * @see #isSetProportionalStress()
	 * @see #unsetProportionalStress()
	 * @see #setProportionalStress(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_ProportionalStress()
	 * @model unsettable="true"
	 * @generated
	 */
	double getProportionalStress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStress <em>Proportional Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proportional Stress</em>' attribute.
	 * @see #isSetProportionalStress()
	 * @see #unsetProportionalStress()
	 * @see #getProportionalStress()
	 * @generated
	 */
	void setProportionalStress(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStress <em>Proportional Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProportionalStress()
	 * @see #getProportionalStress()
	 * @see #setProportionalStress(double)
	 * @generated
	 */
	void unsetProportionalStress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStress <em>Proportional Stress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Proportional Stress</em>' attribute is set.
	 * @see #unsetProportionalStress()
	 * @see #getProportionalStress()
	 * @see #setProportionalStress(double)
	 * @generated
	 */
	boolean isSetProportionalStress();

	/**
	 * Returns the value of the '<em><b>Proportional Stress As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proportional Stress As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proportional Stress As String</em>' attribute.
	 * @see #isSetProportionalStressAsString()
	 * @see #unsetProportionalStressAsString()
	 * @see #setProportionalStressAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getProportionalStressAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStressAsString <em>Proportional Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proportional Stress As String</em>' attribute.
	 * @see #isSetProportionalStressAsString()
	 * @see #unsetProportionalStressAsString()
	 * @see #getProportionalStressAsString()
	 * @generated
	 */
	void setProportionalStressAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStressAsString <em>Proportional Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProportionalStressAsString()
	 * @see #getProportionalStressAsString()
	 * @see #setProportionalStressAsString(String)
	 * @generated
	 */
	void unsetProportionalStressAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getProportionalStressAsString <em>Proportional Stress As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Proportional Stress As String</em>' attribute is set.
	 * @see #unsetProportionalStressAsString()
	 * @see #getProportionalStressAsString()
	 * @see #setProportionalStressAsString(String)
	 * @generated
	 */
	boolean isSetProportionalStressAsString();

	/**
	 * Returns the value of the '<em><b>Plastic Strain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Strain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Strain</em>' attribute.
	 * @see #isSetPlasticStrain()
	 * @see #unsetPlasticStrain()
	 * @see #setPlasticStrain(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_PlasticStrain()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPlasticStrain();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrain <em>Plastic Strain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Strain</em>' attribute.
	 * @see #isSetPlasticStrain()
	 * @see #unsetPlasticStrain()
	 * @see #getPlasticStrain()
	 * @generated
	 */
	void setPlasticStrain(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrain <em>Plastic Strain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticStrain()
	 * @see #getPlasticStrain()
	 * @see #setPlasticStrain(double)
	 * @generated
	 */
	void unsetPlasticStrain();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrain <em>Plastic Strain</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Strain</em>' attribute is set.
	 * @see #unsetPlasticStrain()
	 * @see #getPlasticStrain()
	 * @see #setPlasticStrain(double)
	 * @generated
	 */
	boolean isSetPlasticStrain();

	/**
	 * Returns the value of the '<em><b>Plastic Strain As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Strain As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Strain As String</em>' attribute.
	 * @see #isSetPlasticStrainAsString()
	 * @see #unsetPlasticStrainAsString()
	 * @see #setPlasticStrainAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlasticStrainAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrainAsString <em>Plastic Strain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Strain As String</em>' attribute.
	 * @see #isSetPlasticStrainAsString()
	 * @see #unsetPlasticStrainAsString()
	 * @see #getPlasticStrainAsString()
	 * @generated
	 */
	void setPlasticStrainAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrainAsString <em>Plastic Strain As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticStrainAsString()
	 * @see #getPlasticStrainAsString()
	 * @see #setPlasticStrainAsString(String)
	 * @generated
	 */
	void unsetPlasticStrainAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getPlasticStrainAsString <em>Plastic Strain As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Strain As String</em>' attribute is set.
	 * @see #unsetPlasticStrainAsString()
	 * @see #getPlasticStrainAsString()
	 * @see #setPlasticStrainAsString(String)
	 * @generated
	 */
	boolean isSetPlasticStrainAsString();

	/**
	 * Returns the value of the '<em><b>Relaxations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelaxation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relaxations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relaxations</em>' reference list.
	 * @see #isSetRelaxations()
	 * @see #unsetRelaxations()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalSteelMaterialProperties_Relaxations()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcRelaxation> getRelaxations();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getRelaxations <em>Relaxations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelaxations()
	 * @see #getRelaxations()
	 * @generated
	 */
	void unsetRelaxations();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalSteelMaterialProperties#getRelaxations <em>Relaxations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relaxations</em>' reference list is set.
	 * @see #unsetRelaxations()
	 * @see #getRelaxations()
	 * @generated
	 */
	boolean isSetRelaxations();

} // IfcMechanicalSteelMaterialProperties
