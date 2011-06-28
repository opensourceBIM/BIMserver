/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
		return (ClashDetectionSettings)eGet(LogPackage.Literals.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS, true);
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
