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
package org.bimserver.models.ifc4;

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

public interface IfcSurfaceStyleLighting extends IfcPresentationItem, IfcSurfaceStyleElementSelect {
	/**
	 * Returns the value of the '<em><b>Diffuse Transmission Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Transmission Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Transmission Colour</em>' reference.
	 * @see #setDiffuseTransmissionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleLighting_DiffuseTransmissionColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getDiffuseTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleLighting#getDiffuseTransmissionColour <em>Diffuse Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Transmission Colour</em>' reference.
	 * @see #getDiffuseTransmissionColour()
	 * @generated
	 */
	void setDiffuseTransmissionColour(IfcColourRgb value);

	/**
	 * Returns the value of the '<em><b>Diffuse Reflection Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Reflection Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Reflection Colour</em>' reference.
	 * @see #setDiffuseReflectionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleLighting_DiffuseReflectionColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getDiffuseReflectionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleLighting#getDiffuseReflectionColour <em>Diffuse Reflection Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Reflection Colour</em>' reference.
	 * @see #getDiffuseReflectionColour()
	 * @generated
	 */
	void setDiffuseReflectionColour(IfcColourRgb value);

	/**
	 * Returns the value of the '<em><b>Transmission Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transmission Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transmission Colour</em>' reference.
	 * @see #setTransmissionColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleLighting_TransmissionColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getTransmissionColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleLighting#getTransmissionColour <em>Transmission Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Colour</em>' reference.
	 * @see #getTransmissionColour()
	 * @generated
	 */
	void setTransmissionColour(IfcColourRgb value);

	/**
	 * Returns the value of the '<em><b>Reflectance Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflectance Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflectance Colour</em>' reference.
	 * @see #setReflectanceColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleLighting_ReflectanceColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getReflectanceColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleLighting#getReflectanceColour <em>Reflectance Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflectance Colour</em>' reference.
	 * @see #getReflectanceColour()
	 * @generated
	 */
	void setReflectanceColour(IfcColourRgb value);

} // IfcSurfaceStyleLighting
