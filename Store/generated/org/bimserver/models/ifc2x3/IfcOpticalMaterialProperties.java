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
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Optical Material Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties()
 * @model
 * @generated
 */
public interface IfcOpticalMaterialProperties extends IfcMaterialProperties
{
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
	 * @see #setVisibleTransmittance(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	float getVisibleTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Transmittance</em>' attribute.
	 * @see #isSetVisibleTransmittance()
	 * @see #unsetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @generated
	 */
	void setVisibleTransmittance(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @see #setVisibleTransmittance(float)
	 * @generated
	 */
	void unsetVisibleTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittance <em>Visible Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Transmittance</em>' attribute is set.
	 * @see #unsetVisibleTransmittance()
	 * @see #getVisibleTransmittance()
	 * @see #setVisibleTransmittance(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleTransmittanceAsString()
	 * @see #getVisibleTransmittanceAsString()
	 * @see #setVisibleTransmittanceAsString(String)
	 * @generated
	 */
	void unsetVisibleTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleTransmittanceAsString <em>Visible Transmittance As String</em>}' attribute is set.
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
	 * @see #setSolarTransmittance(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSolarTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Transmittance</em>' attribute.
	 * @see #isSetSolarTransmittance()
	 * @see #unsetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @generated
	 */
	void setSolarTransmittance(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @see #setSolarTransmittance(float)
	 * @generated
	 */
	void unsetSolarTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittance <em>Solar Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Transmittance</em>' attribute is set.
	 * @see #unsetSolarTransmittance()
	 * @see #getSolarTransmittance()
	 * @see #setSolarTransmittance(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarTransmittanceAsString()
	 * @see #getSolarTransmittanceAsString()
	 * @see #setSolarTransmittanceAsString(String)
	 * @generated
	 */
	void unsetSolarTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarTransmittanceAsString <em>Solar Transmittance As String</em>}' attribute is set.
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
	 * @see #setThermalIrTransmittance(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrTransmittance()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThermalIrTransmittance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Transmittance</em>' attribute.
	 * @see #isSetThermalIrTransmittance()
	 * @see #unsetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @generated
	 */
	void setThermalIrTransmittance(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @see #setThermalIrTransmittance(float)
	 * @generated
	 */
	void unsetThermalIrTransmittance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittance <em>Thermal Ir Transmittance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Transmittance</em>' attribute is set.
	 * @see #unsetThermalIrTransmittance()
	 * @see #getThermalIrTransmittance()
	 * @see #setThermalIrTransmittance(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrTransmittanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrTransmittanceAsString()
	 * @see #getThermalIrTransmittanceAsString()
	 * @see #setThermalIrTransmittanceAsString(String)
	 * @generated
	 */
	void unsetThermalIrTransmittanceAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrTransmittanceAsString <em>Thermal Ir Transmittance As String</em>}' attribute is set.
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
	 * @see #setThermalIrEmissivityBack(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityBack()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThermalIrEmissivityBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Back</em>' attribute.
	 * @see #isSetThermalIrEmissivityBack()
	 * @see #unsetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @generated
	 */
	void setThermalIrEmissivityBack(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @see #setThermalIrEmissivityBack(float)
	 * @generated
	 */
	void unsetThermalIrEmissivityBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBack <em>Thermal Ir Emissivity Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Back</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityBack()
	 * @see #getThermalIrEmissivityBack()
	 * @see #setThermalIrEmissivityBack(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrEmissivityBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityBackAsString()
	 * @see #getThermalIrEmissivityBackAsString()
	 * @see #setThermalIrEmissivityBackAsString(String)
	 * @generated
	 */
	void unsetThermalIrEmissivityBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityBackAsString <em>Thermal Ir Emissivity Back As String</em>}' attribute is set.
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
	 * @see #setThermalIrEmissivityFront(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityFront()
	 * @model unsettable="true"
	 * @generated
	 */
	float getThermalIrEmissivityFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thermal Ir Emissivity Front</em>' attribute.
	 * @see #isSetThermalIrEmissivityFront()
	 * @see #unsetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @generated
	 */
	void setThermalIrEmissivityFront(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @see #setThermalIrEmissivityFront(float)
	 * @generated
	 */
	void unsetThermalIrEmissivityFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFront <em>Thermal Ir Emissivity Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Thermal Ir Emissivity Front</em>' attribute is set.
	 * @see #unsetThermalIrEmissivityFront()
	 * @see #getThermalIrEmissivityFront()
	 * @see #setThermalIrEmissivityFront(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getThermalIrEmissivityFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThermalIrEmissivityFrontAsString()
	 * @see #getThermalIrEmissivityFrontAsString()
	 * @see #setThermalIrEmissivityFrontAsString(String)
	 * @generated
	 */
	void unsetThermalIrEmissivityFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getThermalIrEmissivityFrontAsString <em>Thermal Ir Emissivity Front As String</em>}' attribute is set.
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
	 * @see #setVisibleReflectanceBack(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleReflectanceBack()
	 * @model unsettable="true"
	 * @generated
	 */
	float getVisibleReflectanceBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Back</em>' attribute.
	 * @see #isSetVisibleReflectanceBack()
	 * @see #unsetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @generated
	 */
	void setVisibleReflectanceBack(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @see #setVisibleReflectanceBack(float)
	 * @generated
	 */
	void unsetVisibleReflectanceBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBack <em>Visible Reflectance Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Back</em>' attribute is set.
	 * @see #unsetVisibleReflectanceBack()
	 * @see #getVisibleReflectanceBack()
	 * @see #setVisibleReflectanceBack(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleReflectanceBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceBackAsString()
	 * @see #getVisibleReflectanceBackAsString()
	 * @see #setVisibleReflectanceBackAsString(String)
	 * @generated
	 */
	void unsetVisibleReflectanceBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceBackAsString <em>Visible Reflectance Back As String</em>}' attribute is set.
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
	 * @see #setVisibleReflectanceFront(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleReflectanceFront()
	 * @model unsettable="true"
	 * @generated
	 */
	float getVisibleReflectanceFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible Reflectance Front</em>' attribute.
	 * @see #isSetVisibleReflectanceFront()
	 * @see #unsetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @generated
	 */
	void setVisibleReflectanceFront(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @see #setVisibleReflectanceFront(float)
	 * @generated
	 */
	void unsetVisibleReflectanceFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFront <em>Visible Reflectance Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Visible Reflectance Front</em>' attribute is set.
	 * @see #unsetVisibleReflectanceFront()
	 * @see #getVisibleReflectanceFront()
	 * @see #setVisibleReflectanceFront(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVisibleReflectanceFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVisibleReflectanceFrontAsString()
	 * @see #getVisibleReflectanceFrontAsString()
	 * @see #setVisibleReflectanceFrontAsString(String)
	 * @generated
	 */
	void unsetVisibleReflectanceFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getVisibleReflectanceFrontAsString <em>Visible Reflectance Front As String</em>}' attribute is set.
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
	 * @see #setSolarReflectanceFront(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarReflectanceFront()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSolarReflectanceFront();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Front</em>' attribute.
	 * @see #isSetSolarReflectanceFront()
	 * @see #unsetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @generated
	 */
	void setSolarReflectanceFront(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @see #setSolarReflectanceFront(float)
	 * @generated
	 */
	void unsetSolarReflectanceFront();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFront <em>Solar Reflectance Front</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Front</em>' attribute is set.
	 * @see #unsetSolarReflectanceFront()
	 * @see #getSolarReflectanceFront()
	 * @see #setSolarReflectanceFront(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarReflectanceFrontAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceFrontAsString()
	 * @see #getSolarReflectanceFrontAsString()
	 * @see #setSolarReflectanceFrontAsString(String)
	 * @generated
	 */
	void unsetSolarReflectanceFrontAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceFrontAsString <em>Solar Reflectance Front As String</em>}' attribute is set.
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
	 * @see #setSolarReflectanceBack(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarReflectanceBack()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSolarReflectanceBack();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solar Reflectance Back</em>' attribute.
	 * @see #isSetSolarReflectanceBack()
	 * @see #unsetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @generated
	 */
	void setSolarReflectanceBack(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @see #setSolarReflectanceBack(float)
	 * @generated
	 */
	void unsetSolarReflectanceBack();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBack <em>Solar Reflectance Back</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Solar Reflectance Back</em>' attribute is set.
	 * @see #unsetSolarReflectanceBack()
	 * @see #getSolarReflectanceBack()
	 * @see #setSolarReflectanceBack(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpticalMaterialProperties_SolarReflectanceBackAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSolarReflectanceBackAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSolarReflectanceBackAsString()
	 * @see #getSolarReflectanceBackAsString()
	 * @see #setSolarReflectanceBackAsString(String)
	 * @generated
	 */
	void unsetSolarReflectanceBackAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOpticalMaterialProperties#getSolarReflectanceBackAsString <em>Solar Reflectance Back As String</em>}' attribute is set.
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
