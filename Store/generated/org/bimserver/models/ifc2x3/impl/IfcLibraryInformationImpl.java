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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCalendarDate;
import org.bimserver.models.ifc2x3.IfcLibraryInformation;
import org.bimserver.models.ifc2x3.IfcLibraryReference;
import org.bimserver.models.ifc2x3.IfcOrganization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Library Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl#getLibraryReference <em>Library Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLibraryInformationImpl extends IdEObjectImpl implements IfcLibraryInformation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLibraryInformationImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcLibraryInformation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Version(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Version(), newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVersion()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Version());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVersion()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Version());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrganization getPublisher()
	{
		return (IfcOrganization)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Publisher(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(IfcOrganization newPublisher)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Publisher(), newPublisher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPublisher()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Publisher());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPublisher()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_Publisher());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getVersionDate()
	{
		return (IfcCalendarDate)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionDate(IfcCalendarDate newVersionDate)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate(), newVersionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVersionDate()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVersionDate()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcLibraryReference> getLibraryReference()
	{
		return (EList<IfcLibraryReference>)eGet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_LibraryReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLibraryReference()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_LibraryReference());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLibraryReference()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLibraryInformation_LibraryReference());
	}

} //IfcLibraryInformationImpl
