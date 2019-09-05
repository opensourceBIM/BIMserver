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

public interface IfcSurfaceStyleShading extends IfcPresentationItem, IfcSurfaceStyleElementSelect {
	/**
	 * Returns the value of the '<em><b>Surface Colour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Colour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Colour</em>' reference.
	 * @see #setSurfaceColour(IfcColourRgb)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleShading_SurfaceColour()
	 * @model
	 * @generated
	 */
	IfcColourRgb getSurfaceColour();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getSurfaceColour <em>Surface Colour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surface Colour</em>' reference.
	 * @see #getSurfaceColour()
	 * @generated
	 */
	void setSurfaceColour(IfcColourRgb value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleShading_Transparency()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransparency();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparency <em>Transparency</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparency <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransparency()
	 * @see #getTransparency()
	 * @see #setTransparency(double)
	 * @generated
	 */
	void unsetTransparency();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparency <em>Transparency</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceStyleShading_TransparencyAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransparencyAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparencyAsString <em>Transparency As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparencyAsString <em>Transparency As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransparencyAsString()
	 * @see #getTransparencyAsString()
	 * @see #setTransparencyAsString(String)
	 * @generated
	 */
	void unsetTransparencyAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceStyleShading#getTransparencyAsString <em>Transparency As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transparency As String</em>' attribute is set.
	 * @see #unsetTransparencyAsString()
	 * @see #getTransparencyAsString()
	 * @see #setTransparencyAsString(String)
	 * @generated
	 */
	boolean isSetTransparencyAsString();

} // IfcSurfaceStyleShading
