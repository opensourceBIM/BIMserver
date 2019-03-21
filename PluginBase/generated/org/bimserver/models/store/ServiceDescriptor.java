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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getUrl <em>Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getToken <em>Token</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getNotificationProtocol <em>Notification Protocol</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#isWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getCompanyUrl <em>Company Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getTokenUrl <em>Token Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getNewProfileUrl <em>New Profile Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getRegisterUrl <em>Register Url</em>}</li>
 *   <li>{@link org.bimserver.models.store.ServiceDescriptor#getAuthorizeUrl <em>Authorize Url</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor()
 * @model annotation="nodatabase"
 * @extends IdEObject
 * @generated
 */
public interface ServiceDescriptor extends IdEObject {
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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getUrl <em>Url</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Token()
	 * @model
	 * @generated
	 */
	String getToken();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getToken <em>Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' attribute.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_NotificationProtocol()
	 * @model
	 * @generated
	 */
	AccessMethod getNotificationProtocol();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getNotificationProtocol <em>Notification Protocol</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getDescription <em>Description</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_Trigger()
	 * @model
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getTrigger <em>Trigger</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_ReadRevision()
	 * @model
	 * @generated
	 */
	boolean isReadRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#isReadRevision <em>Read Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Revision</em>' attribute.
	 * @see #isReadRevision()
	 * @generated
	 */
	void setReadRevision(boolean value);

	/**
	 * Returns the value of the '<em><b>Read Extended Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Extended Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Extended Data</em>' attribute.
	 * @see #setReadExtendedData(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_ReadExtendedData()
	 * @model
	 * @generated
	 */
	String getReadExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getReadExtendedData <em>Read Extended Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Extended Data</em>' attribute.
	 * @see #getReadExtendedData()
	 * @generated
	 */
	void setReadExtendedData(String value);

	/**
	 * Returns the value of the '<em><b>Write Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Revision</em>' attribute.
	 * @see #setWriteRevision(boolean)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_WriteRevision()
	 * @model
	 * @generated
	 */
	boolean isWriteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#isWriteRevision <em>Write Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Revision</em>' attribute.
	 * @see #isWriteRevision()
	 * @generated
	 */
	void setWriteRevision(boolean value);

	/**
	 * Returns the value of the '<em><b>Write Extended Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Extended Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Extended Data</em>' attribute.
	 * @see #setWriteExtendedData(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_WriteExtendedData()
	 * @model
	 * @generated
	 */
	String getWriteExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getWriteExtendedData <em>Write Extended Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Extended Data</em>' attribute.
	 * @see #getWriteExtendedData()
	 * @generated
	 */
	void setWriteExtendedData(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_ProviderName()
	 * @model
	 * @generated
	 */
	String getProviderName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getProviderName <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider Name</em>' attribute.
	 * @see #getProviderName()
	 * @generated
	 */
	void setProviderName(String value);

	/**
	 * Returns the value of the '<em><b>Company Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company Url</em>' attribute.
	 * @see #setCompanyUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_CompanyUrl()
	 * @model
	 * @generated
	 */
	String getCompanyUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getCompanyUrl <em>Company Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Url</em>' attribute.
	 * @see #getCompanyUrl()
	 * @generated
	 */
	void setCompanyUrl(String value);

	/**
	 * Returns the value of the '<em><b>Token Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Url</em>' attribute.
	 * @see #setTokenUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_TokenUrl()
	 * @model
	 * @generated
	 */
	String getTokenUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getTokenUrl <em>Token Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Url</em>' attribute.
	 * @see #getTokenUrl()
	 * @generated
	 */
	void setTokenUrl(String value);

	/**
	 * Returns the value of the '<em><b>New Profile Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Profile Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Profile Url</em>' attribute.
	 * @see #setNewProfileUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_NewProfileUrl()
	 * @model
	 * @generated
	 */
	String getNewProfileUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getNewProfileUrl <em>New Profile Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Profile Url</em>' attribute.
	 * @see #getNewProfileUrl()
	 * @generated
	 */
	void setNewProfileUrl(String value);

	/**
	 * Returns the value of the '<em><b>Register Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Register Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Register Url</em>' attribute.
	 * @see #setRegisterUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_RegisterUrl()
	 * @model
	 * @generated
	 */
	String getRegisterUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getRegisterUrl <em>Register Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Register Url</em>' attribute.
	 * @see #getRegisterUrl()
	 * @generated
	 */
	void setRegisterUrl(String value);

	/**
	 * Returns the value of the '<em><b>Authorize Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authorize Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authorize Url</em>' attribute.
	 * @see #setAuthorizeUrl(String)
	 * @see org.bimserver.models.store.StorePackage#getServiceDescriptor_AuthorizeUrl()
	 * @model
	 * @generated
	 */
	String getAuthorizeUrl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ServiceDescriptor#getAuthorizeUrl <em>Authorize Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorize Url</em>' attribute.
	 * @see #getAuthorizeUrl()
	 * @generated
	 */
	void setAuthorizeUrl(String value);

} // ServiceDescriptor
