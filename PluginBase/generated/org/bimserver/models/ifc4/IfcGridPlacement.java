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

public interface IfcGridPlacement extends IfcObjectPlacement {
	/**
	 * Returns the value of the '<em><b>Placement Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement Location</em>' reference.
	 * @see #setPlacementLocation(IfcVirtualGridIntersection)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGridPlacement_PlacementLocation()
	 * @model
	 * @generated
	 */
	IfcVirtualGridIntersection getPlacementLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGridPlacement#getPlacementLocation <em>Placement Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Location</em>' reference.
	 * @see #getPlacementLocation()
	 * @generated
	 */
	void setPlacementLocation(IfcVirtualGridIntersection value);

	/**
	 * Returns the value of the '<em><b>Placement Ref Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement Ref Direction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement Ref Direction</em>' reference.
	 * @see #isSetPlacementRefDirection()
	 * @see #unsetPlacementRefDirection()
	 * @see #setPlacementRefDirection(IfcGridPlacementDirectionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcGridPlacement_PlacementRefDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcGridPlacementDirectionSelect getPlacementRefDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Ref Direction</em>' reference.
	 * @see #isSetPlacementRefDirection()
	 * @see #unsetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @generated
	 */
	void setPlacementRefDirection(IfcGridPlacementDirectionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @see #setPlacementRefDirection(IfcGridPlacementDirectionSelect)
	 * @generated
	 */
	void unsetPlacementRefDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement Ref Direction</em>' reference is set.
	 * @see #unsetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @see #setPlacementRefDirection(IfcGridPlacementDirectionSelect)
	 * @generated
	 */
	boolean isSetPlacementRefDirection();

} // IfcGridPlacement
