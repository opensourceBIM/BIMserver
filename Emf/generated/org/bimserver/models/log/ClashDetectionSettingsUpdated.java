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
package org.bimserver.models.log;

import org.bimserver.models.store.ClashDetectionSettings;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clash Detection Settings Updated</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings <em>Clash Detection Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.log.Ifc2x3tc1Package#getClashDetectionSettingsUpdated()
 * @model
 * @generated
 */
public interface ClashDetectionSettingsUpdated extends LogAction {
	/**
	 * Returns the value of the '<em><b>Clash Detection Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clash Detection Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clash Detection Settings</em>' reference.
	 * @see #setClashDetectionSettings(ClashDetectionSettings)
	 * @see org.bimserver.models.log.Ifc2x3tc1Package#getClashDetectionSettingsUpdated_ClashDetectionSettings()
	 * @model
	 * @generated
	 */
	ClashDetectionSettings getClashDetectionSettings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings <em>Clash Detection Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clash Detection Settings</em>' reference.
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	void setClashDetectionSettings(ClashDetectionSettings value);

} // ClashDetectionSettingsUpdated
