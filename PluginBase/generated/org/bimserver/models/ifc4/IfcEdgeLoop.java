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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Edge Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcEdgeLoop#getEdgeList <em>Edge List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcEdgeLoop#getNe <em>Ne</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEdgeLoop()
 * @model
 * @generated
 */
public interface IfcEdgeLoop extends IfcLoop {
	/**
	 * Returns the value of the '<em><b>Edge List</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcOrientedEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge List</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEdgeLoop_EdgeList()
	 * @model
	 * @generated
	 */
	EList<IfcOrientedEdge> getEdgeList();

	/**
	 * Returns the value of the '<em><b>Ne</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ne</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ne</em>' attribute.
	 * @see #isSetNe()
	 * @see #unsetNe()
	 * @see #setNe(long)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEdgeLoop_Ne()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	long getNe();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcEdgeLoop#getNe <em>Ne</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ne</em>' attribute.
	 * @see #isSetNe()
	 * @see #unsetNe()
	 * @see #getNe()
	 * @generated
	 */
	void setNe(long value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcEdgeLoop#getNe <em>Ne</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNe()
	 * @see #getNe()
	 * @see #setNe(long)
	 * @generated
	 */
	void unsetNe();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcEdgeLoop#getNe <em>Ne</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ne</em>' attribute is set.
	 * @see #unsetNe()
	 * @see #getNe()
	 * @see #setNe(long)
	 * @generated
	 */
	boolean isSetNe();

} // IfcEdgeLoop
