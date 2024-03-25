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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getContextOfItems <em>Context Of Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationIdentifier <em>Representation Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationType <em>Representation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getItems <em>Items</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationMap <em>Representation Map</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getLayerAssignments <em>Layer Assignments</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRepresentation#getOfProductRepresentation <em>Of Product Representation</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation()
 * @model
 * @generated
 */
public interface IfcRepresentation extends IfcLayeredItem {
	/**
	 * Returns the value of the '<em><b>Context Of Items</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRepresentationContext#getRepresentationsInContext <em>Representations In Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Of Items</em>' reference.
	 * @see #setContextOfItems(IfcRepresentationContext)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_ContextOfItems()
	 * @see org.bimserver.models.ifc4x3.IfcRepresentationContext#getRepresentationsInContext
	 * @model opposite="RepresentationsInContext"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRepresentationContext getContextOfItems();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getContextOfItems <em>Context Of Items</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Of Items</em>' reference.
	 * @see #getContextOfItems()
	 * @generated
	 */
	void setContextOfItems(IfcRepresentationContext value);

	/**
	 * Returns the value of the '<em><b>Representation Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation Identifier</em>' attribute.
	 * @see #isSetRepresentationIdentifier()
	 * @see #unsetRepresentationIdentifier()
	 * @see #setRepresentationIdentifier(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_RepresentationIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRepresentationIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationIdentifier <em>Representation Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation Identifier</em>' attribute.
	 * @see #isSetRepresentationIdentifier()
	 * @see #unsetRepresentationIdentifier()
	 * @see #getRepresentationIdentifier()
	 * @generated
	 */
	void setRepresentationIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationIdentifier <em>Representation Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationIdentifier()
	 * @see #getRepresentationIdentifier()
	 * @see #setRepresentationIdentifier(String)
	 * @generated
	 */
	void unsetRepresentationIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationIdentifier <em>Representation Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation Identifier</em>' attribute is set.
	 * @see #unsetRepresentationIdentifier()
	 * @see #getRepresentationIdentifier()
	 * @see #setRepresentationIdentifier(String)
	 * @generated
	 */
	boolean isSetRepresentationIdentifier();

	/**
	 * Returns the value of the '<em><b>Representation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation Type</em>' attribute.
	 * @see #isSetRepresentationType()
	 * @see #unsetRepresentationType()
	 * @see #setRepresentationType(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_RepresentationType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRepresentationType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationType <em>Representation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation Type</em>' attribute.
	 * @see #isSetRepresentationType()
	 * @see #unsetRepresentationType()
	 * @see #getRepresentationType()
	 * @generated
	 */
	void setRepresentationType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationType <em>Representation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationType()
	 * @see #getRepresentationType()
	 * @see #setRepresentationType(String)
	 * @generated
	 */
	void unsetRepresentationType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationType <em>Representation Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation Type</em>' attribute is set.
	 * @see #unsetRepresentationType()
	 * @see #getRepresentationType()
	 * @see #setRepresentationType(String)
	 * @generated
	 */
	boolean isSetRepresentationType();

	/**
	 * Returns the value of the '<em><b>Items</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRepresentationItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_Items()
	 * @model
	 * @generated
	 */
	EList<IfcRepresentationItem> getItems();

	/**
	 * Returns the value of the '<em><b>Representation Map</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRepresentationMap}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRepresentationMap#getMappedRepresentation <em>Mapped Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation Map</em>' reference list.
	 * @see #isSetRepresentationMap()
	 * @see #unsetRepresentationMap()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_RepresentationMap()
	 * @see org.bimserver.models.ifc4x3.IfcRepresentationMap#getMappedRepresentation
	 * @model opposite="MappedRepresentation" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRepresentationMap> getRepresentationMap();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationMap <em>Representation Map</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationMap()
	 * @see #getRepresentationMap()
	 * @generated
	 */
	void unsetRepresentationMap();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getRepresentationMap <em>Representation Map</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation Map</em>' reference list is set.
	 * @see #unsetRepresentationMap()
	 * @see #getRepresentationMap()
	 * @generated
	 */
	boolean isSetRepresentationMap();

	/**
	 * Returns the value of the '<em><b>Layer Assignments</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPresentationLayerAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Assignments</em>' reference list.
	 * @see #isSetLayerAssignments()
	 * @see #unsetLayerAssignments()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_LayerAssignments()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPresentationLayerAssignment> getLayerAssignments();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getLayerAssignments <em>Layer Assignments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLayerAssignments()
	 * @see #getLayerAssignments()
	 * @generated
	 */
	void unsetLayerAssignments();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getLayerAssignments <em>Layer Assignments</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Layer Assignments</em>' reference list is set.
	 * @see #unsetLayerAssignments()
	 * @see #getLayerAssignments()
	 * @generated
	 */
	boolean isSetLayerAssignments();

	/**
	 * Returns the value of the '<em><b>Of Product Representation</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcProductRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcProductRepresentation#getRepresentations <em>Representations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Product Representation</em>' reference list.
	 * @see #isSetOfProductRepresentation()
	 * @see #unsetOfProductRepresentation()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRepresentation_OfProductRepresentation()
	 * @see org.bimserver.models.ifc4x3.IfcProductRepresentation#getRepresentations
	 * @model opposite="Representations" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProductRepresentation> getOfProductRepresentation();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getOfProductRepresentation <em>Of Product Representation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOfProductRepresentation()
	 * @see #getOfProductRepresentation()
	 * @generated
	 */
	void unsetOfProductRepresentation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcRepresentation#getOfProductRepresentation <em>Of Product Representation</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Of Product Representation</em>' reference list is set.
	 * @see #unsetOfProductRepresentation()
	 * @see #getOfProductRepresentation()
	 * @generated
	 */
	boolean isSetOfProductRepresentation();

} // IfcRepresentation
