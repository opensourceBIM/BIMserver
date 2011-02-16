/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log.impl;

import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.log.ClashDetectionSettingsUpdated;
import org.bimserver.database.store.log.LogPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clash Detection Settings Updated</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.database.store.log.impl.ClashDetectionSettingsUpdatedImpl#getClashDetectionSettings <em>Clash Detection Settings</em>}</li>
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
