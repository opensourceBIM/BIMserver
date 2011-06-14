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
 * A representation of the model object '<em><b>Ifc Classification Item Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatingItem <em>Relating Item</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatedItems <em>Related Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItemRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcClassificationItemRelationship extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Relating Item</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifyingItemIn <em>Is Classifying Item In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Item</em>' reference.
	 * @see #setRelatingItem(IfcClassificationItem)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItemRelationship_RelatingItem()
	 * @see org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifyingItemIn
	 * @model opposite="IsClassifyingItemIn"
	 * @generated
	 */
	IfcClassificationItem getRelatingItem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcClassificationItemRelationship#getRelatingItem <em>Relating Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Item</em>' reference.
	 * @see #getRelatingItem()
	 * @generated
	 */
	void setRelatingItem(IfcClassificationItem value);

	/**
	 * Returns the value of the '<em><b>Related Items</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcClassificationItem}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifiedItemIn <em>Is Classified Item In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Items</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcClassificationItemRelationship_RelatedItems()
	 * @see org.bimserver.models.ifc2x3.IfcClassificationItem#getIsClassifiedItemIn
	 * @model opposite="IsClassifiedItemIn"
	 * @generated
	 */
	EList<IfcClassificationItem> getRelatedItems();

} // IfcClassificationItemRelationship
