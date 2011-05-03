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

import org.bimserver.emf.IdEObject;

import org.bimserver.models.ifc2x3.IfcLocalPlacement;
import org.bimserver.models.ifc2x3.IfcProduct;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Object Placement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectPlacement#getPlacesObject <em>Places Object</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcObjectPlacement#getReferencedByPlacements <em>Referenced By Placements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectPlacement()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcObjectPlacement extends IdEObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Places Object</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProduct}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProduct#getObjectPlacement <em>Object Placement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Places Object</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Places Object</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectPlacement_PlacesObject()
	 * @see org.bimserver.models.ifc2x3.IfcProduct#getObjectPlacement
	 * @model opposite="ObjectPlacement" upper="2"
	 * @generated
	 */
	EList<IfcProduct> getPlacesObject();

	/**
	 * Returns the value of the '<em><b>Referenced By Placements</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcLocalPlacement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo <em>Placement Rel To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By Placements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By Placements</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcObjectPlacement_ReferencedByPlacements()
	 * @see org.bimserver.models.ifc2x3.IfcLocalPlacement#getPlacementRelTo
	 * @model opposite="PlacementRelTo"
	 * @generated
	 */
	EList<IfcLocalPlacement> getReferencedByPlacements();

} // IfcObjectPlacement
