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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPostalAddress;

import org.bimserver.models.ifc2x3.impl.IfcAddressImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Postal Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getInternalLocation <em>Internal Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getAddressLines <em>Address Lines</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getPostalBox <em>Postal Box</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getTown <em>Town</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl#getCountry <em>Country</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPostalAddressImpl extends IfcAddressImpl implements IfcPostalAddress
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPostalAddressImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternalLocation()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalLocation(String newInternalLocation)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION, newInternalLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalLocation()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalLocation()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__INTERNAL_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getAddressLines()
	{
		return (EList<String>)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAddressLines()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAddressLines()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__ADDRESS_LINES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalBox()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalBox(String newPostalBox)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX, newPostalBox);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPostalBox()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPostalBox()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_BOX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTown()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__TOWN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTown(String newTown)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__TOWN, newTown);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTown()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__TOWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTown()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__TOWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegion()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__REGION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(String newRegion)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__REGION, newRegion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRegion()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__REGION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRegion()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__REGION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalCode()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(String newPostalCode)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE, newPostalCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPostalCode()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPostalCode()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__POSTAL_CODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountry()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountry(String newCountry)
	{
		eSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY, newCountry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCountry()
	{
		eUnset(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCountry()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_POSTAL_ADDRESS__COUNTRY);
	}

} //IfcPostalAddressImpl
