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
 * A representation of the model object '<em><b>Ifc Tessellated Face Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getCoordinates <em>Coordinates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasColours <em>Has Colours</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasTextures <em>Has Textures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getDim <em>Dim</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTessellatedFaceSet()
 * @model
 * @generated
 */
public interface IfcTessellatedFaceSet extends IfcTessellatedItem, IfcBooleanOperand {
	/**
	 * Returns the value of the '<em><b>Coordinates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coordinates</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinates</em>' reference.
	 * @see #setCoordinates(IfcCartesianPointList3D)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTessellatedFaceSet_Coordinates()
	 * @model
	 * @generated
	 */
	IfcCartesianPointList3D getCoordinates();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getCoordinates <em>Coordinates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinates</em>' reference.
	 * @see #getCoordinates()
	 * @generated
	 */
	void setCoordinates(IfcCartesianPointList3D value);

	/**
	 * Returns the value of the '<em><b>Has Colours</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcIndexedColourMap}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getMappedTo <em>Mapped To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Colours</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Colours</em>' reference list.
	 * @see #isSetHasColours()
	 * @see #unsetHasColours()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTessellatedFaceSet_HasColours()
	 * @see org.bimserver.models.ifc4.IfcIndexedColourMap#getMappedTo
	 * @model opposite="MappedTo" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcIndexedColourMap> getHasColours();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasColours <em>Has Colours</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasColours()
	 * @see #getHasColours()
	 * @generated
	 */
	void unsetHasColours();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasColours <em>Has Colours</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Colours</em>' reference list is set.
	 * @see #unsetHasColours()
	 * @see #getHasColours()
	 * @generated
	 */
	boolean isSetHasColours();

	/**
	 * Returns the value of the '<em><b>Has Textures</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcIndexedTextureMap}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcIndexedTextureMap#getMappedTo <em>Mapped To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Textures</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Textures</em>' reference list.
	 * @see #isSetHasTextures()
	 * @see #unsetHasTextures()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTessellatedFaceSet_HasTextures()
	 * @see org.bimserver.models.ifc4.IfcIndexedTextureMap#getMappedTo
	 * @model opposite="MappedTo" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcIndexedTextureMap> getHasTextures();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasTextures <em>Has Textures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasTextures()
	 * @see #getHasTextures()
	 * @generated
	 */
	void unsetHasTextures();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasTextures <em>Has Textures</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Textures</em>' reference list is set.
	 * @see #unsetHasTextures()
	 * @see #getHasTextures()
	 * @generated
	 */
	boolean isSetHasTextures();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTessellatedFaceSet_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(long)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(long)
	 * @generated
	 */
	boolean isSetDim();

} // IfcTessellatedFaceSet
