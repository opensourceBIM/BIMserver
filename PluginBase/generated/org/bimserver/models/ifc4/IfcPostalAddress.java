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
 * A representation of the model object '<em><b>Ifc Postal Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getInternalLocation <em>Internal Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getAddressLines <em>Address Lines</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalBox <em>Postal Box</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getTown <em>Town</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getRegion <em>Region</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcPostalAddress#getCountry <em>Country</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress()
 * @model
 * @generated
 */
public interface IfcPostalAddress extends IfcAddress {
	/**
	 * Returns the value of the '<em><b>Internal Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Location</em>' attribute.
	 * @see #isSetInternalLocation()
	 * @see #unsetInternalLocation()
	 * @see #setInternalLocation(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_InternalLocation()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInternalLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getInternalLocation <em>Internal Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Location</em>' attribute.
	 * @see #isSetInternalLocation()
	 * @see #unsetInternalLocation()
	 * @see #getInternalLocation()
	 * @generated
	 */
	void setInternalLocation(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getInternalLocation <em>Internal Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalLocation()
	 * @see #getInternalLocation()
	 * @see #setInternalLocation(String)
	 * @generated
	 */
	void unsetInternalLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getInternalLocation <em>Internal Location</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Location</em>' attribute is set.
	 * @see #unsetInternalLocation()
	 * @see #getInternalLocation()
	 * @see #setInternalLocation(String)
	 * @generated
	 */
	boolean isSetInternalLocation();

	/**
	 * Returns the value of the '<em><b>Address Lines</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address Lines</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address Lines</em>' attribute list.
	 * @see #isSetAddressLines()
	 * @see #unsetAddressLines()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_AddressLines()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getAddressLines();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getAddressLines <em>Address Lines</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAddressLines()
	 * @see #getAddressLines()
	 * @generated
	 */
	void unsetAddressLines();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getAddressLines <em>Address Lines</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Address Lines</em>' attribute list is set.
	 * @see #unsetAddressLines()
	 * @see #getAddressLines()
	 * @generated
	 */
	boolean isSetAddressLines();

	/**
	 * Returns the value of the '<em><b>Postal Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Box</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Box</em>' attribute.
	 * @see #isSetPostalBox()
	 * @see #unsetPostalBox()
	 * @see #setPostalBox(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_PostalBox()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPostalBox();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalBox <em>Postal Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Box</em>' attribute.
	 * @see #isSetPostalBox()
	 * @see #unsetPostalBox()
	 * @see #getPostalBox()
	 * @generated
	 */
	void setPostalBox(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalBox <em>Postal Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPostalBox()
	 * @see #getPostalBox()
	 * @see #setPostalBox(String)
	 * @generated
	 */
	void unsetPostalBox();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalBox <em>Postal Box</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Postal Box</em>' attribute is set.
	 * @see #unsetPostalBox()
	 * @see #getPostalBox()
	 * @see #setPostalBox(String)
	 * @generated
	 */
	boolean isSetPostalBox();

	/**
	 * Returns the value of the '<em><b>Town</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Town</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Town</em>' attribute.
	 * @see #isSetTown()
	 * @see #unsetTown()
	 * @see #setTown(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_Town()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTown();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getTown <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Town</em>' attribute.
	 * @see #isSetTown()
	 * @see #unsetTown()
	 * @see #getTown()
	 * @generated
	 */
	void setTown(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getTown <em>Town</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTown()
	 * @see #getTown()
	 * @see #setTown(String)
	 * @generated
	 */
	void unsetTown();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getTown <em>Town</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Town</em>' attribute is set.
	 * @see #unsetTown()
	 * @see #getTown()
	 * @see #setTown(String)
	 * @generated
	 */
	boolean isSetTown();

	/**
	 * Returns the value of the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' attribute.
	 * @see #isSetRegion()
	 * @see #unsetRegion()
	 * @see #setRegion(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_Region()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRegion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' attribute.
	 * @see #isSetRegion()
	 * @see #unsetRegion()
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRegion()
	 * @see #getRegion()
	 * @see #setRegion(String)
	 * @generated
	 */
	void unsetRegion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getRegion <em>Region</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Region</em>' attribute is set.
	 * @see #unsetRegion()
	 * @see #getRegion()
	 * @see #setRegion(String)
	 * @generated
	 */
	boolean isSetRegion();

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postal Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #isSetPostalCode()
	 * @see #unsetPostalCode()
	 * @see #setPostalCode(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_PostalCode()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #isSetPostalCode()
	 * @see #unsetPostalCode()
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPostalCode()
	 * @see #getPostalCode()
	 * @see #setPostalCode(String)
	 * @generated
	 */
	void unsetPostalCode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getPostalCode <em>Postal Code</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Postal Code</em>' attribute is set.
	 * @see #unsetPostalCode()
	 * @see #getPostalCode()
	 * @see #setPostalCode(String)
	 * @generated
	 */
	boolean isSetPostalCode();

	/**
	 * Returns the value of the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Country</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Country</em>' attribute.
	 * @see #isSetCountry()
	 * @see #unsetCountry()
	 * @see #setCountry(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPostalAddress_Country()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCountry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' attribute.
	 * @see #isSetCountry()
	 * @see #unsetCountry()
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getCountry <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCountry()
	 * @see #getCountry()
	 * @see #setCountry(String)
	 * @generated
	 */
	void unsetCountry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcPostalAddress#getCountry <em>Country</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Country</em>' attribute is set.
	 * @see #unsetCountry()
	 * @see #getCountry()
	 * @see #setCountry(String)
	 * @generated
	 */
	boolean isSetCountry();

} // IfcPostalAddress
