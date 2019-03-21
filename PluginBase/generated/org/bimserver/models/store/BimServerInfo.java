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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bim Server Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getCurrentVersion <em>Current Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getCurrentDate <em>Current Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getLatestDate <em>Latest Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getUsers <em>Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getServerLogUrl <em>Server Log Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.BimServerInfo#getStarted <em>Started</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getBimServerInfo()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface BimServerInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Version</em>' attribute.
	 * @see #setCurrentVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_CurrentVersion()
	 * @model
	 * @generated
	 */
	String getCurrentVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getCurrentVersion <em>Current Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Version</em>' attribute.
	 * @see #getCurrentVersion()
	 * @generated
	 */
	void setCurrentVersion(String value);

	/**
	 * Returns the value of the '<em><b>Current Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Date</em>' attribute.
	 * @see #setCurrentDate(Date)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_CurrentDate()
	 * @model
	 * @generated
	 */
	Date getCurrentDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getCurrentDate <em>Current Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Date</em>' attribute.
	 * @see #getCurrentDate()
	 * @generated
	 */
	void setCurrentDate(Date value);

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see #setSchemaVersion(int)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_SchemaVersion()
	 * @model
	 * @generated
	 */
	int getSchemaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getSchemaVersion <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Version</em>' attribute.
	 * @see #getSchemaVersion()
	 * @generated
	 */
	void setSchemaVersion(int value);

	/**
	 * Returns the value of the '<em><b>Latest Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Date</em>' attribute.
	 * @see #setLatestDate(Date)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_LatestDate()
	 * @model
	 * @generated
	 */
	Date getLatestDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getLatestDate <em>Latest Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Date</em>' attribute.
	 * @see #getLatestDate()
	 * @generated
	 */
	void setLatestDate(Date value);

	/**
	 * Returns the value of the '<em><b>Latest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Version</em>' attribute.
	 * @see #setLatestVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_LatestVersion()
	 * @model
	 * @generated
	 */
	String getLatestVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getLatestVersion <em>Latest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Version</em>' attribute.
	 * @see #getLatestVersion()
	 * @generated
	 */
	void setLatestVersion(String value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' attribute.
	 * @see #setProjects(int)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_Projects()
	 * @model
	 * @generated
	 */
	int getProjects();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getProjects <em>Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projects</em>' attribute.
	 * @see #getProjects()
	 * @generated
	 */
	void setProjects(int value);

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' attribute.
	 * @see #setRevisions(int)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_Revisions()
	 * @model
	 * @generated
	 */
	int getRevisions();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getRevisions <em>Revisions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revisions</em>' attribute.
	 * @see #getRevisions()
	 * @generated
	 */
	void setRevisions(int value);

	/**
	 * Returns the value of the '<em><b>Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' attribute.
	 * @see #setUsers(int)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_Users()
	 * @model
	 * @generated
	 */
	int getUsers();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getUsers <em>Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Users</em>' attribute.
	 * @see #getUsers()
	 * @generated
	 */
	void setUsers(int value);

	/**
	 * Returns the value of the '<em><b>Checkouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkouts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkouts</em>' attribute.
	 * @see #setCheckouts(int)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_Checkouts()
	 * @model
	 * @generated
	 */
	int getCheckouts();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getCheckouts <em>Checkouts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkouts</em>' attribute.
	 * @see #getCheckouts()
	 * @generated
	 */
	void setCheckouts(int value);

	/**
	 * Returns the value of the '<em><b>Server Log Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Log Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Log Url</em>' attribute.
	 * @see #setServerLogUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_ServerLogUrl()
	 * @model
	 * @generated
	 */
	String getServerLogUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getServerLogUrl <em>Server Log Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Log Url</em>' attribute.
	 * @see #getServerLogUrl()
	 * @generated
	 */
	void setServerLogUrl(String value);

	/**
	 * Returns the value of the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started</em>' attribute.
	 * @see #setStarted(Date)
	 * @see org.bimserver.models.store.StorePackage#getBimServerInfo_Started()
	 * @model
	 * @generated
	 */
	Date getStarted();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.BimServerInfo#getStarted <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Started</em>' attribute.
	 * @see #getStarted()
	 * @generated
	 */
	void setStarted(Date value);

} // BimServerInfo
