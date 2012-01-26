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
 * A representation of the model object '<em><b>Ifc Organization Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatedOrganizations <em>Related Organizations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrganizationRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcOrganizationRelationship extends IdEObject {
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrganizationRelationship_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getName <em>Name</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getName <em>Name</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrganizationRelationship_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Relating Organization</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcOrganization#getRelates <em>Relates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Organization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Organization</em>' reference.
	 * @see #isSetRelatingOrganization()
	 * @see #unsetRelatingOrganization()
	 * @see #setRelatingOrganization(IfcOrganization)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrganizationRelationship_RelatingOrganization()
	 * @see org.bimserver.models.ifc2x3.IfcOrganization#getRelates
	 * @model opposite="Relates" unsettable="true"
	 * @generated
	 */
	IfcOrganization getRelatingOrganization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Organization</em>' reference.
	 * @see #isSetRelatingOrganization()
	 * @see #unsetRelatingOrganization()
	 * @see #getRelatingOrganization()
	 * @generated
	 */
	void setRelatingOrganization(IfcOrganization value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatingOrganization()
	 * @see #getRelatingOrganization()
	 * @see #setRelatingOrganization(IfcOrganization)
	 * @generated
	 */
	void unsetRelatingOrganization();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatingOrganization <em>Relating Organization</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relating Organization</em>' reference is set.
	 * @see #unsetRelatingOrganization()
	 * @see #getRelatingOrganization()
	 * @see #setRelatingOrganization(IfcOrganization)
	 * @generated
	 */
	boolean isSetRelatingOrganization();

	/**
	 * Returns the value of the '<em><b>Related Organizations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcOrganization}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcOrganization#getIsRelatedBy <em>Is Related By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Organizations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Organizations</em>' reference list.
	 * @see #isSetRelatedOrganizations()
	 * @see #unsetRelatedOrganizations()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOrganizationRelationship_RelatedOrganizations()
	 * @see org.bimserver.models.ifc2x3.IfcOrganization#getIsRelatedBy
	 * @model opposite="IsRelatedBy" unsettable="true"
	 * @generated
	 */
	EList<IfcOrganization> getRelatedOrganizations();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatedOrganizations <em>Related Organizations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelatedOrganizations()
	 * @see #getRelatedOrganizations()
	 * @generated
	 */
	void unsetRelatedOrganizations();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcOrganizationRelationship#getRelatedOrganizations <em>Related Organizations</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Related Organizations</em>' reference list is set.
	 * @see #unsetRelatedOrganizations()
	 * @see #getRelatedOrganizations()
	 * @generated
	 */
	boolean isSetRelatedOrganizations();

} // IfcOrganizationRelationship
