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

public interface WebModulePluginConfiguration extends PluginConfiguration {
	/**
	 * Returns the value of the '<em><b>Server Settings</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ServerSettings#getWebModules <em>Web Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Settings</em>' reference.
	 * @see #setServerSettings(ServerSettings)
	 * @see org.bimserver.models.store.StorePackage#getWebModulePluginConfiguration_ServerSettings()
	 * @see org.bimserver.models.store.ServerSettings#getWebModules
	 * @model opposite="webModules"
	 * @generated
	 */
	ServerSettings getServerSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.WebModulePluginConfiguration#getServerSettings <em>Server Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Settings</em>' reference.
	 * @see #getServerSettings()
	 * @generated
	 */
	void setServerSettings(ServerSettings value);

} // WebModulePluginConfiguration
