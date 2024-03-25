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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Well Known Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWellKnownText#getWellKnownText <em>Well Known Text</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcWellKnownText#getCoordinateReferenceSystem <em>Coordinate Reference System</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWellKnownText()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcWellKnownText extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Well Known Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Well Known Text</em>' attribute.
	 * @see #setWellKnownText(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWellKnownText_WellKnownText()
	 * @model
	 * @generated
	 */
	String getWellKnownText();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWellKnownText#getWellKnownText <em>Well Known Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Well Known Text</em>' attribute.
	 * @see #getWellKnownText()
	 * @generated
	 */
	void setWellKnownText(String value);

	/**
	 * Returns the value of the '<em><b>Coordinate Reference System</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcCoordinateReferenceSystem#getWellKnownText <em>Well Known Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coordinate Reference System</em>' reference.
	 * @see #setCoordinateReferenceSystem(IfcCoordinateReferenceSystem)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcWellKnownText_CoordinateReferenceSystem()
	 * @see org.bimserver.models.ifc4x3.IfcCoordinateReferenceSystem#getWellKnownText
	 * @model opposite="WellKnownText"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcCoordinateReferenceSystem getCoordinateReferenceSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcWellKnownText#getCoordinateReferenceSystem <em>Coordinate Reference System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coordinate Reference System</em>' reference.
	 * @see #getCoordinateReferenceSystem()
	 * @generated
	 */
	void setCoordinateReferenceSystem(IfcCoordinateReferenceSystem value);

} // IfcWellKnownText
