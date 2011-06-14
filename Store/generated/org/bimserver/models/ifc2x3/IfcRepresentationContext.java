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
 * A representation of the model object '<em><b>Ifc Representation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getRepresentationsInContext <em>Representations In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationContext()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcRepresentationContext extends IdEObject
{
	/**
	 * Returns the value of the '<em><b>Context Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Identifier</em>' attribute.
	 * @see #isSetContextIdentifier()
	 * @see #unsetContextIdentifier()
	 * @see #setContextIdentifier(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationContext_ContextIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getContextIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Identifier</em>' attribute.
	 * @see #isSetContextIdentifier()
	 * @see #unsetContextIdentifier()
	 * @see #getContextIdentifier()
	 * @generated
	 */
	void setContextIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContextIdentifier()
	 * @see #getContextIdentifier()
	 * @see #setContextIdentifier(String)
	 * @generated
	 */
	void unsetContextIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Context Identifier</em>' attribute is set.
	 * @see #unsetContextIdentifier()
	 * @see #getContextIdentifier()
	 * @see #setContextIdentifier(String)
	 * @generated
	 */
	boolean isSetContextIdentifier();

	/**
	 * Returns the value of the '<em><b>Context Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Type</em>' attribute.
	 * @see #isSetContextType()
	 * @see #unsetContextType()
	 * @see #setContextType(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationContext_ContextType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getContextType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Type</em>' attribute.
	 * @see #isSetContextType()
	 * @see #unsetContextType()
	 * @see #getContextType()
	 * @generated
	 */
	void setContextType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContextType()
	 * @see #getContextType()
	 * @see #setContextType(String)
	 * @generated
	 */
	void unsetContextType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Context Type</em>' attribute is set.
	 * @see #unsetContextType()
	 * @see #getContextType()
	 * @see #setContextType(String)
	 * @generated
	 */
	boolean isSetContextType();

	/**
	 * Returns the value of the '<em><b>Representations In Context</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRepresentation#getContextOfItems <em>Context Of Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representations In Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representations In Context</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRepresentationContext_RepresentationsInContext()
	 * @see org.bimserver.models.ifc2x3.IfcRepresentation#getContextOfItems
	 * @model opposite="ContextOfItems"
	 * @generated
	 */
	EList<IfcRepresentation> getRepresentationsInContext();

} // IfcRepresentationContext
