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
 * A representation of the model object '<em><b>Ifc Alignment Cant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCant#getRailHeadDistance <em>Rail Head Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcAlignmentCant#getRailHeadDistanceAsString <em>Rail Head Distance As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCant()
 * @model
 * @generated
 */
public interface IfcAlignmentCant extends IfcLinearElement {
	/**
	 * Returns the value of the '<em><b>Rail Head Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rail Head Distance</em>' attribute.
	 * @see #setRailHeadDistance(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCant_RailHeadDistance()
	 * @model
	 * @generated
	 */
	double getRailHeadDistance();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCant#getRailHeadDistance <em>Rail Head Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rail Head Distance</em>' attribute.
	 * @see #getRailHeadDistance()
	 * @generated
	 */
	void setRailHeadDistance(double value);

	/**
	 * Returns the value of the '<em><b>Rail Head Distance As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rail Head Distance As String</em>' attribute.
	 * @see #setRailHeadDistanceAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentCant_RailHeadDistanceAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRailHeadDistanceAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcAlignmentCant#getRailHeadDistanceAsString <em>Rail Head Distance As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rail Head Distance As String</em>' attribute.
	 * @see #getRailHeadDistanceAsString()
	 * @generated
	 */
	void setRailHeadDistanceAsString(String value);

} // IfcAlignmentCant
