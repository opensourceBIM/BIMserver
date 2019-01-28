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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcLocalPlacement extends IfcObjectPlacement {
	/**
	 * Returns the value of the '<em><b>Placement Rel To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement Rel To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placement Rel To</em>' reference.
	 * @see #isSetPlacementRelTo()
	 * @see #unsetPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalPlacement_PlacementRelTo()
	 * @see org.bimserver.models.ifc2x3tc1.IfcObjectPlacement#getReferencedByPlacements
	 * @model opposite="ReferencedByPlacements" unsettable="true"
	 * @generated
	 */
	IfcObjectPlacement getPlacementRelTo();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placement Rel To</em>' reference.
	 * @see #isSetPlacementRelTo()
	 * @see #unsetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @generated
	 */
	void setPlacementRelTo(IfcObjectPlacement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @generated
	 */
	void unsetPlacementRelTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Placement Rel To</em>' reference is set.
	 * @see #unsetPlacementRelTo()
	 * @see #getPlacementRelTo()
	 * @see #setPlacementRelTo(IfcObjectPlacement)
	 * @generated
	 */
	boolean isSetPlacementRelTo();

	/**
	 * Returns the value of the '<em><b>Relative Placement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Placement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Placement</em>' reference.
	 * @see #setRelativePlacement(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLocalPlacement_RelativePlacement()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getRelativePlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLocalPlacement#getRelativePlacement <em>Relative Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Placement</em>' reference.
	 * @see #getRelativePlacement()
	 * @generated
	 */
	void setRelativePlacement(IfcAxis2Placement value);

} // IfcLocalPlacement
