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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAddress#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAddress#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAddress#getUserDefinedPurpose <em>User Defined Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAddress#getOfPerson <em>Of Person</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAddress#getOfOrganization <em>Of Organization</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress()
 * @model
 * @generated
 */
public interface IfcAddress extends IfcObjectReferenceSelect
{
	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcAddressTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAddressTypeEnum
	 * @see #setPurpose(IfcAddressTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress_Purpose()
	 * @model
	 * @generated
	 */
	IfcAddressTypeEnum getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAddressTypeEnum
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(IfcAddressTypeEnum value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>User Defined Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Defined Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Defined Purpose</em>' attribute.
	 * @see #isSetUserDefinedPurpose()
	 * @see #unsetUserDefinedPurpose()
	 * @see #setUserDefinedPurpose(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress_UserDefinedPurpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getUserDefinedPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getUserDefinedPurpose <em>User Defined Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Defined Purpose</em>' attribute.
	 * @see #isSetUserDefinedPurpose()
	 * @see #unsetUserDefinedPurpose()
	 * @see #getUserDefinedPurpose()
	 * @generated
	 */
	void setUserDefinedPurpose(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getUserDefinedPurpose <em>User Defined Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserDefinedPurpose()
	 * @see #getUserDefinedPurpose()
	 * @see #setUserDefinedPurpose(String)
	 * @generated
	 */
	void unsetUserDefinedPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcAddress#getUserDefinedPurpose <em>User Defined Purpose</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Defined Purpose</em>' attribute is set.
	 * @see #unsetUserDefinedPurpose()
	 * @see #getUserDefinedPurpose()
	 * @see #setUserDefinedPurpose(String)
	 * @generated
	 */
	boolean isSetUserDefinedPurpose();

	/**
	 * Returns the value of the '<em><b>Of Person</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcPerson}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcPerson#getAddresses <em>Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Person</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Person</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress_OfPerson()
	 * @see org.bimserver.models.ifc2x3.IfcPerson#getAddresses
	 * @model opposite="Addresses"
	 * @generated
	 */
	EList<IfcPerson> getOfPerson();

	/**
	 * Returns the value of the '<em><b>Of Organization</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcOrganization}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcOrganization#getAddresses <em>Addresses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Organization</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Organization</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAddress_OfOrganization()
	 * @see org.bimserver.models.ifc2x3.IfcOrganization#getAddresses
	 * @model opposite="Addresses"
	 * @generated
	 */
	EList<IfcOrganization> getOfOrganization();

} // IfcAddress
