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
 * A representation of the model object '<em><b>Ifc Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileType <em>Profile Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProfileDef#getHasExternalReference <em>Has External Reference</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProfileDef#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProfileDef()
 * @model
 * @generated
 */
public interface IfcProfileDef extends IfcResourceObjectSelect {
	/**
	 * Returns the value of the '<em><b>Profile Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcProfileTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcProfileTypeEnum
	 * @see #setProfileType(IfcProfileTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProfileDef_ProfileType()
	 * @model
	 * @generated
	 */
	IfcProfileTypeEnum getProfileType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileType <em>Profile Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcProfileTypeEnum
	 * @see #getProfileType()
	 * @generated
	 */
	void setProfileType(IfcProfileTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Name</em>' attribute.
	 * @see #isSetProfileName()
	 * @see #unsetProfileName()
	 * @see #setProfileName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProfileDef_ProfileName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getProfileName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileName <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Name</em>' attribute.
	 * @see #isSetProfileName()
	 * @see #unsetProfileName()
	 * @see #getProfileName()
	 * @generated
	 */
	void setProfileName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileName <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProfileName()
	 * @see #getProfileName()
	 * @see #setProfileName(String)
	 * @generated
	 */
	void unsetProfileName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getProfileName <em>Profile Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Profile Name</em>' attribute is set.
	 * @see #unsetProfileName()
	 * @see #getProfileName()
	 * @see #setProfileName(String)
	 * @generated
	 */
	boolean isSetProfileName();

	/**
	 * Returns the value of the '<em><b>Has External Reference</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcExternalReferenceRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has External Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has External Reference</em>' reference list.
	 * @see #isSetHasExternalReference()
	 * @see #unsetHasExternalReference()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProfileDef_HasExternalReference()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcExternalReferenceRelationship> getHasExternalReference();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getHasExternalReference <em>Has External Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	void unsetHasExternalReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getHasExternalReference <em>Has External Reference</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has External Reference</em>' reference list is set.
	 * @see #unsetHasExternalReference()
	 * @see #getHasExternalReference()
	 * @generated
	 */
	boolean isSetHasExternalReference();

	/**
	 * Returns the value of the '<em><b>Has Properties</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcProfileProperties}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcProfileProperties#getProfileDefinition <em>Profile Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Properties</em>' reference list.
	 * @see #isSetHasProperties()
	 * @see #unsetHasProperties()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProfileDef_HasProperties()
	 * @see org.bimserver.models.ifc4.IfcProfileProperties#getProfileDefinition
	 * @model opposite="ProfileDefinition" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProfileProperties> getHasProperties();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getHasProperties <em>Has Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasProperties()
	 * @see #getHasProperties()
	 * @generated
	 */
	void unsetHasProperties();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProfileDef#getHasProperties <em>Has Properties</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Properties</em>' reference list is set.
	 * @see #unsetHasProperties()
	 * @see #getHasProperties()
	 * @generated
	 */
	boolean isSetHasProperties();

} // IfcProfileDef
