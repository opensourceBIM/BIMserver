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

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Vertex Based Texture Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTextureVertices <em>Texture Vertices</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTexturePoints <em>Texture Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexBasedTextureMap()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcVertexBasedTextureMap extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Texture Vertices</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTextureVertex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Vertices</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Vertices</em>' reference list.
	 * @see #isSetTextureVertices()
	 * @see #unsetTextureVertices()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexBasedTextureMap_TextureVertices()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcTextureVertex> getTextureVertices();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTextureVertices <em>Texture Vertices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextureVertices()
	 * @see #getTextureVertices()
	 * @generated
	 */
	void unsetTextureVertices();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTextureVertices <em>Texture Vertices</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Texture Vertices</em>' reference list is set.
	 * @see #unsetTextureVertices()
	 * @see #getTextureVertices()
	 * @generated
	 */
	boolean isSetTextureVertices();

	/**
	 * Returns the value of the '<em><b>Texture Points</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Points</em>' reference list.
	 * @see #isSetTexturePoints()
	 * @see #unsetTexturePoints()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexBasedTextureMap_TexturePoints()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCartesianPoint> getTexturePoints();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTexturePoints <em>Texture Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTexturePoints()
	 * @see #getTexturePoints()
	 * @generated
	 */
	void unsetTexturePoints();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap#getTexturePoints <em>Texture Points</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Texture Points</em>' reference list is set.
	 * @see #unsetTexturePoints()
	 * @see #getTexturePoints()
	 * @generated
	 */
	boolean isSetTexturePoints();

} // IfcVertexBasedTextureMap
