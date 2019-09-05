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
import org.bimserver.models.ifc4.IfcLibraryInformation;
import org.bimserver.models.ifc4.IfcLibraryReference;
import org.bimserver.models.ifc4.IfcRelAssociatesLibrary;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Library Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryReferenceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryReferenceImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryReferenceImpl#getReferencedLibrary <em>Referenced Library</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcLibraryReferenceImpl#getLibraryRefForObjects <em>Library Ref For Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcLibraryReferenceImpl extends IfcExternalReferenceImpl implements IfcLibraryReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLibraryReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_LIBRARY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return (String) eGet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LANGUAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LANGUAGE, newLanguage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLanguage() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LANGUAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLanguage() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LANGUAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLibraryInformation getReferencedLibrary() {
		return (IfcLibraryInformation) eGet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__REFERENCED_LIBRARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferencedLibrary(IfcLibraryInformation newReferencedLibrary) {
		eSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__REFERENCED_LIBRARY, newReferencedLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetReferencedLibrary() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__REFERENCED_LIBRARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetReferencedLibrary() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__REFERENCED_LIBRARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcRelAssociatesLibrary> getLibraryRefForObjects() {
		return (EList<IfcRelAssociatesLibrary>) eGet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LIBRARY_REF_FOR_OBJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLibraryRefForObjects() {
		eUnset(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LIBRARY_REF_FOR_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLibraryRefForObjects() {
		return eIsSet(Ifc4Package.Literals.IFC_LIBRARY_REFERENCE__LIBRARY_REF_FOR_OBJECTS);
	}

} //IfcLibraryReferenceImpl
