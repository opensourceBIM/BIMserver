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
 * A representation of the model object '<em><b>Ifc Cartesian Point List2 D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCartesianPointList2D#getCoordList <em>Coord List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCartesianPointList2D#getTagList <em>Tag List</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCartesianPointList2D()
 * @model
 * @generated
 */
public interface IfcCartesianPointList2D extends IfcCartesianPointList {
	/**
	 * Returns the value of the '<em><b>Coord List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.ListOfIfcLengthMeasure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coord List</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCartesianPointList2D_CoordList()
	 * @model annotation="twodimensionalarray"
	 * @generated
	 */
	EList<ListOfIfcLengthMeasure> getCoordList();

	/**
	 * Returns the value of the '<em><b>Tag List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag List</em>' attribute list.
	 * @see #isSetTagList()
	 * @see #unsetTagList()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCartesianPointList2D_TagList()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getTagList();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCartesianPointList2D#getTagList <em>Tag List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTagList()
	 * @see #getTagList()
	 * @generated
	 */
	void unsetTagList();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCartesianPointList2D#getTagList <em>Tag List</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tag List</em>' attribute list is set.
	 * @see #unsetTagList()
	 * @see #getTagList()
	 * @generated
	 */
	boolean isSetTagList();

} // IfcCartesianPointList2D
