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
 * A representation of the model object '<em><b>Ifc Virtual Grid Intersection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVirtualGridIntersection#getIntersectingAxes <em>Intersecting Axes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVirtualGridIntersection#getOffsetDistances <em>Offset Distances</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcVirtualGridIntersection#getOffsetDistancesAsString <em>Offset Distances As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVirtualGridIntersection()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcVirtualGridIntersection extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Intersecting Axes</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcGridAxis}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcGridAxis#getHasIntersections <em>Has Intersections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intersecting Axes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intersecting Axes</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVirtualGridIntersection_IntersectingAxes()
	 * @see org.bimserver.models.ifc2x3.IfcGridAxis#getHasIntersections
	 * @model opposite="HasIntersections"
	 * @generated
	 */
	EList<IfcGridAxis> getIntersectingAxes();

	/**
	 * Returns the value of the '<em><b>Offset Distances</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Float}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Distances</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Distances</em>' attribute list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVirtualGridIntersection_OffsetDistances()
	 * @model unique="false"
	 * @generated
	 */
	EList<Float> getOffsetDistances();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcVirtualGridIntersection_OffsetDistancesAsString()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getOffsetDistancesAsString();

} // IfcVirtualGridIntersection
