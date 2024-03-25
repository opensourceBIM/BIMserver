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
 * A representation of the model object '<em><b>Ifc Linear Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getRelativePlacement <em>Relative Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getCartesianPosition <em>Cartesian Position</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLinearPlacement()
 * @model
 * @generated
 */
public interface IfcLinearPlacement extends IfcObjectPlacement {
	/**
	 * Returns the value of the '<em><b>Relative Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Placement</em>' reference.
	 * @see #setRelativePlacement(IfcAxis2PlacementLinear)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLinearPlacement_RelativePlacement()
	 * @model
	 * @generated
	 */
	IfcAxis2PlacementLinear getRelativePlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getRelativePlacement <em>Relative Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Placement</em>' reference.
	 * @see #getRelativePlacement()
	 * @generated
	 */
	void setRelativePlacement(IfcAxis2PlacementLinear value);

	/**
	 * Returns the value of the '<em><b>Cartesian Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cartesian Position</em>' reference.
	 * @see #isSetCartesianPosition()
	 * @see #unsetCartesianPosition()
	 * @see #setCartesianPosition(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcLinearPlacement_CartesianPosition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getCartesianPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getCartesianPosition <em>Cartesian Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cartesian Position</em>' reference.
	 * @see #isSetCartesianPosition()
	 * @see #unsetCartesianPosition()
	 * @see #getCartesianPosition()
	 * @generated
	 */
	void setCartesianPosition(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getCartesianPosition <em>Cartesian Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCartesianPosition()
	 * @see #getCartesianPosition()
	 * @see #setCartesianPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetCartesianPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcLinearPlacement#getCartesianPosition <em>Cartesian Position</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cartesian Position</em>' reference is set.
	 * @see #unsetCartesianPosition()
	 * @see #getCartesianPosition()
	 * @see #setCartesianPosition(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetCartesianPosition();

} // IfcLinearPlacement
