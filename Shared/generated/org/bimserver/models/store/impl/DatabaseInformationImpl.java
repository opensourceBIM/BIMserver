/**
 * Copyright (C) 2009-2013 BIMserver.org
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

import java.util.Date;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DatabaseInformationCategory;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getNumberOfProjects <em>Number Of Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getNumberOfUsers <em>Number Of Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getNumberOfRevisions <em>Number Of Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getNumberOfCheckouts <em>Number Of Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getSchemaVersion <em>Schema Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DatabaseInformationImpl#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseInformationImpl extends IdEObjectImpl implements
		DatabaseInformation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatabaseInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.DATABASE_INFORMATION;
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
	public Integer getNumberOfProjects() {
		return (Integer) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_PROJECTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfProjects(Integer newNumberOfProjects) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_PROJECTS,
				newNumberOfProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumberOfUsers() {
		return (Integer) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_USERS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfUsers(Integer newNumberOfUsers) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_USERS,
				newNumberOfUsers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumberOfRevisions() {
		return (Integer) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_REVISIONS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRevisions(Integer newNumberOfRevisions) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_REVISIONS,
				newNumberOfRevisions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumberOfCheckouts() {
		return (Integer) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_CHECKOUTS,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfCheckouts(Integer newNumberOfCheckouts) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__NUMBER_OF_CHECKOUTS,
				newNumberOfCheckouts);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getDatabaseSizeInBytes() {
		return (Long) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__DATABASE_SIZE_IN_BYTES,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseSizeInBytes(Long newDatabaseSizeInBytes) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__DATABASE_SIZE_IN_BYTES,
				newDatabaseSizeInBytes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String) eGet(StorePackage.Literals.DATABASE_INFORMATION__TYPE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return (Date) eGet(StorePackage.Literals.DATABASE_INFORMATION__CREATED,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__CREATED, newCreated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return (String) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSchemaVersion() {
		return (Integer) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__SCHEMA_VERSION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaVersion(Integer newSchemaVersion) {
		eSet(StorePackage.Literals.DATABASE_INFORMATION__SCHEMA_VERSION,
				newSchemaVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DatabaseInformationCategory> getCategories() {
		return (EList<DatabaseInformationCategory>) eGet(
				StorePackage.Literals.DATABASE_INFORMATION__CATEGORIES, true);
	}

} //DatabaseInformationImpl
