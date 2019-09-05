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
 * A representation of the model object '<em><b>Ifc Telecom Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTelecomAddress#getMessagingIDs <em>Messaging IDs</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress()
 * @model
 * @generated
 */
public interface IfcTelecomAddress extends IfcAddress {
	/**
	 * Returns the value of the '<em><b>Telephone Numbers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telephone Numbers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telephone Numbers</em>' attribute list.
	 * @see #isSetTelephoneNumbers()
	 * @see #unsetTelephoneNumbers()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_TelephoneNumbers()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getTelephoneNumbers();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTelephoneNumbers()
	 * @see #getTelephoneNumbers()
	 * @generated
	 */
	void unsetTelephoneNumbers();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getTelephoneNumbers <em>Telephone Numbers</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Telephone Numbers</em>' attribute list is set.
	 * @see #unsetTelephoneNumbers()
	 * @see #getTelephoneNumbers()
	 * @generated
	 */
	boolean isSetTelephoneNumbers();

	/**
	 * Returns the value of the '<em><b>Facsimile Numbers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facsimile Numbers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facsimile Numbers</em>' attribute list.
	 * @see #isSetFacsimileNumbers()
	 * @see #unsetFacsimileNumbers()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_FacsimileNumbers()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getFacsimileNumbers();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacsimileNumbers()
	 * @see #getFacsimileNumbers()
	 * @generated
	 */
	void unsetFacsimileNumbers();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getFacsimileNumbers <em>Facsimile Numbers</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facsimile Numbers</em>' attribute list is set.
	 * @see #unsetFacsimileNumbers()
	 * @see #getFacsimileNumbers()
	 * @generated
	 */
	boolean isSetFacsimileNumbers();

	/**
	 * Returns the value of the '<em><b>Pager Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pager Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pager Number</em>' attribute.
	 * @see #isSetPagerNumber()
	 * @see #unsetPagerNumber()
	 * @see #setPagerNumber(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_PagerNumber()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPagerNumber();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pager Number</em>' attribute.
	 * @see #isSetPagerNumber()
	 * @see #unsetPagerNumber()
	 * @see #getPagerNumber()
	 * @generated
	 */
	void setPagerNumber(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPagerNumber()
	 * @see #getPagerNumber()
	 * @see #setPagerNumber(String)
	 * @generated
	 */
	void unsetPagerNumber();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getPagerNumber <em>Pager Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pager Number</em>' attribute is set.
	 * @see #unsetPagerNumber()
	 * @see #getPagerNumber()
	 * @see #setPagerNumber(String)
	 * @generated
	 */
	boolean isSetPagerNumber();

	/**
	 * Returns the value of the '<em><b>Electronic Mail Addresses</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Electronic Mail Addresses</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Electronic Mail Addresses</em>' attribute list.
	 * @see #isSetElectronicMailAddresses()
	 * @see #unsetElectronicMailAddresses()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_ElectronicMailAddresses()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getElectronicMailAddresses();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElectronicMailAddresses()
	 * @see #getElectronicMailAddresses()
	 * @generated
	 */
	void unsetElectronicMailAddresses();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Electronic Mail Addresses</em>' attribute list is set.
	 * @see #unsetElectronicMailAddresses()
	 * @see #getElectronicMailAddresses()
	 * @generated
	 */
	boolean isSetElectronicMailAddresses();

	/**
	 * Returns the value of the '<em><b>WWW Home Page URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>WWW Home Page URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WWW Home Page URL</em>' attribute.
	 * @see #isSetWWWHomePageURL()
	 * @see #unsetWWWHomePageURL()
	 * @see #setWWWHomePageURL(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_WWWHomePageURL()
	 * @model unsettable="true"
	 * @generated
	 */
	String getWWWHomePageURL();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>WWW Home Page URL</em>' attribute.
	 * @see #isSetWWWHomePageURL()
	 * @see #unsetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @generated
	 */
	void setWWWHomePageURL(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @see #setWWWHomePageURL(String)
	 * @generated
	 */
	void unsetWWWHomePageURL();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getWWWHomePageURL <em>WWW Home Page URL</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>WWW Home Page URL</em>' attribute is set.
	 * @see #unsetWWWHomePageURL()
	 * @see #getWWWHomePageURL()
	 * @see #setWWWHomePageURL(String)
	 * @generated
	 */
	boolean isSetWWWHomePageURL();

	/**
	 * Returns the value of the '<em><b>Messaging IDs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messaging IDs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messaging IDs</em>' attribute list.
	 * @see #isSetMessagingIDs()
	 * @see #unsetMessagingIDs()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTelecomAddress_MessagingIDs()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getMessagingIDs();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getMessagingIDs <em>Messaging IDs</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMessagingIDs()
	 * @see #getMessagingIDs()
	 * @generated
	 */
	void unsetMessagingIDs();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTelecomAddress#getMessagingIDs <em>Messaging IDs</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Messaging IDs</em>' attribute list is set.
	 * @see #unsetMessagingIDs()
	 * @see #getMessagingIDs()
	 * @generated
	 */
	boolean isSetMessagingIDs();

} // IfcTelecomAddress
