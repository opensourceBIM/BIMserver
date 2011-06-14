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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Representation Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationMap#getMappingOrigin <em>Mapping Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationMap#getMappedRepresentation <em>Mapped Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationMap#getMapUsage <em>Map Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationMap()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcRepresentationMap extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Mapping Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Origin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Origin</em>' reference.
	 * @see #setMappingOrigin(IfcAxis2Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationMap_MappingOrigin()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getMappingOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationMap#getMappingOrigin <em>Mapping Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Origin</em>' reference.
	 * @see #getMappingOrigin()
	 * @generated
	 */
	void setMappingOrigin(IfcAxis2Placement value);

	/**
	 * Returns the value of the '<em><b>Mapped Representation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRepresentation#getRepresentationMap <em>Representation Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Representation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Representation</em>' reference.
	 * @see #setMappedRepresentation(IfcRepresentation)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationMap_MappedRepresentation()
	 * @see org.bimserver.models.ifc2x3.IfcRepresentation#getRepresentationMap
	 * @model opposite="RepresentationMap"
	 * @generated
	 */
	IfcRepresentation getMappedRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationMap#getMappedRepresentation <em>Mapped Representation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Representation</em>' reference.
	 * @see #getMappedRepresentation()
	 * @generated
	 */
	void setMappedRepresentation(IfcRepresentation value);

	/**
	 * Returns the value of the '<em><b>Map Usage</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcMappedItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMappedItem#getMappingSource <em>Mapping Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Usage</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Usage</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationMap_MapUsage()
	 * @see org.bimserver.models.ifc2x3.IfcMappedItem#getMappingSource
	 * @model opposite="MappingSource"
	 * @generated
	 */
	EList<IfcMappedItem> getMapUsage();

} // IfcRepresentationMap
