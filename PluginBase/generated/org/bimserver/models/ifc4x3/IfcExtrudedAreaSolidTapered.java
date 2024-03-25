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
 * A representation of the model object '<em><b>Ifc Extruded Area Solid Tapered</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcExtrudedAreaSolidTapered#getEndSweptArea <em>End Swept Area</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcExtrudedAreaSolidTapered()
 * @model
 * @generated
 */
public interface IfcExtrudedAreaSolidTapered extends IfcExtrudedAreaSolid {
	/**
	 * Returns the value of the '<em><b>End Swept Area</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Swept Area</em>' reference.
	 * @see #setEndSweptArea(IfcProfileDef)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcExtrudedAreaSolidTapered_EndSweptArea()
	 * @model
	 * @generated
	 */
	IfcProfileDef getEndSweptArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcExtrudedAreaSolidTapered#getEndSweptArea <em>End Swept Area</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Swept Area</em>' reference.
	 * @see #getEndSweptArea()
	 * @generated
	 */
	void setEndSweptArea(IfcProfileDef value);

} // IfcExtrudedAreaSolidTapered
