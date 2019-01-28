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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Approval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalDateTime <em>Approval Date Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalStatus <em>Approval Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalLevel <em>Approval Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalQualifier <em>Approval Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getActors <em>Actors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getRelates <em>Relates</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcApproval extends IdEObject {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Approval Date Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approval Date Time</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approval Date Time</em>' reference.
	 * @see #setApprovalDateTime(IfcDateTimeSelect)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_ApprovalDateTime()
	 * @model
	 * @generated
	 */
	IfcDateTimeSelect getApprovalDateTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalDateTime <em>Approval Date Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approval Date Time</em>' reference.
	 * @see #getApprovalDateTime()
	 * @generated
	 */
	void setApprovalDateTime(IfcDateTimeSelect value);

	/**
	 * Returns the value of the '<em><b>Approval Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approval Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approval Status</em>' attribute.
	 * @see #isSetApprovalStatus()
	 * @see #unsetApprovalStatus()
	 * @see #setApprovalStatus(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_ApprovalStatus()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApprovalStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalStatus <em>Approval Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approval Status</em>' attribute.
	 * @see #isSetApprovalStatus()
	 * @see #unsetApprovalStatus()
	 * @see #getApprovalStatus()
	 * @generated
	 */
	void setApprovalStatus(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalStatus <em>Approval Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovalStatus()
	 * @see #getApprovalStatus()
	 * @see #setApprovalStatus(String)
	 * @generated
	 */
	void unsetApprovalStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalStatus <em>Approval Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approval Status</em>' attribute is set.
	 * @see #unsetApprovalStatus()
	 * @see #getApprovalStatus()
	 * @see #setApprovalStatus(String)
	 * @generated
	 */
	boolean isSetApprovalStatus();

	/**
	 * Returns the value of the '<em><b>Approval Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approval Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approval Level</em>' attribute.
	 * @see #isSetApprovalLevel()
	 * @see #unsetApprovalLevel()
	 * @see #setApprovalLevel(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_ApprovalLevel()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApprovalLevel();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalLevel <em>Approval Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approval Level</em>' attribute.
	 * @see #isSetApprovalLevel()
	 * @see #unsetApprovalLevel()
	 * @see #getApprovalLevel()
	 * @generated
	 */
	void setApprovalLevel(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalLevel <em>Approval Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovalLevel()
	 * @see #getApprovalLevel()
	 * @see #setApprovalLevel(String)
	 * @generated
	 */
	void unsetApprovalLevel();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalLevel <em>Approval Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approval Level</em>' attribute is set.
	 * @see #unsetApprovalLevel()
	 * @see #getApprovalLevel()
	 * @see #setApprovalLevel(String)
	 * @generated
	 */
	boolean isSetApprovalLevel();

	/**
	 * Returns the value of the '<em><b>Approval Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approval Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approval Qualifier</em>' attribute.
	 * @see #isSetApprovalQualifier()
	 * @see #unsetApprovalQualifier()
	 * @see #setApprovalQualifier(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_ApprovalQualifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getApprovalQualifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalQualifier <em>Approval Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Approval Qualifier</em>' attribute.
	 * @see #isSetApprovalQualifier()
	 * @see #unsetApprovalQualifier()
	 * @see #getApprovalQualifier()
	 * @generated
	 */
	void setApprovalQualifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalQualifier <em>Approval Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovalQualifier()
	 * @see #getApprovalQualifier()
	 * @see #setApprovalQualifier(String)
	 * @generated
	 */
	void unsetApprovalQualifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getApprovalQualifier <em>Approval Qualifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approval Qualifier</em>' attribute is set.
	 * @see #unsetApprovalQualifier()
	 * @see #getApprovalQualifier()
	 * @see #setApprovalQualifier(String)
	 * @generated
	 */
	boolean isSetApprovalQualifier();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcApprovalActorRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcApprovalActorRelationship#getApproval <em>Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see #isSetActors()
	 * @see #unsetActors()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_Actors()
	 * @see org.bimserver.models.ifc2x3tc1.IfcApprovalActorRelationship#getApproval
	 * @model opposite="Approval" unsettable="true"
	 * @generated
	 */
	EList<IfcApprovalActorRelationship> getActors();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getActors <em>Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActors()
	 * @see #getActors()
	 * @generated
	 */
	void unsetActors();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getActors <em>Actors</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Actors</em>' reference list is set.
	 * @see #unsetActors()
	 * @see #getActors()
	 * @generated
	 */
	boolean isSetActors();

	/**
	 * Returns the value of the '<em><b>Is Related With</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship#getRelatedApproval <em>Related Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related With</em>' reference list.
	 * @see #isSetIsRelatedWith()
	 * @see #unsetIsRelatedWith()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_IsRelatedWith()
	 * @see org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship#getRelatedApproval
	 * @model opposite="RelatedApproval" unsettable="true"
	 * @generated
	 */
	EList<IfcApprovalRelationship> getIsRelatedWith();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getIsRelatedWith <em>Is Related With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	void unsetIsRelatedWith();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getIsRelatedWith <em>Is Related With</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related With</em>' reference list is set.
	 * @see #unsetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	boolean isSetIsRelatedWith();

	/**
	 * Returns the value of the '<em><b>Relates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates</em>' reference list.
	 * @see #isSetRelates()
	 * @see #unsetRelates()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcApproval_Relates()
	 * @see org.bimserver.models.ifc2x3tc1.IfcApprovalRelationship#getRelatingApproval
	 * @model opposite="RelatingApproval" unsettable="true"
	 * @generated
	 */
	EList<IfcApprovalRelationship> getRelates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getRelates <em>Relates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	void unsetRelates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcApproval#getRelates <em>Relates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relates</em>' reference list is set.
	 * @see #unsetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	boolean isSetRelates();

} // IfcApproval
