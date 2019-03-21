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
 * A representation of the model object '<em><b>Database Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfProjects <em>Number Of Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfUsers <em>Number Of Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions <em>Number Of Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts <em>Number Of Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getCreated <em>Created</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.DatabaseInformation#getCategories <em>Categories</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface DatabaseInformation extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Number Of Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Projects</em>' attribute.
	 * @see #setNumberOfProjects(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfProjects()
	 * @model
	 * @generated
	 */
	Integer getNumberOfProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfProjects <em>Number Of Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Projects</em>' attribute.
	 * @see #getNumberOfProjects()
	 * @generated
	 */
	void setNumberOfProjects(Integer value);

	/**
	 * Returns the value of the '<em><b>Number Of Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Users</em>' attribute.
	 * @see #setNumberOfUsers(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfUsers()
	 * @model
	 * @generated
	 */
	Integer getNumberOfUsers();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfUsers <em>Number Of Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Users</em>' attribute.
	 * @see #getNumberOfUsers()
	 * @generated
	 */
	void setNumberOfUsers(Integer value);

	/**
	 * Returns the value of the '<em><b>Number Of Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Revisions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Revisions</em>' attribute.
	 * @see #setNumberOfRevisions(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfRevisions()
	 * @model
	 * @generated
	 */
	Integer getNumberOfRevisions();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions <em>Number Of Revisions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Revisions</em>' attribute.
	 * @see #getNumberOfRevisions()
	 * @generated
	 */
	void setNumberOfRevisions(Integer value);

	/**
	 * Returns the value of the '<em><b>Number Of Checkouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Checkouts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Checkouts</em>' attribute.
	 * @see #setNumberOfCheckouts(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_NumberOfCheckouts()
	 * @model
	 * @generated
	 */
	Integer getNumberOfCheckouts();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts <em>Number Of Checkouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Checkouts</em>' attribute.
	 * @see #getNumberOfCheckouts()
	 * @generated
	 */
	void setNumberOfCheckouts(Integer value);

	/**
	 * Returns the value of the '<em><b>Database Size In Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Size In Bytes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Size In Bytes</em>' attribute.
	 * @see #setDatabaseSizeInBytes(Long)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_DatabaseSizeInBytes()
	 * @model
	 * @generated
	 */
	Long getDatabaseSizeInBytes();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Size In Bytes</em>' attribute.
	 * @see #getDatabaseSizeInBytes()
	 * @generated
	 */
	void setDatabaseSizeInBytes(Long value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see #setSchemaVersion(Integer)
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_SchemaVersion()
	 * @model
	 * @generated
	 */
	Integer getSchemaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.DatabaseInformation#getSchemaVersion <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Version</em>' attribute.
	 * @see #getSchemaVersion()
	 * @generated
	 */
	void setSchemaVersion(Integer value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.DatabaseInformationCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getDatabaseInformation_Categories()
	 * @model annotation="embedsreference"
	 * @generated
	 */
	EList<DatabaseInformationCategory> getCategories();

} // DatabaseInformation
