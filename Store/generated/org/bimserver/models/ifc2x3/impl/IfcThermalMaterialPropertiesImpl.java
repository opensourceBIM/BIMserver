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
import org.bimserver.models.ifc2x3.IfcThermalMaterialProperties;

import org.bimserver.models.ifc2x3.impl.IfcMaterialPropertiesImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Thermal Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getBoilingPoint <em>Boiling Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getBoilingPointAsString <em>Boiling Point As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getFreezingPoint <em>Freezing Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getFreezingPointAsString <em>Freezing Point As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getThermalConductivity <em>Thermal Conductivity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl#getThermalConductivityAsString <em>Thermal Conductivity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcThermalMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcThermalMaterialProperties
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
	protected IfcThermalMaterialPropertiesImpl()
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
		return Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSpecificHeatCapacity()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacity(float newSpecificHeatCapacity)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY, newSpecificHeatCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacity()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacity()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificHeatCapacityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificHeatCapacityAsString(String newSpecificHeatCapacityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING, newSpecificHeatCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpecificHeatCapacityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpecificHeatCapacityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__SPECIFIC_HEAT_CAPACITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoilingPoint()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoilingPoint(float newBoilingPoint)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT, newBoilingPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoilingPoint()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoilingPoint()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoilingPointAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoilingPointAsString(String newBoilingPointAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING, newBoilingPointAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBoilingPointAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBoilingPointAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__BOILING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFreezingPoint()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreezingPoint(float newFreezingPoint)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT, newFreezingPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreezingPoint()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreezingPoint()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFreezingPointAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreezingPointAsString(String newFreezingPointAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING, newFreezingPointAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFreezingPointAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFreezingPointAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__FREEZING_POINT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getThermalConductivity()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalConductivity(float newThermalConductivity)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY, newThermalConductivity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalConductivity()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalConductivity()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThermalConductivityAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThermalConductivityAsString(String newThermalConductivityAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING, newThermalConductivityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetThermalConductivityAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetThermalConductivityAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_THERMAL_MATERIAL_PROPERTIES__THERMAL_CONDUCTIVITY_AS_STRING);
	}

} //IfcThermalMaterialPropertiesImpl
