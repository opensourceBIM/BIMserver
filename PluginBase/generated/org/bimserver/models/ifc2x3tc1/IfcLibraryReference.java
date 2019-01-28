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
package org.bimserver.models.ifc2x3tc1;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Library Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryReference#getReferenceIntoLibrary <em>Reference Into Library</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryReference()
 * @model
 * @generated
 */
public interface IfcLibraryReference extends IfcExternalReference, IfcLibrarySelect {
	/**
	 * Returns the value of the '<em><b>Reference Into Library</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getLibraryReference <em>Library Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Into Library</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Into Library</em>' reference list.
	 * @see #isSetReferenceIntoLibrary()
	 * @see #unsetReferenceIntoLibrary()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryReference_ReferenceIntoLibrary()
	 * @see org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getLibraryReference
	 * @model opposite="LibraryReference" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcLibraryInformation> getReferenceIntoLibrary();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryReference#getReferenceIntoLibrary <em>Reference Into Library</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferenceIntoLibrary()
	 * @see #getReferenceIntoLibrary()
	 * @generated
	 */
	void unsetReferenceIntoLibrary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryReference#getReferenceIntoLibrary <em>Reference Into Library</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reference Into Library</em>' reference list is set.
	 * @see #unsetReferenceIntoLibrary()
	 * @see #getReferenceIntoLibrary()
	 * @generated
	 */
	boolean isSetReferenceIntoLibrary();

} // IfcLibraryReference
