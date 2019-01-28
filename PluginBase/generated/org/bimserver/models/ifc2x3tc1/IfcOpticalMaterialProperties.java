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

public interface IfcOpticalMaterialProperties extends IfcMaterialProperties {
	/**
	 * Returns the value of the '<em><b>Visible Transmittance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Transmittance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Transmittance</em>' attribute.
	 * @see #isSetVisibleTransmittance()
	 * @see #unsetVisibleTransmittance()
	 * @see #setVisibleTransmittance(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	double getVisibleTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Transmittance</em>' attribute.
	 * @see #isSetVisibleTransmittance()
	 * @see #unsetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @generated
	 */
	void setVisibleTransmittance(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @see #setVisibleTransmittance(double)
	 * @generated
	 */
	void unsetVisibleTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Transmittance</em>' attribute is set.
	 * @see #unsetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @see #setVisibleTransmittance(double)
	 * @generated
	 */
	boolean isSetVisibleTransmittance();

	/**
	 * Returns the value of the '<em><b>Visible Transmittance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Transmittance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Transmittance As String</em>' attribute.
	 * @see #isSetVisibleTransmittanceAsString()
	 * @see #unsetVisibleTransmittanceAsString()
	 * @see #setVisibleTransmittanceAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Transmittance As String</em>' attribute.
	 * @see #isSetVisibleTransmittanceAsString()
	 * @see #unsetVisibleTransmittanceAsString()
	 * @see #getVisibleTransmittanceAsString()
	 * @generated
	 */
	void setVisibleTransmittanceAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleTransmittanceAsString()
	 * @see #getVisibleTransmittanceAsString()
	 * @see #setVisibleTransmittanceAsString(String)
	 * @generated
	 */
	void unsetVisibleTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Transmittance As String</em>' attribute is set.
	 * @see #unsetVisibleTransmittanceAsString()
	 * @see #getVisibleTransmittanceAsString()
	 * @see #setVisibleTransmittanceAsString(String)
	 * @generated
	 */
	boolean isSetVisibleTransmittanceAsString();

	/**
	 * Returns the value of the '<em><b>Solar Transmittance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Transmittance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Transmittance</em>' attribute.
	 * @see #isSetSolarTransmittance()
	 * @see #unsetSolarTransmittance()
	 * @see #setSolarTransmittance(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSolarTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Transmittance</em>' attribute.
	 * @see #isSetSolarTransmittance()
	 * @see #unsetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @generated
	 */
	void setSolarTransmittance(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @see #setSolarTransmittance(double)
	 * @generated
	 */
	void unsetSolarTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Transmittance</em>' attribute is set.
	 * @see #unsetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @see #setSolarTransmittance(double)
	 * @generated
	 */
	boolean isSetSolarTransmittance();

	/**
	 * Returns the value of the '<em><b>Solar Transmittance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Transmittance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Transmittance As String</em>' attribute.
	 * @see #isSetSolarTransmittanceAsString()
	 * @see #unsetSolarTransmittanceAsString()
	 * @see #setSolarTransmittanceAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Transmittance As String</em>' attribute.
	 * @see #isSetSolarTransmittanceAsString()
	 * @see #unsetSolarTransmittanceAsString()
	 * @see #getSolarTransmittanceAsString()
	 * @generated
	 */
	void setSolarTransmittanceAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarTransmittanceAsString()
	 * @see #getSolarTransmittanceAsString()
	 * @see #setSolarTransmittanceAsString(String)
	 * @generated
	 */
	void unsetSolarTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Transmittance As String</em>' attribute is set.
	 * @see #unsetSolarTransmittanceAsString()
	 * @see #getSolarTransmittanceAsString()
	 * @see #setSolarTransmittanceAsString(String)
	 * @generated
	 */
	boolean isSetSolarTransmittanceAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Transmittance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Transmittance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Transmittance</em>' attribute.
	 * @see #isSetThermalIrTransmittance()
	 * @see #unsetThermalIrTransmittance()
	 * @see #setThermalIrTransmittance(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	double getThermalIrTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Transmittance</em>' attribute.
	 * @see #isSetThermalIrTransmittance()
	 * @see #unsetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @generated
	 */
	void setThermalIrTransmittance(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @see #setThermalIrTransmittance(double)
	 * @generated
	 */
	void unsetThermalIrTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Transmittance</em>' attribute is set.
	 * @see #unsetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @see #setThermalIrTransmittance(double)
	 * @generated
	 */
	boolean isSetThermalIrTransmittance();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Transmittance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Transmittance As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Transmittance As String</em>' attribute.
	 * @see #isSetThermalIrTransmittanceAsString()
	 * @see #unsetThermalIrTransmittanceAsString()
	 * @see #setThermalIrTransmittanceAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Transmittance As String</em>' attribute.
	 * @see #isSetThermalIrTransmittanceAsString()
	 * @see #unsetThermalIrTransmittanceAsString()
	 * @see #getThermalIrTransmittanceAsString()
	 * @generated
	 */
	void setThermalIrTransmittanceAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrTransmittanceAsString()
	 * @see #getThermalIrTransmittanceAsString()
	 * @see #setThermalIrTransmittanceAsString(String)
	 * @generated
	 */
	void unsetThermalIrTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Transmittance As String</em>' attribute is set.
	 * @see #unsetThermalIrTransmittanceAsString()
	 * @see #getThermalIrTransmittanceAsString()
	 * @see #setThermalIrTransmittanceAsString(String)
	 * @generated
	 */
	boolean isSetThermalIrTransmittanceAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Emissivity Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Emissivity Back</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Emissivity Back</em>' attribute.
	 * @see #isSetThermalIrEmissivityBack()
	 * @see #unsetThermalIrEmissivityBack()
	 * @see #setThermalIrEmissivityBack(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityBack()
	 * @model unsettable="true"
	 * @generated
	 */
	double getThermalIrEmissivityBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Back</em>' attribute.
	 * @see #isSetThermalIrEmissivityBack()
	 * @see #unsetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @generated
	 */
	void setThermalIrEmissivityBack(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @see #setThermalIrEmissivityBack(double)
	 * @generated
	 */
	void unsetThermalIrEmissivityBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Back</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @see #setThermalIrEmissivityBack(double)
	 * @generated
	 */
	boolean isSetThermalIrEmissivityBack();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Emissivity Back As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Emissivity Back As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Emissivity Back As String</em>' attribute.
	 * @see #isSetThermalIrEmissivityBackAsString()
	 * @see #unsetThermalIrEmissivityBackAsString()
	 * @see #setThermalIrEmissivityBackAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrEmissivityBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Back As String</em>' attribute.
	 * @see #isSetThermalIrEmissivityBackAsString()
	 * @see #unsetThermalIrEmissivityBackAsString()
	 * @see #getThermalIrEmissivityBackAsString()
	 * @generated
	 */
	void setThermalIrEmissivityBackAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityBackAsString()
	 * @see #getThermalIrEmissivityBackAsString()
	 * @see #setThermalIrEmissivityBackAsString(String)
	 * @generated
	 */
	void unsetThermalIrEmissivityBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Back As String</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityBackAsString()
	 * @see #getThermalIrEmissivityBackAsString()
	 * @see #setThermalIrEmissivityBackAsString(String)
	 * @generated
	 */
	boolean isSetThermalIrEmissivityBackAsString();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Emissivity Front</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Emissivity Front</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Emissivity Front</em>' attribute.
	 * @see #isSetThermalIrEmissivityFront()
	 * @see #unsetThermalIrEmissivityFront()
	 * @see #setThermalIrEmissivityFront(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityFront()
	 * @model unsettable="true"
	 * @generated
	 */
	double getThermalIrEmissivityFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Front</em>' attribute.
	 * @see #isSetThermalIrEmissivityFront()
	 * @see #unsetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @generated
	 */
	void setThermalIrEmissivityFront(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @see #setThermalIrEmissivityFront(double)
	 * @generated
	 */
	void unsetThermalIrEmissivityFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Front</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @see #setThermalIrEmissivityFront(double)
	 * @generated
	 */
	boolean isSetThermalIrEmissivityFront();

	/**
	 * Returns the value of the '<em><b>Thermal Ir Emissivity Front As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thermal Ir Emissivity Front As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thermal Ir Emissivity Front As String</em>' attribute.
	 * @see #isSetThermalIrEmissivityFrontAsString()
	 * @see #unsetThermalIrEmissivityFrontAsString()
	 * @see #setThermalIrEmissivityFrontAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrEmissivityFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Front As String</em>' attribute.
	 * @see #isSetThermalIrEmissivityFrontAsString()
	 * @see #unsetThermalIrEmissivityFrontAsString()
	 * @see #getThermalIrEmissivityFrontAsString()
	 * @generated
	 */
	void setThermalIrEmissivityFrontAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityFrontAsString()
	 * @see #getThermalIrEmissivityFrontAsString()
	 * @see #setThermalIrEmissivityFrontAsString(String)
	 * @generated
	 */
	void unsetThermalIrEmissivityFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Front As String</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityFrontAsString()
	 * @see #getThermalIrEmissivityFrontAsString()
	 * @see #setThermalIrEmissivityFrontAsString(String)
	 * @generated
	 */
	boolean isSetThermalIrEmissivityFrontAsString();

	/**
	 * Returns the value of the '<em><b>Visible Reflectance Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Reflectance Back</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Reflectance Back</em>' attribute.
	 * @see #isSetVisibleReflectanceBack()
	 * @see #unsetVisibleReflectanceBack()
	 * @see #setVisibleReflectanceBack(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleReflectanceBack()
	 * @model unsettable="true"
	 * @generated
	 */
	double getVisibleReflectanceBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Back</em>' attribute.
	 * @see #isSetVisibleReflectanceBack()
	 * @see #unsetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @generated
	 */
	void setVisibleReflectanceBack(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @see #setVisibleReflectanceBack(double)
	 * @generated
	 */
	void unsetVisibleReflectanceBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Back</em>' attribute is set.
	 * @see #unsetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @see #setVisibleReflectanceBack(double)
	 * @generated
	 */
	boolean isSetVisibleReflectanceBack();

	/**
	 * Returns the value of the '<em><b>Visible Reflectance Back As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Reflectance Back As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Reflectance Back As String</em>' attribute.
	 * @see #isSetVisibleReflectanceBackAsString()
	 * @see #unsetVisibleReflectanceBackAsString()
	 * @see #setVisibleReflectanceBackAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleReflectanceBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Back As String</em>' attribute.
	 * @see #isSetVisibleReflectanceBackAsString()
	 * @see #unsetVisibleReflectanceBackAsString()
	 * @see #getVisibleReflectanceBackAsString()
	 * @generated
	 */
	void setVisibleReflectanceBackAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceBackAsString()
	 * @see #getVisibleReflectanceBackAsString()
	 * @see #setVisibleReflectanceBackAsString(String)
	 * @generated
	 */
	void unsetVisibleReflectanceBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Back As String</em>' attribute is set.
	 * @see #unsetVisibleReflectanceBackAsString()
	 * @see #getVisibleReflectanceBackAsString()
	 * @see #setVisibleReflectanceBackAsString(String)
	 * @generated
	 */
	boolean isSetVisibleReflectanceBackAsString();

	/**
	 * Returns the value of the '<em><b>Visible Reflectance Front</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Reflectance Front</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Reflectance Front</em>' attribute.
	 * @see #isSetVisibleReflectanceFront()
	 * @see #unsetVisibleReflectanceFront()
	 * @see #setVisibleReflectanceFront(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleReflectanceFront()
	 * @model unsettable="true"
	 * @generated
	 */
	double getVisibleReflectanceFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Front</em>' attribute.
	 * @see #isSetVisibleReflectanceFront()
	 * @see #unsetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @generated
	 */
	void setVisibleReflectanceFront(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @see #setVisibleReflectanceFront(double)
	 * @generated
	 */
	void unsetVisibleReflectanceFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Front</em>' attribute is set.
	 * @see #unsetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @see #setVisibleReflectanceFront(double)
	 * @generated
	 */
	boolean isSetVisibleReflectanceFront();

	/**
	 * Returns the value of the '<em><b>Visible Reflectance Front As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Reflectance Front As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Reflectance Front As String</em>' attribute.
	 * @see #isSetVisibleReflectanceFrontAsString()
	 * @see #unsetVisibleReflectanceFrontAsString()
	 * @see #setVisibleReflectanceFrontAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleReflectanceFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Front As String</em>' attribute.
	 * @see #isSetVisibleReflectanceFrontAsString()
	 * @see #unsetVisibleReflectanceFrontAsString()
	 * @see #getVisibleReflectanceFrontAsString()
	 * @generated
	 */
	void setVisibleReflectanceFrontAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceFrontAsString()
	 * @see #getVisibleReflectanceFrontAsString()
	 * @see #setVisibleReflectanceFrontAsString(String)
	 * @generated
	 */
	void unsetVisibleReflectanceFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Front As String</em>' attribute is set.
	 * @see #unsetVisibleReflectanceFrontAsString()
	 * @see #getVisibleReflectanceFrontAsString()
	 * @see #setVisibleReflectanceFrontAsString(String)
	 * @generated
	 */
	boolean isSetVisibleReflectanceFrontAsString();

	/**
	 * Returns the value of the '<em><b>Solar Reflectance Front</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Reflectance Front</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Reflectance Front</em>' attribute.
	 * @see #isSetSolarReflectanceFront()
	 * @see #unsetSolarReflectanceFront()
	 * @see #setSolarReflectanceFront(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarReflectanceFront()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSolarReflectanceFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Front</em>' attribute.
	 * @see #isSetSolarReflectanceFront()
	 * @see #unsetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @generated
	 */
	void setSolarReflectanceFront(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @see #setSolarReflectanceFront(double)
	 * @generated
	 */
	void unsetSolarReflectanceFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Front</em>' attribute is set.
	 * @see #unsetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @see #setSolarReflectanceFront(double)
	 * @generated
	 */
	boolean isSetSolarReflectanceFront();

	/**
	 * Returns the value of the '<em><b>Solar Reflectance Front As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Reflectance Front As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Reflectance Front As String</em>' attribute.
	 * @see #isSetSolarReflectanceFrontAsString()
	 * @see #unsetSolarReflectanceFrontAsString()
	 * @see #setSolarReflectanceFrontAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarReflectanceFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Front As String</em>' attribute.
	 * @see #isSetSolarReflectanceFrontAsString()
	 * @see #unsetSolarReflectanceFrontAsString()
	 * @see #getSolarReflectanceFrontAsString()
	 * @generated
	 */
	void setSolarReflectanceFrontAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceFrontAsString()
	 * @see #getSolarReflectanceFrontAsString()
	 * @see #setSolarReflectanceFrontAsString(String)
	 * @generated
	 */
	void unsetSolarReflectanceFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Front As String</em>' attribute is set.
	 * @see #unsetSolarReflectanceFrontAsString()
	 * @see #getSolarReflectanceFrontAsString()
	 * @see #setSolarReflectanceFrontAsString(String)
	 * @generated
	 */
	boolean isSetSolarReflectanceFrontAsString();

	/**
	 * Returns the value of the '<em><b>Solar Reflectance Back</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Reflectance Back</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Reflectance Back</em>' attribute.
	 * @see #isSetSolarReflectanceBack()
	 * @see #unsetSolarReflectanceBack()
	 * @see #setSolarReflectanceBack(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarReflectanceBack()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSolarReflectanceBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Back</em>' attribute.
	 * @see #isSetSolarReflectanceBack()
	 * @see #unsetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @generated
	 */
	void setSolarReflectanceBack(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @see #setSolarReflectanceBack(double)
	 * @generated
	 */
	void unsetSolarReflectanceBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Back</em>' attribute is set.
	 * @see #unsetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @see #setSolarReflectanceBack(double)
	 * @generated
	 */
	boolean isSetSolarReflectanceBack();

	/**
	 * Returns the value of the '<em><b>Solar Reflectance Back As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solar Reflectance Back As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solar Reflectance Back As String</em>' attribute.
	 * @see #isSetSolarReflectanceBackAsString()
	 * @see #unsetSolarReflectanceBackAsString()
	 * @see #setSolarReflectanceBackAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOpticalMaterialProperties_SolarReflectanceBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarReflectanceBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Back As String</em>' attribute.
	 * @see #isSetSolarReflectanceBackAsString()
	 * @see #unsetSolarReflectanceBackAsString()
	 * @see #getSolarReflectanceBackAsString()
	 * @generated
	 */
	void setSolarReflectanceBackAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceBackAsString()
	 * @see #getSolarReflectanceBackAsString()
	 * @see #setSolarReflectanceBackAsString(String)
	 * @generated
	 */
	void unsetSolarReflectanceBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Back As String</em>' attribute is set.
	 * @see #unsetSolarReflectanceBackAsString()
	 * @see #getSolarReflectanceBackAsString()
	 * @see #setSolarReflectanceBackAsString(String)
	 * @generated
	 */
	boolean isSetSolarReflectanceBackAsString();

} // IfcOpticalMaterialProperties
