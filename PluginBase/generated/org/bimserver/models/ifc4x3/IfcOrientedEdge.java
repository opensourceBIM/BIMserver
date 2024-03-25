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
 * A representation of the model object '<em><b>Ifc Oriented Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOrientedEdge#getEdgeElement <em>Edge Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcOrientedEdge#getOrientation <em>Orientation</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOrientedEdge()
 * @model
 * @generated
 */
public interface IfcOrientedEdge extends IfcEdge {
	/**
	 * Returns the value of the '<em><b>Edge Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Element</em>' reference.
	 * @see #setEdgeElement(IfcEdge)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOrientedEdge_EdgeElement()
	 * @model
	 * @generated
	 */
	IfcEdge getEdgeElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcOrientedEdge#getEdgeElement <em>Edge Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Element</em>' reference.
	 * @see #getEdgeElement()
	 * @generated
	 */
	void setEdgeElement(IfcEdge value);

	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #setOrientation(Tristate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcOrientedEdge_Orientation()
	 * @model
	 * @generated
	 */
	Tristate getOrientation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcOrientedEdge#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.Tristate
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(Tristate value);

} // IfcOrientedEdge
