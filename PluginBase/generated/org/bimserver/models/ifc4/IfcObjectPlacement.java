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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Object Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectPlacement#getPlacesObject <em>Places Object</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectPlacement()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcObjectPlacement extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Places Object</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcProduct}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcProduct#getObjectPlacement <em>Object Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Places Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Places Object</em>' reference list.
	 * @see #isSetPlacesObject()
	 * @see #unsetPlacesObject()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectPlacement_PlacesObject()
	 * @see org.bimserver.models.ifc4.IfcProduct#getObjectPlacement
	 * @model opposite="ObjectPlacement" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProduct> getPlacesObject();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectPlacement#getPlacesObject <em>Places Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlacesObject()
	 * @see #getPlacesObject()
	 * @generated
	 */
	void unsetPlacesObject();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectPlacement#getPlacesObject <em>Places Object</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Places Object</em>' reference list is set.
	 * @see #unsetPlacesObject()
	 * @see #getPlacesObject()
	 * @generated
	 */
	boolean isSetPlacesObject();

	/**
	 * Returns the value of the '<em><b>Referenced By Placements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcLocalPlacement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By Placements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By Placements</em>' reference list.
	 * @see #isSetReferencedByPlacements()
	 * @see #unsetReferencedByPlacements()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcObjectPlacement_ReferencedByPlacements()
	 * @see org.bimserver.models.ifc4.IfcLocalPlacement#getPlacementRelTo
	 * @model opposite="PlacementRelTo" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcLocalPlacement> getReferencedByPlacements();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedByPlacements()
	 * @see #getReferencedByPlacements()
	 * @generated
	 */
	void unsetReferencedByPlacements();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced By Placements</em>' reference list is set.
	 * @see #unsetReferencedByPlacements()
	 * @see #getReferencedByPlacements()
	 * @generated
	 */
	boolean isSetReferencedByPlacements();

} // IfcObjectPlacement
