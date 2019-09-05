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
import org.bimserver.models.ifc4.IfcActorSelect;
import org.bimserver.models.ifc4.IfcLibraryInformation;
import org.bimserver.models.ifc4.IfcLibraryReference;
import org.bimserver.models.ifc4.IfcRelAssociatesLibrary;
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
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getLibraryInfoForObjects <em>Library Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryInformationImpl#getHasLibraryReferences <em>Has Library References</em>}</li>
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
		return Ifc4Package.Literals.IFC_LIBRARY_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION, newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVersion() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVersion() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorSelect getPublisher() {
		return (IfcActorSelect) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPublisher(IfcActorSelect newPublisher) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER, newPublisher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPublisher() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPublisher() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__PUBLISHER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionDate() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionDate(String newVersionDate) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE, newVersionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVersionDate() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVersionDate() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__VERSION_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLocation() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLocation() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesLibrary> getLibraryInfoForObjects() {
		return (EList<IfcRelAssociatesLibrary>) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_INFO_FOR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLibraryInfoForObjects() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_INFO_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLibraryInfoForObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__LIBRARY_INFO_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcLibraryReference> getHasLibraryReferences() {
		return (EList<IfcLibraryReference>) eGet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__HAS_LIBRARY_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasLibraryReferences() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__HAS_LIBRARY_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasLibraryReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_INFORMATION__HAS_LIBRARY_REFERENCES);
	}

} //IfcLibraryInformationImpl
