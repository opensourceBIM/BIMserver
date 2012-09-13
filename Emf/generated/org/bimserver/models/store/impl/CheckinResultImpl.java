/**
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinStatus;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Checkin Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.CheckinResultImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckinResultImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckinResultImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckinResultImpl#getLastError <em>Last Error</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.CheckinResultImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckinResultImpl extends IdEObjectImpl implements CheckinResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckinResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.CHECKIN_RESULT;
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
	public Revision getRevision() {
		return (Revision) eGet(StorePackage.Literals.CHECKIN_RESULT__REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(Revision newRevision) {
		eSet(StorePackage.Literals.CHECKIN_RESULT__REVISION, newRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.CHECKIN_RESULT__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.CHECKIN_RESULT__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getProgress() {
		return (Integer) eGet(StorePackage.Literals.CHECKIN_RESULT__PROGRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgress(Integer newProgress) {
		eSet(StorePackage.Literals.CHECKIN_RESULT__PROGRESS, newProgress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastError() {
		return (String) eGet(StorePackage.Literals.CHECKIN_RESULT__LAST_ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastError(String newLastError) {
		eSet(StorePackage.Literals.CHECKIN_RESULT__LAST_ERROR, newLastError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinStatus getStatus() {
		return (CheckinStatus) eGet(StorePackage.Literals.CHECKIN_RESULT__STATUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(CheckinStatus newStatus) {
		eSet(StorePackage.Literals.CHECKIN_RESULT__STATUS, newStatus);
	}

} //CheckinResultImpl
