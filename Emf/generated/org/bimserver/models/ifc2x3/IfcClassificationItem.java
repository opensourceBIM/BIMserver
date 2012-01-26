/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Classification Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getNotation <em>Notation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf <em>Item Of</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getTitle <em>Title</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifiedItemIn <em>Is Classified Item In</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifyingItemIn <em>Is Classifying Item In</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcClassificationItem extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Notation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notation</em>' reference.
	 * @see #isSetNotation()
	 * @see #unsetNotation()
	 * @see #setNotation(IfcClassificationNotationFacet)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem_Notation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcClassificationNotationFacet getNotation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getNotation <em>Notation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notation</em>' reference.
	 * @see #isSetNotation()
	 * @see #unsetNotation()
	 * @see #getNotation()
	 * @generated
	 */
	void setNotation(IfcClassificationNotationFacet value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getNotation <em>Notation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNotation()
	 * @see #getNotation()
	 * @see #setNotation(IfcClassificationNotationFacet)
	 * @generated
	 */
	void unsetNotation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getNotation <em>Notation</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Notation</em>' reference is set.
	 * @see #unsetNotation()
	 * @see #getNotation()
	 * @see #setNotation(IfcClassificationNotationFacet)
	 * @generated
	 */
	boolean isSetNotation();

	/**
	 * Returns the value of the '<em><b>Item Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassification#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Of</em>' reference.
	 * @see #isSetItemOf()
	 * @see #unsetItemOf()
	 * @see #setItemOf(IfcClassification)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem_ItemOf()
	 * @see org.bimserver.models.ifc2x3.IfcClassification#getContains
	 * @model opposite="Contains" unsettable="true"
	 * @generated
	 */
	IfcClassification getItemOf();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf <em>Item Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Of</em>' reference.
	 * @see #isSetItemOf()
	 * @see #unsetItemOf()
	 * @see #getItemOf()
	 * @generated
	 */
	void setItemOf(IfcClassification value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf <em>Item Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetItemOf()
	 * @see #getItemOf()
	 * @see #setItemOf(IfcClassification)
	 * @generated
	 */
	void unsetItemOf();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getItemOf <em>Item Of</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Item Of</em>' reference is set.
	 * @see #unsetItemOf()
	 * @see #getItemOf()
	 * @see #setItemOf(IfcClassification)
	 * @generated
	 */
	boolean isSetItemOf();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #isSetTitle()
	 * @see #unsetTitle()
	 * @see #setTitle(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem_Title()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #isSetTitle()
	 * @see #unsetTitle()
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTitle()
	 * @see #getTitle()
	 * @see #setTitle(String)
	 * @generated
	 */
	void unsetTitle();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getTitle <em>Title</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Title</em>' attribute is set.
	 * @see #unsetTitle()
	 * @see #getTitle()
	 * @see #setTitle(String)
	 * @generated
	 */
	boolean isSetTitle();

	/**
	 * Returns the value of the '<em><b>Is Classified Item In</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatedItems <em>Related Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Classified Item In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Classified Item In</em>' reference list.
	 * @see #isSetIsClassifiedItemIn()
	 * @see #unsetIsClassifiedItemIn()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem_IsClassifiedItemIn()
	 * @see org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatedItems
	 * @model opposite="RelatedItems" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcClassificationItemRelationship> getIsClassifiedItemIn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifiedItemIn <em>Is Classified Item In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsClassifiedItemIn()
	 * @see #getIsClassifiedItemIn()
	 * @generated
	 */
	void unsetIsClassifiedItemIn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifiedItemIn <em>Is Classified Item In</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Classified Item In</em>' reference list is set.
	 * @see #unsetIsClassifiedItemIn()
	 * @see #getIsClassifiedItemIn()
	 * @generated
	 */
	boolean isSetIsClassifiedItemIn();

	/**
	 * Returns the value of the '<em><b>Is Classifying Item In</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatingItem <em>Relating Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Classifying Item In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Classifying Item In</em>' reference list.
	 * @see #isSetIsClassifyingItemIn()
	 * @see #unsetIsClassifyingItemIn()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItem_IsClassifyingItemIn()
	 * @see org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatingItem
	 * @model opposite="RelatingItem" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcClassificationItemRelationship> getIsClassifyingItemIn();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifyingItemIn <em>Is Classifying Item In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsClassifyingItemIn()
	 * @see #getIsClassifyingItemIn()
	 * @generated
	 */
	void unsetIsClassifyingItemIn();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifyingItemIn <em>Is Classifying Item In</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Classifying Item In</em>' reference list is set.
	 * @see #unsetIsClassifyingItemIn()
	 * @see #getIsClassifyingItemIn()
	 * @generated
	 */
	boolean isSetIsClassifyingItemIn();

} // IfcClassificationItem
