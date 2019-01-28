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
package org.bimserver.models.ifc2x3tc1;

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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Virtual Grid Intersection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection#getIntersectingAxes <em>Intersecting Axes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection#getOffsetDistances <em>Offset Distances</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcVirtualGridIntersection#getOffsetDistancesAsString <em>Offset Distances As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcVirtualGridIntersection()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcVirtualGridIntersection extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Intersecting Axes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intersecting Axes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intersecting Axes</em>' reference list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcVirtualGridIntersection_IntersectingAxes()
	 * @see org.bimserver.models.ifc2x3tc1.IfcGridAxis#getHasIntersections
	 * @model opposite="HasIntersections"
	 * @generated
	 */
	EList<IfcGridAxis> getIntersectingAxes();

	/**
	 * Returns the value of the '<em><b>Offset Distances</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Distances</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Distances</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcVirtualGridIntersection_OffsetDistances()
	 * @model unique="false"
	 * @generated
	 */
	EList<Double> getOffsetDistances();

	/**
	 * Returns the value of the '<em><b>Offset Distances As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Distances As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Distances As String</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcVirtualGridIntersection_OffsetDistancesAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getOffsetDistancesAsString();

} // IfcVirtualGridIntersection
