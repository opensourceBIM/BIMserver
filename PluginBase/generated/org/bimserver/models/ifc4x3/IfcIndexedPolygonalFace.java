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
package org.bimserver.models.ifc4x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Indexed Polygonal Face</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getCoordIndex <em>Coord Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getToFaceSet <em>To Face Set</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getHasTexCoords <em>Has Tex Coords</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcIndexedPolygonalFace()
 * @model
 * @generated
 */
public interface IfcIndexedPolygonalFace extends IfcTessellatedItem {
	/**
	 * Returns the value of the '<em><b>Coord Index</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coord Index</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcIndexedPolygonalFace_CoordIndex()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getCoordIndex();

	/**
	 * Returns the value of the '<em><b>To Face Set</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPolygonalFaceSet}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcPolygonalFaceSet#getFaces <em>Faces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Face Set</em>' reference list.
	 * @see #isSetToFaceSet()
	 * @see #unsetToFaceSet()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcIndexedPolygonalFace_ToFaceSet()
	 * @see org.bimserver.models.ifc4x3.IfcPolygonalFaceSet#getFaces
	 * @model opposite="Faces" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPolygonalFaceSet> getToFaceSet();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getToFaceSet <em>To Face Set</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToFaceSet()
	 * @see #getToFaceSet()
	 * @generated
	 */
	void unsetToFaceSet();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getToFaceSet <em>To Face Set</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>To Face Set</em>' reference list is set.
	 * @see #unsetToFaceSet()
	 * @see #getToFaceSet()
	 * @generated
	 */
	boolean isSetToFaceSet();

	/**
	 * Returns the value of the '<em><b>Has Tex Coords</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getTexCoordsOf <em>Tex Coords Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Tex Coords</em>' reference list.
	 * @see #isSetHasTexCoords()
	 * @see #unsetHasTexCoords()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcIndexedPolygonalFace_HasTexCoords()
	 * @see org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getTexCoordsOf
	 * @model opposite="TexCoordsOf" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcTextureCoordinateIndices> getHasTexCoords();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getHasTexCoords <em>Has Tex Coords</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasTexCoords()
	 * @see #getHasTexCoords()
	 * @generated
	 */
	void unsetHasTexCoords();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getHasTexCoords <em>Has Tex Coords</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Tex Coords</em>' reference list is set.
	 * @see #unsetHasTexCoords()
	 * @see #getHasTexCoords()
	 * @generated
	 */
	boolean isSetHasTexCoords();

} // IfcIndexedPolygonalFace
