/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
