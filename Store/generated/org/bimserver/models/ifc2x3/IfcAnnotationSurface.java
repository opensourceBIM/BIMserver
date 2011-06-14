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
 * A representation of the model object '<em><b>Ifc Annotation Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getItem <em>Item</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationSurface()
 * @model
 * @generated
 */
public interface IfcAnnotationSurface extends IfcGeometricRepresentationItem
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationSurface_Item()
	 * @model
	 * @generated
	 */
	IfcGeometricRepresentationItem getItem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(IfcGeometricRepresentationItem value);

	/**
	 * Returns the value of the '<em><b>Texture Coordinates</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTextureCoordinate#getAnnotatedSurface <em>Annotated Surface</em>}'.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationSurface_TextureCoordinates()
	 * @see org.bimserver.models.ifc2x3.IfcTextureCoordinate#getAnnotatedSurface
	 * @model opposite="AnnotatedSurface" unsettable="true"
	 * @generated
	 */
	IfcTextureCoordinate getTextureCoordinates();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextureCoordinates()
	 * @see #getTextureCoordinates()
	 * @see #setTextureCoordinates(IfcTextureCoordinate)
	 * @generated
	 */
	void unsetTextureCoordinates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationSurface#getTextureCoordinates <em>Texture Coordinates</em>}' reference is set.
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
