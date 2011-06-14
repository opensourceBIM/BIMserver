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
import org.bimserver.models.ifc2x3.IfcProductsOfCombustionProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Products Of Combustion Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getN20Content <em>N20 Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getN20ContentAsString <em>N20 Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getCOContent <em>CO Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getCOContentAsString <em>CO Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getCO2Content <em>CO2 Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl#getCO2ContentAsString <em>CO2 Content As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProductsOfCombustionPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcProductsOfCombustionProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProductsOfCombustionPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSpecificHeatCapacity()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacity(float newSpecificHeatCapacity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacity(), newSpecificHeatCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacity()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacity()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificHeatCapacityAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacityAsString(String newSpecificHeatCapacityAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString(), newSpecificHeatCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacityAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacityAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getN20Content()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20Content(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN20Content(float newN20Content)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20Content(), newN20Content);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetN20Content()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20Content());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetN20Content()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20Content());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getN20ContentAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20ContentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN20ContentAsString(String newN20ContentAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20ContentAsString(), newN20ContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetN20ContentAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20ContentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetN20ContentAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_N20ContentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCOContent()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCOContent(float newCOContent)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContent(), newCOContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCOContent()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCOContent()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCOContentAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCOContentAsString(String newCOContentAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContentAsString(), newCOContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCOContentAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCOContentAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_COContentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCO2Content()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2Content(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCO2Content(float newCO2Content)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2Content(), newCO2Content);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCO2Content()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2Content());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCO2Content()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2Content());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCO2ContentAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2ContentAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCO2ContentAsString(String newCO2ContentAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2ContentAsString(), newCO2ContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCO2ContentAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2ContentAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCO2ContentAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProductsOfCombustionProperties_CO2ContentAsString());
	}

} //IfcProductsOfCombustionPropertiesImpl
