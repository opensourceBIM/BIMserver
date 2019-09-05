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
 * A representation of the model object '<em><b>Ifc Library Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLibraryInfoForObjects <em>Library Info For Objects</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcLibraryInformation#getHasLibraryReferences <em>Has Library References</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation()
 * @model
 * @generated
 */
public interface IfcLibraryInformation extends IfcExternalInformation, IfcLibrarySelect {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_Name()
	 * @model annotation="singleindex"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #setVersion(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_Version()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #isSetVersion()
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersion()
	 * @see #getVersion()
	 * @see #setVersion(String)
	 * @generated
	 */
	void unsetVersion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersion <em>Version</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Version</em>' attribute is set.
	 * @see #unsetVersion()
	 * @see #getVersion()
	 * @see #setVersion(String)
	 * @generated
	 */
	boolean isSetVersion();

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publisher</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publisher</em>' reference.
	 * @see #isSetPublisher()
	 * @see #unsetPublisher()
	 * @see #setPublisher(IfcActorSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_Publisher()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcActorSelect getPublisher();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #isSetPublisher()
	 * @see #unsetPublisher()
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(IfcActorSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPublisher()
	 * @see #getPublisher()
	 * @see #setPublisher(IfcActorSelect)
	 * @generated
	 */
	void unsetPublisher();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Publisher</em>' reference is set.
	 * @see #unsetPublisher()
	 * @see #getPublisher()
	 * @see #setPublisher(IfcActorSelect)
	 * @generated
	 */
	boolean isSetPublisher();

	/**
	 * Returns the value of the '<em><b>Version Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Date</em>' attribute.
	 * @see #isSetVersionDate()
	 * @see #unsetVersionDate()
	 * @see #setVersionDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_VersionDate()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVersionDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Date</em>' attribute.
	 * @see #isSetVersionDate()
	 * @see #unsetVersionDate()
	 * @see #getVersionDate()
	 * @generated
	 */
	void setVersionDate(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersionDate()
	 * @see #getVersionDate()
	 * @see #setVersionDate(String)
	 * @generated
	 */
	void unsetVersionDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Version Date</em>' attribute is set.
	 * @see #unsetVersionDate()
	 * @see #getVersionDate()
	 * @see #setVersionDate(String)
	 * @generated
	 */
	boolean isSetVersionDate();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #setLocation(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_Location()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	void unsetLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLocation <em>Location</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location</em>' attribute is set.
	 * @see #unsetLocation()
	 * @see #getLocation()
	 * @see #setLocation(String)
	 * @generated
	 */
	boolean isSetLocation();

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
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getDescription <em>Description</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getDescription <em>Description</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Library Info For Objects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssociatesLibrary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Info For Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Info For Objects</em>' reference list.
	 * @see #isSetLibraryInfoForObjects()
	 * @see #unsetLibraryInfoForObjects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_LibraryInfoForObjects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssociatesLibrary> getLibraryInfoForObjects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLibraryInfoForObjects <em>Library Info For Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLibraryInfoForObjects()
	 * @see #getLibraryInfoForObjects()
	 * @generated
	 */
	void unsetLibraryInfoForObjects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getLibraryInfoForObjects <em>Library Info For Objects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Library Info For Objects</em>' reference list is set.
	 * @see #unsetLibraryInfoForObjects()
	 * @see #getLibraryInfoForObjects()
	 * @generated
	 */
	boolean isSetLibraryInfoForObjects();

	/**
	 * Returns the value of the '<em><b>Has Library References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcLibraryReference}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary <em>Referenced Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Library References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Library References</em>' reference list.
	 * @see #isSetHasLibraryReferences()
	 * @see #unsetHasLibraryReferences()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcLibraryInformation_HasLibraryReferences()
	 * @see org.bimserver.models.ifc4.IfcLibraryReference#getReferencedLibrary
	 * @model opposite="ReferencedLibrary" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcLibraryReference> getHasLibraryReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getHasLibraryReferences <em>Has Library References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasLibraryReferences()
	 * @see #getHasLibraryReferences()
	 * @generated
	 */
	void unsetHasLibraryReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcLibraryInformation#getHasLibraryReferences <em>Has Library References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Library References</em>' reference list is set.
	 * @see #unsetHasLibraryReferences()
	 * @see #getHasLibraryReferences()
	 * @generated
	 */
	boolean isSetHasLibraryReferences();

} // IfcLibraryInformation
