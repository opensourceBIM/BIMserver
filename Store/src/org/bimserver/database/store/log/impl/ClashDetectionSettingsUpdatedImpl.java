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
	public ClashDetectionSettingsUpdatedImpl() {
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
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings)eVirtualGet(LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS);
		if (clashDetectionSettings != null && ((EObject)clashDetectionSettings).eIsProxy()) {
			InternalEObject oldClashDetectionSettings = (InternalEObject)clashDetectionSettings;
			clashDetectionSettings = (ClashDetectionSettings)eResolveProxy(oldClashDetectionSettings);
			if (clashDetectionSettings != oldClashDetectionSettings) {
				eVirtualSet(LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS, clashDetectionSettings);
			}
		}
		return clashDetectionSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettings basicGetClashDetectionSettings() {
		return (ClashDetectionSettings)eVirtualGet(LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClashDetectionSettings(ClashDetectionSettings newClashDetectionSettings) {
		ClashDetectionSettings clashDetectionSettings = newClashDetectionSettings;
		Object oldClashDetectionSettings = eVirtualSet(LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS, clashDetectionSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS:
				if (resolve) return getClashDetectionSettings();
				return basicGetClashDetectionSettings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS:
				setClashDetectionSettings((ClashDetectionSettings)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS:
				setClashDetectionSettings((ClashDetectionSettings)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS:
				return eVirtualGet(LogPackage.CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS) != null;
		}
		return super.eIsSet(featureID);
	}

} //ClashDetectionSettingsUpdatedImpl
