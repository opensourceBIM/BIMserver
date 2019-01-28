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

public interface IfcSurfaceStyleRendering extends IfcSurfaceStyleShading {
	/**
	 * Returns the value of the '<em><b>Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transparency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transparency</em>' attribute.
	 * @see #isSetTransparency()
	 * @see #unsetTransparency()
	 * @see #setTransparency(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_Transparency()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransparency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparency <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transparency</em>' attribute.
	 * @see #isSetTransparency()
	 * @see #unsetTransparency()
	 * @see #getTransparency()
	 * @generated
	 */
	void setTransparency(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparency <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransparency()
	 * @see #getTransparency()
	 * @see #setTransparency(double)
	 * @generated
	 */
	void unsetTransparency();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparency <em>Transparency</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transparency</em>' attribute is set.
	 * @see #unsetTransparency()
	 * @see #getTransparency()
	 * @see #setTransparency(double)
	 * @generated
	 */
	boolean isSetTransparency();

	/**
	 * Returns the value of the '<em><b>Transparency As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transparency As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transparency As String</em>' attribute.
	 * @see #isSetTransparencyAsString()
	 * @see #unsetTransparencyAsString()
	 * @see #setTransparencyAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_TransparencyAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTransparencyAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparencyAsString <em>Transparency As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transparency As String</em>' attribute.
	 * @see #isSetTransparencyAsString()
	 * @see #unsetTransparencyAsString()
	 * @see #getTransparencyAsString()
	 * @generated
	 */
	void setTransparencyAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparencyAsString <em>Transparency As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransparencyAsString()
	 * @see #getTransparencyAsString()
	 * @see #setTransparencyAsString(String)
	 * @generated
	 */
	void unsetTransparencyAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransparencyAsString <em>Transparency As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transparency As String</em>' attribute is set.
	 * @see #unsetTransparencyAsString()
	 * @see #getTransparencyAsString()
	 * @see #setTransparencyAsString(String)
	 * @generated
	 */
	boolean isSetTransparencyAsString();

	/**
	 * Returns the value of the '<em><b>Diffuse Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Colour</em>' reference.
	 * @see #isSetDiffuseColour()
	 * @see #unsetDiffuseColour()
	 * @see #setDiffuseColour(IfcColourOrFactor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_DiffuseColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourOrFactor getDiffuseColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseColour <em>Diffuse Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Colour</em>' reference.
	 * @see #isSetDiffuseColour()
	 * @see #unsetDiffuseColour()
	 * @see #getDiffuseColour()
	 * @generated
	 */
	void setDiffuseColour(IfcColourOrFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseColour <em>Diffuse Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiffuseColour()
	 * @see #getDiffuseColour()
	 * @see #setDiffuseColour(IfcColourOrFactor)
	 * @generated
	 */
	void unsetDiffuseColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseColour <em>Diffuse Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Diffuse Colour</em>' reference is set.
	 * @see #unsetDiffuseColour()
	 * @see #getDiffuseColour()
	 * @see #setDiffuseColour(IfcColourOrFactor)
	 * @generated
	 */
	boolean isSetDiffuseColour();

	/**
	 * Returns the value of the '<em><b>Transmission Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Colour</em>' reference.
	 * @see #isSetTransmissionColour()
	 * @see #unsetTransmissionColour()
	 * @see #setTransmissionColour(IfcColourOrFactor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_TransmissionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourOrFactor getTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransmissionColour <em>Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Colour</em>' reference.
	 * @see #isSetTransmissionColour()
	 * @see #unsetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @generated
	 */
	void setTransmissionColour(IfcColourOrFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransmissionColour <em>Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @see #setTransmissionColour(IfcColourOrFactor)
	 * @generated
	 */
	void unsetTransmissionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getTransmissionColour <em>Transmission Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transmission Colour</em>' reference is set.
	 * @see #unsetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @see #setTransmissionColour(IfcColourOrFactor)
	 * @generated
	 */
	boolean isSetTransmissionColour();

	/**
	 * Returns the value of the '<em><b>Diffuse Transmission Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Transmission Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Transmission Colour</em>' reference.
	 * @see #isSetDiffuseTransmissionColour()
	 * @see #unsetDiffuseTransmissionColour()
	 * @see #setDiffuseTransmissionColour(IfcColourOrFactor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_DiffuseTransmissionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourOrFactor getDiffuseTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Transmission Colour</em>' reference.
	 * @see #isSetDiffuseTransmissionColour()
	 * @see #unsetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @generated
	 */
	void setDiffuseTransmissionColour(IfcColourOrFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @see #setDiffuseTransmissionColour(IfcColourOrFactor)
	 * @generated
	 */
	void unsetDiffuseTransmissionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Diffuse Transmission Colour</em>' reference is set.
	 * @see #unsetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @see #setDiffuseTransmissionColour(IfcColourOrFactor)
	 * @generated
	 */
	boolean isSetDiffuseTransmissionColour();

	/**
	 * Returns the value of the '<em><b>Reflection Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflection Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflection Colour</em>' reference.
	 * @see #isSetReflectionColour()
	 * @see #unsetReflectionColour()
	 * @see #setReflectionColour(IfcColourOrFactor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_ReflectionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourOrFactor getReflectionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getReflectionColour <em>Reflection Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflection Colour</em>' reference.
	 * @see #isSetReflectionColour()
	 * @see #unsetReflectionColour()
	 * @see #getReflectionColour()
	 * @generated
	 */
	void setReflectionColour(IfcColourOrFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getReflectionColour <em>Reflection Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReflectionColour()
	 * @see #getReflectionColour()
	 * @see #setReflectionColour(IfcColourOrFactor)
	 * @generated
	 */
	void unsetReflectionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getReflectionColour <em>Reflection Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reflection Colour</em>' reference is set.
	 * @see #unsetReflectionColour()
	 * @see #getReflectionColour()
	 * @see #setReflectionColour(IfcColourOrFactor)
	 * @generated
	 */
	boolean isSetReflectionColour();

	/**
	 * Returns the value of the '<em><b>Specular Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specular Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specular Colour</em>' reference.
	 * @see #isSetSpecularColour()
	 * @see #unsetSpecularColour()
	 * @see #setSpecularColour(IfcColourOrFactor)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_SpecularColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourOrFactor getSpecularColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularColour <em>Specular Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specular Colour</em>' reference.
	 * @see #isSetSpecularColour()
	 * @see #unsetSpecularColour()
	 * @see #getSpecularColour()
	 * @generated
	 */
	void setSpecularColour(IfcColourOrFactor value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularColour <em>Specular Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecularColour()
	 * @see #getSpecularColour()
	 * @see #setSpecularColour(IfcColourOrFactor)
	 * @generated
	 */
	void unsetSpecularColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularColour <em>Specular Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specular Colour</em>' reference is set.
	 * @see #unsetSpecularColour()
	 * @see #getSpecularColour()
	 * @see #setSpecularColour(IfcColourOrFactor)
	 * @generated
	 */
	boolean isSetSpecularColour();

	/**
	 * Returns the value of the '<em><b>Specular Highlight</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specular Highlight</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specular Highlight</em>' reference.
	 * @see #isSetSpecularHighlight()
	 * @see #unsetSpecularHighlight()
	 * @see #setSpecularHighlight(IfcSpecularHighlightSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_SpecularHighlight()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpecularHighlightSelect getSpecularHighlight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularHighlight <em>Specular Highlight</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specular Highlight</em>' reference.
	 * @see #isSetSpecularHighlight()
	 * @see #unsetSpecularHighlight()
	 * @see #getSpecularHighlight()
	 * @generated
	 */
	void setSpecularHighlight(IfcSpecularHighlightSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularHighlight <em>Specular Highlight</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpecularHighlight()
	 * @see #getSpecularHighlight()
	 * @see #setSpecularHighlight(IfcSpecularHighlightSelect)
	 * @generated
	 */
	void unsetSpecularHighlight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getSpecularHighlight <em>Specular Highlight</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Specular Highlight</em>' reference is set.
	 * @see #unsetSpecularHighlight()
	 * @see #getSpecularHighlight()
	 * @see #setSpecularHighlight(IfcSpecularHighlightSelect)
	 * @generated
	 */
	boolean isSetSpecularHighlight();

	/**
	 * Returns the value of the '<em><b>Reflectance Method</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcReflectanceMethodEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflectance Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflectance Method</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcReflectanceMethodEnum
	 * @see #setReflectanceMethod(IfcReflectanceMethodEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSurfaceStyleRendering_ReflectanceMethod()
	 * @model
	 * @generated
	 */
	IfcReflectanceMethodEnum getReflectanceMethod();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering#getReflectanceMethod <em>Reflectance Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflectance Method</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcReflectanceMethodEnum
	 * @see #getReflectanceMethod()
	 * @generated
	 */
	void setReflectanceMethod(IfcReflectanceMethodEnum value);

} // IfcSurfaceStyleRendering
