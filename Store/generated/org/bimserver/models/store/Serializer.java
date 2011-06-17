/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Serializer#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#isDefaultSerializer <em>Default Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getIgnoreFile <em>Ignore File</em>}</li>
 *   <li>{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getSerializer()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Serializer extends IdEObject
{
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
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Serializer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Serializer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Serializer</em>' attribute.
	 * @see #setDefaultSerializer(boolean)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_DefaultSerializer()
	 * @model
	 * @generated
	 */
	boolean isDefaultSerializer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#isDefaultSerializer <em>Default Serializer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Serializer</em>' attribute.
	 * @see #isDefaultSerializer()
	 * @generated
	 */
	void setDefaultSerializer(boolean value);

	/**
	 * Returns the value of the '<em><b>Ignore File</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IgnoreFile#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore File</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore File</em>' reference.
	 * @see #setIgnoreFile(IgnoreFile)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_IgnoreFile()
	 * @see org.bimserver.models.store.IgnoreFile#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	IgnoreFile getIgnoreFile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getIgnoreFile <em>Ignore File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore File</em>' reference.
	 * @see #getIgnoreFile()
	 * @generated
	 */
	void setIgnoreFile(IgnoreFile value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Settings#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference.
	 * @see #setSettings(Settings)
	 * @see org.bimserver.models.store.StorePackage#getSerializer_Settings()
	 * @see org.bimserver.models.store.Settings#getSerializers
	 * @model opposite="serializers"
	 * @generated
	 */
	Settings getSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(Settings value);

} // Serializer
