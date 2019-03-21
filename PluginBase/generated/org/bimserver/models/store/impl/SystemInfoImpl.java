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
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.SystemInfo;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getCpucores <em>Cpucores</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getDatetime <em>Datetime</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getOsname <em>Osname</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getOsversion <em>Osversion</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getUserHome <em>User Home</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.SystemInfoImpl#getUserDir <em>User Dir</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemInfoImpl extends IdEObjectImpl implements SystemInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SYSTEM_INFO;
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
	public int getCpucores() {
		return (Integer) eGet(StorePackage.Literals.SYSTEM_INFO__CPUCORES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCpucores(int newCpucores) {
		eSet(StorePackage.Literals.SYSTEM_INFO__CPUCORES, newCpucores);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDatetime() {
		return (Date) eGet(StorePackage.Literals.SYSTEM_INFO__DATETIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDatetime(Date newDatetime) {
		eSet(StorePackage.Literals.SYSTEM_INFO__DATETIME, newDatetime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOsname() {
		return (String) eGet(StorePackage.Literals.SYSTEM_INFO__OSNAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOsname(String newOsname) {
		eSet(StorePackage.Literals.SYSTEM_INFO__OSNAME, newOsname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOsversion() {
		return (String) eGet(StorePackage.Literals.SYSTEM_INFO__OSVERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOsversion(String newOsversion) {
		eSet(StorePackage.Literals.SYSTEM_INFO__OSVERSION, newOsversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserName() {
		return (String) eGet(StorePackage.Literals.SYSTEM_INFO__USER_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserName(String newUserName) {
		eSet(StorePackage.Literals.SYSTEM_INFO__USER_NAME, newUserName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserHome() {
		return (String) eGet(StorePackage.Literals.SYSTEM_INFO__USER_HOME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserHome(String newUserHome) {
		eSet(StorePackage.Literals.SYSTEM_INFO__USER_HOME, newUserHome);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUserDir() {
		return (String) eGet(StorePackage.Literals.SYSTEM_INFO__USER_DIR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserDir(String newUserDir) {
		eSet(StorePackage.Literals.SYSTEM_INFO__USER_DIR, newUserDir);
	}

} //SystemInfoImpl
