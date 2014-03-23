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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.ProjectSmall;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Small</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getNrRevisions <em>Nr Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getNrSubProjects <em>Nr Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#isHasCheckinRights <em>Has Checkin Rights</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectSmallImpl#getLastRevisionId <em>Last Revision Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectSmallImpl extends IdEObjectImpl implements ProjectSmall {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectSmallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PROJECT_SMALL;
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
	public String getName() {
		return (String) eGet(StorePackage.Literals.PROJECT_SMALL__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.PROJECT_SMALL__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getParentId() {
		return (Long) eGet(StorePackage.Literals.PROJECT_SMALL__PARENT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentId(long newParentId) {
		eSet(StorePackage.Literals.PROJECT_SMALL__PARENT_ID, newParentId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState getState() {
		return (ObjectState) eGet(StorePackage.Literals.PROJECT_SMALL__STATE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ObjectState newState) {
		eSet(StorePackage.Literals.PROJECT_SMALL__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNrRevisions() {
		return (Integer) eGet(
				StorePackage.Literals.PROJECT_SMALL__NR_REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNrRevisions(int newNrRevisions) {
		eSet(StorePackage.Literals.PROJECT_SMALL__NR_REVISIONS, newNrRevisions);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNrSubProjects() {
		return (Integer) eGet(
				StorePackage.Literals.PROJECT_SMALL__NR_SUB_PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNrSubProjects(int newNrSubProjects) {
		eSet(StorePackage.Literals.PROJECT_SMALL__NR_SUB_PROJECTS,
				newNrSubProjects);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasCheckinRights() {
		return (Boolean) eGet(
				StorePackage.Literals.PROJECT_SMALL__HAS_CHECKIN_RIGHTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasCheckinRights(boolean newHasCheckinRights) {
		eSet(StorePackage.Literals.PROJECT_SMALL__HAS_CHECKIN_RIGHTS,
				newHasCheckinRights);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastRevisionId() {
		return (Long) eGet(
				StorePackage.Literals.PROJECT_SMALL__LAST_REVISION_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastRevisionId(long newLastRevisionId) {
		eSet(StorePackage.Literals.PROJECT_SMALL__LAST_REVISION_ID,
				newLastRevisionId);
	}

} //ProjectSmallImpl
