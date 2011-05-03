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
import org.bimserver.models.ifc2x3.IfcHygroscopicMaterialProperties;

import org.bimserver.models.ifc2x3.impl.IfcMaterialPropertiesImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Hygroscopic Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactor <em>Upper Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactorAsString <em>Upper Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactor <em>Lower Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactorAsString <em>Lower Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacity <em>Isothermal Moisture Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacityAsString <em>Isothermal Moisture Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeability <em>Vapor Permeability</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeabilityAsString <em>Vapor Permeability As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivity <em>Moisture Diffusivity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivityAsString <em>Moisture Diffusivity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcHygroscopicMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcHygroscopicMaterialProperties
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
	protected IfcHygroscopicMaterialPropertiesImpl()
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
		return Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUpperVaporResistanceFactor()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactor(float newUpperVaporResistanceFactor)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR, newUpperVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactor()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactor()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpperVaporResistanceFactorAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactorAsString(String newUpperVaporResistanceFactorAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING, newUpperVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactorAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactorAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__UPPER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLowerVaporResistanceFactor()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactor(float newLowerVaporResistanceFactor)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR, newLowerVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactor()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactor()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerVaporResistanceFactorAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactorAsString(String newLowerVaporResistanceFactorAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING, newLowerVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactorAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactorAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__LOWER_VAPOR_RESISTANCE_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getIsothermalMoistureCapacity()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacity(float newIsothermalMoistureCapacity)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY, newIsothermalMoistureCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacity()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacity()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsothermalMoistureCapacityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacityAsString(String newIsothermalMoistureCapacityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING, newIsothermalMoistureCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__ISOTHERMAL_MOISTURE_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVaporPermeability()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeability(float newVaporPermeability)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY, newVaporPermeability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeability()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeability()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVaporPermeabilityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeabilityAsString(String newVaporPermeabilityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING, newVaporPermeabilityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeabilityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeabilityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__VAPOR_PERMEABILITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMoistureDiffusivity()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivity(float newMoistureDiffusivity)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY, newMoistureDiffusivity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivity()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivity()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMoistureDiffusivityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivityAsString(String newMoistureDiffusivityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING, newMoistureDiffusivityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES__MOISTURE_DIFFUSIVITY_AS_STRING);
	}

} //IfcHygroscopicMaterialPropertiesImpl
