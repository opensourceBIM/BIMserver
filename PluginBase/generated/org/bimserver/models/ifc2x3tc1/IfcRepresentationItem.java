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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Representation Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getLayerAssignments <em>Layer Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getStyledByItem <em>Styled By Item</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRepresentationItem()
 * @model
 * @generated
 */
public interface IfcRepresentationItem extends IfcLayeredItem {
	/**
	 * Returns the value of the '<em><b>Layer Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcPresentationLayerAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Assignments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Assignments</em>' reference list.
	 * @see #isSetLayerAssignments()
	 * @see #unsetLayerAssignments()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRepresentationItem_LayerAssignments()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPresentationLayerAssignment> getLayerAssignments();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getLayerAssignments <em>Layer Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerAssignments()
	 * @see #getLayerAssignments()
	 * @generated
	 */
	void unsetLayerAssignments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getLayerAssignments <em>Layer Assignments</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Assignments</em>' reference list is set.
	 * @see #unsetLayerAssignments()
	 * @see #getLayerAssignments()
	 * @generated
	 */
	boolean isSetLayerAssignments();

	/**
	 * Returns the value of the '<em><b>Styled By Item</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcStyledItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStyledItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styled By Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styled By Item</em>' reference list.
	 * @see #isSetStyledByItem()
	 * @see #unsetStyledByItem()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRepresentationItem_StyledByItem()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStyledItem#getItem
	 * @model opposite="Item" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcStyledItem> getStyledByItem();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getStyledByItem <em>Styled By Item</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStyledByItem()
	 * @see #getStyledByItem()
	 * @generated
	 */
	void unsetStyledByItem();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcRepresentationItem#getStyledByItem <em>Styled By Item</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Styled By Item</em>' reference list is set.
	 * @see #unsetStyledByItem()
	 * @see #getStyledByItem()
	 * @generated
	 */
	boolean isSetStyledByItem();

} // IfcRepresentationItem
