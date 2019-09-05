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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcPostalAddress;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Postal Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getInternalLocation <em>Internal Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getAddressLines <em>Address Lines</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getPostalBox <em>Postal Box</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getTown <em>Town</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPostalAddressImpl#getCountry <em>Country</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPostalAddressImpl extends IfcAddressImpl implements IfcPostalAddress {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPostalAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_POSTAL_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getInternalLocation() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalLocation(String newInternalLocation) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION, newInternalLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInternalLocation() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInternalLocation() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getAddressLines() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetAddressLines() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAddressLines() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPostalBox() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostalBox(String newPostalBox) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX, newPostalBox);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPostalBox() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPostalBox() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTown() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__TOWN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTown(String newTown) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__TOWN, newTown);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTown() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__TOWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTown() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__TOWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRegion() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__REGION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRegion(String newRegion) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__REGION, newRegion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRegion() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__REGION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRegion() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__REGION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPostalCode() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostalCode(String newPostalCode) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE, newPostalCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPostalCode() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPostalCode() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCountry() {
		return (String) eGet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCountry(String newCountry) {
		eSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY, newCountry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCountry() {
		eUnset(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCountry() {
		return eIsSet(Ifc4Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY);
	}

} //IfcPostalAddressImpl
