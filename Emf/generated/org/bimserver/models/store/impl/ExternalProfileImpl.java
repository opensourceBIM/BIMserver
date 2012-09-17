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

import org.bimserver.models.store.ExternalProfile;
import org.bimserver.models.store.ExternalServer;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getServer <em>Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#isReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ExternalProfileImpl#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalProfileImpl extends IdEObjectImpl implements ExternalProfile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalProfileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.EXTERNAL_PROFILE;
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
	public ExternalServer getServer() {
		return (ExternalServer) eGet(StorePackage.Literals.EXTERNAL_PROFILE__SERVER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServer(ExternalServer newServer) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__SERVER, newServer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(StorePackage.Literals.EXTERNAL_PROFILE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.EXTERNAL_PROFILE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadRevision() {
		return (Boolean) eGet(StorePackage.Literals.EXTERNAL_PROFILE__READ_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadRevision(boolean newReadRevision) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__READ_REVISION, newReadRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadExtendedData() {
		return (Boolean) eGet(StorePackage.Literals.EXTERNAL_PROFILE__READ_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadExtendedData(boolean newReadExtendedData) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__READ_EXTENDED_DATA, newReadExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getWriteRevision() {
		return (Project) eGet(StorePackage.Literals.EXTERNAL_PROFILE__WRITE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteRevision(Project newWriteRevision) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__WRITE_REVISION, newWriteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getWriteExtendedData() {
		return (Project) eGet(StorePackage.Literals.EXTERNAL_PROFILE__WRITE_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteExtendedData(Project newWriteExtendedData) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__WRITE_EXTENDED_DATA, newWriteExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.EXTERNAL_PROFILE__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.EXTERNAL_PROFILE__PROJECT, newProject);
	}

} //ExternalProfileImpl
