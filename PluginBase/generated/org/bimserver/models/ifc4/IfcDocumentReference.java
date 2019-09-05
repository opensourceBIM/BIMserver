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
 * A representation of the model object '<em><b>Ifc Document Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentReference#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument <em>Referenced Document</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentReference#getDocumentRefForObjects <em>Document Ref For Objects</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentReference()
 * @model
 * @generated
 */
public interface IfcDocumentReference extends IfcExternalReference, IfcDocumentSelect {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentReference_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Referenced Document</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getHasDocumentReferences <em>Has Document References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Document</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Document</em>' reference.
	 * @see #isSetReferencedDocument()
	 * @see #unsetReferencedDocument()
	 * @see #setReferencedDocument(IfcDocumentInformation)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentReference_ReferencedDocument()
	 * @see org.bimserver.models.ifc4.IfcDocumentInformation#getHasDocumentReferences
	 * @model opposite="HasDocumentReferences" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcDocumentInformation getReferencedDocument();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument <em>Referenced Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Document</em>' reference.
	 * @see #isSetReferencedDocument()
	 * @see #unsetReferencedDocument()
	 * @see #getReferencedDocument()
	 * @generated
	 */
	void setReferencedDocument(IfcDocumentInformation value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument <em>Referenced Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedDocument()
	 * @see #getReferencedDocument()
	 * @see #setReferencedDocument(IfcDocumentInformation)
	 * @generated
	 */
	void unsetReferencedDocument();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument <em>Referenced Document</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Document</em>' reference is set.
	 * @see #unsetReferencedDocument()
	 * @see #getReferencedDocument()
	 * @see #setReferencedDocument(IfcDocumentInformation)
	 * @generated
	 */
	boolean isSetReferencedDocument();

	/**
	 * Returns the value of the '<em><b>Document Ref For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesDocument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Ref For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Ref For Objects</em>' reference list.
	 * @see #isSetDocumentRefForObjects()
	 * @see #unsetDocumentRefForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentReference_DocumentRefForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesDocument> getDocumentRefForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getDocumentRefForObjects <em>Document Ref For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDocumentRefForObjects()
	 * @see #getDocumentRefForObjects()
	 * @generated
	 */
	void unsetDocumentRefForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentReference#getDocumentRefForObjects <em>Document Ref For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Document Ref For Objects</em>' reference list is set.
	 * @see #unsetDocumentRefForObjects()
	 * @see #getDocumentRefForObjects()
	 * @generated
	 */
	boolean isSetDocumentRefForObjects();

} // IfcDocumentReference
