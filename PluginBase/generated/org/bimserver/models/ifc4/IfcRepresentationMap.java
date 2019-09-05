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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Representation Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMappingOrigin <em>Mapping Origin</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMappedRepresentation <em>Mapped Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationMap#getHasShapeAspects <em>Has Shape Aspects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMapUsage <em>Map Usage</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationMap()
 * @model
 * @generated
 */
public interface IfcRepresentationMap extends IfcProductRepresentationSelect {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationMap_MappingOrigin()
	 * @model
	 * @generated
	 */
	IfcAxis2Placement getMappingOrigin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMappingOrigin <em>Mapping Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Origin</em>' reference.
	 * @see #getMappingOrigin()
	 * @generated
	 */
	void setMappingOrigin(IfcAxis2Placement value);

	/**
	 * Returns the value of the '<em><b>Mapped Representation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRepresentation#getRepresentationMap <em>Representation Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Representation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Representation</em>' reference.
	 * @see #setMappedRepresentation(IfcRepresentation)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationMap_MappedRepresentation()
	 * @see org.bimserver.models.ifc4.IfcRepresentation#getRepresentationMap
	 * @model opposite="RepresentationMap"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRepresentation getMappedRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMappedRepresentation <em>Mapped Representation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Representation</em>' reference.
	 * @see #getMappedRepresentation()
	 * @generated
	 */
	void setMappedRepresentation(IfcRepresentation value);

	/**
	 * Returns the value of the '<em><b>Has Shape Aspects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcShapeAspect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Shape Aspects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Shape Aspects</em>' reference list.
	 * @see #isSetHasShapeAspects()
	 * @see #unsetHasShapeAspects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationMap_HasShapeAspects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcShapeAspect> getHasShapeAspects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getHasShapeAspects <em>Has Shape Aspects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasShapeAspects()
	 * @see #getHasShapeAspects()
	 * @generated
	 */
	void unsetHasShapeAspects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getHasShapeAspects <em>Has Shape Aspects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Shape Aspects</em>' reference list is set.
	 * @see #unsetHasShapeAspects()
	 * @see #getHasShapeAspects()
	 * @generated
	 */
	boolean isSetHasShapeAspects();

	/**
	 * Returns the value of the '<em><b>Map Usage</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcMappedItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcMappedItem#getMappingSource <em>Mapping Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Usage</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Usage</em>' reference list.
	 * @see #isSetMapUsage()
	 * @see #unsetMapUsage()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationMap_MapUsage()
	 * @see org.bimserver.models.ifc4.IfcMappedItem#getMappingSource
	 * @model opposite="MappingSource" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcMappedItem> getMapUsage();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMapUsage <em>Map Usage</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMapUsage()
	 * @see #getMapUsage()
	 * @generated
	 */
	void unsetMapUsage();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationMap#getMapUsage <em>Map Usage</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Map Usage</em>' reference list is set.
	 * @see #unsetMapUsage()
	 * @see #getMapUsage()
	 * @generated
	 */
	boolean isSetMapUsage();

} // IfcRepresentationMap
