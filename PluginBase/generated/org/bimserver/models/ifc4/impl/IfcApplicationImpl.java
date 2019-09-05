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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcApplication;
import org.bimserver.models.ifc4.IfcOrganization;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApplicationImpl#getApplicationDeveloper <em>Application Developer</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApplicationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApplicationImpl#getApplicationFullName <em>Application Full Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcApplicationImpl#getApplicationIdentifier <em>Application Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcApplicationImpl extends IdEObjectImpl implements IfcApplication {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOrganization getApplicationDeveloper() {
		return (IfcOrganization) eGet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_DEVELOPER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicationDeveloper(IfcOrganization newApplicationDeveloper) {
		eSet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_DEVELOPER, newApplicationDeveloper);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLICATION__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		eSet(Ifc4Package.Literals.IFC_APPLICATION__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicationFullName() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_FULL_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicationFullName(String newApplicationFullName) {
		eSet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_FULL_NAME, newApplicationFullName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getApplicationIdentifier() {
		return (String) eGet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicationIdentifier(String newApplicationIdentifier) {
		eSet(Ifc4Package.Literals.IFC_APPLICATION__APPLICATION_IDENTIFIER, newApplicationIdentifier);
	}

} //IfcApplicationImpl
