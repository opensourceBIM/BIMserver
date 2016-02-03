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

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Bundle Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getVersion <em>Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getType <em>Type</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#isMismatch <em>Mismatch</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.bimserver.models.store.PluginBundleVersion#getIcon <em>Icon</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface PluginBundleVersion extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.store.PluginBundleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.PluginBundleType
	 * @see #setType(PluginBundleType)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Type()
	 * @model
	 * @generated
	 */
	PluginBundleType getType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.bimserver.models.store.PluginBundleType
	 * @see #getType()
	 * @generated
	 */
	void setType(PluginBundleType value);

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
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Mismatch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mismatch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mismatch</em>' attribute.
	 * @see #setMismatch(boolean)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Mismatch()
	 * @model
	 * @generated
	 */
	boolean isMismatch();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#isMismatch <em>Mismatch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mismatch</em>' attribute.
	 * @see #isMismatch()
	 * @generated
	 */
	void setMismatch(boolean value);

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' attribute.
	 * @see #setRepository(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Repository()
	 * @model
	 * @generated
	 */
	String getRepository();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getRepository <em>Repository</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository</em>' attribute.
	 * @see #getRepository()
	 * @generated
	 */
	void setRepository(String value);

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_GroupId()
	 * @model
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_ArtifactId()
	 * @model
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(byte[])
	 * @see org.bimserver.models.store.StorePackage#getPluginBundleVersion_Icon()
	 * @model
	 * @generated
	 */
	byte[] getIcon();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.PluginBundleVersion#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(byte[] value);

} // PluginBundleVersion
