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
 * A representation of the model object '<em><b>Ifc Surface Style Lighting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getTransmissionColour <em>Transmission Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getReflectanceColour <em>Reflectance Colour</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleLighting()
 * @model
 * @generated
 */
public interface IfcSurfaceStyleLighting extends IfcSurfaceStyleElementSelect {
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
	 * @see #setDiffuseTransmissionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleLighting_DiffuseTransmissionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourRgb getDiffuseTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Transmission Colour</em>' reference.
	 * @see #isSetDiffuseTransmissionColour()
	 * @see #unsetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @generated
	 */
	void setDiffuseTransmissionColour(IfcColourRgb value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @see #setDiffuseTransmissionColour(IfcColourRgb)
	 * @generated
	 */
	void unsetDiffuseTransmissionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Diffuse Transmission Colour</em>' reference is set.
	 * @see #unsetDiffuseTransmissionColour()
	 * @see #getDiffuseTransmissionColour()
	 * @see #setDiffuseTransmissionColour(IfcColourRgb)
	 * @generated
	 */
	boolean isSetDiffuseTransmissionColour();

	/**
	 * Returns the value of the '<em><b>Diffuse Reflection Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Reflection Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Reflection Colour</em>' reference.
	 * @see #isSetDiffuseReflectionColour()
	 * @see #unsetDiffuseReflectionColour()
	 * @see #setDiffuseReflectionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleLighting_DiffuseReflectionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourRgb getDiffuseReflectionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Reflection Colour</em>' reference.
	 * @see #isSetDiffuseReflectionColour()
	 * @see #unsetDiffuseReflectionColour()
	 * @see #getDiffuseReflectionColour()
	 * @generated
	 */
	void setDiffuseReflectionColour(IfcColourRgb value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiffuseReflectionColour()
	 * @see #getDiffuseReflectionColour()
	 * @see #setDiffuseReflectionColour(IfcColourRgb)
	 * @generated
	 */
	void unsetDiffuseReflectionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Diffuse Reflection Colour</em>' reference is set.
	 * @see #unsetDiffuseReflectionColour()
	 * @see #getDiffuseReflectionColour()
	 * @see #setDiffuseReflectionColour(IfcColourRgb)
	 * @generated
	 */
	boolean isSetDiffuseReflectionColour();

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
	 * @see #setTransmissionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleLighting_TransmissionColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourRgb getTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getTransmissionColour <em>Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Colour</em>' reference.
	 * @see #isSetTransmissionColour()
	 * @see #unsetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @generated
	 */
	void setTransmissionColour(IfcColourRgb value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getTransmissionColour <em>Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @see #setTransmissionColour(IfcColourRgb)
	 * @generated
	 */
	void unsetTransmissionColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getTransmissionColour <em>Transmission Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transmission Colour</em>' reference is set.
	 * @see #unsetTransmissionColour()
	 * @see #getTransmissionColour()
	 * @see #setTransmissionColour(IfcColourRgb)
	 * @generated
	 */
	boolean isSetTransmissionColour();

	/**
	 * Returns the value of the '<em><b>Reflectance Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflectance Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflectance Colour</em>' reference.
	 * @see #isSetReflectanceColour()
	 * @see #unsetReflectanceColour()
	 * @see #setReflectanceColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSurfaceStyleLighting_ReflectanceColour()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcColourRgb getReflectanceColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getReflectanceColour <em>Reflectance Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflectance Colour</em>' reference.
	 * @see #isSetReflectanceColour()
	 * @see #unsetReflectanceColour()
	 * @see #getReflectanceColour()
	 * @generated
	 */
	void setReflectanceColour(IfcColourRgb value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getReflectanceColour <em>Reflectance Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReflectanceColour()
	 * @see #getReflectanceColour()
	 * @see #setReflectanceColour(IfcColourRgb)
	 * @generated
	 */
	void unsetReflectanceColour();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSurfaceStyleLighting#getReflectanceColour <em>Reflectance Colour</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reflectance Colour</em>' reference is set.
	 * @see #unsetReflectanceColour()
	 * @see #getReflectanceColour()
	 * @see #setReflectanceColour(IfcColourRgb)
	 * @generated
	 */
	boolean isSetReflectanceColour();

} // IfcSurfaceStyleLighting
