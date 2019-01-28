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
 * A representation of the model object '<em><b>Ifc Library Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersionDate <em>Version Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getLibraryReference <em>Library Reference</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation()
 * @model
 * @generated
 */
public interface IfcLibraryInformation extends IfcLibrarySelect {
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getName <em>Name</em>}' attribute.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation_Version()
	 * @model unsettable="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersion <em>Version</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersion()
	 * @see #getVersion()
	 * @see #setVersion(String)
	 * @generated
	 */
	void unsetVersion();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersion <em>Version</em>}' attribute is set.
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
	 * @see #setPublisher(IfcOrganization)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation_Publisher()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcOrganization getPublisher();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #isSetPublisher()
	 * @see #unsetPublisher()
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(IfcOrganization value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPublisher()
	 * @see #getPublisher()
	 * @see #setPublisher(IfcOrganization)
	 * @generated
	 */
	void unsetPublisher();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getPublisher <em>Publisher</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Publisher</em>' reference is set.
	 * @see #unsetPublisher()
	 * @see #getPublisher()
	 * @see #setPublisher(IfcOrganization)
	 * @generated
	 */
	boolean isSetPublisher();

	/**
	 * Returns the value of the '<em><b>Version Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version Date</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Date</em>' reference.
	 * @see #isSetVersionDate()
	 * @see #unsetVersionDate()
	 * @see #setVersionDate(IfcCalendarDate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation_VersionDate()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCalendarDate getVersionDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Date</em>' reference.
	 * @see #isSetVersionDate()
	 * @see #unsetVersionDate()
	 * @see #getVersionDate()
	 * @generated
	 */
	void setVersionDate(IfcCalendarDate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVersionDate()
	 * @see #getVersionDate()
	 * @see #setVersionDate(IfcCalendarDate)
	 * @generated
	 */
	void unsetVersionDate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getVersionDate <em>Version Date</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Version Date</em>' reference is set.
	 * @see #unsetVersionDate()
	 * @see #getVersionDate()
	 * @see #setVersionDate(IfcCalendarDate)
	 * @generated
	 */
	boolean isSetVersionDate();

	/**
	 * Returns the value of the '<em><b>Library Reference</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcLibraryReference}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryReference#getReferenceIntoLibrary <em>Reference Into Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Reference</em>' reference list.
	 * @see #isSetLibraryReference()
	 * @see #unsetLibraryReference()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcLibraryInformation_LibraryReference()
	 * @see org.bimserver.models.ifc2x3tc1.IfcLibraryReference#getReferenceIntoLibrary
	 * @model opposite="ReferenceIntoLibrary" unsettable="true"
	 * @generated
	 */
	EList<IfcLibraryReference> getLibraryReference();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getLibraryReference <em>Library Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLibraryReference()
	 * @see #getLibraryReference()
	 * @generated
	 */
	void unsetLibraryReference();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcLibraryInformation#getLibraryReference <em>Library Reference</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Library Reference</em>' reference list is set.
	 * @see #unsetLibraryReference()
	 * @see #getLibraryReference()
	 * @generated
	 */
	boolean isSetLibraryReference();

} // IfcLibraryInformation
