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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.Trigger;
import org.bimserver.models.store.User;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getServiceIdentifier <em>Service Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getNotificationProtocol <em>Notification Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getProfileIdentifier <em>Profile Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getProfileDescription <em>Profile Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#isProfilePublic <em>Profile Public</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getInternalService <em>Internal Service</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.ServiceImpl#getModelCheckers <em>Model Checkers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl extends IdEObjectImpl implements Service {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERVICE;
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
	public String getName() {
		return (String) eGet(StorePackage.Literals.SERVICE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(StorePackage.Literals.SERVICE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getServiceName() {
		return (String) eGet(StorePackage.Literals.SERVICE__SERVICE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServiceName(String newServiceName) {
		eSet(StorePackage.Literals.SERVICE__SERVICE_NAME, newServiceName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getServiceIdentifier() {
		return (String) eGet(StorePackage.Literals.SERVICE__SERVICE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServiceIdentifier(String newServiceIdentifier) {
		eSet(StorePackage.Literals.SERVICE__SERVICE_IDENTIFIER, newServiceIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProviderName() {
		return (String) eGet(StorePackage.Literals.SERVICE__PROVIDER_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProviderName(String newProviderName) {
		eSet(StorePackage.Literals.SERVICE__PROVIDER_NAME, newProviderName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUrl() {
		return (String) eGet(StorePackage.Literals.SERVICE__URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUrl(String newUrl) {
		eSet(StorePackage.Literals.SERVICE__URL, newUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getToken() {
		return (String) eGet(StorePackage.Literals.SERVICE__TOKEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToken(String newToken) {
		eSet(StorePackage.Literals.SERVICE__TOKEN, newToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessMethod getNotificationProtocol() {
		return (AccessMethod) eGet(StorePackage.Literals.SERVICE__NOTIFICATION_PROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNotificationProtocol(AccessMethod newNotificationProtocol) {
		eSet(StorePackage.Literals.SERVICE__NOTIFICATION_PROTOCOL, newNotificationProtocol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(StorePackage.Literals.SERVICE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(StorePackage.Literals.SERVICE__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Trigger getTrigger() {
		return (Trigger) eGet(StorePackage.Literals.SERVICE__TRIGGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTrigger(Trigger newTrigger) {
		eSet(StorePackage.Literals.SERVICE__TRIGGER, newTrigger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReadRevision() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE__READ_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadRevision(boolean newReadRevision) {
		eSet(StorePackage.Literals.SERVICE__READ_REVISION, newReadRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedDataSchema getReadExtendedData() {
		return (ExtendedDataSchema) eGet(StorePackage.Literals.SERVICE__READ_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadExtendedData(ExtendedDataSchema newReadExtendedData) {
		eSet(StorePackage.Literals.SERVICE__READ_EXTENDED_DATA, newReadExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getWriteRevision() {
		return (Project) eGet(StorePackage.Literals.SERVICE__WRITE_REVISION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWriteRevision(Project newWriteRevision) {
		eSet(StorePackage.Literals.SERVICE__WRITE_REVISION, newWriteRevision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedDataSchema getWriteExtendedData() {
		return (ExtendedDataSchema) eGet(StorePackage.Literals.SERVICE__WRITE_EXTENDED_DATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWriteExtendedData(ExtendedDataSchema newWriteExtendedData) {
		eSet(StorePackage.Literals.SERVICE__WRITE_EXTENDED_DATA, newWriteExtendedData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfileIdentifier() {
		return (String) eGet(StorePackage.Literals.SERVICE__PROFILE_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileIdentifier(String newProfileIdentifier) {
		eSet(StorePackage.Literals.SERVICE__PROFILE_IDENTIFIER, newProfileIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfileName() {
		return (String) eGet(StorePackage.Literals.SERVICE__PROFILE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileName(String newProfileName) {
		eSet(StorePackage.Literals.SERVICE__PROFILE_NAME, newProfileName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProfileDescription() {
		return (String) eGet(StorePackage.Literals.SERVICE__PROFILE_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfileDescription(String newProfileDescription) {
		eSet(StorePackage.Literals.SERVICE__PROFILE_DESCRIPTION, newProfileDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isProfilePublic() {
		return (Boolean) eGet(StorePackage.Literals.SERVICE__PROFILE_PUBLIC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfilePublic(boolean newProfilePublic) {
		eSet(StorePackage.Literals.SERVICE__PROFILE_PUBLIC, newProfilePublic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project getProject() {
		return (Project) eGet(StorePackage.Literals.SERVICE__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProject(Project newProject) {
		eSet(StorePackage.Literals.SERVICE__PROJECT, newProject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User getUser() {
		return (User) eGet(StorePackage.Literals.SERVICE__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUser(User newUser) {
		eSet(StorePackage.Literals.SERVICE__USER, newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InternalServicePluginConfiguration getInternalService() {
		return (InternalServicePluginConfiguration) eGet(StorePackage.Literals.SERVICE__INTERNAL_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalService(InternalServicePluginConfiguration newInternalService) {
		eSet(StorePackage.Literals.SERVICE__INTERNAL_SERVICE, newInternalService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ModelCheckerInstance> getModelCheckers() {
		return (EList<ModelCheckerInstance>) eGet(StorePackage.Literals.SERVICE__MODEL_CHECKERS, true);
	}

} //ServiceImpl
