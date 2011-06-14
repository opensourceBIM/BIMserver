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
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYieldStress()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStress(float newYieldStress)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress(), newYieldStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStress()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStress()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYieldStressAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYieldStressAsString(String newYieldStressAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStressAsString(), newYieldStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetYieldStressAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetYieldStressAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_YieldStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUltimateStress()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStress(float newUltimateStress)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress(), newUltimateStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStress()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStress()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStressAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStressAsString(String newUltimateStressAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStressAsString(), newUltimateStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStressAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStressAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUltimateStrain()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrain(float newUltimateStrain)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain(), newUltimateStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrain()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrain()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUltimateStrainAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUltimateStrainAsString(String newUltimateStrainAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString(), newUltimateStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUltimateStrainAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUltimateStrainAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHardeningModule()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModule(float newHardeningModule)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule(), newHardeningModule);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModule()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModule()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModule());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHardeningModuleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardeningModuleAsString(String newHardeningModuleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString(), newHardeningModuleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardeningModuleAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardeningModuleAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getProportionalStress()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStress(float newProportionalStress)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress(), newProportionalStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStress()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStress()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProportionalStressAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProportionalStressAsString(String newProportionalStressAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString(), newProportionalStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProportionalStressAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProportionalStressAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPlasticStrain()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrain(float newPlasticStrain)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain(), newPlasticStrain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrain()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrain()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticStrainAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticStrainAsString(String newPlasticStrainAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString(), newPlasticStrainAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticStrainAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticStrainAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelaxation> getRelaxations()
	{
		return (EList<IfcRelaxation>)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelaxations()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelaxations()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalSteelMaterialProperties_Relaxations());
	}

} //IfcMechanicalSteelMaterialPropertiesImpl
