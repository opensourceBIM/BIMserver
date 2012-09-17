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
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getServer <em>Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#isReadRevision <em>Read Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#isReadExtendedData <em>Read Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getWriteRevision <em>Write Revision</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getWriteExtendedData <em>Write Extended Data</em>}</li>
 *   <li>{@link org.bimserver.models.store.ExternalProfile#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getExternalProfile()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface ExternalProfile extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Server</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ExternalServer#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server</em>' reference.
	 * @see #setServer(ExternalServer)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_Server()
	 * @see org.bimserver.models.store.ExternalServer#getProfiles
	 * @model opposite="profiles"
	 * @generated
	 */
	ExternalServer getServer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getServer <em>Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server</em>' reference.
	 * @see #getServer()
	 * @generated
	 */
	void setServer(ExternalServer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Read Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Revision</em>' attribute.
	 * @see #setReadRevision(boolean)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_ReadRevision()
	 * @model
	 * @generated
	 */
	boolean isReadRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#isReadRevision <em>Read Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Revision</em>' attribute.
	 * @see #isReadRevision()
	 * @generated
	 */
	void setReadRevision(boolean value);

	/**
	 * Returns the value of the '<em><b>Read Extended Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Extended Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Extended Data</em>' attribute.
	 * @see #setReadExtendedData(boolean)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_ReadExtendedData()
	 * @model
	 * @generated
	 */
	boolean isReadExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#isReadExtendedData <em>Read Extended Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Extended Data</em>' attribute.
	 * @see #isReadExtendedData()
	 * @generated
	 */
	void setReadExtendedData(boolean value);

	/**
	 * Returns the value of the '<em><b>Write Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Revision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Revision</em>' reference.
	 * @see #setWriteRevision(Project)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_WriteRevision()
	 * @model
	 * @generated
	 */
	Project getWriteRevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getWriteRevision <em>Write Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Revision</em>' reference.
	 * @see #getWriteRevision()
	 * @generated
	 */
	void setWriteRevision(Project value);

	/**
	 * Returns the value of the '<em><b>Write Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Extended Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Extended Data</em>' reference.
	 * @see #setWriteExtendedData(Project)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_WriteExtendedData()
	 * @model
	 * @generated
	 */
	Project getWriteExtendedData();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getWriteExtendedData <em>Write Extended Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Extended Data</em>' reference.
	 * @see #getWriteExtendedData()
	 * @generated
	 */
	void setWriteExtendedData(Project value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Project#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see org.bimserver.models.store.StorePackage#getExternalProfile_Project()
	 * @see org.bimserver.models.store.Project#getProfiles
	 * @model opposite="profiles"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.ExternalProfile#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // ExternalProfile
