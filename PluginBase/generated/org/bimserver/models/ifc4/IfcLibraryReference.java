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
package org.bimserver.models.ifc4;

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
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryReference#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryReference#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary <em>Referenced Library</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryReference#getLibraryRefForObjects <em>Library Ref For Objects</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryReference()
 * @model
 * @generated
 */
public interface IfcLibraryReference extends IfcExternalReference, IfcLibrarySelect {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryReference_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #isSetLanguage()
	 * @see #unsetLanguage()
	 * @see #setLanguage(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryReference_Language()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #isSetLanguage()
	 * @see #unsetLanguage()
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLanguage()
	 * @see #getLanguage()
	 * @see #setLanguage(String)
	 * @generated
	 */
	void unsetLanguage();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getLanguage <em>Language</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Language</em>' attribute is set.
	 * @see #unsetLanguage()
	 * @see #getLanguage()
	 * @see #setLanguage(String)
	 * @generated
	 */
	boolean isSetLanguage();

	/**
	 * Returns the value of the '<em><b>Referenced Library</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getHasLibraryReferences <em>Has Library References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Library</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Library</em>' reference.
	 * @see #isSetReferencedLibrary()
	 * @see #unsetReferencedLibrary()
	 * @see #setReferencedLibrary(IfcLibraryInformation)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryReference_ReferencedLibrary()
	 * @see org.bimserver.models.ifc4.IfcLibraryInformation#getHasLibraryReferences
	 * @model opposite="HasLibraryReferences" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcLibraryInformation getReferencedLibrary();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary <em>Referenced Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Library</em>' reference.
	 * @see #isSetReferencedLibrary()
	 * @see #unsetReferencedLibrary()
	 * @see #getReferencedLibrary()
	 * @generated
	 */
	void setReferencedLibrary(IfcLibraryInformation value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary <em>Referenced Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedLibrary()
	 * @see #getReferencedLibrary()
	 * @see #setReferencedLibrary(IfcLibraryInformation)
	 * @generated
	 */
	void unsetReferencedLibrary();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary <em>Referenced Library</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Library</em>' reference is set.
	 * @see #unsetReferencedLibrary()
	 * @see #getReferencedLibrary()
	 * @see #setReferencedLibrary(IfcLibraryInformation)
	 * @generated
	 */
	boolean isSetReferencedLibrary();

	/**
	 * Returns the value of the '<em><b>Library Ref For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesLibrary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Ref For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Ref For Objects</em>' reference list.
	 * @see #isSetLibraryRefForObjects()
	 * @see #unsetLibraryRefForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryReference_LibraryRefForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesLibrary> getLibraryRefForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getLibraryRefForObjects <em>Library Ref For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLibraryRefForObjects()
	 * @see #getLibraryRefForObjects()
	 * @generated
	 */
	void unsetLibraryRefForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryReference#getLibraryRefForObjects <em>Library Ref For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Library Ref For Objects</em>' reference list is set.
	 * @see #unsetLibraryRefForObjects()
	 * @see #getLibraryRefForObjects()
	 * @generated
	 */
	boolean isSetLibraryRefForObjects();

} // IfcLibraryReference
