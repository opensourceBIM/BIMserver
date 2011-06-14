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
import org.bimserver.models.ifc2x3.IfcMechanicalConcreteMaterialProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Concrete Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getCompressiveStrength <em>Compressive Strength</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getCompressiveStrengthAsString <em>Compressive Strength As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getMaxAggregateSize <em>Max Aggregate Size</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getMaxAggregateSizeAsString <em>Max Aggregate Size As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getAdmixturesDescription <em>Admixtures Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getWorkability <em>Workability</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getProtectivePoreRatio <em>Protective Pore Ratio</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getProtectivePoreRatioAsString <em>Protective Pore Ratio As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl#getWaterImpermeability <em>Water Impermeability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalConcreteMaterialPropertiesImpl extends IfcMechanicalMaterialPropertiesImpl implements IfcMechanicalConcreteMaterialProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalConcreteMaterialPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCompressiveStrength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressiveStrength(float newCompressiveStrength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrength(), newCompressiveStrength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressiveStrength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressiveStrength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressiveStrengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressiveStrengthAsString(String newCompressiveStrengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrengthAsString(), newCompressiveStrengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressiveStrengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressiveStrengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_CompressiveStrengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxAggregateSize()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSize(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAggregateSize(float newMaxAggregateSize)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSize(), newMaxAggregateSize);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxAggregateSize()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSize());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxAggregateSize()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSize());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxAggregateSizeAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSizeAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAggregateSizeAsString(String newMaxAggregateSizeAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSizeAsString(), newMaxAggregateSizeAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxAggregateSizeAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSizeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxAggregateSizeAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_MaxAggregateSizeAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdmixturesDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_AdmixturesDescription(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmixturesDescription(String newAdmixturesDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_AdmixturesDescription(), newAdmixturesDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAdmixturesDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_AdmixturesDescription());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAdmixturesDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_AdmixturesDescription());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkability()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_Workability(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkability(String newWorkability)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_Workability(), newWorkability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWorkability()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_Workability());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWorkability()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_Workability());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getProtectivePoreRatio()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatio(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectivePoreRatio(float newProtectivePoreRatio)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatio(), newProtectivePoreRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProtectivePoreRatio()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProtectivePoreRatio()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatio());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtectivePoreRatioAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatioAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectivePoreRatioAsString(String newProtectivePoreRatioAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatioAsString(), newProtectivePoreRatioAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProtectivePoreRatioAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProtectivePoreRatioAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatioAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWaterImpermeability()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_WaterImpermeability(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaterImpermeability(String newWaterImpermeability)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_WaterImpermeability(), newWaterImpermeability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWaterImpermeability()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_WaterImpermeability());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWaterImpermeability()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalConcreteMaterialProperties_WaterImpermeability());
	}

} //IfcMechanicalConcreteMaterialPropertiesImpl
