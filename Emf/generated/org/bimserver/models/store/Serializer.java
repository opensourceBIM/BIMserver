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
 * A representation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Serializer#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getObjectIDM <em>Object IDM</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getIfcEngine <em>Ifc Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSerializer()
 * @model
 * @generated
 */
public interface Serializer extends Plugin {
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
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getExtension <em>Extension</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getSerializer_ContentType()
	 * @model
	 * @generated
	 */
	String getContentType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getContentType <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Type</em>' attribute.
	 * @see #getContentType()
	 * @generated
	 */
	void setContentType(String value);

	/**
	 * Returns the value of the '<em><b>Object IDM</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ObjectIDM#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object IDM</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object IDM</em>' reference.
	 * @see #setObjectIDM(ObjectIDM)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_ObjectIDM()
	 * @see org.bimserver.models.store.ObjectIDM#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	ObjectIDM getObjectIDM();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getObjectIDM <em>Object IDM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object IDM</em>' reference.
	 * @see #getObjectIDM()
	 * @generated
	 */
	void setObjectIDM(ObjectIDM value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.UserSettings#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(UserSettings)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Settings()
	 * @see org.bimserver.models.store.UserSettings#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	UserSettings getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(UserSettings value);

	/**
	 * Returns the value of the '<em><b>Ifc Engine</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IfcEngine#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Engine</em>' reference.
	 * @see #setIfcEngine(IfcEngine)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_IfcEngine()
	 * @see org.bimserver.models.store.IfcEngine#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	IfcEngine getIfcEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getIfcEngine <em>Ifc Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifc Engine</em>' reference.
	 * @see #getIfcEngine()
	 * @generated
	 */
	void setIfcEngine(IfcEngine value);

} // Serializer
