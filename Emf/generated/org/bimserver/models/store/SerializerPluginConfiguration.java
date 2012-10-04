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
package org.bimserver.models.store;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serializer Plugin Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.SerializerPluginConfiguration#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginConfiguration#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginConfiguration#getObjectIDM <em>Object IDM</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginConfiguration#getUserSettings <em>User Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.SerializerPluginConfiguration#getIfcEngine <em>Ifc Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration()
 * @model
 * @generated
 */
public interface SerializerPluginConfiguration extends PluginConfiguration {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginConfiguration#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Type</em>' attribute.
	 * @see #setContentType(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginConfiguration#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Object IDM</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object IDM</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object IDM</em>' reference.
	 * @see #setObjectIDM(ObjectIDMPluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration_ObjectIDM()
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	ObjectIDMPluginConfiguration getObjectIDM();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginConfiguration#getObjectIDM <em>Object IDM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object IDM</em>' reference.
	 * @see #getObjectIDM()
	 * @generated
	 */
	void setObjectIDM(ObjectIDMPluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>User Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.UserSettings#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Settings</em>' reference.
	 * @see #setUserSettings(UserSettings)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration_UserSettings()
	 * @see org.bimserver.models.store.UserSettings#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	UserSettings getUserSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginConfiguration#getUserSettings <em>User Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Settings</em>' reference.
	 * @see #getUserSettings()
	 * @generated
	 */
	void setUserSettings(UserSettings value);

	/**
	 * Returns the value of the '<em><b>Ifc Engine</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IfcEnginePluginConfiguration#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Engine</em>' reference.
	 * @see #setIfcEngine(IfcEnginePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getSerializerPluginConfiguration_IfcEngine()
	 * @see org.bimserver.models.store.IfcEnginePluginConfiguration#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	IfcEnginePluginConfiguration getIfcEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.SerializerPluginConfiguration#getIfcEngine <em>Ifc Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Engine</em>' reference.
	 * @see #getIfcEngine()
	 * @generated
	 */
	void setIfcEngine(IfcEnginePluginConfiguration value);

} // SerializerPluginConfiguration
