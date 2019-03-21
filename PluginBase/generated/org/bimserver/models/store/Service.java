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

import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.Service#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getServiceIdentifier <em>Service Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getNotificationProtocol <em>Notification Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getProfileIdentifier <em>Profile Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getProfileDescription <em>Profile Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#isProfilePublic <em>Profile Public</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getProject <em>Project</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getUser <em>User</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getInternalService <em>Internal Service</em>}</li>
 *   <li>{@link org.bimserver.models.store.Service#getModelCheckers <em>Model Checkers</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getService()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Service extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.store.StorePackage#getService_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ServiceName()
	 * @model
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Service Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Identifier</em>' attribute.
	 * @see #setServiceIdentifier(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ServiceIdentifier()
	 * @model
	 * @generated
	 */
	String getServiceIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getServiceIdentifier <em>Service Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Identifier</em>' attribute.
	 * @see #getServiceIdentifier()
	 * @generated
	 */
	void setServiceIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Name</em>' attribute.
	 * @see #setProviderName(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ProviderName()
	 * @model
	 * @generated
	 */
	String getProviderName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getProviderName <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Name</em>' attribute.
	 * @see #getProviderName()
	 * @generated
	 */
	void setProviderName(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getService_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' attribute.
	 * @see #setToken(String)
	 * @see org.bimserver.models.store.StorePackage#getService_Token()
	 * @model
	 * @generated
	 */
	String getToken();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getToken <em>Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' attribute.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(String value);

	/**
	 * Returns the value of the '<em><b>Notification Protocol</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.log.AccessMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification Protocol</em>' attribute.
	 * @see org.bimserver.models.log.AccessMethod
	 * @see #setNotificationProtocol(AccessMethod)
	 * @see org.bimserver.models.store.StorePackage#getService_NotificationProtocol()
	 * @model
	 * @generated
	 */
	AccessMethod getNotificationProtocol();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getNotificationProtocol <em>Notification Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification Protocol</em>' attribute.
	 * @see org.bimserver.models.log.AccessMethod
	 * @see #getNotificationProtocol()
	 * @generated
	 */
	void setNotificationProtocol(AccessMethod value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getService_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.Trigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see org.bimserver.models.store.Trigger
	 * @see #setTrigger(Trigger)
	 * @see org.bimserver.models.store.StorePackage#getService_Trigger()
	 * @model
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see org.bimserver.models.store.Trigger
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Read Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Revision</em>' attribute.
	 * @see #setReadRevision(boolean)
	 * @see org.bimserver.models.store.StorePackage#getService_ReadRevision()
	 * @model
	 * @generated
	 */
	boolean isReadRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#isReadRevision <em>Read Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Revision</em>' attribute.
	 * @see #isReadRevision()
	 * @generated
	 */
	void setReadRevision(boolean value);

	/**
	 * Returns the value of the '<em><b>Read Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Extended Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Extended Data</em>' reference.
	 * @see #setReadExtendedData(ExtendedDataSchema)
	 * @see org.bimserver.models.store.StorePackage#getService_ReadExtendedData()
	 * @model
	 * @generated
	 */
	ExtendedDataSchema getReadExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getReadExtendedData <em>Read Extended Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Extended Data</em>' reference.
	 * @see #getReadExtendedData()
	 * @generated
	 */
	void setReadExtendedData(ExtendedDataSchema value);

	/**
	 * Returns the value of the '<em><b>Write Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Revision</em>' reference.
	 * @see #setWriteRevision(Project)
	 * @see org.bimserver.models.store.StorePackage#getService_WriteRevision()
	 * @model
	 * @generated
	 */
	Project getWriteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getWriteRevision <em>Write Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Revision</em>' reference.
	 * @see #getWriteRevision()
	 * @generated
	 */
	void setWriteRevision(Project value);

	/**
	 * Returns the value of the '<em><b>Write Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Extended Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Extended Data</em>' reference.
	 * @see #setWriteExtendedData(ExtendedDataSchema)
	 * @see org.bimserver.models.store.StorePackage#getService_WriteExtendedData()
	 * @model
	 * @generated
	 */
	ExtendedDataSchema getWriteExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getWriteExtendedData <em>Write Extended Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Extended Data</em>' reference.
	 * @see #getWriteExtendedData()
	 * @generated
	 */
	void setWriteExtendedData(ExtendedDataSchema value);

	/**
	 * Returns the value of the '<em><b>Profile Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Identifier</em>' attribute.
	 * @see #setProfileIdentifier(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ProfileIdentifier()
	 * @model
	 * @generated
	 */
	String getProfileIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getProfileIdentifier <em>Profile Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Identifier</em>' attribute.
	 * @see #getProfileIdentifier()
	 * @generated
	 */
	void setProfileIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Name</em>' attribute.
	 * @see #setProfileName(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ProfileName()
	 * @model
	 * @generated
	 */
	String getProfileName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getProfileName <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Name</em>' attribute.
	 * @see #getProfileName()
	 * @generated
	 */
	void setProfileName(String value);

	/**
	 * Returns the value of the '<em><b>Profile Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Description</em>' attribute.
	 * @see #setProfileDescription(String)
	 * @see org.bimserver.models.store.StorePackage#getService_ProfileDescription()
	 * @model
	 * @generated
	 */
	String getProfileDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getProfileDescription <em>Profile Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Description</em>' attribute.
	 * @see #getProfileDescription()
	 * @generated
	 */
	void setProfileDescription(String value);

	/**
	 * Returns the value of the '<em><b>Profile Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile Public</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile Public</em>' attribute.
	 * @see #setProfilePublic(boolean)
	 * @see org.bimserver.models.store.StorePackage#getService_ProfilePublic()
	 * @model
	 * @generated
	 */
	boolean isProfilePublic();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#isProfilePublic <em>Profile Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Public</em>' attribute.
	 * @see #isProfilePublic()
	 * @generated
	 */
	void setProfilePublic(boolean value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getService_Project()
	 * @see org.bimserver.models.store.Project#getServices
	 * @model opposite="services"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.User#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see org.bimserver.models.store.StorePackage#getService_User()
	 * @see org.bimserver.models.store.User#getServices
	 * @model opposite="services"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Internal Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Service</em>' reference.
	 * @see #setInternalService(InternalServicePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getService_InternalService()
	 * @model
	 * @generated
	 */
	InternalServicePluginConfiguration getInternalService();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Service#getInternalService <em>Internal Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Service</em>' reference.
	 * @see #getInternalService()
	 * @generated
	 */
	void setInternalService(InternalServicePluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Model Checkers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ModelCheckerInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Checkers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Checkers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getService_ModelCheckers()
	 * @model
	 * @generated
	 */
	EList<ModelCheckerInstance> getModelCheckers();

} // Service
