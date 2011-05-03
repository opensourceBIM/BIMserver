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
import org.bimserver.models.ifc2x3.IfcMechanicalSteelMaterialProperties;
import org.bimserver.models.ifc2x3.IfcRelaxation;

import org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Steel Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getYieldStress <em>Yield Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getYieldStressAsString <em>Yield Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStress <em>Ultimate Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStressAsString <em>Ultimate Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStrain <em>Ultimate Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getUltimateStrainAsString <em>Ultimate Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getHardeningModule <em>Hardening Module</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getHardeningModuleAsString <em>Hardening Module As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getProportionalStress <em>Proportional Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getProportionalStressAsString <em>Proportional Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getPlasticStrain <em>Plastic Strain</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getPlasticStrainAsString <em>Plastic Strain As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl#getRelaxations <em>Relaxations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalSteelMaterialPropertiesImpl extends IfcMechanicalMaterialPropertiesImpl implements IfcMechanicalSteelMaterialProperties
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
	protected IfcMechanicalSteelMaterialPropertiesImpl()
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
		return Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYieldStress()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStress(float newYieldStress)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS, newYieldStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStress()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStress()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYieldStressAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStressAsString(String newYieldStressAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING, newYieldStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStressAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStressAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__YIELD_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUltimateStress()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStress(float newUltimateStress)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS, newUltimateStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStress()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStress()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStressAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStressAsString(String newUltimateStressAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING, newUltimateStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStressAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStressAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUltimateStrain()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrain(float newUltimateStrain)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN, newUltimateStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrain()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrain()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStrainAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrainAsString(String newUltimateStrainAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING, newUltimateStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrainAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrainAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__ULTIMATE_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHardeningModule()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModule(float newHardeningModule)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE, newHardeningModule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModule()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModule()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHardeningModuleAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModuleAsString(String newHardeningModuleAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING, newHardeningModuleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModuleAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModuleAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__HARDENING_MODULE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getProportionalStress()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStress(float newProportionalStress)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS, newProportionalStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStress()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStress()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProportionalStressAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStressAsString(String newProportionalStressAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING, newProportionalStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStressAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStressAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PROPORTIONAL_STRESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPlasticStrain()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrain(float newPlasticStrain)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN, newPlasticStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrain()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrain()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticStrainAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrainAsString(String newPlasticStrainAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING, newPlasticStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrainAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrainAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__PLASTIC_STRAIN_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelaxation> getRelaxations()
	{
		return (EList<IfcRelaxation>)eGet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelaxations()
	{
		eUnset(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelaxations()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES__RELAXATIONS);
	}

} //IfcMechanicalSteelMaterialPropertiesImpl
