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
 * A representation of the model object '<em><b>Ifc Light Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getLightColour <em>Light Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensityAsString <em>Intensity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource()
 * @model
 * @generated
 */
public interface IfcLightSource extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Light Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Light Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Light Colour</em>' reference.
	 * @see #setLightColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_LightColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getLightColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getLightColour <em>Light Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Light Colour</em>' reference.
	 * @see #getLightColour()
	 * @generated
	 */
	void setLightColour(IfcColourRgb value);

	/**
	 * Returns the value of the '<em><b>Ambient Intensity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ambient Intensity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ambient Intensity</em>' attribute.
	 * @see #isSetAmbientIntensity()
	 * @see #unsetAmbientIntensity()
	 * @see #setAmbientIntensity(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_AmbientIntensity()
	 * @model unsettable="true"
	 * @generated
	 */
	float getAmbientIntensity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ambient Intensity</em>' attribute.
	 * @see #isSetAmbientIntensity()
	 * @see #unsetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @generated
	 */
	void setAmbientIntensity(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @see #setAmbientIntensity(float)
	 * @generated
	 */
	void unsetAmbientIntensity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensity <em>Ambient Intensity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ambient Intensity</em>' attribute is set.
	 * @see #unsetAmbientIntensity()
	 * @see #getAmbientIntensity()
	 * @see #setAmbientIntensity(float)
	 * @generated
	 */
	boolean isSetAmbientIntensity();

	/**
	 * Returns the value of the '<em><b>Ambient Intensity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ambient Intensity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ambient Intensity As String</em>' attribute.
	 * @see #isSetAmbientIntensityAsString()
	 * @see #unsetAmbientIntensityAsString()
	 * @see #setAmbientIntensityAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_AmbientIntensityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getAmbientIntensityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ambient Intensity As String</em>' attribute.
	 * @see #isSetAmbientIntensityAsString()
	 * @see #unsetAmbientIntensityAsString()
	 * @see #getAmbientIntensityAsString()
	 * @generated
	 */
	void setAmbientIntensityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAmbientIntensityAsString()
	 * @see #getAmbientIntensityAsString()
	 * @see #setAmbientIntensityAsString(String)
	 * @generated
	 */
	void unsetAmbientIntensityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ambient Intensity As String</em>' attribute is set.
	 * @see #unsetAmbientIntensityAsString()
	 * @see #getAmbientIntensityAsString()
	 * @see #setAmbientIntensityAsString(String)
	 * @generated
	 */
	boolean isSetAmbientIntensityAsString();

	/**
	 * Returns the value of the '<em><b>Intensity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intensity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intensity</em>' attribute.
	 * @see #isSetIntensity()
	 * @see #unsetIntensity()
	 * @see #setIntensity(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_Intensity()
	 * @model unsettable="true"
	 * @generated
	 */
	float getIntensity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intensity</em>' attribute.
	 * @see #isSetIntensity()
	 * @see #unsetIntensity()
	 * @see #getIntensity()
	 * @generated
	 */
	void setIntensity(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntensity()
	 * @see #getIntensity()
	 * @see #setIntensity(float)
	 * @generated
	 */
	void unsetIntensity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensity <em>Intensity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Intensity</em>' attribute is set.
	 * @see #unsetIntensity()
	 * @see #getIntensity()
	 * @see #setIntensity(float)
	 * @generated
	 */
	boolean isSetIntensity();

	/**
	 * Returns the value of the '<em><b>Intensity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intensity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intensity As String</em>' attribute.
	 * @see #isSetIntensityAsString()
	 * @see #unsetIntensityAsString()
	 * @see #setIntensityAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcLightSource_IntensityAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIntensityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensityAsString <em>Intensity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intensity As String</em>' attribute.
	 * @see #isSetIntensityAsString()
	 * @see #unsetIntensityAsString()
	 * @see #getIntensityAsString()
	 * @generated
	 */
	void setIntensityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensityAsString <em>Intensity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntensityAsString()
	 * @see #getIntensityAsString()
	 * @see #setIntensityAsString(String)
	 * @generated
	 */
	void unsetIntensityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcLightSource#getIntensityAsString <em>Intensity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Intensity As String</em>' attribute is set.
	 * @see #unsetIntensityAsString()
	 * @see #getIntensityAsString()
	 * @see #setIntensityAsString(String)
	 * @generated
	 */
	boolean isSetIntensityAsString();

} // IfcLightSource
