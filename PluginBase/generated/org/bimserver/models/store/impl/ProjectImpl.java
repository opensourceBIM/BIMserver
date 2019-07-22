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
import org.bimserver.models.log.ProjectRelated;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getHasAuthorizedUsers <em>Has Authorized Users</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getConcreteRevisions <em>Concrete Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getLastConcreteRevision <em>Last Concrete Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getLastRevision <em>Last Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getCheckouts <em>Checkouts</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getState <em>State</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getCreatedDate <em>Created Date</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getGeoTag <em>Geo Tag</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getSubProjects <em>Sub Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getExportLengthMeasurePrefix <em>Export Length Measure Prefix</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getLogs <em>Logs</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getModelCheckers <em>Model Checkers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getNewServices <em>New Services</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ProjectImpl#getCheckinInProgress <em>Checkin In Progress</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends IdEObjectImpl implements Project {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.PROJECT;
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
	public Integer getId() {
		return (Integer) eGet(StorePackage.Literals.PROJECT__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(Integer newId) {
		eSet(StorePackage.Literals.PROJECT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(StorePackage.Literals.PROJECT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.PROJECT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<User> getHasAuthorizedUsers() {
		return (EList<User>) eGet(StorePackage.Literals.PROJECT__HAS_AUTHORIZED_USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ConcreteRevision> getConcreteRevisions() {
		return (EList<ConcreteRevision>) eGet(StorePackage.Literals.PROJECT__CONCRETE_REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Revision> getRevisions() {
		return (EList<Revision>) eGet(StorePackage.Literals.PROJECT__REVISIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConcreteRevision getLastConcreteRevision() {
		return (ConcreteRevision) eGet(StorePackage.Literals.PROJECT__LAST_CONCRETE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastConcreteRevision(ConcreteRevision newLastConcreteRevision) {
		eSet(StorePackage.Literals.PROJECT__LAST_CONCRETE_REVISION, newLastConcreteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Revision getLastRevision() {
		return (Revision) eGet(StorePackage.Literals.PROJECT__LAST_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastRevision(Revision newLastRevision) {
		eSet(StorePackage.Literals.PROJECT__LAST_REVISION, newLastRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Checkout> getCheckouts() {
		return (EList<Checkout>) eGet(StorePackage.Literals.PROJECT__CHECKOUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectState getState() {
		return (ObjectState) eGet(StorePackage.Literals.PROJECT__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(ObjectState newState) {
		eSet(StorePackage.Literals.PROJECT__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getCreatedDate() {
		return (Date) eGet(StorePackage.Literals.PROJECT__CREATED_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedDate(Date newCreatedDate) {
		eSet(StorePackage.Literals.PROJECT__CREATED_DATE, newCreatedDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User getCreatedBy() {
		return (User) eGet(StorePackage.Literals.PROJECT__CREATED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedBy(User newCreatedBy) {
		eSet(StorePackage.Literals.PROJECT__CREATED_BY, newCreatedBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeoTag getGeoTag() {
		return (GeoTag) eGet(StorePackage.Literals.PROJECT__GEO_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeoTag(GeoTag newGeoTag) {
		eSet(StorePackage.Literals.PROJECT__GEO_TAG, newGeoTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Project> getSubProjects() {
		return (EList<Project>) eGet(StorePackage.Literals.PROJECT__SUB_PROJECTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getParent() {
		return (Project) eGet(StorePackage.Literals.PROJECT__PARENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(Project newParent) {
		eSet(StorePackage.Literals.PROJECT__PARENT, newParent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.PROJECT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.PROJECT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SIPrefix getExportLengthMeasurePrefix() {
		return (SIPrefix) eGet(StorePackage.Literals.PROJECT__EXPORT_LENGTH_MEASURE_PREFIX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExportLengthMeasurePrefix(SIPrefix newExportLengthMeasurePrefix) {
		eSet(StorePackage.Literals.PROJECT__EXPORT_LENGTH_MEASURE_PREFIX, newExportLengthMeasurePrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ExtendedData> getExtendedData() {
		return (EList<ExtendedData>) eGet(StorePackage.Literals.PROJECT__EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Service> getServices() {
		return (EList<Service>) eGet(StorePackage.Literals.PROJECT__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ProjectRelated> getLogs() {
		return (EList<ProjectRelated>) eGet(StorePackage.Literals.PROJECT__LOGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ModelCheckerInstance> getModelCheckers() {
		return (EList<ModelCheckerInstance>) eGet(StorePackage.Literals.PROJECT__MODEL_CHECKERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSchema() {
		return (String) eGet(StorePackage.Literals.PROJECT__SCHEMA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchema(String newSchema) {
		eSet(StorePackage.Literals.PROJECT__SCHEMA, newSchema);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSendEmailOnNewRevision() {
		return (Boolean) eGet(StorePackage.Literals.PROJECT__SEND_EMAIL_ON_NEW_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSendEmailOnNewRevision(boolean newSendEmailOnNewRevision) {
		eSet(StorePackage.Literals.PROJECT__SEND_EMAIL_ON_NEW_REVISION, newSendEmailOnNewRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<NewService> getNewServices() {
		return (EList<NewService>) eGet(StorePackage.Literals.PROJECT__NEW_SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCheckinInProgress() {
		return (Long) eGet(StorePackage.Literals.PROJECT__CHECKIN_IN_PROGRESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCheckinInProgress(long newCheckinInProgress) {
		eSet(StorePackage.Literals.PROJECT__CHECKIN_IN_PROGRESS, newCheckinInProgress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

} //ProjectImpl
