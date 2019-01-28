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

public interface IfcAnnotationSurface extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(IfcGeometricRepresentationItem)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAnnotationSurface_Item()
	 * @model
	 * @generated
	 */
	IfcGeometricRepresentationItem getItem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(IfcGeometricRepresentationItem value);

	/**
	 * Returns the value of the '<em><b>Texture Coordinates</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Coordinates</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Coordinates</em>' reference.
	 * @see #isSetTextureCoordinates()
	 * @see #unsetTextureCoordinates()
	 * @see #setTextureCoordinates(IfcTextureCoordinate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAnnotationSurface_TextureCoordinates()
	 * @see org.bimserver.models.ifc2x3tc1.IfcTextureCoordinate#getAnnotatedSurface
	 * @model opposite="AnnotatedSurface" unsettable="true"
	 * @generated
	 */
	IfcTextureCoordinate getTextureCoordinates();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture Coordinates</em>' reference.
	 * @see #isSetTextureCoordinates()
	 * @see #unsetTextureCoordinates()
	 * @see #getTextureCoordinates()
	 * @generated
	 */
	void setTextureCoordinates(IfcTextureCoordinate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextureCoordinates()
	 * @see #getTextureCoordinates()
	 * @see #setTextureCoordinates(IfcTextureCoordinate)
	 * @generated
	 */
	void unsetTextureCoordinates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Texture Coordinates</em>' reference is set.
	 * @see #unsetTextureCoordinates()
	 * @see #getTextureCoordinates()
	 * @see #setTextureCoordinates(IfcTextureCoordinate)
	 * @generated
	 */
	boolean isSetTextureCoordinates();

} // IfcAnnotationSurface
