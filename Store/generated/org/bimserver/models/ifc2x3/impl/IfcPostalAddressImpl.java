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
		return Ifc2x3Package.eINSTANCE.getIfcPostalAddress();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInternalLocation()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_InternalLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalLocation(String newInternalLocation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_InternalLocation(), newInternalLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalLocation()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_InternalLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalLocation()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_InternalLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getAddressLines()
	{
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_AddressLines(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAddressLines()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_AddressLines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAddressLines()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_AddressLines());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalBox()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalBox(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalBox(String newPostalBox)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalBox(), newPostalBox);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPostalBox()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalBox());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPostalBox()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalBox());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTown()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Town(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTown(String newTown)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Town(), newTown);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTown()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Town());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTown()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Town());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegion()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Region(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(String newRegion)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Region(), newRegion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRegion()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Region());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRegion()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Region());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalCode()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalCode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalCode(String newPostalCode)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalCode(), newPostalCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPostalCode()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalCode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPostalCode()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_PostalCode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountry()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Country(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountry(String newCountry)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Country(), newCountry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCountry()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Country());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCountry()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPostalAddress_Country());
	}

} //IfcPostalAddressImpl
