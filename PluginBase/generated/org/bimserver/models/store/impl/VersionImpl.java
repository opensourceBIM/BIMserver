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
import org.bimserver.models.store.Version;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getMajor <em>Major</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getMinor <em>Minor</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getFullString <em>Full String</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getDownloadUrl <em>Download Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getSupportUrl <em>Support Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.VersionImpl#getSupportEmail <em>Support Email</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VersionImpl extends IdEObjectImpl implements Version {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.VERSION;
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
	public Integer getMajor() {
		return (Integer) eGet(StorePackage.Literals.VERSION__MAJOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMajor(Integer newMajor) {
		eSet(StorePackage.Literals.VERSION__MAJOR, newMajor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getMinor() {
		return (Integer) eGet(StorePackage.Literals.VERSION__MINOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinor(Integer newMinor) {
		eSet(StorePackage.Literals.VERSION__MINOR, newMinor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getRevision() {
		return (Integer) eGet(StorePackage.Literals.VERSION__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRevision(Integer newRevision) {
		eSet(StorePackage.Literals.VERSION__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFullString() {
		return (String) eGet(StorePackage.Literals.VERSION__FULL_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFullString(String newFullString) {
		eSet(StorePackage.Literals.VERSION__FULL_STRING, newFullString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return (Date) eGet(StorePackage.Literals.VERSION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		eSet(StorePackage.Literals.VERSION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDownloadUrl() {
		return (String) eGet(StorePackage.Literals.VERSION__DOWNLOAD_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDownloadUrl(String newDownloadUrl) {
		eSet(StorePackage.Literals.VERSION__DOWNLOAD_URL, newDownloadUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSupportUrl() {
		return (String) eGet(StorePackage.Literals.VERSION__SUPPORT_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupportUrl(String newSupportUrl) {
		eSet(StorePackage.Literals.VERSION__SUPPORT_URL, newSupportUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSupportEmail() {
		return (String) eGet(StorePackage.Literals.VERSION__SUPPORT_EMAIL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupportEmail(String newSupportEmail) {
		eSet(StorePackage.Literals.VERSION__SUPPORT_EMAIL, newSupportEmail);
	}

} //VersionImpl
