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
 * A representation of the model object '<em><b>Ifc Pixel Texture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getColourComponents <em>Colour Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPixelTexture()
 * @model
 * @generated
 */
public interface IfcPixelTexture extends IfcSurfaceTexture {
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #setWidth(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPixelTexture_Width()
	 * @model unsettable="true"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
	void unsetWidth();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getWidth <em>Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Width</em>' attribute is set.
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
	boolean isSetWidth();

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #setHeight(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPixelTexture_Height()
	 * @model unsettable="true"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
	void unsetHeight();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getHeight <em>Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height</em>' attribute is set.
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
	boolean isSetHeight();

	/**
	 * Returns the value of the '<em><b>Colour Components</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Components</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Components</em>' attribute.
	 * @see #isSetColourComponents()
	 * @see #unsetColourComponents()
	 * @see #setColourComponents(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPixelTexture_ColourComponents()
	 * @model unsettable="true"
	 * @generated
	 */
	int getColourComponents();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getColourComponents <em>Colour Components</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour Components</em>' attribute.
	 * @see #isSetColourComponents()
	 * @see #unsetColourComponents()
	 * @see #getColourComponents()
	 * @generated
	 */
	void setColourComponents(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getColourComponents <em>Colour Components</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetColourComponents()
	 * @see #getColourComponents()
	 * @see #setColourComponents(int)
	 * @generated
	 */
	void unsetColourComponents();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPixelTexture#getColourComponents <em>Colour Components</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Colour Components</em>' attribute is set.
	 * @see #unsetColourComponents()
	 * @see #getColourComponents()
	 * @see #setColourComponents(int)
	 * @generated
	 */
	boolean isSetColourComponents();

} // IfcPixelTexture
