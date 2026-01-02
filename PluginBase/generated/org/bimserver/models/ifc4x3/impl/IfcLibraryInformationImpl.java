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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcActorSelect;
import org.bimserver.models.ifc4x3.IfcLibraryInformation;
import org.bimserver.models.ifc4x3.IfcLibraryReference;
import org.bimserver.models.ifc4x3.IfcRelAssociatesLibrary;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getLibraryInfoForObjects <em>Library Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcLibraryInformationImpl#getHasLibraryReferences <em>Has Library References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLibraryInformationImpl extends IfcExternalInformationImpl implements IfcLibraryInformation {
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
		return Ifc4x3Package.eINSTANCE.getIfcLibraryInformation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Version(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Version(), newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVersion() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Version());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVersion() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Version());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getPublisher() {
		return (IfcActorSelect) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Publisher(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublisher(IfcActorSelect newPublisher) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Publisher(), newPublisher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPublisher() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Publisher());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPublisher() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Publisher());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionDate() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionDate(String newVersionDate) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate(), newVersionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVersionDate() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVersionDate() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_VersionDate());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Location(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Location(), newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLocation() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Location());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLocation() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Location());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesLibrary> getLibraryInfoForObjects() {
		return (EList<IfcRelAssociatesLibrary>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_LibraryInfoForObjects(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLibraryInfoForObjects() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_LibraryInfoForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLibraryInfoForObjects() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_LibraryInfoForObjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcLibraryReference> getHasLibraryReferences() {
		return (EList<IfcLibraryReference>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_HasLibraryReferences(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasLibraryReferences() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_HasLibraryReferences());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasLibraryReferences() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcLibraryInformation_HasLibraryReferences());
	}

} //IfcLibraryInformationImpl
