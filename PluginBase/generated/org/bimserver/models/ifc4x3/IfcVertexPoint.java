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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Vertex Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcVertexPoint#getVertexGeometry <em>Vertex Geometry</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcVertexPoint()
 * @model
 * @generated
 */
public interface IfcVertexPoint extends IfcVertex, IfcPointOrVertexPoint {
	/**
	 * Returns the value of the '<em><b>Vertex Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Geometry</em>' reference.
	 * @see #setVertexGeometry(IfcPoint)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcVertexPoint_VertexGeometry()
	 * @model
	 * @generated
	 */
	IfcPoint getVertexGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcVertexPoint#getVertexGeometry <em>Vertex Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Geometry</em>' reference.
	 * @see #getVertexGeometry()
	 * @generated
	 */
	void setVertexGeometry(IfcPoint value);

} // IfcVertexPoint
