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
import org.bimserver.models.ifc2x3.IfcApplication;
import org.bimserver.models.ifc2x3.IfcOrganization;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApplicationImpl#getApplicationDeveloper <em>Application Developer</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApplicationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApplicationImpl#getApplicationFullName <em>Application Full Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcApplicationImpl#getApplicationIdentifier <em>Application Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcApplicationImpl extends IdEObjectImpl implements IfcApplication
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
	protected IfcApplicationImpl()
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
		return Ifc2x3Package.Literals.IFC_APPLICATION;
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
	public IfcOrganization getApplicationDeveloper()
	{
		return (IfcOrganization)eGet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_DEVELOPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationDeveloper(IfcOrganization newApplicationDeveloper)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_DEVELOPER, newApplicationDeveloper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPLICATION__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPLICATION__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationFullName()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_FULL_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationFullName(String newApplicationFullName)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_FULL_NAME, newApplicationFullName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationIdentifier()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationIdentifier(String newApplicationIdentifier)
	{
		eSet(Ifc2x3Package.Literals.IFC_APPLICATION__APPLICATION_IDENTIFIER, newApplicationIdentifier);
	}

} //IfcApplicationImpl
