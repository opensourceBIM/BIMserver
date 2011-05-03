/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMechanicalMaterialProperties;

import org.bimserver.models.ifc2x3.impl.IfcMaterialPropertiesImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getDynamicViscosity <em>Dynamic Viscosity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getDynamicViscosityAsString <em>Dynamic Viscosity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getYoungModulus <em>Young Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getYoungModulusAsString <em>Young Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getShearModulus <em>Shear Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getShearModulusAsString <em>Shear Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getPoissonRatio <em>Poisson Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getPoissonRatioAsString <em>Poisson Ratio As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getThermalExpansionCoefficient <em>Thermal Expansion Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl#getThermalExpansionCoefficientAsString <em>Thermal Expansion Coefficient As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcMechanicalMaterialProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalMaterialPropertiesImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDynamicViscosity()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosity(float newDynamicViscosity)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY, newDynamicViscosity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosity()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosity()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDynamicViscosityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosityAsString(String newDynamicViscosityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING, newDynamicViscosityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__DYNAMIC_VISCOSITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYoungModulus()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulus(float newYoungModulus)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS, newYoungModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulus()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulus()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYoungModulusAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulusAsString(String newYoungModulusAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING, newYoungModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulusAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulusAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__YOUNG_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearModulus()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulus(float newShearModulus)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS, newShearModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulus()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulus()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearModulusAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulusAsString(String newShearModulusAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING, newShearModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulusAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulusAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__SHEAR_MODULUS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPoissonRatio()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatio(float newPoissonRatio)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO, newPoissonRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatio()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatio()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoissonRatioAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatioAsString(String newPoissonRatioAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING, newPoissonRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatioAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatioAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__POISSON_RATIO_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalExpansionCoefficient()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficient(float newThermalExpansionCoefficient)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT, newThermalExpansionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficient()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficient()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalExpansionCoefficientAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficientAsString(String newThermalExpansionCoefficientAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING, newThermalExpansionCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficientAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficientAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_MATERIAL_PROPERTIES__THERMAL_EXPANSION_COEFFICIENT_AS_STRING);
	}

} //IfcMechanicalMaterialPropertiesImpl
