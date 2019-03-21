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

public interface InternalServicePluginConfiguration extends PluginConfiguration {
	/**
	 * Returns the value of the '<em><b>Remote Accessible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Accessible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Accessible</em>' attribute.
	 * @see #setRemoteAccessible(boolean)
	 * @see org.bimserver.models.store.StorePackage#getInternalServicePluginConfiguration_RemoteAccessible()
	 * @model
	 * @generated
	 */
	boolean isRemoteAccessible();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.InternalServicePluginConfiguration#isRemoteAccessible <em>Remote Accessible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Accessible</em>' attribute.
	 * @see #isRemoteAccessible()
	 * @generated
	 */
	void setRemoteAccessible(boolean value);

	/**
	 * Returns the value of the '<em><b>User Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.UserSettings#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Settings</em>' reference.
	 * @see #setUserSettings(UserSettings)
	 * @see org.bimserver.models.store.StorePackage#getInternalServicePluginConfiguration_UserSettings()
	 * @see org.bimserver.models.store.UserSettings#getServices
	 * @model opposite="services"
	 * @generated
	 */
	UserSettings getUserSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.InternalServicePluginConfiguration#getUserSettings <em>User Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Settings</em>' reference.
	 * @see #getUserSettings()
	 * @generated
	 */
	void setUserSettings(UserSettings value);

	/**
	 * Returns the value of the '<em><b>Public Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Profile</em>' attribute.
	 * @see #setPublicProfile(boolean)
	 * @see org.bimserver.models.store.StorePackage#getInternalServicePluginConfiguration_PublicProfile()
	 * @model
	 * @generated
	 */
	boolean isPublicProfile();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.InternalServicePluginConfiguration#isPublicProfile <em>Public Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Profile</em>' attribute.
	 * @see #isPublicProfile()
	 * @generated
	 */
	void setPublicProfile(boolean value);

} // InternalServicePluginConfiguration
