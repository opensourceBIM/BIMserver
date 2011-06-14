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
public interface IfcVertexBasedTextureMap extends IdEObject
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexBasedTextureMap_TextureVertices()
	 * @model
	 * @generated
	 */
	EList<IfcTextureVertex> getTextureVertices();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVertexBasedTextureMap_TexturePoints()
	 * @model
	 * @generated
	 */
	EList<IfcCartesianPoint> getTexturePoints();

} // IfcVertexBasedTextureMap
