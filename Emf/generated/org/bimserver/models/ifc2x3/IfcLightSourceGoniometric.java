/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Light Source Goniometric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourAppearance <em>Colour Appearance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperature <em>Colour Temperature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperatureAsString <em>Colour Temperature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFlux <em>Luminous Flux</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFluxAsString <em>Luminous Flux As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightEmissionSource <em>Light Emission Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightDistributionDataSource <em>Light Distribution Data Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric()
 * @model
 * @generated
 */
public interface IfcLightSourceGoniometric extends IfcLightSource {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_Position()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #isSetPosition()
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getPosition <em>Position</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Position</em>' reference is set.
	 * @see #unsetPosition()
	 * @see #getPosition()
	 * @see #setPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetPosition();

	/**
	 * Returns the value of the '<em><b>Colour Appearance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Appearance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Appearance</em>' reference.
	 * @see #isSetColourAppearance()
	 * @see #unsetColourAppearance()
	 * @see #setColourAppearance(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_ColourAppearance()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourRgb getColourAppearance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourAppearance <em>Colour Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour Appearance</em>' reference.
	 * @see #isSetColourAppearance()
	 * @see #unsetColourAppearance()
	 * @see #getColourAppearance()
	 * @generated
	 */
	void setColourAppearance(IfcColourRgb value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourAppearance <em>Colour Appearance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColourAppearance()
	 * @see #getColourAppearance()
	 * @see #setColourAppearance(IfcColourRgb)
	 * @generated
	 */
	void unsetColourAppearance();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourAppearance <em>Colour Appearance</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Colour Appearance</em>' reference is set.
	 * @see #unsetColourAppearance()
	 * @see #getColourAppearance()
	 * @see #setColourAppearance(IfcColourRgb)
	 * @generated
	 */
	boolean isSetColourAppearance();

	/**
	 * Returns the value of the '<em><b>Colour Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Temperature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Temperature</em>' attribute.
	 * @see #isSetColourTemperature()
	 * @see #unsetColourTemperature()
	 * @see #setColourTemperature(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_ColourTemperature()
	 * @model unsettable="true"
	 * @generated
	 */
	double getColourTemperature();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperature <em>Colour Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour Temperature</em>' attribute.
	 * @see #isSetColourTemperature()
	 * @see #unsetColourTemperature()
	 * @see #getColourTemperature()
	 * @generated
	 */
	void setColourTemperature(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperature <em>Colour Temperature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColourTemperature()
	 * @see #getColourTemperature()
	 * @see #setColourTemperature(double)
	 * @generated
	 */
	void unsetColourTemperature();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperature <em>Colour Temperature</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Colour Temperature</em>' attribute is set.
	 * @see #unsetColourTemperature()
	 * @see #getColourTemperature()
	 * @see #setColourTemperature(double)
	 * @generated
	 */
	boolean isSetColourTemperature();

	/**
	 * Returns the value of the '<em><b>Colour Temperature As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Temperature As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Temperature As String</em>' attribute.
	 * @see #isSetColourTemperatureAsString()
	 * @see #unsetColourTemperatureAsString()
	 * @see #setColourTemperatureAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_ColourTemperatureAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getColourTemperatureAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperatureAsString <em>Colour Temperature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour Temperature As String</em>' attribute.
	 * @see #isSetColourTemperatureAsString()
	 * @see #unsetColourTemperatureAsString()
	 * @see #getColourTemperatureAsString()
	 * @generated
	 */
	void setColourTemperatureAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperatureAsString <em>Colour Temperature As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColourTemperatureAsString()
	 * @see #getColourTemperatureAsString()
	 * @see #setColourTemperatureAsString(String)
	 * @generated
	 */
	void unsetColourTemperatureAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getColourTemperatureAsString <em>Colour Temperature As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Colour Temperature As String</em>' attribute is set.
	 * @see #unsetColourTemperatureAsString()
	 * @see #getColourTemperatureAsString()
	 * @see #setColourTemperatureAsString(String)
	 * @generated
	 */
	boolean isSetColourTemperatureAsString();

	/**
	 * Returns the value of the '<em><b>Luminous Flux</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Flux</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Flux</em>' attribute.
	 * @see #isSetLuminousFlux()
	 * @see #unsetLuminousFlux()
	 * @see #setLuminousFlux(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_LuminousFlux()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLuminousFlux();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFlux <em>Luminous Flux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Luminous Flux</em>' attribute.
	 * @see #isSetLuminousFlux()
	 * @see #unsetLuminousFlux()
	 * @see #getLuminousFlux()
	 * @generated
	 */
	void setLuminousFlux(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFlux <em>Luminous Flux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLuminousFlux()
	 * @see #getLuminousFlux()
	 * @see #setLuminousFlux(double)
	 * @generated
	 */
	void unsetLuminousFlux();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFlux <em>Luminous Flux</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Luminous Flux</em>' attribute is set.
	 * @see #unsetLuminousFlux()
	 * @see #getLuminousFlux()
	 * @see #setLuminousFlux(double)
	 * @generated
	 */
	boolean isSetLuminousFlux();

	/**
	 * Returns the value of the '<em><b>Luminous Flux As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Luminous Flux As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Luminous Flux As String</em>' attribute.
	 * @see #isSetLuminousFluxAsString()
	 * @see #unsetLuminousFluxAsString()
	 * @see #setLuminousFluxAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_LuminousFluxAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLuminousFluxAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFluxAsString <em>Luminous Flux As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Luminous Flux As String</em>' attribute.
	 * @see #isSetLuminousFluxAsString()
	 * @see #unsetLuminousFluxAsString()
	 * @see #getLuminousFluxAsString()
	 * @generated
	 */
	void setLuminousFluxAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFluxAsString <em>Luminous Flux As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLuminousFluxAsString()
	 * @see #getLuminousFluxAsString()
	 * @see #setLuminousFluxAsString(String)
	 * @generated
	 */
	void unsetLuminousFluxAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLuminousFluxAsString <em>Luminous Flux As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Luminous Flux As String</em>' attribute is set.
	 * @see #unsetLuminousFluxAsString()
	 * @see #getLuminousFluxAsString()
	 * @see #setLuminousFluxAsString(String)
	 * @generated
	 */
	boolean isSetLuminousFluxAsString();

	/**
	 * Returns the value of the '<em><b>Light Emission Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcLightEmissionSourceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light Emission Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light Emission Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLightEmissionSourceEnum
	 * @see #isSetLightEmissionSource()
	 * @see #unsetLightEmissionSource()
	 * @see #setLightEmissionSource(IfcLightEmissionSourceEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_LightEmissionSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLightEmissionSourceEnum getLightEmissionSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightEmissionSource <em>Light Emission Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light Emission Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLightEmissionSourceEnum
	 * @see #isSetLightEmissionSource()
	 * @see #unsetLightEmissionSource()
	 * @see #getLightEmissionSource()
	 * @generated
	 */
	void setLightEmissionSource(IfcLightEmissionSourceEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightEmissionSource <em>Light Emission Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLightEmissionSource()
	 * @see #getLightEmissionSource()
	 * @see #setLightEmissionSource(IfcLightEmissionSourceEnum)
	 * @generated
	 */
	void unsetLightEmissionSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightEmissionSource <em>Light Emission Source</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Light Emission Source</em>' attribute is set.
	 * @see #unsetLightEmissionSource()
	 * @see #getLightEmissionSource()
	 * @see #setLightEmissionSource(IfcLightEmissionSourceEnum)
	 * @generated
	 */
	boolean isSetLightEmissionSource();

	/**
	 * Returns the value of the '<em><b>Light Distribution Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light Distribution Data Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light Distribution Data Source</em>' reference.
	 * @see #isSetLightDistributionDataSource()
	 * @see #unsetLightDistributionDataSource()
	 * @see #setLightDistributionDataSource(IfcLightDistributionDataSourceSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSourceGoniometric_LightDistributionDataSource()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcLightDistributionDataSourceSelect getLightDistributionDataSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightDistributionDataSource <em>Light Distribution Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light Distribution Data Source</em>' reference.
	 * @see #isSetLightDistributionDataSource()
	 * @see #unsetLightDistributionDataSource()
	 * @see #getLightDistributionDataSource()
	 * @generated
	 */
	void setLightDistributionDataSource(IfcLightDistributionDataSourceSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightDistributionDataSource <em>Light Distribution Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLightDistributionDataSource()
	 * @see #getLightDistributionDataSource()
	 * @see #setLightDistributionDataSource(IfcLightDistributionDataSourceSelect)
	 * @generated
	 */
	void unsetLightDistributionDataSource();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSourceGoniometric#getLightDistributionDataSource <em>Light Distribution Data Source</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Light Distribution Data Source</em>' reference is set.
	 * @see #unsetLightDistributionDataSource()
	 * @see #getLightDistributionDataSource()
	 * @see #setLightDistributionDataSource(IfcLightDistributionDataSourceSelect)
	 * @generated
	 */
	boolean isSetLightDistributionDataSource();

} // IfcLightSourceGoniometric
