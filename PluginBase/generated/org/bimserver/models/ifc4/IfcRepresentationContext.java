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
 * A representation of the model object '<em><b>Ifc Representation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcRepresentationContext#getRepresentationsInContext <em>Representations In Context</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationContext()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcRepresentationContext extends IdEObject {
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationContext_ContextIdentifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getContextIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContextIdentifier()
	 * @see #getContextIdentifier()
	 * @see #setContextIdentifier(String)
	 * @generated
	 */
	void unsetContextIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextIdentifier <em>Context Identifier</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationContext_ContextType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getContextType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetContextType()
	 * @see #getContextType()
	 * @see #setContextType(String)
	 * @generated
	 */
	void unsetContextType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getContextType <em>Context Type</em>}' attribute is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRepresentation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRepresentation#getContextOfItems <em>Context Of Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representations In Context</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representations In Context</em>' reference list.
	 * @see #isSetRepresentationsInContext()
	 * @see #unsetRepresentationsInContext()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcRepresentationContext_RepresentationsInContext()
	 * @see org.bimserver.models.ifc4.IfcRepresentation#getContextOfItems
	 * @model opposite="ContextOfItems" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRepresentation> getRepresentationsInContext();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getRepresentationsInContext <em>Representations In Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationsInContext()
	 * @see #getRepresentationsInContext()
	 * @generated
	 */
	void unsetRepresentationsInContext();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcRepresentationContext#getRepresentationsInContext <em>Representations In Context</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representations In Context</em>' reference list is set.
	 * @see #unsetRepresentationsInContext()
	 * @see #getRepresentationsInContext()
	 * @generated
	 */
	boolean isSetRepresentationsInContext();

} // IfcRepresentationContext
