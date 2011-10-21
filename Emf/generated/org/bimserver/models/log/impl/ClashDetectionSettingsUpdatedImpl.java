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
package org.bimserver.models.log.impl;

import org.bimserver.models.log.ClashDetectionSettingsUpdated;
import org.bimserver.models.log.LogPackage;

import org.bimserver.models.store.ClashDetectionSettings;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clash Detection Settings Updated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl#getClashDetectionSettings <em>Clash Detection Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClashDetectionSettingsUpdatedImpl extends LogActionImpl implements ClashDetectionSettingsUpdated {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClashDetectionSettingsUpdatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.CLASH_DETECTION_SETTINGS_UPDATED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettings getClashDetectionSettings() {
		return (ClashDetectionSettings) eGet(LogPackage.Literals.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClashDetectionSettings(ClashDetectionSettings newClashDetectionSettings) {
		eSet(LogPackage.Literals.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS, newClashDetectionSettings);
	}

} //ClashDetectionSettingsUpdatedImpl
