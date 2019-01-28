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

public interface IfcSpaceThermalLoadProperties extends IfcPropertySetDefinition {
	/**
	 * Returns the value of the '<em><b>Applicable Value Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Value Ratio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Value Ratio</em>' attribute.
	 * @see #isSetApplicableValueRatio()
	 * @see #unsetApplicableValueRatio()
	 * @see #setApplicableValueRatio(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_ApplicableValueRatio()
	 * @model unsettable="true"
	 * @generated
	 */
	double getApplicableValueRatio();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatio <em>Applicable Value Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Value Ratio</em>' attribute.
	 * @see #isSetApplicableValueRatio()
	 * @see #unsetApplicableValueRatio()
	 * @see #getApplicableValueRatio()
	 * @generated
	 */
	void setApplicableValueRatio(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatio <em>Applicable Value Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableValueRatio()
	 * @see #getApplicableValueRatio()
	 * @see #setApplicableValueRatio(double)
	 * @generated
	 */
	void unsetApplicableValueRatio();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatio <em>Applicable Value Ratio</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Value Ratio</em>' attribute is set.
	 * @see #unsetApplicableValueRatio()
	 * @see #getApplicableValueRatio()
	 * @see #setApplicableValueRatio(double)
	 * @generated
	 */
	boolean isSetApplicableValueRatio();

	/**
	 * Returns the value of the '<em><b>Applicable Value Ratio As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicable Value Ratio As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicable Value Ratio As String</em>' attribute.
	 * @see #isSetApplicableValueRatioAsString()
	 * @see #unsetApplicableValueRatioAsString()
	 * @see #setApplicableValueRatioAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_ApplicableValueRatioAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApplicableValueRatioAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatioAsString <em>Applicable Value Ratio As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applicable Value Ratio As String</em>' attribute.
	 * @see #isSetApplicableValueRatioAsString()
	 * @see #unsetApplicableValueRatioAsString()
	 * @see #getApplicableValueRatioAsString()
	 * @generated
	 */
	void setApplicableValueRatioAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatioAsString <em>Applicable Value Ratio As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApplicableValueRatioAsString()
	 * @see #getApplicableValueRatioAsString()
	 * @see #setApplicableValueRatioAsString(String)
	 * @generated
	 */
	void unsetApplicableValueRatioAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getApplicableValueRatioAsString <em>Applicable Value Ratio As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Applicable Value Ratio As String</em>' attribute is set.
	 * @see #unsetApplicableValueRatioAsString()
	 * @see #getApplicableValueRatioAsString()
	 * @see #setApplicableValueRatioAsString(String)
	 * @generated
	 */
	boolean isSetApplicableValueRatioAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Load Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcThermalLoadSourceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Load Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Load Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcThermalLoadSourceEnum
	 * @see #setThermalLoadSource(IfcThermalLoadSourceEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_ThermalLoadSource()
	 * @model
	 * @generated
	 */
	IfcThermalLoadSourceEnum getThermalLoadSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getThermalLoadSource <em>Thermal Load Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Load Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcThermalLoadSourceEnum
	 * @see #getThermalLoadSource()
	 * @generated
	 */
	void setThermalLoadSource(IfcThermalLoadSourceEnum value);

	/**
	 * Returns the value of the '<em><b>Property Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum
	 * @see #setPropertySource(IfcPropertySourceEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_PropertySource()
	 * @model
	 * @generated
	 */
	IfcPropertySourceEnum getPropertySource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getPropertySource <em>Property Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcPropertySourceEnum
	 * @see #getPropertySource()
	 * @generated
	 */
	void setPropertySource(IfcPropertySourceEnum value);

	/**
	 * Returns the value of the '<em><b>Source Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Description</em>' attribute.
	 * @see #isSetSourceDescription()
	 * @see #unsetSourceDescription()
	 * @see #setSourceDescription(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_SourceDescription()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSourceDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getSourceDescription <em>Source Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Description</em>' attribute.
	 * @see #isSetSourceDescription()
	 * @see #unsetSourceDescription()
	 * @see #getSourceDescription()
	 * @generated
	 */
	void setSourceDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getSourceDescription <em>Source Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSourceDescription()
	 * @see #getSourceDescription()
	 * @see #setSourceDescription(String)
	 * @generated
	 */
	void unsetSourceDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getSourceDescription <em>Source Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source Description</em>' attribute is set.
	 * @see #unsetSourceDescription()
	 * @see #getSourceDescription()
	 * @see #setSourceDescription(String)
	 * @generated
	 */
	boolean isSetSourceDescription();

	/**
	 * Returns the value of the '<em><b>Maximum Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Value</em>' attribute.
	 * @see #setMaximumValue(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_MaximumValue()
	 * @model
	 * @generated
	 */
	double getMaximumValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMaximumValue <em>Maximum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Value</em>' attribute.
	 * @see #getMaximumValue()
	 * @generated
	 */
	void setMaximumValue(double value);

	/**
	 * Returns the value of the '<em><b>Maximum Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Value As String</em>' attribute.
	 * @see #setMaximumValueAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_MaximumValueAsString()
	 * @model
	 * @generated
	 */
	String getMaximumValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMaximumValueAsString <em>Maximum Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Value As String</em>' attribute.
	 * @see #getMaximumValueAsString()
	 * @generated
	 */
	void setMaximumValueAsString(String value);

	/**
	 * Returns the value of the '<em><b>Minimum Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Value</em>' attribute.
	 * @see #isSetMinimumValue()
	 * @see #unsetMinimumValue()
	 * @see #setMinimumValue(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_MinimumValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMinimumValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValue <em>Minimum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Value</em>' attribute.
	 * @see #isSetMinimumValue()
	 * @see #unsetMinimumValue()
	 * @see #getMinimumValue()
	 * @generated
	 */
	void setMinimumValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValue <em>Minimum Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinimumValue()
	 * @see #getMinimumValue()
	 * @see #setMinimumValue(double)
	 * @generated
	 */
	void unsetMinimumValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValue <em>Minimum Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minimum Value</em>' attribute is set.
	 * @see #unsetMinimumValue()
	 * @see #getMinimumValue()
	 * @see #setMinimumValue(double)
	 * @generated
	 */
	boolean isSetMinimumValue();

	/**
	 * Returns the value of the '<em><b>Minimum Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Value As String</em>' attribute.
	 * @see #isSetMinimumValueAsString()
	 * @see #unsetMinimumValueAsString()
	 * @see #setMinimumValueAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_MinimumValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMinimumValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValueAsString <em>Minimum Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Value As String</em>' attribute.
	 * @see #isSetMinimumValueAsString()
	 * @see #unsetMinimumValueAsString()
	 * @see #getMinimumValueAsString()
	 * @generated
	 */
	void setMinimumValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValueAsString <em>Minimum Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinimumValueAsString()
	 * @see #getMinimumValueAsString()
	 * @see #setMinimumValueAsString(String)
	 * @generated
	 */
	void unsetMinimumValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getMinimumValueAsString <em>Minimum Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minimum Value As String</em>' attribute is set.
	 * @see #unsetMinimumValueAsString()
	 * @see #getMinimumValueAsString()
	 * @see #setMinimumValueAsString(String)
	 * @generated
	 */
	boolean isSetMinimumValueAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Load Time Series Values</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Load Time Series Values</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Load Time Series Values</em>' reference.
	 * @see #isSetThermalLoadTimeSeriesValues()
	 * @see #unsetThermalLoadTimeSeriesValues()
	 * @see #setThermalLoadTimeSeriesValues(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_ThermalLoadTimeSeriesValues()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTimeSeries getThermalLoadTimeSeriesValues();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getThermalLoadTimeSeriesValues <em>Thermal Load Time Series Values</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Load Time Series Values</em>' reference.
	 * @see #isSetThermalLoadTimeSeriesValues()
	 * @see #unsetThermalLoadTimeSeriesValues()
	 * @see #getThermalLoadTimeSeriesValues()
	 * @generated
	 */
	void setThermalLoadTimeSeriesValues(IfcTimeSeries value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getThermalLoadTimeSeriesValues <em>Thermal Load Time Series Values</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalLoadTimeSeriesValues()
	 * @see #getThermalLoadTimeSeriesValues()
	 * @see #setThermalLoadTimeSeriesValues(IfcTimeSeries)
	 * @generated
	 */
	void unsetThermalLoadTimeSeriesValues();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getThermalLoadTimeSeriesValues <em>Thermal Load Time Series Values</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Load Time Series Values</em>' reference is set.
	 * @see #unsetThermalLoadTimeSeriesValues()
	 * @see #getThermalLoadTimeSeriesValues()
	 * @see #setThermalLoadTimeSeriesValues(IfcTimeSeries)
	 * @generated
	 */
	boolean isSetThermalLoadTimeSeriesValues();

	/**
	 * Returns the value of the '<em><b>User Defined Thermal Load Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Thermal Load Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Thermal Load Source</em>' attribute.
	 * @see #isSetUserDefinedThermalLoadSource()
	 * @see #unsetUserDefinedThermalLoadSource()
	 * @see #setUserDefinedThermalLoadSource(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_UserDefinedThermalLoadSource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedThermalLoadSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedThermalLoadSource <em>User Defined Thermal Load Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Thermal Load Source</em>' attribute.
	 * @see #isSetUserDefinedThermalLoadSource()
	 * @see #unsetUserDefinedThermalLoadSource()
	 * @see #getUserDefinedThermalLoadSource()
	 * @generated
	 */
	void setUserDefinedThermalLoadSource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedThermalLoadSource <em>User Defined Thermal Load Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedThermalLoadSource()
	 * @see #getUserDefinedThermalLoadSource()
	 * @see #setUserDefinedThermalLoadSource(String)
	 * @generated
	 */
	void unsetUserDefinedThermalLoadSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedThermalLoadSource <em>User Defined Thermal Load Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Thermal Load Source</em>' attribute is set.
	 * @see #unsetUserDefinedThermalLoadSource()
	 * @see #getUserDefinedThermalLoadSource()
	 * @see #setUserDefinedThermalLoadSource(String)
	 * @generated
	 */
	boolean isSetUserDefinedThermalLoadSource();

	/**
	 * Returns the value of the '<em><b>User Defined Property Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Property Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Property Source</em>' attribute.
	 * @see #isSetUserDefinedPropertySource()
	 * @see #unsetUserDefinedPropertySource()
	 * @see #setUserDefinedPropertySource(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_UserDefinedPropertySource()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedPropertySource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedPropertySource <em>User Defined Property Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Property Source</em>' attribute.
	 * @see #isSetUserDefinedPropertySource()
	 * @see #unsetUserDefinedPropertySource()
	 * @see #getUserDefinedPropertySource()
	 * @generated
	 */
	void setUserDefinedPropertySource(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedPropertySource <em>User Defined Property Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedPropertySource()
	 * @see #getUserDefinedPropertySource()
	 * @see #setUserDefinedPropertySource(String)
	 * @generated
	 */
	void unsetUserDefinedPropertySource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getUserDefinedPropertySource <em>User Defined Property Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Property Source</em>' attribute is set.
	 * @see #unsetUserDefinedPropertySource()
	 * @see #getUserDefinedPropertySource()
	 * @see #setUserDefinedPropertySource(String)
	 * @generated
	 */
	boolean isSetUserDefinedPropertySource();

	/**
	 * Returns the value of the '<em><b>Thermal Load Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcThermalLoadTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Load Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Load Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcThermalLoadTypeEnum
	 * @see #setThermalLoadType(IfcThermalLoadTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceThermalLoadProperties_ThermalLoadType()
	 * @model
	 * @generated
	 */
	IfcThermalLoadTypeEnum getThermalLoadType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceThermalLoadProperties#getThermalLoadType <em>Thermal Load Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Load Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcThermalLoadTypeEnum
	 * @see #getThermalLoadType()
	 * @generated
	 */
	void setThermalLoadType(IfcThermalLoadTypeEnum value);

} // IfcSpaceThermalLoadProperties
