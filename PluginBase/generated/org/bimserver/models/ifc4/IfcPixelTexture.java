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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Pixel Texture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPixelTexture#getWidth <em>Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPixelTexture#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPixelTexture#getColourComponents <em>Colour Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPixelTexture#getPixel <em>Pixel</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPixelTexture()
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
	 * @see #setWidth(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPixelTexture_Width()
	 * @model
	 * @generated
	 */
	long getWidth();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPixelTexture#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(long value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPixelTexture_Height()
	 * @model
	 * @generated
	 */
	long getHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPixelTexture#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(long value);

	/**
	 * Returns the value of the '<em><b>Colour Components</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Components</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Components</em>' attribute.
	 * @see #setColourComponents(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPixelTexture_ColourComponents()
	 * @model
	 * @generated
	 */
	long getColourComponents();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPixelTexture#getColourComponents <em>Colour Components</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colour Components</em>' attribute.
	 * @see #getColourComponents()
	 * @generated
	 */
	void setColourComponents(long value);

	/**
	 * Returns the value of the '<em><b>Pixel</b></em>' attribute list.
	 * The list contents are of type {@link byte}<code>[]</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pixel</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pixel</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPixelTexture_Pixel()
	 * @model unique="false"
	 * @generated
	 */
	EList<byte[]> getPixel();

} // IfcPixelTexture
