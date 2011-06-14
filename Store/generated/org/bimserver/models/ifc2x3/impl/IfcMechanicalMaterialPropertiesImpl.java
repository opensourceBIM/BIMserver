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
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDynamicViscosity()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosity(float newDynamicViscosity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity(), newDynamicViscosity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosity()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosity()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDynamicViscosityAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicViscosityAsString(String newDynamicViscosityAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosityAsString(), newDynamicViscosityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDynamicViscosityAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDynamicViscosityAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_DynamicViscosityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYoungModulus()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulus(float newYoungModulus)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus(), newYoungModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulus()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulus()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYoungModulusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYoungModulusAsString(String newYoungModulusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulusAsString(), newYoungModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYoungModulusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYoungModulusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_YoungModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearModulus()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulus(float newShearModulus)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus(), newShearModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulus()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulus()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearModulusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearModulusAsString(String newShearModulusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulusAsString(), newShearModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearModulusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearModulusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ShearModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPoissonRatio()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatio(float newPoissonRatio)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio(), newPoissonRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatio()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatio()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoissonRatioAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatioAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoissonRatioAsString(String newPoissonRatioAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatioAsString(), newPoissonRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPoissonRatioAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPoissonRatioAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_PoissonRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalExpansionCoefficient()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficient(float newThermalExpansionCoefficient)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient(), newThermalExpansionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficient()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficient()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalExpansionCoefficientAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalExpansionCoefficientAsString(String newThermalExpansionCoefficientAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString(), newThermalExpansionCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalExpansionCoefficientAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalExpansionCoefficientAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString());
	}

} //IfcMechanicalMaterialPropertiesImpl
