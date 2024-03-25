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

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Coordinate Indices</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getTexCoordIndex <em>Tex Coord Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getTexCoordsOf <em>Tex Coords Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getToTexMap <em>To Tex Map</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndices()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTextureCoordinateIndices extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Tex Coord Index</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tex Coord Index</em>' attribute list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndices_TexCoordIndex()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getTexCoordIndex();

	/**
	 * Returns the value of the '<em><b>Tex Coords Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getHasTexCoords <em>Has Tex Coords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tex Coords Of</em>' reference.
	 * @see #setTexCoordsOf(IfcIndexedPolygonalFace)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndices_TexCoordsOf()
	 * @see org.bimserver.models.ifc4x3.IfcIndexedPolygonalFace#getHasTexCoords
	 * @model opposite="HasTexCoords"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcIndexedPolygonalFace getTexCoordsOf();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getTexCoordsOf <em>Tex Coords Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tex Coords Of</em>' reference.
	 * @see #getTexCoordsOf()
	 * @generated
	 */
	void setTexCoordsOf(IfcIndexedPolygonalFace value);

	/**
	 * Returns the value of the '<em><b>To Tex Map</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcIndexedPolygonalTextureMap#getTexCoordIndices <em>Tex Coord Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Tex Map</em>' reference.
	 * @see #isSetToTexMap()
	 * @see #unsetToTexMap()
	 * @see #setToTexMap(IfcIndexedPolygonalTextureMap)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndices_ToTexMap()
	 * @see org.bimserver.models.ifc4x3.IfcIndexedPolygonalTextureMap#getTexCoordIndices
	 * @model opposite="TexCoordIndices" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcIndexedPolygonalTextureMap getToTexMap();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getToTexMap <em>To Tex Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Tex Map</em>' reference.
	 * @see #isSetToTexMap()
	 * @see #unsetToTexMap()
	 * @see #getToTexMap()
	 * @generated
	 */
	void setToTexMap(IfcIndexedPolygonalTextureMap value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getToTexMap <em>To Tex Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetToTexMap()
	 * @see #getToTexMap()
	 * @see #setToTexMap(IfcIndexedPolygonalTextureMap)
	 * @generated
	 */
	void unsetToTexMap();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndices#getToTexMap <em>To Tex Map</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>To Tex Map</em>' reference is set.
	 * @see #unsetToTexMap()
	 * @see #getToTexMap()
	 * @see #setToTexMap(IfcIndexedPolygonalTextureMap)
	 * @generated
	 */
	boolean isSetToTexMap();

} // IfcTextureCoordinateIndices
