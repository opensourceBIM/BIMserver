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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Grid Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementLocation <em>Placement Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridPlacement()
 * @model
 * @generated
 */
public interface IfcGridPlacement extends IfcObjectPlacement
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridPlacement_PlacementLocation()
	 * @model
	 * @generated
	 */
	IfcVirtualGridIntersection getPlacementLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementLocation <em>Placement Location</em>}' reference.
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
	 * @see #setPlacementRefDirection(IfcVirtualGridIntersection)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGridPlacement_PlacementRefDirection()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcVirtualGridIntersection getPlacementRefDirection();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Ref Direction</em>' reference.
	 * @see #isSetPlacementRefDirection()
	 * @see #unsetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @generated
	 */
	void setPlacementRefDirection(IfcVirtualGridIntersection value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @see #setPlacementRefDirection(IfcVirtualGridIntersection)
	 * @generated
	 */
	void unsetPlacementRefDirection();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcGridPlacement#getPlacementRefDirection <em>Placement Ref Direction</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement Ref Direction</em>' reference is set.
	 * @see #unsetPlacementRefDirection()
	 * @see #getPlacementRefDirection()
	 * @see #setPlacementRefDirection(IfcVirtualGridIntersection)
	 * @generated
	 */
	boolean isSetPlacementRefDirection();

} // IfcGridPlacement
