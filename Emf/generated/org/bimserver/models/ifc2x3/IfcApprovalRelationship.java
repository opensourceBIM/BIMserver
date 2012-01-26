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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Approval Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatedApproval <em>Related Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcApprovalRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Related Approval</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcApproval#getIsRelatedWith <em>Is Related With</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Approval</em>' reference.
	 * @see #isSetRelatedApproval()
	 * @see #unsetRelatedApproval()
	 * @see #setRelatedApproval(IfcApproval)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalRelationship_RelatedApproval()
	 * @see org.bimserver.models.ifc2x3.IfcApproval#getIsRelatedWith
	 * @model opposite="IsRelatedWith" unsettable="true"
	 * @generated
	 */
	IfcApproval getRelatedApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatedApproval <em>Related Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Approval</em>' reference.
	 * @see #isSetRelatedApproval()
	 * @see #unsetRelatedApproval()
	 * @see #getRelatedApproval()
	 * @generated
	 */
	void setRelatedApproval(IfcApproval value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatedApproval <em>Related Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedApproval()
	 * @see #getRelatedApproval()
	 * @see #setRelatedApproval(IfcApproval)
	 * @generated
	 */
	void unsetRelatedApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatedApproval <em>Related Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Approval</em>' reference is set.
	 * @see #unsetRelatedApproval()
	 * @see #getRelatedApproval()
	 * @see #setRelatedApproval(IfcApproval)
	 * @generated
	 */
	boolean isSetRelatedApproval();

	/**
	 * Returns the value of the '<em><b>Relating Approval</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcApproval#getRelates <em>Relates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Approval</em>' reference.
	 * @see #isSetRelatingApproval()
	 * @see #unsetRelatingApproval()
	 * @see #setRelatingApproval(IfcApproval)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalRelationship_RelatingApproval()
	 * @see org.bimserver.models.ifc2x3.IfcApproval#getRelates
	 * @model opposite="Relates" unsettable="true"
	 * @generated
	 */
	IfcApproval getRelatingApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Approval</em>' reference.
	 * @see #isSetRelatingApproval()
	 * @see #unsetRelatingApproval()
	 * @see #getRelatingApproval()
	 * @generated
	 */
	void setRelatingApproval(IfcApproval value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingApproval()
	 * @see #getRelatingApproval()
	 * @see #setRelatingApproval(IfcApproval)
	 * @generated
	 */
	void unsetRelatingApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Approval</em>' reference is set.
	 * @see #unsetRelatingApproval()
	 * @see #getRelatingApproval()
	 * @see #setRelatingApproval(IfcApproval)
	 * @generated
	 */
	boolean isSetRelatingApproval();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalRelationship_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcApprovalRelationship_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcApprovalRelationship#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

} // IfcApprovalRelationship
