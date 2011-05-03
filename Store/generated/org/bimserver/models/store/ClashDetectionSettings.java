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

import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clash Detection Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ClashDetectionSettings#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.bimserver.models.store.ClashDetectionSettings#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.bimserver.models.store.ClashDetectionSettings#getMargin <em>Margin</em>}</li>
 *   <li>{@link org.bimserver.models.store.ClashDetectionSettings#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.bimserver.models.store.ClashDetectionSettings#getIgnoredClasses <em>Ignored Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ClashDetectionSettings extends IdEObject
{
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
	 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ClashDetectionSettings#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Project}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings_Projects()
	 * @see org.bimserver.models.store.Project#getClashDetectionSettings
	 * @model opposite="clashDetectionSettings"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Margin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Margin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Margin</em>' attribute.
	 * @see #setMargin(float)
	 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings_Margin()
	 * @model
	 * @generated
	 */
	float getMargin();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ClashDetectionSettings#getMargin <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Margin</em>' attribute.
	 * @see #getMargin()
	 * @generated
	 */
	void setMargin(float value);

	/**
	 * Returns the value of the '<em><b>Revisions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Revision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revisions</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings_Revisions()
	 * @model
	 * @generated
	 */
	EList<Revision> getRevisions();

	/**
	 * Returns the value of the '<em><b>Ignored Classes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignored Classes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignored Classes</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getClashDetectionSettings_IgnoredClasses()
	 * @model
	 * @generated
	 */
	EList<String> getIgnoredClasses();

} // ClashDetectionSettings
