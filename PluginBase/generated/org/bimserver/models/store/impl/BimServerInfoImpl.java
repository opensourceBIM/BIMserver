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
package org.bimserver.models.store.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.BimServerInfo;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bim Server Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getCurrentVersion <em>Current Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getCurrentDate <em>Current Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getLatestDate <em>Latest Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getServerLogUrl <em>Server Log Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.BimServerInfoImpl#getStarted <em>Started</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BimServerInfoImpl extends IdEObjectImpl implements BimServerInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BimServerInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.BIM_SERVER_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCurrentVersion() {
		return (String) eGet(StorePackage.Literals.BIM_SERVER_INFO__CURRENT_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentVersion(String newCurrentVersion) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__CURRENT_VERSION, newCurrentVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getCurrentDate() {
		return (Date) eGet(StorePackage.Literals.BIM_SERVER_INFO__CURRENT_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDate(Date newCurrentDate) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__CURRENT_DATE, newCurrentDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSchemaVersion() {
		return (Integer) eGet(StorePackage.Literals.BIM_SERVER_INFO__SCHEMA_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchemaVersion(int newSchemaVersion) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__SCHEMA_VERSION, newSchemaVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getLatestDate() {
		return (Date) eGet(StorePackage.Literals.BIM_SERVER_INFO__LATEST_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLatestDate(Date newLatestDate) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__LATEST_DATE, newLatestDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLatestVersion() {
		return (String) eGet(StorePackage.Literals.BIM_SERVER_INFO__LATEST_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLatestVersion(String newLatestVersion) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__LATEST_VERSION, newLatestVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getProjects() {
		return (Integer) eGet(StorePackage.Literals.BIM_SERVER_INFO__PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProjects(int newProjects) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__PROJECTS, newProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRevisions() {
		return (Integer) eGet(StorePackage.Literals.BIM_SERVER_INFO__REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRevisions(int newRevisions) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__REVISIONS, newRevisions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getUsers() {
		return (Integer) eGet(StorePackage.Literals.BIM_SERVER_INFO__USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsers(int newUsers) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__USERS, newUsers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCheckouts() {
		return (Integer) eGet(StorePackage.Literals.BIM_SERVER_INFO__CHECKOUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCheckouts(int newCheckouts) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__CHECKOUTS, newCheckouts);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getServerLogUrl() {
		return (String) eGet(StorePackage.Literals.BIM_SERVER_INFO__SERVER_LOG_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServerLogUrl(String newServerLogUrl) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__SERVER_LOG_URL, newServerLogUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getStarted() {
		return (Date) eGet(StorePackage.Literals.BIM_SERVER_INFO__STARTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStarted(Date newStarted) {
		eSet(StorePackage.Literals.BIM_SERVER_INFO__STARTED, newStarted);
	}

} //BimServerInfoImpl
