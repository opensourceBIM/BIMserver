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
 * A representation of the model object '<em><b>Ifc Approval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getTimeOfApproval <em>Time Of Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getLevel <em>Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getRequestingApproval <em>Requesting Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getGivingApproval <em>Giving Approval</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getHasExternalReferences <em>Has External References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getApprovedObjects <em>Approved Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getApprovedResources <em>Approved Resources</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcApproval#getRelates <em>Relates</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval()
 * @model
 * @generated
 */
public interface IfcApproval extends IfcResourceObjectSelect {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #isSetIdentifier()
	 * @see #unsetIdentifier()
	 * @see #setIdentifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Identifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #isSetIdentifier()
	 * @see #unsetIdentifier()
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIdentifier()
	 * @see #getIdentifier()
	 * @see #setIdentifier(String)
	 * @generated
	 */
	void unsetIdentifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getIdentifier <em>Identifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Identifier</em>' attribute is set.
	 * @see #unsetIdentifier()
	 * @see #getIdentifier()
	 * @see #setIdentifier(String)
	 * @generated
	 */
	boolean isSetIdentifier();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Name()
	 * @model unsettable="true"
	 *        annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Time Of Approval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Of Approval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Of Approval</em>' attribute.
	 * @see #isSetTimeOfApproval()
	 * @see #unsetTimeOfApproval()
	 * @see #setTimeOfApproval(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_TimeOfApproval()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTimeOfApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getTimeOfApproval <em>Time Of Approval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Of Approval</em>' attribute.
	 * @see #isSetTimeOfApproval()
	 * @see #unsetTimeOfApproval()
	 * @see #getTimeOfApproval()
	 * @generated
	 */
	void setTimeOfApproval(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getTimeOfApproval <em>Time Of Approval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeOfApproval()
	 * @see #getTimeOfApproval()
	 * @see #setTimeOfApproval(String)
	 * @generated
	 */
	void unsetTimeOfApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getTimeOfApproval <em>Time Of Approval</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Of Approval</em>' attribute is set.
	 * @see #unsetTimeOfApproval()
	 * @see #getTimeOfApproval()
	 * @see #setTimeOfApproval(String)
	 * @generated
	 */
	boolean isSetTimeOfApproval();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #setStatus(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Status()
	 * @model unsettable="true"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getStatus <em>Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status</em>' attribute is set.
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @see #setStatus(String)
	 * @generated
	 */
	boolean isSetStatus();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Level()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLevel();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(String)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(String)
	 * @generated
	 */
	boolean isSetLevel();

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #isSetQualifier()
	 * @see #unsetQualifier()
	 * @see #setQualifier(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Qualifier()
	 * @model unsettable="true"
	 * @generated
	 */
	String getQualifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #isSetQualifier()
	 * @see #unsetQualifier()
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQualifier()
	 * @see #getQualifier()
	 * @see #setQualifier(String)
	 * @generated
	 */
	void unsetQualifier();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getQualifier <em>Qualifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Qualifier</em>' attribute is set.
	 * @see #unsetQualifier()
	 * @see #getQualifier()
	 * @see #setQualifier(String)
	 * @generated
	 */
	boolean isSetQualifier();

	/**
	 * Returns the value of the '<em><b>Requesting Approval</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requesting Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requesting Approval</em>' reference.
	 * @see #isSetRequestingApproval()
	 * @see #unsetRequestingApproval()
	 * @see #setRequestingApproval(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_RequestingApproval()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getRequestingApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getRequestingApproval <em>Requesting Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requesting Approval</em>' reference.
	 * @see #isSetRequestingApproval()
	 * @see #unsetRequestingApproval()
	 * @see #getRequestingApproval()
	 * @generated
	 */
	void setRequestingApproval(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getRequestingApproval <em>Requesting Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequestingApproval()
	 * @see #getRequestingApproval()
	 * @see #setRequestingApproval(IfcActorSelect)
	 * @generated
	 */
	void unsetRequestingApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getRequestingApproval <em>Requesting Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Requesting Approval</em>' reference is set.
	 * @see #unsetRequestingApproval()
	 * @see #getRequestingApproval()
	 * @see #setRequestingApproval(IfcActorSelect)
	 * @generated
	 */
	boolean isSetRequestingApproval();

	/**
	 * Returns the value of the '<em><b>Giving Approval</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Giving Approval</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Giving Approval</em>' reference.
	 * @see #isSetGivingApproval()
	 * @see #unsetGivingApproval()
	 * @see #setGivingApproval(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_GivingApproval()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getGivingApproval();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getGivingApproval <em>Giving Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Giving Approval</em>' reference.
	 * @see #isSetGivingApproval()
	 * @see #unsetGivingApproval()
	 * @see #getGivingApproval()
	 * @generated
	 */
	void setGivingApproval(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getGivingApproval <em>Giving Approval</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGivingApproval()
	 * @see #getGivingApproval()
	 * @see #setGivingApproval(IfcActorSelect)
	 * @generated
	 */
	void unsetGivingApproval();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getGivingApproval <em>Giving Approval</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Giving Approval</em>' reference is set.
	 * @see #unsetGivingApproval()
	 * @see #getGivingApproval()
	 * @see #setGivingApproval(IfcActorSelect)
	 * @generated
	 */
	boolean isSetGivingApproval();

	/**
	 * Returns the value of the '<em><b>Has External References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External References</em>' reference list.
	 * @see #isSetHasExternalReferences()
	 * @see #unsetHasExternalReferences()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_HasExternalReferences()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getHasExternalReferences <em>Has External References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReferences()
	 * @see #getHasExternalReferences()
	 * @generated
	 */
	void unsetHasExternalReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getHasExternalReferences <em>Has External References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External References</em>' reference list is set.
	 * @see #unsetHasExternalReferences()
	 * @see #getHasExternalReferences()
	 * @generated
	 */
	boolean isSetHasExternalReferences();

	/**
	 * Returns the value of the '<em><b>Approved Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesApproval}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelAssociatesApproval#getRelatingApproval <em>Relating Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approved Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approved Objects</em>' reference list.
	 * @see #isSetApprovedObjects()
	 * @see #unsetApprovedObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_ApprovedObjects()
	 * @see org.bimserver.models.ifc4.IfcRelAssociatesApproval#getRelatingApproval
	 * @model opposite="RelatingApproval" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesApproval> getApprovedObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getApprovedObjects <em>Approved Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovedObjects()
	 * @see #getApprovedObjects()
	 * @generated
	 */
	void unsetApprovedObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getApprovedObjects <em>Approved Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approved Objects</em>' reference list is set.
	 * @see #unsetApprovedObjects()
	 * @see #getApprovedObjects()
	 * @generated
	 */
	boolean isSetApprovedObjects();

	/**
	 * Returns the value of the '<em><b>Approved Resources</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcResourceApprovalRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcResourceApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approved Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approved Resources</em>' reference list.
	 * @see #isSetApprovedResources()
	 * @see #unsetApprovedResources()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_ApprovedResources()
	 * @see org.bimserver.models.ifc4.IfcResourceApprovalRelationship#getRelatingApproval
	 * @model opposite="RelatingApproval" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcResourceApprovalRelationship> getApprovedResources();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getApprovedResources <em>Approved Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetApprovedResources()
	 * @see #getApprovedResources()
	 * @generated
	 */
	void unsetApprovedResources();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getApprovedResources <em>Approved Resources</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Approved Resources</em>' reference list is set.
	 * @see #unsetApprovedResources()
	 * @see #getApprovedResources()
	 * @generated
	 */
	boolean isSetApprovedResources();

	/**
	 * Returns the value of the '<em><b>Is Related With</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcApprovalRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatedApprovals <em>Related Approvals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related With</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related With</em>' reference list.
	 * @see #isSetIsRelatedWith()
	 * @see #unsetIsRelatedWith()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_IsRelatedWith()
	 * @see org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatedApprovals
	 * @model opposite="RelatedApprovals" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcApprovalRelationship> getIsRelatedWith();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getIsRelatedWith <em>Is Related With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedWith()
	 * @see #getIsRelatedWith()
	 * @generated
	 */
	void unsetIsRelatedWith();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getIsRelatedWith <em>Is Related With</em>}' reference list is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcApprovalRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatingApproval <em>Relating Approval</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates</em>' reference list.
	 * @see #isSetRelates()
	 * @see #unsetRelates()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcApproval_Relates()
	 * @see org.bimserver.models.ifc4.IfcApprovalRelationship#getRelatingApproval
	 * @model opposite="RelatingApproval" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcApprovalRelationship> getRelates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getRelates <em>Relates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	void unsetRelates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcApproval#getRelates <em>Relates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relates</em>' reference list is set.
	 * @see #unsetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	boolean isSetRelates();

} // IfcApproval
