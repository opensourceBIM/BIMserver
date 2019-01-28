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

public interface IfcFuelProperties extends IfcMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Combustion Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combustion Temperature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combustion Temperature</em>' attribute.
	 * @see #isSetCombustionTemperature()
	 * @see #unsetCombustionTemperature()
	 * @see #setCombustionTemperature(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_CombustionTemperature()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCombustionTemperature();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperature <em>Combustion Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combustion Temperature</em>' attribute.
	 * @see #isSetCombustionTemperature()
	 * @see #unsetCombustionTemperature()
	 * @see #getCombustionTemperature()
	 * @generated
	 */
	void setCombustionTemperature(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperature <em>Combustion Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCombustionTemperature()
	 * @see #getCombustionTemperature()
	 * @see #setCombustionTemperature(double)
	 * @generated
	 */
	void unsetCombustionTemperature();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperature <em>Combustion Temperature</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Combustion Temperature</em>' attribute is set.
	 * @see #unsetCombustionTemperature()
	 * @see #getCombustionTemperature()
	 * @see #setCombustionTemperature(double)
	 * @generated
	 */
	boolean isSetCombustionTemperature();

	/**
	 * Returns the value of the '<em><b>Combustion Temperature As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combustion Temperature As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combustion Temperature As String</em>' attribute.
	 * @see #isSetCombustionTemperatureAsString()
	 * @see #unsetCombustionTemperatureAsString()
	 * @see #setCombustionTemperatureAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_CombustionTemperatureAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCombustionTemperatureAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperatureAsString <em>Combustion Temperature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Combustion Temperature As String</em>' attribute.
	 * @see #isSetCombustionTemperatureAsString()
	 * @see #unsetCombustionTemperatureAsString()
	 * @see #getCombustionTemperatureAsString()
	 * @generated
	 */
	void setCombustionTemperatureAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperatureAsString <em>Combustion Temperature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCombustionTemperatureAsString()
	 * @see #getCombustionTemperatureAsString()
	 * @see #setCombustionTemperatureAsString(String)
	 * @generated
	 */
	void unsetCombustionTemperatureAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCombustionTemperatureAsString <em>Combustion Temperature As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Combustion Temperature As String</em>' attribute is set.
	 * @see #unsetCombustionTemperatureAsString()
	 * @see #getCombustionTemperatureAsString()
	 * @see #setCombustionTemperatureAsString(String)
	 * @generated
	 */
	boolean isSetCombustionTemperatureAsString();

	/**
	 * Returns the value of the '<em><b>Carbon Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Carbon Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Carbon Content</em>' attribute.
	 * @see #isSetCarbonContent()
	 * @see #unsetCarbonContent()
	 * @see #setCarbonContent(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_CarbonContent()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCarbonContent();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContent <em>Carbon Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Carbon Content</em>' attribute.
	 * @see #isSetCarbonContent()
	 * @see #unsetCarbonContent()
	 * @see #getCarbonContent()
	 * @generated
	 */
	void setCarbonContent(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContent <em>Carbon Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCarbonContent()
	 * @see #getCarbonContent()
	 * @see #setCarbonContent(double)
	 * @generated
	 */
	void unsetCarbonContent();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContent <em>Carbon Content</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Carbon Content</em>' attribute is set.
	 * @see #unsetCarbonContent()
	 * @see #getCarbonContent()
	 * @see #setCarbonContent(double)
	 * @generated
	 */
	boolean isSetCarbonContent();

	/**
	 * Returns the value of the '<em><b>Carbon Content As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Carbon Content As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Carbon Content As String</em>' attribute.
	 * @see #isSetCarbonContentAsString()
	 * @see #unsetCarbonContentAsString()
	 * @see #setCarbonContentAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_CarbonContentAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCarbonContentAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContentAsString <em>Carbon Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Carbon Content As String</em>' attribute.
	 * @see #isSetCarbonContentAsString()
	 * @see #unsetCarbonContentAsString()
	 * @see #getCarbonContentAsString()
	 * @generated
	 */
	void setCarbonContentAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContentAsString <em>Carbon Content As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCarbonContentAsString()
	 * @see #getCarbonContentAsString()
	 * @see #setCarbonContentAsString(String)
	 * @generated
	 */
	void unsetCarbonContentAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getCarbonContentAsString <em>Carbon Content As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Carbon Content As String</em>' attribute is set.
	 * @see #unsetCarbonContentAsString()
	 * @see #getCarbonContentAsString()
	 * @see #setCarbonContentAsString(String)
	 * @generated
	 */
	boolean isSetCarbonContentAsString();

	/**
	 * Returns the value of the '<em><b>Lower Heating Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Heating Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Heating Value</em>' attribute.
	 * @see #isSetLowerHeatingValue()
	 * @see #unsetLowerHeatingValue()
	 * @see #setLowerHeatingValue(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_LowerHeatingValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLowerHeatingValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValue <em>Lower Heating Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Heating Value</em>' attribute.
	 * @see #isSetLowerHeatingValue()
	 * @see #unsetLowerHeatingValue()
	 * @see #getLowerHeatingValue()
	 * @generated
	 */
	void setLowerHeatingValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValue <em>Lower Heating Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerHeatingValue()
	 * @see #getLowerHeatingValue()
	 * @see #setLowerHeatingValue(double)
	 * @generated
	 */
	void unsetLowerHeatingValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValue <em>Lower Heating Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Heating Value</em>' attribute is set.
	 * @see #unsetLowerHeatingValue()
	 * @see #getLowerHeatingValue()
	 * @see #setLowerHeatingValue(double)
	 * @generated
	 */
	boolean isSetLowerHeatingValue();

	/**
	 * Returns the value of the '<em><b>Lower Heating Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Heating Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Heating Value As String</em>' attribute.
	 * @see #isSetLowerHeatingValueAsString()
	 * @see #unsetLowerHeatingValueAsString()
	 * @see #setLowerHeatingValueAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_LowerHeatingValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLowerHeatingValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValueAsString <em>Lower Heating Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Heating Value As String</em>' attribute.
	 * @see #isSetLowerHeatingValueAsString()
	 * @see #unsetLowerHeatingValueAsString()
	 * @see #getLowerHeatingValueAsString()
	 * @generated
	 */
	void setLowerHeatingValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValueAsString <em>Lower Heating Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLowerHeatingValueAsString()
	 * @see #getLowerHeatingValueAsString()
	 * @see #setLowerHeatingValueAsString(String)
	 * @generated
	 */
	void unsetLowerHeatingValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getLowerHeatingValueAsString <em>Lower Heating Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Lower Heating Value As String</em>' attribute is set.
	 * @see #unsetLowerHeatingValueAsString()
	 * @see #getLowerHeatingValueAsString()
	 * @see #setLowerHeatingValueAsString(String)
	 * @generated
	 */
	boolean isSetLowerHeatingValueAsString();

	/**
	 * Returns the value of the '<em><b>Higher Heating Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Higher Heating Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Higher Heating Value</em>' attribute.
	 * @see #isSetHigherHeatingValue()
	 * @see #unsetHigherHeatingValue()
	 * @see #setHigherHeatingValue(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_HigherHeatingValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getHigherHeatingValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValue <em>Higher Heating Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Higher Heating Value</em>' attribute.
	 * @see #isSetHigherHeatingValue()
	 * @see #unsetHigherHeatingValue()
	 * @see #getHigherHeatingValue()
	 * @generated
	 */
	void setHigherHeatingValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValue <em>Higher Heating Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHigherHeatingValue()
	 * @see #getHigherHeatingValue()
	 * @see #setHigherHeatingValue(double)
	 * @generated
	 */
	void unsetHigherHeatingValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValue <em>Higher Heating Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Higher Heating Value</em>' attribute is set.
	 * @see #unsetHigherHeatingValue()
	 * @see #getHigherHeatingValue()
	 * @see #setHigherHeatingValue(double)
	 * @generated
	 */
	boolean isSetHigherHeatingValue();

	/**
	 * Returns the value of the '<em><b>Higher Heating Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Higher Heating Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Higher Heating Value As String</em>' attribute.
	 * @see #isSetHigherHeatingValueAsString()
	 * @see #unsetHigherHeatingValueAsString()
	 * @see #setHigherHeatingValueAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcFuelProperties_HigherHeatingValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getHigherHeatingValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValueAsString <em>Higher Heating Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Higher Heating Value As String</em>' attribute.
	 * @see #isSetHigherHeatingValueAsString()
	 * @see #unsetHigherHeatingValueAsString()
	 * @see #getHigherHeatingValueAsString()
	 * @generated
	 */
	void setHigherHeatingValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValueAsString <em>Higher Heating Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHigherHeatingValueAsString()
	 * @see #getHigherHeatingValueAsString()
	 * @see #setHigherHeatingValueAsString(String)
	 * @generated
	 */
	void unsetHigherHeatingValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcFuelProperties#getHigherHeatingValueAsString <em>Higher Heating Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Higher Heating Value As String</em>' attribute is set.
	 * @see #unsetHigherHeatingValueAsString()
	 * @see #getHigherHeatingValueAsString()
	 * @see #setHigherHeatingValueAsString(String)
	 * @generated
	 */
	boolean isSetHigherHeatingValueAsString();

} // IfcFuelProperties
