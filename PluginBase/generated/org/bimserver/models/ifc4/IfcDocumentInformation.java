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
 * A representation of the model object '<em><b>Ifc Document Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIdentification <em>Identification</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIntendedUse <em>Intended Use</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getScope <em>Scope</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentOwner <em>Document Owner</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLastRevisionTime <em>Last Revision Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getElectronicFormat <em>Electronic Format</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidFrom <em>Valid From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidUntil <em>Valid Until</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getStatus <em>Status</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentInfoForObjects <em>Document Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getHasDocumentReferences <em>Has Document References</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointedTo <em>Is Pointed To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointer <em>Is Pointer</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation()
 * @model
 * @generated
 */
public interface IfcDocumentInformation extends IfcExternalInformation, IfcDocumentSelect {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #setIdentification(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Identification()
	 * @model
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #setLocation(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Location()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	void unsetLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLocation <em>Location</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location</em>' attribute is set.
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	boolean isSetLocation();

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #setPurpose(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Purpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	void unsetPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getPurpose <em>Purpose</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Purpose</em>' attribute is set.
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	boolean isSetPurpose();

	/**
	 * Returns the value of the '<em><b>Intended Use</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intended Use</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intended Use</em>' attribute.
	 * @see #isSetIntendedUse()
	 * @see #unsetIntendedUse()
	 * @see #setIntendedUse(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_IntendedUse()
	 * @model unsettable="true"
	 * @generated
	 */
	String getIntendedUse();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIntendedUse <em>Intended Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intended Use</em>' attribute.
	 * @see #isSetIntendedUse()
	 * @see #unsetIntendedUse()
	 * @see #getIntendedUse()
	 * @generated
	 */
	void setIntendedUse(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIntendedUse <em>Intended Use</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntendedUse()
	 * @see #getIntendedUse()
	 * @see #setIntendedUse(String)
	 * @generated
	 */
	void unsetIntendedUse();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIntendedUse <em>Intended Use</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Intended Use</em>' attribute is set.
	 * @see #unsetIntendedUse()
	 * @see #getIntendedUse()
	 * @see #setIntendedUse(String)
	 * @generated
	 */
	boolean isSetIntendedUse();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see #isSetScope()
	 * @see #unsetScope()
	 * @see #setScope(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Scope()
	 * @model unsettable="true"
	 * @generated
	 */
	String getScope();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see #isSetScope()
	 * @see #unsetScope()
	 * @see #getScope()
	 * @generated
	 */
	void setScope(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScope()
	 * @see #getScope()
	 * @see #setScope(String)
	 * @generated
	 */
	void unsetScope();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getScope <em>Scope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scope</em>' attribute is set.
	 * @see #unsetScope()
	 * @see #getScope()
	 * @see #setScope(String)
	 * @generated
	 */
	boolean isSetScope();

	/**
	 * Returns the value of the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #isSetRevision()
	 * @see #unsetRevision()
	 * @see #setRevision(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Revision()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #isSetRevision()
	 * @see #unsetRevision()
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRevision()
	 * @see #getRevision()
	 * @see #setRevision(String)
	 * @generated
	 */
	void unsetRevision();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getRevision <em>Revision</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Revision</em>' attribute is set.
	 * @see #unsetRevision()
	 * @see #getRevision()
	 * @see #setRevision(String)
	 * @generated
	 */
	boolean isSetRevision();

	/**
	 * Returns the value of the '<em><b>Document Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Owner</em>' reference.
	 * @see #isSetDocumentOwner()
	 * @see #unsetDocumentOwner()
	 * @see #setDocumentOwner(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_DocumentOwner()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getDocumentOwner();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentOwner <em>Document Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document Owner</em>' reference.
	 * @see #isSetDocumentOwner()
	 * @see #unsetDocumentOwner()
	 * @see #getDocumentOwner()
	 * @generated
	 */
	void setDocumentOwner(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentOwner <em>Document Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDocumentOwner()
	 * @see #getDocumentOwner()
	 * @see #setDocumentOwner(IfcActorSelect)
	 * @generated
	 */
	void unsetDocumentOwner();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentOwner <em>Document Owner</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Document Owner</em>' reference is set.
	 * @see #unsetDocumentOwner()
	 * @see #getDocumentOwner()
	 * @see #setDocumentOwner(IfcActorSelect)
	 * @generated
	 */
	boolean isSetDocumentOwner();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcActorSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see #isSetEditors()
	 * @see #unsetEditors()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Editors()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcActorSelect> getEditors();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getEditors <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEditors()
	 * @see #getEditors()
	 * @generated
	 */
	void unsetEditors();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getEditors <em>Editors</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Editors</em>' reference list is set.
	 * @see #unsetEditors()
	 * @see #getEditors()
	 * @generated
	 */
	boolean isSetEditors();

	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #setCreationTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_CreationTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCreationTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #isSetCreationTime()
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(String)
	 * @generated
	 */
	void unsetCreationTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getCreationTime <em>Creation Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creation Time</em>' attribute is set.
	 * @see #unsetCreationTime()
	 * @see #getCreationTime()
	 * @see #setCreationTime(String)
	 * @generated
	 */
	boolean isSetCreationTime();

	/**
	 * Returns the value of the '<em><b>Last Revision Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Revision Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Revision Time</em>' attribute.
	 * @see #isSetLastRevisionTime()
	 * @see #unsetLastRevisionTime()
	 * @see #setLastRevisionTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_LastRevisionTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLastRevisionTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLastRevisionTime <em>Last Revision Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Revision Time</em>' attribute.
	 * @see #isSetLastRevisionTime()
	 * @see #unsetLastRevisionTime()
	 * @see #getLastRevisionTime()
	 * @generated
	 */
	void setLastRevisionTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLastRevisionTime <em>Last Revision Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLastRevisionTime()
	 * @see #getLastRevisionTime()
	 * @see #setLastRevisionTime(String)
	 * @generated
	 */
	void unsetLastRevisionTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getLastRevisionTime <em>Last Revision Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Last Revision Time</em>' attribute is set.
	 * @see #unsetLastRevisionTime()
	 * @see #getLastRevisionTime()
	 * @see #setLastRevisionTime(String)
	 * @generated
	 */
	boolean isSetLastRevisionTime();

	/**
	 * Returns the value of the '<em><b>Electronic Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electronic Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electronic Format</em>' attribute.
	 * @see #isSetElectronicFormat()
	 * @see #unsetElectronicFormat()
	 * @see #setElectronicFormat(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_ElectronicFormat()
	 * @model unsettable="true"
	 * @generated
	 */
	String getElectronicFormat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getElectronicFormat <em>Electronic Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Electronic Format</em>' attribute.
	 * @see #isSetElectronicFormat()
	 * @see #unsetElectronicFormat()
	 * @see #getElectronicFormat()
	 * @generated
	 */
	void setElectronicFormat(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getElectronicFormat <em>Electronic Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElectronicFormat()
	 * @see #getElectronicFormat()
	 * @see #setElectronicFormat(String)
	 * @generated
	 */
	void unsetElectronicFormat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getElectronicFormat <em>Electronic Format</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Electronic Format</em>' attribute is set.
	 * @see #unsetElectronicFormat()
	 * @see #getElectronicFormat()
	 * @see #setElectronicFormat(String)
	 * @generated
	 */
	boolean isSetElectronicFormat();

	/**
	 * Returns the value of the '<em><b>Valid From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid From</em>' attribute.
	 * @see #isSetValidFrom()
	 * @see #unsetValidFrom()
	 * @see #setValidFrom(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_ValidFrom()
	 * @model unsettable="true"
	 * @generated
	 */
	String getValidFrom();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidFrom <em>Valid From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid From</em>' attribute.
	 * @see #isSetValidFrom()
	 * @see #unsetValidFrom()
	 * @see #getValidFrom()
	 * @generated
	 */
	void setValidFrom(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidFrom <em>Valid From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValidFrom()
	 * @see #getValidFrom()
	 * @see #setValidFrom(String)
	 * @generated
	 */
	void unsetValidFrom();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidFrom <em>Valid From</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Valid From</em>' attribute is set.
	 * @see #unsetValidFrom()
	 * @see #getValidFrom()
	 * @see #setValidFrom(String)
	 * @generated
	 */
	boolean isSetValidFrom();

	/**
	 * Returns the value of the '<em><b>Valid Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Until</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Until</em>' attribute.
	 * @see #isSetValidUntil()
	 * @see #unsetValidUntil()
	 * @see #setValidUntil(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_ValidUntil()
	 * @model unsettable="true"
	 * @generated
	 */
	String getValidUntil();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidUntil <em>Valid Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid Until</em>' attribute.
	 * @see #isSetValidUntil()
	 * @see #unsetValidUntil()
	 * @see #getValidUntil()
	 * @generated
	 */
	void setValidUntil(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidUntil <em>Valid Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetValidUntil()
	 * @see #getValidUntil()
	 * @see #setValidUntil(String)
	 * @generated
	 */
	void unsetValidUntil();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getValidUntil <em>Valid Until</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Valid Until</em>' attribute is set.
	 * @see #unsetValidUntil()
	 * @see #getValidUntil()
	 * @see #setValidUntil(String)
	 * @generated
	 */
	boolean isSetValidUntil();

	/**
	 * Returns the value of the '<em><b>Confidentiality</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDocumentConfidentialityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidentiality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidentiality</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDocumentConfidentialityEnum
	 * @see #isSetConfidentiality()
	 * @see #unsetConfidentiality()
	 * @see #setConfidentiality(IfcDocumentConfidentialityEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Confidentiality()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDocumentConfidentialityEnum getConfidentiality();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getConfidentiality <em>Confidentiality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidentiality</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDocumentConfidentialityEnum
	 * @see #isSetConfidentiality()
	 * @see #unsetConfidentiality()
	 * @see #getConfidentiality()
	 * @generated
	 */
	void setConfidentiality(IfcDocumentConfidentialityEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getConfidentiality <em>Confidentiality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConfidentiality()
	 * @see #getConfidentiality()
	 * @see #setConfidentiality(IfcDocumentConfidentialityEnum)
	 * @generated
	 */
	void unsetConfidentiality();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getConfidentiality <em>Confidentiality</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Confidentiality</em>' attribute is set.
	 * @see #unsetConfidentiality()
	 * @see #getConfidentiality()
	 * @see #setConfidentiality(IfcDocumentConfidentialityEnum)
	 * @generated
	 */
	boolean isSetConfidentiality();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcDocumentStatusEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDocumentStatusEnum
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #setStatus(IfcDocumentStatusEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_Status()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDocumentStatusEnum getStatus();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcDocumentStatusEnum
	 * @see #isSetStatus()
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(IfcDocumentStatusEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStatus()
	 * @see #getStatus()
	 * @see #setStatus(IfcDocumentStatusEnum)
	 * @generated
	 */
	void unsetStatus();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getStatus <em>Status</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Status</em>' attribute is set.
	 * @see #unsetStatus()
	 * @see #getStatus()
	 * @see #setStatus(IfcDocumentStatusEnum)
	 * @generated
	 */
	boolean isSetStatus();

	/**
	 * Returns the value of the '<em><b>Document Info For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesDocument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document Info For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Info For Objects</em>' reference list.
	 * @see #isSetDocumentInfoForObjects()
	 * @see #unsetDocumentInfoForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_DocumentInfoForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesDocument> getDocumentInfoForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentInfoForObjects <em>Document Info For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDocumentInfoForObjects()
	 * @see #getDocumentInfoForObjects()
	 * @generated
	 */
	void unsetDocumentInfoForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getDocumentInfoForObjects <em>Document Info For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Document Info For Objects</em>' reference list is set.
	 * @see #unsetDocumentInfoForObjects()
	 * @see #getDocumentInfoForObjects()
	 * @generated
	 */
	boolean isSetDocumentInfoForObjects();

	/**
	 * Returns the value of the '<em><b>Has Document References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcDocumentReference}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument <em>Referenced Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Document References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Document References</em>' reference list.
	 * @see #isSetHasDocumentReferences()
	 * @see #unsetHasDocumentReferences()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_HasDocumentReferences()
	 * @see org.bimserver.models.ifc4.IfcDocumentReference#getReferencedDocument
	 * @model opposite="ReferencedDocument" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcDocumentReference> getHasDocumentReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getHasDocumentReferences <em>Has Document References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasDocumentReferences()
	 * @see #getHasDocumentReferences()
	 * @generated
	 */
	void unsetHasDocumentReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getHasDocumentReferences <em>Has Document References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Document References</em>' reference list is set.
	 * @see #unsetHasDocumentReferences()
	 * @see #getHasDocumentReferences()
	 * @generated
	 */
	boolean isSetHasDocumentReferences();

	/**
	 * Returns the value of the '<em><b>Is Pointed To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcDocumentInformationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDocumentInformationRelationship#getRelatedDocuments <em>Related Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pointed To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pointed To</em>' reference list.
	 * @see #isSetIsPointedTo()
	 * @see #unsetIsPointedTo()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_IsPointedTo()
	 * @see org.bimserver.models.ifc4.IfcDocumentInformationRelationship#getRelatedDocuments
	 * @model opposite="RelatedDocuments" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcDocumentInformationRelationship> getIsPointedTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointedTo <em>Is Pointed To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsPointedTo()
	 * @see #getIsPointedTo()
	 * @generated
	 */
	void unsetIsPointedTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointedTo <em>Is Pointed To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Pointed To</em>' reference list is set.
	 * @see #unsetIsPointedTo()
	 * @see #getIsPointedTo()
	 * @generated
	 */
	boolean isSetIsPointedTo();

	/**
	 * Returns the value of the '<em><b>Is Pointer</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcDocumentInformationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcDocumentInformationRelationship#getRelatingDocument <em>Relating Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pointer</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pointer</em>' reference list.
	 * @see #isSetIsPointer()
	 * @see #unsetIsPointer()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcDocumentInformation_IsPointer()
	 * @see org.bimserver.models.ifc4.IfcDocumentInformationRelationship#getRelatingDocument
	 * @model opposite="RelatingDocument" unsettable="true" upper="2"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcDocumentInformationRelationship> getIsPointer();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointer <em>Is Pointer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsPointer()
	 * @see #getIsPointer()
	 * @generated
	 */
	void unsetIsPointer();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcDocumentInformation#getIsPointer <em>Is Pointer</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Pointer</em>' reference list is set.
	 * @see #unsetIsPointer()
	 * @see #getIsPointer()
	 * @generated
	 */
	boolean isSetIsPointer();

} // IfcDocumentInformation
