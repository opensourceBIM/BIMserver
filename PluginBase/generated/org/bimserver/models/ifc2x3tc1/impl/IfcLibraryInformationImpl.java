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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcCalendarDate;
import org.bimserver.models.ifc2x3tc1.IfcLibraryInformation;
import org.bimserver.models.ifc2x3tc1.IfcLibraryReference;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Library Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLibraryInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLibraryInformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLibraryInformationImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLibraryInformationImpl#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcLibraryInformationImpl#getLibraryReference <em>Library Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLibraryInformationImpl extends IdEObjectImpl implements IfcLibraryInformation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLibraryInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION;
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
	public String getName() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVersion() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVersion() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrganization getPublisher() {
		return (IfcOrganization) eGet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(IfcOrganization newPublisher) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER, newPublisher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPublisher() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPublisher() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate getVersionDate() {
		return (IfcCalendarDate) eGet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionDate(IfcCalendarDate newVersionDate) {
		eSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE, newVersionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVersionDate() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVersionDate() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcLibraryReference> getLibraryReference() {
		return (EList<IfcLibraryReference>) eGet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_REFERENCE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLibraryReference() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_REFERENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLibraryReference() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_REFERENCE);
	}

} //IfcLibraryInformationImpl
