/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 * @see org.bimserver.models.log.LogPackage#getClashDetectionSettingsUpdated()
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
	 * @see org.bimserver.models.log.LogPackage#getClashDetectionSettingsUpdated_ClashDetectionSettings()
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
