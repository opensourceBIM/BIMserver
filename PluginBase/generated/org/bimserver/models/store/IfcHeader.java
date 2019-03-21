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
package org.bimserver.models.store;

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

import java.util.Date;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getImplementationLevel <em>Implementation Level</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getFilename <em>Filename</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getPreProcessorVersion <em>Pre Processor Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getOriginatingSystem <em>Originating System</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getIfcSchemaVersion <em>Ifc Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.IfcHeader#getAuthorization <em>Authorization</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getIfcHeader()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcHeader extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_Description()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getDescription();

	/**
	 * Returns the value of the '<em><b>Implementation Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Level</em>' attribute.
	 * @see #setImplementationLevel(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_ImplementationLevel()
	 * @model
	 * @generated
	 */
	String getImplementationLevel();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getImplementationLevel <em>Implementation Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Level</em>' attribute.
	 * @see #getImplementationLevel()
	 * @generated
	 */
	void setImplementationLevel(String value);

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_Filename()
	 * @model
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Stamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Stamp</em>' attribute.
	 * @see #setTimeStamp(Date)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_TimeStamp()
	 * @model
	 * @generated
	 */
	Date getTimeStamp();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getTimeStamp <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' attribute.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(Date value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_Author()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getAuthor();

	/**
	 * Returns the value of the '<em><b>Organization</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_Organization()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getOrganization();

	/**
	 * Returns the value of the '<em><b>Pre Processor Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Processor Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Processor Version</em>' attribute.
	 * @see #setPreProcessorVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_PreProcessorVersion()
	 * @model
	 * @generated
	 */
	String getPreProcessorVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getPreProcessorVersion <em>Pre Processor Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Processor Version</em>' attribute.
	 * @see #getPreProcessorVersion()
	 * @generated
	 */
	void setPreProcessorVersion(String value);

	/**
	 * Returns the value of the '<em><b>Originating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Originating System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Originating System</em>' attribute.
	 * @see #setOriginatingSystem(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_OriginatingSystem()
	 * @model
	 * @generated
	 */
	String getOriginatingSystem();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getOriginatingSystem <em>Originating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Originating System</em>' attribute.
	 * @see #getOriginatingSystem()
	 * @generated
	 */
	void setOriginatingSystem(String value);

	/**
	 * Returns the value of the '<em><b>Ifc Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Schema Version</em>' attribute.
	 * @see #setIfcSchemaVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_IfcSchemaVersion()
	 * @model
	 * @generated
	 */
	String getIfcSchemaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getIfcSchemaVersion <em>Ifc Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Schema Version</em>' attribute.
	 * @see #getIfcSchemaVersion()
	 * @generated
	 */
	void setIfcSchemaVersion(String value);

	/**
	 * Returns the value of the '<em><b>Authorization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authorization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authorization</em>' attribute.
	 * @see #setAuthorization(String)
	 * @see org.bimserver.models.store.StorePackage#getIfcHeader_Authorization()
	 * @model
	 * @generated
	 */
	String getAuthorization();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.IfcHeader#getAuthorization <em>Authorization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorization</em>' attribute.
	 * @see #getAuthorization()
	 * @generated
	 */
	void setAuthorization(String value);

} // IfcHeader
