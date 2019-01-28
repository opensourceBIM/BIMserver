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

public interface IfcThermalMaterialProperties extends IfcMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Specific Heat Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Heat Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Heat Capacity</em>' attribute.
	 * @see #isSetSpecificHeatCapacity()
	 * @see #unsetSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_SpecificHeatCapacity()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSpecificHeatCapacity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Heat Capacity</em>' attribute.
	 * @see #isSetSpecificHeatCapacity()
	 * @see #unsetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @generated
	 */
	void setSpecificHeatCapacity(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @generated
	 */
	void unsetSpecificHeatCapacity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacity <em>Specific Heat Capacity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specific Heat Capacity</em>' attribute is set.
	 * @see #unsetSpecificHeatCapacity()
	 * @see #getSpecificHeatCapacity()
	 * @see #setSpecificHeatCapacity(double)
	 * @generated
	 */
	boolean isSetSpecificHeatCapacity();

	/**
	 * Returns the value of the '<em><b>Specific Heat Capacity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Heat Capacity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Heat Capacity As String</em>' attribute.
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_SpecificHeatCapacityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSpecificHeatCapacityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Heat Capacity As String</em>' attribute.
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @generated
	 */
	void setSpecificHeatCapacityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @generated
	 */
	void unsetSpecificHeatCapacityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getSpecificHeatCapacityAsString <em>Specific Heat Capacity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specific Heat Capacity As String</em>' attribute is set.
	 * @see #unsetSpecificHeatCapacityAsString()
	 * @see #getSpecificHeatCapacityAsString()
	 * @see #setSpecificHeatCapacityAsString(String)
	 * @generated
	 */
	boolean isSetSpecificHeatCapacityAsString();

	/**
	 * Returns the value of the '<em><b>Boiling Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boiling Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boiling Point</em>' attribute.
	 * @see #isSetBoilingPoint()
	 * @see #unsetBoilingPoint()
	 * @see #setBoilingPoint(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_BoilingPoint()
	 * @model unsettable="true"
	 * @generated
	 */
	double getBoilingPoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPoint <em>Boiling Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boiling Point</em>' attribute.
	 * @see #isSetBoilingPoint()
	 * @see #unsetBoilingPoint()
	 * @see #getBoilingPoint()
	 * @generated
	 */
	void setBoilingPoint(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPoint <em>Boiling Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoilingPoint()
	 * @see #getBoilingPoint()
	 * @see #setBoilingPoint(double)
	 * @generated
	 */
	void unsetBoilingPoint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPoint <em>Boiling Point</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boiling Point</em>' attribute is set.
	 * @see #unsetBoilingPoint()
	 * @see #getBoilingPoint()
	 * @see #setBoilingPoint(double)
	 * @generated
	 */
	boolean isSetBoilingPoint();

	/**
	 * Returns the value of the '<em><b>Boiling Point As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boiling Point As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boiling Point As String</em>' attribute.
	 * @see #isSetBoilingPointAsString()
	 * @see #unsetBoilingPointAsString()
	 * @see #setBoilingPointAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_BoilingPointAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBoilingPointAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPointAsString <em>Boiling Point As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boiling Point As String</em>' attribute.
	 * @see #isSetBoilingPointAsString()
	 * @see #unsetBoilingPointAsString()
	 * @see #getBoilingPointAsString()
	 * @generated
	 */
	void setBoilingPointAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPointAsString <em>Boiling Point As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoilingPointAsString()
	 * @see #getBoilingPointAsString()
	 * @see #setBoilingPointAsString(String)
	 * @generated
	 */
	void unsetBoilingPointAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getBoilingPointAsString <em>Boiling Point As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Boiling Point As String</em>' attribute is set.
	 * @see #unsetBoilingPointAsString()
	 * @see #getBoilingPointAsString()
	 * @see #setBoilingPointAsString(String)
	 * @generated
	 */
	boolean isSetBoilingPointAsString();

	/**
	 * Returns the value of the '<em><b>Freezing Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freezing Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freezing Point</em>' attribute.
	 * @see #isSetFreezingPoint()
	 * @see #unsetFreezingPoint()
	 * @see #setFreezingPoint(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_FreezingPoint()
	 * @model unsettable="true"
	 * @generated
	 */
	double getFreezingPoint();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPoint <em>Freezing Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Freezing Point</em>' attribute.
	 * @see #isSetFreezingPoint()
	 * @see #unsetFreezingPoint()
	 * @see #getFreezingPoint()
	 * @generated
	 */
	void setFreezingPoint(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPoint <em>Freezing Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFreezingPoint()
	 * @see #getFreezingPoint()
	 * @see #setFreezingPoint(double)
	 * @generated
	 */
	void unsetFreezingPoint();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPoint <em>Freezing Point</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Freezing Point</em>' attribute is set.
	 * @see #unsetFreezingPoint()
	 * @see #getFreezingPoint()
	 * @see #setFreezingPoint(double)
	 * @generated
	 */
	boolean isSetFreezingPoint();

	/**
	 * Returns the value of the '<em><b>Freezing Point As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Freezing Point As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Freezing Point As String</em>' attribute.
	 * @see #isSetFreezingPointAsString()
	 * @see #unsetFreezingPointAsString()
	 * @see #setFreezingPointAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_FreezingPointAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFreezingPointAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPointAsString <em>Freezing Point As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Freezing Point As String</em>' attribute.
	 * @see #isSetFreezingPointAsString()
	 * @see #unsetFreezingPointAsString()
	 * @see #getFreezingPointAsString()
	 * @generated
	 */
	void setFreezingPointAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPointAsString <em>Freezing Point As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFreezingPointAsString()
	 * @see #getFreezingPointAsString()
	 * @see #setFreezingPointAsString(String)
	 * @generated
	 */
	void unsetFreezingPointAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getFreezingPointAsString <em>Freezing Point As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Freezing Point As String</em>' attribute is set.
	 * @see #unsetFreezingPointAsString()
	 * @see #getFreezingPointAsString()
	 * @see #setFreezingPointAsString(String)
	 * @generated
	 */
	boolean isSetFreezingPointAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Conductivity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Conductivity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Conductivity</em>' attribute.
	 * @see #isSetThermalConductivity()
	 * @see #unsetThermalConductivity()
	 * @see #setThermalConductivity(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_ThermalConductivity()
	 * @model unsettable="true"
	 * @generated
	 */
	double getThermalConductivity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivity <em>Thermal Conductivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Conductivity</em>' attribute.
	 * @see #isSetThermalConductivity()
	 * @see #unsetThermalConductivity()
	 * @see #getThermalConductivity()
	 * @generated
	 */
	void setThermalConductivity(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivity <em>Thermal Conductivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalConductivity()
	 * @see #getThermalConductivity()
	 * @see #setThermalConductivity(double)
	 * @generated
	 */
	void unsetThermalConductivity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivity <em>Thermal Conductivity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Conductivity</em>' attribute is set.
	 * @see #unsetThermalConductivity()
	 * @see #getThermalConductivity()
	 * @see #setThermalConductivity(double)
	 * @generated
	 */
	boolean isSetThermalConductivity();

	/**
	 * Returns the value of the '<em><b>Thermal Conductivity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Conductivity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Conductivity As String</em>' attribute.
	 * @see #isSetThermalConductivityAsString()
	 * @see #unsetThermalConductivityAsString()
	 * @see #setThermalConductivityAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcThermalMaterialProperties_ThermalConductivityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalConductivityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivityAsString <em>Thermal Conductivity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Conductivity As String</em>' attribute.
	 * @see #isSetThermalConductivityAsString()
	 * @see #unsetThermalConductivityAsString()
	 * @see #getThermalConductivityAsString()
	 * @generated
	 */
	void setThermalConductivityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivityAsString <em>Thermal Conductivity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalConductivityAsString()
	 * @see #getThermalConductivityAsString()
	 * @see #setThermalConductivityAsString(String)
	 * @generated
	 */
	void unsetThermalConductivityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcThermalMaterialProperties#getThermalConductivityAsString <em>Thermal Conductivity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Conductivity As String</em>' attribute is set.
	 * @see #unsetThermalConductivityAsString()
	 * @see #getThermalConductivityAsString()
	 * @see #setThermalConductivityAsString(String)
	 * @generated
	 */
	boolean isSetThermalConductivityAsString();

} // IfcThermalMaterialProperties
