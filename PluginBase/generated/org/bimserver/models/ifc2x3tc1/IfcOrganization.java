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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Organization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getIsRelatedBy <em>Is Related By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRelates <em>Relates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getEngages <em>Engages</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization()
 * @model
 * @generated
 */
public interface IfcOrganization extends IfcActorSelect, IfcObjectReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Id()
	 * @model unsettable="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(String)
	 * @generated
	 */
	boolean isSetId();

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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getName <em>Name</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcActorRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see #isSetRoles()
	 * @see #unsetRoles()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Roles()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcActorRole> getRoles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRoles <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	void unsetRoles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRoles <em>Roles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Roles</em>' reference list is set.
	 * @see #unsetRoles()
	 * @see #getRoles()
	 * @generated
	 */
	boolean isSetRoles();

	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcAddress}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcAddress#getOfOrganization <em>Of Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addresses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addresses</em>' reference list.
	 * @see #isSetAddresses()
	 * @see #unsetAddresses()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Addresses()
	 * @see org.bimserver.models.ifc2x3tc1.IfcAddress#getOfOrganization
	 * @model opposite="OfOrganization" unsettable="true"
	 * @generated
	 */
	EList<IfcAddress> getAddresses();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getAddresses <em>Addresses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAddresses()
	 * @see #getAddresses()
	 * @generated
	 */
	void unsetAddresses();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getAddresses <em>Addresses</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Addresses</em>' reference list is set.
	 * @see #unsetAddresses()
	 * @see #getAddresses()
	 * @generated
	 */
	boolean isSetAddresses();

	/**
	 * Returns the value of the '<em><b>Is Related By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship#getRelatedOrganizations <em>Related Organizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Related By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Related By</em>' reference list.
	 * @see #isSetIsRelatedBy()
	 * @see #unsetIsRelatedBy()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_IsRelatedBy()
	 * @see org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship#getRelatedOrganizations
	 * @model opposite="RelatedOrganizations" unsettable="true"
	 * @generated
	 */
	EList<IfcOrganizationRelationship> getIsRelatedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getIsRelatedBy <em>Is Related By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRelatedBy()
	 * @see #getIsRelatedBy()
	 * @generated
	 */
	void unsetIsRelatedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getIsRelatedBy <em>Is Related By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Related By</em>' reference list is set.
	 * @see #unsetIsRelatedBy()
	 * @see #getIsRelatedBy()
	 * @generated
	 */
	boolean isSetIsRelatedBy();

	/**
	 * Returns the value of the '<em><b>Relates</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates</em>' reference list.
	 * @see #isSetRelates()
	 * @see #unsetRelates()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Relates()
	 * @see org.bimserver.models.ifc2x3tc1.IfcOrganizationRelationship#getRelatingOrganization
	 * @model opposite="RelatingOrganization" unsettable="true"
	 * @generated
	 */
	EList<IfcOrganizationRelationship> getRelates();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRelates <em>Relates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	void unsetRelates();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getRelates <em>Relates</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relates</em>' reference list is set.
	 * @see #unsetRelates()
	 * @see #getRelates()
	 * @generated
	 */
	boolean isSetRelates();

	/**
	 * Returns the value of the '<em><b>Engages</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization#getTheOrganization <em>The Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engages</em>' reference list.
	 * @see #isSetEngages()
	 * @see #unsetEngages()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcOrganization_Engages()
	 * @see org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization#getTheOrganization
	 * @model opposite="TheOrganization" unsettable="true"
	 * @generated
	 */
	EList<IfcPersonAndOrganization> getEngages();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getEngages <em>Engages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEngages()
	 * @see #getEngages()
	 * @generated
	 */
	void unsetEngages();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcOrganization#getEngages <em>Engages</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Engages</em>' reference list is set.
	 * @see #unsetEngages()
	 * @see #getEngages()
	 * @generated
	 */
	boolean isSetEngages();

} // IfcOrganization
