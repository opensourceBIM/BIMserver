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
 * A representation of the model object '<em><b>Ifc Texture Coordinate Indices With Voids</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcTextureCoordinateIndicesWithVoids#getInnerTexCoordIndices <em>Inner Tex Coord Indices</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndicesWithVoids()
 * @model
 * @generated
 */
public interface IfcTextureCoordinateIndicesWithVoids extends IfcTextureCoordinateIndices {
	/**
	 * Returns the value of the '<em><b>Inner Tex Coord Indices</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.ListOfELong}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Tex Coord Indices</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTextureCoordinateIndicesWithVoids_InnerTexCoordIndices()
	 * @model annotation="twodimensionalarray"
	 * @generated
	 */
	EList<ListOfELong> getInnerTexCoordIndices();

} // IfcTextureCoordinateIndicesWithVoids
