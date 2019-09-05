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

public interface IfcIndexedTextureMap extends IfcTextureCoordinate {
	/**
	 * Returns the value of the '<em><b>Mapped To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasTextures <em>Has Textures</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped To</em>' reference.
	 * @see #setMappedTo(IfcTessellatedFaceSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedTextureMap_MappedTo()
	 * @see org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasTextures
	 * @model opposite="HasTextures"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcTessellatedFaceSet getMappedTo();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedTextureMap#getMappedTo <em>Mapped To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped To</em>' reference.
	 * @see #getMappedTo()
	 * @generated
	 */
	void setMappedTo(IfcTessellatedFaceSet value);

	/**
	 * Returns the value of the '<em><b>Tex Coords</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tex Coords</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tex Coords</em>' reference.
	 * @see #setTexCoords(IfcTextureVertexList)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedTextureMap_TexCoords()
	 * @model
	 * @generated
	 */
	IfcTextureVertexList getTexCoords();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedTextureMap#getTexCoords <em>Tex Coords</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tex Coords</em>' reference.
	 * @see #getTexCoords()
	 * @generated
	 */
	void setTexCoords(IfcTextureVertexList value);

} // IfcIndexedTextureMap
