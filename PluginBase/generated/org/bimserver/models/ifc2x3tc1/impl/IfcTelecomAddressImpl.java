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
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcTelecomAddress;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Telecom Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl#getTelephoneNumbers <em>Telephone Numbers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl#getFacsimileNumbers <em>Facsimile Numbers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl#getPagerNumber <em>Pager Number</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl#getElectronicMailAddresses <em>Electronic Mail Addresses</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcTelecomAddressImpl#getWWWHomePageURL <em>WWW Home Page URL</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTelecomAddressImpl extends IfcAddressImpl implements IfcTelecomAddress {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTelecomAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getTelephoneNumbers() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__TELEPHONE_NUMBERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTelephoneNumbers() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__TELEPHONE_NUMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTelephoneNumbers() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__TELEPHONE_NUMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getFacsimileNumbers() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__FACSIMILE_NUMBERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFacsimileNumbers() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__FACSIMILE_NUMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFacsimileNumbers() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__FACSIMILE_NUMBERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPagerNumber() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__PAGER_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPagerNumber(String newPagerNumber) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__PAGER_NUMBER, newPagerNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPagerNumber() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__PAGER_NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPagerNumber() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__PAGER_NUMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getElectronicMailAddresses() {
		return (EList<String>) eGet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__ELECTRONIC_MAIL_ADDRESSES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElectronicMailAddresses() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__ELECTRONIC_MAIL_ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElectronicMailAddresses() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__ELECTRONIC_MAIL_ADDRESSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWWWHomePageURL() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__WWW_HOME_PAGE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWWWHomePageURL(String newWWWHomePageURL) {
		eSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__WWW_HOME_PAGE_URL, newWWWHomePageURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWWWHomePageURL() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__WWW_HOME_PAGE_URL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWWWHomePageURL() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_TELECOM_ADDRESS__WWW_HOME_PAGE_URL);
	}

} //IfcTelecomAddressImpl
