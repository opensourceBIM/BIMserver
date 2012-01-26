/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Poly Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPolyLoop#getPolygon <em>Polygon</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPolyLoop()
 * @model
 * @generated
 */
public interface IfcPolyLoop extends IfcLoop {
	/**
	 * Returns the value of the '<em><b>Polygon</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcCartesianPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Polygon</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polygon</em>' reference list.
	 * @see #isSetPolygon()
	 * @see #unsetPolygon()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPolyLoop_Polygon()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcCartesianPoint> getPolygon();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPolyLoop#getPolygon <em>Polygon</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPolygon()
	 * @see #getPolygon()
	 * @generated
	 */
	void unsetPolygon();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPolyLoop#getPolygon <em>Polygon</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Polygon</em>' reference list is set.
	 * @see #unsetPolygon()
	 * @see #getPolygon()
	 * @generated
	 */
	boolean isSetPolygon();

} // IfcPolyLoop
