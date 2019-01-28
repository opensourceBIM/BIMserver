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

public interface IfcMechanicalMaterialProperties extends IfcMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Dynamic Viscosity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Viscosity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Viscosity</em>' attribute.
	 * @see #isSetDynamicViscosity()
	 * @see #unsetDynamicViscosity()
	 * @see #setDynamicViscosity(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_DynamicViscosity()
	 * @model unsettable="true"
	 * @generated
	 */
	double getDynamicViscosity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosity <em>Dynamic Viscosity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Viscosity</em>' attribute.
	 * @see #isSetDynamicViscosity()
	 * @see #unsetDynamicViscosity()
	 * @see #getDynamicViscosity()
	 * @generated
	 */
	void setDynamicViscosity(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosity <em>Dynamic Viscosity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDynamicViscosity()
	 * @see #getDynamicViscosity()
	 * @see #setDynamicViscosity(double)
	 * @generated
	 */
	void unsetDynamicViscosity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosity <em>Dynamic Viscosity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dynamic Viscosity</em>' attribute is set.
	 * @see #unsetDynamicViscosity()
	 * @see #getDynamicViscosity()
	 * @see #setDynamicViscosity(double)
	 * @generated
	 */
	boolean isSetDynamicViscosity();

	/**
	 * Returns the value of the '<em><b>Dynamic Viscosity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Viscosity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Viscosity As String</em>' attribute.
	 * @see #isSetDynamicViscosityAsString()
	 * @see #unsetDynamicViscosityAsString()
	 * @see #setDynamicViscosityAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_DynamicViscosityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDynamicViscosityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosityAsString <em>Dynamic Viscosity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Viscosity As String</em>' attribute.
	 * @see #isSetDynamicViscosityAsString()
	 * @see #unsetDynamicViscosityAsString()
	 * @see #getDynamicViscosityAsString()
	 * @generated
	 */
	void setDynamicViscosityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosityAsString <em>Dynamic Viscosity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDynamicViscosityAsString()
	 * @see #getDynamicViscosityAsString()
	 * @see #setDynamicViscosityAsString(String)
	 * @generated
	 */
	void unsetDynamicViscosityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getDynamicViscosityAsString <em>Dynamic Viscosity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dynamic Viscosity As String</em>' attribute is set.
	 * @see #unsetDynamicViscosityAsString()
	 * @see #getDynamicViscosityAsString()
	 * @see #setDynamicViscosityAsString(String)
	 * @generated
	 */
	boolean isSetDynamicViscosityAsString();

	/**
	 * Returns the value of the '<em><b>Young Modulus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Young Modulus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Young Modulus</em>' attribute.
	 * @see #isSetYoungModulus()
	 * @see #unsetYoungModulus()
	 * @see #setYoungModulus(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_YoungModulus()
	 * @model unsettable="true"
	 * @generated
	 */
	double getYoungModulus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulus <em>Young Modulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Young Modulus</em>' attribute.
	 * @see #isSetYoungModulus()
	 * @see #unsetYoungModulus()
	 * @see #getYoungModulus()
	 * @generated
	 */
	void setYoungModulus(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulus <em>Young Modulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYoungModulus()
	 * @see #getYoungModulus()
	 * @see #setYoungModulus(double)
	 * @generated
	 */
	void unsetYoungModulus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulus <em>Young Modulus</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Young Modulus</em>' attribute is set.
	 * @see #unsetYoungModulus()
	 * @see #getYoungModulus()
	 * @see #setYoungModulus(double)
	 * @generated
	 */
	boolean isSetYoungModulus();

	/**
	 * Returns the value of the '<em><b>Young Modulus As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Young Modulus As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Young Modulus As String</em>' attribute.
	 * @see #isSetYoungModulusAsString()
	 * @see #unsetYoungModulusAsString()
	 * @see #setYoungModulusAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_YoungModulusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getYoungModulusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulusAsString <em>Young Modulus As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Young Modulus As String</em>' attribute.
	 * @see #isSetYoungModulusAsString()
	 * @see #unsetYoungModulusAsString()
	 * @see #getYoungModulusAsString()
	 * @generated
	 */
	void setYoungModulusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulusAsString <em>Young Modulus As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetYoungModulusAsString()
	 * @see #getYoungModulusAsString()
	 * @see #setYoungModulusAsString(String)
	 * @generated
	 */
	void unsetYoungModulusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getYoungModulusAsString <em>Young Modulus As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Young Modulus As String</em>' attribute is set.
	 * @see #unsetYoungModulusAsString()
	 * @see #getYoungModulusAsString()
	 * @see #setYoungModulusAsString(String)
	 * @generated
	 */
	boolean isSetYoungModulusAsString();

	/**
	 * Returns the value of the '<em><b>Shear Modulus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Modulus</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Modulus</em>' attribute.
	 * @see #isSetShearModulus()
	 * @see #unsetShearModulus()
	 * @see #setShearModulus(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_ShearModulus()
	 * @model unsettable="true"
	 * @generated
	 */
	double getShearModulus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulus <em>Shear Modulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Modulus</em>' attribute.
	 * @see #isSetShearModulus()
	 * @see #unsetShearModulus()
	 * @see #getShearModulus()
	 * @generated
	 */
	void setShearModulus(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulus <em>Shear Modulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearModulus()
	 * @see #getShearModulus()
	 * @see #setShearModulus(double)
	 * @generated
	 */
	void unsetShearModulus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulus <em>Shear Modulus</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Modulus</em>' attribute is set.
	 * @see #unsetShearModulus()
	 * @see #getShearModulus()
	 * @see #setShearModulus(double)
	 * @generated
	 */
	boolean isSetShearModulus();

	/**
	 * Returns the value of the '<em><b>Shear Modulus As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Modulus As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Modulus As String</em>' attribute.
	 * @see #isSetShearModulusAsString()
	 * @see #unsetShearModulusAsString()
	 * @see #setShearModulusAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_ShearModulusAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getShearModulusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulusAsString <em>Shear Modulus As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Modulus As String</em>' attribute.
	 * @see #isSetShearModulusAsString()
	 * @see #unsetShearModulusAsString()
	 * @see #getShearModulusAsString()
	 * @generated
	 */
	void setShearModulusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulusAsString <em>Shear Modulus As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearModulusAsString()
	 * @see #getShearModulusAsString()
	 * @see #setShearModulusAsString(String)
	 * @generated
	 */
	void unsetShearModulusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getShearModulusAsString <em>Shear Modulus As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Modulus As String</em>' attribute is set.
	 * @see #unsetShearModulusAsString()
	 * @see #getShearModulusAsString()
	 * @see #setShearModulusAsString(String)
	 * @generated
	 */
	boolean isSetShearModulusAsString();

	/**
	 * Returns the value of the '<em><b>Poisson Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Poisson Ratio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Poisson Ratio</em>' attribute.
	 * @see #isSetPoissonRatio()
	 * @see #unsetPoissonRatio()
	 * @see #setPoissonRatio(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_PoissonRatio()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPoissonRatio();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatio <em>Poisson Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Poisson Ratio</em>' attribute.
	 * @see #isSetPoissonRatio()
	 * @see #unsetPoissonRatio()
	 * @see #getPoissonRatio()
	 * @generated
	 */
	void setPoissonRatio(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatio <em>Poisson Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPoissonRatio()
	 * @see #getPoissonRatio()
	 * @see #setPoissonRatio(double)
	 * @generated
	 */
	void unsetPoissonRatio();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatio <em>Poisson Ratio</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Poisson Ratio</em>' attribute is set.
	 * @see #unsetPoissonRatio()
	 * @see #getPoissonRatio()
	 * @see #setPoissonRatio(double)
	 * @generated
	 */
	boolean isSetPoissonRatio();

	/**
	 * Returns the value of the '<em><b>Poisson Ratio As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Poisson Ratio As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Poisson Ratio As String</em>' attribute.
	 * @see #isSetPoissonRatioAsString()
	 * @see #unsetPoissonRatioAsString()
	 * @see #setPoissonRatioAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_PoissonRatioAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPoissonRatioAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatioAsString <em>Poisson Ratio As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Poisson Ratio As String</em>' attribute.
	 * @see #isSetPoissonRatioAsString()
	 * @see #unsetPoissonRatioAsString()
	 * @see #getPoissonRatioAsString()
	 * @generated
	 */
	void setPoissonRatioAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatioAsString <em>Poisson Ratio As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPoissonRatioAsString()
	 * @see #getPoissonRatioAsString()
	 * @see #setPoissonRatioAsString(String)
	 * @generated
	 */
	void unsetPoissonRatioAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getPoissonRatioAsString <em>Poisson Ratio As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Poisson Ratio As String</em>' attribute is set.
	 * @see #unsetPoissonRatioAsString()
	 * @see #getPoissonRatioAsString()
	 * @see #setPoissonRatioAsString(String)
	 * @generated
	 */
	boolean isSetPoissonRatioAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Expansion Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Expansion Coefficient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Expansion Coefficient</em>' attribute.
	 * @see #isSetThermalExpansionCoefficient()
	 * @see #unsetThermalExpansionCoefficient()
	 * @see #setThermalExpansionCoefficient(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient()
	 * @model unsettable="true"
	 * @generated
	 */
	double getThermalExpansionCoefficient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Expansion Coefficient</em>' attribute.
	 * @see #isSetThermalExpansionCoefficient()
	 * @see #unsetThermalExpansionCoefficient()
	 * @see #getThermalExpansionCoefficient()
	 * @generated
	 */
	void setThermalExpansionCoefficient(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalExpansionCoefficient()
	 * @see #getThermalExpansionCoefficient()
	 * @see #setThermalExpansionCoefficient(double)
	 * @generated
	 */
	void unsetThermalExpansionCoefficient();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Expansion Coefficient</em>' attribute is set.
	 * @see #unsetThermalExpansionCoefficient()
	 * @see #getThermalExpansionCoefficient()
	 * @see #setThermalExpansionCoefficient(double)
	 * @generated
	 */
	boolean isSetThermalExpansionCoefficient();

	/**
	 * Returns the value of the '<em><b>Thermal Expansion Coefficient As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Expansion Coefficient As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Expansion Coefficient As String</em>' attribute.
	 * @see #isSetThermalExpansionCoefficientAsString()
	 * @see #unsetThermalExpansionCoefficientAsString()
	 * @see #setThermalExpansionCoefficientAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalExpansionCoefficientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficientAsString <em>Thermal Expansion Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Expansion Coefficient As String</em>' attribute.
	 * @see #isSetThermalExpansionCoefficientAsString()
	 * @see #unsetThermalExpansionCoefficientAsString()
	 * @see #getThermalExpansionCoefficientAsString()
	 * @generated
	 */
	void setThermalExpansionCoefficientAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficientAsString <em>Thermal Expansion Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalExpansionCoefficientAsString()
	 * @see #getThermalExpansionCoefficientAsString()
	 * @see #setThermalExpansionCoefficientAsString(String)
	 * @generated
	 */
	void unsetThermalExpansionCoefficientAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcMechanicalMaterialProperties#getThermalExpansionCoefficientAsString <em>Thermal Expansion Coefficient As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Expansion Coefficient As String</em>' attribute is set.
	 * @see #unsetThermalExpansionCoefficientAsString()
	 * @see #getThermalExpansionCoefficientAsString()
	 * @see #setThermalExpansionCoefficientAsString(String)
	 * @generated
	 */
	boolean isSetThermalExpansionCoefficientAsString();

} // IfcMechanicalMaterialProperties
